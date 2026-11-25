package c7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.experimental.theories.f;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.PARAMETER})
@f(b.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    int[] ints();
}
