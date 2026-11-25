package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.alipay.sdk.util.f;
import com.facebook.internal.AnalyticsEvents;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes.dex */
final class c implements Closeable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8725g = "MultiDex";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f8726h = "classes";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final String f8727i = ".dex";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f8728j = ".classes";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final String f8729k = ".zip";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f8730l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f8731m = "multidex.version";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f8732n = "timestamp";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f8733o = "crc";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f8734p = "dex.number";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f8735q = "dex.crc.";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f8736r = "dex.time.";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f8737s = 16384;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final long f8738t = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f8739u = "MultiDex.lock";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f8740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f8741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f8742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RandomAccessFile f8743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FileChannel f8744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FileLock f8745f;

    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals(c.f8739u);
        }
    }

    private static class b extends File {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8747a;

        public b(File file, String str) {
            super(file, str);
            this.f8747a = -1L;
        }
    }

    c(File file, File file2) throws IOException {
        Log.i(f8725g, "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f8740a = file;
        this.f8742c = file2;
        this.f8741b = m(file);
        File file3 = new File(file2, f8739u);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f8743d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f8744e = channel;
            try {
                Log.i(f8725g, "Blocking on lock " + file3.getPath());
                this.f8745f = channel.lock();
                Log.i(f8725g, file3.getPath() + " locked");
            } catch (IOException e8) {
                e = e8;
                c(this.f8744e);
                throw e;
            } catch (Error e9) {
                e = e9;
                c(this.f8744e);
                throw e;
            } catch (RuntimeException e10) {
                e = e10;
                c(this.f8744e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e11) {
            c(this.f8743d);
            throw e11;
        }
    }

    private void b() {
        File[] fileArrListFiles = this.f8742c.listFiles(new a());
        if (fileArrListFiles == null) {
            Log.w(f8725g, "Failed to list secondary dex dir content (" + this.f8742c.getPath() + ").");
            return;
        }
        for (File file : fileArrListFiles) {
            Log.i(f8725g, "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i(f8725g, "Deleted old file " + file.getPath());
            } else {
                Log.w(f8725g, "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void c(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e8) {
            Log.w(f8725g, "Failed to close resource", e8);
        }
    }

    private static void e(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-" + str, f8729k, file.getParentFile());
        Log.i(f8725g, "Extracting " + fileCreateTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(fileCreateTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int i7 = inputStream.read(bArr); i7 != -1; i7 = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i7);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i(f8725g, "Renaming to " + file.getPath());
                if (fileCreateTempFile.renameTo(file)) {
                    c(inputStream);
                    fileCreateTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            c(inputStream);
            fileCreateTempFile.delete();
            throw th2;
        }
    }

    private static SharedPreferences f(Context context) {
        return context.getSharedPreferences(f8731m, 4);
    }

    private static long g(File file) {
        long jLastModified = file.lastModified();
        return jLastModified == -1 ? jLastModified - 1 : jLastModified;
    }

    private static long m(File file) throws IOException {
        long jC = e.c(file);
        return jC == -1 ? jC - 1 : jC;
    }

    private static boolean q(Context context, File file, long j7, String str) {
        SharedPreferences sharedPreferencesF = f(context);
        if (sharedPreferencesF.getLong(str + "timestamp", -1L) == g(file)) {
            if (sharedPreferencesF.getLong(str + f8733o, -1L) == j7) {
                return false;
            }
        }
        return true;
    }

    private List<b> s(Context context, String str) throws IOException {
        Log.i(f8725g, "loading existing secondary dex files");
        String str2 = this.f8740a.getName() + f8728j;
        SharedPreferences sharedPreferencesF = f(context);
        int i7 = sharedPreferencesF.getInt(str + f8734p, 1);
        ArrayList arrayList = new ArrayList(i7 + (-1));
        int i8 = 2;
        while (i8 <= i7) {
            b bVar = new b(this.f8742c, str2 + i8 + f8729k);
            if (!bVar.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + bVar.getPath() + "'");
            }
            bVar.f8747a = m(bVar);
            long j7 = sharedPreferencesF.getLong(str + f8735q + i8, -1L);
            long j8 = sharedPreferencesF.getLong(str + f8736r + i8, -1L);
            long jLastModified = bVar.lastModified();
            if (j8 == jLastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = sharedPreferencesF;
                if (j7 == bVar.f8747a) {
                    arrayList.add(bVar);
                    i8++;
                    sharedPreferencesF = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + bVar + " (key \"" + str + "\"), expected modification time: " + j8 + ", modification time: " + jLastModified + ", expected crc: " + j7 + ", file crc: " + bVar.f8747a);
        }
        return arrayList;
    }

    private List<b> u() throws IOException {
        boolean z7;
        String str = this.f8740a.getName() + f8728j;
        b();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f8740a);
        try {
            int i7 = 2;
            ZipEntry entry = zipFile.getEntry(f8726h + 2 + f8727i);
            while (entry != null) {
                b bVar = new b(this.f8742c, str + i7 + f8729k);
                arrayList.add(bVar);
                Log.i(f8725g, "Extraction is needed for file " + bVar);
                int i8 = 0;
                boolean z8 = false;
                while (i8 < 3 && !z8) {
                    int i9 = i8 + 1;
                    e(zipFile, entry, bVar, str);
                    try {
                        bVar.f8747a = m(bVar);
                        z7 = true;
                    } catch (IOException e8) {
                        Log.w(f8725g, "Failed to read crc from " + bVar.getAbsolutePath(), e8);
                        z7 = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z7 ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : f.f13791i);
                    sb.append(" '");
                    sb.append(bVar.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(bVar.length());
                    sb.append(" - crc: ");
                    sb.append(bVar.f8747a);
                    Log.i(f8725g, sb.toString());
                    if (!z7) {
                        bVar.delete();
                        if (bVar.exists()) {
                            Log.w(f8725g, "Failed to delete corrupted secondary dex '" + bVar.getPath() + "'");
                        }
                    }
                    z8 = z7;
                    i8 = i9;
                }
                if (!z8) {
                    throw new IOException("Could not create zip file " + bVar.getAbsolutePath() + " for secondary dex (" + i7 + ")");
                }
                i7++;
                entry = zipFile.getEntry(f8726h + i7 + f8727i);
            }
            try {
                zipFile.close();
            } catch (IOException e9) {
                Log.w(f8725g, "Failed to close resource", e9);
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
                throw th;
            } catch (IOException e10) {
                Log.w(f8725g, "Failed to close resource", e10);
                throw th;
            }
        }
    }

    private static void v(Context context, String str, long j7, long j8, List<b> list) {
        SharedPreferences.Editor editorEdit = f(context).edit();
        editorEdit.putLong(str + "timestamp", j7);
        editorEdit.putLong(str + f8733o, j8);
        editorEdit.putInt(str + f8734p, list.size() + 1);
        int i7 = 2;
        for (b bVar : list) {
            editorEdit.putLong(str + f8735q + i7, bVar.f8747a);
            editorEdit.putLong(str + f8736r + i7, bVar.lastModified());
            i7++;
        }
        editorEdit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8745f.release();
        this.f8744e.close();
        this.f8743d.close();
    }

    List<? extends File> r(Context context, String str, boolean z7) throws IOException {
        List<b> listU;
        List<b> listS;
        Log.i(f8725g, "MultiDexExtractor.load(" + this.f8740a.getPath() + ", " + z7 + ", " + str + ")");
        if (!this.f8745f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z7 && !q(context, this.f8740a, this.f8741b, str)) {
            try {
                listS = s(context, str);
            } catch (IOException e8) {
                Log.w(f8725g, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e8);
                listU = u();
                v(context, str, g(this.f8740a), this.f8741b, listU);
                listS = listU;
            }
            Log.i(f8725g, "load found " + listS.size() + " secondary dex files");
            return listS;
        }
        if (z7) {
            Log.i(f8725g, "Forced extraction must be performed.");
        } else {
            Log.i(f8725g, "Detected that extraction must be performed.");
        }
        listU = u();
        v(context, str, g(this.f8740a), this.f8741b, listU);
        listS = listU;
        Log.i(f8725g, "load found " + listS.size() + " secondary dex files");
        return listS;
    }
}
