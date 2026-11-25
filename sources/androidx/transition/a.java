package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: androidx.transition.a$a, reason: collision with other inner class name */
    interface InterfaceC0128a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    private a() {
    }

    static void a(@c.m0 Animator animator, @c.m0 AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    static void b(@c.m0 Animator animator) {
        animator.pause();
    }

    static void c(@c.m0 Animator animator) {
        animator.resume();
    }
}
