package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends m0.d implements m0.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f8246e = "androidx.lifecycle.savedstate.vm.tag";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.savedstate.b f8247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m f8248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bundle f8249d;

    public a() {
    }

    @c.m0
    private <T extends k0> T d(@c.m0 String str, @c.m0 Class<T> cls) {
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(this.f8247b, this.f8248c, str, this.f8249d);
        T t7 = (T) e(str, cls, savedStateHandleControllerB.i());
        t7.f(f8246e, savedStateHandleControllerB);
        return t7;
    }

    @Override // androidx.lifecycle.m0.b
    @c.m0
    public final <T extends k0> T a(@c.m0 Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (this.f8248c != null) {
            return (T) d(canonicalName, cls);
        }
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.m0.b
    @c.m0
    public final <T extends k0> T b(@c.m0 Class<T> cls, @c.m0 v.a aVar) {
        String str = (String) aVar.a(m0.c.f8340d);
        if (str != null) {
            return this.f8247b != null ? (T) d(str, cls) : (T) e(str, cls, e0.b(aVar));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.m0.d
    @x0({x0.a.LIBRARY_GROUP})
    public void c(@c.m0 k0 k0Var) {
        androidx.savedstate.b bVar = this.f8247b;
        if (bVar != null) {
            LegacySavedStateHandleController.a(k0Var, bVar, this.f8248c);
        }
    }

    @c.m0
    protected abstract <T extends k0> T e(@c.m0 String str, @c.m0 Class<T> cls, @c.m0 d0 d0Var);

    @SuppressLint({"LambdaLast"})
    public a(@c.m0 androidx.savedstate.d dVar, @c.o0 Bundle bundle) {
        this.f8247b = dVar.getSavedStateRegistry();
        this.f8248c = dVar.getLifecycle();
        this.f8249d = bundle;
    }
}
