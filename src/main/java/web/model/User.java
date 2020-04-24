package web.model;

import javax.persistence.*;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "password")
        private String password;

        @Column(name = "sex")
        private Sex sex;

        @Column(name = "role")
        private Role role;

        public User() {
        }

        public User(String name, String password, Sex sex, Role role) {
            this.name = name;
            this.password = password;
            this.sex = sex;
            this.role = role;
        }

        public User(Long id, String name, String password, Sex sex, Role role) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.sex = sex;
            this.role = role;
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

        public String getPassword() {
            return password;
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

        public Role getRole() {
            return role;
        }

        public void setRole(Role role) {
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

