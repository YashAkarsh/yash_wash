package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
class g implements w0.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f14394o = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w0.e f14398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w0.e f14399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final w0.g f14400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final w0.f f14401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final y0.f f14402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final w0.b f14403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final w0.c f14404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f14405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private w0.c f14407n;

    public g(String str, w0.c cVar, int i7, int i8, w0.e eVar, w0.e eVar2, w0.g gVar, w0.f fVar, y0.f fVar2, w0.b bVar) {
        this.f14395b = str;
        this.f14404k = cVar;
        this.f14396c = i7;
        this.f14397d = i8;
        this.f14398e = eVar;
        this.f14399f = eVar2;
        this.f14400g = gVar;
        this.f14401h = fVar;
        this.f14402i = fVar2;
        this.f14403j = bVar;
    }

    @Override // w0.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] bArrArray = ByteBuffer.allocate(8).putInt(this.f14396c).putInt(this.f14397d).array();
        this.f14404k.a(messageDigest);
        messageDigest.update(this.f14395b.getBytes("UTF-8"));
        messageDigest.update(bArrArray);
        w0.e eVar = this.f14398e;
        messageDigest.update((eVar != null ? eVar.a() : "").getBytes("UTF-8"));
        w0.e eVar2 = this.f14399f;
        messageDigest.update((eVar2 != null ? eVar2.a() : "").getBytes("UTF-8"));
        w0.g gVar = this.f14400g;
        messageDigest.update((gVar != null ? gVar.a() : "").getBytes("UTF-8"));
        w0.f fVar = this.f14401h;
        messageDigest.update((fVar != null ? fVar.a() : "").getBytes("UTF-8"));
        w0.b bVar = this.f14403j;
        messageDigest.update((bVar != null ? bVar.a() : "").getBytes("UTF-8"));
    }

    public w0.c b() {
        if (this.f14407n == null) {
            this.f14407n = new l(this.f14395b, this.f14404k);
        }
        return this.f14407n;
    }

    @Override // w0.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.f14395b.equals(gVar.f14395b) || !this.f14404k.equals(gVar.f14404k) || this.f14397d != gVar.f14397d || this.f14396c != gVar.f14396c) {
            return false;
        }
        w0.g gVar2 = this.f14400g;
        if ((gVar2 == null) ^ (gVar.f14400g == null)) {
            return false;
        }
        if (gVar2 != null && !gVar2.a().equals(gVar.f14400g.a())) {
            return false;
        }
        w0.e eVar = this.f14399f;
        if ((eVar == null) ^ (gVar.f14399f == null)) {
            return false;
        }
        if (eVar != null && !eVar.a().equals(gVar.f14399f.a())) {
            return false;
        }
        w0.e eVar2 = this.f14398e;
        if ((eVar2 == null) ^ (gVar.f14398e == null)) {
            return false;
        }
        if (eVar2 != null && !eVar2.a().equals(gVar.f14398e.a())) {
            return false;
        }
        w0.f fVar = this.f14401h;
        if ((fVar == null) ^ (gVar.f14401h == null)) {
            return false;
        }
        if (fVar != null && !fVar.a().equals(gVar.f14401h.a())) {
            return false;
        }
        y0.f fVar2 = this.f14402i;
        if ((fVar2 == null) ^ (gVar.f14402i == null)) {
            return false;
        }
        if (fVar2 != null && !fVar2.a().equals(gVar.f14402i.a())) {
            return false;
        }
        w0.b bVar = this.f14403j;
        if ((bVar == null) ^ (gVar.f14403j == null)) {
            return false;
        }
        return bVar == null || bVar.a().equals(gVar.f14403j.a());
    }

    @Override // w0.c
    public int hashCode() {
        if (this.f14406m == 0) {
            int iHashCode = this.f14395b.hashCode();
            this.f14406m = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f14404k.hashCode()) * 31) + this.f14396c) * 31) + this.f14397d;
            this.f14406m = iHashCode2;
            int i7 = iHashCode2 * 31;
            w0.e eVar = this.f14398e;
            int iHashCode3 = i7 + (eVar != null ? eVar.a().hashCode() : 0);
            this.f14406m = iHashCode3;
            int i8 = iHashCode3 * 31;
            w0.e eVar2 = this.f14399f;
            int iHashCode4 = i8 + (eVar2 != null ? eVar2.a().hashCode() : 0);
            this.f14406m = iHashCode4;
            int i9 = iHashCode4 * 31;
            w0.g gVar = this.f14400g;
            int iHashCode5 = i9 + (gVar != null ? gVar.a().hashCode() : 0);
            this.f14406m = iHashCode5;
            int i10 = iHashCode5 * 31;
            w0.f fVar = this.f14401h;
            int iHashCode6 = i10 + (fVar != null ? fVar.a().hashCode() : 0);
            this.f14406m = iHashCode6;
            int i11 = iHashCode6 * 31;
            y0.f fVar2 = this.f14402i;
            int iHashCode7 = i11 + (fVar2 != null ? fVar2.a().hashCode() : 0);
            this.f14406m = iHashCode7;
            int i12 = iHashCode7 * 31;
            w0.b bVar = this.f14403j;
            this.f14406m = i12 + (bVar != null ? bVar.a().hashCode() : 0);
        }
        return this.f14406m;
    }

    public String toString() {
        if (this.f14405l == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.f14395b);
            sb.append('+');
            sb.append(this.f14404k);
            sb.append("+[");
            sb.append(this.f14396c);
            sb.append('x');
            sb.append(this.f14397d);
            sb.append("]+");
            sb.append('\'');
            w0.e eVar = this.f14398e;
            sb.append(eVar != null ? eVar.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            w0.e eVar2 = this.f14399f;
            sb.append(eVar2 != null ? eVar2.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            w0.g gVar = this.f14400g;
            sb.append(gVar != null ? gVar.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            w0.f fVar = this.f14401h;
            sb.append(fVar != null ? fVar.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            y0.f fVar2 = this.f14402i;
            sb.append(fVar2 != null ? fVar2.a() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            w0.b bVar = this.f14403j;
            sb.append(bVar != null ? bVar.a() : "");
            sb.append('\'');
            sb.append('}');
            this.f14405l = sb.toString();
        }
        return this.f14405l;
    }
}
