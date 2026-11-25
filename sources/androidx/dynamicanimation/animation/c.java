package androidx.dynamicanimation.animation;

import c.v;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b<c> {
    private final a G;

    static final class a implements i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final float f7414d = -4.2f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final float f7415e = 62.5f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f7417b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f7416a = f7414d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b.p f7418c = new b.p();

        a() {
        }

        @Override // androidx.dynamicanimation.animation.i
        public boolean a(float f8, float f9) {
            return Math.abs(f9) < this.f7417b;
        }

        @Override // androidx.dynamicanimation.animation.i
        public float b(float f8, float f9) {
            return f9 * this.f7416a;
        }

        float c() {
            return this.f7416a / f7414d;
        }

        void d(float f8) {
            this.f7416a = f8 * f7414d;
        }

        void e(float f8) {
            this.f7417b = f8 * f7415e;
        }

        b.p f(float f8, float f9, long j7) {
            float f10 = j7;
            this.f7418c.f7413b = (float) (((double) f9) * Math.exp((f10 / 1000.0f) * this.f7416a));
            b.p pVar = this.f7418c;
            float f11 = this.f7416a;
            pVar.f7412a = (float) (((double) (f8 - (f9 / f11))) + (((double) (f9 / f11)) * Math.exp((f11 * f10) / 1000.0f)));
            b.p pVar2 = this.f7418c;
            if (a(pVar2.f7412a, pVar2.f7413b)) {
                this.f7418c.f7413b = 0.0f;
            }
            return this.f7418c;
        }
    }

    public c(h hVar) {
        super(hVar);
        a aVar = new a();
        this.G = aVar;
        aVar.e(i());
    }

    public c A(@v(from = 0.0d, fromInclusive = false) float f8) {
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.G.d(f8);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.b
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public c p(float f8) {
        super.p(f8);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.b
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public c q(float f8) {
        super.q(f8);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.b
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public c u(float f8) {
        super.u(f8);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.b
    float f(float f8, float f9) {
        return this.G.b(f8, f9);
    }

    @Override // androidx.dynamicanimation.animation.b
    boolean j(float f8, float f9) {
        return f8 >= this.f7404g || f8 <= this.f7405h || this.G.a(f8, f9);
    }

    @Override // androidx.dynamicanimation.animation.b
    void v(float f8) {
        this.G.e(f8);
    }

    @Override // androidx.dynamicanimation.animation.b
    boolean y(long j7) {
        b.p pVarF = this.G.f(this.f7399b, this.f7398a, j7);
        float f8 = pVarF.f7412a;
        this.f7399b = f8;
        float f9 = pVarF.f7413b;
        this.f7398a = f9;
        float f10 = this.f7405h;
        if (f8 < f10) {
            this.f7399b = f10;
            return true;
        }
        float f11 = this.f7404g;
        if (f8 <= f11) {
            return j(f8, f9);
        }
        this.f7399b = f11;
        return true;
    }

    public float z() {
        return this.G.c();
    }

    public <K> c(K k7, g<K> gVar) {
        super(k7, gVar);
        a aVar = new a();
        this.G = aVar;
        aVar.e(i());
    }
}
