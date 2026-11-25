package com.haier.uhome.search.service;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29949d = 5000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f29950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f29951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<String, com.haier.uhome.search.a.k> f29952c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.uhome.search.a.e f29953e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static h f29959a = new h();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst e() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f("SEARCH", com.haier.uhome.search.a.f29683d, "checkConditions error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        if (!this.f29951b.get()) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "SDK is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        synchronized (this) {
            if (this.f29950a.get()) {
                return ErrorConst.ERR_USDK_DEVICE_SCANNING;
            }
            this.f29950a.set(true);
            new com.haier.library.common.thread.m<Void, Void, Void>() { // from class: com.haier.uhome.search.service.h.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "start scan ScanDevice", new Object[0]);
                    h.this.f();
                    e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "end scan ScanDevice", new Object[0]);
                    return null;
                }
            }.execute(new Void[0]);
            return ErrorConst.RET_USDK_OK;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        while (this.f29950a.get()) {
            com.haier.uhome.usdk.base.hiwifi.d.a().a(new com.haier.uhome.usdk.base.hiwifi.d.b() { // from class: com.haier.uhome.search.service.b0
                @Override // com.haier.uhome.usdk.base.hiwifi.d.b
                public final void onCallBack(List list) {
                    this.f29822a.b(list);
                }
            });
            SystemClock.sleep(5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ErrorConst g() {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "stop scan ScanDevice", new Object[0]);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f("SEARCH", com.haier.uhome.search.a.f29683d, "checkConditions error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        if (!this.f29951b.get()) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "SDK is not running", new Object[0]);
            return ErrorConst.ERR_USDK_UNSTARTED;
        }
        this.f29950a.set(false);
        Iterator<com.haier.uhome.search.a.k> it = this.f29952c.values().iterator();
        while (it.hasNext()) {
            a(it.next(), false);
        }
        this.f29952c.clear();
        return ErrorConst.RET_USDK_OK;
    }

    private h() {
        this.f29950a = new AtomicBoolean(false);
        this.f29951b = new AtomicBoolean(false);
        this.f29952c = new HashMap<>();
    }

    public void d() {
        this.f29951b.set(false);
    }

    public static h a() {
        return a.f29959a;
    }

    public void b() {
        this.f29951b.set(true);
    }

    public ArrayList<com.haier.uhome.search.a.k> c() {
        return new ArrayList<>(this.f29952c.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        a(com.haier.library.common.util.u.e(list, new com.haier.library.common.util.u.c() { // from class: com.haier.uhome.search.service.d0
            @Override // com.haier.library.common.util.u.c
            public final boolean a(Object obj) {
                return h.b((com.haier.uhome.usdk.base.hiwifi.c) obj);
            }
        }, new com.haier.library.common.util.p() { // from class: com.haier.uhome.search.service.e0
            @Override // com.haier.library.common.util.p
            public final Object transform(Object obj) {
                return this.f29851a.a((com.haier.uhome.usdk.base.hiwifi.c) obj);
            }
        }));
    }

    public void a(com.haier.uhome.search.a.e eVar) {
        this.f29953e = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(com.haier.uhome.usdk.base.hiwifi.c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.a()) || TextUtils.isEmpty(cVar.b()) || !cVar.b().endsWith("z")) ? false : true;
    }

    public void a(final com.haier.uhome.usdk.base.api.o oVar) {
        new com.haier.library.common.thread.m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.search.service.h.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ErrorConst doInBackground(Void... voidArr) {
                return h.this.e();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(ErrorConst errorConst) {
                com.haier.uhome.usdk.base.api.o oVar2 = oVar;
                if (oVar2 != null) {
                    oVar2.onCallback(errorConst);
                } else {
                    e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "startScan callback is null,so give up callback", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.haier.uhome.search.a.k a(com.haier.uhome.usdk.base.hiwifi.c cVar) {
        return a(cVar.b(), cVar.a());
    }

    private void a(final com.haier.uhome.search.a.k kVar, final boolean z7) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.search.service.c0
            @Override // java.lang.Runnable
            public final void run() {
                this.f29829a.b(kVar, z7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.search.a.k kVar, boolean z7) {
        com.haier.uhome.search.a.e eVar = this.f29953e;
        if (eVar == null) {
            e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "DeviceListener is null so give up this callback: <%s-%s>", kVar.i(), Boolean.valueOf(z7));
        } else if (z7) {
            eVar.a(kVar);
        } else {
            eVar.b(kVar);
        }
    }

    private void a(List<com.haier.uhome.search.a.k> list) {
        HashMap map = new HashMap(this.f29952c);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "syncDevices hiWifiScanDevices <%s>", list.toString());
        for (com.haier.uhome.search.a.k kVar : list) {
            com.haier.uhome.search.a.k kVar2 = this.f29952c.get(kVar.i());
            if (kVar2 == null) {
                this.f29952c.put(kVar.i(), kVar);
                a(kVar, true);
            } else {
                map.remove(kVar2.i());
                if (!kVar2.k().equals(kVar.k())) {
                    e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "syncDevices %s devId change to %s", kVar.i(), kVar.k());
                    kVar2.b(kVar.k());
                }
                if (!kVar2.g().equals(kVar.g())) {
                    e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "syncDevices  %s ConfigType change to %s", kVar.i(), kVar.g());
                    kVar2.a(kVar.g());
                }
                if (kVar2.j() != kVar.j()) {
                    e3.a.d("SEARCH", com.haier.uhome.search.a.f29683d, "syncDevices %s SupportNoPwdConfig change to %s", kVar.i(), Boolean.valueOf(kVar.j()));
                    kVar2.a(kVar.j());
                }
            }
        }
        for (com.haier.uhome.search.a.k kVar3 : map.values()) {
            this.f29952c.remove(kVar3.i());
            a(kVar3, false);
        }
        map.clear();
    }

    public void b(final com.haier.uhome.usdk.base.api.o oVar) {
        new com.haier.library.common.thread.m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.search.service.h.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ErrorConst doInBackground(Void... voidArr) {
                return h.this.g();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(ErrorConst errorConst) {
                com.haier.uhome.usdk.base.api.o oVar2 = oVar;
                if (oVar2 != null) {
                    oVar2.onCallback(errorConst);
                } else {
                    e3.a.u("SEARCH", com.haier.uhome.search.a.f29683d, "stopScan callback is null,so give up callback", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    private com.haier.uhome.search.a.k a(String str, String str2) {
        if (str.startsWith(com.haier.uhome.usdk.base.a.T)) {
            String strSubstring = str.substring(2);
            return new com.haier.uhome.search.a.k("haier", strSubstring.substring(0, strSubstring.length() - 4), strSubstring.substring(strSubstring.length() - 4), "", "", str, str, false, str2);
        }
        if (!str.startsWith("uplus-")) {
            return null;
        }
        String[] strArrSplit = str.split("-");
        String str3 = strArrSplit[1];
        String str4 = strArrSplit[2];
        String str5 = strArrSplit[3];
        String strSubstring2 = strArrSplit[4].substring(1);
        String str6 = strArrSplit.length == 6 ? strArrSplit[5] : "";
        return new com.haier.uhome.search.a.k(str3, str4, str5, strSubstring2, str6, str, strArrSplit.length == 6 ? str.substring(0, str.lastIndexOf(45)) : str, str6.endsWith("z"), str2);
    }
}
