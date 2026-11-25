package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private TimeInterpolator f16864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16866e;

    public i(long j7, long j8) {
        this.f16864c = null;
        this.f16865d = 0;
        this.f16866e = 1;
        this.f16862a = j7;
        this.f16863b = j8;
    }

    @m0
    static i b(@m0 ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f16865d = valueAnimator.getRepeatCount();
        iVar.f16866e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(@m0 ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f16847b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f16848c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f16849d : interpolator;
    }

    public void a(@m0 Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f16862a;
    }

    public long d() {
        return this.f16863b;
    }

    @o0
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f16864c;
        return timeInterpolator != null ? timeInterpolator : a.f16847b;
    }

    public boolean equals(@o0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f16865d;
    }

    public int h() {
        return this.f16866e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @m0
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j7, long j8, @m0 TimeInterpolator timeInterpolator) {
        this.f16865d = 0;
        this.f16866e = 1;
        this.f16862a = j7;
        this.f16863b = j8;
        this.f16864c = timeInterpolator;
    }
}
