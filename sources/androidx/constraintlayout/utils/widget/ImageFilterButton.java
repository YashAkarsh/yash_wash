package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.R;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ImageFilterView.c f4372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f4373e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f4374f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f4375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Path f4376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ViewOutlineProvider f4377i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    RectF f4378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Drawable[] f4379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    LayerDrawable f4380l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4381m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Drawable f4382n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Drawable f4383o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f4384p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f4385q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f4386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f4387s;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterButton.this.f4374f) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f4375g);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.f4372d = new ImageFilterView.c();
        this.f4373e = 0.0f;
        this.f4374f = 0.0f;
        this.f4375g = Float.NaN;
        this.f4379k = new Drawable[2];
        this.f4381m = true;
        this.f4382n = null;
        this.f4383o = null;
        this.f4384p = Float.NaN;
        this.f4385q = Float.NaN;
        this.f4386r = Float.NaN;
        this.f4387s = Float.NaN;
        c(context, null);
    }

    private void c(Context context, AttributeSet attrs) {
        setPadding(0, 0, 0, 0);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            this.f4382n = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f4373e = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(typedArrayObtainStyledAttributes.getBoolean(index, this.f4381m));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(typedArrayObtainStyledAttributes.getFloat(index, this.f4384p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(typedArrayObtainStyledAttributes.getFloat(index, this.f4385q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(typedArrayObtainStyledAttributes.getFloat(index, this.f4387s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(typedArrayObtainStyledAttributes.getFloat(index, this.f4386r));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f4383o = drawable;
            if (this.f4382n == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.f4383o = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f4379k;
                    Drawable drawableMutate = drawable2.mutate();
                    this.f4383o = drawableMutate;
                    drawableArr[0] = drawableMutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f4379k;
            Drawable drawableMutate2 = getDrawable().mutate();
            this.f4383o = drawableMutate2;
            drawableArr2[0] = drawableMutate2;
            this.f4379k[1] = this.f4382n.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f4379k);
            this.f4380l = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f4373e * 255.0f));
            if (!this.f4381m) {
                this.f4380l.getDrawable(0).setAlpha((int) ((1.0f - this.f4373e) * 255.0f));
            }
            super.setImageDrawable(this.f4380l);
        }
    }

    private void d() {
        if (Float.isNaN(this.f4384p) && Float.isNaN(this.f4385q) && Float.isNaN(this.f4386r) && Float.isNaN(this.f4387s)) {
            return;
        }
        float f8 = Float.isNaN(this.f4384p) ? 0.0f : this.f4384p;
        float f9 = Float.isNaN(this.f4385q) ? 0.0f : this.f4385q;
        float f10 = Float.isNaN(this.f4386r) ? 1.0f : this.f4386r;
        float f11 = Float.isNaN(this.f4387s) ? 0.0f : this.f4387s;
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

    private void e() {
        if (Float.isNaN(this.f4384p) && Float.isNaN(this.f4385q) && Float.isNaN(this.f4386r) && Float.isNaN(this.f4387s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            d();
        }
    }

    private void setOverlay(boolean overlay) {
        this.f4381m = overlay;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f4372d.f4413f;
    }

    public float getCrossfade() {
        return this.f4373e;
    }

    public float getImagePanX() {
        return this.f4384p;
    }

    public float getImagePanY() {
        return this.f4385q;
    }

    public float getImageRotate() {
        return this.f4387s;
    }

    public float getImageZoom() {
        return this.f4386r;
    }

    public float getRound() {
        return this.f4375g;
    }

    public float getRoundPercent() {
        return this.f4374f;
    }

    public float getSaturation() {
        return this.f4372d.f4412e;
    }

    public float getWarmth() {
        return this.f4372d.f4414g;
    }

    @Override // android.view.View
    public void layout(int l7, int t7, int r7, int b8) {
        super.layout(l7, t7, r7, b8);
        d();
    }

    public void setAltImageResource(int resId) {
        Drawable drawableMutate = e.a.b(getContext(), resId).mutate();
        this.f4382n = drawableMutate;
        Drawable[] drawableArr = this.f4379k;
        drawableArr[0] = this.f4383o;
        drawableArr[1] = drawableMutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f4379k);
        this.f4380l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f4373e);
    }

    public void setBrightness(float brightness) {
        ImageFilterView.c cVar = this.f4372d;
        cVar.f4411d = brightness;
        cVar.c(this);
    }

    public void setContrast(float contrast) {
        ImageFilterView.c cVar = this.f4372d;
        cVar.f4413f = contrast;
        cVar.c(this);
    }

    public void setCrossfade(float crossfade) {
        this.f4373e = crossfade;
        if (this.f4379k != null) {
            if (!this.f4381m) {
                this.f4380l.getDrawable(0).setAlpha((int) ((1.0f - this.f4373e) * 255.0f));
            }
            this.f4380l.getDrawable(1).setAlpha((int) (this.f4373e * 255.0f));
            super.setImageDrawable(this.f4380l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f4382n == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.f4383o = drawableMutate;
        Drawable[] drawableArr = this.f4379k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f4382n;
        LayerDrawable layerDrawable = new LayerDrawable(this.f4379k);
        this.f4380l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f4373e);
    }

    public void setImagePanX(float pan) {
        this.f4384p = pan;
        e();
    }

    public void setImagePanY(float pan) {
        this.f4385q = pan;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int resId) {
        if (this.f4382n == null) {
            super.setImageResource(resId);
            return;
        }
        Drawable drawableMutate = e.a.b(getContext(), resId).mutate();
        this.f4383o = drawableMutate;
        Drawable[] drawableArr = this.f4379k;
        drawableArr[0] = drawableMutate;
        drawableArr[1] = this.f4382n;
        LayerDrawable layerDrawable = new LayerDrawable(this.f4379k);
        this.f4380l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f4373e);
    }

    public void setImageRotate(float rotation) {
        this.f4387s = rotation;
        e();
    }

    public void setImageZoom(float zoom) {
        this.f4386r = zoom;
        e();
    }

    @t0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f4375g = round;
            float f8 = this.f4374f;
            this.f4374f = -1.0f;
            setRoundPercent(f8);
            return;
        }
        boolean z7 = this.f4375g != round;
        this.f4375g = round;
        if (round != 0.0f) {
            if (this.f4376h == null) {
                this.f4376h = new Path();
            }
            if (this.f4378j == null) {
                this.f4378j = new RectF();
            }
            if (this.f4377i == null) {
                b bVar = new b();
                this.f4377i = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f4378j.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f4376h.reset();
            Path path = this.f4376h;
            RectF rectF = this.f4378j;
            float f9 = this.f4375g;
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
        boolean z7 = this.f4374f != round;
        this.f4374f = round;
        if (round != 0.0f) {
            if (this.f4376h == null) {
                this.f4376h = new Path();
            }
            if (this.f4378j == null) {
                this.f4378j = new RectF();
            }
            if (this.f4377i == null) {
                a aVar = new a();
                this.f4377i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f4374f) / 2.0f;
            this.f4378j.set(0.0f, 0.0f, width, height);
            this.f4376h.reset();
            this.f4376h.addRoundRect(this.f4378j, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z7) {
            invalidateOutline();
        }
    }

    public void setSaturation(float saturation) {
        ImageFilterView.c cVar = this.f4372d;
        cVar.f4412e = saturation;
        cVar.c(this);
    }

    public void setWarmth(float warmth) {
        ImageFilterView.c cVar = this.f4372d;
        cVar.f4414g = warmth;
        cVar.c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4372d = new ImageFilterView.c();
        this.f4373e = 0.0f;
        this.f4374f = 0.0f;
        this.f4375g = Float.NaN;
        this.f4379k = new Drawable[2];
        this.f4381m = true;
        this.f4382n = null;
        this.f4383o = null;
        this.f4384p = Float.NaN;
        this.f4385q = Float.NaN;
        this.f4386r = Float.NaN;
        this.f4387s = Float.NaN;
        c(context, attrs);
    }

    public ImageFilterButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4372d = new ImageFilterView.c();
        this.f4373e = 0.0f;
        this.f4374f = 0.0f;
        this.f4375g = Float.NaN;
        this.f4379k = new Drawable[2];
        this.f4381m = true;
        this.f4382n = null;
        this.f4383o = null;
        this.f4384p = Float.NaN;
        this.f4385q = Float.NaN;
        this.f4386r = Float.NaN;
        this.f4387s = Float.NaN;
        c(context, attrs);
    }
}
