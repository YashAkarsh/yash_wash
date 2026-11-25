package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 {
    public static void a(f0 f0Var, int i7) {
    }

    public static void b(f0 f0Var, @c.m0 List list) {
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            f0Var.onLocationChanged((Location) list.get(i7));
        }
    }

    public static void c(f0 f0Var, @c.m0 String str) {
    }

    public static void d(f0 f0Var, @c.m0 String str) {
    }

    public static void e(f0 f0Var, @c.m0 String str, int i7, @c.o0 Bundle bundle) {
    }
}
