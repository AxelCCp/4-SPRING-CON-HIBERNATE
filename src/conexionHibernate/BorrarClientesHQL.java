package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BorrarClientesHQL {
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
			
			//beginTransaction(): EJECUTAR TRANSACCIÓN.
			//getTransaction().commit(): RESCATAMOS LA TRANSACCIÓN QUE HEMOS HECHO, Y CON COMMIT() FIJAMOS LA OPERACIÓN.  
			//USAMOS LENGUAJE HQL PARA MODIFICAR CAMPO NOMBRE, CAMBIAR A LISA, LOS NOMBRE QUE EMPIECEN CON "T".
			miSession.beginTransaction();
			miSession.createQuery("delete Clientes where Apellidos LIKE 'R%'").executeUpdate();
			miSession.getTransaction().commit();
			System.out.println("REGISTROS *** ELIMINADOS *** CORRECTAMENTE");
			miSession.close();
			
		}finally{
			miFactory.close();
		}
		
		
		
		
	}

}
