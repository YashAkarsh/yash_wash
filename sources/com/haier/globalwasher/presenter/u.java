package com.haier.globalwasher.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import c.a1;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.BlueCommandGroupBeen;
import com.haier.globalwasher.modle.bean.UBluetoothBean;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.g0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.j0;
import com.haier.globalwasher.view.activity.order.OrderIsPaidToRunActivity;
import com.haier.uhome.usdk.api.DeviceListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKDeviceManagerListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKManagerListener;
import com.haier.uhome.usdk.api.uSDKArgument;
import com.haier.uhome.usdk.api.uSDKCloudConnectionState;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceAlarm;
import com.haier.uhome.usdk.api.uSDKDeviceAttribute;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceStatusConst;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.api.uSDKState;
import com.haier.uhome.usdk.api.uSDKUserInfo;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class u implements v3.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.hailicommontlib.mvp.model.utils.loading.a f25343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f25344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f25345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f25346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n2.b f25347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    com.haier.globalwasher.modle.utils.phone_util.a f25348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public uSDKDevice f25349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private k f25350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private i f25351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private l f25352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public m f25353o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    v3.a f25355q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25340b = OrderIsPaidToRunActivity.Q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public uSDKDeviceManager f25341c = uSDKDeviceManager.getSingleInstance();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public uSDKManager f25342d = uSDKManager.getSingleInstance();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f25354p = "runningMode";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private j f25356r = new j();

    class a implements IuSDKManagerListener {
        a() {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKManagerListener
        public void onBusinessMessage(String str) {
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "onBusinessMessage : " + str);
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKManagerListener
        public void onSessionException(String str) {
            u.this.f25347i.k(6, new Object[0]);
            i0.d(u.this.f25344f, u.this.z(R.string.usdk_device_token_has_expired));
        }
    }

    class b implements ICallback<Void> {
        b() {
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r7) {
            u uVar = u.this;
            if (uVar.f25342d == null) {
                uVar.f25342d = uSDKManager.getSingleInstance();
            }
            u.this.f25342d.stopSDK(null);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
        }
    }

    class c implements ICallback<Void> {
        c() {
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r7) {
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, " uSDK Start onSuccessful");
            if (u.this.f25352n == null) {
                u uVar = u.this;
                uVar.f25352n = uVar.new l(uVar.f25347i);
            }
            u uVar2 = u.this;
            uVar2.w(uVar2.f25352n);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            u.this.f25343e.b();
            u.this.f25347i.k(1, new Object[0]);
            i0.d(u.this.f25344f, u.this.z(R.string.usdk_start_failed));
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, " uSDK Start Failed");
        }
    }

    class d implements ICallback<Void> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f25360j;

        d(String str) {
            this.f25360j = str;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r7) {
            u.this.B(this.f25360j);
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            u.this.B(this.f25360j);
        }
    }

    class e implements IuSDKCallback {
        e() {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
        public void onCallback(uSDKErrorConst usdkerrorconst) {
            if (h.f25368d[usdkerrorconst.ordinal()] != 1) {
                i0.d(u.this.f25344f, u.this.z(R.string.usdk_device_commend_response_error) + "：" + usdkerrorconst.getValue());
            } else {
                u.this.f25355q.g(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND, 1);
            }
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "result=" + usdkerrorconst);
        }
    }

    class f implements IuSDKCallback {
        f() {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
        public void onCallback(uSDKErrorConst usdkerrorconst) {
            int i7 = h.f25368d[usdkerrorconst.ordinal()];
            i0.d(u.this.f25344f, usdkerrorconst.getValue());
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "result=" + usdkerrorconst);
        }
    }

    class g implements IuSDKCallback {
        g() {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
        public void onCallback(uSDKErrorConst usdkerrorconst) {
            if (usdkerrorconst == uSDKErrorConst.RET_USDK_OK) {
                return;
            }
            Toast.makeText(u.this.f25344f, usdkerrorconst.getValue(), 1).show();
        }
    }

    static /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f25366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f25367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ int[] f25368d;

        static {
            int[] iArr = new int[uSDKErrorConst.values().length];
            f25368d = iArr;
            try {
                iArr[uSDKErrorConst.RET_USDK_OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25368d[uSDKErrorConst.ERR_USDK_UNSTARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25368d[uSDKErrorConst.ERR_USDK_BLE_NOT_OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25368d[uSDKErrorConst.ERR_USDK_NOT_SUPPORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[uSDKState.values().length];
            f25367c = iArr2;
            try {
                iArr2[uSDKState.STATE_UNSTART.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[uSDKDeviceStatusConst.values().length];
            f25366b = iArr3;
            try {
                iArr3[uSDKDeviceStatusConst.STATUS_OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25366b[uSDKDeviceStatusConst.STATUS_UNCONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25366b[uSDKDeviceStatusConst.STATUS_READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25366b[uSDKDeviceStatusConst.STATUS_CONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25366b[uSDKDeviceStatusConst.STATUS_CONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr4 = new int[uSDKCloudConnectionState.values().length];
            f25365a = iArr4;
            try {
                iArr4[uSDKCloudConnectionState.CLOUD_CONNECTION_STATE_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f25365a[uSDKCloudConnectionState.CLOUD_CONNECTION_STATE_CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f25365a[uSDKCloudConnectionState.CLOUD_CONNECTION_STATE_UNCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f25365a[uSDKCloudConnectionState.CLOUD_CONNECTION_STATE_CONNECT_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public class i implements IuSDKDeviceManagerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private n2.b f25369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f25370b;

        public i(n2.b bVar, String str) {
            this.f25369a = bVar;
            this.f25370b = str;
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceManagerListener
        public void onCloudConnectionStateChange(uSDKCloudConnectionState usdkcloudconnectionstate) {
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "onCloudConnectionStateChange-- " + usdkcloudconnectionstate.getDescription());
            int i7 = h.f25365a[usdkcloudconnectionstate.ordinal()];
            if (i7 == 1) {
                u.this.f25343e.b();
                uSDKDevice usdkdeviceC = u.this.c();
                if (usdkdeviceC != null) {
                    usdkdeviceC.setDeviceListener((DeviceListener) u.this.f25350l);
                    u.this.a(this.f25370b);
                    return;
                } else {
                    this.f25369a.k(4, new Object[0]);
                    u.this.f25343e.c(u.this.z(R.string.usdk_no_this_device));
                    u.this.f25343e.b();
                    i0.d(u.this.f25344f, u.this.z(R.string.usdk_no_this_device));
                    return;
                }
            }
            if (i7 == 2) {
                u.this.f25343e.c(u.this.z(R.string.usdk_starting));
                u.this.f25343e.d();
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "服务器正在连接");
            } else {
                if (i7 != 3) {
                    if (i7 != 4) {
                        return;
                    }
                    u.this.f25343e.c(u.this.z(R.string.usdk_cloud_connection_failed));
                    u.this.f25343e.b();
                    com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "服务器连接失败");
                    return;
                }
                u.this.f25343e.c(u.this.z(R.string.usdk_starting));
                u.this.f25343e.b();
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "服务器连接断开");
                i0.d(u.this.f25344f, u.this.z(R.string.usdk_cloud_connection_failed));
                this.f25369a.k(2, usdkcloudconnectionstate);
            }
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceManagerListener
        public void onDeviceBind(String str) {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceManagerListener
        public void onDeviceUnBind(String str) {
            j0.f().h(u.this.c());
            this.f25369a.k(5, new Object[0]);
            i0.d(u.this.f25344f, u.this.z(R.string.usdk_device_unbind));
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceManagerListener
        public void onDevicesAdd(List<uSDKDevice> list) {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceManagerListener
        public void onDevicesRemove(List<uSDKDevice> list) {
            this.f25369a.k(4, new Object[0]);
            u.this.f25343e.b();
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class j extends Handler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f25372b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f25373c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f25374d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f25375e = 3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f25376f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f25377g = 5;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f25378h = 6;

        class a implements ICallback<Void> {
            a() {
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "主动查询 DEVICE_IS_RUNNING");
                uSDKDevice usdkdeviceC = u.this.c();
                if (usdkdeviceC == null) {
                    u.this.f25355q.g(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND, 1);
                    return;
                }
                String value = usdkdeviceC.getAttributeMap().get("runningMode").getValue();
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "主动查询 运行命令执行结果runningMode=" + value);
                if ("1".equals(value)) {
                    u.this.f25355q.g(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND, 1);
                } else {
                    u.this.f25355q.g(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND, 2);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
            }
        }

        class b implements ICallback<Void> {
            b() {
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "主动查询 DEVICE_IS_STOP");
                uSDKDevice usdkdeviceC = u.this.c();
                if (usdkdeviceC == null) {
                    u.this.f25355q.g(com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND, 2);
                    return;
                }
                String value = usdkdeviceC.getAttributeMap().get("runningMode").getValue();
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "主动查询 运行命令执行结果runningMode=" + value);
                if ("2".equals(value)) {
                    u uVar = u.this;
                    uVar.x(uVar.f25346h);
                    u.this.f25355q.g(com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND, 2);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "" + u.this.f25343e.a());
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "msg.what=" + message.what);
            switch (message.what) {
                case 0:
                    u.this.C();
                case 1:
                    try {
                        String string = message.getData().getString(o.f25218y);
                        String string2 = message.getData().getString("command");
                        u uVar = u.this;
                        uVar.e(string, string2, uVar.f25355q);
                        break;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        break;
                    }
                case 2:
                    if (u.this.f25343e != null) {
                        u.this.f25343e.b();
                    }
                    u uVar2 = u.this;
                    com.jiao.project.bluetoothofabroadwasherapp.enums.d dVarH = uVar2.h(uVar2.f25346h);
                    if (dVarH != null && dVarH == com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_OFFLINE) {
                        i0.d(u.this.f25344f, u.this.z(R.string.usdk_offline));
                        break;
                    }
                    break;
                case 3:
                    u uVar3 = u.this;
                    com.jiao.project.bluetoothofabroadwasherapp.enums.d dVarH2 = uVar3.h(uVar3.f25346h);
                    if (dVarH2 != null && dVarH2 == com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_READY) {
                        if (u.this.f25343e != null) {
                            u.this.f25343e.b();
                        }
                        u.this.f25347i.d();
                        break;
                    }
                    break;
                case 4:
                    uSDKDevice usdkdeviceC = u.this.c();
                    if (usdkdeviceC == null) {
                        com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "handler  设备未找到");
                    } else {
                        usdkdeviceC.connectNeedProperties(u.this.f25353o);
                    }
                    break;
                case 5:
                    u.this.f25341c.refreshDeviceList(new a());
                    break;
                case 6:
                    u.this.f25341c.refreshDeviceList(new b());
                    break;
            }
        }

        private j() {
        }
    }

    private class k extends DeviceListener {
        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceAlarm(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list) {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceAttributeChange(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list) {
            if (list != null) {
                for (int i7 = 0; i7 < list.size(); i7++) {
                    if ("runningMode".equals(list.get(i7).getName())) {
                        boolean zEquals = "1".equals(list.get(i7).getValue());
                        if (u.this.f25347i != null && (u.this.f25347i instanceof com.haier.globalwasher.modle.utils.bluetoothutil.a.g)) {
                            ((com.haier.globalwasher.modle.utils.bluetoothutil.a.g) u.this.f25347i).t(zEquals);
                        }
                        if ("1".equals(list.get(i7).getValue())) {
                            if (u.this.f25347i != null) {
                                u.this.f25347i.g(u.this.f25347i.c(), 1);
                            }
                        } else if (u.this.f25347i != null) {
                            u.this.f25347i.g(u.this.f25347i.c(), 2);
                        }
                    }
                }
            }
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceBaseInfoChange(uSDKDevice usdkdevice) {
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onDeviceOnlineStatusChange(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7) {
            g0 g0VarA;
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, usdkdevicestatusconst.getValue());
            int i8 = h.f25366b[usdkdevicestatusconst.ordinal()];
            if (i8 == 1) {
                u.this.f25347i.a(usdkdevice);
                u.this.f25356r.sendEmptyMessageDelayed(2, com.haier.uhome.ble.hal.a.b.a.f28246a);
                u.this.f25343e.b();
                return;
            }
            if (i8 == 2) {
                u.this.f25343e.b();
                return;
            }
            if (i8 != 3) {
                if (i8 != 4) {
                    if (i8 != 5) {
                        return;
                    }
                    u.this.f25343e.d();
                    return;
                } else {
                    usdkdevice.inFocus();
                    u.this.f25343e.c(u.this.z(R.string.usdk_connecting));
                    u.this.f25343e.d();
                    return;
                }
            }
            int iIndexOf = j0.f().e().indexOf(usdkdevice);
            if (iIndexOf > -1 && (g0VarA = j0.f().e().get(iIndexOf).a()) != null) {
                g0VarA.e();
            }
            j0.f().h(usdkdevice);
            u uVar = u.this;
            uVar.f25349k = usdkdevice;
            uVar.f25347i.d();
            u.this.f25343e.b();
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
        public void onSubDeviceListChange(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList) {
        }

        private k() {
        }
    }

    private class l implements ICallback<Void> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        n2.b f25383j;

        public l(n2.b bVar) {
            this.f25383j = bVar;
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r7) {
            u.this.f25343e.c(u.this.z(R.string.usdk_starting));
            u.this.f25343e.d();
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "uSDK 开始连接网关!");
        }

        @Override // com.haier.uhome.usdk.base.api.ICallback
        public void onFailure(uSDKError usdkerror) {
            try {
                this.f25383j.k(3, new Object[0]);
                u.this.f25343e.c(u.this.z(R.string.usdk_cloud_connection_failed) + " : " + usdkerror.getDescription());
                u.this.f25343e.b();
                i0.d(u.this.f25344f, u.this.z(R.string.usdk_cloud_connection_failed) + " : " + usdkerror.getDescription());
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, u.this.z(R.string.usdk_cloud_connection_failed) + " : " + usdkerror.getDescription() + "\n" + usdkerror.getDescription());
            } catch (Exception e8) {
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "UsdkUtil.MyICallback " + e8.getMessage());
            }
        }
    }

    private class m implements IuSDKCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f25385a;

        class a implements j0.a {
            a() {
            }

            @Override // com.haier.globalwasher.modle.utils.j0.a
            public void a(int i7) {
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "连接设备 uSDKErrorConst time=" + i7);
                if (u.this.c() == null) {
                    com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "getDevice=null");
                    return;
                }
                if (u.this.c().getStatus() == uSDKDeviceStatusConst.STATUS_READY) {
                    if (u.this.f25343e != null) {
                        u.this.f25343e.b();
                    }
                    j0.f().h(u.this.c());
                    return;
                }
                if (u.this.c().getStatus() == uSDKDeviceStatusConst.STATUS_CONNECTING || u.this.c().getStatus() == uSDKDeviceStatusConst.STATUS_CONNECTED) {
                    if (u.this.f25343e != null) {
                        u.this.f25343e.d();
                        return;
                    }
                    return;
                }
                if (i7 == 0) {
                    com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "连接设备getDevice().getStatus()=" + u.this.c().getStatus().getValue());
                    int i8 = h.f25366b[u.this.c().getStatus().ordinal()];
                    if (i8 == 1 || i8 == 2) {
                        if (u.this.f25343e != null) {
                            u.this.f25343e.b();
                            i0.d(u.this.f25344f, u.this.z(R.string.usdk_device_commend_timeout));
                        }
                        u.this.D();
                        u.this.f25347i.k(9, new Object[0]);
                    }
                }
            }
        }

        public m(String str) {
            this.f25385a = str;
        }

        @Override // com.haier.uhome.usdk.api.interfaces.IuSDKCallback
        public void onCallback(uSDKErrorConst usdkerrorconst) {
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "开始连接设备  " + usdkerrorconst.getErrorId());
            u.this.f25347i.m(usdkerrorconst);
            int i7 = h.f25368d[usdkerrorconst.ordinal()];
            if (i7 == 1) {
                j0.f().c(u.this.c(), new a());
                u.this.f25343e.c(u.this.z(R.string.usdk_connecting));
                u.this.f25343e.d();
            } else if (i7 == 2) {
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "SDK未启动  ");
                u.this.C();
            } else if (i7 != 3) {
                if (i7 != 4) {
                    i0.d(u.this.f25344f, usdkerrorconst.getValue());
                    return;
                }
                i0.d(u.this.f25344f, "14020");
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "连接设备   14020");
                u.this.f25356r.sendEmptyMessageDelayed(3, 1000L);
            }
        }
    }

    public u(BaseActivity baseActivity) {
        this.f25344f = (Activity) new SoftReference(baseActivity).get();
        b();
        if (this.f25348j == null) {
            this.f25348j = new com.haier.globalwasher.modle.utils.phone_util.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str) {
        uSDKDevice usdkdeviceC = c();
        int iC = (usdkdeviceC == null || usdkdeviceC.getStatus() != uSDKDeviceStatusConst.STATUS_READY) ? C() : 0;
        com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "sendCommandGroup 设备 连接状态=" + iC);
        if (iC != 0) {
            if (iC != 4) {
                return;
            }
            this.f25356r.sendEmptyMessageDelayed(3, 3000L);
            return;
        }
        try {
            BlueCommandGroupBeen command = BlueCommandGroupBeen.getCommand(str);
            if (command == null) {
                this.f25347i.k(10, new Object[0]);
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "blueCommandGroupBeen ==null");
                i0.d(this.f25344f, z(R.string.usdk_device_commend_response_error));
                return;
            }
            if (usdkdeviceC == null) {
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "sendCommend   uDevice=Null");
                i0.d(this.f25344f, z(R.string.usdk_no_this_device));
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i7 = 5;
            for (int i8 = 0; command.getOperationValue() != null && i8 < command.getOperationValue().size(); i8++) {
                arrayList.add(new uSDKArgument(command.getOperationValue().get(i8).getName(), command.getOperationValue().get(i8).getValue()));
                if ("waitingTime".equals(command.getOperationValue().get(i8).getName())) {
                    try {
                        i7 = Integer.parseInt(command.getOperationValue().get(i8).getValue());
                    } catch (Exception unused) {
                        i7 = 5;
                    }
                }
            }
            HashMap<String, uSDKDeviceAttribute> attributeMap = usdkdeviceC.getAttributeMap();
            if (attributeMap == null) {
                com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "sendCommend attributeMap=Null");
                Bundle bundle = new Bundle();
                bundle.putString(o.f25218y, this.f25346h);
                bundle.putString("command", str);
                Message message = new Message();
                message.what = 1;
                message.setData(bundle);
                this.f25356r.sendMessageDelayed(message, 3000L);
                return;
            }
            String value = attributeMap.get("runningMode").getValue();
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "sendCommandGroup runningMode=" + value);
            if (!"1".equals(value)) {
                usdkdeviceC.execOperation(command.getOperationName(), arrayList, i7, new e());
                return;
            }
            this.f25355q.g(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND, 1);
            this.f25343e.b();
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "----设备已经启动");
        } catch (Exception e8) {
            i0.d(this.f25344f, z(R.string.usdk_device_commend_response_error));
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "Exception e=" + e8.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int C() {
        com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = this.f25343e;
        if (aVar != null) {
            aVar.c(z(R.string.usdk_starting));
            this.f25343e.d();
        }
        com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "deviceId=" + this.f25346h);
        if (!d0.j(this.f25346h)) {
            return -1;
        }
        com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "2deviceId=" + this.f25346h);
        if (h.f25367c[this.f25342d.getSDKState().ordinal()] == 1) {
            this.f25342d.startSDK(MyApplication.f24260p, new c());
            return 1;
        }
        int i7 = h.f25365a[this.f25341c.getCloudConnectionState().ordinal()];
        if (i7 != 1) {
            if (i7 != 2) {
                if (i7 == 3 || i7 == 4) {
                    if (!com.haier.globalwasher.modle.utils.i.a()) {
                        if (this.f25352n == null) {
                            this.f25352n = new l(this.f25347i);
                        }
                        w(this.f25352n);
                    }
                }
            }
            return 2;
        }
        uSDKDevice usdkdeviceC = c();
        if (usdkdeviceC == null) {
            this.f25343e.c(z(R.string.usdk_no_this_device));
            this.f25343e.b();
            i0.d(this.f25344f, z(R.string.usdk_no_this_device));
            return 3;
        }
        uSDKDeviceStatusConst status = usdkdeviceC.getStatus();
        com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "uDevice.uDeviceStatusConst" + status.getValue());
        int i8 = h.f25366b[status.ordinal()];
        if (i8 == 1 || i8 == 2) {
            if (!com.haier.globalwasher.modle.utils.i.a()) {
                this.f25356r.sendEmptyMessageDelayed(4, 500L);
            }
            return 3;
        }
        if (i8 == 3) {
            this.f25343e.b();
            this.f25347i.d();
            return 0;
        }
        if (i8 == 4 || i8 == 5) {
            i0.d(this.f25344f, z(R.string.usdk_connecting));
            return 4;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        j(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(ICallback<Void> iCallback) {
        this.f25341c.connectToCloud(new uSDKUserInfo.Builder().setUserToken(this.f25345g).build(), iCallback);
    }

    public void A(String str, String str2) {
        uSDKDevice usdkdeviceC = c();
        if (usdkdeviceC != null) {
            usdkdeviceC.writeAttribute(str, str2, new g());
        } else {
            i0.d(this.f25344f, z(R.string.usdk_no_this_device));
        }
    }

    @Override // v3.c
    public boolean a(String str) {
        this.f25346h = str;
        com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = this.f25343e;
        if (aVar == null) {
            return false;
        }
        aVar.c(z(R.string.usdk_connecting));
        this.f25343e.d();
        com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "connentDevice()开始连接设备devicemac=" + str);
        if (this.f25341c == null) {
            this.f25341c = uSDKDeviceManager.getSingleInstance();
        }
        if (this.f25341c != null || d0.j(str)) {
            uSDKDevice usdkdeviceC = c();
            if (usdkdeviceC == null) {
                this.f25343e.c(z(R.string.usdk_no_this_device));
                this.f25343e.b();
                i0.d(this.f25344f, z(R.string.usdk_no_this_device));
                return false;
            }
            int i7 = h.f25366b[usdkdeviceC.getStatus().ordinal()];
            if (i7 == 1 || i7 == 2) {
                if (!com.haier.globalwasher.modle.utils.i.a()) {
                    this.f25356r.sendEmptyMessageDelayed(4, 500L);
                }
                return false;
            }
            if (i7 == 3) {
                this.f25343e.b();
                this.f25347i.d();
                return true;
            }
            if (i7 == 4) {
                i0.d(this.f25344f, z(R.string.usdk_connecting));
                return true;
            }
        }
        i0.d(this.f25344f, z(R.string.usdk_no_device_id));
        this.f25343e.b();
        return false;
    }

    @Override // v3.c
    public com.haier.hailicommontlib.mvp.model.utils.loading.a b() {
        com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = this.f25343e;
        if (aVar == null || this.f25344f.equals(aVar.a())) {
            com.haier.hailicommontlib.mvp.model.utils.loading.a aVar2 = this.f25343e;
            if (aVar2 != null) {
                aVar2.b();
            }
            com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "" + this.f25344f);
            this.f25343e = new com.haier.hailicommontlib.mvp.model.utils.loading.a(this.f25344f, 1, false);
        }
        return this.f25343e;
    }

    @Override // v3.c
    public void d() {
    }

    @Override // v3.c
    public void e(String str, String str2, v3.a aVar) {
        this.f25346h = str;
        com.haier.globalwasher.modle.utils.q.c(OrderIsPaidToRunActivity.Q, "sendCommandGroup ");
        this.f25355q = aVar;
        this.f25341c.refreshDeviceList(new d(str2));
    }

    @Override // v3.c
    public void f(Activity activity, v3.b bVar, t3.b bVar2) {
        this.f25344f = activity;
        if (this.f25341c == null) {
            this.f25341c = uSDKDeviceManager.getSingleInstance();
        }
        if (this.f25342d == null) {
            this.f25342d = uSDKManager.getSingleInstance();
        }
        UBluetoothBean uBluetoothBean = (UBluetoothBean) bVar;
        this.f25345g = uBluetoothBean.getAccessToken();
        this.f25346h = uBluetoothBean.getBluetoothMac();
        this.f25347i = (n2.b) bVar2;
        b();
        this.f25343e.d();
        if (this.f25348j == null) {
            this.f25348j = new com.haier.globalwasher.modle.utils.phone_util.a();
        }
        if (this.f25350l == null) {
            this.f25350l = new k();
        }
        if (this.f25351m == null) {
            this.f25351m = new i(this.f25347i, this.f25346h);
        }
        if (this.f25353o == null) {
            this.f25353o = new m(this.f25346h);
        }
        this.f25341c.setDeviceManagerListener(this.f25351m);
        this.f25342d.setManagerListener(new a());
        C();
    }

    @Override // v3.c
    public void g(String str, v3.a aVar) {
        this.f25355q = aVar;
        this.f25346h = str;
        uSDKDevice usdkdeviceC = c();
        int iC = (usdkdeviceC == null || usdkdeviceC.getStatus() != uSDKDeviceStatusConst.STATUS_READY) ? C() : 0;
        if (iC == 0) {
            A("returnStandby", "1");
        } else {
            if (iC != 4) {
                return;
            }
            this.f25356r.sendEmptyMessageDelayed(6, com.haier.uhome.ble.hal.a.b.a.f28246a);
        }
    }

    @Override // v3.c
    public com.jiao.project.bluetoothofabroadwasherapp.enums.d h(String str) {
        uSDKDevice usdkdeviceC;
        if (this.f25341c == null) {
            this.f25341c = uSDKDeviceManager.getSingleInstance();
        }
        if ((this.f25341c == null && !d0.j(str)) || (usdkdeviceC = c()) == null) {
            return null;
        }
        int i7 = h.f25366b[usdkdeviceC.getStatus().ordinal()];
        if (i7 == 1) {
            return com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_OFFLINE;
        }
        if (i7 == 2) {
            return com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_UNCONNECT;
        }
        if (i7 == 3) {
            return com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_READY;
        }
        if (i7 == 4) {
            return com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_CONNECTING;
        }
        if (i7 != 5) {
            return null;
        }
        return com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_CONNECTED;
    }

    @Override // v3.c
    public void i() {
        com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = this.f25343e;
        if (aVar != null) {
            aVar.b();
            this.f25343e = null;
            this.f25344f = null;
        }
    }

    @Override // v3.c
    public <T> void j(T t7) {
        uSDKDeviceManager usdkdevicemanager = this.f25341c;
        if (usdkdevicemanager != null) {
            usdkdevicemanager.disconnectToCloud(new b());
        }
    }

    public boolean x(String str) {
        this.f25346h = str;
        uSDKDevice usdkdeviceC = c();
        if (usdkdeviceC != null && d0.j(str) && str.equals(usdkdeviceC.getDeviceId())) {
            usdkdeviceC.disconnect(null);
        }
        return true;
    }

    @Override // v3.c
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public uSDKDevice c() {
        uSDKDeviceManager usdkdevicemanager = this.f25341c;
        if (usdkdevicemanager != null) {
            uSDKDevice device = usdkdevicemanager.getDevice(this.f25346h);
            uSDKDevice usdkdevice = this.f25349k;
            if (usdkdevice != null && d0.j(usdkdevice.getDeviceId()) && !this.f25349k.getDeviceId().equals(this.f25346h)) {
                this.f25349k.disconnect(null);
            }
            if (device != null) {
                this.f25349k = device;
            }
        }
        return this.f25349k;
    }

    public String z(@a1 int i7) {
        Activity activity = this.f25344f;
        if (activity != null && activity.getResources() != null) {
            return this.f25344f.getResources().getString(i7);
        }
        com.haier.hailicommontlib.mvp.model.utils.loading.a aVar = this.f25343e;
        if (aVar == null) {
            return "";
        }
        aVar.b();
        return "";
    }
}
