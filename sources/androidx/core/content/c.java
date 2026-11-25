package androidx.core.content;

import android.content.ContentValues;
import kotlin.jvm.internal.l0;
import kotlin.text.h0;
import kotlin.u0;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    @a7.d
    public static final ContentValues a(@a7.d u0<String, ? extends Object>... pairs) {
        l0.p(pairs, "pairs");
        ContentValues contentValues = new ContentValues(pairs.length);
        for (u0<String, ? extends Object> u0Var : pairs) {
            String strA = u0Var.a();
            Object objB = u0Var.b();
            if (objB == null) {
                contentValues.putNull(strA);
            } else if (objB instanceof String) {
                contentValues.put(strA, (String) objB);
            } else if (objB instanceof Integer) {
                contentValues.put(strA, (Integer) objB);
            } else if (objB instanceof Long) {
                contentValues.put(strA, (Long) objB);
            } else if (objB instanceof Boolean) {
                contentValues.put(strA, (Boolean) objB);
            } else if (objB instanceof Float) {
                contentValues.put(strA, (Float) objB);
            } else if (objB instanceof Double) {
                contentValues.put(strA, (Double) objB);
            } else if (objB instanceof byte[]) {
                contentValues.put(strA, (byte[]) objB);
            } else if (objB instanceof Byte) {
                contentValues.put(strA, (Byte) objB);
            } else {
                if (!(objB instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + strA + h0.f35376b);
                }
                contentValues.put(strA, (Short) objB);
            }
        }
        return contentValues;
    }
}
