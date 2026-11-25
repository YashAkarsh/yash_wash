package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;

/* JADX INFO: loaded from: classes.dex */
public class t0 {
    private t0() {
    }

    @c.o0
    public static q0 a(@c.m0 View view) {
        q0 q0Var = (q0) view.getTag(R.id.view_tree_view_model_store_owner);
        if (q0Var != null) {
            return q0Var;
        }
        Object parent = view.getParent();
        while (q0Var == null && (parent instanceof View)) {
            View view2 = (View) parent;
            q0Var = (q0) view2.getTag(R.id.view_tree_view_model_store_owner);
            parent = view2.getParent();
        }
        return q0Var;
    }

    public static void b(@c.m0 View view, @c.o0 q0 q0Var) {
        view.setTag(R.id.view_tree_view_model_store_owner, q0Var);
    }
}
