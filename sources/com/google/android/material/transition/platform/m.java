package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import c.m0;
import c.o0;
import c.t0;
import com.google.android.material.R;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public class m extends SharedElementCallback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private static WeakReference<View> f19106f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private Rect f19110d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f19107a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19108b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19109c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private d f19111e = new e();

    class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f19112a;

        a(Window window) {
            this.f19112a = window;
        }

        @Override // com.google.android.material.transition.platform.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            m.i(this.f19112a);
        }

        @Override // com.google.android.material.transition.platform.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.h(this.f19112a);
        }
    }

    class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f19114a;

        b(Activity activity) {
            this.f19114a = activity;
        }

        @Override // com.google.android.material.transition.platform.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            View view;
            if (m.f19106f != null && (view = (View) m.f19106f.get()) != null) {
                view.setAlpha(1.0f);
                WeakReference unused = m.f19106f = null;
            }
            this.f19114a.finish();
            this.f19114a.overridePendingTransition(0, 0);
        }
    }

    class c extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Window f19116a;

        c(Window window) {
            this.f19116a = window;
        }

        @Override // com.google.android.material.transition.platform.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            m.h(this.f19116a);
        }
    }

    public interface d {
        @o0
        com.google.android.material.shape.o a(@m0 View view);
    }

    public static class e implements d {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.transition.platform.m.d
        @o0
        public com.google.android.material.shape.o a(@m0 View view) {
            if (view instanceof com.google.android.material.shape.s) {
                return ((com.google.android.material.shape.s) view).getShapeAppearanceModel();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Window window) {
        window.getDecorView().getBackground().mutate().setColorFilter(androidx.core.graphics.r.a(0, androidx.core.graphics.s.CLEAR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Window window) {
        window.getDecorView().getBackground().mutate().clearColorFilter();
    }

    private void m(Window window) {
        Transition sharedElementEnterTransition = window.getSharedElementEnterTransition();
        if (sharedElementEnterTransition instanceof l) {
            l lVar = (l) sharedElementEnterTransition;
            if (!this.f19109c) {
                window.setSharedElementReenterTransition(null);
            }
            if (this.f19108b) {
                o(window, lVar);
                lVar.addListener(new a(window));
            }
        }
    }

    private void n(Activity activity, Window window) {
        Transition sharedElementReturnTransition = window.getSharedElementReturnTransition();
        if (sharedElementReturnTransition instanceof l) {
            l lVar = (l) sharedElementReturnTransition;
            lVar.Y(true);
            lVar.addListener(new b(activity));
            if (this.f19108b) {
                o(window, lVar);
                lVar.addListener(new c(window));
            }
        }
    }

    private static void o(Window window, l lVar) {
        if (lVar.getDuration() >= 0) {
            window.setTransitionBackgroundFadeDuration(lVar.getDuration());
        }
    }

    @o0
    public d e() {
        return this.f19111e;
    }

    public boolean f() {
        return this.f19109c;
    }

    public boolean g() {
        return this.f19108b;
    }

    public void j(@o0 d dVar) {
        this.f19111e = dVar;
    }

    public void k(boolean z7) {
        this.f19109c = z7;
    }

    public void l(boolean z7) {
        this.f19108b = z7;
    }

    @Override // android.app.SharedElementCallback
    @o0
    public Parcelable onCaptureSharedElementSnapshot(@m0 View view, @m0 Matrix matrix, @m0 RectF rectF) {
        f19106f = new WeakReference<>(view);
        return super.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    @o0
    public View onCreateSnapshotView(@m0 Context context, @o0 Parcelable parcelable) {
        WeakReference<View> weakReference;
        View view;
        com.google.android.material.shape.o oVarA;
        View viewOnCreateSnapshotView = super.onCreateSnapshotView(context, parcelable);
        if (viewOnCreateSnapshotView != null && (weakReference = f19106f) != null && this.f19111e != null && (view = weakReference.get()) != null && (oVarA = this.f19111e.a(view)) != null) {
            viewOnCreateSnapshotView.setTag(R.id.mtrl_motion_snapshot_view, oVarA);
        }
        return viewOnCreateSnapshotView;
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(@m0 List<String> list, @m0 Map<String, View> map) {
        View view;
        Activity activityA;
        if (list.isEmpty() || map.isEmpty() || (view = map.get(list.get(0))) == null || (activityA = com.google.android.material.internal.b.a(view.getContext())) == null) {
            return;
        }
        Window window = activityA.getWindow();
        if (this.f19107a) {
            m(window);
        } else {
            n(activityA, window);
        }
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(@m0 List<String> list, @m0 List<View> list2, @m0 List<View> list3) {
        if (!list2.isEmpty() && (list2.get(0).getTag(R.id.mtrl_motion_snapshot_view) instanceof View)) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, null);
        }
        if (!this.f19107a && !list2.isEmpty()) {
            this.f19110d = v.k(list2.get(0));
        }
        this.f19107a = false;
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(@m0 List<String> list, @m0 List<View> list2, @m0 List<View> list3) {
        if (!list2.isEmpty() && !list3.isEmpty()) {
            list2.get(0).setTag(R.id.mtrl_motion_snapshot_view, list3.get(0));
        }
        if (this.f19107a || list2.isEmpty() || this.f19110d == null) {
            return;
        }
        View view = list2.get(0);
        view.measure(View.MeasureSpec.makeMeasureSpec(this.f19110d.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f19110d.height(), 1073741824));
        Rect rect = this.f19110d;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
    }
}
