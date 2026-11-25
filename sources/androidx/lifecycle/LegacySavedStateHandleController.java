package androidx.lifecycle;

import android.os.Bundle;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class LegacySavedStateHandleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f8211a = "androidx.lifecycle.savedstate.vm.tag";

    static final class a implements androidx.savedstate.b.a {
        a() {
        }

        @Override // androidx.savedstate.b.a
        public void a(@c.m0 androidx.savedstate.d dVar) {
            if (!(dVar instanceof q0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            p0 viewModelStore = ((q0) dVar).getViewModelStore();
            androidx.savedstate.b savedStateRegistry = dVar.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.a(viewModelStore.b(it.next()), savedStateRegistry, dVar.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.k(a.class);
        }
    }

    private LegacySavedStateHandleController() {
    }

    static void a(k0 k0Var, androidx.savedstate.b bVar, m mVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) k0Var.d(f8211a);
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.h(bVar, mVar);
        c(bVar, mVar);
    }

    static SavedStateHandleController b(androidx.savedstate.b bVar, m mVar, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, d0.g(bVar.b(str), bundle));
        savedStateHandleController.h(bVar, mVar);
        c(bVar, mVar);
        return savedStateHandleController;
    }

    private static void c(final androidx.savedstate.b bVar, final m mVar) {
        m.c cVarB = mVar.b();
        if (cVarB == m.c.INITIALIZED || cVarB.a(m.c.STARTED)) {
            bVar.k(a.class);
        } else {
            mVar.a(new o() { // from class: androidx.lifecycle.LegacySavedStateHandleController.1
                @Override // androidx.lifecycle.o
                public void g(@c.m0 q qVar, @c.m0 m.b bVar2) {
                    if (bVar2 == m.b.ON_START) {
                        mVar.c(this);
                        bVar.k(a.class);
                    }
                }
            });
        }
    }
}
