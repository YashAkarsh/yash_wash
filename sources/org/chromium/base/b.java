package org.chromium.base;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeAnimator;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f38769c = "AnimationFrameTimeHistogram";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f38770d = 600;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f38771a = new c(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f38772b;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f38773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38774b;

        a(String str) {
            this.f38774b = str;
            this.f38773a = new b(str);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f38773a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f38773a.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f38773a.c();
        }
    }

    /* JADX INFO: renamed from: org.chromium.base.b$b, reason: collision with other inner class name */
    interface InterfaceC0519b {
        void a(String str, long[] jArr, int i7);
    }

    private static class c implements TimeAnimator.TimeListener {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f38775d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimeAnimator f38776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long[] f38777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38778c;

        /* synthetic */ c(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            this.f38777b = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g() {
            boolean zIsStarted = this.f38776a.isStarted();
            this.f38776a.end();
            return zIsStarted;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h() {
            return this.f38778c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long[] i() {
            return this.f38777b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            this.f38778c = 0;
            this.f38777b = new long[600];
            this.f38776a.start();
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator timeAnimator, long j7, long j8) {
            int i7 = this.f38778c;
            long[] jArr = this.f38777b;
            if (i7 == jArr.length) {
                this.f38776a.end();
                f();
                Log.w(b.f38769c, "Animation frame time recording reached the maximum number. It's eitherthe animation took too long or recording end is not called.");
            } else if (j8 > 0) {
                this.f38778c = i7 + 1;
                jArr[i7] = j8;
            }
        }

        private c() {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.f38776a = timeAnimator;
            timeAnimator.setTimeListener(this);
        }
    }

    public b(String str) {
        this.f38772b = str;
    }

    public static Animator.AnimatorListener b(String str) {
        return new a(str);
    }

    public void a() {
        if (this.f38771a.g()) {
            org.chromium.base.c.c().a(this.f38772b, this.f38771a.i(), this.f38771a.h());
        }
        this.f38771a.f();
    }

    public void c() {
        this.f38771a.j();
    }
}
