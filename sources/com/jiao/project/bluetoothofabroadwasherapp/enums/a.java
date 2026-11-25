package com.jiao.project.bluetoothofabroadwasherapp.enums;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    DATA_RESULT_SUCCESS(1003, "数据已返回"),
    CONNECTION_SUCCESS_SEND_COMMENT(1002, "指令下发成功"),
    NOT_RESULT_FAIL(1002, "机器蓝牙模块响应失败"),
    FAIL_BLUETOOTH(1003, "返回数据校验错误"),
    FAIL_MY(1, "输入数据校验错误"),
    CONNECTION_SUCCESS(3001, "蓝牙连接成功"),
    DISCONNET_FAIL(3002, "蓝牙连接断开"),
    SEARCH(3002, "蓝牙搜索中"),
    SEARCH_END(3002, "蓝牙搜索结束"),
    NOT_THIS_ADDRESS_FAIL(3003, "蓝牙未搜索到找到当前设备、\n或当前设备已被其他蓝牙进程占用"),
    CONNET_FAIL(3004, "蓝牙连接失败"),
    OTHER_FAIL(-1, "其他错误"),
    CUSTOM(0, "");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f32291a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f32292b;

    a(int i7, String str) {
        this.f32292b = str;
    }

    public static a b(int i7) {
        for (a aVar : values()) {
            if (aVar.c() == i7) {
                return aVar;
            }
        }
        return OTHER_FAIL;
    }

    public int c() {
        return this.f32291a;
    }

    public String d() {
        return this.f32292b;
    }

    public a e(String str) {
        int i7 = this.f32291a;
        a aVar = CUSTOM;
        if (i7 == aVar.f32291a) {
            this.f32292b = str;
        }
        return aVar;
    }

    a(String str) {
        this.f32292b = str;
    }
}
