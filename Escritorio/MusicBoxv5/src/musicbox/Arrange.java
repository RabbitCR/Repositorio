package musicbox;

import static musicbox.GetMetaData.getAllMetaData;
import static musicbox.GetMetaData.location;
import static musicbox.MusicBox.song;

public class Arrange {
    ListaDoble listD = new ListaDoble();
    ListaDoble listD1 = new ListaDoble();
    ListaEnlazada listS = new ListaEnlazada();
    int actual;
    
    public void bySong(){
        actual = 0;
        listD = getAllMetaData();
        for (int i = 0; i < listD.LargoLista(); i++){
            listD1.InsFinalO(listD.obtenerElementoEnPosicion(actual));
            actual++;
        }
    }
    
    //FALTA IMPLEMENTAR
    /*public void byArtist(){
        ListaDoble comp1 = new ListaDoble();
        ListaDoble comp2 = new ListaDoble();
        actual = 0;
        listD = getAllMetaData();
        for (int i = 0; i < listD.LargoLista(); i++){
            if (listD.obtenerElementoEnPosicion(actual).obtenerDato2().equals(listD.obtenerElementoEnPosicion(actual + 1).obtenerDato2())){
                listD1.InsFinalO(listD.obtenerElementoEnPosicion(actual).obtenerDato1());
            }
            
        }
    }*/
}
