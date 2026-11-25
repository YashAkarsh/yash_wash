package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
class q<T> extends Property<T, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Property<T, PointF> f10762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathMeasure f10763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f10764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f10765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PointF f10766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f10767f;

    q(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f10765d = new float[2];
        this.f10766e = new PointF();
        this.f10762a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f10763b = pathMeasure;
        this.f10764c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t7) {
        return Float.valueOf(this.f10767f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(T t7, Float f8) {
        this.f10767f = f8.floatValue();
        this.f10763b.getPosTan(this.f10764c * f8.floatValue(), this.f10765d, null);
        PointF pointF = this.f10766e;
        float[] fArr = this.f10765d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f10762a.set(t7, pointF);
    }
}
