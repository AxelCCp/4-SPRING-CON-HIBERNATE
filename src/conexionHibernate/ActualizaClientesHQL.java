package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizaClientesHQL {
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
			
			//beginTransaction(): EJECUTAR TRANSACCI�N.
			//getTransaction().commit(): RESCATAMOS LA TRANSACCI�N QUE HEMOS HECHO, Y CON COMMIT() FIJAMOS LA OPERACI�N.  
			//USAMOS LENGUAJE HQL PARA MODIFICAR CAMPO NOMBRE, CAMBIAR A LISA, LOS NOMBRE QUE EMPIECEN CON "T".
			miSession.beginTransaction();
			miSession.createQuery("update Clientes set Nombre='Lisa' where Nombre LIKE 'T%'").executeUpdate();
			miSession.getTransaction().commit();
			System.out.println("REGISTROS *** ACTUALIZADOS *** CORRECTAMENTE");
			miSession.close();
			
		}finally{
			miFactory.close();
		}
		
		
		
		
	}

}
