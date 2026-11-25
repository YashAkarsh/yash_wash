package androidx.test.internal.runner.filters;

import java.util.Iterator;
import org.junit.runner.c;
import org.junit.runner.manipulation.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ParentFilter extends a {
    @Override // org.junit.runner.manipulation.a
    public boolean e(c description) {
        if (description.u()) {
            return f(description);
        }
        Iterator<c> it = description.m().iterator();
        while (it.hasNext()) {
            if (e(it.next())) {
                return true;
            }
        }
        return false;
    }

    protected abstract boolean f(c description);
}
