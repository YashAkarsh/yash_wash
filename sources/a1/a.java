package a1;

import com.bumptech.glide.load.model.l;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a<A, T, Z, R> implements f<A, T, Z, R>, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<A, T, Z, R> f10a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w0.e<File, Z> f11b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private w0.e<T, Z> f12c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private w0.f<Z> f13d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private y0.f<Z, R> f14e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private w0.b<T> f15f;

    public a(f<A, T, Z, R> fVar) {
        this.f10a = fVar;
    }

    @Override // a1.b
    public w0.b<T> e() {
        w0.b<T> bVar = this.f15f;
        return bVar != null ? bVar : this.f10a.e();
    }

    @Override // a1.f
    public y0.f<Z, R> h() {
        y0.f<Z, R> fVar = this.f14e;
        return fVar != null ? fVar : this.f10a.h();
    }

    @Override // a1.b
    public w0.f<Z> i() {
        w0.f<Z> fVar = this.f13d;
        return fVar != null ? fVar : this.f10a.i();
    }

    @Override // a1.b
    public w0.e<T, Z> j() {
        w0.e<T, Z> eVar = this.f12c;
        return eVar != null ? eVar : this.f10a.j();
    }

    @Override // a1.b
    public w0.e<File, Z> k() {
        w0.e<File, Z> eVar = this.f11b;
        return eVar != null ? eVar : this.f10a.k();
    }

    @Override // a1.f
    public l<A, T> l() {
        return this.f10a.l();
    }

    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a<A, T, Z, R> clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e8) {
            throw new RuntimeException(e8);
        }
    }

    public void n(w0.e<File, Z> eVar) {
        this.f11b = eVar;
    }

    public void o(w0.f<Z> fVar) {
        this.f13d = fVar;
    }

    public void p(w0.e<T, Z> eVar) {
        this.f12c = eVar;
    }

    public void q(w0.b<T> bVar) {
        this.f15f = bVar;
    }

    public void r(y0.f<Z, R> fVar) {
        this.f14e = fVar;
    }
}
