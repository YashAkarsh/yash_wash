package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.d0;
import androidx.lifecycle.h0;
import androidx.lifecycle.k0;
import androidx.lifecycle.p0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r;
import c.m0;
import c.o0;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class g implements androidx.lifecycle.q, q0, androidx.lifecycle.l, androidx.savedstate.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l f8834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f8835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r f8836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.savedstate.c f8837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m0
    final UUID f8838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.lifecycle.m.c f8839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private androidx.lifecycle.m.c f8840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f8841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private androidx.lifecycle.m0.b f8842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private d0 f8843k;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8844a;

        static {
            int[] iArr = new int[androidx.lifecycle.m.b.values().length];
            f8844a = iArr;
            try {
                iArr[androidx.lifecycle.m.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8844a[androidx.lifecycle.m.b.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8844a[androidx.lifecycle.m.b.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8844a[androidx.lifecycle.m.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8844a[androidx.lifecycle.m.b.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8844a[androidx.lifecycle.m.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8844a[androidx.lifecycle.m.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static class b extends androidx.lifecycle.a {
        b(@m0 androidx.savedstate.d dVar, @o0 Bundle bundle) {
            super(dVar, bundle);
        }

        @Override // androidx.lifecycle.a
        @m0
        protected <T extends k0> T e(@m0 String str, @m0 Class<T> cls, @m0 d0 d0Var) {
            return new c(d0Var);
        }
    }

    private static class c extends k0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d0 f8845d;

        c(d0 d0Var) {
            this.f8845d = d0Var;
        }

        public d0 g() {
            return this.f8845d;
        }
    }

    g(@m0 Context context, @m0 l lVar, @o0 Bundle bundle, @o0 androidx.lifecycle.q qVar, @o0 h hVar) {
        this(context, lVar, bundle, qVar, hVar, UUID.randomUUID(), null);
    }

    @m0
    private static androidx.lifecycle.m.c e(@m0 androidx.lifecycle.m.b bVar) {
        switch (a.f8844a[bVar.ordinal()]) {
            case 1:
            case 2:
                return androidx.lifecycle.m.c.CREATED;
            case 3:
            case 4:
                return androidx.lifecycle.m.c.STARTED;
            case 5:
                return androidx.lifecycle.m.c.RESUMED;
            case 6:
                return androidx.lifecycle.m.c.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + bVar);
        }
    }

    @o0
    public Bundle a() {
        return this.f8835c;
    }

    @m0
    public l b() {
        return this.f8834b;
    }

    @m0
    androidx.lifecycle.m.c c() {
        return this.f8840h;
    }

    @m0
    public d0 d() {
        if (this.f8843k == null) {
            this.f8843k = ((c) new androidx.lifecycle.m0(this, new b(this, null)).a(c.class)).g();
        }
        return this.f8843k;
    }

    void f(@m0 androidx.lifecycle.m.b bVar) {
        this.f8839g = e(bVar);
        j();
    }

    void g(@o0 Bundle bundle) {
        this.f8835c = bundle;
    }

    @Override // androidx.lifecycle.l
    public /* synthetic */ v.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.k.a(this);
    }

    @Override // androidx.lifecycle.l
    @m0
    public androidx.lifecycle.m0.b getDefaultViewModelProviderFactory() {
        if (this.f8842j == null) {
            this.f8842j = new h0((Application) this.f8833a.getApplicationContext(), this, this.f8835c);
        }
        return this.f8842j;
    }

    @Override // androidx.lifecycle.q
    @m0
    public androidx.lifecycle.m getLifecycle() {
        return this.f8836d;
    }

    @Override // androidx.savedstate.d
    @m0
    public androidx.savedstate.b getSavedStateRegistry() {
        return this.f8837e.b();
    }

    @Override // androidx.lifecycle.q0
    @m0
    public p0 getViewModelStore() {
        h hVar = this.f8841i;
        if (hVar != null) {
            return hVar.i(this.f8838f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    void h(@m0 Bundle bundle) {
        this.f8837e.e(bundle);
    }

    void i(@m0 androidx.lifecycle.m.c cVar) {
        this.f8840h = cVar;
        j();
    }

    void j() {
        if (this.f8839g.ordinal() < this.f8840h.ordinal()) {
            this.f8836d.q(this.f8839g);
        } else {
            this.f8836d.q(this.f8840h);
        }
    }

    g(@m0 Context context, @m0 l lVar, @o0 Bundle bundle, @o0 androidx.lifecycle.q qVar, @o0 h hVar, @m0 UUID uuid, @o0 Bundle bundle2) {
        this.f8836d = new r(this);
        androidx.savedstate.c cVarA = androidx.savedstate.c.a(this);
        this.f8837e = cVarA;
        this.f8839g = androidx.lifecycle.m.c.CREATED;
        this.f8840h = androidx.lifecycle.m.c.RESUMED;
        this.f8833a = context;
        this.f8838f = uuid;
        this.f8834b = lVar;
        this.f8835c = bundle;
        this.f8841i = hVar;
        cVarA.d(bundle2);
        if (qVar != null) {
            this.f8839g = qVar.getLifecycle().b();
        }
    }
}
