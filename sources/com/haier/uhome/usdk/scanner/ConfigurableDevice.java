package com.haier.uhome.usdk.scanner;

import c.o0;
import com.haier.uhome.usdk.api.uSDKDeviceTypeConst;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.utils.f;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class ConfigurableDevice implements Serializable {
    private final com.haier.uhome.search.a.c deviceInfo;
    private final ExtendInfo extendInfo;

    protected ConfigurableDevice(com.haier.uhome.search.a.c cVar) {
        this.deviceInfo = cVar;
        this.extendInfo = new ExtendInfo(cVar.A(), cVar.G(), cVar.B(), cVar.C(), cVar.D());
    }

    public int getAllConfigTypes() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar != null) {
            return cVar.x();
        }
        return 0;
    }

    public String getAppTypeName() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar != null) {
            return cVar.F();
        }
        return null;
    }

    @Keep
    @Deprecated
    public BindType getBindType() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return BindType.PHONE;
        }
        return cVar.h() ? BindType.DEVICE : BindType.PHONE;
    }

    @Keep
    public String getBleDevId() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return null;
        }
        return cVar.b();
    }

    @Keep
    @Deprecated
    public String getBleMac() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    @Keep
    @Deprecated
    public String getBleName() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return null;
        }
        return cVar.d();
    }

    @Keep
    public int getChannel() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return 0;
        }
        return cVar.t();
    }

    @o0
    @Keep
    public String getCompanyId() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return null;
        }
        return cVar.u();
    }

    @Keep
    public ConfigStatus getConfigStatus() {
        int iC = this.deviceInfo.c();
        if (iC == 1) {
            return ConfigStatus.CONFIG_ABLE;
        }
        if (iC == 2) {
            return ConfigStatus.TRIGGER_CONFIG_ABLE;
        }
        if (iC == 3) {
            return ConfigStatus.ALREADY_CONFIGURED;
        }
        e3.a.v("getConfigStatus error configStatus primitive value = %d", Integer.valueOf(this.deviceInfo.c()));
        return ConfigStatus.CONFIG_ABLE;
    }

    @Keep
    public int getConfigType() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return 0;
        }
        return cVar.i();
    }

    @Keep
    public String getDevId() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    public String getDevUuid() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        return cVar == null ? "" : cVar.s();
    }

    public com.haier.uhome.search.a.c getDeviceInfo() {
        return this.deviceInfo;
    }

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    @o0
    @Keep
    public String getHotSpotName() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar != null) {
            return cVar.H();
        }
        return null;
    }

    @o0
    @Keep
    public String getIp() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return null;
        }
        return cVar.p();
    }

    @Keep
    public int getMiddleType() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return 0;
        }
        return cVar.f();
    }

    public String getModelShortID() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar != null) {
            return cVar.y();
        }
        return null;
    }

    @Keep
    public String getName() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return null;
        }
        return cVar.d();
    }

    @Keep
    public int getPort() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return 0;
        }
        return cVar.q();
    }

    @Keep
    public String getProductCode() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null || !com.haier.library.common.util.c.l(cVar.g())) {
            return null;
        }
        return this.deviceInfo.g();
    }

    @Keep
    public int getProtocolVers() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar != null) {
            return f.f(cVar.r());
        }
        return 0;
    }

    @Keep
    public uSDKDeviceTypeConst getType() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        if (cVar == null) {
            return uSDKDeviceTypeConst.UNKNOWN;
        }
        return cVar.e() == null ? uSDKDeviceTypeConst.UNKNOWN : uSDKDeviceTypeConst.getInstance(this.deviceInfo.e().name());
    }

    @Keep
    public String getUplusId() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        return cVar == null ? "" : cVar.l();
    }

    public NewDirectLinkVerificationMethod getVerificationMethod() {
        com.haier.uhome.search.a.c cVar = this.deviceInfo;
        return (cVar == null || cVar.m() != 0) ? NewDirectLinkVerificationMethod.MANUAL_CONFIRM : NewDirectLinkVerificationMethod.VERIFICATION_CODE;
    }

    @Keep
    @Deprecated
    public boolean isConfigurable() {
        return true;
    }

    @Keep
    @Deprecated
    public boolean isTriggerConfigurable() {
        return this.deviceInfo.c() == 2;
    }
}
