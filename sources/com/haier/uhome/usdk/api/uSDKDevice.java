package com.haier.uhome.usdk.api;

import android.os.SystemClock;
import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.control.cloud.api.DeviceFOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.control.cloud.api.ModuleInfo;
import com.haier.uhome.control.local.api.UpdateProgress;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.interfaces.IProgressCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKGetDeviceBindInfoCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKGetDeviceNetQualityCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKOTACallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKReadAttributeCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKResultCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKUpdateRouterSSIDCallBack;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.r;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKDevice extends uSDKDeviceInfo implements Observer {
    private static final int MAX_TIME_WINDOW = 600000;
    private static final int RET_SDK_CTRL_TIMEOUT = -25001;
    private static final long serialVersionUID = -7919399627544268516L;
    Runnable adjustRunnable;
    private volatile com.haier.uhome.usdk.api.interfaces.a bleOTAHandler;
    private FOTAInfo cachedFOTAInfo;
    private k deviceListener;
    private List<com.haier.uhome.control.base.api.b> mAlarmList;
    private ConcurrentHashMap<String, com.haier.uhome.control.base.api.d> mAttrMap;
    private String mAuthInvalidDeviceId;
    private ConcurrentHashMap<String, String> mBaseInfoMap;
    private l mBestConnect;
    private String mBindInfoDeviceId;
    private String mBindInfoIp;
    private int mBindInfoPort;
    private com.haier.uhome.control.local.api.d mBleMeshDevice;
    private com.haier.uhome.control.cloud.api.c mCloudDevice;
    private com.haier.uhome.control.base.api.i mControlDeviceListener;
    private com.haier.uhome.usdk.api.interfaces.d mDeviceDelListener;
    private b mDeviceInfoMonitor;
    private DeviceStatus mDeviceStatus;
    private com.haier.uhome.usdk.api.a.d mEventHandler;
    private com.haier.uhome.usdk.c.e mExecutor;
    private com.haier.uhome.control.base.api.i mGrabControlListener;
    private Map<String, uSDKDevice> mGroupMemberMap;
    private AtomicBoolean mIsShow;
    private com.haier.uhome.control.local.api.g mLocalBLEDevice;
    private com.haier.uhome.control.local.api.h mLocalDevice;
    private com.haier.uhome.control.local.api.i mLocalGatewayDevice;
    private String mMainDeviceId;
    private AtomicBoolean mNeedProperty;
    private uSDKDeviceNetTypeConst mNetTypeConst;
    private com.haier.uhome.control.noumenon.a.a mNoumenonDevice;
    private h mOTAHandler;
    private com.haier.uhome.control.cloud.api.e mP2PHandle;
    private v mSDKDeviceBleEventInfo;
    private uSDKFaultInformation mSDKFaultInformation;
    private List<com.haier.uhome.control.base.api.a> mSortControlDeviceList;
    private Map<String, uSDKDevice> mSubDeviceMap;
    private DeviceListener mSubscribeDeviceListener;
    private com.haier.uhome.usdk.base.api.p mSystemListener;
    private com.haier.library.common.util.b0 mTimeWindowTimer;
    private com.haier.uhome.usdk.base.service.e.a mTokenObserver;
    private com.haier.uhome.control.base.api.a mTopControlDevice;
    private IuSDKUpdateRouterSSIDCallBack mUpdateRouterCallBack;
    private com.haier.library.common.util.b0 mUpdateRouterTimer;
    private i mWifiOTAHandler;
    private volatile com.haier.uhome.usdk.api.interfaces.a meshOTAHandler;
    private int offlineReason;
    private int stateCode;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.uSDKDevice$10, reason: invalid class name */
    class AnonymousClass10 implements ICallback<com.haier.uhome.control.base.api.s> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ICallback f30755a;

        AnonymousClass10(ICallback iCallback) {
            this.f30755a = iCallback;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            uSDKDevice.this.callbackWithError(this.f30755a, usdkerror);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(final com.haier.uhome.control.base.api.s sVar) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final ICallback iCallback = this.f30755a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.usdk.api.m4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30644a.a(iCallback, sVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(ICallback iCallback, com.haier.uhome.control.base.api.s sVar) {
            iCallback.onSuccess(new uSDKNetworkQualityInfoV2(uSDKDevice.this.getConnectStatus(), sVar));
        }
    }

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.uSDKDevice$20, reason: invalid class name */
    static /* synthetic */ class AnonymousClass20 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f30774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f30775c;

        static {
            int[] iArr = new int[com.haier.uhome.usdk.base.api.f.h.values().length];
            f30775c = iArr;
            try {
                iArr[com.haier.uhome.usdk.base.api.f.h.IP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30775c[com.haier.uhome.usdk.base.api.f.h.PORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30775c[com.haier.uhome.usdk.base.api.f.h.SECURITY_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30775c[com.haier.uhome.usdk.base.api.f.h.UPLUS_ID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30775c[com.haier.uhome.usdk.base.api.f.h.BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30775c[com.haier.uhome.usdk.base.api.f.h.DEV_PROTOCOL_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30775c[com.haier.uhome.usdk.base.api.f.h.GROUP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30775c[com.haier.uhome.usdk.base.api.f.h.AUX_CONFIG_CAPABILITY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[uSDKDeviceNetTypeConst.values().length];
            f30774b = iArr2;
            try {
                iArr2[uSDKDeviceNetTypeConst.NET_LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30774b[uSDKDeviceNetTypeConst.NET_REMOTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f30774b[uSDKDeviceNetTypeConst.NET_NOUMENON.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f30774b[uSDKDeviceNetTypeConst.NET_BLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f30774b[uSDKDeviceNetTypeConst.NET_MESH.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f30774b[uSDKDeviceNetTypeConst.NET_LOCAL_GATEWAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr3 = new int[DeviceStatus.values().length];
            f30773a = iArr3;
            try {
                iArr3[DeviceStatus.STATUS_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f30773a[DeviceStatus.STATUS_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f30773a[DeviceStatus.STATUS_OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f30773a[DeviceStatus.STATUS_CONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f30773a[DeviceStatus.STATUS_UNCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f30808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f30809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f30810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private DeviceStatus f30811d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f30812e;

        public a(String str, String str2, String str3) {
            this.f30808a = str;
            this.f30809b = str2;
            this.f30810c = str3;
        }

        public String toString() {
            return "BaseInfo{devId=" + this.f30808a + ", uplusId=" + this.f30809b + ", bleDevId=" + this.f30810c + '}';
        }

        public void a(int i7) {
            this.f30812e = i7;
        }

        public String b() {
            return this.f30809b;
        }

        public String c() {
            return this.f30810c;
        }

        public void a(DeviceStatus deviceStatus) {
            this.f30811d = deviceStatus;
        }

        public String a() {
            return this.f30808a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.haier.uhome.usdk.base.api.f.e f30814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ArrayList<com.haier.uhome.usdk.base.api.f.h> f30815c;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            Iterator<com.haier.uhome.usdk.base.api.f.h> it = this.f30815c.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
            this.f30815c.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(com.haier.uhome.usdk.base.api.f.h hVar) {
            if (b(hVar)) {
                Iterator<com.haier.uhome.usdk.base.api.f.h> it = this.f30815c.iterator();
                while (it.hasNext()) {
                    if (b(it.next())) {
                        e3.a.e("uSDKDevice monitor destroy %s change", hVar);
                        return;
                    }
                }
            }
            e3.a.e("uSDKDevice monitor add %s change to deviceInfoChangeMessageList", hVar);
            this.f30815c.add(hVar);
        }

        private b() {
            this.f30815c = new ArrayList<>();
            a();
        }

        private void c(com.haier.uhome.usdk.base.api.f.h hVar) {
            e3.a.e("uSDKDevice monitor handle %s change", hVar);
            switch (AnonymousClass20.f30775c[hVar.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    uSDKDevice usdkdevice = uSDKDevice.this;
                    usdkdevice.reconnectControlDevice(usdkdevice.mLocalDevice);
                    if (uSDKDevice.this.mTopControlDevice == uSDKDevice.this.mLocalDevice) {
                        uSDKDevice.this.notifyBaseInfoChange();
                    }
                    break;
                case 4:
                    String strC = com.haier.uhome.usdk.base.api.g.a().a(uSDKDevice.this.getDeviceId()).c();
                    if (!TextUtils.isEmpty(strC)) {
                        uSDKDevice.this.setUplusId(strC);
                    }
                    uSDKDevice usdkdevice2 = uSDKDevice.this;
                    usdkdevice2.reconnectControlDevice(usdkdevice2.mLocalDevice);
                    uSDKDevice usdkdevice3 = uSDKDevice.this;
                    usdkdevice3.reconnectControlDevice(usdkdevice3.mCloudDevice);
                    uSDKDevice.this.notifyBaseInfoChange();
                    break;
                case 5:
                    uSDKDevice.this.adjust();
                    if (uSDKDevice.this.mTopControlDevice == uSDKDevice.this.mLocalDevice) {
                        uSDKDevice.this.notifyBaseInfoChange();
                    }
                    break;
                case 6:
                    uSDKDevice usdkdevice4 = uSDKDevice.this;
                    usdkdevice4.reconnectControlDevice(usdkdevice4.mLocalDevice);
                    break;
                case 7:
                    uSDKDevice.this.adjust();
                    a(uSDKDevice.this.mBleMeshDevice);
                    a(uSDKDevice.this.mLocalGatewayDevice);
                    a(uSDKDevice.this.mCloudDevice);
                    break;
                case 8:
                    uSDKDevice usdkdevice5 = uSDKDevice.this;
                    usdkdevice5.reconnectControlDevice(usdkdevice5.mLocalDevice);
                    uSDKDevice usdkdevice6 = uSDKDevice.this;
                    usdkdevice6.reconnectControlDevice(usdkdevice6.mCloudDevice);
                    break;
            }
        }

        private void a(final com.haier.uhome.usdk.base.api.f.h hVar) {
            com.haier.uhome.usdk.api.b.b.a().a(new Runnable() { // from class: com.haier.uhome.usdk.api.q4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30704a.e(hVar);
                }
            });
        }

        private boolean b(com.haier.uhome.usdk.base.api.f.h hVar) {
            return hVar == com.haier.uhome.usdk.base.api.f.h.IP || hVar == com.haier.uhome.usdk.base.api.f.h.PORT;
        }

        private void a(long j7) {
            com.haier.uhome.usdk.api.b.b.a().a(new Runnable() { // from class: com.haier.uhome.usdk.api.o4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30677a.d();
                }
            }, j7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(uSDKDevice.this.getDeviceId());
            if (fVarA == null) {
                e3.a.h("find DeviceInfo with device id=%s fail!!", uSDKDevice.this.getDeviceId());
            } else {
                fVarA.a().a(this.f30814b);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(com.haier.uhome.usdk.base.api.f.h hVar) {
            a(hVar);
            a(100L);
        }

        private void a() {
            this.f30814b = new com.haier.uhome.usdk.base.api.f.e() { // from class: com.haier.uhome.usdk.api.p4
                @Override // com.haier.uhome.usdk.base.api.f.e
                public final void onChange(com.haier.uhome.usdk.base.api.f.h hVar) {
                    this.f30694a.d(hVar);
                }
            };
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a(com.haier.uhome.control.base.api.o oVar) {
            if (oVar == 0) {
                return;
            }
            e3.a.e("refreshGroup with type:" + ((com.haier.uhome.control.base.api.a) oVar).e(), new Object[0]);
            oVar.e_();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(uSDKDevice.this.getDeviceId());
            if (fVarA == null) {
                e3.a.h("find DeviceInfo with device id=%s fail!!", uSDKDevice.this.getDeviceId());
            } else {
                fVarA.a().b(this.f30814b);
            }
        }
    }

    @Deprecated
    public uSDKDevice(String str) {
        this(str, (String) null, false);
        this.mAuthInvalidDeviceId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjust() {
        this.mExecutor.a(this.adjustRunnable);
    }

    private DeviceStatus bindConditionIntoStatus(DeviceStatus deviceStatus) {
        com.haier.uhome.control.noumenon.a.a aVar;
        DeviceStatus deviceStatus2;
        if (getSecurityVersion() == 0 || (aVar = this.mNoumenonDevice) != null || this.mCloudDevice != null || aVar != null || deviceStatus == (deviceStatus2 = DeviceStatus.STATUS_OFFLINE) || deviceStatus == DeviceStatus.STATUS_UNCONNECT) {
            return deviceStatus;
        }
        e3.a.e("bindConditionIntoStatus into device<%s> chance %s to %s", getDeviceId(), deviceStatus, deviceStatus2);
        return deviceStatus2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void callUpdateRouterFailure(uSDKError usdkerror) {
        IuSDKUpdateRouterSSIDCallBack iuSDKUpdateRouterSSIDCallBack = this.mUpdateRouterCallBack;
        if (iuSDKUpdateRouterSSIDCallBack != null) {
            iuSDKUpdateRouterSSIDCallBack.onFailure(usdkerror);
            this.mUpdateRouterCallBack = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackWithError(final ICallback iCallback, final uSDKError usdkerror) {
        if (iCallback == null) {
            return;
        }
        if (usdkerror == null) {
            e3.a.v("callbackWithError with null error object!!,so return with no callback", new Object[0]);
        } else {
            e3.a.v("callbackWithError error <%s>", usdkerror.toString());
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.l4
                @Override // java.lang.Runnable
                public final void run() {
                    iCallback.onFailure(usdkerror);
                }
            });
        }
    }

    private DeviceStatus careIntoStatus(DeviceStatus deviceStatus) {
        if (isCare()) {
            return deviceStatus == DeviceStatus.STATUS_UNCONNECT ? DeviceStatus.STATUS_OFFLINE : deviceStatus;
        }
        DeviceStatus deviceStatus2 = DeviceStatus.STATUS_UNCONNECT;
        return deviceStatus != deviceStatus2 ? deviceStatus2 : deviceStatus;
    }

    private synchronized void checkAndCreate() {
        com.haier.uhome.control.local.api.d dVar;
        com.haier.uhome.control.local.api.g gVar;
        if (this.bleOTAHandler == null && (gVar = this.mLocalBLEDevice) != null) {
            this.bleOTAHandler = new e(gVar);
        }
        if (this.meshOTAHandler == null && (dVar = this.mBleMeshDevice) != null) {
            this.meshOTAHandler = new g(dVar);
        }
    }

    private void checkBleMeshOtaInfo(ICallback<FOTAInfo> iCallback) {
        checkAndCreate();
        ICallback<FOTAInfo> iCallback2 = (ICallback) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class);
        if (this.meshOTAHandler != null) {
            this.meshOTAHandler.a(iCallback2);
        }
    }

    private void checkBleOtaInfo(ICallback<FOTAInfo> iCallback) {
        checkAndCreate();
        ICallback<FOTAInfo> iCallback2 = (ICallback) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class);
        if (this.bleOTAHandler != null) {
            this.bleOTAHandler.a(iCallback2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkDelLocal() {
        return checkDelLocal(this.mLocalDevice, uSDKDeviceNetTypeConst.NET_LOCAL) || checkDelLocal(this.mLocalBLEDevice, uSDKDeviceNetTypeConst.NET_BLE);
    }

    private uSDKErrorConst checkFOTADeviceState() {
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (this.mLocalDevice == null || cVar != null) {
            return cVar == null ? uSDKErrorConst.ERR_INTERNAL : uSDKErrorConst.RET_USDK_OK;
        }
        return uSDKErrorConst.ERR_USDK_DEVICE_IS_NOT_BOUND;
    }

    private void checkNotifyDel() {
        if (!isCare() && this.mIsShow.get()) {
            if (com.haier.library.common.util.u.h(getRealDeviceList())) {
                destroy();
                if (this.mIsShow.compareAndSet(true, false)) {
                    notifyDel();
                    return;
                }
                return;
            }
            if (isHideDevice() && this.mIsShow.compareAndSet(true, false)) {
                notifyDel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeviceBleEvent() {
        this.mEventHandler.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOfflineReason() {
        setOffLineReason(uSDKDeviceNetTypeConst.NET_LOCAL, 0);
        setOffLineReason(uSDKDeviceNetTypeConst.NET_REMOTE, 0);
        setOffLineReason(uSDKDeviceNetTypeConst.NET_NOUMENON, 0);
        setOffLineReason(uSDKDeviceNetTypeConst.NET_BLE, 0);
        this.offlineReason = 0;
    }

    private void clearStopSearchOfflineReason() {
        if (getOffLineReason(uSDKDeviceNetTypeConst.NET_LOCAL) == ErrorConst.ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE.getErrorId()) {
            clearOfflineReason();
        }
    }

    private boolean comeBackWaveControlDev() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            return true;
        }
        List<com.haier.uhome.control.base.api.a> realDeviceList = getRealDeviceList();
        if (com.haier.library.common.util.u.h(realDeviceList)) {
            return false;
        }
        for (com.haier.uhome.control.base.api.a aVar2 : realDeviceList) {
            if (aVar.getClass().equals(aVar2.getClass()) && aVar != aVar2) {
                return true;
            }
        }
        return false;
    }

    private boolean compareAttrChanged(com.haier.uhome.control.base.api.d dVar, com.haier.uhome.control.base.api.d dVar2) {
        long timeStamp = dVar == null ? 0L : dVar.getTimeStamp();
        long timeStamp2 = dVar2 == null ? 0L : dVar2.getTimeStamp();
        long uniqueId = dVar == null ? 0L : dVar.getUniqueId();
        long uniqueId2 = dVar2 != null ? dVar2.getUniqueId() : 0L;
        if (!com.haier.uhome.usdk.base.api.e.b(getChannel())) {
            return uniqueId < uniqueId2;
        }
        if (timeStamp2 - timeStamp >= 30000) {
            return true;
        }
        if (uniqueId2 <= uniqueId || uniqueId2 - uniqueId >= 128) {
            return uniqueId2 < uniqueId && uniqueId - uniqueId2 > 128;
        }
        return true;
    }

    private boolean connectControlDevice(final com.haier.uhome.usdk.base.api.o oVar) {
        if (!uSDKManager.getSingleInstance().a()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.p3
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$connectControlDevice$4(oVar);
                }
            });
            return false;
        }
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.q3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30702a.lambda$connectControlDevice$5(oVar);
                }
            });
            return false;
        }
        if (TextUtils.isEmpty(aVar.W())) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.r3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30715a.lambda$connectControlDevice$6(oVar);
                }
            });
            return false;
        }
        if (aVar.i_()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.s3
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$connectControlDevice$7(oVar);
                }
            });
            return true;
        }
        if (com.haier.library.common.util.u.h(getRealDeviceList())) {
            e3.a.o("try connect a dead device<%s> so return", getDeviceId());
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.t3
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$connectControlDevice$8(oVar);
                }
            });
            return false;
        }
        e3.a.o("connect device<%s> with needProperty = <%s> type %s", getDeviceId(), Boolean.valueOf(this.mNeedProperty.get()), aVar.e());
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.u3
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDevice.lambda$connectControlDevice$9(oVar);
            }
        });
        addDeviceListener(this.mSubscribeDeviceListener);
        adjust();
        List<uSDKDevice> groupMemberList = getGroupMemberList();
        if (!com.haier.library.common.util.u.h(groupMemberList)) {
            Iterator<uSDKDevice> it = groupMemberList.iterator();
            while (it.hasNext()) {
                it.next().adjust();
            }
        }
        return true;
    }

    private void connectPass(final com.haier.uhome.control.base.api.a aVar, boolean z7) {
        if (aVar.A()) {
            return;
        }
        aVar.a(z7, new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.v3
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30990a.lambda$connectPass$14(aVar, errorConst);
            }
        }));
    }

    protected static uSDKDevice createDevice(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new uSDKDevice(str, str2, false);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0047 A[Catch: all -> 0x0091, TryCatch #0 {, blocks: (B:7:0x0013, B:9:0x0018, B:29:0x0047, B:30:0x0056, B:32:0x0058, B:33:0x006a, B:11:0x001c, B:13:0x0020, B:14:0x0023, B:16:0x0027, B:17:0x002a, B:19:0x002e, B:21:0x0034, B:22:0x0037, B:24:0x003b, B:25:0x003e, B:27:0x0042), top: B:49:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0058 A[Catch: all -> 0x0091, TryCatch #0 {, blocks: (B:7:0x0013, B:9:0x0018, B:29:0x0047, B:30:0x0056, B:32:0x0058, B:33:0x006a, B:11:0x001c, B:13:0x0020, B:14:0x0023, B:16:0x0027, B:17:0x002a, B:19:0x002e, B:21:0x0034, B:22:0x0037, B:24:0x003b, B:25:0x003e, B:27:0x0042), top: B:49:0x0013 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    private void destroyControlDev(com.haier.uhome.control.base.api.a aVar) {
        DeviceStatus deviceStatus;
        boolean z7 = true;
        if (aVar == null) {
            e3.a.v("destroy a null ControlDevice<%s>", getDeviceId());
            return;
        }
        synchronized (aVar) {
            if (this.mCloudDevice == aVar) {
                this.mCloudDevice = null;
            } else if (this.mLocalDevice == aVar) {
                this.mLocalDevice = null;
            } else {
                if (this.mNoumenonDevice != aVar) {
                    com.haier.uhome.control.local.api.g gVar = this.mLocalBLEDevice;
                    if (gVar == aVar) {
                        if (!gVar.L()) {
                            this.mLocalBLEDevice = null;
                        }
                    } else if (this.mLocalGatewayDevice == aVar) {
                        this.mLocalGatewayDevice = null;
                    } else if (this.mBleMeshDevice == aVar) {
                        this.mBleMeshDevice = null;
                    }
                    if (z7) {
                        e3.a.u("destroy device a dead control device <%s>, type<%s>", aVar.X(), aVar.e(), new Object[0]);
                        return;
                    }
                    e3.a.n("destroy device<%s>, type<%s>", aVar.X(), aVar.e(), new Object[0]);
                    aVar.f();
                    if (aVar instanceof com.haier.uhome.control.local.api.h) {
                        refreshLocalGatewayManager();
                    }
                    if (com.haier.library.common.util.u.h(getRealDeviceList())) {
                        clearOfflineReason();
                        if (isCare()) {
                            deviceStatus = DeviceStatus.STATUS_OFFLINE;
                        } else {
                            deviceStatus = DeviceStatus.STATUS_UNCONNECT;
                        }
                        notifyStatusChange(deviceStatus, 0);
                    }
                    checkNotifyDel();
                }
                this.mNoumenonDevice = null;
            }
            z7 = false;
            if (z7) {
                e3.a.u("destroy device a dead control device <%s>, type<%s>", aVar.X(), aVar.e(), new Object[0]);
                return;
            }
            e3.a.n("destroy device<%s>, type<%s>", aVar.X(), aVar.e(), new Object[0]);
            aVar.f();
            if (aVar instanceof com.haier.uhome.control.local.api.h) {
                refreshLocalGatewayManager();
            }
            if (com.haier.library.common.util.u.h(getRealDeviceList())) {
                clearOfflineReason();
                if (isCare()) {
                    deviceStatus = DeviceStatus.STATUS_OFFLINE;
                } else {
                    deviceStatus = DeviceStatus.STATUS_UNCONNECT;
                }
                notifyStatusChange(deviceStatus, 0);
            }
            checkNotifyDel();
        }
    }

    @Keep
    private String deviceStateLog() {
        StringBuffer stringBuffer = new StringBuffer();
        List<com.haier.uhome.control.base.api.a> listB = this.mSortControlDeviceList;
        if (listB == null) {
            listB = getBestConnect().b(this, isCare(), getRealDeviceList());
        }
        for (com.haier.uhome.control.base.api.a aVar : listB) {
            stringBuffer.append(aVar.e());
            stringBuffer.append("-");
            stringBuffer.append(aVar.n().getValue());
            if ((aVar instanceof com.haier.uhome.control.local.api.d) && ((com.haier.uhome.control.local.api.d) aVar).R()) {
                stringBuffer.append("*P*");
            }
            stringBuffer.append(":");
        }
        return stringBuffer.toString();
    }

    private boolean disConnectControlDevice(final com.haier.uhome.usdk.base.api.o oVar) {
        if (!uSDKManager.getSingleInstance().a()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.j4
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$disConnectControlDevice$10(oVar);
                }
            });
            return false;
        }
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (com.haier.uhome.control.base.c.d(getUplusId()) && TextUtils.isEmpty(this.mMainDeviceId) && (aVar instanceof com.haier.uhome.control.local.api.h) && (aVar = this.mCloudDevice) == null) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return true;
        }
        if (aVar == null) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.k4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30612a.lambda$disConnectControlDevice$11(oVar);
                }
            });
            return false;
        }
        if (TextUtils.isEmpty(aVar.W())) {
            e3.a.v("disconnect device<%s> warning: ControlDevice uplusId is null", getDeviceId());
        }
        if (isDeadControlDevice(aVar)) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return true;
        }
        this.deviceListener.b(this.mSubscribeDeviceListener);
        if (this.deviceListener.b() > 0) {
            e3.a.o("there is no need to disconnect device<%s>", getDeviceId());
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return true;
        }
        e3.a.n("disconnect device<%s> type:%s", getDeviceId(), aVar.e(), new Object[0]);
        aVar.a(oVar);
        return true;
    }

    private void disConnectPass(final com.haier.uhome.control.base.api.a aVar) {
        if (aVar.A()) {
            aVar.a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.m3
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30642a.lambda$disConnectPass$13(aVar, errorConst);
                }
            }));
        }
    }

    private void doCheckBoardFOTAInfo(final ICallback<FOTAInfo> iCallback) {
        uSDKErrorConst usdkerrorconstCheckFOTADeviceState = checkFOTADeviceState();
        if (usdkerrorconstCheckFOTADeviceState != uSDKErrorConst.RET_USDK_OK) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorconstCheckFOTADeviceState.toError());
        } else {
            this.mCloudDevice.a(new ICallback<FOTAInfo>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.15
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(FOTAInfo fOTAInfo) {
                    uSDKDevice.this.cachedFOTAInfo = fOTAInfo;
                    com.haier.uhome.usdk.base.utils.b.b((ICallback<FOTAInfo>) iCallback, fOTAInfo);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.utils.b.b(iCallback, usdkerror);
                }
            });
        }
    }

    private boolean doMergeCase(com.haier.uhome.control.base.api.a aVar, a aVar2) {
        if (aVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(aVar2.f30809b)) {
            return true;
        }
        String strW = aVar.W();
        if (strW != null && strW.equals(aVar2.f30809b)) {
            return true;
        }
        setUplusId(aVar2.f30809b);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doNotifyAlarmChange, reason: merged with bridge method [inline-methods] */
    public void lambda$notifyAlarmChange$43(List<com.haier.uhome.control.base.api.b> list) {
        if (list != null && mergeInAlarmList(list)) {
            try {
                c.a().b(this, com.haier.library.common.util.u.a(com.haier.library.common.util.u.d(this.mAlarmList), new h2()));
            } catch (IllegalArgumentException e8) {
                e8.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doNotifyAttributeChange, reason: merged with bridge method [inline-methods] */
    public boolean lambda$notifyAttributeChange$44(Map<String, com.haier.uhome.control.base.api.d> map) {
        HashMap<String, com.haier.uhome.control.base.api.d> map2 = new HashMap<>();
        if (!mergeInAttrMap(new ArrayList(map.values()), map2)) {
            return false;
        }
        c.a().c(this, new ArrayList(com.haier.library.common.util.u.c(map2, new x2()).values()));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: doNotifyEventChange, reason: merged with bridge method [inline-methods] */
    public void lambda$notifyEventChange$42(List<com.haier.uhome.control.base.api.e> list) {
        if (list == null) {
            return;
        }
        try {
            c.a().a(this, (List<uSDKDeviceEvent>) com.haier.library.common.util.u.a(com.haier.library.common.util.u.d(list), new com.haier.library.common.util.p() { // from class: com.haier.uhome.usdk.api.g4
                @Override // com.haier.library.common.util.p
                public final Object transform(Object obj) {
                    return new uSDKDeviceEvent((com.haier.uhome.control.base.api.e) obj);
                }
            }));
        } catch (IllegalArgumentException e8) {
            e8.printStackTrace();
        }
    }

    private void doStartBoardFOTA(ICallback<Void> iCallback) {
        uSDKErrorConst usdkerrorconstCheckFOTADeviceState = checkFOTADeviceState();
        if (usdkerrorconstCheckFOTADeviceState != uSDKErrorConst.RET_USDK_OK) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorconstCheckFOTADeviceState.toError());
        } else {
            this.mCloudDevice.a(this.cachedFOTAInfo, iCallback);
        }
    }

    private void electControlDevice() {
        List<com.haier.uhome.control.base.api.a> listSortByPriority = sortByPriority();
        this.mSortControlDeviceList = listSortByPriority;
        if (!com.haier.library.common.util.u.h(listSortByPriority)) {
            setControlDevice(listSortByPriority.get(0));
            notifyStatusChange(listSortByPriority.get(0).n(), 0);
        } else {
            if (isCare()) {
                keepConnection(this.mTopControlDevice);
                notifyStatusChange(DeviceStatus.STATUS_OFFLINE, 0);
            }
            notifyStatusChange(DeviceStatus.STATUS_UNCONNECT, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int errNo2OfflineReason(int i7) {
        if (i7 == ErrorConst.ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE.getErrorId()) {
            return i7;
        }
        return 0;
    }

    private long getAlarmListSeq(List<com.haier.uhome.control.base.api.b> list) {
        if (com.haier.library.common.util.u.h(list)) {
            return -1L;
        }
        try {
            return list.get(0).getUniqueId();
        } catch (IndexOutOfBoundsException e8) {
            e8.printStackTrace();
            return -1L;
        } catch (NullPointerException e9) {
            e9.printStackTrace();
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DeviceStatus getBestActiveStatus() {
        List<com.haier.uhome.control.base.api.a> listB = getBestConnect().b(this, isCare(), getRealDeviceList());
        return com.haier.library.common.util.u.h(listB) ? DeviceStatus.STATUS_UNCONNECT : listB.get(0).n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKDeviceConnectStatus getConnectStatus() {
        if (isConnectedOK(this.mCloudDevice)) {
            return uSDKDeviceConnectStatus.CLOUD_CONNECTED;
        }
        if (isConnectedOK(this.mLocalDevice)) {
            return uSDKDeviceConnectStatus.LOCAL_CONNECTED;
        }
        return isConnectedOK(this.mLocalBLEDevice) ? uSDKDeviceConnectStatus.LOCAL_BLE_CONNECTED : uSDKDeviceConnectStatus.OFFLINE;
    }

    private String getMainDevId() {
        return this.mMainDeviceId;
    }

    private List<com.haier.uhome.control.base.api.a> getRealDeviceList() {
        ArrayList arrayList = new ArrayList(6);
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (cVar != null) {
            arrayList.add(cVar);
        }
        com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
        if (hVar != null) {
            arrayList.add(hVar);
        }
        com.haier.uhome.control.noumenon.a.a aVar = this.mNoumenonDevice;
        if (aVar != null) {
            arrayList.add(aVar);
        }
        com.haier.uhome.control.local.api.g gVar = this.mLocalBLEDevice;
        if (gVar != null) {
            arrayList.add(gVar);
        }
        com.haier.uhome.control.local.api.d dVar = this.mBleMeshDevice;
        if (dVar != null) {
            arrayList.add(dVar);
        }
        com.haier.uhome.control.local.api.i iVar = this.mLocalGatewayDevice;
        if (iVar != null) {
            arrayList.add(iVar);
        }
        return arrayList;
    }

    private int getStateCode() {
        return this.stateCode;
    }

    private int getStatusChangeErrorNo(int i7) {
        com.haier.uhome.control.local.api.h hVar;
        return (i7 == ErrorConst.RET_USDK_OK.getErrorId() && (hVar = this.mLocalDevice) != null && hVar.i_() && hVar == this.mTopControlDevice && this.mDeviceStatus == DeviceStatus.STATUS_OFFLINE) ? uSDKErrorConst.ERR_USDK_DEVICE_IS_BUSY.getErrorId() : i7;
    }

    private String getSubState(DeviceStatus deviceStatus, int i7) {
        int i8 = AnonymousClass20.f30773a[deviceStatus.ordinal()];
        if (i8 == 1) {
            return "connected";
        }
        if (i8 == 2) {
            return "ready";
        }
        if (i8 != 3) {
            if (i8 != 4) {
                return i8 != 5 ? "ready" : "unconnect";
            }
            return "connecting";
        }
        return "offline-" + i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDeviceVersionInfo() {
        if (!isNetTypeContain(uSDKDeviceNetTypeConst.NET_MESH) || isDeviceVersionExist()) {
            return;
        }
        if (!isMeshGetWayOrBleMeshOnline() || this.mBleMeshDevice == null) {
            e3.a.v("No mesh device or mesh device offline!", new Object[0]);
            return;
        }
        String deviceId = getDeviceId();
        com.haier.uhome.control.local.api.d dVar = this.mBleMeshDevice;
        dVar.a(15, deviceId, dVar.d(), new ICallback<com.haier.uhome.control.cloud.api.f>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.19
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.control.cloud.api.f fVar) {
                uSDKDevice.this.upDeviceVersion(fVar);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.h("Querying device version information failed error = %s", usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOpCallback(com.haier.uhome.control.base.api.a aVar, uSDKError usdkerror) {
        if (aVar == null) {
            return;
        }
        boolean z7 = false;
        if (aVar instanceof com.haier.uhome.control.cloud.api.c) {
            if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                getBestConnect().a(false);
            } else if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT) || usdkerror.getCode() == -25001) {
                getBestConnect().a(true);
            }
            z7 = true;
        } else if (aVar instanceof com.haier.uhome.control.local.api.g) {
            if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                getBestConnect().a(true);
            } else if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT) || usdkerror.getCode() == -25001) {
                getBestConnect().a(false);
            }
            z7 = true;
        }
        if (z7) {
            adjust();
        }
    }

    private boolean inConfigState() {
        int i7 = this.offlineReason;
        return i7 >= 1 && i7 <= 9;
    }

    private void init() {
        clearOfflineReason();
        this.mSubDeviceMap = new ConcurrentHashMap();
        this.mGroupMemberMap = new ConcurrentHashMap();
        if (this.mBaseInfoMap == null) {
            this.mBaseInfoMap = new ConcurrentHashMap<>();
        }
        if (getClass() == uSDKDevice.class) {
            registerSystemListener();
            this.mTokenObserver = new com.haier.uhome.usdk.base.service.e.a<String>(com.haier.uhome.usdk.base.service.e.c.TOKEN) { // from class: com.haier.uhome.usdk.api.uSDKDevice.12
                @Override // com.haier.uhome.usdk.base.service.e.a
                public void a(String str, String str2) {
                    uSDKDevice.this.adjust();
                }
            };
            com.haier.uhome.usdk.base.service.e.a().a(this.mTokenObserver);
            com.haier.uhome.usdk.base.c.b.a().a(new com.haier.uhome.usdk.base.c.c() { // from class: com.haier.uhome.usdk.api.x3
                @Override // com.haier.uhome.usdk.base.c.c
                public final void notifyBtStateChanged(int i7) {
                    this.f31013j.lambda$init$0(i7);
                }
            });
        }
        initSub();
    }

    private void initControlDeviceListener() {
        this.mGrabControlListener = new com.haier.uhome.control.base.api.i() { // from class: com.haier.uhome.usdk.api.uSDKDevice.22
            @Override // com.haier.uhome.control.base.api.i
            public void a(RouterSsidPasswordEvent routerSsidPasswordEvent) {
            }

            @Override // com.haier.uhome.control.base.api.i
            public void b(String str, List<com.haier.uhome.control.base.api.b> list) {
                if (uSDKDevice.this.topPassSupportSeq()) {
                    uSDKDevice.this.notifyAlarmChange(list);
                }
            }

            @Override // com.haier.uhome.control.base.api.i
            public void c(String str, List<com.haier.uhome.control.base.api.a> list) {
            }

            @Override // com.haier.uhome.control.base.api.i
            public void a(String str, List<com.haier.uhome.control.base.api.e> list) {
                if (uSDKDevice.this.topPassSupportSeq()) {
                    uSDKDevice.this.notifyEventChange(list);
                }
            }

            @Override // com.haier.uhome.control.base.api.i
            public void a(String str, HashMap<String, com.haier.uhome.control.base.api.d> map) {
                if (uSDKDevice.this.topPassSupportSeq()) {
                    uSDKDevice.this.notifyAttributeChange(map);
                }
            }

            /* JADX WARN: Code duplicated, block: B:19:0x0056  */
            /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // com.haier.uhome.control.base.api.i
            public void a(String str, String str2, DeviceStatus deviceStatus, int i7) {
                int i8 = AnonymousClass20.f30773a[deviceStatus.ordinal()];
                if (i8 == 1) {
                    uSDKDevice.this.tryGetCloudDeviceState();
                } else {
                    if (i8 != 2) {
                        if (i8 == 3) {
                            uSDKDevice usdkdevice = uSDKDevice.this;
                            if (!usdkdevice.isInConfigModeOffline(usdkdevice.module2NetType(str))) {
                                uSDKDevice usdkdevice2 = uSDKDevice.this;
                                if (usdkdevice2.getOffLineReason(usdkdevice2.module2NetType(str)) == 0) {
                                    uSDKDevice usdkdevice3 = uSDKDevice.this;
                                    usdkdevice3.setOffLineReason(usdkdevice3.module2NetType(str), uSDKDevice.this.errNo2OfflineReason(i7));
                                }
                            }
                            uSDKDevice.this.checkDelLocal();
                        }
                    }
                    uSDKDevice.this.adjust();
                    if (uSDKDevice.this.mCloudDevice != null) {
                        uSDKDevice.this.checkModuleOTAStatus();
                    }
                }
                uSDKDevice.this.handleDeviceVersionInfo();
                uSDKDevice.this.adjust();
                if (uSDKDevice.this.mCloudDevice != null) {
                    uSDKDevice.this.checkModuleOTAStatus();
                }
            }
        };
        this.mControlDeviceListener = new com.haier.uhome.control.base.api.i() { // from class: com.haier.uhome.usdk.api.uSDKDevice.23
            @Override // com.haier.uhome.control.base.api.i
            public void a(String str, List<com.haier.uhome.control.base.api.e> list) {
                uSDKDevice.this.notifyEventChange(list);
            }

            @Override // com.haier.uhome.control.base.api.i
            public void b(String str, List<com.haier.uhome.control.base.api.b> list) {
                uSDKDevice.this.notifyAlarmChange(list);
            }

            @Override // com.haier.uhome.control.base.api.i
            public void c(String str, List<com.haier.uhome.control.base.api.a> list) {
            }

            @Override // com.haier.uhome.control.base.api.i
            public void a(String str, HashMap<String, com.haier.uhome.control.base.api.d> map) {
                com.haier.uhome.control.cloud.api.c cVar = uSDKDevice.this.mCloudDevice;
                if (uSDKDevice.this.isPureCloudDevice() && cVar != null && cVar.g() == ErrorConst.ERR_USDK_OFFLINE_DECLARE.getErrorId()) {
                    uSDKDevice.this.clearOfflineReason();
                }
                uSDKDevice.this.notifyAttributeChange(map);
            }

            @Override // com.haier.uhome.control.base.api.i
            public void a(String str, String str2, DeviceStatus deviceStatus, int i7) {
                e3.a.d("onDeviceStatusChange %s, %s, %s", str, str2, deviceStatus);
                int i8 = AnonymousClass20.f30773a[deviceStatus.ordinal()];
                if (i8 == 1) {
                    uSDKDevice.this.tryGetCloudDeviceState();
                    uSDKDevice.this.handleDeviceVersionInfo();
                    if (com.haier.uhome.usdk.base.a.ao.equals(str)) {
                        uSDKDevice.this.clearDeviceBleEvent();
                        RouterSsidPasswordEvent routerSsidPasswordEvent = new RouterSsidPasswordEvent();
                        routerSsidPasswordEvent.setProgress(3);
                        routerSsidPasswordEvent.setState(1);
                        routerSsidPasswordEvent.setStateCode(1000);
                        uSDKDevice.this.updateRouterProgress(routerSsidPasswordEvent);
                    }
                } else if (i8 != 2) {
                    if (i8 == 3) {
                        if (uSDKDevice.this.getBestActiveStatus() == DeviceStatus.STATUS_OFFLINE) {
                            uSDKDevice.this.mAttrMap.clear();
                            uSDKDevice.this.mAlarmList.clear();
                        }
                        uSDKDevice usdkdevice = uSDKDevice.this;
                        if (!usdkdevice.isInConfigModeOffline(usdkdevice.module2NetType(str))) {
                            uSDKDevice usdkdevice2 = uSDKDevice.this;
                            if (usdkdevice2.getOffLineReason(usdkdevice2.module2NetType(str)) == 0) {
                                uSDKDevice usdkdevice3 = uSDKDevice.this;
                                usdkdevice3.setOffLineReason(usdkdevice3.module2NetType(str), uSDKDevice.this.errNo2OfflineReason(i7));
                            }
                        }
                    } else if (i8 == 4 || i8 == 5) {
                    }
                    uSDKDevice.this.checkDelLocal();
                } else {
                    uSDKDevice.this.handleDeviceVersionInfo();
                    uSDKDevice usdkdevice4 = uSDKDevice.this;
                    usdkdevice4.notifyAttributeChange(usdkdevice4.mTopControlDevice.q());
                }
                uSDKDevice.this.masterStateDi(Trace.createDITrace());
                uSDKDevice.this.adjust();
                if (uSDKDevice.this.mCloudDevice != null) {
                    uSDKDevice.this.checkModuleOTAStatus();
                }
            }

            @Override // com.haier.uhome.control.base.api.i
            public void a(RouterSsidPasswordEvent routerSsidPasswordEvent) {
                uSDKDevice.this.updateRouterProgress(routerSsidPasswordEvent);
            }
        };
    }

    private void initSub() {
        List<uSDKDevice> listA;
        if (com.haier.uhome.control.base.c.d(getUplusId()) && com.haier.uhome.control.base.c.a(getDeviceId()) == null && (listA = uSDKDeviceManager.getSingleInstance().a(getDeviceId(), getUplusId())) != null) {
            for (uSDKDevice usdkdevice : listA) {
                addSubDevice(usdkdevice.getDeviceId(), usdkdevice);
            }
        }
        String strA = com.haier.uhome.control.base.c.a(getDeviceId());
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        setMainDeviceId(strA);
    }

    private boolean isCare() {
        uSDKDevice device;
        boolean z7 = this.deviceListener.b() > 0;
        String myGroupDevId = getMyGroupDevId();
        return (TextUtils.isEmpty(myGroupDevId) || (device = uSDKDeviceManager.getSingleInstance().getDevice(myGroupDevId)) == null) ? z7 : device.isCare();
    }

    private boolean isConnectedOK(com.haier.uhome.control.base.api.a aVar) {
        if (aVar != null) {
            return DeviceStatus.STATUS_READY == aVar.n() || DeviceStatus.STATUS_CONNECTED == aVar.n();
        }
        return false;
    }

    private boolean isDeadControlDevice(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            e3.a.o("try to check is dead to a null abs device", new Object[0]);
            return false;
        }
        boolean z7 = true;
        for (com.haier.uhome.control.base.api.a aVar2 : getRealDeviceList()) {
            if (aVar2 != null && aVar2.getClass().equals(aVar.getClass())) {
                z7 = false;
            }
        }
        if (z7) {
            e3.a.o("device<%s> is dead device type %s", getDeviceId(), aVar.getClass());
        }
        return z7;
    }

    private boolean isDeviceVersionExist() {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        if (fVarA == null) {
            return false;
        }
        return !TextUtils.isEmpty(fVarA.q().a());
    }

    private boolean isDuplicateStatus(com.haier.uhome.usdk.api.interfaces.a aVar, FOTAStatusInfo fOTAStatusInfo) {
        if (aVar.a(fOTAStatusInfo)) {
            return false;
        }
        if (!com.haier.uhome.control.cloud.b.a.b(fOTAStatusInfo)) {
            return true;
        }
        aVar.f();
        e3.a.v("Fota status info has invoked all so clear cache!", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInConfigModeOffline(uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        uSDKDeviceNetTypeConst usdkdevicenettypeconst2 = uSDKDeviceNetTypeConst.NET_BLE;
        if (usdkdevicenettypeconst == usdkdevicenettypeconst2 && getOffLineReason(usdkdevicenettypeconst2) == ErrorConst.ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE.getErrorId()) {
            return true;
        }
        uSDKDeviceNetTypeConst usdkdevicenettypeconst3 = uSDKDeviceNetTypeConst.NET_LOCAL;
        return usdkdevicenettypeconst == usdkdevicenettypeconst3 && getOffLineReason(usdkdevicenettypeconst3) == ErrorConst.ERR_USDK_OFFLINE_DECLARE.getErrorId();
    }

    private boolean isInTimeWindow() {
        if (getSecurity() == uSDKDeviceSecurityConst.UNSAFE || !isNetTypeContain(uSDKDeviceNetTypeConst.NET_REMOTE)) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.search.a.n.a().a(getDeviceId());
        if (fVarA == null) {
            e3.a.e("ota tw: deviceInfo is null", new Object[0]);
            return false;
        }
        if (fVarA.l() == 0) {
            e3.a.e("ota tw: bts = 0!", new Object[0]);
            return false;
        }
        long jL = fVarA.l();
        e3.a.e("ota tw: bts = %d", Long.valueOf(jL));
        if (jCurrentTimeMillis - jL > 600000) {
            return false;
        }
        openTimeWindow(jCurrentTimeMillis);
        return true;
    }

    private boolean isMeshGetWayOrBleMeshOnline() {
        com.haier.uhome.control.local.api.d dVar = this.mBleMeshDevice;
        return dVar != null && isOnline(dVar);
    }

    private boolean isOnline(com.haier.uhome.control.base.api.a aVar) {
        return aVar.n() == DeviceStatus.STATUS_CONNECTED || aVar.n() == DeviceStatus.STATUS_READY;
    }

    private boolean isOnlyNetTypeContain(uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        return getRealDeviceList().size() == 1 && isNetTypeContain(usdkdevicenettypeconst);
    }

    private boolean isPureBleDevice() {
        com.haier.uhome.control.local.api.g gVar = this.mLocalBLEDevice;
        return gVar != null && gVar.af() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPureCloudDevice() {
        List<com.haier.uhome.control.base.api.a> realDeviceList = getRealDeviceList();
        return realDeviceList.size() == 1 && (realDeviceList.get(0) instanceof com.haier.uhome.control.cloud.api.c);
    }

    private boolean isSpecialCloudOfflineCase() {
        return getOffLineReason(uSDKDeviceNetTypeConst.NET_REMOTE) == ErrorConst.ERR_USDK_OFFLINE_DECLARE.getErrorId();
    }

    private void keepConnection(com.haier.uhome.control.base.api.a aVar) {
        if (aVar != null && aVar.A()) {
            aVar.a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.b3
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30462a.lambda$keepConnection$3(errorConst);
                }
            }));
        }
    }

    private void keepConnectionAll() {
        for (com.haier.uhome.control.base.api.a aVar : getRealDeviceList()) {
            if (!(aVar instanceof com.haier.uhome.control.local.api.g)) {
                if ((aVar instanceof com.haier.uhome.control.cloud.api.c) && isSpecialCloudOfflineCase()) {
                    aVar.a(com.haier.uhome.usdk.base.a.ao, DeviceStatus.STATUS_OFFLINE, ErrorConst.ERR_USDK_OFFLINE_DECLARE.getErrorId());
                } else {
                    keepConnection(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$authToDevice$28(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$authToDevice$30(final IuSDKCallback iuSDKCallback, final ErrorConst errorConst) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.i4
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDevice.lambda$null$29(iuSDKCallback, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$authToDevice$31(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.ERR_INTERNAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$authToDeviceInvalid$32(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$authToDeviceInvalid$34(final IuSDKCallback iuSDKCallback, final ErrorConst errorConst) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.w2
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDevice.lambda$null$33(iuSDKCallback, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$authToDeviceInvalid$37(final IuSDKCallback iuSDKCallback, final ErrorConst errorConst) {
        if (errorConst.equals(ErrorConst.RET_USDK_OK)) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.m2
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$null$35(iuSDKCallback);
                }
            });
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.n2
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$null$36(iuSDKCallback, errorConst);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$callbackWithError$48(IuSDKCallback iuSDKCallback, uSDKErrorConst usdkerrorconst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(usdkerrorconst);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connect$16(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connectControlDevice$4(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_USDK_UNSTARTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectControlDevice$5(com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.o("connect device<%s> error: ControlDevice is null", getDeviceId());
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_USDK_NOT_SUPPORT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectControlDevice$6(com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.o("connect device<%s> error: ControlDevice uplusId is null", getDeviceId());
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_USDK_NOT_SUPPORT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connectControlDevice$7(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.RET_USDK_OK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connectControlDevice$8(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_USDK_NOT_SUPPORT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connectControlDevice$9(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.RET_USDK_OK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$connectNeedProperties$17(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$connectPass$14(com.haier.uhome.control.base.api.a aVar, ErrorConst errorConst) {
        e3.a.d("refreshConnection<%s> self connect pass<%s> ret %s", getDeviceId(), aVar.e(), errorConst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$disConnectControlDevice$10(com.haier.uhome.usdk.base.api.o oVar) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_USDK_UNSTARTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disConnectControlDevice$11(com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.o("disconnect device<%s> error:ControlDevice is null", getDeviceId());
        if (oVar != null) {
            oVar.onCallback(ErrorConst.ERR_USDK_NOT_SUPPORT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disConnectPass$13(com.haier.uhome.control.base.api.a aVar, ErrorConst errorConst) {
        e3.a.d("refreshConnection<%s> self disconnect pass<%s> ret %s", getDeviceId(), aVar.e(), errorConst);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disconnect$18(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (errorConst == ErrorConst.RET_USDK_OK) {
            adjust();
        }
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.haier.uhome.control.base.api.c lambda$execOperation$15(uSDKArgument usdkargument) {
        return usdkargument;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeviceAuthState$38(IuSDKResultCallback iuSDKResultCallback) {
        if (iuSDKResultCallback != null) {
            iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_DEVICE_UNSUPPORTED_AUTHORIZE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeviceAuthState$40(final IuSDKResultCallback iuSDKResultCallback, final ErrorConst errorConst, final boolean z7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.r2
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDevice.lambda$null$39(iuSDKResultCallback, errorConst, z7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeviceAuthState$41(IuSDKResultCallback iuSDKResultCallback) {
        if (iuSDKResultCallback != null) {
            iuSDKResultCallback.onFail(uSDKErrorConst.ERR_INTERNAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeviceNetQuality$25(IuSDKGetDeviceNetQualityCallback iuSDKGetDeviceNetQualityCallback) {
        if (iuSDKGetDeviceNetQualityCallback != null) {
            iuSDKGetDeviceNetQualityCallback.onDeviceNetQualityGet(uSDKErrorConst.ERR_USDK_NOT_SUPPORT, null, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeviceNetQuality$26(IuSDKGetDeviceNetQualityCallback iuSDKGetDeviceNetQualityCallback, ErrorConst errorConst, com.haier.uhome.control.base.api.f fVar, int i7) {
        iuSDKGetDeviceNetQualityCallback.onDeviceNetQualityGet(uSDKErrorConst.getErrorConst(errorConst), fVar == null ? null : uSDKDeviceNetQuality.getNetQuality(fVar), i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeviceNetQuality$27(IuSDKGetDeviceNetQualityCallback iuSDKGetDeviceNetQualityCallback) {
        if (iuSDKGetDeviceNetQualityCallback != null) {
            iuSDKGetDeviceNetQualityCallback.onDeviceNetQualityGet(uSDKErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST, null, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getGroupMemberList$50(String str, uSDKDevice usdkdevice) {
        return str.equals(usdkdevice.getMyGroupDevId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$init$0(int i7) {
        if (i7 == 1 || i7 == 2) {
            adjust();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$invalidToken$49(ErrorConst errorConst) {
        if (this.mLocalDevice == null) {
            return;
        }
        e3.a.e("Device<%s>invalidToken so self disconnect control device ret = " + errorConst, getDeviceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$keepConnection$3(ErrorConst errorConst) {
        if (errorConst != ErrorConst.RET_USDK_OK) {
            e3.a.h("self disConnect keepConnection device<%s> return %d", getDeviceId(), Integer.valueOf(errorConst.getErrorId()));
        } else {
            e3.a.e("self disConnect keepConnection device<%s> return %d", getDeviceId(), Integer.valueOf(errorConst.getErrorId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$12() {
        e3.a.e("adjust device <%s>", getDeviceId());
        if (inConfigState()) {
            e3.a.e("adjust device<%s> offline reason = %d", getDeviceId(), Integer.valueOf(this.offlineReason));
            keepConnectionAll();
            notifyStatusChange(DeviceStatus.STATUS_OFFLINE, this.offlineReason);
        } else {
            refreshConnection();
            electControlDevice();
        }
        setControlDeviceListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$22(com.haier.uhome.usdk.base.api.c cVar, com.haier.library.common.thread.g gVar, ErrorConst errorConst, String str) {
        cVar.a(errorConst.toError());
        cVar.a(str);
        gVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$23(com.haier.uhome.usdk.base.api.c cVar, com.haier.uhome.control.local.api.h hVar, com.haier.library.common.thread.g gVar, ErrorConst errorConst, String str) {
        cVar.a(errorConst.toError());
        cVar.a(str);
        if (hVar != null) {
            hVar.f();
        }
        gVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$29(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$33(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$35(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.RET_USDK_OK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$36(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$null$39(IuSDKResultCallback iuSDKResultCallback, ErrorConst errorConst, boolean z7) {
        if (iuSDKResultCallback != null) {
            if (errorConst == ErrorConst.RET_USDK_OK) {
                iuSDKResultCallback.onSuccess(Boolean.valueOf(z7));
            } else {
                iuSDKResultCallback.onFail(uSDKErrorConst.getErrorConst(errorConst));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reconnectControlDevice$2(ErrorConst errorConst) {
        adjust();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setDeviceGatewayAndPort$19(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.ERR_USDK_UNSTARTED);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setDeviceGatewayAndPort$20(IuSDKCallback iuSDKCallback) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.ERR_USDK_NOT_SUPPORT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setDeviceGatewayAndPort$21(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryGetDeviceBindInfoOnce$24(final com.haier.uhome.usdk.base.api.c cVar, final com.haier.library.common.thread.g gVar, String str, boolean z7, TraceNode traceNode) {
        com.haier.uhome.control.base.api.l lVar = new com.haier.uhome.control.base.api.l() { // from class: com.haier.uhome.usdk.api.j3
            @Override // com.haier.uhome.control.base.api.l
            public final void onDeviceBindInfoGet(ErrorConst errorConst, String str2) {
                uSDKDevice.lambda$null$22(cVar, gVar, errorConst, str2);
            }
        };
        if (getNetType() != uSDKDeviceNetTypeConst.NET_NOUMENON) {
            com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
            if (hVar != null) {
                hVar.a(str, z7, traceNode, lVar);
                return;
            }
            com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
            if (aVar == null) {
                com.haier.uhome.control.local.e.c.l().a(this.mBindInfoDeviceId, this.mBindInfoIp, this.mBindInfoPort, str, "", (com.haier.uhome.usdk.base.api.q) null, z7, traceNode, lVar);
                return;
            } else {
                aVar.a(str, z7, traceNode, lVar);
                return;
            }
        }
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.search.a.n.a().a(getDeviceId());
        e3.a.e("NOUMENON device <%s> getDeviceBindInfo search info %s", getDeviceId(), fVarA);
        if (fVarA != null) {
            final com.haier.uhome.control.local.api.h hVar2 = new com.haier.uhome.control.local.api.h(getDeviceId(), getUplusId(), getMainDevId());
            hVar2.d(fVarA.p().j());
            hVar2.h(fVarA.p().n());
            hVar2.a(str, z7, traceNode, new com.haier.uhome.control.base.api.l() { // from class: com.haier.uhome.usdk.api.k3
                @Override // com.haier.uhome.control.base.api.l
                public final void onDeviceBindInfoGet(ErrorConst errorConst, String str2) {
                    uSDKDevice.lambda$null$23(cVar, hVar2, gVar, errorConst, str2);
                }
            });
            return;
        }
        uSDKError error = ErrorConst.ERR_INTERNAL.toError();
        error.a("deviceInfo = null");
        cVar.a(error);
        gVar.a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unsubscribeResource$45(IuSDKCallback iuSDKCallback, com.haier.uhome.control.cloud.api.e eVar, ErrorConst errorConst) {
        iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        if (errorConst == ErrorConst.RET_USDK_OK && eVar.f().isEmpty()) {
            this.mP2PHandle = null;
        }
    }

    private boolean lastChallenge(com.haier.uhome.control.base.api.a aVar, com.haier.uhome.control.base.api.a aVar2) {
        if (aVar == null || !isCare() || comeBackWaveControlDev()) {
            return true;
        }
        if (isDeadControlDevice(aVar) && !isDeadControlDevice(aVar2)) {
            return true;
        }
        int iOrdinal = aVar.n().ordinal();
        DeviceStatus deviceStatus = DeviceStatus.STATUS_OFFLINE;
        return iOrdinal > deviceStatus.ordinal() || aVar2.n().ordinal() > deviceStatus.ordinal();
    }

    private void makeBleDevice(a aVar) {
        if (aVar == null) {
            checkDelLocal(this.mLocalBLEDevice, uSDKDeviceNetTypeConst.NET_BLE);
            return;
        }
        if (doMergeCase(this.mLocalBLEDevice, aVar)) {
            e3.a.e("makeBleDevice<%s> device done merge situation", getDeviceId());
            return;
        }
        com.haier.uhome.control.local.api.g gVar = new com.haier.uhome.control.local.api.g(getDeviceId(), aVar.f30810c, getUplusId(), getMainDevId());
        this.mLocalBLEDevice = gVar;
        updateHandlerDevice(gVar);
        if (aVar.f30811d != null) {
            this.mLocalBLEDevice.a(com.haier.uhome.usdk.base.a.aq, aVar.f30811d, 0);
        }
        this.mLocalBLEDevice.a(new com.haier.uhome.control.local.api.b() { // from class: com.haier.uhome.usdk.api.uSDKDevice.24
            @Override // com.haier.uhome.control.local.api.b
            public void a(String str, int i7, int i8, byte[] bArr) {
                k kVarA = a();
                if (kVarA == null) {
                    e3.a.v("device<%d>onBLEHistoryData with null listener", str);
                } else {
                    kVarA.onBLEHistoryData(uSDKDevice.this, i7, i8, bArr);
                }
            }

            @Override // com.haier.uhome.control.local.api.b
            public void a(String str, byte[] bArr) {
                k kVarA = a();
                if (kVarA == null) {
                    e3.a.v("device<%d>onBLERealTimeData with null listener", str);
                } else {
                    kVarA.onBLERealTimeData(uSDKDevice.this, bArr);
                }
            }

            private k a() {
                k overAllListener = uSDKDevice.this.getOverAllListener();
                if (overAllListener != null) {
                    return overAllListener;
                }
                e3.a.v("getDeviceListener with null DeviceListener", new Object[0]);
                return null;
            }
        });
        this.mLocalBLEDevice.a(new k2(this));
        tryActivateControlDevice(this.mLocalBLEDevice);
    }

    private void makeCloudDevice(a aVar) {
        if (aVar == null) {
            e3.a.e("makeCloudDevice<%s> to null", getDeviceId());
            com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
            if (cVar != null) {
                destroyControlDev(cVar);
                return;
            }
            return;
        }
        if (doMergeCase(this.mCloudDevice, aVar)) {
            e3.a.e("makeCloudDevice<%s> device done merge situation", getDeviceId());
            return;
        }
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE == null) {
            e3.a.h("updateControlDevice create cloud device with null user", new Object[0]);
            return;
        }
        com.haier.uhome.control.cloud.api.c cVarA = dVarE.a(getDeviceId(), aVar.f30809b, getMainDevId(), uSDKDeviceManager.getSingleInstance().b());
        this.mCloudDevice = cVarA;
        cVarA.a(new k2(this));
        tryActivateControlDevice(this.mCloudDevice);
    }

    private void makeLocalDevice(a aVar) {
        if (aVar == null) {
            checkDelLocal(this.mLocalDevice, uSDKDeviceNetTypeConst.NET_LOCAL);
            return;
        }
        if (doMergeCase(this.mLocalDevice, aVar)) {
            e3.a.e("makeLocalDevice<%s> device done merge situation", getDeviceId());
            return;
        }
        this.mLocalDevice = new com.haier.uhome.control.local.api.h(getDeviceId(), aVar.f30809b, getMainDevId());
        refreshLocalGatewayManager();
        h hVar = this.mOTAHandler;
        if (hVar != null) {
            hVar.a(this.mLocalDevice);
        }
        tryActivateControlDevice(this.mLocalDevice);
    }

    private void makeLocalGateway(a aVar) {
        com.haier.uhome.control.base.api.a aVar2 = this.mLocalGatewayDevice;
        if (aVar == null) {
            if (aVar2 != null) {
                destroyControlDev(aVar2);
            }
        } else {
            if (doMergeCase(aVar2, aVar)) {
                e3.a.e("makeLocalGateway<%s> device done merge situation", getDeviceId());
                return;
            }
            com.haier.uhome.control.local.api.i iVar = new com.haier.uhome.control.local.api.i(aVar.f30808a, aVar.c(), TextUtils.isEmpty(aVar.f30809b) ? getUplusId() : aVar.f30809b, null, aVar.f30812e, uSDKDeviceManager.getSingleInstance().b());
            this.mLocalGatewayDevice = iVar;
            tryActivateControlDevice(iVar);
        }
    }

    private void makeMeshDevice(a aVar) {
        com.haier.uhome.control.local.api.d dVar = this.mBleMeshDevice;
        if (aVar == null) {
            if (dVar != null) {
                destroyControlDev(dVar);
                return;
            }
            return;
        }
        if (doMergeCase(dVar, aVar) && dVar.d() == aVar.f30812e) {
            e3.a.e("makeBleMeshDevice<%s> device done merge situation", getDeviceId());
            return;
        }
        com.haier.uhome.control.local.api.d.a aVar2 = new com.haier.uhome.control.local.api.d.a();
        aVar2.b(aVar.f30808a);
        aVar2.a(aVar.c());
        aVar2.c(TextUtils.isEmpty(aVar.f30809b) ? getUplusId() : aVar.f30809b);
        aVar2.a(aVar.f30812e);
        aVar2.a(uSDKDeviceManager.getSingleInstance().b());
        com.haier.uhome.control.local.api.d dVarA = aVar2.a();
        dVarA.a(new k2(this));
        this.mBleMeshDevice = dVarA;
        updateHandlerDevice(dVarA);
        tryActivateControlDevice(this.mBleMeshDevice);
    }

    private void makeNoumenonDevice(a aVar) {
        if (aVar == null) {
            e3.a.e("makeNoumenonDevice<%s> to null", getDeviceId());
            com.haier.uhome.control.base.api.a aVar2 = this.mNoumenonDevice;
            if (aVar2 != null) {
                destroyControlDev(aVar2);
                return;
            }
            return;
        }
        if (doMergeCase(this.mNoumenonDevice, aVar)) {
            e3.a.e("makeNoumenonDevice<%s> device done merge situation", getDeviceId());
            return;
        }
        com.haier.uhome.control.noumenon.a.a aVar3 = new com.haier.uhome.control.noumenon.a.a(getDeviceId(), aVar.f30809b, getMainDevId());
        this.mNoumenonDevice = aVar3;
        tryActivateControlDevice(aVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void masterStateDi(Trace trace) {
        String str;
        if (trace == null) {
            return;
        }
        DeviceStatus deviceStatusN = this.mTopControlDevice.n();
        String strA = com.haier.uhome.control.base.d.b.a(deviceStatusN);
        String deviceId = getDeviceId();
        if (deviceStatusN == DeviceStatus.STATUS_OFFLINE) {
            str = "" + getOffLineReason(getNetType());
        } else {
            str = null;
        }
        DITraceNode dITraceNode = new DITraceNode("devst", strA, deviceId, str, VersionManager.getInstance().getSDKVersion());
        HashMap map = new HashMap(3);
        com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        com.haier.uhome.control.local.api.g gVar = this.mLocalBLEDevice;
        map.put(TraceProtocolConst.PRO_DEVICE_LST, hVar == null ? "" : getSubState(hVar.n(), hVar.g()));
        map.put(TraceProtocolConst.PRO_DEVICE_RST, cVar == null ? "" : getSubState(cVar.n(), cVar.g()));
        map.put(TraceProtocolConst.PRO_DEVICE_BLEST, gVar != null ? getSubState(gVar.n(), gVar.g()) : "");
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
        trace.addDITraceNode(dITraceNode);
    }

    private boolean mergeInAlarmList(List<com.haier.uhome.control.base.api.b> list) {
        if (com.haier.library.common.util.u.h(this.mAlarmList)) {
            setAlarmList(list);
            return true;
        }
        if (!topPassSupportSeq()) {
            setAlarmList(list);
            return true;
        }
        long alarmListSeq = getAlarmListSeq(this.mAlarmList);
        long alarmListSeq2 = getAlarmListSeq(list);
        if (alarmListSeq2 > alarmListSeq) {
            setAlarmList(list);
            return true;
        }
        e3.a.e("merge alarm uniqueId fail old:%d new:%d", Long.valueOf(alarmListSeq), Long.valueOf(alarmListSeq2));
        if (!com.haier.library.common.util.u.h(list)) {
            return false;
        }
        this.mAlarmList.clear();
        return true;
    }

    private boolean mergeInAttrMap(List<com.haier.uhome.control.base.api.d> list, HashMap<String, com.haier.uhome.control.base.api.d> map) {
        String name;
        if (list == null || map == null) {
            return false;
        }
        for (com.haier.uhome.control.base.api.d dVar : list) {
            if (dVar != null && (name = dVar.getName()) != null) {
                com.haier.uhome.control.base.api.d dVar2 = this.mAttrMap.get(name);
                Object[] objArr = new Object[3];
                objArr[0] = dVar.getName();
                objArr[1] = Long.valueOf(dVar2 == null ? -1L : dVar2.getUniqueId());
                objArr[2] = Long.valueOf(dVar.getUniqueId());
                e3.a.e("merge attr name %s old=%d, new=%d", objArr);
                if (dVar2 == null) {
                    this.mAttrMap.put(name, newAttr(dVar));
                    map.put(name, newAttr(dVar));
                } else if (topPassSupportSeq()) {
                    if (compareAttrChanged(dVar2, dVar)) {
                        dVar2.b(dVar.getValue());
                        dVar2.a(dVar.getUniqueId());
                        dVar2.b(dVar.getTimeStamp());
                        map.put(name, newAttr(dVar));
                    }
                } else if (!dVar2.getValue().equals(dVar.getValue())) {
                    dVar2.b(dVar.getValue());
                    dVar2.a(dVar.getUniqueId());
                    dVar2.b(dVar.getTimeStamp());
                    map.put(name, newAttr(dVar));
                }
            }
        }
        return !map.isEmpty();
    }

    private boolean needAlarmNotify(List<com.haier.uhome.control.base.api.b> list, List<com.haier.uhome.control.base.api.b> list2) {
        if (com.haier.library.common.util.u.h(list)) {
            return !com.haier.library.common.util.u.h(list2);
        }
        return false;
    }

    private boolean needCatchStopSearch() {
        if (getOffLineReason(uSDKDeviceNetTypeConst.NET_LOCAL) != ErrorConst.ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE.getErrorId()) {
            return false;
        }
        e3.a.e("have been catch the stop search offline reason", new Object[0]);
        if (com.haier.uhome.usdk.base.service.a.a().b() && com.haier.uhome.usdk.base.service.f.a().b()) {
            return true;
        }
        return !uSDKDeviceManager.getSingleInstance().h();
    }

    private boolean needProperty() {
        int iB;
        if (!this.mNeedProperty.get() && (iB = getOverAllListener().b()) <= 1) {
            return iB == 1 && !getOverAllListener().c(this.mSubscribeDeviceListener);
        }
        return true;
    }

    private com.haier.uhome.control.base.api.b newAlarm(com.haier.uhome.control.base.api.b bVar) {
        return new com.haier.uhome.control.base.api.b(bVar.getName(), bVar.getValue(), bVar.getUniqueId());
    }

    private com.haier.uhome.control.base.api.d newAttr(com.haier.uhome.control.base.api.d dVar) {
        return new com.haier.uhome.control.base.api.d(dVar.getName(), dVar.getValue(), dVar.getUniqueId(), dVar.getTimeStamp());
    }

    private void notifyAdd() {
        ArrayList<uSDKDevice> arrayList = new ArrayList<>(1);
        arrayList.add(this);
        c.a().a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAlarmChange(final List<com.haier.uhome.control.base.api.b> list) {
        this.mExecutor.a(new Runnable() { // from class: com.haier.uhome.usdk.api.y2
            @Override // java.lang.Runnable
            public final void run() {
                this.f31021a.lambda$notifyAlarmChange$43(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyAttributeChange(final Map<String, com.haier.uhome.control.base.api.d> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        this.mExecutor.a(new Runnable() { // from class: com.haier.uhome.usdk.api.c4
            @Override // java.lang.Runnable
            public final void run() {
                this.f30476a.lambda$notifyAttributeChange$44(map);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBaseInfoChange() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this);
        c.a().a((List<uSDKDevice>) arrayList);
    }

    private void notifyDel() {
        ArrayList<uSDKDevice> arrayList = new ArrayList<>(1);
        arrayList.add(this);
        c.a().a(arrayList, new uSDKDeviceTypeConst[0]);
        uSDKDevice parentDevice = getParentDevice();
        if (parentDevice != null) {
            parentDevice.removeSubDevice(getDeviceId());
        }
    }

    private boolean notifyDeviceChange(com.haier.uhome.control.base.api.a aVar, List<com.haier.uhome.control.base.api.b> list) {
        if (aVar == null) {
            return false;
        }
        boolean z7 = this.mDeviceStatus != aVar.n();
        if (needAlarmNotify(list, aVar.r())) {
            notifyAlarmChange(aVar.r());
            e3.a.e("notifyDeviceChange<%s> alarm change", getDeviceId());
            z7 = true;
        }
        if (!notifyAttributeChange(aVar.q())) {
            return z7;
        }
        e3.a.e("notifyDeviceChange<%s> attr change", getDeviceId());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEventChange(final List<com.haier.uhome.control.base.api.e> list) {
        this.mExecutor.a(new Runnable() { // from class: com.haier.uhome.usdk.api.o2
            @Override // java.lang.Runnable
            public final void run() {
                this.f30674a.lambda$notifyEventChange$42(list);
            }
        });
    }

    private synchronized void notifyStatusChange(DeviceStatus deviceStatus, int i7) {
        if (deviceStatus == null) {
            return;
        }
        DeviceStatus deviceStatusCareIntoStatus = careIntoStatus(bindConditionIntoStatus(passConditionIntoStatus(offlineReasonIntoStatus(deviceStatus))));
        if (this.mDeviceStatus == deviceStatusCareIntoStatus) {
            return;
        }
        this.mDeviceStatus = deviceStatusCareIntoStatus;
        c.a().a(this, uSDKDeviceStatusConst.getInstance(deviceStatusCareIntoStatus.name()), getStatusChangeErrorNo(i7));
    }

    private DeviceStatus offlineReasonIntoStatus(DeviceStatus deviceStatus) {
        return (getOffLineReason(getNetType()) == 0 || deviceStatus == DeviceStatus.STATUS_UNCONNECT) ? deviceStatus : DeviceStatus.STATUS_OFFLINE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBoardOtaStatusChanged(FOTAStatusInfo fOTAStatusInfo) {
        if (this.bleOTAHandler != null) {
            synchronized (this) {
                if (isDuplicateStatus(this.bleOTAHandler, fOTAStatusInfo)) {
                    e3.a.v("Fota status info has invoked but override by cloud!", new Object[0]);
                    return;
                }
            }
        }
        if (this.meshOTAHandler != null) {
            synchronized (this) {
                if (isDuplicateStatus(this.meshOTAHandler, fOTAStatusInfo)) {
                    e3.a.v("Fota status info has invoked but override by cloud!", new Object[0]);
                    return;
                }
            }
        }
        k overAllListener = getOverAllListener();
        if (overAllListener == null) {
            return;
        }
        if (fOTAStatusInfo != null && fOTAStatusInfo.getUpgradeStatus() == 0) {
            this.cachedFOTAInfo = null;
        }
        overAllListener.onBoardFOTAStatusChange(this, fOTAStatusInfo);
    }

    private void openTimeWindow(long j7) {
        com.haier.library.common.util.b0 b0Var = this.mTimeWindowTimer;
        if (b0Var != null && b0Var.b()) {
            e3.a.h("ota tw: %s open time window again! cancel previous timer!", getDeviceId());
            this.mTimeWindowTimer.f();
        }
        long jL = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId()).l();
        long j8 = 600000 - (j7 - jL);
        e3.a.e("ota tw: bts = %d, remainTime = %d", Long.valueOf(jL), Long.valueOf(j8));
        this.mTimeWindowTimer = com.haier.library.common.util.a0.a(j8, TimeUnit.MILLISECONDS, new Runnable() { // from class: com.haier.uhome.usdk.api.w3
            @Override // java.lang.Runnable
            public final void run() {
                this.f31003a.recoveryUpgradeStatus();
            }
        });
    }

    private DeviceStatus passConditionIntoStatus(DeviceStatus deviceStatus) {
        return com.haier.library.common.util.u.h(getRealDeviceList()) ? DeviceStatus.STATUS_UNCONNECT : deviceStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reconnectControlDevice(com.haier.uhome.control.base.api.a aVar) {
        if (aVar != null) {
            aVar.a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.q2
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30701a.lambda$reconnectControlDevice$2(errorConst);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recoveryUpgradeStatus() {
        e3.a.e("ota tw: %s close time window OTA status restore!", getDeviceId());
        if (isModuleNeedOTA()) {
            setModuleNeedOTA(false);
            notifyBaseInfoChange();
        }
    }

    private void refreshConnection() {
        uSDKDevice device;
        List<com.haier.uhome.control.base.api.a> realDeviceList = getRealDeviceList();
        if (com.haier.library.common.util.u.h(realDeviceList)) {
            return;
        }
        boolean zNeedProperty = needProperty();
        String myGroupDevId = getMyGroupDevId();
        if (!TextUtils.isEmpty(myGroupDevId) && (device = uSDKDeviceManager.getSingleInstance().getDevice(myGroupDevId)) != null) {
            zNeedProperty = device.needProperty();
            e3.a.e("mesh device<%s> care=%s, group<%s> care=%s", Integer.valueOf(getElementAddr()), Integer.valueOf(device.getElementAddr()));
        }
        List<com.haier.uhome.control.base.api.a> listA = getBestConnect().a(this, isCare(), realDeviceList);
        if (listA == null) {
            listA = new ArrayList<>();
        }
        for (com.haier.uhome.control.base.api.a aVar : realDeviceList) {
            if (listA.contains(aVar)) {
                connectPass(aVar, (isMainDevice() && (aVar instanceof com.haier.uhome.control.local.api.h)) || zNeedProperty);
            } else {
                disConnectPass(aVar);
            }
        }
    }

    private void refreshLocalGatewayManager() {
        com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
        if (hVar == null) {
            uSDKDeviceManager.getSingleInstance().a().a(getDeviceId());
        } else if (hVar.M()) {
            uSDKDeviceManager.getSingleInstance().a().a(hVar);
        }
    }

    private void refreshNetType() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        uSDKDeviceNetTypeConst netType = getNetType();
        uSDKDeviceNetTypeConst usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_REMOTE;
        if (aVar == null) {
            if (netType != null) {
                usdkdevicenettypeconst = netType;
            }
            e3.a.u("", "", "refresh device<%s> net type but control device list is null", getDeviceId());
        } else if (aVar instanceof com.haier.uhome.control.local.api.h) {
            usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_LOCAL;
        } else if (!(aVar instanceof com.haier.uhome.control.cloud.api.c)) {
            if (aVar instanceof com.haier.uhome.control.noumenon.a.a) {
                usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_NOUMENON;
            } else if (aVar instanceof com.haier.uhome.control.local.api.g) {
                usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_BLE;
            } else if (aVar instanceof com.haier.uhome.control.local.api.d) {
                usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_MESH;
            } else if (aVar instanceof com.haier.uhome.control.local.api.i) {
                usdkdevicenettypeconst = uSDKDeviceNetTypeConst.NET_LOCAL_GATEWAY;
            }
        }
        if (netType != usdkdevicenettypeconst) {
            this.mNetTypeConst = usdkdevicenettypeconst;
            e3.a.d("", "", "device<%s> net type<%s> change to <%s>", getDeviceId(), netType + "", usdkdevicenettypeconst.toString());
        }
    }

    private void registerSystemListener() {
        if (this.mSystemListener == null) {
            this.mSystemListener = new com.haier.uhome.usdk.base.api.p() { // from class: com.haier.uhome.usdk.api.uSDKDevice.21
                @Override // com.haier.uhome.usdk.base.api.p
                public void a(boolean z7) {
                    uSDKDevice.this.adjust();
                }

                @Override // com.haier.uhome.usdk.base.api.p
                public void b(boolean z7) {
                    uSDKDevice.this.adjust();
                }
            };
        }
        r.a().a(this.mSystemListener);
    }

    private void resetFaultInformation() {
        uSDKFaultInformation usdkfaultinformation = new uSDKFaultInformation();
        usdkfaultinformation.a(0);
        usdkfaultinformation.b(0);
        this.mSDKFaultInformation = usdkfaultinformation;
        setStateCode(0);
        this.mEventHandler.a(false);
    }

    private void setAlarmList(List<com.haier.uhome.control.base.api.b> list) {
        this.mAlarmList.clear();
        if (list != null) {
            Iterator<com.haier.uhome.control.base.api.b> it = list.iterator();
            while (it.hasNext()) {
                this.mAlarmList.add(newAlarm(it.next()));
            }
        }
    }

    private void setControlDevice(com.haier.uhome.control.base.api.a aVar) {
        List<com.haier.uhome.control.base.api.b> listR;
        if (aVar == null) {
            e3.a.h("setControlDevice<%s> with a null object!! ", getDeviceId());
            return;
        }
        com.haier.uhome.control.base.api.a aVar2 = this.mTopControlDevice;
        if (aVar2 != null && aVar2.equals(aVar)) {
            e3.a.e("setControlDevice<%s> device no change so return", getDeviceId());
            return;
        }
        if (!lastChallenge(aVar2, aVar)) {
            e3.a.e("last challenger fail challenger<%s>, Original<%s>", aVar, aVar2 + "");
            return;
        }
        this.mTopControlDevice = aVar;
        if (aVar2 != null) {
            if (!aVar2.getClass().equals(this.mTopControlDevice.getClass()) && isDeadControlDevice(aVar2)) {
                destroyControlDev(aVar2);
            }
            listR = aVar2.r();
        } else {
            listR = null;
        }
        e3.a.e("setControlDevice<%s> success", getDeviceId());
        clearOfflineReason();
        adjust();
        refreshNetType();
        masterStateDi(Trace.createDITrace());
        if (aVar2 != null) {
            notifyBaseInfoChange();
        }
        if (notifyDeviceChange(this.mTopControlDevice, listR)) {
            e3.a.e("setControlDevice<%s> notifyDeviceChange ok", getDeviceId());
        }
        List<com.haier.uhome.control.base.api.a> realDeviceList = getRealDeviceList();
        if (com.haier.library.common.util.u.h(realDeviceList) || realDeviceList.size() != 1) {
            return;
        }
        this.mDeviceInfoMonitor.b();
    }

    private void setControlDeviceListener() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            e3.a.h("<%s>no mTopControlDevice to set listener", getDeviceId());
            return;
        }
        for (com.haier.uhome.control.base.api.a aVar2 : getRealDeviceList()) {
            if (aVar2 != null && aVar2 != aVar) {
                aVar2.a(this.mGrabControlListener);
            }
        }
        aVar.a(this.mControlDeviceListener);
    }

    private void setStateCode(int i7) {
        this.stateCode = i7;
    }

    private void startBleMeshOta(ICallback<Void> iCallback) {
        checkAndCreate();
        ICallback<Void> iCallback2 = (ICallback) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class);
        if (this.meshOTAHandler != null) {
            this.meshOTAHandler.b(iCallback2);
        }
    }

    private void startBleOta(ICallback<Void> iCallback) {
        checkAndCreate();
        ICallback<Void> iCallback2 = (ICallback) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class);
        if (this.bleOTAHandler != null) {
            this.bleOTAHandler.b(iCallback2);
        }
    }

    private boolean supportNetworkQuality() {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        if (fVarA == null) {
            return false;
        }
        return fVarA.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean topPassSupportSeq() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (com.haier.uhome.usdk.base.api.e.b(getChannel())) {
            return true;
        }
        return aVar != null && aVar.h_() > 0;
    }

    private void tryActivateControlDevice(com.haier.uhome.control.base.api.a aVar) {
        com.haier.uhome.control.base.api.a aVar2 = this.mTopControlDevice;
        if (aVar2 == null || aVar == null || !aVar2.getClass().equals(aVar.getClass()) || this.mTopControlDevice == aVar) {
            return;
        }
        this.mTopControlDevice = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryGetCloudDeviceState() {
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (cVar != null && isSpecialCloudOfflineCase()) {
            e3.a.e("tryGetCloudDeviceState start", new Object[0]);
            cVar.b((com.haier.uhome.usdk.base.api.o) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.usdk.base.api.c<String> tryGetDeviceBindInfoOnce(final String str, final boolean z7, final TraceNode traceNode, long j7) {
        e3.a.o("tryGetDeviceBindInfo start", new Object[0]);
        final com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        if (!uSDKManager.getSingleInstance().a()) {
            cVar.a(ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return cVar;
        }
        cVar.a(ErrorConst.ERR_USDK_TIMEOUT.toError());
        long jCurrentTimeMillis = j7 - System.currentTimeMillis();
        if (jCurrentTimeMillis <= 0) {
            return cVar;
        }
        e3.a.o("tryGetDeviceBindInfo remainTime <%d>", Long.valueOf(jCurrentTimeMillis));
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        Runnable runnable = new Runnable() { // from class: com.haier.uhome.usdk.api.l2
            @Override // java.lang.Runnable
            public final void run() {
                this.f30624a.lambda$tryGetDeviceBindInfoOnce$24(cVar, gVar, str, z7, traceNode);
            }
        };
        if (jCurrentTimeMillis >= 5000) {
            jCurrentTimeMillis = 5200;
        }
        return (com.haier.uhome.usdk.base.api.c) gVar.b(runnable, cVar, jCurrentTimeMillis);
    }

    private void unRegisterSystemListener() {
        if (this.mSystemListener == null) {
            e3.a.h("unRegisterSystemListener with a null SystemListener object", new Object[0]);
        } else {
            r.a().b(this.mSystemListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upDeviceVersion(com.haier.uhome.control.cloud.api.f fVar) {
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (cVar != null) {
            cVar.a(fVar);
        }
    }

    private void updateHandlerDevice(com.haier.uhome.control.local.api.a aVar) {
        checkAndCreate();
        if (this.bleOTAHandler != null) {
            this.bleOTAHandler.a(aVar);
        }
        if (this.meshOTAHandler != null) {
            this.meshOTAHandler.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRouterSSIDPasswordEnd() {
        if (this.mSDKDeviceBleEventInfo == null) {
            e3.a.v("updateRouterSSIDPasswordEnd mSDKDeviceBleEventInfo is null", new Object[0]);
        } else {
            com.haier.uhome.control.local.e.b.l().b(this.mSDKDeviceBleEventInfo.c(), this.mSDKDeviceBleEventInfo.d(), new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.18
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    e3.a.v("updateRouterSSIDPasswordEnd onSuccess", new Object[0]);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    e3.a.v("updateRouterSSIDPasswordEnd onFailure", new Object[0]);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRouterSSIDTimeout() {
        if (this.mUpdateRouterCallBack != null) {
            e3.a.v("updateRouterSSIDTimeout", new Object[0]);
            this.mUpdateRouterCallBack.onFailure(ErrorConst.ERR_USDK_UPDATE_SSID_PASSWORD_TIMEOUT.toError());
            this.mUpdateRouterCallBack = null;
            updateSSIDTimeoutTimerCancel();
            updateRouterSSIDPasswordEnd();
        }
    }

    private void updateSSIDPasswordState(v vVar) {
        e3.a.v("onUpdateFaultInformation sdkFaultInformation : %s", vVar.toString());
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (cVar == null || !cVar.X().equals(vVar.c())) {
            return;
        }
        e3.a.v("onUpdateFaultInformation Have binding relationship", new Object[0]);
        if (vVar.h() != 1) {
            resetFaultInformation();
            return;
        }
        if (vVar.i() != 1001 && vVar.i() != 1002 && vVar.i() != 1003 && vVar.i() != 1004) {
            if (vVar.i() == 1000) {
                resetFaultInformation();
                if (this.mUpdateRouterCallBack != null) {
                    this.mEventHandler.addObserver(this);
                    this.mUpdateRouterCallBack.onSuccess(0);
                    updateSSIDTimeoutTimerCancel();
                    this.mUpdateRouterCallBack = null;
                    updateRouterSSIDPasswordEnd();
                    k overAllListener = getOverAllListener();
                    if (overAllListener == null) {
                        e3.a.v("device <%s> onBleReplyStatus with null listener", vVar.c());
                        return;
                    } else {
                        overAllListener.onUpdateFaultInformation(this.mSDKFaultInformation);
                        return;
                    }
                }
                return;
            }
            return;
        }
        e3.a.v("onUpdateFaultInformation updateSSIDPasswordState SDKFaultInformation %s", Integer.valueOf(getStateCode()));
        if (this.mUpdateRouterCallBack != null) {
            this.mEventHandler.addObserver(this);
            callUpdateRouterFailure(uSDKErrorConst.ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD.toError());
            this.mUpdateRouterCallBack = null;
        } else if (getStateCode() != vVar.i()) {
            this.mSDKDeviceBleEventInfo = vVar;
            uSDKFaultInformation usdkfaultinformation = new uSDKFaultInformation();
            usdkfaultinformation.a(vVar.h());
            usdkfaultinformation.b(vVar.i());
            this.mSDKFaultInformation = usdkfaultinformation;
            setStateCode(vVar.i());
            k overAllListener2 = getOverAllListener();
            if (overAllListener2 == null) {
                e3.a.v("device <%s> onBleReplyStatus with null listener", vVar.c());
            } else {
                overAllListener2.onUpdateFaultInformation(usdkfaultinformation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSSIDTimeoutTimerCancel() {
        com.haier.library.common.util.b0 b0Var = this.mUpdateRouterTimer;
        if (b0Var != null) {
            b0Var.f();
            this.mUpdateRouterTimer = null;
        }
    }

    @Keep
    public void addDeviceListener(DeviceListener deviceListener) {
        this.deviceListener.a(deviceListener);
        adjust();
    }

    @Keep
    public void addDevicesToGroup(List<uSDKDevice> list, int i7, IProgressCallback<uSDKDevice, Void> iProgressCallback) {
        f.a(this, list, i7, (IProgressCallback) com.haier.uhome.usdk.base.utils.b.a(iProgressCallback, (Class<?>) IProgressCallback.class));
    }

    void addLocalGateway(com.haier.uhome.control.local.api.h hVar) {
        com.haier.uhome.control.local.api.i iVar = this.mLocalGatewayDevice;
        if (iVar == null) {
            e3.a.e("addLocalGateway to <%s> but is have not a localGatewayDevice", new Object[0]);
        } else {
            iVar.a(hVar);
        }
    }

    void addSubDevice(String str, uSDKDevice usdkdevice) {
        Map<String, uSDKDevice> map = this.mSubDeviceMap;
        if (map == null) {
            e3.a.h("add sub device<%s> error", getDeviceId());
        } else if (map.put(str, usdkdevice) == null) {
            c.a().a(this, getSubDeviceList());
        }
    }

    public void authToDevice(final IuSDKCallback iuSDKCallback) {
        if (this.mTopControlDevice == null) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.b4
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$authToDevice$31(iuSDKCallback);
                }
            });
            return;
        }
        String softwareType = getSoftwareType();
        e3.a.o("softwareType:" + softwareType, new Object[0]);
        if (!com.haier.uhome.usdk.base.a.am.equalsIgnoreCase(softwareType)) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.y3
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$authToDevice$28(iuSDKCallback);
                }
            });
        } else {
            this.mTopControlDevice.a(com.haier.uhome.usdk.base.service.e.a().g(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.a4
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    uSDKDevice.lambda$authToDevice$30(iuSDKCallback, errorConst);
                }
            });
        }
    }

    public void authToDeviceInvalid(final IuSDKCallback iuSDKCallback) {
        if (this.mTopControlDevice == null) {
            e3.a.o("mAuthInvalidDeviceId=" + this.mAuthInvalidDeviceId, new Object[0]);
            com.haier.uhome.control.base.c.d.a().a(com.haier.uhome.usdk.base.service.e.a().b(), com.haier.uhome.usdk.base.service.e.a().g(), this.mAuthInvalidDeviceId, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.h3
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    uSDKDevice.lambda$authToDeviceInvalid$37(iuSDKCallback, errorConst);
                }
            });
            return;
        }
        String softwareType = getSoftwareType();
        e3.a.o("softwareType:" + softwareType, new Object[0]);
        if (!com.haier.uhome.usdk.base.a.am.equalsIgnoreCase(softwareType)) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.f3
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$authToDeviceInvalid$32(iuSDKCallback);
                }
            });
        } else {
            this.mTopControlDevice.b(com.haier.uhome.usdk.base.service.e.a().g(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.g3
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    uSDKDevice.lambda$authToDeviceInvalid$34(iuSDKCallback, errorConst);
                }
            });
        }
    }

    public void cancelFetchBLEHistoryData(ICallback<Void> iCallback) {
        if (!isPureBleDevice()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_NOT_SUPPORT.toError());
            return;
        }
        com.haier.uhome.control.local.api.g gVar = this.mLocalBLEDevice;
        if (gVar == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
        } else {
            gVar.c(iCallback);
        }
    }

    @Keep
    public void checkBoardFOTAInfo(ICallback<FOTAInfo> iCallback) {
        int channel = getChannel();
        if (com.haier.uhome.usdk.base.api.e.e(channel)) {
            checkBleMeshOtaInfo(iCallback);
        } else if (com.haier.uhome.usdk.base.api.e.c(channel)) {
            checkBleOtaInfo(iCallback);
        } else {
            doCheckBoardFOTAInfo(iCallback);
        }
    }

    void checkCloudConnect() {
        final com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (cVar == null) {
            e3.a.e("checkCloudConnect no cloudDevice object!!", new Object[0]);
        } else {
            cVar.a(com.haier.uhome.usdk.base.a.ag, new ArrayList(), 5, Trace.createDITrace(), com.haier.uhome.usdk.base.a.ag, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.16
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    e3.a.e("checkCloudConnect getAllProperty: onSuccess ", new Object[0]);
                    uSDKDevice.this.handleOpCallback(cVar, ErrorConst.RET_USDK_OK.toError());
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    e3.a.e("checkCloudConnect getAllProperty: onFailure %s ", usdkerror);
                    uSDKDevice.this.handleOpCallback(cVar, usdkerror);
                }
            });
        }
    }

    void checkModuleOTAStatus() {
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        boolean z7 = cVar != null && (cVar.n() == DeviceStatus.STATUS_CONNECTED || cVar.n() == DeviceStatus.STATUS_READY);
        if (isNetTypeContain(uSDKDeviceNetTypeConst.NET_REMOTE) && z7) {
            e3.a.e("ota check: %s remote connected not support ota!", getDeviceId());
            if (isModuleNeedOTA()) {
                setModuleNeedOTA(false);
                notifyBaseInfoChange();
                return;
            }
            return;
        }
        if (!isNetTypeContain(uSDKDeviceNetTypeConst.NET_LOCAL)) {
            e3.a.e("ota check: %s not contains local net type!", getDeviceId());
            if (isModuleNeedOTA()) {
                setModuleNeedOTA(false);
                notifyBaseInfoChange();
                return;
            }
            return;
        }
        if (!isInTimeWindow()) {
            e3.a.e("ota check: not in time window!", new Object[0]);
            setModuleNeedOTA(false);
            notifyBaseInfoChange();
            return;
        }
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        com.haier.uhome.usdk.base.api.h hVarF = fVarA.f();
        if (hVarF == null) {
            e3.a.e("ota check: %s deviceInfo is null", getDeviceId());
            return;
        }
        com.haier.uhome.control.local.b.f fVarA2 = com.haier.uhome.control.local.c.a.a(getUplusId(), hVarF, fVarA.p().g(), fVarA.p().h(), fVarA.p().i());
        setModuleNeedOTA(fVarA2.d());
        e3.a.d("ota check: %s ota version check result = %s", getDeviceId(), fVarA2.toString(), new Object[0]);
        if (isModuleNeedOTA()) {
            setModuleOTATargetFile(fVarA2.b());
            setModuleOTATargetVersion(fVarA2.a());
            notifyBaseInfoChange();
        }
    }

    public void connect(final IuSDKCallback iuSDKCallback) {
        this.mNeedProperty.set(false);
        connectControlDevice(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.z2
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                uSDKDevice.lambda$connect$16(iuSDKCallback, errorConst);
            }
        });
    }

    public void connectNeedProperties(final IuSDKCallback iuSDKCallback) {
        this.mNeedProperty.set(true);
        connectControlDevice(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.z3
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                uSDKDevice.lambda$connectNeedProperties$17(iuSDKCallback, errorConst);
            }
        });
    }

    @Keep
    public void createGroup(int i7, ICallback<uSDKDevice> iCallback) {
        f.a(this, i7, (ICallback) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class));
    }

    @Keep
    public void deleteGroup(ICallback<Void> iCallback) {
        f.b(this, (ICallback) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class));
    }

    void destroy() {
        e3.a.e("destroy uSDKDevice<%s>", getDeviceId());
        List<com.haier.uhome.control.base.api.a> realDeviceList = getRealDeviceList();
        if (!com.haier.library.common.util.u.h(realDeviceList)) {
            Iterator<com.haier.uhome.control.base.api.a> it = realDeviceList.iterator();
            while (it.hasNext()) {
                destroyControlDev(it.next());
            }
        }
        this.mDeviceInfoMonitor.c();
        com.haier.uhome.usdk.api.interfaces.d dVar = this.mDeviceDelListener;
        if (dVar != null) {
            dVar.onDeviceDel(getDeviceId());
        }
        if (this.mTokenObserver != null) {
            com.haier.uhome.usdk.base.service.e.a().b(this.mTokenObserver);
            this.mTokenObserver = null;
        }
        unRegisterSystemListener();
    }

    public void disconnect(final IuSDKCallback iuSDKCallback) {
        e3.a.o("disconnect device<%s>", getDeviceId());
        this.mNeedProperty.set(false);
        boolean zA = com.haier.uhome.trace.api.a.a(iuSDKCallback);
        com.haier.uhome.usdk.base.api.o bVar = new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.i3
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30582a.lambda$disconnect$18(iuSDKCallback, errorConst);
            }
        };
        if (zA) {
            bVar = new com.haier.uhome.usdk.base.e.b(bVar);
        }
        if (disConnectControlDevice(bVar)) {
            checkDelLocal();
            checkNotifyDel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: doUpdateControlDevice, reason: merged with bridge method [inline-methods] */
    public void lambda$updateControlDevice$1(a aVar, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        e3.a.e("updateControlDevice<%s> info<%s> net type<%s>", getDeviceId(), aVar, usdkdevicenettypeconst.getValue());
        if (aVar != null) {
            clearOfflineReason();
        }
        switch (AnonymousClass20.f30774b[usdkdevicenettypeconst.ordinal()]) {
            case 1:
                makeLocalDevice(aVar);
                break;
            case 2:
                makeCloudDevice(aVar);
                break;
            case 3:
                makeNoumenonDevice(aVar);
                break;
            case 4:
                makeBleDevice(aVar);
                break;
            case 5:
                makeMeshDevice(aVar);
                break;
            case 6:
                makeLocalGateway(aVar);
                break;
        }
        if (aVar != null && !TextUtils.isEmpty(aVar.f30809b)) {
            setUplusId(aVar.f30809b);
        }
        if (!isHideDevice() && this.mIsShow.compareAndSet(false, true)) {
            notifyAdd();
        }
        adjust();
    }

    @Deprecated
    public void execOperation(String str, List<uSDKArgument> list, IuSDKCallback iuSDKCallback) {
        execOperation(str, list, 15, iuSDKCallback);
    }

    public void fetchBLEHistoryData(ICallback<Void> iCallback) {
        if (!isPureBleDevice()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_NOT_SUPPORT.toError());
            return;
        }
        com.haier.uhome.control.local.api.g gVar = this.mLocalBLEDevice;
        if (gVar == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
        } else {
            gVar.b(iCallback);
        }
    }

    @Keep
    public void fetchBoardFOTAStatus(ICallback<FOTAStatusInfo> iCallback) {
        uSDKErrorConst usdkerrorconstCheckFOTADeviceState = checkFOTADeviceState();
        if (usdkerrorconstCheckFOTADeviceState != uSDKErrorConst.RET_USDK_OK) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorconstCheckFOTADeviceState.toError());
        } else {
            this.mCloudDevice.b(iCallback);
        }
    }

    @Keep
    public void fetchGroupableDeviceList(ICallback<List<uSDKDevice>> iCallback) {
        f.a(this, (ICallback<List<uSDKDevice>>) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class));
    }

    public ArrayList<uSDKDeviceAlarm> getAlarmList() {
        try {
            return com.haier.library.common.util.u.a(new ArrayList(this.mAlarmList), new h2());
        } catch (IllegalArgumentException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public void getAllCacheAlarm(final IuSDKCallback iuSDKCallback) {
        if (uSDKDeviceManager.getSingleInstance().e() == null) {
            callbackWithError(iuSDKCallback, uSDKErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST);
        } else {
            com.haier.uhome.control.cloud.service.c.l().a(getDeviceId(), Trace.createDITrace(), new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.25
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    uSDKDevice.this.callbackWithError(iuSDKCallback, uSDKErrorConst.RET_USDK_OK);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    uSDKDevice.this.callbackWithError(iuSDKCallback, uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                }
            });
        }
    }

    public void getAllCacheProperty(final IuSDKCallback iuSDKCallback) {
        if (uSDKDeviceManager.getSingleInstance().e() == null) {
            callbackWithError(iuSDKCallback, uSDKErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST);
        } else {
            com.haier.uhome.control.cloud.service.c.l().b(getDeviceId(), Trace.createDITrace(), new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.26
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    uSDKDevice.this.callbackWithError(iuSDKCallback, uSDKErrorConst.RET_USDK_OK);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    uSDKDevice.this.callbackWithError(iuSDKCallback, uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                }
            });
        }
    }

    public u getAppProtocolType() {
        return u.a(this.mTopControlDevice.p().name());
    }

    public HashMap<String, uSDKDeviceAttribute> getAttributeMap() {
        return com.haier.library.common.util.u.c(new HashMap(this.mAttrMap), new x2());
    }

    protected l getBestConnect() {
        l lVarMakeBestConnect;
        l lVar = this.mBestConnect;
        if (lVar != null) {
            return lVar;
        }
        synchronized (this) {
            lVarMakeBestConnect = this.mBestConnect;
            if (lVarMakeBestConnect == null) {
                lVarMakeBestConnect = uSDKDeviceManager.getSingleInstance().makeBestConnect();
                this.mBestConnect = lVarMakeBestConnect;
            }
        }
        return lVarMakeBestConnect;
    }

    @Keep
    public int getChannel() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar != null) {
            return aVar.ai();
        }
        e3.a.v("getChannel with null mTopControlDevice", new Object[0]);
        return 0;
    }

    public void getDeviceAuthState(final IuSDKResultCallback<Boolean> iuSDKResultCallback) {
        if (this.mTopControlDevice == null) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.o3
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$getDeviceAuthState$41(iuSDKResultCallback);
                }
            });
            return;
        }
        String softwareType = getSoftwareType();
        e3.a.o("softwareType:" + softwareType, new Object[0]);
        if (!com.haier.uhome.usdk.base.a.am.equalsIgnoreCase(softwareType)) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.s2
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$getDeviceAuthState$38(iuSDKResultCallback);
                }
            });
        } else {
            this.mTopControlDevice.a(com.haier.uhome.usdk.base.service.e.a().g(), new com.haier.uhome.control.base.api.k() { // from class: com.haier.uhome.usdk.api.d3
                @Override // com.haier.uhome.control.base.api.k
                public final void onGetDeviceAuthState(ErrorConst errorConst, boolean z7) {
                    uSDKDevice.lambda$getDeviceAuthState$40(iuSDKResultCallback, errorConst, z7);
                }
            });
        }
    }

    @Keep
    @Deprecated
    public void getDeviceBindInfo(String str, IuSDKGetDeviceBindInfoCallback iuSDKGetDeviceBindInfoCallback) {
        getDeviceBindInfo(str, (TraceNode) null, iuSDKGetDeviceBindInfoCallback);
    }

    public IuSDKDeviceListener getDeviceListener() {
        return this.deviceListener.a();
    }

    public void getDeviceNetQuality(final IuSDKGetDeviceNetQualityCallback iuSDKGetDeviceNetQualityCallback) {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.v2
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$getDeviceNetQuality$27(iuSDKGetDeviceNetQualityCallback);
                }
            });
        } else if (TextUtils.isEmpty(aVar.W())) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.t2
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$getDeviceNetQuality$25(iuSDKGetDeviceNetQualityCallback);
                }
            });
        } else {
            this.mTopControlDevice.a(com.haier.uhome.usdk.base.service.e.a().g(), new com.haier.uhome.control.base.api.m() { // from class: com.haier.uhome.usdk.api.u2
                @Override // com.haier.uhome.control.base.api.m
                public final void onDeviceNetQualityGet(ErrorConst errorConst, com.haier.uhome.control.base.api.f fVar, int i7) {
                    uSDKDevice.lambda$getDeviceNetQuality$26(iuSDKGetDeviceNetQualityCallback, errorConst, fVar, i7);
                }
            });
        }
    }

    @Deprecated
    public String getEProtocolVer() {
        return "";
    }

    public int getElementAddr() {
        com.haier.uhome.usdk.base.api.f.b bVarS;
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        if (fVarA == null || (bVarS = fVarA.s()) == null) {
            return -1;
        }
        return bVarS.a();
    }

    @Keep
    public List<uSDKDevice> getGroupMemberList() {
        if (!isGroup()) {
            return Collections.emptyList();
        }
        List<uSDKDevice> listD = uSDKDeviceManager.getSingleInstance().d();
        if (com.haier.library.common.util.u.h(listD)) {
            return Collections.emptyList();
        }
        final String deviceId = getDeviceId();
        return TextUtils.isEmpty(deviceId) ? Collections.emptyList() : com.haier.library.common.util.u.b(listD, new com.haier.library.common.util.u.c() { // from class: com.haier.uhome.usdk.api.l3
            @Override // com.haier.library.common.util.u.c
            public final boolean a(Object obj) {
                return uSDKDevice.lambda$getGroupMemberList$50(deviceId, (uSDKDevice) obj);
            }
        });
    }

    protected DeviceStatus getHighestStatus() {
        return needProperty() ? DeviceStatus.STATUS_READY : DeviceStatus.STATUS_CONNECTED;
    }

    public String getIp() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar != null) {
            return aVar.H();
        }
        e3.a.v("getIp with null mTopControlDevice", new Object[0]);
        return null;
    }

    public int getMiddleType() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            return 0;
        }
        return aVar.ab();
    }

    public void getModuleInfo(int i7, ICallback<ModuleInfo> iCallback) {
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (cVar == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_REMOTE_DEVICE_NOT_EXIST.toError());
        } else {
            cVar.a(i7, iCallback);
        }
    }

    @Keep
    protected String getMyGroupDevId() {
        com.haier.uhome.usdk.base.api.f.b bVarS;
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        if (fVarA == null || (bVarS = fVarA.s()) == null) {
            return null;
        }
        return bVarS.b();
    }

    public uSDKDeviceNetTypeConst getNetType() {
        uSDKDeviceNetTypeConst usdkdevicenettypeconst = this.mNetTypeConst;
        return usdkdevicenettypeconst == null ? uSDKDeviceNetTypeConst.NET_REMOTE : usdkdevicenettypeconst;
    }

    @Keep
    public void getNetworkQuality(ICallback<uSDKNetworkQualityInfo> iCallback) {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            callbackWithError(iCallback, uSDKErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
        } else if (!isNetTypeContain(uSDKDeviceNetTypeConst.NET_LOCAL) || supportNetworkQuality()) {
            aVar.a(5, (Trace) null, new AnonymousClass9(iCallback));
        } else {
            callbackWithError(iCallback, uSDKErrorConst.ERR_USDK_DEVICE_NOT_NETQUALITY.toError());
        }
    }

    @Keep
    public void getNetworkQualityV2(ICallback<uSDKNetworkQualityInfoV2> iCallback) {
        if (iCallback == null) {
            e3.a.v("getNetworkQualityV2 callback is null!", new Object[0]);
            return;
        }
        if (!uSDKManager.getSingleInstance().a()) {
            callbackWithError(iCallback, ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            callbackWithError(iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
        } else {
            aVar.a(com.haier.uhome.usdk.base.service.e.a().g(), new AnonymousClass10(iCallback));
        }
    }

    protected int getOffLineReason(uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        com.haier.uhome.control.local.api.g gVar;
        int i7 = AnonymousClass20.f30774b[usdkdevicenettypeconst.ordinal()];
        if (i7 == 1) {
            com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
            if (hVar != null) {
                return hVar.g();
            }
            return 0;
        }
        if (i7 == 2) {
            com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
            if (cVar != null) {
                return cVar.g();
            }
            return 0;
        }
        if (i7 != 3) {
            if (i7 == 4 && (gVar = this.mLocalBLEDevice) != null) {
                return gVar.g();
            }
            return 0;
        }
        com.haier.uhome.control.noumenon.a.a aVar = this.mNoumenonDevice;
        if (aVar != null) {
            return aVar.g();
        }
        return 0;
    }

    public k getOverAllListener() {
        return this.deviceListener;
    }

    public uSDKDevice getParentDevice() {
        return uSDKDeviceManager.getSingleInstance().getDevice(this.mMainDeviceId);
    }

    protected int getPort() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar != null) {
            return aVar.I();
        }
        e3.a.v("getPort with null mTopControlDevice", new Object[0]);
        return 0;
    }

    @Keep
    public uSDKFaultInformation getSDKFaultInformation() {
        return this.mSDKFaultInformation;
    }

    public uSDKDeviceSecurityConst getSecurity() {
        int securityVersion = getSecurityVersion();
        if (securityVersion == 0) {
            return uSDKDeviceSecurityConst.UNSAFE;
        }
        return securityVersion > 0 ? uSDKDeviceSecurityConst.SAFE : uSDKDeviceSecurityConst.UNKNOWN;
    }

    public int getSecurityVersion() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            return -1;
        }
        try {
            com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
            if (aVar == hVar) {
                return hVar.K();
            }
            com.haier.uhome.control.local.api.g gVar = this.mLocalBLEDevice;
            if (aVar == gVar) {
                return gVar.M();
            }
            return -1;
        } catch (NullPointerException e8) {
            e8.printStackTrace();
        }
    }

    @Deprecated
    public String getSmartLinkDevfileVersion() {
        return "";
    }

    @Deprecated
    public String getSmartLinkHardwareVersion() {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        return fVarA == null ? "" : fVarA.p().g();
    }

    @Deprecated
    public String getSmartLinkSoftwareVersion() {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        return fVarA == null ? "" : fVarA.p().h();
    }

    @Override // com.haier.uhome.usdk.api.uSDKDeviceInfo
    public String getSoftwareType() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        return aVar != null ? aVar.ac() : "";
    }

    public String getSpecialId() {
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null) {
            return null;
        }
        return aVar.ad();
    }

    public uSDKDeviceStatusConst getStatus() {
        return uSDKDeviceStatusConst.getInstance(this.mDeviceStatus.name());
    }

    @Deprecated
    public uSDKDevice getSubDeviceById(int i7) {
        if (!com.haier.uhome.control.base.c.d(getUplusId())) {
            e3.a.o("call getSubDeviceByKey with a device not main", new Object[0]);
            return null;
        }
        Map<String, uSDKDevice> map = this.mSubDeviceMap;
        if (map == null || map.size() == 0) {
            return null;
        }
        return map.get(String.valueOf(i7));
    }

    @Deprecated
    public int getSubDeviceId() {
        if (this.mMainDeviceId == null) {
            return 0;
        }
        return com.haier.uhome.control.base.c.b(getDeviceId());
    }

    public ArrayList<uSDKDevice> getSubDeviceList() {
        if (!isComplexDevice() || this.mMainDeviceId != null) {
            return null;
        }
        Map<String, uSDKDevice> map = this.mSubDeviceMap;
        if (map != null) {
            return new ArrayList<>(map.values());
        }
        e3.a.o("getSubDeviceList return null", new Object[0]);
        return null;
    }

    public uSDKDeviceTypeConst getType() {
        com.haier.uhome.usdk.base.api.h hVarAa;
        com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (aVar == null || (hVarAa = aVar.aa()) == null) {
            return null;
        }
        return uSDKDeviceTypeConst.getInstance(hVarAa.name());
    }

    @Keep
    public boolean inFocus() {
        boolean zA = getBestConnect().a();
        e3.a.e("device<%s> in focus ret %b", getDeviceId(), Boolean.valueOf(zA));
        if (zA) {
            adjust();
            checkCloudConnect();
        }
        return zA;
    }

    public void invalidToken() {
        com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
        if (hVar == null || !isCare() || hVar.K() == 0) {
            return;
        }
        hVar.a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.n3
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30655a.lambda$invalidToken$49(errorConst);
            }
        }));
    }

    @Keep
    public boolean isBound() {
        return isNetTypeContain(uSDKDeviceNetTypeConst.NET_REMOTE);
    }

    @Deprecated
    public boolean isComplexDevice() {
        return com.haier.uhome.control.base.c.d(getUplusId());
    }

    public boolean isGroup() {
        com.haier.uhome.usdk.base.api.f.b bVarS;
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        if (fVarA == null || (bVarS = fVarA.s()) == null) {
            return false;
        }
        return bVarS.c();
    }

    boolean isHideDevice() {
        if (isCare()) {
            return false;
        }
        return isOnlyNetTypeContain(uSDKDeviceNetTypeConst.NET_BLE) || com.haier.library.common.util.u.h(getRealDeviceList());
    }

    boolean isLocalGateway() {
        com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
        return hVar != null && hVar.M();
    }

    boolean isMainDevice() {
        return com.haier.uhome.control.base.c.d(getUplusId()) && this.mMainDeviceId == null;
    }

    public boolean isNetTypeContain(uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        com.haier.uhome.usdk.base.api.b bVar;
        if (usdkdevicenettypeconst == null) {
            e3.a.o("call isNetTypeContain with null param", new Object[0]);
            return false;
        }
        switch (AnonymousClass20.f30774b[usdkdevicenettypeconst.ordinal()]) {
            case 1:
                bVar = this.mLocalDevice;
                break;
            case 2:
                bVar = this.mCloudDevice;
                break;
            case 3:
                bVar = this.mNoumenonDevice;
                break;
            case 4:
                bVar = this.mLocalBLEDevice;
                break;
            case 5:
                bVar = this.mBleMeshDevice;
                break;
            case 6:
                bVar = this.mLocalGatewayDevice;
                break;
            default:
                e3.a.v("isNetTypeContain netType <%s> Illegal", usdkdevicenettypeconst);
                bVar = null;
                break;
        }
        return bVar != null;
    }

    protected uSDKDeviceNetTypeConst module2NetType(String str) {
        if ("local".equals(str)) {
            return uSDKDeviceNetTypeConst.NET_LOCAL;
        }
        if (com.haier.uhome.usdk.base.a.ao.equals(str)) {
            return uSDKDeviceNetTypeConst.NET_REMOTE;
        }
        if (com.haier.uhome.usdk.base.a.aq.equals(str)) {
            return uSDKDeviceNetTypeConst.NET_BLE;
        }
        return com.haier.uhome.usdk.base.a.ar.equals(str) ? uSDKDeviceNetTypeConst.NET_NOUMENON : uSDKDeviceNetTypeConst.NET_REMOTE;
    }

    public void moduleOTA(IuSDKOTACallback iuSDKOTACallback) {
        synchronized (this) {
            if (this.mOTAHandler == null) {
                this.mOTAHandler = new h(this, this.mLocalDevice);
            }
        }
        this.mOTAHandler.a(iuSDKOTACallback);
        this.mOTAHandler.a();
    }

    protected void onCloudStateChange() {
        adjust();
    }

    @Keep
    public boolean outFocus() {
        boolean zB = getBestConnect().b();
        e3.a.e("device<%s> out focus ret %b", getDeviceId(), Boolean.valueOf(zB));
        if (zB) {
            adjust();
        }
        return zB;
    }

    @Deprecated
    public void readAttribute(String str, IuSDKReadAttributeCallback iuSDKReadAttributeCallback) {
        readAttribute(str, 15, iuSDKReadAttributeCallback);
    }

    @Keep
    public void removeDeviceListener(DeviceListener deviceListener) {
        this.deviceListener.b(deviceListener);
        adjust();
    }

    @Keep
    public void removeDevicesFromGroup(List<uSDKDevice> list, int i7, IProgressCallback<uSDKDevice, Void> iProgressCallback) {
        f.b(this, list, i7, (IProgressCallback) com.haier.uhome.usdk.base.utils.b.a(iProgressCallback, (Class<?>) IProgressCallback.class));
    }

    void removeSubDevice(String str) {
        Map<String, uSDKDevice> map = this.mSubDeviceMap;
        if (map == null) {
            e3.a.h("remove sub device<%s> error", getDeviceId());
        } else if (map.remove(str) != null) {
            c.a().a(this, getSubDeviceList());
        }
    }

    public com.haier.uhome.usdk.base.api.c<String> retryGetDeviceBindInfo(String str, int i7, TraceNode traceNode) {
        com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (!uSDKManager.getSingleInstance().a()) {
            cVar.a(uSDKErrorConst.ERR_MODULE_UNSTARTED.toError());
            return cVar;
        }
        if (TextUtils.isEmpty(str)) {
            cVar.a(uSDKErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError());
            return cVar;
        }
        cVar.a(uSDKErrorConst.ERR_USDK_TIMEOUT.toError());
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) (i7 * 1000));
        TraceNode traceNodeB = com.haier.uhome.trace.api.b.a().b(getDeviceId(), getSecurityVersion(), traceNode);
        while (jCurrentTimeMillis - System.currentTimeMillis() >= 0) {
            if (com.haier.uhome.usdk.bind.s.a().a(getDeviceId())) {
                cVar.a(ErrorConst.ERR_USDK_BIND_DEVICE_IS_CANCELED.toError());
            } else {
                error = cVar.b();
                cVar = tryGetDeviceBindInfoOnce(str, false, null, jCurrentTimeMillis);
                if (!cVar.b().a(ErrorConst.RET_USDK_OK)) {
                    long jCurrentTimeMillis2 = jCurrentTimeMillis - System.currentTimeMillis();
                    if (jCurrentTimeMillis2 > 0) {
                        if (jCurrentTimeMillis2 >= 1000) {
                            jCurrentTimeMillis2 = 1000;
                        }
                        SystemClock.sleep(jCurrentTimeMillis2);
                    }
                }
            }
            e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "getDeviceBindInfo result <%s>, bindinfo<%s>", Integer.valueOf(cVar.b().getCode()), cVar.c());
            com.haier.uhome.trace.api.b.a().e(cVar.b().getCode(), getDeviceId(), getSecurityVersion(), traceNodeB);
            cVar.a("node", traceNodeB);
            return cVar;
        }
        uSDKError usdkerrorB = cVar.b();
        ErrorConst errorConst = ErrorConst.ERR_USDK_TIMEOUT;
        if (usdkerrorB.a(errorConst)) {
            if (error.a(errorConst)) {
                cVar.a(ErrorConst.ERR_USDK_GET_BINDINFO_TIMEOUT.toError());
            } else {
                cVar.a(error);
            }
        }
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "getDeviceBindInfo result <%s>, bindinfo<%s>", Integer.valueOf(cVar.b().getCode()), cVar.c());
        com.haier.uhome.trace.api.b.a().e(cVar.b().getCode(), getDeviceId(), getSecurityVersion(), traceNodeB);
        cVar.a("node", traceNodeB);
        return cVar;
    }

    void rmLocalGateway(com.haier.uhome.control.local.api.h hVar) {
        e3.a.d("gateway device<%s> remove localGateway<%s>", getDeviceId(), hVar.X(), new Object[0]);
        com.haier.uhome.control.local.api.i iVar = this.mLocalGatewayDevice;
        if (iVar == null) {
            e3.a.d("gateway device<%s> remove localGateway<%s> but i no gateway device find", getDeviceId(), hVar.X(), new Object[0]);
            return;
        }
        iVar.b(hVar);
        if (isGroup() || iVar.S() != null) {
            return;
        }
        destroyControlDev(iVar);
    }

    protected void setDeviceDelListener(com.haier.uhome.usdk.api.interfaces.d dVar) {
        this.mDeviceDelListener = dVar;
    }

    public void setDeviceGatewayAndPort(String str, int i7, IuSDKCallback iuSDKCallback) {
        setDeviceGatewayAndPort(str, i7, com.haier.uhome.usdk.base.service.e.a().g(), iuSDKCallback);
    }

    @Deprecated
    public void setDeviceListener(IuSDKDeviceListener iuSDKDeviceListener) {
        e3.a.d("device<%s> setDeviceListener to %s", getDeviceId(), iuSDKDeviceListener == null ? "null" : iuSDKDeviceListener.getClass().getName(), new Object[0]);
        this.deviceListener.a(iuSDKDeviceListener);
    }

    protected void setMainDeviceId(String str) {
        if (str == null) {
            return;
        }
        this.mMainDeviceId = str;
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
        if (device != null) {
            device.addSubDevice(getDeviceId(), this);
        }
    }

    protected void setOffLineReason(uSDKDeviceNetTypeConst usdkdevicenettypeconst, int i7) {
        com.haier.uhome.control.local.api.g gVar;
        int i8 = AnonymousClass20.f30774b[usdkdevicenettypeconst.ordinal()];
        if (i8 == 1) {
            com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
            if (hVar != null) {
                if (i7 == 2) {
                    hVar.a(ErrorConst.ERR_USDK_OFFLINE_DECLARE.getErrorId());
                } else {
                    hVar.a(i7);
                }
            }
        } else if (i8 == 2) {
            com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
            if (cVar != null) {
                if (i7 == 2) {
                    cVar.a(ErrorConst.ERR_USDK_OFFLINE_DECLARE.getErrorId());
                } else {
                    cVar.a(i7);
                }
            }
        } else if (i8 == 3) {
            com.haier.uhome.control.noumenon.a.a aVar = this.mNoumenonDevice;
            if (aVar != null) {
                aVar.a(i7);
            }
        } else if (i8 == 4 && (gVar = this.mLocalBLEDevice) != null) {
            gVar.a(i7);
        }
        this.offlineReason = i7;
    }

    public List<com.haier.uhome.control.base.api.a> sortByPriority() {
        return getBestConnect().b(this, isCare(), getRealDeviceList());
    }

    @Keep
    public void startBoardFOTA(ICallback<Void> iCallback) {
        int channel = getChannel();
        if (com.haier.uhome.usdk.base.api.e.e(channel)) {
            startBleMeshOta(iCallback);
        } else if (com.haier.uhome.usdk.base.api.e.c(channel)) {
            startBleOta(iCallback);
        } else {
            doStartBoardFOTA(iCallback);
        }
    }

    public void startFOTA(DeviceFOTAInfo deviceFOTAInfo, ICallback<Void> iCallback) {
        synchronized (this) {
            if (this.mWifiOTAHandler == null) {
                this.mWifiOTAHandler = new i();
            }
        }
        this.mWifiOTAHandler.a(this.mCloudDevice, deviceFOTAInfo, iCallback);
    }

    public void subscribeResource(String str, final IuSDKCallback iuSDKCallback) {
        subscribeResourceWithDecode(str, 1, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.11
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(uSDKErrorConst.RET_USDK_OK);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                }
            }
        });
    }

    public void subscribeResourceWithDecode(String str, ICallback<Void> iCallback) {
        subscribeResourceWithDecode(str, 2, iCallback);
    }

    @Override // com.haier.uhome.usdk.api.uSDKDeviceInfo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.mTopControlDevice == null) {
            sb.append("mTopControlDevice is null!--");
        }
        sb.append("uSDKDevice{");
        sb.append("DevId = ");
        sb.append(getDeviceId());
        sb.append(",NetType = ");
        sb.append(getNetType());
        sb.append(",DeviceStatus = ");
        sb.append(getStatus());
        sb.append(",UplusId = ");
        sb.append(getUplusId());
        int elementAddr = getElementAddr();
        if (elementAddr != -1 && elementAddr != 0) {
            sb.append(",meshElementAddr = ");
            sb.append(elementAddr);
        }
        String myGroupDevId = getMyGroupDevId();
        if (!TextUtils.isEmpty(myGroupDevId)) {
            sb.append(",myGroupId = ");
            sb.append(myGroupDevId);
        }
        if (isGroup()) {
            List<uSDKDevice> groupMemberList = getGroupMemberList();
            if (!com.haier.library.common.util.u.h(groupMemberList)) {
                sb.append(", inGroupList = {");
                Iterator<uSDKDevice> it = groupMemberList.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().getDeviceId());
                    sb.append(",");
                }
                sb.append(com.alipay.sdk.util.j.f13808d);
            }
        }
        sb.append(com.alipay.sdk.util.j.f13808d);
        return sb.toString();
    }

    public void unsubscribeResource(String str, final IuSDKCallback iuSDKCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            callbackWithError(iuSDKCallback, uSDKErrorConst.ERR_USDK_UNSTARTED);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            callbackWithError(iuSDKCallback, uSDKErrorConst.ERR_USDK_INVALID_PARAM);
            return;
        }
        final com.haier.uhome.control.cloud.api.e eVar = this.mP2PHandle;
        if (eVar == null) {
            callbackWithError(iuSDKCallback, uSDKErrorConst.ERR_USDK_NOT_SUPPORT);
        } else {
            eVar.a(str, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.h4
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f30575a.lambda$unsubscribeResource$45(iuSDKCallback, eVar, errorConst);
                }
            });
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        com.haier.uhome.search.service.entity.d dVar = (com.haier.uhome.search.service.entity.d) obj;
        v vVar = new v();
        vVar.b(getDeviceId());
        vVar.c(dVar.d());
        vVar.e(dVar.f());
        vVar.f(dVar.g());
        vVar.b(dVar.k());
        vVar.c(dVar.h());
        vVar.a(dVar.b());
        updateSSIDPasswordState(vVar);
    }

    protected void updateControlDevice(final a aVar, final uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        this.mExecutor.a(new Runnable() { // from class: com.haier.uhome.usdk.api.j2
            @Override // java.lang.Runnable
            public final void run() {
                this.f30593a.lambda$updateControlDevice$1(aVar, usdkdevicenettypeconst);
            }
        });
    }

    void updateDeviceBleEventState(com.haier.uhome.search.service.entity.d dVar) {
        this.mEventHandler.a(dVar);
    }

    public void updateRouterProgress(RouterSsidPasswordEvent routerSsidPasswordEvent) {
        if (this.mUpdateRouterCallBack == null) {
            e3.a.v("onBleUpdateProgress mIuSDKUpdateRouterSSIDPasswordCallBack is null", new Object[0]);
            return;
        }
        e3.a.e("onBleUpdateProgress RouterSsidPasswordEvent event = " + routerSsidPasswordEvent.toString(), new Object[0]);
        if (routerSsidPasswordEvent.getProgress() == 3) {
            if (routerSsidPasswordEvent.getState() == 1) {
                if (com.haier.uhome.search.service.entity.d.e(routerSsidPasswordEvent.getStateCode())) {
                    callUpdateRouterFailure(ErrorConst.ERR_USDK_DEVICE_UPDATE_SSIS_PASSWORD_ERROR.toError());
                    updateSSIDTimeoutTimerCancel();
                    updateRouterSSIDPasswordEnd();
                    return;
                } else if (routerSsidPasswordEvent.getStateCode() == 1000) {
                    IuSDKUpdateRouterSSIDCallBack iuSDKUpdateRouterSSIDCallBack = this.mUpdateRouterCallBack;
                    if (iuSDKUpdateRouterSSIDCallBack != null) {
                        iuSDKUpdateRouterSSIDCallBack.onSuccess(0);
                        updateSSIDTimeoutTimerCancel();
                        resetFaultInformation();
                        this.mUpdateRouterCallBack = null;
                        updateRouterSSIDPasswordEnd();
                        k overAllListener = getOverAllListener();
                        if (overAllListener == null) {
                            e3.a.v("device updateRouterProgress with null listener", new Object[0]);
                            return;
                        } else {
                            overAllListener.onUpdateFaultInformation(this.mSDKFaultInformation);
                            return;
                        }
                    }
                    return;
                }
            }
        } else if (routerSsidPasswordEvent.getProgress() == 4 && routerSsidPasswordEvent.getResult() == 1) {
            callUpdateRouterFailure(ErrorConst.ERR_USDK_DEVICE_UPDATE_SSIS_PASSWORD_ERROR.toError());
            updateSSIDTimeoutTimerCancel();
            updateRouterSSIDPasswordEnd();
            return;
        }
        if (routerSsidPasswordEvent.getProgress() == 1) {
            this.mUpdateRouterCallBack.updateSSIDProgress(UpdateProgress.UPDATE_PROGRESS_CONNECTING);
        } else if (routerSsidPasswordEvent.getProgress() == 2) {
            this.mEventHandler.addObserver(this);
            this.mUpdateRouterCallBack.updateSSIDProgress(UpdateProgress.UPDATE_PROGRESS_UPDATING);
        }
    }

    @Keep
    public void updateRouterSSID(String str, String str2, String str3, int i7, IuSDKUpdateRouterSSIDCallBack iuSDKUpdateRouterSSIDCallBack) {
        String strG;
        String strD;
        String strF;
        com.haier.uhome.control.local.api.g gVar;
        if (iuSDKUpdateRouterSSIDCallBack == null) {
            e3.a.e("updateRouterSSIDPassword mIuSDKUpdateRouterSSIDPasswordCallBack is null", new Object[0]);
            return;
        }
        this.mUpdateRouterCallBack = (IuSDKUpdateRouterSSIDCallBack) com.haier.uhome.usdk.base.utils.b.a((Object) iuSDKUpdateRouterSSIDCallBack, (Class<?>) IuSDKUpdateRouterSSIDCallBack.class);
        if (i7 < 30 || i7 > 120) {
            e3.a.e("updateRouterSSIDPassword illegal parameter timeout", new Object[0]);
            callUpdateRouterFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.f.b(str)) {
            e3.a.e("updateRouterSSIDPassword illegal parameter ssid", new Object[0]);
            callUpdateRouterFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (!TextUtils.isEmpty(str3) && str3.length() != 12) {
            e3.a.e("updateRouterSSIDPassword illegal parameter bSsid length", new Object[0]);
            callUpdateRouterFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (com.haier.uhome.usdk.base.utils.f.c(str2)) {
            e3.a.e("updateRouterSSIDPassword illegal parameter password", new Object[0]);
            callUpdateRouterFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (this.mSDKDeviceBleEventInfo == null) {
            e3.a.v("updateRouterSSIDPassword mSDKDeviceBleEventInfo is null", new Object[0]);
            callUpdateRouterFailure(uSDKErrorConst.ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD.toError());
            return;
        }
        if (!com.haier.uhome.search.service.entity.d.e(getStateCode())) {
            callUpdateRouterFailure(uSDKErrorConst.ERR_USDK_DEVICE_DONT_NEED_UPDATE_SSID_PASSWORD.toError());
            return;
        }
        com.haier.library.common.util.b0 b0Var = this.mUpdateRouterTimer;
        if (b0Var != null && b0Var.b()) {
            callUpdateRouterFailure(uSDKErrorConst.ERR_USDK_DEVICE_CONFIG_IN_PROGRESS.toError());
            return;
        }
        e3.a.e("updateRouterSSID: mLocalBLEDevice = " + this.mLocalBLEDevice, new Object[0]);
        if (getStateCode() == 1004) {
            if (this.mLocalBLEDevice == null) {
                callUpdateRouterFailure(uSDKErrorConst.ERR_USDK_DEVICE_BLE_IS_NOT_REACHABLE.toError());
                return;
            }
            e3.a.e("updateRouterSSID: DeviceStatus = " + this.mLocalBLEDevice.n(), new Object[0]);
            if (this.mLocalBLEDevice.A() && DeviceStatus.STATUS_CONNECTED != this.mLocalBLEDevice.n() && DeviceStatus.STATUS_READY != this.mLocalBLEDevice.n()) {
                callUpdateRouterFailure(uSDKErrorConst.ERR_USDK_DEVICE_BLE_IS_NOT_REACHABLE.toError());
                return;
            }
        }
        this.mUpdateRouterTimer = com.haier.library.common.util.a0.a(i7, TimeUnit.SECONDS, new Runnable() { // from class: com.haier.uhome.usdk.api.a3
            @Override // java.lang.Runnable
            public final void run() {
                this.f30436a.updateRouterSSIDTimeout();
            }
        });
        if (this.mSDKDeviceBleEventInfo.g() != null || (gVar = this.mLocalBLEDevice) == null) {
            strG = this.mSDKDeviceBleEventInfo.g();
            strD = this.mSDKDeviceBleEventInfo.d();
            strF = this.mSDKDeviceBleEventInfo.f();
        } else {
            strG = gVar.j_();
            strD = this.mLocalBLEDevice.J();
            strF = this.mLocalBLEDevice.G();
        }
        com.haier.uhome.control.local.e.b.l().a(str, str2, str3, this.mSDKDeviceBleEventInfo.c(), strD, i7, strF, strG, getUplusId(), new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.17
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.e("updateRouterSSIDPassword onSuccess", new Object[0]);
                uSDKDevice.this.mEventHandler.deleteObservers();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                uSDKDevice.this.callUpdateRouterFailure(usdkerror);
                uSDKDevice.this.updateSSIDTimeoutTimerCancel();
                uSDKDevice.this.updateRouterSSIDPasswordEnd();
            }
        });
    }

    @Deprecated
    public void writeAttribute(String str, String str2, IuSDKCallback iuSDKCallback) {
        writeAttribute(str, str2, 15, iuSDKCallback);
    }

    private void setDeviceGatewayAndPort(String str, int i7, String str2, final IuSDKCallback iuSDKCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.d4
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$setDeviceGatewayAndPort$19(iuSDKCallback);
                }
            });
            return;
        }
        com.haier.uhome.control.local.api.h hVar = this.mLocalDevice;
        if (hVar == null) {
            if (iuSDKCallback != null) {
                iuSDKCallback.onCallback(uSDKErrorConst.ERR_USDK_DEVICE_NOT_LOCAL);
            }
        } else if (TextUtils.isEmpty(hVar.W())) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.e4
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.lambda$setDeviceGatewayAndPort$20(iuSDKCallback);
                }
            });
        } else {
            this.mLocalDevice.a(str, i7, str2, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.f4
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    uSDKDevice.lambda$setDeviceGatewayAndPort$21(iuSDKCallback, errorConst);
                }
            });
        }
    }

    private void subscribeResourceWithDecode(String str, int i7, ICallback<Void> iCallback) {
        final ICallback iCallback2 = (ICallback) com.haier.uhome.usdk.base.utils.b.a((Object) iCallback, (Class<?>) ICallback.class);
        if (!uSDKManager.getSingleInstance().a()) {
            iCallback2.onFailure(uSDKErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        if (com.haier.library.common.util.c.j(str)) {
            iCallback2.onFailure(uSDKErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (this.deviceListener.a() == null) {
            e3.a.v("subscribeResource but app not setDeviceListener", new Object[0]);
        }
        com.haier.uhome.control.cloud.api.c cVar = this.mCloudDevice;
        if (cVar == null || cVar.n() != DeviceStatus.STATUS_READY) {
            iCallback2.onFailure(ErrorConst.ERR_USDK_DEVICE_REMOTE_STATE_NOT_READY.toError());
        } else {
            this.mCloudDevice.a(new com.haier.uhome.control.cloud.api.h() { // from class: com.haier.uhome.usdk.api.uSDKDevice.13
                @Override // com.haier.uhome.control.cloud.api.h
                public void a(String str2, byte[] bArr) {
                    k overAllListener = uSDKDevice.this.getOverAllListener();
                    if (overAllListener == null) {
                        e3.a.v("onReceiver resource:%s but app not setDeviceListener", str2);
                    } else {
                        overAllListener.onReceive(uSDKDevice.this, str2, bArr);
                    }
                }

                @Override // com.haier.uhome.control.cloud.api.h
                public void a(String str2, String str3) {
                    k overAllListener = uSDKDevice.this.getOverAllListener();
                    if (overAllListener == null) {
                        e3.a.v("onReceiver resource:%s but app not setDeviceListener", str2);
                    } else {
                        overAllListener.onReceiveDecodeResource(uSDKDevice.this, str2, str3);
                    }
                }
            });
            this.mCloudDevice.a(str, i7, new com.haier.uhome.usdk.base.api.n<com.haier.uhome.control.cloud.api.e>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.14
                @Override // com.haier.uhome.usdk.base.api.n
                public void a(com.haier.uhome.control.cloud.api.e eVar) {
                    iCallback2.onSuccess(null);
                    uSDKDevice.this.mP2PHandle = eVar;
                }

                @Override // com.haier.uhome.usdk.base.api.n
                public void a(ErrorConst errorConst) {
                    iCallback2.onFailure(errorConst.toError());
                }
            });
        }
    }

    public void execOperation(String str, List<uSDKArgument> list, ICallback<Void> iCallback) {
        execOperation(str, list, 15, iCallback);
    }

    @Keep
    @Deprecated
    public void getDeviceBindInfo(String str, TraceNode traceNode, IuSDKGetDeviceBindInfoCallback iuSDKGetDeviceBindInfoCallback) {
        getDeviceBindInfo(str, true, traceNode, iuSDKGetDeviceBindInfoCallback);
    }

    public void readAttribute(String str, ICallback<String> iCallback) {
        readAttribute(str, 15, iCallback);
    }

    public void writeAttribute(String str, String str2, ICallback<Void> iCallback) {
        writeAttribute(str, str2, 15, iCallback);
    }

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.uSDKDevice$9, reason: invalid class name */
    class AnonymousClass9 implements ICallback<com.haier.uhome.control.base.api.r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ICallback f30806a;

        AnonymousClass9(ICallback iCallback) {
            this.f30806a = iCallback;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(final com.haier.uhome.control.base.api.r rVar) {
            if (this.f30806a == null) {
                e3.a.o("getNetworkQuality with null callback", new Object[0]);
                return;
            }
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final ICallback iCallback = this.f30806a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.usdk.api.n4
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKDevice.AnonymousClass9.a(iCallback, rVar);
                }
            });
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            uSDKDevice.this.callbackWithError(this.f30806a, usdkerror);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(ICallback iCallback, com.haier.uhome.control.base.api.r rVar) {
            iCallback.onSuccess(new uSDKNetworkQualityInfo(rVar));
        }
    }

    private uSDKDevice(String str, String str2, boolean z7) {
        super(str, str2, z7);
        this.deviceListener = new k();
        this.mSubscribeDeviceListener = new DeviceListener() { // from class: com.haier.uhome.usdk.api.uSDKDevice.1
            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceAlarm(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceAttributeChange(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceBaseInfoChange(uSDKDevice usdkdevice) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceOnlineStatusChange(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onSubDeviceListChange(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList) {
            }
        };
        this.adjustRunnable = new Runnable() { // from class: com.haier.uhome.usdk.api.p2
            @Override // java.lang.Runnable
            public final void run() {
                this.f30692a.lambda$new$12();
            }
        };
        this.mNeedProperty = new AtomicBoolean(false);
        this.mIsShow = new AtomicBoolean(false);
        this.mDeviceInfoMonitor = new b();
        this.mAttrMap = new ConcurrentHashMap<>();
        this.mAlarmList = new CopyOnWriteArrayList();
        this.mDeviceStatus = DeviceStatus.STATUS_UNCONNECT;
        this.mExecutor = new com.haier.uhome.usdk.c.e();
        com.haier.uhome.usdk.api.a.d dVar = new com.haier.uhome.usdk.api.a.d();
        this.mEventHandler = dVar;
        dVar.addObserver(this);
        initControlDeviceListener();
        init();
    }

    private boolean checkDelLocal(com.haier.uhome.control.base.api.a aVar, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        com.haier.uhome.usdk.base.api.f fVarB;
        if (aVar == null) {
            return false;
        }
        boolean zNeedCatchStopSearch = needCatchStopSearch();
        clearStopSearchOfflineReason();
        if (aVar.n() == DeviceStatus.STATUS_OFFLINE || zNeedCatchStopSearch || aVar.n() == DeviceStatus.STATUS_UNCONNECT || !isCare()) {
            String deviceId = getDeviceId();
            if (com.haier.uhome.usdk.base.api.e.a(getChannel())) {
                return true;
            }
            uSDKDevice parentDevice = getParentDevice();
            if (parentDevice != null) {
                deviceId = parentDevice.getDeviceId();
            }
            if (usdkdevicenettypeconst == uSDKDeviceNetTypeConst.NET_LOCAL) {
                fVarB = com.haier.uhome.search.a.n.a().a(deviceId);
            } else {
                fVarB = usdkdevicenettypeconst == uSDKDeviceNetTypeConst.NET_BLE ? com.haier.uhome.search.a.n.a().b(deviceId) : null;
            }
            if (fVarB == null) {
                destroyControlDev(aVar);
                adjust();
                return true;
            }
        }
        return false;
    }

    @Deprecated
    private void getDeviceBindInfo(final String str, final boolean z7, TraceNode traceNode, final IuSDKGetDeviceBindInfoCallback iuSDKGetDeviceBindInfoCallback) {
        e3.a.e("start getDeviceBindInfo.", new Object[0]);
        final TraceNode traceNodeA = z7 ? com.haier.uhome.trace.api.b.a().a(getDeviceId(), getSecurityVersion(), str, 5, traceNode) : null;
        new com.haier.library.common.thread.m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                return uSDKDevice.this.tryGetDeviceBindInfoOnce(str, z7, traceNodeA, System.currentTimeMillis() + 5000);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                if (cVar == null) {
                    e3.a.h("getDeviceBindInfo error!! info is null.", new Object[0]);
                    cVar = new com.haier.uhome.usdk.base.api.c<>();
                    uSDKError error = ErrorConst.ERR_INTERNAL.toError();
                    error.a("getDeviceBindInfo error!! info is null.");
                    cVar.a(error);
                }
                if (z7) {
                    com.haier.uhome.trace.api.b.a().a(cVar.b().getCode(), uSDKDevice.this.getDeviceId(), uSDKDevice.this.getSecurityVersion(), cVar.c(), traceNodeA);
                }
                if (iuSDKGetDeviceBindInfoCallback != null) {
                    iuSDKGetDeviceBindInfoCallback.onDeviceBindInfoGet(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(cVar.b().getCode())), cVar.c());
                } else {
                    e3.a.v("getDeviceBindInfo is null,so give up this callback.", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    @Deprecated
    public void execOperation(String str, List<uSDKArgument> list, int i7, IuSDKCallback iuSDKCallback) {
        execOperation(str, list, i7, Trace.createDITrace(), iuSDKCallback);
    }

    @Deprecated
    public void readAttribute(String str, int i7, IuSDKReadAttributeCallback iuSDKReadAttributeCallback) {
        readAttribute(str, i7, Trace.createDITrace(), iuSDKReadAttributeCallback);
    }

    @Deprecated
    public void writeAttribute(String str, String str2, int i7, IuSDKCallback iuSDKCallback) {
        writeAttribute(str, str2, i7, Trace.createDITrace(), iuSDKCallback);
    }

    private void callbackWithError(final IuSDKResultCallback iuSDKResultCallback, final uSDKErrorConst usdkerrorconst) {
        if (iuSDKResultCallback == null) {
            return;
        }
        if (usdkerrorconst == uSDKErrorConst.RET_USDK_OK) {
            e3.a.v("callbackWithError for OK situation!!,so return with no callback", new Object[0]);
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.c3
                @Override // java.lang.Runnable
                public final void run() {
                    iuSDKResultCallback.onFail(usdkerrorconst);
                }
            });
        }
    }

    public void execOperation(String str, List<uSDKArgument> list, int i7, ICallback<Void> iCallback) {
        execOperation(str, list, i7, Trace.createDITrace(), iCallback);
    }

    public void readAttribute(String str, int i7, ICallback<String> iCallback) {
        readAttribute(str, i7, Trace.createDITrace(), iCallback);
    }

    @Keep
    public void setDeviceListener(DeviceListener deviceListener) {
        e3.a.d("device<%s> setDeviceListener to %s", getDeviceId(), deviceListener == null ? "null" : deviceListener.getClass().getName(), new Object[0]);
        this.deviceListener.a((IuSDKDeviceListener) deviceListener);
    }

    public void writeAttribute(String str, String str2, int i7, ICallback<Void> iCallback) {
        writeAttribute(str, str2, i7, Trace.createDITrace(), iCallback);
    }

    @Deprecated
    public void execOperation(String str, List<uSDKArgument> list, int i7, Trace trace, final IuSDKCallback iuSDKCallback) {
        execOperation(str, list, i7, trace, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.27
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(uSDKErrorConst.RET_USDK_OK);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                }
            }
        });
    }

    @Deprecated
    public void readAttribute(String str, int i7, Trace trace, final IuSDKReadAttributeCallback iuSDKReadAttributeCallback) {
        readAttribute(str, i7, trace, new ICallback<String>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str2) {
                IuSDKReadAttributeCallback iuSDKReadAttributeCallback2 = iuSDKReadAttributeCallback;
                if (iuSDKReadAttributeCallback2 != null) {
                    iuSDKReadAttributeCallback2.onAttributeRead(uSDKErrorConst.RET_USDK_OK, str2);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                IuSDKReadAttributeCallback iuSDKReadAttributeCallback2 = iuSDKReadAttributeCallback;
                if (iuSDKReadAttributeCallback2 != null) {
                    iuSDKReadAttributeCallback2.onAttributeRead(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())), null);
                }
            }
        });
    }

    @Deprecated
    public void writeAttribute(String str, String str2, int i7, Trace trace, final IuSDKCallback iuSDKCallback) {
        writeAttribute(str, str2, i7, trace, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(uSDKErrorConst.RET_USDK_OK);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                }
            }
        });
    }

    public void execOperation(String str, List<uSDKArgument> list, int i7, Trace trace, final ICallback<Void> iCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        final com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (TextUtils.isEmpty(aVar.W())) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_NOT_SUPPORT.toError());
        } else {
            aVar.a(str, com.haier.library.common.util.u.a(list, new com.haier.library.common.util.p() { // from class: com.haier.uhome.usdk.api.i2
                @Override // com.haier.library.common.util.p
                public final Object transform(Object obj) {
                    return uSDKDevice.lambda$execOperation$15((uSDKArgument) obj);
                }
            }), i7, trace, null, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.2
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                    uSDKDevice.this.handleOpCallback(aVar, ErrorConst.RET_USDK_OK.toError());
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                    uSDKDevice.this.handleOpCallback(aVar, usdkerror);
                }
            });
        }
    }

    public void readAttribute(String str, int i7, Trace trace, final ICallback<String> iCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        final com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (TextUtils.isEmpty(aVar.W())) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_NOT_SUPPORT.toError());
        } else {
            aVar.a(str, i7, trace, new ICallback<String>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.4
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(String str2) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<String>) iCallback, str2);
                    uSDKDevice.this.handleOpCallback(aVar, ErrorConst.RET_USDK_OK.toError());
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                    uSDKDevice.this.handleOpCallback(aVar, usdkerror);
                }
            });
        }
    }

    public void writeAttribute(String str, String str2, int i7, Trace trace, final ICallback<Void> iCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_NOT_SUPPORT.toError());
            return;
        }
        final com.haier.uhome.control.base.api.a aVar = this.mTopControlDevice;
        if (TextUtils.isEmpty(aVar.W())) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, uSDKErrorConst.ERR_USDK_NOT_SUPPORT.toError());
        } else {
            aVar.a(str, str2, i7, trace, new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.6
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                    uSDKDevice.this.handleOpCallback(aVar, ErrorConst.RET_USDK_OK.toError());
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                    uSDKDevice.this.handleOpCallback(aVar, usdkerror);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackWithError(final IuSDKCallback iuSDKCallback, final uSDKErrorConst usdkerrorconst) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.e3
            @Override // java.lang.Runnable
            public final void run() {
                uSDKDevice.lambda$callbackWithError$48(iuSDKCallback, usdkerrorconst);
            }
        });
    }

    @Deprecated
    public void getDeviceBindInfo(String str, int i7, IuSDKGetDeviceBindInfoCallback iuSDKGetDeviceBindInfoCallback) {
        getDeviceBindInfo(str, i7, (TraceNode) null, iuSDKGetDeviceBindInfoCallback);
    }

    @Deprecated
    public void getDeviceBindInfo(final String str, final int i7, TraceNode traceNode, final IuSDKGetDeviceBindInfoCallback iuSDKGetDeviceBindInfoCallback) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(getDeviceId(), getSecurityVersion(), str, i7, traceNode);
        new com.haier.library.common.thread.m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.usdk.api.uSDKDevice.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                int i8 = i7;
                if (i8 >= 20 && i8 <= 120) {
                    return uSDKDevice.this.retryGetDeviceBindInfo(str, i8, traceNodeA);
                }
                com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
                uSDKError error = uSDKErrorConst.ERR_USDK_INVALID_PARAM.toError();
                error.a("timeout = " + i7);
                cVar.a(error);
                return cVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                com.haier.uhome.trace.api.b.a().a(cVar.b().getCode(), uSDKDevice.this.getDeviceId(), uSDKDevice.this.getSecurityVersion(), cVar.c(), traceNodeA);
                if (iuSDKGetDeviceBindInfoCallback != null) {
                    iuSDKGetDeviceBindInfoCallback.onDeviceBindInfoGet(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(cVar.b().getCode())), cVar.c());
                } else {
                    e3.a.v("getDeviceBindInfoWithToken is null,so give up this callback.", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    @Deprecated
    public uSDKDevice(String str, String str2, int i7) {
        this.deviceListener = new k();
        this.mSubscribeDeviceListener = new DeviceListener() { // from class: com.haier.uhome.usdk.api.uSDKDevice.1
            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceAlarm(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceAttributeChange(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceBaseInfoChange(uSDKDevice usdkdevice) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onDeviceOnlineStatusChange(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i8) {
            }

            @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
            public void onSubDeviceListChange(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList) {
            }
        };
        this.adjustRunnable = new Runnable() { // from class: com.haier.uhome.usdk.api.p2
            @Override // java.lang.Runnable
            public final void run() {
                this.f30692a.lambda$new$12();
            }
        };
        this.mBindInfoDeviceId = str;
        this.mBindInfoIp = str2;
        this.mBindInfoPort = i7;
    }
}
