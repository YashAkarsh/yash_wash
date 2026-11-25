package h4;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public a(int i7, int i8, byte[] bArr) {
        try {
            new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e8) {
            e8.printStackTrace();
        }
        k4.b.p("Length: " + i7 + " Type : " + i8 + " Data : " + m4.a.a(bArr));
    }

    public static List<a> a(byte[] bArr) {
        byte b8;
        ArrayList arrayList = new ArrayList();
        int i7 = 0;
        while (i7 < bArr.length) {
            int i8 = i7 + 1;
            byte b9 = bArr[i7];
            if (b9 == 0 || (b8 = bArr[i8]) == 0) {
                break;
            }
            int i9 = i8 + 1;
            int i10 = i8 + b9;
            arrayList.add(new a(b9, b8, Arrays.copyOfRange(bArr, i9, i10)));
            i7 = i10;
        }
        return arrayList;
    }
}
