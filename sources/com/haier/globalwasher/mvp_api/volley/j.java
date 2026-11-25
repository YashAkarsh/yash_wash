package com.haier.globalwasher.mvp_api.volley;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f24841f = -20150728102000L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f24842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f24843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f24844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f24846e;

    public j(int i7, byte[] bArr, Map<String, String> map, boolean z7, long j7) {
        this.f24842a = i7;
        this.f24843b = bArr;
        this.f24844c = map;
        this.f24845d = z7;
        this.f24846e = j7;
    }

    public j(int i7, byte[] bArr, Map<String, String> map, boolean z7) {
        this(i7, bArr, map, z7, 0L);
    }

    public j(byte[] bArr) {
        this(200, bArr, Collections.emptyMap(), false, 0L);
    }

    public j(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }
}
