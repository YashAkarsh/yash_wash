package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager.ImageReceiver;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f15606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImageManager f15607b;

    public c(ImageManager imageManager, h hVar) {
        this.f15607b = imageManager;
        this.f15606a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.common.internal.d.a("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f15607b.f15591e.get(this.f15606a);
        if (imageReceiver != null) {
            this.f15607b.f15591e.remove(this.f15606a);
            imageReceiver.d(this.f15606a);
        }
        h hVar = this.f15606a;
        e eVar = hVar.f15615a;
        Uri uri = eVar.f15612a;
        if (uri == null) {
            ImageManager imageManager = this.f15607b;
            hVar.b(imageManager.f15587a, imageManager.f15590d, true);
            return;
        }
        Long l7 = (Long) this.f15607b.f15593g.get(uri);
        if (l7 != null) {
            if (SystemClock.elapsedRealtime() - l7.longValue() < DateUtils.MILLIS_PER_HOUR) {
                h hVar2 = this.f15606a;
                ImageManager imageManager2 = this.f15607b;
                hVar2.b(imageManager2.f15587a, imageManager2.f15590d, true);
                return;
            }
            this.f15607b.f15593g.remove(eVar.f15612a);
        }
        this.f15606a.a(null, false, true, false);
        ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) this.f15607b.f15592f.get(eVar.f15612a);
        if (imageReceiver2 == null) {
            imageReceiver2 = this.f15607b.new ImageReceiver(eVar.f15612a);
            this.f15607b.f15592f.put(eVar.f15612a, imageReceiver2);
        }
        imageReceiver2.b(this.f15606a);
        h hVar3 = this.f15606a;
        if (!(hVar3 instanceof g)) {
            this.f15607b.f15591e.put(hVar3, imageReceiver2);
        }
        synchronized (ImageManager.f15584h) {
            if (!ImageManager.f15585i.contains(eVar.f15612a)) {
                ImageManager.f15585i.add(eVar.f15612a);
                imageReceiver2.e();
            }
        }
    }
}
