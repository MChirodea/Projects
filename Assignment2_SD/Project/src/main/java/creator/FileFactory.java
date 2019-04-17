package creator;


public class FileFactory {

    public static IFileCreator getCreator(String type){
        if(type.equals("PDF Type")){
          return new PDFCreator();
        }else{
           return new TXTCreator();
        }
    }
}
