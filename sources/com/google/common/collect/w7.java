package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
class w7<K, V> extends y6<K, V> {

    static final class a<K, V> extends b<K, V> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final transient w7<K, V> f21300e;

        a(K k7, V v7, w7<K, V> w7Var, w7<K, V> w7Var2) {
            super(k7, v7, w7Var);
            this.f21300e = w7Var2;
        }

        @Override // com.google.common.collect.w7
        w7<K, V> g() {
            return this.f21300e;
        }
    }

    static class b<K, V> extends w7<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final transient w7<K, V> f21301d;

        b(K k7, V v7, w7<K, V> w7Var) {
            super(k7, v7);
            this.f21301d = w7Var;
        }

        @Override // com.google.common.collect.w7
        final w7<K, V> e() {
            return this.f21301d;
        }

        @Override // com.google.common.collect.w7
        final boolean h() {
            return false;
        }
    }

    w7(K k7, V v7) {
        super(k7, v7);
        f2.a(k7, v7);
    }

    static <K, V> w7<K, V>[] c(int i7) {
        return new w7[i7];
    }

    w7<K, V> e() {
        return null;
    }

    w7<K, V> g() {
        return null;
    }

    boolean h() {
        return true;
    }

    w7(w7<K, V> w7Var) {
        super(w7Var.getKey(), w7Var.getValue());
    }
}
