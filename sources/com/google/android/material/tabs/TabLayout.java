package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.l1;
import androidx.core.util.v;
import androidx.core.view.accessibility.l0;
import androidx.core.view.g2;
import androidx.core.view.n0;
import androidx.core.view.n2;
import androidx.core.view.s0;
import androidx.core.widget.u;
import androidx.viewpager.widget.ViewPager;
import c.a1;
import c.h0;
import c.m0;
import c.o0;
import c.q;
import c.t0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@ViewPager.e
public class TabLayout extends HorizontalScrollView {
    private static final int A0 = 300;
    private static final String C0 = "TabLayout";
    public static final int D0 = 0;
    public static final int E0 = 1;
    public static final int F0 = 2;
    public static final int G0 = 0;
    public static final int H0 = 1;
    public static final int I0 = 0;
    public static final int J0 = 1;
    public static final int K0 = 2;
    public static final int L0 = 0;
    public static final int M0 = 1;
    public static final int N0 = 2;
    public static final int O0 = 3;
    public static final int P0 = 0;
    public static final int Q0 = 1;

    @q(unit = 0)
    private static final int R = 72;

    @q(unit = 0)
    static final int S = 8;

    @q(unit = 0)
    private static final int T = 48;

    @q(unit = 0)
    private static final int U = 56;

    @q(unit = 0)
    static final int V = 16;
    private static final int W = -1;
    boolean A;
    boolean B;
    int C;
    boolean D;
    private com.google.android.material.tabs.b E;

    @o0
    private c F;
    private final ArrayList<c> G;

    @o0
    private c H;
    private ValueAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    @o0
    ViewPager f18508J;

    @o0
    private androidx.viewpager.widget.a K;
    private DataSetObserver L;
    private m M;
    private b N;
    private boolean O;
    private final v.a<TabView> P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<i> f18509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private i f18510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    final h f18511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f18512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f18513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f18514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f18515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f18516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ColorStateList f18517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    ColorStateList f18518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    ColorStateList f18519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @m0
    Drawable f18520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f18521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    PorterDuff.Mode f18522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    float f18523o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f18524p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final int f18525q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f18526r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f18527s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f18528t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f18529u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f18530v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    int f18531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f18532x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f18533y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f18534z;
    private static final int Q = R.style.Widget_Design_TabLayout;
    private static final v.a<i> B0 = new v.c(16);

    public final class TabView extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private i f18535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TextView f18536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ImageView f18537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @o0
        private View f18538d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        private BadgeDrawable f18539e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        private View f18540f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @o0
        private TextView f18541g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @o0
        private ImageView f18542h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @o0
        private Drawable f18543i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f18544j;

        class a implements View.OnLayoutChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f18546a;

            a(View view) {
                this.f18546a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                if (this.f18546a.getVisibility() == 0) {
                    TabView.this.w(this.f18546a);
                }
            }
        }

        public TabView(Context context) {
            super(context);
            this.f18544j = 2;
            y(context);
            n2.d2(this, TabLayout.this.f18512d, TabLayout.this.f18513e, TabLayout.this.f18514f, TabLayout.this.f18515g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            n2.g2(this, g2.c(getContext(), 1002));
        }

        private void A(@o0 TextView textView, @o0 ImageView imageView) {
            i iVar = this.f18535a;
            Drawable drawableMutate = (iVar == null || iVar.h() == null) ? null : androidx.core.graphics.drawable.d.r(this.f18535a.h()).mutate();
            i iVar2 = this.f18535a;
            CharSequence charSequenceN = iVar2 != null ? iVar2.n() : null;
            if (imageView != null) {
                if (drawableMutate != null) {
                    imageView.setImageDrawable(drawableMutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z7 = !TextUtils.isEmpty(charSequenceN);
            if (textView != null) {
                if (z7) {
                    textView.setText(charSequenceN);
                    if (this.f18535a.f18569g == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int iE = (z7 && imageView.getVisibility() == 0) ? (int) com.google.android.material.internal.v.e(getContext(), 8) : 0;
                if (TabLayout.this.A) {
                    if (iE != s0.b(marginLayoutParams)) {
                        s0.g(marginLayoutParams, iE);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (iE != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = iE;
                    s0.g(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            i iVar3 = this.f18535a;
            CharSequence charSequence = iVar3 != null ? iVar3.f18566d : null;
            if (Build.VERSION.SDK_INT > 23) {
                if (!z7) {
                    charSequenceN = charSequence;
                }
                l1.a(this, charSequenceN);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @o0
        public BadgeDrawable getBadge() {
            return this.f18539e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @m0
        public BadgeDrawable getOrCreateBadge() {
            if (this.f18539e == null) {
                this.f18539e = BadgeDrawable.d(getContext());
            }
            v();
            BadgeDrawable badgeDrawable = this.f18539e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void i(@o0 View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float j(@m0 Layout layout, int i7, float f8) {
            return layout.getLineWidth(i7) * (f8 / layout.getPaint().getTextSize());
        }

        private void k(boolean z7) {
            setClipChildren(z7);
            setClipToPadding(z7);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z7);
                viewGroup.setClipToPadding(z7);
            }
        }

        @m0
        private FrameLayout l() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(@m0 Canvas canvas) {
            Drawable drawable = this.f18543i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f18543i.draw(canvas);
            }
        }

        @o0
        private FrameLayout n(@m0 View view) {
            if ((view == this.f18537c || view == this.f18536b) && com.google.android.material.badge.a.f17037a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o() {
            return this.f18539e != null;
        }

        private void p() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.a.f17037a) {
                FrameLayout frameLayoutL = l();
                addView(frameLayoutL, 0);
                viewGroup = frameLayoutL;
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, viewGroup, false);
            this.f18537c = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void q() {
            ViewGroup viewGroup;
            if (com.google.android.material.badge.a.f17037a) {
                FrameLayout frameLayoutL = l();
                addView(frameLayoutL);
                viewGroup = frameLayoutL;
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, viewGroup, false);
            this.f18536b = textView;
            viewGroup.addView(textView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            if (this.f18538d != null) {
                u();
            }
            this.f18539e = null;
        }

        private void t(@o0 View view) {
            if (o() && view != null) {
                k(false);
                com.google.android.material.badge.a.b(this.f18539e, view, n(view));
                this.f18538d = view;
            }
        }

        private void u() {
            if (o()) {
                k(true);
                View view = this.f18538d;
                if (view != null) {
                    com.google.android.material.badge.a.g(this.f18539e, view);
                    this.f18538d = null;
                }
            }
        }

        private void v() {
            i iVar;
            i iVar2;
            if (o()) {
                if (this.f18540f != null) {
                    u();
                    return;
                }
                if (this.f18537c != null && (iVar2 = this.f18535a) != null && iVar2.h() != null) {
                    View view = this.f18538d;
                    ImageView imageView = this.f18537c;
                    if (view == imageView) {
                        w(imageView);
                        return;
                    } else {
                        u();
                        t(this.f18537c);
                        return;
                    }
                }
                if (this.f18536b == null || (iVar = this.f18535a) == null || iVar.l() != 1) {
                    u();
                    return;
                }
                View view2 = this.f18538d;
                TextView textView = this.f18536b;
                if (view2 == textView) {
                    w(textView);
                } else {
                    u();
                    t(this.f18536b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w(@m0 View view) {
            if (o() && view == this.f18538d) {
                com.google.android.material.badge.a.j(this.f18539e, view, n(view));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(Context context) {
            GradientDrawable gradientDrawable;
            int i7 = TabLayout.this.f18525q;
            if (i7 != 0) {
                Drawable drawableB = e.a.b(context, i7);
                this.f18543i = drawableB;
                if (drawableB != null && drawableB.isStateful()) {
                    this.f18543i.setState(getDrawableState());
                }
            } else {
                this.f18543i = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            Drawable rippleDrawable = gradientDrawable2;
            if (TabLayout.this.f18519k != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateListA = com.google.android.material.ripple.b.a(TabLayout.this.f18519k);
                boolean z7 = TabLayout.this.D;
                if (z7) {
                    gradientDrawable = gradientDrawable2;
                    gradientDrawable = null;
                }
                rippleDrawable = new RippleDrawable(colorStateListA, gradientDrawable, z7 ? null : gradientDrawable3);
            }
            n2.I1(this, rippleDrawable);
            TabLayout.this.invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f18543i;
            boolean state = false;
            if (drawable != null && drawable.isStateful()) {
                state = false | this.f18543i.setState(drawableState);
            }
            if (state) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        int getContentHeight() {
            View[] viewArr = {this.f18536b, this.f18537c, this.f18540f};
            int iMax = 0;
            int iMin = 0;
            boolean z7 = false;
            for (int i7 = 0; i7 < 3; i7++) {
                View view = viewArr[i7];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z7 ? Math.min(iMin, view.getTop()) : view.getTop();
                    iMax = z7 ? Math.max(iMax, view.getBottom()) : view.getBottom();
                    z7 = true;
                }
            }
            return iMax - iMin;
        }

        int getContentWidth() {
            View[] viewArr = {this.f18536b, this.f18537c, this.f18540f};
            int iMax = 0;
            int iMin = 0;
            boolean z7 = false;
            for (int i7 = 0; i7 < 3; i7++) {
                View view = viewArr[i7];
                if (view != null && view.getVisibility() == 0) {
                    iMin = z7 ? Math.min(iMin, view.getLeft()) : view.getLeft();
                    iMax = z7 ? Math.max(iMax, view.getRight()) : view.getRight();
                    z7 = true;
                }
            }
            return iMax - iMin;
        }

        @o0
        public i getTab() {
            return this.f18535a;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f18539e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f18539e.o()));
            }
            l0 l0VarX1 = l0.X1(accessibilityNodeInfo);
            l0VarX1.Z0(l0.c.h(0, 1, this.f18535a.k(), 1, false, isSelected()));
            if (isSelected()) {
                l0VarX1.X0(false);
                l0VarX1.K0(l0.a.f6496j);
            }
            l0VarX1.D1(getResources().getString(R.string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i7, int i8) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i7);
            int mode = View.MeasureSpec.getMode(i7);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i7 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f18526r, Integer.MIN_VALUE);
            }
            super.onMeasure(i7, i8);
            if (this.f18536b != null) {
                float f8 = TabLayout.this.f18523o;
                int i9 = this.f18544j;
                ImageView imageView = this.f18537c;
                boolean z7 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f18536b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f8 = TabLayout.this.f18524p;
                    }
                } else {
                    i9 = 1;
                }
                float textSize = this.f18536b.getTextSize();
                int lineCount = this.f18536b.getLineCount();
                int iK = u.k(this.f18536b);
                if (f8 != textSize || (iK >= 0 && i9 != iK)) {
                    if (TabLayout.this.f18534z == 1 && f8 > textSize && lineCount == 1 && ((layout = this.f18536b.getLayout()) == null || j(layout, 0, f8) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z7 = false;
                    }
                    if (z7) {
                        this.f18536b.setTextSize(0, f8);
                        this.f18536b.setMaxLines(i9);
                        super.onMeasure(i7, i8);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean zPerformClick = super.performClick();
            if (this.f18535a == null) {
                return zPerformClick;
            }
            if (!zPerformClick) {
                playSoundEffect(0);
            }
            this.f18535a.r();
            return true;
        }

        void s() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z7) {
            if (isSelected() != z7) {
            }
            super.setSelected(z7);
            TextView textView = this.f18536b;
            if (textView != null) {
                textView.setSelected(z7);
            }
            ImageView imageView = this.f18537c;
            if (imageView != null) {
                imageView.setSelected(z7);
            }
            View view = this.f18540f;
            if (view != null) {
                view.setSelected(z7);
            }
        }

        void setTab(@o0 i iVar) {
            if (iVar != this.f18535a) {
                this.f18535a = iVar;
                x();
            }
        }

        final void x() {
            i iVar = this.f18535a;
            Drawable drawableMutate = null;
            View viewG = iVar != null ? iVar.g() : null;
            if (viewG != null) {
                ViewParent parent = viewG.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewG);
                    }
                    addView(viewG);
                }
                this.f18540f = viewG;
                TextView textView = this.f18536b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f18537c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f18537c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) viewG.findViewById(android.R.id.text1);
                this.f18541g = textView2;
                if (textView2 != null) {
                    this.f18544j = u.k(textView2);
                }
                this.f18542h = (ImageView) viewG.findViewById(android.R.id.icon);
            } else {
                View view = this.f18540f;
                if (view != null) {
                    removeView(view);
                    this.f18540f = null;
                }
                this.f18541g = null;
                this.f18542h = null;
            }
            if (this.f18540f == null) {
                if (this.f18537c == null) {
                    p();
                }
                if (iVar != null && iVar.h() != null) {
                    drawableMutate = androidx.core.graphics.drawable.d.r(iVar.h()).mutate();
                }
                if (drawableMutate != null) {
                    androidx.core.graphics.drawable.d.o(drawableMutate, TabLayout.this.f18518j);
                    PorterDuff.Mode mode = TabLayout.this.f18522n;
                    if (mode != null) {
                        androidx.core.graphics.drawable.d.p(drawableMutate, mode);
                    }
                }
                if (this.f18536b == null) {
                    q();
                    this.f18544j = u.k(this.f18536b);
                }
                u.E(this.f18536b, TabLayout.this.f18516h);
                ColorStateList colorStateList = TabLayout.this.f18517i;
                if (colorStateList != null) {
                    this.f18536b.setTextColor(colorStateList);
                }
                A(this.f18536b, this.f18537c);
                v();
                i(this.f18537c);
                i(this.f18536b);
            } else {
                TextView textView3 = this.f18541g;
                if (textView3 != null || this.f18542h != null) {
                    A(textView3, this.f18542h);
                }
            }
            if (iVar != null && !TextUtils.isEmpty(iVar.f18566d)) {
                setContentDescription(iVar.f18566d);
            }
            setSelected(iVar != null && iVar.o());
        }

        final void z() {
            setOrientation(!TabLayout.this.A ? 1 : 0);
            TextView textView = this.f18541g;
            if (textView == null && this.f18542h == null) {
                A(this.f18536b, this.f18537c);
            } else {
                A(textView, this.f18542h);
            }
        }
    }

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    private class b implements ViewPager.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f18549a;

        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.h
        public void a(@m0 ViewPager viewPager, @o0 androidx.viewpager.widget.a aVar, @o0 androidx.viewpager.widget.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.f18508J == viewPager) {
                tabLayout.O(aVar2, this.f18549a);
            }
        }

        void b(boolean z7) {
            this.f18549a = z7;
        }
    }

    @Deprecated
    public interface c<T extends i> {
        void a(T t7);

        void b(T t7);

        void c(T t7);
    }

    public @interface d {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public interface f extends c<i> {
    }

    private class g extends DataSetObserver {
        g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.E();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.E();
        }
    }

    class h extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ValueAnimator f18552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f18553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f18554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f18555d;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ View f18557a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f18558b;

            a(View view, View view2) {
                this.f18557a = view;
                this.f18558b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@m0 ValueAnimator valueAnimator) {
                h.this.h(this.f18557a, this.f18558b, valueAnimator.getAnimatedFraction());
            }
        }

        class b extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f18560a;

            b(int i7) {
                this.f18560a = i7;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.f18553b = this.f18560a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                h.this.f18553b = this.f18560a;
            }
        }

        h(Context context) {
            super(context);
            this.f18553b = -1;
            this.f18555d = -1;
            setWillNotDraw(false);
        }

        private void e() {
            View childAt = getChildAt(this.f18553b);
            com.google.android.material.tabs.b bVar = TabLayout.this.E;
            TabLayout tabLayout = TabLayout.this;
            bVar.d(tabLayout, childAt, tabLayout.f18520l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h(View view, View view2, float f8) {
            if (view != null && view.getWidth() > 0) {
                com.google.android.material.tabs.b bVar = TabLayout.this.E;
                TabLayout tabLayout = TabLayout.this;
                bVar.c(tabLayout, view, view2, f8, tabLayout.f18520l);
            } else {
                Drawable drawable = TabLayout.this.f18520l;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.f18520l.getBounds().bottom);
            }
            n2.n1(this);
        }

        private void i(boolean z7, int i7, int i8) {
            View childAt = getChildAt(this.f18553b);
            View childAt2 = getChildAt(i7);
            if (childAt2 == null) {
                e();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (!z7) {
                this.f18552a.removeAllUpdateListeners();
                this.f18552a.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f18552a = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.a.f16847b);
            valueAnimator.setDuration(i8);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.addListener(new b(i7));
            valueAnimator.start();
        }

        void b(int i7, int i8) {
            ValueAnimator valueAnimator = this.f18552a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f18552a.cancel();
            }
            i(true, i7, i8);
        }

        boolean c() {
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                if (getChildAt(i7).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        float d() {
            return this.f18553b + this.f18554c;
        }

        @Override // android.view.View
        public void draw(@m0 Canvas canvas) {
            int height;
            int iHeight = TabLayout.this.f18520l.getBounds().height();
            if (iHeight < 0) {
                iHeight = TabLayout.this.f18520l.getIntrinsicHeight();
            }
            int i7 = TabLayout.this.f18533y;
            if (i7 == 0) {
                height = getHeight() - iHeight;
                iHeight = getHeight();
            } else if (i7 != 1) {
                height = 0;
                if (i7 != 2) {
                    iHeight = i7 != 3 ? 0 : getHeight();
                }
            } else {
                height = (getHeight() - iHeight) / 2;
                iHeight = (getHeight() + iHeight) / 2;
            }
            if (TabLayout.this.f18520l.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.f18520l.getBounds();
                TabLayout.this.f18520l.setBounds(bounds.left, height, bounds.right, iHeight);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawableR = tabLayout.f18520l;
                if (tabLayout.f18521m != 0) {
                    drawableR = androidx.core.graphics.drawable.d.r(drawableR);
                    androidx.core.graphics.drawable.d.n(drawableR, TabLayout.this.f18521m);
                }
                drawableR.draw(canvas);
            }
            super.draw(canvas);
        }

        void f(int i7, float f8) {
            ValueAnimator valueAnimator = this.f18552a;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f18552a.cancel();
            }
            this.f18553b = i7;
            this.f18554c = f8;
            h(getChildAt(i7), getChildAt(this.f18553b + 1), this.f18554c);
        }

        void g(int i7) {
            Rect bounds = TabLayout.this.f18520l.getBounds();
            TabLayout.this.f18520l.setBounds(bounds.left, 0, bounds.right, i7);
            requestLayout();
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
            super.onLayout(z7, i7, i8, i9, i10);
            ValueAnimator valueAnimator = this.f18552a;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                i(false, this.f18553b, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i7, int i8) {
            super.onMeasure(i7, i8);
            if (View.MeasureSpec.getMode(i7) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z7 = true;
            if (tabLayout.f18531w == 1 || tabLayout.f18534z == 2) {
                int childCount = getChildCount();
                int iMax = 0;
                for (int i9 = 0; i9 < childCount; i9++) {
                    View childAt = getChildAt(i9);
                    if (childAt.getVisibility() == 0) {
                        iMax = Math.max(iMax, childAt.getMeasuredWidth());
                    }
                }
                if (iMax <= 0) {
                    return;
                }
                if (iMax * childCount <= getMeasuredWidth() - (((int) com.google.android.material.internal.v.e(getContext(), 16)) * 2)) {
                    boolean z8 = false;
                    for (int i10 = 0; i10 < childCount; i10++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i10).getLayoutParams();
                        if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                            layoutParams.width = iMax;
                            layoutParams.weight = 0.0f;
                            z8 = true;
                        }
                    }
                    z7 = z8;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.f18531w = 0;
                    tabLayout2.S(false);
                }
                if (z7) {
                    super.onMeasure(i7, i8);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i7) {
            super.onRtlPropertiesChanged(i7);
        }
    }

    public static class i {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f18562k = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @o0
        private Object f18563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        private Drawable f18564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        private CharSequence f18565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @o0
        private CharSequence f18566d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        private View f18568f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @o0
        public TabLayout f18570h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @m0
        public TabView f18571i;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f18567e = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @d
        private int f18569g = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f18572j = -1;

        @m0
        public i A(@d int i7) {
            this.f18569g = i7;
            TabLayout tabLayout = this.f18570h;
            if (tabLayout.f18531w == 1 || tabLayout.f18534z == 2) {
                tabLayout.S(true);
            }
            E();
            if (com.google.android.material.badge.a.f17037a && this.f18571i.o() && this.f18571i.f18539e.isVisible()) {
                this.f18571i.invalidate();
            }
            return this;
        }

        @m0
        public i B(@o0 Object obj) {
            this.f18563a = obj;
            return this;
        }

        @m0
        public i C(@a1 int i7) {
            TabLayout tabLayout = this.f18570h;
            if (tabLayout != null) {
                return D(tabLayout.getResources().getText(i7));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @m0
        public i D(@o0 CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f18566d) && !TextUtils.isEmpty(charSequence)) {
                this.f18571i.setContentDescription(charSequence);
            }
            this.f18565c = charSequence;
            E();
            return this;
        }

        void E() {
            TabView tabView = this.f18571i;
            if (tabView != null) {
                tabView.x();
            }
        }

        @o0
        public BadgeDrawable e() {
            return this.f18571i.getBadge();
        }

        @o0
        public CharSequence f() {
            TabView tabView = this.f18571i;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @o0
        public View g() {
            return this.f18568f;
        }

        @o0
        public Drawable h() {
            return this.f18564b;
        }

        public int i() {
            return this.f18572j;
        }

        @m0
        public BadgeDrawable j() {
            return this.f18571i.getOrCreateBadge();
        }

        public int k() {
            return this.f18567e;
        }

        @d
        public int l() {
            return this.f18569g;
        }

        @o0
        public Object m() {
            return this.f18563a;
        }

        @o0
        public CharSequence n() {
            return this.f18565c;
        }

        public boolean o() {
            TabLayout tabLayout = this.f18570h;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f18567e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void p() {
            this.f18571i.r();
        }

        void q() {
            this.f18570h = null;
            this.f18571i = null;
            this.f18563a = null;
            this.f18564b = null;
            this.f18572j = -1;
            this.f18565c = null;
            this.f18566d = null;
            this.f18567e = -1;
            this.f18568f = null;
        }

        public void r() {
            TabLayout tabLayout = this.f18570h;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.M(this);
        }

        @m0
        public i s(@a1 int i7) {
            TabLayout tabLayout = this.f18570h;
            if (tabLayout != null) {
                return t(tabLayout.getResources().getText(i7));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @m0
        public i t(@o0 CharSequence charSequence) {
            this.f18566d = charSequence;
            E();
            return this;
        }

        @m0
        public i u(@h0 int i7) {
            return v(LayoutInflater.from(this.f18571i.getContext()).inflate(i7, (ViewGroup) this.f18571i, false));
        }

        @m0
        public i v(@o0 View view) {
            this.f18568f = view;
            E();
            return this;
        }

        @m0
        public i w(@c.u int i7) {
            TabLayout tabLayout = this.f18570h;
            if (tabLayout != null) {
                return x(e.a.b(tabLayout.getContext(), i7));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @m0
        public i x(@o0 Drawable drawable) {
            this.f18564b = drawable;
            TabLayout tabLayout = this.f18570h;
            if (tabLayout.f18531w == 1 || tabLayout.f18534z == 2) {
                tabLayout.S(true);
            }
            E();
            if (com.google.android.material.badge.a.f17037a && this.f18571i.o() && this.f18571i.f18539e.isVisible()) {
                this.f18571i.invalidate();
            }
            return this;
        }

        @m0
        public i y(int i7) {
            this.f18572j = i7;
            TabView tabView = this.f18571i;
            if (tabView != null) {
                tabView.setId(i7);
            }
            return this;
        }

        void z(int i7) {
            this.f18567e = i7;
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface j {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface k {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface l {
    }

    public static class m implements ViewPager.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final WeakReference<TabLayout> f18573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f18574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f18575c;

        public m(TabLayout tabLayout) {
            this.f18573a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f18575c = 0;
            this.f18574b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void h(int i7, float f8, int i8) {
            TabLayout tabLayout = this.f18573a.get();
            if (tabLayout != null) {
                int i9 = this.f18575c;
                tabLayout.setScrollPosition(i7, f8, i9 != 2 || this.f18574b == 1, (i9 == 2 && this.f18574b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void t(int i7) {
            this.f18574b = this.f18575c;
            this.f18575c = i7;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void u(int i7) {
            TabLayout tabLayout = this.f18573a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i7 || i7 >= tabLayout.getTabCount()) {
                return;
            }
            int i8 = this.f18575c;
            tabLayout.N(tabLayout.z(i7), i8 == 0 || (i8 == 2 && this.f18574b == 0));
        }
    }

    public static class n implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewPager f18576a;

        public n(ViewPager viewPager) {
            this.f18576a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(i iVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(@m0 i iVar) {
            this.f18576a.setCurrentItem(iVar.k());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(i iVar) {
        }
    }

    public TabLayout(@m0 Context context) {
        this(context, null);
    }

    private void L(int i7) {
        TabView tabView = (TabView) this.f18511c.getChildAt(i7);
        this.f18511c.removeViewAt(i7);
        if (tabView != null) {
            tabView.s();
            this.P.a(tabView);
        }
        requestLayout();
    }

    private void P(@o0 ViewPager viewPager, boolean z7, boolean z8) {
        ViewPager viewPager2 = this.f18508J;
        if (viewPager2 != null) {
            m mVar = this.M;
            if (mVar != null) {
                viewPager2.O(mVar);
            }
            b bVar = this.N;
            if (bVar != null) {
                this.f18508J.N(bVar);
            }
        }
        c cVar = this.H;
        if (cVar != null) {
            H(cVar);
            this.H = null;
        }
        if (viewPager != null) {
            this.f18508J = viewPager;
            if (this.M == null) {
                this.M = new m(this);
            }
            this.M.a();
            viewPager.c(this.M);
            n nVar = new n(viewPager);
            this.H = nVar;
            c(nVar);
            androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                O(adapter, z7);
            }
            if (this.N == null) {
                this.N = new b();
            }
            this.N.b(z7);
            viewPager.b(this.N);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.f18508J = null;
            O(null, false);
        }
        this.O = z8;
    }

    private void Q() {
        int size = this.f18509a.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f18509a.get(i7).E();
        }
    }

    private void R(@m0 LinearLayout.LayoutParams layoutParams) {
        if (this.f18534z == 1 && this.f18531w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    @q(unit = 0)
    private int getDefaultHeight() {
        int size = this.f18509a.size();
        boolean z7 = false;
        for (int i7 = 0; i7 < size; i7++) {
            i iVar = this.f18509a.get(i7);
            if (iVar != null && iVar.h() != null && !TextUtils.isEmpty(iVar.n())) {
                z7 = true;
                break;
            }
        }
        return (!z7 || this.A) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i7 = this.f18527s;
        if (i7 != -1) {
            return i7;
        }
        int i8 = this.f18534z;
        if (i8 == 0 || i8 == 2) {
            return this.f18529u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f18511c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void i(@m0 TabItem tabItem) {
        i iVarD = D();
        CharSequence charSequence = tabItem.f18505a;
        if (charSequence != null) {
            iVarD.D(charSequence);
        }
        Drawable drawable = tabItem.f18506b;
        if (drawable != null) {
            iVarD.x(drawable);
        }
        int i7 = tabItem.f18507c;
        if (i7 != 0) {
            iVarD.u(i7);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            iVarD.t(tabItem.getContentDescription());
        }
        e(iVarD);
    }

    private void j(@m0 i iVar) {
        TabView tabView = iVar.f18571i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.f18511c.addView(tabView, iVar.k(), s());
    }

    private void k(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        i((TabItem) view);
    }

    private void l(int i7) {
        if (i7 == -1) {
            return;
        }
        if (getWindowToken() == null || !n2.U0(this) || this.f18511c.c()) {
            setScrollPosition(i7, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int iO = o(i7, 0.0f);
        if (scrollX != iO) {
            y();
            this.I.setIntValues(scrollX, iO);
            this.I.start();
        }
        this.f18511c.b(i7, this.f18532x);
    }

    private void m(int i7) {
        if (i7 == 0) {
            Log.w(C0, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i7 == 1) {
            this.f18511c.setGravity(1);
            return;
        } else if (i7 != 2) {
            return;
        }
        this.f18511c.setGravity(n0.f6717b);
    }

    private void n() {
        int i7 = this.f18534z;
        n2.d2(this.f18511c, (i7 == 0 || i7 == 2) ? Math.max(0, this.f18530v - this.f18512d) : 0, 0, 0, 0);
        int i8 = this.f18534z;
        if (i8 == 0) {
            m(this.f18531w);
        } else if (i8 == 1 || i8 == 2) {
            if (this.f18531w == 2) {
                Log.w(C0, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.f18511c.setGravity(1);
        }
        S(true);
    }

    private int o(int i7, float f8) {
        int i8 = this.f18534z;
        if (i8 != 0 && i8 != 2) {
            return 0;
        }
        View childAt = this.f18511c.getChildAt(i7);
        int i9 = i7 + 1;
        View childAt2 = i9 < this.f18511c.getChildCount() ? this.f18511c.getChildAt(i9) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i10 = (int) ((width + width2) * 0.5f * f8);
        return n2.Z(this) == 0 ? left + i10 : left - i10;
    }

    private void q(@m0 i iVar, int i7) {
        iVar.z(i7);
        this.f18509a.add(i7, iVar);
        int size = this.f18509a.size();
        while (true) {
            i7++;
            if (i7 >= size) {
                return;
            } else {
                this.f18509a.get(i7).z(i7);
            }
        }
    }

    @m0
    private static ColorStateList r(int i7, int i8) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i8, i7});
    }

    @m0
    private LinearLayout.LayoutParams s() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        R(layoutParams);
        return layoutParams;
    }

    private void setSelectedTabView(int i7) {
        int childCount = this.f18511c.getChildCount();
        if (i7 < childCount) {
            int i8 = 0;
            while (i8 < childCount) {
                View childAt = this.f18511c.getChildAt(i8);
                boolean z7 = true;
                childAt.setSelected(i8 == i7);
                if (i8 != i7) {
                    z7 = false;
                }
                childAt.setActivated(z7);
                i8++;
            }
        }
    }

    @m0
    private TabView u(@m0 i iVar) {
        v.a<TabView> aVar = this.P;
        TabView tabViewB = aVar != null ? aVar.b() : null;
        if (tabViewB == null) {
            tabViewB = new TabView(getContext());
        }
        tabViewB.setTab(iVar);
        tabViewB.setFocusable(true);
        tabViewB.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(iVar.f18566d)) {
            tabViewB.setContentDescription(iVar.f18565c);
        } else {
            tabViewB.setContentDescription(iVar.f18566d);
        }
        return tabViewB;
    }

    private void v(@m0 i iVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).a(iVar);
        }
    }

    private void w(@m0 i iVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).b(iVar);
        }
    }

    private void x(@m0 i iVar) {
        for (int size = this.G.size() - 1; size >= 0; size--) {
            this.G.get(size).c(iVar);
        }
    }

    private void y() {
        if (this.I == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.I = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.animation.a.f16847b);
            this.I.setDuration(this.f18532x);
            this.I.addUpdateListener(new a());
        }
    }

    public boolean A() {
        return this.D;
    }

    public boolean B() {
        return this.A;
    }

    public boolean C() {
        return this.B;
    }

    @m0
    public i D() {
        i iVarT = t();
        iVarT.f18570h = this;
        iVarT.f18571i = u(iVarT);
        if (iVarT.f18572j != -1) {
            iVarT.f18571i.setId(iVarT.f18572j);
        }
        return iVarT;
    }

    void E() {
        int currentItem;
        G();
        androidx.viewpager.widget.a aVar = this.K;
        if (aVar != null) {
            int iE = aVar.e();
            for (int i7 = 0; i7 < iE; i7++) {
                h(D().D(this.K.g(i7)), false);
            }
            ViewPager viewPager = this.f18508J;
            if (viewPager == null || iE <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            M(z(currentItem));
        }
    }

    protected boolean F(i iVar) {
        return B0.a(iVar);
    }

    public void G() {
        for (int childCount = this.f18511c.getChildCount() - 1; childCount >= 0; childCount--) {
            L(childCount);
        }
        Iterator<i> it = this.f18509a.iterator();
        while (it.hasNext()) {
            i next = it.next();
            it.remove();
            next.q();
            F(next);
        }
        this.f18510b = null;
    }

    @Deprecated
    public void H(@o0 c cVar) {
        this.G.remove(cVar);
    }

    public void I(@m0 f fVar) {
        H(fVar);
    }

    public void J(@m0 i iVar) {
        if (iVar.f18570h != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        K(iVar.k());
    }

    public void K(int i7) {
        i iVar = this.f18510b;
        int iK = iVar != null ? iVar.k() : 0;
        L(i7);
        i iVarRemove = this.f18509a.remove(i7);
        if (iVarRemove != null) {
            iVarRemove.q();
            F(iVarRemove);
        }
        int size = this.f18509a.size();
        for (int i8 = i7; i8 < size; i8++) {
            this.f18509a.get(i8).z(i8);
        }
        if (iK == i7) {
            M(this.f18509a.isEmpty() ? null : this.f18509a.get(Math.max(0, i7 - 1)));
        }
    }

    public void M(@o0 i iVar) {
        N(iVar, true);
    }

    public void N(@o0 i iVar, boolean z7) {
        i iVar2 = this.f18510b;
        if (iVar2 == iVar) {
            if (iVar2 != null) {
                v(iVar);
                l(iVar.k());
                return;
            }
            return;
        }
        int iK = iVar != null ? iVar.k() : -1;
        if (z7) {
            if ((iVar2 == null || iVar2.k() == -1) && iK != -1) {
                setScrollPosition(iK, 0.0f, true);
            } else {
                l(iK);
            }
            if (iK != -1) {
                setSelectedTabView(iK);
            }
        }
        this.f18510b = iVar;
        if (iVar2 != null) {
            x(iVar2);
        }
        if (iVar != null) {
            w(iVar);
        }
    }

    void O(@o0 androidx.viewpager.widget.a aVar, boolean z7) {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a aVar2 = this.K;
        if (aVar2 != null && (dataSetObserver = this.L) != null) {
            aVar2.u(dataSetObserver);
        }
        this.K = aVar;
        if (z7 && aVar != null) {
            if (this.L == null) {
                this.L = new g();
            }
            aVar.m(this.L);
        }
        E();
    }

    void S(boolean z7) {
        for (int i7 = 0; i7 < this.f18511c.getChildCount(); i7++) {
            View childAt = this.f18511c.getChildAt(i7);
            childAt.setMinimumWidth(getTabMinWidth());
            R((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z7) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        k(view);
    }

    @Deprecated
    public void c(@o0 c cVar) {
        if (this.G.contains(cVar)) {
            return;
        }
        this.G.add(cVar);
    }

    public void d(@m0 f fVar) {
        c(fVar);
    }

    public void e(@m0 i iVar) {
        h(iVar, this.f18509a.isEmpty());
    }

    public void f(@m0 i iVar, int i7) {
        g(iVar, i7, this.f18509a.isEmpty());
    }

    public void g(@m0 i iVar, int i7, boolean z7) {
        if (iVar.f18570h != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        q(iVar, i7);
        j(iVar);
        if (z7) {
            iVar.r();
        }
    }

    public int getSelectedTabPosition() {
        i iVar = this.f18510b;
        if (iVar != null) {
            return iVar.k();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f18509a.size();
    }

    public int getTabGravity() {
        return this.f18531w;
    }

    @o0
    public ColorStateList getTabIconTint() {
        return this.f18518j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.C;
    }

    public int getTabIndicatorGravity() {
        return this.f18533y;
    }

    int getTabMaxWidth() {
        return this.f18526r;
    }

    public int getTabMode() {
        return this.f18534z;
    }

    @o0
    public ColorStateList getTabRippleColor() {
        return this.f18519k;
    }

    @m0
    public Drawable getTabSelectedIndicator() {
        return this.f18520l;
    }

    @o0
    public ColorStateList getTabTextColors() {
        return this.f18517i;
    }

    public void h(@m0 i iVar, boolean z7) {
        g(iVar, this.f18509a.size(), z7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.k.e(this);
        if (this.f18508J == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                P((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O) {
            setupWithViewPager(null);
            this.O = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@m0 Canvas canvas) {
        for (int i7 = 0; i7 < this.f18511c.getChildCount(); i7++) {
            View childAt = this.f18511c.getChildAt(i7);
            if (childAt instanceof TabView) {
                ((TabView) childAt).m(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        l0.X1(accessibilityNodeInfo).Y0(l0.b.f(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0080  */
    /* JADX WARN: Code duplicated, block: B:30:0x0082  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        int iRound = Math.round(com.google.android.material.internal.v.e(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i8);
        boolean z7 = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i8 = View.MeasureSpec.makeMeasureSpec(iRound + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i8) >= iRound) {
            getChildAt(0).setMinimumHeight(iRound);
        }
        int size = View.MeasureSpec.getSize(i7);
        if (View.MeasureSpec.getMode(i7) != 0) {
            int iE = this.f18528t;
            if (iE <= 0) {
                iE = (int) (size - com.google.android.material.internal.v.e(getContext(), 56));
            }
            this.f18526r = iE;
        }
        super.onMeasure(i7, i8);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i9 = this.f18534z;
            if (i9 == 0) {
                if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                    z7 = true;
                }
            } else if (i9 != 1) {
                if (i9 == 2) {
                    if (childAt.getMeasuredWidth() < getMeasuredWidth()) {
                        z7 = true;
                    }
                }
            } else if (childAt.getMeasuredWidth() != getMeasuredWidth()) {
                z7 = true;
            }
            if (z7) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i8, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    public void p() {
        this.G.clear();
    }

    @Override // android.view.View
    @t0(21)
    public void setElevation(float f8) {
        super.setElevation(f8);
        com.google.android.material.shape.k.d(this, f8);
    }

    public void setInlineLabel(boolean z7) {
        if (this.A != z7) {
            this.A = z7;
            for (int i7 = 0; i7 < this.f18511c.getChildCount(); i7++) {
                View childAt = this.f18511c.getChildAt(i7);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).z();
                }
            }
            n();
        }
    }

    public void setInlineLabelResource(@c.h int i7) {
        setInlineLabel(getResources().getBoolean(i7));
    }

    @Deprecated
    public void setOnTabSelectedListener(@o0 f fVar) {
        setOnTabSelectedListener((c) fVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        y();
        this.I.addListener(animatorListener);
    }

    public void setScrollPosition(int i7, float f8, boolean z7) {
        setScrollPosition(i7, f8, z7, true);
    }

    public void setSelectedTabIndicator(@o0 Drawable drawable) {
        if (this.f18520l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f18520l = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(@c.l int i7) {
        this.f18521m = i7;
    }

    public void setSelectedTabIndicatorGravity(int i7) {
        if (this.f18533y != i7) {
            this.f18533y = i7;
            n2.n1(this.f18511c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i7) {
        this.f18511c.g(i7);
    }

    public void setTabGravity(int i7) {
        if (this.f18531w != i7) {
            this.f18531w = i7;
            n();
        }
    }

    public void setTabIconTint(@o0 ColorStateList colorStateList) {
        if (this.f18518j != colorStateList) {
            this.f18518j = colorStateList;
            Q();
        }
    }

    public void setTabIconTintResource(@c.n int i7) {
        setTabIconTint(e.a.a(getContext(), i7));
    }

    public void setTabIndicatorAnimationMode(int i7) {
        this.C = i7;
        if (i7 == 0) {
            this.E = new com.google.android.material.tabs.b();
        } else {
            if (i7 == 1) {
                this.E = new com.google.android.material.tabs.a();
                return;
            }
            throw new IllegalArgumentException(i7 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z7) {
        this.B = z7;
        n2.n1(this.f18511c);
    }

    public void setTabMode(int i7) {
        if (i7 != this.f18534z) {
            this.f18534z = i7;
            n();
        }
    }

    public void setTabRippleColor(@o0 ColorStateList colorStateList) {
        if (this.f18519k != colorStateList) {
            this.f18519k = colorStateList;
            for (int i7 = 0; i7 < this.f18511c.getChildCount(); i7++) {
                View childAt = this.f18511c.getChildAt(i7);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@c.n int i7) {
        setTabRippleColor(e.a.a(getContext(), i7));
    }

    public void setTabTextColors(@o0 ColorStateList colorStateList) {
        if (this.f18517i != colorStateList) {
            this.f18517i = colorStateList;
            Q();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@o0 androidx.viewpager.widget.a aVar) {
        O(aVar, false);
    }

    public void setUnboundedRipple(boolean z7) {
        if (this.D != z7) {
            this.D = z7;
            for (int i7 = 0; i7 < this.f18511c.getChildCount(); i7++) {
                View childAt = this.f18511c.getChildAt(i7);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@c.h int i7) {
        setUnboundedRipple(getResources().getBoolean(i7));
    }

    public void setupWithViewPager(@o0 ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    protected i t() {
        i iVarB = B0.b();
        return iVarB == null ? new i() : iVarB;
    }

    @o0
    public i z(int i7) {
        if (i7 < 0 || i7 >= getTabCount()) {
            return null;
        }
        return this.f18509a.get(i7);
    }

    public TabLayout(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i7) {
        k(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@o0 c cVar) {
        c cVar2 = this.F;
        if (cVar2 != null) {
            H(cVar2);
        }
        this.F = cVar;
        if (cVar != null) {
            c(cVar);
        }
    }

    public void setScrollPosition(int i7, float f8, boolean z7, boolean z8) {
        int iRound = Math.round(i7 + f8);
        if (iRound < 0 || iRound >= this.f18511c.getChildCount()) {
            return;
        }
        if (z8) {
            this.f18511c.f(i7, f8);
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.I.cancel();
        }
        scrollTo(o(i7, f8), 0);
        if (z7) {
            setSelectedTabView(iRound);
        }
    }

    public void setupWithViewPager(@o0 ViewPager viewPager, boolean z7) {
        P(viewPager, z7, false);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TabLayout(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = Q;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f18509a = new ArrayList<>();
        this.f18520l = new GradientDrawable();
        this.f18521m = 0;
        this.f18526r = Integer.MAX_VALUE;
        this.G = new ArrayList<>();
        this.P = new v.b(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        h hVar = new h(context2);
        this.f18511c = hVar;
        super.addView(hVar, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayJ = com.google.android.material.internal.n.j(context2, attributeSet, R.styleable.TabLayout, i7, i8, R.styleable.TabLayout_tabTextAppearance);
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            com.google.android.material.shape.j jVar = new com.google.android.material.shape.j();
            jVar.n0(ColorStateList.valueOf(colorDrawable.getColor()));
            jVar.Y(context2);
            jVar.m0(n2.R(this));
            n2.I1(this, jVar);
        }
        setSelectedTabIndicator(com.google.android.material.resources.c.d(context2, typedArrayJ, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(typedArrayJ.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        hVar.g(typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(typedArrayJ.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(typedArrayJ.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(typedArrayJ.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int dimensionPixelSize = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.f18515g = dimensionPixelSize;
        this.f18514f = dimensionPixelSize;
        this.f18513e = dimensionPixelSize;
        this.f18512d = dimensionPixelSize;
        this.f18512d = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.f18513e = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.f18513e);
        this.f18514f = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.f18514f);
        this.f18515g = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.f18515g);
        int resourceId = typedArrayJ.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
        this.f18516h = resourceId;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.f18523o = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.f18517i = com.google.android.material.resources.c.a(context2, typedArrayObtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayJ.hasValue(R.styleable.TabLayout_tabTextColor)) {
                this.f18517i = com.google.android.material.resources.c.a(context2, typedArrayJ, R.styleable.TabLayout_tabTextColor);
            }
            if (typedArrayJ.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
                this.f18517i = r(this.f18517i.getDefaultColor(), typedArrayJ.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0));
            }
            this.f18518j = com.google.android.material.resources.c.a(context2, typedArrayJ, R.styleable.TabLayout_tabIconTint);
            this.f18522n = com.google.android.material.internal.v.k(typedArrayJ.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.f18519k = com.google.android.material.resources.c.a(context2, typedArrayJ, R.styleable.TabLayout_tabRippleColor);
            this.f18532x = typedArrayJ.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.f18527s = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.f18528t = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.f18525q = typedArrayJ.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.f18530v = typedArrayJ.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.f18534z = typedArrayJ.getInt(R.styleable.TabLayout_tabMode, 1);
            this.f18531w = typedArrayJ.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.A = typedArrayJ.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.D = typedArrayJ.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            typedArrayJ.recycle();
            Resources resources = getResources();
            this.f18524p = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.f18529u = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            n();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        k(view);
    }

    public void setSelectedTabIndicator(@c.u int i7) {
        if (i7 != 0) {
            setSelectedTabIndicator(e.a.b(getContext(), i7));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        k(view);
    }

    public void setTabTextColors(int i7, int i8) {
        setTabTextColors(r(i7, i8));
    }
}
