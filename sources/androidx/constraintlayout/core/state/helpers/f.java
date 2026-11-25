package androidx.constraintlayout.core.state.helpers;

/* JADX INFO: loaded from: classes.dex */
public class f implements e, androidx.constraintlayout.core.state.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final androidx.constraintlayout.core.state.h f3347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.h f3349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3350d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3351e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f3352f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f3353g;

    public f(androidx.constraintlayout.core.state.h hVar) {
        this.f3347a = hVar;
    }

    @Override // androidx.constraintlayout.core.state.helpers.e, androidx.constraintlayout.core.state.e
    public androidx.constraintlayout.core.widgets.e a() {
        if (this.f3349c == null) {
            this.f3349c = new androidx.constraintlayout.core.widgets.h();
        }
        return this.f3349c;
    }

    @Override // androidx.constraintlayout.core.state.helpers.e, androidx.constraintlayout.core.state.e
    public void apply() {
        this.f3349c.B2(this.f3348b);
        int i7 = this.f3350d;
        if (i7 != -1) {
            this.f3349c.w2(i7);
            return;
        }
        int i8 = this.f3351e;
        if (i8 != -1) {
            this.f3349c.x2(i8);
        } else {
            this.f3349c.y2(this.f3352f);
        }
    }

    @Override // androidx.constraintlayout.core.state.e
    public void b(androidx.constraintlayout.core.widgets.e eVar) {
        if (eVar instanceof androidx.constraintlayout.core.widgets.h) {
            this.f3349c = (androidx.constraintlayout.core.widgets.h) eVar;
        } else {
            this.f3349c = null;
        }
    }

    @Override // androidx.constraintlayout.core.state.e
    public void c(Object obj) {
        this.f3353g = obj;
    }

    @Override // androidx.constraintlayout.core.state.e
    public e d() {
        return null;
    }

    public f e(Object obj) {
        this.f3350d = -1;
        this.f3351e = this.f3347a.f(obj);
        this.f3352f = 0.0f;
        return this;
    }

    public int f() {
        return this.f3348b;
    }

    public f g(float f8) {
        this.f3350d = -1;
        this.f3351e = -1;
        this.f3352f = f8;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.e
    public Object getKey() {
        return this.f3353g;
    }

    public void h(int i7) {
        this.f3348b = i7;
    }

    public f i(Object obj) {
        this.f3350d = this.f3347a.f(obj);
        this.f3351e = -1;
        this.f3352f = 0.0f;
        return this;
    }
}
