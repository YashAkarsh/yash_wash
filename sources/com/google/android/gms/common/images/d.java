package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import c.o0;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f15608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final Bitmap f15609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CountDownLatch f15610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImageManager f15611d;

    public d(ImageManager imageManager, @o0 Uri uri, Bitmap bitmap, boolean z7, CountDownLatch countDownLatch) {
        this.f15611d = imageManager;
        this.f15608a = uri;
        this.f15609b = bitmap;
        this.f15610c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.common.internal.d.a("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.f15609b;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f15611d.f15592f.remove(this.f15608a);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.f15595b;
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                h hVar = (h) arrayList.get(i7);
                Bitmap bitmap2 = this.f15609b;
                if (bitmap2 == null || bitmap == null) {
                    this.f15611d.f15593g.put(this.f15608a, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.f15611d;
                    hVar.b(imageManager.f15587a, imageManager.f15590d, false);
                } else {
                    hVar.c(this.f15611d.f15587a, bitmap2, false);
                }
                if (!(hVar instanceof g)) {
                    this.f15611d.f15591e.remove(hVar);
                }
            }
        }
        this.f15610c.countDown();
        synchronized (ImageManager.f15584h) {
            ImageManager.f15585i.remove(this.f15608a);
        }
    }
}
