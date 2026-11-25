package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import c.m0;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class b {
    public static void a(@m0 AnimatorSet animatorSet, @m0 List<Animator> list) {
        int size = list.size();
        long jMax = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Animator animator = list.get(i7);
            jMax = Math.max(jMax, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        list.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(list);
    }
}
