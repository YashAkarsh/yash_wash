package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import c.f1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q[] f18307a = new q[4];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f18308b = new Matrix[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f18309c = new Matrix[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f18310d = new PointF();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f18311e = new Path();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Path f18312f = new Path();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final q f18313g = new q();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float[] f18314h = new float[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f18315i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f18316j = new Path();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Path f18317k = new Path();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f18318l = true;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f18319a = new p();

        private a() {
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    public interface b {
        void a(q qVar, Matrix matrix, int i7);

        void b(q qVar, Matrix matrix, int i7);
    }

    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        public final o f18320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        public final Path f18321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        public final RectF f18322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @o0
        public final b f18323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f18324e;

        c(@m0 o oVar, float f8, RectF rectF, @o0 b bVar, Path path) {
            this.f18323d = bVar;
            this.f18320a = oVar;
            this.f18324e = f8;
            this.f18322c = rectF;
            this.f18321b = path;
        }
    }

    public p() {
        for (int i7 = 0; i7 < 4; i7++) {
            this.f18307a[i7] = new q();
            this.f18308b[i7] = new Matrix();
            this.f18309c[i7] = new Matrix();
        }
    }

    private float a(int i7) {
        return (i7 + 1) * 90;
    }

    private void b(@m0 c cVar, int i7) {
        this.f18314h[0] = this.f18307a[i7].l();
        this.f18314h[1] = this.f18307a[i7].m();
        this.f18308b[i7].mapPoints(this.f18314h);
        if (i7 == 0) {
            Path path = cVar.f18321b;
            float[] fArr = this.f18314h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f18321b;
            float[] fArr2 = this.f18314h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f18307a[i7].d(this.f18308b[i7], cVar.f18321b);
        b bVar = cVar.f18323d;
        if (bVar != null) {
            bVar.a(this.f18307a[i7], this.f18308b[i7], i7);
        }
    }

    private void c(@m0 c cVar, int i7) {
        int i8 = (i7 + 1) % 4;
        this.f18314h[0] = this.f18307a[i7].j();
        this.f18314h[1] = this.f18307a[i7].k();
        this.f18308b[i7].mapPoints(this.f18314h);
        this.f18315i[0] = this.f18307a[i8].l();
        this.f18315i[1] = this.f18307a[i8].m();
        this.f18308b[i8].mapPoints(this.f18315i);
        float[] fArr = this.f18314h;
        float f8 = fArr[0];
        float[] fArr2 = this.f18315i;
        float fMax = Math.max(((float) Math.hypot(f8 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float fI = i(cVar.f18322c, i7);
        this.f18313g.p(0.0f, 0.0f);
        g gVarJ = j(i7, cVar.f18320a);
        gVarJ.g(fMax, fI, cVar.f18324e, this.f18313g);
        this.f18316j.reset();
        this.f18313g.d(this.f18309c[i7], this.f18316j);
        if (this.f18318l && (gVarJ.e() || l(this.f18316j, i7) || l(this.f18316j, i8))) {
            Path path = this.f18316j;
            path.op(path, this.f18312f, Path.Op.DIFFERENCE);
            this.f18314h[0] = this.f18313g.l();
            this.f18314h[1] = this.f18313g.m();
            this.f18309c[i7].mapPoints(this.f18314h);
            Path path2 = this.f18311e;
            float[] fArr3 = this.f18314h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f18313g.d(this.f18309c[i7], this.f18311e);
        } else {
            this.f18313g.d(this.f18309c[i7], cVar.f18321b);
        }
        b bVar = cVar.f18323d;
        if (bVar != null) {
            bVar.b(this.f18313g, this.f18309c[i7], i7);
        }
    }

    private void f(int i7, @m0 RectF rectF, @m0 PointF pointF) {
        if (i7 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i7 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i7 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private d g(int i7, @m0 o oVar) {
        if (i7 == 1) {
            return oVar.l();
        }
        if (i7 != 2) {
            return i7 != 3 ? oVar.t() : oVar.r();
        }
        return oVar.j();
    }

    private e h(int i7, @m0 o oVar) {
        if (i7 == 1) {
            return oVar.k();
        }
        if (i7 != 2) {
            return i7 != 3 ? oVar.s() : oVar.q();
        }
        return oVar.i();
    }

    private float i(@m0 RectF rectF, int i7) {
        float[] fArr = this.f18314h;
        q qVar = this.f18307a[i7];
        fArr[0] = qVar.f18329c;
        fArr[1] = qVar.f18330d;
        this.f18308b[i7].mapPoints(fArr);
        return (i7 == 1 || i7 == 3) ? Math.abs(rectF.centerX() - this.f18314h[0]) : Math.abs(rectF.centerY() - this.f18314h[1]);
    }

    private g j(int i7, @m0 o oVar) {
        if (i7 == 1) {
            return oVar.h();
        }
        if (i7 != 2) {
            return i7 != 3 ? oVar.o() : oVar.p();
        }
        return oVar.n();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @f1
    @m0
    public static p k() {
        return a.f18319a;
    }

    @t0(19)
    private boolean l(Path path, int i7) {
        this.f18317k.reset();
        this.f18307a[i7].d(this.f18308b[i7], this.f18317k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f18317k.computeBounds(rectF, true);
        path.op(this.f18317k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(@m0 c cVar, int i7) {
        h(i7, cVar.f18320a).c(this.f18307a[i7], 90.0f, cVar.f18324e, cVar.f18322c, g(i7, cVar.f18320a));
        float fA = a(i7);
        this.f18308b[i7].reset();
        f(i7, cVar.f18322c, this.f18310d);
        Matrix matrix = this.f18308b[i7];
        PointF pointF = this.f18310d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f18308b[i7].preRotate(fA);
    }

    private void o(int i7) {
        this.f18314h[0] = this.f18307a[i7].j();
        this.f18314h[1] = this.f18307a[i7].k();
        this.f18308b[i7].mapPoints(this.f18314h);
        float fA = a(i7);
        this.f18309c[i7].reset();
        Matrix matrix = this.f18309c[i7];
        float[] fArr = this.f18314h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f18309c[i7].preRotate(fA);
    }

    public void d(o oVar, float f8, RectF rectF, @m0 Path path) {
        e(oVar, f8, rectF, null, path);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void e(o oVar, float f8, RectF rectF, b bVar, @m0 Path path) {
        path.rewind();
        this.f18311e.rewind();
        this.f18312f.rewind();
        this.f18312f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(oVar, f8, rectF, bVar, path);
        for (int i7 = 0; i7 < 4; i7++) {
            m(cVar, i7);
            o(i7);
        }
        for (int i8 = 0; i8 < 4; i8++) {
            b(cVar, i8);
            c(cVar, i8);
        }
        path.close();
        this.f18311e.close();
        if (this.f18311e.isEmpty()) {
            return;
        }
        path.op(this.f18311e, Path.Op.UNION);
    }

    void n(boolean z7) {
        this.f18318l = z7;
    }
}
