package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
class g0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f9433c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f9434d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f9435e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f9436f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f9437g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f9438h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f9439i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f9440j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f9441k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int f9442l = 32;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f9443m = 64;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f9444n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int f9445o = 256;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final int f9446p = 512;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final int f9447q = 1024;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final int f9448r = 12;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final int f9449s = 4096;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final int f9450t = 8192;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f9451u = 16384;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final int f9452v = 7;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f9453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a f9454b = new a();

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f9455a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f9457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f9458d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f9459e;

        a() {
        }

        void a(int i7) {
            this.f9455a = i7 | this.f9455a;
        }

        boolean b() {
            int i7 = this.f9455a;
            if ((i7 & 7) != 0 && (i7 & (c(this.f9458d, this.f9456b) << 0)) == 0) {
                return false;
            }
            int i8 = this.f9455a;
            if ((i8 & 112) != 0 && (i8 & (c(this.f9458d, this.f9457c) << 4)) == 0) {
                return false;
            }
            int i9 = this.f9455a;
            if ((i9 & 1792) != 0 && (i9 & (c(this.f9459e, this.f9456b) << 8)) == 0) {
                return false;
            }
            int i10 = this.f9455a;
            return (i10 & 28672) == 0 || (i10 & (c(this.f9459e, this.f9457c) << 12)) != 0;
        }

        int c(int i7, int i8) {
            if (i7 > i8) {
                return 1;
            }
            return i7 == i8 ? 2 : 4;
        }

        void d() {
            this.f9455a = 0;
        }

        void e(int i7, int i8, int i9, int i10) {
            this.f9456b = i7;
            this.f9457c = i8;
            this.f9458d = i9;
            this.f9459e = i10;
        }
    }

    interface b {
        View a(int i7);

        int b(View view);

        int c();

        int d();

        int e(View view);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    g0(b bVar) {
        this.f9453a = bVar;
    }

    View a(int i7, int i8, int i9, int i10) {
        int iC = this.f9453a.c();
        int iD = this.f9453a.d();
        int i11 = i8 > i7 ? 1 : -1;
        View view = null;
        while (i7 != i8) {
            View viewA = this.f9453a.a(i7);
            this.f9454b.e(iC, iD, this.f9453a.b(viewA), this.f9453a.e(viewA));
            if (i9 != 0) {
                this.f9454b.d();
                this.f9454b.a(i9);
                if (this.f9454b.b()) {
                    return viewA;
                }
            }
            if (i10 != 0) {
                this.f9454b.d();
                this.f9454b.a(i10);
                if (this.f9454b.b()) {
                    view = viewA;
                }
            }
            i7 += i11;
        }
        return view;
    }

    boolean b(View view, int i7) {
        this.f9454b.e(this.f9453a.c(), this.f9453a.d(), this.f9453a.b(view), this.f9453a.e(view));
        if (i7 == 0) {
            return false;
        }
        this.f9454b.d();
        this.f9454b.a(i7);
        return this.f9454b.b();
    }
}
