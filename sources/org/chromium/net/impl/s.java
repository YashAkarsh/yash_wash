package org.chromium.net.impl;

import android.util.Log;
import android.util.Pair;
import com.haier.uhome.account.api.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import org.chromium.net.k0;
import org.chromium.net.q0;
import org.chromium.net.t0;

/* JADX INFO: loaded from: classes3.dex */
public class s extends org.chromium.net.p.a {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f39405x = "Accept-Encoding";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f39406y = "s";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d f39407f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f39408g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final t0.b f39409h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f39410i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f39411j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f39413l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f39414m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Collection<Object> f39416o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private q0 f39417p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Executor f39418q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f39419r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f39420s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f39421t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f39422u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f39423v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private k0.a f39424w;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ArrayList<Pair<String, String>> f39412k = new ArrayList<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f39415n = 3;

    s(String str, t0.b bVar, Executor executor, d dVar) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (bVar == null) {
            throw new NullPointerException("Callback is required.");
        }
        if (executor == null) {
            throw new NullPointerException("Executor is required.");
        }
        if (dVar == null) {
            throw new NullPointerException("CronetEngine is required.");
        }
        this.f39408g = str;
        this.f39409h = bVar;
        this.f39410i = executor;
        this.f39407f = dVar;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public s p(k0.a aVar) {
        this.f39424w = aVar;
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public s q(int i7) {
        this.f39420s = true;
        this.f39421t = i7;
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public s r(int i7) {
        this.f39422u = true;
        this.f39423v = i7;
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public s g(q0 q0Var, Executor executor) {
        if (q0Var == null) {
            throw new NullPointerException("Invalid UploadDataProvider.");
        }
        if (executor == null) {
            throw new NullPointerException("Invalid UploadDataProvider Executor.");
        }
        if (this.f39411j == null) {
            this.f39411j = Const.HTTP_REQUEST_TYPE_POST;
        }
        this.f39417p = q0Var;
        this.f39418q = executor;
        return this;
    }

    @Override // org.chromium.net.p.a, org.chromium.net.t0.a
    /* JADX INFO: renamed from: n */
    public org.chromium.net.p.a e(String str) {
        if (str == null) {
            throw new NullPointerException("Method is required.");
        }
        this.f39411j = str;
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public s a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Invalid header name.");
        }
        if (str2 == null) {
            throw new NullPointerException("Invalid header value.");
        }
        if ("Accept-Encoding".equalsIgnoreCase(str)) {
            Log.w(f39406y, "It's not necessary to set Accept-Encoding on requests - cronet will do this automatically for you, and setting it yourself has no effect. See https://crbug.com/581399 for details.", new Exception());
            return this;
        }
        this.f39412k.add(Pair.create(str, str2));
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public s i(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Invalid metrics annotation.");
        }
        if (this.f39416o == null) {
            this.f39416o = new ArrayList();
        }
        this.f39416o.add(obj);
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public s b() {
        this.f39419r = true;
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public r c() {
        r rVarZ = this.f39407f.z(this.f39408g, this.f39409h, this.f39410i, this.f39415n, this.f39416o, this.f39413l, this.f39414m, this.f39419r, this.f39420s, this.f39421t, this.f39422u, this.f39423v, this.f39424w);
        String str = this.f39411j;
        if (str != null) {
            rVarZ.i(str);
        }
        for (Pair<String, String> pair : this.f39412k) {
            rVarZ.g((String) pair.first, (String) pair.second);
        }
        q0 q0Var = this.f39417p;
        if (q0Var != null) {
            rVarZ.j(q0Var, this.f39418q);
        }
        return rVarZ;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public s d() {
        this.f39413l = true;
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public s m() {
        this.f39414m = true;
        return this;
    }

    @Override // org.chromium.net.p.a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public s f(int i7) {
        this.f39415n = i7;
        return this;
    }
}
