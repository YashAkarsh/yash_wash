package u4;

import android.annotation.TargetApi;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private f() {
    }

    public static List<Method> a(Class cls, Class<? extends Annotation> cls2) {
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(cls2)) {
                arrayList.add(method);
            }
        }
        return arrayList;
    }

    @TargetApi(23)
    public static List<String> b(Activity activity, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (activity.checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static <A extends Annotation> Method c(Class cls, Class<A> cls2, int i7) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(cls2) && i7 == ((d) method.getAnnotation(d.class)).requestCode()) {
                return method;
            }
        }
        return null;
    }

    public static <A extends Annotation> Method d(Class cls, Class<A> cls2, int i7) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(cls2) && i7 == ((e) method.getAnnotation(e.class)).requestCode()) {
                return method;
            }
        }
        return null;
    }

    public static <A extends Annotation> Method e(Class cls, Class<A> cls2, int i7) {
        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(cls2) && g(method, cls2, i7)) {
                return method;
            }
        }
        return null;
    }

    public static Activity f(Object obj) {
        if (obj instanceof Fragment) {
            return ((Fragment) obj).getActivity();
        }
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    public static boolean g(Method method, Class cls, int i7) {
        if (cls.equals(d.class)) {
            return i7 == ((d) method.getAnnotation(d.class)).requestCode();
        }
        return cls.equals(e.class) && i7 == ((e) method.getAnnotation(e.class)).requestCode();
    }

    public static boolean h() {
        return true;
    }
}
