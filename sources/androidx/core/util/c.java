package androidx.core.util;

import android.util.Log;
import c.m0;
import c.o0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f6347d = "AtomicFile";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f6348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f6349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f6350c;

    public c(@m0 File file) {
        this.f6348a = file;
        this.f6349b = new File(file.getPath() + ".new");
        this.f6350c = new File(file.getPath() + ".bak");
    }

    private static void g(@m0 File file, @m0 File file2) {
        if (file2.isDirectory() && !file2.delete()) {
            Log.e(f6347d, "Failed to delete file which is a directory " + file2);
        }
        if (file.renameTo(file2)) {
            return;
        }
        Log.e(f6347d, "Failed to rename " + file + " to " + file2);
    }

    private static boolean i(@m0 FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void a() {
        this.f6348a.delete();
        this.f6349b.delete();
        this.f6350c.delete();
    }

    public void b(@o0 FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!i(fileOutputStream)) {
            Log.e(f6347d, "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e8) {
            Log.e(f6347d, "Failed to close file output stream", e8);
        }
        if (this.f6349b.delete()) {
            return;
        }
        Log.e(f6347d, "Failed to delete new file " + this.f6349b);
    }

    public void c(@o0 FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return;
        }
        if (!i(fileOutputStream)) {
            Log.e(f6347d, "Failed to sync file output stream");
        }
        try {
            fileOutputStream.close();
        } catch (IOException e8) {
            Log.e(f6347d, "Failed to close file output stream", e8);
        }
        g(this.f6349b, this.f6348a);
    }

    @m0
    public File d() {
        return this.f6348a;
    }

    @m0
    public FileInputStream e() throws FileNotFoundException {
        if (this.f6350c.exists()) {
            g(this.f6350c, this.f6348a);
        }
        if (this.f6349b.exists() && this.f6348a.exists() && !this.f6349b.delete()) {
            Log.e(f6347d, "Failed to delete outdated new file " + this.f6349b);
        }
        return new FileInputStream(this.f6348a);
    }

    @m0
    public byte[] f() throws IOException {
        FileInputStream fileInputStreamE = e();
        try {
            byte[] bArr = new byte[fileInputStreamE.available()];
            int i7 = 0;
            while (true) {
                int i8 = fileInputStreamE.read(bArr, i7, bArr.length - i7);
                if (i8 <= 0) {
                    fileInputStreamE.close();
                    return bArr;
                }
                i7 += i8;
                int iAvailable = fileInputStreamE.available();
                if (iAvailable > bArr.length - i7) {
                    byte[] bArr2 = new byte[iAvailable + i7];
                    System.arraycopy(bArr, 0, bArr2, 0, i7);
                    bArr = bArr2;
                }
            }
        } catch (Throwable th) {
            fileInputStreamE.close();
            throw th;
        }
    }

    @m0
    public FileOutputStream h() throws IOException {
        if (this.f6350c.exists()) {
            g(this.f6350c, this.f6348a);
        }
        try {
            return new FileOutputStream(this.f6349b);
        } catch (FileNotFoundException unused) {
            if (!this.f6349b.getParentFile().mkdirs()) {
                throw new IOException("Failed to create directory for " + this.f6349b);
            }
            try {
                return new FileOutputStream(this.f6349b);
            } catch (FileNotFoundException e8) {
                throw new IOException("Failed to create new file " + this.f6349b, e8);
            }
        }
    }
}
