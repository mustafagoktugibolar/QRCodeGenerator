package generators;

public class QRCode {
    private String data;
    private String uniqueID;
    private String filePath;
    private static final int fileSize = 300;

    private QRCode(String data, String filePath) {
        this.data = data;
        this.uniqueID = IDGenerator.generate();
        this.filePath = filePath;
    }

    public String getData() {
        return data;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String getFilePath() {
        return filePath;
    }

    public static QRCode createQR(String data, String filePath){
        return new QRCode(data, filePath);
    }

}
