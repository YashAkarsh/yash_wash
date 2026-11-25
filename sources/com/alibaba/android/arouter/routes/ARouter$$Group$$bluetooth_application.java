package com.alibaba.android.arouter.routes;

import a3.a;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Group$$bluetooth_application implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(a.f33a, RouteMeta.build(RouteType.PROVIDER, r3.a.class, "/bluetooth_application/bluetoothofabroadwasherapp", "bluetooth_application", null, -1, Integer.MIN_VALUE));
    }
}
