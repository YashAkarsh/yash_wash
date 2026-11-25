package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum uSDKState {
    STATE_UNSTART("uSDK未启动"),
    STATE_STARTING("uSDK启动中"),
    STATE_STARTED("uSDK已启动");

    private String description;

    uSDKState(String str) {
        this.description = str;
    }

    public static uSDKState getInstance(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return STATE_UNSTART;
        }
    }

    public String getDescription() {
        return this.description;
    }
}
