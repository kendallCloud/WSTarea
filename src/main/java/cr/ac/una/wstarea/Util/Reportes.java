/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.wstarea.Util;

import cr.ac.una.wstarea.WSTarea;
import jakarta.annotation.Resource;
import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
/**
 *
 * @author Farlen
 */
public class Reportes {
//    private static final Logger LOG = Logger.getLogger(MarcaService.class.getName());
   
    private final EntityManager em = EntityManagerHelper.getManager();
   public String generarReporteEmpleados() {
       
        try{
            
String root = System.getProperty("user.dir"); 
String filepath = "/reportes/prueba.jrxml"; // in case of Windows: "\\path \\to\\yourfile.txt 
String abspath = root+filepath;

      HashMap parametro = new HashMap();
      String fileName= this.getClass().getPackageName();
      Connection c =  em.unwrap(java.sql.Connection.class);
      parametro.put("","");
//      JasperReport reporte = JasperCompileManager.compileReport("C:\\Users\\User\\JaspersoftWorkspace\\MyReports\\prueba.jrxml");
//      JasperPrint jasperPrint  = JasperFillManager.fillReport(reporte,parametro,c);
     
//      JasperViewer view =  new JasperViewer(jasperPrint);
    
//      view.setVisible(true);
      
      System.out.println("NICEEEEEEE");
      em.getTransaction().commit();
      return "SIUUUUUUUUUUUU";
      
    } catch(Exception ex){
        System.out.println("Error: "+ex);
        return "nooooo" + ":" + ex;
    }
   }
//   @Resource(mappedName="jdbc/relojUNA") DataSource datasource;
    public /*ResponseEntity<byte[]>*/ String generarReporteEmpleados2() throws FileNotFoundException, /*JRException,*/ SQLException,   JRException,   NamingException{
    
        InputStream x = WSTarea.class.getClassLoader().getResourceAsStream("cr/ac/una/wstarea/Report/obtenerEmpleados.jrxml");
//        if(x == null){
//            return x.toString();
//        }
    InitialContext context = new InitialContext();   
    DataSource datasource = (DataSource) context.lookup("jdbc/Reloj");
    Connection c =   datasource.getConnection();
//    InputStream x2 = WSTarea.class.getClassLoader().getResourceAsStream("/reportes/prueba.pdf");
        System.out.println();
        //em.getTransaction().begin();
//        Session s = (Session)em.getDelegate();
//    OpenJPAEntityManager oem = OpenJPAPersistance.cast (em);
//   JasperReport compileReport = JasperCompileManager.compileReport("C:\\Users\\User\\JaspersoftWorkspace\\MyReports\\prueba.jrxml");
    JasperReport compileReport = JasperCompileManager
            .compileReport(x);
//    
    HashMap<String,Object> map = new HashMap<>();    
    JasperPrint report = JasperFillManager.fillReport(compileReport, map,/*new JREmptyDataSource()*/c);
    JasperExportManager.exportReportToPdfFile( report,"prueba.pdf");
    
//    byte [] data = JasperExportManager.exportReportToPdf(report);

//      em.getTransaction().commit();
    return "Generado";
    }
 
    
    
    
    
//    public /*ResponseEntity<byte[]>*/ String generarReporteEmpleados2() {
//    try{            
//    // Obtenemos el entityManager de JPA. En este caso viene inyectado
//    org.hibernate.HibernateEntityManager em1 = (HibernateEntityManager)entityManagerProvider.get();
//    Session session = em1.getSession();
//    session.doWork(new Work() 
//    {
//        @Override
//        public void execute(Connection connection) throws SQLException 
//        {
//            try{
//                InputStream fileStream = getClass().getResourceAsStream(reportPath);
//                JasperReport compiledReport = JasperCompileManager.compileReport(fileStream);
//                JasperPrint jasperPrint = JasperFillManager.fillReport(compiledReport, reportParameters, connection);
//                 
//                // Visualizar o guardar el informe resultante
//            }
//            catch(JRException e){
//                throw new RuntimeException(e);
//            }
//        }
//    });                                                
//}
//catch(Exception e){            
//    // Tratar el error
//}
//}
    
    
    
    
}
