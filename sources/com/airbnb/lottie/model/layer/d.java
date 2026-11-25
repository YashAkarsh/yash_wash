package com.airbnb.lottie.model.layer;

import c.o0;
import com.airbnb.lottie.model.animatable.j;
import com.airbnb.lottie.model.animatable.k;
import com.airbnb.lottie.model.animatable.l;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.airbnb.lottie.model.content.b> f12123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.airbnb.lottie.f f12124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f12125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f12127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private final String f12129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<com.airbnb.lottie.model.content.g> f12130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final l f12131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f12132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f12133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f12134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float f12135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f12136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f12137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f12138p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private final j f12139q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @o0
    private final k f12140r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.model.animatable.b f12141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List<com.airbnb.lottie.value.a<Float>> f12142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final b f12143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final boolean f12144v;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public d(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.f fVar, String str, long j7, a aVar, long j8, @o0 String str2, List<com.airbnb.lottie.model.content.g> list2, l lVar, int i7, int i8, int i9, float f8, float f9, int i10, int i11, @o0 j jVar, @o0 k kVar, List<com.airbnb.lottie.value.a<Float>> list3, b bVar, @o0 com.airbnb.lottie.model.animatable.b bVar2, boolean z7) {
        this.f12123a = list;
        this.f12124b = fVar;
        this.f12125c = str;
        this.f12126d = j7;
        this.f12127e = aVar;
        this.f12128f = j8;
        this.f12129g = str2;
        this.f12130h = list2;
        this.f12131i = lVar;
        this.f12132j = i7;
        this.f12133k = i8;
        this.f12134l = i9;
        this.f12135m = f8;
        this.f12136n = f9;
        this.f12137o = i10;
        this.f12138p = i11;
        this.f12139q = jVar;
        this.f12140r = kVar;
        this.f12142t = list3;
        this.f12143u = bVar;
        this.f12141s = bVar2;
        this.f12144v = z7;
    }

    com.airbnb.lottie.f a() {
        return this.f12124b;
    }

    public long b() {
        return this.f12126d;
    }

    List<com.airbnb.lottie.value.a<Float>> c() {
        return this.f12142t;
    }

    public a d() {
        return this.f12127e;
    }

    List<com.airbnb.lottie.model.content.g> e() {
        return this.f12130h;
    }

    b f() {
        return this.f12143u;
    }

    String g() {
        return this.f12125c;
    }

    long h() {
        return this.f12128f;
    }

    int i() {
        return this.f12138p;
    }

    int j() {
        return this.f12137o;
    }

    @o0
    String k() {
        return this.f12129g;
    }

    List<com.airbnb.lottie.model.content.b> l() {
        return this.f12123a;
    }

    int m() {
        return this.f12134l;
    }

    int n() {
        return this.f12133k;
    }

    int o() {
        return this.f12132j;
    }

    float p() {
        return this.f12136n / this.f12124b.e();
    }

    @o0
    j q() {
        return this.f12139q;
    }

    @o0
    k r() {
        return this.f12140r;
    }

    @o0
    com.airbnb.lottie.model.animatable.b s() {
        return this.f12141s;
    }

    float t() {
        return this.f12135m;
    }

    public String toString() {
        return w("");
    }

    l u() {
        return this.f12131i;
    }

    public boolean v() {
        return this.f12144v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        d dVarV = this.f12124b.v(h());
        if (dVarV != null) {
            sb.append("\t\tParents: ");
            sb.append(dVarV.g());
            d dVarV2 = this.f12124b.v(dVarV.h());
            while (dVarV2 != null) {
                sb.append("->");
                sb.append(dVarV2.g());
                dVarV2 = this.f12124b.v(dVarV2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.f12123a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.f12123a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
