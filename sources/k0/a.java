package k0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.d;
import com.alipay.sdk.util.j;
import com.google.common.net.c;
import com.haier.uhome.account.api.Const;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f34399a = "msp";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f34400b = "application/octet-stream;binary/octet-stream";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CookieManager f34401c = new CookieManager();

    /* JADX INFO: renamed from: k0.a$a, reason: collision with other inner class name */
    public static final class C0420a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f34402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f34403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f34404c;

        public C0420a(String str, Map<String, String> map, byte[] bArr) {
            this.f34402a = str;
            this.f34403b = bArr;
            this.f34404c = map;
        }

        public String toString() {
            return String.format("<UrlConnectionConfigure url=%s requestBody=%s headers=%s>", this.f34402a, this.f34403b, this.f34404c);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f34405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f34406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f34407c;

        public b(Map<String, List<String>> map, String str, byte[] bArr) {
            this.f34405a = map;
            this.f34406b = str;
            this.f34407c = bArr;
        }
    }

    private static Proxy a(Context context) {
        String strE = e(context);
        if (strE != null && !strE.contains("wap")) {
            return null;
        }
        try {
            String property = System.getProperty("https.proxyHost");
            String property2 = System.getProperty("https.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(property, Integer.parseInt(property2)));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01a3 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x01a8 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x01ad A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static b b(Context context, C0420a c0420a) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        if (context == null) {
            return null;
        }
        try {
            d.g(f34399a, "config : " + c0420a);
            URL url = new URL(c0420a.f34402a);
            Proxy proxyA = a(context);
            d.g(f34399a, "proxy: " + proxyA);
            HttpURLConnection httpURLConnection2 = proxyA != null ? (HttpURLConnection) url.openConnection(proxyA) : (HttpURLConnection) url.openConnection();
            try {
                System.setProperty("http.keepAlive", com.paytm.pgsdk.d.G);
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                }
                CookieManager cookieManager = f34401c;
                if (cookieManager.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection2.setRequestProperty(c.f22162p, TextUtils.join(j.f13806b, cookieManager.getCookieStore().getCookies()));
                }
                httpURLConnection2.setConnectTimeout(20000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setInstanceFollowRedirects(true);
                httpURLConnection2.setRequestProperty(c.M, f34399a);
                byte[] bArr = c0420a.f34403b;
                if (bArr == null || bArr.length <= 0) {
                    httpURLConnection2.setRequestMethod(Const.HTTP_REQUEST_TYPE_GET);
                } else {
                    httpURLConnection2.setRequestMethod(Const.HTTP_REQUEST_TYPE_POST);
                    httpURLConnection2.setRequestProperty("Content-Type", f34400b);
                    httpURLConnection2.setRequestProperty(c.f22148i, "UTF-8");
                    httpURLConnection2.setRequestProperty(c.f22160o, "Keep-Alive");
                    httpURLConnection2.setRequestProperty("Keep-Alive", "timeout=180, max=100");
                }
                Map<String, String> map = c0420a.f34404c;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (entry.getKey() != null) {
                            httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection2.setDoInput(true);
                if (Const.HTTP_REQUEST_TYPE_POST.equals(httpURLConnection2.getRequestMethod())) {
                    httpURLConnection2.setDoOutput(true);
                }
                if (Const.HTTP_REQUEST_TYPE_POST.equals(httpURLConnection2.getRequestMethod())) {
                    bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        bufferedOutputStream2.write(c0420a.f34403b);
                        bufferedOutputStream2.flush();
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedInputStream = null;
                        Throwable th2 = th;
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        try {
                            d.d(th);
                            return null;
                        } finally {
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused) {
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                } else {
                    bufferedOutputStream2 = null;
                }
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection2.getInputStream());
                try {
                    byte[] bArrC = c(bufferedInputStream2);
                    Map<String, List<String>> headerFields = httpURLConnection2.getHeaderFields();
                    String strJoin = (headerFields == null || headerFields.get(null) == null) ? null : TextUtils.join(",", headerFields.get(null));
                    List<String> list = headerFields.get(c.f22173u0);
                    if (list != null) {
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            List<HttpCookie> list2 = HttpCookie.parse(it.next());
                            if (list2 != null && !list2.isEmpty()) {
                                f34401c.getCookieStore().add(url.toURI(), list2.get(0));
                            }
                        }
                    }
                    b bVar = new b(headerFields, strJoin, bArrC);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable unused4) {
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (Throwable unused5) {
                    }
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    return bVar;
                } catch (Throwable th3) {
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                    bufferedOutputStream = bufferedOutputStream2;
                    bufferedInputStream = bufferedInputStream2;
                    d.d(th);
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                bufferedOutputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedInputStream = null;
            bufferedOutputStream = null;
        }
    }

    private static byte[] c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i7 = inputStream.read(bArr, 0, 1024);
            if (i7 == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i7);
        }
    }

    private static NetworkInfo d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String e(Context context) {
        try {
            NetworkInfo networkInfoD = d(context);
            if (networkInfoD != null && networkInfoD.isAvailable()) {
                return networkInfoD.getType() == 1 ? "wifi" : networkInfoD.getExtraInfo().toLowerCase();
            }
        } catch (Exception unused) {
        }
        return "none";
    }
}
