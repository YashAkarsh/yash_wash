package androidx.collection;

import c.m0;
import c.o0;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f2288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2294g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2295h;

    public g(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2290c = i7;
        this.f2288a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int p(K k7, V v7) {
        int iR = r(k7, v7);
        if (iR >= 0) {
            return iR;
        }
        throw new IllegalStateException("Negative size: " + k7 + "=" + v7);
    }

    @o0
    protected V c(@m0 K k7) {
        return null;
    }

    public final synchronized int d() {
        return this.f2292e;
    }

    protected void e(boolean z7, @m0 K k7, @m0 V v7, @o0 V v8) {
    }

    public final void f() {
        t(-1);
    }

    public final synchronized int g() {
        return this.f2293f;
    }

    @o0
    public final V h(@m0 K k7) {
        V vPut;
        if (k7 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v7 = this.f2288a.get(k7);
            if (v7 != null) {
                this.f2294g++;
                return v7;
            }
            this.f2295h++;
            V vC = c(k7);
            if (vC == null) {
                return null;
            }
            synchronized (this) {
                this.f2292e++;
                vPut = this.f2288a.put(k7, vC);
                if (vPut != null) {
                    this.f2288a.put(k7, vPut);
                } else {
                    this.f2289b += p(k7, vC);
                }
            }
            if (vPut != null) {
                e(false, k7, vC, vPut);
                return vPut;
            }
            t(this.f2290c);
            return vC;
        }
    }

    public final synchronized int i() {
        return this.f2294g;
    }

    public final synchronized int j() {
        return this.f2290c;
    }

    public final synchronized int k() {
        return this.f2295h;
    }

    @o0
    public final V l(@m0 K k7, @m0 V v7) {
        V vPut;
        if (k7 == null || v7 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2291d++;
            this.f2289b += p(k7, v7);
            vPut = this.f2288a.put(k7, v7);
            if (vPut != null) {
                this.f2289b -= p(k7, vPut);
            }
        }
        if (vPut != null) {
            e(false, k7, vPut, v7);
        }
        t(this.f2290c);
        return vPut;
    }

    public final synchronized int m() {
        return this.f2291d;
    }

    @o0
    public final V n(@m0 K k7) {
        V vRemove;
        if (k7 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            vRemove = this.f2288a.remove(k7);
            if (vRemove != null) {
                this.f2289b -= p(k7, vRemove);
            }
        }
        if (vRemove != null) {
            e(false, k7, vRemove, null);
        }
        return vRemove;
    }

    public void o(int i7) {
        if (i7 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f2290c = i7;
        }
        t(i7);
    }

    public final synchronized int q() {
        return this.f2289b;
    }

    protected int r(@m0 K k7, @m0 V v7) {
        return 1;
    }

    public final synchronized Map<K, V> s() {
        return new LinkedHashMap(this.f2288a);
    }

    public void t(int i7) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f2289b < 0 || (this.f2288a.isEmpty() && this.f2289b != 0)) {
                    break;
                }
                if (this.f2289b > i7 && !this.f2288a.isEmpty()) {
                    Map.Entry<K, V> next = this.f2288a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f2288a.remove(key);
                    this.f2289b -= p(key, value);
                    this.f2293f++;
                }
                return;
            }
            e(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized String toString() {
        int i7;
        int i8;
        i7 = this.f2294g;
        i8 = this.f2295h + i7;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f2290c), Integer.valueOf(this.f2294g), Integer.valueOf(this.f2295h), Integer.valueOf(i8 != 0 ? (i7 * 100) / i8 : 0));
    }
}
