package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public abstract class i<A, B> implements s<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @v1.b
    private transient i<B, A> f19413b;

    class a implements Iterable<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f19414a;

        /* JADX INFO: renamed from: com.google.common.base.i$a$a, reason: collision with other inner class name */
        class C0225a implements Iterator<B> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Iterator<? extends A> f19416a;

            C0225a() {
                this.f19416a = a.this.f19414a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f19416a.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) i.this.b(this.f19416a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f19416a.remove();
            }
        }

        a(Iterable iterable) {
            this.f19414a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0225a();
        }
    }

    private static final class b<A, B, C> extends i<A, C> implements Serializable {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final long f19418e = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final i<A, B> f19419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final i<B, C> f19420d;

        b(i<A, B> iVar, i<B, C> iVar2) {
            this.f19419c = iVar;
            this.f19420d = iVar2;
        }

        @Override // com.google.common.base.i
        A d(C c8) {
            return (A) this.f19419c.d(this.f19420d.d(c8));
        }

        @Override // com.google.common.base.i
        C e(A a8) {
            return (C) this.f19420d.e(this.f19419c.e(a8));
        }

        @Override // com.google.common.base.i, com.google.common.base.s
        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f19419c.equals(bVar.f19419c) && this.f19420d.equals(bVar.f19420d);
        }

        @Override // com.google.common.base.i
        protected A g(C c8) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.i
        protected C h(A a8) {
            throw new AssertionError();
        }

        public int hashCode() {
            return (this.f19419c.hashCode() * 31) + this.f19420d.hashCode();
        }

        public String toString() {
            return this.f19419c + ".andThen(" + this.f19420d + ")";
        }
    }

    private static final class c<A, B> extends i<A, B> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final s<? super A, ? extends B> f19421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final s<? super B, ? extends A> f19422d;

        /* synthetic */ c(s sVar, s sVar2, a aVar) {
            this(sVar, sVar2);
        }

        @Override // com.google.common.base.i, com.google.common.base.s
        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f19421c.equals(cVar.f19421c) && this.f19422d.equals(cVar.f19422d);
        }

        @Override // com.google.common.base.i
        protected A g(B b8) {
            return this.f19422d.apply(b8);
        }

        @Override // com.google.common.base.i
        protected B h(A a8) {
            return this.f19421c.apply(a8);
        }

        public int hashCode() {
            return (this.f19421c.hashCode() * 31) + this.f19422d.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.f19421c + ", " + this.f19422d + ")";
        }

        private c(s<? super A, ? extends B> sVar, s<? super B, ? extends A> sVar2) {
            this.f19421c = (s) e0.E(sVar);
            this.f19422d = (s) e0.E(sVar2);
        }
    }

    private static final class d<T> extends i<T, T> implements Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final d f19423c = new d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f19424d = 0;

        private d() {
        }

        private Object readResolve() {
            return f19423c;
        }

        @Override // com.google.common.base.i
        <S> i<T, S> f(i<T, S> iVar) {
            return (i) e0.F(iVar, "otherConverter");
        }

        @Override // com.google.common.base.i
        protected T g(T t7) {
            return t7;
        }

        @Override // com.google.common.base.i
        protected T h(T t7) {
            return t7;
        }

        @Override // com.google.common.base.i
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public d<T> k() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    private static final class e<A, B> extends i<B, A> implements Serializable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f19425d = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final i<A, B> f19426c;

        e(i<A, B> iVar) {
            this.f19426c = iVar;
        }

        @Override // com.google.common.base.i
        B d(A a8) {
            return this.f19426c.e(a8);
        }

        @Override // com.google.common.base.i
        A e(B b8) {
            return this.f19426c.d(b8);
        }

        @Override // com.google.common.base.i, com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.f19426c.equals(((e) obj).f19426c);
            }
            return false;
        }

        @Override // com.google.common.base.i
        protected B g(A a8) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.i
        protected A h(B b8) {
            throw new AssertionError();
        }

        public int hashCode() {
            return ~this.f19426c.hashCode();
        }

        @Override // com.google.common.base.i
        public i<A, B> k() {
            return this.f19426c;
        }

        public String toString() {
            return this.f19426c + ".reverse()";
        }
    }

    protected i() {
        this(true);
    }

    public static <A, B> i<A, B> i(s<? super A, ? extends B> sVar, s<? super B, ? extends A> sVar2) {
        return new c(sVar, sVar2, null);
    }

    public static <T> i<T, T> j() {
        return d.f19423c;
    }

    public final <C> i<A, C> a(i<B, C> iVar) {
        return f(iVar);
    }

    @Override // com.google.common.base.s, java.util.function.Function
    @u1.a
    @Deprecated
    public final B apply(A a8) {
        return b(a8);
    }

    @u1.a
    public final B b(A a8) {
        return e(a8);
    }

    @u1.a
    public Iterable<B> c(Iterable<? extends A> iterable) {
        e0.F(iterable, "fromIterable");
        return new a(iterable);
    }

    A d(B b8) {
        if (!this.f19412a) {
            return g(b8);
        }
        if (b8 == null) {
            return null;
        }
        return (A) e0.E(g(b8));
    }

    B e(A a8) {
        if (!this.f19412a) {
            return h(a8);
        }
        if (a8 == null) {
            return null;
        }
        return (B) e0.E(h(a8));
    }

    @Override // com.google.common.base.s
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    <C> i<A, C> f(i<B, C> iVar) {
        return new b(this, (i) e0.E(iVar));
    }

    @u1.g
    protected abstract A g(B b8);

    @u1.g
    protected abstract B h(A a8);

    @u1.a
    public i<B, A> k() {
        i<B, A> iVar = this.f19413b;
        if (iVar != null) {
            return iVar;
        }
        e eVar = new e(this);
        this.f19413b = eVar;
        return eVar;
    }

    i(boolean z7) {
        this.f19412a = z7;
    }
}
