package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public final class l2 {
    public static final float a(@a7.d PointF pointF) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        return pointF.x;
    }

    public static final int b(@a7.d Point point) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        return point.x;
    }

    public static final float c(@a7.d PointF pointF) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        return pointF.y;
    }

    public static final int d(@a7.d Point point) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        return point.y;
    }

    @a7.d
    public static final Point e(@a7.d Point point, int i7) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        int i8 = -i7;
        point2.offset(i8, i8);
        return point2;
    }

    @a7.d
    public static final Point f(@a7.d Point point, @a7.d Point p7) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(-p7.x, -p7.y);
        return point2;
    }

    @a7.d
    public static final PointF g(@a7.d PointF pointF, float f8) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        float f9 = -f8;
        pointF2.offset(f9, f9);
        return pointF2;
    }

    @a7.d
    public static final PointF h(@a7.d PointF pointF, @a7.d PointF p7) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(-p7.x, -p7.y);
        return pointF2;
    }

    @a7.d
    public static final Point i(@a7.d Point point, int i7) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        Point point2 = new Point(point.x, point.y);
        point2.offset(i7, i7);
        return point2;
    }

    @a7.d
    public static final Point j(@a7.d Point point, @a7.d Point p7) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        Point point2 = new Point(point.x, point.y);
        point2.offset(p7.x, p7.y);
        return point2;
    }

    @a7.d
    public static final PointF k(@a7.d PointF pointF, float f8) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(f8, f8);
        return pointF2;
    }

    @a7.d
    public static final PointF l(@a7.d PointF pointF, @a7.d PointF p7) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        pointF2.offset(p7.x, p7.y);
        return pointF2;
    }

    @a7.d
    public static final Point m(@a7.d PointF pointF) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        return new Point((int) pointF.x, (int) pointF.y);
    }

    @a7.d
    public static final PointF n(@a7.d Point point) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        return new PointF(point);
    }

    @a7.d
    public static final Point o(@a7.d Point point) {
        kotlin.jvm.internal.l0.p(point, "<this>");
        return new Point(-point.x, -point.y);
    }

    @a7.d
    public static final PointF p(@a7.d PointF pointF) {
        kotlin.jvm.internal.l0.p(pointF, "<this>");
        return new PointF(-pointF.x, -pointF.y);
    }
}
