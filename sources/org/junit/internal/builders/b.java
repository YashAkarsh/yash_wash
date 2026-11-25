package org.junit.internal.builders;

import java.lang.reflect.Modifier;
import org.junit.runner.k;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class b extends org.junit.runners.model.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f39838c = "Custom runner class %s should have a public constructor with signature %s(Class testClass)";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.junit.runners.model.h f39839b;

    public b(org.junit.runners.model.h hVar) {
        this.f39839b = hVar;
    }

    private Class<?> i(Class<?> cls) {
        if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    @Override // org.junit.runners.model.h
    public l c(Class<?> cls) throws Exception {
        Class<?> clsI = cls;
        while (clsI != null) {
            k kVar = (k) clsI.getAnnotation(k.class);
            if (kVar != null) {
                return h(kVar.value(), cls);
            }
            clsI = i(clsI);
        }
        return null;
    }

    public l h(Class<? extends l> cls, Class<?> cls2) throws Exception {
        try {
            return cls.getConstructor(Class.class).newInstance(cls2);
        } catch (NoSuchMethodException unused) {
            try {
                return cls.getConstructor(Class.class, org.junit.runners.model.h.class).newInstance(cls2, this.f39839b);
            } catch (NoSuchMethodException unused2) {
                String simpleName = cls.getSimpleName();
                throw new org.junit.runners.model.e(String.format(f39838c, simpleName, simpleName));
            }
        }
    }
}
