package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.deserializer.d2;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public class g1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g1 f13055g = new g1();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f13056h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f13057i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f13058j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f13059k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f13060l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f13061m = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f13063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f13064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.alibaba.fastjson.m f13065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.alibaba.fastjson.util.g<Type, y0> f13066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f13067f;

    public g1() {
        this(8192);
    }

    private final p0 e(f1 f1Var) throws Exception {
        p0 p0VarZ = this.f13063b.z(f1Var);
        int i7 = 0;
        while (true) {
            f0[] f0VarArr = p0VarZ.f13159k;
            if (i7 >= f0VarArr.length) {
                return p0VarZ;
            }
            Class<?> cls = f0VarArr[i7].f13029a.f13297e;
            if (cls.isEnum() && !(j(cls) instanceof d0)) {
                p0VarZ.f13082i = false;
            }
            i7++;
        }
    }

    public static g1 i() {
        return f13055g;
    }

    private y0 k(Class<?> cls, boolean z7) {
        ClassLoader classLoader;
        y0 y0VarC = this.f13066e.c(cls);
        if (y0VarC == null) {
            try {
                for (Object obj : com.alibaba.fastjson.util.j.a(n.class, Thread.currentThread().getContextClassLoader())) {
                    if (obj instanceof n) {
                        n nVar = (n) obj;
                        Iterator<Type> it = nVar.a().iterator();
                        while (it.hasNext()) {
                            p(it.next(), nVar);
                        }
                    }
                }
            } catch (ClassCastException unused) {
            }
            y0VarC = this.f13066e.c(cls);
        }
        if (y0VarC == null && (classLoader = com.alibaba.fastjson.a.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (Object obj2 : com.alibaba.fastjson.util.j.a(n.class, classLoader)) {
                    if (obj2 instanceof n) {
                        n nVar2 = (n) obj2;
                        Iterator<Type> it2 = nVar2.a().iterator();
                        while (it2.hasNext()) {
                            p(it2.next(), nVar2);
                        }
                    }
                }
            } catch (ClassCastException unused2) {
            }
            y0VarC = this.f13066e.c(cls);
        }
        if (y0VarC != null) {
            return y0VarC;
        }
        String name = cls.getName();
        if (Map.class.isAssignableFrom(cls)) {
            y0VarC = u0.f13175j;
            p(cls, y0VarC);
        } else if (List.class.isAssignableFrom(cls)) {
            y0VarC = s0.f13170a;
            p(cls, y0VarC);
        } else if (Collection.class.isAssignableFrom(cls)) {
            y0VarC = y.f13184a;
            p(cls, y0VarC);
        } else if (Date.class.isAssignableFrom(cls)) {
            y0VarC = b0.f13019a;
            p(cls, y0VarC);
        } else if (com.alibaba.fastjson.c.class.isAssignableFrom(cls)) {
            y0VarC = j0.f13084a;
            p(cls, y0VarC);
        } else if (l0.class.isAssignableFrom(cls)) {
            y0VarC = m0.f13137a;
            p(cls, y0VarC);
        } else if (com.alibaba.fastjson.j.class.isAssignableFrom(cls)) {
            y0VarC = v0.f13178b;
            p(cls, y0VarC);
        } else if (cls.isEnum()) {
            e0.d dVar = (e0.d) com.alibaba.fastjson.util.l.M(cls, e0.d.class);
            if (dVar == null || !dVar.serializeEnumAsJavaBean()) {
                y0VarC = d0.f13022a;
                p(cls, y0VarC);
            } else {
                y0VarC = g(cls);
                p(cls, y0VarC);
            }
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass != null && superclass.isEnum()) {
                e0.d dVar2 = (e0.d) com.alibaba.fastjson.util.l.M(superclass, e0.d.class);
                if (dVar2 == null || !dVar2.serializeEnumAsJavaBean()) {
                    y0VarC = d0.f13022a;
                    p(cls, y0VarC);
                } else {
                    y0VarC = g(cls);
                    p(cls, y0VarC);
                }
            } else if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                y0 lVar = new l(componentType, j(componentType));
                p(cls, lVar);
                y0VarC = lVar;
            } else {
                Class<?> cls2 = null;
                if (Throwable.class.isAssignableFrom(cls)) {
                    f1 f1VarC = com.alibaba.fastjson.util.l.c(cls, null, this.f13065d);
                    f1VarC.f13052g |= k1.WriteClassName.f13132a;
                    y0 p0Var = new p0(f1VarC);
                    p(cls, p0Var);
                    y0VarC = p0Var;
                } else if (TimeZone.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls)) {
                    y0VarC = v0.f13178b;
                    p(cls, y0VarC);
                } else if (Appendable.class.isAssignableFrom(cls)) {
                    y0VarC = k.f13106a;
                    p(cls, y0VarC);
                } else if (Charset.class.isAssignableFrom(cls)) {
                    y0VarC = o1.f13154a;
                    p(cls, y0VarC);
                } else if (Enumeration.class.isAssignableFrom(cls)) {
                    y0VarC = e0.f13024a;
                    p(cls, y0VarC);
                } else if (Calendar.class.isAssignableFrom(cls) || XMLGregorianCalendar.class.isAssignableFrom(cls)) {
                    y0VarC = u.f13173b;
                    p(cls, y0VarC);
                } else if (Clob.class.isAssignableFrom(cls)) {
                    y0VarC = x.f13182a;
                    p(cls, y0VarC);
                } else if (com.alibaba.fastjson.util.l.j0(cls)) {
                    y0VarC = o1.f13154a;
                    p(cls, y0VarC);
                } else if (Iterator.class.isAssignableFrom(cls)) {
                    y0VarC = v0.f13178b;
                    p(cls, y0VarC);
                } else {
                    int i7 = 0;
                    if (name.startsWith("java.awt.") && o.k(cls) && !f13056h) {
                        try {
                            String[] strArr = {"java.awt.Color", "java.awt.Font", "java.awt.Point", "java.awt.Rectangle"};
                            for (int i8 = 0; i8 < 4; i8++) {
                                String str = strArr[i8];
                                if (str.equals(name)) {
                                    Type cls3 = Class.forName(str);
                                    y0VarC = o.f13153a;
                                    p(cls3, y0VarC);
                                    return y0VarC;
                                }
                            }
                        } catch (Throwable unused3) {
                            f13056h = true;
                        }
                    }
                    if (!f13057i && (name.startsWith("java.time.") || name.startsWith("java.util.Optional") || name.equals("java.util.concurrent.atomic.LongAdder") || name.equals("java.util.concurrent.atomic.DoubleAdder"))) {
                        try {
                            String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                            for (int i9 = 0; i9 < 11; i9++) {
                                String str2 = strArr2[i9];
                                if (str2.equals(name)) {
                                    Type cls4 = Class.forName(str2);
                                    y0 y0Var = com.alibaba.fastjson.parser.deserializer.b1.f12852a;
                                    p(cls4, y0Var);
                                    return y0Var;
                                }
                            }
                            String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                            for (int i10 = 0; i10 < 4; i10++) {
                                String str3 = strArr3[i10];
                                if (str3.equals(name)) {
                                    Type cls5 = Class.forName(str3);
                                    y0 y0Var2 = d2.f12879a;
                                    p(cls5, y0Var2);
                                    return y0Var2;
                                }
                            }
                            String[] strArr4 = {"java.util.concurrent.atomic.LongAdder", "java.util.concurrent.atomic.DoubleAdder"};
                            for (int i11 = 0; i11 < 2; i11++) {
                                String str4 = strArr4[i11];
                                if (str4.equals(name)) {
                                    Type cls6 = Class.forName(str4);
                                    y0 y0Var3 = h.f13068a;
                                    p(cls6, y0Var3);
                                    return y0Var3;
                                }
                            }
                        } catch (Throwable unused4) {
                            f13057i = true;
                        }
                    }
                    if (!f13058j && name.startsWith("oracle.sql.")) {
                        try {
                            String[] strArr5 = {"oracle.sql.DATE", "oracle.sql.TIMESTAMP"};
                            for (int i12 = 0; i12 < 2; i12++) {
                                String str5 = strArr5[i12];
                                if (str5.equals(name)) {
                                    Type cls7 = Class.forName(str5);
                                    y0VarC = b0.f13019a;
                                    p(cls7, y0VarC);
                                    return y0VarC;
                                }
                            }
                        } catch (Throwable unused5) {
                            f13058j = true;
                        }
                    }
                    if (!f13059k && name.equals("springfox.documentation.spring.web.json.Json")) {
                        try {
                            Type cls8 = Class.forName("springfox.documentation.spring.web.json.Json");
                            y0VarC = g0.a.f33977a;
                            p(cls8, y0VarC);
                            return y0VarC;
                        } catch (ClassNotFoundException unused6) {
                            f13059k = true;
                        }
                    }
                    if (!f13060l && name.startsWith("com.google.common.collect.")) {
                        try {
                            String[] strArr6 = {"com.google.common.collect.HashMultimap", "com.google.common.collect.LinkedListMultimap", "com.google.common.collect.ArrayListMultimap", "com.google.common.collect.TreeMultimap"};
                            for (int i13 = 0; i13 < 4; i13++) {
                                String str6 = strArr6[i13];
                                if (str6.equals(name)) {
                                    Type cls9 = Class.forName(str6);
                                    y0VarC = h0.f13069a;
                                    p(cls9, y0VarC);
                                    return y0VarC;
                                }
                            }
                        } catch (ClassNotFoundException unused7) {
                            f13060l = true;
                        }
                    }
                    if (!f13061m && name.equals("net.sf.json.JSONNull")) {
                        try {
                            Type cls10 = Class.forName("net.sf.json.JSONNull");
                            y0VarC = v0.f13178b;
                            p(cls10, y0VarC);
                            return y0VarC;
                        } catch (ClassNotFoundException unused8) {
                            f13061m = true;
                        }
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                        return j.f13083a;
                    }
                    if (com.alibaba.fastjson.util.l.k0(cls)) {
                        y0 y0VarJ = j(cls.getSuperclass());
                        p(cls, y0VarJ);
                        return y0VarJ;
                    }
                    if (Proxy.isProxyClass(cls)) {
                        if (interfaces.length != 2) {
                            int length = interfaces.length;
                            Class<?> cls11 = null;
                            while (true) {
                                if (i7 >= length) {
                                    cls2 = cls11;
                                    break;
                                }
                                Class<?> cls12 = interfaces[i7];
                                if (!cls12.getName().startsWith("org.springframework.aop.")) {
                                    if (cls11 != null) {
                                        break;
                                    }
                                    cls11 = cls12;
                                }
                                i7++;
                            }
                        } else {
                            cls2 = interfaces[1];
                        }
                        if (cls2 != null) {
                            y0 y0VarJ2 = j(cls2);
                            p(cls, y0VarJ2);
                            return y0VarJ2;
                        }
                    }
                    if (z7) {
                        y0VarC = g(cls);
                        p(cls, y0VarC);
                    }
                }
            }
        }
        return y0VarC == null ? this.f13066e.c(cls) : y0VarC;
    }

    private void m() {
        p(Boolean.class, t.f13171a);
        p(Character.class, w.f13181a);
        p(Byte.class, i0.f13073a);
        p(Short.class, i0.f13073a);
        p(Integer.class, i0.f13073a);
        p(Long.class, t0.f13172a);
        p(Float.class, g0.f13053b);
        p(Double.class, c0.f13020b);
        p(BigDecimal.class, r.f13166a);
        p(BigInteger.class, s.f13169a);
        p(String.class, n1.f13152a);
        p(byte[].class, a1.f13018a);
        p(short[].class, a1.f13018a);
        p(int[].class, a1.f13018a);
        p(long[].class, a1.f13018a);
        p(float[].class, a1.f13018a);
        p(double[].class, a1.f13018a);
        p(boolean[].class, a1.f13018a);
        p(char[].class, a1.f13018a);
        p(Object[].class, x0.f13183a);
        v0 v0Var = v0.f13178b;
        p(Class.class, v0Var);
        p(SimpleDateFormat.class, v0Var);
        p(Currency.class, new v0());
        p(TimeZone.class, v0Var);
        p(InetAddress.class, v0Var);
        p(Inet4Address.class, v0Var);
        p(Inet6Address.class, v0Var);
        p(InetSocketAddress.class, v0Var);
        p(File.class, v0Var);
        k kVar = k.f13106a;
        p(Appendable.class, kVar);
        p(StringBuffer.class, kVar);
        p(StringBuilder.class, kVar);
        o1 o1Var = o1.f13154a;
        p(Charset.class, o1Var);
        p(Pattern.class, o1Var);
        p(Locale.class, o1Var);
        p(URI.class, o1Var);
        p(URL.class, o1Var);
        p(UUID.class, o1Var);
        m mVar = m.f13136a;
        p(AtomicBoolean.class, mVar);
        p(AtomicInteger.class, mVar);
        p(AtomicLong.class, mVar);
        d1 d1Var = d1.f13023a;
        p(AtomicReference.class, d1Var);
        p(AtomicIntegerArray.class, mVar);
        p(AtomicLongArray.class, mVar);
        p(WeakReference.class, d1Var);
        p(SoftReference.class, d1Var);
        p(LinkedList.class, y.f13184a);
    }

    public void a(Class<?> cls, h1 h1Var) {
        Object objJ = j(cls);
        if (objJ instanceof i1) {
            i1 i1Var = (i1) objJ;
            if (this == f13055g || i1Var != u0.f13175j) {
                i1Var.b(h1Var);
                return;
            }
            u0 u0Var = new u0();
            p(cls, u0Var);
            u0Var.b(h1Var);
        }
    }

    public void b() {
        this.f13066e.a();
        m();
    }

    public void c(Class<?> cls, k1 k1Var, boolean z7) {
        y0 y0VarK = k(cls, false);
        if (y0VarK == null) {
            f1 f1VarC = com.alibaba.fastjson.util.l.c(cls, null, this.f13065d);
            if (z7) {
                f1VarC.f13052g = k1Var.f13132a | f1VarC.f13052g;
            } else {
                f1VarC.f13052g = (~k1Var.f13132a) & f1VarC.f13052g;
            }
            p(cls, f(f1VarC));
            return;
        }
        if (y0VarK instanceof p0) {
            f1 f1Var = ((p0) y0VarK).f13160l;
            int i7 = f1Var.f13052g;
            if (z7) {
                f1Var.f13052g = k1Var.f13132a | i7;
            } else {
                f1Var.f13052g = (~k1Var.f13132a) & i7;
            }
            if (i7 == f1Var.f13052g || y0VarK.getClass() == p0.class) {
                return;
            }
            p(cls, f(f1Var));
        }
    }

    public void d(Class<? extends Enum>... clsArr) {
        for (Class<? extends Enum> cls : clsArr) {
            p(cls, g(cls));
        }
    }

    public y0 f(f1 f1Var) {
        Method method;
        e0.d dVar = f1Var.f13049d;
        boolean z7 = true;
        boolean z8 = this.f13062a && !this.f13067f;
        if (dVar != null) {
            Class<?> clsSerializer = dVar.serializer();
            if (clsSerializer != Void.class) {
                try {
                    Object objNewInstance = clsSerializer.newInstance();
                    if (objNewInstance instanceof y0) {
                        return (y0) objNewInstance;
                    }
                } catch (Throwable unused) {
                }
            }
            if (!dVar.asm()) {
                z8 = false;
            }
            for (k1 k1Var : dVar.serialzeFeatures()) {
                if (k1.WriteNonStringValueAsString == k1Var || k1.WriteEnumUsingToString == k1Var || k1.NotWriteDefaultValue == k1Var || k1.BrowserCompatible == k1Var) {
                    z8 = false;
                    break;
                }
            }
        }
        Class<?> cls = f1Var.f13046a;
        if (!Modifier.isPublic(cls.getModifiers())) {
            return new p0(f1Var);
        }
        if ((z8 && this.f13063b.f13001g0.c(cls)) || cls == Serializable.class || cls == Object.class) {
            z8 = false;
        }
        if (z8 && !com.alibaba.fastjson.util.b.a(cls.getSimpleName())) {
            z8 = false;
        }
        if (z8 && f1Var.f13046a.isInterface()) {
            z8 = false;
        }
        if (!z8) {
            z7 = z8;
            break;
        }
        com.alibaba.fastjson.util.e[] eVarArr = f1Var.f13050e;
        int length = eVarArr.length;
        int i7 = 0;
        while (true) {
            if (i7 < length) {
                com.alibaba.fastjson.util.e eVar = eVarArr[i7];
                Field field = eVar.f13295c;
                if ((field == null || field.getType().equals(eVar.f13297e)) && ((method = eVar.f13294b) == null || method.getReturnType().equals(eVar.f13297e))) {
                    e0.b bVarE = eVar.e();
                    if (bVarE != null) {
                        String str = bVarE.format();
                        if ((str.length() == 0 || (eVar.f13297e == String.class && "trim".equals(str))) && com.alibaba.fastjson.util.b.a(bVarE.name()) && !bVarE.jsonDirect() && bVarE.serializeUsing() == Void.class && !bVarE.unwrapped()) {
                            for (k1 k1Var2 : bVarE.serialzeFeatures()) {
                                if (k1.WriteNonStringValueAsString == k1Var2 || k1.WriteEnumUsingToString == k1Var2 || k1.NotWriteDefaultValue == k1Var2 || k1.BrowserCompatible == k1Var2 || k1.WriteClassName == k1Var2) {
                                    z8 = false;
                                    break;
                                }
                            }
                            if (com.alibaba.fastjson.util.l.c0(method) || com.alibaba.fastjson.util.l.b0(method)) {
                                break;
                            }
                        }
                    }
                    i7++;
                }
                z7 = false;
                break;
            }
            z7 = z8;
            break;
        }
        if (z7) {
            try {
                p0 p0VarE = e(f1Var);
                if (p0VarE != null) {
                    return p0VarE;
                }
            } catch (ClassCastException | ClassFormatError | ClassNotFoundException unused2) {
            } catch (Throwable th) {
                throw new com.alibaba.fastjson.d("create asm serializer error, class " + cls, th);
            }
        }
        return new p0(f1Var);
    }

    public final y0 g(Class<?> cls) {
        f1 f1VarD = com.alibaba.fastjson.util.l.d(cls, null, this.f13065d, this.f13067f);
        return (f1VarD.f13050e.length == 0 && Iterable.class.isAssignableFrom(cls)) ? v0.f13178b : f(f1VarD);
    }

    public final y0 h(Type type) {
        return this.f13066e.c(type);
    }

    public y0 j(Class<?> cls) {
        return k(cls, true);
    }

    public String l() {
        return this.f13064c;
    }

    public boolean n() {
        return this.f13062a;
    }

    public boolean o(Object obj, Object obj2) {
        return p((Type) obj, (y0) obj2);
    }

    public boolean p(Type type, y0 y0Var) {
        return this.f13066e.d(type, y0Var);
    }

    public void q(boolean z7) {
        if (com.alibaba.fastjson.util.b.f13259b) {
            return;
        }
        this.f13062a = z7;
    }

    public void r(com.alibaba.fastjson.m mVar) {
        this.f13065d = mVar;
    }

    public void s(String str) {
        this.f13064c = str;
    }

    public g1(boolean z7) {
        this(8192, z7);
    }

    public g1(int i7) {
        this(i7, false);
    }

    public g1(int i7, boolean z7) {
        this.f13062a = !com.alibaba.fastjson.util.b.f13259b;
        this.f13064c = com.alibaba.fastjson.a.f12529c;
        this.f13067f = z7;
        this.f13066e = new com.alibaba.fastjson.util.g<>(i7);
        try {
            if (this.f13062a) {
                this.f13063b = new a();
            }
        } catch (Throwable unused) {
            this.f13062a = false;
        }
        m();
    }
}
