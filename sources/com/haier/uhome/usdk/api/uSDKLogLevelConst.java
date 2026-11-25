package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKLogLevelConst {
    USDK_LOG_DEBUG(1, "DEBUG"),
    USDK_LOG_INFO(2, "INFO"),
    USDK_LOG_WARN(4, "WARNING"),
    USDK_LOG_ERROR(8, "ERROR"),
    USDK_LOG_NONE(16, "NONE");

    private final String content;
    private final int levelId;

    uSDKLogLevelConst(int i7, String str) {
        this.levelId = i7;
        this.content = str;
    }

    public static uSDKLogLevelConst getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return USDK_LOG_NONE;
        }
    }

    public int getLevelId() {
        return this.levelId;
    }

    public String getValue() {
        return this.content;
    }

    public static uSDKLogLevelConst getInstance(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return USDK_LOG_NONE;
        }
    }
}
