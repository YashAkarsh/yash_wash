package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Callable<u> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HttpRequestRetryHandler f13470e = new ad();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected l f13471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f13472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected o f13473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f13474d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HttpUriRequest f13475f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CookieManager f13478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AbstractHttpEntity f13479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private HttpHost f13480k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private URL f13481l;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f13486q;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HttpContext f13476g = new BasicHttpContext();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CookieStore f13477h = new BasicCookieStore();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f13482m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f13483n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f13484o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f13485p = null;

    public q(l lVar, o oVar) {
        this.f13471a = lVar;
        this.f13472b = lVar.f13448a;
        this.f13473c = oVar;
    }

    private static long a(String[] strArr) {
        String str;
        for (int i7 = 0; i7 < strArr.length; i7++) {
            if ("max-age".equalsIgnoreCase(strArr[i7]) && (str = strArr[i7 + 1]) != null) {
                try {
                    return Long.parseLong(str);
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return 0L;
    }

    private static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader(com.google.common.net.c.f22132a);
        if (firstHeader != null) {
            String[] strArrSplit = firstHeader.getValue().split("=");
            if (strArrSplit.length >= 2) {
                try {
                    return a(strArrSplit);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader(com.google.common.net.c.f22151j0);
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f13475f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.f13479j == null) {
            byte[] bArrB = this.f13473c.b();
            String strB = this.f13473c.b("gzip");
            if (bArrB != null) {
                if (TextUtils.equals(strB, "true")) {
                    this.f13479j = b.a(bArrB);
                } else {
                    this.f13479j = new ByteArrayEntity(bArrB);
                }
                this.f13479j.setContentType(this.f13473c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.f13479j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f13475f = httpPost;
        } else {
            this.f13475f = new HttpGet(b());
        }
        return this.f13475f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x00d2  */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public u call() throws Throwable {
        boolean z7;
        HttpHost httpHost;
        while (true) {
            try {
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.f13472b.getSystemService("connectivity")).getAllNetworkInfo();
                boolean z8 = true;
                if (allNetworkInfo == null) {
                    z7 = false;
                    break;
                }
                int length = allNetworkInfo.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z7 = false;
                        break;
                    }
                    NetworkInfo networkInfo = allNetworkInfo[i7];
                    if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                        z7 = true;
                        break;
                    }
                    i7++;
                }
                if (!z7) {
                    throw new HttpException(1, "The network is not available");
                }
                ArrayList<Header> arrayListD = this.f13473c.d();
                if (arrayListD != null && !arrayListD.isEmpty()) {
                    Iterator<Header> it = arrayListD.iterator();
                    while (it.hasNext()) {
                        c().addHeader(it.next());
                    }
                }
                b.a((HttpRequest) c());
                b.b((HttpRequest) c());
                c().addHeader("cookie", i().getCookie(this.f13473c.a()));
                this.f13476g.setAttribute("http.cookie-store", this.f13477h);
                this.f13471a.a().a(f13470e);
                long jCurrentTimeMillis = System.currentTimeMillis();
                f();
                this.f13475f.getURI().toString();
                HttpParams params = this.f13471a.a().getParams();
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f13472b.getSystemService("connectivity")).getActiveNetworkInfo();
                HttpHost httpHost2 = null;
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    httpHost = null;
                } else {
                    String defaultHost = Proxy.getDefaultHost();
                    int defaultPort = Proxy.getDefaultPort();
                    if (defaultHost != null) {
                        httpHost = new HttpHost(defaultHost, defaultPort);
                    } else {
                        httpHost = null;
                    }
                }
                if (httpHost == null || !TextUtils.equals(httpHost.getHostName(), "127.0.0.1") || httpHost.getPort() != 8087) {
                    httpHost2 = httpHost;
                }
                params.setParameter("http.route.default-proxy", httpHost2);
                HttpHost httpHost3 = this.f13480k;
                if (httpHost3 == null) {
                    URL urlH = h();
                    HttpHost httpHost4 = new HttpHost(urlH.getHost(), g(), urlH.getProtocol());
                    this.f13480k = httpHost4;
                    httpHost3 = httpHost4;
                }
                if (g() == 80) {
                    httpHost3 = new HttpHost(h().getHost());
                }
                HttpResponse httpResponseExecute = this.f13471a.a().execute(httpHost3, this.f13475f, this.f13476g);
                this.f13471a.b(System.currentTimeMillis() - jCurrentTimeMillis);
                List<Cookie> cookies = this.f13477h.getCookies();
                if (this.f13473c.e()) {
                    i().removeAllCookie();
                }
                if (!cookies.isEmpty()) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getDomain() != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(cookie.getName());
                            sb.append("=");
                            sb.append(cookie.getValue());
                            sb.append("; domain=");
                            sb.append(cookie.getDomain());
                            sb.append(cookie.isSecure() ? "; Secure" : "");
                            i().setCookie(this.f13473c.a(), sb.toString());
                            CookieSyncManager.getInstance().sync();
                        }
                    }
                }
                int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
                String reasonPhrase = httpResponseExecute.getStatusLine().getReasonPhrase();
                if (statusCode != 200) {
                    if (statusCode != 304) {
                        z8 = false;
                    }
                    if (!z8) {
                        throw new HttpException(Integer.valueOf(httpResponseExecute.getStatusLine().getStatusCode()), httpResponseExecute.getStatusLine().getReasonPhrase());
                    }
                }
                u uVarA = a(httpResponseExecute, statusCode, reasonPhrase);
                if (((uVarA == null || uVarA.b() == null) ? -1L : uVarA.b().length) == -1 && (uVarA instanceof p)) {
                    try {
                        Long.parseLong(((p) uVarA).a().getHead(com.google.common.net.c.f22134b));
                    } catch (Exception unused) {
                    }
                }
                if (this.f13473c.a() != null && !TextUtils.isEmpty(f())) {
                    f();
                }
                return uVarA;
            } catch (HttpException e8) {
                e();
                if (this.f13473c.f() != null) {
                    e8.getCode();
                    e8.getMsg();
                }
                e8.toString();
                throw e8;
            } catch (NullPointerException e9) {
                e();
                int i8 = this.f13482m;
                if (i8 > 0) {
                    e9.toString();
                    throw new HttpException(0, String.valueOf(e9));
                }
                this.f13482m = i8 + 1;
            } catch (SocketTimeoutException e10) {
                e();
                if (this.f13473c.f() != null) {
                    e10.toString();
                }
                e10.toString();
                throw new HttpException(4, String.valueOf(e10));
            } catch (URISyntaxException e11) {
                throw new RuntimeException("Url parser error!", e11.getCause());
            } catch (UnknownHostException e12) {
                e();
                if (this.f13473c.f() != null) {
                    e12.toString();
                }
                e12.toString();
                throw new HttpException(9, String.valueOf(e12));
            } catch (SSLHandshakeException e13) {
                e();
                if (this.f13473c.f() != null) {
                    e13.toString();
                }
                e13.toString();
                throw new HttpException(2, String.valueOf(e13));
            } catch (SSLPeerUnverifiedException e14) {
                e();
                if (this.f13473c.f() != null) {
                    e14.toString();
                }
                e14.toString();
                throw new HttpException(2, String.valueOf(e14));
            } catch (SSLException e15) {
                e();
                if (this.f13473c.f() != null) {
                    e15.toString();
                }
                e15.toString();
                throw new HttpException(6, String.valueOf(e15));
            } catch (NoHttpResponseException e16) {
                e();
                if (this.f13473c.f() != null) {
                    e16.toString();
                }
                e16.toString();
                throw new HttpException(5, String.valueOf(e16));
            } catch (ConnectionPoolTimeoutException e17) {
                e();
                if (this.f13473c.f() != null) {
                    e17.toString();
                }
                e17.toString();
                throw new HttpException(3, String.valueOf(e17));
            } catch (ConnectTimeoutException e18) {
                e();
                if (this.f13473c.f() != null) {
                    e18.toString();
                }
                e18.toString();
                throw new HttpException(3, String.valueOf(e18));
            } catch (HttpHostConnectException e19) {
                e();
                if (this.f13473c.f() != null) {
                    e19.toString();
                }
                throw new HttpException(8, String.valueOf(e19));
            } catch (IOException e20) {
                e();
                if (this.f13473c.f() != null) {
                    e20.toString();
                }
                e20.toString();
                throw new HttpException(6, String.valueOf(e20));
            } catch (Exception e21) {
                e();
                if (this.f13473c.f() != null) {
                    e21.toString();
                }
                throw new HttpException(0, String.valueOf(e21));
            }
        }
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f13475f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.f13486q)) {
            return this.f13486q;
        }
        String strB = this.f13473c.b("operationType");
        this.f13486q = strB;
        return strB;
    }

    private int g() {
        URL urlH = h();
        return urlH.getPort() == -1 ? urlH.getDefaultPort() : urlH.getPort();
    }

    private URL h() {
        URL url = this.f13481l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.f13473c.a());
        this.f13481l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.f13478i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.f13478i = cookieManager2;
        return cookieManager2;
    }

    private static HttpUrlHeader a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private URI b() {
        String strA = this.f13473c.a();
        String str = this.f13474d;
        if (str != null) {
            strA = str;
        }
        if (strA != null) {
            return new URI(strA);
        }
        throw new RuntimeException("url should not be null");
    }

    public final o a() {
        return this.f13473c;
    }

    private u a(HttpResponse httpResponse, int i7, String str) throws Throwable {
        String str2;
        Thread.currentThread().getId();
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream = null;
        String str3 = null;
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity != null) {
                return null;
            }
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
        Thread.currentThread().getId();
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                a(entity, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                this.f13484o = false;
                this.f13471a.c(System.currentTimeMillis() - jCurrentTimeMillis);
                this.f13471a.a(byteArray.length);
                p pVar = new p(a(httpResponse), i7, str, byteArray);
                long jB = b(httpResponse);
                Header contentType = httpResponse.getEntity().getContentType();
                if (contentType != null) {
                    HashMap<String, String> mapA = a(contentType.getValue());
                    String str4 = mapA.get("charset");
                    str3 = mapA.get("Content-Type");
                    str2 = str4;
                } else {
                    str2 = null;
                }
                pVar.b(str3);
                pVar.a(str2);
                pVar.a(System.currentTimeMillis());
                pVar.b(jB);
                try {
                    byteArrayOutputStream2.close();
                    return pVar;
                } catch (IOException e8) {
                    throw new RuntimeException("ArrayOutputStream close error!", e8.getCause());
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e9) {
                        throw new RuntimeException("ArrayOutputStream close error!", e9.getCause());
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static HashMap<String, String> a(String str) {
        HashMap<String, String> map = new HashMap<>();
        for (String str2 : str.split(com.alipay.sdk.util.j.f13806b)) {
            String[] strArrSplit = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            map.put(strArrSplit[0], strArrSplit[1]);
        }
        return map;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) throws IOException {
        InputStream inputStreamA = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int i7 = inputStreamA.read(bArr);
                    if (i7 == -1 || this.f13473c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, i7);
                    this.f13473c.f();
                }
                outputStream.flush();
                r.a(inputStreamA);
            } catch (Exception e8) {
                e8.getCause();
                throw new IOException("HttpWorker Request Error!" + e8.getLocalizedMessage());
            }
        } catch (Throwable th) {
            r.a(inputStreamA);
            throw th;
        }
    }
}
