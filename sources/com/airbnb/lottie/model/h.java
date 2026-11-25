package com.airbnb.lottie.model;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f12087d = "\r";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12090c;

    public h(String str, float f8, float f9) {
        this.f12088a = str;
        this.f12090c = f9;
        this.f12089b = f8;
    }

    public boolean a(String str) {
        if (this.f12088a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f12088a.endsWith(f12087d)) {
            String str2 = this.f12088a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
