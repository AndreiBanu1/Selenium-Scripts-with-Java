public class Validator {
    Boolean Password_isValid(String Password) {
        if (Password.length() >= 5 && Password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    Boolean UserName_isValid(String username) {
        if(username.length() >= 3 && username.length() <=7) {
            return true;
        } else {
            return false;
        }
    }
}