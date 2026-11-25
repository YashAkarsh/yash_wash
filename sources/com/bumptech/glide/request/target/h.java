package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
public class h extends j<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RemoteViews f14879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f14880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Notification f14882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14883h;

    public h(Context context, RemoteViews remoteViews, int i7, Notification notification, int i8) {
        this(context, remoteViews, i7, Integer.MIN_VALUE, Integer.MIN_VALUE, notification, i8);
    }

    private void j() {
        ((NotificationManager) this.f14880e.getSystemService("notification")).notify(this.f14881f, this.f14882g);
    }

    @Override // com.bumptech.glide.request.target.m
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(Bitmap bitmap, com.bumptech.glide.request.animation.e<? super Bitmap> eVar) {
        this.f14879d.setImageViewBitmap(this.f14883h, bitmap);
        j();
    }

    public h(Context context, RemoteViews remoteViews, int i7, int i8, int i9, Notification notification, int i10) {
        super(i8, i9);
        if (context == null) {
            throw new NullPointerException("Context must not be null!");
        }
        if (notification == null) {
            throw new NullPointerException("Notification object can not be null!");
        }
        if (remoteViews == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        }
        this.f14880e = context;
        this.f14883h = i7;
        this.f14882g = notification;
        this.f14881f = i10;
        this.f14879d = remoteViews;
    }
}
