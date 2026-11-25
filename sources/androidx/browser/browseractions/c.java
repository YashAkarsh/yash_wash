package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class c extends Dialog {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f2077b = 250;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f2078c = 150;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f2079a;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f2080a;

        a(boolean z7) {
            this.f2080a = z7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2080a) {
                return;
            }
            c.super.dismiss();
        }
    }

    c(Context context, View view) {
        super(context);
        this.f2079a = view;
    }

    private void b(boolean z7) {
        float f8 = z7 ? 0.0f : 1.0f;
        float f9 = z7 ? 1.0f : 0.0f;
        long j7 = z7 ? f2077b : 150L;
        this.f2079a.setScaleX(f8);
        this.f2079a.setScaleY(f8);
        this.f2079a.animate().scaleX(f9).scaleY(f9).setDuration(j7).setInterpolator(new androidx.interpolator.view.animation.c()).setListener(new a(z7)).start();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        b(false);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        b(true);
        super.show();
    }
}
