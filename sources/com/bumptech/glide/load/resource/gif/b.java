package com.bumptech.glide.load.resource.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bumptech.glide.load.resource.drawable.b implements f.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Paint f14623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f14624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f14625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.gifdecoder.a f14626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f14627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f14633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f14634n;

    static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f14635j = 119;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.bumptech.glide.gifdecoder.c f14636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte[] f14637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Context f14638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        w0.g<Bitmap> f14639d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14640e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f14641f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        com.bumptech.glide.gifdecoder.a.InterfaceC0161a f14642g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        com.bumptech.glide.load.engine.bitmap_recycle.c f14643h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Bitmap f14644i;

        public a(com.bumptech.glide.gifdecoder.c cVar, byte[] bArr, Context context, w0.g<Bitmap> gVar, int i7, int i8, com.bumptech.glide.gifdecoder.a.InterfaceC0161a interfaceC0161a, com.bumptech.glide.load.engine.bitmap_recycle.c cVar2, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.f14636a = cVar;
            this.f14637b = bArr;
            this.f14643h = cVar2;
            this.f14644i = bitmap;
            this.f14638c = context.getApplicationContext();
            this.f14639d = gVar;
            this.f14640e = i7;
            this.f14641f = i8;
            this.f14642g = interfaceC0161a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new b(this);
        }

        public a(a aVar) {
            if (aVar != null) {
                this.f14636a = aVar.f14636a;
                this.f14637b = aVar.f14637b;
                this.f14638c = aVar.f14638c;
                this.f14639d = aVar.f14639d;
                this.f14640e = aVar.f14640e;
                this.f14641f = aVar.f14641f;
                this.f14642g = aVar.f14642g;
                this.f14643h = aVar.f14643h;
                this.f14644i = aVar.f14644i;
            }
        }
    }

    public b(Context context, com.bumptech.glide.gifdecoder.a.InterfaceC0161a interfaceC0161a, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, w0.g<Bitmap> gVar, int i7, int i8, com.bumptech.glide.gifdecoder.c cVar2, byte[] bArr, Bitmap bitmap) {
        this(new a(cVar2, bArr, context, gVar, i7, i8, interfaceC0161a, cVar, bitmap));
    }

    private void n() {
        this.f14627g.a();
        invalidateSelf();
    }

    private void o() {
        this.f14632l = 0;
    }

    private void r() {
        if (this.f14626f.g() == 1) {
            invalidateSelf();
        } else {
            if (this.f14628h) {
                return;
            }
            this.f14628h = true;
            this.f14627g.g();
            invalidateSelf();
        }
    }

    private void s() {
        this.f14628h = false;
        this.f14627g.h();
    }

    @Override // com.bumptech.glide.load.resource.gif.f.c
    @TargetApi(11)
    public void a(int i7) {
        if (getCallback() == null) {
            stop();
            n();
            return;
        }
        invalidateSelf();
        if (i7 == this.f14626f.g() - 1) {
            this.f14632l++;
        }
        int i8 = this.f14633m;
        if (i8 == -1 || this.f14632l < i8) {
            return;
        }
        stop();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f14630j) {
            return;
        }
        if (this.f14634n) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f14624d);
            this.f14634n = false;
        }
        Bitmap bitmapB = this.f14627g.b();
        if (bitmapB == null) {
            bitmapB = this.f14625e.f14644i;
        }
        canvas.drawBitmap(bitmapB, (Rect) null, this.f14624d, this.f14623c);
    }

    @Override // com.bumptech.glide.load.resource.drawable.b
    public boolean e() {
        return true;
    }

    @Override // com.bumptech.glide.load.resource.drawable.b
    public void f(int i7) {
        if (i7 <= 0 && i7 != -1 && i7 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i7 != 0) {
            this.f14633m = i7;
        } else {
            int iP = this.f14626f.p();
            this.f14633m = iP != 0 ? iP : -1;
        }
    }

    public byte[] g() {
        return this.f14625e.f14637b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f14625e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f14625e.f14644i.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f14625e.f14644i.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public com.bumptech.glide.gifdecoder.a h() {
        return this.f14626f;
    }

    public Bitmap i() {
        return this.f14625e.f14644i;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f14628h;
    }

    public int j() {
        return this.f14626f.g();
    }

    public w0.g<Bitmap> k() {
        return this.f14625e.f14639d;
    }

    boolean l() {
        return this.f14630j;
    }

    public void m() {
        this.f14630j = true;
        a aVar = this.f14625e;
        aVar.f14643h.b(aVar.f14644i);
        this.f14627g.a();
        this.f14627g.h();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f14634n = true;
    }

    public void p(w0.g<Bitmap> gVar, Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        if (gVar == null) {
            throw new NullPointerException("The frame transformation must not be null");
        }
        a aVar = this.f14625e;
        aVar.f14639d = gVar;
        aVar.f14644i = bitmap;
        this.f14627g.f(gVar);
    }

    void q(boolean z7) {
        this.f14628h = z7;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        this.f14623c.setAlpha(i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14623c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        this.f14631k = z7;
        if (!z7) {
            s();
        } else if (this.f14629i) {
            r();
        }
        return super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f14629i = true;
        o();
        if (this.f14631k) {
            r();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f14629i = false;
        s();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public b(b bVar, Bitmap bitmap, w0.g<Bitmap> gVar) {
        a aVar = bVar.f14625e;
        this(new a(aVar.f14636a, aVar.f14637b, aVar.f14638c, gVar, aVar.f14640e, aVar.f14641f, aVar.f14642g, aVar.f14643h, bitmap));
    }

    b(a aVar) {
        this.f14624d = new Rect();
        this.f14631k = true;
        this.f14633m = -1;
        if (aVar != null) {
            this.f14625e = aVar;
            com.bumptech.glide.gifdecoder.a aVar2 = new com.bumptech.glide.gifdecoder.a(aVar.f14642g);
            this.f14626f = aVar2;
            this.f14623c = new Paint();
            aVar2.x(aVar.f14636a, aVar.f14637b);
            f fVar = new f(aVar.f14638c, this, aVar2, aVar.f14640e, aVar.f14641f);
            this.f14627g = fVar;
            fVar.f(aVar.f14639d);
            return;
        }
        throw new NullPointerException("GifState must not be null");
    }

    b(com.bumptech.glide.gifdecoder.a aVar, f fVar, Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Paint paint) {
        this.f14624d = new Rect();
        this.f14631k = true;
        this.f14633m = -1;
        this.f14626f = aVar;
        this.f14627g = fVar;
        a aVar2 = new a(null);
        this.f14625e = aVar2;
        this.f14623c = paint;
        aVar2.f14643h = cVar;
        aVar2.f14644i = bitmap;
    }
}
