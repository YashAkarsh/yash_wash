package com.haier.globalwasher.presenter.authentication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.DefaultPageBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.activity.MainActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25059e = "verifyCode";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25060f = "phoneNumber";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25061g = "type";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Resources f25062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BaseActivity f25063d;

    /* JADX INFO: renamed from: com.haier.globalwasher.presenter.authentication.a$a, reason: collision with other inner class name */
    class C0329a extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25064g;

        C0329a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25064g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25064g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25064g.b(baseData);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25066g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25066g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25066g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25066g.b(baseData);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25068g;

        c(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25068g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25068g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25068g.b(baseData);
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25062c = baseActivity.getResources();
        this.f25063d = baseActivity;
        return baseActivity;
    }

    public void g(com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        new c(bVar).g(1, this.f25063d, i2.a.N1, i2.a.O1, new HashMap(), null, 1);
    }

    public void h(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<DefaultPageBeen>> bVar) {
        BaseListDate<DefaultPageBeen> baseListDate = new BaseListDate<>();
        baseListDate.setRetCode("00000");
        ArrayList<DefaultPageBeen> arrayList = new ArrayList<>();
        arrayList.add(new DefaultPageBeen(this.f25062c.getString(R.string.authentication_center_phone_number), d0.d(t2.a.a(this.f25063d, t2.a.f40354a, t2.a.f40357d)), "", 0));
        arrayList.add(new DefaultPageBeen(this.f25062c.getString(R.string.authentication_center_verification_code), "", "", 1));
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }

    public void i(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("phoneNumber", "" + str);
        map.put("type", "" + str2);
        new C0329a(bVar).g(1, this.f25063d, i2.a.f34097f0, i2.a.f34100g0, map, null, 1);
    }

    public void j() {
        Intent intent = new Intent(i2.a.f34126p);
        intent.putExtra(y.f25405c, new Bundle());
        this.f25063d.sendBroadcast(intent);
        MainActivity.w0(this.f25063d, 1);
        this.f25063d.finish();
    }

    public void k(String str, String str2, String str3, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("phoneNumber", "" + str);
        map.put("type", "" + str2);
        map.put("verifyCode", "" + str3);
        new b(bVar).g(1, this.f25063d, i2.a.f34109j0, i2.a.f34112k0, map, null, 1);
    }
}
