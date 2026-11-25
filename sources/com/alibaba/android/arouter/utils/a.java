package com.alibaba.android.arouter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f12497a = ".classes";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12498b = ".zip";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12499c = "code_cache" + File.separator + "secondary-dexes";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12500d = "multidex.version";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12501e = "dex.number";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f12502f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f12503g = 1;

    /* JADX INFO: renamed from: com.alibaba.android.arouter.utils.a$a, reason: collision with other inner class name */
    static class RunnableC0147a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12505b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Set f12506c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f12507d;

        RunnableC0147a(String str, String str2, Set set, CountDownLatch countDownLatch) {
            this.f12504a = str;
            this.f12505b = str2;
            this.f12506c = set;
            this.f12507d = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            DexFile dexFile = null;
            try {
                try {
                    if (this.f12504a.endsWith(a.f12498b)) {
                        dexFile = DexFile.loadDex(this.f12504a, this.f12504a + ".tmp", 0);
                    } else {
                        dexFile = new DexFile(this.f12504a);
                    }
                    Enumeration<String> enumerationEntries = dexFile.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        String strNextElement = enumerationEntries.nextElement();
                        if (strNextElement.startsWith(this.f12505b)) {
                            this.f12506c.add(strNextElement);
                        }
                    }
                } catch (Throwable th) {
                    try {
                        Log.e("ARouter", "Scan map file in dex files made error.", th);
                    } finally {
                        if (dexFile != null) {
                            try {
                                dexFile.close();
                            } catch (Throwable unused) {
                            }
                        }
                        this.f12507d.countDown();
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static Set<String> a(Context context, String str) throws InterruptedException, PackageManager.NameNotFoundException, IOException {
        HashSet hashSet = new HashSet();
        List<String> listC = c(context);
        CountDownLatch countDownLatch = new CountDownLatch(listC.size());
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            com.alibaba.android.arouter.thread.b.a().execute(new RunnableC0147a(it.next(), str, hashSet, countDownLatch));
        }
        countDownLatch.await();
        Log.d("ARouter::", "Filter " + hashSet.size() + " classes by packageName <" + str + ">");
        return hashSet;
    }

    private static SharedPreferences b(Context context) {
        return context.getSharedPreferences(f12500d, 4);
    }

    public static List<String> c(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + f12497a;
        if (!d()) {
            int i7 = b(context).getInt(f12501e, 1);
            File file2 = new File(applicationInfo.dataDir, f12499c);
            for (int i8 = 2; i8 <= i7; i8++) {
                File file3 = new File(file2, str + i8 + f12498b);
                if (!file3.isFile()) {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
                arrayList.add(file3.getAbsolutePath());
            }
        }
        if (com.alibaba.android.arouter.launcher.a.f()) {
            arrayList.addAll(f(applicationInfo));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d A[PHI: r1
      0x001d: PHI (r1v9 java.lang.String) = (r1v7 java.lang.String), (r1v7 java.lang.String), (r1v10 java.lang.String) binds: [B:13:0x004a, B:15:0x004e, B:6:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    private static boolean d() {
        boolean z7 = false;
        String str = null;
        try {
            if (e()) {
                str = "'YunOS'";
                if (Integer.valueOf(System.getProperty("ro.build.version.sdk")).intValue() >= 21) {
                    z7 = true;
                }
            } else {
                str = "'Android'";
                String property = System.getProperty("java.vm.version");
                if (property != null) {
                    Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(property);
                    if (matcher.matches()) {
                        int i7 = Integer.parseInt(matcher.group(1));
                        int i8 = Integer.parseInt(matcher.group(2));
                        if (i7 > 2 || (i7 == 2 && i8 >= 1)) {
                            z7 = true;
                        }
                    }
                }
            }
        } catch (NumberFormatException | Exception unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append("VM with name ");
        sb.append(str);
        sb.append(z7 ? " has multidex support" : " does not have multidex support");
        Log.i("ARouter::", sb.toString());
        return z7;
    }

    private static boolean e() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            return (property2 != null && property2.toLowerCase().contains("lemur")) || (property != null && property.trim().length() > 0);
        } catch (Exception unused) {
            return false;
        }
    }

    private static List<String> f(ApplicationInfo applicationInfo) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            arrayList.addAll(Arrays.asList(strArr));
            Log.d("ARouter::", "Found InstantRun support");
        } else {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", String.class).invoke(null, applicationInfo.packageName));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(".dex")) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                    Log.d("ARouter::", "Found InstantRun support");
                }
            } catch (Exception e8) {
                Log.e("ARouter::", "InstantRun support error, " + e8.getMessage());
            }
        }
        return arrayList;
    }
}
