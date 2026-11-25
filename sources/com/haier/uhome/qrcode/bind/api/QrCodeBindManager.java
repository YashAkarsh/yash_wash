package com.haier.uhome.qrcode.bind.api;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class QrCodeBindManager {
    private f mQrCodeBindImpl;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static QrCodeBindManager f29563a = new QrCodeBindManager();

        private a() {
        }
    }

    public static QrCodeBindManager getInstance() {
        return a.f29563a;
    }

    public void getQrCode(h hVar, com.haier.uhome.qrcode.bind.api.a.c<i> cVar) {
        this.mQrCodeBindImpl.a(hVar, cVar);
    }

    public void init(Context context) {
        this.mQrCodeBindImpl.a(context);
    }

    public void pollQrCodeStage(j jVar, com.haier.uhome.qrcode.bind.api.a.c<k> cVar) {
        this.mQrCodeBindImpl.b(jVar, cVar);
    }

    public void qrCodeStage(j jVar, com.haier.uhome.qrcode.bind.api.a.c<k> cVar) {
        this.mQrCodeBindImpl.a(jVar, cVar);
    }

    public void refreshToken(m mVar, com.haier.uhome.qrcode.bind.api.a.c<n> cVar) {
        this.mQrCodeBindImpl.a(mVar, cVar);
    }

    private QrCodeBindManager() {
        this.mQrCodeBindImpl = f.a();
    }
}
