package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {
	public static void main(String []args) {

		//CREAMOS OBJ SESSIONFACTORY PARA QUE LEA EL ARCHIVO DE CONFIGURACIÓN Y SEA CAPAZ DE CONSTRUIR UN SESSIONFACTORY. 
		//CONFIGURE(): PARA LEER ARCHIVO DE CONFIGURACION.(INDICAMOS EL ARCHIVO DE CONFIG QUE LEA)
		//addAnnotatedClass():INDICAMOS LA CLASE CON LA QUE VAMOS A TRABAJAR.
		//buildSessionFactory():INDICAMOS QUE COSNTRUYA ESTE SESSION FACTORY.
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();	
	
		
		//CREAR OBJ DE TIPO SESSION.
		//miFactory.openSession(): ABRIMOS LA SESSION.
		Session miSession = miFactory.openSession();
		
		
		try {
			
			//int clienteId: ESTA VARIABLE DETERMINARÁ EL CLIENTE QUE SE MODIFICARÁ.
			//beginTransaction(): EJECUTAR TRANSACCIÓN.
			//getTransaction().commit(): RESCATAMOS LA TRANSACCIÓN QUE HEMOS HECHO, Y CON COMMIT() FIJAMOS LA OPERACIÓN.  
			//Clientes miCliente: CREAMOS UN OBJ DE TIPO CLIENTES, PARA ALMACENAR LA INFORMACIÓN COMPLETA, SEGÚN "clienteId".
			//MODIFICAMOS LA INFORMACIÓN SEGÚN EL SETTER CORRESPONDIENTE. 
			int clienteId=1;
			miSession.beginTransaction();
			Clientes miCliente = miSession.get(Clientes.class, clienteId);
			miCliente.setNombre("Tasha");
			miCliente.setApellidos("Reign");
			miSession.getTransaction().commit();
			System.out.println("REGISTRO *** ACTUALIZADO *** CORRECTAMENTE");
			
			
			
			
			miSession.close();
			
		}finally{
			miFactory.close();
		}
		
		
		
		
	}

}
