package androidx.media;

import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8693f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8694g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8695h = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f8699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f8700e;

    class a implements w.b {
        a() {
        }

        @Override // androidx.media.w.b
        public void a(int i7) {
            v.this.f(i7);
        }

        @Override // androidx.media.w.b
        public void b(int i7) {
            v.this.e(i7);
        }
    }

    public static abstract class b {
        public abstract void a(v vVar);
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public v(int i7, int i8, int i9) {
        this.f8696a = i7;
        this.f8697b = i8;
        this.f8698c = i9;
    }

    public final int a() {
        return this.f8698c;
    }

    public final int b() {
        return this.f8697b;
    }

    public final int c() {
        return this.f8696a;
    }

    public Object d() {
        if (this.f8700e == null) {
            this.f8700e = w.a(this.f8696a, this.f8697b, this.f8698c, new a());
        }
        return this.f8700e;
    }

    public void e(int i7) {
    }

    public void f(int i7) {
    }

    public void g(b bVar) {
        this.f8699d = bVar;
    }

    public final void h(int i7) {
        this.f8698c = i7;
        Object objD = d();
        if (objD != null) {
            w.b(objD, i7);
        }
        b bVar = this.f8699d;
        if (bVar != null) {
            bVar.a(this);
        }
    }
}
