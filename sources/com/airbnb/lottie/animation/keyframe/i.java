package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends f<PointF> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final PointF f11734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f11735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private h f11736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PathMeasure f11737l;

    public i(List<? extends com.airbnb.lottie.value.a<PointF>> list) {
        super(list);
        this.f11734i = new PointF();
        this.f11735j = new float[2];
        this.f11737l = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        h hVar = (h) aVar;
        Path pathJ = hVar.j();
        if (pathJ == null) {
            return aVar.f12349b;
        }
        com.airbnb.lottie.value.j<A> jVar = this.f11718e;
        if (jVar != 0 && (pointF = (PointF) jVar.b(hVar.f12352e, hVar.f12353f.floatValue(), hVar.f12349b, hVar.f12350c, e(), f8, f())) != null) {
            return pointF;
        }
        if (this.f11736k != hVar) {
            this.f11737l.setPath(pathJ, false);
            this.f11736k = hVar;
        }
        PathMeasure pathMeasure = this.f11737l;
        pathMeasure.getPosTan(f8 * pathMeasure.getLength(), this.f11735j, null);
        PointF pointF2 = this.f11734i;
        float[] fArr = this.f11735j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f11734i;
    }
}
