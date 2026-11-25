package com.haier.globalwasher.mvp_api.volley.toolbox;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class t extends com.haier.globalwasher.mvp_api.volley.n<String> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.volley.p.b<String> f25038r;

    public t(int i7, String str, com.haier.globalwasher.mvp_api.volley.p.b<String> bVar, com.haier.globalwasher.mvp_api.moudle.b<String> bVar2) {
        super(i7, str, bVar2);
        this.f25038r = bVar;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected void J() {
        super.J();
        this.f25038r = null;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected com.haier.globalwasher.mvp_api.volley.p<String> L(com.haier.globalwasher.mvp_api.volley.j jVar) {
        String str;
        try {
            str = new String(jVar.f24843b, i.b(jVar.f24844c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(jVar.f24843b);
        }
        return com.haier.globalwasher.mvp_api.volley.p.c(str, i.a(jVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.haier.globalwasher.mvp_api.volley.n
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void g(String str) {
        com.haier.globalwasher.mvp_api.volley.p.b<String> bVar = this.f25038r;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    public t(String str, com.haier.globalwasher.mvp_api.volley.p.b<String> bVar, com.haier.globalwasher.mvp_api.moudle.b<String> bVar2) {
        this(0, str, bVar, bVar2);
    }
}
