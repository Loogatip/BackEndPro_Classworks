package de.aittr.g_37_jp_shop.service;

import de.aittr.g_37_jp_shop.domain.entity.Role;
import de.aittr.g_37_jp_shop.domain.entity.User;
import de.aittr.g_37_jp_shop.repository.UserRepository;
import de.aittr.g_37_jp_shop.service.interfaces.EmailService;
import de.aittr.g_37_jp_shop.service.interfaces.RoleService;
import de.aittr.g_37_jp_shop.service.interfaces.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private BCryptPasswordEncoder encoder;
    private RoleService roleService;
    private EmailService emailService;

    public UserServiceImpl(
            UserRepository repository,
            BCryptPasswordEncoder encoder,
            RoleService roleService,
            EmailService emailService
    ) {
        this.repository = repository;
        this.encoder = encoder;
        this.roleService = roleService;
        this.emailService = emailService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public void register(User user) {
        user.setId(null);  // ->  стирает все входящие ID на ноль, что дает возможность
                           // ->  в последствии генерировать свой.
        user.setPassword(encoder.encode(user.getPassword()));

        // Дальше два одинаковых варианта:
        // 1 Вариант:
//        Role roleUser = roleService.getRoleUser();
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleUser);
//        user.setRoles(roles);

        // 2 Вариант:
        user.setRoles(Set.of(roleService.getRoleUser()));
        // -----
        user.setActive(false);
        repository.save(user);
        emailService.sendConfirmationEmail(user);
    }
}
