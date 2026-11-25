package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o2 {

    public static final class a implements Iterator<Rect>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final RegionIterator f5852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final Rect f5853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f5854c;

        a(Region region) {
            RegionIterator regionIterator = new RegionIterator(region);
            this.f5852a = regionIterator;
            Rect rect = new Rect();
            this.f5853b = rect;
            this.f5854c = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect next() {
            if (!this.f5854c) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.f5853b);
            this.f5854c = this.f5852a.next(this.f5853b);
            return rect;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5854c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @a7.d
    public static final Region a(@a7.d Region region, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.INTERSECT);
        return region2;
    }

    @a7.d
    public static final Region b(@a7.d Region region, @a7.d Region r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean c(@a7.d Region region, @a7.d Point p7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(p7, "p");
        return region.contains(p7.x, p7.y);
    }

    public static final void d(@a7.d Region region, @a7.d i5.l<? super Rect, kotlin.l2> action) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(action, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                action.z(rect);
            }
        }
    }

    @a7.d
    public static final Iterator<Rect> e(@a7.d Region region) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        return new a(region);
    }

    @a7.d
    public static final Region f(@a7.d Region region, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.DIFFERENCE);
        return region2;
    }

    @a7.d
    public static final Region g(@a7.d Region region, @a7.d Region r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.DIFFERENCE);
        return region2;
    }

    @a7.d
    public static final Region h(@a7.d Region region) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @a7.d
    public static final Region i(@a7.d Region region, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.union(r7);
        return region2;
    }

    @a7.d
    public static final Region j(@a7.d Region region, @a7.d Region r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.UNION);
        return region2;
    }

    @a7.d
    public static final Region k(@a7.d Region region, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.union(r7);
        return region2;
    }

    @a7.d
    public static final Region l(@a7.d Region region, @a7.d Region r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.UNION);
        return region2;
    }

    @a7.d
    public static final Region m(@a7.d Region region) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    @a7.d
    public static final Region n(@a7.d Region region, @a7.d Rect r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.XOR);
        return region2;
    }

    @a7.d
    public static final Region o(@a7.d Region region, @a7.d Region r7) {
        kotlin.jvm.internal.l0.p(region, "<this>");
        kotlin.jvm.internal.l0.p(r7, "r");
        Region region2 = new Region(region);
        region2.op(r7, Region.Op.XOR);
        return region2;
    }
}
