package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.l;
import c.a1;
import c.m0;
import c.o0;
import c.x0;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
abstract class a implements NavController.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Integer> f8939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private final WeakReference<androidx.customview.widget.c> f8940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private androidx.appcompat.graphics.drawable.d f8941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ValueAnimator f8942e;

    a(@m0 Context context, @m0 c cVar) {
        this.f8938a = context;
        this.f8939b = cVar.d();
        androidx.customview.widget.c cVarC = cVar.c();
        if (cVarC != null) {
            this.f8940c = new WeakReference<>(cVarC);
        } else {
            this.f8940c = null;
        }
    }

    private void b(boolean z7) {
        boolean z8;
        if (this.f8941d == null) {
            this.f8941d = new androidx.appcompat.graphics.drawable.d(this.f8938a);
            z8 = false;
        } else {
            z8 = true;
        }
        c(this.f8941d, z7 ? R.string.nav_app_bar_open_drawer_description : R.string.nav_app_bar_navigate_up_description);
        float f8 = z7 ? 0.0f : 1.0f;
        if (!z8) {
            this.f8941d.setProgress(f8);
            return;
        }
        float fI = this.f8941d.i();
        ValueAnimator valueAnimator = this.f8942e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f8941d, "progress", fI, f8);
        this.f8942e = objectAnimatorOfFloat;
        objectAnimatorOfFloat.start();
    }

    @Override // androidx.navigation.NavController.b
    public void a(@m0 NavController navController, @m0 l lVar, @o0 Bundle bundle) {
        if (lVar instanceof androidx.navigation.c) {
            return;
        }
        WeakReference<androidx.customview.widget.c> weakReference = this.f8940c;
        androidx.customview.widget.c cVar = weakReference != null ? weakReference.get() : null;
        if (this.f8940c != null && cVar == null) {
            navController.L(this);
            return;
        }
        CharSequence charSequenceN = lVar.n();
        if (charSequenceN != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequenceN);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (bundle == null || !bundle.containsKey(strGroup)) {
                    throw new IllegalArgumentException("Could not find " + strGroup + " in " + bundle + " to fill label " + ((Object) charSequenceN));
                }
                matcher.appendReplacement(stringBuffer, "");
                stringBuffer.append(bundle.get(strGroup).toString());
            }
            matcher.appendTail(stringBuffer);
            d(stringBuffer);
        }
        boolean zD = e.d(lVar, this.f8939b);
        if (cVar == null && zD) {
            c(null, 0);
        } else {
            b(cVar != null && zD);
        }
    }

    protected abstract void c(Drawable drawable, @a1 int i7);

    protected abstract void d(CharSequence charSequence);
}
