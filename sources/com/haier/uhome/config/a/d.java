package com.haier.uhome.config.a;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    BEGIN_CONNECT("beginConnectDevice"),
    BEGIN_CONFIG("beginConfigDevice"),
    BEGIN_BIND("beginBindDevice"),
    WRITE_OK("writeOK");


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28425e;

    d(String str) {
        this.f28425e = str;
    }

    public String a() {
        return this.f28425e;
    }

    public static d a(String str) {
        for (d dVar : values()) {
            if (com.haier.library.common.util.c.c(str, dVar.f28425e)) {
                return dVar;
            }
        }
        return null;
    }
}
