package org.junit.experimental.theories.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.experimental.theories.g;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<g> f39811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<org.junit.experimental.theories.d> f39812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f39813c;

    private b(List<g> list, List<org.junit.experimental.theories.d> list2, k kVar) {
        this.f39812b = list2;
        this.f39811a = list;
        this.f39813c = kVar;
    }

    public static b a(Method method, k kVar) {
        List<org.junit.experimental.theories.d> listO = org.junit.experimental.theories.d.o(kVar.l());
        listO.addAll(org.junit.experimental.theories.d.m(method));
        return new b(new ArrayList(), listO, kVar);
    }

    private org.junit.experimental.theories.e c(Class<? extends org.junit.experimental.theories.e> cls) throws Exception {
        for (Constructor<?> constructor : cls.getConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(k.class)) {
                return (org.junit.experimental.theories.e) constructor.newInstance(this.f39813c);
            }
        }
        return cls.newInstance();
    }

    private List<g> d(org.junit.experimental.theories.d dVar) {
        Class<?> clsI = dVar.i();
        if (clsI.isEnum()) {
            return new d(clsI).a(dVar);
        }
        return (clsI.equals(Boolean.class) || clsI.equals(Boolean.TYPE)) ? new c().a(dVar) : Collections.emptyList();
    }

    private int i() {
        return org.junit.experimental.theories.d.o(this.f39813c.l()).size();
    }

    private org.junit.experimental.theories.e k(org.junit.experimental.theories.d dVar) throws Exception {
        org.junit.experimental.theories.f fVar = (org.junit.experimental.theories.f) dVar.e(org.junit.experimental.theories.f.class);
        return fVar != null ? c(fVar.value()) : new a(this.f39813c);
    }

    public b b(g gVar) {
        ArrayList arrayList = new ArrayList(this.f39811a);
        arrayList.add(gVar);
        List<org.junit.experimental.theories.d> list = this.f39812b;
        return new b(arrayList, list.subList(1, list.size()), this.f39813c);
    }

    public Object[] e(int i7, int i8) throws g.b {
        Object[] objArr = new Object[i8 - i7];
        for (int i9 = i7; i9 < i8; i9++) {
            objArr[i9 - i7] = this.f39811a.get(i9).c();
        }
        return objArr;
    }

    public Object[] f() throws g.b {
        return e(0, this.f39811a.size());
    }

    public Object[] g(boolean z7) throws g.b {
        int size = this.f39811a.size();
        Object[] objArr = new Object[size];
        for (int i7 = 0; i7 < size; i7++) {
            objArr[i7] = this.f39811a.get(i7).b();
        }
        return objArr;
    }

    public Object[] h() throws g.b {
        return e(0, i());
    }

    public Object[] j() throws g.b {
        return e(i(), this.f39811a.size());
    }

    public boolean l() {
        return this.f39812b.size() == 0;
    }

    public org.junit.experimental.theories.d m() {
        return this.f39812b.get(0);
    }

    public List<g> n() throws Throwable {
        org.junit.experimental.theories.d dVarM = m();
        List<g> listA = k(dVarM).a(dVarM);
        return listA.size() == 0 ? d(dVarM) : listA;
    }
}
