package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import c.o0;
import com.google.android.gms.internal.base.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f15615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f15616b;

    public h(Uri uri, int i7) {
        this.f15616b = 0;
        this.f15615a = new e(uri);
        this.f15616b = i7;
    }

    protected abstract void a(@o0 Drawable drawable, boolean z7, boolean z8, boolean z9);

    final void b(Context context, j jVar, boolean z7) {
        int i7 = this.f15616b;
        a(i7 != 0 ? context.getResources().getDrawable(i7) : null, z7, false, false);
    }

    final void c(Context context, Bitmap bitmap, boolean z7) {
        com.google.android.gms.common.internal.d.c(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
