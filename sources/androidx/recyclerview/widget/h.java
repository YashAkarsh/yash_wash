package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.n2;
import c.m0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h extends a0 {
    private static TimeInterpolator A = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final boolean f9460z = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f9461o = new ArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f9462p = new ArrayList<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ArrayList<j> f9463q = new ArrayList<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ArrayList<i> f9464r = new ArrayList<>();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.d0>> f9465s = new ArrayList<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    ArrayList<ArrayList<j>> f9466t = new ArrayList<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    ArrayList<ArrayList<i>> f9467u = new ArrayList<>();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f9468v = new ArrayList<>();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f9469w = new ArrayList<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f9470x = new ArrayList<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f9471y = new ArrayList<>();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f9472a;

        a(ArrayList arrayList) {
            this.f9472a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (j jVar : this.f9472a) {
                h.this.b0(jVar.f9506a, jVar.f9507b, jVar.f9508c, jVar.f9509d, jVar.f9510e);
            }
            this.f9472a.clear();
            h.this.f9466t.remove(this.f9472a);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f9474a;

        b(ArrayList arrayList) {
            this.f9474a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f9474a.iterator();
            while (it.hasNext()) {
                h.this.a0((i) it.next());
            }
            this.f9474a.clear();
            h.this.f9467u.remove(this.f9474a);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f9476a;

        c(ArrayList arrayList) {
            this.f9476a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f9476a.iterator();
            while (it.hasNext()) {
                h.this.Z((RecyclerView.d0) it.next());
            }
            this.f9476a.clear();
            h.this.f9465s.remove(this.f9476a);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f9479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f9480c;

        d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f9478a = d0Var;
            this.f9479b = viewPropertyAnimator;
            this.f9480c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9479b.setListener(null);
            this.f9480c.setAlpha(1.0f);
            h.this.N(this.f9478a);
            h.this.f9470x.remove(this.f9478a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.O(this.f9478a);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f9483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f9484c;

        e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f9482a = d0Var;
            this.f9483b = view;
            this.f9484c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f9483b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9484c.setListener(null);
            h.this.H(this.f9482a);
            h.this.f9468v.remove(this.f9482a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.I(this.f9482a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f9486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f9487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f9488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f9489d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f9490e;

        f(RecyclerView.d0 d0Var, int i7, View view, int i8, ViewPropertyAnimator viewPropertyAnimator) {
            this.f9486a = d0Var;
            this.f9487b = i7;
            this.f9488c = view;
            this.f9489d = i8;
            this.f9490e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f9487b != 0) {
                this.f9488c.setTranslationX(0.0f);
            }
            if (this.f9489d != 0) {
                this.f9488c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9490e.setListener(null);
            h.this.L(this.f9486a);
            h.this.f9469w.remove(this.f9486a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.M(this.f9486a);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f9492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f9493b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f9494c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f9492a = iVar;
            this.f9493b = viewPropertyAnimator;
            this.f9494c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9493b.setListener(null);
            this.f9494c.setAlpha(1.0f);
            this.f9494c.setTranslationX(0.0f);
            this.f9494c.setTranslationY(0.0f);
            h.this.J(this.f9492a.f9500a, true);
            h.this.f9471y.remove(this.f9492a.f9500a);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.K(this.f9492a.f9500a, true);
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.h$h, reason: collision with other inner class name */
    class C0123h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f9496a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f9497b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f9498c;

        C0123h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f9496a = iVar;
            this.f9497b = viewPropertyAnimator;
            this.f9498c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f9497b.setListener(null);
            this.f9498c.setAlpha(1.0f);
            this.f9498c.setTranslationX(0.0f);
            this.f9498c.setTranslationY(0.0f);
            h.this.J(this.f9496a.f9501b, false);
            h.this.f9471y.remove(this.f9496a.f9501b);
            h.this.e0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.K(this.f9496a.f9501b, false);
        }
    }

    private static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f9506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9509d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9510e;

        j(RecyclerView.d0 d0Var, int i7, int i8, int i9, int i10) {
            this.f9506a = d0Var;
            this.f9507b = i7;
            this.f9508c = i8;
            this.f9509d = i9;
            this.f9510e = i10;
        }
    }

    private void c0(RecyclerView.d0 d0Var) {
        View view = d0Var.f9157a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f9470x.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(p()).alpha(0.0f).setListener(new d(d0Var, viewPropertyAnimatorAnimate, view)).start();
    }

    private void f0(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (h0(iVar, d0Var) && iVar.f9500a == null && iVar.f9501b == null) {
                list.remove(iVar);
            }
        }
    }

    private void g0(i iVar) {
        RecyclerView.d0 d0Var = iVar.f9500a;
        if (d0Var != null) {
            h0(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f9501b;
        if (d0Var2 != null) {
            h0(iVar, d0Var2);
        }
    }

    private boolean h0(i iVar, RecyclerView.d0 d0Var) {
        boolean z7 = false;
        if (iVar.f9501b == d0Var) {
            iVar.f9501b = null;
        } else {
            if (iVar.f9500a != d0Var) {
                return false;
            }
            iVar.f9500a = null;
            z7 = true;
        }
        d0Var.f9157a.setAlpha(1.0f);
        d0Var.f9157a.setTranslationX(0.0f);
        d0Var.f9157a.setTranslationY(0.0f);
        J(d0Var, z7);
        return true;
    }

    private void i0(RecyclerView.d0 d0Var) {
        if (A == null) {
            A = new ValueAnimator().getInterpolator();
        }
        d0Var.f9157a.animate().setInterpolator(A);
        k(d0Var);
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean D(RecyclerView.d0 d0Var) {
        i0(d0Var);
        d0Var.f9157a.setAlpha(0.0f);
        this.f9462p.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean E(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i7, int i8, int i9, int i10) {
        if (d0Var == d0Var2) {
            return F(d0Var, i7, i8, i9, i10);
        }
        float translationX = d0Var.f9157a.getTranslationX();
        float translationY = d0Var.f9157a.getTranslationY();
        float alpha = d0Var.f9157a.getAlpha();
        i0(d0Var);
        int i11 = (int) ((i9 - i7) - translationX);
        int i12 = (int) ((i10 - i8) - translationY);
        d0Var.f9157a.setTranslationX(translationX);
        d0Var.f9157a.setTranslationY(translationY);
        d0Var.f9157a.setAlpha(alpha);
        if (d0Var2 != null) {
            i0(d0Var2);
            d0Var2.f9157a.setTranslationX(-i11);
            d0Var2.f9157a.setTranslationY(-i12);
            d0Var2.f9157a.setAlpha(0.0f);
        }
        this.f9464r.add(new i(d0Var, d0Var2, i7, i8, i9, i10));
        return true;
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean F(RecyclerView.d0 d0Var, int i7, int i8, int i9, int i10) {
        View view = d0Var.f9157a;
        int translationX = i7 + ((int) view.getTranslationX());
        int translationY = i8 + ((int) d0Var.f9157a.getTranslationY());
        i0(d0Var);
        int i11 = i9 - translationX;
        int i12 = i10 - translationY;
        if (i11 == 0 && i12 == 0) {
            L(d0Var);
            return false;
        }
        if (i11 != 0) {
            view.setTranslationX(-i11);
        }
        if (i12 != 0) {
            view.setTranslationY(-i12);
        }
        this.f9463q.add(new j(d0Var, translationX, translationY, i9, i10));
        return true;
    }

    @Override // androidx.recyclerview.widget.a0
    public boolean G(RecyclerView.d0 d0Var) {
        i0(d0Var);
        this.f9461o.add(d0Var);
        return true;
    }

    void Z(RecyclerView.d0 d0Var) {
        View view = d0Var.f9157a;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f9468v.add(d0Var);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m()).setListener(new e(d0Var, view, viewPropertyAnimatorAnimate)).start();
    }

    void a0(i iVar) {
        RecyclerView.d0 d0Var = iVar.f9500a;
        View view = d0Var == null ? null : d0Var.f9157a;
        RecyclerView.d0 d0Var2 = iVar.f9501b;
        View view2 = d0Var2 != null ? d0Var2.f9157a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(n());
            this.f9471y.add(iVar.f9500a);
            duration.translationX(iVar.f9504e - iVar.f9502c);
            duration.translationY(iVar.f9505f - iVar.f9503d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f9471y.add(iVar.f9501b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(n()).alpha(1.0f).setListener(new C0123h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    void b0(RecyclerView.d0 d0Var, int i7, int i8, int i9, int i10) {
        View view = d0Var.f9157a;
        int i11 = i9 - i7;
        int i12 = i10 - i8;
        if (i11 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i12 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f9469w.add(d0Var);
        viewPropertyAnimatorAnimate.setDuration(o()).setListener(new f(d0Var, i11, view, i12, viewPropertyAnimatorAnimate)).start();
    }

    void d0(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f9157a.animate().cancel();
        }
    }

    void e0() {
        if (q()) {
            return;
        }
        j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(@m0 RecyclerView.d0 d0Var, @m0 List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k(RecyclerView.d0 d0Var) {
        View view = d0Var.f9157a;
        view.animate().cancel();
        int size = this.f9463q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f9463q.get(size).f9506a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                L(d0Var);
                this.f9463q.remove(size);
            }
        }
        f0(this.f9464r, d0Var);
        if (this.f9461o.remove(d0Var)) {
            view.setAlpha(1.0f);
            N(d0Var);
        }
        if (this.f9462p.remove(d0Var)) {
            view.setAlpha(1.0f);
            H(d0Var);
        }
        for (int size2 = this.f9467u.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f9467u.get(size2);
            f0(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f9467u.remove(size2);
            }
        }
        for (int size3 = this.f9466t.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f9466t.get(size3);
            for (int size4 = arrayList2.size() - 1; size4 >= 0; size4--) {
                if (arrayList2.get(size4).f9506a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    L(d0Var);
                    arrayList2.remove(size4);
                    if (!arrayList2.isEmpty()) {
                        break;
                    }
                    this.f9466t.remove(size3);
                    break;
                }
            }
        }
        for (int size5 = this.f9465s.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.f9465s.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                H(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f9465s.remove(size5);
                }
            }
        }
        this.f9470x.remove(d0Var);
        this.f9468v.remove(d0Var);
        this.f9471y.remove(d0Var);
        this.f9469w.remove(d0Var);
        e0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void l() {
        int size = this.f9463q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f9463q.get(size);
            View view = jVar.f9506a.f9157a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            L(jVar.f9506a);
            this.f9463q.remove(size);
        }
        for (int size2 = this.f9461o.size() - 1; size2 >= 0; size2--) {
            N(this.f9461o.get(size2));
            this.f9461o.remove(size2);
        }
        int size3 = this.f9462p.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f9462p.get(size3);
            d0Var.f9157a.setAlpha(1.0f);
            H(d0Var);
            this.f9462p.remove(size3);
        }
        for (int size4 = this.f9464r.size() - 1; size4 >= 0; size4--) {
            g0(this.f9464r.get(size4));
        }
        this.f9464r.clear();
        if (q()) {
            for (int size5 = this.f9466t.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f9466t.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f9506a.f9157a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    L(jVar2.f9506a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f9466t.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f9465s.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.f9465s.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f9157a.setAlpha(1.0f);
                    H(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f9465s.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f9467u.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f9467u.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    g0(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f9467u.remove(arrayList3);
                    }
                }
            }
            d0(this.f9470x);
            d0(this.f9469w);
            d0(this.f9468v);
            d0(this.f9471y);
            j();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean q() {
        return (this.f9462p.isEmpty() && this.f9464r.isEmpty() && this.f9463q.isEmpty() && this.f9461o.isEmpty() && this.f9469w.isEmpty() && this.f9470x.isEmpty() && this.f9468v.isEmpty() && this.f9471y.isEmpty() && this.f9466t.isEmpty() && this.f9465s.isEmpty() && this.f9467u.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void x() {
        boolean z7 = !this.f9461o.isEmpty();
        boolean z8 = !this.f9463q.isEmpty();
        boolean z9 = !this.f9464r.isEmpty();
        boolean z10 = !this.f9462p.isEmpty();
        if (z7 || z8 || z10 || z9) {
            Iterator<RecyclerView.d0> it = this.f9461o.iterator();
            while (it.hasNext()) {
                c0(it.next());
            }
            this.f9461o.clear();
            if (z8) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f9463q);
                this.f9466t.add(arrayList);
                this.f9463q.clear();
                a aVar = new a(arrayList);
                if (z7) {
                    n2.q1(arrayList.get(0).f9506a.f9157a, aVar, p());
                } else {
                    aVar.run();
                }
            }
            if (z9) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f9464r);
                this.f9467u.add(arrayList2);
                this.f9464r.clear();
                b bVar = new b(arrayList2);
                if (z7) {
                    n2.q1(arrayList2.get(0).f9500a.f9157a, bVar, p());
                } else {
                    bVar.run();
                }
            }
            if (z10) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f9462p);
                this.f9465s.add(arrayList3);
                this.f9462p.clear();
                c cVar = new c(arrayList3);
                if (z7 || z8 || z9) {
                    n2.q1(arrayList3.get(0).f9157a, cVar, (z7 ? p() : 0L) + Math.max(z8 ? o() : 0L, z9 ? n() : 0L));
                } else {
                    cVar.run();
                }
            }
        }
    }

    private static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f9500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.d0 f9501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f9503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9504e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9505f;

        private i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f9500a = d0Var;
            this.f9501b = d0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f9500a + ", newHolder=" + this.f9501b + ", fromX=" + this.f9502c + ", fromY=" + this.f9503d + ", toX=" + this.f9504e + ", toY=" + this.f9505f + '}';
        }

        i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i7, int i8, int i9, int i10) {
            this(d0Var, d0Var2);
            this.f9502c = i7;
            this.f9503d = i8;
            this.f9504e = i9;
            this.f9505f = i10;
        }
    }
}
