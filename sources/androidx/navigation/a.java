package androidx.navigation;

import android.os.Bundle;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8782a;

    public a(int i7) {
        this.f8782a = i7;
    }

    @Override // androidx.navigation.m
    @m0
    public Bundle d() {
        return new Bundle();
    }

    @Override // androidx.navigation.m
    public int e() {
        return this.f8782a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass() && e() == ((a) obj).e();
    }

    public int hashCode() {
        return 31 + e();
    }

    public String toString() {
        return "ActionOnlyNavDirections(actionId=" + e() + ")";
    }
}
