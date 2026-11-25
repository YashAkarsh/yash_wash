package com.haier.uhome.control.local.b;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f29367b;

    public f() {
        this.f29367b = new e();
    }

    @Override // com.haier.uhome.control.local.b.e
    public String a() {
        String strA = this.f29367b.a();
        return strA == null ? "" : strA;
    }

    @Override // com.haier.uhome.control.local.b.e
    public String b() {
        String strB = this.f29367b.b();
        return strB == null ? "" : strB;
    }

    @Override // com.haier.uhome.control.local.b.e
    public int[] c() {
        return this.f29367b.c();
    }

    @Override // com.haier.uhome.control.local.b.e
    public int d(String str) {
        return this.f29367b.d(str);
    }

    @Override // com.haier.uhome.control.local.b.e
    public String toString() {
        return "OtaInfoWrapper{isModuleNeedOTA=" + this.f29366a + ", otaInfo=" + this.f29367b + '}';
    }

    public boolean d() {
        return this.f29366a;
    }

    public f(e eVar) {
        this.f29366a = true;
        this.f29367b = eVar;
    }
}
