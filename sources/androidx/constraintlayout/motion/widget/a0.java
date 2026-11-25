package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MotionLayout f3930a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashSet<View> f3932c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayList<z.b> f3934e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<z> f3931b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3933d = "ViewTransitionController";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<z.b> f3935f = new ArrayList<>();

    class a implements androidx.constraintlayout.widget.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z f3936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f3938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3939d;

        a(final z val$viewTransition, final int val$listen_for_id, final boolean val$isSet, final int val$listen_for_value) {
            this.f3936a = val$viewTransition;
            this.f3937b = val$listen_for_id;
            this.f3938c = val$isSet;
            this.f3939d = val$listen_for_value;
        }

        @Override // androidx.constraintlayout.widget.f.a
        public void a(int id, int value, int oldValue) {
            int iH = this.f3936a.h();
            this.f3936a.r(value);
            if (this.f3937b != id || iH == value) {
                return;
            }
            if (this.f3938c) {
                if (this.f3939d == value) {
                    int childCount = a0.this.f3930a.getChildCount();
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View childAt = a0.this.f3930a.getChildAt(i7);
                        if (this.f3936a.m(childAt)) {
                            int currentState = a0.this.f3930a.getCurrentState();
                            androidx.constraintlayout.widget.d dVarZ0 = a0.this.f3930a.z0(currentState);
                            z zVar = this.f3936a;
                            a0 a0Var = a0.this;
                            zVar.c(a0Var, a0Var.f3930a, currentState, dVarZ0, childAt);
                        }
                    }
                    return;
                }
                return;
            }
            if (this.f3939d != value) {
                int childCount2 = a0.this.f3930a.getChildCount();
                for (int i8 = 0; i8 < childCount2; i8++) {
                    View childAt2 = a0.this.f3930a.getChildAt(i8);
                    if (this.f3936a.m(childAt2)) {
                        int currentState2 = a0.this.f3930a.getCurrentState();
                        androidx.constraintlayout.widget.d dVarZ1 = a0.this.f3930a.z0(currentState2);
                        z zVar2 = this.f3936a;
                        a0 a0Var2 = a0.this;
                        zVar2.c(a0Var2, a0Var2.f3930a, currentState2, dVarZ1, childAt2);
                    }
                }
            }
        }
    }

    public a0(MotionLayout layout) {
        this.f3930a = layout;
    }

    private void i(z viewTransition, boolean isSet) {
        ConstraintLayout.getSharedValues().a(viewTransition.i(), new a(viewTransition, viewTransition.i(), isSet, viewTransition.g()));
    }

    private void n(z vt, View... view) {
        int currentState = this.f3930a.getCurrentState();
        if (vt.f4338f == 2) {
            vt.c(this, this.f3930a, currentState, null, view);
            return;
        }
        if (currentState != -1) {
            androidx.constraintlayout.widget.d dVarZ0 = this.f3930a.z0(currentState);
            if (dVarZ0 == null) {
                return;
            }
            vt.c(this, this.f3930a, currentState, dVarZ0, view);
            return;
        }
        Log.w(this.f3933d, "No support for ViewTransition within transition yet. Currently: " + this.f3930a.toString());
    }

    public void b(z viewTransition) {
        this.f3931b.add(viewTransition);
        this.f3932c = null;
        if (viewTransition.j() == 4) {
            i(viewTransition, true);
        } else if (viewTransition.j() == 5) {
            i(viewTransition, false);
        }
    }

    void c(z.b animation) {
        if (this.f3934e == null) {
            this.f3934e = new ArrayList<>();
        }
        this.f3934e.add(animation);
    }

    void d() {
        ArrayList<z.b> arrayList = this.f3934e;
        if (arrayList == null) {
            return;
        }
        Iterator<z.b> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f3934e.removeAll(this.f3935f);
        this.f3935f.clear();
        if (this.f3934e.isEmpty()) {
            this.f3934e = null;
        }
    }

    boolean e(int viewTransitionId, o motionController) {
        for (z zVar : this.f3931b) {
            if (zVar.e() == viewTransitionId) {
                zVar.f4339g.a(motionController);
                return true;
            }
        }
        return false;
    }

    void f(int id, boolean enable) {
        for (z zVar : this.f3931b) {
            if (zVar.e() == id) {
                zVar.o(enable);
                return;
            }
        }
    }

    void g() {
        this.f3930a.invalidate();
    }

    boolean h(int id) {
        for (z zVar : this.f3931b) {
            if (zVar.e() == id) {
                return zVar.k();
            }
        }
        return false;
    }

    void j(int id) {
        z next;
        Iterator<z> it = this.f3931b.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.e() != id);
        if (next != null) {
            this.f3932c = null;
            this.f3931b.remove(next);
        }
    }

    void k(z.b animation) {
        this.f3935f.add(animation);
    }

    void l(MotionEvent event) {
        int currentState = this.f3930a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.f3932c == null) {
            this.f3932c = new HashSet<>();
            for (z zVar : this.f3931b) {
                int childCount = this.f3930a.getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = this.f3930a.getChildAt(i7);
                    if (zVar.m(childAt)) {
                        childAt.getId();
                        this.f3932c.add(childAt);
                    }
                }
            }
        }
        float x7 = event.getX();
        float y7 = event.getY();
        Rect rect = new Rect();
        int action = event.getAction();
        ArrayList<z.b> arrayList = this.f3934e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<z.b> it = this.f3934e.iterator();
            while (it.hasNext()) {
                it.next().d(action, x7, y7);
            }
        }
        if (action == 0 || action == 1) {
            androidx.constraintlayout.widget.d dVarZ0 = this.f3930a.z0(currentState);
            Iterator<z> it2 = this.f3931b.iterator();
            while (it2.hasNext()) {
                z next = it2.next();
                if (next.u(action)) {
                    for (View view : this.f3932c) {
                        if (next.m(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x7, (int) y7)) {
                                next.c(this, this.f3930a, currentState, dVarZ0, view);
                            }
                            next = next;
                        }
                    }
                }
            }
        }
    }

    void m(int id, View... views) {
        ArrayList arrayList = new ArrayList();
        z zVar = null;
        for (z zVar2 : this.f3931b) {
            if (zVar2.e() == id) {
                for (View view : views) {
                    if (zVar2.d(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    n(zVar2, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                zVar = zVar2;
            }
        }
        if (zVar == null) {
            Log.e(this.f3933d, " Could not find ViewTransition");
        }
    }
}
