package androidx.core.net;

import android.net.Uri;
import androidx.core.util.w;
import c.m0;
import c.o0;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6068b = "mailto:";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f6069c = "mailto";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f6070d = "to";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f6071e = "body";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f6072f = "cc";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f6073g = "bcc";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f6074h = "subject";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f6075a = new HashMap<>();

    private d() {
    }

    public static boolean g(@o0 Uri uri) {
        return uri != null && f6069c.equals(uri.getScheme());
    }

    public static boolean h(@o0 String str) {
        return str != null && str.startsWith(f6068b);
    }

    @m0
    public static d i(@m0 Uri uri) throws e {
        return j(uri.toString());
    }

    @m0
    public static d j(@m0 String str) throws e {
        String strDecode;
        String strSubstring;
        w.l(str);
        if (!h(str)) {
            throw new e("Not a mailto scheme");
        }
        int iIndexOf = str.indexOf(35);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
        }
        int iIndexOf2 = str.indexOf(63);
        if (iIndexOf2 == -1) {
            strDecode = Uri.decode(str.substring(7));
            strSubstring = null;
        } else {
            strDecode = Uri.decode(str.substring(7, iIndexOf2));
            strSubstring = str.substring(iIndexOf2 + 1);
        }
        d dVar = new d();
        if (strSubstring != null) {
            for (String str2 : strSubstring.split(m0.a.f37445e)) {
                String[] strArrSplit = str2.split("=", 2);
                if (strArrSplit.length != 0) {
                    dVar.f6075a.put(Uri.decode(strArrSplit[0]).toLowerCase(Locale.ROOT), strArrSplit.length > 1 ? Uri.decode(strArrSplit[1]) : null);
                }
            }
        }
        String strF = dVar.f();
        if (strF != null) {
            strDecode = strDecode + ", " + strF;
        }
        dVar.f6075a.put("to", strDecode);
        return dVar;
    }

    @o0
    public String a() {
        return this.f6075a.get(f6073g);
    }

    @o0
    public String b() {
        return this.f6075a.get("body");
    }

    @o0
    public String c() {
        return this.f6075a.get(f6072f);
    }

    @o0
    public Map<String, String> d() {
        return this.f6075a;
    }

    @o0
    public String e() {
        return this.f6075a.get(f6074h);
    }

    @o0
    public String f() {
        return this.f6075a.get("to");
    }

    @m0
    public String toString() {
        StringBuilder sb = new StringBuilder(f6068b);
        sb.append('?');
        for (Map.Entry<String, String> entry : this.f6075a.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode(entry.getValue()));
            sb.append(h0.f35378d);
        }
        return sb.toString();
    }
}
