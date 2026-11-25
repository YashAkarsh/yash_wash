package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import c.m0;
import c.o0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e extends Property<Drawable, Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property<Drawable, Integer> f16853b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f16854a;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f16854a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @o0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(@m0 Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@m0 Drawable drawable, @m0 Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
