package generators;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.IOException;
import java.nio.file.Paths;

public class QRCodeGenerator {
    public static boolean generate(QRCode qrCode){
        try{
            //Put the QR Code Into a BitMatrix
            BitMatrix matrix = new MultiFormatWriter()
                    .encode(qrCode.getData(), BarcodeFormat.QR_CODE, 500, 500);

            //Convert Matrix to A Image File
            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(qrCode.getFilePath()));
            return true;

        }catch(WriterException | IOException e){
            e.printStackTrace();
            return false;
        }
    }
}