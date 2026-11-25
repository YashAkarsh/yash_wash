package com.alibaba.fastjson.parser.deserializer;

import easypay.appinvoke.manager.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.fastjson.asm.j {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    static final String f12839i0 = com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.parser.b.class);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    static final String f12840j0 = com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.parser.e.class);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final com.alibaba.fastjson.util.a f12841g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    protected final AtomicLong f12842h0 = new AtomicLong();

    /* JADX INFO: renamed from: com.alibaba.fastjson.parser.deserializer.a$a, reason: collision with other inner class name */
    static class C0149a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final int f12843g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        static final int f12844h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f12845i = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f12846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, Integer> f12847b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f12848c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.alibaba.fastjson.util.h f12849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f12850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private com.alibaba.fastjson.util.e[] f12851f;

        public C0149a(String str, com.alibaba.fastjson.parser.j jVar, com.alibaba.fastjson.util.h hVar, int i7) {
            this.f12846a = -1;
            this.f12850e = str;
            this.f12848c = hVar.f13341a;
            this.f12846a = i7;
            this.f12849d = hVar;
            this.f12851f = hVar.f13348h;
        }

        public Class<?> g() {
            Class<?> cls = this.f12849d.f13342b;
            return cls == null ? this.f12848c : cls;
        }

        public int h(String str) {
            if (this.f12847b.get(str) == null) {
                Map<String, Integer> map = this.f12847b;
                int i7 = this.f12846a;
                this.f12846a = i7 + 1;
                map.put(str, Integer.valueOf(i7));
            }
            return this.f12847b.get(str).intValue();
        }

        public int i(String str, int i7) {
            if (this.f12847b.get(str) == null) {
                this.f12847b.put(str, Integer.valueOf(this.f12846a));
                this.f12846a += i7;
            }
            return this.f12847b.get(str).intValue();
        }
    }

    public a(ClassLoader classLoader) {
        this.f12841g0 = classLoader instanceof com.alibaba.fastjson.util.a ? (com.alibaba.fastjson.util.a) classLoader : new com.alibaba.fastjson.util.a(classLoader);
    }

    private void a(C0149a c0149a, com.alibaba.fastjson.asm.h hVar) {
        b(c0149a, hVar, true);
    }

    private void b(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, boolean z7) {
        int length = c0149a.f12851f.length;
        for (int i7 = 0; i7 < length; i7++) {
            com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
            if (z7) {
                n(hVar, c0149a, i7, fVar);
            }
            o(c0149a, hVar, c0149a.f12851f[i7]);
            if (z7) {
                hVar.l(fVar);
            }
        }
    }

    private void c(com.alibaba.fastjson.asm.c cVar, C0149a c0149a) {
        if (Modifier.isPublic(c0149a.f12849d.f13343c.getModifiers())) {
            com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar, 1, "createInstance", "(L" + f12839i0 + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;", null, null);
            iVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(c0149a.g()));
            iVar.f(89);
            iVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(c0149a.g()), "<init>", "()V");
            iVar.f(com.alibaba.fastjson.asm.j.R);
            iVar.g(3, 3);
            iVar.j();
        }
    }

    private void d(C0149a c0149a, com.alibaba.fastjson.asm.h hVar) {
        Constructor<?> constructor = c0149a.f12849d.f13343c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            hVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(c0149a.g()));
            hVar.f(89);
            hVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(constructor.getDeclaringClass()), "<init>", "()V");
            hVar.h(58, c0149a.h("instance"));
            return;
        }
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.h(25, 0);
        hVar.d(180, com.alibaba.fastjson.util.b.h(n.class), "clazz", "Ljava/lang/Class;");
        hVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(n.class), "createInstance", "(L" + f12839i0 + ";Ljava/lang/reflect/Type;)Ljava/lang/Object;");
        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(c0149a.g()));
        hVar.h(58, c0149a.h("instance"));
    }

    private void e(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, Class<?> cls, int i7) {
        l(c0149a, hVar, eVar);
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        if ((eVar.f13302j & com.alibaba.fastjson.parser.c.SupportArrayToBean.f12829a) != 0) {
            hVar.f(89);
            hVar.c(com.alibaba.fastjson.asm.j.f12608d0, com.alibaba.fastjson.util.b.h(n.class));
            hVar.b(153, fVar);
            hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(n.class));
            hVar.h(25, 1);
            if (eVar.f13298f instanceof Class) {
                hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(eVar.f13297e)));
            } else {
                hVar.h(25, 0);
                hVar.k(Integer.valueOf(i7));
                hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            hVar.k(eVar.f13293a);
            hVar.k(Integer.valueOf(eVar.f13302j));
            hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "deserialze", "(L" + f12839i0 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
            hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls));
            hVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
            hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
            hVar.l(fVar);
        }
        hVar.h(25, 1);
        if (eVar.f13298f instanceof Class) {
            hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(eVar.f13297e)));
        } else {
            hVar.h(25, 0);
            hVar.k(Integer.valueOf(i7));
            hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        hVar.k(eVar.f13293a);
        hVar.i(com.alibaba.fastjson.asm.j.Z, com.alibaba.fastjson.util.b.h(e1.class), "deserialze", "(L" + f12839i0 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls));
        hVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
        hVar.l(fVar2);
    }

    private void f(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.asm.f fVar) {
        hVar.e(21, c0149a.h("matchedCount"));
        hVar.b(158, fVar);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, com.paytm.pgsdk.d.R, "()I");
        hVar.k(13);
        hVar.b(160, fVar);
        r(c0149a, hVar);
    }

    /* JADX WARN: Code duplicated, block: B:135:0x0e17  */
    /* JADX WARN: Code duplicated, block: B:136:0x0e3a  */
    private void g(com.alibaba.fastjson.asm.c cVar, C0149a c0149a) {
        String str;
        int i7;
        com.alibaba.fastjson.asm.f fVar;
        int i8;
        a aVar;
        com.alibaba.fastjson.asm.i iVar;
        com.alibaba.fastjson.asm.f fVar2;
        com.alibaba.fastjson.asm.f fVar3;
        int i9;
        char c8;
        String str2;
        com.alibaba.fastjson.asm.f fVar4;
        a aVar2 = this;
        if (c0149a.f12851f.length == 0) {
            return;
        }
        for (com.alibaba.fastjson.util.e eVar : c0149a.f12851f) {
            Class<?> cls = eVar.f13297e;
            Type type = eVar.f13298f;
            if (cls == Character.TYPE) {
                return;
            }
            if (Collection.class.isAssignableFrom(cls) && (!(type instanceof ParameterizedType) || !(((ParameterizedType) type).getActualTypeArguments()[0] instanceof Class))) {
                return;
            }
        }
        com.alibaba.fastjson.util.h hVar = c0149a.f12849d;
        c0149a.f12851f = hVar.f13349i;
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str3 = f12839i0;
        sb.append(str3);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
        com.alibaba.fastjson.asm.i iVar2 = new com.alibaba.fastjson.asm.i(cVar, 1, "deserialze", sb.toString(), null, null);
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
        aVar2.w(c0149a, iVar2);
        com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
        iVar2.h(25, c0149a.h("lexer"));
        String str4 = f12840j0;
        iVar2.i(com.alibaba.fastjson.asm.j.W, str4, com.paytm.pgsdk.d.R, "()I");
        iVar2.k(14);
        iVar2.b(160, fVar9);
        int i10 = hVar.f13350j;
        com.alibaba.fastjson.parser.c cVar2 = com.alibaba.fastjson.parser.c.SupportArrayToBean;
        if ((i10 & cVar2.f12829a) == 0) {
            iVar2.h(25, c0149a.h("lexer"));
            iVar2.h(21, 4);
            iVar2.k(Integer.valueOf(cVar2.f12829a));
            iVar2.i(com.alibaba.fastjson.asm.j.W, str4, "isEnabled", "(II)Z");
            iVar2.b(153, fVar9);
        }
        iVar2.h(25, 0);
        iVar2.h(25, 1);
        iVar2.h(25, 2);
        iVar2.h(25, 3);
        iVar2.f(1);
        iVar2.i(com.alibaba.fastjson.asm.j.X, c0149a.f12850e, "deserialzeArrayMapping", "(L" + str3 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
        iVar2.f(com.alibaba.fastjson.asm.j.R);
        iVar2.l(fVar9);
        iVar2.h(25, c0149a.h("lexer"));
        iVar2.k(Integer.valueOf(com.alibaba.fastjson.parser.c.SortFeidFastMatch.f12829a));
        iVar2.i(com.alibaba.fastjson.asm.j.W, str4, "isEnabled", "(I)Z");
        iVar2.b(153, fVar6);
        iVar2.h(25, c0149a.h("lexer"));
        iVar2.k(c0149a.f12848c.getName());
        iVar2.i(com.alibaba.fastjson.asm.j.W, str4, "scanType", "(Ljava/lang/String;)I");
        iVar2.k(-1);
        iVar2.b(159, fVar6);
        iVar2.h(25, 1);
        iVar2.i(com.alibaba.fastjson.asm.j.W, str3, "getContext", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class));
        iVar2.h(58, c0149a.h("mark_context"));
        iVar2.f(3);
        iVar2.h(54, c0149a.h("matchedCount"));
        aVar2.d(c0149a, iVar2);
        iVar2.h(25, 1);
        iVar2.i(com.alibaba.fastjson.asm.j.W, str3, "getContext", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class));
        iVar2.h(58, c0149a.h("context"));
        iVar2.h(25, 1);
        iVar2.h(25, c0149a.h("context"));
        iVar2.h(25, c0149a.h("instance"));
        iVar2.h(25, 3);
        iVar2.i(com.alibaba.fastjson.asm.j.W, str3, "setContext", "(" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class));
        iVar2.h(58, c0149a.h("childContext"));
        iVar2.h(25, c0149a.h("lexer"));
        String str5 = "matchStat";
        String str6 = "I";
        iVar2.d(180, str4, "matchStat", "I");
        iVar2.k(4);
        iVar2.b(159, fVar7);
        int i11 = 3;
        iVar2.f(3);
        iVar2.e(54, c0149a.h("matchStat"));
        int length = c0149a.f12851f.length;
        int i12 = 0;
        while (i12 < length) {
            iVar2.f(i11);
            iVar2.h(54, c0149a.h("_asm_flag_" + (i12 / 32)));
            i12 += 32;
            i11 = 3;
        }
        iVar2.h(25, c0149a.h("lexer"));
        iVar2.k(Integer.valueOf(com.alibaba.fastjson.parser.c.InitStringFieldAsEmpty.f12829a));
        iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "isEnabled", "(I)Z");
        iVar2.e(54, c0149a.h("initStringFieldAsEmpty"));
        int i13 = 0;
        while (true) {
            str = "_asm";
            if (i13 >= length) {
                break;
            }
            com.alibaba.fastjson.util.e eVar2 = c0149a.f12851f[i13];
            Class<?> cls2 = eVar2.f13297e;
            if (cls2 == Boolean.TYPE || cls2 == Byte.TYPE || cls2 == Short.TYPE || cls2 == Integer.TYPE) {
                fVar5 = fVar5;
                fVar6 = fVar6;
                fVar7 = fVar7;
                fVar8 = fVar8;
                iVar2.f(3);
                iVar2.h(54, c0149a.h(eVar2.f13293a + "_asm"));
            } else {
                if (cls2 == Long.TYPE) {
                    iVar2.f(9);
                    iVar2.h(55, c0149a.i(eVar2.f13293a + "_asm", 2));
                } else if (cls2 == Float.TYPE) {
                    iVar2.f(11);
                    iVar2.h(56, c0149a.h(eVar2.f13293a + "_asm"));
                } else if (cls2 == Double.TYPE) {
                    iVar2.f(14);
                    iVar2.h(57, c0149a.i(eVar2.f13293a + "_asm", 2));
                } else {
                    if (cls2 == String.class) {
                        com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
                        iVar2.h(21, c0149a.h("initStringFieldAsEmpty"));
                        iVar2.b(153, fVar11);
                        aVar2.u(iVar2, c0149a, i13);
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "stringDefaultValue", "()Ljava/lang/String;");
                        iVar2.b(com.alibaba.fastjson.asm.j.P, fVar10);
                        iVar2.l(fVar11);
                        iVar2.f(1);
                        iVar2.l(fVar10);
                    } else {
                        iVar2.f(1);
                    }
                    iVar2.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls2));
                    iVar2.h(58, c0149a.h(eVar2.f13293a + "_asm"));
                }
                fVar5 = fVar5;
                fVar6 = fVar6;
                fVar7 = fVar7;
                fVar8 = fVar8;
            }
            i13++;
            aVar2 = this;
            fVar6 = fVar6;
            fVar7 = fVar7;
            fVar8 = fVar8;
            fVar5 = fVar5;
        }
        com.alibaba.fastjson.asm.f fVar12 = fVar5;
        com.alibaba.fastjson.asm.f fVar13 = fVar6;
        com.alibaba.fastjson.asm.f fVar14 = fVar7;
        com.alibaba.fastjson.asm.f fVar15 = fVar8;
        int i14 = 0;
        while (i14 < length) {
            com.alibaba.fastjson.util.e eVar3 = c0149a.f12851f[i14];
            Class<?> cls3 = eVar3.f13297e;
            Type type2 = eVar3.f13298f;
            com.alibaba.fastjson.asm.f fVar16 = new com.alibaba.fastjson.asm.f();
            if (cls3 == Boolean.TYPE) {
                iVar2.h(25, c0149a.h("lexer"));
                iVar2.h(25, 0);
                iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldBoolean", "([C)Z");
                iVar2.h(54, c0149a.h(eVar3.f13293a + str));
                i7 = length;
            } else {
                i7 = length;
                if (cls3 == Byte.TYPE) {
                    iVar2.h(25, c0149a.h("lexer"));
                    iVar2.h(25, 0);
                    iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                    iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldInt", "([C)I");
                    iVar2.h(54, c0149a.h(eVar3.f13293a + str));
                } else {
                    fVar = fVar16;
                    i8 = i14;
                    if (cls3 == Byte.class) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        String str7 = f12840j0;
                        iVar2.i(com.alibaba.fastjson.asm.j.W, str7, "scanFieldInt", "([C)I");
                        iVar2.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        com.alibaba.fastjson.asm.f fVar17 = new com.alibaba.fastjson.asm.f();
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str7, str5, str6);
                        iVar2.k(5);
                        iVar2.b(160, fVar17);
                        iVar2.f(1);
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        iVar2.l(fVar17);
                    } else if (cls3 == Short.TYPE) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldInt", "([C)I");
                        iVar2.h(54, c0149a.h(eVar3.f13293a + str));
                    } else if (cls3 == Short.class) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        String str8 = f12840j0;
                        iVar2.i(com.alibaba.fastjson.asm.j.W, str8, "scanFieldInt", "([C)I");
                        iVar2.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        com.alibaba.fastjson.asm.f fVar18 = new com.alibaba.fastjson.asm.f();
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str8, str5, str6);
                        iVar2.k(5);
                        iVar2.b(160, fVar18);
                        iVar2.f(1);
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        iVar2.l(fVar18);
                    } else if (cls3 == Integer.TYPE) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldInt", "([C)I");
                        iVar2.h(54, c0149a.h(eVar3.f13293a + str));
                    } else if (cls3 == Integer.class) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        String str9 = f12840j0;
                        iVar2.i(com.alibaba.fastjson.asm.j.W, str9, "scanFieldInt", "([C)I");
                        iVar2.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        com.alibaba.fastjson.asm.f fVar19 = new com.alibaba.fastjson.asm.f();
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str9, str5, str6);
                        iVar2.k(5);
                        iVar2.b(160, fVar19);
                        iVar2.f(1);
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        iVar2.l(fVar19);
                    } else if (cls3 == Long.TYPE) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldLong", "([C)J");
                        iVar2.h(55, c0149a.i(eVar3.f13293a + str, 2));
                    } else if (cls3 == Long.class) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        String str10 = f12840j0;
                        iVar2.i(com.alibaba.fastjson.asm.j.W, str10, "scanFieldLong", "([C)J");
                        iVar2.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        com.alibaba.fastjson.asm.f fVar20 = new com.alibaba.fastjson.asm.f();
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str10, str5, str6);
                        iVar2.k(5);
                        iVar2.b(160, fVar20);
                        iVar2.f(1);
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        iVar2.l(fVar20);
                    } else if (cls3 == Float.TYPE) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldFloat", "([C)F");
                        iVar2.h(56, c0149a.h(eVar3.f13293a + str));
                    } else if (cls3 == Float.class) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        String str11 = f12840j0;
                        iVar2.i(com.alibaba.fastjson.asm.j.W, str11, "scanFieldFloat", "([C)F");
                        iVar2.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        com.alibaba.fastjson.asm.f fVar21 = new com.alibaba.fastjson.asm.f();
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str11, str5, str6);
                        iVar2.k(5);
                        iVar2.b(160, fVar21);
                        iVar2.f(1);
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        iVar2.l(fVar21);
                    } else if (cls3 == Double.TYPE) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldDouble", "([C)D");
                        iVar2.h(57, c0149a.i(eVar3.f13293a + str, 2));
                    } else if (cls3 == Double.class) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.h(25, 0);
                        iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                        String str12 = f12840j0;
                        iVar2.i(com.alibaba.fastjson.asm.j.W, str12, "scanFieldDouble", "([C)D");
                        iVar2.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        com.alibaba.fastjson.asm.f fVar22 = new com.alibaba.fastjson.asm.f();
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str12, str5, str6);
                        iVar2.k(5);
                        iVar2.b(160, fVar22);
                        iVar2.f(1);
                        iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        iVar2.l(fVar22);
                        aVar = this;
                        iVar2.h(25, c0149a.h("lexer"));
                        str2 = f12840j0;
                        iVar2.d(180, str2, str5, str6);
                        com.alibaba.fastjson.asm.f fVar23 = new com.alibaba.fastjson.asm.f();
                        iVar2.b(158, fVar23);
                        i9 = i8;
                        aVar.u(iVar2, c0149a, i9);
                        iVar2.l(fVar23);
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str2, str5, str6);
                        iVar2.f(89);
                        iVar2.h(54, c0149a.h(str5));
                        iVar2.k(-1);
                        fVar4 = fVar12;
                        iVar2.b(159, fVar4);
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str2, str5, str6);
                        com.alibaba.fastjson.asm.f fVar24 = fVar;
                        iVar2.b(158, fVar24);
                        iVar2.h(21, c0149a.h("matchedCount"));
                        iVar2.f(4);
                        iVar2.f(96);
                        iVar2.h(54, c0149a.h("matchedCount"));
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str2, str5, str6);
                        iVar2.k(4);
                        fVar2 = fVar15;
                        iVar2.b(159, fVar2);
                        iVar2.l(fVar24);
                        if (i9 == i7 - 1) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.d(180, str2, str5, str6);
                            iVar2.k(4);
                            iVar2.b(160, fVar4);
                        }
                        iVar = iVar2;
                        fVar3 = fVar4;
                    } else {
                        if (cls3 == String.class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldString", "([C)Ljava/lang/String;");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3 == Date.class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldDate", "([C)Ljava/util/Date;");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3 == UUID.class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldUUID", "([C)Ljava/util/UUID;");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3 == BigDecimal.class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldDecimal", "([C)Ljava/math/BigDecimal;");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3 == BigInteger.class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldBigInteger", "([C)Ljava/math/BigInteger;");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3 == int[].class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldIntArray", "([C)[I");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3 == float[].class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldFloatArray", "([C)[F");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3 == float[][].class) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldFloatArray2", "([C)[[F");
                            c8 = ':';
                            iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                        } else if (cls3.isEnum()) {
                            iVar2.h(25, 0);
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.h(25, 0);
                            iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                            aVar = this;
                            aVar.l(c0149a, iVar2, eVar3);
                            iVar2.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "scanEnum", "(L" + f12840j0 + ";[C" + com.alibaba.fastjson.util.b.b(e1.class) + ")Ljava/lang/Enum;");
                            iVar2.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls3));
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(eVar3.f13293a);
                            sb2.append(str);
                            c8 = ':';
                            iVar2.h(58, c0149a.h(sb2.toString()));
                            iVar2.h(25, c0149a.h("lexer"));
                            str2 = f12840j0;
                            iVar2.d(180, str2, str5, str6);
                            com.alibaba.fastjson.asm.f fVar25 = new com.alibaba.fastjson.asm.f();
                            iVar2.b(158, fVar25);
                            i9 = i8;
                            aVar.u(iVar2, c0149a, i9);
                            iVar2.l(fVar25);
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.d(180, str2, str5, str6);
                            iVar2.f(89);
                            iVar2.h(54, c0149a.h(str5));
                            iVar2.k(-1);
                            fVar4 = fVar12;
                            iVar2.b(159, fVar4);
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.d(180, str2, str5, str6);
                            com.alibaba.fastjson.asm.f fVar26 = fVar;
                            iVar2.b(158, fVar26);
                            iVar2.h(21, c0149a.h("matchedCount"));
                            iVar2.f(4);
                            iVar2.f(96);
                            iVar2.h(54, c0149a.h("matchedCount"));
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.d(180, str2, str5, str6);
                            iVar2.k(4);
                            fVar2 = fVar15;
                            iVar2.b(159, fVar2);
                            iVar2.l(fVar26);
                            if (i9 == i7 - 1) {
                                iVar2.h(25, c0149a.h("lexer"));
                                iVar2.d(180, str2, str5, str6);
                                iVar2.k(4);
                                iVar2.b(160, fVar4);
                            }
                            iVar = iVar2;
                            fVar3 = fVar4;
                        } else {
                            aVar = this;
                            if (Collection.class.isAssignableFrom(cls3)) {
                                iVar2.h(25, c0149a.h("lexer"));
                                iVar2.h(25, 0);
                                iVar2.d(180, c0149a.f12850e, eVar3.f13293a + "_asm_prefix__", "[C");
                                Class<?> clsP = com.alibaba.fastjson.util.l.P(type2);
                                if (clsP == String.class) {
                                    iVar2.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls3)));
                                    iVar2.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFieldStringArray", "([CLjava/lang/Class;)" + com.alibaba.fastjson.util.b.b(Collection.class));
                                    iVar2.h(58, c0149a.h(eVar3.f13293a + str));
                                    iVar2.h(25, c0149a.h("lexer"));
                                    str2 = f12840j0;
                                    iVar2.d(180, str2, str5, str6);
                                    com.alibaba.fastjson.asm.f fVar27 = new com.alibaba.fastjson.asm.f();
                                    iVar2.b(158, fVar27);
                                    i9 = i8;
                                    aVar.u(iVar2, c0149a, i9);
                                    iVar2.l(fVar27);
                                    iVar2.h(25, c0149a.h("lexer"));
                                    iVar2.d(180, str2, str5, str6);
                                    iVar2.f(89);
                                    iVar2.h(54, c0149a.h(str5));
                                    iVar2.k(-1);
                                    fVar4 = fVar12;
                                    iVar2.b(159, fVar4);
                                    iVar2.h(25, c0149a.h("lexer"));
                                    iVar2.d(180, str2, str5, str6);
                                    com.alibaba.fastjson.asm.f fVar28 = fVar;
                                    iVar2.b(158, fVar28);
                                    iVar2.h(21, c0149a.h("matchedCount"));
                                    iVar2.f(4);
                                    iVar2.f(96);
                                    iVar2.h(54, c0149a.h("matchedCount"));
                                    iVar2.h(25, c0149a.h("lexer"));
                                    iVar2.d(180, str2, str5, str6);
                                    iVar2.k(4);
                                    fVar2 = fVar15;
                                    iVar2.b(159, fVar2);
                                    iVar2.l(fVar28);
                                    if (i9 == i7 - 1) {
                                        iVar2.h(25, c0149a.h("lexer"));
                                        iVar2.d(180, str2, str5, str6);
                                        iVar2.k(4);
                                        iVar2.b(160, fVar4);
                                    }
                                    iVar = iVar2;
                                    fVar3 = fVar4;
                                } else {
                                    fVar2 = fVar15;
                                    com.alibaba.fastjson.asm.f fVar29 = fVar12;
                                    i9 = i8;
                                    str6 = str6;
                                    str5 = str5;
                                    i7 = i7;
                                    fVar3 = fVar29;
                                    str = str;
                                    iVar = iVar2;
                                    i(c0149a, iVar2, fVar29, eVar3, cls3, clsP, i9);
                                    if (i9 == i7 - 1) {
                                        aVar.f(c0149a, iVar, fVar3);
                                    }
                                }
                            } else {
                                str6 = str6;
                                iVar = iVar2;
                                str = str;
                                fVar2 = fVar15;
                                fVar3 = fVar12;
                                i7 = i7;
                                i9 = i8;
                                str5 = str5;
                                j(c0149a, iVar, fVar3, eVar3, cls3, i9);
                                if (i9 == i7 - 1) {
                                    aVar.f(c0149a, iVar, fVar3);
                                }
                            }
                        }
                        aVar = this;
                        iVar2.h(25, c0149a.h("lexer"));
                        str2 = f12840j0;
                        iVar2.d(180, str2, str5, str6);
                        com.alibaba.fastjson.asm.f fVar210 = new com.alibaba.fastjson.asm.f();
                        iVar2.b(158, fVar210);
                        i9 = i8;
                        aVar.u(iVar2, c0149a, i9);
                        iVar2.l(fVar210);
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str2, str5, str6);
                        iVar2.f(89);
                        iVar2.h(54, c0149a.h(str5));
                        iVar2.k(-1);
                        fVar4 = fVar12;
                        iVar2.b(159, fVar4);
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str2, str5, str6);
                        com.alibaba.fastjson.asm.f fVar211 = fVar;
                        iVar2.b(158, fVar211);
                        iVar2.h(21, c0149a.h("matchedCount"));
                        iVar2.f(4);
                        iVar2.f(96);
                        iVar2.h(54, c0149a.h("matchedCount"));
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str2, str5, str6);
                        iVar2.k(4);
                        fVar2 = fVar15;
                        iVar2.b(159, fVar2);
                        iVar2.l(fVar211);
                        if (i9 == i7 - 1) {
                            iVar2.h(25, c0149a.h("lexer"));
                            iVar2.d(180, str2, str5, str6);
                            iVar2.k(4);
                            iVar2.b(160, fVar4);
                        }
                        iVar = iVar2;
                        fVar3 = fVar4;
                    }
                    aVar = this;
                    iVar2.h(25, c0149a.h("lexer"));
                    str2 = f12840j0;
                    iVar2.d(180, str2, str5, str6);
                    com.alibaba.fastjson.asm.f fVar212 = new com.alibaba.fastjson.asm.f();
                    iVar2.b(158, fVar212);
                    i9 = i8;
                    aVar.u(iVar2, c0149a, i9);
                    iVar2.l(fVar212);
                    iVar2.h(25, c0149a.h("lexer"));
                    iVar2.d(180, str2, str5, str6);
                    iVar2.f(89);
                    iVar2.h(54, c0149a.h(str5));
                    iVar2.k(-1);
                    fVar4 = fVar12;
                    iVar2.b(159, fVar4);
                    iVar2.h(25, c0149a.h("lexer"));
                    iVar2.d(180, str2, str5, str6);
                    com.alibaba.fastjson.asm.f fVar213 = fVar;
                    iVar2.b(158, fVar213);
                    iVar2.h(21, c0149a.h("matchedCount"));
                    iVar2.f(4);
                    iVar2.f(96);
                    iVar2.h(54, c0149a.h("matchedCount"));
                    iVar2.h(25, c0149a.h("lexer"));
                    iVar2.d(180, str2, str5, str6);
                    iVar2.k(4);
                    fVar2 = fVar15;
                    iVar2.b(159, fVar2);
                    iVar2.l(fVar213);
                    if (i9 == i7 - 1) {
                        iVar2.h(25, c0149a.h("lexer"));
                        iVar2.d(180, str2, str5, str6);
                        iVar2.k(4);
                        iVar2.b(160, fVar4);
                    }
                    iVar = iVar2;
                    fVar3 = fVar4;
                }
                str = str;
                iVar2 = iVar;
                str6 = str6;
                str5 = str5;
                length = i7;
                fVar12 = fVar3;
                fVar15 = fVar2;
                i14 = i9 + 1;
            }
            i8 = i14;
            fVar = fVar16;
            aVar = this;
            iVar2.h(25, c0149a.h("lexer"));
            str2 = f12840j0;
            iVar2.d(180, str2, str5, str6);
            com.alibaba.fastjson.asm.f fVar214 = new com.alibaba.fastjson.asm.f();
            iVar2.b(158, fVar214);
            i9 = i8;
            aVar.u(iVar2, c0149a, i9);
            iVar2.l(fVar214);
            iVar2.h(25, c0149a.h("lexer"));
            iVar2.d(180, str2, str5, str6);
            iVar2.f(89);
            iVar2.h(54, c0149a.h(str5));
            iVar2.k(-1);
            fVar4 = fVar12;
            iVar2.b(159, fVar4);
            iVar2.h(25, c0149a.h("lexer"));
            iVar2.d(180, str2, str5, str6);
            com.alibaba.fastjson.asm.f fVar215 = fVar;
            iVar2.b(158, fVar215);
            iVar2.h(21, c0149a.h("matchedCount"));
            iVar2.f(4);
            iVar2.f(96);
            iVar2.h(54, c0149a.h("matchedCount"));
            iVar2.h(25, c0149a.h("lexer"));
            iVar2.d(180, str2, str5, str6);
            iVar2.k(4);
            fVar2 = fVar15;
            iVar2.b(159, fVar2);
            iVar2.l(fVar215);
            if (i9 == i7 - 1) {
                iVar2.h(25, c0149a.h("lexer"));
                iVar2.d(180, str2, str5, str6);
                iVar2.k(4);
                iVar2.b(160, fVar4);
            }
            iVar = iVar2;
            fVar3 = fVar4;
            str = str;
            iVar2 = iVar;
            str6 = str6;
            str5 = str5;
            length = i7;
            fVar12 = fVar3;
            fVar15 = fVar2;
            i14 = i9 + 1;
        }
        com.alibaba.fastjson.asm.i iVar3 = iVar2;
        com.alibaba.fastjson.asm.f fVar30 = fVar12;
        int i15 = length;
        iVar3.l(fVar15);
        if (!c0149a.f12848c.isInterface() && !Modifier.isAbstract(c0149a.f12848c.getModifiers())) {
            a(c0149a, iVar3);
        }
        iVar3.l(fVar14);
        t(c0149a, iVar3);
        iVar3.h(25, c0149a.h("instance"));
        Method method = c0149a.f12849d.f13346f;
        if (method != null) {
            iVar3.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(c0149a.g()), method.getName(), "()" + com.alibaba.fastjson.util.b.b(method.getReturnType()));
        }
        iVar3.f(com.alibaba.fastjson.asm.j.R);
        iVar3.l(fVar30);
        a(c0149a, iVar3);
        iVar3.h(25, 0);
        iVar3.h(25, 1);
        iVar3.h(25, 2);
        iVar3.h(25, 3);
        iVar3.h(25, c0149a.h("instance"));
        iVar3.h(21, 4);
        int i16 = i15 / 32;
        if (i15 != 0 && i15 % 32 != 0) {
            i16++;
        }
        if (i16 == 1) {
            iVar3.f(4);
        } else {
            iVar3.e(16, i16);
        }
        iVar3.e(com.alibaba.fastjson.asm.j.f12604b0, 10);
        for (int i17 = 0; i17 < i16; i17++) {
            iVar3.f(89);
            if (i17 == 0) {
                iVar3.f(3);
            } else if (i17 == 1) {
                iVar3.f(4);
            } else {
                iVar3.e(16, i17);
            }
            iVar3.h(21, c0149a.h("_asm_flag_" + i17));
            iVar3.f(79);
        }
        String strH = com.alibaba.fastjson.util.b.h(n.class);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(L");
        String str13 = f12839i0;
        sb3.append(str13);
        sb3.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;");
        iVar3.i(com.alibaba.fastjson.asm.j.W, strH, "parseRest", sb3.toString());
        iVar3.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(c0149a.f12848c));
        iVar3.f(com.alibaba.fastjson.asm.j.R);
        iVar3.l(fVar13);
        iVar3.h(25, 0);
        iVar3.h(25, 1);
        iVar3.h(25, 2);
        iVar3.h(25, 3);
        iVar3.h(21, 4);
        iVar3.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(n.class), "deserialze", "(L" + str13 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;");
        iVar3.f(com.alibaba.fastjson.asm.j.R);
        iVar3.g(10, c0149a.f12846a);
        iVar3.j();
    }

    private void h(com.alibaba.fastjson.asm.c cVar, C0149a c0149a) {
        com.alibaba.fastjson.util.e[] eVarArr;
        int i7;
        int i8;
        int i9;
        int i10;
        com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar, 1, "deserialzeArrayMapping", "(L" + f12839i0 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null, null);
        w(c0149a, iVar);
        d(c0149a, iVar);
        com.alibaba.fastjson.util.e[] eVarArr2 = c0149a.f12849d.f13349i;
        int length = eVarArr2.length;
        int i11 = 0;
        while (i11 < length) {
            boolean z7 = i11 == length + (-1);
            int i12 = z7 ? 93 : 44;
            com.alibaba.fastjson.util.e eVar = eVarArr2[i11];
            Class<?> cls = eVar.f13297e;
            Type type = eVar.f13298f;
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                eVarArr = eVarArr2;
                i7 = length;
                i8 = i11;
                iVar.h(25, c0149a.h("lexer"));
                iVar.h(16, i12);
                iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanInt", "(C)I");
                iVar.h(54, c0149a.h(eVar.f13293a + "_asm"));
            } else {
                eVarArr = eVarArr2;
                i7 = length;
                int i13 = i11;
                if (cls == Byte.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    String str = f12840j0;
                    iVar.i(com.alibaba.fastjson.asm.j.W, str, "scanInt", "(C)I");
                    iVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.d(180, str, "matchStat", "I");
                    iVar.k(5);
                    iVar.b(160, fVar);
                    iVar.f(1);
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    iVar.l(fVar);
                } else if (cls == Short.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    String str2 = f12840j0;
                    iVar.i(com.alibaba.fastjson.asm.j.W, str2, "scanInt", "(C)I");
                    iVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.d(180, str2, "matchStat", "I");
                    iVar.k(5);
                    iVar.b(160, fVar2);
                    iVar.f(1);
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    iVar.l(fVar2);
                } else if (cls == Integer.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    String str3 = f12840j0;
                    iVar.i(com.alibaba.fastjson.asm.j.W, str3, "scanInt", "(C)I");
                    iVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.d(180, str3, "matchStat", "I");
                    iVar.k(5);
                    iVar.b(160, fVar3);
                    iVar.f(1);
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    iVar.l(fVar3);
                } else if (cls == Long.TYPE) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanLong", "(C)J");
                    iVar.h(55, c0149a.i(eVar.f13293a + "_asm", 2));
                } else if (cls == Long.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    String str4 = f12840j0;
                    iVar.i(com.alibaba.fastjson.asm.j.W, str4, "scanLong", "(C)J");
                    iVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.d(180, str4, "matchStat", "I");
                    iVar.k(5);
                    iVar.b(160, fVar4);
                    iVar.f(1);
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    iVar.l(fVar4);
                } else if (cls == Boolean.TYPE) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanBoolean", "(C)Z");
                    iVar.h(54, c0149a.h(eVar.f13293a + "_asm"));
                } else if (cls == Float.TYPE) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanFloat", "(C)F");
                    iVar.h(56, c0149a.h(eVar.f13293a + "_asm"));
                } else if (cls == Float.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    String str5 = f12840j0;
                    iVar.i(com.alibaba.fastjson.asm.j.W, str5, "scanFloat", "(C)F");
                    iVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.d(180, str5, "matchStat", "I");
                    iVar.k(5);
                    iVar.b(160, fVar5);
                    iVar.f(1);
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    iVar.l(fVar5);
                } else if (cls == Double.TYPE) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanDouble", "(C)D");
                    iVar.h(57, c0149a.i(eVar.f13293a + "_asm", 2));
                } else if (cls == Double.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    String str6 = f12840j0;
                    iVar.i(com.alibaba.fastjson.asm.j.W, str6, "scanDouble", "(C)D");
                    iVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.d(180, str6, "matchStat", "I");
                    iVar.k(5);
                    iVar.b(160, fVar6);
                    iVar.f(1);
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    iVar.l(fVar6);
                } else if (cls == Character.TYPE) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanString", "(C)Ljava/lang/String;");
                    iVar.f(3);
                    iVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/String", "charAt", "(I)C");
                    iVar.h(54, c0149a.h(eVar.f13293a + "_asm"));
                } else if (cls == String.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanString", "(C)Ljava/lang/String;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                } else if (cls == BigDecimal.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanDecimal", "(C)Ljava/math/BigDecimal;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                } else if (cls == Date.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanDate", "(C)Ljava/util/Date;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                } else if (cls == UUID.class) {
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "scanUUID", "(C)Ljava/util/UUID;");
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                } else if (cls.isEnum()) {
                    com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
                    com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
                    com.alibaba.fastjson.asm.f fVar9 = new com.alibaba.fastjson.asm.f();
                    com.alibaba.fastjson.asm.f fVar10 = new com.alibaba.fastjson.asm.f();
                    iVar.h(25, c0149a.h("lexer"));
                    String str7 = f12840j0;
                    iVar.i(com.alibaba.fastjson.asm.j.W, str7, "getCurrent", "()C");
                    iVar.f(89);
                    iVar.h(54, c0149a.h("ch"));
                    iVar.k(Integer.valueOf(Constants.LOG_ERROR_OTP));
                    iVar.b(159, fVar10);
                    iVar.h(21, c0149a.h("ch"));
                    iVar.k(34);
                    iVar.b(160, fVar7);
                    iVar.l(fVar10);
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls)));
                    iVar.h(25, 1);
                    iVar.i(com.alibaba.fastjson.asm.j.W, f12839i0, "getSymbolTable", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.k.class));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, str7, "scanEnum", "(Ljava/lang/Class;" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.k.class) + "C)Ljava/lang/Enum;");
                    iVar.b(com.alibaba.fastjson.asm.j.P, fVar9);
                    iVar.l(fVar7);
                    iVar.h(21, c0149a.h("ch"));
                    iVar.k(48);
                    iVar.b(161, fVar8);
                    iVar.h(21, c0149a.h("ch"));
                    iVar.k(57);
                    iVar.b(163, fVar8);
                    l(c0149a, iVar, eVar);
                    iVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(g.class));
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, str7, "scanInt", "(C)I");
                    iVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(g.class), "valueOf", "(I)Ljava/lang/Enum;");
                    iVar.b(com.alibaba.fastjson.asm.j.P, fVar9);
                    iVar.l(fVar8);
                    iVar.h(25, 0);
                    iVar.h(25, c0149a.h("lexer"));
                    iVar.h(16, i12);
                    iVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "scanEnum", "(L" + str7 + ";C)Ljava/lang/Enum;");
                    iVar.l(fVar9);
                    iVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls));
                    iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                } else if (Collection.class.isAssignableFrom(cls)) {
                    Class<?> clsP = com.alibaba.fastjson.util.l.P(type);
                    if (clsP == String.class) {
                        if (cls == List.class || cls == Collections.class || cls == ArrayList.class) {
                            iVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(ArrayList.class));
                            iVar.f(89);
                            iVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(ArrayList.class), "<init>", "()V");
                        } else {
                            iVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls)));
                            iVar.i(com.alibaba.fastjson.asm.j.Y, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.util.l.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                        }
                        iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                        iVar.h(25, c0149a.h("lexer"));
                        iVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
                        iVar.h(16, i12);
                        String str8 = f12840j0;
                        iVar.i(com.alibaba.fastjson.asm.j.W, str8, "scanStringArray", "(Ljava/util/Collection;C)V");
                        com.alibaba.fastjson.asm.f fVar11 = new com.alibaba.fastjson.asm.f();
                        iVar.h(25, c0149a.h("lexer"));
                        iVar.d(180, str8, "matchStat", "I");
                        iVar.k(5);
                        iVar.b(160, fVar11);
                        iVar.f(1);
                        iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                        iVar.l(fVar11);
                    } else {
                        com.alibaba.fastjson.asm.f fVar12 = new com.alibaba.fastjson.asm.f();
                        iVar.h(25, c0149a.h("lexer"));
                        String str9 = f12840j0;
                        iVar.i(com.alibaba.fastjson.asm.j.W, str9, com.paytm.pgsdk.d.R, "()I");
                        iVar.h(54, c0149a.h(com.paytm.pgsdk.d.R));
                        iVar.h(21, c0149a.h(com.paytm.pgsdk.d.R));
                        iVar.k(Integer.valueOf(i13 == 0 ? 14 : 16));
                        iVar.b(159, fVar12);
                        iVar.h(25, 1);
                        iVar.h(21, c0149a.h(com.paytm.pgsdk.d.R));
                        String str10 = f12839i0;
                        iVar.i(com.alibaba.fastjson.asm.j.W, str10, "throwException", "(I)V");
                        iVar.l(fVar12);
                        com.alibaba.fastjson.asm.f fVar13 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar14 = new com.alibaba.fastjson.asm.f();
                        iVar.h(25, c0149a.h("lexer"));
                        iVar.i(com.alibaba.fastjson.asm.j.W, str9, "getCurrent", "()C");
                        iVar.h(16, 91);
                        iVar.b(160, fVar13);
                        iVar.h(25, c0149a.h("lexer"));
                        iVar.i(com.alibaba.fastjson.asm.j.W, str9, "next", "()C");
                        iVar.f(87);
                        iVar.h(25, c0149a.h("lexer"));
                        iVar.k(14);
                        iVar.i(com.alibaba.fastjson.asm.j.W, str9, "setToken", "(I)V");
                        iVar.b(com.alibaba.fastjson.asm.j.P, fVar14);
                        iVar.l(fVar13);
                        iVar.h(25, c0149a.h("lexer"));
                        iVar.k(14);
                        iVar.i(com.alibaba.fastjson.asm.j.W, str9, "nextToken", "(I)V");
                        iVar.l(fVar14);
                        i8 = i13;
                        p(iVar, cls, i8, false);
                        iVar.f(89);
                        iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                        k(c0149a, iVar, eVar, clsP);
                        iVar.h(25, 1);
                        iVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(clsP)));
                        iVar.h(25, 3);
                        iVar.i(com.alibaba.fastjson.asm.j.Y, com.alibaba.fastjson.util.b.h(n.class), "parseArray", "(Ljava/util/Collection;" + com.alibaba.fastjson.util.b.b(e1.class) + "L" + str10 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                    }
                } else {
                    i8 = i13;
                    if (cls.isArray()) {
                        iVar.h(25, c0149a.h("lexer"));
                        iVar.k(14);
                        iVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "nextToken", "(I)V");
                        iVar.h(25, 1);
                        iVar.h(25, 0);
                        iVar.k(Integer.valueOf(i8));
                        iVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                        iVar.i(com.alibaba.fastjson.asm.j.W, f12839i0, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                        iVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls));
                        iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                    } else {
                        com.alibaba.fastjson.asm.f fVar15 = new com.alibaba.fastjson.asm.f();
                        com.alibaba.fastjson.asm.f fVar16 = new com.alibaba.fastjson.asm.f();
                        if (cls == Date.class) {
                            iVar.h(25, c0149a.h("lexer"));
                            String str11 = f12840j0;
                            iVar.i(com.alibaba.fastjson.asm.j.W, str11, "getCurrent", "()C");
                            iVar.k(49);
                            iVar.b(160, fVar15);
                            iVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(Date.class));
                            iVar.f(89);
                            i9 = 25;
                            iVar.h(25, c0149a.h("lexer"));
                            iVar.h(16, i12);
                            i10 = com.alibaba.fastjson.asm.j.W;
                            iVar.i(com.alibaba.fastjson.asm.j.W, str11, "scanLong", "(C)J");
                            iVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(Date.class), "<init>", "(J)V");
                            iVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
                            iVar.b(com.alibaba.fastjson.asm.j.P, fVar16);
                        } else {
                            i9 = 25;
                            i10 = com.alibaba.fastjson.asm.j.W;
                        }
                        iVar.l(fVar15);
                        q(c0149a, iVar, 14);
                        e(c0149a, iVar, eVar, cls, i8);
                        iVar.h(i9, c0149a.h("lexer"));
                        iVar.i(i10, f12840j0, com.paytm.pgsdk.d.R, "()I");
                        iVar.k(15);
                        iVar.b(159, fVar16);
                        iVar.h(i9, 0);
                        iVar.h(i9, c0149a.h("lexer"));
                        if (z7) {
                            iVar.k(15);
                        } else {
                            iVar.k(16);
                        }
                        iVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(n.class), "check", "(" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.d.class) + "I)V");
                        iVar.l(fVar16);
                    }
                }
                i8 = i13;
            }
            i11 = i8 + 1;
            eVarArr2 = eVarArr;
            length = i7;
        }
        b(c0149a, iVar, false);
        com.alibaba.fastjson.asm.f fVar17 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar18 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar19 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar20 = new com.alibaba.fastjson.asm.f();
        iVar.h(25, c0149a.h("lexer"));
        String str12 = f12840j0;
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "getCurrent", "()C");
        iVar.f(89);
        iVar.h(54, c0149a.h("ch"));
        iVar.h(16, 44);
        iVar.b(160, fVar18);
        iVar.h(25, c0149a.h("lexer"));
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "next", "()C");
        iVar.f(87);
        iVar.h(25, c0149a.h("lexer"));
        iVar.k(16);
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "setToken", "(I)V");
        iVar.b(com.alibaba.fastjson.asm.j.P, fVar20);
        iVar.l(fVar18);
        iVar.h(21, c0149a.h("ch"));
        iVar.h(16, 93);
        iVar.b(160, fVar19);
        iVar.h(25, c0149a.h("lexer"));
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "next", "()C");
        iVar.f(87);
        iVar.h(25, c0149a.h("lexer"));
        iVar.k(15);
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "setToken", "(I)V");
        iVar.b(com.alibaba.fastjson.asm.j.P, fVar20);
        iVar.l(fVar19);
        iVar.h(21, c0149a.h("ch"));
        iVar.h(16, 26);
        iVar.b(160, fVar17);
        iVar.h(25, c0149a.h("lexer"));
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "next", "()C");
        iVar.f(87);
        iVar.h(25, c0149a.h("lexer"));
        iVar.k(20);
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "setToken", "(I)V");
        iVar.b(com.alibaba.fastjson.asm.j.P, fVar20);
        iVar.l(fVar17);
        iVar.h(25, c0149a.h("lexer"));
        iVar.k(16);
        iVar.i(com.alibaba.fastjson.asm.j.W, str12, "nextToken", "(I)V");
        iVar.l(fVar20);
        iVar.h(25, c0149a.h("instance"));
        iVar.f(com.alibaba.fastjson.asm.j.R);
        iVar.g(5, c0149a.f12846a);
        iVar.j();
    }

    private void i(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.asm.f fVar, com.alibaba.fastjson.util.e eVar, Class<?> cls, Class<?> cls2, int i7) {
        String str;
        String str2;
        String str3;
        int i8;
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        String str4 = f12840j0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str4, "matchField", "([C)Z");
        hVar.b(153, fVar2);
        u(hVar, c0149a, i7);
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str4, com.paytm.pgsdk.d.R, "()I");
        hVar.k(8);
        hVar.b(160, fVar3);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(16);
        hVar.i(com.alibaba.fastjson.asm.j.W, str4, "nextToken", "(I)V");
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
        hVar.l(fVar3);
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar6 = new com.alibaba.fastjson.asm.f();
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str4, com.paytm.pgsdk.d.R, "()I");
        hVar.k(21);
        hVar.b(160, fVar5);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(14);
        hVar.i(com.alibaba.fastjson.asm.j.W, str4, "nextToken", "(I)V");
        p(hVar, cls, i7, true);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar4);
        hVar.l(fVar5);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str4, com.paytm.pgsdk.d.R, "()I");
        hVar.k(14);
        hVar.b(159, fVar6);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str4, com.paytm.pgsdk.d.R, "()I");
        hVar.k(12);
        hVar.b(160, fVar);
        p(hVar, cls, i7, false);
        hVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
        k(c0149a, hVar, eVar, cls2);
        hVar.h(25, 1);
        hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
        hVar.f(3);
        hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        String strH = com.alibaba.fastjson.util.b.h(e1.class);
        StringBuilder sb = new StringBuilder();
        sb.append("(L");
        String str5 = f12839i0;
        sb.append(str5);
        sb.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.i(com.alibaba.fastjson.asm.j.Z, strH, "deserialze", sb.toString());
        hVar.h(58, c0149a.h("list_item_value"));
        hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
        hVar.h(25, c0149a.h("list_item_value"));
        if (cls.isInterface()) {
            hVar.i(com.alibaba.fastjson.asm.j.Z, com.alibaba.fastjson.util.b.h(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar.f(87);
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
        hVar.l(fVar6);
        p(hVar, cls, i7, false);
        hVar.l(fVar4);
        hVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
        boolean zW = com.alibaba.fastjson.parser.j.w(eVar.f13297e);
        k(c0149a, hVar, eVar, cls2);
        if (zW) {
            hVar.i(com.alibaba.fastjson.asm.j.Z, com.alibaba.fastjson.util.b.h(e1.class), "getFastMatchToken", "()I");
            hVar.h(54, c0149a.h("fastMatchToken"));
            str2 = "lexer";
            hVar.h(25, c0149a.h(str2));
            hVar.h(21, c0149a.h("fastMatchToken"));
            str = str4;
            str3 = "(I)V";
            hVar.i(com.alibaba.fastjson.asm.j.W, str, "nextToken", str3);
        } else {
            str = str4;
            str2 = "lexer";
            str3 = "(I)V";
            hVar.f(87);
            hVar.k(12);
            hVar.h(54, c0149a.h("fastMatchToken"));
            q(c0149a, hVar, 12);
        }
        hVar.h(25, 1);
        String str6 = str3;
        hVar.i(com.alibaba.fastjson.asm.j.W, str5, "getContext", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class));
        hVar.h(58, c0149a.h("listContext"));
        hVar.h(25, 1);
        hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
        hVar.k(eVar.f13293a);
        hVar.i(com.alibaba.fastjson.asm.j.W, str5, "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class));
        hVar.f(87);
        com.alibaba.fastjson.asm.f fVar7 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar8 = new com.alibaba.fastjson.asm.f();
        hVar.f(3);
        hVar.h(54, c0149a.h("i"));
        hVar.l(fVar7);
        hVar.h(25, c0149a.h(str2));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, com.paytm.pgsdk.d.R, "()I");
        hVar.k(15);
        hVar.b(159, fVar8);
        hVar.h(25, 0);
        hVar.d(180, c0149a.f12850e, eVar.f13293a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(e1.class));
        hVar.h(25, 1);
        hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls2)));
        hVar.h(21, c0149a.h("i"));
        hVar.i(com.alibaba.fastjson.asm.j.Y, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
        hVar.i(com.alibaba.fastjson.asm.j.Z, com.alibaba.fastjson.util.b.h(e1.class), "deserialze", "(L" + str5 + ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
        hVar.h(58, c0149a.h("list_item_value"));
        hVar.a(c0149a.h("i"), 1);
        hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
        hVar.h(25, c0149a.h("list_item_value"));
        if (cls.isInterface()) {
            hVar.i(com.alibaba.fastjson.asm.j.Z, com.alibaba.fastjson.util.b.h(cls), "add", "(Ljava/lang/Object;)Z");
        } else {
            hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(cls), "add", "(Ljava/lang/Object;)Z");
        }
        hVar.f(87);
        hVar.h(25, 1);
        hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str5, "checkListResolve", "(Ljava/util/Collection;)V");
        hVar.h(25, c0149a.h(str2));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, com.paytm.pgsdk.d.R, "()I");
        hVar.k(16);
        hVar.b(160, fVar7);
        if (zW) {
            hVar.h(25, c0149a.h(str2));
            hVar.h(21, c0149a.h("fastMatchToken"));
            hVar.i(com.alibaba.fastjson.asm.j.W, str, "nextToken", str6);
            i8 = com.alibaba.fastjson.asm.j.P;
        } else {
            q(c0149a, hVar, 12);
            i8 = com.alibaba.fastjson.asm.j.P;
        }
        hVar.b(i8, fVar7);
        hVar.l(fVar8);
        hVar.h(25, 1);
        hVar.h(25, c0149a.h("listContext"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str5, "setContext", "(" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class) + ")V");
        hVar.h(25, c0149a.h(str2));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, com.paytm.pgsdk.d.R, "()I");
        hVar.k(15);
        hVar.b(160, fVar);
        r(c0149a, hVar);
        hVar.l(fVar2);
    }

    private void j(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.asm.f fVar, com.alibaba.fastjson.util.e eVar, Class<?> cls, int i7) {
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        hVar.h(25, c0149a.h("lexer"));
        hVar.h(25, 0);
        hVar.d(180, c0149a.f12850e, eVar.f13293a + "_asm_prefix__", "[C");
        hVar.i(com.alibaba.fastjson.asm.j.W, f12840j0, "matchField", "([C)Z");
        hVar.b(154, fVar2);
        hVar.f(1);
        hVar.h(58, c0149a.h(eVar.f13293a + "_asm"));
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar3);
        hVar.l(fVar2);
        u(hVar, c0149a, i7);
        hVar.h(21, c0149a.h("matchedCount"));
        hVar.f(4);
        hVar.f(96);
        hVar.h(54, c0149a.h("matchedCount"));
        e(c0149a, hVar, eVar, cls, i7);
        hVar.h(25, 1);
        String str = f12839i0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "getResolveStatus", "()I");
        hVar.k(1);
        hVar.b(160, fVar3);
        hVar.h(25, 1);
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "getLastResolveTask", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.b.a.class));
        hVar.h(58, c0149a.h("resolveTask"));
        hVar.h(25, c0149a.h("resolveTask"));
        hVar.h(25, 1);
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "getContext", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class));
        hVar.d(com.alibaba.fastjson.asm.j.V, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.parser.b.a.class), "ownerContext", com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class));
        hVar.h(25, c0149a.h("resolveTask"));
        hVar.h(25, 0);
        hVar.k(eVar.f13293a);
        hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "getFieldDeserializer", "(Ljava/lang/String;)" + com.alibaba.fastjson.util.b.b(k.class));
        hVar.d(com.alibaba.fastjson.asm.j.V, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.parser.b.a.class), "fieldDeserializer", com.alibaba.fastjson.util.b.b(k.class));
        hVar.h(25, 1);
        hVar.k(0);
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "setResolveStatus", "(I)V");
        hVar.l(fVar3);
    }

    private void k(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar, Class<?> cls) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.h(25, 0);
        hVar.d(180, c0149a.f12850e, eVar.f13293a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(e1.class));
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar);
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.i(com.alibaba.fastjson.asm.j.W, f12839i0, "getConfig", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.j.class));
        hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(cls)));
        hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.parser.j.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + com.alibaba.fastjson.util.b.b(e1.class));
        hVar.d(com.alibaba.fastjson.asm.j.V, c0149a.f12850e, eVar.f13293a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(e1.class));
        hVar.l(fVar);
        hVar.h(25, 0);
        hVar.d(180, c0149a.f12850e, eVar.f13293a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(e1.class));
    }

    private void l(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.h(25, 0);
        hVar.d(180, c0149a.f12850e, eVar.f13293a + "_asm_deser__", com.alibaba.fastjson.util.b.b(e1.class));
        hVar.b(com.alibaba.fastjson.asm.j.f12612f0, fVar);
        hVar.h(25, 0);
        hVar.h(25, 1);
        hVar.i(com.alibaba.fastjson.asm.j.W, f12839i0, "getConfig", "()" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.j.class));
        hVar.k(com.alibaba.fastjson.asm.k.g(com.alibaba.fastjson.util.b.b(eVar.f13297e)));
        hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.parser.j.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + com.alibaba.fastjson.util.b.b(e1.class));
        hVar.d(com.alibaba.fastjson.asm.j.V, c0149a.f12850e, eVar.f13293a + "_asm_deser__", com.alibaba.fastjson.util.b.b(e1.class));
        hVar.l(fVar);
        hVar.h(25, 0);
        hVar.d(180, c0149a.f12850e, eVar.f13293a + "_asm_deser__", com.alibaba.fastjson.util.b.b(e1.class));
    }

    private void m(com.alibaba.fastjson.asm.c cVar, C0149a c0149a) {
        int length = c0149a.f12851f.length;
        for (int i7 = 0; i7 < length; i7++) {
            new com.alibaba.fastjson.asm.d(cVar, 1, c0149a.f12851f[i7].f13293a + "_asm_prefix__", "[C").c();
        }
        int length2 = c0149a.f12851f.length;
        for (int i8 = 0; i8 < length2; i8++) {
            com.alibaba.fastjson.util.e eVar = c0149a.f12851f[i8];
            Class<?> cls = eVar.f13297e;
            if (!cls.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls)) {
                    new com.alibaba.fastjson.asm.d(cVar, 1, eVar.f13293a + "_asm_list_item_deser__", com.alibaba.fastjson.util.b.b(e1.class)).c();
                } else {
                    new com.alibaba.fastjson.asm.d(cVar, 1, eVar.f13293a + "_asm_deser__", com.alibaba.fastjson.util.b.b(e1.class)).c();
                }
            }
        }
        com.alibaba.fastjson.asm.i iVar = new com.alibaba.fastjson.asm.i(cVar, 1, "<init>", "(" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.j.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + ")V", null, null);
        iVar.h(25, 0);
        iVar.h(25, 1);
        iVar.h(25, 2);
        iVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(n.class), "<init>", "(" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.j.class) + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.util.h.class) + ")V");
        int length3 = c0149a.f12851f.length;
        for (int i9 = 0; i9 < length3; i9++) {
            com.alibaba.fastjson.util.e eVar2 = c0149a.f12851f[i9];
            iVar.h(25, 0);
            iVar.k("\"" + eVar2.f13293a + "\":");
            iVar.i(com.alibaba.fastjson.asm.j.W, "java/lang/String", "toCharArray", "()[C");
            iVar.d(com.alibaba.fastjson.asm.j.V, c0149a.f12850e, eVar2.f13293a + "_asm_prefix__", "[C");
        }
        iVar.f(com.alibaba.fastjson.asm.j.S);
        iVar.g(4, 4);
        iVar.j();
    }

    private void n(com.alibaba.fastjson.asm.h hVar, C0149a c0149a, int i7, com.alibaba.fastjson.asm.f fVar) {
        hVar.h(21, c0149a.h("_asm_flag_" + (i7 / 32)));
        hVar.k(Integer.valueOf(1 << i7));
        hVar.f(126);
        hVar.b(153, fVar);
    }

    private void o(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar) {
        Class<?> cls = eVar.f13297e;
        Type type = eVar.f13298f;
        if (cls == Boolean.TYPE) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(21, c0149a.h(eVar.f13293a + "_asm"));
            s(c0149a, hVar, eVar);
            return;
        }
        if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(21, c0149a.h(eVar.f13293a + "_asm"));
            s(c0149a, hVar, eVar);
            return;
        }
        if (cls == Long.TYPE) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(22, c0149a.i(eVar.f13293a + "_asm", 2));
            if (eVar.f13294b == null) {
                hVar.d(com.alibaba.fastjson.asm.j.V, com.alibaba.fastjson.util.b.h(eVar.f13299g), eVar.f13295c.getName(), com.alibaba.fastjson.util.b.b(eVar.f13297e));
                return;
            }
            hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(c0149a.g()), eVar.f13294b.getName(), com.alibaba.fastjson.util.b.c(eVar.f13294b));
            if (eVar.f13294b.getReturnType().equals(Void.TYPE)) {
                return;
            }
            hVar.f(87);
            return;
        }
        if (cls == Float.TYPE) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(23, c0149a.h(eVar.f13293a + "_asm"));
            s(c0149a, hVar, eVar);
            return;
        }
        if (cls == Double.TYPE) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(24, c0149a.i(eVar.f13293a + "_asm", 2));
            s(c0149a, hVar, eVar);
            return;
        }
        if (cls == String.class) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
            s(c0149a, hVar, eVar);
            return;
        }
        if (cls.isEnum()) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
            s(c0149a, hVar, eVar);
            return;
        }
        if (!Collection.class.isAssignableFrom(cls)) {
            hVar.h(25, c0149a.h("instance"));
            hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
            s(c0149a, hVar, eVar);
            return;
        }
        hVar.h(25, c0149a.h("instance"));
        if (com.alibaba.fastjson.util.l.P(type) == String.class) {
            hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
            hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls));
        } else {
            hVar.h(25, c0149a.h(eVar.f13293a + "_asm"));
        }
        s(c0149a, hVar, eVar);
    }

    private void p(com.alibaba.fastjson.asm.h hVar, Class<?> cls, int i7, boolean z7) {
        if (cls.isAssignableFrom(ArrayList.class) && !z7) {
            hVar.c(com.alibaba.fastjson.asm.j.f12602a0, "java/util/ArrayList");
            hVar.f(89);
            hVar.i(com.alibaba.fastjson.asm.j.X, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z7) {
            hVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(LinkedList.class));
            hVar.f(89);
            hVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            hVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(HashSet.class));
            hVar.f(89);
            hVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            hVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(TreeSet.class));
            hVar.f(89);
            hVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            hVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(LinkedHashSet.class));
            hVar.f(89);
            hVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(LinkedHashSet.class), "<init>", "()V");
        } else if (z7) {
            hVar.c(com.alibaba.fastjson.asm.j.f12602a0, com.alibaba.fastjson.util.b.h(HashSet.class));
            hVar.f(89);
            hVar.i(com.alibaba.fastjson.asm.j.X, com.alibaba.fastjson.util.b.h(HashSet.class), "<init>", "()V");
        } else {
            hVar.h(25, 0);
            hVar.k(Integer.valueOf(i7));
            hVar.i(com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(n.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            hVar.i(com.alibaba.fastjson.asm.j.Y, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.util.l.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, com.alibaba.fastjson.util.b.h(cls));
    }

    private void q(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, int i7) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        hVar.h(25, c0149a.h("lexer"));
        String str = f12840j0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "getCurrent", "()C");
        if (i7 == 12) {
            hVar.h(16, 123);
        } else {
            if (i7 != 14) {
                throw new IllegalStateException();
            }
            hVar.h(16, 91);
        }
        hVar.b(160, fVar);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "next", "()C");
        hVar.f(87);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(Integer.valueOf(i7));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "setToken", "(I)V");
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar2);
        hVar.l(fVar);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(Integer.valueOf(i7));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "nextToken", "(I)V");
        hVar.l(fVar2);
    }

    private void r(C0149a c0149a, com.alibaba.fastjson.asm.h hVar) {
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar2 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar3 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar4 = new com.alibaba.fastjson.asm.f();
        com.alibaba.fastjson.asm.f fVar5 = new com.alibaba.fastjson.asm.f();
        hVar.h(25, c0149a.h("lexer"));
        String str = f12840j0;
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "getCurrent", "()C");
        hVar.f(89);
        hVar.h(54, c0149a.h("ch"));
        hVar.h(16, 44);
        hVar.b(160, fVar2);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "next", "()C");
        hVar.f(87);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(16);
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "setToken", "(I)V");
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar5);
        hVar.l(fVar2);
        hVar.h(21, c0149a.h("ch"));
        hVar.h(16, 125);
        hVar.b(160, fVar3);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "next", "()C");
        hVar.f(87);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(13);
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "setToken", "(I)V");
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar5);
        hVar.l(fVar3);
        hVar.h(21, c0149a.h("ch"));
        hVar.h(16, 93);
        hVar.b(160, fVar4);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "next", "()C");
        hVar.f(87);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(15);
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "setToken", "(I)V");
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar5);
        hVar.l(fVar4);
        hVar.h(21, c0149a.h("ch"));
        hVar.h(16, 26);
        hVar.b(160, fVar);
        hVar.h(25, c0149a.h("lexer"));
        hVar.k(20);
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "setToken", "(I)V");
        hVar.b(com.alibaba.fastjson.asm.j.P, fVar5);
        hVar.l(fVar);
        hVar.h(25, c0149a.h("lexer"));
        hVar.i(com.alibaba.fastjson.asm.j.W, str, "nextToken", "()V");
        hVar.l(fVar5);
    }

    private void s(C0149a c0149a, com.alibaba.fastjson.asm.h hVar, com.alibaba.fastjson.util.e eVar) {
        Method method = eVar.f13294b;
        if (method == null) {
            hVar.d(com.alibaba.fastjson.asm.j.V, com.alibaba.fastjson.util.b.h(eVar.f13299g), eVar.f13295c.getName(), com.alibaba.fastjson.util.b.b(eVar.f13297e));
            return;
        }
        hVar.i(method.getDeclaringClass().isInterface() ? com.alibaba.fastjson.asm.j.Z : com.alibaba.fastjson.asm.j.W, com.alibaba.fastjson.util.b.h(eVar.f13299g), method.getName(), com.alibaba.fastjson.util.b.c(method));
        if (eVar.f13294b.getReturnType().equals(Void.TYPE)) {
            return;
        }
        hVar.f(87);
    }

    private void t(C0149a c0149a, com.alibaba.fastjson.asm.h hVar) {
        hVar.h(25, 1);
        hVar.h(25, c0149a.h("context"));
        hVar.i(com.alibaba.fastjson.asm.j.W, f12839i0, "setContext", "(" + com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.i.class) + ")V");
        com.alibaba.fastjson.asm.f fVar = new com.alibaba.fastjson.asm.f();
        hVar.h(25, c0149a.h("childContext"));
        hVar.b(com.alibaba.fastjson.asm.j.f12610e0, fVar);
        hVar.h(25, c0149a.h("childContext"));
        hVar.h(25, c0149a.h("instance"));
        hVar.d(com.alibaba.fastjson.asm.j.V, com.alibaba.fastjson.util.b.h(com.alibaba.fastjson.parser.i.class), "object", "Ljava/lang/Object;");
        hVar.l(fVar);
    }

    private void u(com.alibaba.fastjson.asm.h hVar, C0149a c0149a, int i7) {
        String str = "_asm_flag_" + (i7 / 32);
        hVar.h(21, c0149a.h(str));
        hVar.k(Integer.valueOf(1 << i7));
        hVar.f(128);
        hVar.h(54, c0149a.h(str));
    }

    private void w(C0149a c0149a, com.alibaba.fastjson.asm.h hVar) {
        hVar.h(25, 1);
        hVar.d(180, f12839i0, "lexer", com.alibaba.fastjson.util.b.b(com.alibaba.fastjson.parser.d.class));
        hVar.c(com.alibaba.fastjson.asm.j.f12606c0, f12840j0);
        hVar.h(58, c0149a.h("lexer"));
    }

    public e1 v(com.alibaba.fastjson.parser.j jVar, com.alibaba.fastjson.util.h hVar) throws Exception {
        String str;
        Class<?> cls = hVar.f13341a;
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("not support type :" + cls.getName());
        }
        String str2 = "FastjsonASMDeserializer_" + this.f12842h0.incrementAndGet() + "_" + cls.getSimpleName();
        Package r7 = a.class.getPackage();
        if (r7 != null) {
            String name = r7.getName();
            String str3 = name.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + "/" + str2;
            str = name + com.alibaba.android.arouter.utils.b.f12515h + str2;
            str2 = str3;
        } else {
            str = str2;
        }
        com.alibaba.fastjson.asm.c cVar = new com.alibaba.fastjson.asm.c();
        cVar.k(49, 33, str2, com.alibaba.fastjson.util.b.h(n.class), null);
        m(cVar, new C0149a(str2, jVar, hVar, 3));
        c(cVar, new C0149a(str2, jVar, hVar, 3));
        g(cVar, new C0149a(str2, jVar, hVar, 5));
        h(cVar, new C0149a(str2, jVar, hVar, 4));
        byte[] bArrJ = cVar.j();
        return (e1) this.f12841g0.a(str, bArrJ, 0, bArrJ.length).getConstructor(com.alibaba.fastjson.parser.j.class, com.alibaba.fastjson.util.h.class).newInstance(jVar, hVar);
    }
}
