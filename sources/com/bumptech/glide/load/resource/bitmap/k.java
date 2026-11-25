package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public class k extends com.bumptech.glide.load.resource.drawable.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f14544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f14549h;

    static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f14550d = 6;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Paint f14551e = new Paint(6);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f14552f = 119;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bitmap f14553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f14554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Paint f14555c;

        public a(Bitmap bitmap) {
            this.f14555c = f14551e;
            this.f14553a = bitmap;
        }

        void a() {
            if (f14551e == this.f14555c) {
                this.f14555c = new Paint(6);
            }
        }

        void b(int i7) {
            a();
            this.f14555c.setAlpha(i7);
        }

        void c(ColorFilter colorFilter) {
            a();
            this.f14555c.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new k((Resources) null, this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new k(resources, this);
        }

        a(a aVar) {
            this(aVar.f14553a);
            this.f14554b = aVar.f14554b;
        }
    }

    public k(Resources resources, Bitmap bitmap) {
        this(resources, new a(bitmap));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f14547f) {
            Gravity.apply(119, this.f14545d, this.f14546e, getBounds(), this.f14544c);
            this.f14547f = false;
        }
        a aVar = this.f14549h;
        canvas.drawBitmap(aVar.f14553a, (Rect) null, this.f14544c, aVar.f14555c);
    }

    @Override // com.bumptech.glide.load.resource.drawable.b
    public boolean e() {
        return false;
    }

    @Override // com.bumptech.glide.load.resource.drawable.b
    public void f(int i7) {
    }

    public Bitmap g() {
        return this.f14549h.f14553a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f14549h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14546e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14545d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f14549h.f14553a;
        return (bitmap == null || bitmap.hasAlpha() || this.f14549h.f14555c.getAlpha() < 255) ? -3 : -1;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f14548g && super.mutate() == this) {
            this.f14549h = new a(this.f14549h);
            this.f14548g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f14547f = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        if (this.f14549h.f14555c.getAlpha() != i7) {
            this.f14549h.b(i7);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14549h.c(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
    }

    k(Resources resources, a aVar) {
        int i7;
        this.f14544c = new Rect();
        if (aVar == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        this.f14549h = aVar;
        if (resources != null) {
            i7 = resources.getDisplayMetrics().densityDpi;
            i7 = i7 == 0 ? 160 : i7;
            aVar.f14554b = i7;
        } else {
            i7 = aVar.f14554b;
        }
        this.f14545d = aVar.f14553a.getScaledWidth(i7);
        this.f14546e = aVar.f14553a.getScaledHeight(i7);
    }
}
