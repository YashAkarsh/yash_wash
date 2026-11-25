package com.haier.library.sumhttp.a;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    SOFT_AP("softap"),
    BLE(com.haier.uhome.usdk.base.a.aq);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27923a;

    a(String str) {
        this.f27923a = str;
    }

    public static a a(String str) {
        for (a aVar : values()) {
            if (com.haier.library.common.util.c.d(aVar.f27923a, str)) {
                return aVar;
            }
        }
        return null;
    }

    public String b() {
        return this.f27923a;
    }
}
