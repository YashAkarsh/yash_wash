package com.google.common.io;

import com.google.common.collect.d7;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
public abstract class g {

    class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Charset f21970a;

        a(Charset charset) {
            this.f21970a = (Charset) com.google.common.base.e0.E(charset);
        }

        @Override // com.google.common.io.p
        public g b(Charset charset) {
            return charset.equals(this.f21970a) ? g.this : super.b(charset);
        }

        @Override // com.google.common.io.p
        public Reader q() throws IOException {
            return new InputStreamReader(g.this.m(), this.f21970a);
        }

        @Override // com.google.common.io.p
        public String r() throws IOException {
            return new String(g.this.o(), this.f21970a);
        }

        public String toString() {
            return g.this.toString() + ".asCharSource(" + this.f21970a + ")";
        }
    }

    private static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final byte[] f21972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f21973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f21974c;

        b(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // com.google.common.io.g
        public long g(OutputStream outputStream) throws IOException {
            outputStream.write(this.f21972a, this.f21973b, this.f21974c);
            return this.f21974c;
        }

        @Override // com.google.common.io.g
        public com.google.common.hash.r j(com.google.common.hash.s sVar) throws IOException {
            return sVar.j(this.f21972a, this.f21973b, this.f21974c);
        }

        @Override // com.google.common.io.g
        public boolean k() {
            return this.f21974c == 0;
        }

        @Override // com.google.common.io.g
        public InputStream l() throws IOException {
            return m();
        }

        @Override // com.google.common.io.g
        public InputStream m() {
            return new ByteArrayInputStream(this.f21972a, this.f21973b, this.f21974c);
        }

        @Override // com.google.common.io.g
        public <T> T n(com.google.common.io.e<T> eVar) throws IOException {
            eVar.b(this.f21972a, this.f21973b, this.f21974c);
            return eVar.a();
        }

        @Override // com.google.common.io.g
        public byte[] o() {
            byte[] bArr = this.f21972a;
            int i7 = this.f21973b;
            return Arrays.copyOfRange(bArr, i7, this.f21974c + i7);
        }

        @Override // com.google.common.io.g
        public long p() {
            return this.f21974c;
        }

        @Override // com.google.common.io.g
        public com.google.common.base.a0<Long> q() {
            return com.google.common.base.a0.g(Long.valueOf(this.f21974c));
        }

        @Override // com.google.common.io.g
        public g r(long j7, long j8) {
            com.google.common.base.e0.p(j7 >= 0, "offset (%s) may not be negative", j7);
            com.google.common.base.e0.p(j8 >= 0, "length (%s) may not be negative", j8);
            long jMin = Math.min(j7, this.f21974c);
            return new b(this.f21972a, this.f21973b + ((int) jMin), (int) Math.min(j8, ((long) this.f21974c) - jMin));
        }

        public String toString() {
            return "ByteSource.wrap(" + com.google.common.base.c.k(com.google.common.io.b.a().m(this.f21972a, this.f21973b, this.f21974c), 30, "...") + ")";
        }

        b(byte[] bArr, int i7, int i8) {
            this.f21972a = bArr;
            this.f21973b = i7;
            this.f21974c = i8;
        }
    }

    private static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterable<? extends g> f21975a;

        c(Iterable<? extends g> iterable) {
            this.f21975a = (Iterable) com.google.common.base.e0.E(iterable);
        }

        @Override // com.google.common.io.g
        public boolean k() throws IOException {
            Iterator<? extends g> it = this.f21975a.iterator();
            while (it.hasNext()) {
                if (!it.next().k()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return new b2(this.f21975a.iterator());
        }

        @Override // com.google.common.io.g
        public long p() throws IOException {
            Iterator<? extends g> it = this.f21975a.iterator();
            long jP = 0;
            while (it.hasNext()) {
                jP += it.next().p();
                if (jP < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return jP;
        }

        @Override // com.google.common.io.g
        public com.google.common.base.a0<Long> q() {
            Iterable<? extends g> iterable = this.f21975a;
            if (!(iterable instanceof Collection)) {
                return com.google.common.base.a0.a();
            }
            Iterator<? extends g> it = iterable.iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                com.google.common.base.a0<Long> a0VarQ = it.next().q();
                if (!a0VarQ.f()) {
                    return com.google.common.base.a0.a();
                }
                jLongValue += a0VarQ.e().longValue();
                if (jLongValue < 0) {
                    return com.google.common.base.a0.g(Long.MAX_VALUE);
                }
            }
            return com.google.common.base.a0.g(Long.valueOf(jLongValue));
        }

        public String toString() {
            return "ByteSource.concat(" + this.f21975a + ")";
        }
    }

    private static final class d extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final d f21976d = new d();

        d() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.g
        public p a(Charset charset) {
            com.google.common.base.e0.E(charset);
            return p.i();
        }

        @Override // com.google.common.io.g.b, com.google.common.io.g
        public byte[] o() {
            return this.f21972a;
        }

        @Override // com.google.common.io.g.b
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    private final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f21977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f21978b;

        e(long j7, long j8) {
            com.google.common.base.e0.p(j7 >= 0, "offset (%s) may not be negative", j7);
            com.google.common.base.e0.p(j8 >= 0, "length (%s) may not be negative", j8);
            this.f21977a = j7;
            this.f21978b = j8;
        }

        private InputStream t(InputStream inputStream) throws Throwable {
            long j7 = this.f21977a;
            if (j7 > 0) {
                try {
                    if (h.t(inputStream, j7) < this.f21977a) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } catch (Throwable th) {
                    s sVarB = s.b();
                    sVarB.c(inputStream);
                    try {
                        throw sVarB.e(th);
                    } catch (Throwable th2) {
                        sVarB.close();
                        throw th2;
                    }
                }
            }
            return h.f(inputStream, this.f21978b);
        }

        @Override // com.google.common.io.g
        public boolean k() throws IOException {
            return this.f21978b == 0 || super.k();
        }

        @Override // com.google.common.io.g
        public InputStream l() throws IOException {
            return t(g.this.l());
        }

        @Override // com.google.common.io.g
        public InputStream m() throws IOException {
            return t(g.this.m());
        }

        @Override // com.google.common.io.g
        public com.google.common.base.a0<Long> q() {
            com.google.common.base.a0<Long> a0VarQ = g.this.q();
            if (!a0VarQ.f()) {
                return com.google.common.base.a0.a();
            }
            long jLongValue = a0VarQ.e().longValue();
            return com.google.common.base.a0.g(Long.valueOf(Math.min(this.f21978b, jLongValue - Math.min(this.f21977a, jLongValue))));
        }

        @Override // com.google.common.io.g
        public g r(long j7, long j8) {
            com.google.common.base.e0.p(j7 >= 0, "offset (%s) may not be negative", j7);
            com.google.common.base.e0.p(j8 >= 0, "length (%s) may not be negative", j8);
            return g.this.r(this.f21977a + j7, Math.min(j8, this.f21978b - j7));
        }

        public String toString() {
            return g.this.toString() + ".slice(" + this.f21977a + ", " + this.f21978b + ")";
        }
    }

    protected g() {
    }

    public static g b(Iterable<? extends g> iterable) {
        return new c(iterable);
    }

    public static g c(Iterator<? extends g> it) {
        return b(d7.t(it));
    }

    public static g d(g... gVarArr) {
        return b(d7.u(gVarArr));
    }

    private long h(InputStream inputStream) throws IOException {
        long j7 = 0;
        while (true) {
            long jT = h.t(inputStream, 2147483647L);
            if (jT <= 0) {
                return j7;
            }
            j7 += jT;
        }
    }

    public static g i() {
        return d.f21976d;
    }

    public static g s(byte[] bArr) {
        return new b(bArr);
    }

    public p a(Charset charset) {
        return new a(charset);
    }

    public boolean e(g gVar) throws Throwable {
        int iN;
        com.google.common.base.e0.E(gVar);
        byte[] bArrD = h.d();
        byte[] bArrD2 = h.d();
        s sVarB = s.b();
        try {
            InputStream inputStream = (InputStream) sVarB.c(m());
            InputStream inputStream2 = (InputStream) sVarB.c(gVar.m());
            do {
                iN = h.n(inputStream, bArrD, 0, bArrD.length);
                if (iN == h.n(inputStream2, bArrD2, 0, bArrD2.length) && Arrays.equals(bArrD, bArrD2)) {
                }
                sVarB.close();
                return false;
            } while (iN == bArrD.length);
            sVarB.close();
            return true;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @u1.a
    public long f(f fVar) throws Throwable {
        com.google.common.base.e0.E(fVar);
        s sVarB = s.b();
        try {
            long jB = h.b((InputStream) sVarB.c(m()), (OutputStream) sVarB.c(fVar.c()));
            sVarB.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    @u1.a
    public long g(OutputStream outputStream) throws Throwable {
        com.google.common.base.e0.E(outputStream);
        s sVarB = s.b();
        try {
            long jB = h.b((InputStream) sVarB.c(m()), outputStream);
            sVarB.close();
            return jB;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public com.google.common.hash.r j(com.google.common.hash.s sVar) throws Throwable {
        com.google.common.hash.u uVarB = sVar.b();
        g(com.google.common.hash.q.a(uVarB));
        return uVarB.o();
    }

    public boolean k() throws Throwable {
        com.google.common.base.a0<Long> a0VarQ = q();
        if (a0VarQ.f()) {
            return a0VarQ.e().longValue() == 0;
        }
        s sVarB = s.b();
        try {
            boolean z7 = ((InputStream) sVarB.c(m())).read() == -1;
            sVarB.close();
            return z7;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public InputStream l() throws IOException {
        InputStream inputStreamM = m();
        return inputStreamM instanceof BufferedInputStream ? (BufferedInputStream) inputStreamM : new BufferedInputStream(inputStreamM);
    }

    public abstract InputStream m() throws IOException;

    @s1.a
    @u1.a
    public <T> T n(com.google.common.io.e<T> eVar) throws Throwable {
        com.google.common.base.e0.E(eVar);
        s sVarB = s.b();
        try {
            T t7 = (T) h.o((InputStream) sVarB.c(m()), eVar);
            sVarB.close();
            return t7;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public byte[] o() throws Throwable {
        s sVarB = s.b();
        try {
            InputStream inputStream = (InputStream) sVarB.c(m());
            com.google.common.base.a0<Long> a0VarQ = q();
            byte[] bArrV = a0VarQ.f() ? h.v(inputStream, a0VarQ.e().longValue()) : h.u(inputStream);
            sVarB.close();
            return bArrV;
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    public long p() throws Throwable {
        com.google.common.base.a0<Long> a0VarQ = q();
        if (a0VarQ.f()) {
            return a0VarQ.e().longValue();
        }
        s sVarB = s.b();
        try {
            long jH = h((InputStream) sVarB.c(m()));
            sVarB.close();
            return jH;
        } catch (IOException unused) {
            sVarB.close();
            s sVarB2 = s.b();
            try {
                long jE = h.e((InputStream) sVarB2.c(m()));
                sVarB2.close();
                return jE;
            } catch (Throwable th) {
                try {
                    throw sVarB2.e(th);
                } catch (Throwable th2) {
                    sVarB2.close();
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            sVarB.close();
            throw th3;
        }
    }

    @s1.a
    public com.google.common.base.a0<Long> q() {
        return com.google.common.base.a0.a();
    }

    public g r(long j7, long j8) {
        return new e(j7, j8);
    }
}
