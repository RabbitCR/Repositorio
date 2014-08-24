package musicbox;

public class ListaEnlazada {
    
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int size;
	
    private class Nodo 
	{
        
        private Object dato1;
        private Object dato2;
        private Object dato3;
        private Object dato4;
        private Object dato5;
        private Object dato6;
        private Nodo siguiente;
        
        public Nodo() 
		{
            this.dato1 = null;
            this.dato2 = null;
            this.dato3 = null;
            this.dato4 = null;
            this.dato5 = null;
            this.dato6 = null;
            this.siguiente = null;
        }
        
        public Nodo(Object inputDato1, Object inputDato2, Object inputDato3, Object inputDato4, Object inputDato5, Object inputDato6) 
		{
            this.dato1 = inputDato1;
            this.dato2 = inputDato2;
            this.dato3 = inputDato3;
            this.dato4 = inputDato4;
            this.dato5 = inputDato5;
            this.dato6 = inputDato6;
            this.siguiente = null;
        }

        public Object obtenerDato1() 
		{
            return dato1.toString();
        }

        public void establecerDato1(Object dato) 
		{
            this.dato1 = dato;
        }
        public Object obtenerDato2() 
		{
            return dato2.toString();
        }

        public void establecerDato2(Object dato) 
		{
            this.dato2 = dato;
        }
        public Object obtenerDato3() 
		{
            return dato3.toString();
        }

        public void establecerDato3(Object dato) 
		{
            this.dato3 = dato;
        }
        public Object obtenerDato4() 
		{
            return dato4.toString();
        }

        public void establecerDato5(Object dato) 
		{
            this.dato5 = dato;
        }
        public Object obtenerDato5() 
		{
            return dato6.toString();
        }
        public void establecerDato6(Object dato) 
		{
            this.dato5 = dato;
        }
        public Object obtenerDato6() 
		{
            return dato6.toString();
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
    public ListaEnlazada() 
	{
        this.primerNodo = null;
        this.ultimoNodo = null;
        this.size = 0;
    }
    
	/**
	 * Construye una lista con base en otra lista
	 * Nota: hacer deep-copy, no shallow copy
	 */
/*	 public ListaEnlazada(ListaDoblementeEnlazada lista)
	 {
	 	//...
	 }*/
	
    /**
     * Construye una lista con base en un arreglo
     * @param arreglo the nodes to start with
     */
    /*public ListaEnlazada(String [] arreglo) 
	{
    	// Se invoca al constructor predeterminado
		this();
    	
        if (arreglo.length > 0) 
		{
            for (int i = 0; i < arreglo.length; i++) {
                this.agregar(arreglo[i]);
            }
        }
    }*/
    
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
        	Object dato1 = nodoActual.obtenerDato1();
                Object dato2 = nodoActual.obtenerDato2();
                Object dato3 = nodoActual.obtenerDato3();
                Object dato4 = nodoActual.obtenerDato4();
                Object dato5 = nodoActual.obtenerDato5();
                Object dato6 = nodoActual.obtenerDato6();
        	
        	resultado.append(dato1 == null ? "" : dato1);
                resultado.append(dato2 == null ? "" : dato2);
                resultado.append(dato3 == null ? "" : dato3);
                resultado.append(dato4 == null ? "" : dato4);
                resultado.append(dato5 == null ? "" : dato5);
                resultado.append(dato6 == null ? "" : dato6);
            nodoActual = nodoActual.obtenerSiguiente();
        }
            System.out.println(resultado.toString());
        return resultado.toString();
    }
    
    /**
     * Agrega un nuevo elemento a la lista
     * @param elemento El elemento a agregar
     */
        
        public void agregar(Object elemento1, Object elemento2, Object elemento3, Object elemento4, Object elemento5, Object elemento6 ) 
	{
       	Nodo nodo = new Nodo(elemento1, elemento2, elemento3, elemento4, elemento5, elemento6);

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
            if (elemento.equals(nodoActual.obtenerDato1())) 
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
    public Object obtenerElementoEnPosicion(int posicion) 
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
        Object result = nodoActual.obtenerDato1().toString() + ";" + nodoActual.obtenerDato2().toString() + ";" + nodoActual.obtenerDato3().toString() + ";"  + nodoActual.obtenerDato4().toString() + ";"  + nodoActual.obtenerDato5().toString() + ";"  + nodoActual.obtenerDato6().toString();
        return result;
    }    
	
    /**
     * Elimina un elemento de la lista
     */
    public void eliminar(Object elemento) 
	{
            Nodo Aux = primerNodo;
            while (Aux.siguiente != null){
                if (Aux.obtenerDato1() == elemento){
                    
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
