package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class i extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f16079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h f16081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Drawable f16082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Drawable f16083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f16084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f16085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f16086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f16087o;

    public i(@o0 Drawable drawable, @o0 Drawable drawable2) {
        this(null);
        drawable = drawable == null ? g.f16069a : drawable;
        this.f16082j = drawable;
        drawable.setCallback(this);
        h hVar = this.f16081i;
        hVar.f16072b = drawable.getChangingConfigurations() | hVar.f16072b;
        drawable2 = drawable2 == null ? g.f16069a : drawable2;
        this.f16083k = drawable2;
        drawable2.setCallback(this);
        h hVar2 = this.f16081i;
        hVar2.f16072b = drawable2.getChangingConfigurations() | hVar2.f16072b;
    }

    public final Drawable a() {
        return this.f16083k;
    }

    public final void b(int i7) {
        this.f16075c = this.f16076d;
        this.f16078f = 0;
        this.f16077e = androidx.recyclerview.widget.m.f.f9644c;
        this.f16073a = 1;
        invalidateSelf();
    }

    public final boolean c() {
        if (!this.f16084l) {
            boolean z7 = false;
            if (this.f16082j.getConstantState() != null && this.f16083k.getConstantState() != null) {
                z7 = true;
            }
            this.f16085m = z7;
            this.f16084l = true;
        }
        return this.f16085m;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i7;
        int i8 = this.f16073a;
        int i9 = 0;
        boolean z7 = true;
        if (i8 == 1) {
            this.f16074b = SystemClock.uptimeMillis();
            this.f16073a = 2;
            z7 = false;
        } else if (i8 == 2 && this.f16074b >= 0) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f16074b) / this.f16077e;
            z7 = fUptimeMillis >= 1.0f;
            if (z7) {
                this.f16073a = 0;
            }
            this.f16078f = (int) ((this.f16075c * Math.min(fUptimeMillis, 1.0f)) + 0.0f);
        }
        int i10 = this.f16078f;
        boolean z8 = this.f16079g;
        Drawable drawable = this.f16082j;
        Drawable drawable2 = this.f16083k;
        if (!z7) {
            if (z8) {
                drawable.setAlpha(this.f16076d - i10);
            }
            drawable.draw(canvas);
            if (z8) {
                drawable.setAlpha(this.f16076d);
            }
            if (i10 > 0) {
                drawable2.setAlpha(i10);
                drawable2.draw(canvas);
                drawable2.setAlpha(this.f16076d);
            }
            invalidateSelf();
            return;
        }
        if (z8) {
            if (i10 == 0) {
            }
            i7 = this.f16076d;
            if (i10 == i7) {
                drawable2.setAlpha(i7);
                drawable2.draw(canvas);
            }
        }
        i9 = i10;
        drawable.draw(canvas);
        i10 = i9;
        i7 = this.f16076d;
        if (i10 == i7) {
            drawable2.setAlpha(i7);
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        h hVar = this.f16081i;
        return changingConfigurations | hVar.f16071a | hVar.f16072b;
    }

    @Override // android.graphics.drawable.Drawable
    @o0
    public final Drawable.ConstantState getConstantState() {
        if (!c()) {
            return null;
        }
        this.f16081i.f16071a = getChangingConfigurations();
        return this.f16081i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f16082j.getIntrinsicHeight(), this.f16083k.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f16082j.getIntrinsicWidth(), this.f16083k.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.f16086n) {
            this.f16087o = Drawable.resolveOpacity(this.f16082j.getOpacity(), this.f16083k.getOpacity());
            this.f16086n = true;
        }
        return this.f16087o;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f16080h && super.mutate() == this) {
            if (!c()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.f16082j.mutate();
            this.f16083k.mutate();
            this.f16080h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        this.f16082j.setBounds(rect);
        this.f16083k.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j7) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i7) {
        if (this.f16078f == this.f16076d) {
            this.f16078f = i7;
        }
        this.f16076d = i7;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@o0 ColorFilter colorFilter) {
        this.f16082j.setColorFilter(colorFilter);
        this.f16083k.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    i(@o0 h hVar) {
        this.f16073a = 0;
        this.f16076d = 255;
        this.f16078f = 0;
        this.f16079g = true;
        this.f16081i = new h(hVar);
    }
}
