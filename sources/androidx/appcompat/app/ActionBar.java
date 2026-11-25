package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R;
import androidx.fragment.app.v;
import c.a1;
import c.m0;
import c.o0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f620a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final int f621b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public static final int f622c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f623d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f624e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f625f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f626g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f627h = 16;

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void a(boolean z7);
    }

    @Deprecated
    public interface d {
        boolean a(int i7, long j7);
    }

    @Deprecated
    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f629a = -1;

        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract int d();

        public abstract Object e();

        public abstract CharSequence f();

        public abstract void g();

        public abstract e h(@a1 int i7);

        public abstract e i(CharSequence charSequence);

        public abstract e j(int i7);

        public abstract e k(View view);

        public abstract e l(@c.u int i7);

        public abstract e m(Drawable drawable);

        public abstract e n(f fVar);

        public abstract e o(Object obj);

        public abstract e p(int i7);

        public abstract e q(CharSequence charSequence);
    }

    @Deprecated
    public interface f {
        void a(e eVar, v vVar);

        void b(e eVar, v vVar);

        void c(e eVar, v vVar);
    }

    public Context A() {
        return null;
    }

    public abstract void A0(CharSequence charSequence);

    @o0
    public abstract CharSequence B();

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void B0(CharSequence charSequence) {
    }

    public abstract void C();

    public abstract void C0();

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean D() {
        return false;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public androidx.appcompat.view.b D0(androidx.appcompat.view.b.a aVar) {
        return null;
    }

    public boolean E() {
        return false;
    }

    public abstract boolean F();

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean G() {
        return false;
    }

    @Deprecated
    public abstract e H();

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void I(Configuration configuration) {
    }

    void J() {
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean K(int i7, KeyEvent keyEvent) {
        return false;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean L(KeyEvent keyEvent) {
        return false;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean M() {
        return false;
    }

    @Deprecated
    public abstract void N();

    public abstract void O(c cVar);

    @Deprecated
    public abstract void P(e eVar);

    @Deprecated
    public abstract void Q(int i7);

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    boolean R() {
        return false;
    }

    @Deprecated
    public abstract void S(e eVar);

    public abstract void T(@o0 Drawable drawable);

    public abstract void U(int i7);

    public abstract void V(View view);

    public abstract void W(View view, LayoutParams layoutParams);

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void X(boolean z7) {
    }

    public abstract void Y(boolean z7);

    public abstract void Z(int i7);

    public abstract void a0(int i7, int i8);

    public abstract void b0(boolean z7);

    public abstract void c0(boolean z7);

    public abstract void d0(boolean z7);

    public abstract void e0(boolean z7);

    public void f0(float f8) {
        if (f8 != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public abstract void g(c cVar);

    public void g0(int i7) {
        if (i7 != 0) {
            throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
        }
    }

    @Deprecated
    public abstract void h(e eVar);

    public void h0(boolean z7) {
        if (z7) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    @Deprecated
    public abstract void i(e eVar, int i7);

    public void i0(@a1 int i7) {
    }

    @Deprecated
    public abstract void j(e eVar, int i7, boolean z7);

    public void j0(@o0 CharSequence charSequence) {
    }

    @Deprecated
    public abstract void k(e eVar, boolean z7);

    public void k0(@c.u int i7) {
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean l() {
        return false;
    }

    public void l0(@o0 Drawable drawable) {
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean m() {
        return false;
    }

    public void m0(boolean z7) {
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void n(boolean z7) {
    }

    public abstract void n0(@c.u int i7);

    public abstract View o();

    public abstract void o0(Drawable drawable);

    public abstract int p();

    @Deprecated
    public abstract void p0(SpinnerAdapter spinnerAdapter, d dVar);

    public float q() {
        return 0.0f;
    }

    public abstract void q0(@c.u int i7);

    public abstract int r();

    public abstract void r0(Drawable drawable);

    public int s() {
        return 0;
    }

    @Deprecated
    public abstract void s0(int i7);

    @Deprecated
    public abstract int t();

    @Deprecated
    public abstract void t0(int i7);

    @Deprecated
    public abstract int u();

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public void u0(boolean z7) {
    }

    @Deprecated
    public abstract int v();

    public void v0(Drawable drawable) {
    }

    @o0
    @Deprecated
    public abstract e w();

    public void w0(Drawable drawable) {
    }

    @o0
    public abstract CharSequence x();

    public abstract void x0(int i7);

    @Deprecated
    public abstract e y(int i7);

    public abstract void y0(CharSequence charSequence);

    @Deprecated
    public abstract int z();

    public abstract void z0(@a1 int i7);

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f628a;

        public LayoutParams(@m0 Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f628a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f628a = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
            this.f628a = 8388627;
        }

        public LayoutParams(int i7, int i8, int i9) {
            super(i7, i8);
            this.f628a = i9;
        }

        public LayoutParams(int i7) {
            this(-2, -1, i7);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f628a = 0;
            this.f628a = layoutParams.f628a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f628a = 0;
        }
    }
}
