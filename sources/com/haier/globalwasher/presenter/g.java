package com.haier.globalwasher.presenter;

import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.DeviceListBeen;
import com.haier.globalwasher.modle.bean.LaundryInfo;
import com.haier.globalwasher.modle.bean.LaundryRealted;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class g extends w2.a<com.haier.globalwasher.mvp_api.view.a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25144k = "id";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f25145l = "1";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25146m = "3";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f25147n = "2";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25148o = "laundry_list";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25149p = "laundry";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f25151d = "longitude";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f25152e = "latitude";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f25153f = "businessId";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f25154g = "distance";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f25155h = "pageNumber";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f25156i = "type";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f25157j = "RequestNetWork";

    class a extends com.haier.globalwasher.modle.network.a<BaseListDate<LaundryRealted>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25158g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25158g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25158g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<LaundryRealted> baseListDate) {
            com.haier.globalwasher.modle.utils.q.a("LaundryRealted", "" + baseListDate);
            this.f25158g.b(baseListDate);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseListDate<DeviceListBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25160g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25160g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25160g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<DeviceListBeen> baseListDate) {
            this.f25160g.b(baseListDate);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData<LaundryInfo>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25162g;

        c(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25162g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25162g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<LaundryInfo> baseData) {
            this.f25162g.b(baseData);
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25150c = baseActivity;
        return baseActivity;
    }

    public void g(String str, String str2, int i7, String str3, com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<DeviceListBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("laundryId", str + "");
        map.put("type", str2 + "");
        map.put("pageNumber", i7 + "");
        if (!"0".equals(str3) && !"".equals(str3) && str3 != null && !"ALL".equals(str3)) {
            map.put("floorNumber", str3 + "");
        }
        com.haier.globalwasher.modle.utils.q.c(this.f25157j, "laundryId=" + str + "type" + str2 + "pageNumber" + i7 + "---floorNumber=0");
        new b(bVar).j(0, this.f25150c, i2.a.L0, i2.a.M0, map, DeviceListBeen.class, 2);
    }

    public void h(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData<LaundryInfo>> bVar) {
        HashMap map = new HashMap();
        map.put("laundryId", str + "");
        map.put("type", str2 + "");
        new c(bVar).j(0, this.f25150c, i2.a.J0, i2.a.K0, map, LaundryInfo.class, 1);
    }

    public void i(int i7, int i8, double d8, double d9, int i9, String str, com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<LaundryRealted>> bVar) {
        HashMap map = new HashMap();
        map.put("longitude", d8 + "");
        map.put("latitude", d9 + "");
        map.put("distance", i9 + "");
        map.put("type", str + "");
        map.put("pageNumber", i8 + "");
        new a(bVar).j(i7, this.f25150c, i2.a.H0, i2.a.I0, map, LaundryRealted.class, 2);
    }
}
