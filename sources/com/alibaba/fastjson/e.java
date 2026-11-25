package com.alibaba.fastjson;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e extends a implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f12655l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f12656m = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f12657k;

    public e() {
        this(16, false);
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: A1, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        return this.f12657k.put(str, obj);
    }

    public e V0() {
        this.f12657k.clear();
        return this;
    }

    public e W0(String str, Object obj) {
        this.f12657k.put(str, obj);
        return this;
    }

    public e X0(Map<? extends String, ? extends Object> map) {
        this.f12657k.putAll(map);
        return this;
    }

    public e Y0(Object obj) {
        this.f12657k.remove(obj);
        return this;
    }

    public BigDecimal Z0(String str) {
        return com.alibaba.fastjson.util.l.h(get(str));
    }

    public BigInteger a1(String str) {
        return com.alibaba.fastjson.util.l.i(get(str));
    }

    public Boolean b1(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return com.alibaba.fastjson.util.l.j(obj);
    }

    public boolean c1(String str) {
        Boolean boolJ = com.alibaba.fastjson.util.l.j(get(str));
        if (boolJ == null) {
            return false;
        }
        return boolJ.booleanValue();
    }

    @Override // java.util.Map
    public void clear() {
        this.f12657k.clear();
    }

    public Object clone() {
        return new e((Map<String, Object>) (this.f12657k instanceof LinkedHashMap ? new LinkedHashMap(this.f12657k) : new HashMap(this.f12657k)));
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f12657k.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f12657k.containsValue(obj);
    }

    public Byte d1(String str) {
        return com.alibaba.fastjson.util.l.k(get(str));
    }

    public byte e1(String str) {
        Byte bK = com.alibaba.fastjson.util.l.k(get(str));
        if (bK == null) {
            return (byte) 0;
        }
        return bK.byteValue();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.f12657k.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.f12657k.equals(obj);
    }

    public byte[] f1(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return com.alibaba.fastjson.util.l.l(obj);
    }

    public Date g1(String str) {
        return com.alibaba.fastjson.util.l.n(get(str));
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Object obj2 = this.f12657k.get(obj);
        return (obj2 == null && (obj instanceof Number)) ? this.f12657k.get(obj.toString()) : obj2;
    }

    public Double h1(String str) {
        return com.alibaba.fastjson.util.l.p(get(str));
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.f12657k.hashCode();
    }

    public double i1(String str) {
        Double dP = com.alibaba.fastjson.util.l.p(get(str));
        if (dP == null) {
            return 0.0d;
        }
        return dP.doubleValue();
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
            e0.b bVar = (e0.b) method.getAnnotation(e0.b.class);
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
            this.f12657k.put(strName2, objArr[0]);
            return null;
        }
        if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        }
        if (method.getReturnType() == Void.TYPE) {
            throw new d("illegal getter");
        }
        e0.b bVar2 = (e0.b) method.getAnnotation(e0.b.class);
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
        return com.alibaba.fastjson.util.l.g(this.f12657k.get(strName), method.getGenericReturnType(), com.alibaba.fastjson.parser.j.q());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f12657k.isEmpty();
    }

    public Float j1(String str) {
        return com.alibaba.fastjson.util.l.r(get(str));
    }

    public float k1(String str) {
        Float fR = com.alibaba.fastjson.util.l.r(get(str));
        if (fR == null) {
            return 0.0f;
        }
        return fR.floatValue();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f12657k.keySet();
    }

    public Map<String, Object> l1() {
        return this.f12657k;
    }

    public int m1(String str) {
        Integer numS = com.alibaba.fastjson.util.l.s(get(str));
        if (numS == null) {
            return 0;
        }
        return numS.intValue();
    }

    public Integer n1(String str) {
        return com.alibaba.fastjson.util.l.s(get(str));
    }

    public b o1(String str) {
        Object obj = this.f12657k.get(str);
        if (obj instanceof b) {
            return (b) obj;
        }
        return obj instanceof String ? (b) a.l((String) obj) : (b) a.i0(obj);
    }

    public e p1(String str) {
        Object obj = this.f12657k.get(str);
        if (obj instanceof e) {
            return (e) obj;
        }
        return obj instanceof String ? a.H((String) obj) : (e) a.i0(obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.f12657k.putAll(map);
    }

    public Long q1(String str) {
        return com.alibaba.fastjson.util.l.v(get(str));
    }

    public long r1(String str) {
        Long lV = com.alibaba.fastjson.util.l.v(get(str));
        if (lV == null) {
            return 0L;
        }
        return lV.longValue();
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.f12657k.remove(obj);
    }

    public <T> T s1(String str, n nVar) {
        T t7 = (T) this.f12657k.get(str);
        return nVar == null ? t7 : (T) com.alibaba.fastjson.util.l.g(t7, nVar.a(), com.alibaba.fastjson.parser.j.q());
    }

    @Override // java.util.Map
    public int size() {
        return this.f12657k.size();
    }

    public <T> T t1(String str, Class<T> cls) {
        return (T) com.alibaba.fastjson.util.l.t(this.f12657k.get(str), cls);
    }

    public <T> T u1(String str, Type type) {
        return (T) com.alibaba.fastjson.util.l.g(this.f12657k.get(str), type, com.alibaba.fastjson.parser.j.q());
    }

    public Short v1(String str) {
        return com.alibaba.fastjson.util.l.w(get(str));
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.f12657k.values();
    }

    public short w1(String str) {
        Short shW = com.alibaba.fastjson.util.l.w(get(str));
        if (shW == null) {
            return (short) 0;
        }
        return shW.shortValue();
    }

    public java.sql.Date x1(String str) {
        return com.alibaba.fastjson.util.l.x(get(str));
    }

    public String y1(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Timestamp z1(String str) {
        return com.alibaba.fastjson.util.l.A(get(str));
    }

    public e(Map<String, Object> map) {
        this.f12657k = map;
    }

    public e(boolean z7) {
        this(16, z7);
    }

    public e(int i7) {
        this(i7, false);
    }

    public e(int i7, boolean z7) {
        if (z7) {
            this.f12657k = new LinkedHashMap(i7);
        } else {
            this.f12657k = new HashMap(i7);
        }
    }
}
