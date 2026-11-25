package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class ha {

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final nb f20389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f20390b;

        public <E> ga<E> a() {
            if (!this.f20390b) {
                this.f20389a.l();
            }
            return new d(this.f20389a);
        }

        public b b(int i7) {
            this.f20389a.a(i7);
            return this;
        }

        public b c() {
            this.f20390b = true;
            return this;
        }

        @s1.c("java.lang.ref.WeakReference")
        public b d() {
            this.f20390b = false;
            return this;
        }

        private b() {
            this.f20389a = new nb();
            this.f20390b = true;
        }
    }

    private static class c<E> implements com.google.common.base.s<E, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ga<E> f20391a;

        public c(ga<E> gaVar) {
            this.f20391a = gaVar;
        }

        @Override // com.google.common.base.s, java.util.function.Function
        public E apply(E e8) {
            return this.f20391a.a(e8);
        }

        @Override // com.google.common.base.s
        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return this.f20391a.equals(((c) obj).f20391a);
            }
            return false;
        }

        public int hashCode() {
            return this.f20391a.hashCode();
        }
    }

    @s1.d
    static final class d<E> implements ga<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @s1.d
        final ob<E, nb.a, ?, ?> f20392a;

        @Override // com.google.common.collect.ga
        public E a(E e8) {
            E e9;
            do {
                ob.j jVarF = this.f20392a.f(e8);
                if (jVarF != null && (e9 = (E) jVarF.getKey()) != null) {
                    return e9;
                }
            } while (this.f20392a.putIfAbsent(e8, nb.a.VALUE) != null);
            return e8;
        }

        private d(nb nbVar) {
            this.f20392a = ob.e(nbVar.h(com.google.common.base.l.c()));
        }
    }

    private ha() {
    }

    public static <E> com.google.common.base.s<E, E> a(ga<E> gaVar) {
        return new c((ga) com.google.common.base.e0.E(gaVar));
    }

    public static b b() {
        return new b();
    }

    public static <E> ga<E> c() {
        return b().c().a();
    }

    @s1.c("java.lang.ref.WeakReference")
    public static <E> ga<E> d() {
        return b().d().a();
    }
}
