package q0;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        if (o0.a.d(str) || o0.a.d(str2) || context == null) {
            return;
        }
        try {
            String strB = p0.c.b(p0.c.a(), str3);
            HashMap map = new HashMap();
            map.put(str2, strB);
            e.b(context, str, map);
        } catch (Throwable unused) {
        }
    }
}
