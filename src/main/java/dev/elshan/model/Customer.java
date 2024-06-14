package dev.elshan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String email;
        private String pwd;
        private String role;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPwd() {
                return pwd;
        }

        public void setPwd(String pwd) {
                this.pwd = pwd;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }
}
