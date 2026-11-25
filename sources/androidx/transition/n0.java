package androidx.transition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.n2;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class n0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f10753a;

    static class a extends ViewGroup {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static Method f10754f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ViewGroup f10755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        View f10756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ArrayList<Drawable> f10757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        n0 f10758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f10759e;

        static {
            try {
                Class cls = Integer.TYPE;
                f10754f = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, n0 n0Var) {
            super(context);
            this.f10757c = null;
            this.f10755a = viewGroup;
            this.f10756b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f10758d = n0Var;
        }

        private void c() {
            if (this.f10759e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f10757c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f10759e = true;
                    this.f10755a.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f10755a.getLocationOnScreen(iArr2);
            this.f10756b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f10757c == null) {
                this.f10757c = new ArrayList<>();
            }
            if (this.f10757c.contains(drawable)) {
                return;
            }
            this.f10757c.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f10755a && viewGroup.getParent() != null && n2.O0(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f10755a.getLocationOnScreen(iArr2);
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
            this.f10755a.getLocationOnScreen(iArr);
            this.f10756b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f10756b.getWidth(), this.f10756b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f10757c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.f10757c.get(i7).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
        protected ViewParent f(int i7, int i8, Rect rect) {
            if (!(this.f10755a instanceof ViewGroup) || f10754f == null) {
                return null;
            }
            try {
                e(new int[2]);
                f10754f.invoke(this.f10755a, Integer.valueOf(i7), Integer.valueOf(i8), rect);
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
            ArrayList<Drawable> arrayList = this.f10757c;
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
            if (this.f10755a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (!(this.f10755a instanceof ViewGroup)) {
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
        public void invalidateDrawable(@c.m0 Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(@c.m0 Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f10757c) != null && arrayList.contains(drawable));
        }
    }

    n0(Context context, ViewGroup viewGroup, View view) {
        this.f10753a = new a(context, viewGroup, view, this);
    }

    static n0 e(View view) {
        ViewGroup viewGroupF = f(view);
        if (viewGroupF == null) {
            return null;
        }
        int childCount = viewGroupF.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = viewGroupF.getChildAt(i7);
            if (childAt instanceof a) {
                return ((a) childAt).f10758d;
            }
        }
        return new g0(viewGroupF.getContext(), viewGroupF, view);
    }

    static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // androidx.transition.p0
    public void a(@c.m0 Drawable drawable) {
        this.f10753a.a(drawable);
    }

    @Override // androidx.transition.p0
    public void b(@c.m0 Drawable drawable) {
        this.f10753a.g(drawable);
    }
}
