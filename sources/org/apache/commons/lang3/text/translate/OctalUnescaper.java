package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public class OctalUnescaper extends CharSequenceTranslator {
    private boolean isOctalDigit(char c8) {
        return c8 >= '0' && c8 <= '7';
    }

    private boolean isZeroToThree(char c8) {
        return c8 >= '0' && c8 <= '3';
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i7, Writer writer) throws IOException {
        int length = (charSequence.length() - i7) - 1;
        StringBuilder sb = new StringBuilder();
        if (charSequence.charAt(i7) != '\\' || length <= 0) {
            return 0;
        }
        int i8 = i7 + 1;
        if (!isOctalDigit(charSequence.charAt(i8))) {
            return 0;
        }
        int i9 = i7 + 2;
        int i10 = i7 + 3;
        sb.append(charSequence.charAt(i8));
        if (length > 1 && isOctalDigit(charSequence.charAt(i9))) {
            sb.append(charSequence.charAt(i9));
            if (length > 2 && isZeroToThree(charSequence.charAt(i8)) && isOctalDigit(charSequence.charAt(i10))) {
                sb.append(charSequence.charAt(i10));
            }
        }
        writer.write(Integer.parseInt(sb.toString(), 8));
        return sb.length() + 1;
    }
}
