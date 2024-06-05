package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Cours;
import entities.Professeur;

public class CoursRepository extends Database {
    private final String SQL_INSERT_COURS = "INSERT INTO cours ( `nci`, `nomComplet`, `grade`) VALUES ( ?, ?, ?)";
    private final String SQL_LAST_VALUE_INSERT="SELECT Max(`id_pr`) as max FROM `cours`";
    private final String SQL_SELECT_COURS="SELECT * FROM cours";
    
    public void insert(Cours cours) {
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_INSERT_COURS);
            statement.setString(2, cours.getId());
            statement.setDate(3, cours.getDate());
            statement.setTime(4, cours.getHeureDebut());
            statement.setTime(5, cours.getHeureFin());
            
            

            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

     public  Professeur selectLastCours(){
        Cours cours=null;
        try {
            ouvrirConnexion();
            initPrepareStatement(SQL_LAST_VALUE_INSERT);
     
            ResultSet rs = executeSelect();
            while (rs.next()) {
                cours=new Cours(); 
                cours.setId(rs.getInt("max")); 
             
            }
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       return cours;
      }
      public List <Professeur> selectAll(){
        List <Professeur> professeur= new ArrayList<>();
        try{
            ouvrirConnexion();
            initPrepareStatement(SQL_SELECT_COURS);
            ResultSet rs= executeSelect();
            while(rs.next()){
                Cours cours=new Cours();
                cours.setId(rs.getInt("id"));
                cours.setDate(null);
                cours.setHeureDebut(null);
                cours.setHeureFin(null);
                cours.add(cours);
            }
            rs.close();
            fermerConnexion();
        }
        catch(SQLException e){
            System.out.println("Erreur de connexion a la BD");
        }
        return professeur;

    }
    
    

    

    
}
