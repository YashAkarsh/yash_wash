package androidx.lifecycle;

import c.x0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class Lifecycling {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8214a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f8215b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<Class<?>, Integer> f8216c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends i>>> f8217d = new HashMap();

    private Lifecycling() {
    }

    private static i a(Constructor<? extends i> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (InstantiationException e9) {
            throw new RuntimeException(e9);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @c.o0
    private static Constructor<? extends i> b(Class<?> cls) {
        try {
            Package r7 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r7 != null ? r7.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strC = c(canonicalName);
            if (!name.isEmpty()) {
                strC = name + com.alibaba.android.arouter.utils.b.f12515h + strC;
            }
            Constructor declaredConstructor = Class.forName(strC).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException(e8);
        }
    }

    public static String c(String str) {
        return str.replace(com.alibaba.android.arouter.utils.b.f12515h, "_") + "_LifecycleAdapter";
    }

    @c.m0
    @Deprecated
    static j d(Object obj) {
        final o oVarG = g(obj);
        return new j() { // from class: androidx.lifecycle.Lifecycling.1
            @Override // androidx.lifecycle.o
            public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
                oVarG.g(qVar, bVar);
            }
        };
    }

    private static int e(Class<?> cls) {
        Integer num = f8216c.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iH = h(cls);
        f8216c.put(cls, Integer.valueOf(iH));
        return iH;
    }

    private static boolean f(Class<?> cls) {
        return cls != null && p.class.isAssignableFrom(cls);
    }

    @c.m0
    static o g(Object obj) {
        boolean z7 = obj instanceof o;
        boolean z8 = obj instanceof h;
        if (z7 && z8) {
            return new FullLifecycleObserverAdapter((h) obj, (o) obj);
        }
        if (z8) {
            return new FullLifecycleObserverAdapter((h) obj, null);
        }
        if (z7) {
            return (o) obj;
        }
        Class<?> cls = obj.getClass();
        if (e(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends i>> list = f8217d.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
        }
        i[] iVarArr = new i[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iVarArr[i7] = a(list.get(i7), obj);
        }
        return new CompositeGeneratedAdaptersObserver(iVarArr);
    }

    private static int h(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends i> constructorB = b(cls);
        if (constructorB != null) {
            f8217d.put(cls, Collections.singletonList(constructorB));
            return 2;
        }
        if (c.f8253c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (!f(superclass)) {
            arrayList = null;
        } else {
            if (e(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f8217d.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (f(cls2)) {
                if (e(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f8217d.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f8217d.put(cls, arrayList);
        return 2;
    }
}
