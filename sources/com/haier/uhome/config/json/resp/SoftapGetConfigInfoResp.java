package com.haier.uhome.config.json.resp;

import com.haier.uhome.config.json.ApInfo;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class SoftapGetConfigInfoResp extends BasicResp {

    @b(name = "apList")
    private ArrayList<ApInfo> apList;

    @b(name = "capability")
    private int capability;

    @b(name = "devId")
    private String devId;

    @b(name = "eProtocolVer")
    private String eProtocolVer;

    @b(name = TraceProtocolConst.PRO_IP)
    private String ip;

    @b(name = "mode")
    private int mode;

    @b(name = "reason")
    private int reason;

    @b(name = "softapConfigMode")
    private int softapConfigMode;

    @b(name = "uplusId")
    private String uplusId;

    public ArrayList<ApInfo> getApList() {
        return this.apList;
    }

    public int getCapability() {
        return this.capability;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getIp() {
        return this.ip;
    }

    public int getMode() {
        return this.mode;
    }

    public int getSoftapConfigMode() {
        return this.softapConfigMode;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public String geteProtocolVer() {
        return this.eProtocolVer;
    }

    public void setApList(ArrayList<ApInfo> arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("apList should not be null");
        }
        this.apList = arrayList;
    }

    public void setCapability(int i7) {
        this.capability = i7;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setMode(int i7) {
        this.mode = i7;
    }

    public void setSoftapConfigMode(int i7) {
        this.softapConfigMode = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    public void seteProtocolVer(String str) {
        this.eProtocolVer = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SoftapGetConfigInfoResp{sn=");
        sb.append(getSn());
        sb.append(", errNo=");
        sb.append(getErrNo());
        sb.append(", mode=");
        sb.append(this.mode);
        sb.append(", softapConfigMode=");
        sb.append(this.softapConfigMode);
        sb.append(", reason=");
        sb.append(this.reason);
        sb.append(", uplusId=");
        sb.append(this.uplusId);
        sb.append(", devId=");
        sb.append(this.devId);
        sb.append(", ip=");
        sb.append(this.ip);
        sb.append(", eProtocolVer=");
        sb.append(this.eProtocolVer);
        sb.append(", apList=");
        ArrayList<ApInfo> arrayList = this.apList;
        sb.append(arrayList == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : arrayList.toString());
        sb.append(", capability=");
        sb.append(this.capability);
        sb.append('}');
        return sb.toString();
    }
}
