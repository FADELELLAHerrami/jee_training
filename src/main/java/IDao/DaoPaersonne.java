package IDao;

public interface DaoPaersonne<T> {
	T save(T obj);
	Boolean existPersonne(int id);
	T update(int id, String nom, String prenom);
}
