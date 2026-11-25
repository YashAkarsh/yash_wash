package org.junit.internal.builders;

import org.junit.k;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class c extends org.junit.runners.model.h {
    @Override // org.junit.runners.model.h
    public l c(Class<?> cls) {
        if (cls.getAnnotation(k.class) != null) {
            return new d(cls);
        }
        return null;
    }
}
