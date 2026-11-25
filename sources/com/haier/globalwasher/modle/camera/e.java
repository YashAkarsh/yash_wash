package com.haier.globalwasher.modle.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Camera.PreviewCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f24388d = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f24389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f24390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24391c;

    public e(c cVar) {
        this.f24389a = cVar;
    }

    public void a(Handler handler, int i7) {
        this.f24390b = handler;
        this.f24391c = i7;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point pointB = this.f24389a.b();
        Handler handler = this.f24390b;
        if (pointB == null || handler == null) {
            Log.d(f24388d, "Got preview callback, but no handler or resolution available");
        } else {
            handler.obtainMessage(this.f24391c, pointB.x, pointB.y, bArr).sendToTarget();
            this.f24390b = null;
        }
    }
}
