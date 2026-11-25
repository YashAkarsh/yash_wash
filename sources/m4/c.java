package m4;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f37463b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, a> f37464a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f37465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f37466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f37467c;

        public a(String str, String str2, String str3) {
            this.f37465a = str;
            this.f37466b = str2;
            this.f37467c = str3;
        }
    }

    public c() {
        HashMap map = new HashMap();
        this.f37464a = map;
        map.clear();
    }

    public static c a() {
        if (f37463b == null) {
            synchronized (c.class) {
                if (f37463b == null) {
                    f37463b = new c();
                }
            }
        }
        return f37463b;
    }

    public Map<String, a> b() {
        return this.f37464a;
    }

    public void c(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f37464a == null) {
            this.f37464a = new HashMap();
        }
        if (this.f37464a.containsKey(aVar.f37466b)) {
            return;
        }
        this.f37464a.put(aVar.f37466b, aVar);
    }
}
