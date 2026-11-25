package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import c.b1;
import c.m0;
import c.o0;
import c.r0;
import com.google.android.material.R;
import com.google.android.material.internal.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @r0
    public int f18031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @r0
    public int f18032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    public int[] f18033c = new int[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.l
    public int f18034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18036f;

    protected b(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7, @b1 int i8) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.BaseProgressIndicator, i7, i8, new int[0]);
        this.f18031a = com.google.android.material.resources.c.c(context, typedArrayJ, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f18032b = Math.min(com.google.android.material.resources.c.c(context, typedArrayJ, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f18031a / 2);
        this.f18035e = typedArrayJ.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f18036f = typedArrayJ.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        c(context, typedArrayJ);
        d(context, typedArrayJ);
        typedArrayJ.recycle();
    }

    private void c(@m0 Context context, @m0 TypedArray typedArray) {
        if (!typedArray.hasValue(R.styleable.BaseProgressIndicator_indicatorColor)) {
            this.f18033c = new int[]{k1.a.b(context, R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(R.styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.f18033c = new int[]{typedArray.getColor(R.styleable.BaseProgressIndicator_indicatorColor, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(R.styleable.BaseProgressIndicator_indicatorColor, -1));
        this.f18033c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    private void d(@m0 Context context, @m0 TypedArray typedArray) {
        if (typedArray.hasValue(R.styleable.BaseProgressIndicator_trackColor)) {
            this.f18034d = typedArray.getColor(R.styleable.BaseProgressIndicator_trackColor, -1);
            return;
        }
        this.f18034d = this.f18033c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float f8 = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f18034d = k1.a.a(this.f18034d, (int) (f8 * 255.0f));
    }

    public boolean a() {
        return this.f18036f != 0;
    }

    public boolean b() {
        return this.f18035e != 0;
    }

    abstract void e();
}
