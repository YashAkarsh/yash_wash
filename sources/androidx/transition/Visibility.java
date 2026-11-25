package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final int A0 = 1;
    public static final int B0 = 2;
    private static final String Z = "android:visibility:screenLocation";
    private int W;
    static final String X = "android:visibility:visibility";
    private static final String Y = "android:visibility:parent";
    private static final String[] C0 = {X, Y};

    class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f10648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f10649c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f10647a = viewGroup;
            this.f10648b = view;
            this.f10649c = view2;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void b(@c.m0 Transition transition) {
            l0.b(this.f10647a).d(this.f10648b);
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            this.f10649c.setTag(R.id.save_overlay_view, null);
            l0.b(this.f10647a).d(this.f10648b);
            transition.j0(this);
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void e(@c.m0 Transition transition) {
            if (this.f10648b.getParent() == null) {
                l0.b(this.f10647a).c(this.f10648b);
            } else {
                Visibility.this.cancel();
            }
        }
    }

    private static class b extends AnimatorListenerAdapter implements Transition.h, androidx.transition.a.InterfaceC0128a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f10651a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10652b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ViewGroup f10653c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f10654d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f10655e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f10656f = false;

        b(View view, int i7, boolean z7) {
            this.f10651a = view;
            this.f10652b = i7;
            this.f10653c = (ViewGroup) view.getParent();
            this.f10654d = z7;
            g(true);
        }

        private void f() {
            if (!this.f10656f) {
                q0.i(this.f10651a, this.f10652b);
                ViewGroup viewGroup = this.f10653c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z7) {
            ViewGroup viewGroup;
            if (!this.f10654d || this.f10655e == z7 || (viewGroup = this.f10653c) == null) {
                return;
            }
            this.f10655e = z7;
            l0.d(viewGroup, z7);
        }

        @Override // androidx.transition.Transition.h
        public void a(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void b(@c.m0 Transition transition) {
            g(false);
        }

        @Override // androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            f();
            transition.j0(this);
        }

        @Override // androidx.transition.Transition.h
        public void d(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void e(@c.m0 Transition transition) {
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10656f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0128a
        public void onAnimationPause(Animator animator) {
            if (this.f10656f) {
                return;
            }
            q0.i(this.f10651a, this.f10652b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.a.InterfaceC0128a
        public void onAnimationResume(Animator animator) {
            if (this.f10656f) {
                return;
            }
            q0.i(this.f10651a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f10657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f10658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f10659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f10660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ViewGroup f10661e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ViewGroup f10662f;

        d() {
        }
    }

    public Visibility() {
        this.W = 3;
    }

    private void D0(d0 d0Var) {
        d0Var.f10674a.put(X, Integer.valueOf(d0Var.f10675b.getVisibility()));
        d0Var.f10674a.put(Y, d0Var.f10675b.getParent());
        int[] iArr = new int[2];
        d0Var.f10675b.getLocationOnScreen(iArr);
        d0Var.f10674a.put(Z, iArr);
    }

    private d F0(d0 d0Var, d0 d0Var2) {
        d dVar = new d();
        dVar.f10657a = false;
        dVar.f10658b = false;
        if (d0Var == null || !d0Var.f10674a.containsKey(X)) {
            dVar.f10659c = -1;
            dVar.f10661e = null;
        } else {
            dVar.f10659c = ((Integer) d0Var.f10674a.get(X)).intValue();
            dVar.f10661e = (ViewGroup) d0Var.f10674a.get(Y);
        }
        if (d0Var2 == null || !d0Var2.f10674a.containsKey(X)) {
            dVar.f10660d = -1;
            dVar.f10662f = null;
        } else {
            dVar.f10660d = ((Integer) d0Var2.f10674a.get(X)).intValue();
            dVar.f10662f = (ViewGroup) d0Var2.f10674a.get(Y);
        }
        if (d0Var != null && d0Var2 != null) {
            int i7 = dVar.f10659c;
            int i8 = dVar.f10660d;
            if (i7 == i8 && dVar.f10661e == dVar.f10662f) {
                return dVar;
            }
            if (i7 != i8) {
                if (i7 == 0) {
                    dVar.f10658b = false;
                    dVar.f10657a = true;
                } else if (i8 == 0) {
                    dVar.f10658b = true;
                    dVar.f10657a = true;
                }
            } else if (dVar.f10662f == null) {
                dVar.f10658b = false;
                dVar.f10657a = true;
            } else if (dVar.f10661e == null) {
                dVar.f10658b = true;
                dVar.f10657a = true;
            }
        } else if (d0Var == null && dVar.f10660d == 0) {
            dVar.f10658b = true;
            dVar.f10657a = true;
        } else if (d0Var2 == null && dVar.f10659c == 0) {
            dVar.f10658b = false;
            dVar.f10657a = true;
        }
        return dVar;
    }

    public int E0() {
        return this.W;
    }

    public boolean G0(d0 d0Var) {
        if (d0Var == null) {
            return false;
        }
        return ((Integer) d0Var.f10674a.get(X)).intValue() == 0 && ((View) d0Var.f10674a.get(Y)) != null;
    }

    public Animator H0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        return null;
    }

    public Animator I0(ViewGroup viewGroup, d0 d0Var, int i7, d0 d0Var2, int i8) {
        if ((this.W & 1) != 1 || d0Var2 == null) {
            return null;
        }
        if (d0Var == null) {
            View view = (View) d0Var2.f10675b.getParent();
            if (F0(L(view, false), W(view, false)).f10657a) {
                return null;
            }
        }
        return H0(viewGroup, d0Var2.f10675b, d0Var, d0Var2);
    }

    public Animator J0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003b  */
    public Animator K0(ViewGroup viewGroup, d0 d0Var, int i7, d0 d0Var2, int i8) {
        View view;
        boolean z7;
        boolean z8;
        View view2;
        if ((this.W & 2) != 2 || d0Var == null) {
            return null;
        }
        View view3 = d0Var.f10675b;
        View viewA = d0Var2 != null ? d0Var2.f10675b : null;
        View view4 = (View) view3.getTag(R.id.save_overlay_view);
        if (view4 != null) {
            view2 = null;
            z8 = true;
        } else {
            if (viewA == null || viewA.getParent() == null) {
                if (viewA != null) {
                    view = null;
                    z7 = false;
                } else {
                    viewA = null;
                    view = null;
                    z7 = true;
                }
            } else if (i8 == 4 || view3 == viewA) {
                view = viewA;
                z7 = false;
                viewA = null;
            } else {
                viewA = null;
                view = null;
                z7 = true;
            }
            if (z7) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (F0(W(view5, true), L(view5, true)).f10657a) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.f10632w) {
                            }
                        } else {
                            viewA = c0.a(viewGroup, view3, view5);
                        }
                    }
                    z8 = false;
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                }
                view2 = view;
                z8 = false;
                view4 = view3;
            } else {
                z8 = false;
                View view7 = view;
                view4 = viewA;
                view2 = view7;
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            q0.i(view2, 0);
            Animator animatorJ0 = J0(viewGroup, view2, d0Var, d0Var2);
            if (animatorJ0 != null) {
                b bVar = new b(view2, i8, true);
                animatorJ0.addListener(bVar);
                androidx.transition.a.a(animatorJ0, bVar);
                a(bVar);
            } else {
                q0.i(view2, visibility);
            }
            return animatorJ0;
        }
        if (!z8) {
            int[] iArr = (int[]) d0Var.f10674a.get(Z);
            int i9 = iArr[0];
            int i10 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i9 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i10 - iArr2[1]) - view4.getTop());
            l0.b(viewGroup).c(view4);
        }
        Animator animatorJ1 = J0(viewGroup, view4, d0Var, d0Var2);
        if (!z8) {
            if (animatorJ1 == null) {
                l0.b(viewGroup).d(view4);
            } else {
                view3.setTag(R.id.save_overlay_view, view4);
                a(new a(viewGroup, view4, view3));
            }
        }
        return animatorJ1;
    }

    public void L0(int i7) {
        if ((i7 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.W = i7;
    }

    @Override // androidx.transition.Transition
    @c.o0
    public String[] V() {
        return C0;
    }

    @Override // androidx.transition.Transition
    public boolean X(d0 d0Var, d0 d0Var2) {
        if (d0Var == null && d0Var2 == null) {
            return false;
        }
        if (d0Var != null && d0Var2 != null && d0Var2.f10674a.containsKey(X) != d0Var.f10674a.containsKey(X)) {
            return false;
        }
        d dVarF0 = F0(d0Var, d0Var2);
        if (dVarF0.f10657a) {
            return dVarF0.f10659c == 0 || dVarF0.f10660d == 0;
        }
        return false;
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
        d dVarF0 = F0(d0Var, d0Var2);
        if (!dVarF0.f10657a) {
            return null;
        }
        if (dVarF0.f10661e == null && dVarF0.f10662f == null) {
            return null;
        }
        return dVarF0.f10658b ? I0(viewGroup, d0Var, dVarF0.f10659c, d0Var2, dVarF0.f10660d) : K0(viewGroup, d0Var, dVarF0.f10659c, d0Var2, dVarF0.f10660d);
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10786e);
        int iK = androidx.core.content.res.q.k(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (iK != 0) {
            L0(iK);
        }
    }
}
