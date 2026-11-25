package o3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "code")
    private String f37590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = "name")
    private String f37591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g3.b(name = "icon")
    private String f37592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = "hotSpot")
    private String f37593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g3.b(name = "list")
    private String[] f37594e;

    public String a() {
        return this.f37590a;
    }

    public String b() {
        return this.f37593d;
    }

    public String c() {
        return this.f37592c;
    }

    public String[] d() {
        return this.f37594e;
    }

    public String e() {
        return this.f37591b;
    }

    public void f(String str) {
        this.f37590a = str;
    }

    public void g(String str) {
        this.f37593d = str;
    }

    public void h(String str) {
        this.f37592c = str;
    }

    public void i(String[] strArr) {
        this.f37594e = strArr;
    }

    public void j(String str) {
        this.f37591b = str;
    }

    public String toString() {
        return "TypeInfo{code='" + this.f37590a + "', name='" + this.f37591b + "', icon='" + this.f37592c + "', hotSpot='" + this.f37593d + "', middles=" + Arrays.toString(this.f37594e) + '}';
    }
}
