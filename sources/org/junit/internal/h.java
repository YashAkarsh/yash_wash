package org.junit.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<Method> f39842a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator<Method> f39843b = new b();

    static class a implements Comparator<Method> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            int iHashCode = method.getName().hashCode();
            int iHashCode2 = method2.getName().hashCode();
            if (iHashCode != iHashCode2) {
                return iHashCode < iHashCode2 ? -1 : 1;
            }
            return h.f39843b.compare(method, method2);
        }
    }

    static class b implements Comparator<Method> {
        b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            return iCompareTo != 0 ? iCompareTo : method.toString().compareTo(method2.toString());
        }
    }

    private h() {
    }

    public static Method[] a(Class<?> cls) {
        Comparator<Method> comparatorB = b((org.junit.j) cls.getAnnotation(org.junit.j.class));
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (comparatorB != null) {
            Arrays.sort(declaredMethods, comparatorB);
        }
        return declaredMethods;
    }

    private static Comparator<Method> b(org.junit.j jVar) {
        return jVar == null ? f39842a : jVar.value().a();
    }
}
