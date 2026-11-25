package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f24231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private t[] f24233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f24234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<s, Object> f24235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f24236g;

    public r(String str, byte[] bArr, t[] tVarArr, a aVar) {
        this(str, bArr, tVarArr, aVar, System.currentTimeMillis());
    }

    public void a(t[] tVarArr) {
        t[] tVarArr2 = this.f24233d;
        if (tVarArr2 == null) {
            this.f24233d = tVarArr;
            return;
        }
        if (tVarArr == null || tVarArr.length <= 0) {
            return;
        }
        t[] tVarArr3 = new t[tVarArr2.length + tVarArr.length];
        System.arraycopy(tVarArr2, 0, tVarArr3, 0, tVarArr2.length);
        System.arraycopy(tVarArr, 0, tVarArr3, tVarArr2.length, tVarArr.length);
        this.f24233d = tVarArr3;
    }

    public a b() {
        return this.f24234e;
    }

    public int c() {
        return this.f24232c;
    }

    public byte[] d() {
        return this.f24231b;
    }

    public Map<s, Object> e() {
        return this.f24235f;
    }

    public t[] f() {
        return this.f24233d;
    }

    public String g() {
        return this.f24230a;
    }

    public long h() {
        return this.f24236g;
    }

    public void i(Map<s, Object> map) {
        if (map != null) {
            Map<s, Object> map2 = this.f24235f;
            if (map2 == null) {
                this.f24235f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void j(s sVar, Object obj) {
        if (this.f24235f == null) {
            this.f24235f = new EnumMap(s.class);
        }
        this.f24235f.put(sVar, obj);
    }

    public String toString() {
        return this.f24230a;
    }

    public r(String str, byte[] bArr, t[] tVarArr, a aVar, long j7) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, tVarArr, aVar, j7);
    }

    public r(String str, byte[] bArr, int i7, t[] tVarArr, a aVar, long j7) {
        this.f24230a = str;
        this.f24231b = bArr;
        this.f24232c = i7;
        this.f24233d = tVarArr;
        this.f24234e = aVar;
        this.f24235f = null;
        this.f24236g = j7;
    }
}
