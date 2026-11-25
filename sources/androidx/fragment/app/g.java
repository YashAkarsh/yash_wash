package androidx.fragment.app;

import c.m0;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final androidx.collection.i<ClassLoader, androidx.collection.i<String, Class<?>>> f8000a = new androidx.collection.i<>();

    static boolean b(@m0 ClassLoader classLoader, @m0 String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @m0
    private static Class<?> c(@m0 ClassLoader classLoader, @m0 String str) throws ClassNotFoundException {
        androidx.collection.i<ClassLoader, androidx.collection.i<String, Class<?>>> iVar = f8000a;
        androidx.collection.i<String, Class<?>> iVar2 = iVar.get(classLoader);
        if (iVar2 == null) {
            iVar2 = new androidx.collection.i<>();
            iVar.put(classLoader, iVar2);
        }
        Class<?> cls = iVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        iVar2.put(str, cls2);
        return cls2;
    }

    @m0
    public static Class<? extends Fragment> d(@m0 ClassLoader classLoader, @m0 String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e8) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e8);
        } catch (ClassNotFoundException e9) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists", e9);
        }
    }

    @m0
    public Fragment a(@m0 ClassLoader classLoader, @m0 String str) {
        try {
            return d(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e8) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e8);
        } catch (InstantiationException e9) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e9);
        } catch (NoSuchMethodException e10) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e10);
        } catch (InvocationTargetException e11) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e11);
        }
    }
}
