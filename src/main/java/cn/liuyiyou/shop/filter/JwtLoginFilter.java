//package cn.liuyiyou.shop.filter;
//
//import cn.liuyiyou.shop.entity.Member;
//import cn.liuyiyou.shop.utils.JwtUtils;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
///***
// * @author: liuyiyou
// * @date: 2018/5/28
// */
//public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
//    private AuthenticationManager authenticationManager;
//
//    public JwtLoginFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        Member member = Member.builder().accountName("18600774073").pwd("123456").build();
//        return authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        member.getAccountName(),
//                        member.getPwd(),
//                        new ArrayList<>()
//                )
//        );
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        User user = (User) authResult.getPrincipal();
//        String token = Jwts.builder()
//                .setSubject(user.getUsername())
//                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
//                .signWith(SignatureAlgorithm.HS512, "PrivateSecret")
//                .compact();
//        response.addHeader("Authorization", JwtUtils.getTokenHeader(token));
//    }
//}
