package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.g0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.l2;
import kotlin.text.b0;
import kotlin.text.c0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
class q extends p {

    static final class a extends n0 implements i5.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f34792a = new a();

        a() {
            super(2);
        }

        @Override // i5.p
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void a0(@a7.d File file, @a7.d IOException exception) throws IOException {
            l0.p(file, "<anonymous parameter 0>");
            l0.p(exception, "exception");
            throw exception;
        }
    }

    static final class b extends n0 implements i5.p<File, IOException, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<File, IOException, u> f34793a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(i5.p<? super File, ? super IOException, ? extends u> pVar) {
            super(2);
            this.f34793a = pVar;
        }

        @Override // i5.p
        public /* bridge */ /* synthetic */ l2 a0(File file, IOException iOException) throws x {
            b(file, iOException);
            return l2.f34958a;
        }

        public final void b(@a7.d File f8, @a7.d IOException e8) throws x {
            l0.p(f8, "f");
            l0.p(e8, "e");
            if (this.f34793a.a0(f8, e8) == u.TERMINATE) {
                throw new x(f8);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0099  */
    public static final boolean N(@a7.d File file, @a7.d File target, boolean z7, @a7.d i5.p<? super File, ? super IOException, ? extends u> onError) {
        boolean z8;
        l0.p(file, "<this>");
        l0.p(target, "target");
        l0.p(onError, "onError");
        if (!file.exists()) {
            return onError.a0(file, new t(file, null, "The source file doesn't exist.", 2, null)) != u.TERMINATE;
        }
        try {
            for (File file2 : p.M(file).k(new b(onError))) {
                if (file2.exists()) {
                    File file3 = new File(target, n0(file2, file));
                    if (file3.exists() && (!file2.isDirectory() || !file3.isDirectory())) {
                        if (!z7) {
                            z8 = true;
                        } else if (file3.isDirectory()) {
                            if (V(file3)) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                        } else if (file3.delete()) {
                            z8 = false;
                        } else {
                            z8 = true;
                        }
                        if (z8) {
                            if (onError.a0(file3, new h(file2, file3, "The destination file already exists.")) == u.TERMINATE) {
                                return false;
                            }
                        }
                    }
                    if (file2.isDirectory()) {
                        file3.mkdirs();
                    } else if (Q(file2, file3, z7, 0, 4, null).length() != file2.length() && onError.a0(file2, new IOException("Source file wasn't copied completely, length of destination file differs.")) == u.TERMINATE) {
                        return false;
                    }
                } else if (onError.a0(file2, new t(file2, null, "The source file doesn't exist.", 2, null)) == u.TERMINATE) {
                    return false;
                }
            }
            return true;
        } catch (x unused) {
            return false;
        }
    }

    public static /* synthetic */ boolean O(File file, File file2, boolean z7, i5.p pVar, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        if ((i7 & 4) != 0) {
            pVar = a.f34792a;
        }
        return N(file, file2, z7, pVar);
    }

    @a7.d
    public static final File P(@a7.d File file, @a7.d File target, boolean z7, int i7) throws j {
        l0.p(file, "<this>");
        l0.p(target, "target");
        if (!file.exists()) {
            throw new t(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z7) {
                throw new h(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new h(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    kotlin.io.b.k(fileInputStream, fileOutputStream, i7);
                    c.a(fileOutputStream, null);
                    c.a(fileInputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        c.a(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    c.a(fileInputStream, th3);
                    throw th4;
                }
            }
        } else if (!target.mkdirs()) {
            throw new j(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File Q(File file, File file2, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 8192;
        }
        return P(file, file2, z7, i7);
    }

    @a7.d
    @kotlin.k(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File R(@a7.d String prefix, @a7.e String str, @a7.e File file) throws IOException {
        l0.p(prefix, "prefix");
        File dir = File.createTempFile(prefix, str, file);
        dir.delete();
        if (dir.mkdir()) {
            l0.o(dir, "dir");
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public static /* synthetic */ File S(String str, String str2, File file, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = "tmp";
        }
        if ((i7 & 2) != 0) {
            str2 = null;
        }
        if ((i7 & 4) != 0) {
            file = null;
        }
        return R(str, str2, file);
    }

    @a7.d
    @kotlin.k(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File T(@a7.d String prefix, @a7.e String str, @a7.e File file) throws IOException {
        l0.p(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        l0.o(fileCreateTempFile, "createTempFile(prefix, suffix, directory)");
        return fileCreateTempFile;
    }

    public static /* synthetic */ File U(String str, String str2, File file, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = "tmp";
        }
        if ((i7 & 2) != 0) {
            str2 = null;
        }
        if ((i7 & 4) != 0) {
            file = null;
        }
        return T(str, str2, file);
    }

    public static final boolean V(@a7.d File file) {
        l0.p(file, "<this>");
        while (true) {
            boolean z7 = true;
            for (File file2 : p.L(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z7) {
                    }
                }
                z7 = false;
            }
            return z7;
        }
    }

    public static final boolean W(@a7.d File file, @a7.d File other) {
        l0.p(file, "<this>");
        l0.p(other, "other");
        i iVarF = n.f(file);
        i iVarF2 = n.f(other);
        if (iVarF2.i()) {
            return l0.g(file, other);
        }
        int iH = iVarF.h() - iVarF2.h();
        if (iH < 0) {
            return false;
        }
        return iVarF.g().subList(iH, iVarF.h()).equals(iVarF2.g());
    }

    public static final boolean X(@a7.d File file, @a7.d String other) {
        l0.p(file, "<this>");
        l0.p(other, "other");
        return W(file, new File(other));
    }

    @a7.d
    public static final String Y(@a7.d File file) {
        l0.p(file, "<this>");
        String name = file.getName();
        l0.o(name, "name");
        return c0.q5(name, ClassUtils.PACKAGE_SEPARATOR_CHAR, "");
    }

    @a7.d
    public static final String Z(@a7.d File file) {
        l0.p(file, "<this>");
        if (File.separatorChar != '/') {
            String path = file.getPath();
            l0.o(path, "path");
            return b0.j2(path, File.separatorChar, '/', false, 4, null);
        }
        String path2 = file.getPath();
        l0.o(path2, "path");
        return path2;
    }

    @a7.d
    public static final String a0(@a7.d File file) {
        l0.p(file, "<this>");
        String name = file.getName();
        l0.o(name, "name");
        return c0.B5(name, com.alibaba.android.arouter.utils.b.f12515h, null, 2, null);
    }

    @a7.d
    public static final File b0(@a7.d File file) {
        l0.p(file, "<this>");
        i iVarF = n.f(file);
        File fileE = iVarF.e();
        List<File> listC0 = c0(iVarF.g());
        String separator = File.separator;
        l0.o(separator, "separator");
        return i0(fileE, g0.h3(listC0, separator, null, null, 0, null, null, 62, null));
    }

    private static final List<File> c0(List<? extends File> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (!l0.g(name, com.alibaba.android.arouter.utils.b.f12515h)) {
                if (!l0.g(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || l0.g(((File) g0.k3(arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    private static final i d0(i iVar) {
        return new i(iVar.e(), c0(iVar.g()));
    }

    @a7.d
    public static final File e0(@a7.d File file, @a7.d File base) {
        l0.p(file, "<this>");
        l0.p(base, "base");
        return new File(n0(file, base));
    }

    @a7.e
    public static final File f0(@a7.d File file, @a7.d File base) {
        l0.p(file, "<this>");
        l0.p(base, "base");
        String strO0 = o0(file, base);
        if (strO0 != null) {
            return new File(strO0);
        }
        return null;
    }

    @a7.d
    public static final File g0(@a7.d File file, @a7.d File base) {
        l0.p(file, "<this>");
        l0.p(base, "base");
        String strO0 = o0(file, base);
        return strO0 != null ? new File(strO0) : file;
    }

    @a7.d
    public static final File h0(@a7.d File file, @a7.d File relative) {
        l0.p(file, "<this>");
        l0.p(relative, "relative");
        if (n.d(relative)) {
            return relative;
        }
        String string = file.toString();
        l0.o(string, "this.toString()");
        if ((string.length() == 0) || c0.a3(string, File.separatorChar, false, 2, null)) {
            return new File(string + relative);
        }
        return new File(string + File.separatorChar + relative);
    }

    @a7.d
    public static final File i0(@a7.d File file, @a7.d String relative) {
        l0.p(file, "<this>");
        l0.p(relative, "relative");
        return h0(file, new File(relative));
    }

    @a7.d
    public static final File j0(@a7.d File file, @a7.d File relative) {
        l0.p(file, "<this>");
        l0.p(relative, "relative");
        i iVarF = n.f(file);
        return h0(h0(iVarF.e(), iVarF.h() == 0 ? new File("..") : iVarF.j(0, iVarF.h() - 1)), relative);
    }

    @a7.d
    public static final File k0(@a7.d File file, @a7.d String relative) {
        l0.p(file, "<this>");
        l0.p(relative, "relative");
        return j0(file, new File(relative));
    }

    public static final boolean l0(@a7.d File file, @a7.d File other) {
        l0.p(file, "<this>");
        l0.p(other, "other");
        i iVarF = n.f(file);
        i iVarF2 = n.f(other);
        if (l0.g(iVarF.e(), iVarF2.e()) && iVarF.h() >= iVarF2.h()) {
            return iVarF.g().subList(0, iVarF2.h()).equals(iVarF2.g());
        }
        return false;
    }

    public static final boolean m0(@a7.d File file, @a7.d String other) {
        l0.p(file, "<this>");
        l0.p(other, "other");
        return l0(file, new File(other));
    }

    @a7.d
    public static final String n0(@a7.d File file, @a7.d File base) {
        l0.p(file, "<this>");
        l0.p(base, "base");
        String strO0 = o0(file, base);
        if (strO0 != null) {
            return strO0;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    private static final String o0(File file, File file2) {
        i iVarD0 = d0(n.f(file));
        i iVarD1 = d0(n.f(file2));
        if (!l0.g(iVarD0.e(), iVarD1.e())) {
            return null;
        }
        int iH = iVarD1.h();
        int iH2 = iVarD0.h();
        int iMin = Math.min(iH2, iH);
        int i7 = 0;
        while (i7 < iMin && l0.g(iVarD0.g().get(i7), iVarD1.g().get(i7))) {
            i7++;
        }
        StringBuilder sb = new StringBuilder();
        int i8 = iH - 1;
        if (i7 <= i8) {
            while (!l0.g(iVarD1.g().get(i8).getName(), "..")) {
                sb.append("..");
                if (i8 != i7) {
                    sb.append(File.separatorChar);
                }
                if (i8 != i7) {
                    i8--;
                }
            }
            return null;
        }
        if (i7 < iH2) {
            if (i7 < iH) {
                sb.append(File.separatorChar);
            }
            List listX1 = g0.X1(iVarD0.g(), i7);
            String separator = File.separator;
            l0.o(separator, "separator");
            g0.f3(listX1, sb, separator, null, null, 0, null, null, 124, null);
        }
        return sb.toString();
    }
}
