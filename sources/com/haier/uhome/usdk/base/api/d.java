package com.haier.uhome.usdk.base.api;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    DEV_PROT_STD,
    DEV_PROT_EPP,
    DEV_PROT_BT_EPP;

    public static d a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return DEV_PROT_EPP;
        }
    }

    public static d a(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return DEV_PROT_EPP;
        }
    }
}
