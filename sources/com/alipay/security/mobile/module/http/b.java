package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f13920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static DataReportResult f13921e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w f13922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BugTrackMessageService f13923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DataReportService f13924c;

    private b(Context context, String str) {
        this.f13922a = null;
        this.f13923b = null;
        this.f13924c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f13922a = hVar;
        this.f13923b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f13924c = (DataReportService) this.f13922a.a(DataReportService.class, aaVar);
    }

    public static synchronized b b(Context context, String str) {
        if (f13920d == null) {
            f13920d = new b(context, str);
        }
        return f13920d;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public DataReportResult a(DataReportRequest dataReportRequest) throws InterruptedException {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f13924c != null) {
            f13921e = null;
            new Thread(new c(this, dataReportRequest)).start();
            for (int i7 = r0.a.f40141a; f13921e == null && i7 >= 0; i7 -= 50) {
                Thread.sleep(50L);
            }
        }
        return f13921e;
    }

    @Override // com.alipay.security.mobile.module.http.a
    public boolean a(String str) {
        BugTrackMessageService bugTrackMessageService;
        String strLogCollect;
        if (o0.a.d(str) || (bugTrackMessageService = this.f13923b) == null) {
            return false;
        }
        try {
            strLogCollect = bugTrackMessageService.logCollect(o0.a.k(str));
        } catch (Throwable unused) {
            strLogCollect = null;
        }
        if (o0.a.d(strLogCollect)) {
            return false;
        }
        return ((Boolean) new JSONObject(strLogCollect).get("success")).booleanValue();
    }
}
