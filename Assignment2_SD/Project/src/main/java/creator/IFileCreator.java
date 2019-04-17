package creator;

import com.itextpdf.text.DocumentException;
import model.Report;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IFileCreator {
    void createFile(String path, List<Report> reps) throws DocumentException, FileNotFoundException, UnsupportedEncodingException;
}
