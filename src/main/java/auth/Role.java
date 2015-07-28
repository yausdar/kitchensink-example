package auth;

public enum Role {

	ADMIN("Administrador") , USER("Usuário");
	
	private String name;
	
	private Role(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
