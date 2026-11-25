package n3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f37495b;

    public String a() {
        return this.f37494a;
    }

    public String b() {
        return this.f37495b;
    }

    public void c(String str) {
        this.f37494a = str;
    }

    public void d(String str) {
        this.f37495b = str;
    }

    public String toString() {
        return "GroupDevListRequestBean{deviceId='" + this.f37494a + "', familyId='" + this.f37495b + "'}";
    }
}
