package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    OverScroller f7053a;

    t(Context context, Interpolator interpolator) {
        this.f7053a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static t c(Context context) {
        return d(context, null);
    }

    @Deprecated
    public static t d(Context context, Interpolator interpolator) {
        return new t(context, interpolator);
    }

    @Deprecated
    public void a() {
        this.f7053a.abortAnimation();
    }

    @Deprecated
    public boolean b() {
        return this.f7053a.computeScrollOffset();
    }

    @Deprecated
    public void e(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
        this.f7053a.fling(i7, i8, i9, i10, i11, i12, i13, i14);
    }

    @Deprecated
    public void f(int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f7053a.fling(i7, i8, i9, i10, i11, i12, i13, i14, i15, i16);
    }

    @Deprecated
    public float g() {
        return this.f7053a.getCurrVelocity();
    }

    @Deprecated
    public int h() {
        return this.f7053a.getCurrX();
    }

    @Deprecated
    public int i() {
        return this.f7053a.getCurrY();
    }

    @Deprecated
    public int j() {
        return this.f7053a.getFinalX();
    }

    @Deprecated
    public int k() {
        return this.f7053a.getFinalY();
    }

    @Deprecated
    public boolean l() {
        return this.f7053a.isFinished();
    }

    @Deprecated
    public boolean m() {
        return this.f7053a.isOverScrolled();
    }

    @Deprecated
    public void n(int i7, int i8, int i9) {
        this.f7053a.notifyHorizontalEdgeReached(i7, i8, i9);
    }

    @Deprecated
    public void o(int i7, int i8, int i9) {
        this.f7053a.notifyVerticalEdgeReached(i7, i8, i9);
    }

    @Deprecated
    public boolean p(int i7, int i8, int i9, int i10, int i11, int i12) {
        return this.f7053a.springBack(i7, i8, i9, i10, i11, i12);
    }

    @Deprecated
    public void q(int i7, int i8, int i9, int i10) {
        this.f7053a.startScroll(i7, i8, i9, i10);
    }

    @Deprecated
    public void r(int i7, int i8, int i9, int i10, int i11) {
        this.f7053a.startScroll(i7, i8, i9, i10, i11);
    }
}
