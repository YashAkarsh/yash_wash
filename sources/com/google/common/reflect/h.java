package com.google.common.reflect;

import com.google.common.base.e0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public final class h {
    private h() {
    }

    public static String a(Class<?> cls) {
        return b(cls.getName());
    }

    public static String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf < 0 ? "" : str.substring(0, iLastIndexOf);
    }

    public static void c(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
            } catch (ClassNotFoundException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    public static <T> T d(Class<T> cls, InvocationHandler invocationHandler) {
        e0.E(invocationHandler);
        e0.u(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
