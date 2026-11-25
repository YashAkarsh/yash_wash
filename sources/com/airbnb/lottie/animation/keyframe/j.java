package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class j extends f<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f11738i;

    public j(List<com.airbnb.lottie.value.a<PointF>> list) {
        super(list);
        this.f11738i = new PointF();
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
    public PointF i(com.airbnb.lottie.value.a<PointF> aVar, float f8) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f12349b;
        if (pointF3 == null || (pointF = aVar.f12350c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        com.airbnb.lottie.value.j<A> jVar = this.f11718e;
        if (jVar != 0 && (pointF2 = (PointF) jVar.b(aVar.f12352e, aVar.f12353f.floatValue(), pointF4, pointF5, f8, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f11738i;
        float f9 = pointF4.x;
        float f10 = f9 + ((pointF5.x - f9) * f8);
        float f11 = pointF4.y;
        pointF6.set(f10, f11 + (f8 * (pointF5.y - f11)));
        return this.f11738i;
    }
}
