package rs.srdic.fss.engine.administration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rs.srdic.fss.engine.repository.KorisnikRepository;
import rs.srdic.fss.model.Korisnik;
import rs.srdic.fss.model.enumeration.RoleEnum;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private final KorisnikRepository korisnikRepository;

	@Autowired
	public JwtUserDetailsService(KorisnikRepository korisnikRepository) {
		this.korisnikRepository = korisnikRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Korisnik korisnik = korisnikRepository.findByUsername(username);

		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(RoleEnum.ADMIN.name()));


		if (korisnik != null) {
			return new User(korisnik.getUsername(), new BCryptPasswordEncoder().encode(korisnik.getPassword()), authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

//		if ("javainuse".equals(username)) {
//
//
//
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
	}
}