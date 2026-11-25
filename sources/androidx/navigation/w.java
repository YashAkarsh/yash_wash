package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.l;
import c.m0;
import c.o0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
public abstract class w<D extends l> {

    public interface a {
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String value();
    }

    @m0
    public abstract D a();

    @o0
    public abstract l b(@m0 D d8, @o0 Bundle bundle, @o0 t tVar, @o0 a aVar);

    public void c(@m0 Bundle bundle) {
    }

    @o0
    public Bundle d() {
        return null;
    }

    public abstract boolean e();
}
