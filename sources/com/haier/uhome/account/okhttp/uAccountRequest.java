package com.haier.uhome.account.okhttp;

import android.text.TextUtils;
import com.haier.library.okhttp.a;
import com.haier.library.okhttp.api.e;
import com.haier.library.okhttp.api.f;
import com.haier.uhome.account.api.Const;
import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.interfaces.IRequest;
import com.haier.uhome.account.model.LoginResponse;
import com.haier.uhome.account.model.ReqModel;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.account.model.RespModel;
import java.net.SocketTimeoutException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uAccountRequest implements IRequest {
    public static final String KEY_ACCESS_TOKEN = "accessToken";
    public static final String KEY_RET_CODE = "retCode";
    public static final String KEY_RET_INFO = "retInfo";

    private Map<String, String> delHeaderEmptyItem(Map<String, String> map) {
        return map;
    }

    @Override // com.haier.uhome.account.api.interfaces.IRequest
    public void httpsDelete(ReqModel reqModel, final IAccountListener iAccountListener) {
        f fVar = new f() { // from class: com.haier.uhome.account.okhttp.uAccountRequest.2
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(a aVar, String str) {
                if (TextUtils.isEmpty(str)) {
                    RespCommonModel respCommonModel = new RespCommonModel();
                    respCommonModel.setRetCode("-40002");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_INVALID_RESP_CONTENT);
                    iAccountListener.onResponseFailed(respCommonModel);
                    return;
                }
                e3.a.e("response: %s", str);
                RespModel respModel = (RespModel) com.haier.library.json.a.z(str, RespModel.class);
                String retCode = respModel.getRetCode();
                if (Const.RETCODE_INVALID_PARAM_HAIER.equals(retCode)) {
                    respModel.setRetCode(Const.RETCODE_INVALID_PARAM);
                }
                if (aVar != null && 403 == aVar.u()) {
                    RespCommonModel respCommonModel2 = new RespCommonModel();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        respCommonModel2.setRetCode(jSONObject.getString(uAccountRequest.KEY_RET_CODE));
                        respCommonModel2.setRetInfo(jSONObject.getString(uAccountRequest.KEY_RET_INFO));
                    } catch (JSONException unused) {
                    }
                    iAccountListener.onResponseFailed(respCommonModel2);
                }
                if (aVar != null) {
                    respModel.setAccessToken(aVar.h0().E("accessToken"));
                }
                if ("00000".equals(retCode)) {
                    iAccountListener.onResponseSuccess(str);
                    return;
                }
                RespCommonModel respCommonModel3 = new RespCommonModel();
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    respCommonModel3.setRetCode(jSONObject2.getString(uAccountRequest.KEY_RET_CODE));
                    respCommonModel3.setRetInfo(jSONObject2.getString(uAccountRequest.KEY_RET_INFO));
                } catch (JSONException unused2) {
                }
                iAccountListener.onResponseFailed(respCommonModel3);
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(a aVar, Exception exc) {
                e3.a.e("httpsDelete onError: %s", exc);
                RespCommonModel respCommonModel = new RespCommonModel();
                if (exc == null || !(exc.getCause() instanceof SocketTimeoutException)) {
                    respCommonModel.setRetCode("-40000");
                    respCommonModel.setRetInfo(exc == null ? RetInfoContent.ERR_USDK_OTHER_CONTENT : exc.getMessage());
                    iAccountListener.onHttpError(respCommonModel);
                } else {
                    respCommonModel.setRetCode("-40004");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_NOCONNECTION_CONTENT);
                    iAccountListener.onHttpError(respCommonModel);
                }
            }
        };
        String url = reqModel.getUrl();
        String bodys = reqModel.getBodys();
        Map<String, String> mapDelHeaderEmptyItem = delHeaderEmptyItem(reqModel.getHeaders());
        e3.a.e("uAccount delete url: %s", url);
        e3.a.e("uAccount delete header: %s", mapDelHeaderEmptyItem);
        e3.a.e("uAccount delete bodys:%s", bodys);
        e.m(reqModel.getTimeout(), TimeUnit.SECONDS).g(url, mapDelHeaderEmptyItem, bodys, fVar);
    }

    @Override // com.haier.uhome.account.api.interfaces.IRequest
    public void httpsGet(ReqModel reqModel, final IAccountListener iAccountListener) {
        f fVar = new f() { // from class: com.haier.uhome.account.okhttp.uAccountRequest.3
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(a aVar, String str) {
                if (TextUtils.isEmpty(str)) {
                    RespCommonModel respCommonModel = new RespCommonModel();
                    respCommonModel.setRetCode("-40002");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_INVALID_RESP_CONTENT);
                    iAccountListener.onResponseFailed(respCommonModel);
                    return;
                }
                e3.a.e("response: %s", str);
                RespModel respModel = (RespModel) com.haier.library.json.a.z(str, RespModel.class);
                String retCode = respModel.getRetCode();
                if (Const.RETCODE_INVALID_PARAM_HAIER.equals(retCode)) {
                    respModel.setRetCode(Const.RETCODE_INVALID_PARAM);
                }
                if (aVar != null && 403 == aVar.u()) {
                    RespCommonModel respCommonModel2 = new RespCommonModel();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        respCommonModel2.setRetCode(jSONObject.getString(uAccountRequest.KEY_RET_CODE));
                        respCommonModel2.setRetInfo(jSONObject.getString(uAccountRequest.KEY_RET_INFO));
                    } catch (JSONException unused) {
                    }
                    iAccountListener.onResponseFailed(respCommonModel2);
                }
                if (aVar != null) {
                    respModel.setAccessToken(aVar.h0().E("accessToken"));
                }
                if ("00000".equals(retCode)) {
                    iAccountListener.onResponseSuccess(str);
                    return;
                }
                RespCommonModel respCommonModel3 = new RespCommonModel();
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    respCommonModel3.setRetCode(jSONObject2.getString(uAccountRequest.KEY_RET_CODE));
                    respCommonModel3.setRetInfo(jSONObject2.getString(uAccountRequest.KEY_RET_INFO));
                } catch (JSONException unused2) {
                }
                iAccountListener.onResponseFailed(respCommonModel3);
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(a aVar, Exception exc) {
                e3.a.e("httpsGet onError:%s", exc);
                RespCommonModel respCommonModel = new RespCommonModel();
                if (exc == null || !(exc.getCause() instanceof SocketTimeoutException)) {
                    respCommonModel.setRetCode("-40000");
                    respCommonModel.setRetInfo(exc == null ? RetInfoContent.ERR_USDK_OTHER_CONTENT : exc.getMessage());
                    iAccountListener.onHttpError(respCommonModel);
                } else {
                    respCommonModel.setRetCode("-40004");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_NOCONNECTION_CONTENT);
                    iAccountListener.onHttpError(respCommonModel);
                }
            }
        };
        String url = reqModel.getUrl();
        Map<String, String> mapDelHeaderEmptyItem = delHeaderEmptyItem(reqModel.getHeaders());
        e3.a.e("uAccount get url: %s", url);
        e3.a.e("uAccount get header:%s", mapDelHeaderEmptyItem);
        e.m(reqModel.getTimeout(), TimeUnit.SECONDS).i(url, mapDelHeaderEmptyItem, fVar);
    }

    @Override // com.haier.uhome.account.api.interfaces.IRequest
    public void httpsPost(final ReqModel reqModel, final IAccountListener iAccountListener) {
        f fVar = new f() { // from class: com.haier.uhome.account.okhttp.uAccountRequest.1
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(a aVar, String str) {
                if (TextUtils.isEmpty(str)) {
                    RespCommonModel respCommonModel = new RespCommonModel();
                    respCommonModel.setRetCode("-40002");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_INVALID_RESP_CONTENT);
                    iAccountListener.onResponseFailed(respCommonModel);
                    return;
                }
                e3.a.e("httpsPost response: %s", str);
                RespModel respModel = (RespModel) com.haier.library.json.a.z(str, RespModel.class);
                String retCode = respModel.getRetCode();
                if (Const.RETCODE_INVALID_PARAM_HAIER.equals(retCode)) {
                    respModel.setRetCode(Const.RETCODE_INVALID_PARAM);
                }
                if (aVar != null && 403 == aVar.u()) {
                    RespCommonModel respCommonModel2 = new RespCommonModel();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        respCommonModel2.setRetCode(jSONObject.getString(uAccountRequest.KEY_RET_CODE));
                        respCommonModel2.setRetInfo(jSONObject.getString(uAccountRequest.KEY_RET_INFO));
                    } catch (JSONException unused) {
                    }
                    iAccountListener.onResponseFailed(respCommonModel2);
                }
                if (aVar != null) {
                    String strE = aVar.h0().E("accessToken");
                    respModel.setAccessToken(strE);
                    if (!com.haier.uhome.account.b.a.a((Object) strE)) {
                        e3.a.e("set token: %s", strE);
                        com.haier.uhome.account.a.a.c().a(strE);
                    }
                }
                if (reqModel.isNotFixResult()) {
                    iAccountListener.onResponseSuccess(str);
                    return;
                }
                if ("00000".equals(retCode)) {
                    iAccountListener.onResponseSuccess(str);
                    return;
                }
                RespCommonModel respCommonModel3 = new RespCommonModel();
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    respCommonModel3.setRetCode(jSONObject2.getString(uAccountRequest.KEY_RET_CODE));
                    respCommonModel3.setRetInfo(jSONObject2.getString(uAccountRequest.KEY_RET_INFO));
                } catch (JSONException unused2) {
                }
                iAccountListener.onResponseFailed(respCommonModel3);
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(a aVar, Exception exc) {
                e3.a.e("httpsPost onError: %s", exc);
                RespCommonModel respCommonModel = new RespCommonModel();
                if (exc == null || !(exc.getCause() instanceof SocketTimeoutException)) {
                    respCommonModel.setRetCode("-40000");
                    respCommonModel.setRetInfo(exc == null ? RetInfoContent.ERR_USDK_OTHER_CONTENT : exc.getMessage());
                    iAccountListener.onHttpError(respCommonModel);
                } else {
                    respCommonModel.setRetCode("-40004");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_NOCONNECTION_CONTENT);
                    iAccountListener.onHttpError(respCommonModel);
                }
            }
        };
        String url = reqModel.getUrl();
        String bodys = reqModel.getBodys();
        Map<String, String> mapDelHeaderEmptyItem = delHeaderEmptyItem(reqModel.getHeaders());
        e3.a.e("uAccount post url: %s", url);
        e3.a.e("uAccount post headers: %s", mapDelHeaderEmptyItem);
        e3.a.e("uAccount post bodys: %s", bodys);
        e.m(reqModel.getTimeout(), TimeUnit.SECONDS).u(url, mapDelHeaderEmptyItem, bodys, fVar);
    }

    @Override // com.haier.uhome.account.api.interfaces.IRequest
    public void httpsPostBody(ReqModel reqModel, final IAccountListener iAccountListener) {
        f fVar = new f() { // from class: com.haier.uhome.account.okhttp.uAccountRequest.5
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(a aVar, String str) {
                e3.a.e("uAccount response : response = %s, data = %s", Integer.valueOf(aVar.u()), str);
                if (aVar.u() != 200 || str == null) {
                    return;
                }
                LoginResponse loginResponse = (LoginResponse) com.haier.library.json.a.z(str, LoginResponse.class);
                com.haier.uhome.account.a.a.c().a(loginResponse.getUhome_access_token());
                iAccountListener.onResponseSuccess(loginResponse.getUhome_user_id());
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(a aVar, Exception exc) {
                e3.a.e("uAccount response : exception = %s", exc.toString());
                RespCommonModel respCommonModel = new RespCommonModel();
                if (exc.getCause() instanceof SocketTimeoutException) {
                    respCommonModel.setRetCode("-40004");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_NOCONNECTION_CONTENT);
                    iAccountListener.onHttpError(respCommonModel);
                } else {
                    respCommonModel.setRetCode("-40000");
                    respCommonModel.setRetInfo(exc.getMessage());
                    iAccountListener.onHttpError(respCommonModel);
                }
            }
        };
        String url = reqModel.getUrl();
        Map<String, String> bodysMap = reqModel.getBodysMap();
        Map<String, String> mapDelHeaderEmptyItem = delHeaderEmptyItem(reqModel.getHeaders());
        e3.a.e("uAccount post url: %s", url);
        e3.a.e("uAccount post header: %s", mapDelHeaderEmptyItem);
        e3.a.e("uAccount post bodys: %s", bodysMap);
        e.m(reqModel.getTimeout(), TimeUnit.SECONDS).s(url, mapDelHeaderEmptyItem, bodysMap, fVar);
    }

    @Override // com.haier.uhome.account.api.interfaces.IRequest
    public void sendRequestPic(ReqModel reqModel, final IAccountListener iAccountListener) {
        com.haier.library.okhttp.api.a aVar = new com.haier.library.okhttp.api.a() { // from class: com.haier.uhome.account.okhttp.uAccountRequest.4
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(a aVar2, byte[] bArr) {
                e3.a.e("byte length: %d", Integer.valueOf(bArr.length));
                iAccountListener.onResponseSuccess(bArr);
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(a aVar2, Exception exc) {
                RespCommonModel respCommonModel = new RespCommonModel();
                if (exc == null || !(exc.getCause() instanceof SocketTimeoutException)) {
                    respCommonModel.setRetCode("-40000");
                    respCommonModel.setRetInfo(exc == null ? RetInfoContent.ERR_USDK_OTHER_CONTENT : exc.getMessage());
                    iAccountListener.onHttpError(respCommonModel);
                } else {
                    respCommonModel.setRetCode("-40004");
                    respCommonModel.setRetInfo(RetInfoContent.ERR_USDK_NOCONNECTION_CONTENT);
                    iAccountListener.onHttpError(respCommonModel);
                }
            }
        };
        String url = reqModel.getUrl();
        String bodys = reqModel.getBodys();
        Map<String, String> mapDelHeaderEmptyItem = delHeaderEmptyItem(reqModel.getHeaders());
        e3.a.e("uAccount post url: %s", url);
        e3.a.e("uAccount post header: %s", mapDelHeaderEmptyItem);
        e3.a.e("uAccount post bodys: %s", bodys);
        e.m(reqModel.getTimeout(), TimeUnit.SECONDS).u(url, mapDelHeaderEmptyItem, bodys, aVar);
    }
}
