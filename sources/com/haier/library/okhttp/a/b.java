package com.haier.library.okhttp.a;

import com.haier.library.common.util.j;
import com.haier.library.okhttp.api.e;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f26902d = "httpdns.wangsucloud.com";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f26903e = "edge.wshttpdns.com";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f26904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j<String, c> f26905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f26906c;

    class a extends j<String, c> {
        a() {
        }

        @Override // com.haier.library.common.util.j
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public void a(String str, c cVar) {
            e3.a.e("HttpDns onTimeout <%s>", str);
        }

        @Override // com.haier.library.common.util.j
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void b(String str, c cVar) {
            e3.a.e("HttpDns warnTimeout <%s>", str);
        }
    }

    /* JADX INFO: renamed from: com.haier.library.okhttp.a.b$b, reason: collision with other inner class name */
    private static class C0353b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f26908a = new b(null);

        private C0353b() {
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        return C0353b.f26908a;
    }

    public c b(String str, List<String> list, int i7) {
        e3.a.e("https dns updateCache host<%s> ipList<%s> ttl<%s>", str, list, Integer.valueOf(i7));
        c cVar = new c();
        cVar.c(list);
        cVar.b(i7);
        this.f26905b.a(str, cVar, cVar.f26910b * 1000);
        return cVar;
    }

    public void c(String str, List<InetAddress> list) {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        Iterator<InetAddress> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getHostAddress());
        }
        cVar.c(arrayList);
        cVar.b(300);
        this.f26905b.a(str, cVar, cVar.f26910b * 1000);
    }

    public void d(boolean z7) {
        if (this.f26906c.get() == z7) {
            return;
        }
        this.f26905b.clear();
        this.f26906c.set(z7);
    }

    public boolean e(c cVar) {
        List<String> listA;
        return (cVar == null || (listA = cVar.a()) == null || listA.size() <= 0) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00be  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c2 A[RETURN] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    public boolean f(String str) {
        int iOptInt;
        int i7 = "data";
        List<String> arrayList = new ArrayList<>();
        try {
            try {
                com.haier.library.okhttp.a aVarL = this.f26904a.l(str);
                if (aVarL == null) {
                    if (arrayList.size() <= 0) {
                        return false;
                    }
                    b(str, arrayList, 0);
                    return true;
                }
                if (aVarL.Q()) {
                    e3.a.e("HttpDns response <%s>", aVarL.toString());
                    String strQ = aVarL.b().Q();
                    e3.a.e("HttpDns response body <%s>", strQ);
                    JSONObject jSONObject = new JSONObject(strQ);
                    JSONArray jSONArrayOptJSONArray = jSONObject.getJSONObject("data").getJSONObject(str).optJSONArray("ips");
                    iOptInt = jSONObject.getJSONObject("data").getJSONObject(str).optInt("ttl");
                    if (iOptInt <= 0) {
                        iOptInt = 300;
                    }
                    for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                        try {
                            arrayList.add(jSONArrayOptJSONArray.optString(i8));
                        } catch (IOException e8) {
                            e = e8;
                        } catch (JSONException e9) {
                            e = e9;
                            e.printStackTrace();
                            if (arrayList.size() <= 0) {
                                return false;
                            }
                            b(str, arrayList, iOptInt);
                            return true;
                        }
                    }
                } else {
                    iOptInt = 0;
                }
                aVarL.close();
                if (arrayList.size() <= 0) {
                    return false;
                }
                b(str, arrayList, iOptInt);
                return true;
            } catch (Throwable unused) {
                if (arrayList.size() > 0) {
                    return false;
                }
                b(str, arrayList, i7);
                return true;
            }
        } catch (IOException e10) {
            e = e10;
            iOptInt = 0;
        } catch (JSONException e11) {
            e = e11;
            iOptInt = 0;
        } catch (Throwable unused2) {
            i7 = 0;
            if (arrayList.size() > 0) {
                return false;
            }
            b(str, arrayList, i7);
            return true;
        }
        e3.a.h("HttpDns exception<%s>", e.toString());
        e.printStackTrace();
        if (arrayList.size() <= 0) {
            return false;
        }
        b(str, arrayList, iOptInt);
        return true;
    }

    public j<String, c> g() {
        return this.f26905b;
    }

    public AtomicBoolean h() {
        return this.f26906c;
    }

    private b() {
        this.f26904a = e.n(5L, TimeUnit.SECONDS, false);
        this.f26906c = new AtomicBoolean(true);
        this.f26905b = new a();
    }
}
