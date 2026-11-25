package com.google.common.eventbus;

import com.google.common.base.e0;
import com.google.common.base.r0;
import com.google.common.base.x;
import com.google.common.base.y;
import com.google.common.collect.ck;
import com.google.common.collect.d7;
import com.google.common.collect.ib;
import com.google.common.collect.p6;
import com.google.common.collect.tc;
import com.google.common.collect.u8;
import com.google.common.collect.ua;
import com.google.common.collect.wb;
import com.google.common.reflect.m;
import com.google.common.util.concurrent.n2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.common.cache.k<Class<?>, d7<Method>> f21573c = com.google.common.cache.e.F().P().b(new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.common.cache.k<Class<?>, u8<Class<?>>> f21574d = com.google.common.cache.e.F().P().b(new b());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<g>> f21575a = wb.f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @y1.i
    private final e f21576b;

    static class a extends com.google.common.cache.g<Class<?>, d7<Method>> {
        a() {
        }

        @Override // com.google.common.cache.g
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public d7<Method> d(Class<?> cls) throws Exception {
            return j.e(cls);
        }
    }

    static class b extends com.google.common.cache.g<Class<?>, u8<Class<?>>> {
        b() {
        }

        @Override // com.google.common.cache.g
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public u8<Class<?>> d(Class<?> cls) {
            return u8.p(m.V(cls).E().B0());
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Class<?>> f21578b;

        c(Method method) {
            this.f21577a = method.getName();
            this.f21578b = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f21577a.equals(cVar.f21577a) && this.f21578b.equals(cVar.f21578b);
        }

        public int hashCode() {
            return y.b(this.f21577a, this.f21578b);
        }
    }

    j(e eVar) {
        this.f21576b = (e) e0.E(eVar);
    }

    private tc<Class<?>, g> b(Object obj) {
        p6 p6VarV = p6.V();
        ck<Method> it = d(obj.getClass()).iterator();
        while (it.hasNext()) {
            Method next = it.next();
            p6VarV.put(next.getParameterTypes()[0], g.d(this.f21576b, obj, next));
        }
        return p6VarV;
    }

    @s1.d
    static u8<Class<?>> c(Class<?> cls) {
        try {
            return f21574d.o(cls);
        } catch (n2 e8) {
            throw r0.q(e8.getCause());
        }
    }

    private static d7<Method> d(Class<?> cls) {
        return f21573c.o(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d7<Method> e(Class<?> cls) {
        Set setB0 = m.V(cls).E().B0();
        HashMap mapI0 = wb.i0();
        Iterator it = setB0.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(f.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    e0.w(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                    c cVar = new c(method);
                    if (!mapI0.containsKey(cVar)) {
                        mapI0.put(cVar, method);
                    }
                }
            }
        }
        return d7.r(mapI0.values());
    }

    Iterator<g> f(Object obj) {
        u8<Class<?>> u8VarC = c(obj.getClass());
        ArrayList arrayListU = ib.u(u8VarC.size());
        ck<Class<?>> it = u8VarC.iterator();
        while (it.hasNext()) {
            CopyOnWriteArraySet<g> copyOnWriteArraySet = this.f21575a.get(it.next());
            if (copyOnWriteArraySet != null) {
                arrayListU.add(copyOnWriteArraySet.iterator());
            }
        }
        return ua.i(arrayListU.iterator());
    }

    @s1.d
    Set<g> g(Class<?> cls) {
        return (Set) x.a(this.f21575a.get(cls), u8.A());
    }

    void h(Object obj) {
        for (Map.Entry<Class<?>, Collection<g>> entry : b(obj).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<g> value = entry.getValue();
            CopyOnWriteArraySet<g> copyOnWriteArraySet = this.f21575a.get(key);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet<g> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
                copyOnWriteArraySet = (CopyOnWriteArraySet) x.a(this.f21575a.putIfAbsent(key, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(value);
        }
    }

    void i(Object obj) {
        for (Map.Entry<Class<?>, Collection<g>> entry : b(obj).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<g> value = entry.getValue();
            CopyOnWriteArraySet<g> copyOnWriteArraySet = this.f21575a.get(key);
            if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(value)) {
                throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + obj + " registered?");
            }
        }
    }
}
