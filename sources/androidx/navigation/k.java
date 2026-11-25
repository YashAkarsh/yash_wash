package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import c.m0;
import c.o0;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f8872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8874c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f8875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f8876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f8877c;

        private a() {
        }

        @m0
        public static a b(@m0 String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
            }
            a aVar = new a();
            aVar.e(str);
            return aVar;
        }

        @m0
        public static a c(@m0 String str) {
            a aVar = new a();
            aVar.f(str);
            return aVar;
        }

        @m0
        public static a d(@m0 Uri uri) {
            a aVar = new a();
            aVar.g(uri);
            return aVar;
        }

        @m0
        public k a() {
            return new k(this.f8875a, this.f8876b, this.f8877c);
        }

        @m0
        public a e(@m0 String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
            }
            this.f8876b = str;
            return this;
        }

        @m0
        public a f(@m0 String str) {
            if (Pattern.compile("^[-\\w*.]+/[-\\w+*.]+$").matcher(str).matches()) {
                this.f8877c = str;
                return this;
            }
            throw new IllegalArgumentException("The given mimeType " + str + " does not match to required \"type/subtype\" format");
        }

        @m0
        public a g(@m0 Uri uri) {
            this.f8875a = uri;
            return this;
        }
    }

    k(@m0 Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    @o0
    public String a() {
        return this.f8873b;
    }

    @o0
    public String b() {
        return this.f8874c;
    }

    @o0
    public Uri c() {
        return this.f8872a;
    }

    @m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.f8872a != null) {
            sb.append(" uri=");
            sb.append(this.f8872a.toString());
        }
        if (this.f8873b != null) {
            sb.append(" action=");
            sb.append(this.f8873b);
        }
        if (this.f8874c != null) {
            sb.append(" mimetype=");
            sb.append(this.f8874c);
        }
        sb.append(" }");
        return sb.toString();
    }

    k(@o0 Uri uri, @o0 String str, @o0 String str2) {
        this.f8872a = uri;
        this.f8873b = str;
        this.f8874c = str2;
    }
}
