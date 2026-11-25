package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f29570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f29571e;

    protected static abstract class a<B extends a<B>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f29572a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f29573b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f29574c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f29575d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f29576e = "";

        public B a(String str) {
            this.f29572a = str;
            return this;
        }

        public B b(String str) {
            this.f29573b = str;
            return this;
        }

        public B c(String str) {
            this.f29574c = str;
            return this;
        }

        public B d(String str) {
            this.f29575d = str;
            return this;
        }

        public B e(String str) {
            this.f29576e = str;
            return this;
        }
    }

    public b(a aVar) {
        this.f29567a = aVar.f29572a;
        this.f29568b = aVar.f29573b;
        this.f29569c = aVar.f29574c;
        this.f29570d = aVar.f29575d;
        this.f29571e = aVar.f29576e;
    }

    public String a() {
        return this.f29567a;
    }

    public String b() {
        return this.f29568b;
    }

    public String c() {
        return this.f29569c;
    }

    public String d() {
        return this.f29570d;
    }

    public String e() {
        return this.f29571e;
    }

    public String toString() {
        return "BaseReq{, psiClientId='" + this.f29567a + "', psiClientSecret='" + this.f29568b + "', apiVersion='" + this.f29569c + "', contentType='" + this.f29570d + "', appId='" + this.f29571e + "'}";
    }
}
