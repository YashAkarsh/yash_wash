package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class h<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean A;
    private Drawable B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<ModelType> f14141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f14142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final l f14143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Class<TranscodeType> f14144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.bumptech.glide.manager.m f14145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final com.bumptech.glide.manager.g f14146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a1.a<ModelType, DataType, ResourceType, TranscodeType> f14147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ModelType f14148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private w0.c f14149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.bumptech.glide.request.f<? super ModelType, TranscodeType> f14153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Float f14154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private h<?, ?, ?, TranscodeType> f14155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Float f14156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Drawable f14157q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Drawable f14158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private p f14159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f14160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.bumptech.glide.request.animation.f<TranscodeType> f14161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f14162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f14163w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.bumptech.glide.load.engine.c f14164x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private w0.g<ResourceType> f14165y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f14166z;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.request.e f14167a;

        a(com.bumptech.glide.request.e eVar) {
            this.f14167a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f14167a.isCancelled()) {
                return;
            }
            h.this.F(this.f14167a);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14169a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f14169a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14169a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14169a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14169a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    h(a1.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls, h<ModelType, ?, ?, ?> hVar) {
        this(hVar.f14142b, hVar.f14141a, fVar, cls, hVar.f14143c, hVar.f14145e, hVar.f14146f);
        this.f14148h = hVar.f14148h;
        this.f14150j = hVar.f14150j;
        this.f14149i = hVar.f14149i;
        this.f14164x = hVar.f14164x;
        this.f14160t = hVar.f14160t;
    }

    private p C() {
        p pVar = this.f14159s;
        if (pVar == p.LOW) {
            return p.NORMAL;
        }
        return pVar == p.NORMAL ? p.HIGH : p.IMMEDIATE;
    }

    private com.bumptech.glide.request.c I(com.bumptech.glide.request.target.m<TranscodeType> mVar, float f8, p pVar, com.bumptech.glide.request.d dVar) {
        return com.bumptech.glide.request.b.v(this.f14147g, this.f14148h, this.f14149i, this.f14142b, pVar, mVar, f8, this.f14157q, this.f14151k, this.f14158r, this.f14152l, this.B, this.C, this.f14153m, dVar, this.f14143c.v(), this.f14165y, this.f14144d, this.f14160t, this.f14161u, this.f14163w, this.f14162v, this.f14164x);
    }

    private com.bumptech.glide.request.c p(com.bumptech.glide.request.target.m<TranscodeType> mVar) {
        if (this.f14159s == null) {
            this.f14159s = p.NORMAL;
        }
        return q(mVar, null);
    }

    private com.bumptech.glide.request.c q(com.bumptech.glide.request.target.m<TranscodeType> mVar, com.bumptech.glide.request.h hVar) {
        h<?, ?, ?, TranscodeType> hVar2 = this.f14155o;
        if (hVar2 == null) {
            if (this.f14154n == null) {
                return I(mVar, this.f14156p.floatValue(), this.f14159s, hVar);
            }
            com.bumptech.glide.request.h hVar3 = new com.bumptech.glide.request.h(hVar);
            hVar3.n(I(mVar, this.f14156p.floatValue(), this.f14159s, hVar3), I(mVar, this.f14154n.floatValue(), C(), hVar3));
            return hVar3;
        }
        if (this.A) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (hVar2.f14161u.equals(com.bumptech.glide.request.animation.g.d())) {
            this.f14155o.f14161u = this.f14161u;
        }
        h<?, ?, ?, TranscodeType> hVar4 = this.f14155o;
        if (hVar4.f14159s == null) {
            hVar4.f14159s = C();
        }
        if (com.bumptech.glide.util.i.m(this.f14163w, this.f14162v)) {
            h<?, ?, ?, TranscodeType> hVar5 = this.f14155o;
            if (!com.bumptech.glide.util.i.m(hVar5.f14163w, hVar5.f14162v)) {
                this.f14155o.J(this.f14163w, this.f14162v);
            }
        }
        com.bumptech.glide.request.h hVar6 = new com.bumptech.glide.request.h(hVar);
        com.bumptech.glide.request.c cVarI = I(mVar, this.f14156p.floatValue(), this.f14159s, hVar6);
        this.A = true;
        com.bumptech.glide.request.c cVarQ = this.f14155o.q(mVar, hVar6);
        this.A = false;
        hVar6.n(cVarI, cVarQ);
        return hVar6;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> A(int i7) {
        this.C = i7;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> B(Drawable drawable) {
        this.B = drawable;
        return this;
    }

    public com.bumptech.glide.request.a<TranscodeType> D(int i7, int i8) {
        com.bumptech.glide.request.e eVar = new com.bumptech.glide.request.e(this.f14143c.x(), i7, i8);
        this.f14143c.x().post(new a(eVar));
        return eVar;
    }

    public com.bumptech.glide.request.target.m<TranscodeType> E(ImageView imageView) {
        com.bumptech.glide.util.i.b();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!this.f14166z && imageView.getScaleType() != null) {
            int i7 = b.f14169a[imageView.getScaleType().ordinal()];
            if (i7 == 1) {
                n();
            } else if (i7 == 2 || i7 == 3 || i7 == 4) {
                o();
            }
        }
        return F(this.f14143c.d(imageView, this.f14144d));
    }

    public <Y extends com.bumptech.glide.request.target.m<TranscodeType>> Y F(Y y7) {
        com.bumptech.glide.util.i.b();
        if (y7 == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.f14150j) {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        com.bumptech.glide.request.c cVarE = y7.e();
        if (cVarE != null) {
            cVarE.clear();
            this.f14145e.e(cVarE);
            cVarE.a();
        }
        com.bumptech.glide.request.c cVarP = p(y7);
        y7.a(cVarP);
        this.f14146f.a(y7);
        this.f14145e.h(cVarP);
        return y7;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> G(com.bumptech.glide.request.f<? super ModelType, TranscodeType> fVar) {
        this.f14153m = fVar;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> H(ModelType modeltype) {
        this.f14148h = modeltype;
        this.f14150j = true;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> J(int i7, int i8) {
        if (!com.bumptech.glide.util.i.m(i7, i8)) {
            throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.f14163w = i7;
        this.f14162v = i8;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> L(int i7) {
        this.f14151k = i7;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> M(Drawable drawable) {
        this.f14157q = drawable;
        return this;
    }

    public com.bumptech.glide.request.target.m<TranscodeType> N() {
        return O(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public com.bumptech.glide.request.target.m<TranscodeType> O(int i7, int i8) {
        return F(com.bumptech.glide.request.target.i.i(i7, i8));
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> P(p pVar) {
        this.f14159s = pVar;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> Q(w0.c cVar) {
        if (cVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.f14149i = cVar;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> R(float f8) {
        if (f8 < 0.0f || f8 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f14156p = Float.valueOf(f8);
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> S(boolean z7) {
        this.f14160t = !z7;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> T(w0.b<DataType> bVar) {
        a1.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f14147g;
        if (aVar != null) {
            aVar.q(bVar);
        }
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> U(float f8) {
        if (f8 < 0.0f || f8 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f14154n = Float.valueOf(f8);
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> V(h<?, ?, ?, TranscodeType> hVar) {
        if (equals(hVar)) {
            throw new IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
        }
        this.f14155o = hVar;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> W(y0.f<ResourceType, TranscodeType> fVar) {
        a1.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f14147g;
        if (aVar != null) {
            aVar.r(fVar);
        }
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> X(w0.g<ResourceType>... gVarArr) {
        this.f14166z = true;
        if (gVarArr.length == 1) {
            this.f14165y = gVarArr[0];
        } else {
            this.f14165y = new w0.d(gVarArr);
        }
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> g(int i7) {
        return l(new com.bumptech.glide.request.animation.i(this.f14142b, i7));
    }

    @Deprecated
    public h<ModelType, DataType, ResourceType, TranscodeType> k(Animation animation) {
        return l(new com.bumptech.glide.request.animation.i(animation));
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> l(com.bumptech.glide.request.animation.f<TranscodeType> fVar) {
        if (fVar == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.f14161u = fVar;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> m(com.bumptech.glide.request.animation.j.a aVar) {
        return l(new com.bumptech.glide.request.animation.k(aVar));
    }

    void n() {
    }

    void o() {
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> r(w0.e<File, ResourceType> eVar) {
        a1.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f14147g;
        if (aVar != null) {
            aVar.n(eVar);
        }
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public h<ModelType, DataType, ResourceType, TranscodeType> clone() {
        try {
            h<ModelType, DataType, ResourceType, TranscodeType> hVar = (h) super.clone();
            a1.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f14147g;
            hVar.f14147g = aVar != null ? aVar.clone() : null;
            return hVar;
        } catch (CloneNotSupportedException e8) {
            throw new RuntimeException(e8);
        }
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> t(w0.e<DataType, ResourceType> eVar) {
        a1.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f14147g;
        if (aVar != null) {
            aVar.p(eVar);
        }
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> u(com.bumptech.glide.load.engine.c cVar) {
        this.f14164x = cVar;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> v() {
        return l(com.bumptech.glide.request.animation.g.d());
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> w() {
        return X(com.bumptech.glide.load.resource.e.c());
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> x(w0.f<ResourceType> fVar) {
        a1.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f14147g;
        if (aVar != null) {
            aVar.o(fVar);
        }
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> y(int i7) {
        this.f14152l = i7;
        return this;
    }

    public h<ModelType, DataType, ResourceType, TranscodeType> z(Drawable drawable) {
        this.f14158r = drawable;
        return this;
    }

    h(Context context, Class<ModelType> cls, a1.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls2, l lVar, com.bumptech.glide.manager.m mVar, com.bumptech.glide.manager.g gVar) {
        this.f14149i = com.bumptech.glide.signature.b.b();
        this.f14156p = Float.valueOf(1.0f);
        this.f14159s = null;
        this.f14160t = true;
        this.f14161u = com.bumptech.glide.request.animation.g.d();
        this.f14162v = -1;
        this.f14163w = -1;
        this.f14164x = com.bumptech.glide.load.engine.c.RESULT;
        this.f14165y = com.bumptech.glide.load.resource.e.c();
        this.f14142b = context;
        this.f14141a = cls;
        this.f14144d = cls2;
        this.f14143c = lVar;
        this.f14145e = mVar;
        this.f14146f = gVar;
        this.f14147g = fVar != null ? new a1.a<>(fVar) : null;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        }
        if (cls != null && fVar == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }
}
