package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c.m0;
import c.o0;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.u;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.a(creator = "DataHolderCreator", validate = true)
@c1.a
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @c1.a
    @m0
    public static final Parcelable.Creator<DataHolder> CREATOR = new r();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final a f15537k = new n(new String[0], null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SafeParcelable.g(id = 1000)
    final int f15538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SafeParcelable.c(getter = "getColumns", id = 1)
    private final String[] f15539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Bundle f15540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SafeParcelable.c(getter = "getWindows", id = 2)
    private final CursorWindow[] f15541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SafeParcelable.c(getter = "getStatusCode", id = 3)
    private final int f15542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    @SafeParcelable.c(getter = "getMetadata", id = 4)
    private final Bundle f15543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f15544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f15545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f15546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f15547j;

    @c1.a
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String[] f15548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f15549b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final HashMap<Object, Integer> f15550c = new HashMap<>();

        /* synthetic */ a(String[] strArr, String str, o oVar) {
            this.f15548a = (String[]) u.k(strArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @c1.a
        @m0
        public DataHolder a(int i7) {
            return new DataHolder(this, i7);
        }

        @c1.a
        @m0
        public DataHolder b(int i7, @m0 Bundle bundle) {
            return new DataHolder(this, i7, bundle);
        }

        @c1.a
        @m0
        public a c(@m0 ContentValues contentValues) {
            com.google.android.gms.common.internal.d.c(contentValues);
            HashMap<String, Object> map = new HashMap<>(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            return d(map);
        }

        @m0
        public a d(@m0 HashMap<String, Object> map) {
            com.google.android.gms.common.internal.d.c(map);
            this.f15549b.add(map);
            return this;
        }
    }

    @c1.a
    @m0
    public static DataHolder K(int i7) {
        return new DataHolder(f15537k, i7, (Bundle) null);
    }

    private final void Y0(String str, int i7) {
        Bundle bundle = this.f15540c;
        if (bundle == null || !bundle.containsKey(str)) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "No such column: ".concat(strValueOf) : new String("No such column: "));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i7 < 0 || i7 >= this.f15545h) {
            throw new CursorIndexOutOfBoundsException(i7, this.f15545h);
        }
    }

    private static CursorWindow[] a1(a aVar, int i7) {
        if (aVar.f15548a.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList arrayList = aVar.f15549b;
        int size = arrayList.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(cursorWindow);
        cursorWindow.setNumColumns(aVar.f15548a.length);
        int i8 = 0;
        boolean z7 = false;
        while (i8 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    StringBuilder sb = new StringBuilder(72);
                    sb.append("Allocating additional cursor window for large data set (row ");
                    sb.append(i8);
                    sb.append(")");
                    Log.d("DataHolder", sb.toString());
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i8);
                    cursorWindow.setNumColumns(aVar.f15548a.length);
                    arrayList2.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList2.remove(cursorWindow);
                        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
                    }
                }
                Map map = (Map) arrayList.get(i8);
                int i9 = 0;
                boolean zPutDouble = true;
                while (true) {
                    if (i9 >= aVar.f15548a.length) {
                        z7 = zPutDouble ? false : true;
                        i8++;
                    } else if (zPutDouble) {
                        String str = aVar.f15548a[i9];
                        Object obj = map.get(str);
                        if (obj == null) {
                            zPutDouble = cursorWindow.putNull(i8, i9);
                        } else if (obj instanceof String) {
                            zPutDouble = cursorWindow.putString((String) obj, i8, i9);
                        } else if (obj instanceof Long) {
                            zPutDouble = cursorWindow.putLong(((Long) obj).longValue(), i8, i9);
                        } else if (obj instanceof Integer) {
                            zPutDouble = cursorWindow.putLong(((Integer) obj).intValue(), i8, i9);
                        } else if (obj instanceof Boolean) {
                            zPutDouble = cursorWindow.putLong(true != ((Boolean) obj).booleanValue() ? 0L : 1L, i8, i9);
                        } else if (obj instanceof byte[]) {
                            zPutDouble = cursorWindow.putBlob((byte[]) obj, i8, i9);
                        } else if (obj instanceof Double) {
                            zPutDouble = cursorWindow.putDouble(((Double) obj).doubleValue(), i8, i9);
                        } else {
                            if (!(obj instanceof Float)) {
                                String string = obj.toString();
                                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 32 + string.length());
                                sb2.append("Unsupported object for column ");
                                sb2.append(str);
                                sb2.append(": ");
                                sb2.append(string);
                                throw new IllegalArgumentException(sb2.toString());
                            }
                            zPutDouble = cursorWindow.putDouble(((Float) obj).floatValue(), i8, i9);
                        }
                        i9++;
                    }
                    if (z7) {
                        throw new p("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                    }
                    StringBuilder sb3 = new StringBuilder(74);
                    sb3.append("Couldn't populate window data for row ");
                    sb3.append(i8);
                    sb3.append(" - allocating new window.");
                    Log.d("DataHolder", sb3.toString());
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i8);
                    cursorWindow.setNumColumns(aVar.f15548a.length);
                    arrayList2.add(cursorWindow);
                    i8--;
                    i8++;
                }
            } catch (RuntimeException e8) {
                int size2 = arrayList2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    ((CursorWindow) arrayList2.get(i10)).close();
                }
                throw e8;
            }
        }
        return (CursorWindow[]) arrayList2.toArray(new CursorWindow[arrayList2.size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c1.a
    @m0
    public static a s(@m0 String[] strArr) {
        return new a(strArr, null, 0 == true ? 1 : 0);
    }

    @c1.a
    public int G0(int i7) {
        int length;
        int i8 = 0;
        u.q(i7 >= 0 && i7 < this.f15545h);
        while (true) {
            int[] iArr = this.f15544g;
            length = iArr.length;
            if (i8 >= length) {
                break;
            }
            if (i7 < iArr[i8]) {
                i8--;
                break;
            }
            i8++;
        }
        return i8 == length ? i8 - 1 : i8;
    }

    @c1.a
    public boolean I0(@m0 String str) {
        return this.f15540c.containsKey(str);
    }

    @c1.a
    public boolean J0(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return this.f15541d[i8].isNull(i7, this.f15540c.getInt(str));
    }

    public final double L0(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return this.f15541d[i8].getDouble(i7, this.f15540c.getInt(str));
    }

    @c1.a
    public boolean Q(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return Long.valueOf(this.f15541d[i8].getLong(i7, this.f15540c.getInt(str))).longValue() == 1;
    }

    public final float Q0(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return this.f15541d[i8].getFloat(i7, this.f15540c.getInt(str));
    }

    public final void T0(@m0 String str, int i7, int i8, @m0 CharArrayBuffer charArrayBuffer) {
        Y0(str, i7);
        this.f15541d[i8].copyStringToBuffer(i7, this.f15540c.getInt(str), charArrayBuffer);
    }

    public final void V0() {
        this.f15540c = new Bundle();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            String[] strArr = this.f15539b;
            if (i8 >= strArr.length) {
                break;
            }
            this.f15540c.putInt(strArr[i8], i8);
            i8++;
        }
        this.f15544g = new int[this.f15541d.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f15541d;
            if (i7 >= cursorWindowArr.length) {
                this.f15545h = numRows;
                return;
            }
            this.f15544g[i7] = numRows;
            numRows += this.f15541d[i7].getNumRows() - (numRows - cursorWindowArr[i7].getStartPosition());
            i7++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @c1.a
    public void close() {
        synchronized (this) {
            if (!this.f15546i) {
                this.f15546i = true;
                int i7 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f15541d;
                    if (i7 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i7].close();
                    i7++;
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f15547j && this.f15541d.length > 0 && !isClosed()) {
                close();
                String string = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(string).length() + com.alibaba.fastjson.asm.j.T);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(string);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @c1.a
    public int getCount() {
        return this.f15545h;
    }

    @c1.a
    public boolean isClosed() {
        boolean z7;
        synchronized (this) {
            z7 = this.f15546i;
        }
        return z7;
    }

    @c1.a
    @m0
    public byte[] p0(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return this.f15541d[i8].getBlob(i7, this.f15540c.getInt(str));
    }

    @c1.a
    public int r0(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return this.f15541d[i8].getInt(i7, this.f15540c.getInt(str));
    }

    @c1.a
    public long s0(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return this.f15541d[i8].getLong(i7, this.f15540c.getInt(str));
    }

    @c1.a
    public int v0() {
        return this.f15542e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@m0 Parcel parcel, int i7) {
        int iA = e1.b.a(parcel);
        e1.b.Z(parcel, 1, this.f15539b, false);
        e1.b.c0(parcel, 2, this.f15541d, i7, false);
        e1.b.F(parcel, 3, v0());
        e1.b.k(parcel, 4, y(), false);
        e1.b.F(parcel, 1000, this.f15538a);
        e1.b.b(parcel, iA);
        if ((i7 & 1) != 0) {
            close();
        }
    }

    @c1.a
    @m0
    public String x0(@m0 String str, int i7, int i8) {
        Y0(str, i7);
        return this.f15541d[i8].getString(i7, this.f15540c.getInt(str));
    }

    @o0
    @c1.a
    public Bundle y() {
        return this.f15543f;
    }

    @SafeParcelable.b
    DataHolder(@SafeParcelable.e(id = 1000) int i7, @SafeParcelable.e(id = 1) String[] strArr, @SafeParcelable.e(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.e(id = 3) int i8, @o0 @SafeParcelable.e(id = 4) Bundle bundle) {
        this.f15546i = false;
        this.f15547j = true;
        this.f15538a = i7;
        this.f15539b = strArr;
        this.f15541d = cursorWindowArr;
        this.f15542e = i8;
        this.f15543f = bundle;
    }

    @c1.a
    public DataHolder(@m0 Cursor cursor, int i7, @o0 Bundle bundle) {
        int startPosition;
        f1.a aVar = new f1.a(cursor);
        String[] columnNames = aVar.getColumnNames();
        ArrayList arrayList = new ArrayList();
        try {
            int count = aVar.getCount();
            CursorWindow window = aVar.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                startPosition = 0;
            } else {
                window.acquireReference();
                aVar.b(null);
                arrayList.add(window);
                startPosition = window.getNumRows();
            }
            while (startPosition < count && aVar.moveToPosition(startPosition)) {
                CursorWindow window2 = aVar.getWindow();
                if (window2 != null) {
                    window2.acquireReference();
                    aVar.b(null);
                } else {
                    window2 = new CursorWindow(false);
                    window2.setStartPosition(startPosition);
                    aVar.fillWindow(startPosition, window2);
                }
                if (window2.getNumRows() == 0) {
                    break;
                }
                arrayList.add(window2);
                startPosition = window2.getStartPosition() + window2.getNumRows();
            }
            aVar.close();
            this(columnNames, (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]), i7, bundle);
        } catch (Throwable th) {
            aVar.close();
            throw th;
        }
    }

    private DataHolder(a aVar, int i7, @o0 Bundle bundle) {
        this(aVar.f15548a, a1(aVar, -1), i7, (Bundle) null);
    }

    @c1.a
    public DataHolder(@m0 String[] strArr, @m0 CursorWindow[] cursorWindowArr, int i7, @o0 Bundle bundle) {
        this.f15546i = false;
        this.f15547j = true;
        this.f15538a = 1;
        this.f15539b = (String[]) u.k(strArr);
        this.f15541d = (CursorWindow[]) u.k(cursorWindowArr);
        this.f15542e = i7;
        this.f15543f = bundle;
        V0();
    }
}
