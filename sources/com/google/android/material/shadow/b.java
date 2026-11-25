package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.core.graphics.v1;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f18198i = 68;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f18199j = 20;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f18200k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[] f18201l = new int[3];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float[] f18202m = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f18203n = new int[4];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float[] f18204o = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Paint f18205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Paint f18206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final Paint f18207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Path f18211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint f18212h;

    public b() {
        this(n2.f6743t);
    }

    public void a(@m0 Canvas canvas, @o0 Matrix matrix, @m0 RectF rectF, int i7, float f8, float f9) {
        boolean z7 = f9 < 0.0f;
        Path path = this.f18211g;
        if (z7) {
            int[] iArr = f18203n;
            iArr[0] = 0;
            iArr[1] = this.f18210f;
            iArr[2] = this.f18209e;
            iArr[3] = this.f18208d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f8, f9);
            path.close();
            float f10 = -i7;
            rectF.inset(f10, f10);
            int[] iArr2 = f18203n;
            iArr2[0] = 0;
            iArr2[1] = this.f18208d;
            iArr2[2] = this.f18209e;
            iArr2[3] = this.f18210f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f11 = 1.0f - (i7 / fWidth);
        float[] fArr = f18204o;
        fArr[1] = f11;
        fArr[2] = ((1.0f - f11) / 2.0f) + f11;
        this.f18206b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, f18203n, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z7) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f18212h);
        }
        canvas.drawArc(rectF, f8, f9, true, this.f18206b);
        canvas.restore();
    }

    public void b(@m0 Canvas canvas, @o0 Matrix matrix, @m0 RectF rectF, int i7) {
        rectF.bottom += i7;
        rectF.offset(0.0f, -i7);
        int[] iArr = f18201l;
        iArr[0] = this.f18210f;
        iArr[1] = this.f18209e;
        iArr[2] = this.f18208d;
        Paint paint = this.f18207c;
        float f8 = rectF.left;
        paint.setShader(new LinearGradient(f8, rectF.top, f8, rectF.bottom, iArr, f18202m, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f18207c);
        canvas.restore();
    }

    @m0
    public Paint c() {
        return this.f18205a;
    }

    public void d(int i7) {
        this.f18208d = v1.B(i7, 68);
        this.f18209e = v1.B(i7, 20);
        this.f18210f = v1.B(i7, 0);
        this.f18205a.setColor(this.f18208d);
    }

    public b(int i7) {
        this.f18211g = new Path();
        this.f18212h = new Paint();
        this.f18205a = new Paint();
        d(i7);
        this.f18212h.setColor(0);
        Paint paint = new Paint(4);
        this.f18206b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18207c = new Paint(paint);
    }
}
