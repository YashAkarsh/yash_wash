package com.haier.uhome.mesh.service;

import com.haier.uhome.mesh.util.KeyTools;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class MeshNativeService {
    private AtomicInteger mHandleGenerator;
    private Map<Long, Integer> mHandleMap;
    private MeshVendorModelCallback mVendorModelCallback;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static MeshNativeService f29505a = new MeshNativeService();

        private a() {
        }
    }

    public static MeshNativeService getInstance() {
        return a.f29505a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i7, int i8, VendorData vendorData) {
        e3.a.e("get Vendor Data elementIndex = %d,modelId = %d, data = %s", Integer.valueOf(i7), Integer.valueOf(i8), vendorData.toString());
        Integer num = this.mHandleMap.get(Long.valueOf(KeyTools.getGlobalVendorModelId(i7, i8)));
        if (num == null || num.intValue() == 0) {
            e3.a.v("handle <%d-0x%s> not found", Integer.valueOf(i7), Integer.toHexString(i8));
        } else {
            e3.a.e("send <%s> to handle %d", vendorData, num);
            MeshNative.sendToLib(num.intValue(), vendorData.getDst(), vendorData.getSrc(), vendorData.getTtl(), vendorData.getRssi(), vendorData.getSeqNum(), vendorData.getNetKeyIndex(), vendorData.getAppKeyIndex(), vendorData.getData());
        }
    }

    public void initHal(int i7, int i8, int i9) {
        MeshNative.init(i7, i8, i9);
    }

    public int registerVendorModel(int i7, int i8, int i9) {
        int vendorModelId = KeyTools.getVendorModelId(i8, i9);
        int iRegisterVendorModel = NetworkManagerService.getInstance().registerVendorModel(i7, vendorModelId, this.mVendorModelCallback);
        if (iRegisterVendorModel != 0) {
            return iRegisterVendorModel;
        }
        long globalVendorModelId = KeyTools.getGlobalVendorModelId(i7, i8, i9);
        Map<Long, Integer> map = this.mHandleMap;
        if (map == null) {
            e3.a.v("handle map not init,ret to lib -1", new Object[0]);
            return -4;
        }
        if (map.containsKey(Long.valueOf(globalVendorModelId))) {
            e3.a.v("registerVendorModel failed,%d-%d-%d  ret to lib -2", Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9));
            return -4;
        }
        int andIncrement = this.mHandleGenerator.getAndIncrement();
        this.mHandleMap.put(Long.valueOf(globalVendorModelId), Integer.valueOf(andIncrement));
        e3.a.e("registerVendorModel success,vendorModelId = %s handle = %d", Integer.toHexString(vendorModelId), Integer.valueOf(andIncrement));
        return andIncrement;
    }

    public int sendToStack(int i7, int i8, int i9, int i10, int i11, int i12, byte[] bArr) {
        long jLongValue;
        Iterator<Map.Entry<Long, Integer>> it = this.mHandleMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                jLongValue = 0;
                break;
            }
            Map.Entry<Long, Integer> next = it.next();
            if (next.getValue().intValue() == i7) {
                jLongValue = next.getKey().longValue();
                break;
            }
        }
        if (jLongValue == 0) {
            e3.a.v("handle <%s> not found,ret to lib -1", Integer.toHexString(i7));
            return -7;
        }
        HaierClientModel vendorModel = NetworkManagerService.getInstance().getVendorModel(KeyTools.getElementIndex(jLongValue), KeyTools.getVendorModelId(jLongValue));
        if (vendorModel != null) {
            return vendorModel.sendData(i8, i12, bArr);
        }
        e3.a.v("model <%s> not found,ret to lib -2", Long.toHexString(jLongValue));
        return -8;
    }

    private MeshNativeService() {
        this.mVendorModelCallback = new MeshVendorModelCallback() { // from class: com.haier.uhome.mesh.service.a
            @Override // com.haier.uhome.mesh.service.MeshVendorModelCallback
            public final void onVendorData(int i7, int i8, VendorData vendorData) {
                this.f29507a.lambda$new$0(i7, i8, vendorData);
            }
        };
        this.mHandleMap = new HashMap();
        this.mHandleGenerator = new AtomicInteger(1);
    }
}
