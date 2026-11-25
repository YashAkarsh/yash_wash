package com.haier.library.common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    public static FileOutputStream a(File file, boolean z7) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canWrite()) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        }
        return new FileOutputStream(file, z7);
    }

    public static String b(File file, Charset charset) {
        try {
            FileInputStream fileInputStreamG = g(file);
            try {
                String strC = t.c(fileInputStreamG, charset);
                if (fileInputStreamG != null) {
                    fileInputStreamG.close();
                }
                return strC;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (fileInputStreamG != null) {
                        try {
                            fileInputStreamG.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e8) {
            e3.a.g("Read file to string error", e8);
            return null;
        }
    }

    public static void c(File file, String str, Charset charset) throws IOException {
        d(file, str, charset, false);
    }

    public static void d(File file, String str, Charset charset, boolean z7) throws IOException {
        FileOutputStream fileOutputStreamA = a(file, z7);
        try {
            t.h(str, fileOutputStreamA, charset);
            if (fileOutputStreamA != null) {
                fileOutputStreamA.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (fileOutputStreamA != null) {
                    try {
                        fileOutputStreamA.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static void e(byte[] bArr, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Exception e8) {
            e3.a.g("Write byte array to file error", e8);
        }
    }

    public static byte[] f(File file) {
        if (file == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i7 = fileInputStream.read(bArr, 0, 1024);
                        if (i7 == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            fileInputStream.close();
                            byteArrayOutputStream.close();
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, i7);
                        byteArrayOutputStream.flush();
                        try {
                            throw th;
                        } catch (Throwable th) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th3.addSuppressed(th5);
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th6) {
                throw th6;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    public static FileInputStream g(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }
}
