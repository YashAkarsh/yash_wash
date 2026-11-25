package com.haier.uhome.control.local.d;

import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.handler.t;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.control.base.json.entity.DeviceBleAdvEpp;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements com.haier.uhome.control.base.handler.f {
    @Override // com.haier.uhome.control.base.handler.f
    public /* synthetic */ void a(RouterSsidPasswordEvent routerSsidPasswordEvent) {
        t.a(this, routerSsidPasswordEvent);
    }

    @Override // com.haier.uhome.control.base.handler.f
    public void b(String str, String str2, int i7, List<Integer> list, List<com.haier.uhome.control.base.api.d> list2) {
    }

    @Override // com.haier.uhome.control.base.handler.f
    public /* synthetic */ void a(DeviceBleAdvEpp deviceBleAdvEpp) {
        t.b(this, deviceBleAdvEpp);
    }

    @Override // com.haier.uhome.control.base.handler.f
    public void a(String str, String str2, int i7, DeviceStatus deviceStatus, int i8) {
    }

    @Override // com.haier.uhome.control.base.handler.f
    public void a(String str, String str2, int i7, List<Integer> list, List<com.haier.uhome.control.base.api.b> list2) {
    }

    @Override // com.haier.uhome.control.base.handler.f
    public void a(String str, String str2, List<com.haier.uhome.control.base.api.e> list) {
    }
}
