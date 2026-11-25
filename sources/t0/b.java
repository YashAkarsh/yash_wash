package t0;

import android.content.Context;
import com.alipay.security.mobile.module.http.d;
import s0.c;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f40345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.alipay.security.mobile.module.http.a f40346b;

    public static a b(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f40345a == null) {
            f40346b = d.a(context, str);
            f40345a = new b();
        }
        return f40345a;
    }

    @Override // t0.a
    public c a(s0.d dVar) {
        return s0.b.b(f40346b.a(s0.b.a(dVar)));
    }

    @Override // t0.a
    public boolean a(String str) {
        return f40346b.a(str);
    }
}
