package com.google.gson.internal.bind;

import com.google.gson.e;
import com.google.gson.f;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.j;
import com.google.gson.internal.l;
import com.google.gson.stream.d;
import com.google.gson.v;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f23052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f23053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Excluder f23054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f23055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.gson.internal.reflect.b f23056e = com.google.gson.internal.reflect.b.a();

    class a extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Field f23057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f23058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f23059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f23060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.reflect.a f23061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f23062i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z7, boolean z8, Field field, boolean z9, x xVar, f fVar, com.google.gson.reflect.a aVar, boolean z10) {
            super(str, z7, z8);
            this.f23057d = field;
            this.f23058e = z9;
            this.f23059f = xVar;
            this.f23060g = fVar;
            this.f23061h = aVar;
            this.f23062i = z10;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        void a(com.google.gson.stream.a aVar, Object obj) throws IllegalAccessException, IOException {
            Object objE = this.f23059f.e(aVar);
            if (objE == null && this.f23062i) {
                return;
            }
            this.f23057d.set(obj, objE);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        void b(d dVar, Object obj) throws IllegalAccessException, IOException {
            (this.f23058e ? this.f23059f : new com.google.gson.internal.bind.c(this.f23060g, this.f23059f, this.f23061h.getType())).i(dVar, this.f23057d.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c
        public boolean c(Object obj) throws IllegalAccessException, IOException {
            return this.f23067b && this.f23057d.get(obj) != obj;
        }
    }

    public static final class b<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j<T> f23064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, c> f23065b;

        b(j<T> jVar, Map<String, c> map) {
            this.f23064a = jVar;
            this.f23065b = map;
        }

        @Override // com.google.gson.x
        public T e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            T tA = this.f23064a.a();
            try {
                aVar.e();
                while (aVar.H()) {
                    c cVar = this.f23065b.get(aVar.r0());
                    if (cVar == null || !cVar.f23068c) {
                        aVar.q1();
                    } else {
                        cVar.a(aVar, tA);
                    }
                }
                aVar.E();
                return tA;
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            } catch (IllegalStateException e9) {
                throw new v(e9);
            }
        }

        @Override // com.google.gson.x
        public void i(d dVar, T t7) throws IOException {
            if (t7 == null) {
                dVar.g0();
                return;
            }
            dVar.r();
            try {
                for (c cVar : this.f23065b.values()) {
                    if (cVar.c(t7)) {
                        dVar.K(cVar.f23066a);
                        cVar.b(dVar, t7);
                    }
                }
                dVar.C();
            } catch (IllegalAccessException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f23066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f23067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f23068c;

        protected c(String str, boolean z7, boolean z8) {
            this.f23066a = str;
            this.f23067b = z7;
            this.f23068c = z8;
        }

        abstract void a(com.google.gson.stream.a aVar, Object obj) throws IllegalAccessException, IOException;

        abstract void b(d dVar, Object obj) throws IllegalAccessException, IOException;

        abstract boolean c(Object obj) throws IllegalAccessException, IOException;
    }

    public ReflectiveTypeAdapterFactory(com.google.gson.internal.c cVar, e eVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f23052a = cVar;
        this.f23053b = eVar;
        this.f23054c = excluder;
        this.f23055d = jsonAdapterAnnotationTypeAdapterFactory;
    }

    private c b(f fVar, Field field, String str, com.google.gson.reflect.a<?> aVar, boolean z7, boolean z8) {
        boolean zA = l.a(aVar.getRawType());
        w1.b bVar = (w1.b) field.getAnnotation(w1.b.class);
        x<?> xVarB = bVar != null ? this.f23055d.b(this.f23052a, fVar, aVar, bVar) : null;
        boolean z9 = xVarB != null;
        if (xVarB == null) {
            xVarB = fVar.p(aVar);
        }
        return new a(str, z7, z8, field, z9, xVarB, fVar, aVar, zA);
    }

    static boolean d(Field field, boolean z7, Excluder excluder) {
        return (excluder.i(field.getType(), z7) || excluder.l(field, z7)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    private Map<String, c> e(f fVar, com.google.gson.reflect.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = aVar.getType();
        com.google.gson.reflect.a<?> aVar2 = aVar;
        Class<?> rawType = cls;
        while (rawType != Object.class) {
            Field[] declaredFields = rawType.getDeclaredFields();
            int length = declaredFields.length;
            boolean z7 = false;
            int i7 = 0;
            while (i7 < length) {
                Field field = declaredFields[i7];
                boolean zC = c(field, true);
                boolean zC2 = c(field, z7);
                if (zC || zC2) {
                    this.f23056e.b(field);
                    Type typeP = com.google.gson.internal.b.p(aVar2.getType(), rawType, field.getGenericType());
                    List<String> listF = f(field);
                    int size = listF.size();
                    c cVar = null;
                    ?? r7 = z7;
                    while (r7 < size) {
                        String str = listF.get(r7);
                        boolean z8 = r7 != 0 ? z7 : zC;
                        ?? r20 = r7;
                        c cVar2 = cVar;
                        int i8 = size;
                        List<String> list = listF;
                        Field field2 = field;
                        cVar = cVar2 == null ? (c) linkedHashMap.put(str, b(fVar, field, str, com.google.gson.reflect.a.get(typeP), z8, zC2)) : cVar2;
                        zC = z8;
                        listF = list;
                        size = i8;
                        field = field2;
                        z7 = false;
                        r7 = (r20 == true ? 1 : 0) + 1;
                    }
                    c cVar3 = cVar;
                    if (cVar3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar3.f23066a);
                    }
                }
                i7++;
                z7 = false;
            }
            aVar2 = com.google.gson.reflect.a.get(com.google.gson.internal.b.p(aVar2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = aVar2.getRawType();
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        w1.c cVar = (w1.c) field.getAnnotation(w1.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f23053b.a(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new b(this.f23052a.a(aVar), e(fVar, aVar, rawType));
        }
        return null;
    }

    public boolean c(Field field, boolean z7) {
        return d(field, z7, this.f23054c);
    }
}
