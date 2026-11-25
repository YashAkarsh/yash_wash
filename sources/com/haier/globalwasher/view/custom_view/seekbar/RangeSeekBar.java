package com.haier.globalwasher.view.custom_view.seekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public class RangeSeekBar extends ViewGroup {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f25870u = 5;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f25871v = 5;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f25872w = 8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f25873x = 20;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f25874y = 20;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static int f25875z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f25876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Drawable f25877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ThumbView f25878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ThumbView f25879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f25880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f25884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f25885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f25886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f25887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f25888m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f25889n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f25890o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f25891p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private c f25892q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f25893r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f25894s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f25895t;

    class a implements ThumbView.a {
        a() {
        }

        @Override // com.haier.globalwasher.view.custom_view.seekbar.ThumbView.a
        public void a(int i7) {
            RangeSeekBar.this.f25883h = i7;
            if (RangeSeekBar.this.f25892q != null) {
                RangeSeekBar.this.f25892q.b(RangeSeekBar.this.f25883h, RangeSeekBar.this.f25884i);
            }
        }

        @Override // com.haier.globalwasher.view.custom_view.seekbar.ThumbView.a
        public void b(int i7) {
            RangeSeekBar.this.f25893r = i7;
            if (RangeSeekBar.this.f25892q != null) {
                RangeSeekBar.this.f25892q.a(i7);
            }
        }
    }

    class b implements ThumbView.a {
        b() {
        }

        @Override // com.haier.globalwasher.view.custom_view.seekbar.ThumbView.a
        public void a(int i7) {
            RangeSeekBar.this.f25883h = i7;
            if (RangeSeekBar.this.f25892q != null) {
                RangeSeekBar.this.f25892q.b(RangeSeekBar.this.f25883h, RangeSeekBar.this.f25884i);
            }
        }

        @Override // com.haier.globalwasher.view.custom_view.seekbar.ThumbView.a
        public void b(int i7) {
            RangeSeekBar.this.f25893r = i7;
            if (RangeSeekBar.this.f25892q != null) {
                RangeSeekBar.this.f25892q.a(i7);
            }
        }
    }

    public interface c {
        void a(int i7);

        void b(int i7, int i8);
    }

    public RangeSeekBar(Context context) {
        this(context, null);
    }

    private int i(ThumbView thumbView) {
        int i7 = this.f25882g;
        int centerX = thumbView.getCenterX();
        int i8 = this.f25885j;
        return (i7 * (centerX - i8)) / (this.f25886k - i8);
    }

    private void j() {
        this.f25878c.setCenterX(this.f25885j, this.f25894s);
        this.f25895t = true;
    }

    protected void f(Canvas canvas, int i7) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#e5e5e5"));
        int i8 = this.f25885j;
        int i9 = this.f25888m;
        canvas.drawRect(new Rect(i8, i9, this.f25886k, this.f25880e + i9), paint);
        paint.setColor(getResources().getColor(R.color.app_zhexian_blue_relg));
        int i10 = this.f25885j;
        int i11 = this.f25888m;
        canvas.drawRect(new Rect(i10, i11, i7, this.f25880e + i11), paint);
    }

    protected void g(Canvas canvas, ThumbView thumbView) {
        thumbView.getCenterX();
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(30.0f);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c8  */
    protected void h(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(2.0f);
        paint.setColor(getResources().getColor(R.color.app_zhexian_blue_relg));
        int width = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        if (width <= 740) {
            paint.setTextSize(25.0f);
        } else {
            paint.setTextSize(40.0f);
        }
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        int i7 = 5;
        while (true) {
            int i8 = this.f25882g;
            if (i7 > i8) {
                return;
            }
            if (i7 >= 5 && i7 <= i8 - 5) {
                float f8 = this.f25885j + (i7 * this.f25889n);
                int i9 = i7 - 5;
                int i10 = i9 % 10;
                if (i10 == 0) {
                    int iA = this.f25888m - com.haier.globalwasher.view.custom_view.seekbar.a.a(getContext(), 8.0f);
                    if (i10 == 0) {
                        int i11 = i9 / 10;
                        if (this.f25890o[i11] == this.f25893r) {
                            paint.setColor(getResources().getColor(R.color.app_zhexian_blue_relg));
                            if (width <= 740) {
                                paint.setTextSize(35.0f);
                            } else {
                                paint.setTextSize(50.0f);
                            }
                            canvas.drawText((this.f25890o[i11] * 10) + this.f25891p, f8, iA - 32, paint);
                            canvas.drawLine(f8, (float) (this.f25888m + (-23)), f8, (float) (iA + (-23)), paint);
                        } else {
                            if (width <= 740) {
                                paint.setTextSize(25.0f);
                            } else {
                                paint.setTextSize(40.0f);
                            }
                            paint.setColor(Color.parseColor("#b2b2b2"));
                            canvas.drawText((this.f25890o[i9 / 10] * 10) + this.f25891p, f8, iA - 32, paint);
                            paint.setColor(getResources().getColor(R.color.app_text));
                            canvas.drawLine(f8, (float) (this.f25888m + (-23)), f8, (float) (iA + (-23)), paint);
                        }
                    } else {
                        if (width <= 740) {
                            paint.setTextSize(25.0f);
                        } else {
                            paint.setTextSize(40.0f);
                        }
                        paint.setColor(Color.parseColor("#b2b2b2"));
                        canvas.drawText((this.f25890o[i9 / 10] * 10) + this.f25891p, f8, iA - 32, paint);
                        paint.setColor(getResources().getColor(R.color.app_text));
                        canvas.drawLine(f8, (float) (this.f25888m + (-23)), f8, (float) (iA + (-23)), paint);
                    }
                } else {
                    int iA2 = this.f25888m - com.haier.globalwasher.view.custom_view.seekbar.a.a(getContext(), 5.0f);
                    paint.setColor(Color.parseColor("#b2b2b2"));
                    paint.setColor(getResources().getColor(R.color.app_text));
                    canvas.drawLine(f8, this.f25888m - 23, f8, iA2 - 23, paint);
                }
            }
            i7 += 2;
        }
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas, this.f25878c.getCenterX());
        h(canvas);
        if (this.f25878c.a()) {
            g(canvas, this.f25878c);
        } else if (!this.f25878c.a()) {
            Log.d("ss:", "" + this.f25878c.getCenterX());
            h(canvas);
            f(canvas, this.f25878c.getCenterX());
        } else if (this.f25879d.a()) {
            g(canvas, this.f25879d);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int i11 = this.f25886k;
        int i12 = this.f25885j;
        this.f25889n = (i11 - i12) / this.f25882g;
        this.f25878c.setLimit(i12, i11);
        ThumbView thumbView = this.f25878c;
        int i13 = i10 - 10;
        thumbView.layout(0, 0, thumbView.getMeasuredWidth() - 10, i13);
        this.f25879d.setLimit(this.f25885j, this.f25886k);
        this.f25879d.layout(0, 0, this.f25878c.getMeasuredWidth(), i13);
        j();
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i7, int i8) {
        measureChildren(i7, i8);
        super.onMeasure(i7, i8);
        int size = View.MeasureSpec.getSize(i7);
        int measuredWidth = this.f25878c.getMeasuredWidth() / 2;
        this.f25887l = measuredWidth;
        this.f25886k = size - measuredWidth;
        this.f25885j = measuredWidth;
        setMeasuredDimension(size, this.f25881f + f25875z + this.f25880e + this.f25878c.getMeasuredHeight());
    }

    public void setDefaultCount(int i7) {
        this.f25894s = i7;
        this.f25893r = i7;
        if (this.f25895t) {
            j();
        }
    }

    public void setOnRangeChangeListener(c cVar) {
        this.f25892q = cVar;
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RangeSeekBar(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25882g = 120;
        this.f25884i = 120;
        this.f25890o = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        this.f25891p = "";
        this.f25893r = 1;
        this.f25894s = 1;
        this.f25895t = false;
        setBackgroundDrawable(new BitmapDrawable());
        f25875z = com.haier.globalwasher.view.custom_view.seekbar.a.a(context, 20.0f);
        this.f25880e = com.haier.globalwasher.view.custom_view.seekbar.a.a(context, 4.0f);
        this.f25876a = getResources().getDrawable(R.drawable.icon_huakuai);
        Drawable drawable = getResources().getDrawable(R.drawable.rod_place_icon);
        this.f25877b = drawable;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f25881f = intrinsicHeight;
        this.f25888m = f25875z + intrinsicHeight;
        ThumbView thumbView = new ThumbView(getContext());
        this.f25878c = thumbView;
        thumbView.setRangeSeekBar(this);
        this.f25878c.setImageDrawable(this.f25876a);
        ThumbView thumbView2 = new ThumbView(getContext());
        this.f25879d = thumbView2;
        thumbView2.setRangeSeekBar(this);
        this.f25879d.setImageDrawable(this.f25876a);
        addView(this.f25878c);
        this.f25878c.setOnThumbListener(new a());
        this.f25879d.setOnThumbListener(new b());
    }
}
