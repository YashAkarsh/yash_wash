package n3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37490a;

    public String a() {
        return this.f37490a;
    }

    public void b(String str) {
        this.f37490a = str;
    }

    public String toString() {
        return "CreateGroupDevListRequestBean{deviceId='" + this.f37490a + "'}";
    }
}
