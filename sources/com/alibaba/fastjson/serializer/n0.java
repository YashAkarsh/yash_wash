package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class n0 extends i1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final g1 f13142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j1 f13143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f13144l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f13145m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f13146n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private DateFormat f13147o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected IdentityHashMap<Object, e1> f13148p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected e1 f13149q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected TimeZone f13150r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected Locale f13151s;

    public n0() {
        this(new j1(), g1.i());
    }

    public static void Q(j1 j1Var, Object obj) {
        new n0(j1Var).S(obj);
    }

    public static void R(Writer writer, Object obj) {
        j1 j1Var = new j1();
        try {
            try {
                new n0(j1Var).S(obj);
                j1Var.j2(writer);
                j1Var.close();
            } catch (IOException e8) {
                throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
            }
        } catch (Throwable th) {
            j1Var.close();
            throw th;
        }
    }

    public g1 A() {
        return this.f13142j;
    }

    public y0 B(Class<?> cls) {
        return this.f13142j.j(cls);
    }

    public j1 C() {
        return this.f13143k;
    }

    public boolean D(i1 i1Var) {
        List<w0> list;
        List<w0> list2 = this.f13078e;
        return (list2 != null && list2.size() > 0) || ((list = i1Var.f13078e) != null && list.size() > 0);
    }

    public boolean E(i1 i1Var) {
        List<b1> list;
        List<b1> list2 = this.f13076c;
        return (list2 != null && list2.size() > 0) || ((list = i1Var.f13076c) != null && list.size() > 0);
    }

    public void F() {
        this.f13144l++;
    }

    public boolean G(k1 k1Var) {
        return this.f13143k.G(k1Var);
    }

    public final boolean H(Type type, Object obj) {
        e1 e1Var;
        return this.f13143k.G(k1.WriteClassName) && !(type == null && this.f13143k.G(k1.NotWriteRootClassName) && ((e1Var = this.f13149q) == null || e1Var.f13025a == null));
    }

    public void I() {
        e1 e1Var = this.f13149q;
        if (e1Var != null) {
            this.f13149q = e1Var.f13025a;
        }
    }

    public void J() {
        this.f13143k.write(10);
        for (int i7 = 0; i7 < this.f13144l; i7++) {
            this.f13143k.write(this.f13145m);
        }
    }

    public void K(e1 e1Var) {
        this.f13149q = e1Var;
    }

    public void L(e1 e1Var, Object obj, Object obj2, int i7) {
        M(e1Var, obj, obj2, i7, 0);
    }

    public void M(e1 e1Var, Object obj, Object obj2, int i7, int i8) {
        if (this.f13143k.f13095h) {
            return;
        }
        this.f13149q = new e1(e1Var, obj, obj2, i7, i8);
        if (this.f13148p == null) {
            this.f13148p = new IdentityHashMap<>();
        }
        this.f13148p.put(obj, this.f13149q);
    }

    public void N(Object obj, Object obj2) {
        L(this.f13149q, obj, obj2, 0);
    }

    public void O(String str) {
        this.f13146n = str;
        if (this.f13147o != null) {
            this.f13147o = null;
        }
    }

    public void P(DateFormat dateFormat) {
        this.f13147o = dateFormat;
        if (this.f13146n != null) {
            this.f13146n = null;
        }
    }

    public final void S(Object obj) {
        if (obj == null) {
            this.f13143k.X1();
            return;
        }
        try {
            B(obj.getClass()).c(this, obj, null, null, 0);
        } catch (IOException e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
        }
    }

    public final void T(String str) {
        n1.f13152a.g(this, str);
    }

    protected final void U(char c8, String str, Object obj) {
        if (c8 != 0) {
            this.f13143k.write(c8);
        }
        this.f13143k.J0(str);
        S(obj);
    }

    public void V() {
        this.f13143k.X1();
    }

    public void W(Object obj) {
        e1 e1Var = this.f13149q;
        if (obj == e1Var.f13026b) {
            this.f13143k.write("{\"$ref\":\"@\"}");
            return;
        }
        e1 e1Var2 = e1Var.f13025a;
        if (e1Var2 != null && obj == e1Var2.f13026b) {
            this.f13143k.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            e1 e1Var3 = e1Var.f13025a;
            if (e1Var3 == null) {
                break;
            } else {
                e1Var = e1Var3;
            }
        }
        if (obj == e1Var.f13026b) {
            this.f13143k.write("{\"$ref\":\"$\"}");
            return;
        }
        this.f13143k.write("{\"$ref\":\"");
        this.f13143k.write(this.f13148p.get(obj).toString());
        this.f13143k.write("\"}");
    }

    public final void X(Object obj, Object obj2) {
        Y(obj, obj2, null, 0);
    }

    public final void Y(Object obj, Object obj2, Type type, int i7) {
        try {
            if (obj == null) {
                this.f13143k.X1();
            } else {
                B(obj.getClass()).c(this, obj, obj2, type, i7);
            }
        } catch (IOException e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0078 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(java.lang.Object r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof java.util.Date
            if (r0 == 0) goto L22
            java.text.DateFormat r0 = r5.x()
            if (r0 != 0) goto L16
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.util.Locale r1 = r5.f13151s
            r0.<init>(r7, r1)
            java.util.TimeZone r7 = r5.f13150r
            r0.setTimeZone(r7)
        L16:
            java.util.Date r6 = (java.util.Date) r6
            java.lang.String r6 = r0.format(r6)
            com.alibaba.fastjson.serializer.j1 r7 = r5.f13143k
            r7.a2(r6)
            return
        L22:
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L87
            byte[] r6 = (byte[]) r6
            java.lang.String r0 = "gzip"
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L4d
            java.lang.String r0 = "gzip,base64"
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L39
            goto L4d
        L39:
            java.lang.String r0 = "hex"
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L47
            com.alibaba.fastjson.serializer.j1 r7 = r5.f13143k
            r7.B1(r6)
            goto L77
        L47:
            com.alibaba.fastjson.serializer.j1 r7 = r5.f13143k
            r7.v0(r6)
            goto L77
        L4d:
            r7 = 0
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            r0.<init>()     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            int r1 = r6.length     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            r2 = 512(0x200, float:7.17E-43)
            if (r1 >= r2) goto L5f
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            int r2 = r6.length     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            goto L64
        L5f:
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
        L64:
            r7 = r1
            r7.write(r6)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            r7.finish()     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            com.alibaba.fastjson.serializer.j1 r6 = r5.f13143k     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            byte[] r0 = r0.toByteArray()     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            r6.v0(r0)     // Catch: java.lang.Throwable -> L78 java.io.IOException -> L7a
            com.alibaba.fastjson.util.f.a(r7)
        L77:
            return
        L78:
            r6 = move-exception
            goto L83
        L7a:
            r6 = move-exception
            com.alibaba.fastjson.d r0 = new com.alibaba.fastjson.d     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = "write gzipBytes error"
            r0.<init>(r1, r6)     // Catch: java.lang.Throwable -> L78
            throw r0     // Catch: java.lang.Throwable -> L78
        L83:
            com.alibaba.fastjson.util.f.a(r7)
            throw r6
        L87:
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto Lba
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r0 = r6.iterator()
            com.alibaba.fastjson.serializer.j1 r1 = r5.f13143k
            r2 = 91
            r1.write(r2)
            r1 = 0
        L99:
            int r2 = r6.size()
            if (r1 >= r2) goto Lb2
            java.lang.Object r2 = r0.next()
            if (r1 == 0) goto Lac
            com.alibaba.fastjson.serializer.j1 r3 = r5.f13143k
            r4 = 44
            r3.write(r4)
        Lac:
            r5.Z(r2, r7)
            int r1 = r1 + 1
            goto L99
        Lb2:
            com.alibaba.fastjson.serializer.j1 r6 = r5.f13143k
            r7 = 93
            r6.write(r7)
            return
        Lba:
            r5.S(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.n0.Z(java.lang.Object, java.lang.String):void");
    }

    public boolean r(i1 i1Var) {
        List<a0> list;
        List<p1> list2;
        List<a0> list3;
        List<p1> list4 = this.f13077d;
        return (list4 != null && list4.size() > 0) || ((list = this.f13081h) != null && list.size() > 0) || (((list2 = i1Var.f13077d) != null && list2.size() > 0) || (((list3 = i1Var.f13081h) != null && list3.size() > 0) || this.f13143k.f13097j));
    }

    public void s() {
        this.f13143k.close();
    }

    public void t(k1 k1Var, boolean z7) {
        this.f13143k.r(k1Var, z7);
    }

    public String toString() {
        return this.f13143k.toString();
    }

    public boolean u(Object obj) {
        e1 e1Var;
        IdentityHashMap<Object, e1> identityHashMap = this.f13148p;
        if (identityHashMap == null || (e1Var = identityHashMap.get(obj)) == null) {
            return false;
        }
        Object obj2 = e1Var.f13027c;
        return obj2 == null || (obj2 instanceof Integer) || (obj2 instanceof String);
    }

    public void v() {
        this.f13144l--;
    }

    public e1 w() {
        return this.f13149q;
    }

    public DateFormat x() {
        if (this.f13147o == null && this.f13146n != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f13146n, this.f13151s);
            this.f13147o = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f13150r);
        }
        return this.f13147o;
    }

    public String y() {
        DateFormat dateFormat = this.f13147o;
        return dateFormat instanceof SimpleDateFormat ? ((SimpleDateFormat) dateFormat).toPattern() : this.f13146n;
    }

    public int z() {
        return this.f13144l;
    }

    public n0(j1 j1Var) {
        this(j1Var, g1.i());
    }

    public n0(g1 g1Var) {
        this(new j1(), g1Var);
    }

    public n0(j1 j1Var, g1 g1Var) {
        this.f13144l = 0;
        this.f13145m = "\t";
        this.f13148p = null;
        this.f13150r = com.alibaba.fastjson.a.f12527a;
        this.f13151s = com.alibaba.fastjson.a.f12528b;
        this.f13143k = j1Var;
        this.f13142j = g1Var;
    }
}
