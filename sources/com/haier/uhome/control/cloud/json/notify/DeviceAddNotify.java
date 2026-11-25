package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.j;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAddNotify extends BasicNotify {

    @b(name = "bindTimestamp")
    private long bindTimestamp;

    @b(name = "configVer")
    private String configVer;

    @b(name = "configureBindingMode")
    private String configureBindingMode;

    @b(name = "devId")
    private String devId;

    @b(name = "hwPlatform")
    private String hwPlatform;

    @b(name = "hwVer")
    private String hwVer;

    @b(name = "isAuxConfigCapability")
    private int isAuxConfigCapability;

    @b(name = "keyVer")
    private String keyVer;

    @b(name = "modelShortID")
    private String modelShortID;

    @b(name = "module")
    private String module;

    @b(name = "isOnline")
    private int online;

    @b(name = "protoVer")
    private String protoVer;

    @b(name = "stateCode")
    private int stateCode;

    @b(name = "uplusId")
    private String uplusId;

    public long getBindTimestamp() {
        return this.bindTimestamp;
    }

    public String getConfigVer() {
        return this.configVer;
    }

    public String getConfigureBindingMode() {
        return this.configureBindingMode;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getHwPlatform() {
        return this.hwPlatform;
    }

    public String getHwVer() {
        return this.hwVer;
    }

    public int getIsAuxConfigCapability() {
        return this.isAuxConfigCapability;
    }

    public String getKeyVer() {
        return this.keyVer;
    }

    public String getModelShortID() {
        return this.modelShortID;
    }

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new j();
    }

    public int getOnline() {
        return this.online;
    }

    public String getProtoVer() {
        return this.protoVer;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public void setBindTimestamp(long j7) {
        this.bindTimestamp = j7;
    }

    public void setConfigVer(String str) {
        this.configVer = str;
    }

    public void setConfigureBindingMode(String str) {
        this.configureBindingMode = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setHwPlatform(String str) {
        this.hwPlatform = str;
    }

    public void setHwVer(String str) {
        this.hwVer = str;
    }

    public void setIsAuxConfigCapability(int i7) {
        this.isAuxConfigCapability = i7;
    }

    public void setKeyVer(String str) {
        this.keyVer = str;
    }

    public void setModelShortID(String str) {
        this.modelShortID = str;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setOnline(int i7) {
        this.online = i7;
    }

    public void setProtoVer(String str) {
        this.protoVer = str;
    }

    public void setStateCode(int i7) {
        this.stateCode = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }
}
