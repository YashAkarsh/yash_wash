package org.junit.experimental.theories.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public class f extends a {
    public f(k kVar) {
        super(kVar);
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<Field> j(org.junit.experimental.theories.d dVar) {
        Collection<Field> collectionJ = super.j(dVar);
        String strValue = ((org.junit.experimental.theories.c) dVar.g(org.junit.experimental.theories.c.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field field : collectionJ) {
            if (Arrays.asList(((org.junit.experimental.theories.b) field.getAnnotation(org.junit.experimental.theories.b.class)).value()).contains(strValue)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<org.junit.runners.model.d> k(org.junit.experimental.theories.d dVar) {
        Collection<org.junit.runners.model.d> collectionK = super.k(dVar);
        String strValue = ((org.junit.experimental.theories.c) dVar.g(org.junit.experimental.theories.c.class)).value();
        ArrayList arrayList = new ArrayList();
        for (org.junit.runners.model.d dVar2 : collectionK) {
            if (Arrays.asList(((org.junit.experimental.theories.b) dVar2.getAnnotation(org.junit.experimental.theories.b.class)).value()).contains(strValue)) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<Field> l(org.junit.experimental.theories.d dVar) {
        Collection<Field> collectionL = super.l(dVar);
        String strValue = ((org.junit.experimental.theories.c) dVar.g(org.junit.experimental.theories.c.class)).value();
        ArrayList arrayList = new ArrayList();
        for (Field field : collectionL) {
            if (Arrays.asList(((org.junit.experimental.theories.a) field.getAnnotation(org.junit.experimental.theories.a.class)).value()).contains(strValue)) {
                arrayList.add(field);
            }
        }
        return arrayList;
    }

    @Override // org.junit.experimental.theories.internal.a
    protected Collection<org.junit.runners.model.d> m(org.junit.experimental.theories.d dVar) {
        Collection<org.junit.runners.model.d> collectionM = super.m(dVar);
        String strValue = ((org.junit.experimental.theories.c) dVar.g(org.junit.experimental.theories.c.class)).value();
        ArrayList arrayList = new ArrayList();
        for (org.junit.runners.model.d dVar2 : collectionM) {
            if (Arrays.asList(((org.junit.experimental.theories.a) dVar2.getAnnotation(org.junit.experimental.theories.a.class)).value()).contains(strValue)) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }
}
