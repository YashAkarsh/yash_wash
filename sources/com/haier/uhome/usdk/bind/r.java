package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigStatus;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
public class r extends p {
    r(BaseBindInfo baseBindInfo) {
        super(baseBindInfo);
    }

    @Override // com.haier.uhome.usdk.bind.p, com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        if (!usdkerrorG.a(ErrorConst.RET_USDK_OK)) {
            return usdkerrorG;
        }
        BaseBindInfo baseBindInfo = this.f31610e;
        if (!(baseBindInfo instanceof NewDirectLinkVerificationCodeBindInfo)) {
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("mBindInfo not DirectLinkVerificationCodeBindInfo");
            return error;
        }
        NewDirectLinkVerificationCodeBindInfo newDirectLinkVerificationCodeBindInfo = (NewDirectLinkVerificationCodeBindInfo) baseBindInfo;
        String verificationCode = newDirectLinkVerificationCodeBindInfo.getVerificationCode();
        if (verificationCode == null || verificationCode.length() > 63 || verificationCode.length() < 6) {
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("verificationCode = " + verificationCode);
            return error2;
        }
        ConfigurableDevice configurableDevice = newDirectLinkVerificationCodeBindInfo.getConfigurableDevice();
        if (configurableDevice == null) {
            uSDKError error3 = ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
            error3.a("device not found");
            return error3;
        }
        if (configurableDevice.getConfigStatus() != ConfigStatus.CONFIG_ABLE) {
            uSDKError error4 = ErrorConst.ERR_USDK_DEVICE_IS_NOT_CONFIG_STATE.toError();
            error4.a("device can not config~");
            return error4;
        }
        if (com.haier.uhome.search.service.i.a().a(configurableDevice.getDevId()) != null) {
            return usdkerrorG;
        }
        uSDKError error5 = ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError();
        error5.a("device not found in  ConfigurableDevices ");
        return error5;
    }

    @Override // com.haier.uhome.usdk.bind.p
    protected ConfigurableDevice j() {
        return ((NewDirectLinkVerificationCodeBindInfo) this.f31610e).getConfigurableDevice();
    }

    @Override // com.haier.uhome.usdk.bind.p
    String k() {
        return "bindNewDirectLinkVerificationCode";
    }
}
