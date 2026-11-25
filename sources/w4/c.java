package w4;

import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @w1.c(Constants.EXTRA_BANK_SCHEME)
    private String f40555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @w1.c("bank")
    private String f40556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @w1.c("payType")
    private String f40557c;

    public String a() {
        return this.f40556b;
    }

    public String b() {
        return this.f40555a;
    }

    public String c() {
        return this.f40557c;
    }

    public void d(String str) {
        this.f40556b = str;
    }

    public void e(String str) {
        this.f40555a = str;
    }

    public void f(String str) {
        this.f40557c = str;
    }
}
