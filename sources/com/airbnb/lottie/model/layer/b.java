package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import c.o0;
import c.v;
import com.airbnb.lottie.animation.keyframe.p;
import com.airbnb.lottie.m;
import com.airbnb.lottie.value.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.airbnb.lottie.model.layer.a {

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Float, Float> B;
    private final List<com.airbnb.lottie.model.layer.a> C;
    private final RectF D;
    private final RectF E;
    private Paint F;

    @o0
    private Boolean G;

    @o0
    private Boolean H;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12122a;

        static {
            int[] iArr = new int[d.b.values().length];
            f12122a = iArr;
            try {
                iArr[d.b.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12122a[d.b.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.airbnb.lottie.h hVar, d dVar, List<d> list, com.airbnb.lottie.f fVar) {
        int i7;
        com.airbnb.lottie.model.layer.a aVar;
        super(hVar, dVar);
        this.C = new ArrayList();
        this.D = new RectF();
        this.E = new RectF();
        this.F = new Paint();
        com.airbnb.lottie.model.animatable.b bVarS = dVar.s();
        if (bVarS != null) {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA = bVarS.a();
            this.B = aVarA;
            j(aVarA);
            this.B.a(this);
        } else {
            this.B = null;
        }
        androidx.collection.f fVar2 = new androidx.collection.f(fVar.j().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            d dVar2 = list.get(size);
            com.airbnb.lottie.model.layer.a aVarV = com.airbnb.lottie.model.layer.a.v(dVar2, hVar, fVar);
            if (aVarV != null) {
                fVar2.s(aVarV.w().b(), aVarV);
                if (aVar2 != null) {
                    aVar2.F(aVarV);
                    aVar2 = null;
                } else {
                    this.C.add(0, aVarV);
                    int i8 = a.f12122a[dVar2.f().ordinal()];
                    if (i8 == 1 || i8 == 2) {
                        aVar2 = aVarV;
                    }
                }
            }
            size--;
        }
        for (i7 = 0; i7 < fVar2.B(); i7++) {
            com.airbnb.lottie.model.layer.a aVar3 = (com.airbnb.lottie.model.layer.a) fVar2.m(fVar2.r(i7));
            if (aVar3 != null && (aVar = (com.airbnb.lottie.model.layer.a) fVar2.m(aVar3.w().h())) != null) {
                aVar3.G(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void E(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        for (int i8 = 0; i8 < this.C.size(); i8++) {
            this.C.get(i8).c(eVar, i7, list, eVar2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void H(@v(from = 0.0d, to = 1.0d) float f8) {
        super.H(f8);
        if (this.B != null) {
            f8 = ((this.B.h().floatValue() * this.f12110o.a().h()) - this.f12110o.a().p()) / (this.f12109n.t().e() + 0.01f);
        }
        if (this.B == null) {
            f8 -= this.f12110o.p();
        }
        if (this.f12110o.t() != 0.0f) {
            f8 /= this.f12110o.t();
        }
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.C.get(size).H(f8);
        }
    }

    public boolean K() {
        if (this.H == null) {
            for (int size = this.C.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.layer.a aVar = this.C.get(size);
                if (aVar instanceof f) {
                    if (aVar.x()) {
                        this.H = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).K()) {
                    this.H = Boolean.TRUE;
                    return true;
                }
            }
            this.H = Boolean.FALSE;
        }
        return this.H.booleanValue();
    }

    public boolean L() {
        if (this.G == null) {
            if (y()) {
                this.G = Boolean.TRUE;
                return true;
            }
            for (int size = this.C.size() - 1; size >= 0; size--) {
                if (this.C.get(size).y()) {
                    this.G = Boolean.TRUE;
                    return true;
                }
            }
            this.G = Boolean.FALSE;
        }
        return this.G.booleanValue();
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        super.d(rectF, matrix, z7);
        for (int size = this.C.size() - 1; size >= 0; size--) {
            this.D.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.C.get(size).d(this.D, this.f12108m, true);
            rectF.union(this.D);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 j<T> jVar) {
        super.h(t7, jVar);
        if (t7 == m.A) {
            if (jVar == null) {
                com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar = this.B;
                if (aVar != null) {
                    aVar.m(null);
                    return;
                }
                return;
            }
            p pVar = new p(jVar);
            this.B = pVar;
            pVar.a(this);
            j(this.B);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(Canvas canvas, Matrix matrix, int i7) {
        com.airbnb.lottie.e.a("CompositionLayer#draw");
        this.E.set(0.0f, 0.0f, this.f12110o.j(), this.f12110o.i());
        matrix.mapRect(this.E);
        boolean z7 = this.f12109n.O() && this.C.size() > 1 && i7 != 255;
        if (z7) {
            this.F.setAlpha(i7);
            com.airbnb.lottie.utils.j.n(canvas, this.E, this.F);
        } else {
            canvas.save();
        }
        if (z7) {
            i7 = 255;
        }
        for (int size = this.C.size() - 1; size >= 0; size--) {
            if (!this.E.isEmpty() ? canvas.clipRect(this.E) : true) {
                this.C.get(size).f(canvas, matrix, i7);
            }
        }
        canvas.restore();
        com.airbnb.lottie.e.b("CompositionLayer#draw");
    }
}
