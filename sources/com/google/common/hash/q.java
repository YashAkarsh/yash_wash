package com.google.common.hash;

import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class q {

    private enum a implements p<byte[]> {
        INSTANCE;

        @Override // com.google.common.hash.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void Q(byte[] bArr, h0 h0Var) {
            h0Var.g(bArr);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    private enum b implements p<Integer> {
        INSTANCE;

        @Override // com.google.common.hash.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void Q(Integer num, h0 h0Var) {
            h0Var.e(num.intValue());
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }
    }

    private enum c implements p<Long> {
        INSTANCE;

        @Override // com.google.common.hash.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void Q(Long l7, h0 h0Var) {
            h0Var.f(l7.longValue());
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }
    }

    private static class d<E> implements p<Iterable<? extends E>>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p<E> f21861a;

        d(p<E> pVar) {
            this.f21861a = (p) com.google.common.base.e0.E(pVar);
        }

        @Override // com.google.common.hash.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void Q(Iterable<? extends E> iterable, h0 h0Var) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                this.f21861a.Q(it.next(), h0Var);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f21861a.equals(((d) obj).f21861a);
            }
            return false;
        }

        public int hashCode() {
            return d.class.hashCode() ^ this.f21861a.hashCode();
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.f21861a + ")";
        }
    }

    private static class e extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h0 f21862a;

        e(h0 h0Var) {
            this.f21862a = (h0) com.google.common.base.e0.E(h0Var);
        }

        public String toString() {
            return "Funnels.asOutputStream(" + this.f21862a + ")";
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
            this.f21862a.h((byte) i7);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f21862a.g(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) {
            this.f21862a.j(bArr, i7, i8);
        }
    }

    private static class f implements p<CharSequence>, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Charset f21863a;

        private static class a implements Serializable {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final long f21864b = 0;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f21865a;

            a(Charset charset) {
                this.f21865a = charset.name();
            }

            private Object readResolve() {
                return q.f(Charset.forName(this.f21865a));
            }
        }

        f(Charset charset) {
            this.f21863a = (Charset) com.google.common.base.e0.E(charset);
        }

        @Override // com.google.common.hash.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void Q(CharSequence charSequence, h0 h0Var) {
            h0Var.m(charSequence, this.f21863a);
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.f21863a.equals(((f) obj).f21863a);
            }
            return false;
        }

        public int hashCode() {
            return f.class.hashCode() ^ this.f21863a.hashCode();
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.f21863a.name() + ")";
        }

        Object writeReplace() {
            return new a(this.f21863a);
        }
    }

    private enum g implements p<CharSequence> {
        INSTANCE;

        @Override // com.google.common.hash.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void Q(CharSequence charSequence, h0 h0Var) {
            h0Var.i(charSequence);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }
    }

    private q() {
    }

    public static OutputStream a(h0 h0Var) {
        return new e(h0Var);
    }

    public static p<byte[]> b() {
        return a.INSTANCE;
    }

    public static p<Integer> c() {
        return b.INSTANCE;
    }

    public static p<Long> d() {
        return c.INSTANCE;
    }

    public static <E> p<Iterable<? extends E>> e(p<E> pVar) {
        return new d(pVar);
    }

    public static p<CharSequence> f(Charset charset) {
        return new f(charset);
    }

    public static p<CharSequence> g() {
        return g.INSTANCE;
    }
}
