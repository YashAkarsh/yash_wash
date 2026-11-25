package androidx.test.runner.screenshot;

import android.graphics.Bitmap;
import androidx.test.annotation.Beta;
import androidx.test.internal.util.Checks;
import c.m0;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Beta
public final class ScreenCapture {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Bitmap.CompressFormat f10523f = Bitmap.CompressFormat.PNG;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f10524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ScreenCaptureProcessor f10525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Bitmap.CompressFormat f10527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set<ScreenCaptureProcessor> f10528e;

    ScreenCapture(Bitmap bitmap) {
        this.f10525b = new BasicScreenCaptureProcessor();
        this.f10528e = new HashSet();
        this.f10524a = bitmap;
        this.f10527d = f10523f;
    }

    public Bitmap a() {
        return this.f10524a;
    }

    public Bitmap.CompressFormat b() {
        return this.f10527d;
    }

    public String c() {
        return this.f10526c;
    }

    Set<ScreenCaptureProcessor> d() {
        return this.f10528e;
    }

    public void e() throws IOException {
        f(this.f10528e);
    }

    public boolean equals(Object obj) {
        boolean zSameAs;
        boolean zEquals;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ScreenCapture)) {
            return false;
        }
        ScreenCapture screenCapture = (ScreenCapture) obj;
        if (this.f10524a == null) {
            zSameAs = screenCapture.a() == null;
        } else {
            zSameAs = a().sameAs(screenCapture.a());
        }
        String str = this.f10526c;
        if (str == null) {
            zEquals = screenCapture.c() == null;
        } else {
            zEquals = str.equals(screenCapture.c());
        }
        Bitmap.CompressFormat compressFormat = this.f10527d;
        if (compressFormat == null) {
            zEquals2 = screenCapture.b() == null;
        } else {
            zEquals2 = compressFormat.equals(screenCapture.b());
        }
        return zSameAs && zEquals && zEquals2 && this.f10528e.containsAll(screenCapture.d()) && screenCapture.d().containsAll(this.f10528e);
    }

    public void f(@m0 Set<ScreenCaptureProcessor> processorSet) throws IOException {
        Checks.f(processorSet);
        if (processorSet.isEmpty()) {
            this.f10525b.a(this);
            return;
        }
        Iterator<ScreenCaptureProcessor> it = processorSet.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public ScreenCapture g(Bitmap.CompressFormat format) {
        this.f10527d = format;
        return this;
    }

    public ScreenCapture h(String filename) {
        this.f10526c = filename;
        return this;
    }

    public int hashCode() {
        Bitmap bitmap = this.f10524a;
        int iHashCode = bitmap != null ? 37 + bitmap.hashCode() : 1;
        Bitmap.CompressFormat compressFormat = this.f10527d;
        if (compressFormat != null) {
            iHashCode = (iHashCode * 37) + compressFormat.hashCode();
        }
        String str = this.f10526c;
        if (str != null) {
            iHashCode = (iHashCode * 37) + str.hashCode();
        }
        return !this.f10528e.isEmpty() ? (iHashCode * 37) + this.f10528e.hashCode() : iHashCode;
    }

    ScreenCapture i(@m0 Set<ScreenCaptureProcessor> processorSet) {
        this.f10528e = (Set) Checks.f(processorSet);
        return this;
    }

    ScreenCapture(Bitmap bitmap, ScreenCaptureProcessor defaultProcessor) {
        this.f10525b = new BasicScreenCaptureProcessor();
        this.f10528e = new HashSet();
        this.f10524a = bitmap;
        this.f10527d = f10523f;
        this.f10525b = defaultProcessor;
    }
}
