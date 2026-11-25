package com.jiao.project.bluetoothofabroadwasherapp.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum g {
    ERROR(-1, "未明确参数"),
    STANDBY(0, "待机"),
    WEIGHT(1, "称重"),
    WEASHING_IN_THE_WATER(3, "洗涤进水"),
    WEASHING_HEATING(4, "洗涤加热"),
    WEASHING(5, "洗涤"),
    WEASHING_DRAINAGE(6, "洗涤排水"),
    INTERMEDIATE_DEHYDRATION(7, "中间脱水"),
    RINSE_WATER(8, "漂洗进水"),
    RINSE(9, "漂洗"),
    RINSE__DRAINAGE(10, "漂洗排水"),
    FINAL_DEHYDRATION(11, "最终脱水"),
    END(14, "结束"),
    SHAKE(16, "抖散");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f32364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f32365b;

    g(int i7, String str) {
        this.f32364a = i7;
        this.f32365b = str;
    }

    public static String b(int i7) {
        for (g gVar : values()) {
            if (gVar.f32364a == i7) {
                return gVar.f32365b;
            }
        }
        return ERROR.f32365b + " " + i7;
    }
}
