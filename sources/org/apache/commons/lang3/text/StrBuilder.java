package org.apache.commons.lang3.text;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.Builder;

/* JADX INFO: loaded from: classes3.dex */
public class StrBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    static final int CAPACITY = 32;
    private static final long serialVersionUID = 7628716375283629643L;
    protected char[] buffer;
    private String newLine;
    private String nullText;
    protected int size;

    class StrBuilderTokenizer extends StrTokenizer {
        StrBuilderTokenizer() {
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        public String getContent() {
            String content = super.getContent();
            return content == null ? StrBuilder.this.toString() : content;
        }

        @Override // org.apache.commons.lang3.text.StrTokenizer
        protected List<String> tokenize(char[] cArr, int i7, int i8) {
            if (cArr != null) {
                return super.tokenize(cArr, i7, i8);
            }
            StrBuilder strBuilder = StrBuilder.this;
            return super.tokenize(strBuilder.buffer, 0, strBuilder.size());
        }
    }

    class StrBuilderWriter extends Writer {
        StrBuilderWriter() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i7) {
            StrBuilder.this.append((char) i7);
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            StrBuilder.this.append(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i7, int i8) {
            StrBuilder.this.append(cArr, i7, i8);
        }

        @Override // java.io.Writer
        public void write(String str) {
            StrBuilder.this.append(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i7, int i8) {
            StrBuilder.this.append(str, i7, i8);
        }
    }

    public StrBuilder() {
        this(32);
    }

    private void deleteImpl(int i7, int i8, int i9) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i8, cArr, i7, this.size - i8);
        this.size -= i9;
    }

    private void replaceImpl(int i7, int i8, int i9, String str, int i10) {
        int i11 = (this.size - i9) + i10;
        if (i10 != i9) {
            ensureCapacity(i11);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i8, cArr, i7 + i10, this.size - i8);
            this.size = i11;
        }
        if (i10 > 0) {
            str.getChars(0, i10, this.buffer, i7);
        }
    }

    public <T> StrBuilder appendAll(T... tArr) {
        if (tArr != null && tArr.length > 0) {
            for (T t7 : tArr) {
                append(t7);
            }
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadLeft(Object obj, int i7, char c8) {
        if (i7 > 0) {
            ensureCapacity(this.size + i7);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i7) {
                nullText.getChars(length - i7, length, this.buffer, this.size);
            } else {
                int i8 = i7 - length;
                for (int i9 = 0; i9 < i8; i9++) {
                    this.buffer[this.size + i9] = c8;
                }
                nullText.getChars(0, length, this.buffer, this.size + i8);
            }
            this.size += i7;
        }
        return this;
    }

    public StrBuilder appendFixedWidthPadRight(Object obj, int i7, char c8) {
        if (i7 > 0) {
            ensureCapacity(this.size + i7);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i7) {
                nullText.getChars(0, i7, this.buffer, this.size);
            } else {
                int i8 = i7 - length;
                nullText.getChars(0, length, this.buffer, this.size);
                for (int i9 = 0; i9 < i8; i9++) {
                    this.buffer[this.size + length + i9] = c8;
                }
            }
            this.size += i7;
        }
        return this;
    }

    public StrBuilder appendNewLine() {
        String str = this.newLine;
        if (str != null) {
            return append(str);
        }
        append(SystemUtils.LINE_SEPARATOR);
        return this;
    }

    public StrBuilder appendNull() {
        String str = this.nullText;
        return str == null ? this : append(str);
    }

    public StrBuilder appendPadding(int i7, char c8) {
        if (i7 >= 0) {
            ensureCapacity(this.size + i7);
            for (int i8 = 0; i8 < i7; i8++) {
                char[] cArr = this.buffer;
                int i9 = this.size;
                this.size = i9 + 1;
                cArr[i9] = c8;
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public void appendTo(Appendable appendable) throws IOException {
        if (appendable instanceof Writer) {
            ((Writer) appendable).write(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuilder) {
            ((StringBuilder) appendable).append(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuffer) {
            ((StringBuffer) appendable).append(this.buffer, 0, this.size);
        } else if (appendable instanceof CharBuffer) {
            ((CharBuffer) appendable).put(this.buffer, 0, this.size);
        } else {
            appendable.append(this);
        }
    }

    public StrBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            String string = ObjectUtils.toString(str);
            append(objArr[0]);
            for (int i7 = 1; i7 < objArr.length; i7++) {
                append(string);
                append(objArr[i7]);
            }
        }
        return this;
    }

    public StrBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public Reader asReader() {
        return new StrBuilderReader();
    }

    public StrTokenizer asTokenizer() {
        return new StrBuilderTokenizer();
    }

    public Writer asWriter() {
        return new StrBuilderWriter();
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i7) {
        if (i7 < 0 || i7 >= length()) {
            throw new StringIndexOutOfBoundsException(i7);
        }
        return this.buffer[i7];
    }

    public StrBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c8) {
        char[] cArr = this.buffer;
        for (int i7 = 0; i7 < this.size; i7++) {
            if (cArr[i7] == c8) {
                return true;
            }
        }
        return false;
    }

    public StrBuilder delete(int i7, int i8) {
        int iValidateRange = validateRange(i7, i8);
        int i9 = iValidateRange - i7;
        if (i9 > 0) {
            deleteImpl(i7, iValidateRange, i9);
        }
        return this;
    }

    public StrBuilder deleteAll(char c8) {
        int i7 = 0;
        while (i7 < this.size) {
            if (this.buffer[i7] == c8) {
                int i8 = i7;
                do {
                    i8++;
                    if (i8 >= this.size) {
                        break;
                    }
                } while (this.buffer[i8] == c8);
                int i9 = i8 - i7;
                deleteImpl(i7, i8, i9);
                i7 = i8 - i9;
            }
            i7++;
        }
        return this;
    }

    public StrBuilder deleteCharAt(int i7) {
        if (i7 < 0 || i7 >= this.size) {
            throw new StringIndexOutOfBoundsException(i7);
        }
        deleteImpl(i7, i7 + 1, 1);
        return this;
    }

    public StrBuilder deleteFirst(char c8) {
        for (int i7 = 0; i7 < this.size; i7++) {
            if (this.buffer[i7] == c8) {
                deleteImpl(i7, i7 + 1, 1);
                break;
            }
        }
        return this;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i7 = this.size;
        if (length > i7) {
            return false;
        }
        int i8 = i7 - length;
        int i9 = 0;
        while (i9 < length) {
            if (this.buffer[i8] != str.charAt(i9)) {
                return false;
            }
            i9++;
            i8++;
        }
        return true;
    }

    public StrBuilder ensureCapacity(int i7) {
        char[] cArr = this.buffer;
        if (i7 > cArr.length) {
            char[] cArr2 = new char[i7 * 2];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public boolean equals(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i7 = this.size;
        if (i7 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i8 = i7 - 1; i8 >= 0; i8--) {
            if (cArr[i8] != cArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public boolean equalsIgnoreCase(StrBuilder strBuilder) {
        if (this == strBuilder) {
            return true;
        }
        int i7 = this.size;
        if (i7 != strBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = strBuilder.buffer;
        for (int i8 = i7 - 1; i8 >= 0; i8--) {
            char c8 = cArr[i8];
            char c9 = cArr2[i8];
            if (c8 != c9 && Character.toUpperCase(c8) != Character.toUpperCase(c9)) {
                return false;
            }
        }
        return true;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy(this.buffer, 0, cArr, 0, length);
        return cArr;
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        char[] cArr = this.buffer;
        int i7 = 0;
        for (int i8 = this.size - 1; i8 >= 0; i8--) {
            i7 = (i7 * 31) + cArr[i8];
        }
        return i7;
    }

    public int indexOf(char c8) {
        return indexOf(c8, 0);
    }

    public StrBuilder insert(int i7, Object obj) {
        return obj == null ? insert(i7, this.nullText) : insert(i7, obj.toString());
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int lastIndexOf(char c8) {
        return lastIndexOf(c8, this.size - 1);
    }

    public String leftString(int i7) {
        if (i7 <= 0) {
            return "";
        }
        int i8 = this.size;
        return i7 >= i8 ? new String(this.buffer, 0, i8) : new String(this.buffer, 0, i7);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.size;
    }

    public String midString(int i7, int i8) {
        int i9;
        if (i7 < 0) {
            i7 = 0;
        }
        if (i8 <= 0 || i7 >= (i9 = this.size)) {
            return "";
        }
        return i9 <= i7 + i8 ? new String(this.buffer, i7, i9 - i7) : new String(this.buffer, i7, i8);
    }

    public StrBuilder minimizeCapacity() {
        if (this.buffer.length > length()) {
            char[] cArr = this.buffer;
            char[] cArr2 = new char[length()];
            this.buffer = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, this.size);
        }
        return this;
    }

    public int readFrom(Readable readable) throws IOException {
        int i7 = this.size;
        if (readable instanceof Reader) {
            Reader reader = (Reader) readable;
            ensureCapacity(i7 + 1);
            while (true) {
                char[] cArr = this.buffer;
                int i8 = this.size;
                int i9 = reader.read(cArr, i8, cArr.length - i8);
                if (i9 == -1) {
                    break;
                }
                int i10 = this.size + i9;
                this.size = i10;
                ensureCapacity(i10 + 1);
            }
        } else if (readable instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) readable;
            int iRemaining = charBuffer.remaining();
            ensureCapacity(this.size + iRemaining);
            charBuffer.get(this.buffer, this.size, iRemaining);
            this.size += iRemaining;
        } else {
            while (true) {
                ensureCapacity(this.size + 1);
                char[] cArr2 = this.buffer;
                int i11 = this.size;
                int i12 = readable.read(CharBuffer.wrap(cArr2, i11, cArr2.length - i11));
                if (i12 == -1) {
                    break;
                }
                this.size += i12;
            }
        }
        return this.size - i7;
    }

    public StrBuilder replace(int i7, int i8, String str) {
        int iValidateRange = validateRange(i7, i8);
        replaceImpl(i7, iValidateRange, iValidateRange - i7, str, str == null ? 0 : str.length());
        return this;
    }

    public StrBuilder replaceAll(char c8, char c9) {
        if (c8 != c9) {
            for (int i7 = 0; i7 < this.size; i7++) {
                char[] cArr = this.buffer;
                if (cArr[i7] == c8) {
                    cArr[i7] = c9;
                }
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(char c8, char c9) {
        if (c8 != c9) {
            for (int i7 = 0; i7 < this.size; i7++) {
                char[] cArr = this.buffer;
                if (cArr[i7] == c8) {
                    cArr[i7] = c9;
                    break;
                }
            }
        }
        return this;
    }

    public StrBuilder reverse() {
        int i7 = this.size;
        if (i7 == 0) {
            return this;
        }
        int i8 = i7 / 2;
        char[] cArr = this.buffer;
        int i9 = i7 - 1;
        int i10 = 0;
        while (i10 < i8) {
            char c8 = cArr[i10];
            cArr[i10] = cArr[i9];
            cArr[i9] = c8;
            i10++;
            i9--;
        }
        return this;
    }

    public String rightString(int i7) {
        if (i7 <= 0) {
            return "";
        }
        int i8 = this.size;
        return i7 >= i8 ? new String(this.buffer, 0, i8) : new String(this.buffer, i8 - i7, i7);
    }

    public StrBuilder setCharAt(int i7, char c8) {
        if (i7 < 0 || i7 >= length()) {
            throw new StringIndexOutOfBoundsException(i7);
        }
        this.buffer[i7] = c8;
        return this;
    }

    public StrBuilder setLength(int i7) {
        if (i7 < 0) {
            throw new StringIndexOutOfBoundsException(i7);
        }
        int i8 = this.size;
        if (i7 < i8) {
            this.size = i7;
        } else if (i7 > i8) {
            ensureCapacity(i7);
            this.size = i7;
            for (int i9 = this.size; i9 < i7; i9++) {
                this.buffer[i9] = 0;
            }
        }
        return this;
    }

    public StrBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public StrBuilder setNullText(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i7 = 0; i7 < length; i7++) {
            if (this.buffer[i7] != str.charAt(i7)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i7, int i8) {
        if (i7 < 0) {
            throw new StringIndexOutOfBoundsException(i7);
        }
        if (i8 > this.size) {
            throw new StringIndexOutOfBoundsException(i8);
        }
        if (i7 <= i8) {
            return substring(i7, i8);
        }
        throw new StringIndexOutOfBoundsException(i8 - i7);
    }

    public String substring(int i7) {
        return substring(i7, this.size);
    }

    public char[] toCharArray() {
        int i7 = this.size;
        if (i7 == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[i7];
        System.arraycopy(this.buffer, 0, cArr, 0, i7);
        return cArr;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer(this.size);
        stringBuffer.append(this.buffer, 0, this.size);
        return stringBuffer;
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(this.size);
        sb.append(this.buffer, 0, this.size);
        return sb;
    }

    public StrBuilder trim() {
        int i7 = this.size;
        if (i7 == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i8 = 0;
        while (i8 < i7 && cArr[i8] <= ' ') {
            i8++;
        }
        while (i8 < i7 && cArr[i7 - 1] <= ' ') {
            i7--;
        }
        int i9 = this.size;
        if (i7 < i9) {
            delete(i7, i9);
        }
        if (i8 > 0) {
            delete(0, i8);
        }
        return this;
    }

    protected void validateIndex(int i7) {
        if (i7 < 0 || i7 > this.size) {
            throw new StringIndexOutOfBoundsException(i7);
        }
    }

    protected int validateRange(int i7, int i8) {
        if (i7 < 0) {
            throw new StringIndexOutOfBoundsException(i7);
        }
        int i9 = this.size;
        if (i8 > i9) {
            i8 = i9;
        }
        if (i7 <= i8) {
            return i8;
        }
        throw new StringIndexOutOfBoundsException("end < start");
    }

    class StrBuilderReader extends Reader {
        private int mark;
        private int pos;

        StrBuilderReader() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Reader
        public void mark(int i7) {
            this.mark = this.pos;
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.Reader
        public int read() {
            if (!ready()) {
                return -1;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i7 = this.pos;
            this.pos = i7 + 1;
            return strBuilder.charAt(i7);
        }

        @Override // java.io.Reader
        public boolean ready() {
            return this.pos < StrBuilder.this.size();
        }

        @Override // java.io.Reader
        public void reset() {
            this.pos = this.mark;
        }

        @Override // java.io.Reader
        public long skip(long j7) {
            if (((long) this.pos) + j7 > StrBuilder.this.size()) {
                j7 = StrBuilder.this.size() - this.pos;
            }
            if (j7 < 0) {
                return 0L;
            }
            this.pos = (int) (((long) this.pos) + j7);
            return j7;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i7, int i8) {
            int i9;
            if (i7 < 0 || i8 < 0 || i7 > cArr.length || (i9 = i7 + i8) > cArr.length || i9 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i8 == 0) {
                return 0;
            }
            if (this.pos >= StrBuilder.this.size()) {
                return -1;
            }
            if (this.pos + i8 > StrBuilder.this.size()) {
                i8 = StrBuilder.this.size() - this.pos;
            }
            StrBuilder strBuilder = StrBuilder.this;
            int i10 = this.pos;
            strBuilder.getChars(i10, i10 + i8, cArr, i7);
            this.pos += i8;
            return i8;
        }
    }

    public StrBuilder(int i7) {
        this.buffer = new char[i7 <= 0 ? 32 : i7];
    }

    public StrBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    @Override // org.apache.commons.lang3.builder.Builder
    public String build() {
        return toString();
    }

    public int indexOf(char c8, int i7) {
        if (i7 < 0) {
            i7 = 0;
        }
        if (i7 >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (i7 < this.size) {
            if (cArr[i7] == c8) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public int lastIndexOf(char c8, int i7) {
        int i8 = this.size;
        if (i7 >= i8) {
            i7 = i8 - 1;
        }
        if (i7 < 0) {
            return -1;
        }
        while (i7 >= 0) {
            if (this.buffer[i7] == c8) {
                return i7;
            }
            i7--;
        }
        return -1;
    }

    public String substring(int i7, int i8) {
        return new String(this.buffer, i7, validateRange(i7, i8) - i7);
    }

    public StrBuilder appendln(String str, int i7, int i8) {
        return append(str, i7, i8).appendNewLine();
    }

    public StrBuilder insert(int i7, String str) {
        int length;
        validateIndex(i7);
        if (str == null) {
            str = this.nullText;
        }
        if (str != null && (length = str.length()) > 0) {
            int i8 = this.size + length;
            ensureCapacity(i8);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i7, cArr, i7 + length, this.size - i7);
            this.size = i8;
            str.getChars(0, length, this.buffer, i7);
        }
        return this;
    }

    public StrBuilder(String str) {
        if (str == null) {
            this.buffer = new char[32];
        } else {
            this.buffer = new char[str.length() + 32];
            append(str);
        }
    }

    public StrBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        if (obj instanceof CharSequence) {
            return append((CharSequence) obj);
        }
        return append(obj.toString());
    }

    public StrBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c8) {
        if (size() > 0) {
            append(c8);
        }
        return this;
    }

    public StrBuilder appendln(String str, Object... objArr) {
        return append(str, objArr).appendNewLine();
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public StrBuilder deleteFirst(String str) {
        int iIndexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (iIndexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(iIndexOf, iIndexOf + length, length);
        }
        return this;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    public StrBuilder replace(StrMatcher strMatcher, String str, int i7, int i8, int i9) {
        return replaceImpl(strMatcher, str, i7, validateRange(i7, i8), i9);
    }

    public StrBuilder replaceAll(String str, String str2) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int length2 = str2 == null ? 0 : str2.length();
            int iIndexOf = indexOf(str, 0);
            while (iIndexOf >= 0) {
                replaceImpl(iIndexOf, iIndexOf + length, length, str2, length2);
                iIndexOf = indexOf(str, iIndexOf + length2);
            }
        }
        return this;
    }

    public StrBuilder replaceFirst(String str, String str2) {
        int iIndexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (iIndexOf = indexOf(str, 0)) >= 0) {
            replaceImpl(iIndexOf, iIndexOf + length, length, str2, str2 != null ? str2.length() : 0);
        }
        return this;
    }

    public StrBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public boolean contains(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof StrBuilder) {
            return equals((StrBuilder) obj);
        }
        return false;
    }

    public void getChars(int i7, int i8, char[] cArr, int i9) {
        if (i7 >= 0) {
            if (i8 < 0 || i8 > length()) {
                throw new StringIndexOutOfBoundsException(i8);
            }
            if (i7 <= i8) {
                System.arraycopy(this.buffer, i7, cArr, i9, i8 - i7);
                return;
            }
            throw new StringIndexOutOfBoundsException("end < start");
        }
        throw new StringIndexOutOfBoundsException(i7);
    }

    public int lastIndexOf(String str, int i7) {
        int i8 = this.size;
        if (i7 >= i8) {
            i7 = i8 - 1;
        }
        if (str != null && i7 >= 0) {
            int length = str.length();
            if (length > 0 && length <= this.size) {
                if (length == 1) {
                    return lastIndexOf(str.charAt(0), i7);
                }
                for (int i9 = (i7 - length) + 1; i9 >= 0; i9--) {
                    for (int i10 = 0; i10 < length; i10++) {
                        if (str.charAt(i10) != this.buffer[i9 + i10]) {
                        }
                    }
                    return i9;
                }
            }
            if (length == 0) {
                return i7;
            }
        }
        return -1;
    }

    public char[] toCharArray(int i7, int i8) {
        int iValidateRange = validateRange(i7, i8) - i7;
        if (iValidateRange == 0) {
            return ArrayUtils.EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[iValidateRange];
        System.arraycopy(this.buffer, i7, cArr, 0, iValidateRange);
        return cArr;
    }

    private StrBuilder replaceImpl(StrMatcher strMatcher, String str, int i7, int i8, int i9) {
        if (strMatcher != null && this.size != 0) {
            int length = str == null ? 0 : str.length();
            char[] cArr = this.buffer;
            int i10 = i7;
            while (i10 < i8 && i9 != 0) {
                int iIsMatch = strMatcher.isMatch(cArr, i10, i7, i8);
                if (iIsMatch > 0) {
                    replaceImpl(i10, i10 + iIsMatch, iIsMatch, str, length);
                    i8 = (i8 - iIsMatch) + length;
                    i10 = (i10 + length) - 1;
                    if (i9 > 0) {
                        i9--;
                    }
                }
                i10++;
            }
        }
        return this;
    }

    public StrBuilder appendAll(Iterator<?> it) {
        if (it != null) {
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public StrBuilder appendSeparator(char c8, char c9) {
        if (size() > 0) {
            append(c8);
        } else {
            append(c9);
        }
        return this;
    }

    public StrBuilder appendln(StringBuilder sb) {
        return append(sb).appendNewLine();
    }

    public StrBuilder deleteAll(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int iIndexOf = indexOf(str, 0);
            while (iIndexOf >= 0) {
                deleteImpl(iIndexOf, iIndexOf + length, length);
                iIndexOf = indexOf(str, iIndexOf);
            }
        }
        return this;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public StrBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        if (iterable != null) {
            String string = ObjectUtils.toString(str);
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(string);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(StringBuilder sb, int i7, int i8) {
        return append(sb, i7, i8).appendNewLine();
    }

    public StrBuilder deleteFirst(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, 1);
    }

    public int indexOf(String str, int i7) {
        if (i7 < 0) {
            i7 = 0;
        }
        if (str != null && i7 < this.size) {
            int length = str.length();
            if (length == 1) {
                return indexOf(str.charAt(0), i7);
            }
            if (length == 0) {
                return i7;
            }
            int i8 = this.size;
            if (length > i8) {
                return -1;
            }
            char[] cArr = this.buffer;
            int i9 = (i8 - length) + 1;
            while (i7 < i9) {
                for (int i10 = 0; i10 < length; i10++) {
                    if (str.charAt(i10) != cArr[i7 + i10]) {
                        i7++;
                    }
                }
                return i7;
            }
        }
        return -1;
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            return appendNull();
        }
        if (charSequence instanceof StrBuilder) {
            return append((StrBuilder) charSequence);
        }
        if (charSequence instanceof StringBuilder) {
            return append((StringBuilder) charSequence);
        }
        if (charSequence instanceof StringBuffer) {
            return append((StringBuffer) charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return append((CharBuffer) charSequence);
        }
        return append(charSequence.toString());
    }

    public StrBuilder appendFixedWidthPadLeft(int i7, int i8, char c8) {
        return appendFixedWidthPadLeft(String.valueOf(i7), i8, c8);
    }

    public StrBuilder appendFixedWidthPadRight(int i7, int i8, char c8) {
        return appendFixedWidthPadRight(String.valueOf(i7), i8, c8);
    }

    public StrBuilder appendln(StringBuffer stringBuffer, int i7, int i8) {
        return append(stringBuffer, i7, i8).appendNewLine();
    }

    public StrBuilder replaceFirst(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, 1);
    }

    public StrBuilder appendSeparator(String str, int i7) {
        if (str != null && i7 > 0) {
            append(str);
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder) {
        return append(strBuilder).appendNewLine();
    }

    public StrBuilder replaceAll(StrMatcher strMatcher, String str) {
        return replace(strMatcher, str, 0, this.size, -1);
    }

    public StrBuilder appendSeparator(char c8, int i7) {
        if (i7 > 0) {
            append(c8);
        }
        return this;
    }

    public StrBuilder appendln(StrBuilder strBuilder, int i7, int i8) {
        return append(strBuilder, i7, i8).appendNewLine();
    }

    public StrBuilder deleteAll(StrMatcher strMatcher) {
        return replace(strMatcher, null, 0, this.size, -1);
    }

    public int lastIndexOf(StrMatcher strMatcher) {
        return lastIndexOf(strMatcher, this.size);
    }

    public StrBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public StrBuilder insert(int i7, char[] cArr) {
        validateIndex(i7);
        if (cArr == null) {
            return insert(i7, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i7, cArr2, i7 + length, this.size - i7);
            System.arraycopy(cArr, 0, this.buffer, i7, length);
            this.size += length;
        }
        return this;
    }

    public int lastIndexOf(StrMatcher strMatcher, int i7) {
        int i8 = this.size;
        if (i7 >= i8) {
            i7 = i8 - 1;
        }
        if (strMatcher != null && i7 >= 0) {
            char[] cArr = this.buffer;
            int i9 = i7 + 1;
            while (i7 >= 0) {
                if (strMatcher.isMatch(cArr, i7, 0, i9) > 0) {
                    return i7;
                }
                i7--;
            }
        }
        return -1;
    }

    public StrBuilder appendln(char[] cArr, int i7, int i8) {
        return append(cArr, i7, i8).appendNewLine();
    }

    public StrBuilder appendWithSeparators(Iterator<?> it, String str) {
        if (it != null) {
            String string = ObjectUtils.toString(str);
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(string);
                }
            }
        }
        return this;
    }

    public StrBuilder appendln(boolean z7) {
        return append(z7).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher) {
        return indexOf(strMatcher, 0);
    }

    public StrBuilder appendln(char c8) {
        return append(c8).appendNewLine();
    }

    public int indexOf(StrMatcher strMatcher, int i7) {
        int i8;
        if (i7 < 0) {
            i7 = 0;
        }
        if (strMatcher != null && i7 < (i8 = this.size)) {
            char[] cArr = this.buffer;
            for (int i9 = i7; i9 < i8; i9++) {
                if (strMatcher.isMatch(cArr, i9, i7, i8) > 0) {
                    return i9;
                }
            }
        }
        return -1;
    }

    public StrBuilder appendln(int i7) {
        return append(i7).appendNewLine();
    }

    public StrBuilder appendln(long j7) {
        return append(j7).appendNewLine();
    }

    public StrBuilder appendln(float f8) {
        return append(f8).appendNewLine();
    }

    @Override // java.lang.Appendable
    public StrBuilder append(CharSequence charSequence, int i7, int i8) {
        if (charSequence == null) {
            return appendNull();
        }
        return append(charSequence.toString(), i7, i8);
    }

    public StrBuilder appendln(double d8) {
        return append(d8).appendNewLine();
    }

    public StrBuilder insert(int i7, char[] cArr, int i8, int i9) {
        validateIndex(i7);
        if (cArr == null) {
            return insert(i7, this.nullText);
        }
        if (i8 >= 0 && i8 <= cArr.length) {
            if (i9 < 0 || i8 + i9 > cArr.length) {
                throw new StringIndexOutOfBoundsException("Invalid length: " + i9);
            }
            if (i9 > 0) {
                ensureCapacity(this.size + i9);
                char[] cArr2 = this.buffer;
                System.arraycopy(cArr2, i7, cArr2, i7 + i9, this.size - i7);
                System.arraycopy(cArr, i8, this.buffer, i7, i9);
                this.size += i9;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("Invalid offset: " + i8);
    }

    public StrBuilder append(String str) {
        if (str == null) {
            return appendNull();
        }
        int length = str.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            str.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(String str, int i7, int i8) {
        int i9;
        if (str == null) {
            return appendNull();
        }
        if (i7 >= 0 && i7 <= str.length()) {
            if (i8 < 0 || (i9 = i7 + i8) > str.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i8 > 0) {
                int length = length();
                ensureCapacity(length + i8);
                str.getChars(i7, i9, this.buffer, length);
                this.size += i8;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder insert(int i7, boolean z7) {
        validateIndex(i7);
        if (z7) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i7, cArr, i7 + 4, this.size - i7);
            char[] cArr2 = this.buffer;
            int i8 = i7 + 1;
            cArr2[i7] = 't';
            int i9 = i8 + 1;
            cArr2[i8] = 'r';
            cArr2[i9] = 'u';
            cArr2[i9 + 1] = 'e';
            this.size += 4;
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr3 = this.buffer;
            System.arraycopy(cArr3, i7, cArr3, i7 + 5, this.size - i7);
            char[] cArr4 = this.buffer;
            int i10 = i7 + 1;
            cArr4[i7] = 'f';
            int i11 = i10 + 1;
            cArr4[i10] = 'a';
            int i12 = i11 + 1;
            cArr4[i11] = 'l';
            cArr4[i12] = 's';
            cArr4[i12 + 1] = 'e';
            this.size += 5;
        }
        return this;
    }

    public StrBuilder append(String str, Object... objArr) {
        return append(String.format(str, objArr));
    }

    public StrBuilder append(CharBuffer charBuffer) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int iRemaining = charBuffer.remaining();
            int length = length();
            ensureCapacity(length + iRemaining);
            System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position(), this.buffer, length, iRemaining);
            this.size += iRemaining;
        } else {
            append(charBuffer.toString());
        }
        return this;
    }

    public StrBuilder append(CharBuffer charBuffer, int i7, int i8) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int iRemaining = charBuffer.remaining();
            if (i7 < 0 || i7 > iRemaining) {
                throw new StringIndexOutOfBoundsException("startIndex must be valid");
            }
            if (i8 >= 0 && i7 + i8 <= iRemaining) {
                int length = length();
                ensureCapacity(length + i8);
                System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i7, this.buffer, length, i8);
                this.size += i8;
            } else {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
        } else {
            append(charBuffer.toString(), i7, i8);
        }
        return this;
    }

    public StrBuilder insert(int i7, char c8) {
        validateIndex(i7);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i7, cArr, i7 + 1, this.size - i7);
        this.buffer[i7] = c8;
        this.size++;
        return this;
    }

    public StrBuilder insert(int i7, int i8) {
        return insert(i7, String.valueOf(i8));
    }

    public StrBuilder insert(int i7, long j7) {
        return insert(i7, String.valueOf(j7));
    }

    public StrBuilder insert(int i7, float f8) {
        return insert(i7, String.valueOf(f8));
    }

    public StrBuilder insert(int i7, double d8) {
        return insert(i7, String.valueOf(d8));
    }

    public StrBuilder append(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return appendNull();
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            stringBuffer.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StringBuffer stringBuffer, int i7, int i8) {
        int i9;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i7 >= 0 && i7 <= stringBuffer.length()) {
            if (i8 < 0 || (i9 = i7 + i8) > stringBuffer.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i8 > 0) {
                int length = length();
                ensureCapacity(length + i8);
                stringBuffer.getChars(i7, i9, this.buffer, length);
                this.size += i8;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder append(StringBuilder sb) {
        if (sb == null) {
            return appendNull();
        }
        int length = sb.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            sb.getChars(0, length, this.buffer, length2);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StringBuilder sb, int i7, int i8) {
        int i9;
        if (sb == null) {
            return appendNull();
        }
        if (i7 >= 0 && i7 <= sb.length()) {
            if (i8 < 0 || (i9 = i7 + i8) > sb.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i8 > 0) {
                int length = length();
                ensureCapacity(length + i8);
                sb.getChars(i7, i9, this.buffer, length);
                this.size += i8;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder append(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return appendNull();
        }
        int length = strBuilder.length();
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(strBuilder.buffer, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(StrBuilder strBuilder, int i7, int i8) {
        int i9;
        if (strBuilder == null) {
            return appendNull();
        }
        if (i7 >= 0 && i7 <= strBuilder.length()) {
            if (i8 < 0 || (i9 = i7 + i8) > strBuilder.length()) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            if (i8 > 0) {
                int length = length();
                ensureCapacity(length + i8);
                strBuilder.getChars(i7, i9, this.buffer, length);
                this.size += i8;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
    }

    public StrBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public StrBuilder append(char[] cArr, int i7, int i8) {
        if (cArr == null) {
            return appendNull();
        }
        if (i7 >= 0 && i7 <= cArr.length) {
            if (i8 < 0 || i7 + i8 > cArr.length) {
                throw new StringIndexOutOfBoundsException("Invalid length: " + i8);
            }
            if (i8 > 0) {
                int length = length();
                ensureCapacity(length + i8);
                System.arraycopy(cArr, i7, this.buffer, length, i8);
                this.size += i8;
            }
            return this;
        }
        throw new StringIndexOutOfBoundsException("Invalid startIndex: " + i8);
    }

    public StrBuilder append(boolean z7) {
        if (z7) {
            ensureCapacity(this.size + 4);
            char[] cArr = this.buffer;
            int i7 = this.size;
            int i8 = i7 + 1;
            cArr[i7] = 't';
            int i9 = i8 + 1;
            cArr[i8] = 'r';
            int i10 = i9 + 1;
            cArr[i9] = 'u';
            this.size = i10 + 1;
            cArr[i10] = 'e';
        } else {
            ensureCapacity(this.size + 5);
            char[] cArr2 = this.buffer;
            int i11 = this.size;
            int i12 = i11 + 1;
            cArr2[i11] = 'f';
            int i13 = i12 + 1;
            cArr2[i12] = 'a';
            int i14 = i13 + 1;
            cArr2[i13] = 'l';
            int i15 = i14 + 1;
            cArr2[i14] = 's';
            this.size = i15 + 1;
            cArr2[i15] = 'e';
        }
        return this;
    }

    @Override // java.lang.Appendable
    public StrBuilder append(char c8) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i7 = this.size;
        this.size = i7 + 1;
        cArr[i7] = c8;
        return this;
    }

    public StrBuilder append(int i7) {
        return append(String.valueOf(i7));
    }

    public StrBuilder append(long j7) {
        return append(String.valueOf(j7));
    }

    public StrBuilder append(float f8) {
        return append(String.valueOf(f8));
    }

    public StrBuilder append(double d8) {
        return append(String.valueOf(d8));
    }
}
