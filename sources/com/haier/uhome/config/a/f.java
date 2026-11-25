package com.haier.uhome.config.a;

import com.haier.uhome.config.entity.ConfigResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f28426a = 9022068141696663847L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f28432g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f28438m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f28439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f28440o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f28441p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f28443r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f28444s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f28445t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f28446u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ConfigResult f28447v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f28448w;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28427b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28428c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28429d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f28430e = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28433h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f28434i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f28435j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f28436k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.h f28437l = com.haier.uhome.usdk.base.api.h.UNKNOWN;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<g> f28431f = new ArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f28442q = 1;

    public String a() {
        return this.f28435j;
    }

    protected boolean b() {
        return this.f28438m;
    }

    public int c() {
        return this.f28436k;
    }

    public String d() {
        return this.f28428c;
    }

    public String e() {
        return this.f28427b;
    }

    public com.haier.uhome.usdk.base.api.h f() {
        return this.f28437l;
    }

    public String g() {
        return this.f28429d;
    }

    protected String h() {
        return this.f28430e;
    }

    public List<g> i() {
        return this.f28431f;
    }

    public String j() {
        return this.f28432g;
    }

    public String k() {
        return this.f28433h;
    }

    public String l() {
        return this.f28434i;
    }

    public int m() {
        return this.f28439n;
    }

    public int n() {
        return this.f28440o;
    }

    public String o() {
        return this.f28441p;
    }

    public int p() {
        return this.f28442q;
    }

    public String q() {
        return this.f28443r;
    }

    public boolean r() {
        return this.f28444s;
    }

    public long s() {
        return this.f28445t;
    }

    public long t() {
        return this.f28446u;
    }

    public String toString() {
        return "DeviceConfigInfo{uplusId=" + this.f28427b + ", devId=" + this.f28429d + ", mainGatewayDomain=" + this.f28435j + ", mainGatewayPort=" + this.f28436k + ", country=" + this.f28441p + ", mode=" + this.f28442q + ", capability=" + this.f28444s + ", configResult=" + this.f28447v + ", token=" + this.f28443r + '}';
    }

    public long u() {
        return this.f28448w;
    }

    public ConfigResult v() {
        return this.f28447v;
    }

    public void a(String str) {
        this.f28435j = str;
    }

    public void b(String str) {
        this.f28427b = str;
        com.haier.uhome.usdk.base.utils.f.a aVarA = com.haier.uhome.usdk.base.utils.f.a(str);
        this.f28437l = aVarA != null ? aVarA.a() : null;
    }

    public void c(String str) {
        if (str == null) {
            str = "";
        }
        this.f28429d = str.toUpperCase();
    }

    protected void d(String str) {
        if (str == null) {
            str = "";
        }
        this.f28430e = str;
    }

    public void e(String str) {
        if (str == null) {
            str = "";
        }
        this.f28432g = str;
    }

    public void f(String str) {
        if (str == null) {
            str = "";
        }
        this.f28433h = str;
    }

    public void g(String str) {
        if (str == null) {
            str = "";
        }
        this.f28434i = str;
    }

    public void h(String str) {
        this.f28441p = str;
    }

    public void i(String str) {
        this.f28443r = str;
    }

    protected void a(boolean z7) {
        this.f28438m = z7;
    }

    public void c(int i7) {
        this.f28440o = i7;
    }

    public void d(int i7) {
        this.f28442q = i7;
    }

    public void a(int i7) {
        this.f28436k = i7;
    }

    public void c(long j7) {
        this.f28448w = j7;
    }

    public void a(String str, String str2, String str3, String str4, List<g> list, int i7) {
        this.f28428c = str;
        b(str2);
        c(str3);
        d(str4);
        a(list);
        d(i7);
        a("");
        a(0);
    }

    public void b(int i7) {
        this.f28439n = i7;
    }

    public void b(boolean z7) {
        this.f28444s = z7;
    }

    public void b(long j7) {
        this.f28446u = j7;
    }

    protected void a(com.haier.uhome.usdk.base.api.h hVar) {
        this.f28437l = hVar;
    }

    protected void a(List<g> list) {
        this.f28431f = list;
    }

    public void a(long j7) {
        this.f28445t = j7;
    }

    public void a(ConfigResult configResult) {
        this.f28447v = configResult;
    }
}
