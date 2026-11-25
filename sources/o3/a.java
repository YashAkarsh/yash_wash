package o3;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "version")
    private String f37574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = "language")
    private String f37575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g3.b(name = "update")
    private boolean f37576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g3.b(name = "appTypeInformation")
    private List<g> f37577d;

    public String a() {
        return this.f37575b;
    }

    public List<g> b() {
        return this.f37577d;
    }

    public String c() {
        return this.f37574a;
    }

    public boolean d() {
        return this.f37576c;
    }

    public void e(String str) {
        this.f37575b = str;
    }

    public void f(List<g> list) {
        this.f37577d = list;
    }

    public void g(boolean z7) {
        this.f37576c = z7;
    }

    public void h(String str) {
        this.f37574a = str;
    }

    public String toString() {
        return "AppTypeInfoDto{version='" + this.f37574a + "', language='" + this.f37575b + "', update=" + this.f37576c + ", typeInfos=" + this.f37577d + '}';
    }
}
