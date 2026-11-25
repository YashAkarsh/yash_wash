package androidx.databinding.adapters;

import androidx.cardview.widget.CardView;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@androidx.databinding.h({@androidx.databinding.g(attribute = "cardCornerRadius", method = "setRadius", type = CardView.class), @androidx.databinding.g(attribute = "cardMaxElevation", method = "setMaxCardElevation", type = CardView.class), @androidx.databinding.g(attribute = "cardPreventCornerOverlap", method = "setPreventCornerOverlap", type = CardView.class), @androidx.databinding.g(attribute = "cardUseCompatPadding", method = "setUseCompatPadding", type = CardView.class)})
public class h {
    @androidx.databinding.d({"contentPadding"})
    public static void a(CardView cardView, int i7) {
        cardView.setContentPadding(i7, i7, i7, i7);
    }

    @androidx.databinding.d({"contentPaddingBottom"})
    public static void b(CardView cardView, int i7) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), i7);
    }

    @androidx.databinding.d({"contentPaddingLeft"})
    public static void c(CardView cardView, int i7) {
        cardView.setContentPadding(i7, cardView.getContentPaddingTop(), cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }

    @androidx.databinding.d({"contentPaddingRight"})
    public static void d(CardView cardView, int i7) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), cardView.getContentPaddingTop(), i7, cardView.getContentPaddingBottom());
    }

    @androidx.databinding.d({"contentPaddingTop"})
    public static void e(CardView cardView, int i7) {
        cardView.setContentPadding(cardView.getContentPaddingLeft(), i7, cardView.getContentPaddingRight(), cardView.getContentPaddingBottom());
    }
}
