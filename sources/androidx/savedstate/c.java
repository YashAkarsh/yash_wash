package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.m;
import c.j0;
import h5.l;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    public static final a f9766d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final d f9767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final b f9768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9769c;

    public static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        @a7.d
        @l
        public final c a(@a7.d d owner) {
            l0.p(owner, "owner");
            return new c(owner, null);
        }

        private a() {
        }
    }

    public /* synthetic */ c(d dVar, w wVar) {
        this(dVar);
    }

    @a7.d
    @l
    public static final c a(@a7.d d dVar) {
        return f9766d.a(dVar);
    }

    @a7.d
    public final b b() {
        return this.f9768b;
    }

    @j0
    public final void c() {
        m lifecycle = this.f9767a.getLifecycle();
        l0.o(lifecycle, "owner.lifecycle");
        if (!(lifecycle.b() == m.c.INITIALIZED)) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
        }
        lifecycle.a(new Recreator(this.f9767a));
        this.f9768b.g(lifecycle);
        this.f9769c = true;
    }

    @j0
    public final void d(@a7.e Bundle bundle) {
        if (!this.f9769c) {
            c();
        }
        m lifecycle = this.f9767a.getLifecycle();
        l0.o(lifecycle, "owner.lifecycle");
        if (!lifecycle.b().a(m.c.STARTED)) {
            this.f9768b.h(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    @j0
    public final void e(@a7.d Bundle outBundle) {
        l0.p(outBundle, "outBundle");
        this.f9768b.i(outBundle);
    }

    private c(d dVar) {
        this.f9767a = dVar;
        this.f9768b = new b();
    }
}
