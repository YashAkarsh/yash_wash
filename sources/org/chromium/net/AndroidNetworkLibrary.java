package org.chromium.net;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.CalledByNativeUnchecked;
import org.chromium.base.metrics.RecordHistogram;

/* JADX INFO: loaded from: classes3.dex */
@x6.e
class AndroidNetworkLibrary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38989a = "AndroidNetworkLibrary";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f38990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f38991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<InetAddress> f38992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Set<String> f38993e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f38994a = new a();

        public static a a() {
            return f38994a;
        }

        @org.chromium.base.s0
        public static void d(a aVar) {
            f38994a = aVar;
        }

        @TargetApi(23)
        public boolean b() {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
        }

        @TargetApi(24)
        public boolean c(String str) {
            return Build.VERSION.SDK_INT < 24 ? b() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Method f38995a;

        static {
            try {
                f38995a = FileDescriptor.class.getMethod("setInt$", Integer.TYPE);
            } catch (NoSuchMethodException | SecurityException e8) {
                throw new RuntimeException("Unable to get FileDescriptor.setInt$", e8);
            }
        }

        private b() {
        }

        public static FileDescriptor a(int i7) {
            try {
                FileDescriptor fileDescriptor = new FileDescriptor();
                f38995a.invoke(fileDescriptor, Integer.valueOf(i7));
                return fileDescriptor;
            } catch (IllegalAccessException e8) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e8);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException("FileDescriptor.setInt$() failed", e9);
            }
        }
    }

    private static class c extends Socket {

        private static class a extends SocketImpl {
            a(FileDescriptor fileDescriptor) {
                ((SocketImpl) this).fd = fileDescriptor;
            }

            @Override // java.net.SocketImpl
            protected void accept(SocketImpl socketImpl) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void bind(InetAddress inetAddress, int i7) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            protected void close() {
            }

            @Override // java.net.SocketImpl
            protected void connect(InetAddress inetAddress, int i7) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void create(boolean z7) {
            }

            @Override // java.net.SocketImpl
            protected InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int i7) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            protected OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            protected void listen(int i7) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            protected void sendUrgentData(int i7) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int i7, Object obj) {
                throw new RuntimeException("setOption not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(SocketAddress socketAddress, int i7) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            protected void connect(String str, int i7) {
                throw new RuntimeException("connect not implemented");
            }
        }

        c(FileDescriptor fileDescriptor) throws IOException {
            super(new a(fileDescriptor));
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f38992d = hashSet;
        HashSet hashSet2 = new HashSet();
        f38993e = hashSet2;
        try {
            hashSet.add(InetAddress.getByName("8.8.8.8"));
            hashSet.add(InetAddress.getByName("8.8.4.4"));
            hashSet.add(InetAddress.getByName("2001:4860:4860::8888"));
            hashSet.add(InetAddress.getByName("2001:4860:4860::8844"));
            hashSet.add(InetAddress.getByName("1.1.1.1"));
            hashSet.add(InetAddress.getByName("1.0.0.1"));
            hashSet.add(InetAddress.getByName("2606:4700:4700::1111"));
            hashSet.add(InetAddress.getByName("2606:4700:4700::1001"));
            hashSet.add(InetAddress.getByName("9.9.9.9"));
            hashSet.add(InetAddress.getByName("149.112.112.112"));
            hashSet.add(InetAddress.getByName("2620:fe::fe"));
            hashSet.add(InetAddress.getByName("2620:fe::9"));
            hashSet2.add("dns.google");
            hashSet2.add("1dot1dot1dot1.cloudflare-dns.com");
            hashSet2.add("cloudflare-dns.com");
            hashSet2.add("dns.quad9.net");
        } catch (UnknownHostException e8) {
            throw new RuntimeException("Failed to parse IP addresses", e8);
        }
    }

    AndroidNetworkLibrary() {
    }

    private static String a(LinkProperties linkProperties) {
        if (Build.VERSION.SDK_INT < 28 || linkProperties == null) {
            return null;
        }
        return y6.q.a(linkProperties);
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] bArr) throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.b(bArr);
    }

    private static boolean b() {
        if (f38990b == null) {
            f38990b = Boolean.valueOf(org.chromium.base.i.c(org.chromium.base.o.e(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0);
        }
        return f38990b.booleanValue();
    }

    private static boolean c() {
        if (f38991c == null) {
            f38991c = Boolean.valueOf(org.chromium.base.i.c(org.chromium.base.o.e(), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) == 0);
        }
        return f38991c.booleanValue();
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.c();
    }

    static boolean d(LinkProperties linkProperties) {
        if (Build.VERSION.SDK_INT < 28 || linkProperties == null) {
            return false;
        }
        return y6.q.b(linkProperties);
    }

    @TargetApi(23)
    @CalledByNative
    private static byte[][] getDnsServers() {
        int i7;
        boolean zContains;
        if (!b()) {
            return (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 0, 0);
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) org.chromium.base.o.e().getSystemService("connectivity");
        if (connectivityManager == null) {
            return (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 0, 0);
        }
        Network networkB = y6.a.b(connectivityManager);
        if (networkB == null) {
            return (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 0, 0);
        }
        LinkProperties linkProperties = connectivityManager.getLinkProperties(networkB);
        if (linkProperties == null) {
            return (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 0, 0);
        }
        List<InetAddress> dnsServers = linkProperties.getDnsServers();
        Iterator<InetAddress> it = dnsServers.iterator();
        while (true) {
            if (!it.hasNext()) {
                zContains = false;
                break;
            }
            if (f38992d.contains(it.next())) {
                zContains = true;
                break;
            }
        }
        if (d(linkProperties)) {
            String strA = a(linkProperties);
            if (strA != null) {
                zContains = f38993e.contains(strA.toLowerCase(Locale.US));
            }
            RecordHistogram.e("Net.DNS.Android.DotExplicit", strA != null);
            RecordHistogram.e("Net.DNS.Android.AutoDohPrivate", zContains);
            return (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 1, 1);
        }
        RecordHistogram.e("Net.DNS.Android.AutoDohPublic", zContains);
        byte[][] bArr = new byte[dnsServers.size()][];
        for (i7 = 0; i7 < dnsServers.size(); i7++) {
            bArr[i7] = dnsServers.get(i7).getAddress();
        }
        return bArr;
    }

    @TargetApi(23)
    @CalledByNative
    private static boolean getIsCaptivePortal() {
        Network networkB;
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) org.chromium.base.o.e().getSystemService("connectivity");
        return (connectivityManager == null || (networkB = y6.a.b(connectivityManager)) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(networkB)) == null || !networkCapabilities.hasCapability(17)) ? false : true;
    }

    @CalledByNative
    private static boolean getIsRoaming() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) org.chromium.base.o.e().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isRoaming();
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    @CalledByNative
    private static String getNetworkCountryIso() {
        return org.chromium.net.b.e().f();
    }

    @CalledByNative
    private static String getNetworkOperator() {
        return org.chromium.net.b.e().g();
    }

    @CalledByNative
    private static String getSimOperator() {
        return org.chromium.net.b.e().h();
    }

    @CalledByNative
    public static String getWifiSSID() {
        WifiInfo connectionInfo;
        String ssid;
        if (c()) {
            connectionInfo = ((WifiManager) org.chromium.base.o.e().getSystemService("wifi")).getConnectionInfo();
        } else {
            Intent intentRegisterReceiver = org.chromium.base.o.e().registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
            connectionInfo = intentRegisterReceiver != null ? (WifiInfo) intentRegisterReceiver.getParcelableExtra("wifiInfo") : null;
        }
        return (connectionInfo == null || (ssid = connectionInfo.getSSID()) == null || ssid.equals("<unknown ssid>")) ? "" : ssid;
    }

    @CalledByNative
    public static int getWifiSignalLevel(int i7) {
        int intExtra;
        int iCalculateSignalLevel;
        try {
            Intent intentRegisterReceiver = org.chromium.base.o.e().registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
            if (intentRegisterReceiver != null && (intExtra = intentRegisterReceiver.getIntExtra("newRssi", Integer.MIN_VALUE)) != Integer.MIN_VALUE && (iCalculateSignalLevel = WifiManager.calculateSignalLevel(intExtra, i7)) >= 0 && iCalculateSignalLevel < i7) {
                return iCalculateSignalLevel;
            }
            return -1;
        } catch (IllegalArgumentException unused) {
        }
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return false;
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                try {
                    if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                        return false;
                    }
                } catch (SocketException unused) {
                }
            }
            return true;
        } catch (Exception e8) {
            Log.w(f38989a, "could not get network interfaces: " + e8);
            return false;
        }
    }

    @CalledByNative
    private static boolean isCleartextPermitted(String str) {
        try {
            return a.a().c(str);
        } catch (IllegalArgumentException unused) {
            return a.a().b();
        }
    }

    @CalledByNative
    private static void tagSocket(int i7, int i8, int i9) throws IOException {
        int threadStatsTag = TrafficStats.getThreadStatsTag();
        if (i9 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(i9);
        }
        if (i8 != -1) {
            n0.b(i8);
        }
        ParcelFileDescriptor parcelFileDescriptorAdoptFd = ParcelFileDescriptor.adoptFd(i7);
        c cVar = new c(parcelFileDescriptorAdoptFd.getFileDescriptor());
        TrafficStats.tagSocket(cVar);
        cVar.close();
        parcelFileDescriptorAdoptFd.detachFd();
        if (i9 != threadStatsTag) {
            TrafficStats.setThreadStatsTag(threadStatsTag);
        }
        if (i8 != -1) {
            n0.a();
        }
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2) {
        try {
            return X509Util.n(bArr, str, str2);
        } catch (IllegalArgumentException unused) {
            return new AndroidCertVerifyResult(-1);
        } catch (KeyStoreException unused2) {
            return new AndroidCertVerifyResult(-1);
        } catch (NoSuchAlgorithmException unused3) {
            return new AndroidCertVerifyResult(-1);
        }
    }
}
