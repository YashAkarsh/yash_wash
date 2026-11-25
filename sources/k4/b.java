package k4;

import android.text.TextUtils;
import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f34428a = "Realtek";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f34429b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f34430c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f34431d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f34432e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f34433f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f34434g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f34435h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f34436i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f34437j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f34438k;

    public static String a(Object... objArr) {
        int length;
        if (objArr == null || (length = objArr.length) <= 0) {
            return "";
        }
        if (length <= 1) {
            return objArr[0].toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i7 = 0; i7 < length; i7++) {
            sb.append("Param[");
            sb.append(i7);
            sb.append("] = ");
            Object obj = objArr[i7];
            if (obj == null) {
                sb.append("null");
            } else {
                sb.append(obj.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void b(int i7, String str, String str2) {
        int iMax = Math.max(i7, f34437j);
        if ((iMax & 6) == 6 && f34438k <= 6) {
            Log.wtf(str, str2);
            return;
        }
        if ((iMax & 5) == 5 && f34438k <= 5) {
            Log.e(str, str2);
            return;
        }
        if ((iMax & 4) == 4 && f34438k <= 4) {
            Log.w(str, str2);
            return;
        }
        if ((iMax & 3) == 3 && f34438k <= 3) {
            Log.i(str, str2);
            return;
        }
        if ((iMax & 2) == 2 && f34438k <= 2) {
            Log.d(str, str2);
        } else {
            if ((iMax & 1) != 1 || f34438k > 1) {
                return;
            }
            Log.v(str, str2);
        }
    }

    public static void c(boolean z7, int i7, String str, Object obj) {
        if (z7) {
            String[] strArrD = d(str, obj);
            if (strArrD == null || strArrD.length < 3) {
                b(i7, str, (String) obj);
                return;
            }
            String str2 = strArrD[0];
            String str3 = strArrD[1];
            b(i7, str2, strArrD[2] + str3);
        }
    }

    public static String[] d(String str, Object... objArr) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length < 6) {
            return null;
        }
        String className = stackTrace[5].getClassName();
        String[] strArrSplit = className.split("\\.");
        if (strArrSplit.length > 0) {
            className = strArrSplit[strArrSplit.length - 1] + ".java";
        }
        if (className.contains("$")) {
            className = className.split("\\$")[0] + ".java";
        }
        String methodName = stackTrace[5].getMethodName();
        int lineNumber = stackTrace[5].getLineNumber();
        if (lineNumber < 0) {
            lineNumber = 0;
        }
        String str2 = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        if (str == null) {
            str = className;
        }
        if (TextUtils.isEmpty(str)) {
            str = f34428a;
        }
        return new String[]{str, a(objArr), String.format(Locale.US, "[ (%s:%d)#%s ]", className, Integer.valueOf(lineNumber), str2)};
    }

    public static void e(String str) {
        c(f34429b, 2, f34428a, str);
    }

    public static void f(boolean z7, String str) {
        c(z7, 2, f34428a, str);
    }

    public static void g(boolean z7, String str, String str2) {
        c(z7, 2, str, str2);
    }

    public static void h(String str) {
        c(f34429b, 5, f34428a, str);
    }

    public static void i(boolean z7, String str) {
        c(z7, 5, f34428a, str);
    }

    public static void j(boolean z7, String str, String str2) {
        c(z7, 5, str, str2);
    }

    public static void k(String str) {
        c(f34429b, 3, f34428a, str);
    }

    public static void l(boolean z7, String str) {
        c(z7, 3, f34428a, str);
    }

    public static void m(boolean z7, String str, String str2) {
        c(z7, 3, str, str2);
    }

    public static void n(String str, boolean z7) {
        f34428a = str;
        f34429b = z7;
    }

    public static void o(int i7) {
        f34438k = i7;
    }

    public static void p(String str) {
        c(f34429b, 1, f34428a, str);
    }

    public static void q(boolean z7, String str) {
        c(z7, 1, f34428a, str);
    }

    public static void r(boolean z7, String str, String str2) {
        c(z7, 1, str, str2);
    }

    public static void s(String str) {
        c(f34429b, 4, f34428a, str);
    }

    public static void t(boolean z7, String str) {
        c(z7, 4, f34428a, str);
    }

    public static void u(boolean z7, String str, String str2) {
        c(z7, 4, str, str2);
    }
}
