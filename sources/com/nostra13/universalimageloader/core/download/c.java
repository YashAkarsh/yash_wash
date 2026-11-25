package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public enum a {
        HTTP(com.haier.uhome.usdk.base.a.av),
        HTTPS(j0.b.f34226a),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f32791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f32792b;

        a(String str) {
            this.f32791a = str;
            this.f32792b = str + "://";
        }

        private boolean a(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.f32792b);
        }

        public static a c(String str) {
            if (str != null) {
                for (a aVar : values()) {
                    if (aVar.a(str)) {
                        return aVar;
                    }
                }
            }
            return UNKNOWN;
        }

        public String b(String str) {
            if (a(str)) {
                return str.substring(this.f32792b.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.f32791a));
        }

        public String d(String str) {
            return this.f32792b + str;
        }
    }

    InputStream a(String str, Object obj) throws IOException;
}
