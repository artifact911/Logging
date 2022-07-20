import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LoggingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    UserService userService = new UserService();

    @Test
    public void testGetKeyForUser() {
        Set<Integer> allowedRooms = new HashSet<>(Arrays.asList(1, 2, 3));
        User user = new User("TestName", allowedRooms, new HashSet<>());
        userService.getKeyForUser(user, 3);

        Assert.assertNotNull(user.getKeysAchieved());
        Assert.assertEquals(1, user.getKeysAchieved().size());
        Assert.assertTrue(user.getKeysAchieved().contains(3));
    }

    // приходит майор и говорит, я хочу знать, кто пытался взять недозволенный ключ.
    // Допилим юзерСервис и добавим туда логирование
    @Test
    public void testGetKeyForUserWithException() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("User has no rights for this key!");

        Set<Integer> allowedRooms = new HashSet<>(Arrays.asList(1, 2, 3));
        User user = new User("TestName", allowedRooms, new HashSet<>());
        userService.getKeyForUser(user, 42);
    }
}
