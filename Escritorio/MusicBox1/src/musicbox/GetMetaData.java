package musicbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetMetaData {
    
    public void getMetaData (String songLocation){

        String fileLocation = songLocation;
        ArrayList infoList = new ArrayList();

        try {

            InputStream input = new FileInputStream(new File(fileLocation));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            infoList.add("Title: " + metadata.get("title"));
            infoList.add("Artists: " + metadata.get("xmpDM:artist"));
            infoList.add("Composer : "+metadata.get("xmpDM:composer"));
            infoList.add("Genre : "+metadata.get("xmpDM:genre"));
            infoList.add("Album : "+metadata.get("xmpDM:album"));
            infoList.toString();

        } 
        catch (FileNotFoundException e) {
        } 
        catch (IOException e) {
        } 
        catch (SAXException | TikaException e) {
        }
    
}
}
