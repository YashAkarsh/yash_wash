package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.stream.d;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends x<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final y f23034c = new y() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.y
        public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
            Type type = aVar.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type typeG = com.google.gson.internal.b.g(type);
            return new ArrayTypeAdapter(fVar, fVar.p(com.google.gson.reflect.a.get(typeG)), com.google.gson.internal.b.k(typeG));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<E> f23035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<E> f23036b;

    public ArrayTypeAdapter(f fVar, x<E> xVar, Class<E> cls) {
        this.f23036b = new c(fVar, xVar, cls);
        this.f23035a = cls;
    }

    @Override // com.google.gson.x
    public Object e(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.J0() == com.google.gson.stream.c.NULL) {
            aVar.v0();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.b();
        while (aVar.H()) {
            arrayList.add(this.f23036b.e(aVar));
        }
        aVar.C();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f23035a, size);
        for (int i7 = 0; i7 < size; i7++) {
            Array.set(objNewInstance, i7, arrayList.get(i7));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.x
    public void i(d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.g0();
            return;
        }
        dVar.q();
        int length = Array.getLength(obj);
        for (int i7 = 0; i7 < length; i7++) {
            this.f23036b.i(dVar, (E) Array.get(obj, i7));
        }
        dVar.u();
    }
}
