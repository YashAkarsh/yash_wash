package com.haier.uhome.control.local.json.req;

import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.local.json.ProtocolConst;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class StartDeviceBleOtaReq extends BasicDeviceReq {

    @b(name = "bleDevId")
    private String bleDevId;

    @b(name = "elementAddr")
    private String elementAddr;

    @b(name = "is_ota_resume")
    private int isOtaResume;

    @b(name = RetInfoContent.BindKEY_ISNULL)
    private String key;

    @b(name = "key_alg")
    private int keyAlg;

    @b(name = "key_len")
    private int keyLen;

    @b(name = "module")
    private String module;

    @b(name = "otaFilePath")
    private String otaFilePath;

    @b(name = "protocol")
    private String protocol;

    @b(name = "securityKey")
    private String securityKey;

    @b(name = "bleOTASession")
    private int session;

    @b(name = d.R)
    private String token;

    public String getBleDevId() {
        return this.bleDevId;
    }

    public String getElementAddr() {
        return this.elementAddr;
    }

    public int getIsOtaResume() {
        return this.isOtaResume;
    }

    public String getKey() {
        return this.key;
    }

    public int getKeyAlg() {
        return this.keyAlg;
    }

    public int getKeyLen() {
        return this.keyLen;
    }

    public String getModule() {
        return this.module;
    }

    public String getOtaFilePath() {
        return this.otaFilePath;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getSecurityKey() {
        return this.securityKey;
    }

    public int getSession() {
        return this.session;
    }

    public String getToken() {
        return this.token;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_START_DEVICE_BLE_OTA;
    }

    public void setBleDevId(String str) {
        this.bleDevId = str;
    }

    public void setElementAddr(String str) {
        this.elementAddr = str;
    }

    public void setIsOtaResume(int i7) {
        this.isOtaResume = i7;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setKeyAlg(int i7) {
        this.keyAlg = i7;
    }

    public void setKeyLen(int i7) {
        this.keyLen = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setOtaFilePath(String str) {
        this.otaFilePath = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setSecurityKey(String str) {
        this.securityKey = str;
    }

    public void setSession(int i7) {
        this.session = i7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "StartDeviceBleOtaReq{bleDevId='" + this.bleDevId + "', session=" + this.session + ", protocol='" + this.protocol + "', otaFilePath='" + this.otaFilePath + "', module='" + this.module + "', securityKey='" + this.securityKey + "', key='" + this.key + "', keyLen=" + this.keyLen + ", keyAlg='" + this.keyAlg + "', token='" + this.token + "', isOtaResume='" + this.isOtaResume + "', elementAddr='" + this.elementAddr + "'}";
    }
}
