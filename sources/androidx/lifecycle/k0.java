package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private final Map<String, Object> f8309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private final Set<Closeable> f8310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f8311c;

    public k0() {
        this.f8309a = new HashMap();
        this.f8310b = new LinkedHashSet();
        this.f8311c = false;
    }

    private static void c(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e8) {
                throw new RuntimeException(e8);
            }
        }
    }

    public void a(@c.m0 Closeable closeable) {
        Set<Closeable> set = this.f8310b;
        if (set != null) {
            synchronized (set) {
                this.f8310b.add(closeable);
            }
        }
    }

    @c.j0
    final void b() {
        this.f8311c = true;
        Map<String, Object> map = this.f8309a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f8309a.values().iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
        }
        Set<Closeable> set = this.f8310b;
        if (set != null) {
            synchronized (set) {
                Iterator<Closeable> it2 = this.f8310b.iterator();
                while (it2.hasNext()) {
                    c(it2.next());
                }
            }
        }
        e();
    }

    <T> T d(String str) {
        T t7;
        Map<String, Object> map = this.f8309a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t7 = (T) this.f8309a.get(str);
        }
        return t7;
    }

    protected void e() {
    }

    <T> T f(String str, T t7) {
        Object obj;
        synchronized (this.f8309a) {
            obj = this.f8309a.get(str);
            if (obj == null) {
                this.f8309a.put(str, t7);
            }
        }
        if (obj != null) {
            t7 = (T) obj;
        }
        if (this.f8311c) {
            c(t7);
        }
        return t7;
    }

    public k0(@c.m0 Closeable... closeableArr) {
        this.f8309a = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f8310b = linkedHashSet;
        this.f8311c = false;
        linkedHashSet.addAll(Arrays.asList(closeableArr));
    }
}
