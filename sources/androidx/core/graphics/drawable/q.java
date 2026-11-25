package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import androidx.core.view.n0;
import c.m0;
import c.o0;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5829a = "RoundedBitmapDrawableFa";

    private static class a extends p {
        a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // androidx.core.graphics.drawable.p
        void f(int i7, int i8, int i9, Rect rect, Rect rect2) {
            n0.b(i7, i8, i9, rect, rect2, 0);
        }

        @Override // androidx.core.graphics.drawable.p
        public boolean h() {
            Bitmap bitmap = this.f5816a;
            return bitmap != null && androidx.core.graphics.a.c(bitmap);
        }

        @Override // androidx.core.graphics.drawable.p
        public void o(boolean z7) {
            Bitmap bitmap = this.f5816a;
            if (bitmap != null) {
                androidx.core.graphics.a.d(bitmap, z7);
                invalidateSelf();
            }
        }
    }

    private q() {
    }

    @m0
    public static p a(@m0 Resources resources, @o0 Bitmap bitmap) {
        return new o(resources, bitmap);
    }

    @m0
    public static p b(@m0 Resources resources, @m0 InputStream inputStream) {
        p pVarA = a(resources, BitmapFactory.decodeStream(inputStream));
        if (pVarA.b() == null) {
            Log.w(f5829a, "RoundedBitmapDrawable cannot decode " + inputStream);
        }
        return pVarA;
    }

    @m0
    public static p c(@m0 Resources resources, @m0 String str) {
        p pVarA = a(resources, BitmapFactory.decodeFile(str));
        if (pVarA.b() == null) {
            Log.w(f5829a, "RoundedBitmapDrawable cannot decode " + str);
        }
        return pVarA;
    }
}
