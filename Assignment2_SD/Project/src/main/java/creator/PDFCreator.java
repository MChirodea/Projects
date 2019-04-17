package creator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import creator.IFileCreator;
import model.Report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class PDFCreator implements IFileCreator {
    @Override
    public void createFile(String path, List<Report> reps) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(new File(path +"/reports.pdf")));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        for(Report rep : reps){
            Chunk chunk = new Chunk("User ID: "+rep.getUid().getId() +", Drug bought: " +rep.getDrug() +", Amount: "+rep.getAmount(), font);
            document.add(chunk);
        }
        document.close();
    }
}
