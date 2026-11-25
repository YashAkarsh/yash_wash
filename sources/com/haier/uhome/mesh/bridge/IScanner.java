package com.haier.uhome.mesh.bridge;

import com.haier.uhome.usdk.base.api.o;

/* JADX INFO: loaded from: classes2.dex */
public interface IScanner {
    void registerCallback(IScannerCallback iScannerCallback);

    void scanProv(o oVar);

    void scanProxy(o oVar);

    void stopScanProv(o oVar);

    void stopScanProxy(o oVar);

    void unRegisterCallback(IScannerCallback iScannerCallback);
}
