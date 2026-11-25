package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int A = 1;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f18025y = R.style.Widget_MaterialComponents_LinearProgressIndicator;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f18026z = 0;

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public LinearProgressIndicator(@m0 Context context) {
        this(context, null);
    }

    private void t() {
        setIndeterminateDrawable(i.y(getContext(), (LinearProgressIndicatorSpec) this.f18002a));
        setProgressDrawable(e.A(getContext(), (LinearProgressIndicatorSpec) this.f18002a));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.f18002a).f18027g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.f18002a).f18028h;
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        S s7 = this.f18002a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s7;
        boolean z8 = true;
        if (((LinearProgressIndicatorSpec) s7).f18028h != 1 && ((n2.Z(this) != 1 || ((LinearProgressIndicatorSpec) this.f18002a).f18028h != 2) && (n2.Z(this) != 0 || ((LinearProgressIndicatorSpec) this.f18002a).f18028h != 3))) {
            z8 = false;
        }
        linearProgressIndicatorSpec.f18029i = z8;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onSizeChanged(int i7, int i8, int i9, int i10) {
        int paddingLeft = i7 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i8 - (getPaddingTop() + getPaddingBottom());
        i<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public LinearProgressIndicatorSpec i(@m0 Context context, @m0 AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public void setIndeterminateAnimationType(int i7) {
        if (((LinearProgressIndicatorSpec) this.f18002a).f18027g == i7) {
            return;
        }
        if (r() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s7 = this.f18002a;
        ((LinearProgressIndicatorSpec) s7).f18027g = i7;
        ((LinearProgressIndicatorSpec) s7).e();
        if (i7 == 0) {
            getIndeterminateDrawable().B(new k((LinearProgressIndicatorSpec) this.f18002a));
        } else {
            getIndeterminateDrawable().B(new l(getContext(), (LinearProgressIndicatorSpec) this.f18002a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@m0 int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.f18002a).e();
    }

    public void setIndicatorDirection(int i7) {
        S s7 = this.f18002a;
        ((LinearProgressIndicatorSpec) s7).f18028h = i7;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s7;
        boolean z7 = true;
        if (i7 != 1 && ((n2.Z(this) != 1 || ((LinearProgressIndicatorSpec) this.f18002a).f18028h != 2) && (n2.Z(this) != 0 || i7 != 3))) {
            z7 = false;
        }
        linearProgressIndicatorSpec.f18029i = z7;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i7, boolean z7) {
        S s7 = this.f18002a;
        if (s7 != 0 && ((LinearProgressIndicatorSpec) s7).f18027g == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i7, z7);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i7) {
        super.setTrackCornerRadius(i7);
        ((LinearProgressIndicatorSpec) this.f18002a).e();
        invalidate();
    }

    public LinearProgressIndicator(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@m0 Context context, @o0 AttributeSet attributeSet, @c.f int i7) {
        super(context, attributeSet, i7, f18025y);
        t();
    }
}
