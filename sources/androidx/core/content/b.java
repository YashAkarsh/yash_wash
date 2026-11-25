package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import androidx.core.os.g0;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    @t0(16)
    static class a {
        private a() {
        }

        @c.t
        static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, cancellationSignal);
        }
    }

    private b() {
    }

    @o0
    public static Cursor a(@m0 ContentResolver contentResolver, @m0 Uri uri, @o0 String[] strArr, @o0 String str, @o0 String[] strArr2, @o0 String str2, @o0 androidx.core.os.e eVar) throws Exception {
        Object objB;
        if (eVar != null) {
            try {
                objB = eVar.b();
            } catch (Exception e8) {
                if (e8 instanceof OperationCanceledException) {
                    throw new g0();
                }
                throw e8;
            }
        } else {
            objB = null;
        }
        return a.a(contentResolver, uri, strArr, str, strArr2, str2, (CancellationSignal) objB);
    }
}
