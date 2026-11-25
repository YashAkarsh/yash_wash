package com.bumptech.glide.request.target;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class n<T extends View, Z> extends b<Z> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f14892d = "ViewTarget";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f14893e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Integer f14894f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final T f14895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f14896c;

    private static class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f14897e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f14898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<k> f14899b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ViewTreeObserverOnPreDrawListenerC0173a f14900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Point f14901d;

        /* JADX INFO: renamed from: com.bumptech.glide.request.target.n$a$a, reason: collision with other inner class name */
        private static class ViewTreeObserverOnPreDrawListenerC0173a implements ViewTreeObserver.OnPreDrawListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f14902a;

            public ViewTreeObserverOnPreDrawListenerC0173a(a aVar) {
                this.f14902a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable(n.f14892d, 2)) {
                    Log.v(n.f14892d, "OnGlobalLayoutListener called listener=" + this);
                }
                a aVar = this.f14902a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.b();
                return true;
            }
        }

        public a(View view) {
            this.f14898a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.f14899b.isEmpty()) {
                return;
            }
            int iG = g();
            int iF = f();
            if (h(iG) && h(iF)) {
                i(iG, iF);
                ViewTreeObserver viewTreeObserver = this.f14898a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f14900c);
                }
                this.f14900c = null;
            }
        }

        @TargetApi(13)
        private Point c() {
            Point point = this.f14901d;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.f14898a.getContext().getSystemService("window")).getDefaultDisplay();
            Point point2 = new Point();
            this.f14901d = point2;
            defaultDisplay.getSize(point2);
            return this.f14901d;
        }

        private int e(int i7, boolean z7) {
            if (i7 != -2) {
                return i7;
            }
            Point pointC = c();
            return z7 ? pointC.y : pointC.x;
        }

        private int f() {
            ViewGroup.LayoutParams layoutParams = this.f14898a.getLayoutParams();
            if (h(this.f14898a.getHeight())) {
                return this.f14898a.getHeight();
            }
            if (layoutParams != null) {
                return e(layoutParams.height, true);
            }
            return 0;
        }

        private int g() {
            ViewGroup.LayoutParams layoutParams = this.f14898a.getLayoutParams();
            if (h(this.f14898a.getWidth())) {
                return this.f14898a.getWidth();
            }
            if (layoutParams != null) {
                return e(layoutParams.width, false);
            }
            return 0;
        }

        private boolean h(int i7) {
            return i7 > 0 || i7 == -2;
        }

        private void i(int i7, int i8) {
            Iterator<k> it = this.f14899b.iterator();
            while (it.hasNext()) {
                it.next().e(i7, i8);
            }
            this.f14899b.clear();
        }

        public void d(k kVar) {
            int iG = g();
            int iF = f();
            if (h(iG) && h(iF)) {
                kVar.e(iG, iF);
                return;
            }
            if (!this.f14899b.contains(kVar)) {
                this.f14899b.add(kVar);
            }
            if (this.f14900c == null) {
                ViewTreeObserver viewTreeObserver = this.f14898a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0173a viewTreeObserverOnPreDrawListenerC0173a = new ViewTreeObserverOnPreDrawListenerC0173a(this);
                this.f14900c = viewTreeObserverOnPreDrawListenerC0173a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0173a);
            }
        }
    }

    public n(T t7) {
        if (t7 == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f14895b = t7;
        this.f14896c = new a(t7);
    }

    private Object i() {
        Integer num = f14894f;
        return num == null ? this.f14895b.getTag() : this.f14895b.getTag(num.intValue());
    }

    private void j(Object obj) {
        Integer num = f14894f;
        if (num != null) {
            this.f14895b.setTag(num.intValue(), obj);
        } else {
            f14893e = true;
            this.f14895b.setTag(obj);
        }
    }

    public static void l(int i7) {
        if (f14894f != null || f14893e) {
            throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
        }
        f14894f = Integer.valueOf(i7);
    }

    public T H() {
        return this.f14895b;
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
    public void a(com.bumptech.glide.request.c cVar) {
        j(cVar);
    }

    @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
    public com.bumptech.glide.request.c e() {
        Object objI = i();
        if (objI == null) {
            return null;
        }
        if (objI instanceof com.bumptech.glide.request.c) {
            return (com.bumptech.glide.request.c) objI;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // com.bumptech.glide.request.target.m
    public void h(k kVar) {
        this.f14896c.d(kVar);
    }

    public String toString() {
        return "Target for: " + this.f14895b;
    }
}
