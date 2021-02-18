package conexionHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//HIBERNATE MAPEARÁ LAS PROPIEDADES DE EST CLASE Y PARA ESTO SE USARÁN LAS ANOTACIONES.

@Entity //PARA MAPEO DE CLASE A TABLA, HIBERNATE TRANSFORMA LAS CLASES EN ENTIDADES, PARA MAPEAR.
@Table(name="clientes") //REFERENCIA A LA TABLA A LA QUE NOS REFERIMOS.
public class Clientes {

	
	//HACEMOS QUE LA CLASE SEA CAPAZ DE CREAR OBJ'S DE TIPO CLIENTE, PARA ESTO SE USAN:
			//2 CONSTRUCTORES.
			//GETTERS Y SETTERS 
	
	public Clientes() {
	}
		
	public Clientes(String nombre, String apellidos, String direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	//MÉTODO TO STRING, PARA LEER LA INFORMACIÓN CUANDO SE HAGA UNA BÚSQUEDA , ACTUALIZACION , ETC.
	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion
				+ "]";
	}
	

	//@Id:campo clave.
	//@GeneratedValue:LE DECIMOS QUE ES EL CAMPO PRINCIPAL, PARA QUE RECONOZCA EL ID DEL CLIENTE EN LA TABLA.
	//@Column:PARA MAPEO DE LAS COLUMNAS DE LA TABLA
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="Nombre")
	private String nombre;
	@Column(name="Apellidos")
	private String apellidos;
	@Column(name="Direccion")
	private String direccion;
}

