package androidx.test.internal.util;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10257a = "ReflectionUtil";

    public static void a(final String className, final String methodName) {
        Checks.f(className);
        Checks.f(methodName);
        String strValueOf = String.valueOf(methodName);
        Log.i(f10257a, strValueOf.length() != 0 ? "Attempting to reflectively call: ".concat(strValueOf) : new String("Attempting to reflectively call: "));
        try {
            Method declaredMethod = Class.forName(className).getDeclaredMethod(methodName, new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e8) {
            Log.e(f10257a, "Reflective call failed: ", e8);
        }
    }
}
