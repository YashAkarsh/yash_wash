package androidx.databinding.adapters;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "android:alwaysDrawnWithCache", method = "setAlwaysDrawnWithCacheEnabled", type = ViewGroup.class), @androidx.databinding.g(attribute = "android:animationCache", method = "setAnimationCacheEnabled", type = ViewGroup.class), @androidx.databinding.g(attribute = "android:splitMotionEvents", method = "setMotionEventSplittingEnabled", type = ViewGroup.class)})
public class k0 {

    static class a implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f7240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f7241b;

        a(f fVar, g gVar) {
            this.f7240a = fVar;
            this.f7241b = gVar;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            f fVar = this.f7240a;
            if (fVar != null) {
                fVar.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            g gVar = this.f7241b;
            if (gVar != null) {
                gVar.onChildViewRemoved(view, view2);
            }
        }
    }

    static class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f7242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f7243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f7244c;

        b(e eVar, c cVar, d dVar) {
            this.f7242a = eVar;
            this.f7243b = cVar;
            this.f7244c = dVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            c cVar = this.f7243b;
            if (cVar != null) {
                cVar.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            d dVar = this.f7244c;
            if (dVar != null) {
                dVar.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            e eVar = this.f7242a;
            if (eVar != null) {
                eVar.onAnimationStart(animation);
            }
        }
    }

    public interface c {
        void onAnimationEnd(Animation animation);
    }

    public interface d {
        void onAnimationRepeat(Animation animation);
    }

    public interface e {
        void onAnimationStart(Animation animation);
    }

    public interface f {
        void onChildViewAdded(View view, View view2);
    }

    public interface g {
        void onChildViewRemoved(View view, View view2);
    }

    @androidx.databinding.d({"android:animateLayoutChanges"})
    @TargetApi(11)
    public static void a(ViewGroup viewGroup, boolean z7) {
        if (z7) {
            viewGroup.setLayoutTransition(new LayoutTransition());
        } else {
            viewGroup.setLayoutTransition(null);
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onAnimationStart", "android:onAnimationEnd", "android:onAnimationRepeat"})
    public static void b(ViewGroup viewGroup, e eVar, c cVar, d dVar) {
        if (eVar == null && cVar == null && dVar == null) {
            viewGroup.setLayoutAnimationListener(null);
        } else {
            viewGroup.setLayoutAnimationListener(new b(eVar, cVar, dVar));
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onChildViewAdded", "android:onChildViewRemoved"})
    public static void c(ViewGroup viewGroup, f fVar, g gVar) {
        if (fVar == null && gVar == null) {
            viewGroup.setOnHierarchyChangeListener(null);
        } else {
            viewGroup.setOnHierarchyChangeListener(new a(fVar, gVar));
        }
    }
}
