package com.haier.globalwasher.modle.enum_;

/* JADX INFO: loaded from: classes2.dex */
public enum h {
    MUSIC(1, null),
    IMAGE(2, "image/*"),
    VIDEO(3, null),
    WEB(4, "text/plain"),
    TEXT(5, "text/plain"),
    UNKNOW(-1, null);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24478b;

    h(int i7, String str) {
        this.f24477a = i7;
        this.f24478b = str;
    }

    public static h c(int i7) {
        for (h hVar : values()) {
            if (hVar.b() == i7) {
                return hVar;
            }
        }
        return UNKNOW;
    }

    public int b() {
        return this.f24477a;
    }

    public String d() {
        return this.f24478b;
    }

    public void e(int i7) {
        this.f24477a = i7;
    }

    public void f(String str) {
        this.f24478b = str;
    }
}
