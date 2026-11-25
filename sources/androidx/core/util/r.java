package androidx.core.util;

import c.m0;
import c.o0;
import c.t0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class r {

    @t0(19)
    static class a {
        private a() {
        }

        @c.t
        static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        @c.t
        static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    private r() {
    }

    public static boolean a(@o0 Object obj, @o0 Object obj2) {
        return a.a(obj, obj2);
    }

    public static int b(@o0 Object... objArr) {
        return a.b(objArr);
    }

    public static int c(@o0 Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @m0
    public static <T> T d(@o0 T t7) {
        t7.getClass();
        return t7;
    }

    @m0
    public static <T> T e(@o0 T t7, @m0 String str) {
        if (t7 != null) {
            return t7;
        }
        throw new NullPointerException(str);
    }

    @o0
    public static String f(@o0 Object obj, @o0 String str) {
        return obj != null ? obj.toString() : str;
    }
}
