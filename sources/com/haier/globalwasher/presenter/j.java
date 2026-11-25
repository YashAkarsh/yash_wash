package com.haier.globalwasher.presenter;

import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class j extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f25182d = "orderId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f25183e = "pageNumber";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f25184f = "orderType";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f25185g = "1";

    class a extends com.haier.globalwasher.modle.network.a<BaseListDate<OrderDetailsBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25186g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25186g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25186g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<OrderDetailsBeen> baseListDate) {
            this.f25186g.b(baseListDate);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25188g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25188g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25188g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25188g.b(baseData);
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25181c = baseActivity;
        return baseActivity;
    }

    public void g(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", "" + str);
        new b(bVar).g(1, this.f25181c, i2.a.f34085b1, i2.a.f34089c1, map, null, 1);
    }

    public void h(int i7, int i8, com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<OrderDetailsBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("pageNumber", i8 + "");
        map.put("orderType", "1");
        new a(bVar).j(i7, this.f25181c, i2.a.Z0, i2.a.f34081a1, map, OrderDetailsBeen.class, 2);
    }
}
