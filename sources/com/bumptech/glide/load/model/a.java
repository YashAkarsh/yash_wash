package com.bumptech.glide.load.model;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f14460a = "android_asset";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14461b = "file:///android_asset/";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14462c = 22;

    private a() {
    }

    public static boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f14460a.equals(uri.getPathSegments().get(0));
    }

    public static String b(Uri uri) {
        return uri.toString().substring(f14462c);
    }
}
