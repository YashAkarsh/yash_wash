package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6943b;

    public y1(@c.m0 ViewGroup viewGroup) {
    }

    public int a() {
        return this.f6942a | this.f6943b;
    }

    public void b(@c.m0 View view, @c.m0 View view2, int i7) {
        c(view, view2, i7, 0);
    }

    public void c(@c.m0 View view, @c.m0 View view2, int i7, int i8) {
        if (i8 == 1) {
            this.f6943b = i7;
        } else {
            this.f6942a = i7;
        }
    }

    public void d(@c.m0 View view) {
        e(view, 0);
    }

    public void e(@c.m0 View view, int i7) {
        if (i7 == 1) {
            this.f6943b = 0;
        } else {
            this.f6942a = 0;
        }
    }
}
