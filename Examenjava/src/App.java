import java.util.List;
import java.util.Scanner;

import entities.Modules;
import services.ModulesService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc = new Scanner(System.in);
        ModulesService moduleService=new ModulesService() ;
        do{
                System.out.println("1. Ajouter un Module");
                System.out.println("2. Lister les Modules");
                System.out.println("3. Créer un Cours");
                System.out.println("4. Lister tous les Cours");
                System.out.println("5. Lister les Cours d'un Module et d'un Professeur");
                System.out.println("6. Quitter");
         
            choix=sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                       System.out.print("Nom du Module: ");
                        String nomModule = sc.nextLine();
                        Modules ml= new Modules();
                        ml.setNomModule(nomModule);
                        ModulesService.ajoutermodule(ml);
                        System.out.println("Module ajouté avec succés");

                    break;
                case 2:
                List<Module> listerModule= moduleService.ListerModule();
                for(Modules m: listerModule){
                    System.out.println("ID : "+m.getId());
                    System.out.println("Nom : "+m.getNomModule());
                    
                }

                    break;

                case 3:
                Cours cours=new Cours();
                
                  System.out.println("Entrer la date du cours");
                  cours.setDate(sc.nextLine());
                  sc.nextLine();
                  System.out.println("Entrer l'heure de debut");
                  cours.setHeureDebut(sc.nextLine());
                  System.out.println("Entrer l'heure de fin");
                  cours.setHeureFin(sc.nextLine());
                  
        
                    listerCours = coursService.Listercours();
                    int response;
                    

                    break;
            
                default:
                    break;
            }
        }while(choix!=5);
        
    }
}
