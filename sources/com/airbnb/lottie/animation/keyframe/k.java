package com.airbnb.lottie.animation.keyframe;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends f<com.airbnb.lottie.value.k> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.airbnb.lottie.value.k f11739i;

    public k(List<com.airbnb.lottie.value.a<com.airbnb.lottie.value.k>> list) {
        super(list);
        this.f11739i = new com.airbnb.lottie.value.k();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.airbnb.lottie.animation.keyframe.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public com.airbnb.lottie.value.k i(com.airbnb.lottie.value.a<com.airbnb.lottie.value.k> aVar, float f8) {
        com.airbnb.lottie.value.k kVar;
        com.airbnb.lottie.value.k kVar2;
        com.airbnb.lottie.value.k kVar3 = aVar.f12349b;
        if (kVar3 == null || (kVar = aVar.f12350c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.airbnb.lottie.value.k kVar4 = kVar3;
        com.airbnb.lottie.value.k kVar5 = kVar;
        com.airbnb.lottie.value.j<A> jVar = this.f11718e;
        if (jVar != 0 && (kVar2 = (com.airbnb.lottie.value.k) jVar.b(aVar.f12352e, aVar.f12353f.floatValue(), kVar4, kVar5, f8, e(), f())) != null) {
            return kVar2;
        }
        this.f11739i.d(com.airbnb.lottie.utils.i.j(kVar4.b(), kVar5.b(), f8), com.airbnb.lottie.utils.i.j(kVar4.c(), kVar5.c(), f8));
        return this.f11739i;
    }
}
