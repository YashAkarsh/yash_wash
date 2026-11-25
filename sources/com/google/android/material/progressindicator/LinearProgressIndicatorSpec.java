package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import c.b1;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.n;

/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressIndicatorSpec extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f18029i;

    public LinearProgressIndicatorSpec(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override // com.google.android.material.progressindicator.b
    void e() {
        if (this.f18027g == 0) {
            if (this.f18032b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f18033c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public LinearProgressIndicatorSpec(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7) {
        this(context, attributeSet, i7, LinearProgressIndicator.f18025y);
    }

    public LinearProgressIndicatorSpec(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7, @b1 int i8) {
        super(context, attributeSet, i7, i8);
        TypedArray typedArrayJ = n.j(context, attributeSet, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.f18025y, new int[0]);
        this.f18027g = typedArrayJ.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f18028h = typedArrayJ.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        typedArrayJ.recycle();
        e();
        this.f18029i = this.f18028h == 1;
    }
}
