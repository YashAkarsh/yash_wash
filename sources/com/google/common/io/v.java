package com.google.common.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class v extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f22028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f22029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OutputStream f22030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f22031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f22032f;

    class a extends g {
        a() {
        }

        protected void finalize() {
            try {
                v.this.u();
            } catch (Throwable th) {
                th.printStackTrace(System.err);
            }
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return v.this.r();
        }
    }

    class b extends g {
        b() {
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return v.this.r();
        }
    }

    private static class c extends ByteArrayOutputStream {
        private c() {
        }

        byte[] b() {
            return ((ByteArrayOutputStream) this).buf;
        }

        int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    public v(int i7) {
        this(i7, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized InputStream r() throws IOException {
        if (this.f22032f != null) {
            return new FileInputStream(this.f22032f);
        }
        return new ByteArrayInputStream(this.f22031e.b(), 0, this.f22031e.getCount());
    }

    private void v(int i7) throws IOException {
        if (this.f22032f != null || this.f22031e.getCount() + i7 <= this.f22027a) {
            return;
        }
        File fileCreateTempFile = File.createTempFile("FileBackedOutputStream", null);
        if (this.f22028b) {
            fileCreateTempFile.deleteOnExit();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        fileOutputStream.write(this.f22031e.b(), 0, this.f22031e.getCount());
        fileOutputStream.flush();
        this.f22030d = fileOutputStream;
        this.f22032f = fileCreateTempFile;
        this.f22031e = null;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f22030d.close();
    }

    public g e() {
        return this.f22029c;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.f22030d.flush();
    }

    @s1.d
    synchronized File q() {
        return this.f22032f;
    }

    public synchronized void u() throws IOException {
        a aVar = null;
        try {
            close();
            c cVar = this.f22031e;
            if (cVar == null) {
                this.f22031e = new c(aVar);
            } else {
                cVar.reset();
            }
            this.f22030d = this.f22031e;
            File file = this.f22032f;
            if (file != null) {
                this.f22032f = null;
                if (!file.delete()) {
                    throw new IOException("Could not delete: " + file);
                }
            }
        } catch (Throwable th) {
            if (this.f22031e == null) {
                this.f22031e = new c(aVar);
            } else {
                this.f22031e.reset();
            }
            this.f22030d = this.f22031e;
            File file2 = this.f22032f;
            if (file2 != null) {
                this.f22032f = null;
                if (!file2.delete()) {
                    throw new IOException("Could not delete: " + file2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i7) throws IOException {
        v(1);
        this.f22030d.write(i7);
    }

    public v(int i7, boolean z7) {
        this.f22027a = i7;
        this.f22028b = z7;
        c cVar = new c(null);
        this.f22031e = cVar;
        this.f22030d = cVar;
        if (z7) {
            this.f22029c = new a();
        } else {
            this.f22029c = new b();
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i7, int i8) throws IOException {
        v(i8);
        this.f22030d.write(bArr, i7, i8);
    }
}
