import generators.QRCode;
import generators.QRCodeGenerator;
import view.QRCodeGeneratorView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        String data = "https://www.youtube.com/@SpidermanMitosisTheGame/videos";
//        String filePath = "/Users/mustafagoktugibolar/Documents/ibolar/medcezirQR.jpg";

//        if(QRCodeGenerator.generate(QRCode.createQR(data, filePath))){
//            System.out.println("Process Successful!");
//        }

        //System.out.println(QRCodeGenerator.generate(QRCode.createQR(data, filePath)) ? "Process Successful!" : "Error Occurred!");
        SwingUtilities.invokeLater(() -> new QRCodeGeneratorView().setVisible(true));
    }
}
