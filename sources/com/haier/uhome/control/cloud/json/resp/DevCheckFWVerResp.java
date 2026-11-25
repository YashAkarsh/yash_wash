package com.haier.uhome.control.cloud.json.resp;

import com.alipay.sdk.data.a;
import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.trace.api.TraceProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DevCheckFWVerResp {

    @b(name = "errNo")
    int errNo;

    @b(name = "firmware")
    Firmware firmware;

    @b(name = TraceProtocolConst.PRO_MODEL)
    String model;

    @b(name = "vers")
    String vers;

    public class Firmware {

        @b(name = TraceProtocolConst.PRO_DESCRIPTION)
        String desc;

        @b(name = "digest")
        String digest;

        @b(name = "digestAlg")
        String digestAlg;

        @b(name = RetInfoContent.BindKEY_ISNULL)
        String key;

        @b(name = "keyAlg")
        String keyAlg;

        @b(name = "size")
        int size;

        @b(name = a.f13674p)
        int timeout;

        @b(name = "url")
        String url;

        @b(name = "vers")
        String vers;

        public Firmware() {
        }

        public String getDesc() {
            return this.desc;
        }

        public String getDigest() {
            return this.digest;
        }

        public String getDigestAlg() {
            return this.digestAlg;
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

        public String getUrl() {
            return this.url;
        }

        public String getVers() {
            return this.vers;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setDigest(String str) {
            this.digest = str;
        }

        public void setDigestAlg(String str) {
            this.digestAlg = str;
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

        public void setUrl(String str) {
            this.url = str;
        }

        public void setVers(String str) {
            this.vers = str;
        }
    }

    public int getErrNo() {
        return this.errNo;
    }

    public Firmware getFirmware() {
        return this.firmware;
    }

    public String getModel() {
        return this.model;
    }

    public String getVers() {
        return this.vers;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setFirmware(Firmware firmware) {
        this.firmware = firmware;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setVers(String str) {
        this.vers = str;
    }
}
