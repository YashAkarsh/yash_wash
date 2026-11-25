package com.google.android.material.internal;

import android.os.Build;
import c.x0;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f17801a = "lge";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f17802b = "samsung";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f17803c = "meizu";

    private e() {
    }

    public static boolean a() {
        return b() || d();
    }

    public static boolean b() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f17801a);
    }

    public static boolean c() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f17803c);
    }

    public static boolean d() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f17802b);
    }
}
