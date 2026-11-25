package com.haier.uhome.qrcode.bind.api;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.haier.uhome.nfc.service.HttpHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import retrofit2.r;
import retrofit2.s;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f29589a = "f";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f29591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.qrcode.bind.a.c f29592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.uhome.qrcode.bind.a.b f29593e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.haier.uhome.qrcode.bind.api.a.a f29590b = c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f29594f = new AtomicInteger(0);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static f f29611a = new f();
    }

    private com.haier.uhome.qrcode.bind.api.a.a c() {
        return (com.haier.uhome.qrcode.bind.api.a.a) new s.b().c("https://uws.haier.net").b(retrofit2.converter.gson.a.f()).e().g(com.haier.uhome.qrcode.bind.api.a.a.class);
    }

    public static f a() {
        return a.f29611a;
    }

    public void b(final j jVar, final com.haier.uhome.qrcode.bind.api.a.c<k> cVar) {
        com.haier.uhome.qrcode.bind.a.c cVar2 = this.f29592d;
        if (cVar2 != null) {
            cVar2.d();
        }
        com.haier.uhome.qrcode.bind.a.b<k> bVar = new com.haier.uhome.qrcode.bind.a.b<k>(com.haier.uhome.qrcode.bind.a.b.c(), 3000L) { // from class: com.haier.uhome.qrcode.bind.api.f.3
            @Override // com.haier.uhome.qrcode.bind.a.b
            public void a(long j7) {
                final g gVar = new g();
                f.this.a(jVar, new com.haier.uhome.qrcode.bind.api.a.c<k>() { // from class: com.haier.uhome.qrcode.bind.api.f.3.1
                    @Override // com.haier.uhome.qrcode.bind.api.a.c
                    public void a(l lVar) {
                        com.haier.uhome.qrcode.bind.api.a.c cVar3 = cVar;
                        if (cVar3 != null) {
                            cVar3.a(lVar);
                        }
                    }

                    @Override // com.haier.uhome.qrcode.bind.api.a.b
                    public void a(k kVar) {
                        if (kVar.a() == l.STATE_CONFIRM.a()) {
                            gVar.a("00000");
                        } else {
                            gVar.a("-1");
                        }
                        b(gVar, kVar);
                    }

                    @Override // com.haier.uhome.qrcode.bind.api.a.b
                    public void a(g gVar2) {
                        if (com.haier.uhome.qrcode.bind.a.a.f29541d.equals(gVar2.a()) || com.haier.uhome.qrcode.bind.a.a.f29540c.equals(gVar2.a())) {
                            if (f.this.f29593e != null) {
                                f.this.f29593e.b();
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            f.this.a((com.haier.uhome.qrcode.bind.api.a.b) cVar, gVar2);
                            return;
                        }
                        b(gVar2, null);
                    }
                });
            }

            @Override // com.haier.uhome.qrcode.bind.a.b
            public void a(g gVar, final k kVar) {
                if ("00000".equals(gVar.a())) {
                    f.this.a(cVar, kVar);
                    f.this.f29592d = new com.haier.uhome.qrcode.bind.a.c(new AtomicLong(System.currentTimeMillis() + ((long) ((kVar.c() - 10) * 1000)))) { // from class: com.haier.uhome.qrcode.bind.api.f.3.2
                        @Override // com.haier.uhome.qrcode.bind.a.c
                        public void a() {
                            f.this.a(new m.a().a(jVar.a()).b(jVar.b()).f(kVar.d()).c(jVar.c()).d(jVar.d()).e(jVar.e()).a(), (com.haier.uhome.qrcode.bind.api.a.c<n>) null);
                        }
                    };
                    f.this.f29592d.b();
                    return;
                }
                f.this.a((com.haier.uhome.qrcode.bind.api.a.b) cVar, gVar);
            }
        };
        this.f29593e = bVar;
        bVar.a();
    }

    public void a(Context context) {
        this.f29591c = context;
    }

    public void a(h hVar, final com.haier.uhome.qrcode.bind.api.a.c<i> cVar) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("sn", "" + this.f29594f.incrementAndGet());
        map.put("action", hVar.f().name());
        map.put(HttpHelper.a.f29520d, hVar.a());
        map.put("clientSecret", hVar.b());
        map.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "" + hVar.g());
        map.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "" + hVar.h());
        if (c.QRCODE_BIND.equals(hVar.f()) || c.QRCODE_LOGIN_BIND.equals(hVar.f())) {
            map.put(com.haier.globalwasher.presenter.o.f25218y, hVar.i());
            map.put("typeId", hVar.j());
        }
        String str = f29589a;
        Log.d(str, "getQrCode bodys params: " + map.toString());
        com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e(true);
        eVar.putAll(map);
        String string = eVar.toString();
        Log.d(str, "getQrCode bodys :" + string);
        this.f29590b.a(a(hVar, string, "https://uws.haier.net/ucs/uia/get/qrcode"), map).f(new d<com.haier.uhome.qrcode.bind.api.a<i>>() { // from class: com.haier.uhome.qrcode.bind.api.f.1
            @Override // com.haier.uhome.qrcode.bind.api.d
            public void a(r<com.haier.uhome.qrcode.bind.api.a<i>> rVar) {
                Log.d(f.f29589a, "getQrCode onSuccess response:" + rVar.a().f29566c.toString());
                f.this.a(cVar, rVar.a().f29566c);
                new com.haier.uhome.qrcode.bind.a.c(new AtomicLong(System.currentTimeMillis() + 300000)) { // from class: com.haier.uhome.qrcode.bind.api.f.1.1
                    @Override // com.haier.uhome.qrcode.bind.a.c
                    public void a() {
                        com.haier.uhome.qrcode.bind.api.a.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.a(l.STATE_QRCODE_INVALID);
                        }
                    }
                }.b();
            }

            @Override // com.haier.uhome.qrcode.bind.api.d
            public void a(g gVar) {
                Log.e(f.f29589a, "getQrCode onFailure message:" + gVar.toString());
                f.this.a((com.haier.uhome.qrcode.bind.api.a.b) cVar, gVar);
            }
        });
    }

    public void a(j jVar, final com.haier.uhome.qrcode.bind.api.a.c<k> cVar) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("sn", "" + this.f29594f.incrementAndGet());
        map.put("action", jVar.f());
        map.put(HttpHelper.a.f29520d, jVar.a());
        map.put("clientSecret", jVar.b());
        map.put(com.paytm.pgsdk.d.R, jVar.g());
        String str = f29589a;
        Log.d(str, "pollQrCodeStage bodys params: " + map.toString());
        com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e(true);
        eVar.putAll(map);
        String string = eVar.toString();
        Log.d(str, "pollQrCodeStage bodys :" + string);
        this.f29590b.b(a(jVar, string, "https://uws.haier.net/ucs/uia/get/result-poll"), map).f(new d<com.haier.uhome.qrcode.bind.api.a<k>>() { // from class: com.haier.uhome.qrcode.bind.api.f.2
            @Override // com.haier.uhome.qrcode.bind.api.d
            public void a(r<com.haier.uhome.qrcode.bind.api.a<k>> rVar) {
                Log.d(f.f29589a, "pollQrCodeStage onSuccess response:" + rVar.a().f29566c.toString());
                com.haier.uhome.qrcode.bind.api.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(l.a(rVar.a().f29566c.a()));
                }
                f.this.a(cVar, rVar.a().f29566c);
            }

            @Override // com.haier.uhome.qrcode.bind.api.d
            public void a(g gVar) {
                Log.e(f.f29589a, "pollQrCodeStage onFailure message:" + gVar.toString());
                f.this.a((com.haier.uhome.qrcode.bind.api.a.b) cVar, gVar);
            }
        });
    }

    public void a(m mVar, final com.haier.uhome.qrcode.bind.api.a.c<n> cVar) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sn", "" + this.f29594f.incrementAndGet());
        map.put(HttpHelper.a.f29520d, mVar.a());
        map.put("clientSecret", mVar.b());
        map.put("refreshToken", mVar.f());
        String str = f29589a;
        Log.d(str, "refreshToken bodys params: " + map.toString());
        com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e(true);
        eVar.putAll(map);
        String string = eVar.toString();
        Log.d(str, "refreshToken bodys :" + string);
        this.f29590b.c(a(mVar, string, "https://uws.haier.net/ucs/uia/get/new-token"), map).f(new d<com.haier.uhome.qrcode.bind.api.a<n>>() { // from class: com.haier.uhome.qrcode.bind.api.f.4
            @Override // com.haier.uhome.qrcode.bind.api.d
            public void a(final r<com.haier.uhome.qrcode.bind.api.a<n>> rVar) {
                Log.d(f.f29589a, "refreshToken onSuccess response:" + rVar.a().f29566c.toString());
                if (f.this.f29592d != null) {
                    f.this.f29592d.d();
                }
                f.this.f29592d = new com.haier.uhome.qrcode.bind.a.c(new AtomicLong(System.currentTimeMillis() + ((long) ((rVar.a().f29566c.b() - 10) * 1000)))) { // from class: com.haier.uhome.qrcode.bind.api.f.4.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.haier.uhome.qrcode.bind.a.c
                    public void a() {
                        Log.d(f.f29589a, "refreshToken onDeadlineTime time:" + ((n) ((com.haier.uhome.qrcode.bind.api.a) rVar.a()).f29566c).b());
                    }
                };
                f.this.f29592d.b();
                f.this.a(cVar, rVar.a().f29566c);
            }

            @Override // com.haier.uhome.qrcode.bind.api.d
            public void a(g gVar) {
                com.haier.uhome.qrcode.bind.api.a.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(l.STATE_REFRESH_TOKEN_INVALID);
                }
                Log.e(f.f29589a, "onFailure message:" + gVar.toString());
                f.this.a((com.haier.uhome.qrcode.bind.api.a.b) cVar, gVar);
            }
        });
    }

    private String a(String str, String str2, String str3, String str4, String str5) {
        byte[] bArrDigest;
        String str6 = f29589a;
        Log.d(str6, "appid:" + str + " appKey:" + str2 + " timestamp:" + str3 + " body:" + str4 + " url:" + str5);
        try {
            String path = new URL(str5).getPath();
            String strReplaceAll = str2.trim().replaceAll("\"", "");
            if (str4 != null) {
                str4 = str4.trim();
            }
            if (!str4.equals("")) {
                str4 = str4.replaceAll(" ", "").replaceAll("\t", "").replaceAll("\r", "").replaceAll("\n", "");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(path);
            stringBuffer.append(str4);
            stringBuffer.append(str);
            stringBuffer.append(strReplaceAll);
            stringBuffer.append(str3);
            Log.d(str6, "sinstr:" + stringBuffer.toString());
            try {
                bArrDigest = MessageDigest.getInstance("SHA-256").digest(stringBuffer.toString().getBytes("utf-8"));
            } catch (Exception e8) {
                e8.printStackTrace();
                bArrDigest = null;
            }
            return a(bArrDigest);
        } catch (MalformedURLException e9) {
            e9.printStackTrace();
            return "";
        }
    }

    private String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < bArr.length; i7++) {
            sb.append(String.valueOf("0123456789abcdef".charAt((bArr[i7] & 240) >> 4)));
            sb.append(String.valueOf("0123456789abcdef".charAt(bArr[i7] & com.google.common.base.c.f19317q)));
        }
        Log.d(f29589a, "sign:" + sb.toString());
        return sb.toString();
    }

    private HashMap<String, String> a(b bVar, String str, String str2) {
        String strA = com.haier.uhome.qrcode.bind.a.a.a();
        HashMap<String, String> map = new HashMap<>();
        map.put("apiVersion", bVar.c());
        map.put("Content-Type", bVar.d());
        map.put("appId", bVar.e());
        map.put(HttpHelper.a.f29520d, com.haier.uhome.qrcode.bind.a.a.b());
        map.put("timestamp", strA);
        map.put("language", "zh-cn");
        map.put(HttpHelper.a.f29526j, HttpHelper.b.f29530c);
        String strA2 = a(com.haier.uhome.qrcode.bind.a.a.a(this.f29591c, "APP_ID"), com.haier.uhome.qrcode.bind.a.a.a(this.f29591c, "APP_KEY"), strA, str, str2);
        String str3 = f29589a;
        Log.d(str3, "sign:" + strA2);
        map.put("sign", strA2);
        Log.d(str3, "headers:" + map.toString());
        return map;
    }

    protected <T> void a(com.haier.uhome.qrcode.bind.api.a.b<T> bVar, g gVar) {
        if (bVar == null) {
            return;
        }
        bVar.a(gVar);
    }

    protected <T> void a(com.haier.uhome.qrcode.bind.api.a.b<T> bVar, T t7) {
        if (bVar == null) {
            return;
        }
        bVar.a(t7);
    }
}
