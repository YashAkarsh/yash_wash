package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class c2 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f6546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f6547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f6548c;

    private c2(View view, Runnable runnable) {
        this.f6546a = view;
        this.f6547b = view.getViewTreeObserver();
        this.f6548c = runnable;
    }

    @c.m0
    public static c2 a(@c.m0 View view, @c.m0 Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        c2 c2Var = new c2(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(c2Var);
        view.addOnAttachStateChangeListener(c2Var);
        return c2Var;
    }

    public void b() {
        if (this.f6547b.isAlive()) {
            this.f6547b.removeOnPreDrawListener(this);
        } else {
            this.f6546a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f6546a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f6548c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@c.m0 View view) {
        this.f6547b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@c.m0 View view) {
        b();
    }
}
