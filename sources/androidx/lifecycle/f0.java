package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements androidx.savedstate.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final androidx.savedstate.b f8290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private Bundle f8292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final kotlin.d0 f8293d;

    static final class a extends kotlin.jvm.internal.n0 implements i5.a<g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q0 f8294a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(q0 q0Var) {
            super(0);
            this.f8294a = q0Var;
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g0 invoke() {
            return e0.e(this.f8294a);
        }
    }

    public f0(@a7.d androidx.savedstate.b savedStateRegistry, @a7.d q0 viewModelStoreOwner) {
        kotlin.jvm.internal.l0.p(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.l0.p(viewModelStoreOwner, "viewModelStoreOwner");
        this.f8290a = savedStateRegistry;
        this.f8293d = kotlin.f0.a(new a(viewModelStoreOwner));
    }

    private final g0 c() {
        return (g0) this.f8293d.getValue();
    }

    @Override // androidx.savedstate.b.c
    @a7.d
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f8292c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, d0> entry : c().g().entrySet()) {
            String key = entry.getKey();
            Bundle bundleA = entry.getValue().o().a();
            if (!kotlin.jvm.internal.l0.g(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleA);
            }
        }
        this.f8291b = false;
        return bundle;
    }

    @a7.e
    public final Bundle b(@a7.d String key) {
        kotlin.jvm.internal.l0.p(key, "key");
        d();
        Bundle bundle = this.f8292c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f8292c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f8292c;
        boolean z7 = false;
        if (bundle4 != null && bundle4.isEmpty()) {
            z7 = true;
        }
        if (z7) {
            this.f8292c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.f8291b) {
            return;
        }
        this.f8292c = this.f8290a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.f8291b = true;
        c();
    }
}
