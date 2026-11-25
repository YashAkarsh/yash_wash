package androidx.browser.browseractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.core.content.res.i;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<androidx.browser.browseractions.a> f2073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2074b;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f2075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f2076b;

        a() {
        }
    }

    b(List<androidx.browser.browseractions.a> list, Context context) {
        this.f2073a = list;
        this.f2074b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2073a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        return this.f2073a.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        a aVar;
        androidx.browser.browseractions.a aVar2 = this.f2073a.get(i7);
        if (view == null) {
            view = LayoutInflater.from(this.f2074b).inflate(R.layout.browser_actions_context_menu_row, (ViewGroup) null);
            aVar = new a();
            aVar.f2075a = (ImageView) view.findViewById(R.id.browser_actions_menu_item_icon);
            aVar.f2076b = (TextView) view.findViewById(R.id.browser_actions_menu_item_text);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f2076b.setText(aVar2.c());
        if (aVar2.b() != 0) {
            aVar.f2075a.setImageDrawable(i.g(this.f2074b.getResources(), aVar2.b(), null));
        } else {
            aVar.f2075a.setImageDrawable(null);
        }
        return view;
    }
}
