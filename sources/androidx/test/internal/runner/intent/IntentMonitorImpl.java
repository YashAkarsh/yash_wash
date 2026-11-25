package androidx.test.internal.runner.intent;

import android.content.Intent;
import android.util.Log;
import androidx.test.runner.intent.IntentCallback;
import androidx.test.runner.intent.IntentMonitor;
import c.m0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class IntentMonitorImpl implements IntentMonitor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10110b = "IntentMonitorImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<WeakReference<IntentCallback>> f10111a = Collections.synchronizedList(new ArrayList());

    @Override // androidx.test.runner.intent.IntentMonitor
    public void a(@m0 IntentCallback callback) {
        if (callback == null) {
            throw new NullPointerException("callback cannot be null!");
        }
        Iterator<WeakReference<IntentCallback>> it = this.f10111a.iterator();
        boolean z7 = true;
        while (it.hasNext()) {
            IntentCallback intentCallback = it.next().get();
            if (intentCallback == null) {
                it.remove();
            } else if (intentCallback == callback) {
                z7 = false;
            }
        }
        if (z7) {
            this.f10111a.add(new WeakReference<>(callback));
        }
    }

    @Override // androidx.test.runner.intent.IntentMonitor
    public void b(@m0 IntentCallback callback) {
        if (callback == null) {
            throw new NullPointerException("callback cannot be null!");
        }
        Iterator<WeakReference<IntentCallback>> it = this.f10111a.iterator();
        while (it.hasNext()) {
            IntentCallback intentCallback = it.next().get();
            if (intentCallback == null) {
                it.remove();
            } else if (intentCallback == callback) {
                it.remove();
            }
        }
    }

    public void c(Intent intent) {
        Iterator<WeakReference<IntentCallback>> it = this.f10111a.iterator();
        while (it.hasNext()) {
            IntentCallback intentCallback = it.next().get();
            if (intentCallback == null) {
                it.remove();
            } else {
                try {
                    intentCallback.a(new Intent(intent));
                } catch (RuntimeException e8) {
                    Log.e(f10110b, String.format("Callback threw exception! (callback: %s intent: %s)", intentCallback, intent), e8);
                }
            }
        }
    }
}
