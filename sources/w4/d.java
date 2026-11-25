package w4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @w1.c("url")
    private String f40558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @w1.c("operations")
    private ArrayList<g> f40559b = null;

    public ArrayList<g> a() {
        return this.f40559b;
    }

    public String b() {
        return this.f40558a;
    }

    public void c(ArrayList<g> arrayList) {
        this.f40559b = arrayList;
    }

    public void d(String str) {
        this.f40558a = str;
    }
}
