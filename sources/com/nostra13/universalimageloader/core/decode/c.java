package com.nostra13.universalimageloader.core.decode;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import com.nostra13.universalimageloader.core.assist.d;
import com.nostra13.universalimageloader.core.assist.e;
import com.nostra13.universalimageloader.core.assist.h;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f32753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f32754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f32755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f32756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.download.c f32757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f32758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f32759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BitmapFactory.Options f32760i;

    public c(String str, String str2, e eVar, h hVar, com.nostra13.universalimageloader.core.download.c cVar, com.nostra13.universalimageloader.core.c cVar2) {
        this.f32752a = str;
        this.f32753b = str2;
        this.f32754c = eVar;
        this.f32755d = cVar2.C();
        this.f32756e = hVar;
        this.f32757f = cVar;
        this.f32758g = cVar2.x();
        this.f32759h = cVar2.H();
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.f32760i = options;
        a(cVar2.u(), options);
    }

    private void a(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inDensity = options.inDensity;
        options2.inDither = options.inDither;
        options2.inInputShareable = options.inInputShareable;
        options2.inJustDecodeBounds = options.inJustDecodeBounds;
        options2.inPreferredConfig = options.inPreferredConfig;
        options2.inPurgeable = options.inPurgeable;
        options2.inSampleSize = options.inSampleSize;
        options2.inScaled = options.inScaled;
        options2.inScreenDensity = options.inScreenDensity;
        options2.inTargetDensity = options.inTargetDensity;
        options2.inTempStorage = options.inTempStorage;
        b(options, options2);
        c(options, options2);
    }

    @TargetApi(10)
    private void b(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inPreferQualityOverSpeed = options.inPreferQualityOverSpeed;
    }

    @TargetApi(11)
    private void c(BitmapFactory.Options options, BitmapFactory.Options options2) {
        options2.inBitmap = options.inBitmap;
        options2.inMutable = options.inMutable;
    }

    public BitmapFactory.Options d() {
        return this.f32760i;
    }

    public com.nostra13.universalimageloader.core.download.c e() {
        return this.f32757f;
    }

    public Object f() {
        return this.f32758g;
    }

    public String g() {
        return this.f32752a;
    }

    public d h() {
        return this.f32755d;
    }

    public String i() {
        return this.f32753b;
    }

    public e j() {
        return this.f32754c;
    }

    public h k() {
        return this.f32756e;
    }

    public boolean l() {
        return this.f32759h;
    }
}
