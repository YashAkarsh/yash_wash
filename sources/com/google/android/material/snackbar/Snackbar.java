package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.a1;
import c.l;
import c.m0;
import c.o0;
import c.q;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] N;
    private static final int[] O;

    @o0
    private final AccessibilityManager K;
    private boolean L;

    @o0
    private BaseTransientBottomBar.t<Snackbar> M;

    @x0({x0.a.LIBRARY_GROUP})
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i7, int i8) {
            super.onMeasure(i7, i8);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@o0 Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@o0 Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@o0 ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@o0 PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@o0 View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f18481a;

        a(View.OnClickListener onClickListener) {
            this.f18481a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f18481a.onClick(view);
            Snackbar.this.x(1);
        }
    }

    public static class b extends BaseTransientBottomBar.t<Snackbar> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f18483f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f18484g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f18485h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f18486i = 3;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f18487j = 4;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Snackbar snackbar, int i7) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(Snackbar snackbar) {
        }
    }

    static {
        int i7 = R.attr.snackbarButtonStyle;
        N = new int[]{i7};
        O = new int[]{i7, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@m0 Context context, @m0 ViewGroup viewGroup, @m0 View view, @m0 com.google.android.material.snackbar.a aVar) {
        super(context, viewGroup, view, aVar);
        this.K = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @o0
    private static ViewGroup n0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    @Deprecated
    protected static boolean o0(@m0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(N);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    private static boolean p0(@m0 Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(O);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @m0
    public static Snackbar q0(@m0 Context context, @m0 View view, @m0 CharSequence charSequence, int i7) {
        return t0(context, view, charSequence, i7);
    }

    @m0
    public static Snackbar r0(@m0 View view, @a1 int i7, int i8) {
        return s0(view, view.getResources().getText(i7), i8);
    }

    @m0
    public static Snackbar s0(@m0 View view, @m0 CharSequence charSequence, int i7) {
        return t0(null, view, charSequence, i7);
    }

    @m0
    private static Snackbar t0(@o0 Context context, @m0 View view, @m0 CharSequence charSequence, int i7) {
        ViewGroup viewGroupN0 = n0(view);
        if (viewGroupN0 == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupN0.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(p0(context) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, viewGroupN0, false);
        Snackbar snackbar = new Snackbar(context, viewGroupN0, snackbarContentLayout, snackbarContentLayout);
        snackbar.E0(charSequence);
        snackbar.a0(i7);
        return snackbar;
    }

    @m0
    public Snackbar A0(@o0 PorterDuff.Mode mode) {
        this.f18425c.setBackgroundTintMode(mode);
        return this;
    }

    @m0
    @Deprecated
    public Snackbar B0(@o0 b bVar) {
        BaseTransientBottomBar.t<Snackbar> tVar = this.M;
        if (tVar != null) {
            U(tVar);
        }
        if (bVar != null) {
            s(bVar);
        }
        this.M = bVar;
        return this;
    }

    @m0
    public Snackbar C0(@q int i7) {
        ((SnackbarContentLayout) this.f18425c.getChildAt(0)).setMaxInlineActionWidth(i7);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int D() {
        int iD = super.D();
        if (iD == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.K.getRecommendedTimeoutMillis(iD, (this.L ? 4 : 0) | 1 | 2);
        }
        if (this.L && this.K.isTouchExplorationEnabled()) {
            return -2;
        }
        return iD;
    }

    @m0
    public Snackbar D0(@a1 int i7) {
        return E0(C().getText(i7));
    }

    @m0
    public Snackbar E0(@m0 CharSequence charSequence) {
        ((SnackbarContentLayout) this.f18425c.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @m0
    public Snackbar F0(@l int i7) {
        ((SnackbarContentLayout) this.f18425c.getChildAt(0)).getMessageView().setTextColor(i7);
        return this;
    }

    @m0
    public Snackbar G0(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.f18425c.getChildAt(0)).getMessageView().setTextColor(colorStateList);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean P() {
        return super.P();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void f0() {
        super.f0();
    }

    @m0
    public Snackbar u0(@a1 int i7, View.OnClickListener onClickListener) {
        return v0(C().getText(i7), onClickListener);
    }

    @m0
    public Snackbar v0(@o0 CharSequence charSequence, @o0 View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f18425c.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.L = false;
        } else {
            this.L = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new a(onClickListener));
        }
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void w() {
        super.w();
    }

    @m0
    public Snackbar w0(@l int i7) {
        ((SnackbarContentLayout) this.f18425c.getChildAt(0)).getActionView().setTextColor(i7);
        return this;
    }

    @m0
    public Snackbar x0(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.f18425c.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    @m0
    public Snackbar y0(@l int i7) {
        return z0(ColorStateList.valueOf(i7));
    }

    @m0
    public Snackbar z0(@o0 ColorStateList colorStateList) {
        this.f18425c.setBackgroundTintList(colorStateList);
        return this;
    }
}
