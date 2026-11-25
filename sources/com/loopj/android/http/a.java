package com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f32467i = "1.4.4";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f32468j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f32469k = 10000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f32470l = 5;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f32471m = 1500;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f32472n = 8192;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f32473o = "Accept-Encoding";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f32474p = "gzip";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f32475q = "AsyncHttpClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DefaultHttpClient f32478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HttpContext f32479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ThreadPoolExecutor f32480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Context, List<WeakReference<Future<?>>>> f32481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, String> f32482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f32483h;

    /* JADX INFO: renamed from: com.loopj.android.http.a$a, reason: collision with other inner class name */
    class C0392a implements HttpRequestInterceptor {
        C0392a() {
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (!httpRequest.containsHeader("Accept-Encoding")) {
                httpRequest.addHeader("Accept-Encoding", a.f32474p);
            }
            for (String str : a.this.f32482g.keySet()) {
                httpRequest.addHeader(str, (String) a.this.f32482g.get(str));
            }
        }
    }

    class b implements HttpResponseInterceptor {
        b() {
        }

        @Override // org.apache.http.HttpResponseInterceptor
        public void process(HttpResponse httpResponse, HttpContext httpContext) {
            Header contentEncoding;
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
                return;
            }
            for (HeaderElement headerElement : contentEncoding.getElements()) {
                if (headerElement.getName().equalsIgnoreCase(a.f32474p)) {
                    httpResponse.setEntity(new d(entity));
                    return;
                }
            }
        }
    }

    class c extends DefaultRedirectHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f32486a;

        c(boolean z7) {
            this.f32486a = z7;
        }

        @Override // org.apache.http.impl.client.DefaultRedirectHandler, org.apache.http.client.RedirectHandler
        public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
            return this.f32486a;
        }
    }

    private static class d extends HttpEntityWrapper {
        public d(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public InputStream getContent() throws IOException {
            return new GZIPInputStream(((HttpEntityWrapper) this).wrappedEntity.getContent());
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public long getContentLength() {
            return -1L;
        }
    }

    public a() {
        this(false, 80, 443);
    }

    private HttpEntity A(l lVar, m mVar) {
        if (lVar == null) {
            return null;
        }
        try {
            return lVar.d(mVar);
        } catch (Throwable th) {
            if (mVar != null) {
                mVar.g(0, null, null, th);
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private HttpEntityEnclosingRequestBase b(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    private static SchemeRegistry o(boolean z7, int i7, int i8) {
        if (z7) {
            Log.d(f32475q, "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i7 < 1) {
            Log.d(f32475q, "Invalid HTTP port number specified, defaulting to 80");
            i7 = 80;
        }
        if (i8 < 1) {
            Log.d(f32475q, "Invalid HTTPS port number specified, defaulting to 443");
            i8 = 443;
        }
        SSLSocketFactory sSLSocketFactoryA = z7 ? i.a() : SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(com.haier.uhome.usdk.base.a.av, PlainSocketFactory.getSocketFactory(), i7));
        schemeRegistry.register(new Scheme(j0.b.f34226a, sSLSocketFactoryA, i8));
        return schemeRegistry;
    }

    public static String t(boolean z7, String str, l lVar) {
        if (z7) {
            str = str.replace(" ", "%20");
        }
        if (lVar == null) {
            return str;
        }
        String strE = lVar.e();
        if (str.contains("?")) {
            return str + m0.a.f37445e + strE;
        }
        return str + "?" + strE;
    }

    public k B(Context context, String str, l lVar, m mVar) {
        return C(context, str, A(lVar, mVar), null, mVar);
    }

    public k C(Context context, String str, HttpEntity httpEntity, String str2, m mVar) {
        return N(this.f32478c, this.f32479d, b(new HttpPost(str), httpEntity), str2, mVar, context);
    }

    public k D(Context context, String str, Header[] headerArr, l lVar, String str2, m mVar) {
        HttpPost httpPost = new HttpPost(str);
        if (lVar != null) {
            httpPost.setEntity(A(lVar, mVar));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        return N(this.f32478c, this.f32479d, httpPost, str2, mVar, context);
    }

    public k E(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, m mVar) {
        HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBaseB = b(new HttpPost(str), httpEntity);
        if (headerArr != null) {
            httpEntityEnclosingRequestBaseB.setHeaders(headerArr);
        }
        return N(this.f32478c, this.f32479d, httpEntityEnclosingRequestBaseB, str2, mVar, context);
    }

    public k F(String str, l lVar, m mVar) {
        return B(null, str, lVar, mVar);
    }

    public k G(String str, m mVar) {
        return B(null, str, null, mVar);
    }

    public k H(Context context, String str, l lVar, m mVar) {
        return I(context, str, A(lVar, mVar), null, mVar);
    }

    public k I(Context context, String str, HttpEntity httpEntity, String str2, m mVar) {
        return N(this.f32478c, this.f32479d, b(new HttpPut(str), httpEntity), str2, mVar, context);
    }

    public k J(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, m mVar) {
        HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBaseB = b(new HttpPut(str), httpEntity);
        if (headerArr != null) {
            httpEntityEnclosingRequestBaseB.setHeaders(headerArr);
        }
        return N(this.f32478c, this.f32479d, httpEntityEnclosingRequestBaseB, str2, mVar, context);
    }

    public k K(String str, l lVar, m mVar) {
        return H(null, str, lVar, mVar);
    }

    public k L(String str, m mVar) {
        return H(null, str, null, mVar);
    }

    public void M(String str) {
        this.f32482g.remove(str);
    }

    protected k N(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, m mVar, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        mVar.a(httpUriRequest.getAllHeaders());
        mVar.k(httpUriRequest.getURI());
        Future<?> futureSubmit = this.f32480e.submit(new com.loopj.android.http.b(defaultHttpClient, httpContext, httpUriRequest, mVar));
        if (context != null) {
            List<WeakReference<Future<?>>> linkedList = this.f32481f.get(context);
            if (linkedList == null) {
                linkedList = new LinkedList<>();
                this.f32481f.put(context, linkedList);
            }
            linkedList.add(new WeakReference<>(futureSubmit));
        }
        return new k(futureSubmit);
    }

    public void O(String str, String str2) {
        P(str, str2, AuthScope.ANY);
    }

    public void P(String str, String str2, AuthScope authScope) {
        this.f32478c.getCredentialsProvider().setCredentials(authScope, new UsernamePasswordCredentials(str, str2));
    }

    public void Q(CookieStore cookieStore) {
        this.f32479d.setAttribute("http.cookie-store", cookieStore);
    }

    public void R(boolean z7) {
        this.f32478c.setRedirectHandler(new c(z7));
    }

    public void S(int i7) {
        if (i7 < 1) {
            i7 = 10;
        }
        this.f32476a = i7;
        ConnManagerParams.setMaxConnectionsPerRoute(this.f32478c.getParams(), new ConnPerRouteBean(this.f32476a));
    }

    public void T(int i7, int i8) {
        this.f32478c.setHttpRequestRetryHandler(new n(i7, i8));
    }

    public void U(String str, int i7) {
        this.f32478c.getParams().setParameter("http.route.default-proxy", new HttpHost(str, i7));
    }

    public void V(String str, int i7, String str2, String str3) {
        this.f32478c.getCredentialsProvider().setCredentials(new AuthScope(str, i7), new UsernamePasswordCredentials(str2, str3));
        this.f32478c.getParams().setParameter("http.route.default-proxy", new HttpHost(str, i7));
    }

    public void W(SSLSocketFactory sSLSocketFactory) {
        this.f32478c.getConnectionManager().getSchemeRegistry().register(new Scheme(j0.b.f34226a, sSLSocketFactory, 443));
    }

    public void X(ThreadPoolExecutor threadPoolExecutor) {
        this.f32480e = threadPoolExecutor;
    }

    public void Y(int i7) {
        if (i7 < 1000) {
            i7 = 10000;
        }
        this.f32477b = i7;
        HttpParams params = this.f32478c.getParams();
        ConnManagerParams.setTimeout(params, this.f32477b);
        HttpConnectionParams.setSoTimeout(params, this.f32477b);
        HttpConnectionParams.setConnectionTimeout(params, this.f32477b);
    }

    public void Z(boolean z7) {
        this.f32483h = z7;
    }

    public void a0(String str) {
        HttpProtocolParams.setUserAgent(this.f32478c.getParams(), str);
    }

    public void c(String str, String str2) {
        this.f32482g.put(str, str2);
    }

    public void d(Context context, boolean z7) {
        List<WeakReference<Future<?>>> list = this.f32481f.get(context);
        if (list != null) {
            Iterator<WeakReference<Future<?>>> it = list.iterator();
            while (it.hasNext()) {
                Future<?> future = it.next().get();
                if (future != null) {
                    future.cancel(z7);
                }
            }
        }
        this.f32481f.remove(context);
    }

    public void e() {
        this.f32478c.getCredentialsProvider().clear();
    }

    public k f(Context context, String str, m mVar) {
        return N(this.f32478c, this.f32479d, new HttpDelete(str), null, mVar, context);
    }

    public k g(Context context, String str, Header[] headerArr, l lVar, m mVar) {
        HttpDelete httpDelete = new HttpDelete(t(this.f32483h, str, lVar));
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return N(this.f32478c, this.f32479d, httpDelete, null, mVar, context);
    }

    public k h(Context context, String str, Header[] headerArr, m mVar) {
        HttpDelete httpDelete = new HttpDelete(str);
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return N(this.f32478c, this.f32479d, httpDelete, null, mVar, context);
    }

    public k i(String str, m mVar) {
        return f(null, str, mVar);
    }

    public k j(Context context, String str, l lVar, m mVar) {
        return N(this.f32478c, this.f32479d, new HttpGet(t(this.f32483h, str, lVar)), null, mVar, context);
    }

    public k k(Context context, String str, m mVar) {
        return j(context, str, null, mVar);
    }

    public k l(Context context, String str, Header[] headerArr, l lVar, m mVar) {
        HttpGet httpGet = new HttpGet(t(this.f32483h, str, lVar));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        return N(this.f32478c, this.f32479d, httpGet, null, mVar, context);
    }

    public k m(String str, l lVar, m mVar) {
        return j(null, str, lVar, mVar);
    }

    public k n(String str, m mVar) {
        return j(null, str, null, mVar);
    }

    public HttpClient p() {
        return this.f32478c;
    }

    public HttpContext q() {
        return this.f32479d;
    }

    public int r() {
        return this.f32476a;
    }

    public int s() {
        return this.f32477b;
    }

    public k u(Context context, String str, l lVar, m mVar) {
        return N(this.f32478c, this.f32479d, new HttpHead(t(this.f32483h, str, lVar)), null, mVar, context);
    }

    public k v(Context context, String str, m mVar) {
        return u(context, str, null, mVar);
    }

    public k w(Context context, String str, Header[] headerArr, l lVar, m mVar) {
        HttpHead httpHead = new HttpHead(t(this.f32483h, str, lVar));
        if (headerArr != null) {
            httpHead.setHeaders(headerArr);
        }
        return N(this.f32478c, this.f32479d, httpHead, null, mVar, context);
    }

    public k x(String str, l lVar, m mVar) {
        return u(null, str, lVar, mVar);
    }

    public k y(String str, m mVar) {
        return u(null, str, null, mVar);
    }

    public boolean z() {
        return this.f32483h;
    }

    public a(int i7) {
        this(false, i7, 443);
    }

    public a(int i7, int i8) {
        this(false, i7, i8);
    }

    public a(boolean z7, int i7, int i8) {
        this(o(z7, i7, i8));
    }

    public a(SchemeRegistry schemeRegistry) {
        this.f32476a = 10;
        this.f32477b = 10000;
        this.f32483h = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, this.f32477b);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.f32476a));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.f32477b);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.f32477b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", f32467i));
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f32480e = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        this.f32481f = new WeakHashMap();
        this.f32482g = new HashMap();
        this.f32479d = new SyncBasicHttpContext(new BasicHttpContext());
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f32478c = defaultHttpClient;
        defaultHttpClient.addRequestInterceptor(new C0392a());
        defaultHttpClient.addResponseInterceptor(new b());
        defaultHttpClient.setHttpRequestRetryHandler(new n(5, 1500));
    }
}
