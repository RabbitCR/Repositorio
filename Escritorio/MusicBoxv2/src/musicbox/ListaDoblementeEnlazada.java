package musicbox;

public class ListaDoblementeEnlazada {
    
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int size;
	
    private class Nodo 
	{
        
        private String dato;
        private Nodo siguiente;
        //private Nodo anterior;
        
        public Nodo() 
		{
            this.dato = null;
            this.siguiente = null;
            //this.anterior = null;
        }
        
        public Nodo(String inputDato) 
		{
            this.dato = inputDato;
            this.siguiente = null;
            //this.anterior;
        }

        public String obtenerDato() 
		{
            return dato;
        }

        public void establecerDato(String dato) 
		{
            this.dato = dato;
        }

        public Nodo obtenerSiguiente() 
		{
            return siguiente;
        }

        public void establecerSiguiente(Nodo siguiente) 
		{
            this.siguiente = siguiente;
        }
    }
    
	// Métodos
	
    /**
     * Constructor predeterminado
     */
    public ListaDoblementeEnlazada() 
	{
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.size = 0;
    }
    
	/**
	 * Construye una lista con base en otra lista
	 * Nota: hacer deep-copy, no shallow copy
	 */
	 public ListaDoblementeEnlazada(ListaDoblementeEnlazada lista)
	 {
	 	//...
	 }
	
    /**
     * Construye una lista con base en un arreglo
     * @param arreglo the nodes to start with
     */
    public ListaDoblementeEnlazada(String [] arreglo) 
	{
    	// Se invoca al constructor predeterminado
		this();
    	
        if (arreglo.length > 0) 
		{
            for (int i = 0; i < arreglo.length; i++) {
                this.agregar(arreglo[i]);
            }
        }
    }
    
    /**
     * Devuelve la representación en string de la lista
     */
    public String toString()
	{
        Nodo nodoActual = this.primerNodo;
        
        StringBuffer resultado = new StringBuffer();
        
        for (int i = 0; nodoActual != null; i++) 
		{
        	if (i > 0) 
			{
        		resultado.append(",");
        	}
        	Object dato = nodoActual.obtenerDato();
        	
        	resultado.append(dato == null ? "" : dato);
            nodoActual = nodoActual.obtenerSiguiente();
        }
            System.out.println(resultado.toString());
        return resultado.toString();
    }
    
    /**
     * Agrega un nuevo elemento a la lista
     * @param elemento El elemento a agregar
     */
    public void agregar(String elemento) 
	{
       	Nodo nodo = new Nodo(elemento);

		// caso de lista vacía
		if (this.primerNodo == null) 
		{ 
			this.primerNodo = nodo;
			this.ultimoNodo = nodo;
		}
		else 
		{
			this.ultimoNodo.establecerSiguiente(nodo);
			this.ultimoNodo = nodo;
		}

		this.size++;
    }

    /**
     * Devuelve la posición de un elemento (en caso de encontrarlo)
     */
    public int obtenerIndice(Object elemento) 
	{
        Nodo nodoActual = this.primerNodo;
        int posicion = 0;
        boolean encontrado = false;
        
        for (; ; posicion++) 
		{
            if (nodoActual == null) 
			{           
                break;
            }
            if (elemento.equals(nodoActual.obtenerDato())) 
			{
            	encontrado = true;
                break;
            }
            nodoActual = nodoActual.obtenerSiguiente();
        }
        if (!encontrado) 
		{
        	posicion = -1;
        }
        System.out.println(posicion);
        return posicion;
    }
    
    /**
     * Devuelve el tamaño de la lista
     * @return Número de elementos de la lista
     */
    public int size() 
	{
        //System.out.println(this.size);
    	return this.size;
    }

    /**
     * Obtiene el elemento que está en la posición especificada por el parámetro
     * @param posicion Posición del elemento
     * @return Elemento en la posición especificada
     */
    public String obtenerElementoEnPosicion(int posicion) 
	{
    	if (posicion >= this.size || posicion < 0) 
		{
                //System.out.println(false);
    		return null;
    	}
    	Nodo nodoActual = this.primerNodo;
        for (int i = 0; i < posicion ; i++) 
		{
            nodoActual = nodoActual.obtenerSiguiente();
        }
            //System.out.println(nodoActual.obtenerDato());
        return nodoActual.obtenerDato();
    }
    
	
    /**
     * Elimina un elemento de la lista
     */
    public void eliminar(Object elemento) 
	{
            Nodo Aux = primerNodo;
            while (Aux.siguiente != null){
                if (Aux.obtenerDato() == elemento){
                    
                }
                Aux = Aux.siguiente;
                //System.out.print(Aux.obtenerDato());
                
            }

                
        // Tarea: implementar
    }
	
    /**
     * Elimina todos los elementos de la lista
     */
	public void vaciar(){
		// implementar
	}


    
}
