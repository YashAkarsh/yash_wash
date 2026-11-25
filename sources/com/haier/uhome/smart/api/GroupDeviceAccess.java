package com.haier.uhome.smart.api;

import com.haier.library.common.thread.m;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import e3.a;

/* JADX INFO: loaded from: classes2.dex */
public class GroupDeviceAccess extends AbsDeviceAccess {
    private GroupDevice mGroupDevice;

    public GroupDeviceAccess(GroupDevice groupDevice) {
        super(groupDevice);
        this.mGroupDevice = groupDevice;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkOnlineParam() {
        if (this.mGroupDevice != null) {
            return ErrorConst.RET_USDK_OK.toError();
        }
        a.h("checkOnlineParam mGroupDevice is null", new Object[0]);
        uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error.a("device=null");
        return error;
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected uSDKError checkRegisterParam() {
        return super.checkRegisterParam();
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doDeviceOnline(final ICallback<String> iCallback) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.smart.api.GroupDeviceAccess.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            public Void doInBackground(Void... voidArr) {
                SmartDeviceService.getInstance().groupDeviceOnline(GroupDeviceAccess.this.mGroupDevice.getDeviceId(), GroupDeviceAccess.this.mGroupDevice.getUplusId(), GroupDeviceAccess.this.mGroupDevice.getDeviceKey(), iCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    @Override // com.haier.uhome.smart.api.AbsDeviceAccess
    protected void doRegisterDevice(ICallback<RegisterResult> iCallback) {
    }
}
