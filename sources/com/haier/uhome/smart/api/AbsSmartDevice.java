package com.haier.uhome.smart.api;

import com.haier.library.okhttp.j0;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceBindStatusListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceMessageListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceOtaListener;
import com.haier.uhome.smart.api.interfaces.ISmartDevicePairingListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceResourceListener;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceVideoListener;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.c;
import com.haier.uhome.usdk.base.api.i;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.utils.b;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsSmartDevice {
    private boolean isUprade;
    private String mDeviceId;
    private String mDeviceKey;
    private String mDeviceName;
    private DeviceRole mRole;
    private String mUpCodeT;
    private String mUpgradeVersion;
    private String mUplusId;
    private CopyOnWriteArrayList<ISmartDeviceOtaListener> mSmartDeviceOtaListeners = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<ISmartDeviceResourceListener> mSmartDeviceResourceListeners = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<ISmartDeviceListener> mSmartDeviceListeners = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<ISmartDeviceVideoListener> mSmartDeviceVideoListeners = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<ISmartDeviceMessageListener> mSmartDeviceMessageListener = new CopyOnWriteArrayList<>();
    private List<ISmartDeviceBindStatusListener> mSmartDeviceBindStatusListener = new CopyOnWriteArrayList();

    protected static abstract class Builder<B extends Builder<B>> {
        String mDeviceId = "";
        String mDeviceName = "";
        String mUpCodeT = "";
        String mUplusId = "";
        String mDeviceKey = "";
        String mUpgradeVersion = "";
        boolean isUprade = false;
        DeviceRole mRole = DeviceRole.GENERAL_DEVICE;

        public B deviceId(String str) {
            this.mDeviceId = str;
            return this;
        }

        public B deviceKey(String str) {
            this.mDeviceKey = str;
            return this;
        }

        public B deviceName(String str) {
            this.mDeviceName = str;
            return this;
        }

        public B deviceRole(DeviceRole deviceRole) {
            this.mRole = deviceRole;
            return this;
        }

        public B isUpgrade(boolean z7) {
            this.isUprade = z7;
            return this;
        }

        public B upCodeT(String str) {
            this.mUpCodeT = str;
            return this;
        }

        public B upgradeVersion(String str) {
            this.mUpgradeVersion = str;
            return this;
        }

        public B uplusId(String str) {
            this.mUplusId = str;
            return this;
        }
    }

    public AbsSmartDevice(Builder builder) {
        this.mDeviceId = builder.mDeviceId;
        this.mDeviceName = builder.mDeviceName;
        this.mUpCodeT = builder.mUpCodeT;
        this.mUplusId = builder.mUplusId;
        this.mDeviceKey = builder.mDeviceKey;
        this.mUpgradeVersion = builder.mUpgradeVersion;
        this.isUprade = builder.isUprade;
        this.mRole = builder.mRole;
    }

    public abstract void addDeviceRelation(String str, String str2, ICallback<Void> iCallback);

    public synchronized void addOtaListener(ISmartDeviceOtaListener iSmartDeviceOtaListener) {
        if (iSmartDeviceOtaListener != null) {
            this.mSmartDeviceOtaListeners.add(iSmartDeviceOtaListener);
        }
    }

    public synchronized void addSmartDeviceBindStatusListener(ISmartDeviceBindStatusListener iSmartDeviceBindStatusListener) {
        if (iSmartDeviceBindStatusListener != null) {
            this.mSmartDeviceBindStatusListener.add(iSmartDeviceBindStatusListener);
        }
    }

    public synchronized void addSmartDeviceListener(ISmartDeviceListener iSmartDeviceListener) {
        if (iSmartDeviceListener != null) {
            this.mSmartDeviceListeners.add(iSmartDeviceListener);
        }
    }

    public synchronized void addSmartDeviceMessageListener(ISmartDeviceMessageListener iSmartDeviceMessageListener) {
        if (iSmartDeviceMessageListener != null) {
            this.mSmartDeviceMessageListener.add(iSmartDeviceMessageListener);
        }
    }

    public abstract void addSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener);

    public synchronized void addSmartDeviceVideoListener(ISmartDeviceVideoListener iSmartDeviceVideoListener) {
        if (iSmartDeviceVideoListener != null) {
            this.mSmartDeviceVideoListeners.add(iSmartDeviceVideoListener);
        }
    }

    public synchronized void addSmartdeviceResourceListener(ISmartDeviceResourceListener iSmartDeviceResourceListener) {
        if (iSmartDeviceResourceListener != null) {
            this.mSmartDeviceResourceListeners.add(iSmartDeviceResourceListener);
        }
    }

    public abstract void bindDevice(String str, double d8, ICallback<Void> iCallback);

    public void bindWindow(int i7, final ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().bindWindow(getDeviceId(), i7, new o() { // from class: com.haier.uhome.smart.api.AbsSmartDevice.4
            @Override // com.haier.uhome.usdk.base.api.o
            public void onCallback(ErrorConst errorConst) {
                if (errorConst == ErrorConst.RET_USDK_OK) {
                    b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    b.a(iCallback, errorConst.toError());
                }
            }
        });
    }

    public void getBindQrCode(double d8, final ICallback<String> iCallback) {
        SmartDeviceService.getInstance().getBindQRCode(this, d8, new i<String>() { // from class: com.haier.uhome.smart.api.AbsSmartDevice.5
            @Override // com.haier.uhome.usdk.base.api.i
            public void onCallback(c<String> cVar) {
                if (cVar.b().getCode() == ErrorConst.RET_USDK_OK.getErrorId()) {
                    b.a((ICallback<String>) iCallback, cVar.c());
                } else {
                    b.a(iCallback, cVar.b());
                }
            }
        });
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getDeviceKey() {
        return this.mDeviceKey;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public DeviceRole getRole() {
        return this.mRole;
    }

    public List<ISmartDeviceBindStatusListener> getSmartDeviceBindStatusListener() {
        return this.mSmartDeviceBindStatusListener;
    }

    public CopyOnWriteArrayList<ISmartDeviceListener> getSmartDeviceListerner() {
        return this.mSmartDeviceListeners;
    }

    public CopyOnWriteArrayList<ISmartDeviceMessageListener> getSmartDeviceMessageListener() {
        return this.mSmartDeviceMessageListener;
    }

    public CopyOnWriteArrayList<ISmartDeviceOtaListener> getSmartDeviceOtaListeners() {
        return this.mSmartDeviceOtaListeners;
    }

    public abstract CopyOnWriteArrayList<ISmartDevicePairingListener> getSmartDevicePairingListeners();

    public CopyOnWriteArrayList<ISmartDeviceResourceListener> getSmartDeviceResourceListener() {
        return this.mSmartDeviceResourceListeners;
    }

    public CopyOnWriteArrayList<ISmartDeviceVideoListener> getSmartDeviceVideoListeners() {
        return this.mSmartDeviceVideoListeners;
    }

    public String getUpCodeT() {
        return this.mUpCodeT;
    }

    public String getUpgradeVersion() {
        return this.mUpgradeVersion;
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    public void initIotVideo(String str, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().initIotVideo(getDeviceId(), str, iCallback);
    }

    public boolean isUprade() {
        return this.isUprade;
    }

    public void mcsServerInit(ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().mcsServerInit(getDeviceId(), iCallback);
    }

    public void messagePushInit(ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().messagePushInit(iCallback);
    }

    public void otaFinish(String str, int i7, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().otaFinish(getDeviceId(), str, i7, iCallback);
    }

    public void otaInit(int i7, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().otaInit(i7, iCallback);
    }

    public void queryBindStatus(int i7, int i8, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().queryBindStatus(getDeviceId(), i7, i8, iCallback);
    }

    public void registerDownloadOtapkgCb(String str, String str2, String str3, String str4, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().registerDownloadOtapkgCb(str, str2, str3, str4, iCallback);
    }

    public void registerMessagePush(MessagePush messagePush, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().registerMessagePush(messagePush, iCallback);
    }

    public void registerResource(String str, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().registerResource(getDeviceId(), str, iCallback);
    }

    public void reportAlarm(List<SmartDevicePair> list, final ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().reportAlarm(getDeviceId(), list, new o() { // from class: com.haier.uhome.smart.api.AbsSmartDevice.2
            @Override // com.haier.uhome.usdk.base.api.o
            public void onCallback(ErrorConst errorConst) {
                if (errorConst == ErrorConst.RET_USDK_OK) {
                    b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    b.a(iCallback, errorConst.toError());
                }
            }
        });
    }

    public void reportBigData(String str, String str2, final ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().reportBigData(getDeviceId(), str, str2, new o() { // from class: com.haier.uhome.smart.api.AbsSmartDevice.3
            @Override // com.haier.uhome.usdk.base.api.o
            public void onCallback(ErrorConst errorConst) {
                if (errorConst == ErrorConst.RET_USDK_OK) {
                    b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    b.a(iCallback, errorConst.toError());
                }
            }
        });
    }

    public abstract void reportBindProcess(int i7, String str, String str2, String str3, int i8, String str4, ICallback<Void> iCallback);

    public void reportMessageStatus(MessageStatusAck messageStatusAck, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().reportMessageStatus(messageStatusAck, iCallback);
    }

    public void reportResource(String str, byte[] bArr, int i7, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().reportResource(getDeviceId(), str, bArr, i7, iCallback);
    }

    public void reportStatus(List<SmartDevicePair> list, final ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().reportStatus(getDeviceId(), list, new o() { // from class: com.haier.uhome.smart.api.AbsSmartDevice.1
            @Override // com.haier.uhome.usdk.base.api.o
            public void onCallback(ErrorConst errorConst) {
                if (errorConst == ErrorConst.RET_USDK_OK) {
                    b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    b.a(iCallback, errorConst.toError());
                }
            }
        });
    }

    public synchronized void rmOtaListener(ISmartDeviceOtaListener iSmartDeviceOtaListener) {
        if (iSmartDeviceOtaListener != null) {
            this.mSmartDeviceOtaListeners.remove(iSmartDeviceOtaListener);
        }
    }

    public synchronized void rmSmartDeviceBindStatusListener(ISmartDeviceBindStatusListener iSmartDeviceBindStatusListener) {
        if (iSmartDeviceBindStatusListener != null) {
            this.mSmartDeviceBindStatusListener.remove(iSmartDeviceBindStatusListener);
        }
    }

    public synchronized void rmSmartDeviceListener(ISmartDeviceListener iSmartDeviceListener) {
        if (iSmartDeviceListener != null) {
            this.mSmartDeviceListeners.remove(iSmartDeviceListener);
        }
    }

    public synchronized void rmSmartDeviceMessageListener(ISmartDeviceMessageListener iSmartDeviceMessageListener) {
        if (iSmartDeviceMessageListener != null) {
            this.mSmartDeviceMessageListener.remove(iSmartDeviceMessageListener);
        }
    }

    public abstract void rmSmartDevicePairingListener(ISmartDevicePairingListener iSmartDevicePairingListener);

    public synchronized void rmSmartDeviceVideoListener(ISmartDeviceVideoListener iSmartDeviceVideoListener) {
        if (iSmartDeviceVideoListener != null) {
            this.mSmartDeviceOtaListeners.remove(iSmartDeviceVideoListener);
        }
    }

    public synchronized void rmSmartdeviceResourceListener(ISmartDeviceResourceListener iSmartDeviceResourceListener) {
        if (iSmartDeviceResourceListener != null) {
            this.mSmartDeviceResourceListeners.remove(iSmartDeviceResourceListener);
        }
    }

    public uSDKError sendIotAudio(byte[] bArr, int i7, long j7, int i8) {
        return SmartDeviceService.getInstance().sendIotAudio(getDeviceId(), bArr, i7, j7, i8);
    }

    public uSDKError sendIotVideo(byte[] bArr, int i7, long j7, int i8) {
        return SmartDeviceService.getInstance().sendIotVideo(getDeviceId(), bArr, i7, j7, i8);
    }

    public void setOtaMode(OtaMode otaMode, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().setOtaMode(getDeviceId(), otaMode, iCallback);
    }

    public abstract void startPairingRsp(int i7, int i8, ICallback<Void> iCallback);

    public void unRegisterMessagePush(String str, int i7, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().unRegisterMessagePush(getDeviceId(), str, i7, iCallback);
    }

    public void unRegisterResource(String str, ICallback<Void> iCallback) {
        SmartDeviceService.getInstance().unRegisterResource(getDeviceId(), str, iCallback);
    }

    public void uploadResource(String str, j0 j0Var, String str2, int i7, ICallback<ResourceFile> iCallback) {
        SmartDeviceService.getInstance().uploadResource(getDeviceId(), str, j0Var, str2, i7, iCallback);
    }
}
