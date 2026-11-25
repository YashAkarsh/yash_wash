package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f247d = "Rating";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f248e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f249f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f250g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f251h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f252i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f253j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f254k = 6;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float f255l = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f258c;

    static class a implements Parcelable.Creator<RatingCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RatingCompat[] newArray(int i7) {
            return new RatingCompat[i7];
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    RatingCompat(int i7, float f8) {
        this.f256a = i7;
        this.f257b = f8;
    }

    public static RatingCompat a(Object obj) {
        RatingCompat ratingCompatO = null;
        if (obj != null) {
            Rating rating = (Rating) obj;
            int ratingStyle = rating.getRatingStyle();
            if (rating.isRated()) {
                switch (ratingStyle) {
                    case 1:
                        ratingCompatO = j(rating.hasHeart());
                        break;
                    case 2:
                        ratingCompatO = n(rating.isThumbUp());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        ratingCompatO = l(ratingStyle, rating.getStarRating());
                        break;
                    case 6:
                        ratingCompatO = k(rating.getPercentRating());
                        break;
                    default:
                        return null;
                }
            } else {
                ratingCompatO = o(ratingStyle);
            }
            ratingCompatO.f258c = obj;
        }
        return ratingCompatO;
    }

    public static RatingCompat j(boolean z7) {
        return new RatingCompat(1, z7 ? 1.0f : 0.0f);
    }

    public static RatingCompat k(float f8) {
        if (f8 >= 0.0f && f8 <= 100.0f) {
            return new RatingCompat(6, f8);
        }
        Log.e(f247d, "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat l(int i7, float f8) {
        float f9;
        if (i7 == 3) {
            f9 = 3.0f;
        } else if (i7 == 4) {
            f9 = 4.0f;
        } else {
            if (i7 != 5) {
                Log.e(f247d, "Invalid rating style (" + i7 + ") for a star rating");
                return null;
            }
            f9 = 5.0f;
        }
        if (f8 >= 0.0f && f8 <= f9) {
            return new RatingCompat(i7, f8);
        }
        Log.e(f247d, "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat n(boolean z7) {
        return new RatingCompat(2, z7 ? 1.0f : 0.0f);
    }

    public static RatingCompat o(int i7) {
        switch (i7) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i7, -1.0f);
            default:
                return null;
        }
    }

    public float b() {
        if (this.f256a == 6 && h()) {
            return this.f257b;
        }
        return -1.0f;
    }

    public Object d() {
        if (this.f258c == null) {
            if (h()) {
                int i7 = this.f256a;
                switch (i7) {
                    case 1:
                        this.f258c = Rating.newHeartRating(g());
                        break;
                    case 2:
                        this.f258c = Rating.newThumbRating(i());
                        break;
                    case 3:
                    case 4:
                    case 5:
                        this.f258c = Rating.newStarRating(i7, f());
                        break;
                    case 6:
                        this.f258c = Rating.newPercentageRating(b());
                        break;
                    default:
                        return null;
                }
            } else {
                this.f258c = Rating.newUnratedRating(this.f256a);
            }
        }
        return this.f258c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f256a;
    }

    public int e() {
        return this.f256a;
    }

    public float f() {
        int i7 = this.f256a;
        if ((i7 == 3 || i7 == 4 || i7 == 5) && h()) {
            return this.f257b;
        }
        return -1.0f;
    }

    public boolean g() {
        return this.f256a == 1 && this.f257b == 1.0f;
    }

    public boolean h() {
        return this.f257b >= 0.0f;
    }

    public boolean i() {
        return this.f256a == 2 && this.f257b == 1.0f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f256a);
        sb.append(" rating=");
        float f8 = this.f257b;
        sb.append(f8 < 0.0f ? "unrated" : String.valueOf(f8));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f256a);
        parcel.writeFloat(this.f257b);
    }
}
