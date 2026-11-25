package com.jiao.project.bluetoothofabroadwasherapp.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum e {
    ERROR(-1, "未明确参数"),
    STANDBY(0, "待机"),
    START_WAITING(1, "启动等待"),
    DRYING(2, "烘干中"),
    COOLING(3, "冷却中"),
    SUSPEND(4, "暂停中"),
    END(5, "结束");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f32326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f32327b;

    e(int i7, String str) {
        this.f32326a = i7;
        this.f32327b = str;
    }

    public static String b(int i7) {
        for (e eVar : values()) {
            if (eVar.f32326a == i7) {
                return eVar.f32327b;
            }
        }
        return ERROR.f32327b + " " + i7;
    }
}
