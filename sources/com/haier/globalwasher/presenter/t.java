package com.haier.globalwasher.presenter;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.ProfilePagePassBeen;
import com.haier.globalwasher.modle.bean.UpDataProfileBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.g0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class t extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25314g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25315h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f25316i = "pageType";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f25317j = "phoneNumber";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25318k = "type";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f25319l = "verifyCode";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25320m = "password";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f25321n = "3";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25322o = "5";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f25324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f25325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f25326f = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i7 = message.what;
            if (i7 != 0) {
                if (i7 != 2) {
                    return;
                }
                t.this.f25325e.setText(t.this.f25324d.getString(R.string.verify_the_machine_resed));
                t.this.f25325e.setEnabled(true);
                return;
            }
            int iIntValue = ((Integer) message.obj).intValue();
            t.this.f25325e.setText(iIntValue + "s");
            t.this.f25325e.setEnabled(false);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25328g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25328g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25328g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25328g.b(baseData);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25330g;

        c(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25330g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25330g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25330g.b(baseData);
        }
    }

    class d extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25332g;

        d(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25332g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25332g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25332g.b(baseData);
        }
    }

    class e extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25334g;

        e(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25334g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25334g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25334g.b(baseData);
        }
    }

    class f extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25336g;

        f(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25336g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25336g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25336g.b(baseData);
        }
    }

    class g extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25338g;

        g(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25338g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25338g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25338g.b(baseData);
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25323c = baseActivity;
        this.f25324d = baseActivity.getResources();
        return baseActivity;
    }

    public void i(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<ProfilePagePassBeen>> bVar) {
        BaseListDate<ProfilePagePassBeen> baseListDate = new BaseListDate<>();
        baseListDate.setRetCode("00000");
        ArrayList<ProfilePagePassBeen> arrayList = new ArrayList<>();
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.up_data_new_email), "", "", 0));
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.up_data_verification_code), "", this.f25324d.getString(R.string.up_data_Send), 1));
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }

    public void j(int i7, com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<UpDataProfileBeen>> bVar) {
        BaseListDate<UpDataProfileBeen> baseListDate = new BaseListDate<>();
        baseListDate.setRetCode("00000");
        ArrayList<UpDataProfileBeen> arrayList = new ArrayList<>();
        if (i7 == 2) {
            String strA = t2.a.a(this.f25323c, t2.a.f40354a, t2.a.f40359f);
            if (strA == null) {
                strA = "";
            }
            arrayList.add(new UpDataProfileBeen("", strA, 0, ""));
        } else {
            arrayList.add(new UpDataProfileBeen(this.f25324d.getString(R.string.change_password_old), "", 0, ""));
            arrayList.add(new UpDataProfileBeen(this.f25324d.getString(R.string.change_password_new), "", 1, ""));
        }
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }

    public void k(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<ProfilePagePassBeen>> bVar) {
        BaseListDate<ProfilePagePassBeen> baseListDate = new BaseListDate<>();
        baseListDate.setRetCode("00000");
        ArrayList<ProfilePagePassBeen> arrayList = new ArrayList<>();
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.up_data_current_email), ProfileAvatarImageBeen.getInstance().getDesensitizationMailNumber(), "", 0));
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.up_data_new_email), "", "", 1));
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.up_data_verification_code), "", this.f25324d.getString(R.string.up_data_Send), 2));
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }

    public void l(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<ProfilePagePassBeen>> bVar) {
        BaseListDate<ProfilePagePassBeen> baseListDate = new BaseListDate<>();
        baseListDate.setRetCode("00000");
        ArrayList<ProfilePagePassBeen> arrayList = new ArrayList<>();
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.change_name_phone_number), ProfileAvatarImageBeen.getInstance().getPhoneNumber(), "", 0));
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.change_name_phone_Enter), "", this.f25324d.getString(R.string.change_name_code), 1));
        arrayList.add(new ProfilePagePassBeen(this.f25324d.getString(R.string.change_password_new), "", "", 2));
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }

    public void m(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        if (d0.j(str)) {
            map.put("email", "" + str);
        }
        new g(bVar).g(1, this.f25323c, i2.a.f34103h0, i2.a.f34106i0, map, null, 1);
    }

    public void n(String str, String str2, String str3, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("phoneNumber", "" + str);
        map.put("password", "" + str2);
        map.put("verifyCode", "" + str3);
        new e(bVar).g(1, this.f25323c, i2.a.f34127p0, i2.a.f34130q0, map, null, 1);
    }

    public void o(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        p(str, str2, "", bVar);
    }

    public void p(String str, String str2, String str3, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        if (d0.j(str)) {
            map.put("phoneNumber", "" + str);
        }
        map.put("type", "" + str2);
        if (d0.j(str3)) {
            map.put("email", "" + str3);
        }
        new d(bVar).g(1, this.f25323c, i2.a.f34097f0, i2.a.f34100g0, map, null, 1);
    }

    public void q(FontTextView fontTextView, int i7) {
        this.f25325e = fontTextView;
        fontTextView.setEnabled(false);
        new g0(this.f25326f, i7).d();
    }

    public void r(String str, String str2, String str3, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        if (d0.j(str)) {
            map.put("oldEmail", "" + str);
        }
        if (d0.j(str2)) {
            map.put("newEmail", "" + str2);
        }
        map.put("verifyCode", "" + str3);
        new f(bVar).g(1, this.f25323c, i2.a.f34133r0, i2.a.f34136s0, map, null, 1);
    }

    public void s(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put(com.haier.globalwasher.presenter.e.f25112q, str);
        new b(bVar).g(1, this.f25323c, i2.a.f34151x0, i2.a.f34154y0, map, null, 1);
    }

    public void t(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("oldPassword", str);
        map.put("newPassword", str2);
        new c(bVar).g(1, this.f25323c, i2.a.f34148w0, "user.updatePwd", map, null, 1);
    }
}
