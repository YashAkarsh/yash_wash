package com.haier.uhome.control.cloud.service;

import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResourceNative f29205a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static e f29206a = new e();

        private a() {
        }
    }

    public static e a() {
        return a.f29206a;
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        return 0;
    }

    private e() {
        ResourceNative resourceNative = new ResourceNative();
        this.f29205a = resourceNative;
        resourceNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    protected String a(String str, String str2, int i7, String str3, String str4) {
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "connect(%s,%s,%d,%s,%s).", str, str2, Integer.valueOf(i7), str3, str4);
        String strConnect = this.f29205a.connect(str, str2, i7, str3, str4);
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "connect(%s,%s,%d,%s,%s) ret json <%s>.", str, str2, Integer.valueOf(i7), str3, str4, strConnect);
        return strConnect;
    }

    protected void a(long j7) {
        this.f29205a.disconnect(j7);
    }

    protected int a(long j7, String str, int i7) {
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "subscribeResource(%d,%s,%d).", Long.valueOf(j7), str, Integer.valueOf(i7));
        int iSubscribeResource = this.f29205a.subscribeResource(j7, str, i7);
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "subscribeResource(%d,%s,%d) ret %d.", Long.valueOf(j7), str, Integer.valueOf(i7), Integer.valueOf(iSubscribeResource));
        return iSubscribeResource;
    }

    protected void a(long j7, String str) {
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "unsubscribeResource(%d,%s).", Long.valueOf(j7), str);
        this.f29205a.unsubscribeResource(j7, str);
        e3.a.d(com.haier.uhome.control.base.b.a.f28847a, com.haier.uhome.control.cloud.a.f29014l, "unsubscribeResource(%d,%s) ret void.", Long.valueOf(j7), str);
    }
}
