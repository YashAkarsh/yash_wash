package com.haier.uhome.usdk.bind;

import android.graphics.Bitmap;
import com.haier.uhome.config.entity.ConfigRouterInfo;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.api.uSDKState;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;
import com.haier.uhome.usdk.scanner.DeviceModelInfo;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class Binding {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Binding f31464a = new Binding();

        private a() {
        }
    }

    private void b(BLEBindInfo bLEBindInfo, IBindResultCallback<uSDKDevice> iBindResultCallback) {
        final IBindResultCallback iBindResultCallback2 = (IBindResultCallback) com.haier.uhome.usdk.base.utils.b.a((Object) iBindResultCallback, (Class<?>) IBindResultCallback.class);
        new e(bLEBindInfo).c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.9
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                iBindResultCallback2.onSuccess(wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                iBindResultCallback2.notifyProgress(bindProgress, str, str2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iBindResultCallback2.onFailure(usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    @Keep
    public static Binding getSingleInstance() {
        return a.f31464a;
    }

    @Keep
    public void bindBLEAdvDevice(BLEAdvBindInfo bLEAdvBindInfo, final IBindResultCallback<uSDKDevice> iBindResultCallback) {
        new BLEAdvBindImpl(bLEAdvBindInfo).c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.7
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindResultCallback iBindResultCallback2 = iBindResultCallback;
                if (iBindResultCallback2 != null) {
                    iBindResultCallback2.notifyProgress(bindProgress, str, str2);
                } else {
                    e3.a.e("callback is null", new Object[0]);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    @Keep
    public void bindBLEMeshDevice(BLEMeshBindInfo bLEMeshBindInfo, IBindResultCallback<uSDKDevice> iBindResultCallback) {
        final IBindResultCallback iBindResultCallback2 = (IBindResultCallback) com.haier.uhome.usdk.base.utils.b.a((Object) iBindResultCallback, (Class<?>) IBindResultCallback.class);
        new g(bLEMeshBindInfo).c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                iBindResultCallback2.onSuccess(wVar.a());
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                iBindResultCallback2.notifyProgress(bindProgress, str, str2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iBindResultCallback2.onFailure(usdkerror);
            }
        });
    }

    @Keep
    public void bindCellularDevice(@c.m0 CellularDeviceBindInfo cellularDeviceBindInfo, @c.m0 IBindCellularDeviceCallback iBindCellularDeviceCallback) {
        new o(cellularDeviceBindInfo).bind(iBindCellularDeviceCallback);
    }

    @Keep
    public void bindDeviceByBLE(ConfigurableDevice configurableDevice, BLEBindInfo bLEBindInfo, IBindResultCallback<uSDKDevice> iBindResultCallback) {
        if (bLEBindInfo != null) {
            bLEBindInfo = bLEBindInfo.rebuild().setConfigurableDevice(configurableDevice).build();
        }
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindDeviceByBLE");
        if ((configurableDevice != null ? configurableDevice.getProtocolVers() : 0) == 5) {
            b(bLEBindInfo, iBindResultCallback);
        } else {
            a(bLEBindInfo, iBindResultCallback);
        }
    }

    @Keep
    public void bindDeviceByCameraScanQRCode(CameraQRCodeBindInfo cameraQRCodeBindInfo, IBindByCameraScanQRCodeCallback iBindByCameraScanQRCodeCallback) {
        final IBindByCameraScanQRCodeCallback iBindByCameraScanQRCodeCallback2 = (IBindByCameraScanQRCodeCallback) com.haier.uhome.usdk.base.utils.b.a((Object) iBindByCameraScanQRCodeCallback, (Class<?>) IBindByCameraScanQRCodeCallback.class);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindDeviceByCameraScanQRCode");
        new m(cameraQRCodeBindInfo).c((IBindCallback<com.haier.uhome.usdk.api.w>) new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.16
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                iBindByCameraScanQRCodeCallback2.onSuccess(wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iBindByCameraScanQRCodeCallback2.onFailure(usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }

            @Override // com.haier.uhome.usdk.bind.a
            public void a(Bitmap bitmap) {
                iBindByCameraScanQRCodeCallback2.onQRCodeImageCallback(bitmap);
            }
        });
    }

    @Keep
    public void bindDeviceByQRCode(QRCodeBindInfo qRCodeBindInfo, final ICallback<uSDKDevice> iCallback) {
        v vVar = new v(qRCodeBindInfo);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindDeviceByQRCode");
        vVar.c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.15
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<uSDKDevice>) iCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    @Keep
    public void bindDeviceBySmartLink(SmartLinkBindInfo smartLinkBindInfo, IBindResultCallback<uSDKDevice> iBindResultCallback) {
        a(smartLinkBindInfo, iBindResultCallback);
    }

    @Keep
    public void bindDeviceBySmartLinkAuto(final SmartLinkBindInfo smartLinkBindInfo, final IAutoBindCallback<uSDKDevice> iAutoBindCallback) {
        b bVarA = b.a(smartLinkBindInfo, iAutoBindCallback);
        if (bVarA == null) {
            a(smartLinkBindInfo, iAutoBindCallback);
        } else {
            bVarA.a(new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.Binding.14
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    Binding.this.a(smartLinkBindInfo, iAutoBindCallback);
                }
            });
        }
    }

    @Keep
    public void bindDeviceBySoftAp(SoftApBindInfo softApBindInfo, final ISoftApResultCallback<uSDKDevice> iSoftApResultCallback) {
        z zVar = new z(softApBindInfo);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindDeviceBySoftAp");
        zVar.c(new IBindCallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.12
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iSoftApResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                ISoftApResultCallback iSoftApResultCallback2 = iSoftApResultCallback;
                if (iSoftApResultCallback2 != null) {
                    iSoftApResultCallback2.notifyProgress(bindProgress, str, str2);
                } else {
                    e3.a.e("callback is null", new Object[0]);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iSoftApResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }

            @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
            public void switchNetworkNotify() {
                ISoftApResultCallback iSoftApResultCallback2 = iSoftApResultCallback;
                if (iSoftApResultCallback2 != null) {
                    iSoftApResultCallback2.switchNetworkNotify();
                } else {
                    e3.a.e("callback is null", new Object[0]);
                }
            }
        });
    }

    @Keep
    public void bindDeviceWithoutWifi(WithoutWifiBindInfo withoutWifiBindInfo, IBindResultCallback<uSDKDevice> iBindResultCallback) {
        final IBindResultCallback iBindResultCallback2 = (IBindResultCallback) com.haier.uhome.usdk.base.utils.b.a((Object) iBindResultCallback, (Class<?>) IBindResultCallback.class);
        new f(withoutWifiBindInfo).c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.10
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                iBindResultCallback2.onSuccess(wVar.a());
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                iBindResultCallback2.notifyProgress(bindProgress, str, str2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iBindResultCallback2.onFailure(usdkerror);
            }
        });
    }

    @Keep
    public void bindNewDirectLinkDevice(NewDirectLinkManualConfirmBindInfo newDirectLinkManualConfirmBindInfo, final IBindResultCallback<uSDKDevice> iBindResultCallback) {
        q qVar = new q(newDirectLinkManualConfirmBindInfo);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindNewDirectLinkDevice");
        qVar.c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindResultCallback iBindResultCallback2 = iBindResultCallback;
                if (iBindResultCallback2 != null) {
                    iBindResultCallback2.notifyProgress(bindProgress, str, str2);
                } else {
                    e3.a.e("callback is null", new Object[0]);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    @Keep
    public void bindPureBLEDevice(PureBLEBindInfo pureBLEBindInfo, final IBindResultCallback<uSDKDevice> iBindResultCallback) {
        k uVar = com.haier.library.common.util.c.c(pureBLEBindInfo.getConfigurableDevice().getDeviceInfo().w(), com.haier.uhome.usdk.base.a.be) ? new u(pureBLEBindInfo) : new t(pureBLEBindInfo);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindPureBLEDevice");
        uVar.c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.11
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindResultCallback iBindResultCallback2 = iBindResultCallback;
                if (iBindResultCallback2 != null) {
                    iBindResultCallback2.notifyProgress(bindProgress, str, str2);
                } else {
                    e3.a.e("callback is null", new Object[0]);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    @Keep
    public void bindSlaveDevice(SlaveDeviceBindInfo slaveDeviceBindInfo, final IBindResultCallback<uSDKDevice> iBindResultCallback) {
        x xVar = new x(slaveDeviceBindInfo);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindSlaveDevice");
        xVar.c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindResultCallback iBindResultCallback2 = iBindResultCallback;
                if (iBindResultCallback2 == null) {
                    return;
                }
                iBindResultCallback2.notifyProgress(bindProgress, str, str2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    @Keep
    public void getConfigRouterInfo(int i7, ICallback<ConfigRouterInfo> iCallback) {
        com.haier.uhome.config.a.c.a().a(i7, (ICallback<ConfigRouterInfo>) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class));
    }

    @Keep
    public void getDeviceModelInfo(int i7, String str, String str2, final ICallback<DeviceModelInfo> iCallback) {
        e3.a.e("getDeviceModelInfo in timeOut = %d,deviceName = %s,bssid = %s", Integer.valueOf(i7), str, str2);
        if (uSDKState.STATE_STARTED != uSDKManager.getSingleInstance().getSDKState()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_UNSTARTED.toError());
        } else {
            com.haier.library.sumhttp.request.a.h().b(i7, com.haier.uhome.usdk.base.utils.f.h(str), com.haier.library.common.util.w.c(str2), "", new ICallback<n3.f>() { // from class: com.haier.uhome.usdk.bind.Binding.8
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(n3.f fVar) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<DeviceModelInfo>) iCallback, new DeviceModelInfo(fVar));
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            });
        }
    }

    @Keep
    public void openUserBindTimeWindow(String str, String str2, int i7, final ICallback<Void> iCallback) {
        s.a().a(str, str2, i7, new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.Binding.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
            }
        });
    }

    @Keep
    public void retryBindDevice(int i7, ICallback<uSDKDevice> iCallback) {
        RetryBindDeviceHandler.getSingleInstance().retryBindDevice(i7, iCallback);
    }

    private Binding() {
    }

    private void a(BLEBindInfo bLEBindInfo, final IBindResultCallback<uSDKDevice> iBindResultCallback) {
        new d(bLEBindInfo).c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindResultCallback iBindResultCallback2 = iBindResultCallback;
                if (iBindResultCallback2 != null) {
                    iBindResultCallback2.notifyProgress(bindProgress, str, str2);
                } else {
                    e3.a.e("callback is null", new Object[0]);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SmartLinkBindInfo smartLinkBindInfo, final IBindResultCallback<uSDKDevice> iBindResultCallback) {
        y yVar = new y(smartLinkBindInfo);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindDeviceBySmartLink");
        yVar.c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.13
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindResultCallback iBindResultCallback2 = iBindResultCallback;
                if (iBindResultCallback2 == null) {
                    return;
                }
                iBindResultCallback2.notifyProgress(bindProgress, str, str2);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }

    @Keep
    public void bindNewDirectLinkDevice(NewDirectLinkVerificationCodeBindInfo newDirectLinkVerificationCodeBindInfo, final IBindResultCallback<uSDKDevice> iBindResultCallback) {
        r rVar = new r(newDirectLinkVerificationCodeBindInfo);
        RetryBindDeviceHandler.getSingleInstance().setBindType("bindNewDirectLinkDevice");
        rVar.c(new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.Binding.6
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindResultCallback, wVar.a());
                RetryBindDeviceHandler.getSingleInstance().k();
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindResultCallback iBindResultCallback2 = iBindResultCallback;
                if (iBindResultCallback2 != null) {
                    iBindResultCallback2.notifyProgress(bindProgress, str, str2);
                } else {
                    e3.a.e("callback is null", new Object[0]);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindResultCallback, usdkerror);
                RetryBindDeviceHandler.getSingleInstance().a(usdkerror);
            }
        });
    }
}
