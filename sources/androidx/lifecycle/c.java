package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static c f8253c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8254d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f8255e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8256f = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, a> f8257a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f8258b = new HashMap();

    @Deprecated
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<m.b, List<b>> f8259a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<b, m.b> f8260b;

        a(Map<b, m.b> map) {
            this.f8260b = map;
            for (Map.Entry<b, m.b> entry : map.entrySet()) {
                m.b value = entry.getValue();
                List<b> arrayList = this.f8259a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f8259a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        private static void b(List<b> list, q qVar, m.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(qVar, bVar, obj);
                }
            }
        }

        void a(q qVar, m.b bVar, Object obj) {
            b(this.f8259a.get(bVar), qVar, bVar, obj);
            b(this.f8259a.get(m.b.ON_ANY), qVar, bVar, obj);
        }
    }

    @Deprecated
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f8261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f8262b;

        b(int i7, Method method) {
            this.f8261a = i7;
            this.f8262b = method;
            method.setAccessible(true);
        }

        void a(q qVar, m.b bVar, Object obj) {
            try {
                int i7 = this.f8261a;
                if (i7 == 0) {
                    this.f8262b.invoke(obj, new Object[0]);
                } else if (i7 == 1) {
                    this.f8262b.invoke(obj, qVar);
                } else {
                    if (i7 != 2) {
                        return;
                    }
                    this.f8262b.invoke(obj, qVar, bVar);
                }
            } catch (IllegalAccessException e8) {
                throw new RuntimeException(e8);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException("Failed to call observer method", e9.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f8261a == bVar.f8261a && this.f8262b.getName().equals(bVar.f8262b.getName());
        }

        public int hashCode() {
            return (this.f8261a * 31) + this.f8262b.getName().hashCode();
        }
    }

    c() {
    }

    private a a(Class<?> cls, @c.o0 Method[] methodArr) {
        int i7;
        a aVarC;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarC = c(superclass)) != null) {
            map.putAll(aVarC.f8260b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, m.b> entry : c(cls2).f8260b.entrySet()) {
                e(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z7 = false;
        for (Method method : methodArr) {
            y yVar = (y) method.getAnnotation(y.class);
            if (yVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i7 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(q.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i7 = 1;
                }
                m.b bVarValue = yVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(m.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (bVarValue != m.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i7 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(map, new b(i7, method), bVarValue, cls);
                z7 = true;
            }
        }
        a aVar = new a(map);
        this.f8257a.put(cls, aVar);
        this.f8258b.put(cls, Boolean.valueOf(z7));
        return aVar;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e8) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e8);
        }
    }

    private void e(Map<b, m.b> map, b bVar, m.b bVar2, Class<?> cls) {
        m.b bVar3 = map.get(bVar);
        if (bVar3 == null || bVar2 == bVar3) {
            if (bVar3 == null) {
                map.put(bVar, bVar2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f8262b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar3 + ", new value " + bVar2);
    }

    a c(Class<?> cls) {
        a aVar = this.f8257a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f8258b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrB = b(cls);
        for (Method method : methodArrB) {
            if (((y) method.getAnnotation(y.class)) != null) {
                a(cls, methodArrB);
                return true;
            }
        }
        this.f8258b.put(cls, Boolean.FALSE);
        return false;
    }
}
