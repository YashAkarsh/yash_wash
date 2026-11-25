package q0;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        synchronized (a.class) {
            String strE = null;
            if (context != null) {
                if (!o0.a.d(str) && !o0.a.d(str2)) {
                    try {
                        String strA = e.a(context, str, str2, "");
                        if (o0.a.d(strA)) {
                            return null;
                        }
                        strE = p0.c.e(p0.c.a(), strA);
                    } catch (Throwable unused) {
                    }
                    return strE;
                }
            }
            return null;
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
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
}
