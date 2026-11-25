package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f32761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f32762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f32763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f32764d;

    public b(int i7) {
        this(i7, true, true, true);
    }

    public static void b(View view, int i7) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i7);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            view.startAnimation(alphaAnimation);
        }
    }

    @Override // com.nostra13.universalimageloader.core.display.a
    public void a(Bitmap bitmap, com.nostra13.universalimageloader.core.imageaware.a aVar, f fVar) {
        aVar.h(bitmap);
        if ((this.f32762b && fVar == f.NETWORK) || ((this.f32763c && fVar == f.DISC_CACHE) || (this.f32764d && fVar == f.MEMORY_CACHE))) {
            b(aVar.d(), this.f32761a);
        }
    }

    public b(int i7, boolean z7, boolean z8, boolean z9) {
        this.f32761a = i7;
        this.f32762b = z7;
        this.f32763c = z8;
        this.f32764d = z9;
    }
}
