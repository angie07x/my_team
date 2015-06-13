
package uml;
import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import static javax.print.attribute.Size2DSyntax.MM;

public class DAOFactura {
    Factura fac=new Factura();
    Database db=new Database();
    
     
    public String insertar(Object obj){
        Factura  fac= (Factura) obj;//Estamos haciendo un casting porque el objeto
        //lo convertimos en una variable tipo empleado
        Connection con;
        PreparedStatement pst;
        String sql="insert into factura values(?,?,?)";
        String respuesta;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1,fac.getId_Factura());//Asignar las columnas de la tabla
            pst.setString(2,fac.getFecha_Factura());
            pst.setDouble(3,fac.getTotal_Factura());
            int registros=pst.executeUpdate();//exectuteQuery solo para select
            //executeUpdate es para insert delete update
            //se declara entero porqe puede dividir el numero de valores eliminados
            respuesta=registros +" insertados correctamente";
        } catch (Exception e) {
            respuesta=e.getMessage();             
        }
        return respuesta;
    }
    public String eliminar(Object obj){
        Factura  fac= (Factura) obj;//Estamos haciendo un casting porque el objeto
        //lo convertimos en una variable tipo empleado
        Connection con;
        PreparedStatement pst;
        String sql="delete from factura where id_Factura=?";
        String respuesta;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1,fac.getId_Factura());//Asignar las columnas de la tabla
     
            int registros=pst.executeUpdate();//exectuteQuery solo para select
            //executeUpdate es para insert delete update
            //se declara entero porqe puede dividir el numero de valores eliminados
            respuesta=registros +" eliminados correctamente";
        } catch (Exception e) {
            respuesta=e.getMessage();             
        }
        return respuesta;
    }
    public String modificar(Object obj){
         Factura  fac= (Factura) obj;//Estamos haciendo un casting porque el objeto
        //lo convertimos en una variable tipo empleado
        Connection con;
        PreparedStatement pst;
        String sql="update factura set fecha_Factura=?, total_Factura=?  where id_Factura=?";
        String respuesta;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setString(1, fac.getFecha_Factura());
            pst.setDouble(2, fac.getTotal_Factura());
            pst.setInt(3, fac.getId_Factura());
            int registros=pst.executeUpdate();
            //executeUpdate es para insert delete update
            //se declara entero porqe puede dividir el numero de valores eliminados
            respuesta=registros +" modificados correctamente";
        } catch (Exception e) {
            respuesta=e.getMessage();             
        }
        return respuesta;
    }
    
    
}
