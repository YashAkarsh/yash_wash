package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.n2;
import c.m0;
import c.x0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class s implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f17889a;

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    static class a extends ViewGroup {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static Method f17890f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ViewGroup f17891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        View f17892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList<Drawable> f17893c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        s f17894d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f17895e;

        static {
            try {
                Class cls = Integer.TYPE;
                f17890f = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, s sVar) {
            super(context);
            this.f17893c = null;
            this.f17891a = viewGroup;
            this.f17892b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f17894d = sVar;
        }

        private void c() {
            if (this.f17895e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f17893c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f17895e = true;
                    this.f17891a.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f17891a.getLocationOnScreen(iArr2);
            this.f17892b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f17893c == null) {
                this.f17893c = new ArrayList<>();
            }
            if (this.f17893c.contains(drawable)) {
                return;
            }
            this.f17893c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f17891a && viewGroup.getParent() != null && n2.O0(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f17891a.getLocationOnScreen(iArr2);
                    n2.e1(view, iArr[0] - iArr2[0]);
                    n2.f1(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f17891a.getLocationOnScreen(iArr);
            this.f17892b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f17892b.getWidth(), this.f17892b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f17893c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f17893c.get(i7).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        protected ViewParent f(int i7, int i8, Rect rect) {
            if (this.f17891a == null || f17890f == null) {
                return null;
            }
            try {
                e(new int[2]);
                f17890f.invoke(this.f17891a, Integer.valueOf(i7), Integer.valueOf(i8), rect);
                return null;
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
                return null;
            } catch (InvocationTargetException e9) {
                e9.printStackTrace();
                return null;
            }
        }

        public void g(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f17893c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        public void h(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f17891a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f17891a == null) {
                invalidate(rect);
                return null;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            int[] iArr2 = new int[2];
            e(iArr2);
            rect.offset(iArr2[0], iArr2[1]);
            return super.invalidateChildInParent(iArr, rect);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@m0 Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@m0 Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f17893c) != null && arrayList.contains(drawable));
        }
    }

    s(Context context, ViewGroup viewGroup, View view) {
        this.f17889a = new a(context, viewGroup, view, this);
    }

    static s e(View view) {
        ViewGroup viewGroupF = v.f(view);
        if (viewGroupF == null) {
            return null;
        }
        int childCount = viewGroupF.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroupF.getChildAt(i7);
            if (childAt instanceof a) {
                return ((a) childAt).f17894d;
            }
        }
        return new p(viewGroupF.getContext(), viewGroupF, view);
    }

    @Override // com.google.android.material.internal.u
    public void a(@m0 Drawable drawable) {
        this.f17889a.a(drawable);
    }

    @Override // com.google.android.material.internal.u
    public void b(@m0 Drawable drawable) {
        this.f17889a.g(drawable);
    }
}
