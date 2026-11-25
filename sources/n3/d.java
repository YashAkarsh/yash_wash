package n3;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f37496a;

    public List<String> a() {
        return this.f37496a;
    }

    public void b(List<String> list) {
        this.f37496a = list;
    }

    public String toString() {
        return "ProductCodeRequestBean{productCodeList=" + this.f37496a + '}';
    }
}
