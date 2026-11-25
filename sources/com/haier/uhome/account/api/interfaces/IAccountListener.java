package com.haier.uhome.account.api.interfaces;

import com.haier.uhome.account.model.RespCommonModel;

/* JADX INFO: loaded from: classes2.dex */
public interface IAccountListener<T> {
    void onHttpError(RespCommonModel respCommonModel);

    void onResponseFailed(RespCommonModel respCommonModel);

    void onResponseSuccess(T t7);
}
