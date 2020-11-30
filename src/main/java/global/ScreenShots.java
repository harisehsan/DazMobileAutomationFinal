//package global;
//
//import com.google.common.io.Files;
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.Tesseract1;
//import net.sourceforge.tess4j.TesseractException;
//import net.sourceforge.tess4j.util.LoadLibs;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import sun.applet.Main;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ScreenShots {
//    public Drivers drv = new Drivers();
//
//    public String CreateScreenshotDirectory(String driName) throws IOException {
//        String Time = driName+ LocalDateTime.now().toString().replaceAll("[^A-Za-z0-9]","-");
//        File theDir = new File("./ReadScreenShots/" +Time);
//        if (!theDir.exists()) theDir.mkdirs();
//        return  theDir.getCanonicalPath();
//    }
//
////    public String CaptureScreenshotAndSave(String Path, Integer loopCount) throws IOException {
////        File targetFile = null;
////        for (int i = 0; i <= loopCount; i++) {
////            try {
////                File rawData = ((TakesScreenshot) drv.getDriver()).getScreenshotAs(OutputType.FILE);
////                targetFile =new File(Path +"/"+"Screenshot"+i+".png");
////                Files.copy(rawData,targetFile);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////        assert targetFile != null;
////        return targetFile.getCanonicalPath();
////    }
//
//    public List<String> CaptureScreenshotAndSaveList(String Path, Integer loopCount) throws IOException {
//        File targetFile = null;
//        List<String> stringArray = new ArrayList<>();
//
//        for (int i = 0; i <= loopCount; i++) {
//            try {
//                File rawData = ((TakesScreenshot) drv.getDriver()).getScreenshotAs(OutputType.FILE);
//                targetFile =new File(Path +"/"+"Screenshot"+i+".png");
//                Files.copy(rawData,targetFile);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            assert targetFile != null;
//            stringArray.add(targetFile.getCanonicalPath());
//        }
//        return stringArray;
//    }
//
//    public String ORC(List<String> filepath) throws URISyntaxException, IOException, TesseractException {
////        String textInImage = "";
////        System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/win32-x86" : "lib/win32-x86-64");
////        for (String s: filepath) {
////            File imageFile = new File(s);
////            ITesseract instance = new Tesseract();  // JNA Interface Mapping
//////             ITesseract instance = new Tesseract1(); // JNA Direct Mapping
////             File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Maven build bundles English data
////             instance.setDatapath(tessDataFolder.getPath());
////
////            try {
////                textInImage = instance.doOCR(imageFile);
////                System.out.println(textInImage);
////            } catch (TesseractException e) {
////                System.err.println(e.getMessage());
////            }
////        }
//
////        Approch 2 ::::::::
//        File tmpFolder = LoadLibs.extractTessResources("win32-x86-64");
//        System.setProperty("java.library.path", tmpFolder.getPath());
//        String textInImage = "";
//        Tesseract tesseract = new Tesseract();
//        tesseract.setLanguage("eng");
//        tesseract.setOcrEngineMode(1);
//        Path dataDirectory1 = Paths.get(ClassLoader.getSystemResource("tessdata").toURI());
//        System.out.println("This is the path ::::::::----------->>>>>> " + dataDirectory1);
//        System.out.println("This is the path ::::::::----------->>>>>> " + dataDirectory1.toString());
//        System.out.println("This is the path ::::::::----------->>>>>> " + dataDirectory1.toAbsolutePath());
//        tesseract.setDatapath("D:\\Automation\\DarazMobileAutomationTwo\\tessdata");
//        for (String s: filepath) {
//            BufferedImage images = ImageIO.read(Main.class.getResourceAsStream(s));
//            textInImage = tesseract.doOCR(images);
//            System.out.println(textInImage);
//        }
//
////        Approch 1 ::::::::
////        for (String s : filepath) {
////            System.out.println("THiS is the file Path ::::::::::::::::::: >>>>>>>>> ?????????? " + s);
////        }
////        String textInImage = "";
////        for(String ab : filepath) {
////            File imageFile = new File(ab);
////            ITesseract iTesseract = new Tesseract();  // JNA Interface Mapping
////            try {
////                textInImage = iTesseract.doOCR(imageFile);
////                System.out.println(textInImage);
////            } catch (Exception e) {
////                System.err.println(e.getCause());
////                System.out.println(e.getStackTrace());
////                System.out.println(e.getMessage());
////            }
////        }
//        System.out.println(" ----------------------- >>>>>>>>>>>>>>>>> ------------ " + textInImage );
//        return textInImage;
//    }
//
//    public String CaptureScreenshotsAfterEvent(Integer loopCount) throws IOException {
//        File targetFile = null;
//        for (int i = 0; i <= loopCount; i++) {
//            try {
//                File file = ((TakesScreenshot) drv.getDriver()).getScreenshotAs(OutputType.FILE);
//                targetFile =new File("OnEventCapture" +"/"+"Screenshot"+i+".jpg");
//                Files.copy(file,targetFile);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        assert targetFile != null;
//        return targetFile.toString();
//    }
//
//
//}
//
