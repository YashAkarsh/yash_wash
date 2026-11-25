package androidx.savedstate;

import android.view.View;
import h5.h;
import i5.l;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.sequences.s;
import kotlin.sequences.u;

/* JADX INFO: loaded from: classes.dex */
@h(name = "ViewTreeSavedStateRegistryOwner")
public final class e {

    static final class a extends n0 implements l<View, View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9770a = new a();

        a() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final View z(@a7.d View view) {
            l0.p(view, "view");
            Object parent = view.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    static final class b extends n0 implements l<View, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9771a = new b();

        b() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final d z(@a7.d View view) {
            l0.p(view, "view");
            Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
            if (tag instanceof d) {
                return (d) tag;
            }
            return null;
        }
    }

    @a7.e
    @h(name = "get")
    public static final d a(@a7.d View view) {
        l0.p(view, "<this>");
        return (d) u.F0(u.p1(s.n(view, a.f9770a), b.f9771a));
    }

    @h(name = "set")
    public static final void b(@a7.d View view, @a7.e d dVar) {
        l0.p(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, dVar);
    }
}
