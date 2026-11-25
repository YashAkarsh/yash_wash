package com.haier.globalwasher.modle.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.haier.globalwasher.modle.bean.DataBaseQueryZFBBeen;
import com.haier.globalwasher.modle.utils.q;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f24526d = "OrderPaySqlitedDataBase";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24527e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f24528f = "paytmOrderPayTable";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f24529g = "ZFBOrderPayTable";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f24530h = "trade_no";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f24531i = "code";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f24532j = "payType";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f24533k = "_id";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f24534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f24535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24536c;

    public a(Context context) {
        super(context, f24526d, (SQLiteDatabase.CursorFactory) null, 1);
        this.f24534a = "CREATE TABLE IF NOT EXISTS paytmOrderPayTable(_id INTEGER PRIMARY KEY AUTOINCREMENT,code TEXT NOT NULL ,payType TEXT NOT NULL   )";
        this.f24535b = "CREATE TABLE IF NOT EXISTS ZFBOrderPayTable(_id INTEGER PRIMARY KEY AUTOINCREMENT,code TEXT NOT NULL ,payType TEXT NOT NULL ,trade_no TEXT NOT NULL   )";
        this.f24536c = "doStartPayPlugin";
    }

    public int b(String str, String str2) {
        String[] strArr = {String.valueOf(str.trim())};
        SQLiteDatabase writableDatabase = getWritableDatabase();
        int iDelete = writableDatabase.delete(str2, "code = ? ", strArr);
        writableDatabase.close();
        q.c(this.f24536c, str2 + "delete=" + iDelete);
        close();
        return iDelete;
    }

    public <T> long c(ContentValues contentValues, String str) {
        String str2 = (String) contentValues.get("code");
        ArrayList<T> arrayListF = f(str2, str);
        for (int i7 = 0; i7 < arrayListF.size(); i7++) {
            if (f24529g.equals(str) || f24528f.equals(str)) {
                DataBaseQueryZFBBeen dataBaseQueryZFBBeen = (DataBaseQueryZFBBeen) arrayListF.get(i7);
                q.c(this.f24536c, "orderCode=" + str2 + "---数据库" + dataBaseQueryZFBBeen.getCode());
                if (str2.equals(dataBaseQueryZFBBeen.getCode())) {
                    return -1L;
                }
            }
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long jInsert = writableDatabase.insert(str, null, contentValues);
        writableDatabase.close();
        close();
        q.c(this.f24536c, str + "insert=" + jInsert);
        return jInsert;
    }

    public int e(ContentValues contentValues, String str) {
        String[] strArr;
        String str2;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (f24528f.equals(str) || f24529g.equals(str)) {
            strArr = new String[]{(String) contentValues.get("code")};
            str2 = "code = ?";
        } else {
            str2 = null;
            strArr = null;
        }
        int iUpdate = readableDatabase.update(str, contentValues, str2, strArr);
        q.c(this.f24536c, "updata=" + iUpdate);
        readableDatabase.close();
        close();
        return iUpdate;
    }

    public <T> ArrayList<T> f(String str, String str2) {
        String[] strArr;
        String strTrim = str.trim();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        ArrayList<T> arrayList = new ArrayList<>();
        if (readableDatabase.isOpen()) {
            if (f24528f.equals(str2)) {
                strArr = new String[]{"code", "payType"};
            } else if (f24529g.equals(str2)) {
                strArr = new String[]{"code", "trade_no", "payType"};
            }
            Cursor cursorQuery = readableDatabase.query(str2, strArr, "code = ?", new String[]{strTrim}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToNext()) {
                if (f24528f.equals(str2)) {
                    arrayList.add(new DataBaseQueryZFBBeen(cursorQuery.getString(0) + "", cursorQuery.getString(1) + "", ""));
                } else if (f24529g.equals(str2)) {
                    arrayList.add(new DataBaseQueryZFBBeen(cursorQuery.getString(0) + "", cursorQuery.getString(1) + "", cursorQuery.getString(2) + ""));
                }
                return arrayList;
            }
            cursorQuery.close();
            readableDatabase.close();
        }
        return arrayList;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(this.f24534a);
            sQLiteDatabase.execSQL(this.f24535b);
            q.c("DataBase————", "onCreate DataBase");
        } catch (SQLException e8) {
            q.c("DataBase————", "onCreate Error" + e8.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i7, int i8) {
        try {
            q.c(this.f24536c, "DataBase————onUpgrade ");
        } catch (SQLException e8) {
            q.c(this.f24536c, "DataBase————onUpgrade    Error" + e8.toString());
        }
    }
}
