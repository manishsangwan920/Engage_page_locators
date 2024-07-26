package uitilites;

import lombok.Data;

@Data
public class User {

    private String firstName;
    private String lastName;
    private String userId;
    private String language;
    private String country;
    private String gender;
    private String email;
    private String phone;
    private String city;
    private String lastChannel;
    private boolean emailOptIn;
    private boolean smsOptIn;
    private boolean whatsAppOptIn;
    private String tags;

}
