package org.telbot.telran.info.model;
/** class for definition user-channel subscription with fields id, user_id, group_id and active
 * @author Natalia Lux
 * @version 1.0
 */
import javax.persistence.*;

@Entity
@Table(name = "userChannel")
public class UserChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userId")
    private int userId;
    @Column(name = "groupId")
    private long groupId;
    @Column(name = "active")
    private boolean active;

    public UserChannel() {
        //
    }

    public UserChannel(UserChannel userChannel) {
        //
    }

    public UserChannel(int userId, int groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getIsOn() {
        return active;
    }

    public void setIsOn(boolean isOn) {
        this.active = isOn;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
