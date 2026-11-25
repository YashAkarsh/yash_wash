package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;

/* JADX INFO: loaded from: classes.dex */
public final class n2 {
    @a7.d
    public static final Rect A(@a7.d Rect rect, int i7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.top *= i7;
        rect2.left *= i7;
        rect2.right *= i7;
        rect2.bottom *= i7;
        return rect2;
    }

    @a7.d
    public static final RectF B(@a7.d RectF rectF, float f8) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f8;
        rectF2.left *= f8;
        rectF2.right *= f8;
        rectF2.bottom *= f8;
        return rectF2;
    }

    @a7.d
    public static final RectF C(@a7.d RectF rectF, int i7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        float f8 = i7;
        RectF rectF2 = new RectF(rectF);
        rectF2.top *= f8;
        rectF2.left *= f8;
        rectF2.right *= f8;
        rectF2.bottom *= f8;
        return rectF2;
    }

    @a7.d
    public static final Rect D(@a7.d RectF rectF) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    @a7.d
    public static final RectF E(@a7.d Rect rect) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        return new RectF(rect);
    }

    @a7.d
    public static final Region F(@a7.d Rect rect) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        return new Region(rect);
    }

    @a7.d
    public static final Region G(@a7.d RectF rectF) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return new Region(rect);
    }

    @a7.d
    public static final RectF H(@a7.d RectF rectF, @a7.d Matrix m7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(m7, "m");
        m7.mapRect(rectF);
        return rectF;
    }

    @a7.d
    public static final Region I(@a7.d Rect rect, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region = new Region(rect);
        region.op(r7, Region.Op.XOR);
        return region;
    }

    @a7.d
    public static final Region J(@a7.d RectF rectF, @a7.d RectF r7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r7.roundOut(rect2);
        region.op(rect2, Region.Op.XOR);
        return region;
    }

    @a7.d
    @SuppressLint({"CheckResult"})
    public static final Rect a(@a7.d Rect rect, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Rect rect2 = new Rect(rect);
        rect2.intersect(r7);
        return rect2;
    }

    @a7.d
    @SuppressLint({"CheckResult"})
    public static final RectF b(@a7.d RectF rectF, @a7.d RectF r7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.intersect(r7);
        return rectF2;
    }

    public static final float c(@a7.d RectF rectF) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        return rectF.left;
    }

    public static final int d(@a7.d Rect rect) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        return rect.left;
    }

    public static final float e(@a7.d RectF rectF) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        return rectF.top;
    }

    public static final int f(@a7.d Rect rect) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        return rect.top;
    }

    public static final float g(@a7.d RectF rectF) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        return rectF.right;
    }

    public static final int h(@a7.d Rect rect) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        return rect.right;
    }

    public static final float i(@a7.d RectF rectF) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        return rectF.bottom;
    }

    public static final int j(@a7.d Rect rect) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        return rect.bottom;
    }

    public static final boolean k(@a7.d Rect rect, @a7.d Point p7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        return rect.contains(p7.x, p7.y);
    }

    public static final boolean l(@a7.d RectF rectF, @a7.d PointF p7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        return rectF.contains(p7.x, p7.y);
    }

    @a7.d
    public static final Rect m(@a7.d Rect rect, int i7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        int i8 = -i7;
        rect2.offset(i8, i8);
        return rect2;
    }

    @a7.d
    public static final Rect n(@a7.d Rect rect, @a7.d Point xy) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(-xy.x, -xy.y);
        return rect2;
    }

    @a7.d
    public static final RectF o(@a7.d RectF rectF, float f8) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        float f9 = -f8;
        rectF2.offset(f9, f9);
        return rectF2;
    }

    @a7.d
    public static final RectF p(@a7.d RectF rectF, @a7.d PointF xy) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(-xy.x, -xy.y);
        return rectF2;
    }

    @a7.d
    public static final Region q(@a7.d Rect rect, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region = new Region(rect);
        region.op(r7, Region.Op.DIFFERENCE);
        return region;
    }

    @a7.d
    public static final Region r(@a7.d RectF rectF, @a7.d RectF r7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        Region region = new Region(rect);
        Rect rect2 = new Rect();
        r7.roundOut(rect2);
        region.op(rect2, Region.Op.DIFFERENCE);
        return region;
    }

    @a7.d
    public static final Rect s(@a7.d Rect rect, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r7);
        return rect2;
    }

    @a7.d
    public static final RectF t(@a7.d RectF rectF, @a7.d RectF r7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r7);
        return rectF2;
    }

    @a7.d
    public static final Rect u(@a7.d Rect rect, int i7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        Rect rect2 = new Rect(rect);
        rect2.offset(i7, i7);
        return rect2;
    }

    @a7.d
    public static final Rect v(@a7.d Rect rect, @a7.d Point xy) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(xy, "xy");
        Rect rect2 = new Rect(rect);
        rect2.offset(xy.x, xy.y);
        return rect2;
    }

    @a7.d
    public static final Rect w(@a7.d Rect rect, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(rect, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Rect rect2 = new Rect(rect);
        rect2.union(r7);
        return rect2;
    }

    @a7.d
    public static final RectF x(@a7.d RectF rectF, float f8) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(f8, f8);
        return rectF2;
    }

    @a7.d
    public static final RectF y(@a7.d RectF rectF, @a7.d PointF xy) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(xy, "xy");
        RectF rectF2 = new RectF(rectF);
        rectF2.offset(xy.x, xy.y);
        return rectF2;
    }

    @a7.d
    public static final RectF z(@a7.d RectF rectF, @a7.d RectF r7) {
        kotlin.jvm.internal.l0.p(rectF, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        RectF rectF2 = new RectF(rectF);
        rectF2.union(r7);
        return rectF2;
    }
}
