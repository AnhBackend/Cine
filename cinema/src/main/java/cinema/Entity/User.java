package cinema.Entity;

import cinema.Enums.RoleEnums;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "Point")
    private int point;
    @Column(name = "Username")
    private String username;
    @Column(name = "Email")
    private String email;
    @Column(name = "Name")
    private String name;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "Password")
    private String password;
    @Column(name = "RankCustomerId", insertable = false, updatable = false)
    private int rankCustomerId;
    @Column(name = "UserStatusId", insertable = false, updatable = false)
    private int userStatusId;
    @Column(name = "IsActive")
    private boolean isActive;
    @Column(name = "RoleId", insertable = false, updatable = false)
    private int roleId;

    @Column(name = "confirm_code")
    private String confirmCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Bill> bills;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<ConfirmEmail> confirmEmails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<RefreshToken> refreshTokens;

    @ManyToOne
    @JoinColumn(name = "RankCustomerId")
    @JsonIgnore
    private RankCustomer rankCustomer;

    @ManyToOne
    @JoinColumn(name = "UserStatusId")
    @JsonIgnore
    private UserStatus userStatus;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    @JsonIgnore
    private Role role;

    @Enumerated(EnumType.STRING)
    private RoleEnums roleEnums;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roleEnums.name()));
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
