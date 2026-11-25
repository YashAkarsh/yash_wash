package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IBindResultCallback<R> extends ICallback<R> {
    void notifyProgress(BindProgress bindProgress, String str, String str2);
}
