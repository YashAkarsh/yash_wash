package f1;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class a extends CursorWrapper implements CrossProcessCursor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractWindowedCursor f33888a;

    @c1.a
    public a(@m0 Cursor cursor) {
        super(cursor);
        for (int i7 = 0; i7 < 10 && (cursor instanceof CursorWrapper); i7++) {
            cursor = ((CursorWrapper) cursor).getWrappedCursor();
        }
        if (!(cursor instanceof AbstractWindowedCursor)) {
            String name = cursor.getClass().getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unknown type: ".concat(name) : new String("Unknown type: "));
        }
        this.f33888a = (AbstractWindowedCursor) cursor;
    }

    @c1.a
    public void b(@o0 CursorWindow cursorWindow) {
        this.f33888a.setWindow(cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @c1.a
    public void fillWindow(int i7, @m0 CursorWindow cursorWindow) {
        this.f33888a.fillWindow(i7, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @o0
    @c1.a
    public CursorWindow getWindow() {
        return this.f33888a.getWindow();
    }

    @Override // android.database.CursorWrapper
    @m0
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.f33888a;
    }

    @Override // android.database.CrossProcessCursor
    public final boolean onMove(int i7, int i8) {
        return this.f33888a.onMove(i7, i8);
    }
}
