package androidx.activity;

import android.view.View;
import i5.l;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.sequences.s;
import kotlin.sequences.u;

/* JADX INFO: loaded from: classes.dex */
@h5.h(name = "ViewTreeOnBackPressedDispatcherOwner")
public final class i {

    static final class a extends n0 implements l<View, View> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f579a = new a();

        a() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final View z(@a7.d View it) {
            l0.p(it, "it");
            Object parent = it.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    static final class b extends n0 implements l<View, h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f580a = new b();

        b() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h z(@a7.d View it) {
            l0.p(it, "it");
            Object tag = it.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
            if (tag instanceof h) {
                return (h) tag;
            }
            return null;
        }
    }

    @a7.e
    @h5.h(name = "get")
    public static final h a(@a7.d View view) {
        l0.p(view, "<this>");
        return (h) u.F0(u.p1(s.n(view, a.f579a), b.f580a));
    }

    @h5.h(name = "set")
    public static final void b(@a7.d View view, @a7.d h onBackPressedDispatcherOwner) {
        l0.p(view, "<this>");
        l0.p(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
