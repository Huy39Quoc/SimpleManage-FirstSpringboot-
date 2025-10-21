package sum25.SE190573.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SonyAccounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SonyAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private int accountID;

    @Column(name = "Phone", length = 13)
    private String phone;

    @Column(name = "Password", length = 10)
    private String password;

    @Column(name = "RoleID")
    private int roleID;

    public SonyAccounts(String phone, String password, int roleID) {
        this.phone = phone;
        this.password = password;
        this.roleID = roleID;
    }
}
