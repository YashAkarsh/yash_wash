package com.haier.uhome.usdk.base.utils;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static uSDKError a(BasicResp basicResp) {
        uSDKError error;
        String str;
        if (basicResp == null) {
            e3.a.v("resp2Error param resp is null", new Object[0]);
            return ErrorConst.ERR_INTERNAL.toError();
        }
        ErrorConst errorConstById = ErrorConst.getErrorConstById(basicResp.getErrNo());
        ErrorConst errorConst = ErrorConst.ERR_INTERNAL;
        if (errorConstById == errorConst) {
            error = new uSDKError(basicResp.getErrNo());
            error.setDescription(errorConst.getErrorInfo());
        } else {
            error = errorConstById.toError();
        }
        if (basicResp.getReason() == 0) {
            str = null;
        } else {
            str = "" + basicResp.getReason();
        }
        error.a(str);
        return error;
    }

    public static uSDKError b(BasicResp basicResp) {
        uSDKError usdkerror = new uSDKError(basicResp.getErrNo());
        usdkerror.setDescription(ErrorConst.ERR_INTERNAL.getErrorInfo());
        return usdkerror;
    }

    public static uSDKError a(int i7) {
        return new uSDKError(i7);
    }
}
