package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.deserializer.e2;
import com.alibaba.fastjson.serializer.g1;
import com.alibaba.fastjson.serializer.h1;
import com.alibaba.fastjson.serializer.j1;
import com.alibaba.fastjson.serializer.k1;
import com.alibaba.fastjson.serializer.l0;
import com.alibaba.fastjson.serializer.n0;
import com.alibaba.fastjson.serializer.p0;
import com.alibaba.fastjson.serializer.y0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements j, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TimeZone f12527a = TimeZone.getDefault();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Locale f12528b = Locale.getDefault();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f12529c = com.haier.library.json.a.f26646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final h1[] f12530d = new h1[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f12531e = com.haier.library.json.a.f26647d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f12532f = (((((((com.alibaba.fastjson.parser.c.AutoCloseSource.b() | 0) | com.alibaba.fastjson.parser.c.InternFieldNames.b()) | com.alibaba.fastjson.parser.c.UseBigDecimal.b()) | com.alibaba.fastjson.parser.c.AllowUnQuotedFieldNames.b()) | com.alibaba.fastjson.parser.c.AllowSingleQuotes.b()) | com.alibaba.fastjson.parser.c.AllowArbitraryCommas.b()) | com.alibaba.fastjson.parser.c.SortFeidFastMatch.b()) | com.alibaba.fastjson.parser.c.IgnoreNotMatch.b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f12533g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ThreadLocal<byte[]> f12534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ThreadLocal<char[]> f12535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12536j = "1.2.48";

    static {
        int iB = 0 | k1.QuoteFieldNames.b() | k1.SkipTransientField.b() | k1.WriteEnumUsingName.b() | k1.SortField.b();
        String strL = com.alibaba.fastjson.util.f.l("fastjson.serializerFeatures.MapSortField");
        int iB2 = k1.MapSortField.b();
        if ("true".equals(strL)) {
            iB |= iB2;
        } else if (com.paytm.pgsdk.d.G.equals(strL)) {
            iB &= ~iB2;
        }
        f12533g = iB;
        f12534h = new ThreadLocal<>();
        f12535i = new ThreadLocal<>();
    }

    public static String A0(Object obj, g1 g1Var, h1 h1Var, k1... k1VarArr) {
        return B0(obj, g1Var, new h1[]{h1Var}, null, f12533g, k1VarArr);
    }

    public static <T> List<T> B(String str, Class<T> cls) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.b bVar = new com.alibaba.fastjson.parser.b(str, com.alibaba.fastjson.parser.j.q());
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int iL0 = dVar.L0();
        if (iL0 == 8) {
            dVar.E();
        } else if (iL0 != 20 || !dVar.u()) {
            arrayList = new ArrayList();
            bVar.L0(cls, arrayList);
            bVar.s0(arrayList);
        }
        bVar.close();
        return arrayList;
    }

    public static String B0(Object obj, g1 g1Var, h1[] h1VarArr, String str, int i7, k1... k1VarArr) {
        j1 j1Var = new j1(null, i7, k1VarArr);
        try {
            n0 n0Var = new n0(j1Var, g1Var);
            if (str != null && str.length() != 0) {
                n0Var.O(str);
                n0Var.t(k1.WriteDateUseDateFormat, true);
            }
            if (h1VarArr != null) {
                for (h1 h1Var : h1VarArr) {
                    n0Var.b(h1Var);
                }
            }
            n0Var.S(obj);
            return j1Var.toString();
        } finally {
            j1Var.close();
        }
    }

    public static String C0(Object obj, g1 g1Var, h1[] h1VarArr, k1... k1VarArr) {
        return B0(obj, g1Var, h1VarArr, null, f12533g, k1VarArr);
    }

    public static List<Object> D(String str, Type[] typeArr) {
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.b bVar = new com.alibaba.fastjson.parser.b(str, com.alibaba.fastjson.parser.j.q());
        Object[] objArrA1 = bVar.a1(typeArr);
        List<Object> listAsList = objArrA1 != null ? Arrays.asList(objArrA1) : null;
        bVar.s0(listAsList);
        bVar.close();
        return listAsList;
    }

    public static String D0(Object obj, g1 g1Var, k1... k1VarArr) {
        return A0(obj, g1Var, null, k1VarArr);
    }

    public static String E0(Object obj, h1 h1Var, k1... k1VarArr) {
        return B0(obj, g1.f13055g, new h1[]{h1Var}, null, f12533g, k1VarArr);
    }

    public static String F0(Object obj, boolean z7) {
        return !z7 ? y0(obj) : H0(obj, k1.PrettyFormat);
    }

    public static String G0(Object obj, h1[] h1VarArr, k1... k1VarArr) {
        return B0(obj, g1.f13055g, h1VarArr, null, f12533g, k1VarArr);
    }

    public static e H(String str) {
        Object objL = l(str);
        if (objL instanceof e) {
            return (e) objL;
        }
        try {
            return (e) i0(objL);
        } catch (RuntimeException e8) {
            throw new d("can not cast to JSONObject.", e8);
        }
    }

    public static String H0(Object obj, k1... k1VarArr) {
        return z0(obj, f12533g, k1VarArr);
    }

    public static e I(String str, com.alibaba.fastjson.parser.c... cVarArr) {
        return (e) r(str, cVarArr);
    }

    public static String I0(Object obj, String str, k1... k1VarArr) {
        return B0(obj, g1.f13055g, null, str, f12533g, k1VarArr);
    }

    public static <T> T J(InputStream inputStream, Type type, com.alibaba.fastjson.parser.c... cVarArr) throws IOException {
        return (T) L(inputStream, com.alibaba.fastjson.util.f.f13318e, type, cVarArr);
    }

    public static String J0(Object obj, g1 g1Var, k1... k1VarArr) {
        return B0(obj, g1Var, f12530d, null, 0, k1VarArr);
    }

    public static <T> T K0(a aVar, Class<T> cls) {
        return (T) com.alibaba.fastjson.util.l.e(aVar, cls, com.alibaba.fastjson.parser.j.q());
    }

    public static <T> T L(InputStream inputStream, Charset charset, Type type, com.alibaba.fastjson.parser.c... cVarArr) throws IOException {
        if (charset == null) {
            charset = com.alibaba.fastjson.util.f.f13318e;
        }
        Charset charset2 = charset;
        byte[] bArrB = b(65536);
        int i7 = 0;
        while (true) {
            int i8 = inputStream.read(bArrB, i7, bArrB.length - i7);
            if (i8 == -1) {
                return (T) b0(bArrB, 0, i7, charset2, type, cVarArr);
            }
            i7 += i8;
            if (i7 == bArrB.length) {
                byte[] bArr = new byte[(bArrB.length * 3) / 2];
                System.arraycopy(bArrB, 0, bArr, 0, bArrB.length);
                bArrB = bArr;
            }
        }
    }

    public static <T> T M(String str, n<T> nVar, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) W(str, nVar.f12779a, com.alibaba.fastjson.parser.j.f12976r, f12532f, cVarArr);
    }

    public static <T> T N(String str, Class<T> cls) {
        return (T) P(str, cls, new com.alibaba.fastjson.parser.c[0]);
    }

    public static <T> T O(String str, Class<T> cls, e2 e2Var, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) X(str, cls, com.alibaba.fastjson.parser.j.f12976r, e2Var, f12532f, cVarArr);
    }

    public static final int O0(OutputStream outputStream, Object obj, int i7, k1... k1VarArr) throws IOException {
        return Q0(outputStream, com.alibaba.fastjson.util.f.f13318e, obj, g1.f13055g, null, null, i7, k1VarArr);
    }

    public static <T> T P(String str, Class<T> cls, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) X(str, cls, com.alibaba.fastjson.parser.j.f12976r, null, f12532f, cVarArr);
    }

    public static final int P0(OutputStream outputStream, Object obj, k1... k1VarArr) throws IOException {
        return O0(outputStream, obj, f12533g, k1VarArr);
    }

    public static final int Q0(OutputStream outputStream, Charset charset, Object obj, g1 g1Var, h1[] h1VarArr, String str, int i7, k1... k1VarArr) throws IOException {
        j1 j1Var = new j1(null, i7, k1VarArr);
        try {
            n0 n0Var = new n0(j1Var, g1Var);
            if (str != null && str.length() != 0) {
                n0Var.O(str);
                n0Var.t(k1.WriteDateUseDateFormat, true);
            }
            if (h1VarArr != null) {
                for (h1 h1Var : h1VarArr) {
                    n0Var.b(h1Var);
                }
            }
            n0Var.S(obj);
            return j1Var.k2(outputStream, charset);
        } finally {
            j1Var.close();
        }
    }

    public static final int R0(OutputStream outputStream, Charset charset, Object obj, k1... k1VarArr) throws IOException {
        return Q0(outputStream, charset, obj, g1.f13055g, null, null, f12533g, k1VarArr);
    }

    public static <T> T S(String str, Type type, int i7, com.alibaba.fastjson.parser.c... cVarArr) {
        if (str == null) {
            return null;
        }
        for (com.alibaba.fastjson.parser.c cVar : cVarArr) {
            i7 = com.alibaba.fastjson.parser.c.a(i7, cVar, true);
        }
        com.alibaba.fastjson.parser.b bVar = new com.alibaba.fastjson.parser.b(str, com.alibaba.fastjson.parser.j.q(), i7);
        T t7 = (T) bVar.w1(type);
        bVar.s0(t7);
        bVar.close();
        return t7;
    }

    public static void S0(Writer writer, Object obj, int i7, k1... k1VarArr) {
        j1 j1Var = new j1(writer, i7, k1VarArr);
        try {
            new n0(j1Var).S(obj);
        } finally {
            j1Var.close();
        }
    }

    public static void T0(Writer writer, Object obj, k1... k1VarArr) {
        S0(writer, obj, f12533g, k1VarArr);
    }

    public static void U0(Object obj, Writer writer, k1... k1VarArr) {
        T0(writer, obj, k1VarArr);
    }

    public static <T> T W(String str, Type type, com.alibaba.fastjson.parser.j jVar, int i7, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) X(str, type, jVar, null, i7, cVarArr);
    }

    public static <T> T X(String str, Type type, com.alibaba.fastjson.parser.j jVar, e2 e2Var, int i7, com.alibaba.fastjson.parser.c... cVarArr) {
        if (str == null) {
            return null;
        }
        if (cVarArr != null) {
            for (com.alibaba.fastjson.parser.c cVar : cVarArr) {
                i7 |= cVar.f12829a;
            }
        }
        com.alibaba.fastjson.parser.b bVar = new com.alibaba.fastjson.parser.b(str, jVar, i7);
        if (e2Var != null) {
            if (e2Var instanceof com.alibaba.fastjson.parser.deserializer.j) {
                bVar.H().add((com.alibaba.fastjson.parser.deserializer.j) e2Var);
            }
            if (e2Var instanceof com.alibaba.fastjson.parser.deserializer.i) {
                bVar.G().add((com.alibaba.fastjson.parser.deserializer.i) e2Var);
            }
            if (e2Var instanceof com.alibaba.fastjson.parser.deserializer.l) {
                bVar.d2((com.alibaba.fastjson.parser.deserializer.l) e2Var);
            }
        }
        T t7 = (T) bVar.z1(type, null);
        bVar.s0(t7);
        bVar.close();
        return t7;
    }

    public static <T> T Y(String str, Type type, com.alibaba.fastjson.parser.j jVar, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) X(str, type, jVar, null, f12532f, cVarArr);
    }

    public static <T> T Z(String str, Type type, e2 e2Var, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) X(str, type, com.alibaba.fastjson.parser.j.f12976r, e2Var, f12532f, cVarArr);
    }

    public static <T> T a0(String str, Type type, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) W(str, type, com.alibaba.fastjson.parser.j.f12976r, f12532f, cVarArr);
    }

    private static byte[] b(int i7) {
        ThreadLocal<byte[]> threadLocal = f12534h;
        byte[] bArr = threadLocal.get();
        if (bArr != null) {
            return bArr.length < i7 ? new byte[i7] : bArr;
        }
        if (i7 > 65536) {
            return new byte[i7];
        }
        byte[] bArr2 = new byte[65536];
        threadLocal.set(bArr2);
        return bArr2;
    }

    public static <T> T b0(byte[] bArr, int i7, int i8, Charset charset, Type type, com.alibaba.fastjson.parser.c... cVarArr) {
        String str;
        if (charset == null) {
            charset = com.alibaba.fastjson.util.f.f13318e;
        }
        if (charset == com.alibaba.fastjson.util.f.f13318e) {
            char[] cArrD = d(bArr.length);
            int iF = com.alibaba.fastjson.util.f.f(bArr, i7, i8, cArrD);
            if (iF < 0) {
                return null;
            }
            str = new String(cArrD, 0, iF);
        } else {
            if (i8 < 0) {
                return null;
            }
            str = new String(bArr, i7, i8, charset);
        }
        return (T) a0(str, type, cVarArr);
    }

    public static <T> T c0(byte[] bArr, int i7, int i8, CharsetDecoder charsetDecoder, Type type, com.alibaba.fastjson.parser.c... cVarArr) {
        charsetDecoder.reset();
        char[] cArrD = d((int) (((double) i8) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i7, i8);
        CharBuffer charBufferWrap = CharBuffer.wrap(cArrD);
        com.alibaba.fastjson.util.f.b(charsetDecoder, byteBufferWrap, charBufferWrap);
        return (T) e0(cArrD, charBufferWrap.position(), type, cVarArr);
    }

    private static char[] d(int i7) {
        ThreadLocal<char[]> threadLocal = f12535i;
        char[] cArr = threadLocal.get();
        if (cArr != null) {
            return cArr.length < i7 ? new char[i7] : cArr;
        }
        if (i7 > 65536) {
            return new char[i7];
        }
        char[] cArr2 = new char[65536];
        threadLocal.set(cArr2);
        return cArr2;
    }

    public static <T> T d0(byte[] bArr, Type type, com.alibaba.fastjson.parser.c... cVarArr) {
        return (T) b0(bArr, 0, bArr.length, com.alibaba.fastjson.util.f.f13318e, type, cVarArr);
    }

    public static <T> T e0(char[] cArr, int i7, Type type, com.alibaba.fastjson.parser.c... cVarArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int iA = f12532f;
        for (com.alibaba.fastjson.parser.c cVar : cVarArr) {
            iA = com.alibaba.fastjson.parser.c.a(iA, cVar, true);
        }
        com.alibaba.fastjson.parser.b bVar = new com.alibaba.fastjson.parser.b(cArr, i7, com.alibaba.fastjson.parser.j.q(), iA);
        T t7 = (T) bVar.w1(type);
        bVar.s0(t7);
        bVar.close();
        return t7;
    }

    public static void f0(String str) {
        f12529c = str;
        com.alibaba.fastjson.parser.j.f12976r.f12981c.b(str, 0, str.length(), str.hashCode(), true);
    }

    public static <T> void g(com.alibaba.fastjson.parser.b bVar, T t7) {
        bVar.s0(t7);
    }

    public static Object i0(Object obj) {
        return k0(obj, g1.f13055g);
    }

    public static Object j0(Object obj, com.alibaba.fastjson.parser.j jVar) {
        return k0(obj, g1.f13055g);
    }

    public static Object k0(Object obj, g1 g1Var) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof a) {
            return obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            int size = map.size();
            e eVar = new e((Map<String, Object>) (map instanceof LinkedHashMap ? new LinkedHashMap(size) : map instanceof TreeMap ? new TreeMap() : new HashMap(size)));
            for (Map.Entry entry : map.entrySet()) {
                eVar.put(com.alibaba.fastjson.util.l.z(entry.getKey()), i0(entry.getValue()));
            }
            return eVar;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            b bVar = new b(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                bVar.add(i0(it.next()));
            }
            return bVar;
        }
        if (obj instanceof l0) {
            return l(y0(obj));
        }
        Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((Enum) obj).name();
        }
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            b bVar2 = new b(length);
            for (int i7 = 0; i7 < length; i7++) {
                bVar2.add(i0(Array.get(obj, i7)));
            }
            return bVar2;
        }
        if (com.alibaba.fastjson.parser.j.w(cls)) {
            return obj;
        }
        y0 y0VarJ = g1Var.j(cls);
        if (!(y0VarJ instanceof p0)) {
            return l(y0(obj));
        }
        p0 p0Var = (p0) y0VarJ;
        e eVar2 = new e();
        try {
            for (Map.Entry<String, Object> entry2 : p0Var.A(obj).entrySet()) {
                eVar2.put(entry2.getKey(), i0(entry2.getValue()));
            }
            return eVar2;
        } catch (Exception e8) {
            throw new d("toJSON error", e8);
        }
    }

    public static Object l(String str) {
        return m(str, f12532f);
    }

    public static Object m(String str, int i7) {
        return o(str, com.alibaba.fastjson.parser.j.q(), i7);
    }

    public static byte[] m0(Object obj, int i7, k1... k1VarArr) {
        return n0(obj, g1.f13055g, i7, k1VarArr);
    }

    public static Object n(String str, com.alibaba.fastjson.parser.j jVar) {
        return o(str, jVar, f12532f);
    }

    public static byte[] n0(Object obj, g1 g1Var, int i7, k1... k1VarArr) {
        return s0(obj, g1Var, f12530d, i7, k1VarArr);
    }

    public static Object o(String str, com.alibaba.fastjson.parser.j jVar, int i7) {
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.b bVar = new com.alibaba.fastjson.parser.b(str, jVar, i7);
        Object objX0 = bVar.x0();
        bVar.s0(objX0);
        bVar.close();
        return objX0;
    }

    public static byte[] q0(Object obj, g1 g1Var, h1 h1Var, k1... k1VarArr) {
        return s0(obj, g1Var, new h1[]{h1Var}, f12533g, k1VarArr);
    }

    public static Object r(String str, com.alibaba.fastjson.parser.c... cVarArr) {
        int iA = f12532f;
        for (com.alibaba.fastjson.parser.c cVar : cVarArr) {
            iA = com.alibaba.fastjson.parser.c.a(iA, cVar, true);
        }
        return m(str, iA);
    }

    public static byte[] s0(Object obj, g1 g1Var, h1[] h1VarArr, int i7, k1... k1VarArr) {
        j1 j1Var = new j1(null, i7, k1VarArr);
        try {
            n0 n0Var = new n0(j1Var, g1Var);
            if (h1VarArr != null) {
                for (h1 h1Var : h1VarArr) {
                    n0Var.b(h1Var);
                }
            }
            n0Var.S(obj);
            return j1Var.l0(com.alibaba.fastjson.util.f.f13318e);
        } finally {
            j1Var.close();
        }
    }

    public static Object t(byte[] bArr, int i7, int i8, CharsetDecoder charsetDecoder, int i9) {
        charsetDecoder.reset();
        char[] cArrD = d((int) (((double) i8) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i7, i8);
        CharBuffer charBufferWrap = CharBuffer.wrap(cArrD);
        com.alibaba.fastjson.util.f.b(charsetDecoder, byteBufferWrap, charBufferWrap);
        com.alibaba.fastjson.parser.b bVar = new com.alibaba.fastjson.parser.b(cArrD, charBufferWrap.position(), com.alibaba.fastjson.parser.j.q(), i9);
        Object objX0 = bVar.x0();
        bVar.s0(objX0);
        bVar.close();
        return objX0;
    }

    public static byte[] t0(Object obj, g1 g1Var, k1... k1VarArr) {
        return s0(obj, g1Var, f12530d, f12533g, k1VarArr);
    }

    public static Object u(byte[] bArr, int i7, int i8, CharsetDecoder charsetDecoder, com.alibaba.fastjson.parser.c... cVarArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int iA = f12532f;
        for (com.alibaba.fastjson.parser.c cVar : cVarArr) {
            iA = com.alibaba.fastjson.parser.c.a(iA, cVar, true);
        }
        return t(bArr, i7, i8, charsetDecoder, iA);
    }

    public static byte[] u0(Object obj, h1 h1Var, k1... k1VarArr) {
        return s0(obj, g1.f13055g, new h1[]{h1Var}, f12533g, k1VarArr);
    }

    public static Object w(byte[] bArr, com.alibaba.fastjson.parser.c... cVarArr) {
        char[] cArrD = d(bArr.length);
        int iF = com.alibaba.fastjson.util.f.f(bArr, 0, bArr.length, cArrD);
        if (iF < 0) {
            return null;
        }
        return r(new String(cArrD, 0, iF), cVarArr);
    }

    public static byte[] w0(Object obj, h1[] h1VarArr, k1... k1VarArr) {
        return s0(obj, g1.f13055g, h1VarArr, f12533g, k1VarArr);
    }

    public static byte[] x0(Object obj, k1... k1VarArr) {
        return m0(obj, f12533g, k1VarArr);
    }

    public static String y0(Object obj) {
        return G0(obj, f12530d, new k1[0]);
    }

    public static b z(String str) {
        b bVar = null;
        if (str == null) {
            return null;
        }
        com.alibaba.fastjson.parser.b bVar2 = new com.alibaba.fastjson.parser.b(str, com.alibaba.fastjson.parser.j.q());
        com.alibaba.fastjson.parser.d dVar = bVar2.f12789f;
        if (dVar.L0() == 8) {
            dVar.E();
        } else if (dVar.L0() != 20) {
            bVar = new b();
            bVar2.V0(bVar);
            bVar2.s0(bVar);
        }
        bVar2.close();
        return bVar;
    }

    public static String z0(Object obj, int i7, k1... k1VarArr) {
        j1 j1Var = new j1(null, i7, k1VarArr);
        try {
            new n0(j1Var).S(obj);
            return j1Var.toString();
        } finally {
            j1Var.close();
        }
    }

    public <T> T L0(n nVar) {
        return (T) com.alibaba.fastjson.util.l.g(this, nVar != null ? nVar.a() : null, com.alibaba.fastjson.parser.j.q());
    }

    public <T> T M0(Class<T> cls) {
        return (T) com.alibaba.fastjson.util.l.e(this, cls, com.alibaba.fastjson.parser.j.q());
    }

    public <T> T N0(Type type) {
        return (T) com.alibaba.fastjson.util.l.g(this, type, com.alibaba.fastjson.parser.j.q());
    }

    @Override // com.alibaba.fastjson.j
    public void a(Appendable appendable) {
        j1 j1Var = new j1();
        try {
            try {
                new n0(j1Var).S(this);
                appendable.append(j1Var.toString());
                j1Var.close();
            } catch (IOException e8) {
                throw new d(e8.getMessage(), e8);
            }
        } catch (Throwable th) {
            j1Var.close();
            throw th;
        }
    }

    @Override // com.alibaba.fastjson.c
    public String k() {
        j1 j1Var = new j1();
        try {
            new n0(j1Var).S(this);
            return j1Var.toString();
        } finally {
            j1Var.close();
        }
    }

    public String toString() {
        return k();
    }
}
