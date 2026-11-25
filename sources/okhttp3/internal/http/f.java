package okhttp3.internal.http;

import com.haier.uhome.account.api.Const;
import h5.l;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f37879a = new f();

    private f() {
    }

    @l
    public static final boolean b(@a7.d String method) {
        l0.p(method, "method");
        return (l0.g(method, Const.HTTP_REQUEST_TYPE_GET) || l0.g(method, "HEAD")) ? false : true;
    }

    @l
    public static final boolean e(@a7.d String method) {
        l0.p(method, "method");
        return l0.g(method, Const.HTTP_REQUEST_TYPE_POST) || l0.g(method, "PUT") || l0.g(method, com.haier.globalwasher.mvp_api.volley.toolbox.h.a.f24990a) || l0.g(method, "PROPPATCH") || l0.g(method, "REPORT");
    }

    public final boolean a(@a7.d String method) {
        l0.p(method, "method");
        return l0.g(method, Const.HTTP_REQUEST_TYPE_POST) || l0.g(method, com.haier.globalwasher.mvp_api.volley.toolbox.h.a.f24990a) || l0.g(method, "PUT") || l0.g(method, "DELETE") || l0.g(method, "MOVE");
    }

    public final boolean c(@a7.d String method) {
        l0.p(method, "method");
        return !l0.g(method, "PROPFIND");
    }

    public final boolean d(@a7.d String method) {
        l0.p(method, "method");
        return l0.g(method, "PROPFIND");
    }
}
