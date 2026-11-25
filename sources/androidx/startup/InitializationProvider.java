package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(@m0 Uri uri, @o0 String str, @o0 String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @o0
    public final String getType(@m0 Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    @o0
    public final Uri insert(@m0 Uri uri, @o0 ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            throw new c("Context cannot be null");
        }
        if (context.getApplicationContext() == null) {
            return true;
        }
        a.e(context).a();
        return true;
    }

    @Override // android.content.ContentProvider
    @o0
    public final Cursor query(@m0 Uri uri, @o0 String[] strArr, @o0 String str, @o0 String[] strArr2, @o0 String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    @Override // android.content.ContentProvider
    public final int update(@m0 Uri uri, @o0 ContentValues contentValues, @o0 String str, @o0 String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
