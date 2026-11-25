package com.haier.uhome.usdk.api;

import com.haier.uhome.control.cloud.api.FOTAStatusInfo;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k2 implements com.haier.uhome.control.cloud.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uSDKDevice f30608a;

    public /* synthetic */ k2(uSDKDevice usdkdevice) {
        this.f30608a = usdkdevice;
    }

    @Override // com.haier.uhome.control.cloud.api.g
    public final void onFOTAStatus(FOTAStatusInfo fOTAStatusInfo) {
        this.f30608a.onBoardOtaStatusChanged(fOTAStatusInfo);
    }
}
