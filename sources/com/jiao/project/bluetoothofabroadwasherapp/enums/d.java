package com.jiao.project.bluetoothofabroadwasherapp.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    STATUS_UNCONNECT("未连接"),
    STATUS_OFFLINE("离线"),
    STATUS_CONNECTING("连接中"),
    STATUS_CONNECTED("连接成功"),
    STATUS_READY("就绪");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32317a;

    d(String str) {
        this.f32317a = str;
    }

    public String b() {
        return this.f32317a;
    }
}
