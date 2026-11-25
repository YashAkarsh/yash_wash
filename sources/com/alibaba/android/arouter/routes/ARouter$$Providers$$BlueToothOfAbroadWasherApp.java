package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import java.util.Map;
import r3.a;

/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$BlueToothOfAbroadWasherApp implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.haier.hailicommontlib.mvp.model.interfaces.IBaseApplication", RouteMeta.build(RouteType.PROVIDER, a.class, a3.a.f33a, "bluetooth_application", null, -1, Integer.MIN_VALUE));
    }
}
