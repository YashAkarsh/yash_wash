package com.google.auto.service.processor;

import com.google.common.base.f;
import com.google.common.io.s;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f19283a = "META-INF/services";

    private d() {
    }

    static String a(String str) {
        return "META-INF/services/" + str;
    }

    static Set<String> b(InputStream inputStream) throws Throwable {
        HashSet hashSet = new HashSet();
        s sVarB = s.b();
        try {
            BufferedReader bufferedReader = (BufferedReader) sVarB.c(new BufferedReader(new InputStreamReader(inputStream, f.f19383c)));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    sVarB.close();
                    return hashSet;
                }
                int iIndexOf = line.indexOf(35);
                if (iIndexOf >= 0) {
                    line = line.substring(0, iIndexOf);
                }
                String strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    hashSet.add(strTrim);
                }
            }
        } catch (Throwable th) {
            try {
                throw sVarB.e(th);
            } catch (Throwable th2) {
                sVarB.close();
                throw th2;
            }
        }
    }

    static void c(Collection<String> collection, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, f.f19383c));
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            bufferedWriter.write(it.next());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
