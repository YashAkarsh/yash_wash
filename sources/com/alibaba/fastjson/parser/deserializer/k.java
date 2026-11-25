package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.alibaba.fastjson.util.e f12897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Class<?> f12898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.alibaba.fastjson.serializer.p f12899c;

    public k(Class<?> cls, com.alibaba.fastjson.util.e eVar) {
        this.f12898b = cls;
        this.f12897a = eVar;
    }

    public int a() {
        return 0;
    }

    public abstract void b(com.alibaba.fastjson.parser.b bVar, Object obj, Type type, Map<String, Object> map);

    public void c(Object obj, int i7) {
        e(obj, Integer.valueOf(i7));
    }

    public void d(Object obj, long j7) {
        e(obj, Long.valueOf(j7));
    }

    public void e(Object obj, Object obj2) {
        String str;
        if (obj2 == null && this.f12897a.f13297e.isPrimitive()) {
            return;
        }
        com.alibaba.fastjson.util.e eVar = this.f12897a;
        if (eVar.f13297e == String.class && (str = eVar.f13312t) != null && str.equals("trim")) {
            obj2 = ((String) obj2).trim();
        }
        try {
            com.alibaba.fastjson.util.e eVar2 = this.f12897a;
            Method method = eVar2.f13294b;
            if (method != null) {
                if (!eVar2.f13300h) {
                    method.invoke(obj, obj2);
                    return;
                }
                Class<?> cls = eVar2.f13297e;
                if (cls == AtomicInteger.class) {
                    AtomicInteger atomicInteger = (AtomicInteger) method.invoke(obj, new Object[0]);
                    if (atomicInteger != null) {
                        atomicInteger.set(((AtomicInteger) obj2).get());
                        return;
                    }
                    return;
                }
                if (cls == AtomicLong.class) {
                    AtomicLong atomicLong = (AtomicLong) method.invoke(obj, new Object[0]);
                    if (atomicLong != null) {
                        atomicLong.set(((AtomicLong) obj2).get());
                        return;
                    }
                    return;
                }
                if (cls == AtomicBoolean.class) {
                    AtomicBoolean atomicBoolean = (AtomicBoolean) method.invoke(obj, new Object[0]);
                    if (atomicBoolean != null) {
                        atomicBoolean.set(((AtomicBoolean) obj2).get());
                        return;
                    }
                    return;
                }
                if (Map.class.isAssignableFrom(method.getReturnType())) {
                    Map map = (Map) method.invoke(obj, new Object[0]);
                    if (map != null && map != Collections.emptyMap() && !map.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                        map.putAll((Map) obj2);
                        return;
                    }
                    return;
                }
                Collection collection = (Collection) method.invoke(obj, new Object[0]);
                if (collection != null && obj2 != null && collection != Collections.emptySet() && collection != Collections.emptyList() && !collection.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    collection.clear();
                    collection.addAll((Collection) obj2);
                    return;
                }
                return;
            }
            Field field = eVar2.f13295c;
            if (!eVar2.f13300h) {
                if (field != null) {
                    field.set(obj, obj2);
                    return;
                }
                return;
            }
            Class<?> cls2 = eVar2.f13297e;
            if (cls2 == AtomicInteger.class) {
                AtomicInteger atomicInteger2 = (AtomicInteger) field.get(obj);
                if (atomicInteger2 != null) {
                    atomicInteger2.set(((AtomicInteger) obj2).get());
                    return;
                }
                return;
            }
            if (cls2 == AtomicLong.class) {
                AtomicLong atomicLong2 = (AtomicLong) field.get(obj);
                if (atomicLong2 != null) {
                    atomicLong2.set(((AtomicLong) obj2).get());
                    return;
                }
                return;
            }
            if (cls2 == AtomicBoolean.class) {
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) field.get(obj);
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(((AtomicBoolean) obj2).get());
                    return;
                }
                return;
            }
            if (Map.class.isAssignableFrom(cls2)) {
                Map map2 = (Map) field.get(obj);
                if (map2 != null && map2 != Collections.emptyMap() && !map2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                    map2.putAll((Map) obj2);
                    return;
                }
                return;
            }
            Collection collection2 = (Collection) field.get(obj);
            if (collection2 != null && obj2 != null && collection2 != Collections.emptySet() && collection2 != Collections.emptyList() && !collection2.getClass().getName().startsWith("java.util.Collections$Unmodifiable")) {
                collection2.clear();
                collection2.addAll((Collection) obj2);
            }
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d("set property error, " + this.f12897a.f13293a, e8);
        }
    }

    public void f(Object obj, String str) {
        e(obj, str);
    }

    public void g(Object obj, boolean z7) {
        e(obj, Boolean.valueOf(z7));
    }

    public void h(String str, Object obj) {
        throw new com.alibaba.fastjson.d("TODO");
    }
}
