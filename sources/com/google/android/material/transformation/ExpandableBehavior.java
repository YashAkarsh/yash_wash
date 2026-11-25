package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n2;
import c.i;
import c.m0;
import c.o0;
import java.util.List;
import o1.b;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f18868b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f18869c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f18870d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18871a;

    class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f18872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f18874c;

        a(View view, int i7, b bVar) {
            this.f18872a = view;
            this.f18873b = i7;
            this.f18874c = bVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f18872a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f18871a == this.f18873b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                b bVar = this.f18874c;
                expandableBehavior.K((View) bVar, this.f18872a, bVar.b(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f18871a = 0;
    }

    private boolean H(boolean z7) {
        if (!z7) {
            return this.f18871a == 1;
        }
        int i7 = this.f18871a;
        return i7 == 0 || i7 == 2;
    }

    @o0
    public static <T extends ExpandableBehavior> T J(@m0 View view, @m0 Class<T> cls) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.f)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorF = ((CoordinatorLayout.f) layoutParams).f();
        if (behaviorF instanceof ExpandableBehavior) {
            return cls.cast(behaviorF);
        }
        throw new IllegalArgumentException("The view is not associated with ExpandableBehavior");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @o0
    protected b I(@m0 CoordinatorLayout coordinatorLayout, @m0 View view) {
        List<View> listW = coordinatorLayout.w(view);
        int size = listW.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = listW.get(i7);
            if (f(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }

    protected abstract boolean K(View view, View view2, boolean z7, boolean z8);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean f(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @i
    public boolean i(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!H(bVar.b())) {
            return false;
        }
        this.f18871a = bVar.b() ? 1 : 2;
        return K((View) bVar, view, bVar.b(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @i
    public boolean m(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, int i7) {
        b bVarI;
        if (n2.U0(view) || (bVarI = I(coordinatorLayout, view)) == null || !H(bVarI.b())) {
            return false;
        }
        int i8 = bVarI.b() ? 1 : 2;
        this.f18871a = i8;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i8, bVarI));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18871a = 0;
    }
}
