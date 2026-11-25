package com.google.common.base;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@s1.b
public final class x {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f19574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f19575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f19576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f19577d;

        private static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            String f19578a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f19579b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            a f19580c;

            private a() {
            }
        }

        private a h() {
            a aVar = new a();
            this.f19576c.f19580c = aVar;
            this.f19576c = aVar;
            return aVar;
        }

        private b i(Object obj) {
            h().f19579b = obj;
            return this;
        }

        private b j(String str, Object obj) {
            a aVarH = h();
            aVarH.f19579b = obj;
            aVarH.f19578a = (String) e0.E(str);
            return this;
        }

        @u1.a
        public b a(String str, char c8) {
            return j(str, String.valueOf(c8));
        }

        @u1.a
        public b b(String str, double d8) {
            return j(str, String.valueOf(d8));
        }

        @u1.a
        public b c(String str, float f8) {
            return j(str, String.valueOf(f8));
        }

        @u1.a
        public b d(String str, int i7) {
            return j(str, String.valueOf(i7));
        }

        @u1.a
        public b e(String str, long j7) {
            return j(str, String.valueOf(j7));
        }

        @u1.a
        public b f(String str, Object obj) {
            return j(str, obj);
        }

        @u1.a
        public b g(String str, boolean z7) {
            return j(str, String.valueOf(z7));
        }

        @u1.a
        public b k(char c8) {
            return i(String.valueOf(c8));
        }

        @u1.a
        public b l(double d8) {
            return i(String.valueOf(d8));
        }

        @u1.a
        public b m(float f8) {
            return i(String.valueOf(f8));
        }

        @u1.a
        public b n(int i7) {
            return i(String.valueOf(i7));
        }

        @u1.a
        public b o(long j7) {
            return i(String.valueOf(j7));
        }

        @u1.a
        public b p(Object obj) {
            return i(obj);
        }

        @u1.a
        public b q(boolean z7) {
            return i(String.valueOf(z7));
        }

        @u1.a
        public b r() {
            this.f19577d = true;
            return this;
        }

        public String toString() {
            boolean z7 = this.f19577d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f19574a);
            sb.append('{');
            String str = "";
            for (a aVar = this.f19575b.f19580c; aVar != null; aVar = aVar.f19580c) {
                Object obj = aVar.f19579b;
                if (!z7 || obj != null) {
                    sb.append(str);
                    String str2 = aVar.f19578a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String strDeepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.f19575b = aVar;
            this.f19576c = aVar;
            this.f19577d = false;
            this.f19574a = (String) e0.E(str);
        }
    }

    private x() {
    }

    public static <T> T a(T t7, T t8) {
        if (t7 != null) {
            return t7;
        }
        if (t8 != null) {
            return t8;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Class<?> cls) {
        return new b(cls.getSimpleName());
    }

    public static b c(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }

    public static b d(String str) {
        return new b(str);
    }
}
