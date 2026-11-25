package com.haier.library.json;

import com.haier.library.json.parser.m;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a implements Serializable, Cloneable, InvocationHandler, Map<String, Object> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, Object> f26654h;

    public e() {
        this(16, false);
    }

    public byte A0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return (byte) 0;
        }
        return i3.d.g(obj).byteValue();
    }

    public byte[] B0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return i3.d.h(obj);
    }

    public Date C0(String str) {
        return i3.d.j(get(str));
    }

    public Double D0(String str) {
        return i3.d.k(get(str));
    }

    public double E0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0d;
        }
        return i3.d.k(obj).doubleValue();
    }

    public Float F0(String str) {
        return i3.d.m(get(str));
    }

    public float G0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0f;
        }
        return i3.d.m(obj).floatValue();
    }

    public Map<String, Object> H0() {
        return this.f26654h;
    }

    public int I0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return i3.d.n(obj).intValue();
    }

    public Integer J0(String str) {
        return i3.d.n(get(str));
    }

    public b K0(String str) {
        Object obj = this.f26654h.get(str);
        return obj instanceof b ? (b) obj : (b) a.P(obj);
    }

    public e L0(String str) {
        Object obj = this.f26654h.get(str);
        return obj instanceof e ? (e) obj : (e) a.P(obj);
    }

    public Long M0(String str) {
        return i3.d.q(get(str));
    }

    public long N0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0L;
        }
        return i3.d.q(obj).longValue();
    }

    public <T> T O0(String str, Class<T> cls) {
        return (T) i3.d.o(this.f26654h.get(str), cls);
    }

    public Short P0(String str) {
        return i3.d.r(get(str));
    }

    public short Q0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return (short) 0;
        }
        return i3.d.r(obj).shortValue();
    }

    public String R0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        return this.f26654h.put(str, obj);
    }

    @Override // java.util.Map
    public void clear() {
        this.f26654h.clear();
    }

    public Object clone() {
        return new e(new LinkedHashMap(this.f26654h));
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f26654h.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f26654h.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f26654h.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.f26654h.equals(obj);
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.f26654h.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f26654h.hashCode();
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String strName = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() != Void.TYPE) {
                throw new d("illegal setter");
            }
            g3.b bVar = (g3.b) method.getAnnotation(g3.b.class);
            String strName2 = (bVar == null || bVar.name().length() == 0) ? null : bVar.name();
            if (strName2 == null) {
                String name = method.getName();
                if (!name.startsWith("set")) {
                    throw new d("illegal setter");
                }
                String strSubstring = name.substring(3);
                if (strSubstring.length() == 0) {
                    throw new d("illegal setter");
                }
                strName2 = Character.toLowerCase(strSubstring.charAt(0)) + strSubstring.substring(1);
            }
            this.f26654h.put(strName2, objArr[0]);
            return null;
        }
        if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        }
        if (method.getReturnType() == Void.TYPE) {
            throw new d("illegal getter");
        }
        g3.b bVar2 = (g3.b) method.getAnnotation(g3.b.class);
        if (bVar2 != null && bVar2.name().length() != 0) {
            strName = bVar2.name();
        }
        if (strName == null) {
            String name2 = method.getName();
            if (name2.startsWith("get")) {
                String strSubstring2 = name2.substring(3);
                if (strSubstring2.length() == 0) {
                    throw new d("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring2.charAt(0)) + strSubstring2.substring(1);
            } else {
                if (!name2.startsWith("is")) {
                    if (name2.startsWith("hashCode")) {
                        return Integer.valueOf(hashCode());
                    }
                    if (name2.startsWith("toString")) {
                        return toString();
                    }
                    throw new d("illegal getter");
                }
                String strSubstring3 = name2.substring(2);
                if (strSubstring3.length() == 0) {
                    throw new d("illegal getter");
                }
                strName = Character.toLowerCase(strSubstring3.charAt(0)) + strSubstring3.substring(1);
            }
        }
        return i3.d.c(this.f26654h.get(strName), method.getGenericReturnType(), m.f26768d);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f26654h.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f26654h.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.f26654h.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f26654h.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f26654h.size();
    }

    public BigDecimal u0(String str) {
        return i3.d.d(get(str));
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.f26654h.values();
    }

    public BigInteger w0(String str) {
        return i3.d.e(get(str));
    }

    public Boolean x0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return i3.d.f(obj);
    }

    public boolean y0(String str) {
        Object obj = get(str);
        if (obj == null) {
            return false;
        }
        return i3.d.f(obj).booleanValue();
    }

    public Byte z0(String str) {
        return i3.d.g(get(str));
    }

    public e(Map<String, Object> map) {
        this.f26654h = map;
    }

    public e(boolean z7) {
        this(16, z7);
    }

    public e(int i7) {
        this(i7, false);
    }

    public e(int i7, boolean z7) {
        if (z7) {
            this.f26654h = new LinkedHashMap(i7);
        } else {
            this.f26654h = new HashMap(i7);
        }
    }
}
