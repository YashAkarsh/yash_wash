package com.alipay.security.mobile.module.d;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f13917a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f13918b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f13919c = "";

    public static synchronized void a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        d(arrayList);
    }

    public static synchronized void b(String str, String str2, String str3) {
        f13917a = str;
        f13918b = str2;
        f13919c = str3;
    }

    public static synchronized void c(Throwable th) {
        String string;
        ArrayList arrayList = new ArrayList();
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            string = stringWriter.toString();
        } else {
            string = "";
        }
        arrayList.add(string);
        d(arrayList);
    }

    private static synchronized void d(List<String> list) {
        if (!o0.a.d(f13918b) && !o0.a.d(f13919c)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(f13919c);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(", " + it.next());
            }
            stringBuffer.append("\n");
            try {
                File file = new File(f13917a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(f13917a, f13918b);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                fileWriter.write(stringBuffer.toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception unused) {
            }
        }
    }
}
