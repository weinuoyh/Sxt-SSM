package com.pycredit.test.services.WebServiceSingleQuery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;


import org.codehaus.xfire.client.Client;
import org.w3c.dom.*;

public class Test {

    //public static String soapUrl = "";   //soap ·��
    private static String userName = "zdlhwsquery01"; //�û���
    private static String passWord = "{MD5}Mwl82r7q0E+33nerovt0PA=="; //����
    public static void main(String args[]) throws Exception{
/*������SSLʱ�������´���*/
        System.setProperty("javax.net.ssl.keyStore","E:/datass/test.jks");
        System.setProperty("javax.net.ssl.keyStorePassword","123456");
        Test test =new Test();//��ʼ��Test��
        test.testwsQuery();//�������еķ���
    }

    /*
     *
     *  ���Բ�ѯ�ķ���
     *
     */
    private void testwsQuery()
    {
        try{

            String queryInfo = "";  //��ѯ�����ַ�
            BufferedReader br = new BufferedReader(new FileReader("E:/datass/wsquery1.xml"));//��Buffer���ķ�ʽ��ȡwsquery1.xml
            String str = br.readLine(); //�洢�ַ�����
            //	��ȡ
            while(str!=null)
            {
                queryInfo+=str;
                str = br.readLine();
            }
            //�ر�����ȡ
            br.close();
            //����webservice
            Client client = new Client(new URL("https://test.pycredit.com:9443/services/WebServiceSingleQuery?wsdl"));
            //�õ�������
            Object [] results = client.invoke("queryReport",new Object[]{userName,passWord,queryInfo,"xml"});
            //����������ͨ������ʽ
            if(results[0] instanceof String){
                //���ر����ַ�����������ο��ӿ��ĵ���������������ʽ������ѯ�ӿ�˵��.doc��
                String res=results[0].toString();
                System.out.println("��Ԫ����ԭʼ�����"+res);
                //�����ѯ����������returnValue
                String[] str2=res.split("<returnValue>");
                String[] str3=str2[1].split("</returnValue>");
                String reportvalue=str3[0];
                //ʹ��Base64���CompassStringUtil�������Ľ����
                Base64 base64=new Base64();
                byte [] re=base64.decode(reportvalue);
                String xml=new CompressStringUtil().decompress(re);
                System.out.println(xml);//�õ����Ľ��
            }
            //ר������ͨ������ʽ
            else if (results[0] instanceof Document) {
                //�����ַ���Document����������Document����
                //����dom��
                Document dom = (Document)results[0];
                String outresult=dom.getFirstChild().getFirstChild().getNodeValue();//�õ���������
                //�õ����Ľ��
                String[] str4=outresult.split("<returnValue>");
                String[] str5=str4[1].split("</returnValue>");
                String reportvalue=str5[0];
                //ʹ��Base64���CompassStringUtil�������Ľ����
                Base64 b64=new Base64();
                byte [] re_str=b64.decode(reportvalue);
                String strxml=new CompressStringUtil().decompress(re_str);
                System.out.println(strxml);//�õ����Ľ��
            }
        }
        catch(Exception e){
            System.out.println("(Exception :"+e.getMessage());
        }
    }

}
