package junit.framework;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f34342f = "...";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f34343g = "]";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f34344h = "[";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f34345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f34346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f34347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34349e;

    public c(int i7, String str, String str2) {
        this.f34345a = i7;
        this.f34346b = str;
        this.f34347c = str2;
    }

    private boolean a() {
        return this.f34346b.equals(this.f34347c);
    }

    private String c(String str) {
        String str2 = f34344h + str.substring(this.f34348d, (str.length() - this.f34349e) + 1) + f34343g;
        if (this.f34348d > 0) {
            str2 = d() + str2;
        }
        if (this.f34349e <= 0) {
            return str2;
        }
        return str2 + e();
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f34348d > this.f34345a ? f34342f : "");
        sb.append(this.f34346b.substring(Math.max(0, this.f34348d - this.f34345a), this.f34348d));
        return sb.toString();
    }

    private String e() {
        int iMin = Math.min((this.f34346b.length() - this.f34349e) + 1 + this.f34345a, this.f34346b.length());
        StringBuilder sb = new StringBuilder();
        String str = this.f34346b;
        sb.append(str.substring((str.length() - this.f34349e) + 1, iMin));
        sb.append((this.f34346b.length() - this.f34349e) + 1 < this.f34346b.length() - this.f34345a ? f34342f : "");
        return sb.toString();
    }

    private void f() {
        this.f34348d = 0;
        int iMin = Math.min(this.f34346b.length(), this.f34347c.length());
        while (true) {
            int i7 = this.f34348d;
            if (i7 >= iMin || this.f34346b.charAt(i7) != this.f34347c.charAt(this.f34348d)) {
                return;
            } else {
                this.f34348d++;
            }
        }
    }

    private void g() {
        int length = this.f34346b.length() - 1;
        int length2 = this.f34347c.length() - 1;
        while (true) {
            int i7 = this.f34348d;
            if (length2 < i7 || length < i7 || this.f34346b.charAt(length) != this.f34347c.charAt(length2)) {
                break;
            }
            length2--;
            length--;
        }
        this.f34349e = this.f34346b.length() - length;
    }

    public String b(String str) {
        if (this.f34346b == null || this.f34347c == null || a()) {
            return a.N(str, this.f34346b, this.f34347c);
        }
        f();
        g();
        return a.N(str, c(this.f34346b), c(this.f34347c));
    }
}
