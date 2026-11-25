package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.x0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
class t<T> extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<T> f7252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.databinding.w.a f7253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f7254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f7256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f7257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LayoutInflater f7258g;

    class a extends androidx.databinding.w.a {
        a() {
        }

        @Override // androidx.databinding.w.a
        public void a(androidx.databinding.w wVar) {
            t.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.w.a
        public void f(androidx.databinding.w wVar, int i7, int i8) {
            t.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.w.a
        public void g(androidx.databinding.w wVar, int i7, int i8) {
            t.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.w.a
        public void h(androidx.databinding.w wVar, int i7, int i8, int i9) {
            t.this.notifyDataSetChanged();
        }

        @Override // androidx.databinding.w.a
        public void i(androidx.databinding.w wVar, int i7, int i8) {
            t.this.notifyDataSetChanged();
        }
    }

    public t(Context context, List<T> list, int i7, int i8, int i9) {
        this.f7254c = context;
        this.f7256e = i7;
        this.f7255d = i8;
        this.f7257f = i9;
        this.f7258g = i7 == 0 ? null : (LayoutInflater) context.getSystemService("layout_inflater");
        b(list);
    }

    public View a(int i7, int i8, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = i7 == 0 ? new TextView(this.f7254c) : this.f7258g.inflate(i7, viewGroup, false);
        }
        int i9 = this.f7257f;
        TextView textView = (TextView) (i9 == 0 ? view : view.findViewById(i9));
        T t7 = this.f7252a.get(i8);
        textView.setText(t7 instanceof CharSequence ? (CharSequence) t7 : String.valueOf(t7));
        return view;
    }

    public void b(List<T> list) {
        List<T> list2 = this.f7252a;
        if (list2 == list) {
            return;
        }
        if (list2 instanceof androidx.databinding.w) {
            ((androidx.databinding.w) list2).q(this.f7253b);
        }
        this.f7252a = list;
        if (list instanceof androidx.databinding.w) {
            if (this.f7253b == null) {
                this.f7253b = new a();
            }
            ((androidx.databinding.w) this.f7252a).r0(this.f7253b);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7252a.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        return a(this.f7255d, i7, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        return this.f7252a.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        return a(this.f7256e, i7, view, viewGroup);
    }
}
