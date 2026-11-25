package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
@SuppressLint({"RestrictedApi"})
public class g extends androidx.fragment.app.y {

    class a extends Transition.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f10703a;

        a(Rect rect) {
            this.f10703a = rect;
        }

        @Override // androidx.transition.Transition.f
        public Rect a(@c.m0 Transition transition) {
            return this.f10703a;
        }
    }

    class b implements Transition.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f10705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f10706b;

        b(View view, ArrayList arrayList) {
            this.f10705a = view;
            this.f10706b = arrayList;
        }

        @Override // androidx.transition.Transition.h
        public void a(@c.m0 Transition transition) {
            transition.j0(this);
            transition.a(this);
        }

        @Override // androidx.transition.Transition.h
        public void b(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            transition.j0(this);
            this.f10705a.setVisibility(8);
            int size = this.f10706b.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((View) this.f10706b.get(i7)).setVisibility(0);
            }
        }

        @Override // androidx.transition.Transition.h
        public void d(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void e(@c.m0 Transition transition) {
        }
    }

    class c extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f10708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f10709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f10710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f10711d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f10712e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f10713f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f10708a = obj;
            this.f10709b = arrayList;
            this.f10710c = obj2;
            this.f10711d = arrayList2;
            this.f10712e = obj3;
            this.f10713f = arrayList3;
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void a(@c.m0 Transition transition) {
            Object obj = this.f10708a;
            if (obj != null) {
                g.this.q(obj, this.f10709b, null);
            }
            Object obj2 = this.f10710c;
            if (obj2 != null) {
                g.this.q(obj2, this.f10711d, null);
            }
            Object obj3 = this.f10712e;
            if (obj3 != null) {
                g.this.q(obj3, this.f10713f, null);
            }
        }

        @Override // androidx.transition.y, androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            transition.j0(this);
        }
    }

    class d implements androidx.core.os.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Transition f10715a;

        d(Transition transition) {
            this.f10715a = transition;
        }

        @Override // androidx.core.os.e.b
        public void onCancel() {
            this.f10715a.cancel();
        }
    }

    class e implements Transition.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f10717a;

        e(Runnable runnable) {
            this.f10717a = runnable;
        }

        @Override // androidx.transition.Transition.h
        public void a(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void b(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void c(@c.m0 Transition transition) {
            this.f10717a.run();
        }

        @Override // androidx.transition.Transition.h
        public void d(@c.m0 Transition transition) {
        }

        @Override // androidx.transition.Transition.h
        public void e(@c.m0 Transition transition) {
        }
    }

    class f extends Transition.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f10719a;

        f(Rect rect) {
            this.f10719a = rect;
        }

        @Override // androidx.transition.Transition.f
        public Rect a(@c.m0 Transition transition) {
            Rect rect = this.f10719a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f10719a;
        }
    }

    private static boolean C(Transition transition) {
        return (androidx.fragment.app.y.l(transition.R()) && androidx.fragment.app.y.l(transition.S()) && androidx.fragment.app.y.l(transition.T())) ? false : true;
    }

    @Override // androidx.fragment.app.y
    public void A(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.U().clear();
            transitionSet.U().addAll(arrayList2);
            q(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.y
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.I0((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.y
    public void a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).c(view);
        }
    }

    @Override // androidx.fragment.app.y
    public void b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i7 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iM0 = transitionSet.M0();
            while (i7 < iM0) {
                b(transitionSet.L0(i7), arrayList);
                i7++;
            }
            return;
        }
        if (C(transition) || !androidx.fragment.app.y.l(transition.U())) {
            return;
        }
        int size = arrayList.size();
        while (i7 < size) {
            transition.c(arrayList.get(i7));
            i7++;
        }
    }

    @Override // androidx.fragment.app.y
    public void c(ViewGroup viewGroup, Object obj) {
        z.b(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.y
    public boolean e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.y
    public Object g(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.y
    public Object m(Object obj, Object obj2, Object obj3) {
        Transition transitionV0 = (Transition) obj;
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        if (transitionV0 != null && transition != null) {
            transitionV0 = new TransitionSet().I0(transitionV0).I0(transition).V0(1);
        } else if (transitionV0 == null) {
            transitionV0 = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return transitionV0;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transitionV0 != null) {
            transitionSet.I0(transitionV0);
        }
        transitionSet.I0(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.y
    public Object n(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.I0((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.I0((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.I0((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.y
    public void p(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).l0(view);
        }
    }

    @Override // androidx.fragment.app.y
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i7 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int iM0 = transitionSet.M0();
            while (i7 < iM0) {
                q(transitionSet.L0(i7), arrayList, arrayList2);
                i7++;
            }
            return;
        }
        if (C(transition)) {
            return;
        }
        List<View> listU = transition.U();
        if (listU.size() == arrayList.size() && listU.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i7 < size) {
                transition.c(arrayList2.get(i7));
                i7++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.l0(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.y
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).a(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.y
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.y
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).u0(new f(rect));
        }
    }

    @Override // androidx.fragment.app.y
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((Transition) obj).u0(new a(rect));
        }
    }

    @Override // androidx.fragment.app.y
    public void w(@c.m0 Fragment fragment, @c.m0 Object obj, @c.m0 androidx.core.os.e eVar, @c.m0 Runnable runnable) {
        Transition transition = (Transition) obj;
        eVar.d(new d(transition));
        transition.a(new e(runnable));
    }

    @Override // androidx.fragment.app.y
    public void z(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> listU = transitionSet.U();
        listU.clear();
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            androidx.fragment.app.y.d(listU, arrayList.get(i7));
        }
        listU.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }
}
