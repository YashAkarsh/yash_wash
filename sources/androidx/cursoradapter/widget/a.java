package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, androidx.cursoradapter.widget.b.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Deprecated
    public static final int f7073j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7074k = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected boolean f7075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected boolean f7076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected Cursor f7077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected Context f7078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected int f7079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected C0084a f7080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected DataSetObserver f7081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected androidx.cursoradapter.widget.b f7082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected FilterQueryProvider f7083i;

    /* JADX INFO: renamed from: androidx.cursoradapter.widget.a$a, reason: collision with other inner class name */
    private class C0084a extends ContentObserver {
        C0084a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z7) {
            a.this.k();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f7075a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f7075a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public a(Context context, Cursor cursor) {
        g(context, cursor, 1);
    }

    public CharSequence a(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public void b(Cursor cursor) {
        Cursor cursorM = m(cursor);
        if (cursorM != null) {
            cursorM.close();
        }
    }

    @Override // androidx.cursoradapter.widget.b.a
    public Cursor c() {
        return this.f7077c;
    }

    public Cursor d(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.f7083i;
        return filterQueryProvider != null ? filterQueryProvider.runQuery(charSequence) : this.f7077c;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    public FilterQueryProvider f() {
        return this.f7083i;
    }

    void g(Context context, Cursor cursor, int i7) {
        if ((i7 & 1) == 1) {
            i7 |= 2;
            this.f7076b = true;
        } else {
            this.f7076b = false;
        }
        boolean z7 = cursor != null;
        this.f7077c = cursor;
        this.f7075a = z7;
        this.f7078d = context;
        this.f7079e = z7 ? cursor.getColumnIndexOrThrow(com.haier.globalwasher.modle.sqlitedatabase.a.f24533k) : -1;
        if ((i7 & 2) == 2) {
            this.f7080f = new C0084a();
            this.f7081g = new b();
        } else {
            this.f7080f = null;
            this.f7081g = null;
        }
        if (z7) {
            C0084a c0084a = this.f7080f;
            if (c0084a != null) {
                cursor.registerContentObserver(c0084a);
            }
            DataSetObserver dataSetObserver = this.f7081g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f7075a || (cursor = this.f7077c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f7075a) {
            return null;
        }
        this.f7077c.moveToPosition(i7);
        if (view == null) {
            view = i(this.f7078d, this.f7077c, viewGroup);
        }
        e(view, this.f7078d, this.f7077c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f7082h == null) {
            this.f7082h = new androidx.cursoradapter.widget.b(this);
        }
        return this.f7082h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        Cursor cursor;
        if (!this.f7075a || (cursor = this.f7077c) == null) {
            return null;
        }
        cursor.moveToPosition(i7);
        return this.f7077c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        Cursor cursor;
        if (this.f7075a && (cursor = this.f7077c) != null && cursor.moveToPosition(i7)) {
            return this.f7077c.getLong(this.f7079e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        if (!this.f7075a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f7077c.moveToPosition(i7)) {
            if (view == null) {
                view = j(this.f7078d, this.f7077c, viewGroup);
            }
            e(view, this.f7078d, this.f7077c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i7);
    }

    @Deprecated
    protected void h(Context context, Cursor cursor, boolean z7) {
        g(context, cursor, z7 ? 1 : 2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public View i(Context context, Cursor cursor, ViewGroup viewGroup) {
        return j(context, cursor, viewGroup);
    }

    public abstract View j(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void k() {
        Cursor cursor;
        if (!this.f7076b || (cursor = this.f7077c) == null || cursor.isClosed()) {
            return;
        }
        this.f7075a = this.f7077c.requery();
    }

    public void l(FilterQueryProvider filterQueryProvider) {
        this.f7083i = filterQueryProvider;
    }

    public Cursor m(Cursor cursor) {
        Cursor cursor2 = this.f7077c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0084a c0084a = this.f7080f;
            if (c0084a != null) {
                cursor2.unregisterContentObserver(c0084a);
            }
            DataSetObserver dataSetObserver = this.f7081g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f7077c = cursor;
        if (cursor != null) {
            C0084a c0084a2 = this.f7080f;
            if (c0084a2 != null) {
                cursor.registerContentObserver(c0084a2);
            }
            DataSetObserver dataSetObserver2 = this.f7081g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f7079e = cursor.getColumnIndexOrThrow(com.haier.globalwasher.modle.sqlitedatabase.a.f24533k);
            this.f7075a = true;
            notifyDataSetChanged();
        } else {
            this.f7079e = -1;
            this.f7075a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public a(Context context, Cursor cursor, boolean z7) {
        g(context, cursor, z7 ? 1 : 2);
    }

    public a(Context context, Cursor cursor, int i7) {
        g(context, cursor, i7);
    }
}
