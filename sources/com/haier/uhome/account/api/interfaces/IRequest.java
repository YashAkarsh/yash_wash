package com.haier.uhome.account.api.interfaces;

import com.haier.uhome.account.model.ReqModel;

/* JADX INFO: loaded from: classes2.dex */
public interface IRequest {
    void httpsDelete(ReqModel reqModel, IAccountListener iAccountListener);

    void httpsGet(ReqModel reqModel, IAccountListener iAccountListener);

    void httpsPost(ReqModel reqModel, IAccountListener iAccountListener);

    void httpsPostBody(ReqModel reqModel, IAccountListener iAccountListener);

    void sendRequestPic(ReqModel reqModel, IAccountListener iAccountListener);
}
