package com.haier.uhome.control.base.json.notify;

import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.haier.uhome.control.base.json.ProtocolConst;
import com.haier.uhome.usdk.base.c.e;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceStateNotify extends BasicDeviceNotify {

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "errNo")
    private int errNo;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private String state;

    protected DeviceStateNotify() {
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    public int getErrNo() {
        return this.errNo;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new com.haier.uhome.control.base.handler.e();
    }

    public String getState() {
        return this.state;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setState(String str) {
        if (TextUtils.isEmpty(str) || !str.matches(ProtocolConst.ONLINE_STATE_PATTERN)) {
            throw new IllegalArgumentException("Invalid device onlineState:" + str);
        }
        if (str.equals(ProtocolConst.ONLINE_STATE_CONNECT_FAILED)) {
            str = ProtocolConst.ONLINE_STATE_OFFLINE;
        }
        this.state = str;
        this.state = ProtocolConst.ONLINE_STATE_PREFIX + this.state;
    }

    @Override // com.haier.uhome.control.base.json.notify.BasicDeviceNotify, com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceStateNotify{" + super.toString() + ", state=" + this.state + ", errNo=" + this.errNo + '}';
    }
}
