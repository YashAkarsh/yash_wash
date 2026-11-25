package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Excluder f22993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w f22994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e f22995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Type, h<?>> f22996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<y> f22997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<y> f22998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f22999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f23000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f23001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f23003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f23004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f23005m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f23006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f23007o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f23008p;

    public g() {
        this.f22993a = Excluder.f23011h;
        this.f22994b = w.f23310a;
        this.f22995c = d.f22955a;
        this.f22996d = new HashMap();
        this.f22997e = new ArrayList();
        this.f22998f = new ArrayList();
        this.f22999g = false;
        this.f23001i = 2;
        this.f23002j = 2;
        this.f23003k = false;
        this.f23004l = false;
        this.f23005m = true;
        this.f23006n = false;
        this.f23007o = false;
        this.f23008p = false;
    }

    private void c(String str, int i7, int i8, List<y> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a((Class<? extends Date>) Date.class, str);
            aVar2 = new a((Class<? extends Date>) Timestamp.class, str);
            aVar3 = new a((Class<? extends Date>) java.sql.Date.class, str);
        } else {
            if (i7 == 2 || i8 == 2) {
                return;
            }
            a aVar4 = new a(Date.class, i7, i8);
            a aVar5 = new a(Timestamp.class, i7, i8);
            a aVar6 = new a(java.sql.Date.class, i7, i8);
            aVar = aVar4;
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(TypeAdapters.b(Date.class, aVar));
        list.add(TypeAdapters.b(Timestamp.class, aVar2));
        list.add(TypeAdapters.b(java.sql.Date.class, aVar3));
    }

    public g a(b bVar) {
        this.f22993a = this.f22993a.t(bVar, false, true);
        return this;
    }

    public g b(b bVar) {
        this.f22993a = this.f22993a.t(bVar, true, false);
        return this;
    }

    public f d() {
        List<y> arrayList = new ArrayList<>(this.f22997e.size() + this.f22998f.size() + 3);
        arrayList.addAll(this.f22997e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f22998f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        c(this.f23000h, this.f23001i, this.f23002j, arrayList);
        return new f(this.f22993a, this.f22995c, this.f22996d, this.f22999g, this.f23003k, this.f23007o, this.f23005m, this.f23006n, this.f23008p, this.f23004l, this.f22994b, this.f23000h, this.f23001i, this.f23002j, this.f22997e, this.f22998f, arrayList);
    }

    public g e() {
        this.f23005m = false;
        return this;
    }

    public g f() {
        this.f22993a = this.f22993a.h();
        return this;
    }

    public g g() {
        this.f23003k = true;
        return this;
    }

    public g h(int... iArr) {
        this.f22993a = this.f22993a.u(iArr);
        return this;
    }

    public g i() {
        this.f22993a = this.f22993a.m();
        return this;
    }

    public g j() {
        this.f23007o = true;
        return this;
    }

    public g k(Type type, Object obj) {
        boolean z7 = obj instanceof t;
        com.google.gson.internal.a.a(z7 || (obj instanceof k) || (obj instanceof h) || (obj instanceof x));
        if (obj instanceof h) {
            this.f22996d.put(type, (h) obj);
        }
        if (z7 || (obj instanceof k)) {
            this.f22997e.add(TreeTypeAdapter.l(com.google.gson.reflect.a.get(type), obj));
        }
        if (obj instanceof x) {
            this.f22997e.add(TypeAdapters.a(com.google.gson.reflect.a.get(type), (x) obj));
        }
        return this;
    }

    public g l(y yVar) {
        this.f22997e.add(yVar);
        return this;
    }

    public g m(Class<?> cls, Object obj) {
        boolean z7 = obj instanceof t;
        com.google.gson.internal.a.a(z7 || (obj instanceof k) || (obj instanceof x));
        if ((obj instanceof k) || z7) {
            this.f22998f.add(TreeTypeAdapter.m(cls, obj));
        }
        if (obj instanceof x) {
            this.f22997e.add(TypeAdapters.e(cls, (x) obj));
        }
        return this;
    }

    public g n() {
        this.f22999g = true;
        return this;
    }

    public g o() {
        this.f23004l = true;
        return this;
    }

    public g p(int i7) {
        this.f23001i = i7;
        this.f23000h = null;
        return this;
    }

    public g q(int i7, int i8) {
        this.f23001i = i7;
        this.f23002j = i8;
        this.f23000h = null;
        return this;
    }

    public g r(String str) {
        this.f23000h = str;
        return this;
    }

    public g s(b... bVarArr) {
        for (b bVar : bVarArr) {
            this.f22993a = this.f22993a.t(bVar, true, true);
        }
        return this;
    }

    public g t(d dVar) {
        this.f22995c = dVar;
        return this;
    }

    public g u(e eVar) {
        this.f22995c = eVar;
        return this;
    }

    public g v() {
        this.f23008p = true;
        return this;
    }

    public g w(w wVar) {
        this.f22994b = wVar;
        return this;
    }

    public g x() {
        this.f23006n = true;
        return this;
    }

    public g y(double d8) {
        this.f22993a = this.f22993a.v(d8);
        return this;
    }

    g(f fVar) {
        this.f22993a = Excluder.f23011h;
        this.f22994b = w.f23310a;
        this.f22995c = d.f22955a;
        HashMap map = new HashMap();
        this.f22996d = map;
        ArrayList arrayList = new ArrayList();
        this.f22997e = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f22998f = arrayList2;
        this.f22999g = false;
        this.f23001i = 2;
        this.f23002j = 2;
        this.f23003k = false;
        this.f23004l = false;
        this.f23005m = true;
        this.f23006n = false;
        this.f23007o = false;
        this.f23008p = false;
        this.f22993a = fVar.f22972f;
        this.f22995c = fVar.f22973g;
        map.putAll(fVar.f22974h);
        this.f22999g = fVar.f22975i;
        this.f23003k = fVar.f22976j;
        this.f23007o = fVar.f22977k;
        this.f23005m = fVar.f22978l;
        this.f23006n = fVar.f22979m;
        this.f23008p = fVar.f22980n;
        this.f23004l = fVar.f22981o;
        this.f22994b = fVar.f22985s;
        this.f23000h = fVar.f22982p;
        this.f23001i = fVar.f22983q;
        this.f23002j = fVar.f22984r;
        arrayList.addAll(fVar.f22986t);
        arrayList2.addAll(fVar.f22987u);
    }
}
