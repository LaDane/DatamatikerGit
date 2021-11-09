package FunctionLayer;

import DBAccess.BmiMapper;
import DBAccess.InfoMapper;
import DBAccess.SportMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static List<Sport> getAllSports() throws LoginSampleException {
        return SportMapper.getAllSports();
    }

    public static List<Info> getAllInfos() throws LoginSampleException {
        return InfoMapper.getAllInfos();
    }

    public static void insertBmiItem(double height, double weight, String category,
                     double bmi, String gender, int sport_id, List<String> infoList) throws LoginSampleException {
        BmiMapper.insertBmiItem(height, weight, category, bmi, gender, sport_id, infoList);
    }
}
