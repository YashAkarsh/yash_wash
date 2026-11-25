package com.haier.uhome.control.base.json.notify;

import com.haier.uhome.control.base.handler.a;
import com.haier.uhome.control.base.json.KeyValueItem;
import com.haier.uhome.usdk.base.c.e;
import g3.b;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAlarmNotify extends BasicDeviceNotify {

    @b(name = "alarms")
    private List<KeyValueItem> alarms;

    @b(name = "elementAddr")
    private int elementAddr;

    @b(name = "subdeviceList")
    private List<Integer> subdeviceList;

    @b(name = "uniqueId")
    private long uniqueId;

    protected DeviceAlarmNotify() {
    }

    public List<KeyValueItem> getAlarms() {
        return this.alarms;
    }

    public int getElementAddr() {
        return this.elementAddr;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new a();
    }

    public List<Integer> getSubdeviceList() {
        return this.subdeviceList;
    }

    public long getUniqueId() {
        return this.uniqueId;
    }

    public void setAlarms(List<KeyValueItem> list) {
        this.alarms = list;
    }

    public void setElementAddr(int i7) {
        this.elementAddr = i7;
    }

    public void setSubdeviceList(List<Integer> list) {
        this.subdeviceList = list;
    }

    public void setUniqueId(long j7) {
        this.uniqueId = j7;
    }

    @Override // com.haier.uhome.control.base.json.notify.BasicDeviceNotify, com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceAlarmNotify{");
        sb.append(super.toString());
        sb.append(", alarms=");
        List<KeyValueItem> list = this.alarms;
        String string = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        sb.append(list == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : list.toString());
        sb.append(", subdeviceList=");
        List<Integer> list2 = this.subdeviceList;
        if (list2 != null) {
            string = list2.toString();
        }
        sb.append(string);
        sb.append(",uniqueId=");
        sb.append(this.uniqueId);
        sb.append('}');
        return sb.toString();
    }
}
