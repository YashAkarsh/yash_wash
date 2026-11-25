package com.airbnb.lottie.manager;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import c.o0;
import com.airbnb.lottie.model.i;
import com.airbnb.lottie.utils.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AssetManager f11910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.c f11911e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i<String> f11907a = new i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<i<String>, Typeface> f11908b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Typeface> f11909c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11912f = ".ttf";

    public a(Drawable.Callback callback, @o0 com.airbnb.lottie.c cVar) {
        this.f11911e = cVar;
        if (callback instanceof View) {
            this.f11910d = ((View) callback).getContext().getAssets();
        } else {
            f.e("LottieDrawable must be inside of a view for images to work.");
            this.f11910d = null;
        }
    }

    private Typeface a(String str) {
        String strB;
        Typeface typeface = this.f11909c.get(str);
        if (typeface != null) {
            return typeface;
        }
        com.airbnb.lottie.c cVar = this.f11911e;
        Typeface typefaceA = cVar != null ? cVar.a(str) : null;
        com.airbnb.lottie.c cVar2 = this.f11911e;
        if (cVar2 != null && typefaceA == null && (strB = cVar2.b(str)) != null) {
            typefaceA = Typeface.createFromAsset(this.f11910d, strB);
        }
        if (typefaceA == null) {
            typefaceA = Typeface.createFromAsset(this.f11910d, "fonts/" + str + this.f11912f);
        }
        this.f11909c.put(str, typefaceA);
        return typefaceA;
    }

    private Typeface e(Typeface typeface, String str) {
        int i7;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i7 = 3;
        } else if (zContains) {
            i7 = 2;
        } else {
            i7 = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i7 ? typeface : Typeface.create(typeface, i7);
    }

    public Typeface b(String str, String str2) {
        this.f11907a.b(str, str2);
        Typeface typeface = this.f11908b.get(this.f11907a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(a(str), str2);
        this.f11908b.put(this.f11907a, typefaceE);
        return typefaceE;
    }

    public void c(String str) {
        this.f11912f = str;
    }

    public void d(@o0 com.airbnb.lottie.c cVar) {
        this.f11911e = cVar;
    }
}
