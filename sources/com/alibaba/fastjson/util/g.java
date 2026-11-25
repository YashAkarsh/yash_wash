package com.alibaba.fastjson.util;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13334c = 8192;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V>[] f13335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13336b;

    protected static final class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K f13338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public V f13339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a<K, V> f13340d;

        public a(K k7, V v7, int i7, a<K, V> aVar) {
            this.f13338b = k7;
            this.f13339c = v7;
            this.f13340d = aVar;
            this.f13337a = i7;
        }
    }

    public g() {
        this(8192);
    }

    public void a() {
        Arrays.fill(this.f13335a, (Object) null);
    }

    public Class b(String str) {
        int i7 = 0;
        while (true) {
            a<K, V>[] aVarArr = this.f13335a;
            if (i7 >= aVarArr.length) {
                return null;
            }
            a<K, V> aVar = aVarArr[i7];
            if (aVar != null) {
                for (a<K, V> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f13340d) {
                    K k7 = aVar.f13338b;
                    if (k7 instanceof Class) {
                        Class cls = (Class) k7;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
            }
            i7++;
        }
    }

    public final V c(K k7) {
        for (a<K, V> aVar = this.f13335a[System.identityHashCode(k7) & this.f13336b]; aVar != null; aVar = aVar.f13340d) {
            if (k7 == aVar.f13338b) {
                return aVar.f13339c;
            }
        }
        return null;
    }

    public boolean d(K k7, V v7) {
        int iIdentityHashCode = System.identityHashCode(k7);
        int i7 = this.f13336b & iIdentityHashCode;
        for (a<K, V> aVar = this.f13335a[i7]; aVar != null; aVar = aVar.f13340d) {
            if (k7 == aVar.f13338b) {
                aVar.f13339c = v7;
                return true;
            }
        }
        this.f13335a[i7] = new a<>(k7, v7, iIdentityHashCode, this.f13335a[i7]);
        return false;
    }

    public g(int i7) {
        this.f13336b = i7 - 1;
        this.f13335a = new a[i7];
    }
}
