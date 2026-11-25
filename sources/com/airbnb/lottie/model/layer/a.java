package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.core.view.n2;
import c.o0;
import c.v;
import com.airbnb.lottie.animation.keyframe.o;
import com.airbnb.lottie.model.content.l;
import com.airbnb.lottie.utils.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements com.airbnb.lottie.animation.content.e, com.airbnb.lottie.animation.keyframe.a.b, com.airbnb.lottie.model.f {
    private static final int A = 19;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f12093x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f12094y = 16;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f12095z = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f12096a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix f12097b = new Matrix();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f12098c = new com.airbnb.lottie.animation.a(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Paint f12099d = new com.airbnb.lottie.animation.a(1, PorterDuff.Mode.DST_IN);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Paint f12100e = new com.airbnb.lottie.animation.a(1, PorterDuff.Mode.DST_OUT);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f12101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f12102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final RectF f12103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RectF f12104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final RectF f12105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RectF f12106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f12107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final Matrix f12108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final com.airbnb.lottie.h f12109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final d f12110o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.g f12111p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.animation.keyframe.c f12112q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @o0
    private a f12113r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @o0
    private a f12114s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<a> f12115t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final List<com.airbnb.lottie.animation.keyframe.a<?, ?>> f12116u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final o f12117v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f12118w;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    class C0144a implements com.airbnb.lottie.animation.keyframe.a.b {
        C0144a() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.b
        public void a() {
            a aVar = a.this;
            aVar.I(aVar.f12112q.o() == 1.0f);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12121b;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.content.g.a.values().length];
            f12121b = iArr;
            try {
                iArr[com.airbnb.lottie.model.content.g.a.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12121b[com.airbnb.lottie.model.content.g.a.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12121b[com.airbnb.lottie.model.content.g.a.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12121b[com.airbnb.lottie.model.content.g.a.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[d.a.values().length];
            f12120a = iArr2;
            try {
                iArr2[d.a.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12120a[d.a.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12120a[d.a.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12120a[d.a.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12120a[d.a.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f12120a[d.a.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f12120a[d.a.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    a(com.airbnb.lottie.h hVar, d dVar) {
        com.airbnb.lottie.animation.a aVar = new com.airbnb.lottie.animation.a(1);
        this.f12101f = aVar;
        this.f12102g = new com.airbnb.lottie.animation.a(PorterDuff.Mode.CLEAR);
        this.f12103h = new RectF();
        this.f12104i = new RectF();
        this.f12105j = new RectF();
        this.f12106k = new RectF();
        this.f12108m = new Matrix();
        this.f12116u = new ArrayList();
        this.f12118w = true;
        this.f12109n = hVar;
        this.f12110o = dVar;
        this.f12107l = dVar.g() + "#draw";
        if (dVar.f() == d.b.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o oVarB = dVar.u().b();
        this.f12117v = oVarB;
        oVarB.b(this);
        if (dVar.e() != null && !dVar.e().isEmpty()) {
            com.airbnb.lottie.animation.keyframe.g gVar = new com.airbnb.lottie.animation.keyframe.g(dVar.e());
            this.f12111p = gVar;
            Iterator<com.airbnb.lottie.animation.keyframe.a<l, Path>> it = gVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2 : this.f12111p.c()) {
                j(aVar2);
                aVar2.a(this);
            }
        }
        J();
    }

    private void A(RectF rectF, Matrix matrix) {
        if (y() && this.f12110o.f() != d.b.INVERT) {
            this.f12105j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f12113r.d(this.f12105j, matrix, true);
            if (rectF.intersect(this.f12105j)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void B() {
        this.f12109n.invalidateSelf();
    }

    private void C(float f8) {
        this.f12109n.t().n().e(this.f12110o.g(), f8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(boolean z7) {
        if (z7 != this.f12118w) {
            this.f12118w = z7;
            B();
        }
    }

    private void J() {
        if (this.f12110o.c().isEmpty()) {
            I(true);
            return;
        }
        com.airbnb.lottie.animation.keyframe.c cVar = new com.airbnb.lottie.animation.keyframe.c(this.f12110o.c());
        this.f12112q = cVar;
        cVar.k();
        this.f12112q.a(new C0144a());
        I(this.f12112q.h().floatValue() == 1.0f);
        j(this.f12112q);
    }

    private void k(Canvas canvas, Matrix matrix, com.airbnb.lottie.model.content.g gVar, com.airbnb.lottie.animation.keyframe.a<l, Path> aVar, com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2) {
        this.f12096a.set(aVar.h());
        this.f12096a.transform(matrix);
        this.f12098c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f12096a, this.f12098c);
    }

    private void l(Canvas canvas, Matrix matrix, com.airbnb.lottie.model.content.g gVar, com.airbnb.lottie.animation.keyframe.a<l, Path> aVar, com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2) {
        j.n(canvas, this.f12103h, this.f12099d);
        this.f12096a.set(aVar.h());
        this.f12096a.transform(matrix);
        this.f12098c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f12096a, this.f12098c);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, com.airbnb.lottie.model.content.g gVar, com.airbnb.lottie.animation.keyframe.a<l, Path> aVar, com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2) {
        j.n(canvas, this.f12103h, this.f12098c);
        canvas.drawRect(this.f12103h, this.f12098c);
        this.f12096a.set(aVar.h());
        this.f12096a.transform(matrix);
        this.f12098c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f12096a, this.f12100e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, com.airbnb.lottie.model.content.g gVar, com.airbnb.lottie.animation.keyframe.a<l, Path> aVar, com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2) {
        j.n(canvas, this.f12103h, this.f12099d);
        canvas.drawRect(this.f12103h, this.f12098c);
        this.f12100e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f12096a.set(aVar.h());
        this.f12096a.transform(matrix);
        canvas.drawPath(this.f12096a, this.f12100e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix, com.airbnb.lottie.model.content.g gVar, com.airbnb.lottie.animation.keyframe.a<l, Path> aVar, com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2) {
        j.n(canvas, this.f12103h, this.f12100e);
        canvas.drawRect(this.f12103h, this.f12098c);
        this.f12100e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f12096a.set(aVar.h());
        this.f12096a.transform(matrix);
        canvas.drawPath(this.f12096a, this.f12100e);
        canvas.restore();
    }

    private void p(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.e.a("Layer#saveLayer");
        j.o(canvas, this.f12103h, this.f12099d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            t(canvas);
        }
        com.airbnb.lottie.e.b("Layer#saveLayer");
        for (int i7 = 0; i7 < this.f12111p.b().size(); i7++) {
            com.airbnb.lottie.model.content.g gVar = this.f12111p.b().get(i7);
            com.airbnb.lottie.animation.keyframe.a<l, Path> aVar = this.f12111p.a().get(i7);
            com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2 = this.f12111p.c().get(i7);
            int i8 = b.f12121b[gVar.a().ordinal()];
            if (i8 != 1) {
                if (i8 == 2) {
                    if (i7 == 0) {
                        this.f12098c.setColor(n2.f6743t);
                        this.f12098c.setAlpha(255);
                        canvas.drawRect(this.f12103h, this.f12098c);
                    }
                    if (gVar.d()) {
                        o(canvas, matrix, gVar, aVar, aVar2);
                    } else {
                        q(canvas, matrix, gVar, aVar, aVar2);
                    }
                } else if (i8 != 3) {
                    if (i8 == 4) {
                        if (gVar.d()) {
                            m(canvas, matrix, gVar, aVar, aVar2);
                        } else {
                            k(canvas, matrix, gVar, aVar, aVar2);
                        }
                    }
                } else if (gVar.d()) {
                    n(canvas, matrix, gVar, aVar, aVar2);
                } else {
                    l(canvas, matrix, gVar, aVar, aVar2);
                }
            } else if (r()) {
                this.f12098c.setAlpha(255);
                canvas.drawRect(this.f12103h, this.f12098c);
            }
        }
        com.airbnb.lottie.e.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.e.b("Layer#restoreLayer");
    }

    private void q(Canvas canvas, Matrix matrix, com.airbnb.lottie.model.content.g gVar, com.airbnb.lottie.animation.keyframe.a<l, Path> aVar, com.airbnb.lottie.animation.keyframe.a<Integer, Integer> aVar2) {
        this.f12096a.set(aVar.h());
        this.f12096a.transform(matrix);
        canvas.drawPath(this.f12096a, this.f12100e);
    }

    private boolean r() {
        if (this.f12111p.a().isEmpty()) {
            return false;
        }
        for (int i7 = 0; i7 < this.f12111p.b().size(); i7++) {
            if (this.f12111p.b().get(i7).a() != com.airbnb.lottie.model.content.g.a.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.f12115t != null) {
            return;
        }
        if (this.f12114s == null) {
            this.f12115t = Collections.emptyList();
            return;
        }
        this.f12115t = new ArrayList();
        for (a aVar = this.f12114s; aVar != null; aVar = aVar.f12114s) {
            this.f12115t.add(aVar);
        }
    }

    private void t(Canvas canvas) {
        com.airbnb.lottie.e.a("Layer#clearLayer");
        RectF rectF = this.f12103h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f12102g);
        com.airbnb.lottie.e.b("Layer#clearLayer");
    }

    @o0
    static a v(d dVar, com.airbnb.lottie.h hVar, com.airbnb.lottie.f fVar) {
        switch (b.f12120a[dVar.d().ordinal()]) {
            case 1:
                return new f(hVar, dVar);
            case 2:
                return new com.airbnb.lottie.model.layer.b(hVar, dVar, fVar.o(dVar.k()), fVar);
            case 3:
                return new g(hVar, dVar);
            case 4:
                return new c(hVar, dVar);
            case 5:
                return new e(hVar, dVar);
            case 6:
                return new h(hVar, dVar);
            default:
                com.airbnb.lottie.utils.f.e("Unknown layer type " + dVar.d());
                return null;
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        this.f12104i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (x()) {
            int size = this.f12111p.b().size();
            for (int i7 = 0; i7 < size; i7++) {
                com.airbnb.lottie.model.content.g gVar = this.f12111p.b().get(i7);
                this.f12096a.set(this.f12111p.a().get(i7).h());
                this.f12096a.transform(matrix);
                int i8 = b.f12121b[gVar.a().ordinal()];
                if (i8 == 1 || i8 == 2) {
                    return;
                }
                if ((i8 == 3 || i8 == 4) && gVar.d()) {
                    return;
                }
                this.f12096a.computeBounds(this.f12106k, false);
                if (i7 == 0) {
                    this.f12104i.set(this.f12106k);
                } else {
                    RectF rectF2 = this.f12104i;
                    rectF2.set(Math.min(rectF2.left, this.f12106k.left), Math.min(this.f12104i.top, this.f12106k.top), Math.max(this.f12104i.right, this.f12106k.right), Math.max(this.f12104i.bottom, this.f12106k.bottom));
                }
            }
            if (rectF.intersect(this.f12104i)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void D(com.airbnb.lottie.animation.keyframe.a<?, ?> aVar) {
        this.f12116u.remove(aVar);
    }

    void E(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
    }

    void F(@o0 a aVar) {
        this.f12113r = aVar;
    }

    void G(@o0 a aVar) {
        this.f12114s = aVar;
    }

    void H(@v(from = 0.0d, to = 1.0d) float f8) {
        this.f12117v.j(f8);
        if (this.f12111p != null) {
            for (int i7 = 0; i7 < this.f12111p.a().size(); i7++) {
                this.f12111p.a().get(i7).l(f8);
            }
        }
        if (this.f12110o.t() != 0.0f) {
            f8 /= this.f12110o.t();
        }
        com.airbnb.lottie.animation.keyframe.c cVar = this.f12112q;
        if (cVar != null) {
            cVar.l(f8 / this.f12110o.t());
        }
        a aVar = this.f12113r;
        if (aVar != null) {
            this.f12113r.H(aVar.f12110o.t() * f8);
        }
        for (int i8 = 0; i8 < this.f12116u.size(); i8++) {
            this.f12116u.get(i8).l(f8);
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.a.b
    public void a() {
        B();
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<com.airbnb.lottie.animation.content.c> list, List<com.airbnb.lottie.animation.content.c> list2) {
    }

    @Override // com.airbnb.lottie.model.f
    public void c(com.airbnb.lottie.model.e eVar, int i7, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2) {
        if (eVar.h(getName(), i7)) {
            if (!"__container".equals(getName())) {
                eVar2 = eVar2.a(getName());
                if (eVar.c(getName(), i7)) {
                    list.add(eVar2.j(this));
                }
            }
            if (eVar.i(getName(), i7)) {
                E(eVar, i7 + eVar.e(getName(), i7), list, eVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.e
    @c.i
    public void d(RectF rectF, Matrix matrix, boolean z7) {
        this.f12103h.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.f12108m.set(matrix);
        if (z7) {
            List<a> list = this.f12115t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f12108m.preConcat(this.f12115t.get(size).f12117v.f());
                }
            } else {
                a aVar = this.f12114s;
                if (aVar != null) {
                    this.f12108m.preConcat(aVar.f12117v.f());
                }
            }
        }
        this.f12108m.preConcat(this.f12117v.f());
    }

    @Override // com.airbnb.lottie.animation.content.e
    public void f(Canvas canvas, Matrix matrix, int i7) {
        com.airbnb.lottie.e.a(this.f12107l);
        if (!this.f12118w || this.f12110o.v()) {
            com.airbnb.lottie.e.b(this.f12107l);
            return;
        }
        s();
        com.airbnb.lottie.e.a("Layer#parentMatrix");
        this.f12097b.reset();
        this.f12097b.set(matrix);
        for (int size = this.f12115t.size() - 1; size >= 0; size--) {
            this.f12097b.preConcat(this.f12115t.get(size).f12117v.f());
        }
        com.airbnb.lottie.e.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i7 / 255.0f) * (this.f12117v.h() == null ? 100 : this.f12117v.h().h().intValue())) / 100.0f) * 255.0f);
        if (!y() && !x()) {
            this.f12097b.preConcat(this.f12117v.f());
            com.airbnb.lottie.e.a("Layer#drawLayer");
            u(canvas, this.f12097b, iIntValue);
            com.airbnb.lottie.e.b("Layer#drawLayer");
            C(com.airbnb.lottie.e.b(this.f12107l));
            return;
        }
        com.airbnb.lottie.e.a("Layer#computeBounds");
        d(this.f12103h, this.f12097b, false);
        A(this.f12103h, matrix);
        this.f12097b.preConcat(this.f12117v.f());
        z(this.f12103h, this.f12097b);
        if (!this.f12103h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
            this.f12103h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.airbnb.lottie.e.b("Layer#computeBounds");
        if (!this.f12103h.isEmpty()) {
            com.airbnb.lottie.e.a("Layer#saveLayer");
            this.f12098c.setAlpha(255);
            j.n(canvas, this.f12103h, this.f12098c);
            com.airbnb.lottie.e.b("Layer#saveLayer");
            t(canvas);
            com.airbnb.lottie.e.a("Layer#drawLayer");
            u(canvas, this.f12097b, iIntValue);
            com.airbnb.lottie.e.b("Layer#drawLayer");
            if (x()) {
                p(canvas, this.f12097b);
            }
            if (y()) {
                com.airbnb.lottie.e.a("Layer#drawMatte");
                com.airbnb.lottie.e.a("Layer#saveLayer");
                j.o(canvas, this.f12103h, this.f12101f, 19);
                com.airbnb.lottie.e.b("Layer#saveLayer");
                t(canvas);
                this.f12113r.f(canvas, matrix, iIntValue);
                com.airbnb.lottie.e.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.e.b("Layer#restoreLayer");
                com.airbnb.lottie.e.b("Layer#drawMatte");
            }
            com.airbnb.lottie.e.a("Layer#restoreLayer");
            canvas.restore();
            com.airbnb.lottie.e.b("Layer#restoreLayer");
        }
        C(com.airbnb.lottie.e.b(this.f12107l));
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f12110o.g();
    }

    @Override // com.airbnb.lottie.model.f
    @c.i
    public <T> void h(T t7, @o0 com.airbnb.lottie.value.j<T> jVar) {
        this.f12117v.c(t7, jVar);
    }

    public void j(@o0 com.airbnb.lottie.animation.keyframe.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.f12116u.add(aVar);
    }

    abstract void u(Canvas canvas, Matrix matrix, int i7);

    d w() {
        return this.f12110o;
    }

    boolean x() {
        com.airbnb.lottie.animation.keyframe.g gVar = this.f12111p;
        return (gVar == null || gVar.a().isEmpty()) ? false : true;
    }

    boolean y() {
        return this.f12113r != null;
    }
}
