package com.haier.library.common.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f26585c = 60000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f26586d = 10000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f26587e = "AutoExpirationMap ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    j<K, V>.b f26588a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<K, j<K, V>.c> f26590f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.haier.library.common.thread.d f26589b = new com.haier.library.common.thread.d();

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ScheduledFuture f26591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f26592b;

        private b() {
        }
    }

    private class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f26594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f26595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private V f26596c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f26597d;

        private c() {
        }
    }

    public j() {
        String str;
        String strD = d();
        f26587e = strD;
        if (TextUtils.isEmpty(strD)) {
            str = "AutoExpirationMap:";
        } else {
            str = f26587e + ":";
        }
        f26587e = str;
    }

    private static String d() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 1) {
            return "";
        }
        int i7 = 0;
        while (true) {
            if (i7 >= stackTrace.length) {
                i7 = 0;
                break;
            }
            if (stackTrace[i7].getFileName() == null) {
                return "";
            }
            if (!stackTrace[i7].getFileName().contains("AutoExpirationMap")) {
                break;
            }
            i7++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i8 = i7; i8 < i7 + 1 && i8 < stackTrace.length; i8++) {
            String fileName = stackTrace[i8].getFileName();
            if (fileName != null && fileName.length() > 2) {
                fileName = String.format("%s-%s", fileName.substring(0, 1), fileName.substring(1));
            }
            sb.append(String.format("[%s:%s]", fileName, Integer.valueOf(stackTrace[i8].getLineNumber())));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized void g(K k7) {
        j<K, V>.c cVar = this.f26590f.get(k7);
        if (cVar == null) {
            return;
        }
        if (((c) cVar).f26597d) {
            this.f26590f.remove(k7);
            k(k7, ((c) cVar).f26596c);
        } else {
            e3.a.e(f26587e + "%s timeout but warned no so return", k7);
        }
    }

    private K f() {
        if (this.f26590f.isEmpty()) {
            return null;
        }
        Map.Entry<K, j<K, V>.c> entry = null;
        for (Map.Entry<K, j<K, V>.c> entry2 : this.f26590f.entrySet()) {
            if (!((c) entry2.getValue()).f26597d) {
                if (entry != null) {
                    try {
                        if (((c) entry.getValue()).f26595b > ((c) entry2.getValue()).f26595b) {
                        }
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                entry = entry2;
            }
        }
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void i() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        final Object objF = f();
        if (objF == null) {
            return;
        }
        j<K, V>.c cVar = this.f26590f.get(objF);
        if (cVar == null) {
            return;
        }
        if (((c) cVar).f26595b > jCurrentTimeMillis) {
            return;
        }
        if (((c) cVar).f26597d) {
            return;
        }
        ((c) cVar).f26597d = true;
        m(objF, ((c) cVar).f26596c);
        long j7 = ((c) cVar).f26594a - jCurrentTimeMillis;
        if (j7 < 0) {
            j7 = 0;
        }
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.library.common.util.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f26583a.g(objF);
            }
        }, j7, TimeUnit.MILLISECONDS);
    }

    private synchronized void k(K k7, V v7) {
        e3.a.e(f26587e + "callTimeout  " + k7, new Object[0]);
        a(k7, v7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        K kF = f();
        if (kF == null) {
            e3.a.e(f26587e + "no first key so return", new Object[0]);
            return;
        }
        j<K, V>.c cVar = this.f26590f.get(kF);
        if (cVar == null) {
            e3.a.v(f26587e + "first key<%s> no value so return", kF);
            return;
        }
        long j7 = ((c) cVar).f26595b;
        j<K, V>.b bVar = this.f26588a;
        if (bVar == null || bVar.f26591a == null) {
            bVar = new b();
        } else {
            e3.a.e(f26587e + "run loop try new time %d, old time %d", Long.valueOf(j7), Long.valueOf(bVar.f26592b));
            if (bVar.f26592b <= j7) {
                return;
            } else {
                bVar.f26591a.cancel(false);
            }
        }
        bVar.f26592b = j7;
        long j8 = (j7 - jCurrentTimeMillis) + 10;
        if (j8 < 0) {
            j8 = 5;
        }
        e3.a.e(f26587e + "run loop after %dS first key %s", Long.valueOf(j8 / 1000), kF);
        bVar.f26591a = com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.library.common.util.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f26581a.n();
            }
        }, j8, TimeUnit.MILLISECONDS);
        this.f26588a = bVar;
    }

    private synchronized void m(K k7, V v7) {
        e3.a.e(f26587e + "callWarnTimeout  " + k7, new Object[0]);
        b(k7, v7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        synchronized (this) {
            this.f26588a = null;
        }
        e3.a.e(f26587e + "run loop Now!", new Object[0]);
        i();
        l();
    }

    public abstract void a(K k7, V v7);

    @Override // java.util.Map
    public synchronized void clear() {
        this.f26590f.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f26590f.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f26590f.containsValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    public Set<Map.Entry<K, V>> entrySet() {
        HashMap map = new HashMap(this.f26590f.size());
        for (Map.Entry<K, j<K, V>.c> entry : this.f26590f.entrySet()) {
            map.put(entry.getKey(), ((c) entry.getValue()).f26596c);
        }
        return map.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        j<K, V>.c cVar = this.f26590f.get(obj);
        if (cVar == null) {
            return null;
        }
        return (V) ((c) cVar).f26596c;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f26590f.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.f26590f.keySet();
    }

    @Override // java.util.Map
    public V put(K k7, V v7) {
        return a(k7, v7, 60000L);
    }

    @Override // java.util.Map
    public synchronized void putAll(Map map) {
        this.f26590f.putAll(map);
    }

    @Override // java.util.Map
    public synchronized V remove(Object obj) {
        j<K, V>.c cVarRemove;
        cVarRemove = this.f26590f.remove(obj);
        e3.a.e(f26587e + "user remove key = " + obj, new Object[0]);
        return cVarRemove == null ? null : (V) ((c) cVarRemove).f26596c;
    }

    @Override // java.util.Map
    public int size() {
        return this.f26590f.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        Collection<j<K, V>.c> collectionValues = this.f26590f.values();
        ArrayList arrayList = new ArrayList();
        for (j<K, V>.c cVar : collectionValues) {
            if (cVar != null) {
                arrayList.add(((c) cVar).f26596c);
            }
        }
        return arrayList;
    }

    public V a(K k7, V v7, long j7) {
        return a(k7, v7, j7, 10000L);
    }

    public void b(K k7, V v7) {
        e3.a.d(f26587e + "<%s> warnTimeout key<%s>", this + "", k7 + "", new Object[0]);
    }

    public V a(K k7, V v7, long j7, long j8) {
        j<K, V>.c cVarPut;
        if (k7 != null && v7 != null) {
            j<K, V>.c cVar = new c();
            ((c) cVar).f26594a = System.currentTimeMillis() + j7;
            ((c) cVar).f26595b = ((c) cVar).f26594a - j8;
            ((c) cVar).f26597d = false;
            ((c) cVar).f26596c = v7;
            synchronized (this) {
                cVarPut = this.f26590f.put(k7, cVar);
            }
            e3.a.e(f26587e + "put key =  " + k7 + " timeout = " + j7 + " warn = " + j8, new Object[0]);
            this.f26589b.c(new Runnable() { // from class: com.haier.library.common.util.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f26582a.l();
                }
            });
            if (cVarPut == null) {
                return null;
            }
            return (V) ((c) cVarPut).f26596c;
        }
        throw null;
    }
}
