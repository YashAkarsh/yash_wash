package com.haier.library.okhttp;

import easypay.appinvoke.manager.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f27873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Comparator<String> f27806b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, u> f27809c = new LinkedHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f27812d = b("SSL_RSA_WITH_NULL_MD5", 1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f27815e = b("SSL_RSA_WITH_NULL_SHA", 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f27818f = b("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final u f27821g = b("SSL_RSA_WITH_RC4_128_MD5", 4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final u f27824h = b("SSL_RSA_WITH_RC4_128_SHA", 5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u f27827i = b("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final u f27830j = b("SSL_RSA_WITH_DES_CBC_SHA", 9);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u f27833k = b("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final u f27836l = b("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final u f27839m = b("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final u f27842n = b("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final u f27845o = b("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final u f27848p = b("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final u f27851q = b("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final u f27854r = b("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final u f27857s = b("SSL_DH_anon_WITH_RC4_128_MD5", 24);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final u f27859t = b("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final u f27861u = b("SSL_DH_anon_WITH_DES_CBC_SHA", 26);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final u f27863v = b("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final u f27865w = b("TLS_KRB5_WITH_DES_CBC_SHA", 30);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final u f27867x = b("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final u f27869y = b("TLS_KRB5_WITH_RC4_128_SHA", 32);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final u f27871z = b("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final u A = b("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final u B = b("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final u C = b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final u D = b("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final u E = b("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final u F = b("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final u G = b("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final u H = b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final u I = b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final u f27803J = b("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final u K = b("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final u L = b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final u M = b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final u N = b("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final u O = b("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final u P = b("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final u Q = b("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final u R = b("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final u S = b("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final u T = b("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final u U = b("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final u V = b("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", Constants.ACTION_SUBMIT_BTN_USER_PWD_NB);
    public static final u W = b("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", Constants.ACTION_SUBMIT_CLICKED);
    public static final u X = b("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", Constants.OTP_FILLER_WEB_SUCCESS);
    public static final u Y = b("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final u Z = b("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final u f27804a0 = b("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final u f27807b0 = b("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final u f27810c0 = b("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final u f27813d0 = b("TLS_PSK_WITH_RC4_128_SHA", 138);

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final u f27816e0 = b("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final u f27819f0 = b("TLS_PSK_WITH_AES_128_CBC_SHA", 140);

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final u f27822g0 = b("TLS_PSK_WITH_AES_256_CBC_SHA", 141);

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final u f27825h0 = b("TLS_RSA_WITH_SEED_CBC_SHA", 150);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final u f27828i0 = b("TLS_RSA_WITH_AES_128_GCM_SHA256", Constants.ACTION_DELAY_PASSWORD_FOUND);

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final u f27831j0 = b("TLS_RSA_WITH_AES_256_GCM_SHA384", Constants.ACTION_SAVE_CUST_ID);

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final u f27834k0 = b("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final u f27837l0 = b("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final u f27840m0 = b("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", com.alibaba.fastjson.asm.j.L);

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final u f27843n0 = b("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final u f27846o0 = b("TLS_DH_anon_WITH_AES_128_GCM_SHA256", com.alibaba.fastjson.asm.j.O);

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final u f27849p0 = b("TLS_DH_anon_WITH_AES_256_GCM_SHA384", com.alibaba.fastjson.asm.j.P);

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final u f27852q0 = b("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final u f27855r0 = b("TLS_FALLBACK_SCSV", 22016);

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final u f27858s0 = b("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final u f27860t0 = b("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final u f27862u0 = b("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final u f27864v0 = b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final u f27866w0 = b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final u f27868x0 = b("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final u f27870y0 = b("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final u f27872z0 = b("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final u A0 = b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final u B0 = b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final u C0 = b("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final u D0 = b("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final u E0 = b("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final u F0 = b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final u G0 = b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final u H0 = b("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final u I0 = b("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final u J0 = b("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final u K0 = b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final u L0 = b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final u M0 = b("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final u N0 = b("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final u O0 = b("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final u P0 = b("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final u Q0 = b("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final u R0 = b("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final u S0 = b("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final u T0 = b("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final u U0 = b("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final u V0 = b("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final u W0 = b("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final u X0 = b("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final u Y0 = b("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final u Z0 = b("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final u f27805a1 = b("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final u f27808b1 = b("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final u f27811c1 = b("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final u f27814d1 = b("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final u f27817e1 = b("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final u f27820f1 = b("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final u f27823g1 = b("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final u f27826h1 = b("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final u f27829i1 = b("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final u f27832j1 = b("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final u f27835k1 = b("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final u f27838l1 = b("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final u f27841m1 = b("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final u f27844n1 = b("TLS_AES_128_GCM_SHA256", 4865);

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final u f27847o1 = b("TLS_AES_256_GCM_SHA384", 4866);

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final u f27850p1 = b("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final u f27853q1 = b("TLS_AES_128_CCM_SHA256", 4868);

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final u f27856r1 = b("TLS_AES_256_CCM_8_SHA256", 4869);

    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            int iMin = Math.min(str.length(), str2.length());
            for (int i7 = 4; i7 < iMin; i7++) {
                char cCharAt = str.charAt(i7);
                char cCharAt2 = str2.charAt(i7);
                if (cCharAt != cCharAt2) {
                    return cCharAt < cCharAt2 ? -1 : 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length != length2) {
                return length < length2 ? -1 : 1;
            }
            return 0;
        }
    }

    private u(String str) {
        str.getClass();
        this.f27873a = str;
    }

    public static synchronized u a(String str) {
        u uVar;
        Map<String, u> map = f27809c;
        uVar = map.get(str);
        if (uVar == null) {
            uVar = map.get(e(str));
            if (uVar == null) {
                uVar = new u(str);
            }
            map.put(str, uVar);
        }
        return uVar;
    }

    private static u b(String str, int i7) {
        u uVar = new u(str);
        f27809c.put(str, uVar);
        return uVar;
    }

    static List<u> d(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static String e(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        if (!str.startsWith("SSL_")) {
            return str;
        }
        return "TLS_" + str.substring(4);
    }

    public String c() {
        return this.f27873a;
    }

    public String toString() {
        return this.f27873a;
    }
}
