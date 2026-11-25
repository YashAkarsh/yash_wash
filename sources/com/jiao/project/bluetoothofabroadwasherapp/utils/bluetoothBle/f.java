package com.jiao.project.bluetoothofabroadwasherapp.utils.bluetoothBle;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static t3.c a(byte[] bArr) {
        if (bArr != null && bArr.length >= 9) {
            byte b8 = bArr[9];
            if (b8 == 3) {
                return new w3.c(bArr);
            }
            if (b8 == 2) {
                if (com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[2]) == 26) {
                    return new w3.e(bArr);
                }
                if (com.haier.hailicommontlib.mvp.model.utils.c.e(bArr[2]) == 28) {
                    return new w3.b(bArr);
                }
            }
        }
        return new w3.d();
    }
}
