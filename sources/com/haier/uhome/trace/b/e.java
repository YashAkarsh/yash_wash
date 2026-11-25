package com.haier.uhome.trace.b;

/* JADX INFO: loaded from: classes2.dex */
public enum e {
    APP,
    USDK,
    MODULE;

    public static e a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return APP;
        }
    }
}
