package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DataReportRequest f13925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f13926b;

    c(b bVar, DataReportRequest dataReportRequest) {
        this.f13926b = bVar;
        this.f13925a = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            DataReportResult unused = b.f13921e = this.f13926b.f13924c.reportData(this.f13925a);
        } catch (Throwable th) {
            DataReportResult unused2 = b.f13921e = new DataReportResult();
            b.f13921e.success = false;
            b.f13921e.resultCode = "static data rpc upload error, " + o0.a.b(th);
            o0.a.b(th);
        }
    }
}
