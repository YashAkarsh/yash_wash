package com.alipay.sdk.app;

/* JADX INFO: loaded from: classes.dex */
public enum l {
    SUCCEEDED(9000, "处理成功"),
    FAILED(com.haier.uhome.config.service.a.a.f28529h, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(com.haier.uhome.video.a.f32107b, "支付结果确认中");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f13620b;

    l(int i7, String str) {
        this.f13619a = i7;
        this.f13620b = str;
    }

    public static l d(int i7) {
        if (i7 == 4001) {
            return PARAMS_ERROR;
        }
        if (i7 == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i7 == 8000) {
            return PAY_WAITTING;
        }
        if (i7 == 9000) {
            return SUCCEEDED;
        }
        if (i7 != 6001) {
            return i7 != 6002 ? FAILED : NETWORK_ERROR;
        }
        return CANCELED;
    }

    public int a() {
        return this.f13619a;
    }

    public void b(int i7) {
        this.f13619a = i7;
    }

    public void c(String str) {
        this.f13620b = str;
    }

    public String e() {
        return this.f13620b;
    }
}
