package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.x0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class f extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f1193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1194b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LayoutInflater f1197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1198f;

    public f(g gVar, LayoutInflater layoutInflater, boolean z7, int i7) {
        this.f1196d = z7;
        this.f1197e = layoutInflater;
        this.f1193a = gVar;
        this.f1198f = i7;
        a();
    }

    void a() {
        j jVarY = this.f1193a.y();
        if (jVarY != null) {
            ArrayList<j> arrayListC = this.f1193a.C();
            int size = arrayListC.size();
            for (int i7 = 0; i7 < size; i7++) {
                if (arrayListC.get(i7) == jVarY) {
                    this.f1194b = i7;
                    return;
                }
            }
        }
        this.f1194b = -1;
    }

    public g b() {
        return this.f1193a;
    }

    public boolean c() {
        return this.f1195c;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public j getItem(int i7) {
        ArrayList<j> arrayListC = this.f1196d ? this.f1193a.C() : this.f1193a.H();
        int i8 = this.f1194b;
        if (i8 >= 0 && i7 >= i8) {
            i7++;
        }
        return arrayListC.get(i7);
    }

    public void e(boolean z7) {
        this.f1195c = z7;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<j> arrayListC = this.f1196d ? this.f1193a.C() : this.f1193a.H();
        return this.f1194b < 0 ? arrayListC.size() : arrayListC.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1197e.inflate(this.f1198f, viewGroup, false);
        }
        int groupId = getItem(i7).getGroupId();
        int i8 = i7 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f1193a.I() && groupId != (i8 >= 0 ? getItem(i8).getGroupId() : groupId));
        o.a aVar = (o.a) view;
        if (this.f1195c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.g(getItem(i7), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
