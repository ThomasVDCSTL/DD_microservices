package com.dd_microservices.menu;

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
    private User player;

    public MenuController() {
    }

    /*---------------------Saves---------------------*/
public List getSaveList(User user){
    ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8085/save/"+user.getId(),List.class);
    List<Saves> saveList;
    for (Object save: response.getBody()
         ) {
        saveList.add(SaveDTO.refacto(save));
    }
    return saveList;
}

public Save getSave(User user){
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
        restTemplate.postForEntity("http://localhost:8085/save", saveDTO.getSave(this));
    }else if (saveState==SaveState.loaded){
        restTemplate.put("http://localhost:8085/save", saveDTO.getSave(this));
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
        ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8081/Joueurs",List.class);
        List<User> saveList;
        for (Object save: response.getBody()
        ) {
            userList.add(UserDTO.refacto(user));
        }
        return saveList;
    }

    public User getUser(){
        List<User> userList = getUserList();
    /*todo
interface graphique et choix du user
     */
        int choice=0;

        return userList.get(choice);
    }

    public void saveUser(){

            restTemplate.put("http://localhost:8081/Joueurs", this.player);

    }
    public void deleteUser(int id){
        restTemplate.delete("http://localhost:8081/Joueurs/"+id);
    }
    public User createUser(){
        /*todo
    interface graphique et creation user

     */

        restTemplate.put("http://localhost:8081/Joueurs", this.player);
        return newUser;
    }

    /*---------------------jsp---------------------*/



}
