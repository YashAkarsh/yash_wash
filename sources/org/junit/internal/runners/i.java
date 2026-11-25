package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes3.dex */
public class i extends e {
    public i(Class<?> cls) throws Throwable {
        super(l(cls));
    }

    public static junit.framework.i l(Class<?> cls) throws Exception {
        try {
            Method method = cls.getMethod(junit.runner.a.f34375b, new Class[0]);
            if (Modifier.isStatic(method.getModifiers())) {
                return (junit.framework.i) method.invoke(null, new Object[0]);
            }
            throw new Exception(cls.getName() + ".suite() must be static");
        } catch (InvocationTargetException e8) {
            throw e8.getCause();
        }
    }
}
