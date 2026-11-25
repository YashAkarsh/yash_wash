package com.alipay.sdk.tid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
final class c extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f13746b = "msp.db";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f13747c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f13748a;

    c(Context context) {
        super(context, f13746b, (SQLiteDatabase.CursorFactory) null, 1);
        this.f13748a = new WeakReference<>(context);
    }

    private String g(String str, String str2) {
        return str + str2;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x005c  */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    String b(String str, String str2) throws Throwable {
        SQLiteDatabase readableDatabase;
        Cursor cursorRawQuery;
        Cursor cursor = null;
        string = null;
        string = null;
        String string = null;
        cursor = null;
        try {
            readableDatabase = getReadableDatabase();
            try {
                cursorRawQuery = readableDatabase.rawQuery("select tid from tb_tid where name=?", new String[]{g(str, str2)});
                try {
                    string = cursorRawQuery.moveToFirst() ? cursorRawQuery.getString(0) : null;
                    cursorRawQuery.close();
                    if (readableDatabase.isOpen()) {
                        readableDatabase.close();
                    }
                } catch (Exception unused) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (readableDatabase != null && readableDatabase.isOpen()) {
                    }
                    if (TextUtils.isEmpty(string)) {
                        return string;
                    }
                    return com.alipay.sdk.encrypt.b.c(string, com.alipay.sdk.util.b.h(this.f13748a.get()));
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (readableDatabase != null && readableDatabase.isOpen()) {
                        readableDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                cursorRawQuery = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            cursorRawQuery = null;
            readableDatabase = null;
        } catch (Throwable th3) {
            th = th3;
            readableDatabase = null;
        }
        if (TextUtils.isEmpty(string)) {
            return com.alipay.sdk.encrypt.b.c(string, com.alipay.sdk.util.b.h(this.f13748a.get()));
        }
        return string;
    }

    void e() {
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.execSQL("drop table if exists tb_tid");
                if (writableDatabase.isOpen()) {
                    writableDatabase.close();
                }
            } catch (Exception e8) {
                com.alipay.sdk.util.d.d(e8);
                if (writableDatabase != null && writableDatabase.isOpen()) {
                }
            }
        } catch (Throwable th) {
            if (writableDatabase != null && writableDatabase.isOpen()) {
                writableDatabase.close();
            }
            throw th;
        }
    }

    String f(String str, String str2) throws Throwable {
        SQLiteDatabase readableDatabase;
        Cursor cursorRawQuery;
        Cursor cursor = null;
        string = null;
        string = null;
        String string = null;
        cursor = null;
        try {
            readableDatabase = getReadableDatabase();
            try {
                cursorRawQuery = readableDatabase.rawQuery("select key_tid from tb_tid where name=?", new String[]{g(str, str2)});
                try {
                    string = cursorRawQuery.moveToFirst() ? cursorRawQuery.getString(0) : null;
                    cursorRawQuery.close();
                    if (readableDatabase.isOpen()) {
                        readableDatabase.close();
                    }
                } catch (Exception unused) {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    if (readableDatabase != null && readableDatabase.isOpen()) {
                    }
                    return string;
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (readableDatabase != null && readableDatabase.isOpen()) {
                        readableDatabase.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                cursorRawQuery = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            cursorRawQuery = null;
            readableDatabase = null;
        } catch (Throwable th3) {
            th = th3;
            readableDatabase = null;
        }
        return string;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i7, int i8) {
        sQLiteDatabase.execSQL("drop table if exists tb_tid");
    }
}
