package com.google.android.gms.location;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
final class e2 implements Comparator<DetectedActivity> {
    e2() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        DetectedActivity detectedActivity3 = detectedActivity;
        DetectedActivity detectedActivity4 = detectedActivity2;
        com.google.android.gms.common.internal.u.k(detectedActivity3);
        com.google.android.gms.common.internal.u.k(detectedActivity4);
        int iCompareTo = Integer.valueOf(detectedActivity4.K()).compareTo(Integer.valueOf(detectedActivity3.K()));
        return iCompareTo == 0 ? Integer.valueOf(detectedActivity3.Q()).compareTo(Integer.valueOf(detectedActivity4.Q())) : iCompareTo;
    }
}
