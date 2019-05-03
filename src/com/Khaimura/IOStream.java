package com.Khaimura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOStream {
    public IOStream() {
    }

    public static void stremCopy(InputStream is, OutputStream os) throws IOException {
        if (is != null && os != null) {
            byte[] buffer = new byte[1048576];
            boolean var3 = false;

            int readByte;
            while ((readByte = is.read(buffer)) > 0) {
                os.write(buffer, 0, readByte);
            }

        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void fileCopy(File fis, File foc) throws IOException {
        if (fis != null && foc != null) {
            try {
                InputStream is = new FileInputStream(fis);
                Throwable var3 = null;

                try {
                    OutputStream os = new FileOutputStream(foc);
                    Throwable var5 = null;

                    try {
                        stremCopy(is, os);
                    } catch (Throwable var30) {
                        var5 = var30;
                        throw var30;
                    } finally {
                        if (os != null) {
                            if (var5 != null) {
                                try {
                                    os.close();
                                } catch (Throwable var29) {
                                    var5.addSuppressed(var29);
                                }
                            } else {
                                os.close();
                            }
                        }

                    }
                } catch (Throwable var32) {
                    var3 = var32;
                    throw var32;
                } finally {
                    if (is != null) {
                        if (var3 != null) {
                            try {
                                is.close();
                            } catch (Throwable var28) {
                                var3.addSuppressed(var28);
                            }
                        } else {
                            is.close();
                        }
                    }

                }

            } catch (IOException var34) {
                throw var34;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
