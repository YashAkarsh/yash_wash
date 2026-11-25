package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
@h5.h(name = "ViewModelProviderGetKt")
public final class o0 {
    @a7.d
    public static final v.a a(@a7.d q0 owner) {
        kotlin.jvm.internal.l0.p(owner, "owner");
        if (!(owner instanceof l)) {
            return v.a.C0550a.f40425b;
        }
        v.a defaultViewModelCreationExtras = ((l) owner).getDefaultViewModelCreationExtras();
        kotlin.jvm.internal.l0.o(defaultViewModelCreationExtras, "{\n        owner.defaultV…ModelCreationExtras\n    }");
        return defaultViewModelCreationExtras;
    }

    @c.j0
    public static final /* synthetic */ <VM extends k0> VM b(m0 m0Var) {
        kotlin.jvm.internal.l0.p(m0Var, "<this>");
        kotlin.jvm.internal.l0.y(4, "VM");
        return (VM) m0Var.a(k0.class);
    }
}
