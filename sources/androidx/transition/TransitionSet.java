package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class TransitionSet extends Transition {
    private static final int B0 = 1;
    private static final int C0 = 2;
    private static final int D0 = 4;
    private static final int E0 = 8;
    public static final int F0 = 0;
    public static final int G0 = 1;
    private int A0;
    private ArrayList<Transition> W;
    private boolean X;
    int Y;
    boolean Z;

    class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Transition f10644a;

        a(Transition transition) {
            this.f10644a = transition;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            this.f10644a.r0();
            transition.j0(this);
        }
    }

    static class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TransitionSet f10646a;

        b(TransitionSet transitionSet) {
            this.f10646a = transitionSet;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void a(@c.m0 Transition transition) {
            TransitionSet transitionSet = this.f10646a;
            if (transitionSet.Z) {
                return;
            }
            transitionSet.B0();
            this.f10646a.Z = true;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            TransitionSet transitionSet = this.f10646a;
            int i7 = transitionSet.Y - 1;
            transitionSet.Y = i7;
            if (i7 == 0) {
                transitionSet.Z = false;
                transitionSet.t();
            }
            transition.j0(this);
        }
    }

    public TransitionSet() {
        this.W = new ArrayList<>();
        this.X = true;
        this.Z = false;
        this.A0 = 0;
    }

    private void J0(@c.m0 Transition transition) {
        this.W.add(transition);
        transition.f10627r = this;
    }

    private void Y0() {
        b bVar = new b(this);
        Iterator<Transition> it = this.W.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.Y = this.W.size();
    }

    @Override // androidx.transition.Transition
    @c.m0
    public Transition A(@c.m0 View view, boolean z7) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).A(view, z7);
        }
        return super.A(view, z7);
    }

    @Override // androidx.transition.Transition
    @c.m0
    public Transition B(@c.m0 Class<?> cls, boolean z7) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).B(cls, z7);
        }
        return super.B(cls, z7);
    }

    @Override // androidx.transition.Transition
    @c.m0
    public Transition C(@c.m0 String str, boolean z7) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).C(str, z7);
        }
        return super.C(str, z7);
    }

    @Override // androidx.transition.Transition
    String C0(String str) {
        String strC0 = super.C0(str);
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strC0);
            sb.append("\n");
            sb.append(this.W.get(i7).C0(str + "  "));
            strC0 = sb.toString();
        }
        return strC0;
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public TransitionSet a(@c.m0 Transition.h hVar) {
        return (TransitionSet) super.a(hVar);
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public TransitionSet b(@c.b0 int i7) {
        for (int i8 = 0; i8 < this.W.size(); i8++) {
            this.W.get(i8).b(i7);
        }
        return (TransitionSet) super.b(i7);
    }

    @Override // androidx.transition.Transition
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void F(ViewGroup viewGroup) {
        super.F(viewGroup);
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).F(viewGroup);
        }
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public TransitionSet c(@c.m0 View view) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).c(view);
        }
        return (TransitionSet) super.c(view);
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public TransitionSet d(@c.m0 Class<?> cls) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).d(cls);
        }
        return (TransitionSet) super.d(cls);
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public TransitionSet e(@c.m0 String str) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).e(str);
        }
        return (TransitionSet) super.e(str);
    }

    @c.m0
    public TransitionSet I0(@c.m0 Transition transition) {
        J0(transition);
        long j7 = this.f10612c;
        if (j7 >= 0) {
            transition.t0(j7);
        }
        if ((this.A0 & 1) != 0) {
            transition.v0(J());
        }
        if ((this.A0 & 2) != 0) {
            transition.y0(O());
        }
        if ((this.A0 & 4) != 0) {
            transition.x0(N());
        }
        if ((this.A0 & 8) != 0) {
            transition.u0(I());
        }
        return this;
    }

    public int K0() {
        return !this.X ? 1 : 0;
    }

    @c.o0
    public Transition L0(int i7) {
        if (i7 < 0 || i7 >= this.W.size()) {
            return null;
        }
        return this.W.get(i7);
    }

    public int M0() {
        return this.W.size();
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public TransitionSet j0(@c.m0 Transition.h hVar) {
        return (TransitionSet) super.j0(hVar);
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public TransitionSet k0(@c.b0 int i7) {
        for (int i8 = 0; i8 < this.W.size(); i8++) {
            this.W.get(i8).k0(i7);
        }
        return (TransitionSet) super.k0(i7);
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public TransitionSet l0(@c.m0 View view) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).l0(view);
        }
        return (TransitionSet) super.l0(view);
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public TransitionSet m0(@c.m0 Class<?> cls) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).m0(cls);
        }
        return (TransitionSet) super.m0(cls);
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public TransitionSet n0(@c.m0 String str) {
        for (int i7 = 0; i7 < this.W.size(); i7++) {
            this.W.get(i7).n0(str);
        }
        return (TransitionSet) super.n0(str);
    }

    @c.m0
    public TransitionSet S0(@c.m0 Transition transition) {
        this.W.remove(transition);
        transition.f10627r = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public TransitionSet t0(long j7) {
        ArrayList<Transition> arrayList;
        super.t0(j7);
        if (this.f10612c >= 0 && (arrayList = this.W) != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.W.get(i7).t0(j7);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public TransitionSet v0(@c.o0 TimeInterpolator timeInterpolator) {
        this.A0 |= 1;
        ArrayList<Transition> arrayList = this.W;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.W.get(i7).v0(timeInterpolator);
            }
        }
        return (TransitionSet) super.v0(timeInterpolator);
    }

    @c.m0
    public TransitionSet V0(int i7) {
        if (i7 == 0) {
            this.X = true;
        } else {
            if (i7 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i7);
            }
            this.X = false;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public TransitionSet z0(ViewGroup viewGroup) {
        super.z0(viewGroup);
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).z0(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @c.m0
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public TransitionSet A0(long j7) {
        return (TransitionSet) super.A0(j7);
    }

    @Override // androidx.transition.Transition
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        super.cancel();
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).cancel();
        }
    }

    @Override // androidx.transition.Transition
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void h0(View view) {
        super.h0(view);
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).h0(view);
        }
    }

    @Override // androidx.transition.Transition
    public void k(@c.m0 d0 d0Var) {
        if (Z(d0Var.f10675b)) {
            for (Transition transition : this.W) {
                if (transition.Z(d0Var.f10675b)) {
                    transition.k(d0Var);
                    d0Var.f10676c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    void m(d0 d0Var) {
        super.m(d0Var);
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).m(d0Var);
        }
    }

    @Override // androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        if (Z(d0Var.f10675b)) {
            for (Transition transition : this.W) {
                if (transition.Z(d0Var.f10675b)) {
                    transition.n(d0Var);
                    d0Var.f10676c.add(transition);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void o0(View view) {
        super.o0(view);
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).o0(view);
        }
    }

    @Override // androidx.transition.Transition
    /* JADX INFO: renamed from: q */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.W = new ArrayList<>();
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            transitionSet.J0(this.W.get(i7).clone());
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void r0() {
        if (this.W.isEmpty()) {
            B0();
            t();
            return;
        }
        Y0();
        if (this.X) {
            Iterator<Transition> it = this.W.iterator();
            while (it.hasNext()) {
                it.next().r0();
            }
            return;
        }
        for (int i7 = 1; i7 < this.W.size(); i7++) {
            this.W.get(i7 - 1).a(new a(this.W.get(i7)));
        }
        Transition transition = this.W.get(0);
        if (transition != null) {
            transition.r0();
        }
    }

    @Override // androidx.transition.Transition
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    protected void s(ViewGroup viewGroup, e0 e0Var, e0 e0Var2, ArrayList<d0> arrayList, ArrayList<d0> arrayList2) {
        long jQ = Q();
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            Transition transition = this.W.get(i7);
            if (jQ > 0 && (this.X || i7 == 0)) {
                long jQ2 = transition.Q();
                if (jQ2 > 0) {
                    transition.A0(jQ2 + jQ);
                } else {
                    transition.A0(jQ);
                }
            }
            transition.s(viewGroup, e0Var, e0Var2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    void s0(boolean z7) {
        super.s0(z7);
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).s0(z7);
        }
    }

    @Override // androidx.transition.Transition
    public void u0(Transition.f fVar) {
        super.u0(fVar);
        this.A0 |= 8;
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).u0(fVar);
        }
    }

    @Override // androidx.transition.Transition
    public void x0(PathMotion pathMotion) {
        super.x0(pathMotion);
        this.A0 |= 4;
        if (this.W != null) {
            for (int i7 = 0; i7 < this.W.size(); i7++) {
                this.W.get(i7).x0(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void y0(a0 a0Var) {
        super.y0(a0Var);
        this.A0 |= 2;
        int size = this.W.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.W.get(i7).y0(a0Var);
        }
    }

    @Override // androidx.transition.Transition
    @c.m0
    public Transition z(int i7, boolean z7) {
        for (int i8 = 0; i8 < this.W.size(); i8++) {
            this.W.get(i8).z(i7, z7);
        }
        return super.z(i7, z7);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = new ArrayList<>();
        this.X = true;
        this.Z = false;
        this.A0 = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10790i);
        V0(androidx.core.content.res.q.k(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
