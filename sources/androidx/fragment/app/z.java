package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.h0;
import androidx.lifecycle.m0;
import androidx.lifecycle.p0;
import androidx.lifecycle.q0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class z implements androidx.lifecycle.l, androidx.savedstate.d, q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f8170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p0 f8171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m0.b f8172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private androidx.lifecycle.r f8173d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private androidx.savedstate.c f8174e = null;

    z(@c.m0 Fragment fragment, @c.m0 p0 p0Var) {
        this.f8170a = fragment;
        this.f8171b = p0Var;
    }

    void a(@c.m0 androidx.lifecycle.m.b bVar) {
        this.f8173d.j(bVar);
    }

    void b() {
        if (this.f8173d == null) {
            this.f8173d = new androidx.lifecycle.r(this);
            this.f8174e = androidx.savedstate.c.a(this);
        }
    }

    boolean c() {
        return this.f8173d != null;
    }

    void d(@o0 Bundle bundle) {
        this.f8174e.d(bundle);
    }

    void e(@c.m0 Bundle bundle) {
        this.f8174e.e(bundle);
    }

    void f(@c.m0 androidx.lifecycle.m.c cVar) {
        this.f8173d.q(cVar);
    }

    @Override // androidx.lifecycle.l
    public /* synthetic */ v.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.k.a(this);
    }

    @Override // androidx.lifecycle.l
    @c.m0
    public m0.b getDefaultViewModelProviderFactory() {
        Application application;
        m0.b defaultViewModelProviderFactory = this.f8170a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f8170a.mDefaultFactory)) {
            this.f8172c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f8172c == null) {
            Context applicationContext = this.f8170a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f8172c = new h0(application, this, this.f8170a.getArguments());
        }
        return this.f8172c;
    }

    @Override // androidx.lifecycle.q
    @c.m0
    public androidx.lifecycle.m getLifecycle() {
        b();
        return this.f8173d;
    }

    @Override // androidx.savedstate.d
    @c.m0
    public androidx.savedstate.b getSavedStateRegistry() {
        b();
        return this.f8174e.b();
    }

    @Override // androidx.lifecycle.q0
    @c.m0
    public p0 getViewModelStore() {
        b();
        return this.f8171b;
    }
}
