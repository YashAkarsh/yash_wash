package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.provider.Settings;
import c.g1;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f18030a = 1.0f;

    @g1
    public static void b(float f8) {
        f18030a = f8;
    }

    public float a(@m0 ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
