package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14333d = "MemorySizeCalculator";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f14334e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f14335f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f14336g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final float f14337h = 0.4f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final float f14338i = 0.33f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f14341c;

    private static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f14342a;

        public a(DisplayMetrics displayMetrics) {
            this.f14342a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.k.b
        public int a() {
            return this.f14342a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.k.b
        public int b() {
            return this.f14342a.widthPixels;
        }
    }

    interface b {
        int a();

        int b();
    }

    public k(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new a(context.getResources().getDisplayMetrics()));
    }

    private static int b(ActivityManager activityManager) {
        return Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (d(activityManager) ? f14338i : f14337h));
    }

    @TargetApi(19)
    private static boolean d(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String e(int i7) {
        return Formatter.formatFileSize(this.f14341c, i7);
    }

    public int a() {
        return this.f14339a;
    }

    public int c() {
        return this.f14340b;
    }

    k(Context context, ActivityManager activityManager, b bVar) {
        this.f14341c = context;
        int iB = b(activityManager);
        int iB2 = bVar.b() * bVar.a() * 4;
        int i7 = iB2 * 4;
        int i8 = iB2 * 2;
        int i9 = i8 + i7;
        if (i9 <= iB) {
            this.f14340b = i8;
            this.f14339a = i7;
        } else {
            int iRound = Math.round(iB / 6.0f);
            this.f14340b = iRound * 2;
            this.f14339a = iRound * 4;
        }
        if (Log.isLoggable(f14333d, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculated memory cache size: ");
            sb.append(e(this.f14340b));
            sb.append(" pool size: ");
            sb.append(e(this.f14339a));
            sb.append(" memory class limited? ");
            sb.append(i9 > iB);
            sb.append(" max size: ");
            sb.append(e(iB));
            sb.append(" memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(" isLowMemoryDevice: ");
            sb.append(d(activityManager));
            Log.d(f14333d, sb.toString());
        }
    }
}
