package androidx.test.rule;

import android.test.UiThreadTest;
import android.util.Log;
import androidx.test.internal.runner.junit4.statement.UiThreadStatement;
import org.junit.rules.l;
import org.junit.runner.c;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class UiThreadTestRule implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10381a = "UiThreadTestRule";

    @Override // org.junit.rules.l
    public j a(final j base, c description) {
        return ((base instanceof org.junit.internal.runners.statements.c) || ((base instanceof UiThreadStatement) && !((UiThreadStatement) base).d())) ? base : new UiThreadStatement(base, c(description));
    }

    public void b(final Runnable runnable) throws Throwable {
        UiThreadStatement.f(runnable);
    }

    protected boolean c(c description) {
        if (description.k(UiThreadTest.class) == null) {
            return description.k(androidx.test.annotation.UiThreadTest.class) != null;
        }
        Log.w(f10381a, "Deprecated android.test.UiThreadTest annotation is used! please switch to using androidx.test.annotation.UiThreadTest instead.");
        return true;
    }
}
