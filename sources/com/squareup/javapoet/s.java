package com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends o {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<o> f33439w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<o> f33440x;

    private s(List<o> list, List<o> list2) {
        this(list, list2, new ArrayList());
    }

    public static s A(Type type) {
        return z(o.h(type));
    }

    public static o t(WildcardType wildcardType) {
        return u(wildcardType, new LinkedHashMap());
    }

    static o u(WildcardType wildcardType, Map<Type, q> map) {
        return new s(o.p(wildcardType.getUpperBounds(), map), o.p(wildcardType.getLowerBounds(), map));
    }

    public static o v(javax.lang.model.type.WildcardType wildcardType) {
        return w(wildcardType, new LinkedHashMap());
    }

    static o w(javax.lang.model.type.WildcardType wildcardType, Map<TypeParameterElement, q> map) {
        TypeMirror extendsBound = wildcardType.getExtendsBound();
        if (extendsBound != null) {
            return x(o.k(extendsBound, map));
        }
        TypeMirror superBound = wildcardType.getSuperBound();
        return superBound == null ? y(Object.class) : z(o.k(superBound, map));
    }

    public static s x(o oVar) {
        return new s(Arrays.asList(oVar), Collections.emptyList());
    }

    public static s y(Type type) {
        return x(o.h(type));
    }

    public static s z(o oVar) {
        return new s(Arrays.asList(o.f33380m), Arrays.asList(oVar));
    }

    @Override // com.squareup.javapoet.o
    e f(e eVar) throws IOException {
        if (this.f33440x.size() == 1) {
            return eVar.c("? super $T", this.f33440x.get(0));
        }
        return this.f33439w.get(0).equals(o.f33380m) ? eVar.b("?") : eVar.c("? extends $T", this.f33439w.get(0));
    }

    @Override // com.squareup.javapoet.o
    public o r() {
        return new s(this.f33439w, this.f33440x);
    }

    @Override // com.squareup.javapoet.o
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public s a(List<a> list) {
        return new s(this.f33439w, this.f33440x, e(list));
    }

    private s(List<o> list, List<o> list2, List<a> list3) {
        super(list3);
        List<o> listF = r.f(list);
        this.f33439w = listF;
        this.f33440x = r.f(list2);
        r.b(listF.size() == 1, "unexpected extends bounds: %s", list);
        Iterator<o> it = listF.iterator();
        while (it.hasNext()) {
            o next = it.next();
            r.b((next.n() || next == o.f33371d) ? false : true, "invalid upper bound: %s", next);
        }
        Iterator<o> it2 = this.f33440x.iterator();
        while (it2.hasNext()) {
            o next2 = it2.next();
            r.b((next2.n() || next2 == o.f33371d) ? false : true, "invalid lower bound: %s", next2);
        }
    }
}
