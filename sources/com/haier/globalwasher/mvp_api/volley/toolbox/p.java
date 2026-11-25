package com.haier.globalwasher.mvp_api.volley.toolbox;

import com.haier.globalwasher.mvp_api.volley.v;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p<T> extends com.haier.globalwasher.mvp_api.volley.n<T> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected static final String f25028t = "utf-8";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f25029u = String.format("application/json; charset=%s", f25028t);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.volley.p.b<T> f25030r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f25031s;

    @Deprecated
    public p(String str, String str2, com.haier.globalwasher.mvp_api.volley.p.b<T> bVar, com.haier.globalwasher.mvp_api.moudle.b<T> bVar2) {
        this(-1, str, str2, bVar, bVar2);
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected void J() {
        super.J();
        this.f25030r = null;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected abstract com.haier.globalwasher.mvp_api.volley.p<T> L(com.haier.globalwasher.mvp_api.volley.j jVar);

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected void g(T t7) {
        com.haier.globalwasher.mvp_api.volley.p.b<T> bVar = this.f25030r;
        if (bVar != null) {
            bVar.b(t7);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public byte[] k() {
        try {
            String str = this.f25031s;
            if (str == null) {
                return null;
            }
            return str.getBytes(f25028t);
        } catch (UnsupportedEncodingException unused) {
            v.g("Unsupported Encoding while trying to get the bytes of %s using %s", this.f25031s, f25028t);
            return null;
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public String l() {
        return f25029u;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    @Deprecated
    public byte[] v() {
        return k();
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    @Deprecated
    public String w() {
        return l();
    }

    @Deprecated
    public p(int i7, String str, String str2, com.haier.globalwasher.mvp_api.volley.p.b<T> bVar, com.haier.globalwasher.mvp_api.moudle.b<T> bVar2) {
        super(i7, str, bVar2);
        this.f25030r = bVar;
        this.f25031s = str2;
    }
}
