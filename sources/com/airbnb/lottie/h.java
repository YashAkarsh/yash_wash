package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import c.e0;
import c.j0;
import c.m0;
import c.o0;
import c.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class h extends Drawable implements Drawable.Callback, Animatable {
    public static final int A = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f11809x = "h";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f11810y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f11811z = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f11812a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.airbnb.lottie.f f11813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.airbnb.lottie.utils.g f11814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f11815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set<r> f11818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ArrayList<s> f11819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f11820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private ImageView.ScaleType f11821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.manager.b f11822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private String f11823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.d f11824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.manager.a f11825n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @o0
    com.airbnb.lottie.c f11826o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    u f11827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11828q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.model.layer.b f11829r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11830s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f11831t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f11832u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f11833v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f11834w;

    class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11835a;

        a(String str) {
            this.f11835a = str;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.l0(this.f11835a);
        }
    }

    class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f11838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f11839c;

        b(String str, String str2, boolean z7) {
            this.f11837a = str;
            this.f11838b = str2;
            this.f11839c = z7;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.m0(this.f11837a, this.f11838b, this.f11839c);
        }
    }

    class c implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f11842b;

        c(int i7, int i8) {
            this.f11841a = i7;
            this.f11842b = i8;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.k0(this.f11841a, this.f11842b);
        }
    }

    class d implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f11844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f11845b;

        d(float f8, float f9) {
            this.f11844a = f8;
            this.f11845b = f9;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.n0(this.f11844a, this.f11845b);
        }
    }

    class e implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11847a;

        e(int i7) {
            this.f11847a = i7;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.e0(this.f11847a);
        }
    }

    class f implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f11849a;

        f(float f8) {
            this.f11849a = f8;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.s0(this.f11849a);
        }
    }

    class g implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.model.e f11851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f11852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.value.j f11853c;

        g(com.airbnb.lottie.model.e eVar, Object obj, com.airbnb.lottie.value.j jVar) {
            this.f11851a = eVar;
            this.f11852b = obj;
            this.f11853c = jVar;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.h(this.f11851a, this.f11852b, this.f11853c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.airbnb.lottie.h$h, reason: collision with other inner class name */
    class C0143h<T> extends com.airbnb.lottie.value.j<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.value.l f11855d;

        C0143h(com.airbnb.lottie.value.l lVar) {
            this.f11855d = lVar;
        }

        @Override // com.airbnb.lottie.value.j
        public T a(com.airbnb.lottie.value.b<T> bVar) {
            return (T) this.f11855d.a(bVar);
        }
    }

    class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (h.this.f11829r != null) {
                h.this.f11829r.H(h.this.f11814c.m());
            }
        }
    }

    class j implements s {
        j() {
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.T();
        }
    }

    class k implements s {
        k() {
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.Z();
        }
    }

    class l implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11860a;

        l(int i7) {
            this.f11860a = i7;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.o0(this.f11860a);
        }
    }

    class m implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f11862a;

        m(float f8) {
            this.f11862a = f8;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.q0(this.f11862a);
        }
    }

    class n implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11864a;

        n(int i7) {
            this.f11864a = i7;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.h0(this.f11864a);
        }
    }

    class o implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f11866a;

        o(float f8) {
            this.f11866a = f8;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.j0(this.f11866a);
        }
    }

    class p implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11868a;

        p(String str) {
            this.f11868a = str;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.p0(this.f11868a);
        }
    }

    class q implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f11870a;

        q(String str) {
            this.f11870a = str;
        }

        @Override // com.airbnb.lottie.h.s
        public void a(com.airbnb.lottie.f fVar) {
            h.this.i0(this.f11870a);
        }
    }

    private static class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f11872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        final String f11873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        final ColorFilter f11874c;

        r(@o0 String str, @o0 String str2, @o0 ColorFilter colorFilter) {
            this.f11872a = str;
            this.f11873b = str2;
            this.f11874c = colorFilter;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof r)) {
                return false;
            }
            r rVar = (r) obj;
            return hashCode() == rVar.hashCode() && this.f11874c == rVar.f11874c;
        }

        public int hashCode() {
            String str = this.f11872a;
            int iHashCode = str != null ? 527 * str.hashCode() : 17;
            String str2 = this.f11873b;
            return str2 != null ? iHashCode * 31 * str2.hashCode() : iHashCode;
        }
    }

    private interface s {
        void a(com.airbnb.lottie.f fVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface t {
    }

    public h() {
        com.airbnb.lottie.utils.g gVar = new com.airbnb.lottie.utils.g();
        this.f11814c = gVar;
        this.f11815d = 1.0f;
        this.f11816e = true;
        this.f11817f = false;
        this.f11818g = new HashSet();
        this.f11819h = new ArrayList<>();
        i iVar = new i();
        this.f11820i = iVar;
        this.f11830s = 255;
        this.f11833v = true;
        this.f11834w = false;
        gVar.addUpdateListener(iVar);
    }

    private float B(@m0 Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f11813b.b().width(), canvas.getHeight() / this.f11813b.b().height());
    }

    private void C0() {
        if (this.f11813b == null) {
            return;
        }
        float fH = H();
        setBounds(0, 0, (int) (this.f11813b.b().width() * fH), (int) (this.f11813b.b().height() * fH));
    }

    private void j() {
        this.f11829r = new com.airbnb.lottie.model.layer.b(this, com.airbnb.lottie.parser.s.a(this.f11813b), this.f11813b.j(), this.f11813b);
    }

    private void n(@m0 Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f11821j) {
            o(canvas);
        } else {
            p(canvas);
        }
    }

    private void o(Canvas canvas) {
        float f8;
        if (this.f11829r == null) {
            return;
        }
        Rect bounds = getBounds();
        float fWidth = bounds.width() / this.f11813b.b().width();
        float fHeight = bounds.height() / this.f11813b.b().height();
        int iSave = -1;
        if (this.f11833v) {
            float fMin = Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                f8 = 1.0f / fMin;
                fWidth /= f8;
                fHeight /= f8;
            } else {
                f8 = 1.0f;
            }
            if (f8 > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f9 = fWidth2 * fMin;
                float f10 = fMin * fHeight2;
                canvas.translate(fWidth2 - f9, fHeight2 - f10);
                canvas.scale(f8, f8, f9, f10);
            }
        }
        this.f11812a.reset();
        this.f11812a.preScale(fWidth, fHeight);
        this.f11829r.f(canvas, this.f11812a, this.f11830s);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    private void p(Canvas canvas) {
        float f8;
        int iSave;
        if (this.f11829r == null) {
            return;
        }
        float f9 = this.f11815d;
        float fB = B(canvas);
        if (f9 > fB) {
            f8 = this.f11815d / fB;
        } else {
            fB = f9;
            f8 = 1.0f;
        }
        if (f8 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.f11813b.b().width() / 2.0f;
            float fHeight = this.f11813b.b().height() / 2.0f;
            float f10 = fWidth * fB;
            float f11 = fHeight * fB;
            canvas.translate((H() * fWidth) - f10, (H() * fHeight) - f11);
            canvas.scale(f8, f8, f10, f11);
        } else {
            iSave = -1;
        }
        this.f11812a.reset();
        this.f11812a.preScale(fB, fB);
        this.f11829r.f(canvas, this.f11812a, this.f11830s);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @o0
    private Context u() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private com.airbnb.lottie.manager.a v() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f11825n == null) {
            this.f11825n = new com.airbnb.lottie.manager.a(getCallback(), this.f11826o);
        }
        return this.f11825n;
    }

    private com.airbnb.lottie.manager.b y() {
        if (getCallback() == null) {
            return null;
        }
        com.airbnb.lottie.manager.b bVar = this.f11822k;
        if (bVar != null && !bVar.b(u())) {
            this.f11822k = null;
        }
        if (this.f11822k == null) {
            this.f11822k = new com.airbnb.lottie.manager.b(getCallback(), this.f11823l, this.f11824m, this.f11813b.i());
        }
        return this.f11822k;
    }

    public float A() {
        return this.f11814c.p();
    }

    public void A0(u uVar) {
        this.f11827p = uVar;
    }

    @o0
    public Bitmap B0(String str, @o0 Bitmap bitmap) {
        com.airbnb.lottie.manager.b bVarY = y();
        if (bVarY == null) {
            com.airbnb.lottie.utils.f.e("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapE = bVarY.e(str, bitmap);
        invalidateSelf();
        return bitmapE;
    }

    public float C() {
        return this.f11814c.q();
    }

    @o0
    public com.airbnb.lottie.q D() {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar != null) {
            return fVar.n();
        }
        return null;
    }

    public boolean D0() {
        return this.f11827p == null && this.f11813b.c().C() > 0;
    }

    @v(from = 0.0d, to = 1.0d)
    public float E() {
        return this.f11814c.m();
    }

    public int F() {
        return this.f11814c.getRepeatCount();
    }

    public int G() {
        return this.f11814c.getRepeatMode();
    }

    public float H() {
        return this.f11815d;
    }

    public float I() {
        return this.f11814c.r();
    }

    @o0
    public u J() {
        return this.f11827p;
    }

    @o0
    public Typeface K(String str, String str2) {
        com.airbnb.lottie.manager.a aVarV = v();
        if (aVarV != null) {
            return aVarV.b(str, str2);
        }
        return null;
    }

    public boolean L() {
        com.airbnb.lottie.model.layer.b bVar = this.f11829r;
        return bVar != null && bVar.K();
    }

    public boolean M() {
        com.airbnb.lottie.model.layer.b bVar = this.f11829r;
        return bVar != null && bVar.L();
    }

    public boolean N() {
        com.airbnb.lottie.utils.g gVar = this.f11814c;
        if (gVar == null) {
            return false;
        }
        return gVar.isRunning();
    }

    public boolean O() {
        return this.f11832u;
    }

    public boolean P() {
        return this.f11814c.getRepeatCount() == -1;
    }

    public boolean Q() {
        return this.f11828q;
    }

    @Deprecated
    public void R(boolean z7) {
        this.f11814c.setRepeatCount(z7 ? -1 : 0);
    }

    public void S() {
        this.f11819h.clear();
        this.f11814c.t();
    }

    @j0
    public void T() {
        if (this.f11829r == null) {
            this.f11819h.add(new j());
            return;
        }
        if (this.f11816e || F() == 0) {
            this.f11814c.u();
        }
        if (this.f11816e) {
            return;
        }
        e0((int) (I() < 0.0f ? C() : A()));
        this.f11814c.l();
    }

    public void U() {
        this.f11814c.removeAllListeners();
    }

    public void V() {
        this.f11814c.removeAllUpdateListeners();
        this.f11814c.addUpdateListener(this.f11820i);
    }

    public void W(Animator.AnimatorListener animatorListener) {
        this.f11814c.removeListener(animatorListener);
    }

    public void X(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f11814c.removeUpdateListener(animatorUpdateListener);
    }

    public List<com.airbnb.lottie.model.e> Y(com.airbnb.lottie.model.e eVar) {
        if (this.f11829r == null) {
            com.airbnb.lottie.utils.f.e("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f11829r.c(eVar, 0, arrayList, new com.airbnb.lottie.model.e(new String[0]));
        return arrayList;
    }

    @j0
    public void Z() {
        if (this.f11829r == null) {
            this.f11819h.add(new k());
            return;
        }
        if (this.f11816e || F() == 0) {
            this.f11814c.y();
        }
        if (this.f11816e) {
            return;
        }
        e0((int) (I() < 0.0f ? C() : A()));
        this.f11814c.l();
    }

    public void a0() {
        this.f11814c.z();
    }

    public void b0(boolean z7) {
        this.f11832u = z7;
    }

    public boolean c0(com.airbnb.lottie.f fVar) {
        if (this.f11813b == fVar) {
            return false;
        }
        this.f11834w = false;
        l();
        this.f11813b = fVar;
        j();
        this.f11814c.A(fVar);
        s0(this.f11814c.getAnimatedFraction());
        w0(this.f11815d);
        C0();
        Iterator it = new ArrayList(this.f11819h).iterator();
        while (it.hasNext()) {
            ((s) it.next()).a(fVar);
            it.remove();
        }
        this.f11819h.clear();
        fVar.x(this.f11831t);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    public void d0(com.airbnb.lottie.c cVar) {
        this.f11826o = cVar;
        com.airbnb.lottie.manager.a aVar = this.f11825n;
        if (aVar != null) {
            aVar.d(cVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@m0 Canvas canvas) {
        this.f11834w = false;
        com.airbnb.lottie.e.a("Drawable#draw");
        if (this.f11817f) {
            try {
                n(canvas);
            } catch (Throwable th) {
                com.airbnb.lottie.utils.f.c("Lottie crashed in draw!", th);
            }
        } else {
            n(canvas);
        }
        com.airbnb.lottie.e.b("Drawable#draw");
    }

    public void e0(int i7) {
        if (this.f11813b == null) {
            this.f11819h.add(new e(i7));
        } else {
            this.f11814c.B(i7);
        }
    }

    public void f(Animator.AnimatorListener animatorListener) {
        this.f11814c.addListener(animatorListener);
    }

    public void f0(com.airbnb.lottie.d dVar) {
        this.f11824m = dVar;
        com.airbnb.lottie.manager.b bVar = this.f11822k;
        if (bVar != null) {
            bVar.d(dVar);
        }
    }

    public void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f11814c.addUpdateListener(animatorUpdateListener);
    }

    public void g0(@o0 String str) {
        this.f11823l = str;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f11830s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            return -1;
        }
        return (int) (fVar.b().height() * H());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            return -1;
        }
        return (int) (fVar.b().width() * H());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public <T> void h(com.airbnb.lottie.model.e eVar, T t7, com.airbnb.lottie.value.j<T> jVar) {
        if (this.f11829r == null) {
            this.f11819h.add(new g(eVar, t7, jVar));
            return;
        }
        boolean zIsEmpty = true;
        if (eVar.d() != null) {
            eVar.d().h(t7, jVar);
        } else {
            List<com.airbnb.lottie.model.e> listY = Y(eVar);
            for (int i7 = 0; i7 < listY.size(); i7++) {
                listY.get(i7).d().h(t7, jVar);
            }
            zIsEmpty = true ^ listY.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t7 == com.airbnb.lottie.m.A) {
                s0(E());
            }
        }
    }

    public void h0(int i7) {
        if (this.f11813b == null) {
            this.f11819h.add(new n(i7));
        } else {
            this.f11814c.C(i7 + 0.99f);
        }
    }

    public <T> void i(com.airbnb.lottie.model.e eVar, T t7, com.airbnb.lottie.value.l<T> lVar) {
        h(eVar, t7, new C0143h(lVar));
    }

    public void i0(String str) {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            this.f11819h.add(new q(str));
            return;
        }
        com.airbnb.lottie.model.h hVarK = fVar.k(str);
        if (hVarK != null) {
            h0((int) (hVarK.f12089b + hVarK.f12090c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + com.alibaba.android.arouter.utils.b.f12515h);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@m0 Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f11834w) {
            return;
        }
        this.f11834w = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return N();
    }

    public void j0(@v(from = 0.0d, to = 1.0d) float f8) {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            this.f11819h.add(new o(f8));
        } else {
            h0((int) com.airbnb.lottie.utils.i.j(fVar.p(), this.f11813b.f(), f8));
        }
    }

    public void k() {
        this.f11819h.clear();
        this.f11814c.cancel();
    }

    public void k0(int i7, int i8) {
        if (this.f11813b == null) {
            this.f11819h.add(new c(i7, i8));
        } else {
            this.f11814c.D(i7, i8 + 0.99f);
        }
    }

    public void l() {
        if (this.f11814c.isRunning()) {
            this.f11814c.cancel();
        }
        this.f11813b = null;
        this.f11829r = null;
        this.f11822k = null;
        this.f11814c.k();
        invalidateSelf();
    }

    public void l0(String str) {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            this.f11819h.add(new a(str));
            return;
        }
        com.airbnb.lottie.model.h hVarK = fVar.k(str);
        if (hVarK != null) {
            int i7 = (int) hVarK.f12089b;
            k0(i7, ((int) hVarK.f12090c) + i7);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + com.alibaba.android.arouter.utils.b.f12515h);
        }
    }

    public void m() {
        this.f11833v = false;
    }

    public void m0(String str, String str2, boolean z7) {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            this.f11819h.add(new b(str, str2, z7));
            return;
        }
        com.airbnb.lottie.model.h hVarK = fVar.k(str);
        if (hVarK == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + com.alibaba.android.arouter.utils.b.f12515h);
        }
        int i7 = (int) hVarK.f12089b;
        com.airbnb.lottie.model.h hVarK2 = this.f11813b.k(str2);
        if (str2 != null) {
            k0(i7, (int) (hVarK2.f12089b + (z7 ? 1.0f : 0.0f)));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + com.alibaba.android.arouter.utils.b.f12515h);
    }

    public void n0(@v(from = 0.0d, to = 1.0d) float f8, @v(from = 0.0d, to = 1.0d) float f9) {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            this.f11819h.add(new d(f8, f9));
        } else {
            k0((int) com.airbnb.lottie.utils.i.j(fVar.p(), this.f11813b.f(), f8), (int) com.airbnb.lottie.utils.i.j(this.f11813b.p(), this.f11813b.f(), f9));
        }
    }

    public void o0(int i7) {
        if (this.f11813b == null) {
            this.f11819h.add(new l(i7));
        } else {
            this.f11814c.E(i7);
        }
    }

    public void p0(String str) {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            this.f11819h.add(new p(str));
            return;
        }
        com.airbnb.lottie.model.h hVarK = fVar.k(str);
        if (hVarK != null) {
            o0((int) hVarK.f12089b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + com.alibaba.android.arouter.utils.b.f12515h);
    }

    public void q(boolean z7) {
        if (this.f11828q == z7) {
            return;
        }
        this.f11828q = z7;
        if (this.f11813b != null) {
            j();
        }
    }

    public void q0(float f8) {
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar == null) {
            this.f11819h.add(new m(f8));
        } else {
            o0((int) com.airbnb.lottie.utils.i.j(fVar.p(), this.f11813b.f(), f8));
        }
    }

    public boolean r() {
        return this.f11828q;
    }

    public void r0(boolean z7) {
        this.f11831t = z7;
        com.airbnb.lottie.f fVar = this.f11813b;
        if (fVar != null) {
            fVar.x(z7);
        }
    }

    @j0
    public void s() {
        this.f11819h.clear();
        this.f11814c.l();
    }

    public void s0(@v(from = 0.0d, to = 1.0d) float f8) {
        if (this.f11813b == null) {
            this.f11819h.add(new f(f8));
            return;
        }
        com.airbnb.lottie.e.a("Drawable#setProgress");
        this.f11814c.B(com.airbnb.lottie.utils.i.j(this.f11813b.p(), this.f11813b.f(), f8));
        com.airbnb.lottie.e.b("Drawable#setProgress");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable, long j7) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@e0(from = 0, to = 255) int i7) {
        this.f11830s = i7;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@o0 ColorFilter colorFilter) {
        com.airbnb.lottie.utils.f.e("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @j0
    public void start() {
        T();
    }

    @Override // android.graphics.drawable.Animatable
    @j0
    public void stop() {
        s();
    }

    public com.airbnb.lottie.f t() {
        return this.f11813b;
    }

    public void t0(int i7) {
        this.f11814c.setRepeatCount(i7);
    }

    public void u0(int i7) {
        this.f11814c.setRepeatMode(i7);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void v0(boolean z7) {
        this.f11817f = z7;
    }

    public int w() {
        return (int) this.f11814c.n();
    }

    public void w0(float f8) {
        this.f11815d = f8;
        C0();
    }

    @o0
    public Bitmap x(String str) {
        com.airbnb.lottie.manager.b bVarY = y();
        if (bVarY != null) {
            return bVarY.a(str);
        }
        return null;
    }

    void x0(ImageView.ScaleType scaleType) {
        this.f11821j = scaleType;
    }

    public void y0(float f8) {
        this.f11814c.F(f8);
    }

    @o0
    public String z() {
        return this.f11823l;
    }

    void z0(Boolean bool) {
        this.f11816e = bool.booleanValue();
    }
}
