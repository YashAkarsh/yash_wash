package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.os.SystemClock;
import com.haier.globalwasher.mvp_api.volley.v;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.haier.globalwasher.mvp_api.volley.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final boolean f24960c = v.f25046b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f24961d = 3000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f24962e = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final j f24963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final d f24964b;

    public c(j jVar) {
        this(jVar, new d(f24962e));
    }

    private void b(Map<String, String> map, com.haier.globalwasher.mvp_api.volley.b.a aVar) {
        if (aVar == null) {
            return;
        }
        String str = aVar.f24807b;
        if (str != null) {
            map.put(com.google.common.net.c.f22182z, str);
        }
        if (aVar.f24809d > 0) {
            map.put(com.google.common.net.c.f22180y, DateUtils.formatDate(new Date(aVar.f24809d)));
        }
    }

    private static void c(String str, com.haier.globalwasher.mvp_api.volley.n<?> nVar, com.haier.globalwasher.mvp_api.volley.u uVar) throws com.haier.globalwasher.mvp_api.volley.u {
        com.haier.globalwasher.mvp_api.volley.r rVarA = nVar.A();
        int iD = nVar.D();
        try {
            rVarA.c(uVar);
            nVar.b(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iD)));
        } catch (com.haier.globalwasher.mvp_api.volley.u e8) {
            nVar.b(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iD)));
            throw e8;
        }
    }

    protected static Map<String, String> d(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i7 = 0; i7 < headerArr.length; i7++) {
            treeMap.put(headerArr[i7].getName(), headerArr[i7].getValue());
        }
        return treeMap;
    }

    private byte[] e(HttpEntity httpEntity) throws com.haier.globalwasher.mvp_api.volley.s, IOException {
        r rVar = new r(this.f24964b, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new com.haier.globalwasher.mvp_api.volley.s();
            }
            byte[] bArrA = this.f24964b.a(1024);
            while (true) {
                int i7 = content.read(bArrA);
                if (i7 == -1) {
                    break;
                }
                rVar.write(bArrA, 0, i7);
            }
            byte[] byteArray = rVar.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException unused) {
                v.f("Error occured when calling consumingContent", new Object[0]);
            }
            this.f24964b.b(bArrA);
            rVar.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException unused2) {
                v.f("Error occured when calling consumingContent", new Object[0]);
            }
            this.f24964b.b(null);
            rVar.close();
            throw th;
        }
    }

    private void g(long j7, com.haier.globalwasher.mvp_api.volley.n<?> nVar, byte[] bArr, StatusLine statusLine) {
        if (f24960c || j7 > f24961d) {
            Object[] objArr = new Object[5];
            objArr[0] = nVar;
            objArr[1] = Long.valueOf(j7);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(nVar.A().b());
            v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:54:0x0111  */
    /* JADX WARN: Code duplicated, block: B:56:0x0126  */
    /* JADX WARN: Code duplicated, block: B:58:0x013a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0156 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // com.haier.globalwasher.mvp_api.volley.g
    public com.haier.globalwasher.mvp_api.volley.j a(com.haier.globalwasher.mvp_api.volley.n<?> nVar) throws com.haier.globalwasher.mvp_api.volley.u {
        Map<String, String> map;
        int statusCode;
        com.haier.globalwasher.mvp_api.volley.j jVar;
        Map<String, String> map2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Map<String, String> mapEmptyMap = Collections.emptyMap();
            HttpResponse httpResponseA = null;
            byte[] bArr = null;
            try {
                try {
                    HashMap map3 = new HashMap();
                    b(map3, nVar.m());
                    httpResponseA = this.f24963a.a(nVar, map3);
                    try {
                        StatusLine statusLine = httpResponseA.getStatusLine();
                        int statusCode2 = statusLine.getStatusCode();
                        Map<String, String> mapD = d(httpResponseA.getAllHeaders());
                        try {
                            if (statusCode2 == 304) {
                                com.haier.globalwasher.mvp_api.volley.b.a aVarM = nVar.m();
                                if (aVarM == null) {
                                    return new com.haier.globalwasher.mvp_api.volley.j(304, null, mapD, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                }
                                aVarM.f24812g.putAll(mapD);
                                return new com.haier.globalwasher.mvp_api.volley.j(304, aVarM.f24806a, aVarM.f24812g, true, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            }
                            if (statusCode2 == 301 || statusCode2 == 302) {
                                try {
                                    nVar.N(mapD.get(com.google.common.net.c.f22157m0));
                                } catch (IOException e8) {
                                    e = e8;
                                    map2 = mapD;
                                    bArr = null;
                                    map = map2;
                                    if (httpResponseA == null) {
                                        throw new com.haier.globalwasher.mvp_api.volley.k(e);
                                    }
                                    statusCode = httpResponseA.getStatusLine().getStatusCode();
                                    if (statusCode != 301 || statusCode == 302) {
                                        v.c("Request at %s has been redirected to %s", nVar.s(), nVar.F());
                                    } else {
                                        v.c("Unexpected response code %d for %s", Integer.valueOf(statusCode), nVar.F());
                                    }
                                    if (bArr == null) {
                                        throw new com.haier.globalwasher.mvp_api.volley.i(e);
                                    }
                                    jVar = new com.haier.globalwasher.mvp_api.volley.j(statusCode, bArr, map, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                    if (statusCode != 401 || statusCode == 403) {
                                        c(com.alipay.sdk.app.statistic.c.f13642n, nVar, new com.haier.globalwasher.mvp_api.volley.a(jVar));
                                    } else {
                                        if (statusCode != 301 && statusCode != 302) {
                                            throw new com.haier.globalwasher.mvp_api.volley.s(jVar);
                                        }
                                        c("redirect", nVar, new com.haier.globalwasher.mvp_api.volley.m(jVar));
                                    }
                                }
                            }
                            byte[] bArrE = httpResponseA.getEntity() != null ? e(httpResponseA.getEntity()) : new byte[0];
                            try {
                                map2 = mapD;
                                try {
                                    g(SystemClock.elapsedRealtime() - jElapsedRealtime, nVar, bArrE, statusLine);
                                    if (statusCode2 < 200 || statusCode2 > 299) {
                                        throw new IOException();
                                    }
                                    return new com.haier.globalwasher.mvp_api.volley.j(statusCode2, bArrE, map2, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                } catch (IOException e9) {
                                    e = e9;
                                    bArr = bArrE;
                                    map = map2;
                                    if (httpResponseA == null) {
                                        throw new com.haier.globalwasher.mvp_api.volley.k(e);
                                    }
                                    statusCode = httpResponseA.getStatusLine().getStatusCode();
                                    if (statusCode != 301) {
                                        v.c("Request at %s has been redirected to %s", nVar.s(), nVar.F());
                                    } else {
                                        v.c("Request at %s has been redirected to %s", nVar.s(), nVar.F());
                                    }
                                    if (bArr == null) {
                                        throw new com.haier.globalwasher.mvp_api.volley.i(e);
                                    }
                                    jVar = new com.haier.globalwasher.mvp_api.volley.j(statusCode, bArr, map, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                                    if (statusCode != 401) {
                                    }
                                    c(com.alipay.sdk.app.statistic.c.f13642n, nVar, new com.haier.globalwasher.mvp_api.volley.a(jVar));
                                }
                            } catch (IOException e10) {
                                e = e10;
                                map2 = mapD;
                            }
                        } catch (IOException e11) {
                            e = e11;
                            map = mapD;
                            httpResponseA = httpResponseA;
                            if (httpResponseA == null) {
                                throw new com.haier.globalwasher.mvp_api.volley.k(e);
                            }
                            statusCode = httpResponseA.getStatusLine().getStatusCode();
                            if (statusCode != 301) {
                                v.c("Request at %s has been redirected to %s", nVar.s(), nVar.F());
                            } else {
                                v.c("Request at %s has been redirected to %s", nVar.s(), nVar.F());
                            }
                            if (bArr == null) {
                                throw new com.haier.globalwasher.mvp_api.volley.i(e);
                            }
                            jVar = new com.haier.globalwasher.mvp_api.volley.j(statusCode, bArr, map, false, SystemClock.elapsedRealtime() - jElapsedRealtime);
                            if (statusCode != 401) {
                            }
                            c(com.alipay.sdk.app.statistic.c.f13642n, nVar, new com.haier.globalwasher.mvp_api.volley.a(jVar));
                        }
                    } catch (IOException e12) {
                        e = e12;
                        map = mapEmptyMap;
                    }
                } catch (IOException e13) {
                    e = e13;
                    map = mapEmptyMap;
                    bArr = null;
                }
            } catch (MalformedURLException e14) {
                throw new RuntimeException("Bad URL " + nVar.F(), e14);
            } catch (SocketTimeoutException unused) {
                c("socket", nVar, new com.haier.globalwasher.mvp_api.volley.t());
            } catch (ConnectTimeoutException unused2) {
                c("connection", nVar, new com.haier.globalwasher.mvp_api.volley.t());
            }
        }
    }

    protected void f(String str, String str2, long j7) {
        v.f("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(SystemClock.elapsedRealtime() - j7), str2);
    }

    public c(j jVar, d dVar) {
        this.f24963a = jVar;
        this.f24964b = dVar;
    }
}
