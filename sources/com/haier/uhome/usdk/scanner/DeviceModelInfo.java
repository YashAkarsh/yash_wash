package com.haier.uhome.usdk.scanner;

import com.haier.uhome.usdk.base.annotation.Keep;
import n3.f;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class DeviceModelInfo {
    private ConfigGuide mConfigGuide;
    private f mTransDeviceModelInfo;

    public DeviceModelInfo(f fVar) {
        this.mTransDeviceModelInfo = fVar;
        if (fVar != null) {
            this.mConfigGuide = new ConfigGuide(fVar.o());
        }
    }

    @Keep
    public String getAppTypeCode() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.h();
    }

    @Keep
    public String getAppTypeName() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.i();
    }

    @Keep
    public String getBindFailed() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.j();
    }

    @Keep
    public String getBindFailedImg() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.k();
    }

    @Keep
    public String getBindSuccess() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.l();
    }

    @Keep
    public String getBindSuccessImg() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.m();
    }

    @Keep
    public String getBrandCode() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.n();
    }

    @Keep
    public ConfigGuide getConfigGuide() {
        if (this.mTransDeviceModelInfo == null) {
            return null;
        }
        return this.mConfigGuide;
    }

    @Keep
    public String getConfigMode() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.p();
    }

    @Keep
    public String getDeviceRole() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.q();
    }

    @Keep
    public String getHotspotName() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.r();
    }

    @Keep
    public String getModelCode() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.t();
    }

    @Keep
    public String getProductCode() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.u();
    }

    @Keep
    public String getProductDesc() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.v();
    }

    @Keep
    public String getProductImg1() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.w();
    }

    @Keep
    public String getProductImg2() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.x();
    }

    @Keep
    public String getSelfDiscoverySignCode() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.y();
    }

    @Keep
    public String getSelfDiscoverySignName() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.z();
    }

    @Keep
    public String getState() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.A();
    }

    @Keep
    public String getTypeId() {
        f fVar = this.mTransDeviceModelInfo;
        if (fVar == null) {
            return null;
        }
        return fVar.B();
    }
}
