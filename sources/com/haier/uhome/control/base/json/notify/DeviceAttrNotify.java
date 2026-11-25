package com.haier.uhome.control.base.json.notify;

import com.haier.uhome.control.base.json.KeyValueItem;
import com.haier.uhome.usdk.base.c.e;
import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAttrNotify extends BasicDeviceNotify {

    @b(name = "attrs")
    private List<KeyValueItem> attrs;

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "subdeviceList")
    private List<Integer> subdeviceList;

    @b(name = "uniqueId")
    private String uniqueId;

    protected DeviceAttrNotify() {
    }

    public List<KeyValueItem> getAttrs() {
        return this.attrs;
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new com.haier.uhome.control.base.handler.b();
    }

    public List<Integer> getSubdeviceList() {
        return this.subdeviceList;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setAttrs(List<KeyValueItem> list) {
        this.attrs = list;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setSubdeviceList(List<Integer> list) {
        this.subdeviceList = list;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    @Override // com.haier.uhome.control.base.json.notify.BasicDeviceNotify, com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceAttrNotify{attrs=" + this.attrs + ", subdeviceList=" + this.subdeviceList + ", uniqueId='" + this.uniqueId + "', elementAddr=" + this.elementAddr + '}';
    }
}
