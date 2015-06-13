
package uml;
import java.util.ArrayList;
import java.sql.*;

public class DAODetalle_Factura {
    DetalleFactura deta=new DetalleFactura();
    Database db=new Database();
    
    public ArrayList<Object []> listar(){
        ArrayList<Object[]> datos = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        ResultSetMetaData meta;//numero de filas,numero de columnas
        String sql="SELECT detalle_factura.id_Detalle,factura.id_Factura,factura.fecha_Factura,detalle_factura.nombre_Producto,detalle_factura.cantidad_Producto,detalle_factura.precio_Unitario,factura.total_Factura FROM detalle_factura\n" +
        "INNER JOIN factura\n" +
        "ON detalle_factura.id_Factura=factura.id_Factura";
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            //Conexion a base de datos
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();//ejecuta la consulta y guarda el resultado en la varibale Resultset
            meta=rs.getMetaData();//todo lo de la consulta lo guardamos en el meta data
            //este me devuelve las columnas
            while (rs.next()) {
                Object [] fila= new Object[meta.getColumnCount()];                
                for (int i = 0; i < fila.length; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                datos.add(fila);
            }
            rs.close();
        } catch (Exception e) {
            
        }
        return datos;
    }
    
    public String insertar(Object obj){
        DetalleFactura  deta= (DetalleFactura) obj;//Estamos haciendo un casting porque el objeto
        //lo convertimos en una variable tipo empleado
        Connection con;
        PreparedStatement pst;
        String sql="insert into detalle_factura values(?,?,?,?,?)";
        String respuesta;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1,deta.getId_Detalle());
            pst.setInt(2,deta.getFactura().getId_Factura());
            pst.setString(3,deta.getNombre_Producto());
            pst.setInt(4,deta.getCantidad());
            pst.setDouble(5,deta.getPrecio_Unitario());
     

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
        DetalleFactura  deta= (DetalleFactura) obj;//Estamos haciendo un casting porque el objeto
        //lo convertimos en una variable tipo empleado
        Connection con;
        PreparedStatement pst;
        String sql="delete from detalle_factura where id_Detalle=?";
        String respuesta;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1,deta.getId_Detalle());//Asignar las columnas de la tabla
     
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
         DetalleFactura  deta= (DetalleFactura) obj;//Estamos haciendo un casting porque el objeto
        //lo convertimos en una variable tipo empleado
        Connection con;
        PreparedStatement pst;
        String sql="update detalle_factura set id_Factura=?,nombre_Producto=?,cantidad_Producto=?,precio_Unitario=?  where id_Detalle=?";
        String respuesta;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(),db.getUser(),db.getPass());
            pst=con.prepareStatement(sql);
            pst.setInt(1,deta.getFactura().getId_Factura());
            pst.setString(2,deta.getNombre_Producto());
            pst.setInt(3,deta.getCantidad());
            pst.setDouble(4,deta.getPrecio_Unitario());
          pst.setInt(5, deta.getId_Detalle());
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
