package androidx.lifecycle;

import c.x0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f8358a = new HashMap();

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public boolean a(String str, int i7) {
        Integer num = this.f8358a.get(str);
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z7 = (iIntValue & i7) != 0;
        this.f8358a.put(str, Integer.valueOf(i7 | iIntValue));
        return !z7;
    }
}
