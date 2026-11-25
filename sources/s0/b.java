package s0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.f40312a;
        dataReportRequest.rpcVersion = dVar.f40321j;
        dataReportRequest.bizType = "1";
        HashMap map = new HashMap();
        dataReportRequest.bizData = map;
        map.put("apdid", dVar.f40313b);
        dataReportRequest.bizData.put("apdidToken", dVar.f40314c);
        dataReportRequest.bizData.put("umidToken", dVar.f40315d);
        dataReportRequest.bizData.put("dynamicKey", dVar.f40316e);
        dataReportRequest.deviceData = dVar.f40317f;
        return dataReportRequest;
    }

    public static c b(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f40296a = dataReportResult.success;
        cVar.f40297b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.f40303c = map.get("apdid");
            cVar.f40304d = map.get("apdidToken");
            cVar.f40307g = map.get("dynamicKey");
            cVar.f40308h = map.get("timeInterval");
            cVar.f40309i = map.get("webrtcUrl");
            cVar.f40310j = "";
            String str = map.get("drmSwitch");
            if (o0.a.g(str)) {
                if (str.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    cVar.f40305e = sb.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(2));
                    cVar.f40306f = sb2.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.f40311k = map.get("apse_degrade");
            }
        }
        return cVar;
    }
}
