package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import c.j0;
import java.util.Map;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private static final C0125b f9758g = new C0125b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    @Deprecated
    private static final String f9759h = "androidx.lifecycle.BundlableSavedStateRegistry.key";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private Bundle f9762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f9763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private Recreator.b f9764e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final androidx.arch.core.internal.b<String, c> f9760a = new androidx.arch.core.internal.b<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9765f = true;

    public interface a {
        void a(@a7.d d dVar);
    }

    /* JADX INFO: renamed from: androidx.savedstate.b$b, reason: collision with other inner class name */
    private static final class C0125b {
        public /* synthetic */ C0125b(w wVar) {
            this();
        }

        private C0125b() {
        }
    }

    public interface c {
        @a7.d
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(b this$0, q qVar, m.b event) {
        l0.p(this$0, "this$0");
        l0.p(qVar, "<anonymous parameter 0>");
        l0.p(event, "event");
        if (event == m.b.ON_START) {
            this$0.f9765f = true;
        } else if (event == m.b.ON_STOP) {
            this$0.f9765f = false;
        }
    }

    @a7.e
    @j0
    public final Bundle b(@a7.d String key) {
        l0.p(key, "key");
        if (!this.f9763d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f9762c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f9762c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f9762c;
        boolean z7 = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z7 = true;
        }
        if (!z7) {
            this.f9762c = null;
        }
        return bundle2;
    }

    @a7.e
    public final c c(@a7.d String key) {
        l0.p(key, "key");
        for (Map.Entry<String, c> components : this.f9760a) {
            l0.o(components, "components");
            String key2 = components.getKey();
            c value = components.getValue();
            if (l0.g(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final boolean d() {
        return this.f9765f;
    }

    @j0
    public final boolean e() {
        return this.f9763d;
    }

    @j0
    public final void g(@a7.d m lifecycle) {
        l0.p(lifecycle, "lifecycle");
        if (!(!this.f9761b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new o() { // from class: androidx.savedstate.a
            @Override // androidx.lifecycle.o
            public final void g(q qVar, m.b bVar) {
                b.f(this.f9757a, qVar, bVar);
            }
        });
        this.f9761b = true;
    }

    @j0
    public final void h(@a7.e Bundle bundle) {
        if (!this.f9761b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f9763d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f9762c = bundle != null ? bundle.getBundle(f9759h) : null;
        this.f9763d = true;
    }

    @j0
    public final void i(@a7.d Bundle outBundle) {
        l0.p(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f9762c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        androidx.arch.core.internal.b<String, c>.d dVarD = this.f9760a.d();
        l0.o(dVarD, "this.components.iteratorWithAdditions()");
        while (dVarD.hasNext()) {
            Map.Entry next = dVarD.next();
            bundle.putBundle((String) next.getKey(), ((c) next.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle(f9759h, bundle);
    }

    @j0
    public final void j(@a7.d String key, @a7.d c provider) {
        l0.p(key, "key");
        l0.p(provider, "provider");
        if (!(this.f9760a.h(key, provider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    @j0
    public final void k(@a7.d Class<? extends a> clazz) {
        l0.p(clazz, "clazz");
        if (!this.f9765f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.b bVar = this.f9764e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f9764e = bVar;
        try {
            clazz.getDeclaredConstructor(new Class[0]);
            Recreator.b bVar2 = this.f9764e;
            if (bVar2 != null) {
                String name = clazz.getName();
                l0.o(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e8) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e8);
        }
    }

    public final void l(boolean z7) {
        this.f9765f = z7;
    }

    @j0
    public final void m(@a7.d String key) {
        l0.p(key, "key");
        this.f9760a.j(key);
    }
}
