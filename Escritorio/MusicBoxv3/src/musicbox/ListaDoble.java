package musicbox;

class NodoLista{
	ListaEnlazada dato;
        Object datoO;
	NodoLista siguiente;
	NodoLista anterior;
	
	NodoLista(ListaEnlazada valor){
		dato = valor;
		siguiente = null;
		anterior = null;
	}
	
	NodoLista(ListaEnlazada valor,NodoLista signodo){
		dato = valor;
		siguiente = signodo;
	}
        NodoLista(Object valor){
		datoO = valor;
		siguiente = null;
		anterior = null;
	}
	
	NodoLista(Object valor,NodoLista signodo){
		datoO = valor;
		siguiente = signodo;
	}
}

public class ListaDoble {


public NodoLista primero;

	public boolean VaciaLista(){ return primero == null;}
	
	public void Imprimir()
        { if (VaciaLista())
        {
         System.out.println( "vacia" );
        }
        //fin del primer if
        else
        {
                  System.out.print( "La  " +"  es:  ");
          NodoLista Actual = primero;

         while (Actual != null)
                 {
          System.out.print (Actual.dato.toString() + " ");
          Actual=Actual.siguiente;
         }

         System.out.println();
         System.out.println();
        }
        }
	
	public void ImprimirCircular(){
		if(VaciaLista())
		{
			System.out.println("Vacía");
			
		}
		
		else{
			
			NodoLista actual = primero;
			System.out.println(actual.dato.toString());
			actual = actual.siguiente;
			
			while(actual!= primero){
				System.out.println(actual.dato.toString());
				actual = actual.siguiente;
			}
			
		}
		
	}
	
	public void InsInicio(ListaEnlazada EI){
		if (VaciaLista()){
			primero = new NodoLista(EI);
			primero.anterior = null;
		}
		
		else{
			NodoLista nuevo = new NodoLista(EI,primero);
			primero.anterior = nuevo;
			primero = nuevo;
		}
	}
	
	public void InsInicioC(ListaEnlazada EI){
		if(VaciaLista()){
			primero = new NodoLista(EI);
			primero.siguiente = primero;
			primero.anterior = primero;
			
		}
		else{
			NodoLista nuevo = new NodoLista(EI);
			nuevo.siguiente.anterior = nuevo;
			nuevo.anterior = primero.anterior;
			primero.anterior = nuevo;
			primero = nuevo;
		}
	}
	
	public void InsFinalC(ListaEnlazada EI){
		if(VaciaLista()){
			primero = new NodoLista(EI);
			primero.siguiente = primero;
			primero.anterior = primero;
			}
		else{
			NodoLista nuevo = new NodoLista(EI);
			nuevo.anterior = primero.anterior;
			nuevo.siguiente = primero.anterior.siguiente;
			primero.anterior.siguiente = nuevo;
			primero.anterior = nuevo;
		}
	}
	
	public void InsFinal(ListaEnlazada EI){
		if (VaciaLista()){
			primero = new NodoLista(EI);
			primero.anterior = null;
		}
		else{
			NodoLista aux = primero;
			while(aux.siguiente != null){
				aux = aux.siguiente;
			}
			aux.siguiente = new NodoLista(EI);
			aux.siguiente.anterior = aux;
		}
	}
        
        public void InsFinalO(Object EI){
		if (VaciaLista()){
			primero = new NodoLista(EI);
			primero.anterior = null;
		}
		else{
			NodoLista aux = primero;
			while(aux.siguiente != null){
				aux = aux.siguiente;
			}
			aux.siguiente = new NodoLista(EI);
			aux.siguiente.anterior = aux;
		}
	}
	
	public void InsPos(int EI, int pos){
		if(VaciaLista())
			primero = new NodoLista(EI);
		else{
			if(pos<=1){
				NodoLista nuevo = new NodoLista(EI);
				nuevo.siguiente = primero;
				primero = nuevo;
				primero.siguiente.anterior = primero;
			}
			else{
				NodoLista aux = primero;
				int i = 2;
				while((i!=pos)&&(aux.siguiente != null)){
					i++;
					aux = aux.siguiente;
				}
				NodoLista nuevo = new NodoLista(EI);
				nuevo.siguiente = aux.siguiente;
				aux.siguiente = nuevo;
				nuevo.anterior = aux;
				
			}
		}
	}
	
	public void EliInicio(){
		if (VaciaLista())
			System.out.println("No hay elementos");
		else{
			if(primero.siguiente == null)
				primero = null;
			else{
				primero = primero.siguiente;
				primero.anterior = null;
			}
		}
		
	}
	
	public void EliInicioC(){
		if(VaciaLista()){
			System.out.println("No hay elementos");
		}
		else{
			if(primero.siguiente == primero)
				primero = null;
			else{
				primero.siguiente = primero.anterior;
				primero.anterior.siguiente = primero.siguiente;
				primero = primero.siguiente;
			}
		}
	}
	
	public void EliFinal(){
		if(VaciaLista())
			System.out.println("No hay elementos");
		else{
			if(primero.siguiente == null)
				primero = null;
			else{
				NodoLista actual = primero;
				while(actual.siguiente!=null){
					actual = actual.siguiente;
				}
				actual.anterior.siguiente = null;
			}
		}
	}
	
	public void EliFinalC(){
		if(VaciaLista()){
			System.out.println("No hay elementos");
		}
		else{
			if(primero.siguiente == primero)
				primero = null;
			else{
				primero.anterior = primero.anterior.anterior;
				primero.anterior.siguiente = primero;
			}
		}
	}
	
	public void EliPos(int pos){
		if(VaciaLista())
			System.out.println("No hay elementos");
		else{
			
			NodoLista actual = primero;
			int i = 1;
			while((1!=pos)&&(actual.siguiente != null)){
				i++;
				actual = actual.siguiente;
			}
			if(pos==1)
				EliInicio();
			else{
				if(i == pos){
					actual.anterior.siguiente = actual.siguiente;
					actual.siguiente.anterior = actual.anterior;
				}
			}
		}
	}
	
	public void Invertir(){
		NodoLista sig = primero;
		NodoLista ant = null;
		while(!(VaciaLista())){
			sig = primero.siguiente;
			primero.siguiente = ant;
			ant = primero;
			primero = sig;
			
			}
		primero = ant;
	}
	
	public int LargoLista()
	{
		int i = 0;
		if (VaciaLista())
			return i;
		else
		{
			NodoLista aux = primero;
			i++;
			aux = aux.siguiente;
			while(aux!=null)
			{
				i++;
				aux = aux.siguiente;
				
			}
			
		 
		}
		//System.out.println(i);
		
		return i;
		
		
	}
        public ListaEnlazada obtenerElementoEnPosicion(int posicion) 
	{
    	if (posicion >= this.LargoLista() || posicion < 0) 
		{
                //System.out.println(false);
    		return null;
    	}
    	NodoLista nodoActual = this.primero;
        for (int i = 0; i < posicion ; i++) 
		{
            nodoActual = nodoActual.siguiente;
        }
            //System.out.println(nodoActual.obtenerDato());
        ListaEnlazada result = nodoActual.dato;
        return result;
    }
    public Object obtenerElementoEnPosicionO(int posicion) 
	{
    	if (posicion >= this.LargoLista() || posicion < 0) 
		{
                //System.out.println(false);
    		return null;
    	}
    	NodoLista nodoActual = this.primero;
        for (int i = 0; i < posicion ; i++) 
		{
            nodoActual = nodoActual.siguiente;
        }
            //System.out.println(nodoActual.obtenerDato());
        ListaEnlazada result = nodoActual.dato;
        return result;
    }    
}