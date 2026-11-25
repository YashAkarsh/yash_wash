package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.k2;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public class l0 {

    @kotlin.g1(version = "1.4")
    public static class a {
        private a() {
        }
    }

    private l0() {
    }

    private static <T extends Throwable> T A(T t7) {
        return (T) B(t7, l0.class.getName());
    }

    static <T extends Throwable> T B(T t7, String str) {
        StackTraceElement[] stackTrace = t7.getStackTrace();
        int length = stackTrace.length;
        int i7 = -1;
        for (int i8 = 0; i8 < length; i8++) {
            if (str.equals(stackTrace[i8].getClassName())) {
                i7 = i8;
            }
        }
        t7.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i7 + 1, length));
        return t7;
    }

    public static String C(String str, Object obj) {
        return str + obj;
    }

    public static void D() {
        throw ((AssertionError) A(new AssertionError()));
    }

    public static void E(String str) {
        throw ((AssertionError) A(new AssertionError(str)));
    }

    public static void F() {
        throw ((IllegalArgumentException) A(new IllegalArgumentException()));
    }

    public static void G(String str) {
        throw ((IllegalArgumentException) A(new IllegalArgumentException(str)));
    }

    public static void H() {
        throw ((IllegalStateException) A(new IllegalStateException()));
    }

    public static void I(String str) {
        throw ((IllegalStateException) A(new IllegalStateException(str)));
    }

    @kotlin.g1(version = "1.4")
    public static void J() {
        throw ((NullPointerException) A(new NullPointerException()));
    }

    @kotlin.g1(version = "1.4")
    public static void K(String str) {
        throw ((NullPointerException) A(new NullPointerException(str)));
    }

    public static void L() {
        throw ((kotlin.z) A(new kotlin.z()));
    }

    public static void M(String str) {
        throw ((kotlin.z) A(new kotlin.z(str)));
    }

    private static void N(String str) {
        throw ((IllegalArgumentException) A(new IllegalArgumentException(v(str))));
    }

    private static void O(String str) {
        throw ((NullPointerException) A(new NullPointerException(v(str))));
    }

    public static void P() {
        Q("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Q(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void R(String str) {
        throw ((k2) A(new k2(str)));
    }

    public static void S(String str) {
        R("lateinit property " + str + " has not been initialized");
    }

    @kotlin.g1(version = "1.1")
    public static boolean a(double d8, Double d9) {
        return d9 != null && d8 == d9.doubleValue();
    }

    @kotlin.g1(version = "1.1")
    public static boolean b(float f8, Float f9) {
        return f9 != null && f8 == f9.floatValue();
    }

    @kotlin.g1(version = "1.1")
    public static boolean c(Double d8, double d9) {
        return d8 != null && d8.doubleValue() == d9;
    }

    @kotlin.g1(version = "1.1")
    public static boolean d(Double d8, Double d9) {
        if (d8 == null) {
            if (d9 == null) {
                return true;
            }
        } else if (d9 != null && d8.doubleValue() == d9.doubleValue()) {
            return true;
        }
        return false;
    }

    @kotlin.g1(version = "1.1")
    public static boolean e(Float f8, float f9) {
        return f8 != null && f8.floatValue() == f9;
    }

    @kotlin.g1(version = "1.1")
    public static boolean f(Float f8, Float f9) {
        if (f8 == null) {
            if (f9 == null) {
                return true;
            }
        } else if (f9 != null && f8.floatValue() == f9.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean g(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException(str + " must not be null")));
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) A(new IllegalStateException(str)));
        }
    }

    public static void j(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException("Field specified as non-null is null: " + str + com.alibaba.android.arouter.utils.b.f12515h + str2)));
    }

    public static void k(String str) throws ClassNotFoundException {
        String strReplace = str.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e8) {
            throw ((ClassNotFoundException) A(new ClassNotFoundException("Class " + strReplace + " is not found. Please update the Kotlin runtime to the latest version", e8)));
        }
    }

    public static void l(String str, String str2) throws ClassNotFoundException {
        String strReplace = str.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR);
        try {
            Class.forName(strReplace);
        } catch (ClassNotFoundException e8) {
            throw ((ClassNotFoundException) A(new ClassNotFoundException("Class " + strReplace + " is not found: this code requires the Kotlin runtime of version at least " + str2, e8)));
        }
    }

    public static void m(Object obj) {
        if (obj == null) {
            J();
        }
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            K(str);
        }
    }

    public static void o(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) A(new NullPointerException(str + " must not be null")));
    }

    public static void p(Object obj, String str) {
        if (obj == null) {
            O(str);
        }
    }

    public static void q(Object obj, String str) {
        if (obj == null) {
            N(str);
        }
    }

    public static void r(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) A(new IllegalStateException(str)));
        }
    }

    public static void s(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) A(new IllegalStateException("Method specified as non-null returned null: " + str + com.alibaba.android.arouter.utils.b.f12515h + str2)));
    }

    public static int t(int i7, int i8) {
        if (i7 < i8) {
            return -1;
        }
        return i7 == i8 ? 0 : 1;
    }

    public static int u(long j7, long j8) {
        if (j7 < j8) {
            return -1;
        }
        return j7 == j8 ? 0 : 1;
    }

    private static String v(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + com.alibaba.android.arouter.utils.b.f12515h + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static void w() {
        P();
    }

    public static void x(String str) {
        Q(str);
    }

    public static void y(int i7, String str) {
        P();
    }

    public static void z(int i7, String str, String str2) {
        Q(str2);
    }
}
