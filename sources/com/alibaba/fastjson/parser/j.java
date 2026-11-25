package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.m;
import com.alibaba.fastjson.parser.deserializer.b1;
import com.alibaba.fastjson.parser.deserializer.c1;
import com.alibaba.fastjson.parser.deserializer.d1;
import com.alibaba.fastjson.parser.deserializer.d2;
import com.alibaba.fastjson.parser.deserializer.e1;
import com.alibaba.fastjson.parser.deserializer.f2;
import com.alibaba.fastjson.parser.deserializer.g2;
import com.alibaba.fastjson.parser.deserializer.i2;
import com.alibaba.fastjson.parser.deserializer.j2;
import com.alibaba.fastjson.parser.deserializer.k2;
import com.alibaba.fastjson.parser.deserializer.l2;
import com.alibaba.fastjson.parser.deserializer.n;
import com.alibaba.fastjson.parser.deserializer.o;
import com.alibaba.fastjson.serializer.b0;
import com.alibaba.fastjson.serializer.g0;
import com.alibaba.fastjson.serializer.i0;
import com.alibaba.fastjson.serializer.n1;
import com.alibaba.fastjson.serializer.r;
import com.alibaba.fastjson.serializer.s;
import com.alibaba.fastjson.serializer.t;
import com.alibaba.fastjson.serializer.t0;
import com.alibaba.fastjson.serializer.u;
import com.alibaba.fastjson.serializer.v;
import com.alibaba.fastjson.serializer.v0;
import com.alibaba.fastjson.serializer.w;
import com.alibaba.fastjson.serializer.x0;
import com.alibaba.fastjson.serializer.y;
import com.alibaba.fastjson.util.l;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12971m = "fastjson.parser.autoTypeAccept";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f12974p;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static j f12976r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static boolean f12977s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static boolean f12978t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.alibaba.fastjson.util.g<Type, e1> f12979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f12980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f12981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public m f12982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ClassLoader f12983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.alibaba.fastjson.parser.deserializer.a f12984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long[] f12986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long[] f12987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f12988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f12989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12970l = "fastjson.parser.deny";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f12973o = C(com.alibaba.fastjson.util.f.l(f12970l));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f12972n = "fastjson.parser.autoTypeSupport";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f12975q = "true".equals(com.alibaba.fastjson.util.f.l(f12972n));

    static {
        String[] strArrC = C(com.alibaba.fastjson.util.f.l(f12971m));
        if (strArrC == null) {
            strArrC = new String[0];
        }
        f12974p = strArrC;
        f12976r = new j();
        f12977s = false;
        f12978t = false;
    }

    public j() {
        this(false);
    }

    private static String[] C(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(",");
    }

    private void c(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            a(str);
        }
    }

    private void d(String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            b(str);
        }
    }

    public static Field p(String str, Map<String, Field> map) {
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field != null) {
            return field;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt >= 'a' && cCharAt <= 'z') {
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            field = map.get(new String(charArray));
        }
        if (str.length() <= 2) {
            return field;
        }
        char cCharAt2 = str.charAt(1);
        if (str.length() <= 2 || cCharAt < 'a' || cCharAt > 'z' || cCharAt2 < 'A' || cCharAt2 > 'Z') {
            return field;
        }
        for (Map.Entry<String, Field> entry : map.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return field;
    }

    public static j q() {
        return f12976r;
    }

    private void r() {
        com.alibaba.fastjson.util.g<Type, e1> gVar = this.f12979a;
        v0 v0Var = v0.f13178b;
        gVar.d(SimpleDateFormat.class, v0Var);
        this.f12979a.d(Timestamp.class, i2.f12894c);
        this.f12979a.d(Date.class, i2.f12893b);
        this.f12979a.d(Time.class, l2.f12900a);
        this.f12979a.d(java.util.Date.class, b0.f13019a);
        com.alibaba.fastjson.util.g<Type, e1> gVar2 = this.f12979a;
        u uVar = u.f13173b;
        gVar2.d(Calendar.class, uVar);
        this.f12979a.d(XMLGregorianCalendar.class, uVar);
        this.f12979a.d(com.alibaba.fastjson.e.class, c1.f12877a);
        com.alibaba.fastjson.util.g<Type, e1> gVar3 = this.f12979a;
        y yVar = y.f13184a;
        gVar3.d(com.alibaba.fastjson.b.class, yVar);
        this.f12979a.d(Map.class, c1.f12877a);
        this.f12979a.d(HashMap.class, c1.f12877a);
        this.f12979a.d(LinkedHashMap.class, c1.f12877a);
        this.f12979a.d(TreeMap.class, c1.f12877a);
        this.f12979a.d(ConcurrentMap.class, c1.f12877a);
        this.f12979a.d(ConcurrentHashMap.class, c1.f12877a);
        this.f12979a.d(Collection.class, yVar);
        this.f12979a.d(List.class, yVar);
        this.f12979a.d(ArrayList.class, yVar);
        com.alibaba.fastjson.util.g<Type, e1> gVar4 = this.f12979a;
        o oVar = o.f12912a;
        gVar4.d(Object.class, oVar);
        this.f12979a.d(String.class, n1.f13152a);
        this.f12979a.d(StringBuffer.class, n1.f13152a);
        this.f12979a.d(StringBuilder.class, n1.f13152a);
        com.alibaba.fastjson.util.g<Type, e1> gVar5 = this.f12979a;
        Class cls = Character.TYPE;
        w wVar = w.f13181a;
        gVar5.d(cls, wVar);
        this.f12979a.d(Character.class, wVar);
        com.alibaba.fastjson.util.g<Type, e1> gVar6 = this.f12979a;
        Class cls2 = Byte.TYPE;
        d1 d1Var = d1.f12878a;
        gVar6.d(cls2, d1Var);
        this.f12979a.d(Byte.class, d1Var);
        this.f12979a.d(Short.TYPE, d1Var);
        this.f12979a.d(Short.class, d1Var);
        this.f12979a.d(Integer.TYPE, i0.f13073a);
        this.f12979a.d(Integer.class, i0.f13073a);
        this.f12979a.d(Long.TYPE, t0.f13172a);
        this.f12979a.d(Long.class, t0.f13172a);
        this.f12979a.d(BigInteger.class, s.f13169a);
        this.f12979a.d(BigDecimal.class, r.f13166a);
        this.f12979a.d(Float.TYPE, g0.f13053b);
        this.f12979a.d(Float.class, g0.f13053b);
        this.f12979a.d(Double.TYPE, d1Var);
        this.f12979a.d(Double.class, d1Var);
        com.alibaba.fastjson.util.g<Type, e1> gVar7 = this.f12979a;
        Class cls3 = Boolean.TYPE;
        t tVar = t.f13171a;
        gVar7.d(cls3, tVar);
        this.f12979a.d(Boolean.class, tVar);
        this.f12979a.d(Class.class, v0Var);
        this.f12979a.d(char[].class, new v());
        this.f12979a.d(AtomicBoolean.class, tVar);
        this.f12979a.d(AtomicInteger.class, i0.f13073a);
        this.f12979a.d(AtomicLong.class, t0.f13172a);
        com.alibaba.fastjson.util.g<Type, e1> gVar8 = this.f12979a;
        com.alibaba.fastjson.serializer.d1 d1Var2 = com.alibaba.fastjson.serializer.d1.f13023a;
        gVar8.d(AtomicReference.class, d1Var2);
        this.f12979a.d(WeakReference.class, d1Var2);
        this.f12979a.d(SoftReference.class, d1Var2);
        this.f12979a.d(UUID.class, v0Var);
        this.f12979a.d(TimeZone.class, v0Var);
        this.f12979a.d(Locale.class, v0Var);
        this.f12979a.d(Currency.class, v0Var);
        this.f12979a.d(Inet4Address.class, v0Var);
        this.f12979a.d(Inet6Address.class, v0Var);
        this.f12979a.d(InetSocketAddress.class, v0Var);
        this.f12979a.d(File.class, v0Var);
        this.f12979a.d(URI.class, v0Var);
        this.f12979a.d(URL.class, v0Var);
        this.f12979a.d(Pattern.class, v0Var);
        this.f12979a.d(Charset.class, v0Var);
        this.f12979a.d(com.alibaba.fastjson.g.class, v0Var);
        this.f12979a.d(Number.class, d1Var);
        com.alibaba.fastjson.util.g<Type, e1> gVar9 = this.f12979a;
        com.alibaba.fastjson.serializer.m mVar = com.alibaba.fastjson.serializer.m.f13136a;
        gVar9.d(AtomicIntegerArray.class, mVar);
        this.f12979a.d(AtomicLongArray.class, mVar);
        this.f12979a.d(StackTraceElement.class, j2.f12896a);
        this.f12979a.d(Serializable.class, oVar);
        this.f12979a.d(Cloneable.class, oVar);
        this.f12979a.d(Comparable.class, oVar);
        this.f12979a.d(Closeable.class, oVar);
        this.f12979a.d(com.alibaba.fastjson.f.class, new com.alibaba.fastjson.parser.deserializer.m());
    }

    public static boolean w(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == java.util.Date.class || cls == Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void x(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) {
            return;
        }
        x(cls.getSuperclass(), map);
    }

    public void A(boolean z7) {
        this.f12985g = z7;
    }

    public void B(ClassLoader classLoader) {
        this.f12983e = classLoader;
    }

    public void a(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jK = l.K(str);
        if (Arrays.binarySearch(this.f12987i, jK) >= 0) {
            return;
        }
        long[] jArr = this.f12987i;
        int length = jArr.length + 1;
        long[] jArr2 = new long[length];
        jArr2[length - 1] = jK;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f12987i = jArr2;
    }

    public void b(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        long jK = l.K(str);
        if (Arrays.binarySearch(this.f12986h, jK) >= 0) {
            return;
        }
        long[] jArr = this.f12986h;
        int length = jArr.length + 1;
        long[] jArr2 = new long[length];
        jArr2[length - 1] = jK;
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Arrays.sort(jArr2);
        this.f12986h = jArr2;
    }

    public Class<?> e(String str, Class<?> cls) {
        return f(str, cls, com.alibaba.fastjson.a.f12532f);
    }

    public Class<?> f(String str, Class<?> cls, int i7) throws Throwable {
        Class<?> clsO0;
        long j7;
        String str2;
        InputStream inputStream;
        boolean z7;
        InputStream inputStream2;
        boolean zC;
        if (str == null) {
            return null;
        }
        if (str.length() >= 128 || str.length() < 3) {
            throw new com.alibaba.fastjson.d("autoType is not support. " + str);
        }
        boolean z8 = (cls == null || cls == Object.class || cls == Serializable.class || cls == Cloneable.class || cls == Closeable.class || cls == EventListener.class || cls == Iterable.class || cls == Collection.class) ? false : true;
        String strReplace = str.replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);
        long jCharAt = (((long) strReplace.charAt(0)) ^ (-3750763034362895579L)) * 1099511628211L;
        if (jCharAt == -5808493101479473382L) {
            throw new com.alibaba.fastjson.d("autoType is not support. " + str);
        }
        String str3 = "autoType is not support. ";
        if ((((long) strReplace.charAt(strReplace.length() - 1)) ^ jCharAt) * 1099511628211L == 655701488918567152L) {
            throw new com.alibaba.fastjson.d(str3 + str);
        }
        long jCharAt2 = (((((((long) strReplace.charAt(0)) ^ (-3750763034362895579L)) * 1099511628211L) ^ ((long) strReplace.charAt(1))) * 1099511628211L) ^ ((long) strReplace.charAt(2))) * 1099511628211L;
        if (this.f12985g || z8) {
            long jCharAt3 = jCharAt2;
            int i8 = 3;
            clsO0 = null;
            while (i8 < strReplace.length()) {
                long j8 = jCharAt2;
                jCharAt3 = (((long) strReplace.charAt(i8)) ^ jCharAt3) * 1099511628211L;
                if (Arrays.binarySearch(this.f12987i, jCharAt3) >= 0 && (clsO0 = l.o0(str, this.f12983e, true)) != null) {
                    return clsO0;
                }
                if (Arrays.binarySearch(this.f12986h, jCharAt3) >= 0 && l.O(str) == null) {
                    throw new com.alibaba.fastjson.d(str3 + str);
                }
                i8++;
                str3 = str3;
                jCharAt2 = j8;
            }
            j7 = jCharAt2;
            str2 = str3;
        } else {
            j7 = jCharAt2;
            str2 = str3;
            clsO0 = null;
        }
        if (clsO0 == null) {
            clsO0 = l.O(str);
        }
        if (clsO0 == null) {
            clsO0 = this.f12979a.b(str);
        }
        if (clsO0 != null) {
            if (cls == null || clsO0 == HashMap.class || cls.isAssignableFrom(clsO0)) {
                return clsO0;
            }
            throw new com.alibaba.fastjson.d("type not match. " + str + " -> " + cls.getName());
        }
        if (!this.f12985g) {
            int i9 = 3;
            while (i9 < strReplace.length()) {
                long jCharAt4 = (j7 ^ ((long) strReplace.charAt(i9))) * 1099511628211L;
                if (Arrays.binarySearch(this.f12986h, jCharAt4) >= 0) {
                    throw new com.alibaba.fastjson.d(str2 + str);
                }
                if (Arrays.binarySearch(this.f12987i, jCharAt4) >= 0) {
                    if (clsO0 == null) {
                        clsO0 = l.o0(str, this.f12983e, true);
                    }
                    if (cls == null || !cls.isAssignableFrom(clsO0)) {
                        return clsO0;
                    }
                    throw new com.alibaba.fastjson.d("type not match. " + str + " -> " + cls.getName());
                }
                i9++;
                j7 = jCharAt4;
            }
        }
        try {
            String str4 = str.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ".class";
            ClassLoader classLoader = this.f12983e;
            InputStream resourceAsStream = classLoader != null ? classLoader.getResourceAsStream(str4) : j.class.getClassLoader().getResourceAsStream(str4);
            if (resourceAsStream != null) {
                try {
                    try {
                        com.alibaba.fastjson.asm.b bVar = new com.alibaba.fastjson.asm.b(resourceAsStream, true);
                        z7 = false;
                        try {
                            com.alibaba.fastjson.asm.l lVar = new com.alibaba.fastjson.asm.l("<clinit>", new Class[0]);
                            bVar.a(lVar);
                            zC = lVar.c();
                        } catch (Exception unused) {
                            inputStream2 = resourceAsStream;
                            com.alibaba.fastjson.util.f.a(inputStream2);
                            zC = z7;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = resourceAsStream;
                        com.alibaba.fastjson.util.f.a(inputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    z7 = false;
                }
            } else {
                z7 = false;
                zC = false;
            }
            com.alibaba.fastjson.util.f.a(resourceAsStream);
        } catch (Exception unused3) {
            z7 = false;
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        int i10 = c.SupportAutoType.f12829a;
        boolean z9 = (!this.f12985g && (i7 & i10) == 0 && (i10 & com.alibaba.fastjson.a.f12532f) == 0) ? z7 : true;
        if (clsO0 == null && (z9 || zC || z8)) {
            if (z9 || zC) {
                z7 = true;
            }
            clsO0 = l.o0(str, this.f12983e, z7);
        }
        if (clsO0 != null) {
            if (zC) {
                l.b(str, clsO0);
                return clsO0;
            }
            if (ClassLoader.class.isAssignableFrom(clsO0) || DataSource.class.isAssignableFrom(clsO0)) {
                throw new com.alibaba.fastjson.d(str2 + str);
            }
            if (cls != null) {
                if (cls.isAssignableFrom(clsO0)) {
                    l.b(str, clsO0);
                    return clsO0;
                }
                throw new com.alibaba.fastjson.d("type not match. " + str + " -> " + cls.getName());
            }
            if (com.alibaba.fastjson.util.h.b(clsO0, clsO0, this.f12982d).f13344d != null && z9) {
                throw new com.alibaba.fastjson.d(str2 + str);
            }
        }
        if (z9) {
            if (clsO0 != null) {
                l.b(str, clsO0);
            }
            return clsO0;
        }
        throw new com.alibaba.fastjson.d(str2 + str);
    }

    public void g() {
        this.f12979a.a();
        r();
    }

    public void h(Properties properties) {
        d(C(properties.getProperty(f12970l)));
        c(C(properties.getProperty(f12971m)));
        String property = properties.getProperty(f12972n);
        if ("true".equals(property)) {
            this.f12985g = true;
        } else if (com.paytm.pgsdk.d.G.equals(property)) {
            this.f12985g = false;
        }
    }

    public com.alibaba.fastjson.parser.deserializer.k i(j jVar, com.alibaba.fastjson.util.h hVar, com.alibaba.fastjson.util.e eVar) {
        Class<?> clsDeserializeUsing;
        Class<?> cls = hVar.f13341a;
        Class<?> cls2 = eVar.f13297e;
        e0.b bVarE = eVar.e();
        Class<?> cls3 = null;
        if (bVarE != null && (clsDeserializeUsing = bVarE.deserializeUsing()) != Void.class) {
            cls3 = clsDeserializeUsing;
        }
        return (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) ? new com.alibaba.fastjson.parser.deserializer.c(jVar, cls, eVar) : new com.alibaba.fastjson.parser.deserializer.f(jVar, cls, eVar);
    }

    public e1 j(Class<?> cls, Type type) {
        e0.b bVarE;
        Method method;
        com.alibaba.fastjson.parser.deserializer.a aVar;
        boolean zA = this.f12980b & (!this.f12988j);
        if (zA) {
            e0.d dVar = (e0.d) l.M(cls, e0.d.class);
            if (dVar != null) {
                Class<?> clsDeserializer = dVar.deserializer();
                if (clsDeserializer != Void.class) {
                    try {
                        Object objNewInstance = clsDeserializer.newInstance();
                        if (objNewInstance instanceof e1) {
                            return (e1) objNewInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                zA = dVar.asm();
            }
            if (zA) {
                Class<?> clsF = com.alibaba.fastjson.util.h.f(cls, dVar);
                if (clsF == null) {
                    clsF = cls;
                }
                do {
                    if (!Modifier.isPublic(clsF.getModifiers())) {
                        zA = false;
                        break;
                    }
                    clsF = clsF.getSuperclass();
                    if (clsF == Object.class) {
                        break;
                    }
                } while (clsF != null);
            }
        }
        if (cls.getTypeParameters().length != 0) {
            zA = false;
        }
        if (zA && (aVar = this.f12984f) != null && aVar.f12841g0.c(cls)) {
            zA = false;
        }
        if (zA) {
            zA = com.alibaba.fastjson.util.b.a(cls.getSimpleName());
        }
        if (zA) {
            if (cls.isInterface()) {
                zA = false;
            }
            com.alibaba.fastjson.util.h hVarB = com.alibaba.fastjson.util.h.b(cls, type, this.f12982d);
            if (zA && hVarB.f13348h.length > 200) {
                zA = false;
            }
            Constructor<?> constructor = hVarB.f13343c;
            if (zA && constructor == null && !cls.isInterface()) {
                zA = false;
            }
            for (com.alibaba.fastjson.util.e eVar : hVarB.f13348h) {
                if (!eVar.f13300h) {
                    Class<?> cls2 = eVar.f13297e;
                    if (Modifier.isPublic(cls2.getModifiers()) && ((!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) && ((eVar.k() == null || com.alibaba.fastjson.util.b.a(eVar.k().getName())) && (((bVarE = eVar.e()) == null || (com.alibaba.fastjson.util.b.a(bVarE.name()) && bVarE.format().length() == 0 && bVarE.deserializeUsing() == Void.class && !bVarE.unwrapped())) && (((method = eVar.f13294b) == null || method.getParameterTypes().length <= 1) && (!cls2.isEnum() || (n(cls2) instanceof com.alibaba.fastjson.parser.deserializer.g))))))) {
                    }
                }
                zA = false;
                break;
            }
        }
        if (!((zA && cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) ? false : zA)) {
            return new n(this, cls, type);
        }
        com.alibaba.fastjson.util.h hVarB2 = com.alibaba.fastjson.util.h.b(cls, type, this.f12982d);
        try {
            return this.f12984f.v(this, hVarB2);
        } catch (com.alibaba.fastjson.d unused2) {
            return new n(this, hVarB2);
        } catch (NoSuchMethodException unused3) {
            return new n(this, cls, type);
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("create asm deserializer error, " + cls.getName(), e8);
        }
    }

    public ClassLoader k() {
        return this.f12983e;
    }

    public e1 l(com.alibaba.fastjson.util.e eVar) {
        return m(eVar.f13297e, eVar.f13298f);
    }

    public e1 m(Class<?> cls, Type type) {
        e1 e1VarJ;
        Class<?> clsMappingTo;
        Type type2 = type;
        e1 e1VarC = this.f12979a.c(type2);
        if (e1VarC != null) {
            return e1VarC;
        }
        if (type2 == null) {
            type2 = cls;
        }
        e1 e1VarC2 = this.f12979a.c(type2);
        if (e1VarC2 != null) {
            return e1VarC2;
        }
        e0.d dVar = (e0.d) l.M(cls, e0.d.class);
        if (dVar != null && (clsMappingTo = dVar.mappingTo()) != Void.class) {
            return m(clsMappingTo, clsMappingTo);
        }
        if ((type2 instanceof WildcardType) || (type2 instanceof TypeVariable) || (type2 instanceof ParameterizedType)) {
            e1VarC2 = this.f12979a.c(cls);
        }
        if (e1VarC2 != null) {
            return e1VarC2;
        }
        String strReplace = cls.getName().replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);
        int i7 = 0;
        if (strReplace.startsWith("java.awt.") && com.alibaba.fastjson.serializer.o.k(cls) && !f12977s) {
            String[] strArr = {"java.awt.Point", "java.awt.Font", "java.awt.Rectangle", "java.awt.Color"};
            for (int i8 = 0; i8 < 4; i8++) {
                try {
                    String str = strArr[i8];
                    if (str.equals(strReplace)) {
                        com.alibaba.fastjson.util.g<Type, e1> gVar = this.f12979a;
                        Class<?> cls2 = Class.forName(str);
                        com.alibaba.fastjson.serializer.o oVar = com.alibaba.fastjson.serializer.o.f13153a;
                        gVar.d(cls2, oVar);
                        return oVar;
                    }
                } catch (Throwable unused) {
                    f12977s = true;
                }
            }
            e1VarC2 = com.alibaba.fastjson.serializer.o.f13153a;
        }
        if (!f12978t) {
            try {
                if (strReplace.startsWith("java.time.")) {
                    String[] strArr2 = {"java.time.LocalDateTime", "java.time.LocalDate", "java.time.LocalTime", "java.time.ZonedDateTime", "java.time.OffsetDateTime", "java.time.OffsetTime", "java.time.ZoneOffset", "java.time.ZoneRegion", "java.time.ZoneId", "java.time.Period", "java.time.Duration", "java.time.Instant"};
                    while (i7 < 12) {
                        String str2 = strArr2[i7];
                        if (str2.equals(strReplace)) {
                            com.alibaba.fastjson.util.g<Type, e1> gVar2 = this.f12979a;
                            Class<?> cls3 = Class.forName(str2);
                            b1 b1Var = b1.f12852a;
                            gVar2.d(cls3, b1Var);
                            return b1Var;
                        }
                        i7++;
                    }
                } else if (strReplace.startsWith("java.util.Optional")) {
                    String[] strArr3 = {"java.util.Optional", "java.util.OptionalDouble", "java.util.OptionalInt", "java.util.OptionalLong"};
                    while (i7 < 4) {
                        String str3 = strArr3[i7];
                        if (str3.equals(strReplace)) {
                            com.alibaba.fastjson.util.g<Type, e1> gVar3 = this.f12979a;
                            Class<?> cls4 = Class.forName(str3);
                            d2 d2Var = d2.f12879a;
                            gVar3.d(cls4, d2Var);
                            return d2Var;
                        }
                        i7++;
                    }
                }
            } catch (Throwable unused2) {
                f12978t = true;
            }
        }
        if (strReplace.equals("java.nio.file.Path")) {
            com.alibaba.fastjson.util.g<Type, e1> gVar4 = this.f12979a;
            e1VarC2 = v0.f13178b;
            gVar4.d(cls, e1VarC2);
        }
        if (cls == Map.Entry.class) {
            com.alibaba.fastjson.util.g<Type, e1> gVar5 = this.f12979a;
            e1VarC2 = v0.f13178b;
            gVar5.d(cls, e1VarC2);
        }
        try {
            for (com.alibaba.fastjson.parser.deserializer.d dVar2 : com.alibaba.fastjson.util.j.a(com.alibaba.fastjson.parser.deserializer.d.class, Thread.currentThread().getContextClassLoader())) {
                Iterator<Type> it = dVar2.a().iterator();
                while (it.hasNext()) {
                    this.f12979a.d(it.next(), dVar2);
                }
            }
        } catch (Exception unused3) {
        }
        if (e1VarC2 == null) {
            e1VarC2 = this.f12979a.c(type2);
        }
        if (e1VarC2 != null) {
            return e1VarC2;
        }
        if (cls.isEnum()) {
            e0.d dVar3 = (e0.d) cls.getAnnotation(e0.d.class);
            if (dVar3 != null) {
                try {
                    e1 e1Var = (e1) dVar3.deserializer().newInstance();
                    this.f12979a.d(cls, e1Var);
                    return e1Var;
                } catch (Throwable unused4) {
                }
            }
            e1VarJ = new com.alibaba.fastjson.parser.deserializer.g(cls);
        } else if (cls.isArray()) {
            e1VarJ = x0.f13183a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class || Collection.class.isAssignableFrom(cls)) {
            e1VarJ = y.f13184a;
        } else if (Map.class.isAssignableFrom(cls)) {
            e1VarJ = c1.f12877a;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            e1VarJ = new k2(this, cls);
        } else if (f2.class.isAssignableFrom(cls)) {
            e1VarJ = new g2(cls);
        } else {
            e1VarJ = cls == InetAddress.class ? v0.f13178b : j(cls, type2);
        }
        y(type2, e1VarJ);
        return e1VarJ;
    }

    public e1 n(Type type) {
        e1 e1VarC = this.f12979a.c(type);
        if (e1VarC != null) {
            return e1VarC;
        }
        if (type instanceof Class) {
            return m((Class) type, type);
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            return rawType instanceof Class ? m((Class) rawType, type) : n(rawType);
        }
        if (type instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type).getUpperBounds();
            if (upperBounds.length == 1) {
                return n(upperBounds[0]);
            }
        }
        return o.f12912a;
    }

    public com.alibaba.fastjson.util.g<Type, e1> o() {
        return this.f12979a;
    }

    public void s(Class<?>... clsArr) {
        if (clsArr == null) {
            return;
        }
        for (Class<?> cls : clsArr) {
            if (cls != null) {
                y(cls, j(cls, cls));
            }
        }
    }

    public boolean t() {
        return this.f12980b;
    }

    public boolean u() {
        return this.f12985g;
    }

    public boolean v(Class<?> cls) {
        return w(cls);
    }

    public void y(Type type, e1 e1Var) {
        this.f12979a.d(type, e1Var);
    }

    public void z(boolean z7) {
        this.f12980b = z7;
    }

    public j(boolean z7) {
        this(null, null, z7);
    }

    public j(ClassLoader classLoader) {
        this(null, classLoader, false);
    }

    public j(com.alibaba.fastjson.parser.deserializer.a aVar) {
        this(aVar, null, false);
    }

    private j(com.alibaba.fastjson.parser.deserializer.a aVar, ClassLoader classLoader, boolean z7) {
        this.f12979a = new com.alibaba.fastjson.util.g<>();
        this.f12980b = !com.alibaba.fastjson.util.b.f13259b;
        this.f12981c = new k(4096);
        this.f12985g = f12975q;
        this.f12989k = l.f13374a;
        this.f12986h = new long[]{-8720046426850100497L, -8165637398350707645L, -8109300701639721088L, -8083514888460375884L, -7966123100503199569L, -7921218830998286408L, -7768608037458185275L, -7766605818834748097L, -6835437086156813536L, -6179589609550493385L, -5194641081268104286L, -4837536971810737970L, -4082057040235125754L, -3935185854875733362L, -2753427844400776271L, -2364987994247679115L, -2262244760619952081L, -1872417015366588117L, -1589194880214235129L, -254670111376247151L, -190281065685395680L, 33238344207745342L, 313864100207897507L, 1073634739308289776L, 1203232727967308606L, 1459860845934817624L, 1502845958873959152L, 3547627781654598988L, 3730752432285826863L, 3794316665763266033L, 4147696707147271408L, 5347909877633654828L, 5450448828334921485L, 5688200883751798389L, 5751393439502795295L, 5944107969236155580L, 6742705432718011780L, 7017492163108594270L, 7179336928365889465L, 7442624256860549330L, 8389032537095247355L, 8409640769019589119L, 8838294710098435315L};
        long[] jArr = new long[f12974p.length];
        int i7 = 0;
        while (true) {
            String[] strArr = f12974p;
            if (i7 >= strArr.length) {
                break;
            }
            jArr[i7] = l.K(strArr[i7]);
            i7++;
        }
        Arrays.sort(jArr);
        this.f12987i = jArr;
        this.f12988j = z7;
        if (aVar == null && !com.alibaba.fastjson.util.b.f13259b) {
            try {
                if (classLoader == null) {
                    aVar = new com.alibaba.fastjson.parser.deserializer.a(new com.alibaba.fastjson.util.a());
                } else {
                    aVar = new com.alibaba.fastjson.parser.deserializer.a(classLoader);
                }
            } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
            }
        }
        this.f12984f = aVar;
        if (aVar == null) {
            this.f12980b = false;
        }
        r();
        d(f12973o);
        c(f12974p);
    }
}
