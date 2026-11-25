package androidx.test.rule;

import android.os.Debug;
import org.junit.rules.l;
import org.junit.runner.c;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
public class DisableOnAndroidDebug implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f10344a;

    public DisableOnAndroidDebug(l rule) {
        this.f10344a = rule;
    }

    @Override // org.junit.rules.l
    public final j a(final j base, c description) {
        return b() ? base : this.f10344a.a(base, description);
    }

    public boolean b() {
        return Debug.isDebuggerConnected();
    }
}
