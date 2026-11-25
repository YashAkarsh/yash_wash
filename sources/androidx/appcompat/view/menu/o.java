package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public interface o {

    public interface a {
        boolean d();

        boolean f();

        void g(j jVar, int i7);

        j getItemData();

        void setCheckable(boolean z7);

        void setChecked(boolean z7);

        void setEnabled(boolean z7);

        void setIcon(Drawable drawable);

        void setShortcut(boolean z7, char c8);

        void setTitle(CharSequence charSequence);
    }

    void e(g gVar);

    int getWindowAnimations();
}
