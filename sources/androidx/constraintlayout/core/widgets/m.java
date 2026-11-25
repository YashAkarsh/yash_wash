package androidx.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3734d;

    public boolean a(int i7, int i8) {
        int i9;
        int i10 = this.f3731a;
        return i7 >= i10 && i7 < i10 + this.f3733c && i8 >= (i9 = this.f3732b) && i8 < i9 + this.f3734d;
    }

    public int b() {
        return (this.f3731a + this.f3733c) / 2;
    }

    public int c() {
        return (this.f3732b + this.f3734d) / 2;
    }

    void d(int i7, int i8) {
        this.f3731a -= i7;
        this.f3732b -= i8;
        this.f3733c += i7 * 2;
        this.f3734d += i8 * 2;
    }

    boolean e(m mVar) {
        int i7;
        int i8;
        int i9 = this.f3731a;
        int i10 = mVar.f3731a;
        return i9 >= i10 && i9 < i10 + mVar.f3733c && (i7 = this.f3732b) >= (i8 = mVar.f3732b) && i7 < i8 + mVar.f3734d;
    }

    public void f(int i7, int i8, int i9, int i10) {
        this.f3731a = i7;
        this.f3732b = i8;
        this.f3733c = i9;
        this.f3734d = i10;
    }
}
