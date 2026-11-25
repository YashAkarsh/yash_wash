package com.haier.uhome.config.service;

import com.haier.uhome.config.json.req.BleCfgSetSimpleParamReq;
import com.haier.uhome.config.json.req.BleConfigReq;
import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConfigNative f28599a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g f28600a = new g();

        private a() {
        }
    }

    public static g a() {
        return a.f28600a;
    }

    public void b() {
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "stopBleAllConfig start", new Object[0]);
        this.f28599a.stopBleAllConfig();
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "stopBleAllConfig end", new Object[0]);
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "sendReq %s", basicReq);
        int sn = basicReq.getSn();
        if (basicReq instanceof BleConfigReq) {
            BleConfigReq bleConfigReq = (BleConfigReq) basicReq;
            return a(sn, bleConfigReq.getBleDevId(), bleConfigReq.getSsid(), bleConfigReq.getBssid(), bleConfigReq.getPassword(), bleConfigReq.getToken(), bleConfigReq.getTraceId(), bleConfigReq.getTimestamp(), bleConfigReq.getBindCode(), bleConfigReq.getBleType());
        }
        if (!(basicReq instanceof BleCfgSetSimpleParamReq)) {
            return -1;
        }
        BleCfgSetSimpleParamReq bleCfgSetSimpleParamReq = (BleCfgSetSimpleParamReq) basicReq;
        return a(sn, bleCfgSetSimpleParamReq.getModule(), bleCfgSetSimpleParamReq.getBleDevId(), bleCfgSetSimpleParamReq.getDevId(), bleCfgSetSimpleParamReq.getTimeout(), bleCfgSetSimpleParamReq.getTraceId());
    }

    private g() {
        ConfigNative configNative = new ConfigNative();
        this.f28599a = configNative;
        configNative.bleConfigInit();
        this.f28599a.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    private int a(int i7, String str, String str2, String str3, String str4, String str5, String str6, long j7, long j8, int i8) {
        String str7 = str == null ? "" : str;
        String str8 = str2 == null ? "" : str2;
        String str9 = str3 == null ? "" : str3;
        String str10 = str4 == null ? "" : str4;
        String str11 = str5 == null ? "" : str5;
        String str12 = str6 == null ? "" : str6;
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "startBleConfig sn %d-%s-%s, bleType = %d", Integer.valueOf(i7), str7, str8, Integer.valueOf(i8));
        int iStartBleConfig = this.f28599a.startBleConfig(i7, str7, str8, str9, str10, str11, str12, j7, j8, i8);
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "startBleConfig sn %d-%s-%s ret = %d", Integer.valueOf(i7), str7, str8, Integer.valueOf(iStartBleConfig));
        return iStartBleConfig;
    }

    private int a(int i7, String str, String str2, String str3, int i8, String str4) {
        String str5 = str == null ? "" : str;
        String str6 = str2 == null ? "" : str2;
        String str7 = str3 == null ? "" : str3;
        String str8 = str4 == null ? "" : str4;
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "startBleSimpleConfig sn %d-%s-%s", Integer.valueOf(i7), str6, str7);
        int iStartBleSimpleConfig = this.f28599a.startBleSimpleConfig(i7, str5, str6, str7, i8, str8);
        e3.a.d(com.haier.uhome.config.a.E, "BLE", "startBleSimpleConfig sn %d-%s-%s ret = %d", Integer.valueOf(i7), str6, str7, Integer.valueOf(iStartBleSimpleConfig));
        return iStartBleSimpleConfig;
    }
}
