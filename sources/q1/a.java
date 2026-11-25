package q1;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.view.d;
import c.b1;
import c.f;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f40115a = {R.attr.theme, com.google.android.material.R.attr.theme};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f40116b = {com.google.android.material.R.attr.materialThemeOverlay};

    private a() {
    }

    @b1
    private static int a(@m0 Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f40115a);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    @b1
    private static int b(@m0 Context context, @o0 AttributeSet attributeSet, @f int i7, @b1 int i8) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f40116b, i7, i8);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    @m0
    public static Context c(@m0 Context context, @o0 AttributeSet attributeSet, @f int i7, @b1 int i8) {
        int iB = b(context, attributeSet, i7, i8);
        boolean z7 = (context instanceof d) && ((d) context).c() == iB;
        if (iB == 0 || z7) {
            return context;
        }
        d dVar = new d(context, iB);
        int iA = a(context, attributeSet);
        if (iA != 0) {
            dVar.getTheme().applyStyle(iA, true);
        }
        return dVar;
    }
}
