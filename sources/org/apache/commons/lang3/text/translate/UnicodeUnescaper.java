package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public class UnicodeUnescaper extends CharSequenceTranslator {
    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i7, Writer writer) throws IOException {
        int i8;
        int i9;
        if (charSequence.charAt(i7) != '\\' || (i8 = i7 + 1) >= charSequence.length() || charSequence.charAt(i8) != 'u') {
            return 0;
        }
        int i10 = 2;
        while (true) {
            i9 = i7 + i10;
            if (i9 >= charSequence.length() || charSequence.charAt(i9) != 'u') {
                break;
            }
            i10++;
        }
        if (i9 < charSequence.length() && charSequence.charAt(i9) == '+') {
            i10++;
        }
        int i11 = i7 + i10;
        int i12 = i11 + 4;
        if (i12 > charSequence.length()) {
            throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + ((Object) charSequence.subSequence(i7, charSequence.length())) + "' due to end of CharSequence");
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(i11, i12);
        try {
            writer.write((char) Integer.parseInt(charSequenceSubSequence.toString(), 16));
            return i10 + 4;
        } catch (NumberFormatException e8) {
            throw new IllegalArgumentException("Unable to parse unicode value: " + ((Object) charSequenceSubSequence), e8);
        }
    }
}
