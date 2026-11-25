package com.haier.globalwasher.mvp_api.volley.myvolley;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.haier.globalwasher.mvp_api.volley.n;
import com.haier.globalwasher.mvp_api.volley.o;
import com.haier.globalwasher.mvp_api.volley.toolbox.l;
import com.haier.globalwasher.mvp_api.volley.toolbox.u;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24866e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f24867f = "HttpManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d f24868g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24869a = "saywash-android";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o f24870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l f24871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l.f f24872d;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24873a;

        static {
            int[] iArr = new int[b.values().length];
            f24873a = iArr;
            try {
                iArr[b.DISK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24873a[b.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        DISK,
        MEMORY
    }

    private d() {
    }

    public static d d() {
        if (f24868g == null) {
            f24868g = new d();
        }
        return f24868g;
    }

    public <T> void a(n<T> nVar) {
        nVar.S(f24867f);
        e().a(nVar);
    }

    public void b() {
        o oVar = this.f24870b;
        if (oVar != null) {
            oVar.d(f24867f);
        }
    }

    public l c() {
        l lVar = this.f24871c;
        if (lVar != null) {
            return lVar;
        }
        throw new IllegalStateException("ImageLoader not initialized");
    }

    public o e() {
        o oVar = this.f24870b;
        if (oVar != null) {
            return oVar;
        }
        throw new IllegalStateException("RequestQueue not initialized");
    }

    public void f(Context context, String str, Bitmap.CompressFormat compressFormat, int i7, b bVar) {
        if (f24868g == null) {
            f24868g = new d();
        }
        this.f24870b = u.d(context, new int[0]);
        int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass() / 8;
        if (memoryClass > 10) {
            memoryClass = 10;
        }
        int i8 = memoryClass * 1048576;
        int i9 = a.f24873a[bVar.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                this.f24872d = new com.haier.globalwasher.mvp_api.volley.myvolley.a(i8);
            }
            this.f24872d = new com.haier.globalwasher.mvp_api.volley.myvolley.a(i8);
        } else {
            this.f24872d = new com.haier.globalwasher.mvp_api.volley.myvolley.b(context, str, i8, compressFormat, i7);
        }
        this.f24871c = new l(this.f24870b, this.f24872d);
    }
}
