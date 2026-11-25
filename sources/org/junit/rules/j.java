package org.junit.rules;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class j extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f39935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f39936b;

    public j() {
        this(null);
    }

    private File f(File file) throws IOException {
        File fileCreateTempFile = File.createTempFile("junit", "", file);
        fileCreateTempFile.delete();
        fileCreateTempFile.mkdir();
        return fileCreateTempFile;
    }

    private boolean i(int i7, String[] strArr) {
        return i7 == strArr.length - 1;
    }

    private void o(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                o(file2);
            }
        }
        file.delete();
    }

    private void p(String str) throws IOException {
        if (new File(str).getParent() != null) {
            throw new IOException("Folder name cannot consist of multiple path components separated by a file separator. Please use newFolder('MyParentFolder','MyFolder') to create hierarchies of folders");
        }
    }

    @Override // org.junit.rules.e
    protected void b() {
        g();
    }

    @Override // org.junit.rules.e
    protected void c() throws Throwable {
        e();
    }

    public void e() throws IOException {
        this.f39936b = f(this.f39935a);
    }

    public void g() {
        File file = this.f39936b;
        if (file != null) {
            o(file);
        }
    }

    public File h() {
        File file = this.f39936b;
        if (file != null) {
            return file;
        }
        throw new IllegalStateException("the temporary folder has not yet been created");
    }

    public File j() throws IOException {
        return File.createTempFile("junit", null, h());
    }

    public File k(String str) throws IOException {
        File file = new File(h(), str);
        if (file.createNewFile()) {
            return file;
        }
        throw new IOException("a file with the name '" + str + "' already exists in the test folder");
    }

    public File l() throws IOException {
        return f(h());
    }

    public File m(String str) throws IOException {
        return n(str);
    }

    public File n(String... strArr) throws IOException {
        File fileH = h();
        int i7 = 0;
        while (i7 < strArr.length) {
            String str = strArr[i7];
            p(str);
            File file = new File(fileH, str);
            if (!file.mkdir() && i(i7, strArr)) {
                throw new IOException("a folder with the name '" + str + "' already exists");
            }
            i7++;
            fileH = file;
        }
        return fileH;
    }

    public j(File file) {
        this.f39935a = file;
    }
}
