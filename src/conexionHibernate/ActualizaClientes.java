package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientes {
	public static void main(String []args) {

		//CREAMOS OBJ SESSIONFACTORY PARA QUE LEA EL ARCHIVO DE CONFIGURACI�N Y SEA CAPAZ DE CONSTRUIR UN SESSIONFACTORY. 
		//CONFIGURE(): PARA LEER ARCHIVO DE CONFIGURACION.(INDICAMOS EL ARCHIVO DE CONFIG QUE LEA)
		//addAnnotatedClass():INDICAMOS LA CLASE CON LA QUE VAMOS A TRABAJAR.
		//buildSessionFactory():INDICAMOS QUE COSNTRUYA ESTE SESSION FACTORY.
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();	
	
		
		//CREAR OBJ DE TIPO SESSION.
		//miFactory.openSession(): ABRIMOS LA SESSION.
		Session miSession = miFactory.openSession();
		
		
		try {
			
			//int clienteId: ESTA VARIABLE DETERMINAR� EL CLIENTE QUE SE MODIFICAR�.
			//beginTransaction(): EJECUTAR TRANSACCI�N.
			//getTransaction().commit(): RESCATAMOS LA TRANSACCI�N QUE HEMOS HECHO, Y CON COMMIT() FIJAMOS LA OPERACI�N.  
			//Clientes miCliente: CREAMOS UN OBJ DE TIPO CLIENTES, PARA ALMACENAR LA INFORMACI�N COMPLETA, SEG�N "clienteId".
			//MODIFICAMOS LA INFORMACI�N SEG�N EL SETTER CORRESPONDIENTE. 
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
