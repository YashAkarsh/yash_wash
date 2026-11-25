package org.chromium.net;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class u implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet<String> f39524a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet<String> f39525b = new HashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashSet<String> f39526c = new HashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MimeTypeMap f39527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f39528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f39529f;

    public u(@c.m0 List<String> list, boolean z7) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String lowerCase = it.next().trim().toLowerCase(Locale.US);
            if (lowerCase.startsWith(com.alibaba.android.arouter.utils.b.f12515h)) {
                this.f39524a.add(lowerCase.substring(1));
            } else if (lowerCase.equals("*/*")) {
                this.f39528e = true;
            } else if (lowerCase.endsWith("/*")) {
                this.f39526c.add(lowerCase.substring(0, lowerCase.length() - 2));
            } else if (lowerCase.contains("/")) {
                this.f39525b.add(lowerCase);
            }
        }
        this.f39527d = MimeTypeMap.getSingleton();
        this.f39529f = z7;
    }

    @c.m0
    private static String b(@c.m0 String str) {
        return str.split("/", 2)[0];
    }

    private String c(@c.m0 String str) {
        String mimeTypeFromExtension = this.f39527d.getMimeTypeFromExtension(str);
        if (mimeTypeFromExtension != null) {
            return mimeTypeFromExtension.toLowerCase(Locale.US);
        }
        return null;
    }

    public boolean a(Uri uri, String str) {
        if (uri != null) {
            String lowerCase = MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase(Locale.US);
            if (this.f39524a.contains(lowerCase)) {
                return true;
            }
            if (str == null) {
                str = c(lowerCase);
            }
        }
        if (str != null) {
            return this.f39528e || this.f39525b.contains(str) || this.f39526c.contains(b(str));
        }
        return false;
    }

    @Override // java.io.FileFilter
    public boolean accept(@c.m0 File file) {
        return file.isDirectory() ? this.f39529f : a(Uri.fromFile(file), null);
    }
}
