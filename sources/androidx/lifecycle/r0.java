package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;

/* JADX INFO: loaded from: classes.dex */
public class r0 {
    private r0() {
    }

    @c.o0
    public static q a(@c.m0 View view) {
        q qVar = (q) view.getTag(R.id.view_tree_lifecycle_owner);
        if (qVar != null) {
            return qVar;
        }
        Object parent = view.getParent();
        while (qVar == null && (parent instanceof View)) {
            View view2 = (View) parent;
            qVar = (q) view2.getTag(R.id.view_tree_lifecycle_owner);
            parent = view2.getParent();
        }
        return qVar;
    }

    public static void b(@c.m0 View view, @c.o0 q qVar) {
        view.setTag(R.id.view_tree_lifecycle_owner, qVar);
    }
}
