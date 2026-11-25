package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class k extends ViewGroup implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ViewGroup f10733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f10734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f10735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f10736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.o0
    private Matrix f10737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f10738f;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            n2.n1(k.this);
            k kVar = k.this;
            ViewGroup viewGroup = kVar.f10733a;
            if (viewGroup == null || (view = kVar.f10734b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            n2.n1(k.this.f10733a);
            k kVar2 = k.this;
            kVar2.f10733a = null;
            kVar2.f10734b = null;
            return true;
        }
    }

    k(View view) {
        super(view.getContext());
        this.f10738f = new a();
        this.f10735c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    static k b(View view, ViewGroup viewGroup, Matrix matrix) {
        int i7;
        i iVar;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        i iVarB = i.b(viewGroup);
        k kVarE = e(view);
        if (kVarE == null || (iVar = (i) kVarE.getParent()) == iVarB) {
            i7 = 0;
        } else {
            i7 = kVarE.f10736d;
            iVar.removeView(kVarE);
            kVarE = null;
        }
        if (kVarE == null) {
            if (matrix == null) {
                matrix = new Matrix();
                c(view, viewGroup, matrix);
            }
            kVarE = new k(view);
            kVarE.h(matrix);
            if (iVarB == null) {
                iVarB = new i(viewGroup);
            } else {
                iVarB.g();
            }
            d(viewGroup, iVarB);
            d(viewGroup, kVarE);
            iVarB.a(kVarE);
            kVarE.f10736d = i7;
        } else if (matrix != null) {
            kVarE.h(matrix);
        }
        kVarE.f10736d++;
        return kVarE;
    }

    static void c(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        q0.j(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        q0.k(viewGroup, matrix);
    }

    static void d(View view, View view2) {
        q0.g(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static k e(View view) {
        return (k) view.getTag(R.id.ghost_view);
    }

    static void f(View view) {
        k kVarE = e(view);
        if (kVarE != null) {
            int i7 = kVarE.f10736d - 1;
            kVarE.f10736d = i7;
            if (i7 <= 0) {
                ((i) kVarE.getParent()).removeView(kVarE);
            }
        }
    }

    static void g(@c.m0 View view, @c.o0 k kVar) {
        view.setTag(R.id.ghost_view, kVar);
    }

    @Override // androidx.transition.h
    public void a(ViewGroup viewGroup, View view) {
        this.f10733a = viewGroup;
        this.f10734b = view;
    }

    void h(@c.m0 Matrix matrix) {
        this.f10737e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g(this.f10735c, this);
        this.f10735c.getViewTreeObserver().addOnPreDrawListener(this.f10738f);
        q0.i(this.f10735c, 4);
        if (this.f10735c.getParent() != null) {
            ((View) this.f10735c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f10735c.getViewTreeObserver().removeOnPreDrawListener(this.f10738f);
        q0.i(this.f10735c, 0);
        g(this.f10735c, null);
        if (this.f10735c.getParent() != null) {
            ((View) this.f10735c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        d.a(canvas, true);
        canvas.setMatrix(this.f10737e);
        q0.i(this.f10735c, 0);
        this.f10735c.invalidate();
        q0.i(this.f10735c, 4);
        drawChild(canvas, this.f10735c, getDrawingTime());
        d.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
    }

    @Override // android.view.View, androidx.transition.h
    public void setVisibility(int i7) {
        super.setVisibility(i7);
        if (e(this.f10735c) == this) {
            q0.i(this.f10735c, i7 == 0 ? 4 : 0);
        }
    }
}
