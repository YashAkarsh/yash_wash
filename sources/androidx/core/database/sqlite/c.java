package androidx.core.database.sqlite;

import a7.d;
import android.database.sqlite.SQLiteDatabase;
import i5.l;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final <T> T a(@d SQLiteDatabase sQLiteDatabase, boolean z7, @d l<? super SQLiteDatabase, ? extends T> body) {
        l0.p(sQLiteDatabase, "<this>");
        l0.p(body, "body");
        if (z7) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tZ = body.z(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tZ;
        } finally {
            i0.d(1);
            sQLiteDatabase.endTransaction();
            i0.c(1);
        }
    }

    public static /* synthetic */ Object b(SQLiteDatabase sQLiteDatabase, boolean z7, l body, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = true;
        }
        l0.p(sQLiteDatabase, "<this>");
        l0.p(body, "body");
        if (z7) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objZ = body.z(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objZ;
        } finally {
            i0.d(1);
            sQLiteDatabase.endTransaction();
            i0.c(1);
        }
    }
}
