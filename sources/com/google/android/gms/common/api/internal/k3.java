package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
public final class k3 extends f3<Void> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n2 f15318c;

    public k3(n2 n2Var, com.google.android.gms.tasks.n<Void> nVar) {
        super(3, nVar);
        this.f15318c = n2Var;
    }

    @Override // com.google.android.gms.common.api.internal.f3, com.google.android.gms.common.api.internal.n3
    public final /* bridge */ /* synthetic */ void d(@c.m0 h0 h0Var, boolean z7) {
    }

    @Override // com.google.android.gms.common.api.internal.e2
    public final boolean f(v1<?> v1Var) {
        return this.f15318c.f15355a.f();
    }

    @Override // com.google.android.gms.common.api.internal.e2
    @c.o0
    public final Feature[] g(v1<?> v1Var) {
        return this.f15318c.f15355a.c();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.common.api.internal.f3
    public final void h(v1<?> v1Var) throws RemoteException {
        this.f15318c.f15355a.d(v1Var.s(), this.f15209b);
        n.a<?> aVarB = this.f15318c.f15355a.b();
        if (aVarB != null) {
            v1Var.u().put(aVarB, this.f15318c);
        }
    }
}
