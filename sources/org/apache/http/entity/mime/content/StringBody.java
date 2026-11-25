package org.apache.http.entity.mime.content;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: loaded from: classes3.dex */
public class StringBody extends AbstractContentBody {
    private final Charset charset;
    private final byte[] content;

    public StringBody(String str, String str2, Charset charset) throws UnsupportedEncodingException {
        super(str2);
        if (str == null) {
            throw new IllegalArgumentException("Text may not be null");
        }
        charset = charset == null ? Charset.forName(CharEncoding.US_ASCII) : charset;
        this.content = str.getBytes(charset.name());
        this.charset = charset;
    }

    public static StringBody create(String str, String str2, Charset charset) throws IllegalArgumentException {
        try {
            return new StringBody(str, str2, charset);
        } catch (UnsupportedEncodingException e8) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e8);
        }
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getCharset() {
        return this.charset.name();
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.content.length;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return null;
    }

    public Reader getReader() {
        return new InputStreamReader(new ByteArrayInputStream(this.content), this.charset);
    }

    @Override // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    @Override // org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        byte[] bArr = new byte[4096];
        while (true) {
            int i7 = byteArrayInputStream.read(bArr);
            if (i7 == -1) {
                outputStream.flush();
                return;
            }
            outputStream.write(bArr, 0, i7);
        }
    }

    public static StringBody create(String str, Charset charset) throws IllegalArgumentException {
        return create(str, null, charset);
    }

    public static StringBody create(String str) throws IllegalArgumentException {
        return create(str, null, null);
    }

    public StringBody(String str, Charset charset) throws UnsupportedEncodingException {
        this(str, "text/plain", charset);
    }

    public StringBody(String str) throws UnsupportedEncodingException {
        this(str, "text/plain", null);
    }
}
