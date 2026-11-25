package com.haier.uhome.usdk.api;

import com.haier.uhome.control.cloud.api.FOTAStatusInfo;
import com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListenerWithResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class k extends DeviceListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IuSDKDeviceListener f30603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<DeviceListener> f30604b = new CopyOnWriteArrayList<>();

    public void a(IuSDKDeviceListener iuSDKDeviceListener) {
        this.f30603a = iuSDKDeviceListener;
    }

    public void b(DeviceListener deviceListener) {
        this.f30604b.remove(deviceListener);
    }

    public boolean c(DeviceListener deviceListener) {
        return this.f30604b.contains(deviceListener);
    }

    @Override // com.haier.uhome.usdk.api.DeviceListener
    public void onBLEHistoryData(uSDKDevice usdkdevice, int i7, int i8, byte[] bArr) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener == null || !(iuSDKDeviceListener instanceof DeviceListener)) {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        } else {
            ((DeviceListener) iuSDKDeviceListener).onBLEHistoryData(usdkdevice, i7, i8, bArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onBLEHistoryData(usdkdevice, i7, i8, bArr);
        }
    }

    @Override // com.haier.uhome.usdk.api.DeviceListener
    public void onBLERealTimeData(uSDKDevice usdkdevice, byte[] bArr) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener == null || !(iuSDKDeviceListener instanceof DeviceListener)) {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        } else {
            ((DeviceListener) iuSDKDeviceListener).onBLERealTimeData(usdkdevice, bArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onBLERealTimeData(usdkdevice, bArr);
        }
    }

    @Override // com.haier.uhome.usdk.api.DeviceListener
    public void onBoardFOTAStatusChange(uSDKDevice usdkdevice, FOTAStatusInfo fOTAStatusInfo) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener == null || !(iuSDKDeviceListener instanceof DeviceListener)) {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        } else {
            ((DeviceListener) iuSDKDeviceListener).onBoardFOTAStatusChange(usdkdevice, fOTAStatusInfo);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onBoardFOTAStatusChange(usdkdevice, fOTAStatusInfo);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
    public void onDeviceAlarm(uSDKDevice usdkdevice, List<uSDKDeviceAlarm> list) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener != null) {
            iuSDKDeviceListener.onDeviceAlarm(usdkdevice, list);
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onDeviceAlarm(usdkdevice, list);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
    public void onDeviceAttributeChange(uSDKDevice usdkdevice, List<uSDKDeviceAttribute> list) {
        e3.a.e("SceneDeviceListener onDeviceAttributeChange mDeviceListenerList size = %d", Integer.valueOf(this.f30604b.size()));
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener != null) {
            iuSDKDeviceListener.onDeviceAttributeChange(usdkdevice, list);
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onDeviceAttributeChange(usdkdevice, list);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
    public void onDeviceBaseInfoChange(uSDKDevice usdkdevice) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener != null) {
            iuSDKDeviceListener.onDeviceBaseInfoChange(usdkdevice);
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onDeviceBaseInfoChange(usdkdevice);
        }
    }

    @Override // com.haier.uhome.usdk.api.DeviceListener, com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
    public void onDeviceEvent(uSDKDevice usdkdevice, List<uSDKDeviceEvent> list) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener != null) {
            iuSDKDeviceListener.onDeviceEvent(usdkdevice, list);
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onDeviceEvent(usdkdevice, list);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
    public void onDeviceOnlineStatusChange(uSDKDevice usdkdevice, uSDKDeviceStatusConst usdkdevicestatusconst, int i7) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener != null) {
            iuSDKDeviceListener.onDeviceOnlineStatusChange(usdkdevice, usdkdevicestatusconst, i7);
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onDeviceOnlineStatusChange(usdkdevice, usdkdevicestatusconst, i7);
        }
    }

    @Override // com.haier.uhome.usdk.api.DeviceListener, com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListenerWithResource
    public void onReceive(uSDKDevice usdkdevice, String str, byte[] bArr) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener == null || !(iuSDKDeviceListener instanceof IuSDKDeviceListenerWithResource)) {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        } else {
            ((IuSDKDeviceListenerWithResource) iuSDKDeviceListener).onReceive(usdkdevice, str, bArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onReceive(usdkdevice, str, bArr);
        }
    }

    @Override // com.haier.uhome.usdk.api.DeviceListener, com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListenerWithResource
    public void onReceiveDecodeResource(uSDKDevice usdkdevice, String str, String str2) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener == null || !(iuSDKDeviceListener instanceof IuSDKDeviceListenerWithResource)) {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        } else {
            ((IuSDKDeviceListenerWithResource) iuSDKDeviceListener).onReceiveDecodeResource(usdkdevice, str, str2);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onReceiveDecodeResource(usdkdevice, str, str2);
        }
    }

    @Override // com.haier.uhome.usdk.api.interfaces.IuSDKDeviceListener
    public void onSubDeviceListChange(uSDKDevice usdkdevice, ArrayList<uSDKDevice> arrayList) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener != null) {
            iuSDKDeviceListener.onSubDeviceListChange(usdkdevice, arrayList);
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = usdkdevice == null ? "" : usdkdevice.getDeviceId();
            e3.a.e("device<%s> notify to appSet fail", objArr);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onSubDeviceListChange(usdkdevice, arrayList);
        }
    }

    @Override // com.haier.uhome.usdk.api.DeviceListener
    public void onUpdateFaultInformation(uSDKFaultInformation usdkfaultinformation) {
        IuSDKDeviceListener iuSDKDeviceListener = this.f30603a;
        if (iuSDKDeviceListener == null || !(iuSDKDeviceListener instanceof DeviceListener)) {
            e3.a.e("device<%s> notify to appSet fail", "");
        } else {
            ((DeviceListener) iuSDKDeviceListener).onUpdateFaultInformation(usdkfaultinformation);
        }
        Iterator<DeviceListener> it = this.f30604b.iterator();
        while (it.hasNext()) {
            it.next().onUpdateFaultInformation(usdkfaultinformation);
        }
    }

    public IuSDKDeviceListener a() {
        return this.f30603a;
    }

    public int b() {
        CopyOnWriteArrayList<DeviceListener> copyOnWriteArrayList = this.f30604b;
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList.size();
        }
        return 0;
    }

    public void a(DeviceListener deviceListener) {
        if (c(deviceListener)) {
            e3.a.e("The same object is added only once", new Object[0]);
        } else {
            this.f30604b.add(deviceListener);
        }
    }
}
