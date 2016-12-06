package clases;

public class Libro {
	private Integer numero_id;
	private String titulo;
	private String autor;

	
	public Libro (){}
	public Libro (int num, String tit, String autr) {
		this.numero_id = num;
		this.titulo = tit;
		this.autor = autr;
	}

	public void setNumero_id(int numero_id) {
		this.numero_id = numero_id;
	}
	public Integer getNumero_id() {
		return numero_id;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
}
