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
    
    public ListaEnlazada getMetaData (String link){
        ListaEnlazada list = new ListaEnlazada ();
        try {

            InputStream input = new FileInputStream(new File(link));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();
            
            list.agregar("Title: " + metadata.get("title"), "Artists: " + metadata.get("xmpDM:artist"), "Genre : "+metadata.get("xmpDM:genre"), "Album : "+metadata.get("xmpDM:album"), "Location: " + link, "parseCtx");
        } 
        catch (FileNotFoundException e) {
        } 
        catch (IOException e) {
        } 
        catch (SAXException | TikaException e) {
        }
        return list;
    
    }
    public ListaDoble getAllMetaData (String link){
        int actual = 0;
        ListaDoble listDirectory = listDirectory(link);
        ListaDoble dataList = new ListaDoble();
        for (int i = 0; i < listDirectory.LargoLista(); i++){
            dataList.InsFinal(getMetaData(link + listDirectory.obtenerElementoEnPosicionO(actual)));
            actual++;
        }
        return dataList;
    }
    public ListaDoble listDirectory (String link){
        String sDirectorio = link;
        ListaDoble listFiles = new ListaDoble();
        File f = new File(sDirectorio);
    
        if (f.exists()){ 
            File[] ficheros = f.listFiles();
            for (int x=0; x < ficheros.length; x++){
                listFiles.InsFinalO(ficheros[x].getName());
                //System.out.println(ficheros[x].getName());
                
            }
        }
        else {
            System.out.println("Invalid Directory");
        }
        //listFiles.Imprimir();
        return filtrarElementos(listFiles);
    }
    
    public static ListaDoble filtrarElementos (ListaDoble list){
        int actual = 0;
        ListaDoble tracks = new ListaDoble();
        ListaDoble folders = new ListaDoble();
        for (int i = 0; i < list.LargoLista(); i++){
            //System.out.println("1");
            if (getExtensionFile(list.obtenerElementoEnPosicionO(actual).toString()).equals("mp3")){
                //System.out.println("1");
                tracks.InsFinalO(list.obtenerElementoEnPosicionO(actual));
            }
            else{
                //System.out.println("0");
                folders.InsFinalO(list.obtenerElementoEnPosicionO(actual));
            }
            actual++;
        }
        return tracks;
    }
      
    public static String getExtensionFile(String filename) {
                int index = filename.lastIndexOf('.');
                if (index == -1) {
                    return "";
                } 
                else {
                    //System.out.println(filename.substring(index + 1));
                    return filename.substring(index + 1);
                }
    }  
}