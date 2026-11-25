package com.alibaba.android.arouter.core;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Route(path = "/arouter/service/autowired")
public class b implements AutowiredService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LruCache<String, ISyringe> f12438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f12439c;

    @Override // com.alibaba.android.arouter.facade.service.AutowiredService
    public void autowire(Object obj) {
        String name = obj.getClass().getName();
        try {
            if (this.f12439c.contains(name)) {
                return;
            }
            ISyringe iSyringe = this.f12438b.get(name);
            if (iSyringe == null) {
                iSyringe = (ISyringe) Class.forName(obj.getClass().getName() + "$$ARouter$$Autowired").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            iSyringe.inject(obj);
            this.f12438b.put(name, iSyringe);
        } catch (Exception unused) {
            this.f12439c.add(name);
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        this.f12438b = new LruCache<>(66);
        this.f12439c = new ArrayList();
    }
}
