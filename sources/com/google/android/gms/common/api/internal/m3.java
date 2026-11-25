package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;

/* JADX INFO: loaded from: classes.dex */
public final class m3 extends f3<Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n.a<?> f15332c;

    public m3(n.a<?> aVar, com.google.android.gms.tasks.n<Boolean> nVar) {
        super(4, nVar);
        this.f15332c = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.f3, com.google.android.gms.common.api.internal.n3
    public final /* bridge */ /* synthetic */ void d(@c.m0 h0 h0Var, boolean z7) {
    }

    @Override // com.google.android.gms.common.api.internal.e2
    public final boolean f(v1<?> v1Var) {
        n2 n2Var = v1Var.u().get(this.f15332c);
        return n2Var != null && n2Var.f15355a.f();
    }

    @Override // com.google.android.gms.common.api.internal.e2
    @c.o0
    public final Feature[] g(v1<?> v1Var) {
        n2 n2Var = v1Var.u().get(this.f15332c);
        if (n2Var == null) {
            return null;
        }
        return n2Var.f15355a.c();
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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v4 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.google.android.gms.common.api.internal.f3
    public final void h(com.google.android.gms.common.api.internal.v1<?> r4) throws android.os.RemoteException {
        /*
            r3 = this;
            java.util.Map r0 = r4.u()
            com.google.android.gms.common.api.internal.n$a<?> r1 = r3.f15332c
            java.lang.Object r0 = r0.remove(r1)
            com.google.android.gms.common.api.internal.n2 r0 = (com.google.android.gms.common.api.internal.n2) r0
            if (r0 == 0) goto L1f
            com.google.android.gms.common.api.internal.c0<com.google.android.gms.common.api.a$b, ?> r1 = r0.f15356b
            com.google.android.gms.common.api.a$f r4 = r4.s()
            com.google.android.gms.tasks.n<T> r2 = r3.f15209b
            r1.b(r4, r2)
            com.google.android.gms.common.api.internal.t<com.google.android.gms.common.api.a$b, ?> r4 = r0.f15355a
            r4.a()
            return
        L1f:
            com.google.android.gms.tasks.n<T> r4 = r3.f15209b
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.e(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.m3.h(com.google.android.gms.common.api.internal.v1):void");
    }
}
