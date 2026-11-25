package com.haier.library.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.haier.uhome.account.api.RetInfoContent;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26615a = "android.net.wifi.WIFI_AP_STATE_CHANGED";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f26616b = 13;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f26617c = 11;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f26618d = "<unknown ssid>";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static WifiManager.MulticastLock f26619e;

    private w() {
    }

    public static int a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (Exception e8) {
            e3.a.g("getIp get excp %s", e8);
            return null;
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            e3.a.h("correctBSSID bssid is empty", new Object[0]);
            return str;
        }
        String upperCase = str.toUpperCase(Locale.getDefault());
        for (int i7 = 0; i7 < upperCase.length(); i7++) {
            char cCharAt = upperCase.charAt(i7);
            if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'A' || cCharAt > 'F')) {
                upperCase = upperCase.replace(cCharAt, ':');
            }
        }
        String strReplaceAll = upperCase.replaceAll("-", ":");
        if (!strReplaceAll.contains(":")) {
            return strReplaceAll;
        }
        String[] strArrSplit = strReplaceAll.split(":");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (TextUtils.isEmpty(str2) || str2.length() > 2) {
                e3.a.f("correctBSSID bssid <%s>, sub Illegal %s", str, str2, new Object[0]);
            } else {
                if (str2.length() < 2) {
                    sb.append("0");
                }
                sb.append(str2);
            }
        }
        String string = sb.toString();
        e3.a.d("correctBSSID bssid <%s>, result =  %s", str, string, new Object[0]);
        return string;
    }

    public static String d(Context context) {
        int iA = a(context);
        if (iA == 0) {
            return RetInfoContent.MOBILE_ISNULL;
        }
        if (iA != 1) {
            return iA != 9 ? "" : "ethernet";
        }
        return h(context);
    }

    public static String e(String str) {
        e3.a.e("resolveIpByName " + str, new Object[0]);
        if (str == null || str.length() == 0) {
            e3.a.e("resolveIpByName hostname is null or length is 0", new Object[0]);
            return null;
        }
        try {
            String hostAddress = InetAddress.getByName(str).getHostAddress();
            e3.a.n("resolveIpByName %s -> %s", str, hostAddress, new Object[0]);
            return hostAddress;
        } catch (UnknownHostException e8) {
            e3.a.o("resolveIpByName get Exception : %s", e8.toString());
            return null;
        }
    }

    public static void f() {
        WifiManager.MulticastLock multicastLock = f26619e;
        if (multicastLock == null || multicastLock.isHeld()) {
            return;
        }
        f26619e.release();
    }

    public static String g(Context context) {
        return d(context) + "_" + b();
    }

    public static String h(Context context) {
        WifiInfo connectionInfo;
        String str = f26618d;
        if (context == null) {
            return str;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return str;
            }
            connectionInfo = wifiManager.getConnectionInfo();
        } catch (Exception e8) {
            e8.getStackTrace();
            connectionInfo = null;
        }
        if (connectionInfo == null) {
            return str;
        }
        String ssid = connectionInfo.getSSID();
        if (TextUtils.isEmpty(ssid)) {
            return str;
        }
        return (ssid.length() > 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) ? ssid.substring(1, ssid.length() - 1) : ssid;
    }

    public static String i(Context context) {
        int i7;
        if (context == null) {
            e3.a.v("getRouterIp with a null context", new Object[0]);
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || (i7 = wifiManager.getDhcpInfo().gateway) == 0) {
                return null;
            }
            return Formatter.formatIpAddress(i7);
        } catch (Exception e8) {
            e3.a.g("getRouterIp get excp %s", e8);
            return null;
        }
    }

    public static String j(Context context) {
        WifiInfo connectionInfo;
        String bssid;
        if (context == null) {
            e3.a.v("getBSSID with a null context", new Object[0]);
            return "";
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (bssid = connectionInfo.getBSSID()) == null) ? "" : c(bssid);
    }

    public static void k(Context context) {
        WifiManager wifiManager;
        if (context == null) {
            e3.a.o("uSDK start opened multicast fail!context is null", new Object[0]);
            return;
        }
        if (f26619e != null || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return;
        }
        WifiManager.MulticastLock multicastLockCreateMulticastLock = wifiManager.createMulticastLock("multicast.test");
        f26619e = multicastLockCreateMulticastLock;
        multicastLockCreateMulticastLock.acquire();
        e3.a.e("uSDK start opened multicast!", new Object[0]);
    }

    public static boolean l(Context context) {
        if (context == null) {
            e3.a.o("uSDK checkWifiApEnabled fail!context is null", new Object[0]);
            return false;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return false;
            }
            return ((Boolean) wifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]).invoke(wifiManager, new Object[0])).booleanValue();
        } catch (Exception e8) {
            e3.a.g("isWifiApEnabled get excp %s", e8);
            return false;
        }
    }

    public static boolean m(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            return wifiManager != null && wifiManager.isWifiEnabled();
        } catch (Exception e8) {
            e3.a.g("isWifiEnabled when obtain from wifiManager error", e8);
            return false;
        }
    }
}
