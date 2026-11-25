package androidx.test.internal.util;

import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.j;
import junit.framework.n;
import junit.runner.a;

/* JADX INFO: loaded from: classes.dex */
public class AndroidRunnerBuilderUtil {
    public static boolean a(Class<?> loadedClass) {
        for (Method method : loadedClass.getMethods()) {
            if (e(method)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Class<?> testClass) {
        try {
            testClass.getMethod(a.f34375b, new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean c(Class<?> testClass) {
        return j.class.isAssignableFrom(testClass);
    }

    public static boolean d(Class<?> testClass) {
        return n.class.isAssignableFrom(testClass);
    }

    private static boolean e(Method m7) {
        return f(m7) && Modifier.isPublic(m7.getModifiers());
    }

    private static boolean f(Method m7) {
        return m7.getParameterTypes().length == 0 && m7.getName().startsWith(InstrumentationResultPrinter.f10180n) && m7.getReturnType().equals(Void.TYPE);
    }
}
