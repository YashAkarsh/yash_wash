package org.apache.commons.lang3.text.translate;

/* JADX INFO: loaded from: classes3.dex */
public class JavaUnicodeEscaper extends UnicodeEscaper {
    public JavaUnicodeEscaper(int i7, int i8, boolean z7) {
        super(i7, i8, z7);
    }

    public static JavaUnicodeEscaper above(int i7) {
        return outsideOf(0, i7);
    }

    public static JavaUnicodeEscaper below(int i7) {
        return outsideOf(i7, Integer.MAX_VALUE);
    }

    public static JavaUnicodeEscaper between(int i7, int i8) {
        return new JavaUnicodeEscaper(i7, i8, true);
    }

    public static JavaUnicodeEscaper outsideOf(int i7, int i8) {
        return new JavaUnicodeEscaper(i7, i8, false);
    }

    @Override // org.apache.commons.lang3.text.translate.UnicodeEscaper
    protected String toUtf16Escape(int i7) {
        char[] chars = Character.toChars(i7);
        return "\\u" + CharSequenceTranslator.hex(chars[0]) + "\\u" + CharSequenceTranslator.hex(chars[1]);
    }
}
