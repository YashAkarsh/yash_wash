package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import c.m0;
import c.o0;
import c.x0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f17845a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private b f17846b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    ValueAnimator f17847c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f17848d = new a();

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i iVar = i.this;
            if (iVar.f17847c == animator) {
                iVar.f17847c = null;
            }
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f17850a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f17851b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f17850a = iArr;
            this.f17851b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f17847c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f17847c = null;
        }
    }

    private void e(@m0 b bVar) {
        ValueAnimator valueAnimator = bVar.f17851b;
        this.f17847c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f17848d);
        this.f17845a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f17847c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f17847c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.f17845a.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                bVar = null;
                break;
            }
            bVar = this.f17845a.get(i7);
            if (StateSet.stateSetMatches(bVar.f17850a, iArr)) {
                break;
            } else {
                i7++;
            }
        }
        b bVar2 = this.f17846b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.f17846b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}
