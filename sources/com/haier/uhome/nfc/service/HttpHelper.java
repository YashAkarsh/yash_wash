package com.haier.uhome.nfc.service;

import android.text.TextUtils;
import c.m0;
import com.haier.library.okhttp.f;
import com.haier.library.okhttp.g;
import com.haier.library.okhttp.g0;
import com.haier.library.okhttp.j0;
import com.haier.library.sumhttp.plugin.i;
import com.haier.uhome.mesh.bridge.RtkCoreMeshWrapper;
import com.haier.uhome.nfc.service.entity.ModuleDeviceInfoResultDto;
import com.haier.uhome.nfc.service.entity.NFCInfo;
import com.haier.uhome.nfc.service.entity.NFCInfoResp;
import com.haier.uhome.usdk.base.annotation.Keep;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class HttpHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f29511a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f29512b = "https://uws.haier.net";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f29513c = "https://uws.haier.net/dcs/device-service-2c/get/device/nfc/full-info";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f29514d = "https://uws.haier.net/dcs/device-service-2c/update/device/nfc/full-info";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f29515e = "https://uws.haier.net/dcs/device-service-2c/get/cloud-device/module/device-info/open-window";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f29516f = 4000;

    private interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f29517a = "appId";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f29518b = "appVersion";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f29519c = "apiVersion";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f29520d = "clientId";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f29521e = "sequenceId";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f29522f = "accessToken";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f29523g = "sign";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f29524h = "timestamp";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f29525i = "language";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f29526j = "timezone";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f29527k = "Content-Type";
    }

    private interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f29528a = "v1";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f29529b = "zh-cn";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f29530c = "8";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f29531d = "application/json;charset=UTF-8";
    }

    private static String a(String str, String str2, String str3, String str4, String str5) {
        try {
            String path = new URL(str5).getPath();
            String strReplaceAll = str2.trim().replaceAll("\"", "");
            if (str4 != null) {
                str4 = str4.trim();
                if (!str4.equals("")) {
                    str4 = str4.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("\n", "");
                }
            }
            return a(MessageDigest.getInstance("SHA-256").digest((path + str4 + str + strReplaceAll + str3).getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e8) {
            e8.printStackTrace();
            return null;
        }
    }

    private static g0 b(String str, String str2) {
        String str3 = System.currentTimeMillis() + "";
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String strI = eVarA.i();
        String strH = eVarA.h();
        String strK = eVarA.k();
        String strJ = eVarA.j();
        String strG = eVarA.g();
        String strA = a(strI, strH, str3, str2, str);
        if (!f29511a && strA == null) {
            throw new AssertionError();
        }
        return new g0.a().c("appId", strI).c(a.f29518b, strJ).c("apiVersion", "v1").c(a.f29520d, strK).c(a.f29521e, str3 + "000110").c("accessToken", strG).c("sign", strA).c("timestamp", str3).c("language", "zh-cn").c(a.f29526j, b.f29530c).c("Content-Type", "application/json;charset=UTF-8").e();
    }

    @Keep
    public static void getNfc(NFCInfo nFCInfo, com.haier.library.sumhttp.plugin.a<NFCInfoResp> aVar, com.haier.library.sumhttp.plugin.b bVar) {
        String strZ = com.haier.library.json.a.Z(nFCInfo);
        i.a(new com.haier.library.sumhttp.plugin.d(new f.a().h(f29513c).d(b(f29513c, strZ)).b(g.c(j0.d("application/json;charset=UTF-8"), strZ)).s(), new com.haier.library.sumhttp.plugin.resp.d(NFCInfoResp.class), aVar, bVar, f29516f));
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b8 : bArr) {
            sb.append("0123456789abcdef".charAt((b8 & 240) >> 4));
            sb.append("0123456789abcdef".charAt(b8 & com.google.common.base.c.f19317q));
        }
        return sb.toString();
    }

    static void a(NFCInfo nFCInfo, com.haier.library.sumhttp.plugin.a<Void> aVar, com.haier.library.sumhttp.plugin.b bVar) {
        String strZ = com.haier.library.json.a.Z(nFCInfo);
        i.a(new com.haier.library.sumhttp.plugin.d(new f.a().h(f29514d).d(b(f29514d, strZ)).b(g.c(j0.d("application/json;charset=UTF-8"), strZ)).s(), new com.haier.library.sumhttp.plugin.resp.f(), aVar, bVar, f29516f));
    }

    public static com.haier.library.sumhttp.plugin.resp.c<ModuleDeviceInfoResultDto> a(@m0 String str, String str2) {
        HashMap map = new HashMap();
        map.put("moduleId", str);
        if (!TextUtils.isEmpty(str2)) {
            map.put("moduleType", str2);
        }
        String strZ = com.haier.library.json.a.Z(map);
        f fVarS = new f.a().h(f29515e).d(b(f29515e, strZ)).b(g.c(j0.d("application/json;charset=UTF-8"), strZ)).s();
        com.haier.library.sumhttp.plugin.resp.c<ModuleDeviceInfoResultDto> cVar = new com.haier.library.sumhttp.plugin.resp.c<>(ModuleDeviceInfoResultDto.class);
        i.c(new com.haier.library.sumhttp.plugin.d(fVarS, cVar, null, null, 5000L), 5000L);
        return cVar;
    }

    public static void a(@m0 String str, String str2, com.haier.library.sumhttp.plugin.a<List<ModuleDeviceInfoResultDto>> aVar, com.haier.library.sumhttp.plugin.b bVar) {
        HashMap map = new HashMap();
        map.put("moduleId", str);
        if (!TextUtils.isEmpty(str2)) {
            map.put("moduleType", str2);
        }
        String strZ = com.haier.library.json.a.Z(map);
        i.c(new com.haier.library.sumhttp.plugin.d(new f.a().h(f29515e).d(b(f29515e, strZ)).b(g.c(j0.d("application/json;charset=UTF-8"), strZ)).s(), new com.haier.library.sumhttp.plugin.resp.c(ModuleDeviceInfoResultDto.class), aVar, bVar, 5000L, RtkCoreMeshWrapper.RTK_PROV_CONNECT_TIMEOUT), 0L);
    }
}
