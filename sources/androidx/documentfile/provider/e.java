package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import c.o0;
import c.t0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class e extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f7318d;

    e(@o0 a aVar, Context context, Uri uri) {
        super(aVar);
        this.f7317c = context;
        this.f7318d = uri;
    }

    private static void w(@o0 AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e8) {
                throw e8;
            } catch (Exception unused) {
            }
        }
    }

    @o0
    private static Uri x(Context context, Uri uri, String str, String str2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.documentfile.provider.a
    public boolean a() {
        return b.a(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    public boolean b() {
        return b.b(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public a c(String str) {
        Uri uriX = x(this.f7317c, this.f7318d, "vnd.android.document/directory", str);
        if (uriX != null) {
            return new e(this, this.f7317c, uriX);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public a d(String str, String str2) {
        Uri uriX = x(this.f7317c, this.f7318d, str, str2);
        if (uriX != null) {
            return new e(this, this.f7317c, uriX);
        }
        return null;
    }

    @Override // androidx.documentfile.provider.a
    public boolean e() {
        try {
            return DocumentsContract.deleteDocument(this.f7317c.getContentResolver(), this.f7318d);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // androidx.documentfile.provider.a
    public boolean f() {
        return b.d(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public String k() {
        return b.f(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    @o0
    public String m() {
        return b.h(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    public Uri n() {
        return this.f7318d;
    }

    @Override // androidx.documentfile.provider.a
    public boolean o() {
        return b.i(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    public boolean q() {
        return b.j(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    public boolean r() {
        return b.k(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    public long s() {
        return b.l(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    public long t() {
        return b.m(this.f7317c, this.f7318d);
    }

    @Override // androidx.documentfile.provider.a
    public a[] u() {
        ContentResolver contentResolver = this.f7317c.getContentResolver();
        Uri uri = this.f7318d;
        Uri uriBuildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uriBuildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
                while (cursorQuery.moveToNext()) {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(this.f7318d, cursorQuery.getString(0)));
                }
            } catch (Exception e8) {
                Log.w("DocumentFile", "Failed query: " + e8);
            }
            w(cursorQuery);
            Uri[] uriArr = (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            a[] aVarArr = new a[uriArr.length];
            for (int i7 = 0; i7 < uriArr.length; i7++) {
                aVarArr[i7] = new e(this, this.f7317c, uriArr[i7]);
            }
            return aVarArr;
        } catch (Throwable th) {
            w(cursorQuery);
            throw th;
        }
    }

    @Override // androidx.documentfile.provider.a
    public boolean v(String str) {
        try {
            Uri uriRenameDocument = DocumentsContract.renameDocument(this.f7317c.getContentResolver(), this.f7318d, str);
            if (uriRenameDocument != null) {
                this.f7318d = uriRenameDocument;
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
