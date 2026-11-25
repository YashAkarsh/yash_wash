package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.z;
import kotlin.jvm.internal.l0;
import kotlin.text.c0;

/* JADX INFO: loaded from: classes2.dex */
class n {
    @a7.d
    public static final File a(@a7.d File file) {
        l0.p(file, "<this>");
        return new File(c(file));
    }

    private static final int b(String str) {
        int iQ3;
        int iQ4 = c0.q3(str, File.separatorChar, 0, false, 4, null);
        if (iQ4 != 0) {
            if (iQ4 > 0 && str.charAt(iQ4 - 1) == ':') {
                return iQ4 + 1;
            }
            if (iQ4 == -1 && c0.a3(str, ':', false, 2, null)) {
                return str.length();
            }
            return 0;
        }
        if (str.length() > 1) {
            char cCharAt = str.charAt(1);
            char c8 = File.separatorChar;
            if (cCharAt == c8 && (iQ3 = c0.q3(str, c8, 2, false, 4, null)) >= 0) {
                int iQ5 = c0.q3(str, File.separatorChar, iQ3 + 1, false, 4, null);
                return iQ5 >= 0 ? iQ5 + 1 : str.length();
            }
        }
        return 1;
    }

    @a7.d
    public static final String c(@a7.d File file) {
        l0.p(file, "<this>");
        String path = file.getPath();
        l0.o(path, "path");
        String path2 = file.getPath();
        l0.o(path2, "path");
        String strSubstring = path.substring(0, b(path2));
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean d(@a7.d File file) {
        l0.p(file, "<this>");
        String path = file.getPath();
        l0.o(path, "path");
        return b(path) > 0;
    }

    @a7.d
    public static final File e(@a7.d File file, int i7, int i8) {
        l0.p(file, "<this>");
        return f(file).j(i7, i8);
    }

    @a7.d
    public static final i f(@a7.d File file) {
        List listF;
        l0.p(file, "<this>");
        String path = file.getPath();
        l0.o(path, "path");
        int iB = b(path);
        String strSubstring = path.substring(0, iB);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = path.substring(iB);
        l0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
        if (strSubstring2.length() == 0) {
            listF = kotlin.collections.y.F();
        } else {
            List listS4 = c0.S4(strSubstring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(z.Z(listS4, 10));
            Iterator it = listS4.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            listF = arrayList;
        }
        return new i(new File(strSubstring), listF);
    }
}
