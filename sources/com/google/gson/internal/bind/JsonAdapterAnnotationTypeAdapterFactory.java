package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.k;
import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.internal.c f23042a;

    public JsonAdapterAnnotationTypeAdapterFactory(com.google.gson.internal.c cVar) {
        this.f23042a = cVar;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
        w1.b bVar = (w1.b) aVar.getRawType().getAnnotation(w1.b.class);
        if (bVar == null) {
            return null;
        }
        return (x<T>) b(this.f23042a, fVar, aVar, bVar);
    }

    x<?> b(com.google.gson.internal.c cVar, f fVar, com.google.gson.reflect.a<?> aVar, w1.b bVar) {
        x<?> treeTypeAdapter;
        Object objA = cVar.a(com.google.gson.reflect.a.get((Class) bVar.value())).a();
        if (objA instanceof x) {
            treeTypeAdapter = (x) objA;
        } else if (objA instanceof y) {
            treeTypeAdapter = ((y) objA).a(fVar, aVar);
        } else {
            boolean z7 = objA instanceof t;
            if (!z7 && !(objA instanceof k)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z7 ? (t) objA : null, objA instanceof k ? (k) objA : null, fVar, aVar, null);
        }
        return (treeTypeAdapter == null || !bVar.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.d();
    }
}
