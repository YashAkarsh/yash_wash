package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class f0 implements Comparable<f0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.e f13029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f13030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f13031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13033e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13034f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected p f13035g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13036h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f13037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f13038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f13039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected boolean f13040l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f13041m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f13042n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f13043o;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final y0 f13044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<?> f13045b;

        public a(y0 y0Var, Class<?> cls) {
            this.f13044a = y0Var;
            this.f13045b = cls;
        }
    }

    public f0(Class<?> cls, com.alibaba.fastjson.util.e eVar) {
        boolean z7;
        e0.d dVar;
        Class<?> cls2;
        this.f13037i = false;
        this.f13038j = false;
        this.f13039k = false;
        this.f13041m = false;
        this.f13029a = eVar;
        this.f13035g = new p(cls, eVar);
        if (cls != null && ((eVar.f13309q || (cls2 = eVar.f13297e) == Long.TYPE || cls2 == Long.class) && (dVar = (e0.d) com.alibaba.fastjson.util.l.M(cls, e0.d.class)) != null)) {
            for (k1 k1Var : dVar.serialzeFeatures()) {
                if (k1Var == k1.WriteEnumUsingToString) {
                    this.f13037i = true;
                } else if (k1Var == k1.WriteEnumUsingName) {
                    this.f13038j = true;
                } else if (k1Var == k1.DisableCircularReferenceDetect) {
                    this.f13039k = true;
                } else if (k1Var == k1.BrowserCompatible) {
                    this.f13042n = true;
                }
            }
        }
        eVar.m();
        this.f13032d = kotlin.text.h0.f35376b + eVar.f13293a + "\":";
        e0.b bVarE = eVar.e();
        if (bVarE != null) {
            k1[] k1VarArrSerialzeFeatures = bVarE.serialzeFeatures();
            int length = k1VarArrSerialzeFeatures.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length) {
                    z7 = false;
                    break;
                } else {
                    if ((k1VarArrSerialzeFeatures[i7].b() & k1.G) != 0) {
                        z7 = true;
                        break;
                    }
                    i7++;
                }
            }
            String str = bVarE.format();
            this.f13036h = str;
            if (str.trim().length() == 0) {
                this.f13036h = null;
            }
            for (k1 k1Var2 : bVarE.serialzeFeatures()) {
                if (k1Var2 == k1.WriteEnumUsingToString) {
                    this.f13037i = true;
                } else if (k1Var2 == k1.WriteEnumUsingName) {
                    this.f13038j = true;
                } else if (k1Var2 == k1.DisableCircularReferenceDetect) {
                    this.f13039k = true;
                } else if (k1Var2 == k1.BrowserCompatible) {
                    this.f13042n = true;
                }
            }
            this.f13031c = k1.e(bVarE.serialzeFeatures());
        } else {
            z7 = false;
        }
        this.f13030b = z7;
        this.f13041m = com.alibaba.fastjson.util.l.c0(eVar.f13294b) || com.alibaba.fastjson.util.l.b0(eVar.f13294b);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(f0 f0Var) {
        return this.f13029a.compareTo(f0Var.f13029a);
    }

    public Object b(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objC = this.f13029a.c(obj);
        if (this.f13036h == null || objC == null || this.f13029a.f13297e != Date.class) {
            return objC;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f13036h);
        simpleDateFormat.setTimeZone(com.alibaba.fastjson.a.f12527a);
        return simpleDateFormat.format(objC);
    }

    public Object c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objC = this.f13029a.c(obj);
        if (!this.f13041m || com.alibaba.fastjson.util.l.e0(objC)) {
            return objC;
        }
        return null;
    }

    public void d(n0 n0Var) throws IOException {
        j1 j1Var = n0Var.f13143k;
        if (!j1Var.f13093f) {
            if (this.f13034f == null) {
                this.f13034f = this.f13029a.f13293a + ":";
            }
            j1Var.write(this.f13034f);
            return;
        }
        if (!j1Var.f13092e) {
            j1Var.write(this.f13032d);
            return;
        }
        if (this.f13033e == null) {
            this.f13033e = '\'' + this.f13029a.f13293a + "':";
        }
        j1Var.write(this.f13033e);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    public void e(n0 n0Var, Object obj) throws Exception {
        Class<?> cls;
        y0 y0VarB;
        if (this.f13043o == null) {
            Class<?> cls2 = obj == null ? this.f13029a.f13297e : obj.getClass();
            e0.b bVarE = this.f13029a.e();
            if (bVarE == null || bVarE.serializeUsing() == Void.class) {
                if (this.f13036h == null) {
                    y0VarB = null;
                } else if (cls2 == Double.TYPE || cls2 == Double.class) {
                    y0VarB = new c0(this.f13036h);
                } else if (cls2 == Float.TYPE || cls2 == Float.class) {
                    y0VarB = new g0(this.f13036h);
                } else {
                    y0VarB = null;
                }
                if (y0VarB == null) {
                    y0VarB = n0Var.B(cls2);
                }
            } else {
                y0VarB = (y0) bVarE.serializeUsing().newInstance();
                this.f13040l = true;
            }
            this.f13043o = new a(y0VarB, cls2);
        }
        a aVar = this.f13043o;
        int iB = this.f13039k ? this.f13029a.f13301i | k1.DisableCircularReferenceDetect.b() : this.f13029a.f13301i;
        if (obj == null) {
            j1 j1Var = n0Var.f13143k;
            if (this.f13029a.f13297e == Object.class && j1Var.F(k1.G)) {
                j1Var.X1();
                return;
            }
            Class<?> cls3 = aVar.f13045b;
            if (Number.class.isAssignableFrom(cls3)) {
                j1Var.Y1(this.f13031c, k1.WriteNullNumberAsZero.f13132a);
                return;
            }
            if (String.class == cls3) {
                j1Var.Y1(this.f13031c, k1.WriteNullStringAsEmpty.f13132a);
                return;
            }
            if (Boolean.class == cls3) {
                j1Var.Y1(this.f13031c, k1.WriteNullBooleanAsFalse.f13132a);
                return;
            }
            if (Collection.class.isAssignableFrom(cls3)) {
                j1Var.Y1(this.f13031c, k1.WriteNullListAsEmpty.f13132a);
                return;
            }
            y0 y0Var = aVar.f13044a;
            if (j1Var.F(k1.G) && (y0Var instanceof p0)) {
                j1Var.X1();
                return;
            } else {
                com.alibaba.fastjson.util.e eVar = this.f13029a;
                y0Var.c(n0Var, null, eVar.f13293a, eVar.f13298f, iB);
                return;
            }
        }
        if (this.f13029a.f13309q) {
            if (this.f13038j) {
                n0Var.f13143k.a2(((Enum) obj).name());
                return;
            } else if (this.f13037i) {
                n0Var.f13143k.a2(((Enum) obj).toString());
                return;
            }
        }
        Class<?> cls4 = obj.getClass();
        y0 y0VarB2 = (cls4 == aVar.f13045b || this.f13040l) ? aVar.f13044a : n0Var.B(cls4);
        String str = this.f13036h;
        if (str != null && !(y0VarB2 instanceof c0) && !(y0VarB2 instanceof g0)) {
            if (y0VarB2 instanceof z) {
                ((z) y0VarB2).d(n0Var, obj, this.f13035g);
                return;
            } else {
                n0Var.Z(obj, str);
                return;
            }
        }
        com.alibaba.fastjson.util.e eVar2 = this.f13029a;
        if (eVar2.f13311s) {
            if (y0VarB2 instanceof p0) {
                ((p0) y0VarB2).G(n0Var, obj, eVar2.f13293a, eVar2.f13298f, iB, true);
                return;
            } else if (y0VarB2 instanceof u0) {
                ((u0) y0VarB2).r(n0Var, obj, eVar2.f13293a, eVar2.f13298f, iB, true);
                return;
            }
        }
        if ((this.f13031c & k1.WriteClassName.f13132a) != 0 && cls4 != eVar2.f13297e && p0.class.isInstance(y0VarB2)) {
            com.alibaba.fastjson.util.e eVar3 = this.f13029a;
            ((p0) y0VarB2).G(n0Var, obj, eVar3.f13293a, eVar3.f13298f, iB, false);
            return;
        }
        if (this.f13042n && ((cls = this.f13029a.f13297e) == Long.TYPE || cls == Long.class)) {
            long jLongValue = ((Long) obj).longValue();
            if (jLongValue > 9007199254740991L || jLongValue < -9007199254740991L) {
                n0Var.C().a2(Long.toString(jLongValue));
                return;
            }
        }
        com.alibaba.fastjson.util.e eVar4 = this.f13029a;
        y0VarB2.c(n0Var, obj, eVar4.f13293a, eVar4.f13298f, iB);
    }
}
