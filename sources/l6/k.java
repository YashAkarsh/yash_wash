package l6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import v6.h0;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@h0({s.class, d.class, f.class})
@v6.s(stringPatterns = {"^([A-Za-z_][A-Za-z_0-9]*)(\\[\\])*$"})
public @interface k {
}
