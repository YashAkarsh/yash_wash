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
public final class CircularProgressIndicatorSpec extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @r0
    public int f18022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @r0
    public int f18023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f18024i;

    public CircularProgressIndicatorSpec(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.b
    void e() {
    }

    public CircularProgressIndicatorSpec(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7) {
        this(context, attributeSet, i7, CircularProgressIndicator.f18020y);
    }

    public CircularProgressIndicatorSpec(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7, @b1 int i8) {
        super(context, attributeSet, i7, i8);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.CircularProgressIndicator, i7, i8, new int[0]);
        this.f18022g = Math.max(com.google.android.material.resources.c.c(context, typedArrayJ, R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f18031a * 2);
        this.f18023h = com.google.android.material.resources.c.c(context, typedArrayJ, R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f18024i = typedArrayJ.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayJ.recycle();
        e();
    }
}
