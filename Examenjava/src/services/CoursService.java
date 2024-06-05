package services;

import java.util.List;

import entities.Cours;
import repositories.CoursRepository;
import repositories.ProfesseurRepository;

public class CoursService {
    CoursRepository coursRepository=new CoursRepository();
    
      public  void ajouterUncours(Cours cours){
        //Transaction
         coursRepository.insert(cours);
         
      }
    
    
  
    public List<Cours>listercours(){
      return coursRepository.selectAll();
    }  

    
}
