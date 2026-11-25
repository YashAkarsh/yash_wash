package com.haier.uhome.usdk.base.service;

import android.content.Context;
import android.text.TextUtils;
import com.haier.library.common.thread.m;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final String A = "https://standardcfm-gea-us.haieriot.net:443/hardwareconfig/config/getDownUrlByFormat";
    private static final String B = "https://standardcfm-sea.haieriot.net:443/hardwareconfig/config/getDownUrlByFormat";
    private static final String C = "https://standardcfm.haigeek.com:443/hardwareconfig/app/config/getDownUrlByFormat";
    private static final String D = "http://uhome.haier.net:6050/logserver/v3/usdklog";
    private static final String E = "http://bigdata-sea.haieriot.net/loggateway/v3/usdklog";
    private static final int F = 0;
    private static final int G = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f31349r = "gw-gea-euro.haieriot.net";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f31350s = "gw-gea-us.haieriot.net";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f31351t = "gw-sea.haieriot.net";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f31352u = "gw.haier.net";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f31353v = "uws-gea-euro.haieriot.net";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f31354w = "uws-gea-us.haieriot.net";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f31355x = "uws-sea.haieriot.net";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f31356y = "uws.haier.net";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f31357z = "https://standardcfm-gea-euro.haieriot.net:443/hardwareconfig/config/getDownUrlByFormat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f31358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f31359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f31362e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f31363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f31364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f31365h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f31366i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f31367j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f31368k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f31369l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f31370m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f31371n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f31372o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f31373p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31374q;

    public static abstract class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f31379a;

        public a(c cVar) {
            this.f31379a = cVar;
        }

        public abstract void a(T t7, T t8);
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static e f31380a = new e();

        private b() {
        }
    }

    public enum c {
        TOKEN
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized List<a> r() {
        return new ArrayList(this.f31358a);
    }

    public Context b() {
        return this.f31359b;
    }

    public int c() {
        return this.f31367j;
    }

    public String d() {
        return this.f31371n;
    }

    public String e() {
        return this.f31361d;
    }

    public int f() {
        return this.f31374q;
    }

    public String g() {
        String str = this.f31360c;
        return str == null ? "" : str;
    }

    public String h() {
        return this.f31362e;
    }

    public String i() {
        return this.f31363f;
    }

    public String j() {
        return this.f31364g;
    }

    public String k() {
        String str = this.f31365h;
        if (str != null) {
            return str;
        }
        f(com.haier.library.common.util.f.t(this.f31359b));
        return this.f31365h;
    }

    public String l() {
        return TextUtils.isEmpty(this.f31366i) ? k() : this.f31366i;
    }

    public String m() {
        return this.f31368k;
    }

    public String n() {
        return this.f31369l;
    }

    public int o() {
        return this.f31370m;
    }

    public String p() {
        return this.f31372o;
    }

    public String q() {
        return this.f31373p + "/";
    }

    private e() {
        this.f31358a = new ArrayList();
        a(0);
    }

    public static e a() {
        return b.f31380a;
    }

    private boolean i(String str) {
        return Pattern.compile("(http|https)://([\\w.]+/?)\\S*").matcher(str).matches();
    }

    public void b(String str) {
        e3.a.e("updateToken token to <%s>", str);
        String str2 = this.f31360c;
        if (str2 == null || !str2.equals(str)) {
            a(c.TOKEN, this.f31360c, str);
            this.f31360c = str;
        }
    }

    public void c(String str) {
        this.f31362e = str;
    }

    public void d(String str) {
        this.f31363f = str;
    }

    public void e(String str) {
        this.f31364g = str;
    }

    public void f(String str) {
        this.f31365h = str;
    }

    public void g(String str) {
        e3.a.e("updateAppClientId to <%s>", str);
        this.f31366i = str;
    }

    public ErrorConst h(String str) {
        if (str == null || str.length() <= 0 || !i(str)) {
            return ErrorConst.ERR_USDK_INVALID_PARAM;
        }
        e3.a.e("setProfileServiceUrl url: <%s>", str);
        this.f31368k = str;
        return ErrorConst.RET_USDK_OK;
    }

    public void a(Context context) {
        if (context == null) {
            e3.a.v("setContext param context is null", new Object[0]);
            this.f31359b = null;
            this.f31373p = null;
        } else {
            this.f31359b = context.getApplicationContext();
            this.f31373p = com.haier.uhome.usdk.base.utils.f.b(context).getPath();
            e(com.haier.uhome.usdk.base.utils.f.a(context));
        }
    }

    public synchronized void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f31358a.remove(aVar);
    }

    public boolean a(int i7) {
        this.f31367j = i7;
        if (i7 == 0) {
            this.f31369l = f31352u;
            this.f31370m = 56811;
            this.f31371n = f31356y;
            this.f31368k = C;
            this.f31372o = D;
            this.f31374q = 0;
        } else if (i7 == 1) {
            this.f31369l = f31350s;
            this.f31370m = 56815;
            this.f31371n = f31354w;
            this.f31368k = A;
            this.f31372o = null;
            this.f31374q = 1;
        } else if (i7 == 2) {
            this.f31369l = f31349r;
            this.f31370m = 56815;
            this.f31371n = f31353v;
            this.f31368k = f31357z;
            this.f31372o = null;
            this.f31374q = 1;
        } else {
            if (i7 != 3) {
                e3.a.v("setArea error, area = %d", Integer.valueOf(i7));
                return false;
            }
            this.f31369l = f31351t;
            this.f31370m = 56815;
            this.f31371n = f31355x;
            this.f31368k = B;
            this.f31372o = E;
            this.f31374q = 1;
        }
        return true;
    }

    public void a(String str) {
        this.f31361d = str;
    }

    private void a(final c cVar, final Object obj, final Object obj2) {
        new m<Void, Void, Void>() { // from class: com.haier.uhome.usdk.base.service.e.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                for (a aVar : e.this.r()) {
                    if (aVar.f31379a == cVar) {
                        aVar.a(obj, obj2);
                    }
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    public synchronized void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (!this.f31358a.contains(aVar)) {
            this.f31358a.add(aVar);
        }
    }
}
