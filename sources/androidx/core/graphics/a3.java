package androidx.core.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@c.t0(28)
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class a3 extends z2 {
    private static final String B = "createFromFamiliesWithDefault";
    private static final int C = -1;
    private static final String D = "sans-serif";

    @Override // androidx.core.graphics.z2
    protected Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f5919m, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f5925s.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    @Override // androidx.core.graphics.z2
    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(B, Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
