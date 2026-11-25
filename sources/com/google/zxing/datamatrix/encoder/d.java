package com.google.zxing.datamatrix.encoder;

import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes2.dex */
final class d extends k {
    d() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.k
    public int c(int i7) {
        return i7 <= 8 ? Constants.ACTION_DELAY_PASSWORD_FOUND : Constants.ACTION_START_NB_OTP;
    }

    @Override // com.google.zxing.datamatrix.encoder.k
    public int g() {
        return 10;
    }
}
