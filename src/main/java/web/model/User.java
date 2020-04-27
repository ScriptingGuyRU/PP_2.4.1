package web.model;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",unique = true)
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private Sex sex;

    @ElementCollection(targetClass=Role.class, fetch=FetchType.EAGER)
    @CollectionTable(name="user_role", joinColumns=@JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role = new HashSet<>();

    public User() {
    }

    public User(String name, String password, Sex sex, Set<Role> role) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.role = role;
    }

    public User(String name, String password, Sex sex) {
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    public User(Long id, String name, String password, Sex sex) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Set<Role>    getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User " +
                "\nid = " + id +
                "\nname = '" + name + '\'' +
                "\npassword = '" + password + '\'' +
                "\nsex = " + sex + "\nrole = " + role;
    }


}

