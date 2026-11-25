package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
class p1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f1954h = "TooltipPopup";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f1955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f1956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextView f1957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f1958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Rect f1959e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f1960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f1961g;

    p1(@c.m0 Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1958d = layoutParams;
        this.f1959e = new Rect();
        this.f1960f = new int[2];
        this.f1961g = new int[2];
        this.f1955a = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1956b = viewInflate;
        this.f1957c = (TextView) viewInflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void a(View view, int i7, int i8, boolean z7, WindowManager.LayoutParams layoutParams) {
        int height;
        int i9;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1955a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i7 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1955a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i8 + dimensionPixelOffset2;
            i9 = i8 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i9 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1955a.getResources().getDimensionPixelOffset(z7 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View viewB = b(view);
        if (viewB == null) {
            Log.e(f1954h, "Cannot find app view");
            return;
        }
        viewB.getWindowVisibleDisplayFrame(this.f1959e);
        Rect rect = this.f1959e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1955a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1959e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewB.getLocationOnScreen(this.f1961g);
        view.getLocationOnScreen(this.f1960f);
        int[] iArr = this.f1960f;
        int i10 = iArr[0];
        int[] iArr2 = this.f1961g;
        int i11 = i10 - iArr2[0];
        iArr[0] = i11;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i11 + i7) - (viewB.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1956b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f1956b.getMeasuredHeight();
        int i12 = this.f1960f[1];
        int i13 = ((i9 + i12) - dimensionPixelOffset3) - measuredHeight;
        int i14 = i12 + height + dimensionPixelOffset3;
        if (z7) {
            if (i13 >= 0) {
                layoutParams.y = i13;
                return;
            } else {
                layoutParams.y = i14;
                return;
            }
        }
        if (measuredHeight + i14 <= this.f1959e.height()) {
            layoutParams.y = i14;
        } else {
            layoutParams.y = i13;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    void c() {
        if (d()) {
            ((WindowManager) this.f1955a.getSystemService("window")).removeView(this.f1956b);
        }
    }

    boolean d() {
        return this.f1956b.getParent() != null;
    }

    void e(View view, int i7, int i8, boolean z7, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1957c.setText(charSequence);
        a(view, i7, i8, z7, this.f1958d);
        ((WindowManager) this.f1955a.getSystemService("window")).addView(this.f1956b, this.f1958d);
    }
}
