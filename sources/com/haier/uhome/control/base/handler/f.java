package com.haier.uhome.control.base.handler;

import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.control.base.json.entity.DeviceBleAdvEpp;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface f {
    void a(RouterSsidPasswordEvent routerSsidPasswordEvent);

    void a(DeviceBleAdvEpp deviceBleAdvEpp);

    void a(String str, String str2, int i7, DeviceStatus deviceStatus, int i8);

    void a(String str, String str2, int i7, List<Integer> list, List<com.haier.uhome.control.base.api.b> list2);

    void a(String str, String str2, List<com.haier.uhome.control.base.api.e> list);

    void b(String str, String str2, int i7, List<Integer> list, List<com.haier.uhome.control.base.api.d> list2);
}
