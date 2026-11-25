package com.haier.library.json.serializer;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f26831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f26832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected List<d> f26833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<a> f26834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected List<u> f26835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected List<c0> f26836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected List<r> f26837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected List<v> f26838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f26839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f26840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DateFormat f26841k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected IdentityHashMap<Object, w> f26842l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected w f26843m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TimeZone f26844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Locale f26845o;

    public m() {
        this(new z(null, com.haier.library.json.a.f26649f, a0.f26809y), x.f26859c);
    }

    public static Object s(m mVar, Object obj, Object obj2, Object obj3) {
        List<c0> list = mVar.f26836f;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = com.haier.library.json.a.Z(obj2);
            }
            Iterator<c0> it = list.iterator();
            while (it.hasNext()) {
                obj3 = it.next().a(obj, (String) obj2, obj3);
            }
        }
        return obj3;
    }

    public static final void w(z zVar, Object obj) {
        new m(zVar, x.f26859c).y(obj);
    }

    public static final void x(Writer writer, Object obj) {
        z zVar = new z(null, com.haier.library.json.a.f26649f, a0.f26809y);
        try {
            try {
                new m(zVar, x.f26859c).y(obj);
                zVar.o0(writer);
                zVar.close();
            } catch (IOException e8) {
                throw new com.haier.library.json.d(e8.getMessage(), e8);
            }
        } catch (Throwable th) {
            zVar.close();
            throw th;
        }
    }

    protected final void A(char c8, String str, Object obj) {
        if (c8 != 0) {
            this.f26832b.write(c8);
        }
        this.f26832b.v(str, true);
        y(obj);
    }

    public void B(Object obj) {
        w wVar = this.f26843m;
        if (obj == wVar.f26856b) {
            this.f26832b.write("{\"$ref\":\"@\"}");
            return;
        }
        w wVar2 = wVar.f26855a;
        if (wVar2 != null && obj == wVar2.f26856b) {
            this.f26832b.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            w wVar3 = wVar.f26855a;
            if (wVar3 == null) {
                break;
            } else {
                wVar = wVar3;
            }
        }
        if (obj == wVar.f26856b) {
            this.f26832b.write("{\"$ref\":\"$\"}");
            return;
        }
        String string = this.f26842l.get(obj).toString();
        this.f26832b.write("{\"$ref\":\"");
        this.f26832b.write(string);
        this.f26832b.write("\"}");
    }

    public final void C(Object obj, Object obj2) {
        D(obj, obj2, null, 0);
    }

    public final void D(Object obj, Object obj2, Type type, int i7) {
        try {
            if (obj == null) {
                this.f26832b.H();
            } else {
                this.f26831a.a(obj.getClass()).b(this, obj, obj2, type);
            }
        } catch (IOException e8) {
            throw new com.haier.library.json.d(e8.getMessage(), e8);
        }
    }

    public final void E(Object obj, String str) {
        if (!(obj instanceof Date)) {
            y(obj);
            return;
        }
        DateFormat dateFormatI = i();
        if (dateFormatI == null) {
            dateFormatI = new SimpleDateFormat(str, this.f26845o);
            dateFormatI.setTimeZone(this.f26844n);
        }
        this.f26832b.K(dateFormatI.format((Date) obj));
    }

    public boolean a(Object obj, Object obj2, Object obj3) {
        List<u> list = this.f26835e;
        if (list == null) {
            return true;
        }
        if (obj2 != null && !(obj2 instanceof String)) {
            obj2 = com.haier.library.json.a.Z(obj2);
        }
        Iterator<u> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().b(obj, (String) obj2, obj3)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(Object obj, Object obj2) {
        List<v> list = this.f26838h;
        if (list == null) {
            return true;
        }
        for (v vVar : list) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = com.haier.library.json.a.Z(obj2);
            }
            if (!vVar.c(this, obj, (String) obj2)) {
                return false;
            }
        }
        return true;
    }

    public void c() {
        this.f26832b.close();
    }

    public void d(a0 a0Var, boolean z7) {
        this.f26832b.f(a0Var, z7);
    }

    public void e() {
        this.f26839i--;
    }

    public List<a> f() {
        if (this.f26834d == null) {
            this.f26834d = new ArrayList();
        }
        return this.f26834d;
    }

    public List<d> g() {
        if (this.f26833c == null) {
            this.f26833c = new ArrayList();
        }
        return this.f26833c;
    }

    public w h() {
        return this.f26843m;
    }

    public DateFormat i() {
        if (this.f26841k == null && this.f26840j != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f26840j, this.f26845o);
            this.f26841k = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f26844n);
        }
        return this.f26841k;
    }

    public String j() {
        DateFormat dateFormat = this.f26841k;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.f26840j;
    }

    public List<r> k() {
        if (this.f26837g == null) {
            this.f26837g = new ArrayList();
        }
        return this.f26837g;
    }

    public List<u> l() {
        if (this.f26835e == null) {
            this.f26835e = new ArrayList();
        }
        return this.f26835e;
    }

    public List<v> m() {
        if (this.f26838h == null) {
            this.f26838h = new ArrayList();
        }
        return this.f26838h;
    }

    public List<c0> n() {
        if (this.f26836f == null) {
            this.f26836f = new ArrayList();
        }
        return this.f26836f;
    }

    public z o() {
        return this.f26832b;
    }

    public void p() {
        this.f26839i++;
    }

    public void q() {
        this.f26832b.write(10);
        for (int i7 = 0; i7 < this.f26839i; i7++) {
            this.f26832b.write(9);
        }
    }

    public Object r(Object obj, Object obj2, Object obj3) {
        List<r> list = this.f26837g;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = com.haier.library.json.a.Z(obj2);
            }
            Iterator<r> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().a(obj, (String) obj2, obj3);
            }
        }
        return obj2;
    }

    public void t(w wVar, Object obj, Object obj2, int i7) {
        if ((this.f26832b.f26874c & a0.DisableCircularReferenceDetect.f26811a) == 0) {
            this.f26843m = new w(wVar, obj, obj2, i7);
            if (this.f26842l == null) {
                this.f26842l = new IdentityHashMap<>();
            }
            this.f26842l.put(obj, this.f26843m);
        }
    }

    public String toString() {
        return this.f26832b.toString();
    }

    public void u(String str) {
        this.f26840j = str;
        if (this.f26841k != null) {
            this.f26841k = null;
        }
    }

    public void v(DateFormat dateFormat) {
        this.f26841k = dateFormat;
        if (this.f26840j != null) {
            this.f26840j = null;
        }
    }

    public final void y(Object obj) {
        if (obj == null) {
            this.f26832b.H();
            return;
        }
        try {
            this.f26831a.a(obj.getClass()).b(this, obj, null, null);
        } catch (IOException e8) {
            throw new com.haier.library.json.d(e8.getMessage(), e8);
        }
    }

    public final void z(String str) {
        if (str == null) {
            z zVar = this.f26832b;
            if ((zVar.f26874c & a0.WriteNullStringAsEmpty.f26811a) != 0) {
                zVar.K("");
                return;
            } else {
                zVar.H();
                return;
            }
        }
        z zVar2 = this.f26832b;
        if ((zVar2.f26874c & a0.UseSingleQuotes.f26811a) != 0) {
            zVar2.g0(str);
        } else {
            zVar2.Q(str, (char) 0, true);
        }
    }

    public m(z zVar) {
        this(zVar, x.f26859c);
    }

    public m(x xVar) {
        this(new z(null, com.haier.library.json.a.f26649f, a0.f26809y), xVar);
    }

    public m(z zVar, x xVar) {
        this.f26839i = 0;
        this.f26844n = com.haier.library.json.a.f26644a;
        this.f26845o = com.haier.library.json.a.f26645b;
        this.f26832b = zVar;
        this.f26831a = xVar;
        this.f26844n = com.haier.library.json.a.f26644a;
    }
}
