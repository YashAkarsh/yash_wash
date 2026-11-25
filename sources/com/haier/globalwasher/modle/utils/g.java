package com.haier.globalwasher.modle.utils;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.haier.globalwasher.R;
import com.haier.globalwasher.view.activity.CaptureActivity;

/* JADX INFO: loaded from: classes2.dex */
public class g extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CaptureActivity f24591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j2.c f24592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.haier.globalwasher.modle.camera.d f24593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f24594d;

    private enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public g(CaptureActivity captureActivity, com.haier.globalwasher.modle.camera.d dVar, int i7) {
        this.f24591a = captureActivity;
        j2.c cVar = new j2.c(captureActivity, i7);
        this.f24592b = cVar;
        cVar.start();
        this.f24594d = a.SUCCESS;
        this.f24593c = dVar;
        dVar.k();
        b();
    }

    private void b() {
        if (this.f24594d == a.SUCCESS) {
            this.f24594d = a.PREVIEW;
            this.f24593c.i(this.f24592b.a(), R.id.decode);
        }
    }

    public void a() {
        this.f24594d = a.DONE;
        this.f24593c.l();
        Message.obtain(this.f24592b.a(), R.id.quit).sendToTarget();
        try {
            this.f24592b.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i7 = message.what;
        if (i7 == R.id.restart_preview) {
            b();
            return;
        }
        if (i7 == R.id.decode_succeeded) {
            this.f24594d = a.SUCCESS;
            this.f24591a.t0((com.google.zxing.r) message.obj, message.getData());
        } else if (i7 == R.id.decode_failed) {
            this.f24594d = a.PREVIEW;
            this.f24593c.i(this.f24592b.a(), R.id.decode);
        } else if (i7 == R.id.return_scan_result) {
            this.f24591a.setResult(-1, (Intent) message.obj);
            this.f24591a.finish();
        }
    }
}
