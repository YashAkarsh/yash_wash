package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.stream.d;
import com.google.gson.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
final class c<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f23143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<T> f23144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f23145c;

    c(f fVar, x<T> xVar, Type type) {
        this.f23143a = fVar;
        this.f23144b = xVar;
        this.f23145c = type;
    }

    private Type j(Type type, Object obj) {
        if (obj != null) {
            return (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type;
        }
        return type;
    }

    @Override // com.google.gson.x
    public T e(com.google.gson.stream.a aVar) throws IOException {
        return this.f23144b.e(aVar);
    }

    @Override // com.google.gson.x
    public void i(d dVar, T t7) throws IOException {
        x<T> xVarP = this.f23144b;
        Type typeJ = j(this.f23145c, t7);
        if (typeJ != this.f23145c) {
            xVarP = this.f23143a.p(com.google.gson.reflect.a.get(typeJ));
            if (xVarP instanceof ReflectiveTypeAdapterFactory.b) {
                x<T> xVar = this.f23144b;
                if (!(xVar instanceof ReflectiveTypeAdapterFactory.b)) {
                    xVarP = xVar;
                }
            }
        }
        xVarP.i(dVar, t7);
    }
}
