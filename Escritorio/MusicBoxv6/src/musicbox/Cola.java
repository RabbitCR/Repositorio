package musicbox;

public class Cola {
    private ListaDoble Cola = new ListaDoble();
    
    public int getSize() {
        return this.Cola.LargoLista();
    }
    
    public void encolar(ListaEnlazada list) {
        this.Cola.InsFinal(list);
    }
    
    public void desencolar() {
        this.Cola.EliInicio();
    }
    
    public ListaEnlazada obtenerPrimero() {
        return this.Cola.obtenerElementoEnPosicion(0);
    }
    
    public boolean empty () {
        return this.Cola.VaciaLista();
    }
}
