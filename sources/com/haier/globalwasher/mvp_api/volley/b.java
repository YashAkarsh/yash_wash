package com.haier.globalwasher.mvp_api.volley;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f24806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f24807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f24808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f24809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f24810e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f24811f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f24812g = Collections.emptyMap();

        public boolean a() {
            return this.f24810e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f24811f < System.currentTimeMillis();
        }
    }

    void a();

    void b(String str, a aVar);

    a c(String str);

    void clear();

    void d(String str, boolean z7);

    void remove(String str);
}
