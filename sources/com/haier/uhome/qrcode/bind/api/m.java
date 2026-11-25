package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public class m extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29653a;

    public static class a extends b.a<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f29654f;

        public a f(String str) {
            this.f29654f = str;
            return this;
        }

        public m a() {
            return new m(this);
        }
    }

    public m(a aVar) {
        super(aVar);
        this.f29653a = aVar.f29654f;
    }

    public String f() {
        return this.f29653a;
    }

    @Override // com.haier.uhome.qrcode.bind.api.b
    public String toString() {
        return "RefreshTokenReq{refreshToken='" + this.f29653a + "'}";
    }
}
