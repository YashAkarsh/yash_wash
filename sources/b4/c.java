package b4;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11314d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f11315a = new c();

        public c a() {
            return this.f11315a;
        }

        public b b(boolean z7) {
            this.f11315a.e(z7);
            return this;
        }

        public b c(int i7) {
            this.f11315a.f(i7);
            return this;
        }

        public b d(String str) {
            this.f11315a.g(str);
            return this;
        }

        public b e(boolean z7) {
            this.f11315a.h(z7);
            return this;
        }
    }

    public int a() {
        return this.f11314d;
    }

    public String b() {
        return this.f11313c;
    }

    public boolean c() {
        return this.f11311a;
    }

    public boolean d() {
        return this.f11312b;
    }

    public void e(boolean z7) {
        this.f11311a = z7;
    }

    public void f(int i7) {
        this.f11314d = i7;
    }

    public void g(String str) {
        this.f11313c = str;
    }

    public void h(boolean z7) {
        this.f11312b = z7;
    }

    public String toString() {
        return String.format("debugEnabled=%b, printLog=%b, logTag=%s, globalLogLevel=0x%02X", Boolean.valueOf(this.f11311a), Boolean.valueOf(this.f11312b), this.f11313c, Integer.valueOf(this.f11314d));
    }

    public c() {
        this.f11311a = true;
        this.f11312b = true;
        this.f11313c = "Realtek";
        this.f11314d = 1;
    }
}
