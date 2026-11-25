package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f11456b = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11457c = "Prefer-Html-Meta-Tags";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f11458d = "al";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f11459e = "value";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f11460f = "app_name";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f11461g = "class";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f11462h = "package";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f11463i = "url";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f11464j = "should_fallback";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f11465k = "url";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f11466l = "web";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f11467m = "android";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f11468a;

    class a implements m<JSONArray, bolts.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f11469a;

        a(Uri uri) {
            this.f11469a = uri;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public bolts.c a(p<JSONArray> pVar) throws Exception {
            return t.g(t.h(pVar.F()), this.f11469a);
        }
    }

    class b implements m<Void, p<JSONArray>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f11471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f11472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f11473c;

        class a extends WebViewClient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f11475a = false;

            a() {
            }

            private void a(WebView webView) {
                if (this.f11475a) {
                    return;
                }
                this.f11475a = true;
                webView.loadUrl(t.f11456b);
            }

            @Override // android.webkit.WebViewClient
            public void onLoadResource(WebView webView, String str) {
                super.onLoadResource(webView, str);
                a(webView);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                a(webView);
            }
        }

        /* JADX INFO: renamed from: bolts.t$b$b, reason: collision with other inner class name */
        class C0138b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f11477a;

            C0138b(q qVar) {
                this.f11477a = qVar;
            }

            @JavascriptInterface
            public void setValue(String str) {
                try {
                    this.f11477a.g(new JSONArray(str));
                } catch (JSONException e8) {
                    this.f11477a.f(e8);
                }
            }
        }

        b(l lVar, Uri uri, l lVar2) {
            this.f11471a = lVar;
            this.f11472b = uri;
            this.f11473c = lVar2;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p<JSONArray> a(p<Void> pVar) throws Exception {
            q qVar = new q();
            WebView webView = new WebView(t.this.f11468a);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setNetworkAvailable(false);
            webView.setWebViewClient(new a());
            webView.addJavascriptInterface(new C0138b(qVar), "boltsWebViewAppLinkResolverResult");
            webView.loadDataWithBaseURL(this.f11472b.toString(), (String) this.f11473c.a(), this.f11471a.a() != null ? ((String) this.f11471a.a()).split(com.alipay.sdk.util.j.f13806b)[0] : null, null, null);
            return qVar.a();
        }
    }

    class c implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Uri f11479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ l f11480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f11481c;

        c(Uri uri, l lVar, l lVar2) {
            this.f11479a = uri;
            this.f11480b = lVar;
            this.f11481c = lVar2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            URL url = new URL(this.f11479a.toString());
            URLConnection uRLConnectionOpenConnection = null;
            while (url != null) {
                uRLConnectionOpenConnection = url.openConnection();
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnectionOpenConnection).setInstanceFollowRedirects(true);
                }
                uRLConnectionOpenConnection.setRequestProperty(t.f11457c, t.f11458d);
                uRLConnectionOpenConnection.connect();
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() < 400) {
                        URL url2 = new URL(httpURLConnection.getHeaderField(com.google.common.net.c.f22157m0));
                        httpURLConnection.disconnect();
                        url = url2;
                    }
                }
                url = null;
            }
            try {
                this.f11480b.b(t.i(uRLConnectionOpenConnection));
                this.f11481c.b(uRLConnectionOpenConnection.getContentType());
                return null;
            } finally {
                if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnectionOpenConnection).disconnect();
                }
            }
        }
    }

    public t(Context context) {
        this.f11468a = context;
    }

    private static List<Map<String, Object>> f(Map<String, Object> map, String str) {
        List<Map<String, Object>> list = (List) map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x010f  */
    public static bolts.c g(Map<String, Object> map, Uri uri) {
        Uri uriJ;
        ArrayList arrayList = new ArrayList();
        List listEmptyList = (List) map.get("android");
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        Iterator it = listEmptyList.iterator();
        while (true) {
            int i7 = 0;
            if (!it.hasNext()) {
                break;
            }
            Map map2 = (Map) it.next();
            List<Map<String, Object>> listF = f(map2, "url");
            List<Map<String, Object>> listF2 = f(map2, f11462h);
            List<Map<String, Object>> listF3 = f(map2, "class");
            List<Map<String, Object>> listF4 = f(map2, "app_name");
            int iMax = Math.max(listF.size(), Math.max(listF2.size(), Math.max(listF3.size(), listF4.size())));
            while (i7 < iMax) {
                arrayList.add(new bolts.c.a((String) (listF2.size() > i7 ? listF2.get(i7).get(f11459e) : null), (String) (listF3.size() > i7 ? listF3.get(i7).get(f11459e) : null), j((String) (listF.size() > i7 ? listF.get(i7).get(f11459e) : null)), (String) (listF4.size() > i7 ? listF4.get(i7).get(f11459e) : null)));
                i7++;
            }
        }
        List list = (List) map.get("web");
        if (list == null || list.size() <= 0) {
            uriJ = uri;
        } else {
            Map map3 = (Map) list.get(0);
            List list2 = (List) map3.get("url");
            List list3 = (List) map3.get(f11464j);
            if (list3 != null && list3.size() > 0) {
                uriJ = Arrays.asList("no", com.paytm.pgsdk.d.G, "0").contains(((String) ((Map) list3.get(0)).get(f11459e)).toLowerCase()) ? null : uri;
            }
            if (uriJ != null && list2 != null && list2.size() > 0) {
                uriJ = j((String) ((Map) list2.get(0)).get(f11459e));
            }
        }
        return new bolts.c(uri, arrayList, uriJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> h(JSONArray jSONArray) throws JSONException {
        HashMap map = new HashMap();
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i7);
            String[] strArrSplit = jSONObject.getString("property").split(":");
            if (strArrSplit[0].equals(f11458d)) {
                Map map2 = map;
                int i8 = 1;
                while (true) {
                    if (i8 >= strArrSplit.length) {
                        break;
                    }
                    List arrayList = (List) map2.get(strArrSplit[i8]);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map2.put(strArrSplit[i8], arrayList);
                    }
                    Map map3 = arrayList.size() > 0 ? (Map) arrayList.get(arrayList.size() - 1) : null;
                    if (map3 == null || i8 == strArrSplit.length - 1) {
                        map2 = new HashMap();
                        arrayList.add(map2);
                    } else {
                        map2 = map3;
                    }
                    i8++;
                }
                if (jSONObject.has("content")) {
                    if (jSONObject.isNull("content")) {
                        map2.put(f11459e, null);
                    } else {
                        map2.put(f11459e, jSONObject.getString("content"));
                    }
                }
            }
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        int i7;
        if (uRLConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            try {
                inputStream = uRLConnection.getInputStream();
            } catch (Exception unused) {
                inputStream = httpURLConnection.getErrorStream();
            }
        } else {
            inputStream = uRLConnection.getInputStream();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i8 = inputStream.read(bArr);
                if (i8 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i8);
            }
            String contentEncoding = uRLConnection.getContentEncoding();
            if (contentEncoding == null) {
                for (String str : uRLConnection.getContentType().split(com.alipay.sdk.util.j.f13806b)) {
                    String strTrim = str.trim();
                    if (strTrim.startsWith("charset=")) {
                        contentEncoding = strTrim.substring(8);
                        break;
                    }
                }
                if (contentEncoding == null) {
                    contentEncoding = "UTF-8";
                }
            }
            return new String(byteArrayOutputStream.toByteArray(), contentEncoding);
        } finally {
            inputStream.close();
        }
    }

    private static Uri j(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    @Override // bolts.e
    public p<bolts.c> a(Uri uri) {
        l lVar = new l();
        l lVar2 = new l();
        return p.g(new c(uri, lVar, lVar2)).R(new b(lVar2, uri, lVar), p.f11391k).L(new a(uri));
    }
}
