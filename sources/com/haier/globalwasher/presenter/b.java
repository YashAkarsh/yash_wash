package com.haier.globalwasher.presenter;

import android.content.res.Resources;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CouponPageBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f25070f = "CouponPresenter";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f25072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f25073e = System.currentTimeMillis();

    class a extends com.haier.globalwasher.modle.network.a<BaseListDate<CouponPageBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25074g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25074g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25074g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<CouponPageBeen> baseListDate) {
            this.f25074g.b(baseListDate);
        }
    }

    private long h() {
        try {
            try {
                URLConnection uRLConnectionOpenConnection = new URL("http://www.ntsc.ac.cn").openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(5000);
                uRLConnectionOpenConnection.connect();
                long date = uRLConnectionOpenConnection.getDate();
                this.f25073e = date;
                return date;
            } catch (Exception e8) {
                e8.printStackTrace();
                if (this.f25073e == 0) {
                    this.f25073e = -1L;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f25073e = jCurrentTimeMillis;
                return jCurrentTimeMillis;
            }
        } catch (Throwable unused) {
            return this.f25073e;
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25071c = baseActivity;
        this.f25072d = baseActivity.getResources();
        return baseActivity;
    }

    public boolean g(String str) {
        long time;
        try {
            time = new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime();
        } catch (Exception unused) {
            time = -1;
        }
        long j7 = this.f25073e;
        if (j7 == -1 || time == -1) {
            return false;
        }
        if (j7 < time) {
            com.haier.globalwasher.modle.utils.q.c(f25070f, "thisDate=" + time + "----thisTime=" + this.f25073e + "true");
            return true;
        }
        com.haier.globalwasher.modle.utils.q.c(f25070f, "thisDate=" + time + "----thisTime=" + this.f25073e + com.paytm.pgsdk.d.G);
        return false;
    }

    public void i(int i7, int i8, com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<CouponPageBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("pageNumber", i8 + "");
        map.put("type", "1");
        map.put("isExpired", "N");
        new a(bVar).j(i7, this.f25071c, i2.a.F0, "user.getCouponList", map, CouponPageBeen.class, 2);
    }
}
