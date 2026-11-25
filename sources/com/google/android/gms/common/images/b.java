package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import c.o0;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f15603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final ParcelFileDescriptor f15604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ImageManager f15605c;

    public b(ImageManager imageManager, @o0 Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f15605c = imageManager;
        this.f15603a = uri;
        this.f15604b = parcelFileDescriptor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.common.internal.d.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f15604b;
        Bitmap bitmapDecodeFileDescriptor = null;
        boolean z7 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmapDecodeFileDescriptor = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e8) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.f15603a)), e8);
                z7 = true;
            }
            try {
                this.f15604b.close();
            } catch (IOException e9) {
                Log.e("ImageManager", "closed failed", e9);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.f15605c;
        imageManager.f15588b.post(new d(imageManager, this.f15603a, bitmapDecodeFileDescriptor, z7, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.f15603a)));
        }
    }
}
