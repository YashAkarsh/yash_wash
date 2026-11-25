package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
class y0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2019i = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2020a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2021b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2022c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2023d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2024e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2025f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f2026g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2027h = false;

    y0() {
    }

    public int a() {
        return this.f2026g ? this.f2020a : this.f2021b;
    }

    public int b() {
        return this.f2020a;
    }

    public int c() {
        return this.f2021b;
    }

    public int d() {
        return this.f2026g ? this.f2021b : this.f2020a;
    }

    public void e(int i7, int i8) {
        this.f2027h = false;
        if (i7 != Integer.MIN_VALUE) {
            this.f2024e = i7;
            this.f2020a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f2025f = i8;
            this.f2021b = i8;
        }
    }

    public void f(boolean z7) {
        if (z7 == this.f2026g) {
            return;
        }
        this.f2026g = z7;
        if (!this.f2027h) {
            this.f2020a = this.f2024e;
            this.f2021b = this.f2025f;
            return;
        }
        if (z7) {
            int i7 = this.f2023d;
            if (i7 == Integer.MIN_VALUE) {
                i7 = this.f2024e;
            }
            this.f2020a = i7;
            int i8 = this.f2022c;
            if (i8 == Integer.MIN_VALUE) {
                i8 = this.f2025f;
            }
            this.f2021b = i8;
            return;
        }
        int i9 = this.f2022c;
        if (i9 == Integer.MIN_VALUE) {
            i9 = this.f2024e;
        }
        this.f2020a = i9;
        int i10 = this.f2023d;
        if (i10 == Integer.MIN_VALUE) {
            i10 = this.f2025f;
        }
        this.f2021b = i10;
    }

    public void g(int i7, int i8) {
        this.f2022c = i7;
        this.f2023d = i8;
        this.f2027h = true;
        if (this.f2026g) {
            if (i8 != Integer.MIN_VALUE) {
                this.f2020a = i8;
            }
            if (i7 != Integer.MIN_VALUE) {
                this.f2021b = i7;
                return;
            }
            return;
        }
        if (i7 != Integer.MIN_VALUE) {
            this.f2020a = i7;
        }
        if (i8 != Integer.MIN_VALUE) {
            this.f2021b = i8;
        }
    }
}
