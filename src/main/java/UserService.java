import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Log4j2
public class UserService {

    //добавлен для майора
    //этот логер надо дописать теперь в конфиг
    Logger comradeMajor = LogManager.getLogger("comradeMajor");

    public void getKeyForUser(User user, Integer keyToAchieve) {
        log.info("User is getting a key");
        if (!user.getRoomsAllowed().contains(keyToAchieve)) {
            comradeMajor.warn("User {} is trying to get a key {}", user.getUserName(), keyToAchieve);
            throw new RuntimeException("User has no rights for this key!");
        }
        user.getKeysAchieved().add(keyToAchieve);
        log.info("User got a key");
    }
}
