package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import c.f1;

/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewPager2 f11217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f11218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f11219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f11220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11221e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f11222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11223g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f11224h;

    d(ViewPager2 viewPager2, g gVar, RecyclerView recyclerView) {
        this.f11217a = viewPager2;
        this.f11218b = gVar;
        this.f11219c = recyclerView;
    }

    private void a(long j7, int i7, float f8, float f9) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.f11224h, j7, i7, f8, f9, 0);
        this.f11220d.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void c() {
        VelocityTracker velocityTracker = this.f11220d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f11220d = VelocityTracker.obtain();
            this.f11221e = ViewConfiguration.get(this.f11217a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    @f1
    boolean b() {
        if (this.f11218b.i()) {
            return false;
        }
        this.f11223g = 0;
        this.f11222f = 0;
        this.f11224h = SystemClock.uptimeMillis();
        c();
        this.f11218b.m();
        if (!this.f11218b.k()) {
            this.f11219c.N1();
        }
        a(this.f11224h, 0, 0.0f, 0.0f);
        return true;
    }

    @f1
    boolean d() {
        if (!this.f11218b.j()) {
            return false;
        }
        this.f11218b.o();
        VelocityTracker velocityTracker = this.f11220d;
        velocityTracker.computeCurrentVelocity(1000, this.f11221e);
        if (this.f11219c.l0((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f11217a.u();
        return true;
    }

    @f1
    boolean e(float f8) {
        if (!this.f11218b.j()) {
            return false;
        }
        float f9 = this.f11222f - f8;
        this.f11222f = f9;
        int iRound = Math.round(f9 - this.f11223g);
        this.f11223g += iRound;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z7 = this.f11217a.getOrientation() == 0;
        int i7 = z7 ? iRound : 0;
        int i8 = z7 ? 0 : iRound;
        float f10 = z7 ? this.f11222f : 0.0f;
        float f11 = z7 ? 0.0f : this.f11222f;
        this.f11219c.scrollBy(i7, i8);
        a(jUptimeMillis, 2, f10, f11);
        return true;
    }

    boolean f() {
        return this.f11218b.j();
    }
}
