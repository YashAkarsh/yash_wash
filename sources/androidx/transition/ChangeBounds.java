package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n2;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private int[] W;
    private boolean X;
    private boolean Y;
    private static final String Z = "android:changeBounds:bounds";
    private static final String A0 = "android:changeBounds:clip";
    private static final String B0 = "android:changeBounds:parent";
    private static final String C0 = "android:changeBounds:windowX";
    private static final String D0 = "android:changeBounds:windowY";
    private static final String[] E0 = {Z, A0, B0, C0, D0};
    private static final Property<Drawable, PointF> F0 = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> G0 = new c(PointF.class, "topLeft");
    private static final Property<k, PointF> H0 = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> I0 = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> J0 = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> K0 = new g(PointF.class, "position");
    private static t L0 = new t();

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f10551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f10552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f10553d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f8) {
            this.f10550a = viewGroup;
            this.f10551b = bitmapDrawable;
            this.f10552c = view;
            this.f10553d = f8;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            q0.b(this.f10550a).b(this.f10551b);
            q0.h(this.f10552c, this.f10553d);
        }
    }

    static class b extends Property<Drawable, PointF> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Rect f10555a;

        b(Class cls, String str) {
            super(cls, str);
            this.f10555a = new Rect();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f10555a);
            Rect rect = this.f10555a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f10555a);
            this.f10555a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f10555a);
        }
    }

    static class c extends Property<k, PointF> {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            q0.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            q0.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            q0.g(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f10556a;
        private k mViewBounds;

        h(k kVar) {
            this.f10556a = kVar;
            this.mViewBounds = kVar;
        }
    }

    class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f10559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f10560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f10561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10562e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f10563f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10564g;

        i(View view, Rect rect, int i7, int i8, int i9, int i10) {
            this.f10559b = view;
            this.f10560c = rect;
            this.f10561d = i7;
            this.f10562e = i8;
            this.f10563f = i9;
            this.f10564g = i10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10558a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f10558a) {
                return;
            }
            n2.M1(this.f10559b, this.f10560c);
            q0.g(this.f10559b, this.f10561d, this.f10562e, this.f10563f, this.f10564g);
        }
    }

    class j extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f10566a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10567b;

        j(ViewGroup viewGroup) {
            this.f10567b = viewGroup;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void b(@c.m0 Transition transition) {
            l0.d(this.f10567b, false);
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            if (!this.f10566a) {
                l0.d(this.f10567b, false);
            }
            transition.j0(this);
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void d(@c.m0 Transition transition) {
            l0.d(this.f10567b, false);
            this.f10566a = true;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void e(@c.m0 Transition transition) {
            l0.d(this.f10567b, true);
        }
    }

    private static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f10571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f10572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f10573e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f10574f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f10575g;

        k(View view) {
            this.f10573e = view;
        }

        private void b() {
            q0.g(this.f10573e, this.f10569a, this.f10570b, this.f10571c, this.f10572d);
            this.f10574f = 0;
            this.f10575g = 0;
        }

        void a(PointF pointF) {
            this.f10571c = Math.round(pointF.x);
            this.f10572d = Math.round(pointF.y);
            int i7 = this.f10575g + 1;
            this.f10575g = i7;
            if (this.f10574f == i7) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f10569a = Math.round(pointF.x);
            this.f10570b = Math.round(pointF.y);
            int i7 = this.f10574f + 1;
            this.f10574f = i7;
            if (i7 == this.f10575g) {
                b();
            }
        }
    }

    public ChangeBounds() {
        this.W = new int[2];
        this.X = false;
        this.Y = false;
    }

    private void D0(d0 d0Var) {
        View view = d0Var.f10675b;
        if (!n2.U0(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        d0Var.f10674a.put(Z, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        d0Var.f10674a.put(B0, d0Var.f10675b.getParent());
        if (this.Y) {
            d0Var.f10675b.getLocationInWindow(this.W);
            d0Var.f10674a.put(C0, Integer.valueOf(this.W[0]));
            d0Var.f10674a.put(D0, Integer.valueOf(this.W[1]));
        }
        if (this.X) {
            d0Var.f10674a.put(A0, n2.P(view));
        }
    }

    private boolean F0(View view, View view2) {
        if (!this.Y) {
            return true;
        }
        d0 d0VarL = L(view, true);
        if (d0VarL == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == d0VarL.f10675b) {
            return true;
        }
        return false;
    }

    public boolean E0() {
        return this.X;
    }

    public void G0(boolean z7) {
        this.X = z7;
    }

    @Override // androidx.transition.Transition
    @c.o0
    public String[] V() {
        return E0;
    }

    @Override // androidx.transition.Transition
    public void k(@c.m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        D0(d0Var);
    }

    @Override // androidx.transition.Transition
    @c.o0
    public Animator r(@c.m0 ViewGroup viewGroup, @c.o0 d0 d0Var, @c.o0 d0 d0Var2) {
        int i7;
        View view;
        ObjectAnimator objectAnimatorA;
        int i8;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (d0Var == null || d0Var2 == null) {
            return null;
        }
        Map<String, Object> map = d0Var.f10674a;
        Map<String, Object> map2 = d0Var2.f10674a;
        ViewGroup viewGroup2 = (ViewGroup) map.get(B0);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(B0);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = d0Var2.f10675b;
        if (!F0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) d0Var.f10674a.get(C0)).intValue();
            int iIntValue2 = ((Integer) d0Var.f10674a.get(D0)).intValue();
            int iIntValue3 = ((Integer) d0Var2.f10674a.get(C0)).intValue();
            int iIntValue4 = ((Integer) d0Var2.f10674a.get(D0)).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.W);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = q0.c(view2);
            q0.h(view2, 0.0f);
            q0.b(viewGroup).a(bitmapDrawable);
            PathMotion pathMotionN = N();
            int[] iArr = this.W;
            int i9 = iArr[0];
            int i10 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, s.a(F0, pathMotionN.a(iIntValue - i9, iIntValue2 - i10, iIntValue3 - i9, iIntValue4 - i10)));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect2 = (Rect) d0Var.f10674a.get(Z);
        Rect rect3 = (Rect) d0Var2.f10674a.get(Z);
        int i11 = rect2.left;
        int i12 = rect3.left;
        int i13 = rect2.top;
        int i14 = rect3.top;
        int i15 = rect2.right;
        int i16 = rect3.right;
        int i17 = rect2.bottom;
        int i18 = rect3.bottom;
        int i19 = i15 - i11;
        int i20 = i17 - i13;
        int i21 = i16 - i12;
        int i22 = i18 - i14;
        Rect rect4 = (Rect) d0Var.f10674a.get(A0);
        Rect rect5 = (Rect) d0Var2.f10674a.get(A0);
        if ((i19 == 0 || i20 == 0) && (i21 == 0 || i22 == 0)) {
            i7 = 0;
        } else {
            i7 = (i11 == i12 && i13 == i14) ? 0 : 1;
            if (i15 != i16 || i17 != i18) {
                i7++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i7++;
        }
        if (i7 <= 0) {
            return null;
        }
        if (this.X) {
            q0.g(view, i11, i13, Math.max(i19, i21) + i11, Math.max(i20, i22) + i13);
            if (i11 == i12 && i13 == i14) {
                objectAnimatorA = null;
            } else {
                view = view2;
                objectAnimatorA = p.a(view, K0, N().a(i11, i13, i12, i14));
            }
            if (rect4 == null) {
                i8 = 0;
                rect = new Rect(0, 0, i19, i20);
            } else {
                i8 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i8, i8, i21, i22) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                n2.M1(view, rect);
                t tVar = L0;
                Object[] objArr = new Object[2];
                objArr[i8] = rect;
                objArr[1] = rect6;
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", tVar, objArr);
                objectAnimatorOfObject.addListener(new i(view, rect5, i12, i14, i16, i18));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = c0.c(objectAnimatorA, objectAnimator);
        } else {
            q0.g(view, i11, i13, i15, i17);
            if (i7 != 2) {
                animatorC = (i11 == i12 && i13 == i14) ? p.a(view, I0, N().a(i15, i17, i16, i18)) : p.a(view, J0, N().a(i11, i13, i12, i14));
            } else if (i19 == i21 && i20 == i22) {
                animatorC = p.a(view, K0, N().a(i11, i13, i12, i14));
            } else {
                k kVar = new k(view);
                ObjectAnimator objectAnimatorA2 = p.a(kVar, G0, N().a(i11, i13, i12, i14));
                ObjectAnimator objectAnimatorA3 = p.a(kVar, H0, N().a(i15, i17, i16, i18));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new h(kVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            l0.d(viewGroup4, true);
            a(new j(viewGroup4));
        }
        return animatorC;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = new int[2];
        this.X = false;
        this.Y = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10785d);
        boolean zE = androidx.core.content.res.q.e(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        G0(zE);
    }
}
