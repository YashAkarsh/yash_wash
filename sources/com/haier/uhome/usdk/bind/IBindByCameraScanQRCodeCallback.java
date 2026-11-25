package com.haier.uhome.usdk.bind;

import android.graphics.Bitmap;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IBindByCameraScanQRCodeCallback extends ICallback<uSDKDevice> {
    @Keep
    void onQRCodeImageCallback(Bitmap bitmap);
}
