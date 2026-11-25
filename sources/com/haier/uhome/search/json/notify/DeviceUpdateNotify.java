package com.haier.uhome.search.json.notify;

import com.haier.uhome.search.b.d;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceUpdateNotify extends BasicNotify {

    @b(name = "accessoryWifi")
    private int accessoryWifi;

    @b(name = "APConnected")
    private int apConnected;

    @b(name = "BDAddress")
    private String bdAddress;

    @b(name = "bindTimestamp")
    private long bindTimestamp;

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "busying")
    private int busy;

    @b(name = "configMode")
    private int configMode;

    @b(name = "isConfigurable")
    private int configurable;

    @b(name = "isControllable")
    private int controllable;

    @b(name = "devId")
    private String devId;

    @b(name = "hardwareType")
    private String hardwareType;

    @b(name = "hardwareVer")
    private String hardwareVer;

    @b(name = "hwPlatform")
    private String hwPlatform;

    @b(name = "hwVer")
    private String hwVer;

    @b(name = "ip4hostAddress")
    private String ip4hostAddress;

    @b(name = "ip6hostAddress")
    private String ip6hostAddress;

    @b(name = "isAuxConfigCapability")
    private int isAuxConfigCapability;

    @b(name = "isMeshGW")
    private int isMeshGW;

    @b(name = "isOnline")
    private int isOnline;

    @b(name = "keyVer")
    private String keyVer;

    @b(name = "isLocalkeyValid")
    private int localkeyValid;

    @b(name = "configureBindingMode")
    private String mConfigureBindingMode;

    @b(name = "devState")
    private int mDevState;

    @b(name = "onlineVer")
    private String mOnlineVer;

    @b(name = "pType")
    private String mPType;

    @b(name = "verificationMethod")
    private int mVerificationMethod;

    @b(name = "modelShortID")
    private String modelShortID;

    @b(name = "module")
    private String module;

    @b(name = "name")
    private String name;

    @b(name = "port")
    private int port;

    @b(name = "productCode")
    private String productCode;

    @b(name = "propertyChanged")
    private boolean propertyChanged;

    @b(name = "protoVer")
    private String protoVer;

    @b(name = "protocol")
    private String protocol;

    @b(name = "protVers")
    private String protocolVers;

    @b(name = "RSSI")
    private int rssi;

    @b(name = "securityVersion")
    private String securityVersionName;

    @b(name = "selfBind")
    private int selfBind;

    @b(name = "sharedPort")
    private int sharedPort;

    @b(name = "smartlinkSeed")
    private int smartlinkSeed;

    @b(name = "softwareType")
    private String softwareType;

    @b(name = "softwareVer")
    private String softwareVer;

    @b(name = "stateCode")
    private int stateCode;

    @b(name = "supportNetworkQuality")
    private int supportNetworkQuality;

    @b(name = "isTriggerConfigurable")
    private int triggerConfigurable;

    @b(name = "typeMain")
    private int typeMain;

    @b(name = "typeMinor")
    private int typeMinor;

    @b(name = "udpPort")
    private int udpPort;

    @b(name = "isUpdatable")
    private int updatable;

    @b(name = "uplusId")
    private String uplusId;

    @b(name = "mac")
    private String wifiMac;

    public int getAccessoryWifi() {
        return this.accessoryWifi;
    }

    public int getApConnected() {
        return this.apConnected;
    }

    public String getBdAddress() {
        return this.bdAddress;
    }

    public long getBindTimestamp() {
        return this.bindTimestamp;
    }

    public String getBleDevId() {
        return this.bleDevId;
    }

    public int getBusy() {
        return this.busy;
    }

    public int getConfigMode() {
        return this.configMode;
    }

    public int getConfigurable() {
        return this.configurable;
    }

    public String getConfigureBindingMode() {
        return this.mConfigureBindingMode;
    }

    public int getControllable() {
        return this.controllable;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getDevState() {
        return this.mDevState;
    }

    public String getHardwareType() {
        return this.hardwareType;
    }

    public String getHardwareVer() {
        return this.hardwareVer;
    }

    public String getHwPlatform() {
        return this.hwPlatform;
    }

    public String getHwVer() {
        return this.hwVer;
    }

    public String getIp4hostAddress() {
        return this.ip4hostAddress;
    }

    public String getIp6hostAddress() {
        return this.ip6hostAddress;
    }

    public int getIsAuxConfigCapability() {
        return this.isAuxConfigCapability;
    }

    public int getIsMeshGW() {
        return this.isMeshGW;
    }

    public int getIsOnline() {
        return this.isOnline;
    }

    public String getKeyVer() {
        return this.keyVer;
    }

    public int getLocalkeyValid() {
        return this.localkeyValid;
    }

    public String getModelShortID() {
        return this.modelShortID;
    }

    public String getModule() {
        return this.module;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new d();
    }

    public String getOnlineVer() {
        return this.mOnlineVer;
    }

    public String getPType() {
        return this.mPType;
    }

    public int getPort() {
        return this.port;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getProtoVer() {
        return this.protoVer;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getProtocolVers() {
        return this.protocolVers;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSecurityVersionName() {
        return this.securityVersionName;
    }

    public int getSelfBind() {
        return this.selfBind;
    }

    public int getSharedPort() {
        return this.sharedPort;
    }

    public int getSmartlinkSeed() {
        return this.smartlinkSeed;
    }

    public String getSoftwareType() {
        return this.softwareType;
    }

    public String getSoftwareVer() {
        return this.softwareVer;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public int getSupportNetworkQuality() {
        return this.supportNetworkQuality;
    }

    public int getTriggerConfigurable() {
        return this.triggerConfigurable;
    }

    public int getTypeMain() {
        return this.typeMain;
    }

    public int getTypeMinor() {
        return this.typeMinor;
    }

    public int getUdpPort() {
        return this.udpPort;
    }

    public int getUpdatable() {
        return this.updatable;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public int getVerificationMethod() {
        return this.mVerificationMethod;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public boolean isPropertyChanged() {
        return this.propertyChanged;
    }

    public void setAccessoryWifi(int i7) {
        this.accessoryWifi = i7;
    }

    public void setApConnected(int i7) {
        this.apConnected = i7;
    }

    public void setBdAddress(String str) {
        this.bdAddress = str;
    }

    public void setBindTimestamp(long j7) {
        this.bindTimestamp = j7;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setBusy(int i7) {
        this.busy = i7;
    }

    public void setConfigMode(int i7) {
        this.configMode = i7;
    }

    public void setConfigurable(int i7) {
        this.configurable = i7;
    }

    public void setConfigureBindingMode(String str) {
        this.mConfigureBindingMode = str;
    }

    public void setControllable(int i7) {
        this.controllable = i7;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setDevState(int i7) {
        this.mDevState = i7;
    }

    public void setHardwareType(String str) {
        this.hardwareType = str;
    }

    public void setHardwareVer(String str) {
        this.hardwareVer = str;
    }

    public void setHwPlatform(String str) {
        this.hwPlatform = str;
    }

    public void setHwVer(String str) {
        this.hwVer = str;
    }

    public void setIp4hostAddress(String str) {
        this.ip4hostAddress = str;
    }

    public void setIp6hostAddress(String str) {
        this.ip6hostAddress = str;
    }

    public void setIsAuxConfigCapability(int i7) {
        this.isAuxConfigCapability = i7;
    }

    public void setIsMeshGW(int i7) {
        this.isMeshGW = i7;
    }

    public void setIsOnline(int i7) {
        this.isOnline = i7;
    }

    public void setKeyVer(String str) {
        this.keyVer = str;
    }

    public void setLocalkeyValid(int i7) {
        this.localkeyValid = i7;
    }

    public void setModelShortID(String str) {
        this.modelShortID = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnlineVer(String str) {
        this.mOnlineVer = str;
    }

    public void setPType(String str) {
        this.mPType = str;
    }

    public void setPort(int i7) {
        this.port = i7;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setPropertyChanged(boolean z7) {
        this.propertyChanged = z7;
    }

    public void setProtoVer(String str) {
        this.protoVer = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setProtocolVers(String str) {
        this.protocolVers = str;
    }

    public void setRssi(int i7) {
        this.rssi = i7;
    }

    public void setSecurityVersionName(String str) {
        this.securityVersionName = str;
    }

    public void setSelfBind(int i7) {
        this.selfBind = i7;
    }

    public void setSharedPort(int i7) {
        this.sharedPort = i7;
    }

    public void setSmartlinkSeed(int i7) {
        this.smartlinkSeed = i7;
    }

    public void setSoftwareType(String str) {
        this.softwareType = str;
    }

    public void setSoftwareVer(String str) {
        this.softwareVer = str;
    }

    public void setStateCode(int i7) {
        this.stateCode = i7;
    }

    public void setSupportNetworkQuality(int i7) {
        this.supportNetworkQuality = i7;
    }

    public void setTriggerConfigurable(int i7) {
        this.triggerConfigurable = i7;
    }

    public void setTypeMain(int i7) {
        this.typeMain = i7;
    }

    public void setTypeMinor(int i7) {
        this.typeMinor = i7;
    }

    public void setUdpPort(int i7) {
        this.udpPort = i7;
    }

    public void setUpdatable(int i7) {
        this.updatable = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    public void setVerificationMethod(int i7) {
        this.mVerificationMethod = i7;
    }

    public void setWifiMac(String str) {
        this.wifiMac = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceUpdateNotify{" + super.toString() + "module=" + this.module + ", protocol=" + this.protocol + ", protocolVers=" + this.protocolVers + ", uplusId=" + this.uplusId + ", devId=" + this.devId + ", softwareType=" + this.softwareType + ", hardwareType=" + this.hardwareType + ", smartlinkSeed=" + this.smartlinkSeed + ", configMode=" + this.configMode + ", softwareVer=" + this.softwareVer + ", hardwareVer=" + this.hardwareVer + ", apConnected=" + this.apConnected + ", selfBind=" + this.selfBind + ", bleDevId=" + this.bleDevId + ", localkeyValid=" + this.localkeyValid + ", wifiMac=" + this.wifiMac + ", configurable=" + this.configurable + ", bdAddress=" + this.bdAddress + ", udpPort=" + this.udpPort + ", controllable=" + this.controllable + ", updatable=" + this.updatable + ", rssi=" + this.rssi + ", accessoryWifi=" + this.accessoryWifi + ", triggerConfigurable=" + this.triggerConfigurable + ", typeMain=" + this.typeMain + ", typeMinor=" + this.typeMinor + ", securityVersionName=" + this.securityVersionName + ", busy=" + this.busy + ", supportNetworkQuality=" + this.supportNetworkQuality + ", ip4hostAddress=" + this.ip4hostAddress + ", ip6hostAddress=" + this.ip6hostAddress + ", port=" + this.port + ", sharedPort=" + this.sharedPort + ", isOnline=" + this.isOnline + ", bindTimestamp=" + this.bindTimestamp + ", name=" + this.name + ", propertyChanged=" + this.propertyChanged + ", productCode=" + this.productCode + ", mPType=" + this.mPType + ", mOnlineVer=" + this.mOnlineVer + ", mDevState=" + this.mDevState + ", mConfigureBindingMode=" + this.mConfigureBindingMode + ", mVerificationMethod=" + this.mVerificationMethod + ", isAuxConfigCapability=" + this.isAuxConfigCapability + ", protoVer=" + this.protoVer + ", keyVer=" + this.keyVer + ", hwPlatform=" + this.hwPlatform + ", hwVer=" + this.hwVer + ", modelShortID=" + this.modelShortID + ", stateCode=" + this.stateCode + "} ";
    }
}
