package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.internal.j;
import com.google.gson.stream.d;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f23037a;

    private static final class a<E> extends x<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x<E> f23038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j<? extends Collection<E>> f23039b;

        public a(f fVar, Type type, x<E> xVar, j<? extends Collection<E>> jVar) {
            this.f23038a = new c(fVar, xVar, type);
            this.f23039b = jVar;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Collection<E> e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            Collection<E> collectionA = this.f23039b.a();
            aVar.b();
            while (aVar.H()) {
                collectionA.add(this.f23038a.e(aVar));
            }
            aVar.C();
            return collectionA;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(d dVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                dVar.g0();
                return;
            }
            dVar.q();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f23038a.i(dVar, it.next());
            }
            dVar.u();
        }
    }

    public CollectionTypeAdapterFactory(com.google.gson.internal.c cVar) {
        this.f23037a = cVar;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeH = com.google.gson.internal.b.h(type, rawType);
        return new a(fVar, typeH, fVar.p(com.google.gson.reflect.a.get(typeH)), this.f23037a.a(aVar));
    }
}
