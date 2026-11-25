package com.haier.globalwasher.presenter;

import android.app.Activity;
import android.content.Intent;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.AppAdInfo;
import com.haier.globalwasher.modle.utils.n0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.view.activity.MainActivity;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class r implements com.haier.globalwasher.mvp_api.presenter.b<BaseActivity> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseActivity f25298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f25299c = "type";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f25300d = "5";

    class a extends com.haier.globalwasher.modle.network.a<BaseData<AppAdInfo>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25301g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25301g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25301g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<AppAdInfo> baseData) {
            this.f25301g.b(baseData);
        }
    }

    public void b(com.haier.globalwasher.mvp_api.moudle.b<BaseData<AppAdInfo>> bVar) {
        HashMap map = new HashMap();
        map.put("type", n0.f(this.f25298b) + "");
        new a(bVar).j(0, this.f25298b, i2.a.T0, i2.a.U0, map, AppAdInfo.class, 1);
    }

    @Override // com.haier.globalwasher.mvp_api.presenter.b
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(BaseActivity baseActivity) {
        this.f25298b = baseActivity;
    }

    public void d(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) MainActivity.class));
        activity.finish();
    }
}
