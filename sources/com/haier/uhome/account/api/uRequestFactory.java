package com.haier.uhome.account.api;

import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.interfaces.IRequest;
import com.haier.uhome.account.model.ReqModel;
import com.haier.uhome.account.okhttp.uAccountRequest;

/* JADX INFO: loaded from: classes2.dex */
public class uRequestFactory {
    private static final String REQ_TYPE_DELETE = "DELETE";
    private static final String REQ_TYPE_GET = "GET";
    private static final String REQ_TYPE_POST = "POST";
    private static final String REQ_TYPE_POSTBODY = "POSTBODY";
    private IRequest mRequest;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static uRequestFactory f28109a = new uRequestFactory();
    }

    public static uRequestFactory getSingleInstance() {
        return a.f28109a;
    }

    public IRequest getRequest() {
        return this.mRequest;
    }

    public void sendRequest(ReqModel reqModel, IAccountListener iAccountListener) {
        if (reqModel.getHttps()) {
            String requestType = reqModel.getRequestType();
            if (REQ_TYPE_DELETE.equals(requestType)) {
                this.mRequest.httpsDelete(reqModel, iAccountListener);
                return;
            }
            if ("GET".equals(requestType)) {
                this.mRequest.httpsGet(reqModel, iAccountListener);
            } else if ("POST".equals(requestType)) {
                this.mRequest.httpsPost(reqModel, iAccountListener);
            } else if ("POSTBODY".equals(requestType)) {
                this.mRequest.httpsPostBody(reqModel, iAccountListener);
            }
        }
    }

    public void sendRequestPic(ReqModel reqModel, IAccountListener iAccountListener) {
        this.mRequest.sendRequestPic(reqModel, iAccountListener);
    }

    public void setRequest(IRequest iRequest) {
        this.mRequest = iRequest;
    }

    private uRequestFactory() {
        this.mRequest = new uAccountRequest();
    }
}
