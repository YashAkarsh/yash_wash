package w4;

import easypay.appinvoke.manager.Constants;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @w1.c("etag")
    private String f40542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @w1.c(Constants.EXTRA_BANK_SCHEME)
    private String f40543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @w1.c("bankName")
    private String f40544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @w1.c("payMode")
    private String f40545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @w1.c("pages")
    private ArrayList<d> f40546e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @w1.c("enabled")
    private Boolean f40547f;

    public String a() {
        return this.f40544c;
    }

    public String b() {
        return this.f40543b;
    }

    public Boolean c() {
        return this.f40547f;
    }

    public String d() {
        return this.f40542a;
    }

    public String e() {
        return this.f40545d;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        a aVar = (a) obj;
        return (a() + e() + b()).equals(aVar.a() + aVar.e() + aVar.b());
    }

    public ArrayList<d> f() {
        return this.f40546e;
    }

    public void g(String str) {
        this.f40544c = str;
    }

    public void h(String str) {
        this.f40543b = str;
    }

    public void i(Boolean bool) {
        this.f40547f = bool;
    }

    public void j(String str) {
        this.f40542a = str;
    }

    public void k(String str) {
        this.f40545d = str;
    }

    public void l(ArrayList<d> arrayList) {
        this.f40546e = arrayList;
    }

    public String toString() {
        return a() + e() + b();
    }
}
