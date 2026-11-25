package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static int f3188f = 80;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static int f3189g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f3190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f3191b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f3192c = Long.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b f3193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3194e;

    public c(char[] cArr) {
        this.f3190a = cArr;
    }

    protected void a(StringBuilder sb, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            sb.append(' ');
        }
    }

    public String b() {
        String str = new String(this.f3190a);
        long j7 = this.f3192c;
        if (j7 != Long.MAX_VALUE) {
            long j8 = this.f3191b;
            if (j7 >= j8) {
                return str.substring((int) j8, ((int) j7) + 1);
            }
        }
        long j9 = this.f3191b;
        return str.substring((int) j9, ((int) j9) + 1);
    }

    public c d() {
        return this.f3193d;
    }

    protected String f() {
        if (!g.f3200d) {
            return "";
        }
        return m() + " -> ";
    }

    public long g() {
        return this.f3192c;
    }

    public float h() {
        if (this instanceof e) {
            return ((e) this).h();
        }
        return Float.NaN;
    }

    public int j() {
        if (this instanceof e) {
            return ((e) this).j();
        }
        return 0;
    }

    public int k() {
        return this.f3194e;
    }

    public long l() {
        return this.f3191b;
    }

    protected String m() {
        String string = getClass().toString();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    public boolean n() {
        return this.f3192c != Long.MAX_VALUE;
    }

    public boolean o() {
        return this.f3191b > -1;
    }

    public boolean p() {
        return this.f3191b == -1;
    }

    public void r(b bVar) {
        this.f3193d = bVar;
    }

    public void s(long j7) {
        if (this.f3192c != Long.MAX_VALUE) {
            return;
        }
        this.f3192c = j7;
        if (g.f3200d) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        b bVar = this.f3193d;
        if (bVar != null) {
            bVar.x(this);
        }
    }

    public void t(int i7) {
        this.f3194e = i7;
    }

    public String toString() {
        long j7 = this.f3191b;
        long j8 = this.f3192c;
        if (j7 > j8 || j8 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.f3191b + "-" + this.f3192c + ")";
        }
        return m() + " (" + this.f3191b + " : " + this.f3192c + ") <<" + new String(this.f3190a).substring((int) this.f3191b, ((int) this.f3192c) + 1) + ">>";
    }

    public void u(long j7) {
        this.f3191b = j7;
    }

    protected String v(int i7, int i8) {
        return "";
    }

    protected String w() {
        return "";
    }
}
