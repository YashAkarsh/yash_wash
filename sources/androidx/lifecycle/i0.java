package androidx.lifecycle;

import android.app.Application;
import c.x0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final List<Class<?>> f8301a = kotlin.collections.y.M(Application.class, d0.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final List<Class<?>> f8302b = kotlin.collections.x.l(d0.class);

    @a7.e
    public static final <T> Constructor<T> c(@a7.d Class<T> modelClass, @a7.d List<? extends Class<?>> signature) {
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        kotlin.jvm.internal.l0.p(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        kotlin.jvm.internal.l0.o(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.l0.o(parameterTypes, "constructor.parameterTypes");
            List listKz = kotlin.collections.p.kz(parameterTypes);
            if (kotlin.jvm.internal.l0.g(signature, listKz)) {
                return constructor;
            }
            if (signature.size() == listKz.size() && listKz.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends k0> T d(@a7.d Class<T> modelClass, @a7.d Constructor<T> constructor, @a7.d Object... params) {
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        kotlin.jvm.internal.l0.p(constructor, "constructor");
        kotlin.jvm.internal.l0.p(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e8) {
            throw new RuntimeException("Failed to access " + modelClass, e8);
        } catch (InstantiationException e9) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e9);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e10.getCause());
        }
    }
}
