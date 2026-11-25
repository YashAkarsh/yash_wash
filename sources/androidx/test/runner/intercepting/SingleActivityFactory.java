package androidx.test.runner.intercepting;

import android.app.Activity;
import android.content.Intent;
import androidx.test.internal.util.Checks;

/* JADX INFO: loaded from: classes.dex */
public abstract class SingleActivityFactory<T extends Activity> implements InterceptingActivityFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<T> f10476a;

    public SingleActivityFactory(Class<T> activityClassToIntercept) {
        Checks.f(activityClassToIntercept);
        this.f10476a = (Class) Checks.f(activityClassToIntercept);
    }

    @Override // androidx.test.runner.intercepting.InterceptingActivityFactory
    public final boolean a(ClassLoader classLoader, String className, Intent intent) {
        return this.f10476a.getName().equals(className);
    }

    @Override // androidx.test.runner.intercepting.InterceptingActivityFactory
    public final Activity b(ClassLoader classLoader, String className, Intent intent) {
        if (a(classLoader, className, intent)) {
            return c(intent);
        }
        throw new UnsupportedOperationException(String.format("Can't create instance of %s", className));
    }

    protected abstract T c(Intent intent);

    public final Class<T> d() {
        return this.f10476a;
    }
}
