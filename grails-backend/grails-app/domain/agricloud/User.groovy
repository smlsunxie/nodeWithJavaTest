package agricloud

class User {

	String account;
	String password;
	String name;
	String email;

    static constraints = {
		name nullable: true
		email nullable: true
    }
}
