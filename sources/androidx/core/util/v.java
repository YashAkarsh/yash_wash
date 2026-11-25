package androidx.core.util;

import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class v {

    public interface a<T> {
        boolean a(@m0 T t7);

        @o0
        T b();
    }

    public static class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object[] f6415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6416b;

        public b(int i7) {
            if (i7 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f6415a = new Object[i7];
        }

        private boolean c(@m0 T t7) {
            for (int i7 = 0; i7 < this.f6416b; i7++) {
                if (this.f6415a[i7] == t7) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.core.util.v.a
        public boolean a(@m0 T t7) {
            if (c(t7)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i7 = this.f6416b;
            Object[] objArr = this.f6415a;
            if (i7 >= objArr.length) {
                return false;
            }
            objArr[i7] = t7;
            this.f6416b = i7 + 1;
            return true;
        }

        @Override // androidx.core.util.v.a
        public T b() {
            int i7 = this.f6416b;
            if (i7 <= 0) {
                return null;
            }
            int i8 = i7 - 1;
            Object[] objArr = this.f6415a;
            T t7 = (T) objArr[i8];
            objArr[i8] = null;
            this.f6416b = i7 - 1;
            return t7;
        }
    }

    public static class c<T> extends b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f6417c;

        public c(int i7) {
            super(i7);
            this.f6417c = new Object();
        }

        @Override // androidx.core.util.v.b, androidx.core.util.v.a
        public boolean a(@m0 T t7) {
            boolean zA;
            synchronized (this.f6417c) {
                zA = super.a(t7);
            }
            return zA;
        }

        @Override // androidx.core.util.v.b, androidx.core.util.v.a
        public T b() {
            T t7;
            synchronized (this.f6417c) {
                t7 = (T) super.b();
            }
            return t7;
        }
    }

    private v() {
    }
}
