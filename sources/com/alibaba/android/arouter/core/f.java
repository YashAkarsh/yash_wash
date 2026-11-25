package com.alibaba.android.arouter.core;

import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Map<String, Class<? extends IRouteGroup>> f12454a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Map<String, RouteMeta> f12455b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static Map<Class, IProvider> f12456c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static Map<String, RouteMeta> f12457d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static Map<Integer, Class<? extends IInterceptor>> f12458e = new b0.a("More than one interceptors use same priority [%s]");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static List<IInterceptor> f12459f = new ArrayList();

    f() {
    }

    static void a() {
        f12455b.clear();
        f12454a.clear();
        f12456c.clear();
        f12457d.clear();
        f12459f.clear();
        f12458e.clear();
    }
}
