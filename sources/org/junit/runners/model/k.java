package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class k implements org.junit.runners.model.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f40054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f40055e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f40056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<? extends Annotation>, List<d>> f40057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<? extends Annotation>, List<org.junit.runners.model.b>> f40058c;

    private static class b implements Comparator<Field> {
        private b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    private static class c implements Comparator<d> {
        private c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return org.junit.internal.h.f39843b.compare(dVar.j(), dVar2.j());
        }
    }

    static {
        f40054d = new b();
        f40055e = new c();
    }

    public k(Class<?> cls) {
        this.f40056a = cls;
        if (cls != null && cls.getConstructors().length > 1) {
            throw new IllegalArgumentException("Test class can only have one constructor");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        s(linkedHashMap, linkedHashMap2);
        this.f40057b = q(linkedHashMap);
        this.f40058c = q(linkedHashMap2);
    }

    protected static <T extends org.junit.runners.model.c<T>> void a(T t7, Map<Class<? extends Annotation>, List<T>> map) {
        for (Annotation annotation : t7.getAnnotations()) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            List<T> listF = f(map, clsAnnotationType, true);
            if (t7.f(listF)) {
                return;
            }
            if (r(clsAnnotationType)) {
                listF.add(0, t7);
            } else {
                listF.add(t7);
            }
        }
    }

    private <T> List<T> b(Map<?, List<T>> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<List<T>> it = map.values().iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(it.next());
        }
        return new ArrayList(linkedHashSet);
    }

    private static <T> List<T> f(Map<Class<? extends Annotation>, List<T>> map, Class<? extends Annotation> cls, boolean z7) {
        if (!map.containsKey(cls) && z7) {
            map.put(cls, new ArrayList());
        }
        List<T> list = map.get(cls);
        return list == null ? Collections.emptyList() : list;
    }

    private static Field[] m(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.sort(declaredFields, f40054d);
        return declaredFields;
    }

    private static List<Class<?>> n(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    private static <T extends org.junit.runners.model.c<T>> Map<Class<? extends Annotation>, List<T>> q(Map<Class<? extends Annotation>, List<T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Class<? extends Annotation>, List<T>> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private static boolean r(Class<? extends Annotation> cls) {
        return cls.equals(org.junit.f.class) || cls.equals(org.junit.g.class);
    }

    public <T> List<T> c(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runners.model.b> it = e(cls).iterator();
        while (it.hasNext()) {
            try {
                Object objI = it.next().i(obj);
                if (cls2.isInstance(objI)) {
                    arrayList.add(cls2.cast(objI));
                }
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e8);
            }
        }
        return arrayList;
    }

    public List<org.junit.runners.model.b> d() {
        return b(this.f40058c);
    }

    public List<org.junit.runners.model.b> e(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(f(this.f40058c, cls, false));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f40056a == ((k) obj).f40056a;
    }

    public <T> List<T> g(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (d dVar : i(cls)) {
            try {
                if (cls2.isAssignableFrom(dVar.l())) {
                    arrayList.add(cls2.cast(dVar.m(obj, new Object[0])));
                }
            } catch (Throwable th) {
                throw new RuntimeException("Exception in " + dVar.c(), th);
            }
        }
        return arrayList;
    }

    @Override // org.junit.runners.model.a
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        Class<?> cls2 = this.f40056a;
        if (cls2 == null) {
            return null;
        }
        return (T) cls2.getAnnotation(cls);
    }

    @Override // org.junit.runners.model.a
    public Annotation[] getAnnotations() {
        Class<?> cls = this.f40056a;
        return cls == null ? new Annotation[0] : cls.getAnnotations();
    }

    public List<d> h() {
        List<d> listB = b(this.f40057b);
        Collections.sort(listB, f40055e);
        return listB;
    }

    public int hashCode() {
        Class<?> cls = this.f40056a;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public List<d> i(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(f(this.f40057b, cls, false));
    }

    public Class<?> j() {
        return this.f40056a;
    }

    public String k() {
        Class<?> cls = this.f40056a;
        return cls == null ? "null" : cls.getName();
    }

    public Constructor<?> l() {
        Constructor<?>[] constructors = this.f40056a.getConstructors();
        org.junit.c.v(1L, constructors.length);
        return constructors[0];
    }

    public boolean o() {
        return this.f40056a.isMemberClass() && !Modifier.isStatic(this.f40056a.getModifiers());
    }

    public boolean p() {
        return Modifier.isPublic(this.f40056a.getModifiers());
    }

    protected void s(Map<Class<? extends Annotation>, List<d>> map, Map<Class<? extends Annotation>, List<org.junit.runners.model.b>> map2) {
        for (Class<?> cls : n(this.f40056a)) {
            for (Method method : org.junit.internal.h.a(cls)) {
                a(new d(method), map);
            }
            for (Field field : m(cls)) {
                a(new org.junit.runners.model.b(field), map2);
            }
        }
    }
}
