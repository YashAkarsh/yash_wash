package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements kotlin.reflect.d<Object>, t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f34922b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final Map<Class<? extends kotlin.v<?>>, Integer> f34923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final HashMap<String, String> f34924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final HashMap<String, String> f34925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final HashMap<String, String> f34926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private static final Map<String, String> f34927g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Class<?> f34928a;

    public static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        @a7.e
        public final String a(@a7.d Class<?> jClass) {
            String str;
            l0.p(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String str3 = (String) u.f34926f.get(jClass.getName());
                return str3 == null ? jClass.getCanonicalName() : str3;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (str = (String) u.f34926f.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
        
            if (r2 == null) goto L13;
         */
        @a7.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String b(@a7.d java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.l0.p(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb6
            Le:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L6c
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r2 = r8.getEnclosingMethod()
                r3 = 2
                r4 = 36
                java.lang.String r5 = "name"
                if (r2 == 0) goto L43
                kotlin.jvm.internal.l0.o(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = r2.getName()
                r6.append(r2)
                r6.append(r4)
                java.lang.String r2 = r6.toString()
                java.lang.String r2 = kotlin.text.s.p5(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L40
                goto L43
            L40:
                r1 = r2
                goto Lb6
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                if (r8 == 0) goto L64
                kotlin.jvm.internal.l0.o(r0, r5)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r8.getName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r8 = r2.toString()
                java.lang.String r1 = kotlin.text.s.p5(r0, r8, r1, r3, r1)
                goto Lb6
            L64:
                kotlin.jvm.internal.l0.o(r0, r5)
                java.lang.String r1 = kotlin.text.s.o5(r0, r4, r1, r3, r1)
                goto Lb6
            L6c:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto La1
                java.lang.Class r8 = r8.getComponentType()
                boolean r0 = r8.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L9e
                java.util.Map r0 = kotlin.jvm.internal.u.z()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L9e
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r2)
                java.lang.String r8 = r0.toString()
                r1 = r8
            L9e:
                if (r1 != 0) goto Lb6
                goto L40
            La1:
                java.util.Map r0 = kotlin.jvm.internal.u.z()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb6
                java.lang.String r1 = r8.getSimpleName()
            Lb6:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.u.a.b(java.lang.Class):java.lang.String");
        }

        public final boolean c(@a7.e Object obj, @a7.d Class<?> jClass) {
            l0.p(jClass, "jClass");
            Map map = u.f34923c;
            l0.n(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return t1.B(obj, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = h5.a.g(h5.a.i(jClass));
            }
            return jClass.isInstance(obj);
        }

        private a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i7 = 0;
        List listM = kotlin.collections.y.M(i5.a.class, i5.l.class, i5.p.class, i5.q.class, i5.r.class, i5.s.class, i5.t.class, i5.u.class, i5.v.class, i5.w.class, i5.b.class, i5.c.class, i5.d.class, i5.e.class, i5.f.class, i5.g.class, i5.h.class, i5.i.class, i5.j.class, i5.k.class, i5.m.class, i5.n.class, i5.o.class);
        ArrayList arrayList = new ArrayList(kotlin.collections.z.Z(listM, 10));
        for (Object obj : listM) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            arrayList.add(kotlin.p1.a((Class) obj, Integer.valueOf(i7)));
            i7 = i8;
        }
        f34923c = kotlin.collections.c1.B0(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put(androidx.constraintlayout.core.motion.utils.w.b.f3031f, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put(androidx.constraintlayout.core.motion.utils.w.b.f3028c, "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f34924d = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put(com.alibaba.android.arouter.compiler.utils.a.f12432z, "kotlin.Boolean");
        map2.put(com.alibaba.android.arouter.compiler.utils.a.A, "kotlin.Char");
        map2.put(com.alibaba.android.arouter.compiler.utils.a.f12426t, "kotlin.Byte");
        map2.put(com.alibaba.android.arouter.compiler.utils.a.f12427u, "kotlin.Short");
        map2.put(com.alibaba.android.arouter.compiler.utils.a.f12428v, "kotlin.Int");
        map2.put(com.alibaba.android.arouter.compiler.utils.a.f12430x, "kotlin.Float");
        map2.put(com.alibaba.android.arouter.compiler.utils.a.f12429w, "kotlin.Long");
        map2.put(com.alibaba.android.arouter.compiler.utils.a.f12431y, "kotlin.Double");
        f34925e = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put(com.alibaba.android.arouter.compiler.utils.a.B, "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        l0.o(collectionValues, "primitiveFqNames.values");
        for (String kotlinName : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            l0.o(kotlinName, "kotlinName");
            sb.append(kotlin.text.c0.s5(kotlinName, ClassUtils.PACKAGE_SEPARATOR_CHAR, null, 2, null));
            sb.append("CompanionObject");
            kotlin.u0 u0VarA = kotlin.p1.a(sb.toString(), kotlinName + ".Companion");
            map3.put(u0VarA.e(), u0VarA.f());
        }
        for (Map.Entry<Class<? extends kotlin.v<?>>, Integer> entry : f34923c.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f34926f = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.b1.j(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), kotlin.text.c0.s5((String) entry2.getValue(), ClassUtils.PACKAGE_SEPARATOR_CHAR, null, 2, null));
        }
        f34927g = linkedHashMap;
    }

    public u(@a7.d Class<?> jClass) {
        l0.p(jClass, "jClass");
        this.f34928a = jClass;
    }

    private final Void A() {
        throw new h5.p();
    }

    @kotlin.g1(version = "1.3")
    public static /* synthetic */ void B() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void C() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void G() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void K() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void M() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void P() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void Q() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void S() {
    }

    @kotlin.g1(version = "1.4")
    public static /* synthetic */ void T() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void W() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void X() {
    }

    @kotlin.g1(version = "1.1")
    public static /* synthetic */ void Y() {
    }

    @kotlin.g1(version = "1.5")
    public static /* synthetic */ void a0() {
    }

    @Override // kotlin.reflect.d
    public boolean D() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public boolean E() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    @a7.e
    public String F() {
        return f34922b.b(s());
    }

    @Override // kotlin.reflect.d
    @a7.d
    public List<kotlin.reflect.s> I() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    @a7.e
    public Object L() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public boolean R() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public boolean V() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public boolean b() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public boolean e() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    @kotlin.g1(version = "1.1")
    public boolean e0(@a7.e Object obj) {
        return f34922b.c(obj, s());
    }

    @Override // kotlin.reflect.d
    public boolean equals(@a7.e Object obj) {
        return (obj instanceof u) && l0.g(h5.a.g(this), h5.a.g((kotlin.reflect.d) obj));
    }

    @Override // kotlin.reflect.d
    @a7.e
    public kotlin.reflect.w f() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.b
    @a7.d
    public List<Annotation> getAnnotations() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    @a7.d
    public List<kotlin.reflect.t> getTypeParameters() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public int hashCode() {
        return h5.a.g(this).hashCode();
    }

    @Override // kotlin.reflect.d, kotlin.reflect.h
    @a7.d
    public Collection<kotlin.reflect.c<?>> i() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public boolean isOpen() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    @a7.e
    public String j() {
        return f34922b.a(s());
    }

    @Override // kotlin.reflect.d
    @a7.d
    public Collection<kotlin.reflect.d<?>> m() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    @a7.d
    public Collection<kotlin.reflect.i<Object>> r() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.reflect.d
    public boolean r0() {
        A();
        throw new kotlin.y();
    }

    @Override // kotlin.jvm.internal.t
    @a7.d
    public Class<?> s() {
        return this.f34928a;
    }

    @Override // kotlin.reflect.d
    public boolean t() {
        A();
        throw new kotlin.y();
    }

    @a7.d
    public String toString() {
        return s().toString() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.reflect.d
    @a7.d
    public List<kotlin.reflect.d<? extends Object>> x() {
        A();
        throw new kotlin.y();
    }
}
