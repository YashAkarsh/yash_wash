package org.apache.commons.lang3.text;

import java.util.Arrays;
import kotlin.text.h0;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class StrMatcher {
    private static final StrMatcher COMMA_MATCHER = new CharMatcher(',');
    private static final StrMatcher TAB_MATCHER = new CharMatcher('\t');
    private static final StrMatcher SPACE_MATCHER = new CharMatcher(' ');
    private static final StrMatcher SPLIT_MATCHER = new CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final StrMatcher TRIM_MATCHER = new TrimMatcher();
    private static final StrMatcher SINGLE_QUOTE_MATCHER = new CharMatcher('\'');
    private static final StrMatcher DOUBLE_QUOTE_MATCHER = new CharMatcher(h0.f35376b);
    private static final StrMatcher QUOTE_MATCHER = new CharSetMatcher("'\"".toCharArray());
    private static final StrMatcher NONE_MATCHER = new NoMatcher();

    static final class CharMatcher extends StrMatcher {
        private final char ch;

        CharMatcher(char c8) {
            this.ch = c8;
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i7, int i8, int i9) {
            return this.ch == cArr[i7] ? 1 : 0;
        }
    }

    static final class CharSetMatcher extends StrMatcher {
        private final char[] chars;

        CharSetMatcher(char[] cArr) {
            char[] cArr2 = (char[]) cArr.clone();
            this.chars = cArr2;
            Arrays.sort(cArr2);
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i7, int i8, int i9) {
            return Arrays.binarySearch(this.chars, cArr[i7]) >= 0 ? 1 : 0;
        }
    }

    static final class NoMatcher extends StrMatcher {
        NoMatcher() {
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i7, int i8, int i9) {
            return 0;
        }
    }

    static final class StringMatcher extends StrMatcher {
        private final char[] chars;

        StringMatcher(String str) {
            this.chars = str.toCharArray();
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i7, int i8, int i9) {
            int length = this.chars.length;
            if (i7 + length > i9) {
                return 0;
            }
            int i10 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i10 >= cArr2.length) {
                    return length;
                }
                if (cArr2[i10] != cArr[i7]) {
                    return 0;
                }
                i10++;
                i7++;
            }
        }
    }

    static final class TrimMatcher extends StrMatcher {
        TrimMatcher() {
        }

        @Override // org.apache.commons.lang3.text.StrMatcher
        public int isMatch(char[] cArr, int i7, int i8, int i9) {
            return cArr[i7] <= ' ' ? 1 : 0;
        }
    }

    protected StrMatcher() {
    }

    public static StrMatcher charMatcher(char c8) {
        return new CharMatcher(c8);
    }

    public static StrMatcher charSetMatcher(char... cArr) {
        if (cArr == null || cArr.length == 0) {
            return NONE_MATCHER;
        }
        return cArr.length == 1 ? new CharMatcher(cArr[0]) : new CharSetMatcher(cArr);
    }

    public static StrMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public static StrMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public static StrMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public static StrMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public static StrMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public static StrMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public static StrMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public static StrMatcher stringMatcher(String str) {
        return StringUtils.isEmpty(str) ? NONE_MATCHER : new StringMatcher(str);
    }

    public static StrMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public static StrMatcher trimMatcher() {
        return TRIM_MATCHER;
    }

    public int isMatch(char[] cArr, int i7) {
        return isMatch(cArr, i7, 0, cArr.length);
    }

    public abstract int isMatch(char[] cArr, int i7, int i8, int i9);

    public static StrMatcher charSetMatcher(String str) {
        if (StringUtils.isEmpty(str)) {
            return NONE_MATCHER;
        }
        if (str.length() == 1) {
            return new CharMatcher(str.charAt(0));
        }
        return new CharSetMatcher(str.toCharArray());
    }
}
