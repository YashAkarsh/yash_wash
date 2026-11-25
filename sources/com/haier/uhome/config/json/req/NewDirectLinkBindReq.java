package com.haier.uhome.config.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.config.json.ProtocolConst;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class NewDirectLinkBindReq extends BasicReq {

    @b(name = "bindCode")
    private long mBindCode;

    @b(name = "devId")
    private String mDevId;

    @b(name = TraceProtocolConst.PRO_IP)
    private String mIp;

    @b(name = "module")
    private String mModule;

    @b(name = "port")
    private int mPort;

    @b(name = a.f13674p)
    private int mTimeout;

    @b(name = d.R)
    private String mToken;

    @b(name = "uplusId")
    private String mUplusId;

    @b(name = "verificationCode")
    private String mVerificationCode;

    @b(name = "verificationMethod")
    private int mVerificationMethod;

    public long getBindCode() {
        return this.mBindCode;
    }

    public String getDevId() {
        return this.mDevId;
    }

    public String getIp() {
        return this.mIp;
    }

    public String getModule() {
        return this.mModule;
    }

    public int getPort() {
        return this.mPort;
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public String getToken() {
        return this.mToken;
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    public String getVerificationCode() {
        return this.mVerificationCode;
    }

    public int getVerificationMethod() {
        return this.mVerificationMethod;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_NEW_DIRECT_LINK_BIND;
    }

    public void setBindCode(long j7) {
        this.mBindCode = j7;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setIp(String str) {
        this.mIp = str;
    }

    public void setModule(String str) {
        this.mModule = str;
    }

    public void setPort(int i7) {
        this.mPort = i7;
    }

    public void setTimeout(int i7) {
        this.mTimeout = i7;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public void setUplusId(String str) {
        this.mUplusId = str;
    }

    public void setVerificationCode(String str) {
        this.mVerificationCode = str;
    }

    public void setVerificationMethod(int i7) {
        this.mVerificationMethod = i7;
    }
}
