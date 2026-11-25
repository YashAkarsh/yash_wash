package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.internal.j;
import com.google.gson.internal.m;
import com.google.gson.l;
import com.google.gson.r;
import com.google.gson.stream.d;
import com.google.gson.v;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f23043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f23044b;

    private final class a<K, V> extends x<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final x<K> f23045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x<V> f23046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j<? extends Map<K, V>> f23047c;

        public a(f fVar, Type type, x<K> xVar, Type type2, x<V> xVar2, j<? extends Map<K, V>> jVar) {
            this.f23045a = new c(fVar, xVar, type);
            this.f23046b = new c(fVar, xVar2, type2);
            this.f23047c = jVar;
        }

        private String j(l lVar) {
            if (!lVar.z()) {
                if (lVar.w()) {
                    return "null";
                }
                throw new AssertionError();
            }
            r rVarP = lVar.p();
            if (rVarP.F()) {
                return String.valueOf(rVarP.s());
            }
            if (rVarP.B()) {
                return Boolean.toString(rVarP.f());
            }
            if (rVarP.G()) {
                return rVarP.u();
            }
            throw new AssertionError();
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Map<K, V> e(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.c cVarJ0 = aVar.J0();
            if (cVarJ0 == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            Map<K, V> mapA = this.f23047c.a();
            if (cVarJ0 == com.google.gson.stream.c.BEGIN_ARRAY) {
                aVar.b();
                while (aVar.H()) {
                    aVar.b();
                    K kE = this.f23045a.e(aVar);
                    if (mapA.put(kE, this.f23046b.e(aVar)) != null) {
                        throw new v("duplicate key: " + kE);
                    }
                    aVar.C();
                }
                aVar.C();
            } else {
                aVar.e();
                while (aVar.H()) {
                    com.google.gson.internal.f.f23173a.a(aVar);
                    K kE2 = this.f23045a.e(aVar);
                    if (mapA.put(kE2, this.f23046b.e(aVar)) != null) {
                        throw new v("duplicate key: " + kE2);
                    }
                }
                aVar.E();
            }
            return mapA;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(d dVar, Map<K, V> map) throws IOException {
            if (map == null) {
                dVar.g0();
                return;
            }
            if (!MapTypeAdapterFactory.this.f23044b) {
                dVar.r();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    dVar.K(String.valueOf(entry.getKey()));
                    this.f23046b.i(dVar, entry.getValue());
                }
                dVar.C();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i7 = 0;
            boolean z7 = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                l lVarH = this.f23045a.h(entry2.getKey());
                arrayList.add(lVarH);
                arrayList2.add(entry2.getValue());
                z7 |= lVarH.v() || lVarH.x();
            }
            if (!z7) {
                dVar.r();
                int size = arrayList.size();
                while (i7 < size) {
                    dVar.K(j((l) arrayList.get(i7)));
                    this.f23046b.i(dVar, (V) arrayList2.get(i7));
                    i7++;
                }
                dVar.C();
                return;
            }
            dVar.q();
            int size2 = arrayList.size();
            while (i7 < size2) {
                dVar.q();
                m.b((l) arrayList.get(i7), dVar);
                this.f23046b.i(dVar, (V) arrayList2.get(i7));
                dVar.u();
                i7++;
            }
            dVar.u();
        }
    }

    public MapTypeAdapterFactory(com.google.gson.internal.c cVar, boolean z7) {
        this.f23043a = cVar;
        this.f23044b = z7;
    }

    private x<?> b(f fVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f23092f : fVar.p(com.google.gson.reflect.a.get(type));
    }

    @Override // com.google.gson.y
    public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
        Type type = aVar.getType();
        if (!Map.class.isAssignableFrom(aVar.getRawType())) {
            return null;
        }
        Type[] typeArrJ = com.google.gson.internal.b.j(type, com.google.gson.internal.b.k(type));
        return new a(fVar, typeArrJ[0], b(fVar, typeArrJ[0]), typeArrJ[1], fVar.p(com.google.gson.reflect.a.get(typeArrJ[1])), this.f23043a.a(aVar));
    }
}
