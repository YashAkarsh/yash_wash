package com.haier.uhome.control.base.json.req;

import com.alipay.sdk.data.a;
import g3.b;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasicOpReq extends BasicDeviceReq {

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "isGroup")
    private boolean isGroup;

    @b(name = "module")
    private String module;

    @b(name = "parentDevId")
    private String parentDevId;

    @b(name = "subdeviceList")
    private List<Integer> subdeviceList;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "traceId")
    private String traceId;

    public int getElementAddr() {
        return this.elementAddr;
    }

    public boolean getIsGroup() {
        return this.isGroup;
    }

    public String getModule() {
        return this.module;
    }

    public String getParentDevId() {
        return this.parentDevId;
    }

    public List<Integer> getSubdeviceList() {
        return this.subdeviceList;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setIsGroup(boolean z7) {
        this.isGroup = z7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setParentDevId(String str) {
        this.parentDevId = str;
    }

    public void setSubdeviceList(List<Integer> list) {
        this.subdeviceList = list;
    }

    public void setTimeout(int i7) {
        if (i7 > 120 || i7 < 5) {
            throw new IllegalArgumentException("BasicOpReq timeout is illegal");
        }
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BasicOpReq{");
        sb.append(super.toString());
        sb.append("module=");
        sb.append(this.module);
        sb.append(", traceId=");
        sb.append(this.traceId);
        sb.append(", timeout=");
        sb.append(this.timeout);
        sb.append(", subdeviceList=");
        List<Integer> list = this.subdeviceList;
        sb.append(list == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : list.toString());
        sb.append(", parentDevId=");
        sb.append(this.parentDevId);
        sb.append('}');
        return sb.toString();
    }
}
