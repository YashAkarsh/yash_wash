package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements androidx.lifecycle.q, androidx.core.view.p0.a {
    private androidx.collection.i<Class<? extends a>, a> mExtraDataMap = new androidx.collection.i<>();
    private androidx.lifecycle.r mLifecycleRegistry = new androidx.lifecycle.r(this);

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static class a {
    }

    private static boolean A(@c.o0 String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return false;
        }
        String str = strArr[0];
        str.hashCode();
        switch (str) {
            case "--translation":
                return Build.VERSION.SDK_INT >= 31;
            case "--contentcapture":
                return Build.VERSION.SDK_INT >= 29;
            case "--autofill":
                return Build.VERSION.SDK_INT >= 26;
            default:
                return false;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.p0.d(decorView, keyEvent)) {
            return androidx.core.view.p0.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.p0.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    @c.m0
    public androidx.lifecycle.m getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(@c.o0 Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.b0.g(this);
    }

    @Override // android.app.Activity
    @c.i
    protected void onSaveInstanceState(@c.m0 Bundle bundle) {
        this.mLifecycleRegistry.l(androidx.lifecycle.m.c.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put((Class<? extends a>) aVar.getClass(), aVar);
    }

    protected final boolean shouldDumpInternalState(@c.o0 String[] strArr) {
        return !A(strArr);
    }

    @Override // androidx.core.view.p0.a
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public boolean superDispatchKeyEvent(@c.m0 KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
