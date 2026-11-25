package com.haier.uhome.search.service;

import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SearchNative f29849a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static e f29850a = new e();

        private a() {
        }
    }

    public static e a() {
        return a.f29850a;
    }

    public int b(int i7) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "stopSearch(%d).", Integer.valueOf(i7));
        int iStopSearch = this.f29849a.stopSearch(i7);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "stopSearch(%d) ret %d.", Integer.valueOf(i7), Integer.valueOf(iStopSearch));
        return iStopSearch;
    }

    public int c() {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "unregisterACKReceiver().", new Object[0]);
        int iSmlkCloseAck = this.f29849a.smlkCloseAck();
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "unregisterACKReceiver() ret %d.", Integer.valueOf(iSmlkCloseAck));
        return iSmlkCloseAck;
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        return 0;
    }

    private e() {
        SearchNative searchNative = new SearchNative();
        this.f29849a = searchNative;
        searchNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    public int a(int i7) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "startSearch(%d).", Integer.valueOf(i7));
        int iStartSearch = this.f29849a.startSearch(i7);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "startSearch(%d) ret %d.", Integer.valueOf(i7), Integer.valueOf(iStartSearch));
        return iStartSearch;
    }

    public int b() {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "registerACKReceiver().", new Object[0]);
        int iSmlkOpenAck = this.f29849a.smlkOpenAck();
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "registerACKReceiver() ret %d.", Integer.valueOf(iSmlkOpenAck));
        return iSmlkOpenAck;
    }

    public String a(byte[] bArr) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "parserDeviceUUID( %s ).", com.haier.library.common.util.c.o(bArr));
        String str = this.f29849a.parserDeviceUUID(bArr);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "parserDeviceUUID() ret %s.", str);
        return str;
    }

    public int b(String str) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29686g, "startUnconnectedDevSearch ip = %s", str);
        int iStartUnconnectedDevSearch = this.f29849a.startUnconnectedDevSearch(str);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29686g, "startUnconnectedDevSearch ret %d.", Integer.valueOf(iStartUnconnectedDevSearch));
        return iStartUnconnectedDevSearch;
    }

    public int a(String str) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "openWifiStateNotify().", new Object[0]);
        int iOpenWifiStateNotify = this.f29849a.openWifiStateNotify(str.getBytes());
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "openWifiStateNotify() ret %d.", Integer.valueOf(iOpenWifiStateNotify));
        return iOpenWifiStateNotify;
    }
}
