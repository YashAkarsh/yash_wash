package androidx.viewpager2.adapter;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.n2;
import androidx.recyclerview.widget.RecyclerView;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public final class a extends RecyclerView.d0 {
    private a(@m0 FrameLayout frameLayout) {
        super(frameLayout);
    }

    @m0
    static a O(@m0 ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setId(n2.D());
        frameLayout.setSaveEnabled(false);
        return new a(frameLayout);
    }

    @m0
    FrameLayout P() {
        return (FrameLayout) this.f9157a;
    }
}
