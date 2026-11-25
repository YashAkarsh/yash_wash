package com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends o {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final n f33368w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f33369x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<o> f33370y;

    n(n nVar, c cVar, List<o> list) {
        this(nVar, cVar, list, new ArrayList());
    }

    public static n t(c cVar, o... oVarArr) {
        return new n(null, cVar, Arrays.asList(oVarArr));
    }

    public static n u(Class<?> cls, Type... typeArr) {
        return new n(null, c.w(cls), o.o(typeArr));
    }

    public static n v(ParameterizedType parameterizedType) {
        return w(parameterizedType, new LinkedHashMap());
    }

    static n w(ParameterizedType parameterizedType, Map<Type, q> map) {
        c cVarW = c.w((Class) parameterizedType.getRawType());
        ParameterizedType parameterizedType2 = (!(parameterizedType.getOwnerType() instanceof ParameterizedType) || Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers())) ? null : (ParameterizedType) parameterizedType.getOwnerType();
        List<o> listP = o.p(parameterizedType.getActualTypeArguments(), map);
        return parameterizedType2 != null ? w(parameterizedType2, map).y(cVarW.E(), listP) : new n(null, cVarW, listP);
    }

    @Override // com.squareup.javapoet.o
    e f(e eVar) throws IOException {
        n nVar = this.f33368w;
        if (nVar != null) {
            nVar.g(eVar);
            this.f33368w.f(eVar);
            eVar.b(com.alibaba.android.arouter.utils.b.f12515h + this.f33369x.E());
        } else {
            this.f33369x.g(eVar);
            this.f33369x.f(eVar);
        }
        if (!this.f33370y.isEmpty()) {
            eVar.d("<");
            boolean z7 = true;
            for (o oVar : this.f33370y) {
                if (!z7) {
                    eVar.d(", ");
                }
                oVar.g(eVar);
                oVar.f(eVar);
                z7 = false;
            }
            eVar.d(">");
        }
        return eVar;
    }

    @Override // com.squareup.javapoet.o
    public o r() {
        return new n(this.f33368w, this.f33369x, this.f33370y, new ArrayList());
    }

    @Override // com.squareup.javapoet.o
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public n a(List<a> list) {
        return new n(this.f33368w, this.f33369x, this.f33370y, e(list));
    }

    public n x(String str) {
        r.c(str, "name == null", new Object[0]);
        return new n(this, this.f33369x.B(str), new ArrayList(), new ArrayList());
    }

    public n y(String str, List<o> list) {
        r.c(str, "name == null", new Object[0]);
        return new n(this, this.f33369x.B(str), list, new ArrayList());
    }

    private n(n nVar, c cVar, List<o> list, List<a> list2) {
        super(list2);
        this.f33369x = (c) r.c(cVar, "rawType == null", new Object[0]);
        this.f33368w = nVar;
        List<o> listF = r.f(list);
        this.f33370y = listF;
        r.b((listF.isEmpty() && nVar == null) ? false : true, "no type arguments: %s", cVar);
        Iterator<o> it = listF.iterator();
        while (it.hasNext()) {
            o next = it.next();
            r.b((next.n() || next == o.f33371d) ? false : true, "invalid type parameter: %s", next);
        }
    }
}
