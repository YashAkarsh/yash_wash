package com.haier.uhome.usdk.scanner;

import com.haier.library.common.util.p;
import com.haier.library.common.util.u;
import com.haier.uhome.search.a.f;
import com.haier.uhome.search.a.i;
import com.haier.uhome.search.a.l;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceScanner implements f, i {

    @Deprecated
    public static final int BLE_SCAN = 0;

    @Deprecated
    public static final int DEFAULT = 0;

    @Deprecated
    public static final int HI_ROUTER_SCAN = 0;

    @Deprecated
    public static final int WIFI_SCAN = 0;
    private AtomicBoolean bleCtl;
    private AtomicBoolean bleInvalidCtl;
    private List<IDeviceScannerListener> deviceScannerListenerList;
    private volatile IDeviceScannerListener listener;
    private ScannerListener permissionListener;
    private final l scannerManager;
    private AtomicBoolean wifiCtl;
    private AtomicBoolean wifiInvalidCtl;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DeviceScanner f32077a = new DeviceScanner();

        private a() {
        }
    }

    public static DeviceScanner getSingleInstance() {
        return a.f32077a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startScanConfigurableDevice$0(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopScanConfigurableDevice$1(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    public void addDeviceScannerListener(IDeviceScannerListener iDeviceScannerListener) {
        this.deviceScannerListenerList.add(iDeviceScannerListener);
    }

    @Override // com.haier.uhome.search.a.i
    public void blePermissionInvalid() {
        ScannerListener scannerListener;
        if (!this.bleInvalidCtl.compareAndSet(false, true) || (scannerListener = this.permissionListener) == null) {
            return;
        }
        scannerListener.onPermissionInvalid(Permission.BLE_INVALID);
    }

    @Override // com.haier.uhome.search.a.i
    public void bluetoothDisable() {
        ScannerListener scannerListener;
        if (!this.bleCtl.compareAndSet(false, true) || (scannerListener = this.permissionListener) == null) {
            return;
        }
        scannerListener.onPermissionInvalid(Permission.BLE_DISABLE);
    }

    public void enableSoftapScan(boolean z7) {
        l.a().a(z7);
    }

    public ArrayList<ConfigurableDevice> getConfigurableDevices() {
        return u.a(l.a().c(), new p() { // from class: com.haier.uhome.usdk.scanner.b
            @Override // com.haier.library.common.util.p
            public final Object transform(Object obj) {
                return new ConfigurableDevice((com.haier.uhome.search.a.c) obj);
            }
        });
    }

    @Override // com.haier.uhome.search.a.f
    public final void onDeviceAdd(com.haier.uhome.search.a.c cVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceAdd %s", cVar);
        if ((cVar.i() & ConfigType.BLE_MESH.getMask()) == 0 || uSDKDeviceManager.getSingleInstance().b().d()) {
            ConfigurableDevice configurableDevice = new ConfigurableDevice(cVar);
            if (this.listener != null) {
                this.listener.onDeviceAdd(configurableDevice);
            } else {
                e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceAdd listener is null,so give up", new Object[0]);
            }
            Iterator<IDeviceScannerListener> it = this.deviceScannerListenerList.iterator();
            while (it.hasNext()) {
                it.next().onDeviceAdd(configurableDevice);
            }
        }
    }

    @Override // com.haier.uhome.search.a.f
    public final void onDeviceDel(com.haier.uhome.search.a.c cVar, int i7) {
        if (this.listener == null) {
            e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceDel listener is null,so give up", new Object[0]);
        } else {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceDel %s,reason %d", cVar, Integer.valueOf(i7));
            this.listener.onDeviceRemove(new ConfigurableDevice(cVar));
        }
    }

    @Override // com.haier.uhome.search.a.f
    public final void onDeviceUpdate(com.haier.uhome.search.a.c cVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceUpdate %s", cVar);
        try {
            ConfigurableDevice configurableDevice = new ConfigurableDevice(cVar);
            if (this.listener != null) {
                this.listener.onDeviceUpdate(configurableDevice);
            } else {
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "onDeviceUpdate listener is null,so give up", new Object[0]);
            }
            Iterator<IDeviceScannerListener> it = this.deviceScannerListenerList.iterator();
            while (it.hasNext()) {
                it.next().onDeviceUpdate(configurableDevice);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void removeDeviceScannerListener(IDeviceScannerListener iDeviceScannerListener) {
        this.deviceScannerListenerList.remove(iDeviceScannerListener);
    }

    @Deprecated
    public void setFeature(int i7) {
        e3.a.v("call Deprecated fun<setFeature>", new Object[0]);
    }

    public void setListener(IDeviceScannerListener iDeviceScannerListener) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "IDeviceScannerListener set to %s", iDeviceScannerListener);
        this.listener = iDeviceScannerListener;
    }

    public void setScannerListener(ScannerListener scannerListener) {
        this.permissionListener = (ScannerListener) com.haier.uhome.usdk.base.utils.b.a(scannerListener, (Class<?>) ScannerListener.class);
    }

    public void startScanConfigurableDevice(final IuSDKCallback iuSDKCallback) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "startScanConfigurableDevice", new Object[0]);
        this.scannerManager.a(this, new o() { // from class: com.haier.uhome.usdk.scanner.c
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                DeviceScanner.lambda$startScanConfigurableDevice$0(iuSDKCallback, errorConst);
            }
        });
    }

    public void stopScanConfigurableDevice(final IuSDKCallback iuSDKCallback) {
        this.bleCtl.set(false);
        this.wifiCtl.set(false);
        this.bleInvalidCtl.set(false);
        this.wifiInvalidCtl.set(false);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "stopScanConfigurableDevice ", new Object[0]);
        this.scannerManager.e(new o() { // from class: com.haier.uhome.usdk.scanner.a
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                DeviceScanner.lambda$stopScanConfigurableDevice$1(iuSDKCallback, errorConst);
            }
        });
    }

    @Override // com.haier.uhome.search.a.i
    public void wifiDisable() {
        ScannerListener scannerListener;
        if (!this.wifiCtl.compareAndSet(false, true) || (scannerListener = this.permissionListener) == null) {
            return;
        }
        scannerListener.onPermissionInvalid(Permission.WIFI_DISABLE);
    }

    @Override // com.haier.uhome.search.a.i
    public void wifiPermissionInvalid() {
        ScannerListener scannerListener;
        if (!this.wifiInvalidCtl.compareAndSet(false, true) || (scannerListener = this.permissionListener) == null) {
            return;
        }
        scannerListener.onPermissionInvalid(Permission.WIFI_INVALID);
    }

    private DeviceScanner() {
        this.deviceScannerListenerList = new ArrayList();
        this.wifiCtl = new AtomicBoolean(false);
        this.wifiInvalidCtl = new AtomicBoolean(false);
        this.bleCtl = new AtomicBoolean(false);
        this.bleInvalidCtl = new AtomicBoolean(false);
        l lVarA = l.a();
        this.scannerManager = lVarA;
        lVarA.a(this);
    }
}
