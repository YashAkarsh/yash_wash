package com.haier.globalwasher.presenter;

import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.DeviceDetailBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.activity.device.DeviceBaseActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class x extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f25389d = "1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f25390e = "2";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f25391f = "3";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f25392g = "RequestNetWork";

    class a extends com.haier.globalwasher.modle.network.a<BaseData<DeviceDetailBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DeviceBaseActivity.k f25393g;

        a(DeviceBaseActivity.k kVar) {
            this.f25393g = kVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25393g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<DeviceDetailBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || baseData.getData() == null) {
                return;
            }
            this.f25393g.h(baseData);
            BaseListDate baseListDate = new BaseListDate();
            baseListDate.setRetCode("00000");
            baseListDate.setRetInfo(baseData.getRetInfo());
            ArrayList arrayList = new ArrayList();
            if (baseData.getData().getRunMode() == null || baseData.getData().getRunMode().size() <= 0) {
                return;
            }
            for (int i7 = 0; i7 < baseData.getData().getRunMode().size(); i7++) {
                if ("T".equals(baseData.getData().getRunMode().get(i7).getIsDisply())) {
                    arrayList.add(baseData.getData().getRunMode().get(i7));
                }
            }
            baseListDate.setData(arrayList);
            this.f25393g.b(baseListDate);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f25396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f25397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f25398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f25399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25400f;

        class a extends com.haier.globalwasher.modle.network.a<BaseData<OrderDetailsBeen>> {
            a() {
            }

            @Override // com.haier.globalwasher.modle.network.a
            public void i(Exception exc) {
                b.this.f25400f.a(exc);
            }

            @Override // com.haier.globalwasher.modle.network.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public void p(BaseData<OrderDetailsBeen> baseData) {
                if ("00000".equals(baseData.getRetCode())) {
                    b.this.f25400f.b(baseData);
                    return;
                }
                i0.d(x.this.f25388c, "" + baseData.getRetInfo());
            }
        }

        b(String str, String str2, int i7, String str3, String str4, com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25395a = str;
            this.f25396b = str2;
            this.f25397c = i7;
            this.f25398d = str3;
            this.f25399e = str4;
            this.f25400f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap map = new HashMap();
            map.put(o.f25218y, this.f25395a);
            map.put("runCount", "1");
            map.put("modeId", this.f25396b);
            map.put("isRq", this.f25397c + "");
            map.put("orderesource", "1");
            map.put("runCount", this.f25398d);
            if (d0.j(this.f25399e)) {
                map.put("orderDeviType", this.f25399e);
            }
            new a().g(1, x.this.f25388c, i2.a.V0, i2.a.W0, map, OrderDetailsBeen.class, 1);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData<OrderDetailsBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25403g;

        c(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25403g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25403g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<OrderDetailsBeen> baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                this.f25403g.b(baseData);
                return;
            }
            com.haier.globalwasher.modle.utils.q.c("RequestNetWork", baseData.getRetCode());
            i0.d(x.this.f25388c, "" + baseData.getRetInfo());
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25388c = baseActivity;
        return baseActivity;
    }

    public void h(int i7, String str, String str2, String str3, String str4, com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderDetailsBeen>> bVar) {
        BaseActivity baseActivity = this.f25388c;
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        this.f25388c.runOnUiThread(new b(str, str2, i7, str3, str4, bVar));
    }

    public void i(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderDetailsBeen>> bVar) {
        HashMap map = new HashMap();
        map.put(o.f25218y, str);
        map.put("modeId", str2);
        map.put("orderesource", "1");
        new c(bVar).g(1, this.f25388c, i2.a.X0, i2.a.Y0, map, OrderDetailsBeen.class, 1);
    }

    public void j(int i7, String str, String str2, DeviceBaseActivity.k kVar) {
        HashMap map = new HashMap();
        if (str != null && !"".equals(str)) {
            map.put(o.f25218y, str);
        } else if (str2 != null && !"".equals(str2)) {
            map.put("deviceQRCode", str2);
        }
        if (map.size() == 0) {
            kVar.a(new Exception(this.f25388c.getResources().getString(R.string.data_loss)));
        } else {
            new a(kVar).j(i7, this.f25388c, i2.a.N0, i2.a.O0, map, DeviceDetailBeen.class, 1);
        }
    }
}
