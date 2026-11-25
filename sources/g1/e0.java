package g1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import c.m0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f33980a = Process.myUid();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f33981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f33982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f33983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f33984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Method f33985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Method f33986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Method f33987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Method f33988i;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Method method8 = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f33981b = method;
        if (v.g()) {
            try {
                method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused2) {
                method2 = null;
            }
        } else {
            method2 = null;
        }
        f33982c = method2;
        try {
            method3 = WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception unused3) {
            method3 = null;
        }
        f33983d = method3;
        try {
            method4 = WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
            method4 = null;
        }
        f33984e = method4;
        if (v.g()) {
            try {
                method5 = WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused5) {
                method5 = null;
            }
        } else {
            method5 = null;
        }
        f33985f = method5;
        if (v.o()) {
            try {
                method6 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e8) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e8);
                method6 = null;
            }
        } else {
            method6 = null;
        }
        f33986g = method6;
        if (v.o()) {
            try {
                method7 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e9) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e9);
                method7 = null;
            }
        } else {
            method7 = null;
        }
        f33987h = method7;
        if (v.o()) {
            try {
                method8 = WorkSource.class.getMethod("isEmpty", new Class[0]);
                method8.setAccessible(true);
            } catch (Exception unused6) {
            }
        }
        f33988i = method8;
    }

    private e0() {
    }

    @c1.a
    public static void a(@m0 WorkSource workSource, int i7, @m0 String str) {
        Method method = f33982c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i7), str);
                return;
            } catch (Exception e8) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e8);
                return;
            }
        }
        Method method2 = f33981b;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i7));
            } catch (Exception e9) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e9);
            }
        }
    }

    @c1.a
    @m0
    public static WorkSource b(@m0 Context context, @m0 String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfoC = com.google.android.gms.common.wrappers.d.a(context).c(str, 0);
                if (applicationInfoC == null) {
                    Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                int i7 = applicationInfoC.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i7, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
            }
        }
        return null;
    }

    @c1.a
    @m0
    public static WorkSource c(@m0 Context context, @m0 String str, @m0 String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i7 = -1;
        try {
            ApplicationInfo applicationInfoC = com.google.android.gms.common.wrappers.d.a(context).c(str, 0);
            if (applicationInfoC == null) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
            } else {
                i7 = applicationInfoC.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
        }
        if (i7 < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = f33986g;
        if (method2 == null || (method = f33987h) == null) {
            a(workSource, i7, str);
        } else {
            try {
                Object objInvoke = method2.invoke(workSource, new Object[0]);
                int i8 = f33980a;
                if (i7 != i8) {
                    method.invoke(objInvoke, Integer.valueOf(i7), str);
                }
                method.invoke(objInvoke, Integer.valueOf(i8), str2);
            } catch (Exception e8) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e8);
            }
        }
        return workSource;
    }

    @c1.a
    @m0
    public static List<String> d(@m0 WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int iG = workSource == null ? 0 : g(workSource);
        if (iG != 0) {
            for (int i7 = 0; i7 < iG; i7++) {
                Method method = f33985f;
                String str = null;
                if (method != null) {
                    try {
                        str = (String) method.invoke(workSource, Integer.valueOf(i7));
                    } catch (Exception e8) {
                        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e8);
                    }
                }
                if (!b0.b(str)) {
                    com.google.android.gms.common.internal.u.k(str);
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    @c1.a
    public static boolean e(@m0 Context context) {
        return (context == null || context.getPackageManager() == null || com.google.android.gms.common.wrappers.d.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    @c1.a
    public static boolean f(@m0 WorkSource workSource) {
        Method method = f33988i;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                com.google.android.gms.common.internal.u.k(objInvoke);
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e8) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e8);
            }
        }
        return g(workSource) == 0;
    }

    public static int g(@m0 WorkSource workSource) {
        Method method = f33983d;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, new Object[0]);
                com.google.android.gms.common.internal.u.k(objInvoke);
                return ((Integer) objInvoke).intValue();
            } catch (Exception e8) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e8);
            }
        }
        return 0;
    }
}
