package org.junit.internal.builders;

import org.junit.internal.runners.i;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class h extends org.junit.runners.model.h {
    @Override // org.junit.runners.model.h
    public l c(Class<?> cls) throws Throwable {
        if (h(cls)) {
            return new i(cls);
        }
        return null;
    }

    public boolean h(Class<?> cls) {
        try {
            cls.getMethod(junit.runner.a.f34375b, new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }
}
