package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
public class a extends j<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f14870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ComponentName f14871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RemoteViews f14872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f14873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14874h;

    public a(Context context, RemoteViews remoteViews, int i7, int i8, int i9, int... iArr) {
        super(i8, i9);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        }
        if (iArr == null) {
            throw new NullPointerException("WidgetIds can not be null!");
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        if (remoteViews == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        }
        this.f14873g = context;
        this.f14872f = remoteViews;
        this.f14874h = i7;
        this.f14870d = iArr;
        this.f14871e = null;
    }

    private void j() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f14873g);
        ComponentName componentName = this.f14871e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f14872f);
        } else {
            appWidgetManager.updateAppWidget(this.f14870d, this.f14872f);
        }
    }

    @Override // com.bumptech.glide.request.target.m
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(Bitmap bitmap, com.bumptech.glide.request.animation.e<? super Bitmap> eVar) {
        this.f14872f.setImageViewBitmap(this.f14874h, bitmap);
        j();
    }

    public a(Context context, RemoteViews remoteViews, int i7, int... iArr) {
        this(context, remoteViews, i7, Integer.MIN_VALUE, Integer.MIN_VALUE, iArr);
    }

    public a(Context context, RemoteViews remoteViews, int i7, int i8, int i9, ComponentName componentName) {
        super(i8, i9);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        }
        if (componentName == null) {
            throw new NullPointerException("ComponentName can not be null!");
        }
        if (remoteViews != null) {
            this.f14873g = context;
            this.f14872f = remoteViews;
            this.f14874h = i7;
            this.f14871e = componentName;
            this.f14870d = null;
            return;
        }
        throw new NullPointerException("RemoteViews object can not be null!");
    }

    public a(Context context, RemoteViews remoteViews, int i7, ComponentName componentName) {
        this(context, remoteViews, i7, Integer.MIN_VALUE, Integer.MIN_VALUE, componentName);
    }
}
