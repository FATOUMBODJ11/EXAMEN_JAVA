package services;

import java.util.List;

import repositories.ModulesRepository;

public class ModulesService {
    ModulesRepository moduleRepository=new ModulesRepository();

    public void ajoutermodule(Modules module){
        moduleRepository.insertModules(module);
    }

    public List<Module>ListerModule(){
        return moduleRepository.selectAll();
    }

    public Module findModuleById(int id){
      return moduleRepository.selectModuleById(id);
   }
    
}
