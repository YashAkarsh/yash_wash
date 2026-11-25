package com.haier.uhome.account.model.geamodel;

import com.haier.globalwasher.presenter.o;
import g3.b;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class GEADeviceVersion {

    @b(name = "basePropertiy")
    private GEABaseProperty basePropertiy;

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "deviceType")
    private String deviceType;

    @b(name = "location")
    private GEALocation location;

    @b(name = "modules")
    private Set<GEAModule> modules;

    @b(name = "wifiType")
    private String wifiType;

    public GEABaseProperty getBasePropertiy() {
        return this.basePropertiy;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public GEALocation getLocation() {
        return this.location;
    }

    public Set<GEAModule> getModules() {
        return this.modules;
    }

    public String getWifiType() {
        return this.wifiType;
    }

    public void setBasePropertiy(GEABaseProperty gEABaseProperty) {
        this.basePropertiy = gEABaseProperty;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public void setLocation(GEALocation gEALocation) {
        this.location = gEALocation;
    }

    public void setModules(Set<GEAModule> set) {
        this.modules = set;
    }

    public void setWifiType(String str) {
        this.wifiType = str;
    }
}
