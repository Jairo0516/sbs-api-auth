package com.api.auth.config.security.filter;

import java.io.IOException;

import com.api.auth.config.security.JWTUtil;
import com.api.auth.domain.service.impl.AuthUserDetailsService;
import com.api.auth.domain.service.impl.UserDetailsService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        try {
        String url = httpServletRequest.getRequestURI();
        String authorizationHeader = httpServletRequest.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            String jwt = authorizationHeader.substring(7);
            String username = jwtUtil.extractUsername(jwt);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = authUserDetailsService.loadUserByUsername(username);
                if (jwtUtil.validateToken(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (StringIndexOutOfBoundsException | SignatureException | ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            httpServletResponse.resetBuffer();
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpServletResponse.setHeader("Content-Type", "application/json");

            httpServletResponse.getOutputStream().print(
                    "{" +
                            "\"code\": \"" + HttpServletResponse.SC_FORBIDDEN + "\"," +
                            "\"errorMessage\": \"" + e.getMessage() + "\"" +
                     "}"
            );
            // httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
            httpServletResponse.flushBuffer();
        }

    }

}