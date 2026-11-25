package com.haier.globalwasher.presenter;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import c.t0;
import com.alipay.sdk.app.PayTask;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.ClearBucketBeen;
import com.haier.globalwasher.modle.bean.CouponPageBeen;
import com.haier.globalwasher.modle.bean.discount.CounponSelectReturnBean;
import com.haier.globalwasher.modle.bean.discount.DisCountInfo;
import com.haier.globalwasher.modle.bean.pay.PasTmResultBeen;
import com.haier.globalwasher.modle.bean.pay.PayListBeen;
import com.haier.globalwasher.modle.bean.pay.PayResult;
import com.haier.globalwasher.modle.bean.pay.PayTMParamentBean;
import com.haier.globalwasher.modle.bean.pay.PrePayBean;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.mvp_api.moudle.BaseBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o extends w2.a<BaseActivity> {
    public static final String A = "couponType";
    public static final int B = 1;
    public static final String C = "OrderDetailsBeen";
    public static final String D = "fromPage";
    public static final int E = 1;
    public static final int F = 2;
    public static final String G = "CouponPageBeen";
    public static final String H = "deviceType";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f25213t = "payType";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f25214u = "type";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f25215v = "orderId";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f25216w = "price";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f25217x = "orderCode";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f25218y = "deviceId";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f25219z = "couponId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f25221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f25222e = com.paytm.pgsdk.d.f33005h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f25223f = com.paytm.pgsdk.d.f33003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f25224g = com.paytm.pgsdk.d.f33001d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f25225h = com.paytm.pgsdk.d.f33002e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f25226i = "MID";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f25227j = com.paytm.pgsdk.d.f33000c;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f25228k = com.paytm.pgsdk.d.f33004g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f25229l = com.paytm.pgsdk.d.f33006i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f25230m = com.paytm.pgsdk.d.f32998a;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f25231n = 100;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final String f25232o = "TXN_SUCCESS";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final String f25233p = "TXN_FAILURE";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final String f25234q = "PENDING";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f25235r = "PayPresenter";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    com.haier.globalwasher.modle.utils.v f25236s;

    class a extends com.haier.globalwasher.modle.network.a<BaseData<CounponSelectReturnBean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25237g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25237g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25237g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<CounponSelectReturnBean> baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                this.f25237g.b(baseData);
            }
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseListDate<PayListBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25239g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25239g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25239g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<PayListBeen> baseListDate) {
            this.f25239g.b(baseListDate);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData<ClearBucketBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25241g;

        c(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25241g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25241g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<ClearBucketBeen> baseData) {
            this.f25241g.b(baseData);
        }
    }

    class d extends com.haier.globalwasher.modle.network.a<BaseListDate<CouponPageBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ BaseListActivity.a f25243g;

        d(BaseListActivity.a aVar) {
            this.f25243g = aVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25243g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<CouponPageBeen> baseListDate) {
            this.f25243g.b(baseListDate);
        }
    }

    class e extends com.haier.globalwasher.modle.network.a<BaseBeen> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25245g;

        e(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25245g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            com.haier.globalwasher.modle.utils.q.c("GsonRequest", "00009090988000-------");
            this.f25245g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseBeen baseBeen) {
            com.haier.globalwasher.modle.utils.q.c("GsonRequest", "----" + baseBeen.toString());
            this.f25245g.b(baseBeen);
        }
    }

    class f implements com.paytm.pgsdk.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m2.a f25247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f25248b;

        f(m2.a aVar, String str) {
            this.f25247a = aVar;
            this.f25248b = str;
        }

        @Override // com.paytm.pgsdk.l
        public void a() {
            this.f25247a.e("Cancel PayTm payment");
        }

        @Override // com.paytm.pgsdk.l
        public void b(String str) {
            com.haier.globalwasher.modle.utils.q.c("PayPresenter", "someUIErrorOccurred=" + str);
            this.f25247a.a(new Exception(str));
        }

        @Override // com.paytm.pgsdk.l
        public void c(String str) {
            com.haier.globalwasher.modle.utils.q.a("PayPresenter", "onErrorProceed " + str);
        }

        @Override // com.paytm.pgsdk.l
        public void d() {
            i0.d(o.this.f25220c, o.this.f25220c.getResources().getString(R.string.barrels_of_not_net_work));
        }

        @Override // com.paytm.pgsdk.l
        public void e(int i7, String str, String str2) {
            com.haier.globalwasher.modle.utils.q.c("PayPresenter", "onErrorLoadingWebPage=iniErrorCode=" + i7 + "  inErrorMessage=" + str + "  inFailingUrl=" + str2);
            this.f25247a.a(new Exception(str));
        }

        @Override // com.paytm.pgsdk.l
        public void f(String str, Bundle bundle) {
            this.f25247a.e(str);
        }

        @Override // com.paytm.pgsdk.l
        public void g(String str) {
            com.haier.globalwasher.modle.utils.q.c("PayPresenter", "clientAuthenticationFailed=" + str);
            this.f25247a.a(new Exception(str));
        }

        @Override // com.paytm.pgsdk.l
        @t0(api = 26)
        public void h(Bundle bundle) {
            o.this.w(this.f25248b, bundle, this.f25247a);
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ m2.a f25251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f25252c;

        g(String str, m2.a aVar, String str2) {
            this.f25250a = str;
            this.f25251b = aVar;
            this.f25252c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            PayResult payResult = new PayResult(this.f25250a);
            com.haier.globalwasher.modle.utils.q.c("PayPresenter", "" + payResult.toString());
            if (TextUtils.equals(payResult.getResultStatus(), "6001")) {
                this.f25251b.e(o.this.f25220c.getResources().getString(R.string.alipay_cancel));
            } else {
                o.this.z(com.haier.globalwasher.modle.enum_.f.ALIPAY.b(), this.f25252c, this.f25251b);
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i0.d(o.this.f25220c, "Alipay error");
        }
    }

    class i extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ m2.a f25255g;

        i(m2.a aVar) {
            this.f25255g = aVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25255g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                this.f25255g.b(baseData);
            } else {
                this.f25255g.d(baseData);
            }
        }
    }

    class j extends com.haier.globalwasher.modle.network.a<BaseData<PrePayBean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f25257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ m2.a f25258h;

        j(String str, m2.a aVar) {
            this.f25257g = str;
            this.f25258h = aVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25258h.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<PrePayBean> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || baseData.getData() == null) {
                if (i2.a.f34132r.equals(baseData.getRetCode())) {
                    this.f25258h.b(baseData);
                    return;
                } else {
                    this.f25258h.d(baseData);
                    return;
                }
            }
            PayTMParamentBean prepayInfo = baseData.getData().getPrepayInfo();
            if ("1".equals(baseData.getData().getIsPayZero())) {
                o.this.z(baseData.getData().getPayType(), this.f25257g, this.f25258h);
                return;
            }
            if ("1".equals(baseData.getData().getPayType())) {
                if (prepayInfo != null) {
                    o.this.t(this.f25257g, prepayInfo, this.f25258h);
                    return;
                } else {
                    i0.d(o.this.f25220c, "API ERROR :PayTMParamentBean IS NULL");
                    return;
                }
            }
            if ("3".equals(baseData.getData().getPayType())) {
                if (!d0.j(prepayInfo)) {
                    i0.d(o.this.f25220c, "API ERROR :prepayInfo IS NULL");
                    return;
                } else {
                    com.haier.globalwasher.modle.utils.q.c("PayPresenter", "payTMParamentBean zfb 3");
                    o.this.k(this.f25257g, prepayInfo.getBody(), this.f25258h);
                    return;
                }
            }
            i0.d(o.this.f25220c, "未知支付类型：" + baseData.getRetInfo());
        }
    }

    private String m(ArrayList<DisCountInfo> arrayList) {
        return new com.google.gson.f().z(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str, m2.a aVar, String str2) {
        try {
            com.haier.globalwasher.modle.utils.q.c("PayPresenter", "Runnable");
            String strPay = new PayTask(this.f25220c).pay(str, true);
            com.haier.globalwasher.modle.utils.q.c("PayPresenter", "result  =" + strPay);
            this.f25220c.runOnUiThread(new g(strPay, aVar, str2));
        } catch (Exception e8) {
            com.haier.globalwasher.modle.utils.q.c("PayPresenter", "Exception e=" + e8.toString());
            this.f25220c.runOnUiThread(new h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(final m2.a aVar, final String str, final String str2, View view) {
        aVar.c(com.haier.globalwasher.modle.enum_.f.PAYTM.b());
        new Thread(new Runnable() { // from class: com.haier.globalwasher.presenter.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f25205a.q(str, aVar, str2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(m2.a aVar, PayTMParamentBean payTMParamentBean, String str, View view) {
        aVar.c(com.haier.globalwasher.modle.enum_.f.PAYTM.b());
        try {
            com.paytm.pgsdk.s sVar = new com.paytm.pgsdk.s(new com.paytm.pgsdk.i(payTMParamentBean.getORDER_ID(), payTMParamentBean.getMID(), payTMParamentBean.getTXN_TOKEN(), payTMParamentBean.getTXN_AMOUNT(), payTMParamentBean.getCALLBACK_URL()), new f(aVar, str));
            if (!MyApplication.f24258n) {
                sVar.v("https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage");
            }
            sVar.z(this.f25220c, this.f25231n);
        } catch (Exception unused) {
            i0.d(this.f25220c, "param error");
        }
    }

    public void A(String str, DisCountInfo disCountInfo, com.haier.globalwasher.mvp_api.moudle.b<BaseData<CounponSelectReturnBean>> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str);
        if (!disCountInfo.getPreferValueId().equals("0")) {
            map.put(A, disCountInfo.getPreferType());
            map.put(f25219z, disCountInfo.getPreferValueId());
        }
        new a(bVar).g(1, this.f25220c, i2.a.Z1, i2.a.f34082a2, map, CounponSelectReturnBean.class, 1);
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25220c = baseActivity;
        this.f25221d = baseActivity.getResources();
        return baseActivity;
    }

    public void k(final String str, final String str2, final m2.a aVar) {
        com.haier.globalwasher.modle.utils.q.c("PayPresenter", "aliPay");
        u(new View.OnClickListener() { // from class: com.haier.globalwasher.presenter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f25201a.r(aVar, str2, str, view);
            }
        });
    }

    public void l(int i7, String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData<ClearBucketBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str);
        new c(bVar).g(i7, this.f25220c, i2.a.f34149w1, i2.a.f34152x1, map, ClearBucketBeen.class, 1);
    }

    public void n(int i7, int i8, String str, String str2, BaseListActivity.a aVar) {
        HashMap map = new HashMap();
        map.put("pageNumber", i7 + "");
        map.put("type", "1");
        map.put(f25218y, str);
        map.put("isExpired", "N");
        map.put("code", str2);
        new d(aVar).j(i8, this.f25220c, i2.a.f34116l1, "user.getCouponList", map, CouponPageBeen.class, 2);
    }

    public void o(int i7, String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseBeen> bVar) {
        String str3;
        HashMap map = new HashMap();
        if (str2.charAt(0) == '1') {
            str3 = "washCoupon";
        } else if (str2.charAt(0) == '2') {
            str3 = "shoeCoupon";
        } else {
            str3 = str2.charAt(0) == '3' ? "dryCoupon" : "";
        }
        map.put("type", "1");
        map.put(f25218y, str);
        map.put("code", str3);
        new e(bVar).j(i7, this.f25220c, i2.a.f34128p1, i2.a.f34131q1, map, null, 1);
    }

    public void p(String str, int i7, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<PayListBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str);
        map.put("type", i7 + "");
        map.put("deviceType", "2");
        map.put("orderType", str2);
        new b(bVar).j(0, this.f25220c, i2.a.f34122n1, i2.a.f34125o1, map, PayListBeen.class, 2);
    }

    public void t(final String str, final PayTMParamentBean payTMParamentBean, final m2.a aVar) {
        v(new View.OnClickListener() { // from class: com.haier.globalwasher.presenter.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f25209a.s(aVar, payTMParamentBean, str, view);
            }
        });
    }

    public void u(View.OnClickListener onClickListener) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f25221d.getString(R.string.open_paytm_popup_button_no));
        arrayList.add(this.f25221d.getString(R.string.open_paytm_popup_button_yes));
        if (this.f25236s == null) {
            this.f25236s = new com.haier.globalwasher.modle.utils.v();
        }
        this.f25236s.l(this.f25220c, this.f25221d.getString(R.string.open_alipay_popup_title), arrayList, null, onClickListener);
    }

    public void v(View.OnClickListener onClickListener) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.f25221d.getString(R.string.open_paytm_popup_button_no));
        arrayList.add(this.f25221d.getString(R.string.open_paytm_popup_button_yes));
        if (this.f25236s == null) {
            this.f25236s = new com.haier.globalwasher.modle.utils.v();
        }
        this.f25236s.l(this.f25220c, this.f25221d.getString(R.string.open_paytm_popup_title), arrayList, null, onClickListener);
    }

    public void w(String str, Bundle bundle, m2.a aVar) {
        if (bundle == null) {
            com.haier.globalwasher.modle.utils.q.a("PayPresenter", "onTransactionResponse null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str2 : bundle.keySet()) {
            try {
                jSONObject.put(str2, JSONObject.wrap(bundle.get(str2)));
            } catch (JSONException unused) {
            }
        }
        x(str, jSONObject.toString(), aVar);
    }

    public void x(String str, String str2, m2.a aVar) {
        if (str2 == null) {
            com.haier.globalwasher.modle.utils.q.a("PayPresenter", "onTransactionResponse null");
            return;
        }
        PasTmResultBeen pasTmResultBeenObjectFromData = PasTmResultBeen.objectFromData(str2);
        if (pasTmResultBeenObjectFromData != null) {
            com.haier.globalwasher.modle.utils.q.a("PayPresenter", "onTransactionResponse=" + pasTmResultBeenObjectFromData.toString());
            if ("TXN_SUCCESS".equals(pasTmResultBeenObjectFromData.getSTATUS()) && pasTmResultBeenObjectFromData.getRESPCODE().equals("01")) {
                z(com.haier.globalwasher.modle.enum_.f.PAYTM.b(), str, aVar);
                return;
            }
            if ("TXN_FAILURE".equals(pasTmResultBeenObjectFromData.getSTATUS())) {
                aVar.a(new Exception(pasTmResultBeenObjectFromData.getRESPMSG()));
                i0.d(this.f25220c, pasTmResultBeenObjectFromData.getRESPMSG());
            } else if ("PENDING".equals(pasTmResultBeenObjectFromData.getSTATUS())) {
                z(com.haier.globalwasher.modle.enum_.f.PAYTM.b(), str, aVar);
            }
        }
    }

    public void y(String str, String str2, String str3, ArrayList<DisCountInfo> arrayList, m2.a aVar) {
        HashMap map = new HashMap();
        map.put("orderId", str);
        map.put("payType", str2);
        map.put("orderDeviceId", str3);
        map.put("phoneType", "2");
        if (arrayList != null && arrayList.size() > 0) {
            map.put("couponsJson", m(arrayList));
        }
        new j(str, aVar).g(1, this.f25220c, i2.a.f34155y1, i2.a.f34158z1, map, PrePayBean.class, 1);
    }

    public void z(String str, String str2, m2.a aVar) {
        com.haier.globalwasher.modle.utils.q.c("PayPresenter", "requestOfPayResult11");
        if (com.haier.globalwasher.modle.utils.i.b(600L)) {
            return;
        }
        com.haier.globalwasher.modle.utils.q.c("PayPresenter", "requestOfPayResult22");
        HashMap map = new HashMap();
        map.put("payType", str);
        map.put("orderId", str2);
        new i(aVar).g(1, this.f25220c, i2.a.A1, i2.a.B1, map, null, 1);
    }
}
