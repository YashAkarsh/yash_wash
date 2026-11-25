package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.a2;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class f0 implements a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7042a = "ReceiveContent";

    @t0(16)
    private static final class a {
        private a() {
        }

        static CharSequence a(@m0 Context context, @m0 ClipData.Item item, int i7) {
            if ((i7 & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            CharSequence charSequenceCoerceToText = item.coerceToText(context);
            return charSequenceCoerceToText instanceof Spanned ? charSequenceCoerceToText.toString() : charSequenceCoerceToText;
        }
    }

    private static final class b {
        private b() {
        }

        static CharSequence a(@m0 Context context, @m0 ClipData.Item item, int i7) {
            CharSequence charSequenceCoerceToText = item.coerceToText(context);
            return ((i7 & 1) == 0 || !(charSequenceCoerceToText instanceof Spanned)) ? charSequenceCoerceToText : charSequenceCoerceToText.toString();
        }
    }

    private static CharSequence b(@m0 Context context, @m0 ClipData.Item item, int i7) {
        return a.a(context, item, i7);
    }

    private static void c(@m0 Editable editable, @m0 CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int iMax = Math.max(0, Math.min(selectionStart, selectionEnd));
        int iMax2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, iMax2);
        editable.replace(iMax, iMax2, charSequence);
    }

    @Override // androidx.core.view.a2
    @o0
    public androidx.core.view.k a(@m0 View view, @m0 androidx.core.view.k kVar) {
        if (Log.isLoggable(f7042a, 3)) {
            Log.d(f7042a, "onReceive: " + kVar);
        }
        if (kVar.g() == 2) {
            return kVar;
        }
        ClipData clipDataC = kVar.c();
        int iE = kVar.e();
        TextView textView = (TextView) view;
        Editable editable = (Editable) textView.getText();
        Context context = textView.getContext();
        boolean z7 = false;
        for (int i7 = 0; i7 < clipDataC.getItemCount(); i7++) {
            CharSequence charSequenceB = b(context, clipDataC.getItemAt(i7), iE);
            if (charSequenceB != null) {
                if (z7) {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), charSequenceB);
                } else {
                    c(editable, charSequenceB);
                    z7 = true;
                }
            }
        }
        return null;
    }
}
