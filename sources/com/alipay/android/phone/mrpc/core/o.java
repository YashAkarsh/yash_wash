package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes.dex */
public final class o extends t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f13459c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13463g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<Header> f13461e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f13462f = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13460d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f13458b = str;
    }

    public final String a() {
        return this.f13458b;
    }

    public final String b(String str) {
        Map<String, String> map = this.f13462f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final String c() {
        return this.f13460d;
    }

    public final ArrayList<Header> d() {
        return this.f13461e;
    }

    public final boolean e() {
        return this.f13463g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        byte[] bArr = this.f13459c;
        if (bArr == null) {
            if (oVar.f13459c != null) {
                return false;
            }
        } else if (!bArr.equals(oVar.f13459c)) {
            return false;
        }
        String str = this.f13458b;
        String str2 = oVar.f13458b;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Map<String, String> map = this.f13462f;
        int iHashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f13462f.get("id").hashCode() + 31) * 31;
        String str = this.f13458b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f13458b, this.f13461e);
    }

    public final void a(String str) {
        this.f13460d = str;
    }

    public final byte[] b() {
        return this.f13459c;
    }

    public final void a(String str, String str2) {
        if (this.f13462f == null) {
            this.f13462f = new HashMap();
        }
        this.f13462f.put(str, str2);
    }

    public final void a(Header header) {
        this.f13461e.add(header);
    }

    public final void a(boolean z7) {
        this.f13463g = z7;
    }

    public final void a(byte[] bArr) {
        this.f13459c = bArr;
    }
}
