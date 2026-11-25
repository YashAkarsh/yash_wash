package com.haier.globalwasher.mvp_api.volley.toolbox;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes2.dex */
public class h implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f24988b = "Content-Type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final HttpClient f24989a;

    public static final class a extends HttpEntityEnclosingRequestBase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f24990a = "PATCH";

        public a() {
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return f24990a;
        }

        public a(URI uri) {
            setURI(uri);
        }

        public a(String str) {
            setURI(URI.create(str));
        }
    }

    public h(HttpClient httpClient) {
        this.f24989a = httpClient;
    }

    private static void b(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    static HttpUriRequest c(com.haier.globalwasher.mvp_api.volley.n<?> nVar, Map<String, String> map) throws com.haier.globalwasher.mvp_api.volley.a {
        switch (nVar.r()) {
            case -1:
                byte[] bArrV = nVar.v();
                if (bArrV == null) {
                    return new HttpGet(nVar.F());
                }
                HttpPost httpPost = new HttpPost(nVar.F());
                httpPost.addHeader("Content-Type", nVar.w());
                httpPost.setEntity(new ByteArrayEntity(bArrV));
                return httpPost;
            case 0:
                return new HttpGet(nVar.F());
            case 1:
                HttpPost httpPost2 = new HttpPost(nVar.F());
                httpPost2.addHeader("Content-Type", nVar.l());
                f(httpPost2, nVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(nVar.F());
                httpPut.addHeader("Content-Type", nVar.l());
                f(httpPut, nVar);
                return httpPut;
            case 3:
                return new HttpDelete(nVar.F());
            case 4:
                return new HttpHead(nVar.F());
            case 5:
                return new HttpOptions(nVar.F());
            case 6:
                return new HttpTrace(nVar.F());
            case 7:
                a aVar = new a(nVar.F());
                aVar.addHeader("Content-Type", nVar.l());
                f(aVar, nVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static List<NameValuePair> d(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (String str : map.keySet()) {
            arrayList.add(new BasicNameValuePair(str, map.get(str)));
        }
        return arrayList;
    }

    private static void f(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, com.haier.globalwasher.mvp_api.volley.n<?> nVar) throws com.haier.globalwasher.mvp_api.volley.a {
        byte[] bArrK = nVar.k();
        if (bArrK != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(bArrK));
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.j
    public HttpResponse a(com.haier.globalwasher.mvp_api.volley.n<?> nVar, Map<String, String> map) throws com.haier.globalwasher.mvp_api.volley.a, IOException {
        HttpUriRequest httpUriRequestC = c(nVar, map);
        b(httpUriRequestC, map);
        b(httpUriRequestC, nVar.p());
        e(httpUriRequestC);
        HttpParams params = httpUriRequestC.getParams();
        int iD = nVar.D();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, iD);
        return this.f24989a.execute(httpUriRequestC);
    }

    protected void e(HttpUriRequest httpUriRequest) throws IOException {
    }
}
