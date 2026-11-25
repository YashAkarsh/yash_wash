package org.junit;

/* JADX INFO: loaded from: classes3.dex */
public class i extends AssertionError {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f39816c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f39817d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f39818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f39819b;

    private static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f39820d = "...";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f39821e = "]";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f39822f = "[";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f39823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f39824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f39825c;

        private class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f39826a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f39827b;

            private String e(String str) {
                return b.f39822f + str.substring(this.f39826a.length(), str.length() - this.f39827b.length()) + b.f39821e;
            }

            public String a() {
                return e(b.this.f39825c);
            }

            public String b() {
                if (this.f39826a.length() <= b.this.f39823a) {
                    return this.f39826a;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(b.f39820d);
                String str = this.f39826a;
                sb.append(str.substring(str.length() - b.this.f39823a));
                return sb.toString();
            }

            public String c() {
                if (this.f39827b.length() <= b.this.f39823a) {
                    return this.f39827b;
                }
                return this.f39827b.substring(0, b.this.f39823a) + b.f39820d;
            }

            public String d() {
                return e(b.this.f39824b);
            }

            private a() {
                String strG = b.this.g();
                this.f39826a = strG;
                this.f39827b = b.this.h(strG);
            }
        }

        public b(int i7, String str, String str2) {
            this.f39823a = i7;
            this.f39824b = str;
            this.f39825c = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String g() {
            int iMin = Math.min(this.f39824b.length(), this.f39825c.length());
            for (int i7 = 0; i7 < iMin; i7++) {
                if (this.f39824b.charAt(i7) != this.f39825c.charAt(i7)) {
                    return this.f39824b.substring(0, i7);
                }
            }
            return this.f39824b.substring(0, iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String h(String str) {
            int iMin = Math.min(this.f39824b.length() - str.length(), this.f39825c.length() - str.length()) - 1;
            int i7 = 0;
            while (i7 <= iMin) {
                String str2 = this.f39824b;
                char cCharAt = str2.charAt((str2.length() - 1) - i7);
                String str3 = this.f39825c;
                if (cCharAt != str3.charAt((str3.length() - 1) - i7)) {
                    break;
                }
                i7++;
            }
            String str4 = this.f39824b;
            return str4.substring(str4.length() - i7);
        }

        public String f(String str) {
            String str2;
            String str3 = this.f39824b;
            if (str3 == null || (str2 = this.f39825c) == null || str3.equals(str2)) {
                return c.k0(str, this.f39824b, this.f39825c);
            }
            a aVar = new a();
            String strB = aVar.b();
            String strC = aVar.c();
            return c.k0(str, strB + aVar.d() + strC, strB + aVar.a() + strC);
        }
    }

    public i(String str, String str2, String str3) {
        super(str);
        this.f39818a = str2;
        this.f39819b = str3;
    }

    public String a() {
        return this.f39819b;
    }

    public String b() {
        return this.f39818a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return new b(20, this.f39818a, this.f39819b).f(super.getMessage());
    }
}
