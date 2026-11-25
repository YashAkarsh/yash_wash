package com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends o {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final o f33284w;

    private b(o oVar) {
        this(oVar, new ArrayList());
    }

    public static b t(GenericArrayType genericArrayType) {
        return u(genericArrayType, new LinkedHashMap());
    }

    static b u(GenericArrayType genericArrayType, Map<Type, q> map) {
        return x(o.i(genericArrayType.getGenericComponentType(), map));
    }

    public static b v(ArrayType arrayType) {
        return w(arrayType, new LinkedHashMap());
    }

    static b w(ArrayType arrayType, Map<TypeParameterElement, q> map) {
        return new b(o.k(arrayType.getComponentType(), map));
    }

    public static b x(o oVar) {
        return new b(oVar);
    }

    public static b y(Type type) {
        return x(o.h(type));
    }

    @Override // com.squareup.javapoet.o
    e f(e eVar) throws IOException {
        return eVar.c("$T[]", this.f33284w);
    }

    @Override // com.squareup.javapoet.o
    public o r() {
        return new b(this.f33284w);
    }

    @Override // com.squareup.javapoet.o
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public b a(List<a> list) {
        return new b(this.f33284w, e(list));
    }

    private b(o oVar, List<a> list) {
        super(list);
        this.f33284w = (o) r.c(oVar, "rawType == null", new Object[0]);
    }
}
