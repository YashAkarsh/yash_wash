package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import c.e0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY})
@c.d
final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f7631f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f7632g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f7633h = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final f.l f7634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final p f7635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private f.e f7636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f7637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private final int[] f7638e;

    @t0(19)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f7639a = -1;

        private a() {
        }

        static int a(CharSequence charSequence, int i7, int i8) {
            int length = charSequence.length();
            if (i7 < 0 || length < i7 || i8 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i8 != 0) {
                    i7--;
                    if (i7 < 0) {
                        return z7 ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i7);
                    if (z7) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i8--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i8--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z7 = true;
                    }
                }
                return i7;
            }
        }

        static int b(CharSequence charSequence, int i7, int i8) {
            int length = charSequence.length();
            if (i7 < 0 || length < i7 || i8 < 0) {
                return -1;
            }
            while (true) {
                boolean z7 = false;
                while (i8 != 0) {
                    if (i7 >= length) {
                        if (z7) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i7);
                    if (z7) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i8--;
                        i7++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i8--;
                        i7++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i7++;
                        z7 = true;
                    }
                }
                return i7;
            }
        }
    }

    static final class b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final int f7640i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final int f7641j = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7642a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p.a f7643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private p.a f7644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private p.a f7645d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f7646e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f7647f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f7648g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int[] f7649h;

        b(p.a aVar, boolean z7, int[] iArr) {
            this.f7643b = aVar;
            this.f7644c = aVar;
            this.f7648g = z7;
            this.f7649h = iArr;
        }

        private static boolean d(int i7) {
            return i7 == 65039;
        }

        private static boolean f(int i7) {
            return i7 == 65038;
        }

        private int g() {
            this.f7642a = 1;
            this.f7644c = this.f7643b;
            this.f7647f = 0;
            return 1;
        }

        private boolean h() {
            if (this.f7644c.b().l() || d(this.f7646e)) {
                return true;
            }
            if (this.f7648g) {
                if (this.f7649h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f7649h, this.f7644c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i7) {
            p.a aVarA = this.f7644c.a(i7);
            int iG = 2;
            if (this.f7642a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.f7642a = 2;
                    this.f7644c = aVarA;
                    this.f7647f = 1;
                }
            } else if (aVarA != null) {
                this.f7644c = aVarA;
                this.f7647f++;
            } else if (f(i7)) {
                iG = g();
            } else if (!d(i7)) {
                if (this.f7644c.b() != null) {
                    iG = 3;
                    if (this.f7647f != 1 || h()) {
                        this.f7645d = this.f7644c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.f7646e = i7;
            return iG;
        }

        i b() {
            return this.f7644c.b();
        }

        i c() {
            return this.f7645d.b();
        }

        boolean e() {
            return this.f7642a == 2 && this.f7644c.b() != null && (this.f7647f > 1 || h());
        }
    }

    j(@m0 p pVar, @m0 f.l lVar, @m0 f.e eVar, boolean z7, @o0 int[] iArr) {
        this.f7634a = lVar;
        this.f7635b = pVar;
        this.f7636c = eVar;
        this.f7637d = z7;
        this.f7638e = iArr;
    }

    private void a(@m0 Spannable spannable, i iVar, int i7, int i8) {
        spannable.setSpan(this.f7634a.a(iVar), i7, i8, 33);
    }

    private static boolean b(@m0 Editable editable, @m0 KeyEvent keyEvent, boolean z7) {
        k[] kVarArr;
        if (i(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!h(selectionStart, selectionEnd) && (kVarArr = (k[]) editable.getSpans(selectionStart, selectionEnd, k.class)) != null && kVarArr.length > 0) {
            for (k kVar : kVarArr) {
                int spanStart = editable.getSpanStart(kVar);
                int spanEnd = editable.getSpanEnd(kVar);
                if ((z7 && spanStart == selectionStart) || ((!z7 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean e(@m0 InputConnection inputConnection, @m0 Editable editable, @e0(from = 0) int i7, @e0(from = 0) int i8, boolean z7) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i7 >= 0 && i8 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (h(selectionStart, selectionEnd)) {
                return false;
            }
            if (z7) {
                iMax = a.a(editable, selectionStart, Math.max(i7, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i8, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i7, 0);
                iMin = Math.min(selectionEnd + i8, editable.length());
            }
            k[] kVarArr = (k[]) editable.getSpans(iMax, iMin, k.class);
            if (kVarArr != null && kVarArr.length > 0) {
                for (k kVar : kVarArr) {
                    int spanStart = editable.getSpanStart(kVar);
                    int spanEnd = editable.getSpanEnd(kVar);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean f(@m0 Editable editable, int i7, @m0 KeyEvent keyEvent) {
        boolean zB;
        if (i7 != 67) {
            zB = i7 != 112 ? false : b(editable, keyEvent, true);
        } else {
            zB = b(editable, keyEvent, false);
        }
        if (!zB) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean g(CharSequence charSequence, int i7, int i8, i iVar) {
        if (iVar.e() == 0) {
            iVar.n(this.f7636c.a(charSequence, i7, i8, iVar.i()));
        }
        return iVar.e() == 2;
    }

    private static boolean h(int i7, int i8) {
        return i7 == -1 || i8 == -1 || i7 != i8;
    }

    private static boolean i(@m0 KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    int c(@m0 CharSequence charSequence) {
        return d(charSequence, this.f7635b.h());
    }

    int d(@m0 CharSequence charSequence, int i7) {
        b bVar = new b(this.f7635b.i(), this.f7637d, this.f7638e);
        int length = charSequence.length();
        int iCharCount = 0;
        int i8 = 0;
        int i9 = 0;
        while (iCharCount < length) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            int iA = bVar.a(iCodePointAt);
            i iVarB = bVar.b();
            if (iA == 1) {
                iCharCount += Character.charCount(iCodePointAt);
                i9 = 0;
            } else if (iA == 2) {
                iCharCount += Character.charCount(iCodePointAt);
            } else if (iA == 3) {
                iVarB = bVar.c();
                if (iVarB.d() <= i7) {
                    i8++;
                }
            }
            if (iVarB != null && iVarB.d() <= i7) {
                i9++;
            }
        }
        if (i8 != 0) {
            return 2;
        }
        if (!bVar.e() || bVar.b().d() > i7) {
            return i9 == 0 ? 0 : 2;
        }
        return 1;
    }

    CharSequence j(@m0 CharSequence charSequence, @e0(from = 0) int i7, @e0(from = 0) int i8, @e0(from = 0) int i9, boolean z7) {
        u uVar;
        int iCharCount;
        k[] kVarArr;
        boolean z8 = charSequence instanceof q;
        if (z8) {
            ((q) charSequence).a();
        }
        if (!z8) {
            try {
                uVar = charSequence instanceof Spannable ? new u((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i7 + (-1), i8 + 1, k.class) > i8) ? null : new u(charSequence);
            } finally {
                if (z8) {
                    ((q) charSequence).d();
                }
            }
        }
        if (uVar != null && (kVarArr = (k[]) uVar.getSpans(i7, i8, k.class)) != null && kVarArr.length > 0) {
            for (k kVar : kVarArr) {
                int spanStart = uVar.getSpanStart(kVar);
                int spanEnd = uVar.getSpanEnd(kVar);
                if (spanStart != i8) {
                    uVar.removeSpan(kVar);
                }
                i7 = Math.min(spanStart, i7);
                i8 = Math.max(spanEnd, i8);
            }
        }
        if (i7 != i8 && i7 < charSequence.length()) {
            if (i9 != Integer.MAX_VALUE && uVar != null) {
                i9 -= ((k[]) uVar.getSpans(0, uVar.length(), k.class)).length;
            }
            b bVar = new b(this.f7635b.i(), this.f7637d, this.f7638e);
            int iCodePointAt = Character.codePointAt(charSequence, i7);
            int i10 = 0;
            u uVar2 = uVar;
            loop1: while (true) {
                iCharCount = i7;
                while (true) {
                    if (i7 >= i8 || i10 >= i9) {
                        break loop1;
                    }
                    int iA = bVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i8) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i7 = iCharCount;
                    } else if (iA == 2) {
                        i7 += Character.charCount(iCodePointAt);
                        if (i7 < i8) {
                            iCodePointAt = Character.codePointAt(charSequence, i7);
                        }
                    } else if (iA != 3) {
                    }
                }
                if (z7 || !g(charSequence, iCharCount, i7, bVar.c())) {
                    if (uVar2 == null) {
                        uVar2 = new u((Spannable) new SpannableString(charSequence));
                    }
                    a(uVar2, bVar.c(), iCharCount, i7);
                    i10++;
                }
            }
            if (bVar.e() && i10 < i9 && (z7 || !g(charSequence, iCharCount, i7, bVar.b()))) {
                if (uVar2 == null) {
                    uVar2 = new u(charSequence);
                }
                a(uVar2, bVar.b(), iCharCount, i7);
            }
            return uVar2 != null ? uVar2.b() : charSequence;
        }
        return charSequence;
    }
}
