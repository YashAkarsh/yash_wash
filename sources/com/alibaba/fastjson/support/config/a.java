package com.alibaba.fastjson.support.config;

import com.alibaba.fastjson.parser.c;
import com.alibaba.fastjson.parser.j;
import com.alibaba.fastjson.serializer.g1;
import com.alibaba.fastjson.serializer.h1;
import com.alibaba.fastjson.serializer.k1;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<Class<?>, h1> f13191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f13193i = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Charset f13185a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g1 f13186b = g1.i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f13187c = new j();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k1[] f13188d = {k1.BrowserSecure};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private h1[] f13189e = new h1[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c[] f13190f = new c[0];

    public Charset a() {
        return this.f13185a;
    }

    public Map<Class<?>, h1> b() {
        return this.f13191g;
    }

    public String c() {
        return this.f13192h;
    }

    public c[] d() {
        return this.f13190f;
    }

    public j e() {
        return this.f13187c;
    }

    public g1 f() {
        return this.f13186b;
    }

    public h1[] g() {
        return this.f13189e;
    }

    public k1[] h() {
        return this.f13188d;
    }

    public boolean i() {
        return this.f13193i;
    }

    public void j(Charset charset) {
        this.f13185a = charset;
    }

    public void k(Map<Class<?>, h1> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<Class<?>, h1> entry : map.entrySet()) {
            this.f13186b.a(entry.getKey(), entry.getValue());
        }
        this.f13191g = map;
    }

    public void l(String str) {
        this.f13192h = str;
    }

    public void m(c... cVarArr) {
        this.f13190f = cVarArr;
    }

    public void n(j jVar) {
        this.f13187c = jVar;
    }

    public void o(g1 g1Var) {
        this.f13186b = g1Var;
    }

    public void p(h1... h1VarArr) {
        this.f13189e = h1VarArr;
    }

    public void q(k1... k1VarArr) {
        this.f13188d = k1VarArr;
    }

    public void r(boolean z7) {
        this.f13193i = z7;
    }
}
