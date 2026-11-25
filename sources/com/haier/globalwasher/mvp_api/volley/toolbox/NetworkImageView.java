package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f24950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l.g f24951e;

    class a implements l.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f24952a;

        /* JADX INFO: renamed from: com.haier.globalwasher.mvp_api.volley.toolbox.NetworkImageView$a$a, reason: collision with other inner class name */
        class RunnableC0326a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ l.g f24954a;

            RunnableC0326a(l.g gVar) {
                this.f24954a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.f24954a, false);
            }
        }

        a(boolean z7) {
            this.f24952a = z7;
        }

        @Override // com.haier.globalwasher.mvp_api.volley.toolbox.l.h
        public void a(l.g gVar, boolean z7) {
            if (z7 && this.f24952a) {
                NetworkImageView.this.post(new RunnableC0326a(gVar));
                return;
            }
            if (gVar.d() != null) {
                NetworkImageView.this.setImageBitmap(gVar.d());
            } else if (NetworkImageView.this.f24948b != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f24948b);
            }
        }

        @Override // com.haier.globalwasher.mvp_api.volley.p.a
        public void c(com.haier.globalwasher.mvp_api.volley.u uVar) {
            if (NetworkImageView.this.f24949c != 0) {
                NetworkImageView networkImageView = NetworkImageView.this;
                networkImageView.setImageResource(networkImageView.f24949c);
            }
        }
    }

    public NetworkImageView(Context context) {
        this(context, null);
    }

    private void d() {
        int i7 = this.f24948b;
        if (i7 != 0) {
            setImageResource(i7);
        } else {
            setImageBitmap(null);
        }
    }

    void c(boolean z7) {
        boolean z8;
        boolean z9;
        int width = getWidth();
        int height = getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        if (getLayoutParams() != null) {
            z8 = getLayoutParams().width == -2;
            z9 = getLayoutParams().height == -2;
        } else {
            z8 = false;
            z9 = false;
        }
        boolean z10 = z8 && z9;
        if (width == 0 && height == 0 && !z10) {
            return;
        }
        if (TextUtils.isEmpty(this.f24947a)) {
            l.g gVar = this.f24951e;
            if (gVar != null) {
                gVar.c();
                this.f24951e = null;
            }
            d();
            return;
        }
        l.g gVar2 = this.f24951e;
        if (gVar2 != null && gVar2.e() != null) {
            if (this.f24951e.e().equals(this.f24947a)) {
                return;
            }
            this.f24951e.c();
            d();
        }
        if (z8) {
            width = 0;
        }
        this.f24951e = this.f24950d.g(this.f24947a, new a(z7), width, z9 ? 0 : height, scaleType);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public String getImageURL() {
        return this.f24947a;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        l.g gVar = this.f24951e;
        if (gVar != null) {
            gVar.c();
            setImageBitmap(null);
            this.f24951e = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        c(true);
    }

    public void setDefaultImageResId(int i7) {
        this.f24948b = i7;
    }

    public void setErrorImageResId(int i7) {
        this.f24949c = i7;
    }

    public void setImageUrl(String str, l lVar) {
        this.f24947a = str;
        this.f24950d = lVar;
        c(false);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetworkImageView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
    }
}
