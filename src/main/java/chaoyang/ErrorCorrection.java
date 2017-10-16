package chaoyang;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by Cc on 2017/10/16.
 */
public class ErrorCorrection {
    private static void handle(String xmlDir) throws Exception {
        // 输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码
        format.setEncoding("UTF-8");

        File[] xml64s = new File(xmlDir).listFiles(
                pathname -> pathname.getName().endsWith("xml"));

        for(File file : xml64s) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);

            for (Element object : document.getRootElement().elements("object")) {
                if (object.element("name").getText().equals("62")) {
                    System.out.println(object.element("name").getText());
                    object.element("name").setText("64");
                }
            }

            // XMLWriter 指定输出文件以及格式
            XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                    new FileOutputStream(file), "UTF-8"), format);
            // 写入新文件
            writer.write(document);
            writer.flush();
            writer.close();
        }
    }
    public static void main(String[] args) {
        try {
            handle("/Users/Cc/Desktop/xray_xml_label/64/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
