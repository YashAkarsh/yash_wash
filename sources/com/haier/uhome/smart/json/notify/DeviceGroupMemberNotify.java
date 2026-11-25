package com.haier.uhome.smart.json.notify;

import androidx.core.app.l2;
import com.haier.uhome.smart.handler.DeviceGroupMemberNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGroupMemberNotify extends BasicNotify {

    @b(name = l2.f5226y0)
    private int errNo;

    @b(name = "groupId")
    private String groupId;

    @b(name = "devidArray")
    private ArrayList<String> memberList;

    public int getErrNo() {
        return this.errNo;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public ArrayList<String> getMemberList() {
        return this.memberList;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceGroupMemberNotifyHandler();
    }

    public void setErrNo(int i7) {
        this.errNo = i7;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setMemberList(ArrayList<String> arrayList) {
        this.memberList = arrayList;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceGroupMemberNotify{groupId='" + this.groupId + "', errNo=" + this.errNo + ", memberList=" + this.memberList + '}';
    }
}
