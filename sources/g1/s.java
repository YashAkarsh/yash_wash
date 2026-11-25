package g1;

import c.m0;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class s {
    @c1.a
    public static void a(@m0 StringBuilder sb, @m0 HashMap<String, String> map) {
        sb.append("{");
        boolean z7 = true;
        for (String str : map.keySet()) {
            if (!z7) {
                sb.append(",");
            }
            String str2 = map.get(str);
            sb.append("\"");
            sb.append(str);
            sb.append("\":");
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append("\"");
                sb.append(str2);
                sb.append("\"");
            }
            z7 = false;
        }
        sb.append(com.alipay.sdk.util.j.f13808d);
    }
}
