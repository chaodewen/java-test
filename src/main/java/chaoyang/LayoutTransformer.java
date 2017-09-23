package chaoyang;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cc on 2017/9/21.
 */
public class LayoutTransformer {

    private static File[] xml61s, xml63s, xml64s, xml67s, unlabeledImages;

    private static int cnt, total61, total63, total64, total67;

    public static void genOutput(String xmlDir, String imageDir, String outputDir) throws Exception {
        xml61s = new File(xmlDir + "61").listFiles(
                pathname -> pathname.getName().endsWith("xml"));
        xml63s = new File(xmlDir + "63").listFiles(
                pathname -> pathname.getName().endsWith("xml"));
        xml64s = new File(xmlDir + "64").listFiles(
                pathname -> pathname.getName().endsWith("xml"));
        xml67s = new File(xmlDir + "67").listFiles(
                pathname -> pathname.getName().endsWith("xml"));

        unlabeledImages = new File(imageDir + "unlabeled/").listFiles(
                pathname -> pathname.getName().endsWith("xml"));

        cnt = 0;
        total61 = 0;
        total63 = 0;
        total64 = 0;
        total67 = 0;

        handleByXmlType(xml61s, 61, imageDir, outputDir);
        handleByXmlType(xml63s, 63, imageDir, outputDir);
        handleByXmlType(xml64s, 64, imageDir, outputDir);
        handleByXmlType(xml67s, 67, imageDir, outputDir);

        genTxt(outputDir);

        System.out.println("cnt = " + cnt);
        System.out.println("total61 = " + total61);
        System.out.println("total63 = " + total63);
        System.out.println("total64 = " + total64);
        System.out.println("total67 = " + total67);
    }

    private static void genTxt(String outputDir) throws Exception {
        List<Integer> test = new ArrayList<>(), trainval = new ArrayList<>()
                , train = new ArrayList<>(), val = new ArrayList<>();

        genSingleTxtList(0, total61 - 1, test, trainval, train, val);
        genSingleTxtList(total61, total61 + total63 - 1, test, trainval, train, val);
        genSingleTxtList(total61 + total63, total61 + total63 + total64 - 1
                , test, trainval, train, val);
        genSingleTxtList(total61 + total63 + total64
                , total61 + total63 + total64 + total67 - 1
                , test, trainval, train, val);

        writeTxt(outputDir + "/ImageSets/Main/test.txt", test);
        writeTxt(outputDir + "/ImageSets/Main/trainval.txt", trainval);
        writeTxt(outputDir + "/ImageSets/Main/train.txt", train);
        writeTxt(outputDir + "/ImageSets/Main/val.txt", val);
    }

    private static void writeTxt(String outputDir, List<Integer> list) throws Exception {
        File file = new File(outputDir);
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            for (Integer i : list) {
                writer.write(String.valueOf(i));
                writer.newLine(); // 换行
            }
            writer.flush();
        } finally {
            if (writer != null) {
                writer.close();
            }
            if (fw != null) {
                fw.close();
            }
        }
    }

    private static void genSingleTxtList(int start, int end, List<Integer> test
            , List<Integer> trainval, List<Integer> train, List<Integer> val) {
        int test_trainval = (start + end) / 2, train_val = (test_trainval + end) / 2;

        System.out.println("Handling region = [" + start + ", " + test_trainval
                + ", " + train_val + ", " + end + "]");

        for (int i = start; i <= end; i++) {
            if (i < test_trainval) {
                test.add(i);
            } else {
                trainval.add(i);
                if (i < train_val) {
                    train.add(i);
                } else {
                    val.add(i);
                }
            }
        }
    }

    private static void handleByXmlType(File[] xmlFiles, int defectNo, String imageDir, String outputDir) throws Exception {
        for (File file : xmlFiles) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(file);

            String filename = document.getRootElement().element("filename").getText();

            boolean isConcerned = true;
            for (Element object : document.getRootElement().elements("object")) {
                if (object.element("Difficult") != null) {
                    object.element("Difficult").setName("difficult");
                }
                if (!object.element("name").getText().equals("61")
                        && !object.element("name").getText().equals("63")
                        && !object.element("name").getText().equals("64")
                        && !object.element("name").getText().equals("67")) {
                    isConcerned = false;
                    break;
                }
            }

            if (isConcerned) {
                File image = findImage(imageDir + "labeled/", defectNo, filename);

                if (image == null) {
                    System.out.println("Image Not Found : " + filename);
                } else {
                    saveToOutput(document, image, outputDir);
                    cnt++;
                }

                switch (defectNo) {
                    case 61:
                        total61++;
                        break;
                    case 63:
                        total63++;
                        break;
                    case 64:
                        total64++;
                        break;
                    case 67:
                        total67++;
                }
            }
            else {
                System.out.println("Skip xml file : " + filename);
            }
        }
    }

    private static File findImage(String imageDir, int defectNo, String filename) {
        for (File file : new File(imageDir + defectNo).listFiles()) {
            if (file.getName().contains(filename)) {
                return file;
            }
        }

        if (defectNo == 61) {
            for (int i = 1; i <= 4; i++) {
                for (File file : new File(imageDir + "61" + i).listFiles()) {
                    if (file.getName().contains(filename)) {
                        return file;
                    }
                }
            }
        }

        for (File file : unlabeledImages) {
            if (file.getName().contains(filename)) {
                return file;
            }
        }

        return null;
    }

    private static void saveToOutput(Document document, File image, String outputDir) throws Exception {
        File imageOutput = new File(outputDir + "JPEGImages/" + cnt + ".jpg");
        copy(image, imageOutput);

        document.getRootElement().element("filename").setText(String.valueOf(cnt) + ".jpg");
        document.getRootElement().element("folder").setText("labeled_data");

        saveDocument(document, outputDir + "Annotations/" + cnt + ".xml");
    }

    private static void copy(File source, File dest) throws Exception {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            if (inputChannel != null) {
                inputChannel.close();
            }
            if (outputChannel != null) {
                outputChannel.close();
            }
        }
    }

    private static void saveDocument(Document document, String outputDir) throws Exception {
        // 输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // 设置编码
        format.setEncoding("UTF-8");
        // XMLWriter 指定输出文件以及格式
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(
                new FileOutputStream(new File(outputDir)), "UTF-8"), format);

        // 写入新文件
        writer.write(document);
        writer.flush();
        writer.close();
    }

    public static void main(String[] args) {
        try {
//            genOutput("/home/ccnt/chaoyang/chaodewen/data/whole/xray_xml_label/"
//                    , "/home/ccnt/chaoyang/chaodewen/data/whole/xray_raw_data/"
//                    , "/home/ccnt/chaoyang/chaodewen/data/whole/VOC_Chaoyang/labeled_data/");

            genOutput("/Users/Cc/Desktop/xray_xml_label/"
                    , "/Users/Cc/Desktop/xray_raw_data/"
                    , "/Users/Cc/Desktop/VOC_Chaoyang/labeled_data/");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
