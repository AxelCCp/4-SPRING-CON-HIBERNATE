package conexionHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardaClientePrueba {
	public static void main(String []args) {
		
		//PASO 1:
		//CREAMOS OBJ SESSIONFACTORY PARA QUE LEA EL ARCHIVO DE CONFIGURACIÓN Y SEA CAPAZ DE CONSTRUIR UN SESSIONFACTORY. 
		//CONFIGURE(): PARA LEER ARCHIVO DE CONFIGURACION.(INDICAMOS EL ARCHIVO DE CONFIG QUE LEA)
		//addAnnotatedClass():INDICAMOS LA CLASE CON LA QUE VAMOS A TRABAJAR.
		//buildSessionFactory():INDICAMOS QUE COSNTRUYA ESTE SESSION FACTORY.
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();	
	
		
		//PASO 2:
		//CREAR OBJ DE TIPO SESSION.
		//miFactory.openSession(): ABRIMOS LA SESSION.
		
		Session miSession = miFactory.openSession();
		
		
		try {
			//PASO 3:
			//CREAMOS OBJ DE TIPO CLIENTES.
			Clientes cliente1 = new Clientes("Julia","Ann", "xxxxxxx n°123");
			
			//PASO 4:
			//beginTransaction(): EJECUTAR TRANSACCIÓN.
			//save(cliente1): LA TRANSACCIÓN GUARDA AL OBJ CLIENTES EN LA BBDD.
			//getTransaction().commit(): RESCATAMOS LA TRANSACCIÓN QUE HEMOS HECHO, Y CON COMMIT() FIJAMOS LA OPERACIÓN.  
			miSession.beginTransaction();
			miSession.save(cliente1);
			miSession.getTransaction().commit();
			System.out.println("REGISTRO INSERTADO CORRECTAMENTE");
			
			
			//CLASE 50 / LECTURA DE REGISTRO
			miSession.beginTransaction();
			System.out.println("Lectura del registro con Id: " + cliente1.getId());
			
			Clientes clienteInsertado = miSession.get(Clientes.class, cliente1.getId());
			
			System.out.println("Registro: " + clienteInsertado);
			
			miSession.getTransaction().commit();
			
			System.out.println("Terminado");
			
			miSession.close();
			
		}finally{
			miFactory.close();
		}
		
		
		
		
	}

}
