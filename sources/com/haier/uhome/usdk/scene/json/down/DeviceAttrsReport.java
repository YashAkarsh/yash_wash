package com.haier.uhome.usdk.scene.json.down;

import com.haier.globalwasher.presenter.o;
import com.haier.library.json.a;
import com.haier.uhome.usdk.scene.json.ProtocolConst;
import g3.b;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAttrsReport implements BaseDown {

    @b(name = "changeReport")
    private HashMap<String, List<ReportBean>> changeReport;

    @b(name = o.f25218y)
    private String deviceId;

    @Override // com.haier.uhome.usdk.scene.json.down.BaseDown
    public final String buildJson() {
        HashMap map = new HashMap(1);
        map.put(ProtocolConst.DOWN_RPT_DEVICE_ATTRS, this);
        return a.Z(map);
    }

    public HashMap<String, List<ReportBean>> getChangeReport() {
        return this.changeReport;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setChangeReport(HashMap<String, List<ReportBean>> map) {
        this.changeReport = map;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public String toString() {
        return "DeviceAttrsReport{deviceId='" + this.deviceId + "', changeReport=" + this.changeReport + '}';
    }
}
