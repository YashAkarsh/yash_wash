package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import c.m0;
import com.google.android.material.internal.v;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private k() {
    }

    @m0
    static e a(int i7) {
        if (i7 != 0) {
            return i7 != 1 ? b() : new f();
        }
        return new n();
    }

    @m0
    static e b() {
        return new n();
    }

    @m0
    static g c() {
        return new g();
    }

    public static void d(@m0 View view, float f8) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            ((j) background).m0(f8);
        }
    }

    public static void e(@m0 View view) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            f(view, (j) background);
        }
    }

    public static void f(@m0 View view, @m0 j jVar) {
        if (jVar.a0()) {
            jVar.r0(v.i(view));
        }
    }
}
