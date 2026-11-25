package org.chromium.net.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import org.chromium.net.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f39425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f39426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f39427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f39428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f39429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f39430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicLong f39431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f39432h;

    public static final class a extends u0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<Map.Entry<String, String>> f39433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<String, List<String>> f39434b;

        a(List<Map.Entry<String, String>> list) {
            this.f39433a = list;
        }

        @Override // org.chromium.net.u0.a
        public List<Map.Entry<String, String>> a() {
            return this.f39433a;
        }

        @Override // org.chromium.net.u0.a
        public Map<String, List<String>> b() {
            Map<String, List<String>> map = this.f39434b;
            if (map != null) {
                return map;
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, String> entry : this.f39433a) {
                ArrayList arrayList = new ArrayList();
                if (treeMap.containsKey(entry.getKey())) {
                    arrayList.addAll((Collection) treeMap.get(entry.getKey()));
                }
                arrayList.add(entry.getValue());
                treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
            }
            Map<String, List<String>> mapUnmodifiableMap = Collections.unmodifiableMap(treeMap);
            this.f39434b = mapUnmodifiableMap;
            return mapUnmodifiableMap;
        }
    }

    public u(List<String> list, int i7, String str, List<Map.Entry<String, String>> list2, boolean z7, String str2, String str3, long j7) {
        this.f39425a = Collections.unmodifiableList(list);
        this.f39426b = i7;
        this.f39427c = str;
        this.f39432h = new a(Collections.unmodifiableList(list2));
        this.f39428d = z7;
        this.f39429e = str2;
        this.f39430f = str3;
        this.f39431g = new AtomicLong(j7);
    }

    @Override // org.chromium.net.u0
    public Map<String, List<String>> a() {
        return this.f39432h.b();
    }

    @Override // org.chromium.net.u0
    public List<Map.Entry<String, String>> b() {
        return this.f39432h.a();
    }

    @Override // org.chromium.net.u0
    public int c() {
        return this.f39426b;
    }

    @Override // org.chromium.net.u0
    public String d() {
        return this.f39427c;
    }

    @Override // org.chromium.net.u0
    public String e() {
        return this.f39429e;
    }

    @Override // org.chromium.net.u0
    public String f() {
        return this.f39430f;
    }

    @Override // org.chromium.net.u0
    public long g() {
        return this.f39431g.get();
    }

    @Override // org.chromium.net.u0
    public String h() {
        List<String> list = this.f39425a;
        return list.get(list.size() - 1);
    }

    @Override // org.chromium.net.u0
    public List<String> i() {
        return this.f39425a;
    }

    @Override // org.chromium.net.u0
    public boolean j() {
        return this.f39428d;
    }

    public void k(long j7) {
        this.f39431g.set(j7);
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedByteCount = %d", Integer.toHexString(System.identityHashCode(this)), h(), i().toString(), Integer.valueOf(c()), d(), b().toString(), Boolean.valueOf(j()), e(), f(), Long.valueOf(g()));
    }

    @Deprecated
    public u(List<String> list, int i7, String str, List<Map.Entry<String, String>> list2, boolean z7, String str2, String str3) {
        this(list, i7, str, list2, z7, str2, str3, 0L);
    }
}
