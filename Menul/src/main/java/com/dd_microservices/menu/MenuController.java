package com.dd_microservices.menu;

import com.dd_microservices.menu.ClassesObjets.Game;
import com.dd_microservices.menu.ClassesObjets.JoueurData;
import com.dd_microservices.menu.ClassesObjets.Personnage;
import com.dd_microservices.menu.ClassesObjets.Save;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Savepoint;
import java.util.List;

@RestController
@Repository
public class MenuController {


    private final RestTemplate restTemplate= new RestTemplate();
    private SaveState saveState ;

    private Personnage hero;
    private Game partie;
    private Save actualSave;
    private JoueurData player;

    public MenuController() {
    }

    /*---------------------Saves---------------------*/
public List getSaveList(JoueurData user){
    ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8085/save/"+user.getId(),List.class);
    return response.getBody();
}

public Save getSave(JoueurData user){
    List<Save> saveList = getSaveList(user);
    /*todo
    interface graphique et choix de la save
     */
    int choice;
    saveState= SaveState.loaded;
    return saveList.get(choice);
}

public void saveGame(){
    if (saveState==SaveState.created) {
        restTemplate.postForEntity("http://localhost:8085/save", new Save(player.getId(), hero.getId(),hero.getArme().getId(),hero.getLife(),partie.getBoard().getId(),partie.getPosition()));
    }else if (saveState==SaveState.loaded){
        restTemplate.put("http://localhost:8085/save",actualSave.update(hero.getLife()));
    }
}
public void deleteGame(int id){
    restTemplate.delete("http://localhost:8085/save"+id);
}


    /*---------------------Perso---------------------*/





    /*---------------------Board---------------------*/





    /*---------------------Item---------------------*/






    /*---------------------Game---------------------*/





    /*---------------------User---------------------*/
    public List getUserList(){
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8083/Joueurs",List.class);
        return response.getBody();
    }

    public JoueurData getUser(){
        List<JoueurData> userList = getUserList();
    /*todo
interface graphique et choix du user
     */
        int choice=0;

        return userList.get(choice);
    }

    public void saveUser(){

            restTemplate.put("http://localhost:8083/Joueurs", this.player);

    }
    public void deleteUser(int id){
        restTemplate.delete("http://localhost:8083/Joueurs/"+id);
    }
    public JoueurData createUser(){
        /*todo
    interface graphique et creation user

     */

        restTemplate.put("http://localhost:8083/Joueurs", this.player);
        return newUser;
    }

    /*---------------------jsp---------------------*/



}
