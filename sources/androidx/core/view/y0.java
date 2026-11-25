package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f6937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<p1> f6938b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<p1, a> f6939c = new HashMap();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.lifecycle.m f6940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private androidx.lifecycle.o f6941b;

        a(@c.m0 androidx.lifecycle.m mVar, @c.m0 androidx.lifecycle.o oVar) {
            this.f6940a = mVar;
            this.f6941b = oVar;
            mVar.a(oVar);
        }

        void a() {
            this.f6940a.c(this.f6941b);
            this.f6941b = null;
        }
    }

    public y0(@c.m0 Runnable runnable) {
        this.f6937a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(p1 p1Var, androidx.lifecycle.q qVar, androidx.lifecycle.m.b bVar) {
        if (bVar == androidx.lifecycle.m.b.ON_DESTROY) {
            l(p1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(androidx.lifecycle.m.c cVar, p1 p1Var, androidx.lifecycle.q qVar, androidx.lifecycle.m.b bVar) {
        if (bVar == androidx.lifecycle.m.b.e(cVar)) {
            c(p1Var);
            return;
        }
        if (bVar == androidx.lifecycle.m.b.ON_DESTROY) {
            l(p1Var);
        } else if (bVar == androidx.lifecycle.m.b.a(cVar)) {
            this.f6938b.remove(p1Var);
            this.f6937a.run();
        }
    }

    public void c(@c.m0 p1 p1Var) {
        this.f6938b.add(p1Var);
        this.f6937a.run();
    }

    public void d(@c.m0 final p1 p1Var, @c.m0 androidx.lifecycle.q qVar) {
        c(p1Var);
        androidx.lifecycle.m lifecycle = qVar.getLifecycle();
        a aVarRemove = this.f6939c.remove(p1Var);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f6939c.put(p1Var, new a(lifecycle, new androidx.lifecycle.o() { // from class: androidx.core.view.w0
            @Override // androidx.lifecycle.o
            public final void g(androidx.lifecycle.q qVar2, androidx.lifecycle.m.b bVar) {
                this.f6886a.f(p1Var, qVar2, bVar);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void e(@c.m0 final p1 p1Var, @c.m0 androidx.lifecycle.q qVar, @c.m0 final androidx.lifecycle.m.c cVar) {
        androidx.lifecycle.m lifecycle = qVar.getLifecycle();
        a aVarRemove = this.f6939c.remove(p1Var);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f6939c.put(p1Var, new a(lifecycle, new androidx.lifecycle.o() { // from class: androidx.core.view.x0
            @Override // androidx.lifecycle.o
            public final void g(androidx.lifecycle.q qVar2, androidx.lifecycle.m.b bVar) {
                this.f6934a.g(cVar, p1Var, qVar2, bVar);
            }
        }));
    }

    public void h(@c.m0 Menu menu, @c.m0 MenuInflater menuInflater) {
        Iterator<p1> it = this.f6938b.iterator();
        while (it.hasNext()) {
            it.next().c(menu, menuInflater);
        }
    }

    public void i(@c.m0 Menu menu) {
        Iterator<p1> it = this.f6938b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
    }

    public boolean j(@c.m0 MenuItem menuItem) {
        Iterator<p1> it = this.f6938b.iterator();
        while (it.hasNext()) {
            if (it.next().a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(@c.m0 Menu menu) {
        Iterator<p1> it = this.f6938b.iterator();
        while (it.hasNext()) {
            it.next().d(menu);
        }
    }

    public void l(@c.m0 p1 p1Var) {
        this.f6938b.remove(p1Var);
        a aVarRemove = this.f6939c.remove(p1Var);
        if (aVarRemove != null) {
            aVarRemove.a();
        }
        this.f6937a.run();
    }
}
