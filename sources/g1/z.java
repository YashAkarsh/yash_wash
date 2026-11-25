package g1;

import c.m0;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class z {
    private z() {
    }

    @c1.a
    @m0
    public static String[] a(@m0 Set<Scope> set) {
        com.google.android.gms.common.internal.u.l(set, "scopes can't be null.");
        Scope[] scopeArr = (Scope[]) set.toArray(new Scope[set.size()]);
        com.google.android.gms.common.internal.u.l(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i7 = 0; i7 < scopeArr.length; i7++) {
            strArr[i7] = scopeArr[i7].K();
        }
        return strArr;
    }
}
