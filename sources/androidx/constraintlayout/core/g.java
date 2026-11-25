package androidx.constraintlayout.core;

/* JADX INFO: loaded from: classes.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f2446a = false;

    interface a<T> {
        boolean a(T t7);

        T b();

        void c(T[] tArr, int i7);
    }

    static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f2447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2448b;

        b(int i7) {
            if (i7 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f2447a = new Object[i7];
        }

        private boolean d(T t7) {
            for (int i7 = 0; i7 < this.f2448b; i7++) {
                if (this.f2447a[i7] == t7) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.g.a
        public boolean a(T t7) {
            int i7 = this.f2448b;
            Object[] objArr = this.f2447a;
            if (i7 >= objArr.length) {
                return false;
            }
            objArr[i7] = t7;
            this.f2448b = i7 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.core.g.a
        public T b() {
            int i7 = this.f2448b;
            if (i7 <= 0) {
                return null;
            }
            int i8 = i7 - 1;
            Object[] objArr = this.f2447a;
            T t7 = (T) objArr[i8];
            objArr[i8] = null;
            this.f2448b = i7 - 1;
            return t7;
        }

        @Override // androidx.constraintlayout.core.g.a
        public void c(T[] tArr, int i7) {
            if (i7 > tArr.length) {
                i7 = tArr.length;
            }
            for (int i8 = 0; i8 < i7; i8++) {
                T t7 = tArr[i8];
                int i9 = this.f2448b;
                Object[] objArr = this.f2447a;
                if (i9 < objArr.length) {
                    objArr[i9] = t7;
                    this.f2448b = i9 + 1;
                }
            }
        }
    }

    private g() {
    }
}
