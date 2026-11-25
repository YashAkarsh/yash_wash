package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.d0;
import c.m0;
import c.o0;
import c.x0;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class l extends Transition {
    private static final String W = "android:textscale:scale";

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f17882a;

        a(TextView textView) {
            this.f17882a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f17882a.setScaleX(fFloatValue);
            this.f17882a.setScaleY(fFloatValue);
        }
    }

    private void D0(@m0 d0 d0Var) {
        View view = d0Var.f10675b;
        if (view instanceof TextView) {
            d0Var.f10674a.put(W, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void k(@m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    public void n(@m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    public Animator r(@m0 ViewGroup viewGroup, @o0 d0 d0Var, @o0 d0 d0Var2) {
        if (d0Var == null || d0Var2 == null || !(d0Var.f10675b instanceof TextView)) {
            return null;
        }
        View view = d0Var2.f10675b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = d0Var.f10674a;
        Map<String, Object> map2 = d0Var2.f10674a;
        float fFloatValue = map.get(W) != null ? ((Float) map.get(W)).floatValue() : 1.0f;
        float fFloatValue2 = map2.get(W) != null ? ((Float) map2.get(W)).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new a(textView));
        return valueAnimatorOfFloat;
    }
}
