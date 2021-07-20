package edu.bit.kit.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipalVO implements UserDetails{
    
    
    private ArrayList<UserVO> userVO;
    
    public UserPrincipalVO(ArrayList<UserVO> userAuthes) {
        this.userVO = userAuthes;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 유저가 가지고 있는 권한 목록
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        for(int i = 0; i < userVO.size(); i++) {
            authorities.add(new SimpleGrantedAuthority(userVO.get(i).getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        // 유저 비밀번호
        return userVO.get(0).getUserPassword();
    }

    @Override
    public String getUsername() {
        // 유저 아이디
        return userVO.get(0).getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 유저 아이디가 만료 되었는지
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 유저 아이디가 Lock 걸렸는지
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호가 만료 되었는지
        return false;
    }

    @Override
    public boolean isEnabled() {
        // 계정이 활성화 되었는지
        return false;
    }

}
