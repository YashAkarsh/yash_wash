package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class y {
    @SuppressLint({"ApplySharedPref"})
    public static final void a(@a7.d SharedPreferences sharedPreferences, boolean z7, @a7.d i5.l<? super SharedPreferences.Editor, l2> action) {
        l0.p(sharedPreferences, "<this>");
        l0.p(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        l0.o(editor, "editor");
        action.z(editor);
        if (z7) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void b(SharedPreferences sharedPreferences, boolean z7, i5.l action, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        l0.p(sharedPreferences, "<this>");
        l0.p(action, "action");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        l0.o(editor, "editor");
        action.z(editor);
        if (z7) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
