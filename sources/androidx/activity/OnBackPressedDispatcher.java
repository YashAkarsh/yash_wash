package androidx.activity;

import android.annotation.SuppressLint;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import c.j0;
import c.m0;
import c.o0;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final Runnable f563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayDeque<g> f564b;

    private class LifecycleOnBackPressedCancellable implements o, androidx.activity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m f565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        private androidx.activity.a f567c;

        LifecycleOnBackPressedCancellable(@m0 m mVar, g gVar) {
            this.f565a = mVar;
            this.f566b = gVar;
            mVar.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f565a.c(this);
            this.f566b.e(this);
            androidx.activity.a aVar = this.f567c;
            if (aVar != null) {
                aVar.cancel();
                this.f567c = null;
            }
        }

        @Override // androidx.lifecycle.o
        public void g(@m0 q qVar, @m0 m.b bVar) {
            if (bVar == m.b.ON_START) {
                this.f567c = OnBackPressedDispatcher.this.c(this.f566b);
                return;
            }
            if (bVar != m.b.ON_STOP) {
                if (bVar == m.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.f567c;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }
    }

    private class a implements androidx.activity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f569a;

        a(g gVar) {
            this.f569a = gVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f564b.remove(this.f569a);
            this.f569a.e(this);
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    @j0
    public void a(@m0 g gVar) {
        c(gVar);
    }

    @SuppressLint({"LambdaLast"})
    @j0
    public void b(@m0 q qVar, @m0 g gVar) {
        m lifecycle = qVar.getLifecycle();
        if (lifecycle.b() == m.c.DESTROYED) {
            return;
        }
        gVar.a(new LifecycleOnBackPressedCancellable(lifecycle, gVar));
    }

    @m0
    @j0
    androidx.activity.a c(@m0 g gVar) {
        this.f564b.add(gVar);
        a aVar = new a(gVar);
        gVar.a(aVar);
        return aVar;
    }

    @j0
    public boolean d() {
        Iterator<g> itDescendingIterator = this.f564b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            if (itDescendingIterator.next().c()) {
                return true;
            }
        }
        return false;
    }

    @j0
    public void e() {
        Iterator<g> itDescendingIterator = this.f564b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            g next = itDescendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f563a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public OnBackPressedDispatcher(@o0 Runnable runnable) {
        this.f564b = new ArrayDeque<>();
        this.f563a = runnable;
    }
}
