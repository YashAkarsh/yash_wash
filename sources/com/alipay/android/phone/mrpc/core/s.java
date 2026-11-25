package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f13487a;

    public static final boolean a(Context context) {
        Boolean bool = f13487a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f13487a = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
