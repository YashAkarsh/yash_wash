package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f4390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4391e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Drawable f4392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f4393g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f4394h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f4395i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f4396j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Path f4397k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ViewOutlineProvider f4398l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    RectF f4399m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Drawable[] f4400n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    LayerDrawable f4401o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    float f4402p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    float f4403q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    float f4404r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    float f4405s;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterView.this.f4395i) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f4396j);
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float[] f4408a = new float[20];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ColorMatrix f4409b = new ColorMatrix();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorMatrix f4410c = new ColorMatrix();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f4411d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f4412e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f4413f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f4414g = 1.0f;

        c() {
        }

        private void a(float brightness) {
            float[] fArr = this.f4408a;
            fArr[0] = brightness;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = brightness;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = brightness;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float saturationStrength) {
            float f8 = 1.0f - saturationStrength;
            float f9 = 0.2999f * f8;
            float f10 = 0.587f * f8;
            float f11 = f8 * 0.114f;
            float[] fArr = this.f4408a;
            fArr[0] = f9 + saturationStrength;
            fArr[1] = f10;
            fArr[2] = f11;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f9;
            fArr[6] = f10 + saturationStrength;
            fArr[7] = f11;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f9;
            fArr[11] = f10;
            fArr[12] = f11 + saturationStrength;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float warmth) {
            float fLog;
            float fPow;
            float fLog2;
            if (warmth <= 0.0f) {
                warmth = 0.01f;
            }
            float f8 = (5000.0f / warmth) / 100.0f;
            if (f8 > 66.0f) {
                double d8 = f8 - 60.0f;
                fPow = ((float) Math.pow(d8, -0.13320475816726685d)) * 329.69873f;
                fLog = ((float) Math.pow(d8, 0.07551484555006027d)) * 288.12216f;
            } else {
                fLog = (((float) Math.log(f8)) * 99.4708f) - 161.11957f;
                fPow = 255.0f;
            }
            if (f8 < 66.0f) {
                fLog2 = f8 > 19.0f ? (((float) Math.log(f8 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f;
            } else {
                fLog2 = 255.0f;
            }
            float fMin = Math.min(255.0f, Math.max(fPow, 0.0f));
            float fMin2 = Math.min(255.0f, Math.max(fLog, 0.0f));
            float fMin3 = Math.min(255.0f, Math.max(fLog2, 0.0f));
            float fLog3 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float fLog4 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float fMin4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float fMin5 = Math.min(255.0f, Math.max(fLog3, 0.0f));
            float fMin6 = fMin3 / Math.min(255.0f, Math.max(fLog4, 0.0f));
            float[] fArr = this.f4408a;
            fArr[0] = fMin / fMin4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fMin2 / fMin5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = fMin6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        void c(ImageView view) {
            boolean z7;
            this.f4409b.reset();
            float f8 = this.f4412e;
            boolean z8 = true;
            if (f8 != 1.0f) {
                b(f8);
                this.f4409b.set(this.f4408a);
                z7 = true;
            } else {
                z7 = false;
            }
            float f9 = this.f4413f;
            if (f9 != 1.0f) {
                this.f4410c.setScale(f9, f9, f9, 1.0f);
                this.f4409b.postConcat(this.f4410c);
                z7 = true;
            }
            float f10 = this.f4414g;
            if (f10 != 1.0f) {
                d(f10);
                this.f4410c.set(this.f4408a);
                this.f4409b.postConcat(this.f4410c);
                z7 = true;
            }
            float f11 = this.f4411d;
            if (f11 != 1.0f) {
                a(f11);
                this.f4410c.set(this.f4408a);
                this.f4409b.postConcat(this.f4410c);
            } else {
                z8 = z7;
            }
            if (z8) {
                view.setColorFilter(new ColorMatrixColorFilter(this.f4409b));
            } else {
                view.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.f4390d = new c();
        this.f4391e = true;
        this.f4392f = null;
        this.f4393g = null;
        this.f4394h = 0.0f;
        this.f4395i = 0.0f;
        this.f4396j = Float.NaN;
        this.f4400n = new Drawable[2];
        this.f4402p = Float.NaN;
        this.f4403q = Float.NaN;
        this.f4404r = Float.NaN;
        this.f4405s = Float.NaN;
        e(context, null);
    }

    private void e(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f4392f = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f4394h = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f4391e));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f4402p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f4403q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f4405s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f4404r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f4393g = drawable;
            if (this.f4392f == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f4393g = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f4400n;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f4393g = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f4400n;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f4393g = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f4400n[1] = this.f4392f.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f4400n);
            this.f4401o = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f4394h * 255.0f));
            if (!this.f4391e) {
                this.f4401o.getDrawable(0).setAlpha((int) ((1.0f - this.f4394h) * 255.0f));
            }
            super.setImageDrawable(this.f4401o);
        }
    }

    private void f() {
        if (Float.isNaN(this.f4402p) && Float.isNaN(this.f4403q) && Float.isNaN(this.f4404r) && Float.isNaN(this.f4405s)) {
            return;
        }
        float f8 = Float.isNaN(this.f4402p) ? 0.0f : this.f4402p;
        float f9 = Float.isNaN(this.f4403q) ? 0.0f : this.f4403q;
        float f10 = Float.isNaN(this.f4404r) ? 1.0f : this.f4404r;
        float f11 = Float.isNaN(this.f4405s) ? 0.0f : this.f4405s;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f12 = f10 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f12, f12);
        float f13 = intrinsicWidth * f12;
        float f14 = f12 * intrinsicHeight;
        matrix.postTranslate((((f8 * (width - f13)) + width) - f13) * 0.5f, (((f9 * (height - f14)) + height) - f14) * 0.5f);
        matrix.postRotate(f11, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void g() {
        if (Float.isNaN(this.f4402p) && Float.isNaN(this.f4403q) && Float.isNaN(this.f4404r) && Float.isNaN(this.f4405s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            f();
        }
    }

    private void setOverlay(boolean overlay) {
        this.f4391e = overlay;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f4390d.f4411d;
    }

    public float getContrast() {
        return this.f4390d.f4413f;
    }

    public float getCrossfade() {
        return this.f4394h;
    }

    public float getImagePanX() {
        return this.f4402p;
    }

    public float getImagePanY() {
        return this.f4403q;
    }

    public float getImageRotate() {
        return this.f4405s;
    }

    public float getImageZoom() {
        return this.f4404r;
    }

    public float getRound() {
        return this.f4396j;
    }

    public float getRoundPercent() {
        return this.f4395i;
    }

    public float getSaturation() {
        return this.f4390d.f4412e;
    }

    public float getWarmth() {
        return this.f4390d.f4414g;
    }

    @Override // android.view.View
    public void layout(int l7, int t7, int r7, int b8) {
        super.layout(l7, t7, r7, b8);
        f();
    }

    public void setAltImageResource(int resId) {
        Drawable drawableMutate = e.a.b(getContext(), resId).mutate();
        this.f4392f = drawableMutate;
        Drawable[] drawableArr = this.f4400n;
        drawableArr[0] = this.f4393g;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f4400n);
        this.f4401o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f4394h);
    }

    public void setBrightness(float brightness) {
        c cVar = this.f4390d;
        cVar.f4411d = brightness;
        cVar.c(this);
    }

    public void setContrast(float contrast) {
        c cVar = this.f4390d;
        cVar.f4413f = contrast;
        cVar.c(this);
    }

    public void setCrossfade(float crossfade) {
        this.f4394h = crossfade;
        if (this.f4400n != null) {
            if (!this.f4391e) {
                this.f4401o.getDrawable(0).setAlpha((int) ((1.0f - this.f4394h) * 255.0f));
            }
            this.f4401o.getDrawable(1).setAlpha((int) (this.f4394h * 255.0f));
            super.setImageDrawable(this.f4401o);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f4392f == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f4393g = drawableMutate;
        Drawable[] drawableArr = this.f4400n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f4392f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f4400n);
        this.f4401o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f4394h);
    }

    public void setImagePanX(float pan) {
        this.f4402p = pan;
        g();
    }

    public void setImagePanY(float pan) {
        this.f4403q = pan;
        g();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        if (this.f4392f == null) {
            super.setImageResource(resId);
            return;
        }
        Drawable drawableMutate = e.a.b(getContext(), resId).mutate();
        this.f4393g = drawableMutate;
        Drawable[] drawableArr = this.f4400n;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f4392f;
        LayerDrawable layerDrawable = new LayerDrawable(this.f4400n);
        this.f4401o = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f4394h);
    }

    public void setImageRotate(float rotation) {
        this.f4405s = rotation;
        g();
    }

    public void setImageZoom(float zoom) {
        this.f4404r = zoom;
        g();
    }

    @t0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f4396j = round;
            float f8 = this.f4395i;
            this.f4395i = -1.0f;
            setRoundPercent(f8);
            return;
        }
        boolean z7 = this.f4396j != round;
        this.f4396j = round;
        if (round != 0.0f) {
            if (this.f4397k == null) {
                this.f4397k = new Path();
            }
            if (this.f4399m == null) {
                this.f4399m = new RectF();
            }
            if (this.f4398l == null) {
                b bVar = new b();
                this.f4398l = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f4399m.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f4397k.reset();
            Path path = this.f4397k;
            RectF rectF = this.f4399m;
            float f9 = this.f4396j;
            path.addRoundRect(rectF, f9, f9, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    @t0(21)
    public void setRoundPercent(float round) {
        boolean z7 = this.f4395i != round;
        this.f4395i = round;
        if (round != 0.0f) {
            if (this.f4397k == null) {
                this.f4397k = new Path();
            }
            if (this.f4399m == null) {
                this.f4399m = new RectF();
            }
            if (this.f4398l == null) {
                a aVar = new a();
                this.f4398l = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f4395i) / 2.0f;
            this.f4399m.set(0.0f, 0.0f, width, height);
            this.f4397k.reset();
            this.f4397k.addRoundRect(this.f4399m, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setSaturation(float saturation) {
        c cVar = this.f4390d;
        cVar.f4412e = saturation;
        cVar.c(this);
    }

    public void setWarmth(float warmth) {
        c cVar = this.f4390d;
        cVar.f4414g = warmth;
        cVar.c(this);
    }

    public ImageFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4390d = new c();
        this.f4391e = true;
        this.f4392f = null;
        this.f4393g = null;
        this.f4394h = 0.0f;
        this.f4395i = 0.0f;
        this.f4396j = Float.NaN;
        this.f4400n = new Drawable[2];
        this.f4402p = Float.NaN;
        this.f4403q = Float.NaN;
        this.f4404r = Float.NaN;
        this.f4405s = Float.NaN;
        e(context, attrs);
    }

    public ImageFilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4390d = new c();
        this.f4391e = true;
        this.f4392f = null;
        this.f4393g = null;
        this.f4394h = 0.0f;
        this.f4395i = 0.0f;
        this.f4396j = Float.NaN;
        this.f4400n = new Drawable[2];
        this.f4402p = Float.NaN;
        this.f4403q = Float.NaN;
        this.f4404r = Float.NaN;
        this.f4405s = Float.NaN;
        e(context, attrs);
    }
}
