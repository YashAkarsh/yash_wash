package g1;

import android.content.Context;
import android.content.SharedPreferences;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class a0 {
    private a0() {
    }

    @c1.a
    @Deprecated
    public static void a(@m0 Context context, @m0 SharedPreferences.Editor editor, @m0 String str) {
        throw new IllegalStateException("world-readable shared preferences should only be used by apk");
    }
}
