package com.haier.uhome.mesh.bridge;

import com.haier.library.common.thread.m;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.service.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class RtkScannerWrapper implements IScanner {
    private static final long AUTO_SCAN_DELAY = 500;
    public static final int STATE_DISCOVERY_FINISHED = 3;
    public static final int STATE_DISCOVERY_STARTED = 2;
    public static final int STATE_DISCOVERY_START_PROCESS = 1;
    public static final int STATE_IDLE = 0;
    private List<IScannerCallback> mIScannerCallbacks;
    private volatile IdentityCallback mIdentityCallback;
    private t4.a mMeshScanCallback;
    private t4.c mProvScanner;
    private t4.c mProxyScanner;

    /* JADX INFO: renamed from: com.haier.uhome.mesh.bridge.RtkScannerWrapper$1, reason: invalid class name */
    class AnonymousClass1 extends t4.a {
        AnonymousClass1() {
        }

        @Override // t4.a
        public void onIdentityDeviceFound(h4.b bVar, byte[] bArr, byte[] bArr2) {
            if (bVar == null || bVar.b() == null) {
                e3.a.e("ExtendedBluetoothDevice is null or BluetoothDevice is null,so return", new Object[0]);
                return;
            }
            e3.a.d("Mesh scan: identity device = %s, hash = %s, random = %s", bVar.b().getAddress(), com.haier.library.common.util.c.a(bArr), com.haier.library.common.util.c.a(bArr2));
            IdentityCallback identityCallback = RtkScannerWrapper.this.mIdentityCallback;
            if (identityCallback != null) {
                identityCallback.onIdentityDeviceFound(bVar.b().getAddress(), bArr, bArr2);
            }
        }

        @Override // t4.a
        public void onProvDeviceFound(final h4.b bVar, final byte[] bArr) {
            if (bVar == null || bVar.b() == null) {
                e3.a.e("ExtendedBluetoothDevice is null or BluetoothDevice is null,so return", new Object[0]);
            } else {
                e3.a.d("Mesh scan: prov device = %s, deviceUuid = %s", a(bVar), com.haier.library.common.util.c.a(bArr), new Object[0]);
                m.execute(new Runnable() { // from class: com.haier.uhome.mesh.bridge.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f29502a.a(bVar, bArr);
                    }
                });
            }
        }

        @Override // t4.a
        public void onProxyDeviceFound(h4.b bVar, byte[] bArr) {
            if (bVar == null || bVar.b() == null) {
                e3.a.e("ExtendedBluetoothDevice is null or BluetoothDevice is null,so return", new Object[0]);
                return;
            }
            e3.a.d("Mesh scan: proxy device = %s, networkId = %s", a(bVar), com.haier.library.common.util.c.a(bArr), new Object[0]);
            Iterator it = RtkScannerWrapper.this.mIScannerCallbacks.iterator();
            while (it.hasNext()) {
                ((IScannerCallback) it.next()).onProxyDeviceFound(bVar.b().getAddress(), bVar.c(), bVar.d(), bVar.e());
            }
        }

        @Override // t4.a
        public void onScanStateChanged(boolean z7) {
            super.onScanStateChanged(z7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(h4.b bVar, byte[] bArr) {
            Iterator it = RtkScannerWrapper.this.mIScannerCallbacks.iterator();
            while (it.hasNext()) {
                ((IScannerCallback) it.next()).onUnProvDeviceFound(bVar.b().getAddress(), bVar.c(), bArr, bVar.e());
            }
        }

        private String a(h4.b bVar) {
            return "{ name: " + bVar.c() + ", address: " + bVar.f34047a.getAddress() + " }";
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static RtkScannerWrapper f29500a = new RtkScannerWrapper(null);

        private a() {
        }
    }

    /* synthetic */ RtkScannerWrapper(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static RtkScannerWrapper getInstance() {
        return a.f29500a;
    }

    @Override // com.haier.uhome.mesh.bridge.IScanner
    public void registerCallback(IScannerCallback iScannerCallback) {
        this.mIScannerCallbacks.add(iScannerCallback);
    }

    public void registerIdentityCallback(IdentityCallback identityCallback) {
        this.mIdentityCallback = identityCallback;
    }

    public void removeIdentityCallback() {
        this.mIdentityCallback = null;
    }

    @Override // com.haier.uhome.mesh.bridge.IScanner
    public void scanProv(o oVar) {
        t4.c cVar = this.mProvScanner;
        if (cVar != null) {
            cVar.i();
            this.mProvScanner.c();
            this.mProvScanner = null;
        }
        t4.c cVar2 = new t4.c(e.a().b(), AUTO_SCAN_DELAY);
        this.mProvScanner = cVar2;
        cVar2.f(this.mMeshScanCallback);
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.mesh.bridge.IScanner
    public void scanProxy(o oVar) {
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.v("scanProxy fail, ble is disable!", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_BLE_NOT_OPEN);
            return;
        }
        t4.c cVar = this.mProxyScanner;
        if (cVar != null) {
            cVar.i();
            this.mProxyScanner.c();
            this.mProxyScanner = null;
        }
        t4.c cVar2 = new t4.c(e.a().b(), AUTO_SCAN_DELAY);
        this.mProxyScanner = cVar2;
        cVar2.h(new t4.b.a().b(0).a());
        this.mProxyScanner.g(this.mMeshScanCallback);
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.mesh.bridge.IScanner
    public void stopScanProv(o oVar) {
        t4.c cVar = this.mProvScanner;
        if (cVar != null) {
            cVar.i();
        }
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.mesh.bridge.IScanner
    public void stopScanProxy(o oVar) {
        t4.c cVar = this.mProxyScanner;
        if (cVar != null) {
            cVar.i();
        }
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.mesh.bridge.IScanner
    public void unRegisterCallback(IScannerCallback iScannerCallback) {
        this.mIScannerCallbacks.remove(iScannerCallback);
    }

    private RtkScannerWrapper() {
        this.mMeshScanCallback = new AnonymousClass1();
        this.mIScannerCallbacks = new CopyOnWriteArrayList();
    }
}
