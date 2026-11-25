package androidx.lifecycle;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements androidx.startup.b<q> {
    @Override // androidx.startup.b
    @c.m0
    public List<Class<? extends androidx.startup.b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // androidx.startup.b
    @c.m0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public q b(@c.m0 Context context) {
        if (!androidx.startup.a.e(context).g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        n.a(context);
        z.i(context);
        return z.h();
    }
}
