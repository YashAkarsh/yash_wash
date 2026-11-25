package com.haier.uhome.control.cloud.json.req;

import com.alipay.sdk.data.a;
import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;
import com.haier.uhome.control.cloud.json.ProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BoardFOTAReq extends BasicDeviceReq {

    @b(name = "digest")
    String digest;

    @b(name = "digestAlg")
    String digestAlg;

    @b(name = "fotaTimeout")
    int fotaTimeout;

    @b(name = RetInfoContent.BindKEY_ISNULL)
    String key;

    @b(name = "keyAlg")
    String keyAlg;

    @b(name = "size")
    int size;

    @b(name = a.f13674p)
    int timeout;

    @b(name = "traceId")
    private String traceId;

    @b(name = "upgradePackageURL")
    String url;

    public String getDigest() {
        return this.digest;
    }

    public String getDigestAlg() {
        return this.digestAlg;
    }

    public int getFotaTimeout() {
        return this.fotaTimeout;
    }

    public String getKey() {
        return this.key;
    }

    public String getKeyAlg() {
        return this.keyAlg;
    }

    public int getSize() {
        return this.size;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return ProtocolConst.REQ_BOARD_FOTA;
    }

    public void setDigest(String str) {
        this.digest = str;
    }

    public void setDigestAlg(String str) {
        this.digestAlg = str;
    }

    public void setFotaTimeout(int i7) {
        this.fotaTimeout = i7;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setKeyAlg(String str) {
        this.keyAlg = str;
    }

    public void setSize(int i7) {
        this.size = i7;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
