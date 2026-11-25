package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.bitmap.t;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b<ModelType, TranscodeType> extends h<ModelType, com.bumptech.glide.load.model.g, Bitmap, TranscodeType> implements a, e {
    private final com.bumptech.glide.load.engine.bitmap_recycle.c D;
    private com.bumptech.glide.load.resource.bitmap.g E;
    private w0.a F;
    private w0.e<InputStream, Bitmap> G;
    private w0.e<ParcelFileDescriptor, Bitmap> H;

    b(a1.f<ModelType, com.bumptech.glide.load.model.g, Bitmap, TranscodeType> fVar, Class<TranscodeType> cls, h<ModelType, ?, ?, ?> hVar) {
        super(fVar, cls, hVar);
        this.E = com.bumptech.glide.load.resource.bitmap.g.f14533d;
        com.bumptech.glide.load.engine.bitmap_recycle.c cVarR = hVar.f14143c.r();
        this.D = cVarR;
        w0.a aVarS = hVar.f14143c.s();
        this.F = aVarS;
        this.G = new r(cVarR, aVarS);
        this.H = new com.bumptech.glide.load.resource.bitmap.i(cVarR, this.F);
    }

    private RuntimeException m0() {
        String canonicalName = this.f14144d.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = this.f14144d.toString();
        }
        return new UnsupportedOperationException(".crossFade() is not supported for " + canonicalName + ", use .animate() to provide a compatible animation.");
    }

    private b<ModelType, TranscodeType> s0(com.bumptech.glide.load.resource.bitmap.g gVar) {
        this.E = gVar;
        r rVar = new r(gVar, this.D, this.F);
        this.G = rVar;
        super.t(new com.bumptech.glide.load.resource.bitmap.n(rVar, this.H));
        return this;
    }

    public b<ModelType, TranscodeType> A0(w0.e<InputStream, Bitmap> eVar) {
        this.G = eVar;
        super.t(new com.bumptech.glide.load.resource.bitmap.n(eVar, this.H));
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> G(com.bumptech.glide.request.f<? super ModelType, TranscodeType> fVar) {
        super.G(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> H(ModelType modeltype) {
        super.H(modeltype);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> J(int i7, int i8) {
        super.J(i7, i8);
        return this;
    }

    @Override // com.bumptech.glide.h
    public com.bumptech.glide.request.target.m<TranscodeType> E(ImageView imageView) {
        return super.E(imageView);
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> L(int i7) {
        super.L(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> M(Drawable drawable) {
        super.M(drawable);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> P(p pVar) {
        super.P(pVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> Q(w0.c cVar) {
        super.Q(cVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> R(float f8) {
        super.R(f8);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> S(boolean z7) {
        super.S(z7);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> T(w0.b<com.bumptech.glide.load.model.g> bVar) {
        super.T(bVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> U(float f8) {
        super.U(f8);
        return this;
    }

    public b<ModelType, TranscodeType> M0(b<?, TranscodeType> bVar) {
        super.V(bVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> V(h<?, ?, ?, TranscodeType> hVar) {
        super.V(hVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> W(y0.f<Bitmap, TranscodeType> fVar) {
        super.W(fVar);
        return this;
    }

    public b<ModelType, TranscodeType> P0(com.bumptech.glide.load.resource.bitmap.e... eVarArr) {
        super.X(eVarArr);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> X(w0.g<Bitmap>... gVarArr) {
        super.X(gVarArr);
        return this;
    }

    public b<ModelType, TranscodeType> R0(w0.e<ParcelFileDescriptor, Bitmap> eVar) {
        this.H = eVar;
        super.t(new com.bumptech.glide.load.resource.bitmap.n(this.G, eVar));
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> g(int i7) {
        super.g(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    @Deprecated
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> k(Animation animation) {
        super.k(animation);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> l(com.bumptech.glide.request.animation.f<TranscodeType> fVar) {
        super.l(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> m(com.bumptech.glide.request.animation.j.a aVar) {
        super.m(aVar);
        return this;
    }

    public b<ModelType, TranscodeType> c0() {
        return s0(com.bumptech.glide.load.resource.bitmap.g.f14533d);
    }

    public b<ModelType, TranscodeType> d0() {
        return s0(com.bumptech.glide.load.resource.bitmap.g.f14535f);
    }

    public b<ModelType, TranscodeType> e0() {
        return s0(com.bumptech.glide.load.resource.bitmap.g.f14534e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> r(w0.e<File, Bitmap> eVar) {
        super.r(eVar);
        return this;
    }

    @Override // com.bumptech.glide.a
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> j() {
        return P0(this.f14143c.p());
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> clone() {
        return (b) super.clone();
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public final b<ModelType, TranscodeType> h() {
        if (Bitmap.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.b());
        }
        if (Drawable.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.c());
        }
        throw m0();
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> b(int i7) {
        if (Bitmap.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.b(i7));
        }
        if (Drawable.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.c(i7));
        }
        throw m0();
    }

    @Override // com.bumptech.glide.e
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> i(int i7, int i8) {
        if (Bitmap.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.b(this.f14142b, i7, i8));
        }
        if (Drawable.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.c(this.f14142b, i7, i8));
        }
        throw m0();
    }

    @Override // com.bumptech.glide.e
    @Deprecated
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> c(Animation animation, int i7) {
        if (Bitmap.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.b(animation, i7));
        }
        if (Drawable.class.isAssignableFrom(this.f14144d)) {
            return l(new com.bumptech.glide.request.animation.c(animation, i7));
        }
        throw m0();
    }

    @Override // com.bumptech.glide.h
    void n() {
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> t(w0.e<com.bumptech.glide.load.model.g, Bitmap> eVar) {
        super.t(eVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    void o() {
        e();
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> u(com.bumptech.glide.load.engine.c cVar) {
        super.u(cVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> v() {
        super.v();
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> w() {
        super.w();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> x(w0.f<Bitmap> fVar) {
        super.x(fVar);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> y(int i7) {
        super.y(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> z(Drawable drawable) {
        super.z(drawable);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> A(int i7) {
        super.A(i7);
        return this;
    }

    @Override // com.bumptech.glide.h
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> B(Drawable drawable) {
        super.B(drawable);
        return this;
    }

    @Override // com.bumptech.glide.a
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public b<ModelType, TranscodeType> e() {
        return P0(this.f14143c.q());
    }

    public b<ModelType, TranscodeType> z0(w0.a aVar) {
        this.F = aVar;
        this.G = new r(this.E, this.D, aVar);
        this.H = new com.bumptech.glide.load.resource.bitmap.i(new t(), this.D, aVar);
        super.r(new com.bumptech.glide.load.resource.file.c(new r(this.E, this.D, aVar)));
        super.t(new com.bumptech.glide.load.resource.bitmap.n(this.G, this.H));
        return this;
    }
}
