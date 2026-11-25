package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.account.okhttp.uAccountRequest;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.R;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class v extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f31833a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f31834b = 76;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f31835c = 96;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f31836f = "^([1-2]\\S{63})$";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private QRCodeBindInfo f31837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String[] f31838h;

    protected v(QRCodeBindInfo qRCodeBindInfo) {
        super(qRCodeBindInfo);
        a(false);
        b(false);
        this.f31837g = qRCodeBindInfo;
        this.f31838h = com.haier.uhome.usdk.base.service.e.a().b().getResources().getStringArray(R.array.custom_type_id);
    }

    private String e(String str) {
        return TextUtils.isEmpty(str) ? "" : str.toUpperCase();
    }

    private String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = new StringBuffer(str).reverse().toString();
        e3.a.e("get qr Info reverse <%s>", string);
        int length = string.length();
        if (length <= 0) {
            return null;
        }
        if (length == 1) {
            return string;
        }
        if (length % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            int i7 = length / 2;
            sb.append(string.substring(i7));
            sb.append(string.substring(0, i7));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        int i8 = length / 2;
        sb2.append(string.substring(i8 + 1));
        sb2.append(string.charAt(i8));
        sb2.append(string.substring(0, i8));
        return sb2.toString();
    }

    private boolean j() {
        QRCodeBindInfo qRCodeBindInfo = this.f31837g;
        return qRCodeBindInfo != null && qRCodeBindInfo.getQRCode() != null && this.f31837g.getQRCode().length() >= 76 && this.f31837g.getQRCode().length() <= 96;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        if (this.f31837g == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "bindInfo is null", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("bindInfo=null");
            return error;
        }
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "token is null", new Object[0]);
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        if (TextUtils.isEmpty(this.f31837g.getQRCode())) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "qr code is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("qrCode = null");
            return error2;
        }
        if (this.f31837g.getTimeout() >= 30 && this.f31837g.getTimeout() <= 180) {
            return super.g();
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31837g.getTimeout(), new Object[0]);
        uSDKError error3 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error3.a("timeout=" + this.f31837g.getTimeout());
        return error3;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE != null) {
            dVarE.a(r(), w() ? m() : 0L, 0, 5, t(), null);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        a(this.f31837g == null ? com.haier.uhome.trace.api.b.a().g(null) : com.haier.uhome.trace.api.b.a().f(this.f31837g.getQRCode(), this.f31837g.getAppCsNode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean k() {
        return System.currentTimeMillis() > x();
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        com.haier.library.json.e eVarT;
        String qRCode = this.f31837g.getQRCode();
        try {
            eVarT = com.haier.library.json.a.t(qRCode);
        } catch (Exception unused) {
            e3.a.v("doBindDevice qrStr is not json", new Object[0]);
            eVarT = null;
        }
        if (eVarT != null && !eVarT.isEmpty()) {
            String strR0 = eVarT.R0("UPID");
            String strE = e(eVarT.R0("DID"));
            String strR1 = eVarT.R0("BDK");
            String strR2 = eVarT.R0("VER");
            String strF = f(strR1);
            e3.a.d("BD", "QR", "get qr Info UPID = %s,DID = %s,BDK = %s, BDK_SRC = %S, VER = %s", strR0, strE, strF, strR1, strR2);
            a(strE, strR0, strR2, strF, iBindCallback);
            return;
        }
        if (j()) {
            a(e(qRCode.substring(64)), qRCode.substring(0, 64), iBindCallback);
            return;
        }
        uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
        error.a("qrCode = " + qRCode);
        iBindCallback.onFailure(error);
    }

    private boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.f31838h) {
            if (str2.toUpperCase().contentEquals(str.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    private com.haier.uhome.usdk.api.x<String> g(String str) {
        com.haier.uhome.usdk.api.x<String> xVar = new com.haier.uhome.usdk.api.x<>();
        String strA = com.haier.uhome.config.a.c.a().a(com.haier.uhome.usdk.base.service.e.a().g(), str);
        e3.a.e("getBindInfoByBindKey bindinfo<%s>", this.f31837g);
        if (!TextUtils.isEmpty(strA)) {
            com.haier.library.json.e eVarL0 = com.haier.library.json.a.t(strA).L0("dev_bind_rsp");
            int iI0 = eVarL0.I0("ret");
            String strR0 = eVarL0.R0(uAccountRequest.KEY_RET_INFO);
            if (iI0 == uSDKErrorConst.RET_USDK_OK.getErrorId()) {
                xVar.a(ErrorConst.RET_USDK_OK.toError());
                xVar.a(strR0);
                return xVar;
            }
            uSDKError error = ErrorConst.ERR_INTERNAL.toError();
            error.a(strR0);
            xVar.a(error);
            return xVar;
        }
        uSDKError error2 = ErrorConst.ERR_INTERNAL.toError();
        error2.a("retInfo is null");
        xVar.a(error2);
        return xVar;
    }

    private uSDKError a(String str, String str2, String str3, boolean z7) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (TextUtils.isEmpty(str) || !str.matches(f31836f)) {
            e3.a.h("checkParam uplusId <%s> is invalid", str);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("uplusId = " + str);
            return error2;
        }
        if (z7) {
            if (!"1.0".equals(str3)) {
                e3.a.h("checkParam version <%s> is invalid", str3);
                uSDKError error3 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
                error3.a("version = " + str3);
                return error3;
            }
            if (TextUtils.isEmpty(str2)) {
                e3.a.h("checkParam devId <%s> is invalid", str2);
                uSDKError error4 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
                error4.a("devId = " + str2);
                return error4;
            }
        } else if (!a(str2)) {
            e3.a.h("checkParam devId <%s> is invalid", str2);
            uSDKError error5 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error5.a("devId = " + str2);
            return error5;
        }
        return error;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String upperCase = str.toUpperCase();
        for (int i7 = 0; i7 < upperCase.length(); i7++) {
            char cCharAt = upperCase.charAt(i7);
            if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'A' || cCharAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        s.a().a(r(), s(), m(), 0, e(), u(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.v.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.usdk.api.w>) iCallback, wVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
            }
        });
    }

    private void a(String str, final String str2, final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        uSDKError usdkerrorA = a(str2, str, null, false);
        if (!usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            a(iBindCallback, usdkerrorA);
            return;
        }
        a(str, str2);
        if (h(str2)) {
            a((ICallback<com.haier.uhome.usdk.api.w>) iBindCallback);
        } else {
            com.haier.uhome.usdk.c.f.a().a(str, new com.haier.uhome.usdk.a.b() { // from class: com.haier.uhome.usdk.bind.m1
                @Override // com.haier.uhome.usdk.a.b
                public final boolean isTimeout() {
                    return this.f31667a.k();
                }
            }, new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.v.2
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                    String uplusId = wVar.a().getUplusId();
                    if (uplusId != null && uplusId.equalsIgnoreCase(str2)) {
                        v.this.a(wVar.a().getDeviceId(), wVar.a().getUplusId());
                        v.this.a((ICallback<com.haier.uhome.usdk.api.w>) iBindCallback);
                        return;
                    }
                    uSDKError error = ErrorConst.ERR_USDK_DEVICE_UPLUSID_NOT_MATCH.toError();
                    error.a("uplusId=" + str2);
                    v.this.a(iBindCallback, error);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    v.this.a(iBindCallback, usdkerror);
                }
            });
        }
    }

    private void a(String str, String str2, String str3, String str4, final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        try {
            uSDKError usdkerrorA = a(str2, str, str3, true);
            ErrorConst errorConst = ErrorConst.RET_USDK_OK;
            if (!usdkerrorA.a(errorConst)) {
                a(iBindCallback, usdkerrorA);
                return;
            }
            a(str, str2);
            com.haier.uhome.usdk.api.x<String> xVarG = g(str4);
            e3.a.e("getBindInfoByBindKey devBindInfo<%s>", xVarG.b());
            if (!xVarG.a().a(errorConst)) {
                e3.a.h("getBindInfo error <%s>", xVarG.b());
                a(iBindCallback, xVarG.a());
            } else {
                s.a().a(r(), s(), (String) null, xVarG.b(), x(), u(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.v.3
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                        IBindCallback iBindCallback2 = iBindCallback;
                        if (iBindCallback2 != null) {
                            iBindCallback2.onSuccess(wVar);
                        }
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        iBindCallback.onFailure(usdkerror);
                    }
                });
            }
        } catch (Exception e8) {
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("json parser error," + e8.getMessage());
            a(iBindCallback, error);
        }
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (str == null || str.isEmpty()) {
            str = "local";
        }
        int code = usdkerror.getCode();
        com.haier.uhome.trace.api.b bVarA = com.haier.uhome.trace.api.b.a();
        String strR = r();
        QRCodeBindInfo qRCodeBindInfo = this.f31837g;
        bVarA.d(code, strR, qRCodeBindInfo == null ? null : qRCodeBindInfo.getAppCsNode(), str);
    }
}
