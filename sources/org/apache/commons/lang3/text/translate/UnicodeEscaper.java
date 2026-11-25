package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static UnicodeEscaper above(int i7) {
        return outsideOf(0, i7);
    }

    public static UnicodeEscaper below(int i7) {
        return outsideOf(i7, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper between(int i7, int i8) {
        return new UnicodeEscaper(i7, i8, true);
    }

    public static UnicodeEscaper outsideOf(int i7, int i8) {
        return new UnicodeEscaper(i7, i8, false);
    }

    protected String toUtf16Escape(int i7) {
        return "\\u" + CharSequenceTranslator.hex(i7);
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
        if (i7 > 65535) {
            writer.write(toUtf16Escape(i7));
            return true;
        }
        writer.write("\\u");
        char[] cArr = CharSequenceTranslator.HEX_DIGITS;
        writer.write(cArr[(i7 >> 12) & 15]);
        writer.write(cArr[(i7 >> 8) & 15]);
        writer.write(cArr[(i7 >> 4) & 15]);
        writer.write(cArr[i7 & 15]);
        return true;
    }

    protected UnicodeEscaper(int i7, int i8, boolean z7) {
        this.below = i7;
        this.above = i8;
        this.between = z7;
    }
}
