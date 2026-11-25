package androidx.navigation;

import c.b0;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0
    private int f8908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.b
    @c.a
    private int f8910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.b
    @c.a
    private int f8911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.b
    @c.a
    private int f8912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.b
    @c.a
    private int f8913g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f8914a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f8916c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @b0
        int f8915b = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @c.b
        @c.a
        int f8917d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @c.b
        @c.a
        int f8918e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @c.b
        @c.a
        int f8919f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @c.b
        @c.a
        int f8920g = -1;

        @m0
        public t a() {
            return new t(this.f8914a, this.f8915b, this.f8916c, this.f8917d, this.f8918e, this.f8919f, this.f8920g);
        }

        @m0
        public a b(@c.b @c.a int i7) {
            this.f8917d = i7;
            return this;
        }

        @m0
        public a c(@c.b @c.a int i7) {
            this.f8918e = i7;
            return this;
        }

        @m0
        public a d(boolean z7) {
            this.f8914a = z7;
            return this;
        }

        @m0
        public a e(@c.b @c.a int i7) {
            this.f8919f = i7;
            return this;
        }

        @m0
        public a f(@c.b @c.a int i7) {
            this.f8920g = i7;
            return this;
        }

        @m0
        public a g(@b0 int i7, boolean z7) {
            this.f8915b = i7;
            this.f8916c = z7;
            return this;
        }
    }

    t(boolean z7, @b0 int i7, boolean z8, @c.b @c.a int i8, @c.b @c.a int i9, @c.b @c.a int i10, @c.b @c.a int i11) {
        this.f8907a = z7;
        this.f8908b = i7;
        this.f8909c = z8;
        this.f8910d = i8;
        this.f8911e = i9;
        this.f8912f = i10;
        this.f8913g = i11;
    }

    @c.b
    @c.a
    public int a() {
        return this.f8910d;
    }

    @c.b
    @c.a
    public int b() {
        return this.f8911e;
    }

    @c.b
    @c.a
    public int c() {
        return this.f8912f;
    }

    @c.b
    @c.a
    public int d() {
        return this.f8913g;
    }

    @b0
    public int e() {
        return this.f8908b;
    }

    public boolean f() {
        return this.f8909c;
    }

    public boolean g() {
        return this.f8907a;
    }
}
