package com.haier.uhome.usdk.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.haier.uhome.usdk.api.interfaces.c {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(uSDKDevice usdkdevice, List list) {
        k overAllListener = usdkdevice.getOverAllListener();
        if (overAllListener == null) {
            e3.a.v("device <%s-%s> listener not register, so give up this device attr change msg", usdkdevice.getDeviceId(), Integer.valueOf(usdkdevice.getSubDeviceId()));
        } else {
            e3.a.e("notify device<%s> attr msg<%s> to listener:%s", usdkdevice.getDeviceId(), list, overAllListener.getClass().toString());
            overAllListener.onDeviceAttributeChange(usdkdevice, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(uSDKDevice usdkdevice, List list) {
        k overAllListener = usdkdevice.getOverAllListener();
        if (overAllListener == null) {
            e3.a.v("device <%s-%s> listener not register, so give up this alarm msg", usdkdevice.getDeviceId(), Integer.valueOf(usdkdevice.getSubDeviceId()));
        } else {
            e3.a.d("notify device<%s> alarm msg to listener:%s", usdkdevice.getDeviceId(), overAllListener.getClass().toString(), new Object[0]);
            overAllListener.onDeviceAlarm(usdkdevice, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(uSDKDevice usdkdevice, List list) {
        k overAllListener = usdkdevice.getOverAllListener();
        if (overAllListener == null) {
            e3.a.v("device <%s-%s> listener not register, so give up this event msg", usdkdevice.getDeviceId(), Integer.valueOf(usdkdevice.getSubDeviceId()));
        } else {
            e3.a.d("notify device<%s> event msg to listener:%s", usdkdevice.getDeviceId(), overAllListener.getClass().toString(), new Object[0]);
            overAllListener.onDeviceEvent(usdkdevice, list);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a(final uSDKDevice usdkdevice, final List<uSDKDeviceEvent> list) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.y0
            @Override // java.lang.Runnable
            public final void run() {
                d.f(usdkdevice, list);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void b(final uSDKDevice usdkdevice, final List<uSDKDeviceAlarm> list) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.q0
            @Override // java.lang.Runnable
            public final void run() {
                d.e(usdkdevice, list);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void c(final uSDKDevice usdkdevice, final List<uSDKDeviceAttribute> list) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.s0
            @Override // java.lang.Runnable
            public final void run() {
                d.d(usdkdevice, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7) {
        k overAllListener = usdkdevice.getOverAllListener();
        if (overAllListener == null) {
            e3.a.v("device <%s> listener not register, so give up this device online status change msg", usdkdevice.toString());
        } else {
            e3.a.e("notify device<%s> online status change<%s-%s> msg to listener:%s", usdkdevice.getDeviceId(), usdkdevicestatusconst, usdkdevice.getNetType(), overAllListener.getClass().toString());
            overAllListener.onDeviceOnlineStatusChange(usdkdevice, usdkdevicestatusconst, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(String str) {
        if (uSDKManager.getSingleInstance().getManagerListener() == null) {
            e3.a.e("SDKManagerListener not register,so give up this business message", new Object[0]);
            return;
        }
        e3.a.e("notify business message,message is:" + str, new Object[0]);
        uSDKManager.getSingleInstance().getManagerListener().onBusinessMessage(str);
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a(final uSDKDevice usdkdevice, final uSDKDeviceStatusConst usdkdevicestatusconst, final int i7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.u0
            @Override // java.lang.Runnable
            public final void run() {
                d.b(usdkdevice, usdkdevicestatusconst, i7);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a(final List<uSDKDevice> list) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.v0
            @Override // java.lang.Runnable
            public final void run() {
                d.f(list);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a(String str, final String str2) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.n0
            @Override // java.lang.Runnable
            public final void run() {
                d.f(str2);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a(final String str) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.z0
            @Override // java.lang.Runnable
            public final void run() {
                d.d(str);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a(final uSDKCloudConnectionState usdkcloudconnectionstate) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.t0
            @Override // java.lang.Runnable
            public final void run() {
                d.b(usdkcloudconnectionstate);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void c(final List<uSDKDevice> list) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.p0
            @Override // java.lang.Runnable
            public final void run() {
                d.d(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(String str) {
        if (uSDKManager.getSingleInstance().getManagerListener() == null) {
            e3.a.e("SDKManagerListener not register,so give up this session exception message", new Object[0]);
            return;
        }
        e3.a.e("notify session exception message,token is:" + str, new Object[0]);
        uSDKManager.getSingleInstance().getManagerListener().onSessionException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(List list) {
        if (uSDKDeviceManager.getSingleInstance().getDeviceManagerListener() == null) {
            e3.a.e("DeviceManagerListener not register,so give up this devices remove message", new Object[0]);
        } else {
            e3.a.e("notify devices remove message %s", list);
            uSDKDeviceManager.getSingleInstance().getDeviceManagerListener().onDevicesRemove(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(List list) {
        if (uSDKDeviceManager.getSingleInstance().getDeviceManagerListener() == null) {
            e3.a.e("DeviceManagerListener not register,so give up this devices add message", new Object[0]);
        } else {
            e3.a.e("notify devices add message %s", list);
            uSDKDeviceManager.getSingleInstance().getDeviceManagerListener().onDevicesAdd(list);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a(final uSDKDevice usdkdevice, final ArrayList<uSDKDevice> arrayList) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.o0
            @Override // java.lang.Runnable
            public final void run() {
                d.b(usdkdevice, arrayList);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void b(final List<uSDKDevice> list) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.r0
            @Override // java.lang.Runnable
            public final void run() {
                d.e(list);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void a() {
        com.haier.library.common.thread.a.b().a();
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void b(String str, final String str2) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.w0
            @Override // java.lang.Runnable
            public final void run() {
                d.e(str2);
            }
        });
    }

    @Override // com.haier.uhome.usdk.api.interfaces.c
    public void b(final String str) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.x0
            @Override // java.lang.Runnable
            public final void run() {
                d.c(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(uSDKCloudConnectionState usdkcloudconnectionstate) {
        if (uSDKDeviceManager.getSingleInstance().getDeviceManagerListener() == null) {
            e3.a.e("DeviceManagerListener not register,so give up  cloud state message", new Object[0]);
            return;
        }
        e3.a.e("notify cloud state,state is:" + usdkcloudconnectionstate, new Object[0]);
        uSDKDeviceManager.getSingleInstance().getDeviceManagerListener().onCloudConnectionStateChange(usdkcloudconnectionstate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            uSDKDevice usdkdevice = (uSDKDevice) it.next();
            if (usdkdevice.getOverAllListener() != null) {
                e3.a.e("notify base info changes ,device is:" + usdkdevice.toString(), new Object[0]);
                usdkdevice.getOverAllListener().onDeviceBaseInfoChange(usdkdevice);
            } else {
                e3.a.v("device <%s> listener not register, so give up this device base info msg", usdkdevice.getDeviceId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str) {
        if (uSDKDeviceManager.getSingleInstance().getDeviceManagerListener() == null) {
            e3.a.e("DeviceManagerListener not register,so give up this devices unbinded message", new Object[0]);
            return;
        }
        e3.a.e("notify device unbinded message,devId is : " + str, new Object[0]);
        uSDKDeviceManager.getSingleInstance().getDeviceManagerListener().onDeviceUnBind(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(String str) {
        if (uSDKDeviceManager.getSingleInstance().getDeviceManagerListener() == null) {
            e3.a.e("DeviceManagerListener not register,so give up this devices binded message", new Object[0]);
            return;
        }
        e3.a.e("notify device binded message,devId is : " + str, new Object[0]);
        uSDKDeviceManager.getSingleInstance().getDeviceManagerListener().onDeviceBind(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(uSDKDevice usdkdevice, ArrayList arrayList) {
        if (usdkdevice.getOverAllListener() != null) {
            e3.a.e("notify device sub dev list change,device is:" + usdkdevice.toString(), new Object[0]);
            usdkdevice.getOverAllListener().onSubDeviceListChange(usdkdevice, arrayList);
            return;
        }
        e3.a.v("device <%s> listener not register, so give up this device sub dev list change.", usdkdevice.getDeviceId());
    }
}
