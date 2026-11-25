package androidx.core.view;

import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class k2 {
    private k2() {
    }

    @Deprecated
    public static float a(VelocityTracker velocityTracker, int i7) {
        return velocityTracker.getXVelocity(i7);
    }

    @Deprecated
    public static float b(VelocityTracker velocityTracker, int i7) {
        return velocityTracker.getYVelocity(i7);
    }
}
