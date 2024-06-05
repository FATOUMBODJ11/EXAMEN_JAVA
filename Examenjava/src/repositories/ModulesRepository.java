package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Modules;

public class ModulesRepository extends Database{
    private final String SQL_SELECT_MODULES="select * from module";
    private final String SQL_INSERT_MODULES="INSERT INTO `module` ( `id`,`nomModule`) VALUES (?,?);";
    private final String SQL_SELECT_BY_ID="SELECT * FROM `module` where id like ? ";


    public List <Module> selectAll(){
        List <Module> modules= new ArrayList<>();
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_MODULES);
            ResultSet rs= executeSelect();
            while(rs.next()){
                Modules module = new Modules();
                module.setId(rs.getInt("id"));
                module.setNomModule(rs.getString("nom")); 
                module.add(modules);
            }
            rs.close();
            closeConnexion();
        }
        catch(SQLException e){
            System.out.println("Erreur de connexion a la BD");
        }
        return modules;

    }
    private void closeConnexion() {
    }
    public void insertModules(Modules modules){
        try {
             ouvrirConnexion();
             initPrepareStatement(SQL_INSERT_MODULES);
              statement.setInt(1,modules.getId());
              statement.setString(2,modules.getNomModule());
              
             executeUpdate();
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
    }

    
       public Modules selectModuleById(int id){
        Modules modules = null;
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs=executeSelect();
            if(rs.next()){
                modules  = new Module();
                 modules.setId(rs.getInt ("id"));
                 modules.setnomModule(rs.getString("niveau")); 

            }
            statement.close();
            rs.close();
            conn.close();

        }catch (SQLException e) {
            System.out.println("Erreur de connexion à la BD");
        }
        return modules;
    }
    
    
}
