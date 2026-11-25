package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.alipay.sdk.data.a;
import com.haier.uhome.smart.handler.DeviceOpNotifyHandler;
import com.haier.uhome.smart.json.Pair;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceOpNotify extends BasicNotify {

    @b(name = TraceProtocolConst.PRO_ARGS)
    private ArrayList<Pair> args;

    @b(name = "devId")
    private String devId;

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "isGroup")
    private boolean isGroup;

    @b(name = "len")
    private int len;

    @b(name = "module")
    private String module;

    @b(name = "op")
    private String op;

    @b(name = "parentDevId")
    private String parentDevId;

    @b(name = "sn")
    private int sn;

    @b(name = "subdeviceList")
    private String subdeviceList;

    @b(name = a.f13674p)
    private int timeout;

    @b(name = "traceId")
    private String traceId;

    public ArrayList<Pair> getArgs() {
        return this.args;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    public int getFrom() {
        return this.from;
    }

    public int getLen() {
        return this.len;
    }

    public String getModule() {
        return this.module;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceOpNotifyHandler();
    }

    public String getOp() {
        return this.op;
    }

    public String getParentDevId() {
        return this.parentDevId;
    }

    public int getSn() {
        return this.sn;
    }

    public String getSubdeviceList() {
        return this.subdeviceList;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public boolean isGroup() {
        return this.isGroup;
    }

    public void setArgs(ArrayList<Pair> arrayList) {
        this.args = arrayList;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setGroup(boolean z7) {
        this.isGroup = z7;
    }

    public void setLen(int i7) {
        this.len = i7;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setOp(String str) {
        this.op = str;
    }

    public void setParentDevId(String str) {
        this.parentDevId = str;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public void setSubdeviceList(String str) {
        this.subdeviceList = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceOpNotify{devId='" + this.devId + "', sn=" + this.sn + ", op='" + this.op + "', args=" + this.args + ", len=" + this.len + ", from=" + this.from + ", elementAddr=" + this.elementAddr + ", isGroup=" + this.isGroup + ", module='" + this.module + "', parentDevId='" + this.parentDevId + "', subdeviceList='" + this.subdeviceList + "', timeout=" + this.timeout + ", traceId='" + this.traceId + "'}";
    }
}
