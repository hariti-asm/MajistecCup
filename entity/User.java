package ma.hariti.asmaa.wrm.majesticcup.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    public enum UserRole {
        USER, ADMIN, OPERATOR
    }
}

