package com.haier.uhome.control.base.api;

import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface i extends Serializable {
    void a(RouterSsidPasswordEvent routerSsidPasswordEvent);

    void a(String str, String str2, DeviceStatus deviceStatus, int i7);

    void a(String str, HashMap<String, d> map);

    void a(String str, List<e> list);

    void b(String str, List<b> list);

    void c(String str, List<a> list);
}
