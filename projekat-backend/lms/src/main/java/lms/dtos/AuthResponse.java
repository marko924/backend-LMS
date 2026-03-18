package lms.dtos;

//Ovaj dto sluzi serveru da spakuje generisani jwt token i posalje ga nazad klijentu

public class AuthResponse {
	
	private final String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
