package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.util.w;
import c.m0;
import c.o0;
import c.t0;
import com.google.android.material.R;
import com.google.android.material.shape.j;
import com.google.android.material.shape.o;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class e extends d {

    static class a extends j {
        a(o oVar) {
            super(oVar);
        }

        @Override // com.google.android.material.shape.j, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    e(FloatingActionButton floatingActionButton, com.google.android.material.shadow.c cVar) {
        super(floatingActionButton, cVar);
    }

    @m0
    private Animator m0(float f8, float f9) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f17692y, "elevation", f8).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f17692y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f9).setDuration(100L));
        animatorSet.setInterpolator(d.F);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void C() {
        i0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void E(int[] iArr) {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void F(float f8, float f9, float f10) {
        int i7 = Build.VERSION.SDK_INT;
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(d.S, m0(f8, f10));
        stateListAnimator.addState(d.T, m0(f8, f9));
        stateListAnimator.addState(d.U, m0(f8, f9));
        stateListAnimator.addState(d.V, m0(f8, f9));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f17692y, "elevation", f8).setDuration(0L));
        if (i7 <= 24) {
            FloatingActionButton floatingActionButton = this.f17692y;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.f17692y, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(d.F);
        stateListAnimator.addState(d.W, animatorSet);
        stateListAnimator.addState(d.X, m0(0.0f, 0.0f));
        this.f17692y.setStateListAnimator(stateListAnimator);
        if (c0()) {
            i0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean N() {
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void Y(@o0 ColorStateList colorStateList) {
        Drawable drawable = this.f17670c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(com.google.android.material.ripple.b.d(colorStateList));
        } else {
            super.Y(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    boolean c0() {
        return this.f17693z.c() || !e0();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void g0() {
    }

    @Override // com.google.android.material.floatingactionbutton.d
    @m0
    j j() {
        return new a((o) w.l(this.f17668a));
    }

    @m0
    c l0(int i7, ColorStateList colorStateList) {
        Context context = this.f17692y.getContext();
        c cVar = new c((o) w.l(this.f17668a));
        cVar.f(androidx.core.content.d.f(context, R.color.design_fab_stroke_top_outer_color), androidx.core.content.d.f(context, R.color.design_fab_stroke_top_inner_color), androidx.core.content.d.f(context, R.color.design_fab_stroke_end_inner_color), androidx.core.content.d.f(context, R.color.design_fab_stroke_end_outer_color));
        cVar.e(i7);
        cVar.d(colorStateList);
        return cVar;
    }

    @Override // com.google.android.material.floatingactionbutton.d
    public float n() {
        return this.f17692y.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void s(@m0 Rect rect) {
        if (this.f17693z.c()) {
            super.s(rect);
        } else if (e0()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f17678k - this.f17692y.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.d
    void x(ColorStateList colorStateList, @o0 PorterDuff.Mode mode, ColorStateList colorStateList2, int i7) {
        Drawable layerDrawable;
        j jVarJ = j();
        this.f17669b = jVarJ;
        jVarJ.setTintList(colorStateList);
        if (mode != null) {
            this.f17669b.setTintMode(mode);
        }
        this.f17669b.Y(this.f17692y.getContext());
        if (i7 > 0) {
            this.f17671d = l0(i7, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) w.l(this.f17671d), (Drawable) w.l(this.f17669b)});
        } else {
            this.f17671d = null;
            layerDrawable = this.f17669b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(com.google.android.material.ripple.b.d(colorStateList2), layerDrawable, null);
        this.f17670c = rippleDrawable;
        this.f17672e = rippleDrawable;
    }
}
