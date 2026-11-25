package org.chromium.net.urlconnection;

import android.annotation.SuppressLint;
import android.util.Log;
import android.util.Pair;
import com.haier.uhome.account.api.Const;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.chromium.net.j;
import org.chromium.net.k;
import org.chromium.net.p;
import org.chromium.net.t0;
import org.chromium.net.u0;

/* JADX INFO: loaded from: classes3.dex */
public class d extends HttpURLConnection {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f39551q = "d";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f39552r = "Content-Length";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f39553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f39554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private t0 f39555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<Pair<String, String>> f39556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f39557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f39558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f39559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f39560h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private f f39561i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private g f39562j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private u0 f39563k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IOException f39564l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f39565m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f39566n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<Map.Entry<String, String>> f39567o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Map<String, List<String>> f39568p;

    private class a extends t0.b {
        public a() {
        }

        private void g(IOException iOException) {
            d.this.f39564l = iOException;
            if (d.this.f39561i != null) {
                d.this.f39561i.f(iOException);
            }
            if (d.this.f39562j != null) {
                d.this.f39562j.v(iOException);
            }
            d.this.f39566n = true;
            d.this.f39554b.f();
        }

        @Override // org.chromium.net.t0.b
        public void a(t0 t0Var, u0 u0Var) {
            d.this.f39563k = u0Var;
            g(new IOException("disconnect() called"));
        }

        @Override // org.chromium.net.t0.b
        public void b(t0 t0Var, u0 u0Var, k kVar) {
            if (kVar == null) {
                throw new IllegalStateException("Exception cannot be null in onFailed.");
            }
            d.this.f39563k = u0Var;
            g(kVar);
        }

        @Override // org.chromium.net.t0.b
        public void c(t0 t0Var, u0 u0Var, ByteBuffer byteBuffer) {
            d.this.f39563k = u0Var;
            d.this.f39554b.f();
        }

        @Override // org.chromium.net.t0.b
        public void d(t0 t0Var, u0 u0Var, String str) {
            d.this.f39565m = true;
            try {
                URL url = new URL(str);
                boolean zEquals = url.getProtocol().equals(((HttpURLConnection) d.this).url.getProtocol());
                if (((HttpURLConnection) d.this).instanceFollowRedirects) {
                    ((HttpURLConnection) d.this).url = url;
                }
                if (((HttpURLConnection) d.this).instanceFollowRedirects && zEquals) {
                    d.this.f39555c.b();
                    return;
                }
            } catch (MalformedURLException unused) {
            }
            d.this.f39563k = u0Var;
            d.this.f39555c.a();
            g(null);
        }

        @Override // org.chromium.net.t0.b
        public void e(t0 t0Var, u0 u0Var) {
            d.this.f39563k = u0Var;
            d.this.f39566n = true;
            d.this.f39554b.f();
        }

        @Override // org.chromium.net.t0.b
        public void f(t0 t0Var, u0 u0Var) {
            d.this.f39563k = u0Var;
            g(null);
        }
    }

    public d(URL url, j jVar) {
        super(url);
        this.f39553a = jVar;
        this.f39554b = new i();
        this.f39561i = new f(this);
        this.f39556d = new ArrayList();
    }

    private void m() throws IOException {
        if (!this.f39566n) {
            throw new IllegalStateException("No response.");
        }
        IOException iOException = this.f39564l;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f39563k == null) {
            throw new NullPointerException("Response info is null when there is no exception.");
        }
    }

    private int n(String str) {
        for (int i7 = 0; i7 < this.f39556d.size(); i7++) {
            if (((String) this.f39556d.get(i7).first).equalsIgnoreCase(str)) {
                return i7;
            }
        }
        return -1;
    }

    private Map<String, List<String>> o() {
        Map<String, List<String>> map = this.f39568p;
        if (map != null) {
            return map;
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, String> entry : p()) {
            ArrayList arrayList = new ArrayList();
            if (treeMap.containsKey(entry.getKey())) {
                arrayList.addAll((Collection) treeMap.get(entry.getKey()));
            }
            arrayList.add(entry.getValue());
            treeMap.put(entry.getKey(), Collections.unmodifiableList(arrayList));
        }
        Map<String, List<String>> mapUnmodifiableMap = Collections.unmodifiableMap(treeMap);
        this.f39568p = mapUnmodifiableMap;
        return mapUnmodifiableMap;
    }

    private List<Map.Entry<String, String>> p() {
        List<Map.Entry<String, String>> list = this.f39567o;
        if (list != null) {
            return list;
        }
        this.f39567o = new ArrayList();
        for (Map.Entry<String, String> entry : this.f39563k.b()) {
            if (!entry.getKey().equalsIgnoreCase(com.google.common.net.c.X)) {
                this.f39567o.add(new AbstractMap.SimpleImmutableEntry(entry));
            }
        }
        List<Map.Entry<String, String>> listUnmodifiableList = Collections.unmodifiableList(this.f39567o);
        this.f39567o = listUnmodifiableList;
        return listUnmodifiableList;
    }

    private Map.Entry<String, String> q(int i7) {
        try {
            s();
            List<Map.Entry<String, String>> listP = p();
            if (i7 >= listP.size()) {
                return null;
            }
            return listP.get(i7);
        } catch (IOException unused) {
            return null;
        }
    }

    private void s() throws IOException {
        g gVar = this.f39562j;
        if (gVar != null) {
            gVar.q();
            if (u()) {
                this.f39562j.close();
            }
        }
        if (!this.f39566n) {
            y();
            this.f39554b.d();
        }
        m();
    }

    @SuppressLint({"NewApi"})
    private long t() {
        long j7 = ((HttpURLConnection) this).fixedContentLength;
        try {
            long j8 = getClass().getField("fixedContentLengthLong").getLong(this);
            return j8 != -1 ? j8 : j7;
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return j7;
        }
    }

    private boolean u() {
        return ((HttpURLConnection) this).chunkLength > 0;
    }

    private final void v(String str, String str2, boolean z7) {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot modify request property after connection is made.");
        }
        int iN = n(str);
        if (iN >= 0) {
            if (!z7) {
                throw new UnsupportedOperationException("Cannot add multiple headers of the same key, " + str + ". crbug.com/432719.");
            }
            this.f39556d.remove(iN);
        }
        this.f39556d.add(Pair.create(str, str2));
    }

    private void y() throws IOException {
        if (((HttpURLConnection) this).connected) {
            return;
        }
        p.a aVar = (p.a) this.f39553a.e(getURL().toString(), new a(), this.f39554b);
        if (((HttpURLConnection) this).doOutput) {
            if (((HttpURLConnection) this).method.equals(Const.HTTP_REQUEST_TYPE_GET)) {
                ((HttpURLConnection) this).method = Const.HTTP_REQUEST_TYPE_POST;
            }
            g gVar = this.f39562j;
            if (gVar != null) {
                aVar.g(gVar.r(), this.f39554b);
                if (getRequestProperty("Content-Length") == null && !u()) {
                    addRequestProperty("Content-Length", Long.toString(this.f39562j.r().b()));
                }
                this.f39562j.u();
            } else if (getRequestProperty("Content-Length") == null) {
                addRequestProperty("Content-Length", "0");
            }
            if (getRequestProperty("Content-Type") == null) {
                addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
        }
        for (Pair<String, String> pair : this.f39556d) {
            aVar.a((String) pair.first, (String) pair.second);
        }
        if (!getUseCaches()) {
            aVar.d();
        }
        aVar.e(((HttpURLConnection) this).method);
        if (this.f39557e) {
            aVar.q(this.f39558f);
        }
        if (this.f39559g) {
            aVar.r(this.f39560h);
        }
        p pVarC = aVar.c();
        this.f39555c = pVarC;
        pVarC.f();
        ((HttpURLConnection) this).connected = true;
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        v(str, str2, false);
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        getOutputStream();
        y();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (((HttpURLConnection) this).connected) {
            this.f39555c.a();
        }
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            s();
            if (this.f39563k.c() >= 400) {
                return this.f39561i;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        try {
            s();
            Map<String, List<String>> mapO = o();
            if (!mapO.containsKey(str)) {
                return null;
            }
            List<String> list = mapO.get(str);
            return list.get(list.size() - 1);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i7) {
        Map.Entry<String, String> entryQ = q(i7);
        if (entryQ == null) {
            return null;
        }
        return entryQ.getKey();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            s();
            return o();
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        s();
        if (!((HttpURLConnection) this).instanceFollowRedirects && this.f39565m) {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (this.f39563k.c() < 400) {
            return this.f39561i;
        }
        throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        if (this.f39562j == null && ((HttpURLConnection) this).doOutput) {
            if (((HttpURLConnection) this).connected) {
                throw new ProtocolException("Cannot write to OutputStream after receiving response.");
            }
            if (u()) {
                this.f39562j = new b(this, ((HttpURLConnection) this).chunkLength, this.f39554b);
                y();
            } else {
                long jT = t();
                if (jT != -1) {
                    this.f39562j = new c(this, jT, this.f39554b);
                    y();
                } else {
                    Log.d(f39551q, "Outputstream is being buffered in memory.");
                    String requestProperty = getRequestProperty("Content-Length");
                    if (requestProperty == null) {
                        this.f39562j = new org.chromium.net.urlconnection.a(this);
                    } else {
                        this.f39562j = new org.chromium.net.urlconnection.a(this, Long.parseLong(requestProperty));
                    }
                }
            }
        }
        return this.f39562j;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot access request headers after connection is set.");
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Pair<String, String> pair : this.f39556d) {
            if (treeMap.containsKey(pair.first)) {
                throw new IllegalStateException("Should not have multiple values.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add((String) pair.second);
            treeMap.put((String) pair.first, Collections.unmodifiableList(arrayList));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        int iN = n(str);
        if (iN >= 0) {
            return (String) this.f39556d.get(iN).second;
        }
        return null;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        s();
        return this.f39563k.c();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        s();
        return this.f39563k.d();
    }

    void r(ByteBuffer byteBuffer) throws IOException {
        this.f39555c.e(byteBuffer);
        this.f39554b.e(getReadTimeout());
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i7) {
        Log.d(f39551q, "setConnectTimeout is not supported by CronetHttpURLConnection");
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        v(str, str2, true);
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    public void w(int i7) {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot modify traffic stats tag after connection is made.");
        }
        this.f39557e = true;
        this.f39558f = i7;
    }

    public void x(int i7) {
        if (((HttpURLConnection) this).connected) {
            throw new IllegalStateException("Cannot modify traffic stats UID after connection is made.");
        }
        this.f39559g = true;
        this.f39560h = i7;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i7) {
        Map.Entry<String, String> entryQ = q(i7);
        if (entryQ == null) {
            return null;
        }
        return entryQ.getValue();
    }
}
