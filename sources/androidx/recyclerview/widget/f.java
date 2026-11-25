package androidx.recyclerview.widget;

import c.m0;

/* JADX INFO: loaded from: classes.dex */
public class f implements t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9408f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9409g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9410h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9411i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final t f9412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9413b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f9414c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9415d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Object f9416e = null;

    public f(@m0 t tVar) {
        this.f9412a = tVar;
    }

    @Override // androidx.recyclerview.widget.t
    public void a(int i7, int i8) {
        e();
        this.f9412a.a(i7, i8);
    }

    @Override // androidx.recyclerview.widget.t
    public void b(int i7, int i8) {
        int i9;
        if (this.f9413b == 1 && i7 >= (i9 = this.f9414c)) {
            int i10 = this.f9415d;
            if (i7 <= i9 + i10) {
                this.f9415d = i10 + i8;
                this.f9414c = Math.min(i7, i9);
                return;
            }
        }
        e();
        this.f9414c = i7;
        this.f9415d = i8;
        this.f9413b = 1;
    }

    @Override // androidx.recyclerview.widget.t
    public void c(int i7, int i8) {
        int i9;
        if (this.f9413b == 2 && (i9 = this.f9414c) >= i7 && i9 <= i7 + i8) {
            this.f9415d += i8;
            this.f9414c = i7;
        } else {
            e();
            this.f9414c = i7;
            this.f9415d = i8;
            this.f9413b = 2;
        }
    }

    @Override // androidx.recyclerview.widget.t
    public void d(int i7, int i8, Object obj) {
        int i9;
        if (this.f9413b == 3) {
            int i10 = this.f9414c;
            int i11 = this.f9415d;
            if (i7 <= i10 + i11 && (i9 = i7 + i8) >= i10 && this.f9416e == obj) {
                this.f9414c = Math.min(i7, i10);
                this.f9415d = Math.max(i11 + i10, i9) - this.f9414c;
                return;
            }
        }
        e();
        this.f9414c = i7;
        this.f9415d = i8;
        this.f9416e = obj;
        this.f9413b = 3;
    }

    public void e() {
        int i7 = this.f9413b;
        if (i7 == 0) {
            return;
        }
        if (i7 == 1) {
            this.f9412a.b(this.f9414c, this.f9415d);
        } else if (i7 == 2) {
            this.f9412a.c(this.f9414c, this.f9415d);
        } else if (i7 == 3) {
            this.f9412a.d(this.f9414c, this.f9415d, this.f9416e);
        }
        this.f9416e = null;
        this.f9413b = 0;
    }
}
