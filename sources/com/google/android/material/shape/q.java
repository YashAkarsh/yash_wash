package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import c.m0;
import c.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final float f18325j = 270.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static final float f18326k = 180.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f18327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f18328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f18329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f18330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f18331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f18332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<g> f18333g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<i> f18334h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f18335i;

    class a extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f18336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Matrix f18337c;

        a(List list, Matrix matrix) {
            this.f18336b = list;
            this.f18337c = matrix;
        }

        @Override // com.google.android.material.shape.q.i
        public void a(Matrix matrix, com.google.android.material.shadow.b bVar, int i7, Canvas canvas) {
            Iterator it = this.f18336b.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(this.f18337c, bVar, i7, canvas);
            }
        }
    }

    static class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f18339b;

        public b(d dVar) {
            this.f18339b = dVar;
        }

        @Override // com.google.android.material.shape.q.i
        public void a(Matrix matrix, @m0 com.google.android.material.shadow.b bVar, int i7, @m0 Canvas canvas) {
            bVar.a(canvas, matrix, new RectF(this.f18339b.k(), this.f18339b.o(), this.f18339b.l(), this.f18339b.j()), i7, this.f18339b.m(), this.f18339b.n());
        }
    }

    static class c extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f18340b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f18341c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f18342d;

        public c(f fVar, float f8, float f9) {
            this.f18340b = fVar;
            this.f18341c = f8;
            this.f18342d = f9;
        }

        @Override // com.google.android.material.shape.q.i
        public void a(Matrix matrix, @m0 com.google.android.material.shadow.b bVar, int i7, @m0 Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f18340b.f18357c - this.f18342d, this.f18340b.f18356b - this.f18341c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f18341c, this.f18342d);
            matrix2.preRotate(c());
            bVar.b(canvas, matrix2, rectF, i7);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f18340b.f18357c - this.f18342d) / (this.f18340b.f18356b - this.f18341c)));
        }
    }

    public static class d extends g {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final RectF f18343h = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f18344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f18345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f18346d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f18347e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f18348f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f18349g;

        public d(float f8, float f9, float f10, float f11) {
            q(f8);
            u(f9);
            r(f10);
            p(f11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f18347e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f18344b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f18346d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f18348f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f18349g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f18345c;
        }

        private void p(float f8) {
            this.f18347e = f8;
        }

        private void q(float f8) {
            this.f18344b = f8;
        }

        private void r(float f8) {
            this.f18346d = f8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f8) {
            this.f18348f = f8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f8) {
            this.f18349g = f8;
        }

        private void u(float f8) {
            this.f18345c = f8;
        }

        @Override // com.google.android.material.shape.q.g
        public void a(@m0 Matrix matrix, @m0 Path path) {
            Matrix matrix2 = this.f18358a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f18343h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f18350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f18351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f18352d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f18353e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f18354f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f18355g;

        public e(float f8, float f9, float f10, float f11, float f12, float f13) {
            h(f8);
            j(f9);
            i(f10);
            k(f11);
            l(f12);
            m(f13);
        }

        private float b() {
            return this.f18350b;
        }

        private float c() {
            return this.f18352d;
        }

        private float d() {
            return this.f18351c;
        }

        private float e() {
            return this.f18351c;
        }

        private float f() {
            return this.f18354f;
        }

        private float g() {
            return this.f18355g;
        }

        private void h(float f8) {
            this.f18350b = f8;
        }

        private void i(float f8) {
            this.f18352d = f8;
        }

        private void j(float f8) {
            this.f18351c = f8;
        }

        private void k(float f8) {
            this.f18353e = f8;
        }

        private void l(float f8) {
            this.f18354f = f8;
        }

        private void m(float f8) {
            this.f18355g = f8;
        }

        @Override // com.google.android.material.shape.q.g
        public void a(@m0 Matrix matrix, @m0 Path path) {
            Matrix matrix2 = this.f18358a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.f18350b, this.f18351c, this.f18352d, this.f18353e, this.f18354f, this.f18355g);
            path.transform(matrix);
        }
    }

    public static class f extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f18356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f18357c;

        @Override // com.google.android.material.shape.q.g
        public void a(@m0 Matrix matrix, @m0 Path path) {
            Matrix matrix2 = this.f18358a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f18356b, this.f18357c);
            path.transform(matrix);
        }
    }

    public static abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Matrix f18358a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static class h extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f18359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f18360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f18361d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f18362e;

        private float f() {
            return this.f18359b;
        }

        private float g() {
            return this.f18360c;
        }

        private float h() {
            return this.f18361d;
        }

        private float i() {
            return this.f18362e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(float f8) {
            this.f18359b = f8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(float f8) {
            this.f18360c = f8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(float f8) {
            this.f18361d = f8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(float f8) {
            this.f18362e = f8;
        }

        @Override // com.google.android.material.shape.q.g
        public void a(@m0 Matrix matrix, @m0 Path path) {
            Matrix matrix2 = this.f18358a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(f(), g(), h(), i());
            path.transform(matrix);
        }
    }

    static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Matrix f18363a = new Matrix();

        i() {
        }

        public abstract void a(Matrix matrix, com.google.android.material.shadow.b bVar, int i7, Canvas canvas);

        public final void b(com.google.android.material.shadow.b bVar, int i7, Canvas canvas) {
            a(f18363a, bVar, i7, canvas);
        }
    }

    public q() {
        p(0.0f, 0.0f);
    }

    private void b(float f8) {
        if (h() == f8) {
            return;
        }
        float fH = ((f8 - h()) + 360.0f) % 360.0f;
        if (fH > 180.0f) {
            return;
        }
        d dVar = new d(j(), k(), j(), k());
        dVar.s(h());
        dVar.t(fH);
        this.f18334h.add(new b(dVar));
        r(f8);
    }

    private void c(i iVar, float f8, float f9) {
        b(f8);
        this.f18334h.add(iVar);
        r(f9);
    }

    private float h() {
        return this.f18331e;
    }

    private float i() {
        return this.f18332f;
    }

    private void r(float f8) {
        this.f18331e = f8;
    }

    private void s(float f8) {
        this.f18332f = f8;
    }

    private void t(float f8) {
        this.f18329c = f8;
    }

    private void u(float f8) {
        this.f18330d = f8;
    }

    private void v(float f8) {
        this.f18327a = f8;
    }

    private void w(float f8) {
        this.f18328b = f8;
    }

    public void a(float f8, float f9, float f10, float f11, float f12, float f13) {
        d dVar = new d(f8, f9, f10, f11);
        dVar.s(f12);
        dVar.t(f13);
        this.f18333g.add(dVar);
        b bVar = new b(dVar);
        float f14 = f12 + f13;
        boolean z7 = f13 < 0.0f;
        if (z7) {
            f12 = (f12 + 180.0f) % 360.0f;
        }
        c(bVar, f12, z7 ? (180.0f + f14) % 360.0f : f14);
        double d8 = f14;
        t(((f8 + f10) * 0.5f) + (((f10 - f8) / 2.0f) * ((float) Math.cos(Math.toRadians(d8)))));
        u(((f9 + f11) * 0.5f) + (((f11 - f9) / 2.0f) * ((float) Math.sin(Math.toRadians(d8)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f18333g.size();
        for (int i7 = 0; i7 < size; i7++) {
            this.f18333g.get(i7).a(matrix, path);
        }
    }

    boolean e() {
        return this.f18335i;
    }

    @m0
    i f(Matrix matrix) {
        b(i());
        return new a(new ArrayList(this.f18334h), new Matrix(matrix));
    }

    @t0(21)
    public void g(float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f18333g.add(new e(f8, f9, f10, f11, f12, f13));
        this.f18335i = true;
        t(f12);
        u(f13);
    }

    float j() {
        return this.f18329c;
    }

    float k() {
        return this.f18330d;
    }

    float l() {
        return this.f18327a;
    }

    float m() {
        return this.f18328b;
    }

    public void n(float f8, float f9) {
        f fVar = new f();
        fVar.f18356b = f8;
        fVar.f18357c = f9;
        this.f18333g.add(fVar);
        c cVar = new c(fVar, j(), k());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        t(f8);
        u(f9);
    }

    @t0(21)
    public void o(float f8, float f9, float f10, float f11) {
        h hVar = new h();
        hVar.j(f8);
        hVar.k(f9);
        hVar.l(f10);
        hVar.m(f11);
        this.f18333g.add(hVar);
        this.f18335i = true;
        t(f10);
        u(f11);
    }

    public void p(float f8, float f9) {
        q(f8, f9, 270.0f, 0.0f);
    }

    public void q(float f8, float f9, float f10, float f11) {
        v(f8);
        w(f9);
        t(f8);
        u(f9);
        r(f10);
        s((f10 + f11) % 360.0f);
        this.f18333g.clear();
        this.f18334h.clear();
        this.f18335i = false;
    }

    public q(float f8, float f9) {
        p(f8, f9);
    }
}
