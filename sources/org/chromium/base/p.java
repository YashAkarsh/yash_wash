package org.chromium.base;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f38855b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<b<?>> f38856a = Collections.newSetFromMap(new WeakHashMap());

    public static class b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f38857b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.o0
        private T f38858a;

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f38858a = null;
        }

        @c.o0
        public T c() {
            return this.f38858a;
        }

        private b(T t7) {
            this.f38858a = t7;
        }
    }

    public void a() {
        Iterator<b<?>> it = this.f38856a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f38856a.clear();
    }

    public <T> b<T> b(T t7) {
        b<T> bVar = new b<>(t7);
        this.f38856a.add(bVar);
        return bVar;
    }

    public void c(b<?> bVar) {
        if (this.f38856a.contains(bVar)) {
            bVar.b();
            this.f38856a.remove(bVar);
        }
    }
}
