package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@c.t0(29)
@c.x0({c.x0.a.LIBRARY_GROUP})
public class y3 extends z3 {
    private Font k(@c.m0 FontFamily fontFamily, int i7) {
        p3.a();
        FontStyle fontStyleA = o3.a((i7 & 1) != 0 ? androidx.constraintlayout.core.motion.utils.w.h.f3152j : 400, (i7 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iL = l(fontStyleA, font.getStyle());
        for (int i8 = 1; i8 < fontFamily.getSize(); i8++) {
            Font font2 = fontFamily.getFont(i8);
            int iL2 = l(fontStyleA, font2.getStyle());
            if (iL2 < iL) {
                font = font2;
                iL = iL2;
            }
        }
        return font;
    }

    private static int l(@c.m0 FontStyle fontStyle, @c.m0 FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // androidx.core.graphics.z3
    @c.o0
    public Typeface b(Context context, androidx.core.content.res.f.d dVar, Resources resources, int i7) {
        try {
            FontFamily.Builder builderA = null;
            for (androidx.core.content.res.f.e eVar : dVar.a()) {
                try {
                    k3.a();
                    Font fontBuild = h3.a(resources, eVar.b()).setWeight(eVar.e()).setSlant(eVar.f() ? 1 : 0).setTtcIndex(eVar.c()).setFontVariationSettings(eVar.d()).build();
                    if (builderA == null) {
                        l3.a();
                        builderA = i3.a(fontBuild);
                    } else {
                        builderA.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builderA == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builderA.build();
            j3.a();
            return g3.a(fontFamilyBuild).setStyle(k(fontFamilyBuild, i7).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.z3
    @c.o0
    public Typeface c(Context context, @c.o0 CancellationSignal cancellationSignal, @c.m0 androidx.core.provider.j.c[] cVarArr, int i7) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builderA = null;
            for (androidx.core.provider.j.c cVar : cVarArr) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(cVar.d(), "r", cancellationSignal);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                    } else {
                        try {
                            k3.a();
                            Font fontBuild = n3.a(parcelFileDescriptorOpenFileDescriptor).setWeight(cVar.e()).setSlant(cVar.f() ? 1 : 0).setTtcIndex(cVar.c()).build();
                            if (builderA == null) {
                                l3.a();
                                builderA = i3.a(fontBuild);
                            } else {
                                builderA.addFont(fontBuild);
                            }
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            if (builderA == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builderA.build();
            j3.a();
            return g3.a(fontFamilyBuild).setStyle(k(fontFamilyBuild, i7).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.z3
    protected Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.z3
    @c.o0
    public Typeface e(Context context, Resources resources, int i7, String str, int i8) {
        try {
            k3.a();
            Font fontBuild = h3.a(resources, i7).build();
            l3.a();
            FontFamily fontFamilyBuild = i3.a(fontBuild).build();
            j3.a();
            return g3.a(fontFamilyBuild).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.z3
    protected androidx.core.provider.j.c h(androidx.core.provider.j.c[] cVarArr, int i7) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
