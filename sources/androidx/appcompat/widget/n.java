package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1919a = "ReceiveContent";

    @c.t0(24)
    private static final class a {
        private a() {
        }

        @c.t
        static boolean a(@c.m0 DragEvent dragEvent, @c.m0 TextView textView, @c.m0 Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
                n2.m1(textView, new androidx.core.view.k.b(dragEvent.getClipData(), 3).a());
                return true;
            } finally {
                textView.endBatchEdit();
            }
        }

        @c.t
        static boolean b(@c.m0 DragEvent dragEvent, @c.m0 View view, @c.m0 Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            n2.m1(view, new androidx.core.view.k.b(dragEvent.getClipData(), 3).a());
            return true;
        }
    }

    private n() {
    }

    static boolean a(@c.m0 View view, @c.m0 DragEvent dragEvent) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 31 && i7 >= 24 && dragEvent.getLocalState() == null && n2.h0(view) != null) {
            Activity activityC = c(view);
            if (activityC == null) {
                Log.i(f1919a, "Can't handle drop: no activity: view=" + view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof TextView ? a.a(dragEvent, (TextView) view, activityC) : a.b(dragEvent, view, activityC);
            }
        }
        return false;
    }

    static boolean b(@c.m0 TextView textView, int i7) {
        if (Build.VERSION.SDK_INT >= 31 || n2.h0(textView) == null || !(i7 == 16908322 || i7 == 16908337)) {
            return false;
        }
        ClipboardManager clipboardManager = (ClipboardManager) textView.getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            n2.m1(textView, new androidx.core.view.k.b(primaryClip, 1).d(i7 != 16908322 ? 1 : 0).a());
        }
        return true;
    }

    @c.o0
    static Activity c(@c.m0 View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }
}
