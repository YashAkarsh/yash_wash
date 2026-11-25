package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.w;
import c.m0;
import c.o0;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f6132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f6133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f6134f;

    public h(@m0 String str, @m0 String str2, @m0 String str3, @m0 List<List<byte[]>> list) {
        this.f6129a = (String) w.l(str);
        this.f6130b = (String) w.l(str2);
        this.f6131c = (String) w.l(str3);
        this.f6132d = (List) w.l(list);
        this.f6133e = 0;
        this.f6134f = a(str, str2, str3);
    }

    private String a(@m0 String str, @m0 String str2, @m0 String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    @o0
    public List<List<byte[]>> b() {
        return this.f6132d;
    }

    @c.e
    public int c() {
        return this.f6133e;
    }

    @x0({x0.a.LIBRARY})
    @m0
    String d() {
        return this.f6134f;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public String e() {
        return this.f6134f;
    }

    @m0
    public String f() {
        return this.f6129a;
    }

    @m0
    public String g() {
        return this.f6130b;
    }

    @m0
    public String h() {
        return this.f6131c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f6129a + ", mProviderPackage: " + this.f6130b + ", mQuery: " + this.f6131c + ", mCertificates:");
        for (int i7 = 0; i7 < this.f6132d.size(); i7++) {
            sb.append(" [");
            List<byte[]> list = this.f6132d.get(i7);
            for (int i8 = 0; i8 < list.size(); i8++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i8), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append(com.alipay.sdk.util.j.f13808d);
        sb.append("mCertificatesArray: " + this.f6133e);
        return sb.toString();
    }

    public h(@m0 String str, @m0 String str2, @m0 String str3, @c.e int i7) {
        this.f6129a = (String) w.l(str);
        this.f6130b = (String) w.l(str2);
        this.f6131c = (String) w.l(str3);
        this.f6132d = null;
        w.a(i7 != 0);
        this.f6133e = i7;
        this.f6134f = a(str, str2, str3);
    }
}
