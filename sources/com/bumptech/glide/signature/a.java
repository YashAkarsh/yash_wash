package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, w0.c> f14903a = new ConcurrentHashMap<>();

    private a() {
    }

    public static w0.c a(Context context) {
        String packageName = context.getPackageName();
        ConcurrentHashMap<String, w0.c> concurrentHashMap = f14903a;
        w0.c cVar = concurrentHashMap.get(packageName);
        if (cVar != null) {
            return cVar;
        }
        w0.c cVarB = b(context);
        w0.c cVarPutIfAbsent = concurrentHashMap.putIfAbsent(packageName, cVarB);
        return cVarPutIfAbsent == null ? cVarB : cVarPutIfAbsent;
    }

    private static w0.c b(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            packageInfo = null;
        }
        return new d(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
    }

    static void c() {
        f14903a.clear();
    }
}
