package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import c.m0;
import c.t0;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f841a = "ResourcesFlusher";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Field f842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Class<?> f844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Field f846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Field f848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f849i;

    @t0(16)
    static class a {
        private a() {
        }

        @c.t
        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    private q() {
    }

    static void a(@m0 Resources resources) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 28) {
            return;
        }
        if (i7 >= 24) {
            d(resources);
        } else {
            c(resources);
        }
    }

    @t0(21)
    private static void b(@m0 Resources resources) {
        Map map;
        if (!f843c) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f842b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e(f841a, "Could not retrieve Resources#mDrawableCache field", e8);
            }
            f843c = true;
        }
        Field field = f842b;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e9) {
                Log.e(f841a, "Could not retrieve value from Resources#mDrawableCache", e9);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    @t0(23)
    private static void c(@m0 Resources resources) {
        Object obj;
        if (!f843c) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f842b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e(f841a, "Could not retrieve Resources#mDrawableCache field", e8);
            }
            f843c = true;
        }
        Field field = f842b;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e9) {
                Log.e(f841a, "Could not retrieve value from Resources#mDrawableCache", e9);
                obj = null;
            }
        } else {
            obj = null;
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    @t0(24)
    private static void d(@m0 Resources resources) {
        Object obj;
        if (!f849i) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f848h = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e8) {
                Log.e(f841a, "Could not retrieve Resources#mResourcesImpl field", e8);
            }
            f849i = true;
        }
        Field field = f848h;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e9) {
            Log.e(f841a, "Could not retrieve value from Resources#mResourcesImpl", e9);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f843c) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f842b = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e(f841a, "Could not retrieve ResourcesImpl#mDrawableCache field", e10);
            }
            f843c = true;
        }
        Field field2 = f842b;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e11) {
                Log.e(f841a, "Could not retrieve value from ResourcesImpl#mDrawableCache", e11);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    @t0(16)
    private static void e(@m0 Object obj) {
        LongSparseArray longSparseArray;
        if (!f845e) {
            try {
                f844d = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e8) {
                Log.e(f841a, "Could not find ThemedResourceCache class", e8);
            }
            f845e = true;
        }
        Class<?> cls = f844d;
        if (cls == null) {
            return;
        }
        if (!f847g) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f846f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e9) {
                Log.e(f841a, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e9);
            }
            f847g = true;
        }
        Field field = f846f;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e10) {
            Log.e(f841a, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e10);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            a.a(longSparseArray);
        }
    }
}
