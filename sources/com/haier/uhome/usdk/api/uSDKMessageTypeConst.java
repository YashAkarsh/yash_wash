package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKMessageTypeConst {
    MESSAGE_INFRARED_DATA("红外数据"),
    MESSAGE_CHECKING_RESULT("生产检测数据"),
    MESSAGE_BIGDATA("大数据"),
    MESSAGE_OTHER("其他数据");

    private final String content;

    uSDKMessageTypeConst(String str) {
        this.content = str;
    }

    public static uSDKMessageTypeConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return MESSAGE_OTHER;
        }
    }

    public String getValue() {
        return this.content;
    }

    public static uSDKMessageTypeConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return MESSAGE_OTHER;
        }
    }
}
