package com.haier.uhome.control.base.json.notify;

import com.haier.uhome.control.base.handler.d;
import com.haier.uhome.control.base.json.Event;
import com.haier.uhome.usdk.base.c.e;
import g3.b;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceEventNotify extends BasicDeviceNotify {

    @b(name = "events")
    private List<Event> events;

    public List<Event> getEvents() {
        return this.events;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new d();
    }

    public void setEvents(List<Event> list) {
        this.events = list;
    }

    @Override // com.haier.uhome.control.base.json.notify.BasicDeviceNotify, com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceEventNotify{events=" + this.events + '}';
    }
}
