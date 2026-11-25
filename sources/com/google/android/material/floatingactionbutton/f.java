package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import c.m0;
import c.o0;
import com.google.android.material.animation.h;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface f {
    void a();

    h b();

    @c.b
    int c();

    void d();

    @o0
    h e();

    boolean f();

    void g(@m0 Animator.AnimatorListener animatorListener);

    void h(@m0 Animator.AnimatorListener animatorListener);

    void i();

    void j(@o0 h hVar);

    AnimatorSet k();

    List<Animator.AnimatorListener> l();

    void m(@o0 ExtendedFloatingActionButton.j jVar);

    void onAnimationStart(Animator animator);
}
