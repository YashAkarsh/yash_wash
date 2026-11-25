package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f6676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f6677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View.OnLongClickListener f6681f = new View.OnLongClickListener() { // from class: androidx.core.view.j0
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return this.f6629a.d(view);
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View.OnTouchListener f6682g = new View.OnTouchListener() { // from class: androidx.core.view.k0
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return this.f6661a.e(view, motionEvent);
        }
    };

    public interface a {
        boolean a(@c.m0 View view, @c.m0 l0 l0Var);
    }

    public l0(@c.m0 View view, @c.m0 a aVar) {
        this.f6676a = view;
        this.f6677b = aVar;
    }

    public void a() {
        this.f6676a.setOnLongClickListener(this.f6681f);
        this.f6676a.setOnTouchListener(this.f6682g);
    }

    public void b() {
        this.f6676a.setOnLongClickListener(null);
        this.f6676a.setOnTouchListener(null);
    }

    public void c(@c.m0 Point point) {
        point.set(this.f6678c, this.f6679d);
    }

    public boolean d(@c.m0 View view) {
        return this.f6677b.a(view, this);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0046  */
    public boolean e(@c.m0 View view, @c.m0 MotionEvent motionEvent) {
        int x7 = (int) motionEvent.getX();
        int y7 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6678c = x7;
            this.f6679d = y7;
        } else if (action == 1) {
            this.f6680e = false;
        } else if (action != 2) {
            if (action == 3) {
                this.f6680e = false;
            }
        } else if (q1.l(motionEvent, 8194) && (motionEvent.getButtonState() & 1) != 0 && !this.f6680e && (this.f6678c != x7 || this.f6679d != y7)) {
            this.f6678c = x7;
            this.f6679d = y7;
            boolean zA = this.f6677b.a(view, this);
            this.f6680e = zA;
            return zA;
        }
        return false;
    }
}
