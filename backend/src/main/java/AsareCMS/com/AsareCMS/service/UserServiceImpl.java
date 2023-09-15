//package AsareCMS.com.AsareCMS.service;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Objects;
//import AsareCMS.com.AsareCMS.model.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import java.util.stream.Collectors;
//
//
//public class UserServiceImpl implements UserDetails {
//    private static final long serialVersionUID = 1L;
//
//    private Long id;
//
//    private String username;
//
//    private String email;
//
//    @JsonIgnore
//    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserServiceImpl(Long id, String username, String email, String password,
//                           Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
////    public static UserServiceImpl build(User user) {
////        List<GrantedAuthority> authorities = user.getRole().stream()
////                .map(role -> new SimpleGrantedAuthority(role.getRoname().name()))
////                .collect(Collectors.toList());
////
////        return new UserServiceImpl(
////                user.getId(),
////                user.getUsername(),
////                user.getEmail(),
////                user.getPassword(),
////                authorities);
////    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        UserServiceImpl user = (UserServiceImpl) o;
//        return Objects.equals(id, user.id);
//    }
//}
