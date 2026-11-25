package com.airbnb.lottie.animation.keyframe;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<com.airbnb.lottie.value.a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
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
    public int p(com.airbnb.lottie.value.a<Integer> aVar, float f8) {
        Integer num;
        Integer num2 = aVar.f12349b;
        if (num2 == null || aVar.f12350c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = aVar.f12350c.intValue();
        com.airbnb.lottie.value.j<A> jVar = this.f11718e;
        return (jVar == 0 || (num = (Integer) jVar.b(aVar.f12352e, aVar.f12353f.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f8, e(), f())) == null) ? com.airbnb.lottie.utils.d.c(com.airbnb.lottie.utils.i.b(f8, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.airbnb.lottie.animation.keyframe.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer i(com.airbnb.lottie.value.a<Integer> aVar, float f8) {
        return Integer.valueOf(p(aVar, f8));
    }
}
