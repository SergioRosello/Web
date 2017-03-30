package code;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class TablonDeAnuncios {

    public TablonDeAnuncios(String nombre, String asunto, String descripcion) {
		super();
		Nombre = nombre;
		Asunto = asunto;
		Descripcion = descripcion;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String Nombre;
    private String Asunto;
    private String Descripcion;
    
    public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getAsunto() {
		return Asunto;
	}
	public void setAsunto(String asunto) {
		Asunto = asunto;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

}