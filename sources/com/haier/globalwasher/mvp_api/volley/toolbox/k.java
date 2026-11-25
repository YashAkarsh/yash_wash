package com.haier.globalwasher.mvp_api.volley.toolbox;

import com.haier.uhome.account.api.Const;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: loaded from: classes2.dex */
public class k implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24991c = "Content-Type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f24992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f24993b;

    public interface a {
        String a(String str);
    }

    public k() {
        this(null);
    }

    private static void b(HttpURLConnection httpURLConnection, com.haier.globalwasher.mvp_api.volley.n<?> nVar) throws com.haier.globalwasher.mvp_api.volley.a, IOException {
        byte[] bArrK = nVar.k();
        if (bArrK != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", nVar.l());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bArrK);
            dataOutputStream.close();
        }
    }

    private static HttpEntity d(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    private static boolean e(int i7, int i8) {
        return (i7 == 4 || (100 <= i8 && i8 < 200) || i8 == 204 || i8 == 304) ? false : true;
    }

    private HttpURLConnection f(URL url, com.haier.globalwasher.mvp_api.volley.n<?> nVar) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionC = c(url);
        int iD = nVar.D();
        httpURLConnectionC.setConnectTimeout(iD);
        httpURLConnectionC.setReadTimeout(iD);
        httpURLConnectionC.setUseCaches(false);
        httpURLConnectionC.setDoInput(true);
        if (j0.b.f34226a.equals(url.getProtocol()) && (sSLSocketFactory = this.f24993b) != null) {
            ((HttpsURLConnection) httpURLConnectionC).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionC;
    }

    static void g(HttpURLConnection httpURLConnection, com.haier.globalwasher.mvp_api.volley.n<?> nVar) throws com.haier.globalwasher.mvp_api.volley.a, IOException {
        switch (nVar.r()) {
            case -1:
                byte[] bArrV = nVar.v();
                if (bArrV != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(Const.HTTP_REQUEST_TYPE_POST);
                    httpURLConnection.addRequestProperty("Content-Type", nVar.w());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArrV);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod(Const.HTTP_REQUEST_TYPE_GET);
                return;
            case 1:
                httpURLConnection.setRequestMethod(Const.HTTP_REQUEST_TYPE_POST);
                b(httpURLConnection, nVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, nVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                httpURLConnection.setRequestMethod(h.a.f24990a);
                b(httpURLConnection, nVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.j
    public HttpResponse a(com.haier.globalwasher.mvp_api.volley.n<?> nVar, Map<String, String> map) throws com.haier.globalwasher.mvp_api.volley.a, IOException {
        String strF = nVar.F();
        HashMap map2 = new HashMap();
        map2.putAll(nVar.p());
        map2.putAll(map);
        a aVar = this.f24992a;
        if (aVar != null) {
            String strA = aVar.a(strF);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strF);
            }
            strF = strA;
        }
        HttpURLConnection httpURLConnectionF = f(new URL(strF), nVar);
        for (String str : map2.keySet()) {
            httpURLConnectionF.addRequestProperty(str, (String) map2.get(str));
        }
        g(httpURLConnectionF, nVar);
        ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (httpURLConnectionF.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicStatusLine basicStatusLine = new BasicStatusLine(protocolVersion, httpURLConnectionF.getResponseCode(), httpURLConnectionF.getResponseMessage());
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(basicStatusLine);
        if (e(nVar.r(), basicStatusLine.getStatusCode())) {
            basicHttpResponse.setEntity(d(httpURLConnectionF));
        }
        for (Map.Entry<String, List<String>> entry : httpURLConnectionF.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }

    protected HttpURLConnection c(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public k(a aVar) {
        this(aVar, null);
    }

    public k(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f24992a = aVar;
        this.f24993b = sSLSocketFactory;
    }
}
