package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.w;
import c.g1;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6593a = 16777216;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6594b = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f6595c = new String[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f6596d = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f6597e = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f6598f = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f6599g = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f6600h = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g1
    static final int f6601i = 2048;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g1
    static final int f6602j = 1024;

    @t0(30)
    private static class a {
        private a() {
        }

        static CharSequence a(@m0 EditorInfo editorInfo, int i7) {
            return editorInfo.getInitialSelectedText(i7);
        }

        static CharSequence b(@m0 EditorInfo editorInfo, int i7, int i8) {
            return editorInfo.getInitialTextAfterCursor(i7, i8);
        }

        static CharSequence c(@m0 EditorInfo editorInfo, int i7, int i8) {
            return editorInfo.getInitialTextBeforeCursor(i7, i8);
        }

        static void d(@m0 EditorInfo editorInfo, CharSequence charSequence, int i7) {
            editorInfo.setInitialSurroundingSubText(charSequence, i7);
        }
    }

    @Deprecated
    public g() {
    }

    @m0
    public static String[] a(@m0 EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr != null ? strArr : f6595c;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return f6595c;
        }
        String[] stringArray = bundle.getStringArray(f6596d);
        if (stringArray == null) {
            stringArray = editorInfo.extras.getStringArray(f6597e);
        }
        return stringArray != null ? stringArray : f6595c;
    }

    @o0
    public static CharSequence b(@m0 EditorInfo editorInfo, int i7) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.a(editorInfo, i7);
        }
        if (editorInfo.extras == null) {
            return null;
        }
        int iMin = Math.min(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int iMax = Math.max(editorInfo.initialSelStart, editorInfo.initialSelEnd);
        int i8 = editorInfo.extras.getInt(f6599g);
        int i9 = editorInfo.extras.getInt(f6600h);
        int i10 = iMax - iMin;
        if (editorInfo.initialSelStart < 0 || editorInfo.initialSelEnd < 0 || i9 - i8 != i10 || (charSequence = editorInfo.extras.getCharSequence(f6598f)) == null) {
            return null;
        }
        return (i7 & 1) != 0 ? charSequence.subSequence(i8, i9) : TextUtils.substring(charSequence, i8, i9);
    }

    @o0
    public static CharSequence c(@m0 EditorInfo editorInfo, int i7, int i8) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.b(editorInfo, i7, i8);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(f6598f)) == null) {
            return null;
        }
        int i9 = editorInfo.extras.getInt(f6600h);
        int iMin = Math.min(i7, charSequence.length() - i9);
        return (i8 & 1) != 0 ? charSequence.subSequence(i9, iMin + i9) : TextUtils.substring(charSequence, i9, iMin + i9);
    }

    @o0
    public static CharSequence d(@m0 EditorInfo editorInfo, int i7, int i8) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 30) {
            return a.c(editorInfo, i7, i8);
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null || (charSequence = bundle.getCharSequence(f6598f)) == null) {
            return null;
        }
        int i9 = editorInfo.extras.getInt(f6599g);
        int iMin = Math.min(i7, i9);
        return (i8 & 1) != 0 ? charSequence.subSequence(i9 - iMin, i9) : TextUtils.substring(charSequence, i9 - iMin, i9);
    }

    static int e(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        if (bundle == null) {
            return 0;
        }
        boolean zContainsKey = bundle.containsKey(f6596d);
        boolean zContainsKey2 = editorInfo.extras.containsKey(f6597e);
        if (zContainsKey && zContainsKey2) {
            return 4;
        }
        if (zContainsKey) {
            return 3;
        }
        return zContainsKey2 ? 2 : 0;
    }

    private static boolean f(CharSequence charSequence, int i7, int i8) {
        if (i8 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i7));
        }
        if (i8 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i7));
    }

    private static boolean g(int i7) {
        int i8 = i7 & 4095;
        return i8 == 129 || i8 == 225 || i8 == 18;
    }

    public static void h(@m0 EditorInfo editorInfo, @o0 String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray(f6596d, strArr);
        editorInfo.extras.putStringArray(f6597e, strArr);
    }

    public static void i(@m0 EditorInfo editorInfo, @m0 CharSequence charSequence, int i7) {
        w.l(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            a.d(editorInfo, charSequence, i7);
            return;
        }
        int i8 = editorInfo.initialSelStart;
        int i9 = editorInfo.initialSelEnd;
        int i10 = i8 > i9 ? i9 - i7 : i8 - i7;
        int i11 = i8 > i9 ? i8 - i7 : i9 - i7;
        int length = charSequence.length();
        if (i7 < 0 || i10 < 0 || i11 > length) {
            k(editorInfo, null, 0, 0);
            return;
        }
        if (g(editorInfo.inputType)) {
            k(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            k(editorInfo, charSequence, i10, i11);
        } else {
            l(editorInfo, charSequence, i10, i11);
        }
    }

    public static void j(@m0 EditorInfo editorInfo, @m0 CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            a.d(editorInfo, charSequence, 0);
        } else {
            i(editorInfo, charSequence, 0);
        }
    }

    private static void k(EditorInfo editorInfo, CharSequence charSequence, int i7, int i8) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence(f6598f, charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt(f6599g, i7);
        editorInfo.extras.putInt(f6600h, i8);
    }

    private static void l(EditorInfo editorInfo, CharSequence charSequence, int i7, int i8) {
        int i9 = i8 - i7;
        int i10 = i9 > 1024 ? 0 : i9;
        int i11 = 2048 - i10;
        int iMin = Math.min(charSequence.length() - i8, i11 - Math.min(i7, (int) (((double) i11) * 0.8d)));
        int iMin2 = Math.min(i7, i11 - iMin);
        int i12 = i7 - iMin2;
        if (f(charSequence, i12, 0)) {
            i12++;
            iMin2--;
        }
        if (f(charSequence, (i8 + iMin) - 1, 1)) {
            iMin--;
        }
        CharSequence charSequenceConcat = i10 != i9 ? TextUtils.concat(charSequence.subSequence(i12, i12 + iMin2), charSequence.subSequence(i8, iMin + i8)) : charSequence.subSequence(i12, iMin2 + i10 + iMin + i12);
        int i13 = iMin2 + 0;
        k(editorInfo, charSequenceConcat, i13, i10 + i13);
    }
}
