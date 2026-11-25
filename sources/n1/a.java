package n1;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.v1;
import c.l;
import c.m0;
import com.google.android.material.R;
import com.google.android.material.internal.v;
import com.google.android.material.resources.b;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f37473e = 4.5f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f37474f = 2.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f37475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f37477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f37478d;

    public a(@m0 Context context) {
        this.f37475a = b.b(context, R.attr.elevationOverlayEnabled, false);
        this.f37476b = k1.a.b(context, R.attr.elevationOverlayColor, 0);
        this.f37477c = k1.a.b(context, R.attr.colorSurface, 0);
        this.f37478d = context.getResources().getDisplayMetrics().density;
    }

    private boolean m(@l int i7) {
        return v1.B(i7, 255) == this.f37477c;
    }

    public int a(float f8) {
        return Math.round(b(f8) * 255.0f);
    }

    public float b(float f8) {
        float f9 = this.f37478d;
        if (f9 <= 0.0f || f8 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f8 / f9)) * f37473e) + f37474f) / 100.0f, 1.0f);
    }

    @l
    public int c(@l int i7, float f8) {
        float fB = b(f8);
        return v1.B(k1.a.h(v1.B(i7, 255), this.f37476b, fB), Color.alpha(i7));
    }

    @l
    public int d(@l int i7, float f8, @m0 View view) {
        return c(i7, f8 + i(view));
    }

    @l
    public int e(@l int i7, float f8) {
        return (this.f37475a && m(i7)) ? c(i7, f8) : i7;
    }

    @l
    public int f(@l int i7, float f8, @m0 View view) {
        return e(i7, f8 + i(view));
    }

    @l
    public int g(float f8) {
        return e(this.f37477c, f8);
    }

    @l
    public int h(float f8, @m0 View view) {
        return g(f8 + i(view));
    }

    public float i(@m0 View view) {
        return v.i(view);
    }

    @l
    public int j() {
        return this.f37476b;
    }

    @l
    public int k() {
        return this.f37477c;
    }

    public boolean l() {
        return this.f37475a;
    }
}
