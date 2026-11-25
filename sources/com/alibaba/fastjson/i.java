package com.alibaba.fastjson;

import java.io.Closeable;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.alibaba.fastjson.parser.b f12759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private k f12760b;

    public i(Reader reader) {
        this(reader, new com.alibaba.fastjson.parser.c[0]);
    }

    private void G() {
        k kVar = this.f12760b;
        int i7 = kVar.f12767b;
        int i8 = 1002;
        switch (i7) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i8 = 1003;
                break;
            case 1004:
                i8 = 1005;
                break;
            case 1005:
                i8 = -1;
                break;
            default:
                throw new d("illegal state : " + i7);
        }
        if (i8 != -1) {
            kVar.f12767b = i8;
        }
    }

    private void H() {
        int i7 = this.f12760b.f12767b;
        switch (i7) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.f12759a.b(17);
                return;
            case 1003:
                this.f12759a.c(16, 18);
                return;
            case 1005:
                this.f12759a.b(16);
                return;
            default:
                throw new d("illegal state : " + i7);
        }
    }

    private void I0() {
        switch (this.f12760b.f12767b) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.f12759a.b(17);
                return;
            case 1003:
            case 1005:
                this.f12759a.b(16);
                return;
            default:
                throw new d("illegal state : " + this.f12760b.f12767b);
        }
    }

    private void r() {
        int i7;
        k kVar = this.f12760b.f12766a;
        this.f12760b = kVar;
        if (kVar == null) {
            return;
        }
        switch (kVar.f12767b) {
            case 1001:
            case 1003:
                i7 = 1002;
                break;
            case 1002:
                i7 = 1003;
                break;
            case 1004:
                i7 = 1005;
                break;
            default:
                i7 = -1;
                break;
        }
        if (i7 != -1) {
            kVar.f12767b = i7;
        }
    }

    public TimeZone C() {
        return this.f12759a.f12789f.getTimeZone();
    }

    public boolean E() {
        if (this.f12760b == null) {
            throw new d("context is null");
        }
        int iL0 = this.f12759a.f12789f.L0();
        int i7 = this.f12760b.f12767b;
        switch (i7) {
            case 1001:
            case 1003:
                return iL0 != 13;
            case 1002:
            default:
                throw new d("illegal state : " + i7);
            case 1004:
            case 1005:
                return iL0 != 15;
        }
    }

    public int F() {
        return this.f12759a.f12789f.L0();
    }

    public void G0() {
        if (this.f12760b == null) {
            this.f12760b = new k(null, 1001);
        } else {
            I0();
            this.f12760b = new k(this.f12760b, 1001);
        }
        this.f12759a.c(12, 18);
    }

    public Integer K() {
        Object objX0;
        if (this.f12760b == null) {
            objX0 = this.f12759a.x0();
        } else {
            H();
            objX0 = this.f12759a.x0();
            G();
        }
        return com.alibaba.fastjson.util.l.s(objX0);
    }

    public Long Q() {
        Object objX0;
        if (this.f12760b == null) {
            objX0 = this.f12759a.x0();
        } else {
            H();
            objX0 = this.f12759a.x0();
            G();
        }
        return com.alibaba.fastjson.util.l.v(objX0);
    }

    public void b(com.alibaba.fastjson.parser.c cVar, boolean z7) {
        this.f12759a.r(cVar, z7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12759a.close();
    }

    public void e() {
        this.f12759a.b(15);
        r();
    }

    public <T> T g0(n<T> nVar) {
        return (T) l0(nVar.a());
    }

    public <T> T h0(Class<T> cls) {
        if (this.f12760b == null) {
            return (T) this.f12759a.s1(cls);
        }
        H();
        T t7 = (T) this.f12759a.s1(cls);
        G();
        return t7;
    }

    public <T> T l0(Type type) {
        if (this.f12760b == null) {
            return (T) this.f12759a.w1(type);
        }
        H();
        T t7 = (T) this.f12759a.w1(type);
        G();
        return t7;
    }

    public Object o0(Map map) {
        if (this.f12760b == null) {
            return this.f12759a.A1(map);
        }
        H();
        Object objA1 = this.f12759a.A1(map);
        G();
        return objA1;
    }

    public void p0(Object obj) {
        if (this.f12760b == null) {
            this.f12759a.N1(obj);
            return;
        }
        H();
        this.f12759a.N1(obj);
        G();
    }

    public void q() {
        this.f12759a.b(13);
        r();
    }

    public String r0() {
        Object objX0;
        if (this.f12760b == null) {
            objX0 = this.f12759a.x0();
        } else {
            H();
            com.alibaba.fastjson.parser.d dVar = this.f12759a.f12789f;
            if (this.f12760b.f12767b == 1001 && dVar.L0() == 18) {
                String strX0 = dVar.x0();
                dVar.E();
                objX0 = strX0;
            } else {
                objX0 = this.f12759a.x0();
            }
            G();
        }
        return com.alibaba.fastjson.util.l.z(objX0);
    }

    public Object readObject() {
        if (this.f12760b == null) {
            return this.f12759a.x0();
        }
        H();
        int i7 = this.f12760b.f12767b;
        Object objI1 = (i7 == 1001 || i7 == 1003) ? this.f12759a.i1() : this.f12759a.x0();
        G();
        return objI1;
    }

    public void s0(Locale locale) {
        this.f12759a.f12789f.Y0(locale);
    }

    public Locale u() {
        return this.f12759a.f12789f.getLocale();
    }

    public void v0(TimeZone timeZone) {
        this.f12759a.f12789f.e1(timeZone);
    }

    public void x0() {
        if (this.f12760b == null) {
            this.f12760b = new k(null, 1004);
        } else {
            I0();
            this.f12760b = new k(this.f12760b, 1004);
        }
        this.f12759a.b(14);
    }

    public i(Reader reader, com.alibaba.fastjson.parser.c... cVarArr) {
        this(new com.alibaba.fastjson.parser.f(reader));
        for (com.alibaba.fastjson.parser.c cVar : cVarArr) {
            b(cVar, true);
        }
    }

    public i(com.alibaba.fastjson.parser.d dVar) {
        this(new com.alibaba.fastjson.parser.b(dVar));
    }

    public i(com.alibaba.fastjson.parser.b bVar) {
        this.f12759a = bVar;
    }
}
