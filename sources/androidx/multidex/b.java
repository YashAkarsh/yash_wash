package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.util.Log;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f8709a = "MultiDex";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8710b = "secondary-dexes";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8711c = "code_cache";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8712d = "secondary-dexes";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f8713e = 20;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8714f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8715g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8716h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f8717i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Set<File> f8718j = new HashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final boolean f8719k = o(System.getProperty("java.vm.version"));

    private static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f8720b = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC0109a f8721a;

        /* JADX INFO: renamed from: androidx.multidex.b$a$a, reason: collision with other inner class name */
        private interface InterfaceC0109a {
            Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException;
        }

        /* JADX INFO: renamed from: androidx.multidex.b$a$b, reason: collision with other inner class name */
        private static class C0110b implements InterfaceC0109a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Constructor<?> f8722a;

            C0110b(Class<?> cls) throws NoSuchMethodException, SecurityException {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f8722a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.b.a.InterfaceC0109a
            public Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException {
                return this.f8722a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        private static class c implements InterfaceC0109a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Constructor<?> f8723a;

            c(Class<?> cls) throws NoSuchMethodException, SecurityException {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f8723a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.b.a.InterfaceC0109a
            public Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                return this.f8723a.newInstance(file, file, dexFile);
            }
        }

        private static class d implements InterfaceC0109a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Constructor<?> f8724a;

            d(Class<?> cls) throws NoSuchMethodException, SecurityException {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f8724a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.b.a.InterfaceC0109a
            public Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                return this.f8724a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        private a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            InterfaceC0109a dVar;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    dVar = new C0110b(cls);
                } catch (NoSuchMethodException unused) {
                    dVar = new c(cls);
                }
            } catch (NoSuchMethodException unused2) {
                dVar = new d(cls);
            }
            this.f8721a = dVar;
        }

        static void a(ClassLoader classLoader, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            Object obj = b.g(classLoader, "pathList").get(classLoader);
            Object[] objArrB = new a().b(list);
            try {
                b.f(obj, "dexElements", objArrB);
            } catch (NoSuchFieldException e8) {
                Log.w(b.f8709a, "Failed find field 'dexElements' attempting 'pathElements'", e8);
                b.f(obj, "pathElements", objArrB);
            }
        }

        private Object[] b(List<? extends File> list) throws IllegalAccessException, InstantiationException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i7 = 0; i7 < size; i7++) {
                File file = list.get(i7);
                objArr[i7] = this.f8721a.a(file, DexFile.loadDex(file.getPath(), c(file), 0));
            }
            return objArr;
        }

        private static String c(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f8720b) + ".dex").getPath();
        }
    }

    /* JADX INFO: renamed from: androidx.multidex.b$b, reason: collision with other inner class name */
    private static final class C0111b {
        private C0111b() {
        }

        static void a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IOException, IllegalArgumentException, InvocationTargetException {
            IOException[] iOExceptionArr;
            Object obj = b.g(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            b.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w(b.f8709a, "Exception in makeDexElement", (IOException) it.next());
                }
                Field fieldG = b.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) fieldG.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                fieldG.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            return (Object[]) b.h(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }

    private static final class c {
        private c() {
        }

        static void a(ClassLoader classLoader, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
            int size = list.size();
            Field fieldG = b.g(classLoader, "path");
            StringBuilder sb = new StringBuilder((String) fieldG.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb.append(':');
                sb.append(absolutePath);
                int iPreviousIndex = listIterator.previousIndex();
                strArr[iPreviousIndex] = absolutePath;
                fileArr[iPreviousIndex] = next;
                zipFileArr[iPreviousIndex] = new ZipFile(next);
                dexFileArr[iPreviousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            fieldG.set(classLoader, sb.toString());
            b.f(classLoader, "mPaths", strArr);
            b.f(classLoader, "mFiles", fileArr);
            b.f(classLoader, "mZips", zipFileArr);
            b.f(classLoader, "mDexs", dexFileArr);
        }
    }

    private b() {
    }

    private static void d(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i(f8709a, "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                Log.w(f8709a, "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : fileArrListFiles) {
                Log.i(f8709a, "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i(f8709a, "Deleted old file " + file2.getPath());
                } else {
                    Log.w(f8709a, "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                Log.i(f8709a, "Deleted old secondary dex dir " + file.getPath());
                return;
            }
            Log.w(f8709a, "Failed to delete secondary dex dir " + file.getPath());
        }
    }

    private static void e(Context context, File file, File file2, String str, String str2, boolean z7) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Set<File> set = f8718j;
        synchronized (set) {
            if (set.contains(file)) {
                return;
            }
            set.add(file);
            Log.w(f8709a, "MultiDex is not guaranteed to work in SDK version " + Build.VERSION.SDK_INT + ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"" + System.getProperty("java.vm.version") + "\"");
            ClassLoader classLoaderJ = j(context);
            if (classLoaderJ == null) {
                return;
            }
            try {
                d(context);
            } catch (Throwable th) {
                Log.w(f8709a, "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.", th);
            }
            File fileK = k(context, file2, str);
            androidx.multidex.c cVar = new androidx.multidex.c(file, fileK);
            try {
                try {
                    n(classLoaderJ, fileK, cVar.r(context, str2, false));
                } catch (IOException e8) {
                    if (!z7) {
                        throw e8;
                    }
                    Log.w(f8709a, "Failed to install extracted secondary dex files, retrying with forced extraction", e8);
                    n(classLoaderJ, fileK, cVar.r(context, str2, true));
                }
                try {
                    cVar.close();
                    e = null;
                } catch (IOException e9) {
                    e = e9;
                }
                if (e != null) {
                    throw e;
                }
            } catch (Throwable th2) {
                try {
                    cVar.close();
                } catch (IOException unused) {
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field fieldG = g(obj, str);
        Object[] objArr2 = (Object[]) fieldG.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        fieldG.set(obj, objArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field g(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method h(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e8) {
            Log.w(f8709a, "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e8);
            return null;
        }
    }

    private static ClassLoader j(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                return classLoader;
            }
            Log.e(f8709a, "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e8) {
            Log.w(f8709a, "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e8);
            return null;
        }
    }

    private static File k(Context context, File file, String str) throws IOException {
        File file2 = new File(file, f8711c);
        try {
            p(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), f8711c);
            p(file2);
        }
        File file3 = new File(file2, str);
        p(file3);
        return file3;
    }

    public static void l(Context context) {
        Log.i(f8709a, "Installing application");
        if (f8719k) {
            Log.i(f8709a, "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        try {
            ApplicationInfo applicationInfoI = i(context);
            if (applicationInfoI == null) {
                Log.i(f8709a, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
            } else {
                e(context, new File(applicationInfoI.sourceDir), new File(applicationInfoI.dataDir), "secondary-dexes", "", true);
                Log.i(f8709a, "install done");
            }
        } catch (Exception e8) {
            Log.e(f8709a, "MultiDex installation failure", e8);
            throw new RuntimeException("MultiDex installation failed (" + e8.getMessage() + ").");
        }
    }

    public static void m(Context context, Context context2) {
        Log.i(f8709a, "Installing instrumentation");
        if (f8719k) {
            Log.i(f8709a, "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        try {
            ApplicationInfo applicationInfoI = i(context);
            if (applicationInfoI == null) {
                Log.i(f8709a, "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            ApplicationInfo applicationInfoI2 = i(context2);
            if (applicationInfoI2 == null) {
                Log.i(f8709a, "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            String str = context.getPackageName() + com.alibaba.android.arouter.utils.b.f12515h;
            File file = new File(applicationInfoI2.dataDir);
            e(context2, new File(applicationInfoI.sourceDir), file, str + "secondary-dexes", str, false);
            e(context2, new File(applicationInfoI2.sourceDir), file, "secondary-dexes", "", false);
            Log.i(f8709a, "Installation done");
        } catch (Exception e8) {
            Log.e(f8709a, "MultiDex installation failure", e8);
            throw new RuntimeException("MultiDex installation failed (" + e8.getMessage() + ").");
        }
    }

    private static void n(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (list.isEmpty()) {
            return;
        }
        C0111b.a(classLoader, list, file);
    }

    static boolean o(String str) {
        boolean z7 = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, com.alibaba.android.arouter.utils.b.f12515h);
            String strNextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (strNextToken != null && strNextToken2 != null) {
                try {
                    int i7 = Integer.parseInt(strNextToken);
                    int i8 = Integer.parseInt(strNextToken2);
                    if (i7 > 2 || (i7 == 2 && i8 >= 1)) {
                        z7 = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with version ");
        sb.append(str);
        sb.append(z7 ? " has multidex support" : " does not have multidex support");
        Log.i(f8709a, sb.toString());
        return z7;
    }

    private static void p(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.e(f8709a, "Failed to create dir " + file.getPath() + ". Parent file is null.");
        } else {
            Log.e(f8709a, "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }
}
