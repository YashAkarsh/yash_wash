package j6;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import u6.b;
import u6.c;
import v6.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private a() {
        throw new Error("do not instantiate");
    }

    @c
    public static String a(String str) {
        return b(str, 0);
    }

    @c
    public static String b(String str, int i7) {
        try {
            int iC = c(Pattern.compile(str));
            if (iC >= i7) {
                return str;
            }
            throw new Error(i(str, i7, iC));
        } catch (PatternSyntaxException e8) {
            throw new Error(e8);
        }
    }

    @b
    private static int c(Pattern pattern) {
        return pattern.matcher("").groupCount();
    }

    @b
    @l(expression = {"#1"}, qualifier = k6.c.class, result = true)
    public static boolean d(char c8) {
        return e(Character.toString(c8));
    }

    @b
    @l(expression = {"#1"}, qualifier = k6.c.class, result = true)
    public static boolean e(String str) {
        return f(str, 0);
    }

    @b
    @l(expression = {"#1"}, qualifier = k6.c.class, result = true)
    public static boolean f(String str, int i7) {
        try {
            return c(Pattern.compile(str)) >= i7;
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }

    @c
    public static String g(String str) {
        return h(str, 0);
    }

    @c
    public static String h(String str, int i7) {
        try {
            int iC = c(Pattern.compile(str));
            if (iC < i7) {
                return i(str, i7, iC);
            }
            return null;
        } catch (PatternSyntaxException e8) {
            return e8.getMessage();
        }
    }

    @c
    private static String i(String str, int i7, int i8) {
        return "regex \"" + str + "\" has " + i8 + " groups, but " + i7 + " groups are needed.";
    }

    @c
    public static PatternSyntaxException j(String str) {
        return k(str, 0);
    }

    @c
    public static PatternSyntaxException k(String str, int i7) {
        try {
            int iC = c(Pattern.compile(str));
            if (iC < i7) {
                return new PatternSyntaxException(i(str, i7, iC), str, -1);
            }
            return null;
        } catch (PatternSyntaxException e8) {
            return e8;
        }
    }

    /* JADX INFO: renamed from: j6.a$a, reason: collision with other inner class name */
    public static class C0418a extends Exception {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f34326b = 6266881831979001480L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PatternSyntaxException f34327a;

        public C0418a(PatternSyntaxException patternSyntaxException) {
            this.f34327a = patternSyntaxException;
        }

        public String a() {
            return this.f34327a.getDescription();
        }

        public int b() {
            return this.f34327a.getIndex();
        }

        public String c() {
            return this.f34327a.getPattern();
        }

        @Override // java.lang.Throwable
        @b
        public String getMessage() {
            return this.f34327a.getMessage();
        }

        public C0418a(String str, String str2, int i7) {
            this(new PatternSyntaxException(str, str2, i7));
        }
    }
}
