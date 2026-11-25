package com.haier.globalwasher.mvp_api.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n<T> implements Comparable<n<T>> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f24895p = "UTF-8";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static long f24896q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v.a f24897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f24900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.moudle.b f24903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f24904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private o f24905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f24906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f24907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f24908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private r f24909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.volley.b.a f24910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Object f24911o;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f24912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f24913b;

        a(String str, long j7) {
            this.f24912a = str;
            this.f24913b = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.f24897a.a(this.f24912a, this.f24913b);
            n.this.f24897a.b(toString());
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f24915a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f24916b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f24917c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f24918d = 2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f24919e = 3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f24920f = 4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f24921g = 5;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f24922h = 6;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f24923i = 7;
    }

    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    @Deprecated
    public n(String str, com.haier.globalwasher.mvp_api.moudle.b bVar) {
        this(-1, str, bVar);
    }

    private static String e(int i7, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Request:");
        sb.append(i7);
        sb.append(":");
        sb.append(str);
        sb.append(":");
        sb.append(System.currentTimeMillis());
        sb.append(":");
        long j7 = f24896q;
        f24896q = 1 + j7;
        sb.append(j7);
        return f.b(sb.toString());
    }

    private byte[] h(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append(h0.f35378d);
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException("Encoding not supported: " + str, e8);
        }
    }

    private static int i(String str) {
        Uri uri;
        String host;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null || (host = uri.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public r A() {
        return this.f24909m;
    }

    public final int B() {
        Integer num = this.f24904h;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public Object C() {
        return this.f24911o;
    }

    public final int D() {
        return this.f24909m.a();
    }

    public int E() {
        return this.f24902f;
    }

    public String F() {
        String str = this.f24900d;
        return str != null ? str : this.f24899c;
    }

    public boolean G() {
        return this.f24908l;
    }

    public boolean H() {
        return this.f24907k;
    }

    public void I() {
        this.f24908l = true;
    }

    protected void J() {
        this.f24903g = null;
    }

    protected u K(u uVar) {
        return uVar;
    }

    protected abstract p<T> L(j jVar);

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> M(com.haier.globalwasher.mvp_api.volley.b.a aVar) {
        this.f24910n = aVar;
        return this;
    }

    public void N(String str) {
        this.f24900d = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> O(o oVar) {
        this.f24905i = oVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> P(r rVar) {
        this.f24909m = rVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> Q(int i7) {
        this.f24904h = Integer.valueOf(i7);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n<?> R(boolean z7) {
        this.f24906j = z7;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n<?> S(Object obj) {
        this.f24911o = obj;
        return this;
    }

    public final boolean T() {
        return this.f24906j;
    }

    public void b(String str) {
        if (v.a.f25047c) {
            this.f24897a.a(str, Thread.currentThread().getId());
        }
    }

    public void c() {
        this.f24907k = true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(n<T> nVar) {
        c cVarZ = z();
        c cVarZ2 = nVar.z();
        return cVarZ == cVarZ2 ? this.f24904h.intValue() - nVar.f24904h.intValue() : cVarZ2.ordinal() - cVarZ.ordinal();
    }

    public void f(u uVar) {
        com.haier.globalwasher.mvp_api.moudle.b bVar = this.f24903g;
        if (bVar != null) {
            bVar.a(uVar);
        }
    }

    protected abstract void g(T t7);

    void j(String str) {
        o oVar = this.f24905i;
        if (oVar != null) {
            oVar.e(this);
            J();
        }
        if (v.a.f25047c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
            } else {
                this.f24897a.a(str, id);
                this.f24897a.b(toString());
            }
        }
    }

    public byte[] k() throws com.haier.globalwasher.mvp_api.volley.a {
        Map<String, String> mapT = t();
        if (mapT == null || mapT.size() <= 0) {
            return null;
        }
        return h(mapT, u());
    }

    public String l() {
        return "application/x-www-form-urlencoded; charset=" + u();
    }

    public com.haier.globalwasher.mvp_api.volley.b.a m() {
        return this.f24910n;
    }

    public String n() {
        return this.f24898b + ":" + this.f24899c;
    }

    public com.haier.globalwasher.mvp_api.moudle.b o() {
        return this.f24903g;
    }

    public Map<String, String> p() throws com.haier.globalwasher.mvp_api.volley.a {
        return Collections.emptyMap();
    }

    public String q() {
        return this.f24901e;
    }

    public int r() {
        return this.f24898b;
    }

    public String s() {
        return this.f24899c;
    }

    protected Map<String, String> t() throws com.haier.globalwasher.mvp_api.volley.a {
        return null;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(E());
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24907k ? "[X] " : "[ ] ");
        sb.append(F());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(z());
        sb.append(" ");
        sb.append(this.f24904h);
        return sb.toString();
    }

    protected String u() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] v() throws com.haier.globalwasher.mvp_api.volley.a {
        Map<String, String> mapX = x();
        if (mapX == null || mapX.size() <= 0) {
            return null;
        }
        return h(mapX, y());
    }

    @Deprecated
    public String w() {
        return l();
    }

    @Deprecated
    protected Map<String, String> x() throws com.haier.globalwasher.mvp_api.volley.a {
        return t();
    }

    @Deprecated
    protected String y() {
        return u();
    }

    public c z() {
        return c.NORMAL;
    }

    public n(int i7, String str, com.haier.globalwasher.mvp_api.moudle.b bVar) {
        this.f24897a = v.a.f25047c ? new v.a() : null;
        this.f24906j = true;
        this.f24907k = false;
        this.f24908l = false;
        this.f24910n = null;
        this.f24898b = i7;
        this.f24899c = str;
        this.f24901e = e(i7, str);
        this.f24903g = bVar;
        P(new d());
        this.f24902f = i(str);
    }
}
