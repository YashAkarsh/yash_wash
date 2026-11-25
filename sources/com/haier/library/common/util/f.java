package com.haier.library.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f26569a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final int f26570b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f26571c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f26572d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f26573e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f26574f = "isPersistClient2ExternalSuccess";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f26575g = "/.dciduPlus/.dcidConfig";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f26577i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static AtomicBoolean f26576h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f26578j = "";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f26579k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static Object f26580l = new Object();

    private f() {
    }

    private static String A() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(System.currentTimeMillis());
        return a.i(stringBuffer.toString().toUpperCase());
    }

    public static String B(Context context) {
        WifiManager wifiManager;
        if (context == null || !J(context) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null) {
            return "";
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo == null ? "" : connectionInfo.getMacAddress();
        } catch (Exception e8) {
            e3.a.h("getLocalMacAddressFromWifiInfo error<%s>", e8.toString());
            return "";
        }
    }

    private static String C() {
        if (!TextUtils.isEmpty(f26578j) && !f26578j.replace("-", "").matches("^[0]+$")) {
            e3.a.e("make clientId with oaid way", new Object[0]);
            return a.i(f26578j.toUpperCase());
        }
        e3.a.h("make clientId with oaid way error", new Object[0]);
        e3.a.e("make clientId with uuid way", new Object[0]);
        return A();
    }

    public static boolean D(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return (locationManager != null && locationManager.isProviderEnabled("network")) || (locationManager != null && locationManager.isProviderEnabled("gps"));
    }

    private static String E(Context context) {
        String strG = G(context);
        if (o(context, strG)) {
            e3.a.e("found cached clientId:%s", strG);
            f26579k = 1;
            return strG;
        }
        String strI = I(context);
        if (o(context, strI)) {
            e3.a.e("found old clientId in sdcard:%s", strI);
            f26579k = 3;
            return strI;
        }
        String strC = C();
        f26579k = 4;
        e3.a.e("generate new clientId:%s", strC);
        return strC;
    }

    private static InetAddress F() {
        InetAddress inetAddress;
        SocketException e8;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            do {
                try {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        try {
                            if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.getHostAddress().contains(":")) {
                                inetAddress = inetAddressNextElement;
                                break;
                            }
                            inetAddress = null;
                        } catch (SocketException e9) {
                            e8 = e9;
                            inetAddress = inetAddressNextElement;
                            e3.a.v("getLocalInetAddress get Excp %s", e8);
                        }
                    }
                } catch (SocketException e10) {
                    e8 = e10;
                }
            } while (inetAddress == null);
        } catch (SocketException e11) {
            inetAddress = null;
            e8 = e11;
        }
        return inetAddress;
    }

    private static String G(Context context) {
        File file = new File(context.getFilesDir(), f26575g);
        return file.exists() ? e(file) : "";
    }

    private static boolean H(Context context) {
        if (context == null) {
            return false;
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 > 28) {
            e3.a.e("version SDK_INT is %d so unusable serial", Integer.valueOf(i7));
            return false;
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return false;
        }
        int i8 = applicationInfo.targetSdkVersion;
        if (i8 <= 27) {
            return true;
        }
        e3.a.e("targetSdkVersion is %d so unusable serial", Integer.valueOf(i8));
        return false;
    }

    private static String I(Context context) {
        if (context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            e3.a.e("found old clientId in sdcard fail permission forbid", new Object[0]);
            return "";
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory(), f26575g);
            return !file.exists() ? "" : e(file);
        } catch (Exception e8) {
            e8.printStackTrace();
            return "";
        }
    }

    private static boolean J(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0) {
            return false;
        }
        e3.a.h("isAccessWifiStateAuthorized: access wifi state is enabled", new Object[0]);
        return true;
    }

    public static int b() {
        return f26579k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c(Object obj, Method method, Object[] objArr) throws Throwable {
        Method declaredMethod;
        if (method != null && "OnSupport".equals(method.getName()) && (declaredMethod = objArr[1].getClass().getDeclaredMethod("getOAID", new Class[0])) != null) {
            f26578j = (String) declaredMethod.invoke(objArr[1], new Object[0]);
            e3.a.e("make clientId with oaid way success" + f26578j, new Object[0]);
        }
        return null;
    }

    public static String d(Context context) {
        String strT = t(context);
        return strT.length() > 24 ? strT.substring(8, 24) : strT.substring(0, 16);
    }

    private static String e(File file) {
        String line = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                try {
                    line = bufferedReader.readLine();
                    bufferedReader.close();
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (Exception e8) {
            e3.a.v("readFileOneLine getExcp %s", e8);
        }
        return line == null ? "" : line;
    }

    private static String f(Reader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        int i7 = reader.read(cArr);
        while (i7 >= 0) {
            sb.append(cArr, 0, i7);
            i7 = reader.read(cArr);
        }
        return sb.toString();
    }

    private static String g(String str) throws Exception {
        FileReader fileReader = new FileReader(str);
        String strF = f(fileReader);
        fileReader.close();
        return strF;
    }

    private static String h(String str, String str2) {
        String line;
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                line = bufferedReader.readLine();
                if (line == null || line.contains(str2)) {
                    break;
                }
                sb.append(line);
            }
            sb = new StringBuilder(line);
        } catch (Exception e8) {
            e3.a.v("callCmd getExcp %s", e8);
        }
        return sb.toString();
    }

    private static String i(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b8 : bArr) {
            sb.append(String.format("%02X:", Byte.valueOf(b8)));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean j(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    private static boolean k(File file, String str) {
        if (file == null) {
            e3.a.h("saveDeviceId with null file!!", new Object[0]);
            return false;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
                if (file.exists() || file.createNewFile()) {
                    n(file, str);
                }
                e3.a.e("write dcid to %s success", file.getAbsolutePath());
                return true;
            }
            e3.a.h("getDCID Error,saveDeviceId mkdir error", new Object[0]);
            return false;
        } catch (Exception e8) {
            e3.a.v("saveDeviceId get Excp %s", e8);
            return false;
        }
    }

    public static String l() {
        String strTrim;
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream()));
            String line = "";
            while (true) {
                if (line != null) {
                    line = lineNumberReader.readLine();
                    if (line != null) {
                        strTrim = line.trim();
                        break;
                    }
                    strTrim = "";
                    break;
                }
                strTrim = "";
                break;
            }
        } catch (Exception e8) {
            e3.a.h("getMacAddress exception<%s>", e8.toString());
        }
        if (strTrim == null || "".equals(strTrim)) {
            try {
                return g("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            } catch (Exception e9) {
                e3.a.h("getMacAddress exception<%s>", e9.toString());
            }
        }
        return strTrim;
    }

    public static String m(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context should not be null");
        }
        String strT = t(context);
        String strI = a.i(strT + "_" + context.getPackageName());
        e3.a.d("getNewClientId dcid:<%s> & newClientId:<%s>", strT, strI, new Object[0]);
        return strI;
    }

    private static void n(File file, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (Exception e8) {
            e3.a.v("writeOneLineToFile getExcp %s", e8);
        }
    }

    private static boolean o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!H(context)) {
            String strY = y();
            e3.a.e("bad dcid show:" + strY, new Object[0]);
            if (str.equals(strY)) {
                e3.a.e(" dcid<%s> equal to serial way, so is bad dcid", str);
                return false;
            }
        }
        return true;
    }

    public static String p() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(F()).getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i7 = 0; i7 < hardwareAddress.length; i7++) {
                if (i7 != 0) {
                    sb.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i7] & 255);
                if (hexString.length() == 1) {
                    hexString = 0 + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString().toUpperCase();
        } catch (Exception e8) {
            e3.a.v("getMacAddress get Excp %s", e8);
            return null;
        }
    }

    private static void q(Context context, String str) {
        if (f26576h.compareAndSet(false, true)) {
            u(context, str);
            if (y.a(context).m(f26574f, false)) {
                return;
            }
            y.a(context).h(f26574f, x(context, str));
        }
    }

    public static boolean r(Context context) {
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            Class<?> cls2 = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
            cls.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, cls2).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.haier.library.common.util.e
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method, Object[] objArr) {
                    return f.c(obj, method, objArr);
                }
            }));
            return true;
        } catch (Exception unused) {
            e3.a.e("oaid sdk error", new Object[0]);
            return false;
        }
    }

    public static String s() {
        Enumeration<NetworkInterface> networkInterfaces;
        String strI = null;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e8) {
            e3.a.v("getNetworkInterfaces get Excp %s", e8);
            networkInterfaces = null;
        }
        if (networkInterfaces == null) {
            return null;
        }
        while (networkInterfaces.hasMoreElements()) {
            try {
                strI = i(networkInterfaces.nextElement().getHardwareAddress());
                if (strI != null) {
                    break;
                }
            } catch (SocketException e9) {
                e3.a.v("getHardwareAddress get Excp %s", e9);
            }
        }
        return strI;
    }

    public static String t(Context context) {
        String upperCase;
        synchronized (f26580l) {
            try {
                if (context == null) {
                    throw new IllegalArgumentException("context should not be null");
                }
                String str = f26577i;
                if (!TextUtils.isEmpty(str)) {
                    e3.a.e("get client id from RAM", new Object[0]);
                    return str;
                }
                String strE = E(context);
                if (TextUtils.isEmpty(strE)) {
                    e3.a.h("get client id fail!!!", new Object[0]);
                    upperCase = "";
                } else {
                    upperCase = strE.toUpperCase();
                    f26577i = upperCase;
                    q(context, upperCase);
                }
                return upperCase;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean u(Context context, String str) {
        return k(new File(context.getFilesDir(), f26575g), str);
    }

    public static String v() {
        String strH = h("busybox ifconfig", "HWaddr");
        if (strH == null) {
            return "网络异常";
        }
        return (strH.length() <= 0 || !strH.contains("HWaddr")) ? strH : strH.substring(strH.indexOf("HWaddr") + 6, strH.length() - 1);
    }

    public static String w(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private static boolean x(Context context, String str) {
        if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            return false;
        }
        try {
            return k(new File(Environment.getExternalStorageDirectory(), f26575g), str);
        } catch (Exception e8) {
            e3.a.v("saveDeviceId get Excp %s", e8);
            return false;
        }
    }

    private static String y() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Build.SERIAL);
        stringBuffer.append(Build.BOARD);
        stringBuffer.append(Build.BRAND);
        stringBuffer.append(Build.DEVICE);
        stringBuffer.append(Build.HARDWARE);
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append(Build.PRODUCT);
        stringBuffer.append(Build.MODEL);
        return a.i(stringBuffer.toString().toUpperCase());
    }

    public static String z(Context context) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 24) {
            return l();
        }
        if (i7 < 24) {
            return null;
        }
        if (TextUtils.isEmpty(p())) {
            return !TextUtils.isEmpty(s()) ? s() : v();
        }
        return p();
    }
}
