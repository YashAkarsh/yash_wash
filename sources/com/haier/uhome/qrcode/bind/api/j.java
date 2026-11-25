package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public class j extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f29633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29634b;

    public static class a extends b.a<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f29635f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f29636g;

        public a f(String str) {
            this.f29636g = str;
            return this;
        }

        public a a(c cVar) {
            this.f29635f = cVar;
            return this;
        }

        public j a() {
            return new j(this);
        }
    }

    public j(a aVar) {
        super(aVar);
        this.f29633a = aVar.f29635f;
        this.f29634b = aVar.f29636g;
    }

    public c f() {
        return this.f29633a;
    }

    public String g() {
        return this.f29634b;
    }

    @Override // com.haier.uhome.qrcode.bind.api.b
    public String toString() {
        return "QrLoginStageReq{action=" + this.f29633a + ", token='" + this.f29634b + "'}";
    }
}
