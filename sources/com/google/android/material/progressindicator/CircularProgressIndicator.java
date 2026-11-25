package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import c.m0;
import c.o0;
import c.r0;
import c.x0;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int A = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f18020y = R.style.Widget_MaterialComponents_CircularProgressIndicator;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f18021z = 0;

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public CircularProgressIndicator(@m0 Context context) {
        this(context, null);
    }

    private void t() {
        setIndeterminateDrawable(i.x(getContext(), (CircularProgressIndicatorSpec) this.f18002a));
        setProgressDrawable(e.z(getContext(), (CircularProgressIndicatorSpec) this.f18002a));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f18002a).f18024i;
    }

    @r0
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f18002a).f18023h;
    }

    @r0
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f18002a).f18022g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public CircularProgressIndicatorSpec i(@m0 Context context, @m0 AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndicatorDirection(int i7) {
        ((CircularProgressIndicatorSpec) this.f18002a).f18024i = i7;
        invalidate();
    }

    public void setIndicatorInset(@r0 int i7) {
        S s7 = this.f18002a;
        if (((CircularProgressIndicatorSpec) s7).f18023h != i7) {
            ((CircularProgressIndicatorSpec) s7).f18023h = i7;
            invalidate();
        }
    }

    public void setIndicatorSize(@r0 int i7) {
        int iMax = Math.max(i7, getTrackThickness() * 2);
        S s7 = this.f18002a;
        if (((CircularProgressIndicatorSpec) s7).f18022g != iMax) {
            ((CircularProgressIndicatorSpec) s7).f18022g = iMax;
            ((CircularProgressIndicatorSpec) s7).e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i7) {
        super.setTrackThickness(i7);
        ((CircularProgressIndicatorSpec) this.f18002a).e();
    }

    public CircularProgressIndicator(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7) {
        super(context, attributeSet, i7, f18020y);
        t();
    }
}
