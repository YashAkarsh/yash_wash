package com.haier.uhome.usdk.base.api;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    APP_PROT_STD,
    APP_PROT_SIXID;

    public static a a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return APP_PROT_SIXID;
        }
    }

    public static a a(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return APP_PROT_SIXID;
        }
    }
}
