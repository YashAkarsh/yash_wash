package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import c.o0;
import com.airbnb.lottie.animation.keyframe.n;
import com.airbnb.lottie.animation.keyframe.p;
import com.airbnb.lottie.m;
import com.airbnb.lottie.model.animatable.k;
import com.airbnb.lottie.u;
import com.airbnb.lottie.utils.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.airbnb.lottie.model.layer.a {
    private final StringBuilder B;
    private final RectF C;
    private final Matrix D;
    private final Paint E;
    private final Paint F;
    private final Map<com.airbnb.lottie.model.d, List<com.airbnb.lottie.animation.content.d>> G;
    private final androidx.collection.f<String> H;
    private final n I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final com.airbnb.lottie.h f12158J;
    private final com.airbnb.lottie.f K;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Integer, Integer> L;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Integer, Integer> M;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Integer, Integer> N;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Integer, Integer> O;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Float, Float> P;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Float, Float> Q;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Float, Float> R;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Float, Float> S;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Float, Float> T;

    @o0
    private com.airbnb.lottie.animation.keyframe.a<Float, Float> U;

    class a extends Paint {
        a(int i7) {
            super(i7);
            setStyle(Paint.Style.FILL);
        }
    }

    class b extends Paint {
        b(int i7) {
            super(i7);
            setStyle(Paint.Style.STROKE);
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12161a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.b.a.values().length];
            f12161a = iArr;
            try {
                iArr[com.airbnb.lottie.model.b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12161a[com.airbnb.lottie.model.b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12161a[com.airbnb.lottie.model.b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    h(com.airbnb.lottie.h hVar, d dVar) {
        com.airbnb.lottie.model.animatable.b bVar;
        com.airbnb.lottie.model.animatable.b bVar2;
        com.airbnb.lottie.model.animatable.a aVar;
        com.airbnb.lottie.model.animatable.a aVar2;
        super(hVar, dVar);
        this.B = new StringBuilder(2);
        this.C = new RectF();
        this.D = new Matrix();
        this.E = new a(1);
        this.F = new b(1);
        this.G = new HashMap();
        this.H = new androidx.collection.f<>();
        this.f12158J = hVar;
        this.K = dVar.a();
        n nVarA = dVar.q().a();
        this.I = nVarA;
        nVarA.a(this);
        j(nVarA);
        k kVarR = dVar.r();
        if (kVarR != null && (aVar2 = kVarR.f11924a) != null) {
            com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVarA = aVar2.a();
            this.L = aVarA;
            aVarA.a(this);
            j(this.L);
        }
        if (kVarR != null && (aVar = kVarR.f11925b) != null) {
            com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVarA2 = aVar.a();
            this.N = aVarA2;
            aVarA2.a(this);
            j(this.N);
        }
        if (kVarR != null && (bVar2 = kVarR.f11926c) != null) {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA3 = bVar2.a();
            this.P = aVarA3;
            aVarA3.a(this);
            j(this.P);
        }
        if (kVarR == null || (bVar = kVarR.f11927d) == null) {
            return;
        }
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVarA4 = bVar.a();
        this.R = aVarA4;
        aVarA4.a(this);
        j(this.R);
    }

    private void K(com.airbnb.lottie.model.b.a aVar, Canvas canvas, float f8) {
        int i7 = c.f12161a[aVar.ordinal()];
        if (i7 == 2) {
            canvas.translate(-f8, 0.0f);
        } else {
            if (i7 != 3) {
                return;
            }
            canvas.translate((-f8) / 2.0f, 0.0f);
        }
    }

    private String L(String str, int i7) {
        int iCodePointAt = str.codePointAt(i7);
        int iCharCount = Character.charCount(iCodePointAt) + i7;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!X(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j7 = iCodePointAt;
        if (this.H.i(j7)) {
            return this.H.m(j7);
        }
        this.B.setLength(0);
        while (i7 < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i7);
            this.B.appendCodePoint(iCodePointAt3);
            i7 += Character.charCount(iCodePointAt3);
        }
        String string = this.B.toString();
        this.H.s(j7, string);
        return string;
    }

    private void M(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void N(com.airbnb.lottie.model.d dVar, Matrix matrix, float f8, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        List<com.airbnb.lottie.animation.content.d> listU = U(dVar);
        for (int i7 = 0; i7 < listU.size(); i7++) {
            Path pathG = listU.get(i7).g();
            pathG.computeBounds(this.C, false);
            this.D.set(matrix);
            this.D.preTranslate(0.0f, (-bVar.f11944g) * j.e());
            this.D.preScale(f8, f8);
            pathG.transform(this.D);
            if (bVar.f11948k) {
                Q(pathG, this.E, canvas);
                Q(pathG, this.F, canvas);
            } else {
                Q(pathG, this.F, canvas);
                Q(pathG, this.E, canvas);
            }
        }
    }

    private void O(String str, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        if (bVar.f11948k) {
            M(str, this.E, canvas);
            M(str, this.F, canvas);
        } else {
            M(str, this.F, canvas);
            M(str, this.E, canvas);
        }
    }

    private void P(String str, com.airbnb.lottie.model.b bVar, Canvas canvas, float f8) {
        float fFloatValue;
        int length = 0;
        while (length < str.length()) {
            String strL = L(str, length);
            length += strL.length();
            O(strL, bVar, canvas);
            float fMeasureText = this.E.measureText(strL, 0, 1);
            float f9 = bVar.f11942e / 10.0f;
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar = this.S;
            if (aVar != null) {
                fFloatValue = aVar.h().floatValue();
            } else {
                com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar2 = this.R;
                if (aVar2 != null) {
                    fFloatValue = aVar2.h().floatValue();
                }
                canvas.translate(fMeasureText + (f9 * f8), 0.0f);
            }
            f9 += fFloatValue;
            canvas.translate(fMeasureText + (f9 * f8), 0.0f);
        }
    }

    private void Q(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void R(String str, com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas, float f8, float f9) {
        float fFloatValue;
        for (int i7 = 0; i7 < str.length(); i7++) {
            com.airbnb.lottie.model.d dVarM = this.K.c().m(com.airbnb.lottie.model.d.e(str.charAt(i7), cVar.b(), cVar.d()));
            if (dVarM != null) {
                N(dVarM, matrix, f9, bVar, canvas);
                float fD = ((float) dVarM.d()) * f9 * j.e() * f8;
                float f10 = bVar.f11942e / 10.0f;
                com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar = this.S;
                if (aVar != null) {
                    fFloatValue = aVar.h().floatValue();
                } else {
                    com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar2 = this.R;
                    if (aVar2 != null) {
                        fFloatValue = aVar2.h().floatValue();
                    }
                    canvas.translate(fD + (f10 * f8), 0.0f);
                }
                f10 += fFloatValue;
                canvas.translate(fD + (f10 * f8), 0.0f);
            }
        }
    }

    private void S(com.airbnb.lottie.model.b bVar, Matrix matrix, com.airbnb.lottie.model.c cVar, Canvas canvas) {
        float fFloatValue;
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar = this.U;
        if (aVar != null) {
            fFloatValue = aVar.h().floatValue();
        } else {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar2 = this.T;
            fFloatValue = aVar2 != null ? aVar2.h().floatValue() : bVar.f11940c;
        }
        float f8 = fFloatValue / 100.0f;
        float fG = j.g(matrix);
        String str = bVar.f11938a;
        float fE = bVar.f11943f * j.e();
        List<String> listW = W(str);
        int size = listW.size();
        for (int i7 = 0; i7 < size; i7++) {
            String str2 = listW.get(i7);
            float fV = V(str2, cVar, f8, fG);
            canvas.save();
            K(bVar.f11941d, canvas, fV);
            canvas.translate(0.0f, (i7 * fE) - (((size - 1) * fE) / 2.0f));
            R(str2, bVar, matrix, cVar, canvas, fG, f8);
            canvas.restore();
        }
    }

    private void T(com.airbnb.lottie.model.b bVar, com.airbnb.lottie.model.c cVar, Matrix matrix, Canvas canvas) {
        float fFloatValue;
        float fG = j.g(matrix);
        Typeface typefaceK = this.f12158J.K(cVar.b(), cVar.d());
        if (typefaceK == null) {
            return;
        }
        String strB = bVar.f11938a;
        u uVarJ = this.f12158J.J();
        if (uVarJ != null) {
            strB = uVarJ.b(strB);
        }
        this.E.setTypeface(typefaceK);
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar = this.U;
        if (aVar != null) {
            fFloatValue = aVar.h().floatValue();
        } else {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar2 = this.T;
            fFloatValue = aVar2 != null ? aVar2.h().floatValue() : bVar.f11940c;
        }
        this.E.setTextSize(fFloatValue * j.e());
        this.F.setTypeface(this.E.getTypeface());
        this.F.setTextSize(this.E.getTextSize());
        float fE = bVar.f11943f * j.e();
        List<String> listW = W(strB);
        int size = listW.size();
        for (int i7 = 0; i7 < size; i7++) {
            String str = listW.get(i7);
            K(bVar.f11941d, canvas, this.F.measureText(str));
            canvas.translate(0.0f, (i7 * fE) - (((size - 1) * fE) / 2.0f));
            P(str, bVar, canvas, fG);
            canvas.setMatrix(matrix);
        }
    }

    private List<com.airbnb.lottie.animation.content.d> U(com.airbnb.lottie.model.d dVar) {
        if (this.G.containsKey(dVar)) {
            return this.G.get(dVar);
        }
        List<com.airbnb.lottie.model.content.n> listA = dVar.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(new com.airbnb.lottie.animation.content.d(this.f12158J, this, listA.get(i7)));
        }
        this.G.put(dVar, arrayList);
        return arrayList;
    }

    private float V(String str, com.airbnb.lottie.model.c cVar, float f8, float f9) {
        float fD = 0.0f;
        for (int i7 = 0; i7 < str.length(); i7++) {
            com.airbnb.lottie.model.d dVarM = this.K.c().m(com.airbnb.lottie.model.d.e(str.charAt(i7), cVar.b(), cVar.d()));
            if (dVarM != null) {
                fD = (float) (((double) fD) + (dVarM.d() * ((double) f8) * ((double) j.e()) * ((double) f9)));
            }
        }
        return fD;
    }

    private List<String> W(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean X(int i7) {
        return Character.getType(i7) == 16 || Character.getType(i7) == 27 || Character.getType(i7) == 6 || Character.getType(i7) == 28 || Character.getType(i7) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.animation.content.e
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        super.d(rectF, matrix, z7);
        rectF.set(0.0f, 0.0f, this.K.b().width(), this.K.b().height());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.f
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        super.h(t7, jVar);
        if (t7 == m.f11881a) {
            com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar = this.M;
            if (aVar != null) {
                D(aVar);
            }
            if (jVar == null) {
                this.M = null;
                return;
            }
            p pVar = new p(jVar);
            this.M = pVar;
            pVar.a(this);
            j(this.M);
            return;
        }
        if (t7 == m.f11882b) {
            com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2 = this.O;
            if (aVar2 != null) {
                D(aVar2);
            }
            if (jVar == null) {
                this.O = null;
                return;
            }
            p pVar2 = new p(jVar);
            this.O = pVar2;
            pVar2.a(this);
            j(this.O);
            return;
        }
        if (t7 == m.f11895o) {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar3 = this.Q;
            if (aVar3 != null) {
                D(aVar3);
            }
            if (jVar == null) {
                this.Q = null;
                return;
            }
            p pVar3 = new p(jVar);
            this.Q = pVar3;
            pVar3.a(this);
            j(this.Q);
            return;
        }
        if (t7 == m.f11896p) {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar4 = this.S;
            if (aVar4 != null) {
                D(aVar4);
            }
            if (jVar == null) {
                this.S = null;
                return;
            }
            p pVar4 = new p(jVar);
            this.S = pVar4;
            pVar4.a(this);
            j(this.S);
            return;
        }
        if (t7 == m.B) {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar5 = this.U;
            if (aVar5 != null) {
                D(aVar5);
            }
            if (jVar == null) {
                this.U = null;
                return;
            }
            p pVar5 = new p(jVar);
            this.U = pVar5;
            pVar5.a(this);
            j(this.U);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(Canvas canvas, Matrix matrix, int i7) {
        canvas.save();
        if (!this.f12158J.D0()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.model.b bVarH = this.I.h();
        com.airbnb.lottie.model.c cVar = this.K.g().get(bVarH.f11939b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar = this.M;
        if (aVar != null) {
            this.E.setColor(aVar.h().intValue());
        } else {
            com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2 = this.L;
            if (aVar2 != null) {
                this.E.setColor(aVar2.h().intValue());
            } else {
                this.E.setColor(bVarH.f11945h);
            }
        }
        com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar3 = this.O;
        if (aVar3 != null) {
            this.F.setColor(aVar3.h().intValue());
        } else {
            com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar4 = this.N;
            if (aVar4 != null) {
                this.F.setColor(aVar4.h().intValue());
            } else {
                this.F.setColor(bVarH.f11946i);
            }
        }
        int iIntValue = ((this.f12117v.h() == null ? 100 : this.f12117v.h().h().intValue()) * 255) / 100;
        this.E.setAlpha(iIntValue);
        this.F.setAlpha(iIntValue);
        com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar5 = this.Q;
        if (aVar5 != null) {
            this.F.setStrokeWidth(aVar5.h().floatValue());
        } else {
            com.airbnb.lottie.animation.keyframe.a<Float, Float> aVar6 = this.P;
            if (aVar6 != null) {
                this.F.setStrokeWidth(aVar6.h().floatValue());
            } else {
                this.F.setStrokeWidth(bVarH.f11947j * j.e() * j.g(matrix));
            }
        }
        if (this.f12158J.D0()) {
            S(bVarH, matrix, cVar, canvas);
        } else {
            T(bVarH, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
