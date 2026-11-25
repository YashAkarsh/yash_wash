package e3;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.material.timepicker.TimeModel;
import com.haier.library.common.util.o;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f33537a = "uSDK";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f33539c = "##";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f33540d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f33541e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f33542f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f33543g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f33544h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f33545i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f33546j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f33547k = 16;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final SparseArray<String> f33549m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f33538b = "^.*%[acdefsixop].*$";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f33548l = Pattern.compile(f33538b);

    static {
        SparseArray<String> sparseArray = new SparseArray<>(5);
        f33549m = sparseArray;
        sparseArray.put(1, "D");
        sparseArray.put(2, "I");
        sparseArray.put(4, "W");
        sparseArray.put(8, "E");
        sparseArray.put(16, "N");
    }

    private a() {
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(TimeModel.f18789i) || str.contains("%s") || str.contains("%i") || str.contains("%e") || str.contains("%f") || str.contains("%x") || str.contains("%o") || str.contains("%p");
    }

    private static Object[] b(String str, String str2, Object[] objArr) {
        int i7 = 1;
        Object[] objArr2 = new Object[(f33539c.equals(str) ? 1 : 2) + (objArr != null ? objArr.length : 0)];
        if (f33539c.equals(str)) {
            i7 = 0;
        } else {
            objArr2[0] = str;
        }
        int i8 = i7 + 1;
        objArr2[i7] = str2;
        if (objArr != null && objArr.length > 0) {
            System.arraycopy(objArr, 0, objArr2, i8, objArr.length);
        }
        return objArr2;
    }

    private static void c(Object[] objArr) {
        for (int length = objArr.length - 1; length >= 0; length--) {
            Object obj = objArr[length];
            if (obj instanceof Throwable) {
                objArr[length] = o.b((Throwable) obj);
            }
        }
    }

    public static void d(String str, String str2, String str3, Object... objArr) {
        q(1, str, str2, str3, objArr);
    }

    public static void e(String str, Object... objArr) {
        q(1, "", "", str, objArr);
    }

    public static void f(String str, String str2, String str3, Object... objArr) {
        q(8, str, str2, str3, objArr);
    }

    public static void g(String str, Throwable th) {
        q(8, "", "", str.concat(" %s"), th);
    }

    public static void h(String str, Object... objArr) {
        q(8, "", "", str, objArr);
    }

    public static void i(Throwable th) {
        if (f33541e <= 8) {
            Log.e(f33537a, "", th);
        }
    }

    private static String j(String str, Object[] objArr, Object[] objArr2) {
        int length = objArr.length - ((objArr2 == null || objArr2.length <= 0) ? 0 : objArr2.length);
        Object[] objArr3 = new Object[length];
        System.arraycopy(objArr, 0, objArr3, 0, length);
        int iLastIndexOf = str.lastIndexOf(91);
        String str2 = String.format(str.substring(0, iLastIndexOf), objArr3);
        StringBuilder sb = new StringBuilder(str.substring(iLastIndexOf + 1, str.length() - 1));
        sb.append(" -- origin args is");
        for (int i7 = 0; objArr2 != null && i7 < objArr2.length; i7++) {
            sb.append(" $");
            sb.append(i7);
            sb.append(" = ");
            sb.append(objArr2[i7]);
        }
        return str2 + sb.toString();
    }

    public static String k(int i7) {
        return l(null, i7);
    }

    public static String l(String str, int i7) {
        int i8;
        if (i7 < 1) {
            return "getLastStack with no fileName or step";
        }
        if (1 < f33541e) {
            return "getLastStack in release";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace == null || stackTrace.length < 2) {
            return "";
        }
        if (!TextUtils.isEmpty(str)) {
            i8 = 1;
            while (true) {
                if (i8 >= stackTrace.length) {
                    i8 = 0;
                    break;
                }
                if (stackTrace[i8].getFileName() == null) {
                    return "";
                }
                if (!stackTrace[i8].getFileName().contains(str)) {
                    break;
                }
                i8++;
            }
        } else {
            i8 = 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i9 = i8; i9 < i8 + i7 && i9 < stackTrace.length; i9++) {
            String fileName = stackTrace[i9].getFileName();
            if (fileName != null && fileName.length() > 2) {
                fileName = String.format("%s-%s", fileName.substring(0, 1), fileName.substring(1));
            }
            sb.append(String.format("[%s-%s-%s]", fileName, stackTrace[i9].getMethodName(), Integer.valueOf(stackTrace[i9].getLineNumber())));
        }
        return sb.toString();
    }

    public static int m() {
        return f33541e;
    }

    public static void n(String str, String str2, String str3, Object... objArr) {
        q(2, str, str2, str3, objArr);
    }

    public static void o(String str, Object... objArr) {
        q(2, "", "", str, objArr);
    }

    public static void p(String str, int i7, String str2) {
        f33540d = str;
        f33541e = i7;
        f33542f = str2;
    }

    private static void q(int i7, String str, String str2, String str3, Object... objArr) {
        if (a(str) && a(str2)) {
            w(i7, "", "", str + str2, b(f33539c, str3, objArr));
            return;
        }
        if (a(str)) {
            w(i7, "", "", str, b(str2, str3, objArr));
        } else if (a(str2)) {
            w(i7, str, "", str2, b(f33539c, str3, objArr));
        } else {
            w(i7, str, str2, str3, objArr);
        }
    }

    private static StackTraceElement r() {
        int i7;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i8 = -1;
        for (int i9 = 0; i9 < stackTrace.length; i9++) {
            if (stackTrace[i9].getClassName().equals(a.class.getName())) {
                i8 = i9;
            }
        }
        if (i8 == -1 || (i7 = i8 + 1) >= stackTrace.length) {
            return null;
        }
        return stackTrace[i7];
    }

    public static void s(int i7) {
        f33541e = i7;
    }

    public static void t(String str) {
        f33542f = str;
    }

    public static void u(String str, String str2, String str3, Object... objArr) {
        q(4, str, str2, str3, objArr);
    }

    public static void v(String str, Object... objArr) {
        q(4, "", "", str, objArr);
    }

    private static void w(int i7, String str, String str2, String str3, Object[] objArr) {
        int i8;
        String strJ;
        if (f33541e > i7) {
            return;
        }
        StackTraceElement stackTraceElementR = r();
        if (stackTraceElementR == null) {
            Log.v(f33537a, "StackTraceElement is null");
            return;
        }
        Object[] objArr2 = new Object[((objArr == null || objArr.length <= 0) ? 1 : objArr.length) + 8 + (!TextUtils.isEmpty(str) ? 1 : 0) + (!TextUtils.isEmpty(str2) ? 1 : 0)];
        StringBuilder sb = new StringBuilder("[%s][%s_%s][%s]");
        objArr2[0] = Thread.currentThread().getName();
        objArr2[1] = f33540d;
        objArr2[2] = f33542f;
        objArr2[3] = f33549m.get(i7);
        if (TextUtils.isEmpty(str)) {
            i8 = 4;
        } else {
            sb.append("[%s]");
            objArr2[4] = str;
            i8 = 5;
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append("[%s]");
            objArr2[i8] = str2;
            i8++;
        }
        sb.append("[%s:%s]");
        int i9 = i8 + 1;
        objArr2[i8] = stackTraceElementR.getFileName();
        int i10 = i9 + 1;
        objArr2[i9] = Integer.valueOf(stackTraceElementR.getLineNumber());
        if (objArr == null || objArr.length <= 0) {
            objArr2[i10] = str3;
            sb.append("[%s]");
        } else {
            System.arraycopy(objArr, 0, objArr2, i10, objArr.length);
            sb.append('[');
            sb.append(str3);
            sb.append(']');
        }
        if (i7 == 4 || i7 == 8) {
            c(objArr2);
        }
        try {
            strJ = String.format(sb.toString(), objArr2);
        } catch (Exception unused) {
            strJ = j(sb.toString(), objArr2, objArr);
        }
        if (i7 == 1) {
            Log.d(f33537a, strJ);
            return;
        }
        if (i7 == 2) {
            Log.i(f33537a, strJ);
        } else if (i7 == 4) {
            Log.w(f33537a, strJ);
        } else {
            if (i7 != 8) {
                return;
            }
            Log.e(f33537a, strJ);
        }
    }
}
