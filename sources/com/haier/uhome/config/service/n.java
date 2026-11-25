package com.haier.uhome.config.service;

import com.haier.uhome.usdk.base.json.BasicReq;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConfigNative f28666a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static n f28667a = new n();

        private a() {
        }
    }

    public static n a() {
        return a.f28667a;
    }

    private String c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress() && inetAddressNextElement.getHostAddress() != null && inetAddressNextElement.getHostAddress().equals("192.168.43.1")) {
                        return "192.168.43.1";
                    }
                }
            }
            return "";
        } catch (Exception e8) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "get my wifi ap ip fail -> %s", e8);
            return "";
        }
    }

    public int b() {
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "stopSmartConfig().", new Object[0]);
        int iStopSmartConfig = this.f28666a.stopSmartConfig();
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "stopSmartConfig() ret %d", Integer.valueOf(iStopSmartConfig));
        return iStopSmartConfig;
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        return 0;
    }

    private n() {
        ConfigNative configNative = new ConfigNative();
        this.f28666a = configNative;
        configNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    int a(String str, String str2, String str3, String str4, List<String> list, int i7, int i8, int i9) {
        String str5 = str == null ? "" : str;
        String str6 = str2 == null ? "" : str2;
        String str7 = str3 == null ? "" : str3;
        String str8 = str4 == null ? "" : str4;
        Object[] array = com.haier.library.common.util.u.h(list) ? new String[0] : list.toArray();
        String strC = com.haier.library.common.util.w.l(com.haier.uhome.usdk.base.service.e.a().b()) ? c() : "";
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "startSmartConfig(\n ssid = %s,\n bssid = %s,\n password = %s,\n devId = %s,\n typeIdList = %s,\n security = %d,\n seedId = %d,\n txtimeout = %d,\n localIp = %s).", str5, str6, str7, str8, a(array), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), strC);
        int iStartSmartConfig = this.f28666a.startSmartConfig(str5, str6, str7, str8, strC, array, i7, i8, i9);
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.F, "startSmartConfig %s ret %d", str8, Integer.valueOf(iStartSmartConfig));
        return iStartSmartConfig;
    }

    private String a(Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (sb.length() > 0) {
                sb.append("|");
            }
            sb.append(obj);
        }
        return sb.toString();
    }
}
