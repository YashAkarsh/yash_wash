package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.n2;
import androidx.core.view.w5;
import androidx.core.view.z1;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class v {

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f17897a;

        a(View view) {
            this.f17897a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f17897a.getContext().getSystemService("input_method")).showSoftInput(this.f17897a, 1);
        }
    }

    static class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f17898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f17899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f17900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f17901d;

        b(boolean z7, boolean z8, boolean z9, e eVar) {
            this.f17898a = z7;
            this.f17899b = z8;
            this.f17900c = z9;
            this.f17901d = eVar;
        }

        @Override // com.google.android.material.internal.v.e
        @m0
        public w5 a(View view, @m0 w5 w5Var, @m0 f fVar) {
            if (this.f17898a) {
                fVar.f17907d += w5Var.o();
            }
            boolean zJ = v.j(view);
            if (this.f17899b) {
                if (zJ) {
                    fVar.f17906c += w5Var.p();
                } else {
                    fVar.f17904a += w5Var.p();
                }
            }
            if (this.f17900c) {
                if (zJ) {
                    fVar.f17904a += w5Var.q();
                } else {
                    fVar.f17906c += w5Var.q();
                }
            }
            fVar.a(view);
            e eVar = this.f17901d;
            return eVar != null ? eVar.a(view, w5Var, fVar) : w5Var;
        }
    }

    static class c implements z1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f17902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f17903b;

        c(e eVar, f fVar) {
            this.f17902a = eVar;
            this.f17903b = fVar;
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, w5 w5Var) {
            return this.f17902a.a(view, w5Var, new f(this.f17903b));
        }
    }

    static class d implements View.OnAttachStateChangeListener {
        d() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@m0 View view) {
            view.removeOnAttachStateChangeListener(this);
            n2.v1(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public interface e {
        w5 a(View view, w5 w5Var, f fVar);
    }

    private v() {
    }

    public static void a(@o0 View view, @m0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void b(@m0 View view, @o0 AttributeSet attributeSet, int i7, int i8) {
        c(view, attributeSet, i7, i8, null);
    }

    public static void c(@m0 View view, @o0 AttributeSet attributeSet, int i7, int i8, @o0 e eVar) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i7, i8);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z8 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z9 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        d(view, new b(z7, z8, z9, eVar));
    }

    public static void d(@m0 View view, @m0 e eVar) {
        n2.a2(view, new c(eVar, new f(n2.k0(view), view.getPaddingTop(), n2.j0(view), view.getPaddingBottom())));
        n(view);
    }

    public static float e(@m0 Context context, @c.q(unit = 0) int i7) {
        return TypedValue.applyDimension(1, i7, context.getResources().getDisplayMetrics());
    }

    @o0
    public static ViewGroup f(@o0 View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @o0
    public static u g(@m0 View view) {
        return h(f(view));
    }

    @o0
    public static u h(@o0 View view) {
        if (view == null) {
            return null;
        }
        return new t(view);
    }

    public static float i(@m0 View view) {
        float fR = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fR += n2.R((View) parent);
        }
        return fR;
    }

    public static boolean j(View view) {
        return n2.Z(view) == 1;
    }

    public static PorterDuff.Mode k(int i7, PorterDuff.Mode mode) {
        if (i7 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i7 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i7 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i7) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void l(@o0 View view, @m0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            m(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void m(@m0 ViewTreeObserver viewTreeObserver, @m0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void n(@m0 View view) {
        if (n2.O0(view)) {
            n2.v1(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void o(@m0 View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f17906c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f17907d;

        public f(int i7, int i8, int i9, int i10) {
            this.f17904a = i7;
            this.f17905b = i8;
            this.f17906c = i9;
            this.f17907d = i10;
        }

        public void a(View view) {
            n2.d2(view, this.f17904a, this.f17905b, this.f17906c, this.f17907d);
        }

        public f(@m0 f fVar) {
            this.f17904a = fVar.f17904a;
            this.f17905b = fVar.f17905b;
            this.f17906c = fVar.f17906c;
            this.f17907d = fVar.f17907d;
        }
    }
}
