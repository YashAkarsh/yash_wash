package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigStatus;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
class q extends p {
    q(BaseBindInfo baseBindInfo) {
        super(baseBindInfo);
    }

    @Override // com.haier.uhome.usdk.bind.p, com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        if (!usdkerrorG.a(ErrorConst.RET_USDK_OK)) {
            return usdkerrorG;
        }
        BaseBindInfo baseBindInfo = this.f31610e;
        if (!(baseBindInfo instanceof NewDirectLinkManualConfirmBindInfo)) {
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("mBindInfo not DirectLinkVerificationCodeBindInfo");
            return error;
        }
        ConfigurableDevice configurableDevice = ((NewDirectLinkManualConfirmBindInfo) baseBindInfo).getConfigurableDevice();
        if (configurableDevice == null) {
            uSDKError error2 = ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
            error2.a("device not found");
            return error2;
        }
        if (configurableDevice.getConfigStatus() != ConfigStatus.CONFIG_ABLE) {
            uSDKError error3 = ErrorConst.ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE.toError();
            error3.a("device can not config~");
            return error3;
        }
        if (com.haier.uhome.search.service.i.a().a(configurableDevice.getDevId()) != null) {
            return usdkerrorG;
        }
        uSDKError error4 = ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        error4.a("device not found in  ConfigurableDevices ");
        return error4;
    }

    @Override // com.haier.uhome.usdk.bind.p
    protected ConfigurableDevice j() {
        return ((NewDirectLinkManualConfirmBindInfo) this.f31610e).getConfigurableDevice();
    }

    @Override // com.haier.uhome.usdk.bind.p
    String k() {
        return "bindNewDirectLinkManualConfirm";
    }
}
