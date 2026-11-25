package com.bumptech.glide.load.model;

import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class k<A, B> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f14498b = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.util.f<b<A>, B> f14499a;

    class a extends com.bumptech.glide.util.f<b<A>, B> {
        a(int i7) {
            super(i7);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.util.f
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void m(b<A> bVar, B b8) {
            bVar.c();
        }
    }

    static final class b<A> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f14501d = com.bumptech.glide.util.i.d(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f14503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private A f14504c;

        private b() {
        }

        static <A> b<A> a(A a8, int i7, int i8) {
            b<A> bVar = (b) f14501d.poll();
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a8, i7, i8);
            return bVar;
        }

        private void b(A a8, int i7, int i8) {
            this.f14504c = a8;
            this.f14503b = i7;
            this.f14502a = i8;
        }

        public void c() {
            f14501d.offer(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f14503b == bVar.f14503b && this.f14502a == bVar.f14502a && this.f14504c.equals(bVar.f14504c);
        }

        public int hashCode() {
            return (((this.f14502a * 31) + this.f14503b) * 31) + this.f14504c.hashCode();
        }
    }

    public k() {
        this(250);
    }

    public B a(A a8, int i7, int i8) {
        b<A> bVarA = b.a(a8, i7, i8);
        B bK = this.f14499a.k(bVarA);
        bVarA.c();
        return bK;
    }

    public void b(A a8, int i7, int i8, B b8) {
        this.f14499a.n(b.a(a8, i7, i8), b8);
    }

    public k(int i7) {
        this.f14499a = new a(i7);
    }
}
