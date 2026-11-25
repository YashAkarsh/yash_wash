package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class x extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f31870c = -25001;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f31871f = 128;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SlaveDeviceBindInfo f31872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31873b;

    public x(SlaveDeviceBindInfo slaveDeviceBindInfo) {
        super(slaveDeviceBindInfo);
        a(true);
        b(false);
        this.f31872a = slaveDeviceBindInfo;
        this.f31873b = UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
    }

    public synchronized void f(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        uSDKDevice masterDevice = this.f31872a.getMasterDevice();
        String uplusID = this.f31872a.getUplusID();
        String productCode = this.f31872a.getProductCode();
        String extendInfo = this.f31872a.getExtendInfo();
        if (extendInfo == null) {
            extendInfo = "";
        }
        String str = extendInfo;
        if (str.length() > 128) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        final com.haier.uhome.usdk.c.d dVar = new com.haier.uhome.usdk.c.d(new IBindCallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.x.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindCallback, wVar);
            }

            @Override // com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str2, String str3) {
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, usdkerror);
            }

            @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
            public void switchNetworkNotify() {
            }
        });
        final StringBuffer stringBuffer = new StringBuffer();
        final com.haier.uhome.usdk.a.a aVar = new com.haier.uhome.usdk.a.a(new AtomicLong(x()), false) { // from class: com.haier.uhome.usdk.bind.x.3
            @Override // com.haier.uhome.usdk.a.a
            public void a() {
                dVar.onFailure(ErrorConst.ERR_USDK_WAIT_NETWORKING_RESULT_TIMEOUT.toError());
            }
        };
        aVar.b();
        com.haier.uhome.control.cloud.a.h.a().a(new com.haier.uhome.control.cloud.a.a() { // from class: com.haier.uhome.usdk.bind.x.4
            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str2, String str3, String str4) {
                uSDKDevice device;
                if (stringBuffer.length() <= 0 || !stringBuffer.toString().equals(str3) || (device = uSDKDeviceManager.getSingleInstance().getDevice(str3)) == null || !device.isBound()) {
                    return;
                }
                com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
                wVar.a(device);
                wVar.a(wVar.b());
                aVar.c();
                dVar.onSuccess(wVar);
            }

            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str2, String str3, String str4, int i7, int i8, String str5) {
                if (i7 == 1) {
                    if (x.this.f31873b.equals(str5) && x.this.f31872a.getUplusID().equals(str3) && x.this.f31872a.getProductCode().equals(str4)) {
                        if (stringBuffer.length() == 0) {
                            stringBuffer.append(str2);
                        }
                        if (i8 == ErrorConst.RET_USDK_OK.getErrorId()) {
                            if (stringBuffer.toString().equals(str2)) {
                                x.this.a(iBindCallback, BindProgress.START_BIND_SLAVE_DEVICE);
                                uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str2);
                                if (device == null || !device.isBound()) {
                                    return;
                                }
                                com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
                                wVar.a(device);
                                wVar.a(wVar.b());
                                aVar.c();
                                dVar.onSuccess(wVar);
                                return;
                            }
                            return;
                        }
                        aVar.c();
                        dVar.onFailure(new uSDKError(i8));
                        return;
                    }
                    return;
                }
                if (i7 == 2 && i8 == ErrorConst.RET_USDK_OK.getErrorId() && stringBuffer.toString().equals(str2)) {
                    com.haier.uhome.usdk.c.f.a().a(str2, x.this.e(), true, x.this.w() ? x.this.m() : 0L, 0, x.this.u(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.x.4.1
                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(com.haier.uhome.usdk.api.w wVar2) {
                            aVar.c();
                            dVar.onSuccess(wVar2);
                        }

                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        public void onFailure(uSDKError usdkerror) {
                            aVar.c();
                            dVar.onFailure(ErrorConst.ERR_USDK_GET_BIND_RESULT_TIMEOUT.toError());
                        }
                    });
                }
            }
        });
        a(masterDevice.getDeviceId(), uplusID, productCode, str, new IBindCallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.x.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
            }

            @Override // com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str2, String str3) {
                x.this.a(iBindCallback, bindProgress);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                dVar.onFailure(usdkerror);
            }

            @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
            public void switchNetworkNotify() {
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "token is null", new Object[0]);
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        if (this.f31872a == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter SlaveDeviceBindInfo is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("bindInfo=null");
            return error2;
        }
        StringBuilder sb = new StringBuilder();
        uSDKDevice masterDevice = this.f31872a.getMasterDevice();
        if (masterDevice == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter masterDevice : " + masterDevice.toString(), new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append("masterdevice=");
            sb.append(masterDevice.toString());
        }
        String uplusID = this.f31872a.getUplusID();
        if (TextUtils.isEmpty(uplusID)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter uplusId : " + uplusID, new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(", uplusid = ");
            sb.append(uplusID);
        }
        String productCode = this.f31872a.getProductCode();
        if (TextUtils.isEmpty(productCode)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter productCode : " + productCode, new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(", productCode = ");
            sb.append(productCode);
        }
        if (this.f31872a.getTimeout() < 30 || this.f31872a.getTimeout() > 120) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31872a.getTimeout(), new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(",timeout=");
            sb.append(this.f31872a.getTimeout());
        }
        if (error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            error.a(sb.toString().replaceFirst(",", ""));
            return error;
        }
        com.haier.uhome.control.cloud.api.c cVarA = uSDKDeviceManager.getSingleInstance().e().a(masterDevice.getDeviceId());
        return (cVarA == null || !(cVarA.n() == DeviceStatus.STATUS_CONNECTED || cVarA.n() == DeviceStatus.STATUS_READY)) ? ErrorConst.ERR_USDK_DEVICE_IS_OFFLINE.toError() : super.g();
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(iBindCallback, BindProgress.START_NETWORKING_MODE);
        new com.haier.library.common.thread.m<Void, Void, Void>() { // from class: com.haier.uhome.usdk.bind.x.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                x.this.f(iBindCallback);
                return null;
            }
        }.execute(new Void[0]);
    }

    private uSDKError a(String str, String str2, String str3, String str4, IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        uSDKError error = ErrorConst.ERR_USDK_ENTER_NETWORKING_MODE_TIMEOUT.toError();
        while (true) {
            if (e() < 5000) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "start pairing timeout result = " + error.toString(), new Object[0]);
                break;
            }
            error = a(str, str2, str3, str4, this.f31873b, iBindCallback);
            e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "start pairing once result = " + error.toString(), new Object[0]);
            if (error.a(ErrorConst.RET_USDK_OK.toError()) || (!error.a(ErrorConst.ERR_USDK_TIMEOUT) && error.getCode() != -25001)) {
                break;
            }
        }
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (error.a(errorConst)) {
            error = errorConst.toError();
        } else if (!error.a(ErrorConst.ERR_USDK_TIMEOUT) && error.getCode() != -25001) {
            iBindCallback.onFailure(error);
        } else {
            error = ErrorConst.ERR_USDK_ENTER_NETWORKING_MODE_TIMEOUT.toError();
            iBindCallback.onFailure(error);
        }
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "retry start pairing end result = " + error.toString(), new Object[0]);
        return error;
    }

    private uSDKError a(String str, final String str2, final String str3, final String str4, final String str5, final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        final com.haier.uhome.control.cloud.api.c cVarA = uSDKDeviceManager.getSingleInstance().e().a(str);
        if (cVarA == null) {
            return ErrorConst.ERR_USDK_DEVICE_IS_OFFLINE.toError();
        }
        return (uSDKError) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.bind.q1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31713a.a(cVarA, str2, str3, str4, str5, iBindCallback, gVar);
            }
        }, ErrorConst.ERR_USDK_TIMEOUT.toError(), 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.control.cloud.api.c cVar, String str, String str2, String str3, String str4, final IBindCallback iBindCallback, final com.haier.library.common.thread.g gVar) {
        cVar.a(str, str2, str3, str4, new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.x.6
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                x.this.a(iBindCallback, BindProgress.START_NETWORKING);
                gVar.a(ErrorConst.RET_USDK_OK.toError());
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                gVar.a(usdkerror);
            }
        });
    }
}
