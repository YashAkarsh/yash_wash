package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import c.x0;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
public final class h0 extends m0.d implements m0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private Application f8296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final m0.b f8297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private Bundle f8298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private m f8299e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.e
    private androidx.savedstate.b f8300f;

    public h0() {
        this.f8297c = new m0.a();
    }

    @Override // androidx.lifecycle.m0.b
    @a7.d
    public <T extends k0> T a(@a7.d Class<T> modelClass) {
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) d(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.m0.b
    @a7.d
    public <T extends k0> T b(@a7.d Class<T> modelClass, @a7.d v.a extras) {
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        kotlin.jvm.internal.l0.p(extras, "extras");
        String str = (String) extras.a(m0.c.f8340d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(e0.f8286c) == null || extras.a(e0.f8287d) == null) {
            if (this.f8299e != null) {
                return (T) d(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(m0.a.f8333i);
        boolean zIsAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? i0.c(modelClass, i0.f8302b) : i0.c(modelClass, i0.f8301a);
        if (constructorC == null) {
            return (T) this.f8297c.b(modelClass, extras);
        }
        return (!zIsAssignableFrom || application == null) ? (T) i0.d(modelClass, constructorC, e0.b(extras)) : (T) i0.d(modelClass, constructorC, application, e0.b(extras));
    }

    @Override // androidx.lifecycle.m0.d
    @x0({x0.a.LIBRARY_GROUP})
    public void c(@a7.d k0 viewModel) {
        kotlin.jvm.internal.l0.p(viewModel, "viewModel");
        m mVar = this.f8299e;
        if (mVar != null) {
            LegacySavedStateHandleController.a(viewModel, this.f8300f, mVar);
        }
    }

    @a7.d
    public final <T extends k0> T d(@a7.d String key, @a7.d Class<T> modelClass) {
        T t7;
        Application application;
        kotlin.jvm.internal.l0.p(key, "key");
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        if (this.f8299e == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f8296b == null) ? i0.c(modelClass, i0.f8302b) : i0.c(modelClass, i0.f8301a);
        if (constructorC == null) {
            return this.f8296b != null ? (T) this.f8297c.a(modelClass) : (T) m0.c.f8338b.a().a(modelClass);
        }
        SavedStateHandleController savedStateHandleControllerB = LegacySavedStateHandleController.b(this.f8300f, this.f8299e, key, this.f8298d);
        if (!zIsAssignableFrom || (application = this.f8296b) == null) {
            d0 d0VarI = savedStateHandleControllerB.i();
            kotlin.jvm.internal.l0.o(d0VarI, "controller.handle");
            t7 = (T) i0.d(modelClass, constructorC, d0VarI);
        } else {
            kotlin.jvm.internal.l0.m(application);
            d0 d0VarI2 = savedStateHandleControllerB.i();
            kotlin.jvm.internal.l0.o(d0VarI2, "controller.handle");
            t7 = (T) i0.d(modelClass, constructorC, application, d0VarI2);
        }
        t7.f("androidx.lifecycle.savedstate.vm.tag", savedStateHandleControllerB);
        return t7;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h0(@a7.e Application application, @a7.d androidx.savedstate.d owner) {
        this(application, owner, null);
        kotlin.jvm.internal.l0.p(owner, "owner");
    }

    @SuppressLint({"LambdaLast"})
    public h0(@a7.e Application application, @a7.d androidx.savedstate.d owner, @a7.e Bundle bundle) {
        m0.a aVar;
        kotlin.jvm.internal.l0.p(owner, "owner");
        this.f8300f = owner.getSavedStateRegistry();
        this.f8299e = owner.getLifecycle();
        this.f8298d = bundle;
        this.f8296b = application;
        if (application != null) {
            aVar = m0.a.f8330f.b(application);
        } else {
            aVar = new m0.a();
        }
        this.f8297c = aVar;
    }
}
