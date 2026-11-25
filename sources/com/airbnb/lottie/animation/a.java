package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class a extends Paint {
    public a() {
    }

    @Override // android.graphics.Paint
    public void setTextLocales(@m0 LocaleList localeList) {
    }

    public a(int i7) {
        super(i7);
    }

    public a(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public a(int i7, PorterDuff.Mode mode) {
        super(i7);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
