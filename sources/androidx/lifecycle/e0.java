package androidx.lifecycle;

import android.os.Bundle;
import kotlin.jvm.internal.l1;

/* JADX INFO: loaded from: classes.dex */
@h5.h(name = "SavedStateHandleSupport")
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final String f8284a = "androidx.lifecycle.internal.SavedStateHandlesVM";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final String f8285b = "androidx.lifecycle.internal.SavedStateHandlesProvider";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final v.a.b<androidx.savedstate.d> f8286c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final v.a.b<q0> f8287d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final v.a.b<Bundle> f8288e = new a();

    public static final class a implements v.a.b<Bundle> {
        a() {
        }
    }

    public static final class b implements v.a.b<androidx.savedstate.d> {
        b() {
        }
    }

    public static final class c implements v.a.b<q0> {
        c() {
        }
    }

    static final class d extends kotlin.jvm.internal.n0 implements i5.l<v.a, g0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f8289a = new d();

        d() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g0 z(@a7.d v.a initializer) {
            kotlin.jvm.internal.l0.p(initializer, "$this$initializer");
            return new g0();
        }
    }

    private static final d0 a(androidx.savedstate.d dVar, q0 q0Var, String str, Bundle bundle) {
        f0 f0VarD = d(dVar);
        g0 g0VarE = e(q0Var);
        d0 d0Var = g0VarE.g().get(str);
        if (d0Var != null) {
            return d0Var;
        }
        d0 d0VarA = d0.f8273f.a(f0VarD.b(str), bundle);
        g0VarE.g().put(str, d0VarA);
        return d0VarA;
    }

    @a7.d
    @c.j0
    public static final d0 b(@a7.d v.a aVar) {
        kotlin.jvm.internal.l0.p(aVar, "<this>");
        androidx.savedstate.d dVar = (androidx.savedstate.d) aVar.a(f8286c);
        if (dVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        q0 q0Var = (q0) aVar.a(f8287d);
        if (q0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f8288e);
        String str = (String) aVar.a(m0.c.f8340d);
        if (str != null) {
            return a(dVar, q0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c.j0
    public static final <T extends androidx.savedstate.d & q0> void c(@a7.d T t7) {
        kotlin.jvm.internal.l0.p(t7, "<this>");
        m.c cVarB = t7.getLifecycle().b();
        kotlin.jvm.internal.l0.o(cVarB, "lifecycle.currentState");
        if (!(cVarB == m.c.INITIALIZED || cVarB == m.c.CREATED)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t7.getSavedStateRegistry().c(f8285b) == null) {
            f0 f0Var = new f0(t7.getSavedStateRegistry(), t7);
            t7.getSavedStateRegistry().j(f8285b, f0Var);
            t7.getLifecycle().a(new SavedStateHandleAttacher(f0Var));
        }
    }

    @a7.d
    public static final f0 d(@a7.d androidx.savedstate.d dVar) {
        kotlin.jvm.internal.l0.p(dVar, "<this>");
        androidx.savedstate.b.c cVarC = dVar.getSavedStateRegistry().c(f8285b);
        f0 f0Var = cVarC instanceof f0 ? (f0) cVarC : null;
        if (f0Var != null) {
            return f0Var;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    @a7.d
    public static final g0 e(@a7.d q0 q0Var) {
        kotlin.jvm.internal.l0.p(q0Var, "<this>");
        v.c cVar = new v.c();
        cVar.a(l1.d(g0.class), d.f8289a);
        return (g0) new m0(q0Var, cVar.b()).b(f8284a, g0.class);
    }
}
