package u4;

import android.annotation.TargetApi;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f40409d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f40410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f40411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f40412c;

    public interface a {
        void a(int i7);

        void b(int i7);
    }

    private c(Object obj) {
        this.f40412c = obj;
    }

    private static void b(Object obj, int i7) {
        d(obj, f.e(obj.getClass(), d.class, i7));
    }

    private static void c(Object obj, int i7) {
        d(obj, f.e(obj.getClass(), e.class, i7));
    }

    private static void d(Object obj, Method method) {
        if (method != null) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(obj, null);
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
            } catch (InvocationTargetException e9) {
                e9.printStackTrace();
            }
        }
    }

    public static void e(Activity activity, int i7, String str) {
        f40409d = null;
        g(activity, i7, new String[]{str});
    }

    public static void f(Activity activity, int i7, String str, a aVar) {
        if (aVar != null) {
            f40409d = aVar;
        }
        g(activity, i7, new String[]{str});
    }

    public static void g(Activity activity, int i7, String[] strArr) {
        f40409d = null;
        r(activity, i7, strArr);
    }

    public static void h(Activity activity, int i7, String[] strArr, a aVar) {
        if (aVar != null) {
            f40409d = aVar;
        }
        r(activity, i7, strArr);
    }

    public static void i(Fragment fragment, int i7, String str) {
        f40409d = null;
        k(fragment, i7, new String[]{str});
    }

    public static void j(Fragment fragment, int i7, String str, a aVar) {
        if (aVar != null) {
            f40409d = aVar;
        }
        k(fragment, i7, new String[]{str});
    }

    public static void k(Fragment fragment, int i7, String[] strArr) {
        f40409d = null;
        r(fragment, i7, strArr);
    }

    public static void l(Fragment fragment, int i7, String[] strArr, a aVar) {
        if (aVar != null) {
            f40409d = aVar;
        }
        r(fragment, i7, strArr);
    }

    public static void m(Activity activity, int i7, String[] strArr, int[] iArr) {
        s(activity, i7, strArr, iArr);
    }

    public static void n(Fragment fragment, int i7, String[] strArr, int[] iArr) {
        s(fragment, i7, strArr, iArr);
    }

    @TargetApi(23)
    private static void r(Object obj, int i7, String[] strArr) {
        if (!f.h()) {
            a aVar = f40409d;
            if (aVar != null) {
                aVar.b(i7);
                return;
            } else {
                c(obj, i7);
                return;
            }
        }
        List<String> listB = f.b(f.f(obj), strArr);
        if (listB.size() <= 0) {
            a aVar2 = f40409d;
            if (aVar2 != null) {
                aVar2.b(i7);
                return;
            } else {
                c(obj, i7);
                return;
            }
        }
        if (obj instanceof Activity) {
            ((Activity) obj).requestPermissions((String[]) listB.toArray(new String[listB.size()]), i7);
        } else {
            if (obj instanceof Fragment) {
                ((Fragment) obj).requestPermissions((String[]) listB.toArray(new String[listB.size()]), i7);
                return;
            }
            throw new IllegalArgumentException(obj.getClass().getName() + " is not supported");
        }
    }

    private static void s(Object obj, int i7, String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < iArr.length; i8++) {
            if (iArr[i8] != 0) {
                arrayList.add(strArr[i8]);
            }
        }
        if (arrayList.size() > 0) {
            a aVar = f40409d;
            if (aVar != null) {
                aVar.a(i7);
                return;
            } else {
                b(obj, i7);
                return;
            }
        }
        a aVar2 = f40409d;
        if (aVar2 != null) {
            aVar2.b(i7);
        } else {
            c(obj, i7);
        }
    }

    public static c t(Activity activity) {
        return new c(activity);
    }

    public static c u(Fragment fragment) {
        return new c(fragment);
    }

    public c a(int i7) {
        this.f40411b = i7;
        return this;
    }

    public c o(String... strArr) {
        this.f40410a = strArr;
        return this;
    }

    @TargetApi(23)
    public void p() {
        f40409d = null;
        r(this.f40412c, this.f40411b, this.f40410a);
    }

    @TargetApi(23)
    public void q(a aVar) {
        if (aVar != null) {
            f40409d = aVar;
        }
        r(this.f40412c, this.f40411b, this.f40410a);
    }
}
