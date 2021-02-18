package conexionHibernate;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {
	public static void main(String[]args) {
		
		SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Clientes.class).buildSessionFactory();	
		Session miSession = miFactory.openSession();
		
		
		try {
			
			//COMENZAR SESIÓN
			miSession.beginTransaction();
			
			//CONSULTA DE CLIENTES
			//List<Clientes> losClientes: LA INFORMACIÓN DE LA QUERY SE ALMACENA EN ESTA LISTA.
			//createQuery(): REALIZAMOS LA CONSULTA.
			//getResultList():PARA OBTENER LA INFORMACIÓN QUE SE CONSIGUE CON createQuery(). 
			List<Clientes> losClientes = miSession.createQuery("from Clientes").getResultList();
			//MOSTRAR CLIENTES
			for(Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}
			//---------------------------------
			
			
			//CONSULTA...DAME LOS ANN
			//cl: ES UN ALIAS PARA LUEGO USAR where.
			//apellidos: (con minúscula) es la propiedad de la clase Clientes 
			losClientes = miSession.createQuery("from Clientes cl where cl.apellidos='Ann'").getResultList();
			for(Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}
			//--------------------
			
			
			
			//CONSULTA...DAME LOS QUE VIVEN EN "xxxxx n°2345" Ó SE APELLIDAN "Ann"
			losClientes = miSession.createQuery("from Clientes cl where cl.apellidos='Ann' or cl.direccion='xxxxx n°2345'").getResultList();
			
			for(Clientes unCliente : losClientes) {
				System.out.println(unCliente);
			}
			//--------------------
			
			
			//COMMIT
			miSession.getTransaction().commit();
			
			miSession.close();

			
		}finally {
			miFactory.close();
			
		}
	}
}
