package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private TextView f1967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private TextClassifier f1968b;

    @c.t0(26)
    private static final class a {
        private a() {
        }

        @c.m0
        @c.t
        static TextClassifier a(@c.m0 TextView textView) {
            TextClassificationManager textClassificationManagerA = p.a(textView.getContext().getSystemService(TextClassificationManager.class));
            return textClassificationManagerA != null ? textClassificationManagerA.getTextClassifier() : TextClassifier.NO_OP;
        }
    }

    s(@c.m0 TextView textView) {
        this.f1967a = (TextView) androidx.core.util.w.l(textView);
    }

    @c.t0(api = 26)
    @c.m0
    public TextClassifier a() {
        TextClassifier textClassifier = this.f1968b;
        return textClassifier == null ? a.a(this.f1967a) : textClassifier;
    }

    @c.t0(api = 26)
    public void b(@c.o0 TextClassifier textClassifier) {
        this.f1968b = textClassifier;
    }
}
