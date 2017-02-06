package clases;

public class Libro {
	private Integer idlibro;
	private String titulo;
	private String autor;

	
	public Libro (){}
	public Libro (int num, String tit, String autr) {
		this.idlibro = num;
		this.titulo = tit;
		this.autor = autr;
	}

	public void setNumero_id(int numero_id) {
		this.idlibro = numero_id;
	}
	public Integer getNumero_id() {
		return idlibro;
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
