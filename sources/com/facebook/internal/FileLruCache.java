package com.facebook.internal;

import com.alipay.sdk.util.j;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes.dex */
public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = "FileLruCache";
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private AtomicLong lastClearCacheTime = new AtomicLong(0);
    private final Limits limits;
    private final Object lock;
    private final String tag;

    private static class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.FileLruCache.BufferFile.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !str.startsWith(BufferFile.FILE_NAME_PREFIX);
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.FileLruCache.BufferFile.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.startsWith(BufferFile.FILE_NAME_PREFIX);
            }
        };

        private BufferFile() {
        }

        static void deleteAll(File file) {
            File[] fileArrListFiles = file.listFiles(excludeNonBufferFiles());
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    file2.delete();
                }
            }
        }

        static FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        static FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        static File newFile(File file) {
            return new File(file, FILE_NAME_PREFIX + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
        }
    }

    private static class CloseCallbackOutputStream extends OutputStream {
        final StreamCloseCallback callback;
        final OutputStream innerStream;

        CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.innerStream.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) throws IOException {
            this.innerStream.write(bArr, i7, i8);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.innerStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i7) throws IOException {
            this.innerStream.write(i7);
        }
    }

    public static final class Limits {
        private int fileCount = 1024;
        private int byteCount = 1048576;

        int getByteCount() {
            return this.byteCount;
        }

        int getFileCount() {
            return this.fileCount;
        }

        void setByteCount(int i7) {
            if (i7 < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = i7;
        }

        void setFileCount(int i7) {
            if (i7 < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = i7;
        }
    }

    private static final class ModifiedFile implements Comparable<ModifiedFile> {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;

        ModifiedFile(File file) {
            this.file = file;
            this.modified = file.lastModified();
        }

        public boolean equals(Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        File getFile() {
            return this.file;
        }

        long getModified() {
            return this.modified;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.modified % 2147483647L));
        }

        @Override // java.lang.Comparable
        public int compareTo(ModifiedFile modifiedFile) {
            if (getModified() < modifiedFile.getModified()) {
                return -1;
            }
            if (getModified() > modifiedFile.getModified()) {
                return 1;
            }
            return getFile().compareTo(modifiedFile.getFile());
        }
    }

    private interface StreamCloseCallback {
        void onClose();
    }

    private static final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        private StreamHeader() {
        }

        static JSONObject readHeader(InputStream inputStream) throws IOException {
            if (inputStream.read() != 0) {
                return null;
            }
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < 3; i9++) {
                int i10 = inputStream.read();
                if (i10 == -1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i8 = (i8 << 8) + (i10 & 255);
            }
            byte[] bArr = new byte[i8];
            while (i7 < i8) {
                int i11 = inputStream.read(bArr, i7, i8 - i7);
                if (i11 < 1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i7) + " when expected " + i8);
                    return null;
                }
                i7 += i11;
            }
            try {
                Object objNextValue = new JSONTokener(new String(bArr)).nextValue();
                if (objNextValue instanceof JSONObject) {
                    return (JSONObject) objNextValue;
                }
                Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + objNextValue.getClass().getCanonicalName());
                return null;
            } catch (JSONException e8) {
                throw new IOException(e8.getMessage());
            }
        }

        static void writeHeader(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }
    }

    public FileLruCache(String str, Limits limits) {
        this.tag = str;
        this.limits = limits;
        File file = new File(FacebookSdk.getCacheDir(), str);
        this.directory = file;
        this.lock = new Object();
        if (file.mkdirs() || file.isDirectory()) {
            BufferFile.deleteAll(file);
        }
    }

    private void postTrim() {
        synchronized (this.lock) {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.FileLruCache.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FileLruCache.this.trim();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trim() {
        long j7;
        synchronized (this.lock) {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
        }
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            File[] fileArrListFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
            long length = 0;
            if (fileArrListFiles != null) {
                j7 = 0;
                for (File file : fileArrListFiles) {
                    ModifiedFile modifiedFile = new ModifiedFile(file);
                    priorityQueue.add(modifiedFile);
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                    length += file.length();
                    j7++;
                }
            } else {
                j7 = 0;
            }
            while (true) {
                if (length <= this.limits.getByteCount() && j7 <= this.limits.getFileCount()) {
                    synchronized (this.lock) {
                        this.isTrimInProgress = false;
                        this.lock.notifyAll();
                    }
                    return;
                }
                File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + file2.getName());
                length -= file2.length();
                j7--;
                file2.delete();
            }
        } catch (Throwable th) {
            synchronized (this.lock) {
                this.isTrimInProgress = false;
                this.lock.notifyAll();
                throw th;
            }
        }
    }

    public void clearCache() {
        final File[] fileArrListFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (fileArrListFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.FileLruCache.2
                @Override // java.lang.Runnable
                public void run() {
                    for (File file : fileArrListFiles) {
                        file.delete();
                    }
                }
            });
        }
    }

    public InputStream get(String str) throws IOException {
        return get(str, null);
    }

    public String getLocation() {
        return this.directory.getPath();
    }

    public InputStream interceptAndPut(String str, InputStream inputStream) throws IOException {
        return new CopyingInputStream(inputStream, openPutStream(str));
    }

    public OutputStream openPutStream(String str) throws IOException {
        return openPutStream(str, null);
    }

    long sizeInBytesForTest() {
        synchronized (this.lock) {
            while (true) {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.lock.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        File[] fileArrListFiles = this.directory.listFiles();
        long length = 0;
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                length += file.length();
            }
        }
        return length;
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + j.f13808d;
    }

    private static final class CopyingInputStream extends InputStream {
        final InputStream input;
        final OutputStream output;

        CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            this.input = inputStream;
            this.output = outputStream;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.input.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        @Override // java.io.InputStream
        public void mark(int i7) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int i7 = this.input.read(bArr);
            if (i7 > 0) {
                this.output.write(bArr, 0, i7);
            }
            return i7;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long j7) throws IOException {
            byte[] bArr = new byte[1024];
            long j8 = 0;
            while (j8 < j7) {
                int i7 = read(bArr, 0, (int) Math.min(j7 - j8, 1024));
                if (i7 < 0) {
                    return j8;
                }
                j8 += (long) i7;
            }
            return j8;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i7 = this.input.read();
            if (i7 >= 0) {
                this.output.write(i7);
            }
            return i7;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i7, int i8) throws IOException {
            int i9 = this.input.read(bArr, i7, i8);
            if (i9 > 0) {
                this.output.write(bArr, i7, i9);
            }
            return i9;
        }
    }

    public InputStream get(String str, String str2) throws IOException {
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            try {
                JSONObject header = StreamHeader.readHeader(bufferedInputStream);
                if (header == null) {
                    bufferedInputStream.close();
                    return null;
                }
                String strOptString = header.optString("key");
                if (strOptString != null && strOptString.equals(str)) {
                    String strOptString2 = header.optString("tag", null);
                    if ((str2 == null && strOptString2 != null) || (str2 != null && !str2.equals(strOptString2))) {
                        bufferedInputStream.close();
                        return null;
                    }
                    long time = new Date().getTime();
                    Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                    file.setLastModified(time);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                return null;
            } catch (Throwable th) {
                bufferedInputStream.close();
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public OutputStream openPutStream(final String str, String str2) throws IOException {
        final File fileNewFile = BufferFile.newFile(this.directory);
        fileNewFile.delete();
        if (!fileNewFile.createNewFile()) {
            throw new IOException("Could not create file at " + fileNewFile.getAbsolutePath());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileNewFile);
            final long jCurrentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() { // from class: com.facebook.internal.FileLruCache.1
                @Override // com.facebook.internal.FileLruCache.StreamCloseCallback
                public void onClose() {
                    if (jCurrentTimeMillis < FileLruCache.this.lastClearCacheTime.get()) {
                        fileNewFile.delete();
                    } else {
                        FileLruCache.this.renameToTargetAndTrim(str, fileNewFile);
                    }
                }
            }), 8192);
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    StreamHeader.writeHeader(bufferedOutputStream, jSONObject);
                    return bufferedOutputStream;
                } catch (JSONException e8) {
                    Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: " + e8);
                    throw new IOException(e8.getMessage());
                }
            } catch (Throwable th) {
                bufferedOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e9) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: " + e9);
            throw new IOException(e9.getMessage());
        }
    }
}
