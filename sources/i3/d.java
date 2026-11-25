package i3;

import androidx.constraintlayout.core.motion.utils.w;
import com.alipay.sdk.util.j;
import com.haier.library.json.parser.e;
import com.haier.library.json.parser.g;
import com.haier.library.json.parser.m;
import com.haier.library.json.serializer.a0;
import h3.f;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f34184a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f34185b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentMap<String, Class<?>> f34186c;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f34186c = concurrentHashMap;
        concurrentHashMap.put("byte", Byte.TYPE);
        f34186c.put("short", Short.TYPE);
        f34186c.put("int", Integer.TYPE);
        f34186c.put("long", Long.TYPE);
        f34186c.put(w.b.f3028c, Float.TYPE);
        f34186c.put("double", Double.TYPE);
        f34186c.put(w.b.f3031f, Boolean.TYPE);
        f34186c.put("char", Character.TYPE);
        f34186c.put("[byte", byte[].class);
        f34186c.put("[short", short[].class);
        f34186c.put("[int", int[].class);
        f34186c.put("[long", long[].class);
        f34186c.put("[float", float[].class);
        f34186c.put("[double", double[].class);
        f34186c.put("[boolean", boolean[].class);
        f34186c.put("[char", char[].class);
        f34186c.put(HashMap.class.getName(), HashMap.class);
    }

    public static boolean A(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class)) {
            return false;
        }
        Type genericSuperclass = ((Class) type).getGenericSuperclass();
        return genericSuperclass != Object.class && A(genericSuperclass);
    }

    private static boolean B(Class<?> cls, g3.d dVar, String str) {
        if (dVar != null && dVar.ignores() != null) {
            for (String str2 : dVar.ignores()) {
                if (str.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        return (superclass == Object.class || superclass == null || !B(superclass, (g3.d) superclass.getAnnotation(g3.d.class), str)) ? false : true;
    }

    public static Class<?> C(String str, ClassLoader classLoader) {
        Exception e8;
        Class<?> clsLoadClass;
        if (str == null || str.length() == 0) {
            return null;
        }
        Class<?> cls = f34186c.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(C(str.substring(1), classLoader), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(j.f13806b)) {
            return C(str.substring(1, str.length() - 1), classLoader);
        }
        if (classLoader != null) {
            try {
                cls = classLoader.loadClass(str);
                f34186c.put(str, cls);
                return cls;
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                clsLoadClass = contextClassLoader.loadClass(str);
                try {
                    f34186c.put(str, clsLoadClass);
                    return clsLoadClass;
                } catch (Exception e10) {
                    e8 = e10;
                    e8.printStackTrace();
                    cls = clsLoadClass;
                    cls = Class.forName(str);
                    f34186c.put(str, cls);
                    return cls;
                }
            }
        } catch (Exception e11) {
            Class<?> cls2 = cls;
            e8 = e11;
            clsLoadClass = cls2;
        }
        try {
            cls = Class.forName(str);
            f34186c.put(str, cls);
            return cls;
        } catch (Exception e12) {
            e12.printStackTrace();
            return cls;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean D(Class<?> cls, Member member, int i7) {
        if (member != 0 && f34185b) {
            Class<? super Object> superclass = cls.getSuperclass();
            if ((superclass == null || superclass == Object.class) && (member.getModifiers() & 1) != 0 && (i7 & 1) != 0) {
                return false;
            }
            try {
                ((AccessibleObject) member).setAccessible(true);
                return true;
            } catch (AccessControlException unused) {
                f34185b = false;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(Object obj, Class<T> cls, m mVar) {
        Object obj2;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(com.haier.library.json.a.f26646c)) ? (T) p(map, cls, mVar) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t7 = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                int i7 = 0;
                while (it.hasNext()) {
                    Array.set(t7, i7, a(it.next(), cls.getComponentType(), mVar));
                    i7++;
                }
                return t7;
            }
            if (cls == byte[].class) {
                return (T) h(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) f(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) g(obj);
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) r(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) n(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) q(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) m(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) k(obj);
        }
        if (cls == String.class) {
            return (T) s(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) d(obj);
        }
        if (cls == BigInteger.class) {
            return (T) e(obj);
        }
        if (cls == Date.class) {
            return (T) j(obj);
        }
        if (cls.isEnum()) {
            return (T) l(obj, cls, mVar);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            Date dateJ = j(obj);
            if (cls == Calendar.class) {
                obj2 = (T) Calendar.getInstance(com.haier.library.json.a.f26644a, com.haier.library.json.a.f26645b);
            } else {
                try {
                    obj2 = (T) ((Calendar) cls.newInstance());
                } catch (Exception e8) {
                    throw new com.haier.library.json.d("can not cast to : " + cls.getName(), e8);
                }
            }
            ((Calendar) obj2).setTime(dateJ);
            return (T) obj2;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if (cls == Currency.class) {
                return (T) Currency.getInstance(str);
            }
        }
        throw new com.haier.library.json.d("can not cast to : " + cls.getName());
    }

    /* JADX WARN: Type inference failed for: r8v5, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T b(Object obj, ParameterizedType parameterizedType, m mVar) {
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                T t7 = (rawType == Set.class || rawType == HashSet.class) ? (T) new HashSet() : rawType == TreeSet.class ? (T) new TreeSet() : (T) new ArrayList();
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t7).add(c(it.next(), type, mVar));
                }
                return t7;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r8 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r8.put(c(entry.getKey(), type2, mVar), c(entry.getValue(), type3, mVar));
                }
                return r8;
            }
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) c(obj, rawType, mVar);
        }
        throw new com.haier.library.json.d("can not cast to : " + parameterizedType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T c(Object obj, Type type, m mVar) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) a(obj, (Class) type, mVar);
        }
        if (type instanceof ParameterizedType) {
            return (T) b(obj, (ParameterizedType) type, mVar);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new com.haier.library.json.d("can not cast to : " + type);
    }

    public static final BigDecimal d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return new BigDecimal(string);
    }

    public static final BigInteger e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return new BigInteger(string);
    }

    public static final Boolean f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if (com.paytm.pgsdk.d.G.equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new com.haier.library.json.d("can not cast to int, value : " + obj);
    }

    public static final Byte g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (!(obj instanceof String)) {
            throw new com.haier.library.json.d("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str)) {
            return null;
        }
        return Byte.valueOf(Byte.parseByte(str));
    }

    public static final byte[] h(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return e.j((String) obj);
        }
        throw new com.haier.library.json.d("can not cast to int, value : " + obj);
    }

    public static final Character i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new com.haier.library.json.d("can not cast to byte, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new com.haier.library.json.d("can not cast to byte, value : " + obj);
    }

    public static final Date j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : -1L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.indexOf(45) != -1) {
                int length = str.length();
                String str2 = com.haier.library.json.a.f26647d;
                if (length != 19) {
                    if (str.length() == 10) {
                        str2 = "yyyy-MM-dd";
                    } else if (str.length() != 19) {
                        str2 = "yyyy-MM-dd HH:mm:ss.SSS";
                    }
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, com.haier.library.json.a.f26645b);
                simpleDateFormat.setTimeZone(com.haier.library.json.a.f26644a);
                try {
                    return simpleDateFormat.parse(str);
                } catch (ParseException unused) {
                    throw new com.haier.library.json.d("can not cast to Date, value : " + str);
                }
            }
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            jLongValue = Long.parseLong(str);
        }
        if (jLongValue >= 0) {
            return new Date(jLongValue);
        }
        throw new com.haier.library.json.d("can not cast to Date, value : " + obj);
    }

    public static final Double k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            throw new com.haier.library.json.d("can not cast to double, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    public static final <T> T l(Object obj, Class<T> cls, m mVar) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            throw new com.haier.library.json.d("can not cast to : " + cls.getName());
        } catch (Exception e8) {
            throw new com.haier.library.json.d("can not cast to : " + cls.getName(), e8);
        }
    }

    public static final Float m(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            throw new com.haier.library.json.d("can not cast to float, value : " + obj);
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string)) {
            return null;
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static final Integer n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (!(obj instanceof String)) {
            throw new com.haier.library.json.d("can not cast to int, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str)) {
            return null;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public static final <T> T o(Object obj, Class<T> cls) {
        return (T) a(obj, cls, m.f26768d);
    }

    public static final <T> T p(Map<String, Object> map, Class<T> cls, m mVar) {
        int iIntValue = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    iIntValue = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValue);
            }
            Object obj = map.get(com.haier.library.json.a.f26646c);
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> clsC = C(str4, null);
                if (clsC == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsC.equals(cls)) {
                    return (T) p(map, clsC, mVar);
                }
            }
            if (cls.isInterface()) {
                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, map instanceof com.haier.library.json.e ? (com.haier.library.json.e) map : new com.haier.library.json.e(map));
            }
            if (mVar == null) {
                mVar = m.f26768d;
            }
            f fVarC = mVar.c(cls);
            g gVar = fVarC instanceof g ? (g) fVarC : null;
            if (gVar != null) {
                return (T) gVar.c(map, mVar);
            }
            throw new com.haier.library.json.d("can not get javaBeanDeserializer");
        } catch (Exception e8) {
            throw new com.haier.library.json.d(e8.getMessage(), e8);
        }
    }

    public static final Long q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                e eVar = new e(str);
                Calendar calendarM = eVar.L(false) ? eVar.m() : null;
                eVar.f();
                if (calendarM != null) {
                    return Long.valueOf(calendarM.getTimeInMillis());
                }
            }
        }
        throw new com.haier.library.json.d("can not cast to long, value : " + obj);
    }

    public static final Short r(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (!(obj instanceof String)) {
            throw new com.haier.library.json.d("can not cast to short, value : " + obj);
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str)) {
            return null;
        }
        return Short.valueOf(Short.parseShort(str));
    }

    public static final String s(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* JADX WARN: Code duplicated, block: B:138:0x02f7 A[PHI: r0
      0x02f7: PHI (r0v38 java.lang.String) = (r0v37 java.lang.String), (r0v41 java.lang.String) binds: [B:134:0x02ec, B:136:0x02f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:139:0x0319  */
    /* JADX WARN: Code duplicated, block: B:208:0x044d  */
    /* JADX WARN: Code duplicated, block: B:210:0x0452 A[LOOP:6: B:209:0x0450->B:210:0x0452, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:211:0x0460  */
    /* JADX WARN: Code duplicated, block: B:214:0x046e A[LOOP:7: B:212:0x0468->B:214:0x046e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:216:0x047a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0220 A[PHI: r12 r21 r22 r27 r28 r29
      0x0220: PHI (r12v19 java.lang.reflect.Field[]) = 
      (r10v4 java.lang.reflect.Field[])
      (r10v4 java.lang.reflect.Field[])
      (r10v4 java.lang.reflect.Field[])
      (r10v4 java.lang.reflect.Field[])
      (r10v4 java.lang.reflect.Field[])
      (r12v22 java.lang.reflect.Field[])
     binds: [B:45:0x011c, B:47:0x0124, B:60:0x016e, B:62:0x0178, B:65:0x0186, B:39:0x00b2] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r21v4 int) = (r5v6 int), (r5v6 int), (r5v6 int), (r5v6 int), (r5v6 int), (r21v7 int) binds: [B:45:0x011c, B:47:0x0124, B:60:0x016e, B:62:0x0178, B:65:0x0186, B:39:0x00b2] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r22v4 int) = (r6v5 int), (r6v5 int), (r6v5 int), (r6v5 int), (r6v5 int), (r22v7 int) binds: [B:45:0x011c, B:47:0x0124, B:60:0x016e, B:62:0x0178, B:65:0x0186, B:39:0x00b2] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r27v4 java.lang.reflect.Method[]) = 
      (r7v8 java.lang.reflect.Method[])
      (r7v8 java.lang.reflect.Method[])
      (r7v8 java.lang.reflect.Method[])
      (r7v8 java.lang.reflect.Method[])
      (r7v8 java.lang.reflect.Method[])
      (r27v6 java.lang.reflect.Method[])
     binds: [B:45:0x011c, B:47:0x0124, B:60:0x016e, B:62:0x0178, B:65:0x0186, B:39:0x00b2] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r28v5 java.lang.Class<g3.b>) = 
      (r8v4 java.lang.Class<g3.b>)
      (r8v4 java.lang.Class<g3.b>)
      (r8v4 java.lang.Class<g3.b>)
      (r8v4 java.lang.Class<g3.b>)
      (r8v4 java.lang.Class<g3.b>)
      (r28v7 java.lang.Class<g3.b>)
     binds: [B:45:0x011c, B:47:0x0124, B:60:0x016e, B:62:0x0178, B:65:0x0186, B:39:0x00b2] A[DONT_GENERATE, DONT_INLINE]
      0x0220: PHI (r29v7 java.lang.Class<? super ?>) = 
      (r9v5 java.lang.Class<? super ?>)
      (r9v5 java.lang.Class<? super ?>)
      (r9v5 java.lang.Class<? super ?>)
      (r9v5 java.lang.Class<? super ?>)
      (r9v5 java.lang.Class<? super ?>)
      (r29v9 java.lang.Class<? super ?>)
     binds: [B:45:0x011c, B:47:0x0124, B:60:0x016e, B:62:0x0178, B:65:0x0186, B:39:0x00b2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Instruction removed from duplicated block: B:208:0x044d, please report this as an issue */
    public static List<a> t(Class<?> cls, int i7, boolean z7, g3.d dVar, Map<String, String> map, boolean z8, boolean z9, boolean z10) {
        String[] strArrOrders;
        boolean z11;
        Iterator it;
        int i8;
        int i9;
        int i10;
        Class<g3.b> cls2;
        Field[] fieldArr;
        int iOrdinal;
        int iA;
        Method method;
        Field[] fieldArr2;
        Class<g3.b> cls3;
        String strSubstring;
        g3.b bVar;
        int i11;
        int i12;
        String strU;
        int i13;
        int i14;
        g3.b bVar2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = cls.getDeclaredFields();
        Class<? super Object> cls4 = Object.class;
        Class<g3.b> cls5 = g3.b.class;
        if (!z7) {
            Method[] methods = cls.getMethods();
            int length = methods.length;
            int i15 = 0;
            while (i15 < length) {
                Method method2 = methods[i15];
                String name = method2.getName();
                if ((method2.getModifiers() & 8) != 0 || method2.getReturnType().equals(Void.TYPE) || method2.getParameterTypes().length != 0 || method2.getReturnType() == ClassLoader.class || method2.getDeclaringClass() == cls4 || (name.equals("getMetaClass") && method2.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                    i15 = i15;
                    length = length;
                    methods = methods;
                    cls2 = cls5;
                    cls4 = cls4;
                    fieldArr = declaredFields;
                } else {
                    g3.b bVarZ = z9 ? (g3.b) method2.getAnnotation(cls5) : null;
                    if (bVarZ == null && z9) {
                        bVarZ = z(cls, method2);
                    }
                    g3.b bVar3 = bVarZ;
                    if (bVar3 != null) {
                        if (bVar3.serialize()) {
                            iOrdinal = bVar3.ordinal();
                            iA = a0.a(bVar3.serialzeFeatures());
                            if (bVar3.name().length() != 0) {
                                String strName = bVar3.name();
                                if (map == 0 || (strName = map.get(strName)) != null) {
                                    String str = strName;
                                    D(cls, method2, i7);
                                    i15 = i15;
                                    length = length;
                                    methods = methods;
                                    cls5 = cls5;
                                    cls4 = cls4;
                                    declaredFields = declaredFields;
                                    linkedHashMap.put(str, new a(str, method2, null, cls, null, iOrdinal, iA, bVar3, null, true));
                                }
                            }
                            fieldArr = declaredFields;
                            cls2 = cls5;
                        }
                        i15 = i15;
                        length = length;
                        methods = methods;
                        cls2 = cls5;
                        cls4 = cls4;
                        fieldArr = declaredFields;
                    } else {
                        iOrdinal = 0;
                        iA = 0;
                    }
                    if (!name.startsWith("get")) {
                        method = method2;
                        fieldArr2 = declaredFields;
                        cls3 = cls5;
                    } else if (name.length() < 4 || name.equals("getClass")) {
                        fieldArr = declaredFields;
                        cls2 = cls5;
                    } else {
                        char cCharAt = name.charAt(3);
                        if (Character.isUpperCase(cCharAt)) {
                            strU = f34184a ? u(name.substring(3)) : Character.toLowerCase(name.charAt(3)) + name.substring(4);
                        } else if (cCharAt == '_') {
                            strU = name.substring(4);
                        } else if (cCharAt == 'f') {
                            strU = name.substring(3);
                        } else if (name.length() < 5 || !Character.isUpperCase(name.charAt(4))) {
                            fieldArr = declaredFields;
                            cls2 = cls5;
                        } else {
                            strU = u(name.substring(3));
                        }
                        if (B(cls, dVar, strU)) {
                            fieldArr = declaredFields;
                            cls2 = cls5;
                        } else {
                            Field fieldW = w(cls, strU, declaredFields);
                            Class<g3.b> cls6 = cls5;
                            if (fieldW != null) {
                                g3.b bVar4 = z9 ? (g3.b) fieldW.getAnnotation(cls6) : null;
                                if (bVar4 != null) {
                                    if (bVar4.serialize()) {
                                        int iOrdinal2 = bVar4.ordinal();
                                        int iA2 = a0.a(bVar4.serialzeFeatures());
                                        if (bVar4.name().length() != 0) {
                                            strU = bVar4.name();
                                            if (map == 0 || (strU = map.get(strU)) != null) {
                                            }
                                        }
                                        bVar2 = bVar4;
                                        i14 = iOrdinal2;
                                        i13 = iA2;
                                    }
                                    fieldArr = declaredFields;
                                    cls2 = cls6;
                                } else {
                                    i13 = iA;
                                    i14 = iOrdinal;
                                    bVar2 = bVar4;
                                }
                            } else {
                                i13 = iA;
                                i14 = iOrdinal;
                                bVar2 = null;
                            }
                            if (map == 0 || (strU = map.get(strU)) != null) {
                                String str2 = strU;
                                D(cls, method2, i7);
                                method = method2;
                                cls3 = cls6;
                                fieldArr2 = declaredFields;
                                linkedHashMap.put(str2, new a(str2, method2, fieldW, cls, null, i14, i13, bVar3, bVar2, z10));
                                iOrdinal = i14;
                                iA = i13;
                            } else {
                                fieldArr = declaredFields;
                                cls2 = cls6;
                            }
                        }
                    }
                    if (!name.startsWith("is") || name.length() < 3) {
                        fieldArr = fieldArr2;
                        cls2 = cls3;
                    } else {
                        char cCharAt2 = name.charAt(2);
                        if (Character.isUpperCase(cCharAt2)) {
                            strSubstring = f34184a ? u(name.substring(2)) : Character.toLowerCase(name.charAt(2)) + name.substring(3);
                        } else if (cCharAt2 == '_') {
                            strSubstring = name.substring(3);
                        } else if (cCharAt2 == 'f') {
                            strSubstring = name.substring(2);
                        } else {
                            fieldArr = fieldArr2;
                            cls2 = cls3;
                        }
                        fieldArr = fieldArr2;
                        Field fieldW2 = w(cls, strSubstring, fieldArr);
                        if (fieldW2 == null) {
                            fieldW2 = w(cls, name, fieldArr);
                        }
                        if (fieldW2 != null) {
                            cls2 = cls3;
                            g3.b bVar5 = z9 ? (g3.b) fieldW2.getAnnotation(cls2) : null;
                            if (bVar5 == null) {
                                bVar = bVar5;
                            } else if (bVar5.serialize()) {
                                int iOrdinal3 = bVar5.ordinal();
                                int iA3 = a0.a(bVar5.serialzeFeatures());
                                if (bVar5.name().length() != 0) {
                                    strSubstring = bVar5.name();
                                    map = map;
                                    fieldArr = fieldArr;
                                    if (map == null || (strSubstring = map.get(strSubstring)) != null) {
                                    }
                                } else {
                                    map = map;
                                    fieldArr = fieldArr;
                                }
                                bVar = bVar5;
                                i11 = iOrdinal3;
                                i12 = iA3;
                                if (map != null || (strSubstring = map.get(strSubstring)) != null) {
                                    String str3 = strSubstring;
                                    D(cls, fieldW2, i7);
                                    Method method3 = method;
                                    D(cls, method3, i7);
                                    linkedHashMap.put(str3, new a(str3, method3, fieldW2, cls, null, i11, i12, bVar3, bVar, z10));
                                }
                            } else {
                                fieldArr = fieldArr;
                            }
                        } else {
                            cls2 = cls3;
                            bVar = null;
                        }
                        i11 = iOrdinal;
                        i12 = iA;
                        if (map != null) {
                            String str4 = strSubstring;
                            D(cls, fieldW2, i7);
                            Method method4 = method;
                            D(cls, method4, i7);
                            linkedHashMap.put(str4, new a(str4, method4, fieldW2, cls, null, i11, i12, bVar3, bVar, z10));
                        } else {
                            String str5 = strSubstring;
                            D(cls, fieldW2, i7);
                            Method method5 = method;
                            D(cls, method5, i7);
                            linkedHashMap.put(str5, new a(str5, method5, fieldW2, cls, null, i11, i12, bVar3, bVar, z10));
                        }
                    }
                }
                i15++;
                cls5 = cls2;
                declaredFields = fieldArr;
                length = length;
                methods = methods;
                cls4 = cls4;
            }
        }
        Class<g3.b> cls7 = cls5;
        Class<? super Object> cls8 = cls4;
        Field[] fieldArr3 = declaredFields;
        ArrayList<Field> arrayList = new ArrayList(fieldArr3.length);
        for (Field field : fieldArr3) {
            if ((field.getModifiers() & 8) == 0 && (field.getModifiers() & 1) != 0) {
                arrayList.add(field);
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        while (superclass != null) {
            Class<? super Object> cls9 = cls8;
            if (superclass == cls9) {
                break;
            }
            for (Field field2 : superclass.getDeclaredFields()) {
                if ((field2.getModifiers() & 8) == 0 && (field2.getModifiers() & 1) != 0) {
                    arrayList.add(field2);
                }
            }
            superclass = superclass.getSuperclass();
            cls8 = cls9;
        }
        for (Field field3 : arrayList) {
            g3.b bVar6 = z9 ? (g3.b) field3.getAnnotation(cls7) : null;
            String name2 = field3.getName();
            if (bVar6 == null) {
                i9 = 0;
                i10 = 0;
            } else if (bVar6.serialize()) {
                int iOrdinal4 = bVar6.ordinal();
                int iA4 = a0.a(bVar6.serialzeFeatures());
                if (bVar6.name().length() != 0) {
                    name2 = bVar6.name();
                }
                i9 = iOrdinal4;
                i10 = iA4;
            }
            if (map == 0 || (name2 = map.get(name2)) != null) {
                String str6 = name2;
                if (!linkedHashMap.containsKey(str6)) {
                    D(cls, field3, i7);
                    linkedHashMap.put(str6, new a(str6, null, field3, cls, null, i9, i10, null, bVar6, z10));
                }
                cls7 = cls7;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (dVar != null) {
            strArrOrders = dVar.orders();
            if (strArrOrders != null && strArrOrders.length == linkedHashMap.size()) {
                int length2 = strArrOrders.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length2) {
                        z11 = true;
                        break;
                    }
                    if (linkedHashMap.containsKey(strArrOrders[i16])) {
                        i16++;
                    }
                }
            }
            if (z11) {
                for (String str7 : strArrOrders) {
                    arrayList2.add((a) linkedHashMap.get(str7));
                }
            } else {
                it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    arrayList2.add((a) it.next());
                }
                if (z8) {
                    Collections.sort(arrayList2);
                }
            }
            return arrayList2;
        }
        strArrOrders = null;
        z11 = false;
        if (z11) {
            while (i8 < r2) {
                arrayList2.add((a) linkedHashMap.get(str7));
            }
        } else {
            it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                arrayList2.add((a) it.next());
            }
            if (z8) {
                Collections.sort(arrayList2);
            }
        }
        return arrayList2;
    }

    public static String u(String str) {
        if (str == null || str.length() == 0 || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Class<?> v(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return v(((ParameterizedType) type).getRawType());
        }
        return type instanceof TypeVariable ? (Class) ((TypeVariable) type).getBounds()[0] : Object.class;
    }

    public static Field w(Class<?> cls, String str, Field[] fieldArr) {
        Field fieldX = x(cls, str, fieldArr);
        if (fieldX == null) {
            fieldX = x(cls, "_" + str, fieldArr);
        }
        if (fieldX == null) {
            fieldX = x(cls, "m_" + str, fieldArr);
        }
        if (fieldX != null) {
            return fieldX;
        }
        return x(cls, "m" + str.substring(0, 1).toUpperCase() + str.substring(1), fieldArr);
    }

    private static Field x(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return w(superclass, str, superclass.getDeclaredFields());
    }

    public static Type y(Type type) {
        return type instanceof Class ? y(((Class) type).getGenericSuperclass()) : type;
    }

    public static g3.b z(Class<?> cls, Method method) {
        boolean z7;
        g3.b bVar;
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName())) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    Class<?>[] parameterTypes2 = method.getParameterTypes();
                    if (parameterTypes.length != parameterTypes2.length) {
                        continue;
                    } else {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= parameterTypes.length) {
                                z7 = true;
                                break;
                            }
                            if (!parameterTypes[i7].equals(parameterTypes2[i7])) {
                                z7 = false;
                                break;
                            }
                            i7++;
                        }
                        if (z7 && (bVar = (g3.b) method2.getAnnotation(g3.b.class)) != null) {
                            return bVar;
                        }
                    }
                }
            }
        }
        return null;
    }
}
