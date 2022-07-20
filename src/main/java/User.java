import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String userName;
    private Set<Integer> roomsAllowed;
    private Set<Integer> keysAchieved;
}
