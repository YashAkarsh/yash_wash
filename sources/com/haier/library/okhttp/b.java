package com.haier.library.okhttp;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Reader f26925a;

    static class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j0 f26926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f26927c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.haier.library.a.i f26928d;

        a(j0 j0Var, long j7, com.haier.library.a.i iVar) {
            this.f26926b = j0Var;
            this.f26927c = j7;
            this.f26928d = iVar;
        }

        @Override // com.haier.library.okhttp.b
        @Nullable
        public j0 C() {
            return this.f26926b;
        }

        @Override // com.haier.library.okhttp.b
        public com.haier.library.a.i K() {
            return this.f26928d;
        }

        @Override // com.haier.library.okhttp.b
        public long u() {
            return this.f26927c;
        }
    }

    /* JADX INFO: renamed from: com.haier.library.okhttp.b$b, reason: collision with other inner class name */
    static final class C0354b extends Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.haier.library.a.i f26929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Charset f26930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f26931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private Reader f26932d;

        C0354b(com.haier.library.a.i iVar, Charset charset) {
            this.f26929a = iVar;
            this.f26930b = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f26931c = true;
            Reader reader = this.f26932d;
            if (reader != null) {
                reader.close();
            } else {
                this.f26929a.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i7, int i8) throws IOException {
            if (this.f26931c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.f26932d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f26929a.h(), n.d.l(this.f26929a, this.f26930b));
                this.f26932d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i7, i8);
        }
    }

    public static b E(@Nullable j0 j0Var, long j7, com.haier.library.a.i iVar) {
        if (iVar != null) {
            return new a(j0Var, j7, iVar);
        }
        throw new NullPointerException("source == null");
    }

    public static b F(@Nullable j0 j0Var, com.haier.library.a.j jVar) {
        return E(j0Var, jVar.Z(), new com.haier.library.a.g().B(jVar));
    }

    public static b G(@Nullable j0 j0Var, String str) {
        Charset charset = n.d.f27695j;
        if (j0Var != null) {
            Charset charsetF = j0Var.f();
            if (charsetF == null) {
                j0Var = j0.d(j0Var + "; charset=utf-8");
            } else {
                charset = charsetF;
            }
        }
        com.haier.library.a.g gVarU0 = new com.haier.library.a.g().U0(str, charset);
        return E(j0Var, gVarU0.Y0(), gVarU0);
    }

    public static b H(@Nullable j0 j0Var, byte[] bArr) {
        return E(j0Var, bArr.length, new com.haier.library.a.g().K1(bArr));
    }

    private Charset r() {
        j0 j0VarC = C();
        return j0VarC != null ? j0VarC.c(n.d.f27695j) : n.d.f27695j;
    }

    @Nullable
    public abstract j0 C();

    public abstract com.haier.library.a.i K();

    public final String Q() throws IOException {
        com.haier.library.a.i iVarK = K();
        try {
            return iVarK.j1(n.d.l(iVarK, r()));
        } finally {
            n.d.s(iVarK);
        }
    }

    public final InputStream b() {
        return K().h();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        n.d.s(K());
    }

    public final byte[] e() throws IOException {
        long jU = u();
        if (jU > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jU);
        }
        com.haier.library.a.i iVarK = K();
        try {
            byte[] bArrN1 = iVarK.n1();
            n.d.s(iVarK);
            if (jU == -1 || jU == bArrN1.length) {
                return bArrN1;
            }
            throw new IOException("Content-Length (" + jU + ") and stream length (" + bArrN1.length + ") disagree");
        } catch (Throwable th) {
            n.d.s(iVarK);
            throw th;
        }
    }

    public final Reader q() {
        Reader reader = this.f26925a;
        if (reader != null) {
            return reader;
        }
        C0354b c0354b = new C0354b(K(), r());
        this.f26925a = c0354b;
        return c0354b;
    }

    public abstract long u();
}
