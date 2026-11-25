package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public class h extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f29614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f29615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f29619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29621h;

    public static class a extends b.a<a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f29622f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f29623g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f29624h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f29625i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f29626j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f29627k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f29628l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f29629m;

        @Override // com.haier.uhome.qrcode.bind.api.b.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a c(String str) {
            this.f29627k = str;
            return this;
        }

        @Override // com.haier.uhome.qrcode.bind.api.b.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a d(String str) {
            this.f29628l = str;
            return this;
        }

        public a a(c cVar) {
            this.f29622f = cVar;
            return this;
        }

        public a b(int i7) {
            this.f29624h = i7;
            return this;
        }

        public a f(String str) {
            this.f29625i = str;
            return this;
        }

        public a g(String str) {
            this.f29626j = str;
            return this;
        }

        public a a(int i7) {
            this.f29623g = i7;
            return this;
        }

        public h a() {
            return new h(this);
        }
    }

    public h(a aVar) {
        super(aVar);
        this.f29614a = aVar.f29622f;
        this.f29615b = aVar.f29623g;
        this.f29616c = aVar.f29624h;
        this.f29617d = aVar.f29625i;
        this.f29618e = aVar.f29626j;
        this.f29619f = aVar.f29627k;
        this.f29620g = aVar.f29628l;
    }

    @Override // com.haier.uhome.qrcode.bind.api.b
    public String c() {
        return this.f29619f;
    }

    @Override // com.haier.uhome.qrcode.bind.api.b
    public String d() {
        return this.f29620g;
    }

    public c f() {
        return this.f29614a;
    }

    public int g() {
        return this.f29615b;
    }

    public int h() {
        return this.f29616c;
    }

    public String i() {
        return this.f29617d;
    }

    public String j() {
        return this.f29618e;
    }

    public String k() {
        return this.f29621h;
    }

    @Override // com.haier.uhome.qrcode.bind.api.b
    public String toString() {
        return "QrCodeReq{action=" + this.f29614a + ", width=" + this.f29615b + ", height=" + this.f29616c + ", deviceId='" + this.f29617d + "', typeId='" + this.f29618e + "', apiVersion='" + this.f29619f + "', contentType='" + this.f29620g + "', imageType='" + this.f29621h + "'}";
    }
}
