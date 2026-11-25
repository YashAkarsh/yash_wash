package com.haier.uhome.control.base.handler;

import com.haier.library.common.util.u;
import com.haier.uhome.control.base.json.Event;
import com.haier.uhome.control.base.json.KeyValueItem;
import com.haier.uhome.control.base.json.notify.DeviceEventNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.uhome.usdk.base.c.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.haier.library.common.util.p<KeyValueItem, com.haier.uhome.control.base.api.d> f28983a = new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.base.handler.r
        @Override // com.haier.library.common.util.p
        public final Object transform(Object obj) {
            return d.a((KeyValueItem) obj);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.haier.library.common.util.p<Event, com.haier.uhome.control.base.api.e> f28984b = new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.base.handler.s
        @Override // com.haier.library.common.util.p
        public final Object transform(Object obj) {
            return this.f29012a.a((Event) obj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ com.haier.uhome.control.base.api.d a(KeyValueItem keyValueItem) {
        return new com.haier.uhome.control.base.api.d(keyValueItem.getName(), keyValueItem.getValue());
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        DeviceEventNotify deviceEventNotify = (DeviceEventNotify) basicNotify;
        e3.a.e("notify device %s event msg %s", deviceEventNotify.getDevId(), deviceEventNotify);
        ControlBaseNotifier.getInstance().notifyDevEventChange(deviceEventNotify.getModule(), deviceEventNotify.getDevId(), u.a(deviceEventNotify.getEvents(), this.f28984b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.haier.uhome.control.base.api.e a(Event event) {
        return new com.haier.uhome.control.base.api.e(event.getName(), event.getType(), u.a(event.getAttrs(), this.f28983a));
    }
}
