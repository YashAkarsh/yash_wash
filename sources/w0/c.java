package w0;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40491a = "UTF-8";

    void a(MessageDigest messageDigest) throws UnsupportedEncodingException;

    boolean equals(Object obj);

    int hashCode();
}
