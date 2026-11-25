package g1;

import android.text.TextUtils;
import c.o0;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@d0
@c1.a
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f33979a = Pattern.compile("\\$\\{(.*?)\\}");

    private b0() {
    }

    @o0
    @c1.a
    public static String a(@o0 String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @c1.a
    @g6.c(expression = {"#1"}, result = false)
    public static boolean b(@o0 String str) {
        return str == null || str.trim().isEmpty();
    }
}
