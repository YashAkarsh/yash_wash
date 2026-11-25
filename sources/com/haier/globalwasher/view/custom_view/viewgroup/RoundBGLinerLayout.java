package com.haier.globalwasher.view.custom_view.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.core.view.n2;
import c.o0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.utils.n0;

/* JADX INFO: loaded from: classes2.dex */
public class RoundBGLinerLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Path f25939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f25940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean[] f25943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25946i;

    public RoundBGLinerLayout(Context context) {
        this(context, null);
    }

    public void a(Canvas canvas) {
        int i7;
        double d8;
        int i8;
        double d9;
        int i9;
        int i10;
        int i11;
        int i12;
        this.f25941d = getMeasuredWidth();
        this.f25942e = getMeasuredHeight();
        int i13 = this.f25944g;
        this.f25939b.reset();
        float f8 = i13;
        this.f25939b.moveTo(this.f25945h + i13, f8);
        this.f25939b.lineTo((this.f25941d - this.f25945h) - i13, f8);
        double dC = c(this.f25945h + n0.k(getContext(), this.f25945h));
        if (this.f25943f[1]) {
            int i14 = this.f25941d - i13;
            int i15 = this.f25945h;
            i7 = (int) (((double) (i14 - i15)) + dC);
            d8 = ((double) (i15 + i13)) - dC;
        } else {
            i7 = (int) (((double) (this.f25941d - i13)) - dC);
            d8 = ((double) i13) + dC;
        }
        this.f25939b.quadTo(i7, (int) d8, this.f25941d - i13, this.f25945h + i13);
        this.f25939b.lineTo(this.f25941d - i13, (this.f25942e - this.f25945h) - i13);
        if (this.f25943f[2]) {
            int i16 = this.f25941d - i13;
            int i17 = this.f25945h;
            i8 = (int) (((double) (i16 - i17)) + dC);
            d9 = ((double) ((this.f25942e - i13) - i17)) + dC;
        } else {
            i8 = (int) (((double) (this.f25941d - i13)) - dC);
            d9 = ((double) (this.f25942e - i13)) - dC;
        }
        this.f25939b.quadTo(i8, (int) d9, (this.f25941d - i13) - this.f25945h, this.f25942e - i13);
        this.f25939b.lineTo(this.f25945h + i13, this.f25942e - i13);
        if (this.f25943f[3]) {
            int i18 = this.f25945h;
            i9 = (int) (((double) i13) + (((double) i18) - dC));
            i10 = (int) (((double) (this.f25942e - i13)) - (((double) i18) - dC));
        } else {
            i9 = (int) (((double) i13) + dC);
            i10 = (int) (((double) (this.f25942e - i13)) - dC);
        }
        this.f25939b.quadTo(i9, i10, f8, (this.f25942e - i13) - this.f25945h);
        this.f25939b.lineTo(f8, this.f25945h + i13);
        if (this.f25943f[0]) {
            double d10 = i13;
            int i19 = this.f25945h;
            i11 = (int) ((((double) i19) - dC) + d10);
            i12 = (int) (d10 + (((double) i19) - dC));
        } else {
            i11 = (int) (((double) i13) + dC);
            i12 = i11;
        }
        this.f25939b.quadTo(i11, i12, i13 + this.f25945h, f8);
        canvas.drawPath(this.f25939b, this.f25940c);
    }

    public double b(double d8) {
        return Math.sqrt(Math.pow(d8, 2.0d) / 2.0d);
    }

    public double c(int i7) {
        return Math.sqrt(Math.pow(i7, 2.0d) * 2.0d) / 2.0d;
    }

    public void d(TypedArray typedArray) {
        try {
            int color = typedArray.getColor(R.styleable.album_backgroundColor, -16776961);
            int color2 = typedArray.getColor(R.styleable.album_shadowColor, n2.f6743t);
            this.f25940c.setColor(color);
            this.f25945h = typedArray.getLayoutDimension(R.styleable.album_radius, n0.e(5.0f));
            this.f25940c.setShadowLayer(this.f25944g - 2, 1.0f, 1.0f, color2);
            this.f25940c.setStyle(typedArray.getBoolean(R.styleable.album_is_fill, true) ? Paint.Style.FILL : Paint.Style.STROKE);
            this.f25943f[0] = typedArray.getBoolean(R.styleable.album_top_left_angle_direction, true);
            this.f25943f[1] = typedArray.getBoolean(R.styleable.album_top_right_angle_direction, true);
            this.f25943f[2] = typedArray.getBoolean(R.styleable.album_buttom_right_angle_direction, true);
            this.f25943f[3] = typedArray.getBoolean(R.styleable.album_buttom_left_angle_direction, true);
        } finally {
            typedArray.recycle();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    public RoundBGLinerLayout(Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundBGLinerLayout(Context context, @o0 AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, 0);
    }

    public RoundBGLinerLayout(Context context, @o0 AttributeSet attributeSet, int i7, int i8) {
        super(context, attributeSet, i7, i8);
        this.f25938a = "CouponBGView";
        this.f25943f = new boolean[4];
        this.f25944g = n0.e(5.0f);
        this.f25945h = 0;
        this.f25946i = 0;
        this.f25939b = new Path();
        Paint paint = new Paint();
        this.f25940c = paint;
        paint.setAntiAlias(true);
        this.f25940c.setStyle(Paint.Style.FILL);
        this.f25940c.setStrokeWidth(2);
        this.f25940c.setColor(-16776961);
        this.f25940c.setShadowLayer(this.f25944g, 1.0f, 1.0f, getResources().getColor(R.color.blue, null));
        d(context.obtainStyledAttributes(attributeSet, R.styleable.album, i7, i8));
    }
}
