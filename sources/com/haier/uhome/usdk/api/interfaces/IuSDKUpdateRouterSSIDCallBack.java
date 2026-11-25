package com.haier.uhome.usdk.api.interfaces;

import com.haier.uhome.control.local.api.UpdateProgress;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IuSDKUpdateRouterSSIDCallBack extends ICallback<Integer> {
    @Keep
    void updateSSIDProgress(UpdateProgress updateProgress);
}
