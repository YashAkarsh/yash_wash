package com.haier.globalwasher.modle.enum_;

/* JADX INFO: loaded from: classes2.dex */
public enum g {
    PAY_TITLE(1),
    RESERVE_TITLE(2),
    WASHING_NOTIFICATION(3),
    WASHED_NOTIFICATION(4),
    DRYWASHED_TITLE(5),
    DEVICEBROKEN_TITLE(6),
    OCCUPY_BROKEN_NOTIFICATION(7),
    QUEUE_TITLE(8),
    BROADCAST_NOTIFICATION(9),
    PAY_TITLE_GREATE(10),
    PAY_TITLE_START(11),
    BARRELS_OF_CLEAN(12),
    LIEN_UP_FAULT(13),
    APP_MESSAGT(14);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f24469a;

    g(int i7) {
        this.f24469a = i7;
    }

    public static g c(int i7) {
        for (g gVar : values()) {
            if (gVar.b() == i7) {
                return gVar;
            }
        }
        return APP_MESSAGT;
    }

    public int b() {
        return this.f24469a;
    }
}
