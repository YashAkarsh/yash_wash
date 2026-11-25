package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.n2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10823c = "TransitionManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Transition f10824d = new AutoTransition();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadLocal<WeakReference<androidx.collection.a<ViewGroup, ArrayList<Transition>>>> f10825e = new ThreadLocal<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static ArrayList<ViewGroup> f10826f = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.collection.a<u, Transition> f10827a = new androidx.collection.a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.collection.a<u, androidx.collection.a<u, Transition>> f10828b = new androidx.collection.a<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Transition f10829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ViewGroup f10830b;

        /* JADX INFO: renamed from: androidx.transition.z$a$a, reason: collision with other inner class name */
        class C0129a extends y {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ androidx.collection.a f10831a;

            C0129a(androidx.collection.a aVar) {
                this.f10831a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.transition.y, androidx.transition.Transition.h
            public void c(@c.m0 Transition transition) {
                ((ArrayList) this.f10831a.get(a.this.f10830b)).remove(transition);
                transition.j0(this);
            }
        }

        a(Transition transition, ViewGroup viewGroup) {
            this.f10829a = transition;
            this.f10830b = viewGroup;
        }

        private void a() {
            this.f10830b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f10830b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!z.f10826f.remove(this.f10830b)) {
                return true;
            }
            androidx.collection.a<ViewGroup, ArrayList<Transition>> aVarE = z.e();
            ArrayList<Transition> arrayList = aVarE.get(this.f10830b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                aVarE.put(this.f10830b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f10829a);
            this.f10829a.a(new C0129a(aVarE));
            this.f10829a.o(this.f10830b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).o0(this.f10830b);
                }
            }
            this.f10829a.i0(this.f10830b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            z.f10826f.remove(this.f10830b);
            ArrayList<Transition> arrayList = z.e().get(this.f10830b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().o0(this.f10830b);
                }
            }
            this.f10829a.p(true);
        }
    }

    public static void a(@c.m0 ViewGroup viewGroup) {
        b(viewGroup, null);
    }

    public static void b(@c.m0 ViewGroup viewGroup, @c.o0 Transition transition) {
        if (f10826f.contains(viewGroup) || !n2.U0(viewGroup)) {
            return;
        }
        f10826f.add(viewGroup);
        if (transition == null) {
            transition = f10824d;
        }
        Transition transitionClone = transition.clone();
        j(viewGroup, transitionClone);
        u.g(viewGroup, null);
        i(viewGroup, transitionClone);
    }

    private static void c(u uVar, Transition transition) {
        ViewGroup viewGroupE = uVar.e();
        if (f10826f.contains(viewGroupE)) {
            return;
        }
        u uVarC = u.c(viewGroupE);
        if (transition == null) {
            if (uVarC != null) {
                uVarC.b();
            }
            uVar.a();
            return;
        }
        f10826f.add(viewGroupE);
        Transition transitionClone = transition.clone();
        transitionClone.z0(viewGroupE);
        if (uVarC != null && uVarC.f()) {
            transitionClone.s0(true);
        }
        j(viewGroupE, transitionClone);
        uVar.a();
        i(viewGroupE, transitionClone);
    }

    public static void d(ViewGroup viewGroup) {
        f10826f.remove(viewGroup);
        ArrayList<Transition> arrayList = e().get(viewGroup);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            ((Transition) arrayList2.get(size)).F(viewGroup);
        }
    }

    static androidx.collection.a<ViewGroup, ArrayList<Transition>> e() {
        androidx.collection.a<ViewGroup, ArrayList<Transition>> aVar;
        WeakReference<androidx.collection.a<ViewGroup, ArrayList<Transition>>> weakReference = f10825e.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a<ViewGroup, ArrayList<Transition>> aVar2 = new androidx.collection.a<>();
        f10825e.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private Transition f(u uVar) {
        u uVarC;
        androidx.collection.a<u, Transition> aVar;
        Transition transition;
        ViewGroup viewGroupE = uVar.e();
        if (viewGroupE != null && (uVarC = u.c(viewGroupE)) != null && (aVar = this.f10828b.get(uVar)) != null && (transition = aVar.get(uVarC)) != null) {
            return transition;
        }
        Transition transition2 = this.f10827a.get(uVar);
        return transition2 != null ? transition2 : f10824d;
    }

    public static void g(@c.m0 u uVar) {
        c(uVar, f10824d);
    }

    public static void h(@c.m0 u uVar, @c.o0 Transition transition) {
        c(uVar, transition);
    }

    private static void i(ViewGroup viewGroup, Transition transition) {
        if (transition == null || viewGroup == null) {
            return;
        }
        a aVar = new a(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void j(ViewGroup viewGroup, Transition transition) {
        ArrayList<Transition> arrayList = e().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().h0(viewGroup);
            }
        }
        if (transition != null) {
            transition.o(viewGroup, true);
        }
        u uVarC = u.c(viewGroup);
        if (uVarC != null) {
            uVarC.b();
        }
    }

    public void k(@c.m0 u uVar, @c.m0 u uVar2, @c.o0 Transition transition) {
        androidx.collection.a<u, Transition> aVar = this.f10828b.get(uVar2);
        if (aVar == null) {
            aVar = new androidx.collection.a<>();
            this.f10828b.put(uVar2, aVar);
        }
        aVar.put(uVar, transition);
    }

    public void l(@c.m0 u uVar, @c.o0 Transition transition) {
        this.f10827a.put(uVar, transition);
    }

    public void m(@c.m0 u uVar) {
        c(uVar, f(uVar));
    }
}
