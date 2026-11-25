package com.haier.uhome.usdk.api;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.cloud.api.DeviceFOTAInfo;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
final class i {
    i() {
    }

    void a(com.haier.uhome.control.cloud.api.c cVar, DeviceFOTAInfo deviceFOTAInfo, ICallback<Void> iCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        if (deviceFOTAInfo == null || TextUtils.isEmpty(deviceFOTAInfo.b()) || TextUtils.isEmpty(deviceFOTAInfo.a())) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (cVar == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
            return;
        }
        if (cVar.n() != DeviceStatus.STATUS_CONNECTED && cVar.n() != DeviceStatus.STATUS_READY) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
        } else if (com.haier.uhome.usdk.base.api.e.f(cVar.ai())) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_SUPPORT_SUCH_DEVICE_OTA.toError());
        } else {
            cVar.a(deviceFOTAInfo, iCallback);
        }
    }
}
