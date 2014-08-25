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
    
    public static String location;
        
    public void setLocation (String location){
        this.location = location;
    }
    
    public static ListaEnlazada getMetaData (String link){
        ListaEnlazada list = new ListaEnlazada ();
        try {

            InputStream input = new FileInputStream(new File(link));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();
            
            list.agregar(metadata.get("title"),metadata.get("xmpDM:artist"),metadata.get("xmpDM:genre"),metadata.get("xmpDM:album"),metadata.get("xmpDM:trackNumber"),metadata.get("xmpDM:trackNumber"));
            //list.toString();
        } 
        catch (FileNotFoundException e) {
        } 
        catch (IOException e) {
        } 
        catch (SAXException | TikaException e) {
        }
        return list;
    
    }
    public static ListaDoble getAllMetaData (){
        int actual = 0;
        ListaDoble listDirectory = listDirectory();
        ListaDoble dataList = new ListaDoble();
        for (int i = 0; i < listDirectory.LargoLista(); i++){
            dataList.InsFinal(getMetaData(location+ listDirectory.obtenerElementoEnPosicionO(actual)));
            actual++;
        }
        return dataList;
    }
    public static ListaDoble listDirectory (){
        String sDirectorio = location;
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
                    return filename.substring(index + 1);
                }
    }
    
    public void getData (){
        ListaEnlazada x = getAllMetaData().obtenerElementoEnPosicion(0);
        x.obtenerDato1();
        x.obtenerDato2();
        x.obtenerDato3();
        x.obtenerDato4();
        x.obtenerDato5();
        x.obtenerDato6();
        
    }
    
    public int getNumber (String number){
        //String str = "st1-st2-st3";
        int e = 0;
        String delimiter = "";
        String[] temp;
        temp = number.split(delimiter);
        for(int i =0; i != 1 ; i++){
            e = Integer.parseInt(temp[i]);
        }
        return e;
        //System.out.println(temp[i]);
    }
      
}