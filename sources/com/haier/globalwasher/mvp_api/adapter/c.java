package com.haier.globalwasher.mvp_api.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.haier.globalwasher.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> extends RecyclerView.g<a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24779e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24780f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f24781g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f24782h = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<T> f24783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f24784d;

    public static class a extends RecyclerView.d0 {
        private View H;
        private SparseArray<View> I;

        public a(View view) {
            super(view);
            this.H = view;
            this.I = new SparseArray<>();
        }

        public <V> V O(int i7) {
            return (V) this.I.get(i7);
        }

        public void P(int... iArr) {
            for (int i7 : iArr) {
                this.I.put(i7, this.H.findViewById(i7));
            }
        }
    }

    public c(ArrayList<T> arrayList, int i7) {
        this.f24783c = arrayList;
        this.f24784d = i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public a w(ViewGroup viewGroup, int i7) {
        View viewInflate;
        int i8 = this.f24784d;
        if (i8 == 1) {
            viewInflate = View.inflate(viewGroup.getContext(), R.layout.adapter_base_view, null);
        } else if (i8 == 2) {
            viewInflate = View.inflate(viewGroup.getContext(), R.layout.adapter_base_view_not_projection, null);
        } else if (i8 == 3) {
            viewInflate = View.inflate(viewGroup.getContext(), R.layout.adapter_base_view_not_projection_have_padding, null);
        } else {
            viewInflate = i8 == 4 ? View.inflate(viewGroup.getContext(), R.layout.adapter_base_view_all_not, null) : View.inflate(viewGroup.getContext(), R.layout.adapter_base_view, null);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.v_padding);
        if (H()) {
            viewFindViewById.setVisibility(0);
        } else {
            viewFindViewById.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.lly_margin);
        View viewG = G(viewGroup.getContext());
        if (viewG != null) {
            linearLayout.addView(viewG);
        }
        return new a(viewInflate);
    }

    public abstract View G(Context context);

    public abstract boolean H();

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f24783c.size();
    }
}
