package androidx.constraintlayout.motion.utils;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3831e;

    public void a(View v7) {
        this.f3828b = v7.getLeft();
        this.f3829c = v7.getTop();
        this.f3830d = v7.getRight();
        this.f3831e = v7.getBottom();
        this.f3827a = v7.getRotation();
    }

    public int b() {
        return this.f3831e - this.f3829c;
    }

    public int c() {
        return this.f3830d - this.f3828b;
    }
}
