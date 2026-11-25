package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class f0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f9417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<a<T>> f9418b = new SparseArray<>(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    a<T> f9419c;

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T[] f9420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<T> f9423d;

        public a(Class<T> cls, int i7) {
            this.f9420a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i7));
        }

        boolean a(int i7) {
            int i8 = this.f9421b;
            return i8 <= i7 && i7 < i8 + this.f9422c;
        }

        T b(int i7) {
            return this.f9420a[i7 - this.f9421b];
        }
    }

    public f0(int i7) {
        this.f9417a = i7;
    }

    public a<T> a(a<T> aVar) {
        int iIndexOfKey = this.f9418b.indexOfKey(aVar.f9421b);
        if (iIndexOfKey < 0) {
            this.f9418b.put(aVar.f9421b, aVar);
            return null;
        }
        a<T> aVarValueAt = this.f9418b.valueAt(iIndexOfKey);
        this.f9418b.setValueAt(iIndexOfKey, aVar);
        if (this.f9419c == aVarValueAt) {
            this.f9419c = aVar;
        }
        return aVarValueAt;
    }

    public void b() {
        this.f9418b.clear();
    }

    public a<T> c(int i7) {
        return this.f9418b.valueAt(i7);
    }

    public T d(int i7) {
        a<T> aVar = this.f9419c;
        if (aVar == null || !aVar.a(i7)) {
            int iIndexOfKey = this.f9418b.indexOfKey(i7 - (i7 % this.f9417a));
            if (iIndexOfKey < 0) {
                return null;
            }
            this.f9419c = this.f9418b.valueAt(iIndexOfKey);
        }
        return this.f9419c.b(i7);
    }

    public a<T> e(int i7) {
        a<T> aVar = this.f9418b.get(i7);
        if (this.f9419c == aVar) {
            this.f9419c = null;
        }
        this.f9418b.delete(i7);
        return aVar;
    }

    public int f() {
        return this.f9418b.size();
    }
}
