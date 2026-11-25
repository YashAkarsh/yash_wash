package com.haier.uhome.usdk.api;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKDeviceConfigInfo implements Serializable {
    private static final long serialVersionUID = 9022068141696663847L;
    private com.haier.uhome.config.a.f mDeviceConfigInfo;

    public uSDKDeviceConfigInfo() {
        this.mDeviceConfigInfo = new com.haier.uhome.config.a.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ uSDKDeviceConfigInfoAP lambda$getAplist$0(com.haier.uhome.config.a.g gVar) {
        return new uSDKDeviceConfigInfoAP(gVar.b(), gVar.c(), uSDKApEncryptionTypeConst.getInstance(gVar.a().name()));
    }

    @Deprecated
    public String getAccessGatewayDomain() {
        return null;
    }

    @Deprecated
    public int getAccessGatewayPort() {
        return 0;
    }

    public String getApPassword() {
        return this.mDeviceConfigInfo.l();
    }

    public String getApSsid() {
        return this.mDeviceConfigInfo.j();
    }

    public List<uSDKDeviceConfigInfoAP> getAplist() {
        return com.haier.library.common.util.u.a(this.mDeviceConfigInfo.i(), new com.haier.library.common.util.p() { // from class: com.haier.uhome.usdk.api.r4
            @Override // com.haier.library.common.util.p
            public final Object transform(Object obj) {
                return uSDKDeviceConfigInfo.lambda$getAplist$0((com.haier.uhome.config.a.g) obj);
            }
        });
    }

    public String getCountry() {
        return this.mDeviceConfigInfo.o();
    }

    protected com.haier.uhome.config.a.f getDeviceConfigInfo() {
        return this.mDeviceConfigInfo;
    }

    public String getEProtocolVer() {
        return this.mDeviceConfigInfo.d();
    }

    public String getMac() {
        return this.mDeviceConfigInfo.g();
    }

    public String getMainGatewayDomain() {
        return this.mDeviceConfigInfo.a();
    }

    public int getMainGatewayPort() {
        return this.mDeviceConfigInfo.c();
    }

    public int getSeconds() {
        return this.mDeviceConfigInfo.n();
    }

    public int getServerSeconds() {
        return this.mDeviceConfigInfo.m();
    }

    public uSDKDeviceTypeConst getType() {
        return uSDKDeviceTypeConst.getInstance(this.mDeviceConfigInfo.f().b());
    }

    public String getTypeIdentifier() {
        return this.mDeviceConfigInfo.e();
    }

    @Deprecated
    public void setAccessGatewayDomain(String str) {
    }

    @Deprecated
    public void setAccessGatewayPort(int i7) {
    }

    public void setApPassword(String str) {
        this.mDeviceConfigInfo.g(str);
    }

    @Deprecated
    public void setApSid(String str) {
        setApSsid(str);
    }

    public void setApSsid(String str) {
        this.mDeviceConfigInfo.e(str);
    }

    public void setCountry(String str) {
        this.mDeviceConfigInfo.h(str);
    }

    public void setMac(String str) {
        this.mDeviceConfigInfo.c(str);
    }

    public void setMainGatewayDomain(String str) {
        this.mDeviceConfigInfo.a(str);
    }

    public void setMainGatewayPort(int i7) {
        this.mDeviceConfigInfo.a(i7);
    }

    public void setSeconds(int i7) {
        this.mDeviceConfigInfo.c(i7);
    }

    public void setServerSeconds(int i7) {
        this.mDeviceConfigInfo.b(i7);
    }

    public String toString() {
        return this.mDeviceConfigInfo.toString();
    }

    public uSDKDeviceConfigInfo(com.haier.uhome.config.a.f fVar) {
        if (fVar != null) {
            this.mDeviceConfigInfo = fVar;
        } else {
            this.mDeviceConfigInfo = new com.haier.uhome.config.a.f();
        }
    }
}
