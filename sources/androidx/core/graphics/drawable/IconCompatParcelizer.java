package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.e eVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f5800a = eVar.M(iconCompat.f5800a, 1);
        iconCompat.f5802c = eVar.t(iconCompat.f5802c, 2);
        iconCompat.f5803d = eVar.W(iconCompat.f5803d, 3);
        iconCompat.f5804e = eVar.M(iconCompat.f5804e, 4);
        iconCompat.f5805f = eVar.M(iconCompat.f5805f, 5);
        iconCompat.f5806g = (ColorStateList) eVar.W(iconCompat.f5806g, 6);
        iconCompat.f5808i = eVar.d0(iconCompat.f5808i, 7);
        iconCompat.f5809j = eVar.d0(iconCompat.f5809j, 8);
        iconCompat.g();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.e eVar) {
        eVar.j0(true, true);
        iconCompat.h(eVar.i());
        int i7 = iconCompat.f5800a;
        if (-1 != i7) {
            eVar.M0(i7, 1);
        }
        byte[] bArr = iconCompat.f5802c;
        if (bArr != null) {
            eVar.u0(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f5803d;
        if (parcelable != null) {
            eVar.X0(parcelable, 3);
        }
        int i8 = iconCompat.f5804e;
        if (i8 != 0) {
            eVar.M0(i8, 4);
        }
        int i9 = iconCompat.f5805f;
        if (i9 != 0) {
            eVar.M0(i9, 5);
        }
        ColorStateList colorStateList = iconCompat.f5806g;
        if (colorStateList != null) {
            eVar.X0(colorStateList, 6);
        }
        String str = iconCompat.f5808i;
        if (str != null) {
            eVar.f1(str, 7);
        }
        String str2 = iconCompat.f5809j;
        if (str2 != null) {
            eVar.f1(str2, 8);
        }
    }
}
