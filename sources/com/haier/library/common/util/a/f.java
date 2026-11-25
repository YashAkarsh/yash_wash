package com.haier.library.common.util.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static String a(ScanResult scanResult) {
        if (scanResult == null) {
            return "";
        }
        String[] strArrSplit = scanResult.capabilities.replaceAll("\\[", "").replaceAll("]", ",").split(",");
        if (strArrSplit.length <= 0) {
            return "";
        }
        String str = strArrSplit[0];
        if (str.toUpperCase().contains("WPA") && !"WPA".equals(str.toUpperCase())) {
            return "WPA";
        }
        if (!str.toUpperCase().contains("WPA2") || "WPA2".equals(str.toUpperCase())) {
            return (!str.toUpperCase().contains("WEP") || "WEP".equals(str.toUpperCase())) ? "OPEN" : "WEP";
        }
        return "WPA2";
    }

    private static String b(String str) {
        if (str == null) {
            str = "";
        }
        if ("<unknown ssid>".equals(str)) {
            str = "";
        }
        String str2 = "0x".equals(str) ? "" : str;
        return (TextUtils.isEmpty(str2) || str2.length() < 2 || !str2.startsWith("\"")) ? str2 : str2.substring(1, str2.length() - 1);
    }

    public static boolean c(Context context) {
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    private static e d(String str) {
        for (String str2 : str.replaceAll("\\[", "").replaceAll("]", ",").split(",")) {
            if (str2.toUpperCase().contains("WPA") && !str2.toUpperCase().equals("WPA")) {
                return e.WPA;
            }
            if (str2.toUpperCase().contains("WPA2") && !str2.toUpperCase().equals("WPA2")) {
                return e.WPA;
            }
            if (str2.toUpperCase().contains("WEP") && !str2.toUpperCase().equals("WEP")) {
                return e.WEP;
            }
        }
        return e.NONE;
    }

    public static String e(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        return SupplicantState.COMPLETED != connectionInfo.getSupplicantState() ? "" : b(connectionInfo.getSSID());
    }
}
