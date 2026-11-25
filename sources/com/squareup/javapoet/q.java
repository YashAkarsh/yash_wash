package com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends o {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f33436w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<o> f33437x;

    private q(String str, List<o> list) {
        this(str, list, new ArrayList());
    }

    static q A(TypeVariable typeVariable, Map<TypeParameterElement, q> map) {
        TypeParameterElement typeParameterElement = (TypeParameterElement) typeVariable.asElement();
        q qVar = map.get(typeParameterElement);
        if (qVar != null) {
            return qVar;
        }
        ArrayList arrayList = new ArrayList();
        q qVar2 = new q(typeParameterElement.getSimpleName().toString(), Collections.unmodifiableList(arrayList));
        map.put(typeParameterElement, qVar2);
        Iterator it = typeParameterElement.getBounds().iterator();
        while (it.hasNext()) {
            arrayList.add(o.k((TypeMirror) it.next(), map));
        }
        arrayList.remove(o.f33380m);
        return qVar2;
    }

    private static q B(String str, List<o> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.remove(o.f33380m);
        return new q(str, Collections.unmodifiableList(arrayList));
    }

    public static q t(String str) {
        return B(str, Collections.emptyList());
    }

    public static q u(String str, o... oVarArr) {
        return B(str, Arrays.asList(oVarArr));
    }

    public static q v(String str, Type... typeArr) {
        return B(str, o.o(typeArr));
    }

    public static q w(java.lang.reflect.TypeVariable<?> typeVariable) {
        return x(typeVariable, new LinkedHashMap());
    }

    static q x(java.lang.reflect.TypeVariable<?> typeVariable, Map<Type, q> map) {
        q qVar = map.get(typeVariable);
        if (qVar != null) {
            return qVar;
        }
        ArrayList arrayList = new ArrayList();
        q qVar2 = new q(typeVariable.getName(), Collections.unmodifiableList(arrayList));
        map.put(typeVariable, qVar2);
        for (Type type : typeVariable.getBounds()) {
            arrayList.add(o.i(type, map));
        }
        arrayList.remove(o.f33380m);
        return qVar2;
    }

    public static q y(TypeParameterElement typeParameterElement) {
        String string = typeParameterElement.getSimpleName().toString();
        List bounds = typeParameterElement.getBounds();
        ArrayList arrayList = new ArrayList();
        Iterator it = bounds.iterator();
        while (it.hasNext()) {
            arrayList.add(o.j((TypeMirror) it.next()));
        }
        return B(string, arrayList);
    }

    public static q z(TypeVariable typeVariable) {
        return y(typeVariable.asElement());
    }

    public q C(List<o> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f33437x);
        arrayList.addAll(list);
        return new q(this.f33436w, arrayList, this.f33391b);
    }

    public q D(o... oVarArr) {
        return C(Arrays.asList(oVarArr));
    }

    public q E(Type... typeArr) {
        return C(o.o(typeArr));
    }

    @Override // com.squareup.javapoet.o
    e f(e eVar) throws IOException {
        return eVar.d(this.f33436w);
    }

    @Override // com.squareup.javapoet.o
    public o r() {
        return new q(this.f33436w, this.f33437x);
    }

    @Override // com.squareup.javapoet.o
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public q a(List<a> list) {
        return new q(this.f33436w, this.f33437x, list);
    }

    private q(String str, List<o> list, List<a> list2) {
        super(list2);
        this.f33436w = (String) r.c(str, "name == null", new Object[0]);
        this.f33437x = list;
        Iterator<o> it = list.iterator();
        while (it.hasNext()) {
            o next = it.next();
            r.b((next.n() || next == o.f33371d) ? false : true, "invalid bound: %s", next);
        }
    }
}
