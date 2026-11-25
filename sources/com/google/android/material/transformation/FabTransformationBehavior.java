package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.w;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.animation.h;
import com.google.android.material.animation.i;
import com.google.android.material.animation.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Rect f18878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RectF f18879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f18880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int[] f18881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f18882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f18883k;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f18884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f18885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f18886c;

        a(boolean z7, View view, View view2) {
            this.f18884a = z7;
            this.f18885b = view;
            this.f18886c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f18884a) {
                return;
            }
            this.f18885b.setVisibility(4);
            this.f18886c.setAlpha(1.0f);
            this.f18886c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f18884a) {
                this.f18885b.setVisibility(0);
                this.f18886c.setAlpha(0.0f);
                this.f18886c.setVisibility(4);
            }
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f18888a;

        b(View view) {
            this.f18888a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f18888a.invalidate();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f18890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f18891b;

        c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.f18890a = cVar;
            this.f18891b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f18890a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f18890a.setCircularRevealOverlayDrawable(this.f18891b);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f18893a;

        d(com.google.android.material.circularreveal.c cVar) {
            this.f18893a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            com.google.android.material.circularreveal.c.e revealInfo = this.f18893a.getRevealInfo();
            revealInfo.f17399c = Float.MAX_VALUE;
            this.f18893a.setRevealInfo(revealInfo);
        }
    }

    protected static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @o0
        public h f18895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f18896b;

        protected e() {
        }
    }

    public FabTransformationBehavior() {
        this.f18878f = new Rect();
        this.f18879g = new RectF();
        this.f18880h = new RectF();
        this.f18881i = new int[2];
    }

    @o0
    private ViewGroup N(@m0 View view) {
        View viewFindViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return i0(viewFindViewById);
        }
        return ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? i0(((ViewGroup) view).getChildAt(0)) : i0(view);
    }

    private void O(@m0 View view, @m0 e eVar, @m0 i iVar, @m0 i iVar2, float f8, float f9, float f10, float f11, @m0 RectF rectF) {
        float fV = V(eVar, iVar, f8, f10);
        float fV2 = V(eVar, iVar2, f9, f11);
        Rect rect = this.f18878f;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f18879g;
        rectF2.set(rect);
        RectF rectF3 = this.f18880h;
        W(view, rectF3);
        rectF3.offset(fV, fV2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void P(@m0 View view, @m0 RectF rectF) {
        W(view, rectF);
        rectF.offset(this.f18882j, this.f18883k);
    }

    @m0
    private Pair<i, i> Q(float f8, float f9, boolean z7, @m0 e eVar) {
        i iVarH;
        i iVarH2;
        if (f8 == 0.0f || f9 == 0.0f) {
            iVarH = eVar.f18895a.h("translationXLinear");
            iVarH2 = eVar.f18895a.h("translationYLinear");
        } else if ((!z7 || f9 >= 0.0f) && (z7 || f9 <= 0.0f)) {
            iVarH = eVar.f18895a.h("translationXCurveDownwards");
            iVarH2 = eVar.f18895a.h("translationYCurveDownwards");
        } else {
            iVarH = eVar.f18895a.h("translationXCurveUpwards");
            iVarH2 = eVar.f18895a.h("translationYCurveUpwards");
        }
        return new Pair<>(iVarH, iVarH2);
    }

    private float R(@m0 View view, @m0 View view2, @m0 j jVar) {
        RectF rectF = this.f18879g;
        RectF rectF2 = this.f18880h;
        P(view, rectF);
        W(view2, rectF2);
        rectF2.offset(-T(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float S(@m0 View view, @m0 View view2, @m0 j jVar) {
        RectF rectF = this.f18879g;
        RectF rectF2 = this.f18880h;
        P(view, rectF);
        W(view2, rectF2);
        rectF2.offset(0.0f, -U(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float T(@m0 View view, @m0 View view2, @m0 j jVar) {
        float fCenterX;
        float fCenterX2;
        float f8;
        RectF rectF = this.f18879g;
        RectF rectF2 = this.f18880h;
        P(view, rectF);
        W(view2, rectF2);
        int i7 = jVar.f16867a & 7;
        if (i7 == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else {
            if (i7 != 3) {
                if (i7 != 5) {
                    f8 = 0.0f;
                } else {
                    fCenterX = rectF2.right;
                    fCenterX2 = rectF.right;
                }
                return f8 + jVar.f16868b;
            }
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        }
        f8 = fCenterX - fCenterX2;
        return f8 + jVar.f16868b;
    }

    private float U(@m0 View view, @m0 View view2, @m0 j jVar) {
        float fCenterY;
        float fCenterY2;
        float f8;
        RectF rectF = this.f18879g;
        RectF rectF2 = this.f18880h;
        P(view, rectF);
        W(view2, rectF2);
        int i7 = jVar.f16867a & 112;
        if (i7 == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else {
            if (i7 != 48) {
                if (i7 != 80) {
                    f8 = 0.0f;
                } else {
                    fCenterY = rectF2.bottom;
                    fCenterY2 = rectF.bottom;
                }
                return f8 + jVar.f16869c;
            }
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        }
        f8 = fCenterY - fCenterY2;
        return f8 + jVar.f16869c;
    }

    private float V(@m0 e eVar, @m0 i iVar, float f8, float f9) {
        long jC = iVar.c();
        long jD = iVar.d();
        i iVarH = eVar.f18895a.h("expansion");
        return com.google.android.material.animation.a.a(f8, f9, iVar.e().getInterpolation((((iVarH.c() + iVarH.d()) + 17) - jC) / jD));
    }

    private void W(@m0 View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f18881i;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void X(View view, View view2, boolean z7, boolean z8, @m0 e eVar, @m0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupN;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.f17381o == 0) || (viewGroupN = N(view2)) == null) {
                return;
            }
            if (z7) {
                if (!z8) {
                    com.google.android.material.animation.d.f16852a.set(viewGroupN, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupN, com.google.android.material.animation.d.f16852a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupN, com.google.android.material.animation.d.f16852a, 0.0f);
            }
            eVar.f18895a.h("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(@m0 View view, View view2, boolean z7, boolean z8, @m0 e eVar, @m0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            int iG0 = g0(view);
            int i7 = 16777215 & iG0;
            if (z7) {
                if (!z8) {
                    cVar.setCircularRevealScrimColor(iG0);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, com.google.android.material.circularreveal.c.d.f17395a, i7);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(cVar, com.google.android.material.circularreveal.c.d.f17395a, iG0);
            }
            objectAnimatorOfInt.setEvaluator(com.google.android.material.animation.c.b());
            eVar.f18895a.h(w.b.f3029d).a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    private void Z(@m0 View view, @m0 View view2, boolean z7, @m0 e eVar, @m0 List<Animator> list) {
        float fT = T(view, view2, eVar.f18896b);
        float fU = U(view, view2, eVar.f18896b);
        Pair<i, i> pairQ = Q(fT, fU, z7, eVar);
        i iVar = (i) pairQ.first;
        i iVar2 = (i) pairQ.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z7) {
            fT = this.f18882j;
        }
        fArr[0] = fT;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z7) {
            fU = this.f18883k;
        }
        fArr2[0] = fU;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    @TargetApi(21)
    private void a0(View view, @m0 View view2, boolean z7, boolean z8, @m0 e eVar, @m0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float fR = n2.R(view2) - n2.R(view);
        if (z7) {
            if (!z8) {
                view2.setTranslationZ(-fR);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -fR);
        }
        eVar.f18895a.h("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b0(@m0 View view, View view2, boolean z7, boolean z8, @m0 e eVar, float f8, float f9, @m0 List<Animator> list, @m0 List<Animator.AnimatorListener> list2) {
        Animator animatorA;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            float fR = R(view, view2, eVar.f18896b);
            float fS = S(view, view2, eVar.f18896b);
            ((FloatingActionButton) view).k(this.f18878f);
            float fWidth = this.f18878f.width() / 2.0f;
            i iVarH = eVar.f18895a.h("expansion");
            if (z7) {
                if (!z8) {
                    cVar.setRevealInfo(new com.google.android.material.circularreveal.c.e(fR, fS, fWidth));
                }
                if (z8) {
                    fWidth = cVar.getRevealInfo().f17399c;
                }
                animatorA = com.google.android.material.circularreveal.a.a(cVar, fR, fS, p1.a.b(fR, fS, 0.0f, 0.0f, f8, f9));
                animatorA.addListener(new d(cVar));
                e0(view2, iVarH.c(), (int) fR, (int) fS, fWidth, list);
            } else {
                float f10 = cVar.getRevealInfo().f17399c;
                Animator animatorA2 = com.google.android.material.circularreveal.a.a(cVar, fR, fS, fWidth);
                int i7 = (int) fR;
                int i8 = (int) fS;
                e0(view2, iVarH.c(), i7, i8, f10, list);
                d0(view2, iVarH.c(), iVarH.d(), eVar.f18895a.i(), i7, i8, fWidth, list);
                animatorA = animatorA2;
            }
            iVarH.a(animatorA);
            list.add(animatorA);
            list2.add(com.google.android.material.circularreveal.a.c(cVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void c0(View view, View view2, boolean z7, boolean z8, @m0 e eVar, @m0 List<Animator> list, @m0 List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z7) {
                if (!z8) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, com.google.android.material.animation.e.f16853b, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, com.google.android.material.animation.e.f16853b, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new b(view2));
            eVar.f18895a.h("iconFade").a(objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new c(cVar, drawable));
        }
    }

    private void d0(View view, long j7, long j8, long j9, int i7, int i8, float f8, @m0 List<Animator> list) {
        long j10 = j7 + j8;
        if (j10 < j9) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i7, i8, f8, f8);
            animatorCreateCircularReveal.setStartDelay(j10);
            animatorCreateCircularReveal.setDuration(j9 - j10);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void e0(View view, long j7, int i7, int i8, float f8, @m0 List<Animator> list) {
        if (j7 > 0) {
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i7, i8, f8, f8);
            animatorCreateCircularReveal.setStartDelay(0L);
            animatorCreateCircularReveal.setDuration(j7);
            list.add(animatorCreateCircularReveal);
        }
    }

    private void f0(@m0 View view, @m0 View view2, boolean z7, boolean z8, @m0 e eVar, @m0 List<Animator> list, List<Animator.AnimatorListener> list2, @m0 RectF rectF) {
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fT = T(view, view2, eVar.f18896b);
        float fU = U(view, view2, eVar.f18896b);
        Pair<i, i> pairQ = Q(fT, fU, z7, eVar);
        i iVar = (i) pairQ.first;
        i iVar2 = (i) pairQ.second;
        if (z7) {
            if (!z8) {
                view2.setTranslationX(-fT);
                view2.setTranslationY(-fU);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            O(view2, eVar, iVar, iVar2, -fT, -fU, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fT);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fU);
        }
        iVar.a(objectAnimatorOfFloat);
        iVar2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    private int g0(@m0 View view) {
        ColorStateList colorStateListN = n2.N(view);
        if (colorStateListN != null) {
            return colorStateListN.getColorForState(view.getDrawableState(), colorStateListN.getDefaultColor());
        }
        return 0;
    }

    @o0
    private ViewGroup i0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @m0
    protected AnimatorSet M(@m0 View view, @m0 View view2, boolean z7, boolean z8) {
        e eVarH0 = h0(view2.getContext(), z7);
        if (z7) {
            this.f18882j = view.getTranslationX();
            this.f18883k = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        a0(view, view2, z7, z8, eVarH0, arrayList, arrayList2);
        RectF rectF = this.f18879g;
        f0(view, view2, z7, z8, eVarH0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        Z(view, view2, z7, eVarH0, arrayList);
        c0(view, view2, z7, z8, eVarH0, arrayList, arrayList2);
        b0(view, view2, z7, z8, eVarH0, fWidth, fHeight, arrayList, arrayList2);
        Y(view, view2, z7, z8, eVarH0, arrayList, arrayList2);
        X(view, view2, z7, z8, eVarH0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z7, view2, view));
        int size = arrayList2.size();
        for (int i7 = 0; i7 < size; i7++) {
            animatorSet.addListener(arrayList2.get(i7));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @c.i
    public boolean f(@m0 CoordinatorLayout coordinatorLayout, @m0 View view, @m0 View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @c.i
    public void h(@m0 CoordinatorLayout.f fVar) {
        if (fVar.f5014h == 0) {
            fVar.f5014h = 80;
        }
    }

    protected abstract e h0(Context context, boolean z7);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18878f = new Rect();
        this.f18879g = new RectF();
        this.f18880h = new RectF();
        this.f18881i = new int[2];
    }
}
