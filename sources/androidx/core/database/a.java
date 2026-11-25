package androidx.core.database;

import android.database.Cursor;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    @a7.e
    public static final byte[] a(@a7.d Cursor cursor, int i7) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i7)) {
            return null;
        }
        return cursor.getBlob(i7);
    }

    @a7.e
    public static final Double b(@a7.d Cursor cursor, int i7) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i7)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i7));
    }

    @a7.e
    public static final Float c(@a7.d Cursor cursor, int i7) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i7)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i7));
    }

    @a7.e
    public static final Integer d(@a7.d Cursor cursor, int i7) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i7)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i7));
    }

    @a7.e
    public static final Long e(@a7.d Cursor cursor, int i7) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i7)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i7));
    }

    @a7.e
    public static final Short f(@a7.d Cursor cursor, int i7) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i7)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i7));
    }

    @a7.e
    public static final String g(@a7.d Cursor cursor, int i7) {
        l0.p(cursor, "<this>");
        if (cursor.isNull(i7)) {
            return null;
        }
        return cursor.getString(i7);
    }
}
