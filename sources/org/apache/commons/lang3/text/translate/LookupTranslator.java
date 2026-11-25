package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<String, String> lookupMap = new HashMap<>();
    private final HashSet<Character> prefixSet = new HashSet<>();
    private final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        if (charSequenceArr != null) {
            int i9 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0].toString(), charSequenceArr2[1].toString());
                this.prefixSet.add(Character.valueOf(charSequenceArr2[0].charAt(0)));
                int length = charSequenceArr2[0].length();
                i7 = length < i7 ? length : i7;
                if (length > i9) {
                    i9 = length;
                }
            }
            i8 = i9;
        }
        this.shortest = i7;
        this.longest = i8;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence charSequence, int i7, Writer writer) throws IOException {
        if (!this.prefixSet.contains(Character.valueOf(charSequence.charAt(i7)))) {
            return 0;
        }
        int length = this.longest;
        if (i7 + length > charSequence.length()) {
            length = charSequence.length() - i7;
        }
        while (length >= this.shortest) {
            String str = this.lookupMap.get(charSequence.subSequence(i7, i7 + length).toString());
            if (str != null) {
                writer.write(str);
                return length;
            }
            length--;
        }
        return 0;
    }
}
