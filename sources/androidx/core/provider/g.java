package androidx.core.provider;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import c.g1;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<byte[]> f6128a = new Comparator() { // from class: androidx.core.provider.f
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return g.g((byte[]) obj, (byte[]) obj2);
        }
    };

    @t0(16)
    static class a {
        private a() {
        }

        @t
        static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    private g() {
    }

    private static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!Arrays.equals(list.get(i7), list2.get(i7))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> d(h hVar, Resources resources) {
        return hVar.b() != null ? hVar.b() : androidx.core.content.res.f.c(resources, hVar.c());
    }

    @m0
    static j.b e(@m0 Context context, @m0 h hVar, @o0 CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoF = f(context.getPackageManager(), hVar, context.getResources());
        return providerInfoF == null ? j.b.a(1, null) : j.b.a(0, h(context, hVar, providerInfoF.authority, cancellationSignal));
    }

    @o0
    @g1
    static ProviderInfo f(@m0 PackageManager packageManager, @m0 h hVar, @o0 Resources resources) throws PackageManager.NameNotFoundException {
        String strF = hVar.f();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strF, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strF);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(hVar.g())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strF + ", but package was not " + hVar.g());
        }
        List<byte[]> listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listB, f6128a);
        List<List<byte[]>> listD = d(hVar, resources);
        for (int i7 = 0; i7 < listD.size(); i7++) {
            ArrayList arrayList = new ArrayList(listD.get(i7));
            Collections.sort(arrayList, f6128a);
            if (c(listB, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i7 = 0; i7 < bArr.length; i7++) {
            byte b8 = bArr[i7];
            byte b9 = bArr2[i7];
            if (b8 != b9) {
                return b8 - b9;
            }
        }
        return 0;
    }

    @m0
    @g1
    static j.c[] h(Context context, h hVar, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursorA = null;
        try {
            int i7 = 0;
            cursorA = a.a(context.getContentResolver(), uriBuild, new String[]{com.haier.globalwasher.modle.sqlitedatabase.a.f24533k, j.a.f6154a, j.a.f6155b, j.a.f6156c, j.a.f6157d, j.a.f6158e, j.a.f6159f}, "query = ?", new String[]{hVar.h()}, null, cancellationSignal);
            if (cursorA != null && cursorA.getCount() > 0) {
                int columnIndex = cursorA.getColumnIndex(j.a.f6159f);
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorA.getColumnIndex(com.haier.globalwasher.modle.sqlitedatabase.a.f24533k);
                int columnIndex3 = cursorA.getColumnIndex(j.a.f6154a);
                int columnIndex4 = cursorA.getColumnIndex(j.a.f6155b);
                int columnIndex5 = cursorA.getColumnIndex(j.a.f6157d);
                int columnIndex6 = cursorA.getColumnIndex(j.a.f6158e);
                while (cursorA.moveToNext()) {
                    int i8 = columnIndex != -1 ? cursorA.getInt(columnIndex) : i7;
                    arrayList2.add(j.c.a(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorA.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorA.getLong(columnIndex3)), columnIndex4 != -1 ? cursorA.getInt(columnIndex4) : i7, columnIndex5 != -1 ? cursorA.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorA.getInt(columnIndex6) == 1, i8));
                    i7 = 0;
                }
                arrayList = arrayList2;
            }
            return (j.c[]) arrayList.toArray(new j.c[0]);
        } finally {
            if (cursorA != null) {
                cursorA.close();
            }
        }
    }
}
