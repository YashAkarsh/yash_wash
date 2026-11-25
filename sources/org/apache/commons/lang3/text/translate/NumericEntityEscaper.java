package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public class NumericEntityEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    private NumericEntityEscaper(int i7, int i8, boolean z7) {
        this.below = i7;
        this.above = i8;
        this.between = z7;
    }

    public static NumericEntityEscaper above(int i7) {
        return outsideOf(0, i7);
    }

    public static NumericEntityEscaper below(int i7) {
        return outsideOf(i7, Integer.MAX_VALUE);
    }

    public static NumericEntityEscaper between(int i7, int i8) {
        return new NumericEntityEscaper(i7, i8, true);
    }

    public static NumericEntityEscaper outsideOf(int i7, int i8) {
        return new NumericEntityEscaper(i7, i8, false);
    }

    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i7, Writer writer) throws IOException {
        if (this.between) {
            if (i7 < this.below || i7 > this.above) {
                return false;
            }
        } else if (i7 >= this.below && i7 <= this.above) {
            return false;
        }
        writer.write("&#");
        writer.write(Integer.toString(i7, 10));
        writer.write(59);
        return true;
    }

    public NumericEntityEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }
}
