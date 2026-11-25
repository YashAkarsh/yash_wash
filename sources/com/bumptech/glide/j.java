package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class j<ModelType> extends h<ModelType, InputStream, com.bumptech.glide.load.resource.gif.b, com.bumptech.glide.load.resource.gif.b> implements a, e {
    j(a1.f<ModelType, InputStream, com.bumptech.glide.load.resource.gif.b, com.bumptech.glide.load.resource.gif.b> fVar, Class<com.bumptech.glide.load.resource.gif.b> cls, h<ModelType, ?, ?, ?> hVar) {
        super(fVar, cls, hVar);
    }

    private com.bumptech.glide.load.resource.gif.e[] H0(w0.g<Bitmap>[] gVarArr) {
        com.bumptech.glide.load.resource.gif.e[] eVarArr = new com.bumptech.glide.load.resource.gif.e[gVarArr.length];
        for (int i7 = 0; i7 < gVarArr.length; i7++) {
            eVarArr[i7] = new com.bumptech.glide.load.resource.gif.e(gVarArr[i7], this.f14143c.r());
        }
        return eVarArr;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> Q(w0.c cVar) {
        super.Q(cVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> R(float f8) {
        super.R(f8);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> S(boolean z7) {
        super.S(z7);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> T(w0.b<InputStream> bVar) {
        super.T(bVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> U(float f8) {
        super.U(f8);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> V(h<?, ?, ?, com.bumptech.glide.load.resource.gif.b> hVar) {
        super.V(hVar);
        return this;
    }

    public j<ModelType> G0(j<?> jVar) {
        super.V(jVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> W(y0.f<com.bumptech.glide.load.resource.gif.b, com.bumptech.glide.load.resource.gif.b> fVar) {
        super.W(fVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> X(w0.g<com.bumptech.glide.load.resource.gif.b>... gVarArr) {
        super.X(gVarArr);
        return this;
    }

    public j<ModelType> K0(com.bumptech.glide.load.resource.bitmap.e... eVarArr) {
        return X(H0(eVarArr));
    }

    public j<ModelType> L0(w0.g<Bitmap>... gVarArr) {
        return X(H0(gVarArr));
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public j<ModelType> g(int i7) {
        super.g(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    @Deprecated
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public j<ModelType> k(Animation animation) {
        super.k(animation);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> l(com.bumptech.glide.request.animation.f<com.bumptech.glide.load.resource.gif.b> fVar) {
        super.l(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> m(com.bumptech.glide.request.animation.j.a aVar) {
        super.m(aVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> r(w0.e<File, com.bumptech.glide.load.resource.gif.b> eVar) {
        super.r(eVar);
        return this;
    }

    @Override // com.bumptech.glide.a
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> j() {
        return K0(this.f14143c.p());
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> clone() {
        return (j) super.clone();
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> h() {
        super.l(new com.bumptech.glide.request.animation.c());
        return this;
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> b(int i7) {
        super.l(new com.bumptech.glide.request.animation.c(i7));
        return this;
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> i(int i7, int i8) {
        super.l(new com.bumptech.glide.request.animation.c(this.f14142b, i7, i8));
        return this;
    }

    @Override // com.bumptech.glide.e
    @Deprecated
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> c(Animation animation, int i7) {
        super.l(new com.bumptech.glide.request.animation.c(animation, i7));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> t(w0.e<InputStream, com.bumptech.glide.load.resource.gif.b> eVar) {
        super.t(eVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> u(com.bumptech.glide.load.engine.c cVar) {
        super.u(cVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> v() {
        super.v();
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> w() {
        super.w();
        return this;
    }

    @Override // com.bumptech.glide.h
    void n() {
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> x(w0.f<com.bumptech.glide.load.resource.gif.b> fVar) {
        super.x(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    void o() {
        e();
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> y(int i7) {
        super.y(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> z(Drawable drawable) {
        super.z(drawable);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> A(int i7) {
        super.A(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> B(Drawable drawable) {
        super.B(drawable);
        return this;
    }

    @Override // com.bumptech.glide.a
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> e() {
        return K0(this.f14143c.q());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> G(com.bumptech.glide.request.f<? super ModelType, com.bumptech.glide.load.resource.gif.b> fVar) {
        super.G(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> H(ModelType modeltype) {
        super.H(modeltype);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> J(int i7, int i8) {
        super.J(i7, i8);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> L(int i7) {
        super.L(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> M(Drawable drawable) {
        super.M(drawable);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public j<ModelType> P(p pVar) {
        super.P(pVar);
        return this;
    }
}
