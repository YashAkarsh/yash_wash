package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private Animator f17641a;

    a() {
    }

    public void a() {
        Animator animator = this.f17641a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f17641a = null;
    }

    public void c(Animator animator) {
        a();
        this.f17641a = animator;
    }
}
