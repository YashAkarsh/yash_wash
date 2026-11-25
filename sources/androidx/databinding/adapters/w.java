package androidx.databinding.adapters;

import android.widget.RatingBar;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@androidx.databinding.o({@androidx.databinding.n(attribute = "android:rating", type = RatingBar.class)})
@x0({x0.a.LIBRARY})
public class w {

    static class a implements RatingBar.OnRatingBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RatingBar.OnRatingBarChangeListener f7262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.databinding.m f7263b;

        a(RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, androidx.databinding.m mVar) {
            this.f7262a = onRatingBarChangeListener;
            this.f7263b = mVar;
        }

        @Override // android.widget.RatingBar.OnRatingBarChangeListener
        public void onRatingChanged(RatingBar ratingBar, float f8, boolean z7) {
            RatingBar.OnRatingBarChangeListener onRatingBarChangeListener = this.f7262a;
            if (onRatingBarChangeListener != null) {
                onRatingBarChangeListener.onRatingChanged(ratingBar, f8, z7);
            }
            this.f7263b.a();
        }
    }

    @androidx.databinding.d(requireAll = false, value = {"android:onRatingChanged", "android:ratingAttrChanged"})
    public static void a(RatingBar ratingBar, RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, androidx.databinding.m mVar) {
        if (mVar == null) {
            ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
        } else {
            ratingBar.setOnRatingBarChangeListener(new a(onRatingBarChangeListener, mVar));
        }
    }

    @androidx.databinding.d({"android:rating"})
    public static void b(RatingBar ratingBar, float f8) {
        if (ratingBar.getRating() != f8) {
            ratingBar.setRating(f8);
        }
    }
}
