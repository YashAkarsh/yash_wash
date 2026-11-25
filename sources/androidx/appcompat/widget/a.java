package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.n2;
import androidx.core.view.n4;
import androidx.core.view.o4;

/* JADX INFO: loaded from: classes.dex */
abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f1698i = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final b f1699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f1700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ActionMenuView f1701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ActionMenuPresenter f1702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f1703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected n4 f1704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1706h;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    class RunnableC0024a implements Runnable {
        RunnableC0024a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.o();
        }
    }

    protected class b implements o4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1708a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1709b;

        protected b() {
        }

        @Override // androidx.core.view.o4
        public void a(View view) {
            this.f1708a = true;
        }

        @Override // androidx.core.view.o4
        public void b(View view) {
            if (this.f1708a) {
                return;
            }
            a aVar = a.this;
            aVar.f1704f = null;
            a.super.setVisibility(this.f1709b);
        }

        @Override // androidx.core.view.o4
        public void c(View view) {
            a.super.setVisibility(0);
            this.f1708a = false;
        }

        public b d(n4 n4Var, int i7) {
            a.this.f1704f = n4Var;
            this.f1709b = i7;
            return this;
        }
    }

    a(@c.m0 Context context) {
        this(context, null);
    }

    protected static int k(int i7, int i8, boolean z7) {
        return z7 ? i7 - i8 : i7 + i8;
    }

    public void c(int i7) {
        n(i7, 200L).y();
    }

    public boolean d() {
        return i() && getVisibility() == 0;
    }

    public void e() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.C();
        }
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.F();
        }
        return false;
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.H();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f1704f != null ? this.f1699a.f1709b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1703e;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.I();
        }
        return false;
    }

    public boolean i() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        return actionMenuPresenter != null && actionMenuPresenter.J();
    }

    protected int j(View view, int i7, int i8, int i9) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i7, Integer.MIN_VALUE), i8);
        return Math.max(0, (i7 - view.getMeasuredWidth()) - i9);
    }

    protected int l(View view, int i7, int i8, int i9, boolean z7) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = i8 + ((i9 - measuredHeight) / 2);
        if (z7) {
            view.layout(i7 - measuredWidth, i10, i7, measuredHeight + i10);
        } else {
            view.layout(i7, i10, i7 + measuredWidth, measuredHeight + i10);
        }
        return z7 ? -measuredWidth : measuredWidth;
    }

    public void m() {
        post(new RunnableC0024a());
    }

    public n4 n(int i7, long j7) {
        n4 n4Var = this.f1704f;
        if (n4Var != null) {
            n4Var.d();
        }
        if (i7 != 0) {
            n4 n4VarB = n2.g(this).b(0.0f);
            n4VarB.s(j7);
            n4VarB.u(this.f1699a.d(n4VarB, i7));
            return n4VarB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        n4 n4VarB2 = n2.g(this).b(1.0f);
        n4VarB2.s(j7);
        n4VarB2.u(this.f1699a.d(n4VarB2, i7));
        return n4VarB2;
    }

    public boolean o() {
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.R();
        }
        return false;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f1702d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.K(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1706h = false;
        }
        if (!this.f1706h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1706h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1706h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1705g = false;
        }
        if (!this.f1705g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1705g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1705g = false;
        }
        return true;
    }

    public void setContentHeight(int i7) {
        this.f1703e = i7;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i7) {
        if (i7 != getVisibility()) {
            n4 n4Var = this.f1704f;
            if (n4Var != null) {
                n4Var.d();
            }
            super.setVisibility(i7);
        }
    }

    a(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f1699a = new b();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f1700b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f1700b = context;
        }
    }
}
