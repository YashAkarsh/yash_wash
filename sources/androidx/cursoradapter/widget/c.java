package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7087l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7088m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private LayoutInflater f7089n;

    @Deprecated
    public c(Context context, int i7, Cursor cursor) {
        super(context, cursor);
        this.f7088m = i7;
        this.f7087l = i7;
        this.f7089n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.a
    public View i(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f7089n.inflate(this.f7088m, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.a
    public View j(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f7089n.inflate(this.f7087l, viewGroup, false);
    }

    public void n(int i7) {
        this.f7088m = i7;
    }

    public void o(int i7) {
        this.f7087l = i7;
    }

    @Deprecated
    public c(Context context, int i7, Cursor cursor, boolean z7) {
        super(context, cursor, z7);
        this.f7088m = i7;
        this.f7087l = i7;
        this.f7089n = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public c(Context context, int i7, Cursor cursor, int i8) {
        super(context, cursor, i8);
        this.f7088m = i7;
        this.f7087l = i7;
        this.f7089n = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
