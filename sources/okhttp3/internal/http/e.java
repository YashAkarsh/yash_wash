package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.b1;
import kotlin.collections.c1;
import kotlin.jvm.internal.l0;
import kotlin.m;
import kotlin.text.b0;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
@h5.h(name = "HttpHeaders")
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final p f37877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final p f37878b;

    static {
        p.a aVar = p.f38508f;
        f37877a = aVar.l("\"\\");
        f37878b = aVar.l("\t ,=");
    }

    @kotlin.k(level = m.ERROR, message = "No longer supported", replaceWith = @b1(expression = "response.promisesBody()", imports = {}))
    public static final boolean a(@a7.d Response response) {
        l0.p(response, "response");
        return c(response);
    }

    @a7.d
    public static final List<Challenge> b(@a7.d Headers parseChallenges, @a7.d String headerName) {
        l0.p(parseChallenges, "$this$parseChallenges");
        l0.p(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = parseChallenges.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (b0.K1(headerName, parseChallenges.name(i7), true)) {
                try {
                    d(new okio.m().q0(parseChallenges.value(i7)), arrayList);
                } catch (EOFException e8) {
                    okhttp3.internal.platform.k.f38284e.g().m("Unable to parse challenge", 5, e8);
                }
            }
        }
        return arrayList;
    }

    public static final boolean c(@a7.d Response promisesBody) {
        l0.p(promisesBody, "$this$promisesBody");
        if (l0.g(promisesBody.request().method(), "HEAD")) {
            return false;
        }
        int iCode = promisesBody.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && okhttp3.internal.d.x(promisesBody) == -1 && !b0.K1("chunked", Response.header$default(promisesBody, com.google.common.net.c.f22183z0, null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0090  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x0085 A[EDGE_INSN: B:59:0x0085->B:28:0x0085 BREAK  A[LOOP:2: B:22:0x0072->B:48:0x00c5], SYNTHETIC] */
    private static final void d(okio.m mVar, List<Challenge> list) throws EOFException {
        String strF;
        while (true) {
            String strF2 = null;
            while (true) {
                if (strF2 == null) {
                    h(mVar);
                    strF2 = f(mVar);
                    if (strF2 == null) {
                        return;
                    }
                }
                boolean zH = h(mVar);
                String strF3 = f(mVar);
                if (strF3 == null) {
                    if (mVar.N()) {
                        list.add(new Challenge(strF2, (Map<String, String>) c1.z()));
                        return;
                    }
                    return;
                }
                byte b8 = (byte) 61;
                int iS = okhttp3.internal.d.S(mVar, b8);
                boolean zH2 = h(mVar);
                if (zH || !(zH2 || mVar.N())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iS2 = iS + okhttp3.internal.d.S(mVar, b8);
                    while (true) {
                        if (strF3 != null) {
                            if (iS2 == 0) {
                                break;
                                break;
                            }
                            if (iS2 <= 1) {
                                return;
                            }
                            if (i(mVar, (byte) 34)) {
                                strF = e(mVar);
                            } else {
                                strF = f(mVar);
                            }
                            if (strF != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        strF3 = f(mVar);
                        if (h(mVar)) {
                            break;
                        }
                        iS2 = okhttp3.internal.d.S(mVar, b8);
                        if (iS2 == 0) {
                            break;
                        }
                        if (iS2 <= 1 || h(mVar)) {
                            return;
                        }
                        if (i(mVar, (byte) 34)) {
                            strF = e(mVar);
                        } else {
                            strF = f(mVar);
                        }
                        if (strF != null || ((String) linkedHashMap.put(strF3, strF)) != null) {
                            return;
                        }
                        if (!h(mVar) && !mVar.N()) {
                            return;
                        } else {
                            strF3 = null;
                        }
                    }
                    list.add(new Challenge(strF2, linkedHashMap));
                    strF2 = strF3;
                } else {
                    Map mapSingletonMap = Collections.singletonMap(null, strF3 + b0.g2("=", iS));
                    l0.o(mapSingletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                    list.add(new Challenge(strF2, (Map<String, String>) mapSingletonMap));
                }
            }
        }
    }

    private static final String e(okio.m mVar) throws EOFException {
        byte b8 = (byte) 34;
        if (!(mVar.readByte() == b8)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        okio.m mVar2 = new okio.m();
        while (true) {
            long jZ = mVar.Z(f37877a);
            if (jZ == -1) {
                return null;
            }
            if (mVar.v0(jZ) == b8) {
                mVar2.write(mVar, jZ);
                mVar.readByte();
                return mVar2.m1();
            }
            if (mVar.B1() == jZ + 1) {
                return null;
            }
            mVar2.write(mVar, jZ);
            mVar.readByte();
            mVar2.write(mVar, 1L);
        }
    }

    private static final String f(okio.m mVar) {
        long jZ = mVar.Z(f37878b);
        if (jZ == -1) {
            jZ = mVar.B1();
        }
        if (jZ != 0) {
            return mVar.h(jZ);
        }
        return null;
    }

    public static final void g(@a7.d CookieJar receiveHeaders, @a7.d HttpUrl url, @a7.d Headers headers) {
        l0.p(receiveHeaders, "$this$receiveHeaders");
        l0.p(url, "url");
        l0.p(headers, "headers");
        if (receiveHeaders == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(url, headers);
        if (all.isEmpty()) {
            return;
        }
        receiveHeaders.saveFromResponse(url, all);
    }

    private static final boolean h(okio.m mVar) throws EOFException {
        boolean z7 = false;
        while (!mVar.N()) {
            byte bV0 = mVar.v0(0L);
            if (bV0 == 9 || bV0 == 32) {
                mVar.readByte();
            } else {
                if (bV0 != 44) {
                    break;
                }
                mVar.readByte();
                z7 = true;
            }
        }
        return z7;
    }

    private static final boolean i(okio.m mVar, byte b8) {
        return !mVar.N() && mVar.v0(0L) == b8;
    }
}
