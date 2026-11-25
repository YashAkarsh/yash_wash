package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class f<ModelType> extends h<ModelType, com.bumptech.glide.load.model.g, com.bumptech.glide.load.resource.gifbitmap.a, com.bumptech.glide.load.resource.drawable.b> implements a, e {
    f(Context context, Class<ModelType> cls, a1.f<ModelType, com.bumptech.glide.load.model.g, com.bumptech.glide.load.resource.gifbitmap.a, com.bumptech.glide.load.resource.drawable.b> fVar, l lVar, com.bumptech.glide.manager.m mVar, com.bumptech.glide.manager.g gVar) {
        super(context, cls, fVar, com.bumptech.glide.load.resource.drawable.b.class, lVar, mVar, gVar);
        h();
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> P(p pVar) {
        super.P(pVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> Q(w0.c cVar) {
        super.Q(cVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> R(float f8) {
        super.R(f8);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> S(boolean z7) {
        super.S(z7);
        return this;
    }

    @Override // com.bumptech.glide.h
    public com.bumptech.glide.request.target.m<com.bumptech.glide.load.resource.drawable.b> E(ImageView imageView) {
        return super.E(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> T(w0.b<com.bumptech.glide.load.model.g> bVar) {
        super.T(bVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> U(float f8) {
        super.U(f8);
        return this;
    }

    public f<ModelType> G0(f<?> fVar) {
        super.V(fVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> V(h<?, ?, ?, com.bumptech.glide.load.resource.drawable.b> hVar) {
        super.V(hVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> W(y0.f<com.bumptech.glide.load.resource.gifbitmap.a, com.bumptech.glide.load.resource.drawable.b> fVar) {
        super.W(fVar);
        return this;
    }

    public f<ModelType> J0(com.bumptech.glide.load.resource.bitmap.e... eVarArr) {
        return c0(eVarArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> X(w0.g<com.bumptech.glide.load.resource.gifbitmap.a>... gVarArr) {
        super.X(gVarArr);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public f<ModelType> g(int i7) {
        super.g(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    @Deprecated
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public f<ModelType> k(Animation animation) {
        super.k(animation);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> l(com.bumptech.glide.request.animation.f<com.bumptech.glide.load.resource.drawable.b> fVar) {
        super.l(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> m(com.bumptech.glide.request.animation.j.a aVar) {
        super.m(aVar);
        return this;
    }

    public f<ModelType> c0(w0.g<Bitmap>... gVarArr) {
        com.bumptech.glide.load.resource.gifbitmap.f[] fVarArr = new com.bumptech.glide.load.resource.gifbitmap.f[gVarArr.length];
        for (int i7 = 0; i7 < gVarArr.length; i7++) {
            fVarArr[i7] = new com.bumptech.glide.load.resource.gifbitmap.f(this.f14143c.r(), gVarArr[i7]);
        }
        return X(fVarArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> r(w0.e<File, com.bumptech.glide.load.resource.gifbitmap.a> eVar) {
        super.r(eVar);
        return this;
    }

    @Override // com.bumptech.glide.a
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> j() {
        return X(this.f14143c.t());
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> clone() {
        return (f) super.clone();
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public final f<ModelType> h() {
        super.l(new com.bumptech.glide.request.animation.c());
        return this;
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> b(int i7) {
        super.l(new com.bumptech.glide.request.animation.c(i7));
        return this;
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> i(int i7, int i8) {
        super.l(new com.bumptech.glide.request.animation.c(this.f14142b, i7, i8));
        return this;
    }

    @Override // com.bumptech.glide.e
    @Deprecated
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> c(Animation animation, int i7) {
        super.l(new com.bumptech.glide.request.animation.c(animation, i7));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> t(w0.e<com.bumptech.glide.load.model.g, com.bumptech.glide.load.resource.gifbitmap.a> eVar) {
        super.t(eVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> u(com.bumptech.glide.load.engine.c cVar) {
        super.u(cVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> v() {
        super.v();
        return this;
    }

    @Override // com.bumptech.glide.h
    void n() {
        j();
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> w() {
        super.w();
        return this;
    }

    @Override // com.bumptech.glide.h
    void o() {
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> x(w0.f<com.bumptech.glide.load.resource.gifbitmap.a> fVar) {
        super.x(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> y(int i7) {
        super.y(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> z(Drawable drawable) {
        super.z(drawable);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> A(int i7) {
        super.A(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> B(Drawable drawable) {
        super.B(drawable);
        return this;
    }

    @Override // com.bumptech.glide.a
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> e() {
        return X(this.f14143c.u());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> G(com.bumptech.glide.request.f<? super ModelType, com.bumptech.glide.load.resource.drawable.b> fVar) {
        super.G(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> H(ModelType modeltype) {
        super.H(modeltype);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> J(int i7, int i8) {
        super.J(i7, i8);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> L(int i7) {
        super.L(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public f<ModelType> M(Drawable drawable) {
        super.M(drawable);
        return this;
    }
}
