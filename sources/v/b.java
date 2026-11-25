package v;

import androidx.lifecycle.k0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class b implements m0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final g<?>[] f40426b;

    public b(@a7.d g<?>... initializers) {
        l0.p(initializers, "initializers");
        this.f40426b = initializers;
    }

    @Override // androidx.lifecycle.m0.b
    public /* synthetic */ k0 a(Class cls) {
        return n0.a(this, cls);
    }

    @Override // androidx.lifecycle.m0.b
    @a7.d
    public <T extends k0> T b(@a7.d Class<T> modelClass, @a7.d a extras) {
        l0.p(modelClass, "modelClass");
        l0.p(extras, "extras");
        T t7 = null;
        for (g<?> gVar : this.f40426b) {
            if (l0.g(gVar.a(), modelClass)) {
                T tZ = gVar.b().z(extras);
                t7 = tZ instanceof k0 ? tZ : null;
            }
        }
        if (t7 != null) {
            return t7;
        }
        throw new IllegalArgumentException("No initializer set for given class " + modelClass.getName());
    }
}
