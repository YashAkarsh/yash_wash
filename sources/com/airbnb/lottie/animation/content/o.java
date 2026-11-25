package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import c.o0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o implements n, com.airbnb.lottie.animation.keyframe.a.b, k {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f11658o = 0.47829f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float f11659p = 0.25f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.h f11662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.i.a f11663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f11664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, PointF> f11666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.airbnb.lottie.animation.keyframe.a<?, Float> f11671l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f11673n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f11660a = new Path();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f11672m = new b();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11674a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.content.i.a.values().length];
            f11674a = iArr;
            try {
                iArr[com.airbnb.lottie.model.content.i.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11674a[com.airbnb.lottie.model.content.i.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public o(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.i iVar) {
        this.f11662c = hVar;
        this.f11661b = iVar.d();
        com.airbnb.lottie.model.content.i.a aVarJ = iVar.j();
        this.f11663d = aVarJ;
        this.f11664e = iVar.k();
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA = iVar.g().a();
        this.f11665f = aVarA;
        com.airbnb.lottie.animation.keyframe.a<PointF, PointF> aVarA2 = iVar.h().a();
        this.f11666g = aVarA2;
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA3 = iVar.i().a();
        this.f11667h = aVarA3;
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA4 = iVar.e().a();
        this.f11669j = aVarA4;
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA5 = iVar.f().a();
        this.f11671l = aVarA5;
        com.airbnb.lottie.model.content.i.a aVar2 = com.airbnb.lottie.model.content.i.a.STAR;
        if (aVarJ == aVar2) {
            this.f11668i = iVar.b().a();
            this.f11670k = iVar.c().a();
        } else {
            this.f11668i = null;
            this.f11670k = null;
        }
        aVar.j(aVarA);
        aVar.j(aVarA2);
        aVar.j(aVarA3);
        aVar.j(aVarA4);
        aVar.j(aVarA5);
        if (aVarJ == aVar2) {
            aVar.j(this.f11668i);
            aVar.j(this.f11670k);
        }
        aVarA.a(this);
        aVarA2.a(this);
        aVarA3.a(this);
        aVarA4.a(this);
        aVarA5.a(this);
        if (aVarJ == aVar2) {
            this.f11668i.a(this);
            this.f11670k.a(this);
        }
    }

    private void e() {
        int iFloor = (int) Math.floor(this.f11665f.h().floatValue());
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar = this.f11667h;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d8 = iFloor;
        float fFloatValue = this.f11671l.h().floatValue() / 100.0f;
        float fFloatValue2 = this.f11669j.h().floatValue();
        double d9 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d9);
        float fSin = (float) (Math.sin(radians) * d9);
        this.f11660a.moveTo(fCos, fSin);
        double d10 = (float) (6.283185307179586d / d8);
        double d11 = radians + d10;
        double dCeil = Math.ceil(d8);
        int i7 = 0;
        while (i7 < dCeil) {
            float fCos2 = (float) (Math.cos(d11) * d9);
            double d12 = dCeil;
            float fSin2 = (float) (d9 * Math.sin(d11));
            if (fFloatValue != 0.0f) {
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                double dAtan3 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan3);
                float fSin4 = (float) Math.sin(dAtan3);
                float f8 = fFloatValue2 * fFloatValue * f11659p;
                this.f11660a.cubicTo(fCos - (fCos3 * f8), fSin - (fSin3 * f8), fCos2 + (fCos4 * f8), fSin2 + (f8 * fSin4), fCos2, fSin2);
            } else {
                this.f11660a.lineTo(fCos2, fSin2);
            }
            d11 += d10;
            i7++;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d12;
            d9 = d9;
            d10 = d10;
        }
        PointF pointFH = this.f11666g.h();
        this.f11660a.offset(pointFH.x, pointFH.y);
        this.f11660a.close();
    }

    private void i() {
        float f8;
        float f9;
        double d8;
        float fSin;
        float f10;
        float f11;
        float f12;
        float fFloatValue = this.f11665f.h().floatValue();
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar = this.f11667h;
        double radians = Math.toRadians((aVar == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d9 = fFloatValue;
        float f13 = (float) (6.283185307179586d / d9);
        float f14 = f13 / 2.0f;
        float f15 = fFloatValue - ((int) fFloatValue);
        if (f15 != 0.0f) {
            radians += (double) ((1.0f - f15) * f14);
        }
        float fFloatValue2 = this.f11669j.h().floatValue();
        float fFloatValue3 = this.f11668i.h().floatValue();
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar2 = this.f11670k;
        float fFloatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar3 = this.f11671l;
        float fFloatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (f15 != 0.0f) {
            f10 = ((fFloatValue2 - fFloatValue3) * f15) + fFloatValue3;
            double d10 = f10;
            float fCos = (float) (d10 * Math.cos(radians));
            fSin = (float) (d10 * Math.sin(radians));
            this.f11660a.moveTo(fCos, fSin);
            d8 = radians + ((double) ((f13 * f15) / 2.0f));
            f8 = fCos;
            f9 = f14;
        } else {
            double d11 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d11);
            float fSin2 = (float) (d11 * Math.sin(radians));
            this.f11660a.moveTo(fCos2, fSin2);
            f8 = fCos2;
            f9 = f14;
            d8 = radians + ((double) f9);
            fSin = fSin2;
            f10 = 0.0f;
        }
        double dCeil = Math.ceil(d9) * 2.0d;
        int i7 = 0;
        float f16 = f9;
        float f17 = f8;
        boolean z7 = false;
        while (true) {
            double d12 = i7;
            if (d12 >= dCeil) {
                PointF pointFH = this.f11666g.h();
                this.f11660a.offset(pointFH.x, pointFH.y);
                this.f11660a.close();
                return;
            }
            float f18 = z7 ? fFloatValue2 : fFloatValue3;
            float f19 = (f10 == 0.0f || d12 != dCeil - 2.0d) ? f16 : (f13 * f15) / 2.0f;
            if (f10 == 0.0f || d12 != dCeil - 1.0d) {
                f10 = f18;
            }
            double d13 = f10;
            double d14 = dCeil;
            float fCos3 = (float) (d13 * Math.cos(d8));
            float fSin3 = (float) (d13 * Math.sin(d8));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.f11660a.lineTo(fCos3, fSin3);
                f11 = fFloatValue4;
                f12 = fFloatValue5;
            } else {
                f11 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f17) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f12 = fFloatValue5;
                double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan3);
                float fSin5 = (float) Math.sin(dAtan3);
                float f20 = z7 ? f11 : f12;
                float f21 = z7 ? f12 : f11;
                float f22 = z7 ? fFloatValue3 : fFloatValue2;
                float f23 = z7 ? fFloatValue2 : fFloatValue3;
                float f24 = f22 * f20 * f11658o;
                float f25 = fCos4 * f24;
                float f26 = f24 * fSin4;
                float f27 = f23 * f21 * f11658o;
                float f28 = fCos5 * f27;
                float f29 = f27 * fSin5;
                if (f15 != 0.0f) {
                    if (i7 == 0) {
                        f25 *= f15;
                        f26 *= f15;
                    } else if (d12 == d14 - 1.0d) {
                        f28 *= f15;
                        f29 *= f15;
                    }
                }
                this.f11660a.cubicTo(f17 - f25, fSin - f26, fCos3 + f28, fSin3 + f29, fCos3, fSin3);
            }
            d8 += (double) f19;
            z7 = !z7;
            i7++;
            f17 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f12;
            fFloatValue4 = f11;
            f10 = f10;
            f13 = f13;
            dCeil = d14;
        }
    }

    private void j() {
        this.f11673n = false;
        this.f11662c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        j();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        for (int i7 = 0; i7 < list.size(); i7++) {
            c cVar = list.get(i7);
            if (cVar instanceof t) {
                t tVar = (t) cVar;
                if (tVar.j() == com.airbnb.lottie.model.content.q.a.SIMULTANEOUSLY) {
                    this.f11672m.a(tVar);
                    tVar.c(this);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        com.airbnb.lottie.utils.i.l(eVar, i7, list, eVar2, this);
    }

    @Override // com.airbnb.lottie.animation.content.n
    public Path g() {
        if (this.f11673n) {
            return this.f11660a;
        }
        this.f11660a.reset();
        if (this.f11664e) {
            this.f11673n = true;
            return this.f11660a;
        }
        int i7 = a.f11674a[this.f11663d.ordinal()];
        if (i7 == 1) {
            i();
        } else if (i7 == 2) {
            e();
        }
        this.f11660a.close();
        this.f11672m.b(this.f11660a);
        this.f11673n = true;
        return this.f11660a;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11661b;
    }

    @Override // com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar;
        com.airbnb.lottie.animation.keyframe.a<?, Float> aVar2;
        if (t7 == com.airbnb.lottie.m.f11899s) {
            this.f11665f.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11900t) {
            this.f11667h.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11890j) {
            this.f11666g.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11901u && (aVar2 = this.f11668i) != null) {
            aVar2.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11902v) {
            this.f11669j.m(jVar);
            return;
        }
        if (t7 == com.airbnb.lottie.m.f11903w && (aVar = this.f11670k) != null) {
            aVar.m(jVar);
        } else if (t7 == com.airbnb.lottie.m.f11904x) {
            this.f11671l.m(jVar);
        }
    }
}
