package com.haier.library.json;

import com.haier.library.json.parser.m;
import com.haier.library.json.serializer.a0;
import com.haier.library.json.serializer.c0;
import com.haier.library.json.serializer.n;
import com.haier.library.json.serializer.r;
import com.haier.library.json.serializer.t;
import com.haier.library.json.serializer.u;
import com.haier.library.json.serializer.v;
import com.haier.library.json.serializer.x;
import com.haier.library.json.serializer.y;
import com.haier.library.json.serializer.z;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements c, f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f26646c = "@type";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f26647d = "yyyy-MM-dd HH:mm:ss";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f26650g = "1.1.53";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TimeZone f26644a = TimeZone.getDefault();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Locale f26645b = Locale.getDefault();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f26648e = (((((((com.haier.library.json.parser.d.AutoCloseSource.f26696a | 0) | com.haier.library.json.parser.d.InternFieldNames.f26696a) | com.haier.library.json.parser.d.UseBigDecimal.f26696a) | com.haier.library.json.parser.d.AllowUnQuotedFieldNames.f26696a) | com.haier.library.json.parser.d.AllowSingleQuotes.f26696a) | com.haier.library.json.parser.d.AllowArbitraryCommas.f26696a) | com.haier.library.json.parser.d.SortFeidFastMatch.f26696a) | com.haier.library.json.parser.d.IgnoreNotMatch.f26696a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f26649f = ((((a0.QuoteFieldNames.f26811a | 0) | a0.SkipTransientField.f26811a) | a0.WriteEnumUsingToString.f26811a) | a0.SortField.f26811a) | a0.WriteMapNullValue.f26811a;

    public static final <T> T B(String str, Class<T> cls, h3.g gVar, com.haier.library.json.parser.d... dVarArr) {
        return (T) J(str, cls, m.f26768d, gVar, f26648e, dVarArr);
    }

    public static final <T> T D(String str, Class<T> cls, com.haier.library.json.parser.d... dVarArr) {
        return (T) I(str, cls, m.f26768d, f26648e, dVarArr);
    }

    public static final <T> T H(String str, Type type, int i7, com.haier.library.json.parser.d... dVarArr) {
        if (str == null) {
            return null;
        }
        for (com.haier.library.json.parser.d dVar : dVarArr) {
            i7 |= dVar.f26696a;
        }
        com.haier.library.json.parser.b bVar = new com.haier.library.json.parser.b(str, m.f26768d, i7);
        T t7 = (T) bVar.x0(type);
        bVar.F(t7);
        bVar.close();
        return t7;
    }

    public static final <T> T I(String str, Type type, m mVar, int i7, com.haier.library.json.parser.d... dVarArr) {
        return (T) J(str, type, mVar, null, i7, dVarArr);
    }

    public static final <T> T J(String str, Type type, m mVar, h3.g gVar, int i7, com.haier.library.json.parser.d... dVarArr) {
        if (str == null) {
            return null;
        }
        for (com.haier.library.json.parser.d dVar : dVarArr) {
            i7 |= dVar.f26696a;
        }
        com.haier.library.json.parser.b bVar = new com.haier.library.json.parser.b(str, mVar, i7);
        if (gVar instanceof h3.c) {
            bVar.C().add((h3.c) gVar);
        }
        if (gVar instanceof h3.b) {
            bVar.u().add((h3.b) gVar);
        }
        if (gVar instanceof h3.e) {
            bVar.f26672m = (h3.e) gVar;
        }
        T t7 = (T) bVar.x0(type);
        bVar.F(t7);
        bVar.close();
        return t7;
    }

    public static final <T> T L(String str, Type type, h3.g gVar, com.haier.library.json.parser.d... dVarArr) {
        return (T) J(str, type, m.f26768d, gVar, f26648e, dVarArr);
    }

    public static final <T> T M(String str, Type type, com.haier.library.json.parser.d... dVarArr) {
        return (T) I(str, type, m.f26768d, f26648e, dVarArr);
    }

    public static final <T> T N(byte[] bArr, Type type, com.haier.library.json.parser.d... dVarArr) {
        return (T) M(new String(bArr, Charset.forName("UTF-8")), type, dVarArr);
    }

    public static final <T> T O(char[] cArr, int i7, Type type, com.haier.library.json.parser.d... dVarArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i8 = f26648e;
        for (com.haier.library.json.parser.d dVar : dVarArr) {
            i8 |= dVar.f26696a;
        }
        com.haier.library.json.parser.b bVar = new com.haier.library.json.parser.b(cArr, i7, m.f26768d, i8);
        T t7 = (T) bVar.x0(type);
        bVar.F(t7);
        bVar.close();
        return t7;
    }

    public static final Object P(Object obj) {
        return W(obj, x.f26859c);
    }

    @Deprecated
    public static final Object S(Object obj, m mVar) {
        return W(obj, x.f26859c);
    }

    public static Object W(Object obj, x xVar) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            e eVar = new e(map.size());
            for (Map.Entry entry : map.entrySet()) {
                eVar.put(i3.d.s(entry.getKey()), P(entry.getValue()));
            }
            return eVar;
        }
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            b bVar = new b(collection.size());
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                bVar.add(P(it.next()));
            }
            return bVar;
        }
        Class<?> cls = obj.getClass();
        if (cls.isEnum()) {
            return ((Enum) obj).name();
        }
        if (cls.isArray()) {
            int length = Array.getLength(obj);
            b bVar2 = new b(length);
            for (int i7 = 0; i7 < length; i7++) {
                bVar2.add(P(Array.get(obj, i7)));
            }
            return bVar2;
        }
        if (m.e(cls)) {
            return obj;
        }
        t tVarA = xVar.a(cls);
        if (!(tVarA instanceof n)) {
            return null;
        }
        n nVar = (n) tVarA;
        e eVar2 = new e();
        try {
            for (Map.Entry<String, Object> entry2 : nVar.a(obj).entrySet()) {
                if (b(entry2)) {
                    eVar2.put(entry2.getKey(), P(entry2.getValue()));
                }
            }
            return eVar2;
        } catch (Exception e8) {
            throw new d("toJSON error", e8);
        }
    }

    public static final byte[] X(Object obj, x xVar, a0... a0VarArr) {
        z zVar = new z(null, f26649f, a0VarArr);
        try {
            new com.haier.library.json.serializer.m(zVar, xVar).y(obj);
            return zVar.r("UTF-8");
        } finally {
            zVar.close();
        }
    }

    public static final byte[] Y(Object obj, a0... a0VarArr) {
        z zVar = new z(null, f26649f, a0VarArr);
        try {
            new com.haier.library.json.serializer.m(zVar, x.f26859c).y(obj);
            return zVar.r("UTF-8");
        } finally {
            zVar.close();
        }
    }

    public static final String Z(Object obj) {
        return c0(obj, x.f26859c, null, null, f26649f, new a0[0]);
    }

    public static final String a0(Object obj, int i7, a0... a0VarArr) {
        return c0(obj, x.f26859c, null, null, i7, a0VarArr);
    }

    private static boolean b(Map.Entry<String, Object> entry) {
        String key = entry.getKey();
        Object value = entry.getValue();
        if ("subdeviceList".equals(key) && (value instanceof Collection)) {
            return !((Collection) value).isEmpty();
        }
        return true;
    }

    public static final String b0(Object obj, x xVar, y yVar, a0... a0VarArr) {
        return c0(obj, xVar, new y[]{yVar}, null, f26649f, a0VarArr);
    }

    public static String c0(Object obj, x xVar, y[] yVarArr, String str, int i7, a0... a0VarArr) {
        z zVar = new z(null, i7, a0VarArr);
        try {
            com.haier.library.json.serializer.m mVar = new com.haier.library.json.serializer.m(zVar, xVar);
            for (a0 a0Var : a0VarArr) {
                mVar.d(a0Var, true);
            }
            if (str != null && str.length() != 0) {
                mVar.u(str);
                mVar.d(a0.WriteDateUseDateFormat, true);
            }
            if (yVarArr != null) {
                for (y yVar : yVarArr) {
                    if (yVar != null) {
                        if (yVar instanceof v) {
                            mVar.m().add((v) yVar);
                        }
                        if (yVar instanceof r) {
                            mVar.k().add((r) yVar);
                        }
                        if (yVar instanceof c0) {
                            mVar.n().add((c0) yVar);
                        }
                        if (yVar instanceof u) {
                            mVar.l().add((u) yVar);
                        }
                        if (yVar instanceof com.haier.library.json.serializer.d) {
                            mVar.g().add((com.haier.library.json.serializer.d) yVar);
                        }
                        if (yVar instanceof com.haier.library.json.serializer.a) {
                            mVar.f().add((com.haier.library.json.serializer.a) yVar);
                        }
                    }
                }
            }
            mVar.y(obj);
            return zVar.toString();
        } finally {
            zVar.close();
        }
    }

    public static final Object d(String str) {
        return g(str, f26648e);
    }

    public static final String d0(Object obj, x xVar, y[] yVarArr, a0... a0VarArr) {
        return c0(obj, xVar, yVarArr, null, f26649f, a0VarArr);
    }

    public static final String e0(Object obj, x xVar, a0... a0VarArr) {
        return c0(obj, xVar, null, null, f26649f, a0VarArr);
    }

    public static final String f0(Object obj, y yVar, a0... a0VarArr) {
        return c0(obj, x.f26859c, new y[]{yVar}, null, f26649f, a0VarArr);
    }

    public static final Object g(String str, int i7) {
        if (str == null) {
            return null;
        }
        com.haier.library.json.parser.b bVar = new com.haier.library.json.parser.b(str, m.f26768d, i7);
        Object objH = bVar.H(null);
        bVar.F(objH);
        bVar.close();
        return objH;
    }

    public static final String i0(Object obj, boolean z7) {
        return !z7 ? Z(obj) : k0(obj, a0.PrettyFormat);
    }

    public static final String j0(Object obj, y[] yVarArr, a0... a0VarArr) {
        return c0(obj, x.f26859c, yVarArr, null, f26649f, a0VarArr);
    }

    public static final String k0(Object obj, a0... a0VarArr) {
        return a0(obj, f26649f, a0VarArr);
    }

    public static final Object l(String str, com.haier.library.json.parser.d... dVarArr) {
        int i7 = f26648e;
        for (com.haier.library.json.parser.d dVar : dVarArr) {
            i7 |= dVar.f26696a;
        }
        return g(str, i7);
    }

    public static final Object m(byte[] bArr, com.haier.library.json.parser.d... dVarArr) {
        return u(new String(bArr, Charset.forName("UTF-8")), dVarArr);
    }

    public static final String m0(Object obj, String str, a0... a0VarArr) {
        return c0(obj, x.f26859c, null, str, f26649f, a0VarArr);
    }

    public static final b n(String str) {
        b bVar = null;
        if (str == null) {
            return null;
        }
        com.haier.library.json.parser.b bVar2 = new com.haier.library.json.parser.b(str, m.f26768d);
        com.haier.library.json.parser.e eVar = bVar2.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 8) {
            eVar.x();
        } else if (iD0 != 20) {
            bVar = new b();
            bVar2.l0(bVar);
            bVar2.F(bVar);
        }
        bVar2.close();
        return bVar;
    }

    public static final String n0(Object obj, x xVar, a0... a0VarArr) {
        return c0(obj, x.f26859c, null, null, 0, a0VarArr);
    }

    public static final <T> List<T> o(String str, Class<T> cls) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        com.haier.library.json.parser.b bVar = new com.haier.library.json.parser.b(str, m.f26768d);
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        int iD0 = eVar.d0();
        if (iD0 == 8) {
            eVar.x();
        } else if (iD0 != 20 || !eVar.q()) {
            arrayList = new ArrayList();
            bVar.Q(cls, arrayList);
            bVar.F(arrayList);
        }
        bVar.close();
        return arrayList;
    }

    public static final <T> T q0(a aVar, Class<T> cls) {
        return (T) i3.d.a(aVar, cls, m.f26768d);
    }

    public static final List<Object> r(String str, Type[] typeArr) {
        if (str == null) {
            return null;
        }
        com.haier.library.json.parser.b bVar = new com.haier.library.json.parser.b(str, m.f26768d);
        Object[] objArrP0 = bVar.p0(typeArr);
        List<Object> listAsList = objArrP0 != null ? Arrays.asList(objArrP0) : null;
        bVar.F(listAsList);
        bVar.close();
        return listAsList;
    }

    public static final e t(String str) {
        Object objD = d(str);
        return objD instanceof e ? (e) objD : (e) P(objD);
    }

    public static final void t0(Object obj, Writer writer, a0... a0VarArr) {
        z zVar = new z(writer, f26649f, a0VarArr);
        try {
            new com.haier.library.json.serializer.m(zVar, x.f26859c).y(obj);
        } finally {
            zVar.close();
        }
    }

    public static final e u(String str, com.haier.library.json.parser.d... dVarArr) {
        return (e) l(str, dVarArr);
    }

    public static final <T> T w(String str, g gVar, com.haier.library.json.parser.d... dVarArr) {
        return (T) I(str, gVar.f26655a, m.f26768d, f26648e, dVarArr);
    }

    public static final <T> T z(String str, Class<T> cls) {
        return (T) D(str, cls, new com.haier.library.json.parser.d[0]);
    }

    @Override // com.haier.library.json.f
    public void a(Appendable appendable) {
        z zVar = new z(null, f26649f, a0.f26809y);
        try {
            try {
                new com.haier.library.json.serializer.m(zVar, x.f26859c).y(this);
                appendable.append(zVar.toString());
                zVar.close();
            } catch (IOException e8) {
                throw new d(e8.getMessage(), e8);
            }
        } catch (Throwable th) {
            zVar.close();
            throw th;
        }
    }

    @Override // com.haier.library.json.c
    public String k() {
        z zVar = new z(null, f26649f, a0.f26809y);
        try {
            new com.haier.library.json.serializer.m(zVar, x.f26859c).y(this);
            return zVar.toString();
        } finally {
            zVar.close();
        }
    }

    public <T> T s0(Class<T> cls) {
        return (T) i3.d.a(this, cls, m.d());
    }

    public String toString() {
        return k();
    }
}
