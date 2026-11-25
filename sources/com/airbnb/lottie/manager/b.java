package com.airbnb.lottie.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import c.o0;
import com.airbnb.lottie.d;
import com.airbnb.lottie.i;
import com.airbnb.lottie.utils.f;
import com.airbnb.lottie.utils.j;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f11913e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private d f11916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, i> f11917d;

    public b(Drawable.Callback callback, String str, d dVar, Map<String, i> map) {
        this.f11915b = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f11915b;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f11915b += '/';
            }
        }
        if (callback instanceof View) {
            this.f11914a = ((View) callback).getContext();
            this.f11917d = map;
            d(dVar);
        } else {
            f.e("LottieDrawable must be inside of a view for images to work.");
            this.f11917d = new HashMap();
            this.f11914a = null;
        }
    }

    private Bitmap c(String str, @o0 Bitmap bitmap) {
        synchronized (f11913e) {
            this.f11917d.get(str).g(bitmap);
        }
        return bitmap;
    }

    @o0
    public Bitmap a(String str) {
        i iVar = this.f11917d.get(str);
        if (iVar == null) {
            return null;
        }
        Bitmap bitmapA = iVar.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        d dVar = this.f11916c;
        if (dVar != null) {
            Bitmap bitmapA2 = dVar.a(iVar);
            if (bitmapA2 != null) {
                c(str, bitmapA2);
            }
            return bitmapA2;
        }
        String strC = iVar.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e8) {
                f.f("data URL did not have correct base64 format.", e8);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f11915b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return c(str, j.m(BitmapFactory.decodeStream(this.f11914a.getAssets().open(this.f11915b + strC), null, options), iVar.f(), iVar.d()));
        } catch (IOException e9) {
            f.f("Unable to open asset.", e9);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f11914a == null) || this.f11914a.equals(context);
    }

    public void d(@o0 d dVar) {
        this.f11916c = dVar;
    }

    @o0
    public Bitmap e(String str, @o0 Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap bitmapA = this.f11917d.get(str).a();
            c(str, bitmap);
            return bitmapA;
        }
        i iVar = this.f11917d.get(str);
        Bitmap bitmapA2 = iVar.a();
        iVar.g(null);
        return bitmapA2;
    }
}
