package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class u extends t {

    static final class a extends n0 implements i5.l<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f35443a = new a();

        a() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d String line) {
            l0.p(line, "line");
            return line;
        }
    }

    static final class b extends n0 implements i5.l<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35444a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f35444a = str;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d String line) {
            l0.p(line, "line");
            return this.f35444a + line;
        }
    }

    static final class c extends n0 implements i5.l<String, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f35445a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(1);
            this.f35445a = str;
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String z(@a7.d String it) {
            l0.p(it, "it");
            if (b0.U1(it)) {
                return it.length() < this.f35445a.length() ? this.f35445a : it;
            }
            return this.f35445a + it;
        }
    }

    private static final i5.l<String, String> g(String str) {
        return str.length() == 0 ? a.f35443a : new b(str);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    private static final int h(String str) {
        int length = str.length();
        int i7 = 0;
        while (i7 < length) {
            if (!d.r(str.charAt(i7))) {
                if (i7 == -1) {
                    return str.length();
                }
                return i7;
            }
            i7++;
        }
        i7 = -1;
        if (i7 == -1) {
            return str.length();
        }
        return i7;
    }

    @a7.d
    public static final String i(@a7.d String str, @a7.d String indent) {
        l0.p(str, "<this>");
        l0.p(indent, "indent");
        return kotlin.sequences.u.e1(kotlin.sequences.u.k1(c0.K3(str), new c(indent)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    private static final String k(List<String> list, int i7, i5.l<? super String, String> lVar, i5.l<? super String, String> lVar2) {
        String strZ;
        int iH = kotlin.collections.y.H(list);
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : list) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                kotlin.collections.y.X();
            }
            String str = (String) obj;
            if ((i8 == 0 || i8 == iH) && b0.U1(str)) {
                str = null;
            } else {
                String strZ2 = lVar2.z(str);
                if (strZ2 != null && (strZ = lVar.z(strZ2)) != null) {
                    str = strZ;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i8 = i9;
        }
        String string = ((StringBuilder) kotlin.collections.g0.f3(arrayList, new StringBuilder(i7), "\n", null, null, 0, null, null, 124, null)).toString();
        l0.o(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    @a7.d
    public static final String l(@a7.d String str, @a7.d String newIndent) {
        String strZ;
        l0.p(str, "<this>");
        l0.p(newIndent, "newIndent");
        List<String> listL3 = c0.L3(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listL3) {
            if (!b0.U1((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.z.Z(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(h((String) it.next())));
        }
        Integer num = (Integer) kotlin.collections.g0.c4(arrayList2);
        int i7 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listL3.size());
        i5.l<String, String> lVarG = g(newIndent);
        int iH = kotlin.collections.y.H(listL3);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listL3) {
            int i8 = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            String str2 = (String) obj2;
            if ((i7 == 0 || i7 == iH) && b0.U1(str2)) {
                str2 = null;
            } else {
                String strA6 = e0.A6(str2, iIntValue);
                if (strA6 != null && (strZ = lVarG.z(strA6)) != null) {
                    str2 = strZ;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i7 = i8;
        }
        String string = ((StringBuilder) kotlin.collections.g0.f3(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        l0.o(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static /* synthetic */ String m(String str, String str2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str2 = "";
        }
        return l(str, str2);
    }

    @a7.d
    public static final String n(@a7.d String str, @a7.d String newIndent, @a7.d String marginPrefix) {
        int i7;
        String strZ;
        l0.p(str, "<this>");
        l0.p(newIndent, "newIndent");
        l0.p(marginPrefix, "marginPrefix");
        if (!(!b0.U1(marginPrefix))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> listL3 = c0.L3(str);
        int length = str.length() + (newIndent.length() * listL3.size());
        i5.l<String, String> lVarG = g(newIndent);
        int iH = kotlin.collections.y.H(listL3);
        ArrayList arrayList = new ArrayList();
        int i8 = 0;
        for (Object obj : listL3) {
            int i9 = i8 + 1;
            if (i8 < 0) {
                kotlin.collections.y.X();
            }
            String str2 = (String) obj;
            String strSubstring = null;
            if ((i8 == 0 || i8 == iH) && b0.U1(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i10 = 0;
                while (true) {
                    if (i10 >= length2) {
                        i7 = -1;
                        break;
                    }
                    if (!d.r(str2.charAt(i10))) {
                        i7 = i10;
                        break;
                    }
                    i10++;
                }
                if (i7 != -1) {
                    int i11 = i7;
                    if (b0.t2(str2, marginPrefix, i7, false, 4, null)) {
                        int length3 = i11 + marginPrefix.length();
                        l0.n(str2, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str2.substring(length3);
                        l0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (strZ = lVarG.z(strSubstring)) != null) {
                    str2 = strZ;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i8 = i9;
        }
        String string = ((StringBuilder) kotlin.collections.g0.f3(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        l0.o(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static /* synthetic */ String o(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str2 = "";
        }
        if ((i7 & 2) != 0) {
            str3 = "|";
        }
        return n(str, str2, str3);
    }

    @a7.d
    public static String p(@a7.d String str) {
        l0.p(str, "<this>");
        return l(str, "");
    }

    @a7.d
    public static final String q(@a7.d String str, @a7.d String marginPrefix) {
        l0.p(str, "<this>");
        l0.p(marginPrefix, "marginPrefix");
        return n(str, "", marginPrefix);
    }

    public static /* synthetic */ String r(String str, String str2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str2 = "|";
        }
        return q(str, str2);
    }
}
