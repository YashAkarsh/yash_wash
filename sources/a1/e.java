package a1;

import com.bumptech.glide.load.model.l;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class e<A, T, Z, R> implements f<A, T, Z, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<A, T> f19a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y0.f<Z, R> f20b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<T, Z> f21c;

    public e(l<A, T> lVar, y0.f<Z, R> fVar, b<T, Z> bVar) {
        if (lVar == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f19a = lVar;
        if (fVar == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f20b = fVar;
        if (bVar == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f21c = bVar;
    }

    @Override // a1.b
    public w0.b<T> e() {
        return this.f21c.e();
    }

    @Override // a1.f
    public y0.f<Z, R> h() {
        return this.f20b;
    }

    @Override // a1.b
    public w0.f<Z> i() {
        return this.f21c.i();
    }

    @Override // a1.b
    public w0.e<T, Z> j() {
        return this.f21c.j();
    }

    @Override // a1.b
    public w0.e<File, Z> k() {
        return this.f21c.k();
    }

    @Override // a1.f
    public l<A, T> l() {
        return this.f19a;
    }
}
