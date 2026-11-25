package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.l;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.core.view.z1;
import c.b1;
import c.h0;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.shape.j;

/* JADX INFO: loaded from: classes.dex */
public class a extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BottomSheetBehavior<FrameLayout> f17189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FrameLayout f17190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CoordinatorLayout f17191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FrameLayout f17192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f17193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f17194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f17195k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17196l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private BottomSheetBehavior.g f17197m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f17198n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @m0
    private BottomSheetBehavior.g f17199o;

    /* JADX INFO: renamed from: com.google.android.material.bottomsheet.a$a, reason: collision with other inner class name */
    class C0190a implements z1 {
        C0190a() {
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, w5 w5Var) {
            if (a.this.f17197m != null) {
                a.this.f17189e.u0(a.this.f17197m);
            }
            if (w5Var != null) {
                a aVar = a.this;
                aVar.f17197m = new f(aVar.f17192h, w5Var, null);
                a.this.f17189e.U(a.this.f17197m);
            }
            return w5Var;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f17194j && aVar.isShowing() && a.this.x()) {
                a.this.cancel();
            }
        }
    }

    class c extends androidx.core.view.a {
        c() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            if (!a.this.f17194j) {
                l0Var.d1(false);
            } else {
                l0Var.a(1048576);
                l0Var.d1(true);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i7, Bundle bundle) {
            if (i7 == 1048576) {
                a aVar = a.this;
                if (aVar.f17194j) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.j(view, i7, bundle);
        }
    }

    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class e extends BottomSheetBehavior.g {
        e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@m0 View view, float f8) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@m0 View view, int i7) {
            if (i7 == 5) {
                a.this.cancel();
            }
        }
    }

    private static class f extends BottomSheetBehavior.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f17205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f17206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final w5 f17207c;

        /* synthetic */ f(View view, w5 w5Var, C0190a c0190a) {
            this(view, w5Var);
        }

        private void c(View view) {
            if (view.getTop() < this.f17207c.r()) {
                a.w(view, this.f17205a);
                view.setPadding(view.getPaddingLeft(), this.f17207c.r() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.w(view, this.f17206b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void a(@m0 View view, float f8) {
            c(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(@m0 View view, int i7) {
            c(view);
        }

        private f(@m0 View view, @m0 w5 w5Var) {
            this.f17207c = w5Var;
            boolean z7 = (view.getSystemUiVisibility() & 8192) != 0;
            this.f17206b = z7;
            j jVarI0 = BottomSheetBehavior.f0(view).i0();
            ColorStateList colorStateListY = jVarI0 != null ? jVarI0.y() : n2.N(view);
            if (colorStateListY != null) {
                this.f17205a = k1.a.f(colorStateListY.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.f17205a = k1.a.f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.f17205a = z7;
            }
        }
    }

    public a(@m0 Context context) {
        this(context, 0);
        this.f17198n = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private static int g(@m0 Context context, int i7) {
        if (i7 != 0) {
            return i7;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
    }

    private FrameLayout p() {
        if (this.f17190f == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.f17190f = frameLayout;
            this.f17191g = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.f17190f.findViewById(R.id.design_bottom_sheet);
            this.f17192h = frameLayout2;
            BottomSheetBehavior<FrameLayout> bottomSheetBehaviorF0 = BottomSheetBehavior.f0(frameLayout2);
            this.f17189e = bottomSheetBehaviorF0;
            bottomSheetBehaviorF0.U(this.f17199o);
            this.f17189e.E0(this.f17194j);
        }
        return this.f17190f;
    }

    public static void w(@m0 View view, boolean z7) {
        int systemUiVisibility = view.getSystemUiVisibility();
        view.setSystemUiVisibility(z7 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
    }

    private View y(int i7, @o0 View view, @o0 ViewGroup.LayoutParams layoutParams) {
        p();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f17190f.findViewById(R.id.coordinator);
        if (i7 != 0 && view == null) {
            view = getLayoutInflater().inflate(i7, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f17198n) {
            n2.a2(this.f17192h, new C0190a());
        }
        this.f17192h.removeAllViews();
        if (layoutParams == null) {
            this.f17192h.addView(view);
        } else {
            this.f17192h.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b());
        n2.B1(this.f17192h, new c());
        this.f17192h.setOnTouchListener(new d());
        return this.f17190f;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorR = r();
        if (!this.f17193i || bottomSheetBehaviorR.o0() == 5) {
            super.cancel();
        } else {
            bottomSheetBehaviorR.K0(5);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z7 = this.f17198n && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.f17190f;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z7);
            }
            CoordinatorLayout coordinatorLayout = this.f17191g;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z7);
            }
            if (z7) {
                window.getDecorView().setSystemUiVisibility(768);
            }
        }
    }

    @Override // androidx.appcompat.app.l, androidx.activity.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // androidx.activity.f, android.app.Dialog
    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f17189e;
        if (bottomSheetBehavior == null || bottomSheetBehavior.o0() != 5) {
            return;
        }
        this.f17189e.K0(4);
    }

    @m0
    public BottomSheetBehavior<FrameLayout> r() {
        if (this.f17189e == null) {
            p();
        }
        return this.f17189e;
    }

    public boolean s() {
        return this.f17193i;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z7) {
        super.setCancelable(z7);
        if (this.f17194j != z7) {
            this.f17194j = z7;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.f17189e;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.E0(z7);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z7) {
        super.setCanceledOnTouchOutside(z7);
        if (z7 && !this.f17194j) {
            this.f17194j = true;
        }
        this.f17195k = z7;
        this.f17196l = true;
    }

    @Override // androidx.appcompat.app.l, androidx.activity.f, android.app.Dialog
    public void setContentView(@h0 int i7) {
        super.setContentView(y(i7, null, null));
    }

    public boolean t() {
        return this.f17198n;
    }

    void u() {
        this.f17189e.u0(this.f17199o);
    }

    public void v(boolean z7) {
        this.f17193i = z7;
    }

    boolean x() {
        if (!this.f17196l) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.f17195k = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f17196l = true;
        }
        return this.f17195k;
    }

    @Override // androidx.appcompat.app.l, androidx.activity.f, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(y(0, view, null));
    }

    @Override // androidx.appcompat.app.l, androidx.activity.f, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(y(0, view, layoutParams));
    }

    public a(@m0 Context context, @b1 int i7) {
        super(context, g(context, i7));
        this.f17194j = true;
        this.f17195k = true;
        this.f17199o = new e();
        i(1);
        this.f17198n = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    protected a(@m0 Context context, boolean z7, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z7, onCancelListener);
        this.f17194j = true;
        this.f17195k = true;
        this.f17199o = new e();
        i(1);
        this.f17194j = z7;
        this.f17198n = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
