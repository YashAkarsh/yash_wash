package com.haier.globalwasher.presenter;

import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.AnalysisURLBeen;
import com.haier.globalwasher.modle.bean.DeviceDetailBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.haier.globalwasher.mvp_api.presenter.b<BaseActivity> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseActivity f25054b;

    /* JADX INFO: renamed from: com.haier.globalwasher.presenter.a$a, reason: collision with other inner class name */
    class C0328a extends com.haier.globalwasher.modle.network.a<BaseData<DeviceDetailBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25055g;

        C0328a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25055g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25055g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<DeviceDetailBeen> baseData) {
            this.f25055g.b(baseData);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData<AnalysisURLBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25057g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25057g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25057g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<AnalysisURLBeen> baseData) {
            this.f25057g.b(baseData);
        }
    }

    public void b(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData<AnalysisURLBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("url", str);
        new b(bVar).j(0, this.f25054b, i2.a.E1, i2.a.F1, map, AnalysisURLBeen.class, 1);
    }

    public void c(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData<DeviceDetailBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("deviceQRCode", str);
        new C0328a(bVar).j(1, this.f25054b, i2.a.N0, i2.a.O0, map, DeviceDetailBeen.class, 1);
    }

    @Override // com.haier.globalwasher.mvp_api.presenter.b
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(BaseActivity baseActivity) {
        this.f25054b = baseActivity;
    }
}
