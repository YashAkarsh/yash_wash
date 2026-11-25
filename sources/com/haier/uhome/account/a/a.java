package com.haier.uhome.account.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.haier.uhome.account.api.Const;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.HttpRequestType;
import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.uRequestFactory;
import com.haier.uhome.account.model.ReqModel;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.account.model.RespModel;
import com.haier.uhome.account.model.uwsmodel.DeviceBaseInfo;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.trace.b.f;
import com.haier.uhome.trace.b.g;
import com.haier.uhome.usdk.base.service.e;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.haier.uhome.account.a.a.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f28053e = "loginId";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f28054f = "password";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f28055g = "name";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f28056h = "mobile";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f28057i = "email";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f28058j = "deviceToken";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f28059k = "uvc";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f28060l = "deviceId";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f28061m = "data";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f28062n = "mainType";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f28063o = "typeId";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f28064p = "captcha";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f28065q = "accessToken";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final byte[] f28066r = "NE4L9UvJkbIaOxdW".getBytes();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final byte[] f28067s = "1269571569321021".getBytes();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final byte[] f28068t = "1269571569321021".getBytes();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final byte[] f28069u = "NE4L9UvJkbIaOxdW".getBytes();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f28073d;

    /* JADX INFO: renamed from: com.haier.uhome.account.a.a$a, reason: collision with other inner class name */
    abstract class AbstractC0364a<T> implements IAccountListener<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IAccountListener f28101a;

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onHttpError(RespCommonModel respCommonModel) {
            this.f28101a.onHttpError(respCommonModel);
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onResponseFailed(RespCommonModel respCommonModel) {
            this.f28101a.onResponseFailed(respCommonModel);
        }

        private AbstractC0364a(IAccountListener iAccountListener) {
            this.f28101a = iAccountListener;
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f28107a = new a();

        private c() {
        }
    }

    public static a c() {
        return c.f28107a;
    }

    private String d() {
        String strD = e.a().d();
        if (!TextUtils.isEmpty(strD) && !strD.contains(j0.b.f34226a)) {
            strD = "https://" + strD;
        }
        return TextUtils.isEmpty(strD) ? "https://uws.haier.net" : strD;
    }

    @Override // com.haier.uhome.account.a.a.a
    public String a(Context context) {
        return Const.RESET_PAS;
    }

    @Override // com.haier.uhome.account.a.a.a
    public void b(Context context, String str, final IAccountListener<DeviceBaseInfo> iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        String str2 = d() + Const.GET_BASE_INFO;
        HashMap map = new HashMap();
        map.put("deviceId", str);
        uRequestFactory.getSingleInstance().sendRequest(b(context, map, str2), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.6
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str3) {
                DeviceBaseInfo deviceBaseInfo;
                RespCommonModel respCommonModel = new RespCommonModel();
                try {
                    deviceBaseInfo = (DeviceBaseInfo) com.haier.library.json.a.z(com.haier.library.json.a.t(str3).L0("deviceBaseInfo").k(), DeviceBaseInfo.class);
                } catch (Exception e8) {
                    respCommonModel.setRetCode("-40002");
                    respCommonModel.setRetInfo(e8.getMessage());
                    e3.a.v("getDeviceBaseInfo excp -> %s", e8);
                    deviceBaseInfo = null;
                }
                if (deviceBaseInfo == null) {
                    iAccountListener.onResponseFailed(respCommonModel);
                } else {
                    iAccountListener.onResponseSuccess(deviceBaseInfo);
                }
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void e(Context context, String str, String str2, IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str)) {
            a(iAccountListener, "devicId参数无效，该值必填");
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str2)) {
            a(iAccountListener, "name参数无效，该值必填");
            return;
        }
        String str3 = c(context) + Const.UPDATE_NICKNAME;
        HashMap map = new HashMap();
        map.put("deviceId", str);
        map.put("name", str2);
        ReqModel reqModelA = a(context, map, str3);
        uRequestFactory.getSingleInstance().sendRequest(reqModelA, new b(reqModelA, null, iAccountListener));
    }

    private a() {
    }

    @Override // com.haier.uhome.account.a.a.a
    public void c(Context context, String str, String str2, final IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28072c)) {
            a(iAccountListener, RetInfoContent.REGISTR_MOBILE_ISNULL_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str2)) {
            a(iAccountListener, "activationcode参数无效，该值必填");
            return;
        }
        if (!com.haier.uhome.account.b.a.b(str)) {
            a(iAccountListener, RetInfoContent.PAS_INVALID_PARAM_CONTENT);
            return;
        }
        String str3 = c(context) + Const.REGISTE_RAND_LOGIN;
        HashMap map = new HashMap();
        map.put("mobile", this.f28072c);
        map.put("password", str);
        map.put(f28059k, str2);
        uRequestFactory.getSingleInstance().sendRequest(a(context, map, str3), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.5
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str4) {
                String openId = ((RespModel) com.haier.library.json.a.z(str4, RespModel.class)).getOpenId();
                a.this.b(openId);
                iAccountListener.onResponseSuccess(openId);
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void a(Context context, String str, String str2, final IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) str)) {
            a(iAccountListener, "loginId参数无效，该值必填");
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str2)) {
            a(iAccountListener, "password参数无效，该值必填");
            return;
        }
        String str3 = c(context) + Const.LOGIN_URL;
        HashMap map = new HashMap();
        map.put("loginId", str);
        map.put(f28058j, "");
        map.put("password", str2);
        uRequestFactory.getSingleInstance().sendRequest(a(context, map, str3), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.1
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str4) {
                String openId = ((RespModel) com.haier.library.json.a.z(str4, RespModel.class)).getOpenId();
                a.this.b(openId);
                iAccountListener.onResponseSuccess(openId);
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void d(Context context, String str, String str2, IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (!com.haier.uhome.account.b.a.f(str)) {
            a(iAccountListener, RetInfoContent.EMAIL_INVALID_PARAM_CONTENT);
            return;
        }
        if (!com.haier.uhome.account.b.a.e(str2)) {
            a(iAccountListener, RetInfoContent.MOBILE_INVALID_PARAM_CONTENT);
            return;
        }
        this.f28073d = str2;
        String str3 = c(context) + Const.SEND_BIND_MOBILE_CODE;
        HashMap map = new HashMap();
        map.put("email", str);
        map.put("mobile", str2);
        ReqModel reqModelA = a(context, map, str3);
        uRequestFactory.getSingleInstance().sendRequest(reqModelA, new b(reqModelA, null, iAccountListener));
    }

    class b implements IAccountListener<String> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IAccountListener f28104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ReqModel f28105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f28106d;

        b(ReqModel reqModel, String str, IAccountListener iAccountListener) {
            this.f28105c = reqModel;
            this.f28104b = iAccountListener;
            this.f28106d = str;
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponseSuccess(String str) {
            RespModel respModel = (RespModel) com.haier.library.json.a.z(str, RespModel.class);
            RespCommonModel respCommonModel = new RespCommonModel();
            respCommonModel.setRetCode(respModel.getRetCode());
            respCommonModel.setRetInfo(respModel.getRetInfo());
            a(str, respCommonModel);
            this.f28104b.onResponseSuccess(respCommonModel);
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onHttpError(RespCommonModel respCommonModel) {
            a("{\"info\":\"onResponseFailed\"}", respCommonModel);
            this.f28104b.onHttpError(respCommonModel);
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onResponseFailed(RespCommonModel respCommonModel) {
            a("{\"info\":\"onResponseFailed\"}", respCommonModel);
            this.f28104b.onResponseFailed(respCommonModel);
        }

        private void a(String str, RespCommonModel respCommonModel) {
            TraceNode traceNodeCreateCSNode;
            e3.a.e("sendNode -> %s", str);
            String url = this.f28105c.getUrl();
            if ("bindDevice".equals(url.substring(url.lastIndexOf(47) + 1))) {
                com.haier.uhome.trace.b.c cVarA = g.a().a(com.haier.uhome.trace.b.b.f30244a);
                if (cVarA != null) {
                    traceNodeCreateCSNode = TraceNode.createCSNode(url, com.haier.uhome.usdk.base.a.av);
                    traceNodeCreateCSNode.add(TraceProtocolConst.PRO_APP_ID, e.a().i());
                    traceNodeCreateCSNode.add(TraceProtocolConst.PRO_TOKEN, a.this.a());
                    traceNodeCreateCSNode.add(TraceProtocolConst.PRO_DEVICE_ID, this.f28106d);
                    traceNodeCreateCSNode.add("code", String.valueOf(respCommonModel.getRetCode()));
                    cVarA.a(traceNodeCreateCSNode, com.haier.uhome.trace.b.e.USDK);
                } else {
                    traceNodeCreateCSNode = null;
                }
                com.haier.uhome.trace.b.c cVarA2 = g.a().a(com.haier.uhome.trace.b.b.f30244a);
                if (cVarA2 != null) {
                    TraceNode traceNodeCreateCRNode = TraceNode.createCRNode(url, com.haier.uhome.usdk.base.a.av, traceNodeCreateCSNode);
                    traceNodeCreateCRNode.add(TraceProtocolConst.PRO_APP_ID, e.a().i());
                    traceNodeCreateCRNode.add(TraceProtocolConst.PRO_TOKEN, a.this.a());
                    traceNodeCreateCRNode.add(TraceProtocolConst.PRO_DEVICE_ID, this.f28106d);
                    traceNodeCreateCRNode.add("code", String.valueOf(respCommonModel.getRetCode()));
                    cVarA2.a(traceNodeCreateCRNode, com.haier.uhome.trace.b.e.USDK);
                }
            }
        }
    }

    @Override // com.haier.uhome.account.a.a.a
    public void b(Context context, final IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        String str = c(context) + Const.GET_BASE;
        HashMap map = new HashMap();
        map.put("accessToken", this.f28070a);
        uRequestFactory.getSingleInstance().sendRequest(a(context, map, str), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.7
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str2) {
                iAccountListener.onResponseSuccess(((RespModel) com.haier.library.json.a.z(str2, RespModel.class)).getUserBase());
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void a(Context context, String str, IAccountListener iAccountListener) {
        if (!com.haier.uhome.account.b.a.e(str)) {
            a(iAccountListener, RetInfoContent.MOBILE_INVALID_PARAM_CONTENT);
            return;
        }
        this.f28072c = str;
        String str2 = c(context) + Const.ACTIVATION_CODE;
        HashMap map = new HashMap();
        map.put("mobile", str);
        ReqModel reqModelA = a(context, map, str2);
        uRequestFactory.getSingleInstance().sendRequest(reqModelA, new b(reqModelA, null, iAccountListener));
    }

    @Override // com.haier.uhome.account.a.a.a
    public String b(Context context) {
        return com.haier.uhome.account.b.a.a((Object) this.f28070a) ? RetInfoContent.TOKEN_INVALID_PARAM_CONTENT : Const.MODIFY_PAS;
    }

    @Override // com.haier.uhome.account.a.a.a
    public void c(Context context, String str, IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) this.f28073d)) {
            a(iAccountListener, RetInfoContent.BIND_MOBILE_ISNULL_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str)) {
            a(iAccountListener, "activationcode参数无效，该值必填");
            return;
        }
        String str2 = c(context) + Const.BIND_MOBILE;
        HashMap map = new HashMap();
        map.put("mobile", this.f28073d);
        map.put(f28059k, str);
        ReqModel reqModelA = a(context, map, str2);
        uRequestFactory.getSingleInstance().sendRequest(reqModelA, new b(reqModelA, null, iAccountListener));
    }

    @Override // com.haier.uhome.account.a.a.a
    public void b(Context context, String str, String str2, final IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        String str3 = c(context) + Const.DEVICELIST_URL;
        HashMap map = new HashMap();
        map.put(f28062n, str);
        map.put(f28063o, str2);
        uRequestFactory.getSingleInstance().sendRequest(a(context, map, str3), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.8
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str4) {
                iAccountListener.onResponseSuccess(((RespModel) com.haier.library.json.a.z(str4, RespModel.class)).getDevices());
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void d(Context context, String str, IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str)) {
            a(iAccountListener, "devicId参数无效，该值必填");
            return;
        }
        ReqModel reqModelB = b(context, new HashMap(), d() + "/uds/v1/protected/{deviceId}/unbindDevice".replace("{deviceId}", str));
        uRequestFactory.getSingleInstance().sendRequest(reqModelB, new b(reqModelB, null, iAccountListener));
    }

    @Override // com.haier.uhome.account.a.a.a
    public void a(Context context, IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        this.f28072c = "";
        this.f28073d = "";
        ReqModel reqModelA = a(context, new HashMap(), c(context) + Const.LOGOUT);
        uRequestFactory.getSingleInstance().sendRequest(reqModelA, new b(reqModelA, null, iAccountListener));
        a("");
    }

    @Override // com.haier.uhome.account.a.a.a
    public void b(Context context, final String str, String str2, String str3, final IAccountListener iAccountListener) {
        String strK;
        if (!com.haier.uhome.account.b.a.c(str)) {
            a(iAccountListener, RetInfoContent.LOGINID_INVALID_PARAM_CONTENT);
            return;
        }
        if (!com.haier.uhome.account.b.a.d(str2)) {
            a(iAccountListener, RetInfoContent.PAS_INVALID_PARAM_CONTENT);
            return;
        }
        String str4 = c(context) + Const.LOGIN_URL_GEA;
        if (e.a().c() == 2) {
            strK = com.haier.library.common.util.a.a(f28066r, str2.getBytes(Charset.forName("utf-8")), f28067s);
        } else {
            strK = com.haier.library.common.util.a.k(str2);
        }
        HashMap map = new HashMap();
        map.put("loginId", str);
        map.put("password", strK);
        map.put(f28064p, str3);
        uRequestFactory.getSingleInstance().sendRequest(b(context, map, str4), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.12
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str5) {
                RespModel respModel = (RespModel) com.haier.library.json.a.z(str5, RespModel.class);
                IAccountListener iAccountListener2 = iAccountListener;
                if (iAccountListener2 != null) {
                    iAccountListener2.onResponseSuccess(respModel);
                } else {
                    e3.a.d("ACC", "NET", "login callback is null, loginId = <%s> ret data = <%s>", str, respModel);
                }
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void d(Context context, final IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        ReqModel reqModelB = b(context, new HashMap(), c(context) + Const.DEVICELIST_URL_GEA);
        reqModelB.setRequestType(Const.HTTP_REQUEST_TYPE_GET);
        uRequestFactory.getSingleInstance().sendRequest(reqModelB, new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.4
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str) {
                iAccountListener.onResponseSuccess((RespModel) com.haier.library.json.a.z(str, RespModel.class));
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void c(Context context, String str, String str2, String str3, final IAccountListener iAccountListener) {
        if (!com.haier.uhome.account.b.a.c(str)) {
            a(iAccountListener, RetInfoContent.LOGINID_INVALID_PARAM_CONTENT);
            return;
        }
        if (!com.haier.uhome.account.b.a.d(str2)) {
            a(iAccountListener, RetInfoContent.PAS_INVALID_PARAM_CONTENT);
            return;
        }
        String str4 = c(context) + Const.REGISTER_URL;
        String strK = com.haier.library.common.util.a.k(str2);
        e3.a.e("sha encryptPassword:" + strK, new Object[0]);
        String strA = com.haier.library.common.util.a.a(f28068t, strK.getBytes(Charset.forName("utf-8")), f28069u);
        HashMap map = new HashMap();
        map.put("loginId", str);
        map.put("password", strA);
        map.put(f28064p, str3);
        uRequestFactory.getSingleInstance().sendRequest(b(context, map, str4), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.2
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str5) {
                iAccountListener.onResponseSuccess((RespModel) com.haier.library.json.a.z(str5, RespModel.class));
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void a(Context context, String str, String str2, String str3, IAccountListener iAccountListener) {
        String str4 = d() + "/uds/v1/protected/bindDevice";
        TraceNode traceNodeCreateNode = TraceNode.createNode("bindDevice", "local", f.SR, null);
        traceNodeCreateNode.add(TraceProtocolConst.PRO_APP_ID, e.a().i());
        traceNodeCreateNode.add(TraceProtocolConst.PRO_TOKEN, a());
        traceNodeCreateNode.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("clientid", e.a().k());
        traceNodeCreateNode.add(TraceProtocolConst.PRO_IPM, eVar.k());
        com.haier.uhome.trace.b.c cVarA = g.a().a(com.haier.uhome.trace.b.b.f30244a);
        if (cVarA != null) {
            cVarA.a(traceNodeCreateNode, com.haier.uhome.trace.b.e.USDK);
        }
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str)) {
            a(iAccountListener, "devicId参数无效，该值必填");
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str2)) {
            a(iAccountListener, "name参数无效，该值必填");
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str3)) {
            a(iAccountListener, "key参数无效，该值必填");
            return;
        }
        HashMap map = new HashMap();
        map.put("deviceId", str);
        map.put("name", str2);
        map.put("data", str3);
        ReqModel reqModelB = b(context, map, str4);
        TraceNode traceNodeCreateCSNode = TraceNode.createCSNode(str4, com.haier.uhome.usdk.base.a.av);
        traceNodeCreateCSNode.add(TraceProtocolConst.PRO_APP_ID, e.a().i());
        traceNodeCreateCSNode.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeCreateCSNode.add(TraceProtocolConst.PRO_TOKEN, a());
        com.haier.uhome.trace.b.c cVarA2 = g.a().a(com.haier.uhome.trace.b.b.f30244a);
        if (cVarA2 != null) {
            cVarA2.a(traceNodeCreateCSNode, com.haier.uhome.trace.b.e.USDK);
        }
        uRequestFactory.getSingleInstance().sendRequest(reqModelB, new b(reqModelB, str, iAccountListener));
    }

    private ReqModel b(Context context, Map<String, Object> map, String str) {
        return a(context, map, str, Const.HTTP_REQUEST_TYPE_POST);
    }

    @Override // com.haier.uhome.account.a.a.a
    public String b() {
        return this.f28071b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.f28071b = str;
    }

    @Override // com.haier.uhome.account.a.a.a
    public void c(Context context, final IAccountListener iAccountListener) {
        uRequestFactory.getSingleInstance().sendRequestPic(b(context, new HashMap(), c(context) + Const.CAPTCHA_URL), new AbstractC0364a<byte[]>(iAccountListener) { // from class: com.haier.uhome.account.a.a.3
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(byte[] bArr) {
                iAccountListener.onResponseSuccess(a.this.a(bArr));
            }
        });
    }

    private String c(Context context) {
        String strC = com.haier.uhome.account.b.b.c(context, Const.DEVELOPER_URL);
        return com.haier.uhome.account.b.a.a((Object) strC) ? Const.MAIN_URL : strC;
    }

    @Override // com.haier.uhome.account.a.a.a
    public void a(Context context, String str, Map<String, Object> map, final IAccountListener iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) this.f28070a)) {
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) str)) {
            a(iAccountListener, "url参数无效，该值必填");
            return;
        }
        uRequestFactory.getSingleInstance().sendRequest(a(context, map, c(context) + str), new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.9
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str2) {
                iAccountListener.onResponseSuccess(str2);
            }
        });
    }

    private boolean a(Map<String, String> map) {
        if (map == null) {
            e3.a.v("sendCustomRequest headers is  null", new Object[0]);
            return true;
        }
        return TextUtils.isEmpty(map.get("accessToken"));
    }

    @Override // com.haier.uhome.account.a.a.a
    public void a(Context context, final CustomReqInfo customReqInfo, final IAccountListener iAccountListener) {
        String str;
        ReqModel reqModelA;
        if (customReqInfo == null) {
            e3.a.v("sendCustomRequest reqInfo null", new Object[0]);
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        Map<String, String> headers = customReqInfo.getHeaders();
        if (com.haier.uhome.account.b.a.a((Object) customReqInfo.getToken()) && com.haier.uhome.account.b.a.a((Object) this.f28070a) && a(headers)) {
            e3.a.v("sendCustomRequest reqInfo token && accessToken && headerToken is empty ", new Object[0]);
            a(iAccountListener, RetInfoContent.TOKEN_INVALID_PARAM_CONTENT);
            return;
        }
        if (com.haier.uhome.account.b.a.a((Object) customReqInfo.getUrl())) {
            e3.a.v("sendCustomRequest reqInfo url is empty", new Object[0]);
            a(iAccountListener, "url参数无效，该值必填");
            return;
        }
        if (customReqInfo.getRequestType() == HttpRequestType.GET) {
            str = Const.HTTP_REQUEST_TYPE_GET;
        } else {
            str = customReqInfo.getRequestType() == HttpRequestType.DELETE ? "DELETE" : Const.HTTP_REQUEST_TYPE_POST;
        }
        if (customReqInfo.isNotUwsType()) {
            reqModelA = a(context, customReqInfo.getBody(), customReqInfo.getUrl());
        } else {
            reqModelA = a(context, customReqInfo.getBody(), customReqInfo.getUrl(), str);
        }
        if (headers != null) {
            for (String str2 : headers.keySet()) {
                String str3 = headers.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    reqModelA.getHeaders().put(str2, str3);
                }
            }
        }
        if (!TextUtils.isEmpty(customReqInfo.getToken())) {
            reqModelA.getHeaders().put("accessToken", customReqInfo.getToken());
        }
        if (com.haier.library.common.util.c.l(customReqInfo.getApiVersion())) {
            reqModelA.getHeaders().put("apiVersion", customReqInfo.getApiVersion());
        }
        reqModelA.setTimeout(customReqInfo.getTimeout());
        reqModelA.setNotFixResult(customReqInfo.isNotFixResult());
        uRequestFactory.getSingleInstance().sendRequest(reqModelA, new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.10
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str4) {
                IAccountListener iAccountListener2 = iAccountListener;
                if (iAccountListener2 != null) {
                    iAccountListener2.onResponseSuccess(str4);
                } else {
                    e3.a.d("ACC", "NET", "sendCustomRequest  callback is null, req = <%s> ret data = <%s>", customReqInfo, str4);
                }
            }
        });
    }

    @Override // com.haier.uhome.account.a.a.a
    public void a(Context context, final ReqModel reqModel, final IAccountListener<String> iAccountListener) {
        if (com.haier.uhome.account.b.a.a((Object) reqModel.getUrl())) {
            a(iAccountListener, "url参数无效，该值必填");
        } else {
            uRequestFactory.getSingleInstance().sendRequest(reqModel, new AbstractC0364a<String>(iAccountListener) { // from class: com.haier.uhome.account.a.a.11
                @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResponseSuccess(String str) {
                    IAccountListener iAccountListener2 = iAccountListener;
                    if (iAccountListener2 != null) {
                        iAccountListener2.onResponseSuccess(str);
                    } else {
                        e3.a.d("ACC", "NET", "sendCustomRequest  callback is null, req = <%s> ret data = <%s>", reqModel, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    private void a(IAccountListener iAccountListener, String str) {
        if (iAccountListener != null) {
            RespCommonModel respCommonModel = new RespCommonModel();
            respCommonModel.setRetCode(Const.RETCODE_INVALID_PARAM);
            respCommonModel.setRetInfo(str);
            iAccountListener.onResponseFailed(respCommonModel);
            return;
        }
        e3.a.v("callback is null,so give up callback", new Object[0]);
    }

    private ReqModel a(Context context, Map<String, Object> map, String str) {
        String string = new com.haier.library.json.e(map).toString();
        Map<String, String> mapA = a(context, string, str.startsWith(d()));
        ReqModel reqModel = new ReqModel();
        reqModel.setUrl(str);
        reqModel.setBodys(string);
        reqModel.setHeaders(mapA);
        reqModel.setHttps(Const.IS_HTTPS.booleanValue());
        reqModel.setRequestType(Const.HTTP_REQUEST_TYPE_POST);
        return reqModel;
    }

    private Map<String, String> a(Context context, String str, boolean z7) {
        String strK;
        String str2 = System.currentTimeMillis() + "";
        if (e.a().b() == null) {
            e.a().a(context);
        }
        String strI = e.a().i();
        if (TextUtils.isEmpty(strI)) {
            strI = com.haier.uhome.account.b.b.c(context, "APP_ID");
            e.a().d(strI);
        }
        String str3 = strI;
        String strH = e.a().h();
        if (TextUtils.isEmpty(strH)) {
            strH = com.haier.uhome.account.b.b.c(context, "APP_KEY");
            e.a().c(strH);
        }
        String str4 = strH;
        String strJ = e.a().j();
        if (TextUtils.isEmpty(strJ)) {
            strJ = com.haier.uhome.account.b.b.b(context, context.getPackageName());
            e.a().e(strJ);
        }
        String str5 = strJ;
        if (z7) {
            strK = e.a().l();
            if (TextUtils.isEmpty(strK)) {
                strK = com.haier.library.common.util.f.t(context);
                e3.a.e("setAppClientId to " + strK, new Object[0]);
                e.a().g(strK);
            }
        } else {
            strK = e.a().k();
            if (TextUtils.isEmpty(strK)) {
                strK = com.haier.library.common.util.f.t(context);
                e.a().f(strK);
            }
        }
        String str6 = com.haier.uhome.account.b.b.b() + "000009";
        if (com.haier.uhome.account.b.a.a((Object) str3) || com.haier.uhome.account.b.a.a((Object) str4)) {
            e3.a.v("appid or appkey is null, setup it!", new Object[0]);
        }
        String strI2 = com.haier.library.common.util.a.i(a(str3, str4, str2, str, (String) null));
        HashMap map = new HashMap();
        map.put("appId", str3);
        map.put(HttpHelper.a.f29520d, strK);
        map.put(HttpHelper.a.f29518b, str5);
        map.put(HttpHelper.a.f29521e, str6);
        String str7 = this.f28070a;
        map.put("accessToken", str7 != null ? str7 : "");
        map.put("sign", strI2);
        map.put("language", "zh-cn");
        map.put("timestamp", str2);
        map.put(HttpHelper.a.f29526j, Const.APP_TIMEZONE);
        map.put("Content-type", "application/json");
        return map;
    }

    private String a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str5)) {
            try {
                sb.append(new URL(str5).getPath());
            } catch (MalformedURLException e8) {
                e3.a.g("getSign url excp -> %s", e8);
            }
        } else {
            e3.a.v("getSign url is Empty -> %s", str5);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4.trim().replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("\n", ""));
        } else {
            e3.a.v("getSign body is Empty -> %s", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str.trim().replaceAll("\"", ""));
        } else {
            e3.a.v("getSign appId is Empty -> %s", str);
        }
        sb.append(str2);
        sb.append(str3);
        e3.a.o("待签名字符串:" + sb.toString(), new Object[0]);
        return sb.toString();
    }

    private ReqModel a(Context context, Map<String, Object> map, String str, String str2) {
        String string = new com.haier.library.json.e(map).toString();
        if (map.isEmpty()) {
            string = "";
        }
        Map<String, String> mapA = a(context, string, str);
        ReqModel reqModel = new ReqModel();
        reqModel.setUrl(str);
        reqModel.setBodys(string);
        reqModel.setHeaders(mapA);
        reqModel.setHttps(Const.IS_HTTPS.booleanValue());
        reqModel.setRequestType(str2);
        return reqModel;
    }

    private Map<String, String> a(Context context, String str, String str2) {
        String strK;
        String str3 = System.currentTimeMillis() + "";
        if (e.a().b() == null) {
            e.a().a(context);
        }
        String strI = e.a().i();
        if (TextUtils.isEmpty(strI)) {
            strI = com.haier.uhome.account.b.b.c(context, "APP_ID");
            e.a().d(strI);
        }
        String str4 = strI;
        String strH = e.a().h();
        if (TextUtils.isEmpty(strH)) {
            strH = com.haier.uhome.account.b.b.c(context, "APP_KEY");
            e.a().c(strH);
        }
        String str5 = strH;
        String strJ = e.a().j();
        if (TextUtils.isEmpty(strJ)) {
            strJ = com.haier.uhome.account.b.b.b(context, context.getPackageName());
            e.a().e(strJ);
        }
        String str6 = strJ;
        if (!TextUtils.isEmpty(str2) && str2.startsWith(d())) {
            strK = e.a().l();
            if (TextUtils.isEmpty(strK)) {
                strK = com.haier.library.common.util.f.t(context);
                e3.a.e("setAppClientId to " + strK, new Object[0]);
                e.a().g(strK);
            }
        } else {
            strK = e.a().k();
            if (TextUtils.isEmpty(strK)) {
                strK = com.haier.library.common.util.f.t(context);
                e.a().f(strK);
            }
        }
        String str7 = strK;
        String str8 = com.haier.uhome.account.b.b.b() + "000009";
        if (com.haier.uhome.account.b.a.a((Object) str4) || com.haier.uhome.account.b.a.a((Object) str5)) {
            e3.a.v("appid or appkey is null, setup it!", new Object[0]);
        }
        String strK2 = com.haier.library.common.util.a.k(a(str4, str5, str3, str, str2));
        HashMap map = new HashMap();
        map.put("appId", str4);
        map.put(HttpHelper.a.f29520d, str7);
        map.put(HttpHelper.a.f29518b, str6);
        map.put("apiVersion", "v1");
        map.put(HttpHelper.a.f29521e, str8);
        String str9 = this.f28070a;
        map.put("accessToken", str9 != null ? str9 : "");
        map.put("sign", strK2);
        map.put("language", "zh-cn");
        map.put("timestamp", str3);
        map.put(HttpHelper.a.f29526j, Const.APP_TIMEZONE);
        map.put("Content-type", "application/json");
        return map;
    }

    @Override // com.haier.uhome.account.a.a.a
    public String a() {
        return this.f28070a;
    }

    public void a(String str) {
        this.f28070a = str;
    }
}
