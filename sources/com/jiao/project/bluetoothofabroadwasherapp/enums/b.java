package com.jiao.project.bluetoothofabroadwasherapp.enums;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public enum b {
    VAILED_CODE("验证码", 1, new int[]{93, 29, 0, 0}),
    DEVICE_STATU("设备属性状态", 1, new int[]{77, 1}),
    RERSET("重置", 1, new int[]{93, 31, 0, 1}),
    DRY_RUN("干衣机运行", 96, new int[]{0, 1, 1, 0, 0, 0, 0}),
    DRY_OFF("DRY关机", 1, new int[]{93, 32, 0, 0}),
    DRY_NO("DRY开机", 1, new int[]{93, 32, 0, 1}),
    WASHER_RUN("洗衣机运行", 96, new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0}),
    WASHER_OFF("WASH关机", 1, new int[]{93, 1, 0, 0}),
    WASHER_NO("WASH关机", 1, new int[]{93, 1, 0, 1});


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f32303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f32305c;

    b(String str, int i7, int[] iArr) {
        this.f32304b = i7;
        this.f32305c = iArr;
        this.f32303a = str;
    }

    public byte b() {
        return com.haier.hailicommontlib.mvp.model.utils.c.l(this.f32304b);
    }

    public String c() {
        return this.f32303a;
    }

    public int[] d() {
        return this.f32305c;
    }
}
