package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.bind.entity.DeviceWithError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IBindCellularDeviceCallback {
    @Keep
    void completionHandler(List<uSDKDevice> list, List<DeviceWithError> list2, uSDKError usdkerror);

    @Keep
    void progressNotify(int i7, int i8);
}
