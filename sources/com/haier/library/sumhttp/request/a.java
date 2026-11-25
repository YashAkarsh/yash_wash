package com.haier.library.sumhttp.request;

import android.text.TextUtils;
import com.haier.globalwasher.presenter.o;
import com.haier.library.sumhttp.response.g;
import com.haier.library.sumhttp.response.h;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.r;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n3.e;
import n3.f;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f27973a;

    /* JADX INFO: renamed from: com.haier.library.sumhttp.request.a$a, reason: collision with other inner class name */
    class C0363a implements m3.a<g> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ICallback f27974j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ String f27975k;

        C0363a(ICallback iCallback, String str) {
            this.f27974j = iCallback;
            this.f27975k = str;
        }

        @Override // m3.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(g gVar) {
            if (gVar == null) {
                e3.a.e("originalDeviceModelInfo is null", new Object[0]);
                uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                error.a("originalDeviceModelInfo is null");
                this.f27974j.onFailure(error);
                return;
            }
            if (!"00000".equals(gVar.b())) {
                e3.a.d("Failed to get model information deviceMac = %s, RetCode = %s, RetInfo = %s", this.f27975k, gVar.b(), gVar.c());
                uSDKError error2 = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                error2.a(gVar.b());
                this.f27974j.onFailure(error2);
                return;
            }
            if (gVar.a() == null) {
                e3.a.e("OriginalDeviceModelInfo Payload is null", new Object[0]);
                uSDKError error3 = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                error3.a("OriginalDeviceModelInfo Payload is null");
                this.f27974j.onFailure(error3);
                return;
            }
            e3.a.e("onSuccess to getDeviceModelInfo deviceMac = %s", this.f27975k);
            e eVar = new e();
            eVar.r(gVar.a().s());
            eVar.r(gVar.a().s());
            eVar.t(gVar.a().t());
            eVar.u(gVar.a().u());
            eVar.v(gVar.a().v());
            eVar.w(gVar.a().w());
            eVar.x(gVar.a().x());
            eVar.y(gVar.a().y());
            eVar.z(gVar.a().z());
            eVar.A(gVar.a().A());
            eVar.B(gVar.a().B());
            f fVar = new f();
            fVar.R(gVar.a().l());
            fVar.C(gVar.a().a());
            fVar.D(gVar.a().b());
            fVar.E(gVar.a().c());
            fVar.F(gVar.a().d());
            fVar.H(gVar.a().e());
            fVar.I(gVar.a().f());
            fVar.J(gVar.a().g());
            fVar.M(gVar.a().h());
            fVar.N(gVar.a().i());
            fVar.O(gVar.a().j());
            fVar.P(gVar.a().k());
            fVar.S(gVar.a().m());
            fVar.T(gVar.a().n());
            fVar.U(gVar.a().o());
            fVar.V(gVar.a().p());
            fVar.X(gVar.a().r());
            fVar.Y(gVar.a().C());
            fVar.L(eVar);
            this.f27974j.onSuccess(fVar);
        }

        @Override // m3.a
        public void onError(Exception exc) {
            e3.a.e("getDeviceModelInfo exception = %s", exc.toString());
            uSDKError error = ErrorConst.ERR_USDK_NETWORK_EXCEPTION.toError();
            error.setDescription(exc.getMessage());
            this.f27974j.onFailure(error);
        }
    }

    private <T> void d(int i7, String str, String str2, String str3, String str4, m3.a<T> aVar) {
        n3.b bVar = new n3.b();
        bVar.e(str);
        bVar.f(str2);
        bVar.d(str3);
        String strZ = com.haier.library.json.a.Z(bVar);
        String str5 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + l3.a.f37423f;
        String strI = com.haier.uhome.usdk.base.service.e.a().i();
        b.a().b(2).j(str5).d(strI).h(com.haier.uhome.usdk.base.service.e.a().h()).e(strZ, l3.a.f37423f, com.haier.uhome.usdk.base.service.e.a().l(), com.haier.uhome.usdk.base.service.e.a().g(), str4).c(new m3.b(aVar)).k(strZ).g(i7).i();
    }

    public static a h() {
        if (f27973a == null) {
            synchronized (a.class) {
                if (f27973a == null) {
                    f27973a = new a();
                }
            }
        }
        return f27973a;
    }

    public static boolean l(Exception exc) {
        Class<?> cls = exc.getClass();
        return cls == SocketTimeoutException.class || cls == ConnectException.class;
    }

    public <T> void a(String str, String str2, String str3, String str4, String str5, String str6, m3.a<T> aVar) {
        if (str5 != null) {
            n3.a aVar2 = new n3.a();
            aVar2.b(str5);
            String strZ = com.haier.library.json.a.Z(aVar2);
            b.a().b(2).j("https://" + com.haier.uhome.usdk.base.service.e.a().d() + l3.a.f37422e).d(str).h(str2).e(strZ, l3.a.f37422e, str3, str4, str6).c(new m3.b(aVar)).k(strZ).g(15).i();
        }
    }

    public <T> void b(int i7, String str, String str2, String str3, ICallback<f> iCallback) {
        c(i7, "", str, str2, str3, iCallback);
    }

    public <T> void c(int i7, String str, String str2, String str3, String str4, ICallback<f> iCallback) {
        if (iCallback == null) {
            e3.a.e("getDeviceModelInfo iCallback is null", new Object[0]);
            return;
        }
        if (i7 < 5 || i7 > 15) {
            e3.a.e("getDeviceModelInfo Parameter exception", new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("Parameter exception timeout is " + i7);
            iCallback.onFailure(error);
            return;
        }
        if (com.haier.library.common.util.c.j(com.haier.uhome.usdk.base.service.e.a().g())) {
            e3.a.e("getDeviceModelInfo Token is null", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError());
        } else if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            d(i7, str, str2, str3, str4, new C0363a(iCallback, str3));
        } else {
            e3.a.e("getDeviceModelInfo name and wifiMac is null", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_NAME_MAC_NULL.toError());
        }
    }

    public void e(String str, ICallback<f> iCallback) {
        c(15, "", "", str, "", iCallback);
    }

    public <T> void f(m3.a<T> aVar) {
        HashMap map = new HashMap(3);
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        map.put(HttpHelper.a.f29518b, eVarA.j());
        map.put("usdkVersion", r.a().e());
        map.put("strategyType", new String[]{"nc", "to"});
        String strZ = com.haier.library.json.a.Z(map);
        String str = "https://" + eVarA.d() + l3.a.f37425h;
        String strI = eVarA.i();
        b.a().b(2).j(str).d(strI).h(eVarA.h()).e(strZ, l3.a.f37425h, eVarA.l(), eVarA.g(), "").c(new m3.b(aVar)).k(strZ).i();
    }

    public <T> void g(String str, m3.a<T> aVar) {
        HashMap map = new HashMap(1);
        map.put("version", str);
        String strZ = com.haier.library.json.a.Z(map);
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str2 = "https://" + eVarA.d() + l3.a.f37426i;
        String strI = eVarA.i();
        String strH = eVarA.h();
        String strL = eVarA.l();
        String strG = eVarA.g();
        HashMap map2 = new HashMap(2);
        map2.put("apiVersion", "v1");
        map2.put("language", "zh-cn");
        b.a().b(2).j(str2).d(strI).h(strH).g(5).f(strZ, l3.a.f37426i, strL, strG, "", map2).c(new m3.b(aVar)).k(strZ).i();
    }

    public void i(String str, String str2, com.haier.library.okhttp.api.b<InputStream> bVar) {
        d.a().b(1).h(str).d(str2).c(bVar).e(15).g();
    }

    public <T> void j(String str, String str2, m3.a<T> aVar) {
        HashMap map = new HashMap(3);
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        map.put(o.f25218y, str);
        String strZ = com.haier.library.json.a.Z(map);
        String str3 = "https://" + eVarA.d() + l3.a.f37424g;
        String strI = eVarA.i();
        b.a().b(2).j(str3).d(strI).h(eVarA.h()).e(strZ, l3.a.f37424g, eVarA.l(), eVarA.g(), str2).c(new m3.b(aVar)).k(strZ).i();
    }

    public void k(String str, int i7, int i8, String str2, com.haier.library.okhttp.api.f fVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str3 = "https://" + eVarA.d() + l3.a.f37434q;
        o3.c cVar = new o3.c();
        cVar.e(str);
        cVar.f(i7);
        cVar.d(i8);
        String strZ = com.haier.library.json.a.Z(cVar);
        String strI = eVarA.i();
        b.a().b(2).j(str3).d(strI).h(eVarA.h()).e(strZ, l3.a.f37434q, eVarA.l(), eVarA.g(), str2).c(fVar).k(strZ).g(15).i();
    }

    public void m(Map<String, Object> map, m3.a<com.haier.library.sumhttp.response.b> aVar) {
        String strZ = com.haier.library.json.a.Z(map);
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str = "https://" + eVarA.d() + l3.a.f37428k;
        String strI = eVarA.i();
        String strH = eVarA.h();
        String strL = eVarA.l();
        String strG = eVarA.g();
        HashMap map2 = new HashMap(2);
        map2.put("apiVersion", "v1");
        map.putAll(map2);
        b.a().b(2).j(str).d(strI).h(strH).g(5).f(strZ, l3.a.f37428k, strL, strG, "", map2).c(new m3.b(aVar)).k(strZ).i();
    }

    public void n(String str, m3.a<h> aVar) {
        HashMap map = new HashMap(1);
        map.put("mac", str);
        String strZ = com.haier.library.json.a.Z(map);
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str2 = "https://" + eVarA.d() + l3.a.f37427j;
        String strG = eVarA.g();
        String strI = eVarA.i();
        String strH = eVarA.h();
        String strL = eVarA.l();
        HashMap map2 = new HashMap(2);
        map2.put("apiVersion", "v1");
        b.a().b(2).j(str2).d(strI).h(strH).g(5).f(strZ, l3.a.f37427j, strL, strG, "", map2).c(new m3.b(aVar)).k(strZ).i();
    }

    public void o(String str, String str2, com.haier.library.okhttp.api.f fVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str3 = "https://" + eVarA.d() + l3.a.f37431n;
        String strI = eVarA.i();
        b.a().b(2).j(str3).d(strI).h(eVarA.h()).e(str, l3.a.f37431n, eVarA.l(), eVarA.g(), str2).c(fVar).k(str).g(15).i();
    }

    public void p(String str, String str2, String str3, String str4, com.haier.library.okhttp.api.f fVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str5 = "https://" + eVarA.d() + l3.a.f37430m;
        String strI = eVarA.i();
        String strH = eVarA.h();
        String strL = eVarA.l();
        String strG = eVarA.g();
        HashMap map = new HashMap(3);
        map.put(o.f25218y, str);
        map.put("familyId", str2);
        map.put("version", str3);
        String strZ = com.haier.library.json.a.Z(map);
        b.a().b(2).j(str5).d(strI).h(strH).e(strZ, l3.a.f37430m, strL, strG, str4).c(fVar).k(strZ).g(15).i();
    }

    public void q(String str, String str2, com.haier.library.okhttp.api.f fVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str3 = "https://" + eVarA.d() + l3.a.f37435r;
        String strI = eVarA.i();
        b.a().b(2).j(str3).d(strI).h(eVarA.h()).e(str, l3.a.f37435r, eVarA.l(), eVarA.g(), str2).c(fVar).k(str).g(15).i();
    }

    public void r(String str, String str2, com.haier.library.okhttp.api.f fVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str3 = "https://" + eVarA.d() + l3.a.f37436s;
        String strI = eVarA.i();
        b.a().b(2).j(str3).d(strI).h(eVarA.h()).e(str, l3.a.f37436s, eVarA.l(), eVarA.g(), str2).c(fVar).k(str).g(15).i();
    }

    public void s(String str, String str2, String str3, com.haier.library.okhttp.api.f fVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str4 = "https://" + eVarA.d() + l3.a.f37432o;
        HashMap map = new HashMap(2);
        map.put("sceneId", str);
        map.put("familyId", str2);
        String strZ = com.haier.library.json.a.Z(map);
        String strI = eVarA.i();
        b.a().b(2).j(str4).d(strI).h(eVarA.h()).e(strZ, l3.a.f37432o, eVarA.l(), eVarA.g(), str3).c(fVar).k(strZ).g(15).i();
    }

    public <T> void t(String str, m3.a<T> aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        String str2 = "/ddc/app/deviceModel/" + str + "/productCode";
        c.a().b(1).e("", str2).g(l3.a.f37418a + str2).c(new m3.b(aVar)).f(5).h();
    }

    public <T> void u(o3.d dVar, List<o3.f> list, String str, m3.a<T> aVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str2 = "https://" + eVarA.d() + l3.a.f37433p;
        o3.h hVar = new o3.h();
        hVar.c(dVar);
        hVar.d(list);
        String strZ = com.haier.library.json.a.Z(hVar);
        String strI = eVarA.i();
        b.a().b(2).j(str2).d(strI).h(eVarA.h()).e(strZ, l3.a.f37433p, eVarA.l(), eVarA.g(), str).c(new m3.b(aVar)).k(strZ).g(15).i();
    }

    public <T> void v(Map<String, Object> map, String str, m3.a<T> aVar) {
        com.haier.uhome.usdk.base.service.e eVarA = com.haier.uhome.usdk.base.service.e.a();
        String str2 = "https://" + eVarA.d() + l3.a.f37437t;
        String strZ = com.haier.library.json.a.Z(map);
        String strI = eVarA.i();
        b.a().b(2).j(str2).d(strI).h(eVarA.h()).e(strZ, l3.a.f37437t, eVarA.l(), eVarA.g(), str).c(new m3.b(aVar)).k(strZ).g(15).i();
    }
}
