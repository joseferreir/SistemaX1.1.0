package br.edu.ifpb.sistemax.entidades;

/**
 * Interface que deve ser implementada por qualquer objeto que deseja adicionar
 * observadores para seus eventos. Observadores, por sua vez, devem implementar
 * {@link Observer}
 * 
 * @author diogo.moreira
 * @see Observer
 */
public interface Observable<T> {
	
	/**
	 * Método para adicionar um novo observador
	 * @param newObserver
	 */
	void addObserver(Observer newObserver);
	
	/**
	 * Método para remover um observador
	 * @param observer
	 */
	void removeObserver(Observer observer);
	
	void notifyObservers(T object,String responsavelPorExSala);

}
