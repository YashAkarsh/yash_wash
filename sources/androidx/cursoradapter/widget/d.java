package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public class d extends c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected int[] f7090o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP})
    protected int[] f7091p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f7092q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private a f7093r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b f7094s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String[] f7095t;

    public interface a {
        CharSequence a(Cursor cursor);
    }

    public interface b {
        boolean a(View view, Cursor cursor, int i7);
    }

    @Deprecated
    public d(Context context, int i7, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i7, cursor);
        this.f7092q = -1;
        this.f7091p = iArr;
        this.f7095t = strArr;
        q(cursor, strArr);
    }

    private void q(Cursor cursor, String[] strArr) {
        if (cursor == null) {
            this.f7090o = null;
            return;
        }
        int length = strArr.length;
        int[] iArr = this.f7090o;
        if (iArr == null || iArr.length != length) {
            this.f7090o = new int[length];
        }
        for (int i7 = 0; i7 < length; i7++) {
            this.f7090o[i7] = cursor.getColumnIndexOrThrow(strArr[i7]);
        }
    }

    @Override // androidx.cursoradapter.widget.a, androidx.cursoradapter.widget.b.a
    public CharSequence a(Cursor cursor) {
        a aVar = this.f7093r;
        if (aVar != null) {
            return aVar.a(cursor);
        }
        int i7 = this.f7092q;
        return i7 > -1 ? cursor.getString(i7) : super.a(cursor);
    }

    @Override // androidx.cursoradapter.widget.a
    public void e(View view, Context context, Cursor cursor) {
        b bVar = this.f7094s;
        int[] iArr = this.f7091p;
        int length = iArr.length;
        int[] iArr2 = this.f7090o;
        for (int i7 = 0; i7 < length; i7++) {
            View viewFindViewById = view.findViewById(iArr[i7]);
            if (viewFindViewById != null) {
                if (bVar != null ? bVar.a(viewFindViewById, cursor, iArr2[i7]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr2[i7]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewFindViewById instanceof TextView) {
                        y((TextView) viewFindViewById, string);
                    } else {
                        if (!(viewFindViewById instanceof ImageView)) {
                            throw new IllegalStateException(viewFindViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                        x((ImageView) viewFindViewById, string);
                    }
                }
            }
        }
    }

    @Override // androidx.cursoradapter.widget.a
    public Cursor m(Cursor cursor) {
        q(cursor, this.f7095t);
        return super.m(cursor);
    }

    public void p(Cursor cursor, String[] strArr, int[] iArr) {
        this.f7095t = strArr;
        this.f7091p = iArr;
        q(cursor, strArr);
        super.b(cursor);
    }

    public a r() {
        return this.f7093r;
    }

    public int s() {
        return this.f7092q;
    }

    public b t() {
        return this.f7094s;
    }

    public void u(a aVar) {
        this.f7093r = aVar;
    }

    public void v(int i7) {
        this.f7092q = i7;
    }

    public void w(b bVar) {
        this.f7094s = bVar;
    }

    public void x(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    public void y(TextView textView, String str) {
        textView.setText(str);
    }

    public d(Context context, int i7, Cursor cursor, String[] strArr, int[] iArr, int i8) {
        super(context, i7, cursor, i8);
        this.f7092q = -1;
        this.f7091p = iArr;
        this.f7095t = strArr;
        q(cursor, strArr);
    }
}
