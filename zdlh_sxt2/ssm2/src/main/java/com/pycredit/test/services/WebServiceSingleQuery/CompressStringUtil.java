package com.pycredit.test.services.WebServiceSingleQuery;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.util.zip.ZipEntry;

import java.util.zip.ZipInputStream;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;


/**

 * ���������Ҫ������ɶ��ַ�����ѹ��, ��ѹ��, �Լ�Base64����, ����ѹ�����

 *@author anwx

 */

public final class CompressStringUtil {

    private static Log log = LogFactory.getLog(CompressStringUtil.class);

    

    /**

     * ��ѹ��

     * @param compressed

     * @return

     */

    public static final String decompress(byte[] compressed) {

        if (compressed == null)

            return null;

        ByteArrayOutputStream out = null;

        ByteArrayInputStream in = null;

        ZipInputStream zin = null;

        String decompressed;

        try {

            out = new ByteArrayOutputStream();

            in = new ByteArrayInputStream(compressed);

            zin = new ZipInputStream(in);

            ZipEntry entry = zin.getNextEntry();

            byte[] buffer = new byte[1024];

            int offset = -1;

            while ((offset = zin.read(buffer)) != -1) {

                out.write(buffer, 0, offset);

            }

            decompressed = new String(out.toByteArray(),"GBK");

        } catch (IOException e) {

            decompressed = null;

            throw new RuntimeException("��ѹ���ַ������ݳ���", e);

        } finally {

            if (zin != null) {

                try {

                    zin.close();

                } catch (IOException e) {

                    log.debug("�ر�ZipInputStream", e);

                }

            }

            if (in != null) {

                try {

                    in.close();

                } catch (IOException e) {

                    log.error("�ر�ByteArrayInputStream", e);

                }

            }

            if (out != null) {

                try {

                    out.close();

                } catch (IOException e) {

                    log.debug("�ر�ByteArrayOutputStream", e);

                }

            }

        }

        return decompressed;

    }

}

