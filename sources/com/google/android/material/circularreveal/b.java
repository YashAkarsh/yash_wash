package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.n2;
import c.l;
import c.m0;
import c.o0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final boolean f17377k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f17378l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f17379m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f17380n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17381o = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f17382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final View f17383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final Path f17384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final Paint f17385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    private final Paint f17386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private c.e f17387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private Drawable f17388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f17389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f17391j;

    public interface a {
        void c(Canvas canvas);

        boolean d();
    }

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.b$b, reason: collision with other inner class name */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0195b {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.f17382a = aVar;
        View view = (View) aVar;
        this.f17383b = view;
        view.setWillNotDraw(false);
        this.f17384c = new Path();
        this.f17385d = new Paint(7);
        Paint paint = new Paint(1);
        this.f17386e = paint;
        paint.setColor(0);
    }

    private void d(@m0 Canvas canvas, int i7, float f8) {
        this.f17389h.setColor(i7);
        this.f17389h.setStrokeWidth(f8);
        c.e eVar = this.f17387f;
        canvas.drawCircle(eVar.f17397a, eVar.f17398b, eVar.f17399c - (f8 / 2.0f), this.f17389h);
    }

    private void e(@m0 Canvas canvas) {
        this.f17382a.c(canvas);
        if (r()) {
            c.e eVar = this.f17387f;
            canvas.drawCircle(eVar.f17397a, eVar.f17398b, eVar.f17399c, this.f17386e);
        }
        if (p()) {
            d(canvas, n2.f6743t, 10.0f);
            d(canvas, k.a.f34390c, 5.0f);
        }
        f(canvas);
    }

    private void f(@m0 Canvas canvas) {
        if (q()) {
            Rect bounds = this.f17388g.getBounds();
            float fWidth = this.f17387f.f17397a - (bounds.width() / 2.0f);
            float fHeight = this.f17387f.f17398b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f17388g.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    private float i(@m0 c.e eVar) {
        return p1.a.b(eVar.f17397a, eVar.f17398b, 0.0f, 0.0f, this.f17383b.getWidth(), this.f17383b.getHeight());
    }

    private void k() {
        if (f17381o == 1) {
            this.f17384c.rewind();
            c.e eVar = this.f17387f;
            if (eVar != null) {
                this.f17384c.addCircle(eVar.f17397a, eVar.f17398b, eVar.f17399c, Path.Direction.CW);
            }
        }
        this.f17383b.invalidate();
    }

    private boolean p() {
        c.e eVar = this.f17387f;
        boolean z7 = eVar == null || eVar.a();
        if (f17381o == 0) {
            return !z7 && this.f17391j;
        }
        return !z7;
    }

    private boolean q() {
        return (this.f17390i || this.f17388g == null || this.f17387f == null) ? false : true;
    }

    private boolean r() {
        return (this.f17390i || Color.alpha(this.f17386e.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (f17381o == 0) {
            this.f17390i = true;
            this.f17391j = false;
            this.f17383b.buildDrawingCache();
            Bitmap drawingCache = this.f17383b.getDrawingCache();
            if (drawingCache == null && this.f17383b.getWidth() != 0 && this.f17383b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f17383b.getWidth(), this.f17383b.getHeight(), Bitmap.Config.ARGB_8888);
                this.f17383b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f17385d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f17390i = false;
            this.f17391j = true;
        }
    }

    public void b() {
        if (f17381o == 0) {
            this.f17391j = false;
            this.f17383b.destroyDrawingCache();
            this.f17385d.setShader(null);
            this.f17383b.invalidate();
        }
    }

    public void c(@m0 Canvas canvas) {
        if (p()) {
            int i7 = f17381o;
            if (i7 == 0) {
                c.e eVar = this.f17387f;
                canvas.drawCircle(eVar.f17397a, eVar.f17398b, eVar.f17399c, this.f17385d);
                if (r()) {
                    c.e eVar2 = this.f17387f;
                    canvas.drawCircle(eVar2.f17397a, eVar2.f17398b, eVar2.f17399c, this.f17386e);
                }
            } else if (i7 == 1) {
                int iSave = canvas.save();
                canvas.clipPath(this.f17384c);
                this.f17382a.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.f17383b.getWidth(), this.f17383b.getHeight(), this.f17386e);
                }
                canvas.restoreToCount(iSave);
            } else {
                if (i7 != 2) {
                    throw new IllegalStateException("Unsupported strategy " + i7);
                }
                this.f17382a.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.f17383b.getWidth(), this.f17383b.getHeight(), this.f17386e);
                }
            }
        } else {
            this.f17382a.c(canvas);
            if (r()) {
                canvas.drawRect(0.0f, 0.0f, this.f17383b.getWidth(), this.f17383b.getHeight(), this.f17386e);
            }
        }
        f(canvas);
    }

    @o0
    public Drawable g() {
        return this.f17388g;
    }

    @l
    public int h() {
        return this.f17386e.getColor();
    }

    @o0
    public c.e j() {
        c.e eVar = this.f17387f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f17399c = i(eVar2);
        }
        return eVar2;
    }

    public boolean l() {
        return this.f17382a.d() && !p();
    }

    public void m(@o0 Drawable drawable) {
        this.f17388g = drawable;
        this.f17383b.invalidate();
    }

    public void n(@l int i7) {
        this.f17386e.setColor(i7);
        this.f17383b.invalidate();
    }

    public void o(@o0 c.e eVar) {
        if (eVar == null) {
            this.f17387f = null;
        } else {
            c.e eVar2 = this.f17387f;
            if (eVar2 == null) {
                this.f17387f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (p1.a.e(eVar.f17399c, i(eVar), 1.0E-4f)) {
                this.f17387f.f17399c = Float.MAX_VALUE;
            }
        }
        k();
    }
}
