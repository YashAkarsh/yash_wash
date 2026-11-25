package t6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Inherited
@Target({ElementType.TYPE})
public @interface m {
    String[] field();

    int[] minLen();
}
