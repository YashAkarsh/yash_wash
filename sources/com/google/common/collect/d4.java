package com.google.common.collect;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d4 f20107a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d4 f20108b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d4 f20109c = new b(1);

    static class a extends d4 {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.d4
        public d4 d(double d8, double d9) {
            return o(Double.compare(d8, d9));
        }

        @Override // com.google.common.collect.d4
        public d4 e(float f8, float f9) {
            return o(Float.compare(f8, f9));
        }

        @Override // com.google.common.collect.d4
        public d4 f(int i7, int i8) {
            return o(com.google.common.primitives.c0.e(i7, i8));
        }

        @Override // com.google.common.collect.d4
        public d4 g(long j7, long j8) {
            return o(com.google.common.primitives.d0.d(j7, j8));
        }

        @Override // com.google.common.collect.d4
        public d4 i(Comparable comparable, Comparable comparable2) {
            return o(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.d4
        public <T> d4 j(T t7, T t8, Comparator<T> comparator) {
            return o(comparator.compare(t7, t8));
        }

        @Override // com.google.common.collect.d4
        public d4 k(boolean z7, boolean z8) {
            return o(com.google.common.primitives.a.d(z7, z8));
        }

        @Override // com.google.common.collect.d4
        public d4 l(boolean z7, boolean z8) {
            return o(com.google.common.primitives.a.d(z8, z7));
        }

        @Override // com.google.common.collect.d4
        public int m() {
            return 0;
        }

        d4 o(int i7) {
            if (i7 < 0) {
                return d4.f20108b;
            }
            return i7 > 0 ? d4.f20109c : d4.f20107a;
        }
    }

    private static final class b extends d4 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f20110d;

        b(int i7) {
            super(null);
            this.f20110d = i7;
        }

        @Override // com.google.common.collect.d4
        public d4 d(double d8, double d9) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public d4 e(float f8, float f9) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public d4 f(int i7, int i8) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public d4 g(long j7, long j8) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public d4 i(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public <T> d4 j(T t7, T t8, Comparator<T> comparator) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public d4 k(boolean z7, boolean z8) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public d4 l(boolean z7, boolean z8) {
            return this;
        }

        @Override // com.google.common.collect.d4
        public int m() {
            return this.f20110d;
        }
    }

    /* synthetic */ d4(a aVar) {
        this();
    }

    public static d4 n() {
        return f20107a;
    }

    public abstract d4 d(double d8, double d9);

    public abstract d4 e(float f8, float f9);

    public abstract d4 f(int i7, int i8);

    public abstract d4 g(long j7, long j8);

    @Deprecated
    public final d4 h(Boolean bool, Boolean bool2) {
        return k(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract d4 i(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> d4 j(T t7, T t8, Comparator<T> comparator);

    public abstract d4 k(boolean z7, boolean z8);

    public abstract d4 l(boolean z7, boolean z8);

    public abstract int m();

    private d4() {
    }
}
