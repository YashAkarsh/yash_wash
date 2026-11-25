package com.google.android.gms.location;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class b2 implements Comparator<ActivityTransition> {
    b2() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(ActivityTransition activityTransition, ActivityTransition activityTransition2) {
        ActivityTransition activityTransition3 = activityTransition;
        ActivityTransition activityTransition4 = activityTransition2;
        com.google.android.gms.common.internal.u.k(activityTransition3);
        com.google.android.gms.common.internal.u.k(activityTransition4);
        int iK = activityTransition3.K();
        int iK2 = activityTransition4.K();
        if (iK != iK2) {
            return iK >= iK2 ? 1 : -1;
        }
        int iQ = activityTransition3.Q();
        int iQ2 = activityTransition4.Q();
        if (iQ == iQ2) {
            return 0;
        }
        return iQ < iQ2 ? -1 : 1;
    }
}
