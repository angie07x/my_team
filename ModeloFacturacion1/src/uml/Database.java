
package uml;

public class Database {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public Database() {
        this.driver="com.mysql.jdbc.Driver";
        this.url="jdbc:mysql://localhost:3306/ejercicio";//donde esta localhost puede ir 
        //de dominio tambien o la ip si la conexion es remota
        this.user="root";
        this.pass="Itca123";//con xampp no tienes contraseña root
    }
    // no se implementa set para que la clase sea segura
    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
}
