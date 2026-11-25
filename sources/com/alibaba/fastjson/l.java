package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.j1;
import com.alibaba.fastjson.serializer.k1;
import com.alibaba.fastjson.serializer.n0;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class l implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j1 f12768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n0 f12769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f12770c;

    public l(Writer writer) {
        j1 j1Var = new j1(writer);
        this.f12768a = j1Var;
        this.f12769b = new n0(j1Var);
    }

    private void E() {
        k kVar = this.f12770c.f12766a;
        this.f12770c = kVar;
        if (kVar == null) {
            return;
        }
        int i7 = kVar.f12767b;
        int i8 = 1002;
        if (i7 != 1001) {
            if (i7 != 1002) {
                i8 = i7 != 1004 ? -1 : 1005;
            } else {
                i8 = 1003;
            }
        }
        if (i8 != -1) {
            kVar.f12767b = i8;
        }
    }

    private void b() {
        int i7;
        k kVar = this.f12770c;
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

    private void e() {
        k kVar = this.f12770c;
        if (kVar == null) {
            return;
        }
        int i7 = kVar.f12767b;
        if (i7 == 1002) {
            this.f12768a.write(58);
        } else if (i7 == 1003) {
            this.f12768a.write(44);
        } else {
            if (i7 != 1005) {
                return;
            }
            this.f12768a.write(44);
        }
    }

    private void q() {
        int i7 = this.f12770c.f12767b;
        switch (i7) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.f12768a.write(58);
                return;
            case 1003:
            default:
                throw new d("illegal state : " + i7);
            case 1005:
                this.f12768a.write(44);
                return;
        }
    }

    public void C() {
        this.f12768a.write(125);
        E();
    }

    public void F() {
        if (this.f12770c != null) {
            q();
        }
        this.f12770c = new k(this.f12770c, 1004);
        this.f12768a.write(91);
    }

    public void G() {
        if (this.f12770c != null) {
            q();
        }
        this.f12770c = new k(this.f12770c, 1001);
        this.f12768a.write(123);
    }

    @Deprecated
    public void H() {
        u();
    }

    @Deprecated
    public void K() {
        C();
    }

    public void Q(String str) {
        h0(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12768a.close();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f12768a.flush();
    }

    public void g0(Object obj) {
        e();
        this.f12769b.S(obj);
        b();
    }

    public void h0(String str) {
        e();
        this.f12769b.T(str);
        b();
    }

    @Deprecated
    public void l0() {
        F();
    }

    @Deprecated
    public void o0() {
        G();
    }

    public void p0(Object obj) {
        g0(obj);
    }

    public void r(k1 k1Var, boolean z7) {
        this.f12768a.r(k1Var, z7);
    }

    public void u() {
        this.f12768a.write(93);
        E();
    }
}
