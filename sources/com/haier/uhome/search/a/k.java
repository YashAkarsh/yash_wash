package com.haier.uhome.search.a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class k implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f29716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.h f29718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f29719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f29724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f29725j;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z7, String str8) {
        this.f29717b = str;
        this.f29720e = str3;
        this.f29721f = str4;
        this.f29722g = str5;
        this.f29716a = str6;
        this.f29723h = str7;
        this.f29724i = z7;
        this.f29725j = str8;
        c(str2);
    }

    private int a(String str, int i7, int i8) {
        try {
            return Integer.valueOf(str.substring(i7, i8), 16).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private void c(String str) {
        int i7;
        try {
            i7 = Integer.parseInt(f());
        } catch (Exception unused) {
            i7 = 0;
        }
        if (i7 >= 5) {
            this.f29718c = com.haier.uhome.usdk.base.api.h.a(a(str, 0, 2));
            this.f29719d = a(str, 2, 4);
        } else {
            this.f29718c = com.haier.uhome.usdk.base.api.h.b(str);
            this.f29719d = 0;
        }
    }

    public com.haier.uhome.usdk.base.api.h b() {
        return this.f29718c;
    }

    public String d() {
        return this.f29720e;
    }

    public String e() {
        return this.f29716a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f29723h;
        String strI = ((k) obj).i();
        if (str != null) {
            return str.equals(strI);
        }
        return strI == null;
    }

    public String f() {
        return this.f29721f;
    }

    public String g() {
        return this.f29722g;
    }

    public boolean h() {
        try {
            return Integer.parseInt(this.f29721f) >= 3;
        } catch (Exception unused) {
            return false;
        }
    }

    public int hashCode() {
        return this.f29723h.hashCode();
    }

    public String i() {
        return this.f29723h;
    }

    public boolean j() {
        return this.f29724i;
    }

    public String k() {
        return this.f29725j;
    }

    public String toString() {
        return "ScanDevice{manufacturer=" + this.f29717b + ", deviceType=" + this.f29718c + ", middleType=" + this.f29719d + ", devIdSuffix=" + this.f29720e + ", ssid=" + this.f29716a + ", version=" + this.f29721f + ", configType=" + this.f29722g + ", id=" + this.f29723h + ", supportNoPwdConfig=" + this.f29724i + ", devId=" + this.f29725j + '}';
    }

    public void b(String str) {
        this.f29725j = str;
    }

    public String a() {
        return this.f29717b;
    }

    public void a(String str) {
        this.f29722g = str;
    }

    public void a(boolean z7) {
        this.f29724i = z7;
    }

    public int c() {
        return this.f29719d;
    }
}
