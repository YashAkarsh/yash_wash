package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@c.t0(17)
public class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private static Method f6116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private static Constructor<UserHandle> f6117b;

    @c.t0(24)
    private static class a {
        private a() {
        }

        @c.m0
        static UserHandle a(int i7) {
            return UserHandle.getUserHandleForUid(i7);
        }
    }

    private y0() {
    }

    private static Method a() throws NoSuchMethodException {
        if (f6116a == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", Integer.TYPE);
            f6116a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return f6116a;
    }

    private static Constructor<UserHandle> b() throws NoSuchMethodException {
        if (f6117b == null) {
            Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(Integer.TYPE);
            f6117b = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return f6117b;
    }

    @c.m0
    public static UserHandle c(int i7) {
        if (Build.VERSION.SDK_INT >= 24) {
            return a.a(i7);
        }
        try {
            return b().newInstance((Integer) a().invoke(null, Integer.valueOf(i7)));
        } catch (IllegalAccessException e8) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e8);
            throw illegalAccessError;
        } catch (InstantiationException e9) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e9);
            throw instantiationError;
        } catch (NoSuchMethodException e10) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e10);
            throw noSuchMethodError;
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
