package androidx.core.content;

import android.content.SharedPreferences;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class x {

    @Deprecated
    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static a f5771b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final C0060a f5772a = new C0060a();

        /* JADX INFO: renamed from: androidx.core.content.x$a$a, reason: collision with other inner class name */
        private static class C0060a {
            C0060a() {
            }

            public void a(@m0 SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        private a() {
        }

        @Deprecated
        public static a b() {
            if (f5771b == null) {
                f5771b = new a();
            }
            return f5771b;
        }

        @Deprecated
        public void a(@m0 SharedPreferences.Editor editor) {
            this.f5772a.a(editor);
        }
    }

    private x() {
    }
}
