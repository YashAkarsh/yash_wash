package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.l0;
import androidx.core.view.accessibility.r0;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class y extends androidx.core.view.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RecyclerView f9748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f9749e;

    public static class a extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final y f9750d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<View, androidx.core.view.a> f9751e = new WeakHashMap();

        public a(@m0 y yVar) {
            this.f9750d = yVar;
        }

        @Override // androidx.core.view.a
        public boolean a(@m0 View view, @m0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f9751e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        @o0
        public r0 b(@m0 View view) {
            androidx.core.view.a aVar = this.f9751e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // androidx.core.view.a
        public void f(@m0 View view, @m0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f9751e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public void g(View view, l0 l0Var) {
            if (this.f9750d.o() || this.f9750d.f9748d.getLayoutManager() == null) {
                super.g(view, l0Var);
                return;
            }
            this.f9750d.f9748d.getLayoutManager().f1(view, l0Var);
            androidx.core.view.a aVar = this.f9751e.get(view);
            if (aVar != null) {
                aVar.g(view, l0Var);
            } else {
                super.g(view, l0Var);
            }
        }

        @Override // androidx.core.view.a
        public void h(@m0 View view, @m0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f9751e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public boolean i(@m0 ViewGroup viewGroup, @m0 View view, @m0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f9751e.get(viewGroup);
            return aVar != null ? aVar.i(viewGroup, view, accessibilityEvent) : super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i7, Bundle bundle) {
            if (this.f9750d.o() || this.f9750d.f9748d.getLayoutManager() == null) {
                return super.j(view, i7, bundle);
            }
            androidx.core.view.a aVar = this.f9751e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i7, bundle)) {
                    return true;
                }
            } else if (super.j(view, i7, bundle)) {
                return true;
            }
            return this.f9750d.f9748d.getLayoutManager().z1(view, i7, bundle);
        }

        @Override // androidx.core.view.a
        public void l(@m0 View view, int i7) {
            androidx.core.view.a aVar = this.f9751e.get(view);
            if (aVar != null) {
                aVar.l(view, i7);
            } else {
                super.l(view, i7);
            }
        }

        @Override // androidx.core.view.a
        public void m(@m0 View view, @m0 AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f9751e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        androidx.core.view.a n(View view) {
            return this.f9751e.remove(view);
        }

        void o(View view) {
            androidx.core.view.a aVarE = n2.E(view);
            if (aVarE == null || aVarE == this) {
                return;
            }
            this.f9751e.put(view, aVarE);
        }
    }

    public y(@m0 RecyclerView recyclerView) {
        this.f9748d = recyclerView;
        androidx.core.view.a aVarN = n();
        if (aVarN == null || !(aVarN instanceof a)) {
            this.f9749e = new a(this);
        } else {
            this.f9749e = (a) aVarN;
        }
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || o()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().b1(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.a
    public void g(View view, l0 l0Var) {
        super.g(view, l0Var);
        if (o() || this.f9748d.getLayoutManager() == null) {
            return;
        }
        this.f9748d.getLayoutManager().d1(l0Var);
    }

    @Override // androidx.core.view.a
    public boolean j(View view, int i7, Bundle bundle) {
        if (super.j(view, i7, bundle)) {
            return true;
        }
        if (o() || this.f9748d.getLayoutManager() == null) {
            return false;
        }
        return this.f9748d.getLayoutManager().x1(i7, bundle);
    }

    @m0
    public androidx.core.view.a n() {
        return this.f9749e;
    }

    boolean o() {
        return this.f9748d.C0();
    }
}
