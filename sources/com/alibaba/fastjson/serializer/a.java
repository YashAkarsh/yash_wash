package com.alibaba.fastjson.serializer;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.HttpUrl;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.fastjson.asm.j {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    static final String f12992i0 = com.alibaba.fastjson.util.b.h(n0.class);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    static final String f12993j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    static final String f12994k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    static final String f12995l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    static final String f12996m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    static final String f12997n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    static final String f12998o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    static final String f12999p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    static final String f13000q0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected final com.alibaba.fastjson.util.a f13001g0 = new com.alibaba.fastjson.util.a();

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final AtomicLong f13002h0 = new AtomicLong();

    /* JADX INFO: renamed from: com.alibaba.fastjson.serializer.a$a, reason: collision with other inner class name */
    static class C0150a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f13003h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f13004i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final int f13005j = 3;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final int f13006k = 4;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final int f13007l = 5;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        static int f13008m = 6;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static int f13009n = 7;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static int f13010o = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.alibaba.fastjson.util.e[] f13011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f1 f13013c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f13014d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<String, Integer> f13015e = new HashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f13016f = 9;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f13017g;

        public C0150a(com.alibaba.fastjson.util.e[] eVarArr, f1 f1Var, String str, boolean z7, boolean z8) {
            this.f13011a = eVarArr;
            this.f13012b = str;
            this.f13013c = f1Var;
            this.f13014d = z7;
            this.f13017g = z8 || f1Var.f13046a.isEnum();
        }

        public int f(String str) {
            int length = this.f13011a.length;
            for (int i7 = 0; i7 < length; i7++) {
                if (this.f13011a[i7].f13293a.equals(str)) {
                    return i7;
                }
            }
            return -1;
        }

        public int g(String str) {
            if (this.f13015e.get(str) == null) {
                Map<String, Integer> map = this.f13015e;
                int i7 = this.f13016f;
                this.f13016f = i7 + 1;
                map.put(str, Integer.valueOf(i7));
            }
            return this.f13015e.get(str).intValue();
        }

        public int h(String str, int i7) {
            if (this.f13015e.get(str) == null) {
                this.f13015e.put(str, Integer.valueOf(this.f13016f));
                this.f13016f += i7;
            }
            return this.f13015e.get(str).intValue();
        }
    }

    static {
        String strH = com.alibaba.fastjson.util.b.h(y0.class);
        f12993j0 = strH;
        f12994k0 = "L" + strH + com.alipay.sdk.util.j.f13806b;
        String strH2 = com.alibaba.fastjson.util.b.h(j1.class);
        f12995l0 = strH2;
        f12996m0 = "L" + strH2 + com.alipay.sdk.util.j.f13806b;
        f12997n0 = com.alibaba.fastjson.util.b.h(p0.class);
        f12998o0 = "L" + com.alibaba.fastjson.util.b.h(p0.class) + com.alipay.sdk.util.j.f13806b;
        f12999p0 = com.alibaba.fastjson.util.b.b(e1.class);
        f13000q0 = com.alibaba.fastjson.util.b.b(i1.class);
    }

    private void A(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e[] eVarArr, C0150a c0150a) throws Exception {
        String str;
        String str2;
        String str3;
        char c8;
        boolean z7;
        int i7;
        a aVar;
        char c9;
        int i8;
        Class<?> cls2;
        int i9;
        int i10;
        String str4;
        int i11;
        int i12;
        a aVar2 = this;
        com.alibaba.fastjson.util.e[] eVarArr2 = eVarArr;
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.h(25, 1);
        hVar.h(25, 0);
        String str5 = f12992i0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str5, "hasPropertyFilters", "(" + f13000q0 + ")Z");
        hVar.b(154, fVar);
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.h(25, 2);
        hVar.h(25, 3);
        hVar.h(25, 4);
        hVar.h(21, 5);
        String str6 = f12997n0;
        StringBuilder sb = new StringBuilder();
        String str7 = "(L";
        sb.append("(L");
        sb.append(str5);
        String str8 = ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V";
        sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        hVar.i(com.alibaba.fastjson.asm.j.X, str6, "writeNoneASM", sb.toString());
        hVar.f(com.alibaba.fastjson.asm.j.S);
        hVar.l(fVar);
        String str9 = "out";
        hVar.h(25, c0150a.g("out"));
        hVar.h(16, 91);
        String str10 = f12995l0;
        String str11 = "(I)V";
        hVar.i(com.alibaba.fastjson.asm.j.W, str10, "write", "(I)V");
        int length = eVarArr2.length;
        if (length == 0) {
            hVar.h(25, c0150a.g("out"));
            hVar.h(16, 93);
            hVar.i(com.alibaba.fastjson.asm.j.W, str10, "write", "(I)V");
            return;
        }
        int i13 = 0;
        while (i13 < length) {
            int i14 = i13 == length + (-1) ? 93 : 44;
            com.alibaba.fastjson.util.e eVar = eVarArr2[i13];
            Class<?> cls3 = eVar.f13297e;
            hVar.k(eVar.f13293a);
            hVar.h(58, C0150a.f13008m);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str = str9;
                length = length;
                i13 = i13;
                int i15 = i14;
                str2 = str7;
                str3 = str11;
                c8 = 25;
                z7 = false;
                i7 = com.alibaba.fastjson.asm.j.W;
                hVar.h(25, c0150a.g(str));
                hVar.f(89);
                aVar = this;
                aVar.i(hVar, c0150a, eVar);
                String str12 = f12995l0;
                hVar.i(com.alibaba.fastjson.asm.j.W, str12, "writeInt", str3);
                c9 = 16;
                hVar.h(16, i15);
                hVar.i(com.alibaba.fastjson.asm.j.W, str12, "write", str3);
            } else {
                if (cls3 == Long.TYPE) {
                    hVar.h(25, c0150a.g(str9));
                    hVar.f(89);
                    aVar2.i(hVar, c0150a, eVar);
                    String str13 = f12995l0;
                    i12 = com.alibaba.fastjson.asm.j.W;
                    hVar.i(com.alibaba.fastjson.asm.j.W, str13, "writeLong", "(J)V");
                    hVar.h(16, i14);
                    hVar.i(com.alibaba.fastjson.asm.j.W, str13, "write", str11);
                } else if (cls3 == Float.TYPE) {
                    hVar.h(25, c0150a.g(str9));
                    hVar.f(89);
                    aVar2.i(hVar, c0150a, eVar);
                    hVar.f(4);
                    String str14 = f12995l0;
                    i12 = com.alibaba.fastjson.asm.j.W;
                    hVar.i(com.alibaba.fastjson.asm.j.W, str14, "writeFloat", "(FZ)V");
                    hVar.h(16, i14);
                    hVar.i(com.alibaba.fastjson.asm.j.W, str14, "write", str11);
                } else if (cls3 == Double.TYPE) {
                    hVar.h(25, c0150a.g(str9));
                    hVar.f(89);
                    aVar2.i(hVar, c0150a, eVar);
                    hVar.f(4);
                    String str15 = f12995l0;
                    i12 = com.alibaba.fastjson.asm.j.W;
                    hVar.i(com.alibaba.fastjson.asm.j.W, str15, "writeDouble", "(DZ)V");
                    hVar.h(16, i14);
                    hVar.i(com.alibaba.fastjson.asm.j.W, str15, "write", str11);
                } else {
                    if (cls3 == Boolean.TYPE) {
                        hVar.h(25, c0150a.g(str9));
                        hVar.f(89);
                        aVar2.i(hVar, c0150a, eVar);
                        String str16 = f12995l0;
                        i8 = com.alibaba.fastjson.asm.j.W;
                        hVar.i(com.alibaba.fastjson.asm.j.W, str16, "write", "(Z)V");
                        hVar.h(16, i14);
                        hVar.i(com.alibaba.fastjson.asm.j.W, str16, "write", str11);
                    } else if (cls3 == Character.TYPE) {
                        hVar.h(25, c0150a.g(str9));
                        aVar2.i(hVar, c0150a, eVar);
                        hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Character", "toString", "(C)Ljava/lang/String;");
                        hVar.h(16, i14);
                        hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeString", "(Ljava/lang/String;C)V");
                        length = length;
                        i13 = i13;
                        i7 = 182;
                        str2 = str7;
                        str3 = str11;
                        z7 = false;
                        aVar = aVar2;
                        str = str9;
                        c9 = 16;
                        c8 = 25;
                    } else if (cls3 == String.class) {
                        hVar.h(25, c0150a.g(str9));
                        aVar2.i(hVar, c0150a, eVar);
                        hVar.h(16, i14);
                        String str17 = f12995l0;
                        i7 = com.alibaba.fastjson.asm.j.W;
                        hVar.i(com.alibaba.fastjson.asm.j.W, str17, "writeString", "(Ljava/lang/String;C)V");
                        length = length;
                        i13 = i13;
                        str2 = str7;
                        str3 = str11;
                        z7 = false;
                        c9 = 16;
                        aVar = aVar2;
                        str = str9;
                        c8 = 25;
                    } else {
                        i8 = com.alibaba.fastjson.asm.j.W;
                        if (cls3.isEnum()) {
                            hVar.h(25, c0150a.g(str9));
                            hVar.f(89);
                            aVar2.i(hVar, c0150a, eVar);
                            String str18 = f12995l0;
                            hVar.i(com.alibaba.fastjson.asm.j.W, str18, "writeEnum", "(Ljava/lang/Enum;)V");
                            hVar.h(16, i14);
                            hVar.i(com.alibaba.fastjson.asm.j.W, str18, "write", str11);
                        } else if (List.class.isAssignableFrom(cls3)) {
                            Type type = eVar.f13298f;
                            Type type2 = type instanceof Class ? Object.class : ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (!(type2 instanceof Class) || (cls2 = (Class) type2) == Object.class) {
                                cls2 = null;
                            }
                            aVar2.i(hVar, c0150a, eVar);
                            hVar.c(com.alibaba.fastjson.asm.j.f12606c0, "java/util/List");
                            hVar.h(58, c0150a.g("list"));
                            if (cls2 == String.class && c0150a.f13014d) {
                                hVar.h(25, c0150a.g(str9));
                                hVar.h(25, c0150a.g("list"));
                                hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "write", "(Ljava/util/List;)V");
                                str = str9;
                                i11 = 182;
                                str2 = str7;
                                str4 = str11;
                                i9 = 25;
                                i10 = 16;
                            } else {
                                com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
                                hVar.h(25, c0150a.g("list"));
                                hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar3);
                                hVar.h(25, c0150a.g(str9));
                                String str19 = f12995l0;
                                Type type3 = type2;
                                String str20 = str8;
                                hVar.i(com.alibaba.fastjson.asm.j.W, str19, "writeNull", "()V");
                                hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
                                hVar.l(fVar3);
                                hVar.h(25, c0150a.g("list"));
                                hVar.i(com.alibaba.fastjson.asm.j.Z, "java/util/List", "size", "()I");
                                hVar.h(54, c0150a.g("size"));
                                hVar.h(25, c0150a.g(str9));
                                hVar.h(16, 91);
                                hVar.i(com.alibaba.fastjson.asm.j.W, str19, "write", str11);
                                com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
                                hVar.f(3);
                                String str21 = str7;
                                hVar.h(54, c0150a.g("i"));
                                hVar.l(fVar4);
                                hVar.h(21, c0150a.g("i"));
                                hVar.h(21, c0150a.g("size"));
                                hVar.b(com.alibaba.fastjson.asm.j.L, fVar6);
                                hVar.h(21, c0150a.g("i"));
                                hVar.b(153, fVar5);
                                hVar.h(25, c0150a.g(str9));
                                hVar.h(16, 44);
                                hVar.i(com.alibaba.fastjson.asm.j.W, str19, "write", str11);
                                hVar.l(fVar5);
                                hVar.h(25, c0150a.g("list"));
                                hVar.h(21, c0150a.g("i"));
                                hVar.i(com.alibaba.fastjson.asm.j.Z, "java/util/List", "get", "(I)Ljava/lang/Object;");
                                hVar.h(58, c0150a.g("list_item"));
                                com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
                                String str22 = str11;
                                hVar.h(25, c0150a.g("list_item"));
                                hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar8);
                                hVar.h(25, c0150a.g(str9));
                                String str23 = str9;
                                hVar.i(com.alibaba.fastjson.asm.j.W, str19, "writeNull", "()V");
                                hVar.b(com.alibaba.fastjson.asm.j.P, fVar7);
                                hVar.l(fVar8);
                                com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
                                com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
                                if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                    fVar4 = fVar4;
                                    fVar7 = fVar7;
                                    str8 = str20;
                                    str2 = str21;
                                } else {
                                    hVar.h(25, c0150a.g("list_item"));
                                    hVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                                    hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
                                    hVar.b(com.alibaba.fastjson.asm.j.O, fVar10);
                                    aVar2.k(c0150a, hVar, eVar, cls2);
                                    hVar.h(58, c0150a.g("list_item_desc"));
                                    com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
                                    com.alibaba.fastjson.asm.f fVar12 = new com.alibaba.fastjson.asm.f();
                                    if (c0150a.f13014d) {
                                        hVar.h(25, c0150a.g("list_item_desc"));
                                        String str24 = f12997n0;
                                        hVar.c(com.alibaba.fastjson.asm.j.f12608d0, str24);
                                        hVar.b(153, fVar11);
                                        hVar.h(25, c0150a.g("list_item_desc"));
                                        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, str24);
                                        hVar.h(25, 1);
                                        hVar.h(25, c0150a.g("list_item"));
                                        if (c0150a.f13017g) {
                                            hVar.f(1);
                                        } else {
                                            hVar.h(21, c0150a.g("i"));
                                            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                        }
                                        hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
                                        hVar.k(Integer.valueOf(eVar.f13301i));
                                        StringBuilder sb2 = new StringBuilder();
                                        str2 = str21;
                                        sb2.append(str2);
                                        sb2.append(f12992i0);
                                        str8 = str20;
                                        sb2.append(str8);
                                        hVar.i(com.alibaba.fastjson.asm.j.W, str24, "writeAsArrayNonContext", sb2.toString());
                                        hVar.b(com.alibaba.fastjson.asm.j.P, fVar12);
                                        hVar.l(fVar11);
                                    } else {
                                        fVar4 = fVar4;
                                        fVar7 = fVar7;
                                        str8 = str20;
                                        str2 = str21;
                                    }
                                    hVar.h(25, c0150a.g("list_item_desc"));
                                    hVar.h(25, 1);
                                    hVar.h(25, c0150a.g("list_item"));
                                    if (c0150a.f13017g) {
                                        hVar.f(1);
                                    } else {
                                        hVar.h(21, c0150a.g("i"));
                                        hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                    }
                                    hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
                                    hVar.k(Integer.valueOf(eVar.f13301i));
                                    hVar.i(com.alibaba.fastjson.asm.j.Z, f12993j0, "write", str2 + f12992i0 + str8);
                                    hVar.l(fVar12);
                                    hVar.b(com.alibaba.fastjson.asm.j.P, fVar9);
                                }
                                hVar.l(fVar10);
                                hVar.h(25, 1);
                                hVar.h(25, c0150a.g("list_item"));
                                if (c0150a.f13017g) {
                                    hVar.f(1);
                                } else {
                                    hVar.h(21, c0150a.g("i"));
                                    hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                }
                                if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                                    hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                                } else {
                                    hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b((Class) type3)));
                                    hVar.k(Integer.valueOf(eVar.f13301i));
                                    hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                                }
                                hVar.l(fVar9);
                                hVar.l(fVar7);
                                hVar.a(c0150a.g("i"), 1);
                                hVar.b(com.alibaba.fastjson.asm.j.P, fVar4);
                                hVar.l(fVar6);
                                str = str23;
                                i9 = 25;
                                hVar.h(25, c0150a.g(str));
                                i10 = 16;
                                hVar.h(16, 93);
                                str4 = str22;
                                i11 = com.alibaba.fastjson.asm.j.W;
                                hVar.i(com.alibaba.fastjson.asm.j.W, str19, "write", str4);
                                hVar.l(fVar2);
                            }
                            hVar.h(i9, c0150a.g(str));
                            hVar.h(i10, i14);
                            hVar.i(i11, f12995l0, "write", str4);
                            aVar = this;
                            i7 = i11;
                            str3 = str4;
                            c8 = 25;
                            z7 = false;
                        } else {
                            String str25 = str9;
                            length = length;
                            i13 = i13;
                            str2 = str7;
                            String str26 = str11;
                            com.alibaba.fastjson.asm.f fVar13 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar14 = new com.alibaba.fastjson.asm.f();
                            i(hVar, c0150a, eVar);
                            hVar.f(89);
                            hVar.h(58, c0150a.g("field_" + eVar.f13297e.getName()));
                            hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar14);
                            hVar.h(25, c0150a.g(str25));
                            String str27 = f12995l0;
                            int i16 = i14;
                            hVar.i(com.alibaba.fastjson.asm.j.W, str27, "writeNull", "()V");
                            hVar.b(com.alibaba.fastjson.asm.j.P, fVar13);
                            hVar.l(fVar14);
                            com.alibaba.fastjson.asm.f fVar15 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar16 = new com.alibaba.fastjson.asm.f();
                            hVar.h(25, c0150a.g("field_" + eVar.f13297e.getName()));
                            hVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                            hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls3)));
                            hVar.b(com.alibaba.fastjson.asm.j.O, fVar16);
                            j(c0150a, hVar, eVar);
                            hVar.h(58, c0150a.g("fied_ser"));
                            com.alibaba.fastjson.asm.f fVar17 = new com.alibaba.fastjson.asm.f();
                            com.alibaba.fastjson.asm.f fVar18 = new com.alibaba.fastjson.asm.f();
                            if (c0150a.f13014d && Modifier.isPublic(cls3.getModifiers())) {
                                hVar.h(25, c0150a.g("fied_ser"));
                                String str28 = f12997n0;
                                hVar.c(com.alibaba.fastjson.asm.j.f12608d0, str28);
                                hVar.b(153, fVar17);
                                hVar.h(25, c0150a.g("fied_ser"));
                                hVar.c(com.alibaba.fastjson.asm.j.f12606c0, str28);
                                hVar.h(25, 1);
                                hVar.h(25, c0150a.g("field_" + eVar.f13297e.getName()));
                                hVar.h(25, C0150a.f13008m);
                                hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls3)));
                                hVar.k(Integer.valueOf(eVar.f13301i));
                                hVar.i(com.alibaba.fastjson.asm.j.W, str28, "writeAsArrayNonContext", str2 + f12992i0 + str8);
                                hVar.b(com.alibaba.fastjson.asm.j.P, fVar18);
                                hVar.l(fVar17);
                            }
                            hVar.h(25, c0150a.g("fied_ser"));
                            hVar.h(25, 1);
                            hVar.h(25, c0150a.g("field_" + eVar.f13297e.getName()));
                            hVar.h(25, C0150a.f13008m);
                            hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls3)));
                            hVar.k(Integer.valueOf(eVar.f13301i));
                            String str29 = f12993j0;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(str2);
                            String str30 = f12992i0;
                            sb3.append(str30);
                            sb3.append(str8);
                            hVar.i(com.alibaba.fastjson.asm.j.Z, str29, "write", sb3.toString());
                            hVar.l(fVar18);
                            hVar.b(com.alibaba.fastjson.asm.j.P, fVar15);
                            hVar.l(fVar16);
                            String strI = eVar.i();
                            hVar.h(25, 1);
                            hVar.h(25, c0150a.g("field_" + eVar.f13297e.getName()));
                            if (strI != null) {
                                hVar.k(strI);
                                i7 = com.alibaba.fastjson.asm.j.W;
                                hVar.i(com.alibaba.fastjson.asm.j.W, str30, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
                            } else {
                                i7 = com.alibaba.fastjson.asm.j.W;
                                hVar.h(25, C0150a.f13008m);
                                Type type4 = eVar.f13298f;
                                if ((type4 instanceof Class) && ((Class) type4).isPrimitive()) {
                                    hVar.i(com.alibaba.fastjson.asm.j.W, str30, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
                                } else {
                                    z7 = false;
                                    hVar.h(25, 0);
                                    hVar.d(180, c0150a.f13012b, eVar.f13293a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                                    hVar.k(Integer.valueOf(eVar.f13301i));
                                    i7 = com.alibaba.fastjson.asm.j.W;
                                    hVar.i(com.alibaba.fastjson.asm.j.W, str30, r9, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                                }
                                hVar.l(fVar15);
                                hVar.l(fVar13);
                                str = str25;
                                c8 = 25;
                                hVar.h(25, c0150a.g(str));
                                hVar.h(16, i16);
                                str3 = str26;
                                hVar.i(i7, str27, "write", str3);
                                aVar = this;
                            }
                            z7 = false;
                            hVar.l(fVar15);
                            hVar.l(fVar13);
                            str = str25;
                            c8 = 25;
                            hVar.h(25, c0150a.g(str));
                            hVar.h(16, i16);
                            str3 = str26;
                            hVar.i(i7, str27, "write", str3);
                            aVar = this;
                        }
                        c9 = 16;
                    }
                    aVar = aVar2;
                    str = str9;
                    i7 = i8;
                    str2 = str7;
                    str3 = str11;
                    c8 = 25;
                    z7 = false;
                    c9 = 16;
                }
                length = length;
                i13 = i13;
                i7 = i12;
                str2 = str7;
                str3 = str11;
                z7 = false;
                c9 = 16;
                aVar = aVar2;
                str = str9;
                c8 = 25;
            }
            str11 = str3;
            length = length;
            i13++;
            eVarArr2 = eVarArr;
            str9 = str;
            aVar2 = aVar;
            str7 = str2;
        }
    }

    private void B(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e[] eVarArr, C0150a c0150a) throws Exception {
        String str;
        int i7;
        String str2;
        int i8;
        Class<?> cls2;
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        int length = eVarArr.length;
        String str3 = "out";
        if (!c0150a.f13014d) {
            com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
            hVar.h(25, c0150a.g("out"));
            hVar.k(Integer.valueOf(k1.PrettyFormat.f13132a));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
            hVar.b(154, fVar3);
            int length2 = eVarArr.length;
            int i9 = 0;
            boolean z7 = false;
            while (i9 < length2) {
                int i10 = length2;
                if (eVarArr[i9].f13294b != null) {
                    z7 = true;
                }
                i9++;
                length2 = i10;
            }
            if (z7) {
                hVar.h(25, c0150a.g("out"));
                hVar.k(Integer.valueOf(k1.IgnoreErrorGetter.f13132a));
                hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
                hVar.b(153, fVar2);
            } else {
                hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
            }
            hVar.l(fVar3);
            hVar.h(25, 0);
            hVar.h(25, 1);
            hVar.h(25, 2);
            hVar.h(25, 3);
            hVar.h(25, 4);
            hVar.h(21, 5);
            hVar.i(com.alibaba.fastjson.asm.j.X, f12997n0, "write", "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.f(com.alibaba.fastjson.asm.j.S);
            hVar.l(fVar2);
        }
        if (!c0150a.f13017g) {
            com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
            hVar.h(25, 0);
            hVar.h(25, 1);
            hVar.h(25, 2);
            hVar.h(21, 5);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "writeReference", "(L" + f12992i0 + ";Ljava/lang/Object;I)Z");
            hVar.b(153, fVar4);
            hVar.f(com.alibaba.fastjson.asm.j.S);
            hVar.l(fVar4);
        }
        if (c0150a.f13014d) {
            str = c0150a.f13017g ? "writeAsArrayNonContext" : "writeAsArray";
        } else {
            str = "writeAsArrayNormal";
        }
        int i11 = c0150a.f13013c.f13052g;
        k1 k1Var = k1.BeanToArray;
        if ((i11 & k1Var.f13132a) == 0) {
            com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
            hVar.h(25, c0150a.g("out"));
            hVar.k(Integer.valueOf(k1Var.f13132a));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
            hVar.b(153, fVar5);
            hVar.h(25, 0);
            hVar.h(25, 1);
            hVar.h(25, 2);
            hVar.h(25, 3);
            hVar.h(25, 4);
            hVar.h(21, 5);
            hVar.i(com.alibaba.fastjson.asm.j.W, c0150a.f13012b, str, "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.f(com.alibaba.fastjson.asm.j.S);
            hVar.l(fVar5);
        } else {
            hVar.h(25, 0);
            hVar.h(25, 1);
            hVar.h(25, 2);
            hVar.h(25, 3);
            hVar.h(25, 4);
            hVar.h(21, 5);
            hVar.i(com.alibaba.fastjson.asm.j.W, c0150a.f13012b, str, "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.f(com.alibaba.fastjson.asm.j.S);
        }
        String str4 = "parent";
        if (!c0150a.f13017g) {
            hVar.h(25, 1);
            String str5 = f12992i0;
            StringBuilder sb = new StringBuilder();
            sb.append("()");
            String str6 = f12999p0;
            sb.append(str6);
            hVar.i(com.alibaba.fastjson.asm.j.W, str5, "getContext", sb.toString());
            hVar.h(58, c0150a.g("parent"));
            hVar.h(25, 1);
            hVar.h(25, c0150a.g("parent"));
            hVar.h(25, 2);
            hVar.h(25, 3);
            hVar.k(Integer.valueOf(c0150a.f13013c.f13052g));
            hVar.i(com.alibaba.fastjson.asm.j.W, str5, "setContext", "(" + str6 + "Ljava/lang/Object;Ljava/lang/Object;I)V");
        }
        boolean z8 = (c0150a.f13013c.f13052g & k1.WriteClassName.f13132a) != 0;
        if (z8 || !c0150a.f13014d) {
            com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
            if (z8) {
                i7 = com.alibaba.fastjson.asm.j.W;
            } else {
                hVar.h(25, 1);
                hVar.h(25, 4);
                hVar.h(25, 2);
                String str7 = f12992i0;
                i7 = com.alibaba.fastjson.asm.j.W;
                hVar.i(com.alibaba.fastjson.asm.j.W, str7, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
                hVar.b(153, fVar7);
            }
            hVar.h(25, 4);
            hVar.h(25, 2);
            hVar.i(i7, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar.b(165, fVar7);
            hVar.l(fVar8);
            hVar.h(25, c0150a.g("out"));
            hVar.h(16, 123);
            hVar.i(i7, f12995l0, "write", "(I)V");
            hVar.h(25, 0);
            hVar.h(25, 1);
            if (c0150a.f13013c.f13048c != null) {
                hVar.k(c0150a.f13013c.f13048c);
            } else {
                hVar.f(1);
            }
            hVar.h(25, 2);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "writeClassName", "(L" + f12992i0 + ";Ljava/lang/String;Ljava/lang/Object;)V");
            hVar.h(16, 44);
            hVar.b(com.alibaba.fastjson.asm.j.P, fVar6);
            hVar.l(fVar7);
            hVar.h(16, 123);
            hVar.l(fVar6);
        } else {
            hVar.h(16, 123);
            str4 = "parent";
        }
        hVar.h(54, c0150a.g("seperator"));
        if (!c0150a.f13014d) {
            c(hVar, c0150a);
        }
        if (!c0150a.f13014d) {
            hVar.h(25, c0150a.g("out"));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isNotWriteDefaultValue", "()Z");
            hVar.h(54, c0150a.g("notWriteDefaultValue"));
            hVar.h(25, 1);
            hVar.h(25, 0);
            String str8 = f12992i0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(");
            String str9 = f13000q0;
            sb2.append(str9);
            sb2.append(")Z");
            hVar.i(com.alibaba.fastjson.asm.j.W, str8, "checkValue", sb2.toString());
            hVar.h(54, c0150a.g("checkValue"));
            hVar.h(25, 1);
            hVar.h(25, 0);
            hVar.i(com.alibaba.fastjson.asm.j.W, str8, "hasNameFilters", "(" + str9 + ")Z");
            hVar.h(54, c0150a.g("hasNameFilters"));
        }
        int i12 = 0;
        while (i12 < length) {
            com.alibaba.fastjson.util.e eVar = eVarArr[i12];
            Class<?> cls3 = eVar.f13297e;
            hVar.k(eVar.f13293a);
            hVar.h(58, C0150a.f13008m);
            if (cls3 == Byte.TYPE || cls3 == Short.TYPE || cls3 == Integer.TYPE) {
                str2 = str3;
                i8 = i12;
                m(cls, hVar, eVar, c0150a, c0150a.g(cls3.getName()), 'I');
            } else {
                if (cls3 == Long.TYPE) {
                    cls2 = cls;
                    p(cls2, hVar, eVar, c0150a);
                } else {
                    cls2 = cls;
                    if (cls3 == Float.TYPE) {
                        h(cls2, hVar, eVar, c0150a);
                    } else if (cls3 == Double.TYPE) {
                        e(cls2, hVar, eVar, c0150a);
                    } else if (cls3 == Boolean.TYPE) {
                        str2 = str3;
                        i8 = i12;
                        m(cls, hVar, eVar, c0150a, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3031f), 'Z');
                    } else {
                        str2 = str3;
                        i8 = i12;
                        if (cls3 == Character.TYPE) {
                            m(cls, hVar, eVar, c0150a, c0150a.g("char"), 'C');
                        } else if (cls3 == String.class) {
                            w(cls2, hVar, eVar, c0150a);
                        } else if (cls3 == BigDecimal.class) {
                            d(cls2, hVar, eVar, c0150a);
                        } else if (List.class.isAssignableFrom(cls3)) {
                            o(cls2, hVar, eVar, c0150a);
                        } else if (cls3.isEnum()) {
                            f(cls2, hVar, eVar, c0150a);
                        } else {
                            s(cls2, hVar, eVar, c0150a);
                        }
                    }
                }
                str2 = str3;
                i8 = i12;
            }
            i12 = i8 + 1;
            str3 = str2;
        }
        String str10 = str3;
        if (!c0150a.f13014d) {
            a(hVar, c0150a);
        }
        com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
        hVar.h(21, c0150a.g("seperator"));
        hVar.e(16, 123);
        hVar.b(160, fVar9);
        hVar.h(25, c0150a.g(str10));
        hVar.h(16, 123);
        String str11 = f12995l0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str11, "write", "(I)V");
        hVar.l(fVar9);
        hVar.h(25, c0150a.g(str10));
        hVar.h(16, 125);
        hVar.i(com.alibaba.fastjson.asm.j.W, str11, "write", "(I)V");
        hVar.l(fVar10);
        hVar.l(fVar);
        if (c0150a.f13017g) {
            return;
        }
        hVar.h(25, 1);
        hVar.h(25, c0150a.g(str4));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "setContext", "(" + f12999p0 + ")V");
    }

    private void a(com.alibaba.fastjson.asm.h hVar, C0150a c0150a) {
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.h(25, 2);
        hVar.h(21, c0150a.g("seperator"));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "writeAfter", "(L" + f12992i0 + ";Ljava/lang/Object;C)C");
        hVar.h(54, c0150a.g("seperator"));
    }

    private void b(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        Class<?> cls = eVar.f13297e;
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.h(25, 2);
        hVar.h(25, C0150a.f13008m);
        if (cls == Byte.TYPE) {
            hVar.h(21, c0150a.g("byte"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.h(21, c0150a.g("short"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.h(21, c0150a.g("int"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.h(21, c0150a.g("char"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.h(22, c0150a.h("long", 2));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.h(23, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3028c));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.h(24, c0150a.h("double", 2));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.h(21, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3031f));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.h(25, c0150a.g("decimal"));
        } else if (cls == String.class) {
            hVar.h(25, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
        } else if (cls.isEnum()) {
            hVar.h(25, c0150a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.h(25, c0150a.g("list"));
        } else {
            hVar.h(25, c0150a.g("object"));
        }
        hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "apply", "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z");
    }

    private void c(com.alibaba.fastjson.asm.h hVar, C0150a c0150a) {
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.h(25, 2);
        hVar.h(21, c0150a.g("seperator"));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "writeBefore", "(L" + f12992i0 + ";Ljava/lang/Object;C)C");
        hVar.h(54, c0150a.g("seperator"));
    }

    private void d(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar);
        i(hVar, c0150a, eVar);
        hVar.h(58, c0150a.g("decimal"));
        g(hVar, eVar, c0150a, fVar);
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        hVar.l(fVar2);
        hVar.h(25, c0150a.g("decimal"));
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar3);
        l(hVar, eVar, c0150a);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar4);
        hVar.l(fVar3);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        hVar.h(25, C0150a.f13008m);
        hVar.h(25, c0150a.g("decimal"));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValue", "(CLjava/lang/String;Ljava/math/BigDecimal;)V");
        v(hVar, c0150a);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar4);
        hVar.l(fVar4);
        hVar.l(fVar);
    }

    private void e(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar);
        i(hVar, c0150a, eVar);
        hVar.h(57, c0150a.h("double", 2));
        g(hVar, eVar, c0150a, fVar);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        hVar.h(25, C0150a.f13008m);
        hVar.h(24, c0150a.h("double", 2));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValue", "(CLjava/lang/String;D)V");
        v(hVar, c0150a);
        hVar.l(fVar);
    }

    private void f(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar3);
        i(hVar, c0150a, eVar);
        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, "java/lang/Enum");
        hVar.h(58, c0150a.g("enum"));
        g(hVar, eVar, c0150a, fVar3);
        hVar.h(25, c0150a.g("enum"));
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar);
        l(hVar, eVar, c0150a);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
        hVar.l(fVar);
        if (c0150a.f13014d) {
            hVar.h(25, c0150a.g("out"));
            hVar.h(21, c0150a.g("seperator"));
            hVar.h(25, C0150a.f13008m);
            hVar.h(25, c0150a.g("enum"));
            hVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/Enum", "name", "()Ljava/lang/String;");
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValueStringWithDoubleQuote", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.h(25, c0150a.g("out"));
            hVar.h(21, c0150a.g("seperator"));
            String str = f12995l0;
            hVar.i(com.alibaba.fastjson.asm.j.W, str, "write", "(I)V");
            hVar.h(25, c0150a.g("out"));
            hVar.h(25, C0150a.f13008m);
            hVar.f(3);
            hVar.i(com.alibaba.fastjson.asm.j.W, str, "writeFieldName", "(Ljava/lang/String;Z)V");
            hVar.h(25, 1);
            hVar.h(25, c0150a.g("enum"));
            hVar.h(25, C0150a.f13008m);
            hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(eVar.f13297e)));
            hVar.k(Integer.valueOf(eVar.f13301i));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
        }
        v(hVar, c0150a);
        hVar.l(fVar2);
        hVar.l(fVar3);
    }

    private void g(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a, com.alibaba.fastjson.asm.f fVar) {
        if (eVar.f13307o) {
            hVar.h(25, c0150a.g("out"));
            hVar.k(Integer.valueOf(k1.SkipTransientField.f13132a));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
            hVar.b(154, fVar);
        }
        r(hVar, eVar, c0150a, fVar);
        if (c0150a.f13014d) {
            return;
        }
        b(hVar, eVar, c0150a);
        hVar.b(153, fVar);
        t(hVar, eVar, c0150a);
        u(hVar, eVar, c0150a, fVar);
    }

    private void h(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar);
        i(hVar, c0150a, eVar);
        hVar.h(56, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3028c));
        g(hVar, eVar, c0150a, fVar);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        hVar.h(25, C0150a.f13008m);
        hVar.h(23, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3028c));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValue", "(CLjava/lang/String;F)V");
        v(hVar, c0150a);
        hVar.l(fVar);
    }

    private void i(com.alibaba.fastjson.asm.h hVar, C0150a c0150a, com.alibaba.fastjson.util.e eVar) {
        Method method = eVar.f13294b;
        if (method != null) {
            hVar.h(25, c0150a.g("entity"));
            Class<?> declaringClass = method.getDeclaringClass();
            hVar.i(declaringClass.isInterface() ? com.alibaba.fastjson.asm.j.Z : com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(declaringClass), method.getName(), com.alibaba.fastjson.util.b.c(method));
            if (method.getReturnType().equals(eVar.f13297e)) {
                return;
            }
            hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(eVar.f13297e));
            return;
        }
        hVar.h(25, c0150a.g("entity"));
        Field field = eVar.f13295c;
        hVar.d(180, com.alibaba.fastjson.util.b.h(eVar.f13299g), field.getName(), com.alibaba.fastjson.util.b.b(field.getType()));
        if (field.getType().equals(eVar.f13297e)) {
            return;
        }
        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(eVar.f13297e));
    }

    private void j(C0150a c0150a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.h(25, 0);
        String str = c0150a.f13012b;
        String str2 = eVar.f13293a + "_asm_ser_";
        String str3 = f12994k0;
        hVar.d(180, str, str2, str3);
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar);
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(eVar.f13297e)));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.d(com.alibaba.fastjson.asm.j.V, c0150a.f13012b, eVar.f13293a + "_asm_ser_", str3);
        hVar.l(fVar);
        hVar.h(25, 0);
        hVar.d(180, c0150a.f13012b, eVar.f13293a + "_asm_ser_", str3);
    }

    private void k(C0150a c0150a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, Class<?> cls) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.h(25, 0);
        String str = c0150a.f13012b;
        String str2 = eVar.f13293a + "_asm_list_item_ser_";
        String str3 = f12994k0;
        hVar.d(180, str, str2, str3);
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar);
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls)));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "getObjectWriter", "(Ljava/lang/Class;)" + str3);
        hVar.d(com.alibaba.fastjson.asm.j.V, c0150a.f13012b, eVar.f13293a + "_asm_list_item_ser_", str3);
        hVar.l(fVar);
        hVar.h(25, 0);
        hVar.d(180, c0150a.f13012b, eVar.f13293a + "_asm_list_item_ser_", str3);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0099  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:43:0x0138  */
    private void l(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        int i7;
        int iB;
        int iB2;
        Class<?> cls = eVar.f13297e;
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        hVar.l(fVar);
        e0.b bVarE = eVar.e();
        int iE = bVarE != null ? k1.e(bVarE.serialzeFeatures()) : 0;
        e0.d dVar = c0150a.f13013c.f13049d;
        if (dVar != null) {
            iE |= k1.e(dVar.serialzeFeatures());
        }
        if (cls == String.class) {
            iB = k1.WriteMapNullValue.b();
            iB2 = k1.WriteNullStringAsEmpty.b();
        } else if (Number.class.isAssignableFrom(cls)) {
            iB = k1.WriteMapNullValue.b();
            iB2 = k1.WriteNullNumberAsZero.b();
        } else {
            if (!Collection.class.isAssignableFrom(cls)) {
                if (Boolean.class == cls) {
                    iB = k1.WriteMapNullValue.b();
                    iB2 = k1.WriteNullBooleanAsFalse.b();
                } else {
                    i7 = k1.G;
                }
                if ((iE & i7) == 0) {
                    hVar.h(25, c0150a.g("out"));
                    hVar.k(Integer.valueOf(i7));
                    hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
                    hVar.b(153, fVar2);
                }
                hVar.l(fVar3);
                hVar.h(25, c0150a.g("out"));
                hVar.h(21, c0150a.g("seperator"));
                String str = f12995l0;
                hVar.i(com.alibaba.fastjson.asm.j.W, str, "write", "(I)V");
                x(hVar, c0150a);
                hVar.h(25, c0150a.g("out"));
                hVar.k(Integer.valueOf(iE));
                if (cls != String.class || cls == Character.class) {
                    hVar.k(Integer.valueOf(k1.WriteNullStringAsEmpty.f13132a));
                } else if (Number.class.isAssignableFrom(cls)) {
                    hVar.k(Integer.valueOf(k1.WriteNullNumberAsZero.f13132a));
                } else if (cls == Boolean.class) {
                    hVar.k(Integer.valueOf(k1.WriteNullBooleanAsFalse.f13132a));
                } else if (Collection.class.isAssignableFrom(cls) || cls.isArray()) {
                    hVar.k(Integer.valueOf(k1.WriteNullListAsEmpty.f13132a));
                } else {
                    hVar.k(0);
                }
                hVar.i(com.alibaba.fastjson.asm.j.W, str, "writeNull", "(II)V");
                v(hVar, c0150a);
                hVar.b(com.alibaba.fastjson.asm.j.P, fVar4);
                hVar.l(fVar2);
                hVar.l(fVar4);
            }
            iB = k1.WriteMapNullValue.b();
            iB2 = k1.WriteNullListAsEmpty.b();
        }
        i7 = iB | iB2;
        if ((iE & i7) == 0) {
            hVar.h(25, c0150a.g("out"));
            hVar.k(Integer.valueOf(i7));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
            hVar.b(153, fVar2);
        }
        hVar.l(fVar3);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        String str2 = f12995l0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str2, "write", "(I)V");
        x(hVar, c0150a);
        hVar.h(25, c0150a.g("out"));
        hVar.k(Integer.valueOf(iE));
        if (cls != String.class) {
            hVar.k(Integer.valueOf(k1.WriteNullStringAsEmpty.f13132a));
        } else {
            hVar.k(Integer.valueOf(k1.WriteNullStringAsEmpty.f13132a));
        }
        hVar.i(com.alibaba.fastjson.asm.j.W, str2, "writeNull", "(II)V");
        v(hVar, c0150a);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar4);
        hVar.l(fVar2);
        hVar.l(fVar4);
    }

    private void m(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a, int i7, char c8) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar);
        i(hVar, c0150a, eVar);
        hVar.h(54, i7);
        g(hVar, eVar, c0150a, fVar);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        hVar.h(25, C0150a.f13008m);
        hVar.h(21, i7);
        hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValue", "(CLjava/lang/String;" + c8 + ")V");
        v(hVar, c0150a);
        hVar.l(fVar);
    }

    private void n(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a, com.alibaba.fastjson.asm.f fVar) {
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.k(eVar.f13303k);
        hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "applyLabel", "(L" + f12992i0 + ";Ljava/lang/String;)Z");
        hVar.b(153, fVar);
    }

    private void o(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar;
        String str;
        com.alibaba.fastjson.util.e eVar2;
        int i7;
        int i8;
        int i9;
        Type typeQ = com.alibaba.fastjson.util.l.Q(eVar.f13298f);
        Class<?> cls2 = null;
        Class<?> cls3 = typeQ instanceof Class ? (Class) typeQ : null;
        if (cls3 != Object.class && cls3 != Serializable.class) {
            cls2 = cls3;
        }
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar2);
        i(hVar, c0150a, eVar);
        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, "java/util/List");
        hVar.h(58, c0150a.g("list"));
        g(hVar, eVar, c0150a, fVar2);
        hVar.h(25, c0150a.g("list"));
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar3);
        l(hVar, eVar, c0150a);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar4);
        hVar.l(fVar3);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        String str2 = f12995l0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str2, "write", "(I)V");
        x(hVar, c0150a);
        hVar.h(25, c0150a.g("list"));
        hVar.i(com.alibaba.fastjson.asm.j.Z, "java/util/List", "size", "()I");
        hVar.h(54, c0150a.g("size"));
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
        hVar.h(21, c0150a.g("size"));
        hVar.f(3);
        hVar.b(160, fVar5);
        hVar.h(25, c0150a.g("out"));
        hVar.k(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        hVar.i(com.alibaba.fastjson.asm.j.W, str2, "write", "(Ljava/lang/String;)V");
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar6);
        hVar.l(fVar5);
        if (!c0150a.f13017g) {
            hVar.h(25, 1);
            hVar.h(25, c0150a.g("list"));
            hVar.h(25, C0150a.f13008m);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)V");
        }
        if (typeQ == String.class && c0150a.f13014d) {
            hVar.h(25, c0150a.g("out"));
            hVar.h(25, c0150a.g("list"));
            hVar.i(com.alibaba.fastjson.asm.j.W, str2, "write", "(Ljava/util/List;)V");
            i8 = 25;
            i9 = 182;
            i7 = 1;
        } else {
            hVar.h(25, c0150a.g("out"));
            hVar.h(16, 91);
            hVar.i(com.alibaba.fastjson.asm.j.W, str2, "write", "(I)V");
            com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
            hVar.f(3);
            hVar.h(54, c0150a.g("i"));
            hVar.l(fVar7);
            hVar.h(21, c0150a.g("i"));
            hVar.h(21, c0150a.g("size"));
            hVar.b(com.alibaba.fastjson.asm.j.L, fVar9);
            hVar.h(21, c0150a.g("i"));
            hVar.b(153, fVar8);
            hVar.h(25, c0150a.g("out"));
            hVar.h(16, 44);
            hVar.i(com.alibaba.fastjson.asm.j.W, str2, "write", "(I)V");
            hVar.l(fVar8);
            hVar.h(25, c0150a.g("list"));
            hVar.h(21, c0150a.g("i"));
            hVar.i(com.alibaba.fastjson.asm.j.Z, "java/util/List", "get", "(I)Ljava/lang/Object;");
            hVar.h(58, c0150a.g("list_item"));
            com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
            hVar.h(25, c0150a.g("list_item"));
            hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar11);
            hVar.h(25, c0150a.g("out"));
            hVar.i(com.alibaba.fastjson.asm.j.W, str2, "writeNull", "()V");
            hVar.b(com.alibaba.fastjson.asm.j.P, fVar10);
            hVar.l(fVar11);
            com.alibaba.fastjson.asm.f fVar12 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar13 = new com.alibaba.fastjson.asm.f();
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                fVar10 = fVar10;
                fVar = fVar12;
                fVar13 = fVar13;
                str = "write";
                eVar2 = eVar;
            } else {
                hVar.h(25, c0150a.g("list_item"));
                hVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
                hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
                hVar.b(com.alibaba.fastjson.asm.j.O, fVar13);
                eVar2 = eVar;
                k(c0150a, hVar, eVar2, cls2);
                hVar.h(58, c0150a.g("list_item_desc"));
                com.alibaba.fastjson.asm.f fVar14 = new com.alibaba.fastjson.asm.f();
                com.alibaba.fastjson.asm.f fVar15 = new com.alibaba.fastjson.asm.f();
                if (c0150a.f13014d) {
                    String str3 = (c0150a.f13017g && c0150a.f13014d) ? "writeDirectNonContext" : "write";
                    hVar.h(25, c0150a.g("list_item_desc"));
                    String str4 = f12997n0;
                    hVar.c(com.alibaba.fastjson.asm.j.f12608d0, str4);
                    hVar.b(153, fVar14);
                    hVar.h(25, c0150a.g("list_item_desc"));
                    hVar.c(com.alibaba.fastjson.asm.j.f12606c0, str4);
                    hVar.h(25, 1);
                    hVar.h(25, c0150a.g("list_item"));
                    if (c0150a.f13017g) {
                        hVar.f(1);
                    } else {
                        hVar.h(21, c0150a.g("i"));
                        hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    }
                    hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
                    hVar.k(Integer.valueOf(eVar2.f13301i));
                    hVar.i(com.alibaba.fastjson.asm.j.W, str4, str3, "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                    hVar.b(com.alibaba.fastjson.asm.j.P, fVar15);
                    hVar.l(fVar14);
                } else {
                    fVar10 = fVar10;
                    fVar13 = fVar13;
                }
                hVar.h(25, c0150a.g("list_item_desc"));
                hVar.h(25, 1);
                hVar.h(25, c0150a.g("list_item"));
                if (c0150a.f13017g) {
                    hVar.f(1);
                } else {
                    hVar.h(21, c0150a.g("i"));
                    hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                }
                hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
                hVar.k(Integer.valueOf(eVar2.f13301i));
                str = "write";
                hVar.i(com.alibaba.fastjson.asm.j.Z, f12993j0, str, "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                hVar.l(fVar15);
                fVar = fVar12;
                hVar.b(com.alibaba.fastjson.asm.j.P, fVar);
            }
            hVar.l(fVar13);
            hVar.h(25, 1);
            hVar.h(25, c0150a.g("list_item"));
            if (c0150a.f13017g) {
                hVar.f(1);
            } else {
                hVar.h(21, c0150a.g("i"));
                hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            }
            if (cls2 == null || !Modifier.isPublic(cls2.getModifiers())) {
                hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b((Class) typeQ)));
                hVar.k(Integer.valueOf(eVar2.f13301i));
                hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
            hVar.l(fVar);
            hVar.l(fVar10);
            i7 = 1;
            hVar.a(c0150a.g("i"), 1);
            hVar.b(com.alibaba.fastjson.asm.j.P, fVar7);
            hVar.l(fVar9);
            i8 = 25;
            hVar.h(25, c0150a.g("out"));
            hVar.h(16, 93);
            i9 = com.alibaba.fastjson.asm.j.W;
            hVar.i(com.alibaba.fastjson.asm.j.W, str2, str, "(I)V");
        }
        hVar.h(i8, i7);
        hVar.i(i9, f12992i0, "popContext", "()V");
        hVar.l(fVar6);
        v(hVar, c0150a);
        hVar.l(fVar4);
        hVar.l(fVar2);
    }

    private void p(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar);
        i(hVar, c0150a, eVar);
        hVar.h(55, c0150a.h("long", 2));
        g(hVar, eVar, c0150a, fVar);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        hVar.h(25, C0150a.f13008m);
        hVar.h(22, c0150a.h("long", 2));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValue", "(CLjava/lang/String;J)V");
        v(hVar, c0150a);
        hVar.l(fVar);
    }

    private void q(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a, com.alibaba.fastjson.asm.f fVar) {
        if (!c0150a.f13014d) {
            hVar.h(25, 0);
            hVar.h(25, 1);
            hVar.h(25, 2);
            hVar.h(25, C0150a.f13008m);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "applyName", "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/String;)Z");
            hVar.b(153, fVar);
            n(hVar, eVar, c0150a, fVar);
        }
        if (eVar.f13295c == null) {
            hVar.h(25, c0150a.g("out"));
            hVar.k(Integer.valueOf(k1.IgnoreNonFieldGetter.f13132a));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
            hVar.b(154, fVar);
        }
    }

    private void r(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a, com.alibaba.fastjson.asm.f fVar) {
        if (c0150a.f13014d) {
            return;
        }
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        hVar.h(21, c0150a.g("notWriteDefaultValue"));
        hVar.b(153, fVar2);
        Class<?> cls = eVar.f13297e;
        if (cls == Boolean.TYPE) {
            hVar.h(21, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3031f));
            hVar.b(153, fVar);
        } else if (cls == Byte.TYPE) {
            hVar.h(21, c0150a.g("byte"));
            hVar.b(153, fVar);
        } else if (cls == Short.TYPE) {
            hVar.h(21, c0150a.g("short"));
            hVar.b(153, fVar);
        } else if (cls == Integer.TYPE) {
            hVar.h(21, c0150a.g("int"));
            hVar.b(153, fVar);
        } else if (cls == Long.TYPE) {
            hVar.h(22, c0150a.g("long"));
            hVar.f(9);
            hVar.f(com.alibaba.fastjson.asm.j.C);
            hVar.b(153, fVar);
        } else if (cls == Float.TYPE) {
            hVar.h(23, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3028c));
            hVar.f(11);
            hVar.f(com.alibaba.fastjson.asm.j.D);
            hVar.b(153, fVar);
        } else if (cls == Double.TYPE) {
            hVar.h(24, c0150a.g("double"));
            hVar.f(14);
            hVar.f(151);
            hVar.b(153, fVar);
        }
        hVar.l(fVar2);
    }

    private void s(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        q(hVar, eVar, c0150a, fVar);
        i(hVar, c0150a, eVar);
        hVar.h(58, c0150a.g("object"));
        g(hVar, eVar, c0150a, fVar);
        y(hVar, eVar, c0150a, fVar);
        hVar.l(fVar);
    }

    private void t(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.h(21, c0150a.g("hasNameFilters"));
        hVar.b(153, fVar);
        Class<?> cls = eVar.f13297e;
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.h(25, 2);
        hVar.h(25, C0150a.f13008m);
        if (cls == Byte.TYPE) {
            hVar.h(21, c0150a.g("byte"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
        } else if (cls == Short.TYPE) {
            hVar.h(21, c0150a.g("short"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
        } else if (cls == Integer.TYPE) {
            hVar.h(21, c0150a.g("int"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        } else if (cls == Character.TYPE) {
            hVar.h(21, c0150a.g("char"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
        } else if (cls == Long.TYPE) {
            hVar.h(22, c0150a.h("long", 2));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
        } else if (cls == Float.TYPE) {
            hVar.h(23, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3028c));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
        } else if (cls == Double.TYPE) {
            hVar.h(24, c0150a.h("double", 2));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
        } else if (cls == Boolean.TYPE) {
            hVar.h(21, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3031f));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
        } else if (cls == BigDecimal.class) {
            hVar.h(25, c0150a.g("decimal"));
        } else if (cls == String.class) {
            hVar.h(25, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
        } else if (cls.isEnum()) {
            hVar.h(25, c0150a.g("enum"));
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.h(25, c0150a.g("list"));
        } else {
            hVar.h(25, c0150a.g("object"));
        }
        hVar.i(com.alibaba.fastjson.asm.j.W, f12997n0, "processKey", "(L" + f12992i0 + ";Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;");
        hVar.h(58, C0150a.f13008m);
        hVar.l(fVar);
    }

    private void u(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a, com.alibaba.fastjson.asm.f fVar) {
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        Class<?> cls = eVar.f13297e;
        if (cls.isPrimitive()) {
            com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
            hVar.h(21, c0150a.g("checkValue"));
            hVar.b(154, fVar3);
            hVar.f(1);
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
            hVar.h(58, C0150a.f13010o);
            hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
            hVar.l(fVar3);
        }
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.h(25, 0);
        hVar.k(Integer.valueOf(c0150a.f(eVar.f13293a)));
        String str = f12997n0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "getBeanContext", "(I)" + com.alibaba.fastjson.util.b.b(p.class));
        hVar.h(25, 2);
        hVar.h(25, C0150a.f13008m);
        if (cls == Byte.TYPE) {
            hVar.h(21, c0150a.g("byte"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == Short.TYPE) {
            hVar.h(21, c0150a.g("short"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == Integer.TYPE) {
            hVar.h(21, c0150a.g("int"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == Character.TYPE) {
            hVar.h(21, c0150a.g("char"));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == Long.TYPE) {
            hVar.h(22, c0150a.h("long", 2));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == Float.TYPE) {
            hVar.h(23, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3028c));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == Double.TYPE) {
            hVar.h(24, c0150a.h("double", 2));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == Boolean.TYPE) {
            hVar.h(21, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3031f));
            hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");
            hVar.f(89);
            hVar.h(58, C0150a.f13009n);
        } else if (cls == BigDecimal.class) {
            hVar.h(25, c0150a.g("decimal"));
            hVar.h(58, C0150a.f13009n);
            hVar.h(25, C0150a.f13009n);
        } else if (cls == String.class) {
            hVar.h(25, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
            hVar.h(58, C0150a.f13009n);
            hVar.h(25, C0150a.f13009n);
        } else if (cls.isEnum()) {
            hVar.h(25, c0150a.g("enum"));
            hVar.h(58, C0150a.f13009n);
            hVar.h(25, C0150a.f13009n);
        } else if (List.class.isAssignableFrom(cls)) {
            hVar.h(25, c0150a.g("list"));
            hVar.h(58, C0150a.f13009n);
            hVar.h(25, C0150a.f13009n);
        } else {
            hVar.h(25, c0150a.g("object"));
            hVar.h(58, C0150a.f13009n);
            hVar.h(25, C0150a.f13009n);
        }
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "processValue", "(L" + f12992i0 + com.alipay.sdk.util.j.f13806b + com.alibaba.fastjson.util.b.b(p.class) + "Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.h(58, C0150a.f13010o);
        hVar.h(25, C0150a.f13009n);
        hVar.h(25, C0150a.f13010o);
        hVar.b(165, fVar2);
        y(hVar, eVar, c0150a, fVar);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar);
        hVar.l(fVar2);
    }

    private void v(com.alibaba.fastjson.asm.h hVar, C0150a c0150a) {
        hVar.h(16, 44);
        hVar.h(54, c0150a.g("seperator"));
    }

    private void w(Class<?> cls, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        if (eVar.f13293a.equals(c0150a.f13013c.f13048c)) {
            hVar.h(25, 1);
            hVar.h(25, 4);
            hVar.h(25, 2);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "isWriteClassName", "(Ljava/lang/reflect/Type;Ljava/lang/Object;)Z");
            hVar.b(154, fVar);
        }
        q(hVar, eVar, c0150a, fVar);
        i(hVar, c0150a, eVar);
        hVar.h(58, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
        g(hVar, eVar, c0150a, fVar);
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        hVar.h(25, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar2);
        l(hVar, eVar, c0150a);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar3);
        hVar.l(fVar2);
        if ("trim".equals(eVar.f13312t)) {
            hVar.h(25, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
            hVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/String", "trim", "()Ljava/lang/String;");
            hVar.h(58, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
        }
        if (c0150a.f13014d) {
            hVar.h(25, c0150a.g("out"));
            hVar.h(21, c0150a.g("seperator"));
            hVar.h(25, C0150a.f13008m);
            hVar.h(25, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValueStringWithDoubleQuoteCheck", "(CLjava/lang/String;Ljava/lang/String;)V");
        } else {
            hVar.h(25, c0150a.g("out"));
            hVar.h(21, c0150a.g("seperator"));
            hVar.h(25, C0150a.f13008m);
            hVar.h(25, c0150a.g(androidx.constraintlayout.core.motion.utils.w.b.f3030e));
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldValue", "(CLjava/lang/String;Ljava/lang/String;)V");
        }
        v(hVar, c0150a);
        hVar.l(fVar3);
        hVar.l(fVar);
    }

    private void x(com.alibaba.fastjson.asm.h hVar, C0150a c0150a) {
        if (c0150a.f13014d) {
            hVar.h(25, c0150a.g("out"));
            hVar.h(25, C0150a.f13008m);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldNameDirect", "(Ljava/lang/String;)V");
        } else {
            hVar.h(25, c0150a.g("out"));
            hVar.h(25, C0150a.f13008m);
            hVar.f(3);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "writeFieldName", "(Ljava/lang/String;Z)V");
        }
    }

    private void y(com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, C0150a c0150a, com.alibaba.fastjson.asm.f fVar) {
        com.alibaba.fastjson.asm.f fVar2;
        com.alibaba.fastjson.asm.f fVar3;
        String str;
        String strI = eVar.i();
        Class<?> cls = eVar.f13297e;
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        if (c0150a.f13014d) {
            hVar.h(25, c0150a.g("object"));
        } else {
            hVar.h(25, C0150a.f13010o);
        }
        hVar.f(89);
        hVar.h(58, c0150a.g("object"));
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar4);
        l(hVar, eVar, c0150a);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar);
        hVar.l(fVar4);
        hVar.h(25, c0150a.g("out"));
        hVar.h(21, c0150a.g("seperator"));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12995l0, "write", "(I)V");
        x(hVar, c0150a);
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
        if (!Modifier.isPublic(cls.getModifiers()) || com.alibaba.fastjson.parser.j.w(cls)) {
            fVar2 = fVar5;
            fVar3 = fVar6;
        } else {
            hVar.h(25, c0150a.g("object"));
            hVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/Object", "getClass", "()Ljava/lang/Class;");
            hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls)));
            hVar.b(com.alibaba.fastjson.asm.j.O, fVar6);
            j(c0150a, hVar, eVar);
            hVar.h(58, c0150a.g("fied_ser"));
            com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
            com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
            hVar.h(25, c0150a.g("fied_ser"));
            String str2 = f12997n0;
            hVar.c(com.alibaba.fastjson.asm.j.f12608d0, str2);
            hVar.b(153, fVar7);
            int i7 = eVar.f13301i;
            boolean z7 = (k1.DisableCircularReferenceDetect.f13132a & i7) != 0;
            boolean z8 = (k1.BeanToArray.f13132a & i7) != 0;
            if (z7 || (c0150a.f13017g && c0150a.f13014d)) {
                str = z8 ? "writeAsArrayNonContext" : "writeDirectNonContext";
            } else {
                str = z8 ? "writeAsArray" : "write";
            }
            hVar.h(25, c0150a.g("fied_ser"));
            hVar.c(com.alibaba.fastjson.asm.j.f12606c0, str2);
            hVar.h(25, 1);
            hVar.h(25, c0150a.g("object"));
            hVar.h(25, C0150a.f13008m);
            hVar.h(25, 0);
            hVar.d(180, c0150a.f13012b, eVar.f13293a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.k(Integer.valueOf(eVar.f13301i));
            StringBuilder sb = new StringBuilder();
            sb.append("(L");
            String str3 = f12992i0;
            sb.append(str3);
            sb.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.i(com.alibaba.fastjson.asm.j.W, str2, str, sb.toString());
            hVar.b(com.alibaba.fastjson.asm.j.P, fVar8);
            hVar.l(fVar7);
            hVar.h(25, c0150a.g("fied_ser"));
            hVar.h(25, 1);
            hVar.h(25, c0150a.g("object"));
            hVar.h(25, C0150a.f13008m);
            hVar.h(25, 0);
            hVar.d(180, c0150a.f13012b, eVar.f13293a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            hVar.k(Integer.valueOf(eVar.f13301i));
            hVar.i(com.alibaba.fastjson.asm.j.Z, f12993j0, "write", "(L" + str3 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            hVar.l(fVar8);
            fVar2 = fVar5;
            hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
            fVar3 = fVar6;
        }
        hVar.l(fVar3);
        hVar.h(25, 1);
        if (c0150a.f13014d) {
            hVar.h(25, c0150a.g("object"));
        } else {
            hVar.h(25, C0150a.f13010o);
        }
        if (strI != 0) {
            hVar.k(strI);
            hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFormat", "(Ljava/lang/Object;Ljava/lang/String;)V");
        } else {
            hVar.h(25, C0150a.f13008m);
            Type type = eVar.f13298f;
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            } else {
                if (eVar.f13297e == String.class) {
                    hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(String.class)));
                } else {
                    hVar.h(25, 0);
                    hVar.d(180, c0150a.f13012b, eVar.f13293a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
                }
                hVar.k(Integer.valueOf(eVar.f13301i));
                hVar.i(com.alibaba.fastjson.asm.j.W, f12992i0, "writeWithFieldName", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            }
        }
        hVar.l(fVar2);
        v(hVar, c0150a);
    }

    public p0 z(f1 f1Var) throws Exception {
        String str;
        String str2;
        boolean z7;
        Class<f1> cls;
        com.alibaba.fastjson.util.e[] eVarArr;
        int i7;
        String str3;
        boolean z8;
        boolean z9;
        String str4;
        boolean z10;
        boolean z11;
        String str5;
        int i8;
        char c8;
        Method method;
        Class<?> cls2 = f1Var.f13046a;
        if (cls2.isPrimitive()) {
            throw new com.alibaba.fastjson.d("unsupportd class " + cls2.getName());
        }
        e0.d dVar = (e0.d) com.alibaba.fastjson.util.l.M(cls2, e0.d.class);
        com.alibaba.fastjson.util.e[] eVarArr2 = f1Var.f13050e;
        for (com.alibaba.fastjson.util.e eVar : eVarArr2) {
            if (eVar.f13295c == null && (method = eVar.f13294b) != null && method.getDeclaringClass().isInterface()) {
                return new p0(f1Var);
            }
        }
        com.alibaba.fastjson.util.e[] eVarArr3 = f1Var.f13051f;
        boolean z12 = eVarArr3 == f1Var.f13050e;
        if (eVarArr3.length > 256) {
            return new p0(f1Var);
        }
        for (com.alibaba.fastjson.util.e eVar2 : eVarArr3) {
            if (!com.alibaba.fastjson.util.b.a(eVar2.k().getName())) {
                return new p0(f1Var);
            }
        }
        String str6 = "ASMSerializer_" + this.f13002h0.incrementAndGet() + "_" + cls2.getSimpleName();
        Package r7 = a.class.getPackage();
        if (r7 != null) {
            String name = r7.getName();
            String str7 = name.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + "/" + str6;
            str = name + com.alibaba.android.arouter.utils.b.f12515h + str6;
            str2 = str7;
        } else {
            str = str6;
            str2 = str;
        }
        a.class.getPackage().getName();
        com.alibaba.fastjson.asm.c cVar = new com.alibaba.fastjson.asm.c();
        cVar.k(49, 33, str2, f12997n0, new String[]{f12993j0});
        int i9 = 0;
        for (int length = eVarArr3.length; i9 < length; length = length) {
            com.alibaba.fastjson.util.e eVar3 = eVarArr3[i9];
            if (!eVar3.f13297e.isPrimitive() && eVar3.f13297e != String.class) {
                new com.alibaba.fastjson.asm.d(cVar, 1, eVar3.f13293a + "_asm_fieldType", "Ljava/lang/reflect/Type;").c();
                if (List.class.isAssignableFrom(eVar3.f13297e)) {
                    new com.alibaba.fastjson.asm.d(cVar, 1, eVar3.f13293a + "_asm_list_item_ser_", f12994k0).c();
                }
                new com.alibaba.fastjson.asm.d(cVar, 1, eVar3.f13293a + "_asm_ser_", f12994k0).c();
            }
            i9++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<f1> cls3 = f1.class;
        sb.append(com.alibaba.fastjson.util.b.b(cls3));
        sb.append(")V");
        com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar, 1, "<init>", sb.toString(), null, null);
        iVar.h(25, 0);
        iVar.h(25, 1);
        iVar.i(com.alibaba.fastjson.asm.j.X, f12997n0, "<init>", "(" + com.alibaba.fastjson.util.b.b(cls3) + ")V");
        int i10 = 0;
        while (i10 < eVarArr3.length) {
            com.alibaba.fastjson.util.e eVar4 = eVarArr3[i10];
            if (eVar4.f13297e.isPrimitive() || eVar4.f13297e == String.class) {
                cVar = cVar;
                str = str;
            } else {
                iVar.h(25, 0);
                if (eVar4.f13294b != null) {
                    iVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(eVar4.f13299g)));
                    iVar.k(eVar4.f13294b.getName());
                    iVar.i(com.alibaba.fastjson.asm.j.Y, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.util.b.class), "getMethodType", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Type;");
                } else {
                    iVar.h(25, 0);
                    iVar.k(Integer.valueOf(i10));
                    iVar.i(com.alibaba.fastjson.asm.j.X, f12997n0, "getFieldType", "(I)Ljava/lang/reflect/Type;");
                }
                iVar.d(com.alibaba.fastjson.asm.j.V, str2, eVar4.f13293a + "_asm_fieldType", "Ljava/lang/reflect/Type;");
            }
            i10++;
            cVar = cVar;
            str = str;
        }
        com.alibaba.fastjson.asm.c cVar2 = cVar;
        String str8 = str;
        iVar.f(com.alibaba.fastjson.asm.j.S);
        char c9 = 4;
        iVar.g(4, 4);
        iVar.j();
        if (dVar == null) {
            z7 = false;
            break;
        }
        k1[] k1VarArrSerialzeFeatures = dVar.serialzeFeatures();
        int length2 = k1VarArrSerialzeFeatures.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length2) {
                z7 = false;
                break;
            }
            if (k1VarArrSerialzeFeatures[i11] == k1.DisableCircularReferenceDetect) {
                z7 = true;
                break;
            }
            i11++;
        }
        int i12 = 0;
        while (true) {
            cls = cls3;
            eVarArr = eVarArr2;
            if (i12 >= 3) {
                break;
            }
            if (i12 == 0) {
                str4 = "write";
                z11 = z7;
                z10 = true;
            } else if (i12 == 1) {
                str4 = "writeNormal";
                z11 = z7;
                z10 = false;
            } else {
                str4 = "writeDirectNonContext";
                z10 = true;
                z11 = true;
            }
            com.alibaba.fastjson.asm.c cVar3 = cVar2;
            int i13 = i12;
            String str9 = str8;
            String str10 = str2;
            C0150a c0150a = new C0150a(eVarArr3, f1Var, str2, z10, z11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(L");
            String str11 = f12992i0;
            sb2.append(str11);
            sb2.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            com.alibaba.fastjson.asm.i iVar2 = new com.alibaba.fastjson.asm.i(cVar2, 1, str4, sb2.toString(), null, new String[]{"java/io/IOException"});
            com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
            iVar2.h(25, 2);
            iVar2.b(com.alibaba.fastjson.asm.j.f12612f0, fVar);
            iVar2.h(25, 1);
            iVar2.i(com.alibaba.fastjson.asm.j.W, str11, "writeNull", "()V");
            iVar2.f(com.alibaba.fastjson.asm.j.S);
            iVar2.l(fVar);
            iVar2.h(25, 1);
            iVar2.d(180, str11, "out", f12996m0);
            iVar2.h(58, c0150a.g("out"));
            if (z12 || c0150a.f13014d || !(dVar == null || dVar.alphabetic())) {
                str5 = str10;
            } else {
                com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
                iVar2.h(25, c0150a.g("out"));
                iVar2.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isSortField", "()Z");
                iVar2.b(154, fVar2);
                iVar2.h(25, 0);
                iVar2.h(25, 1);
                iVar2.h(25, 2);
                iVar2.h(25, 3);
                iVar2.h(25, 4);
                iVar2.h(21, 5);
                str5 = str10;
                iVar2.i(com.alibaba.fastjson.asm.j.W, str5, "writeUnsorted", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.f(com.alibaba.fastjson.asm.j.S);
                iVar2.l(fVar2);
            }
            if (!c0150a.f13014d || z11) {
                i8 = com.alibaba.fastjson.asm.j.S;
                c8 = 4;
            } else {
                com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
                com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
                iVar2.h(25, 0);
                iVar2.h(25, 1);
                iVar2.i(com.alibaba.fastjson.asm.j.W, f12997n0, "writeDirect", "(L" + str11 + ";)Z");
                iVar2.b(154, fVar4);
                iVar2.h(25, 0);
                iVar2.h(25, 1);
                iVar2.h(25, 2);
                iVar2.h(25, 3);
                iVar2.h(25, 4);
                iVar2.h(21, 5);
                iVar2.i(com.alibaba.fastjson.asm.j.W, str5, "writeNormal", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                iVar2.f(com.alibaba.fastjson.asm.j.S);
                iVar2.l(fVar4);
                iVar2.h(25, c0150a.g("out"));
                iVar2.k(Integer.valueOf(k1.DisableCircularReferenceDetect.f13132a));
                iVar2.i(com.alibaba.fastjson.asm.j.W, f12995l0, "isEnabled", "(I)Z");
                iVar2.b(153, fVar3);
                iVar2.h(25, 0);
                iVar2.h(25, 1);
                iVar2.h(25, 2);
                iVar2.h(25, 3);
                c8 = 4;
                iVar2.h(25, 4);
                iVar2.h(21, 5);
                iVar2.i(com.alibaba.fastjson.asm.j.W, str5, "writeDirectNonContext", "(L" + str11 + ";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
                i8 = com.alibaba.fastjson.asm.j.S;
                iVar2.f(com.alibaba.fastjson.asm.j.S);
                iVar2.l(fVar3);
            }
            iVar2.h(25, 2);
            iVar2.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls2));
            iVar2.h(58, c0150a.g("entity"));
            B(cls2, iVar2, eVarArr3, c0150a);
            iVar2.f(i8);
            iVar2.g(7, c0150a.f13016f + 2);
            iVar2.j();
            str2 = str5;
            dVar = dVar;
            z12 = z12;
            cls3 = cls;
            eVarArr2 = eVarArr;
            cVar2 = cVar3;
            str8 = str9;
            c9 = c8;
            i12 = i13 + 1;
        }
        String str12 = str2;
        com.alibaba.fastjson.asm.c cVar4 = cVar2;
        String str13 = str8;
        if (z12) {
            i7 = 180;
        } else {
            C0150a c0150a2 = new C0150a(eVarArr3, f1Var, str12, false, z7);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("(L");
            String str14 = f12992i0;
            sb3.append(str14);
            sb3.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            i7 = 180;
            com.alibaba.fastjson.asm.i iVar3 = new com.alibaba.fastjson.asm.i(cVar4, 1, "writeUnsorted", sb3.toString(), null, new String[]{"java/io/IOException"});
            iVar3.h(25, 1);
            iVar3.d(180, str14, "out", f12996m0);
            iVar3.h(58, c0150a2.g("out"));
            iVar3.h(25, 2);
            iVar3.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls2));
            iVar3.h(58, c0150a2.g("entity"));
            B(cls2, iVar3, eVarArr, c0150a2);
            iVar3.f(com.alibaba.fastjson.asm.j.S);
            iVar3.g(7, c0150a2.f13016f + 2);
            iVar3.j();
        }
        int i14 = 0;
        int i15 = 3;
        while (i14 < i15) {
            if (i14 == 0) {
                str3 = "writeAsArray";
                z9 = z7;
                z8 = true;
            } else if (i14 == 1) {
                str3 = "writeAsArrayNormal";
                z9 = z7;
                z8 = false;
            } else {
                str3 = "writeAsArrayNonContext";
                z8 = true;
                z9 = true;
            }
            int i16 = i14;
            int i17 = i7;
            C0150a c0150a3 = new C0150a(eVarArr3, f1Var, str12, z8, z9);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("(L");
            String str15 = f12992i0;
            sb4.append(str15);
            sb4.append(";Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/reflect/Type;I)V");
            com.alibaba.fastjson.asm.i iVar4 = new com.alibaba.fastjson.asm.i(cVar4, 1, str3, sb4.toString(), null, new String[]{"java/io/IOException"});
            iVar4.h(25, 1);
            iVar4.d(i17, str15, "out", f12996m0);
            iVar4.h(58, c0150a3.g("out"));
            iVar4.h(25, 2);
            iVar4.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls2));
            iVar4.h(58, c0150a3.g("entity"));
            A(cls2, iVar4, eVarArr3, c0150a3);
            iVar4.f(com.alibaba.fastjson.asm.j.S);
            iVar4.g(7, c0150a3.f13016f + 2);
            iVar4.j();
            i7 = i17;
            i15 = 3;
            i14 = i16 + 1;
        }
        byte[] bArrJ = cVar4.j();
        return (p0) this.f13001g0.a(str13, bArrJ, 0, bArrJ.length).getConstructor(cls).newInstance(f1Var);
    }
}
