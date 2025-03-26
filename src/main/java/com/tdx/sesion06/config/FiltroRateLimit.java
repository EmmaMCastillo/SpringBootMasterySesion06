package com.tdx.sesion06.config;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import io.github.bucket4j.Bandwidth;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FiltroRateLimit extends OncePerRequestFilter {

    private  final Map<String, Bucket>  buckets = new ConcurrentHashMap<>();

    private Bucket crearBucket(){
        Refill refill = Refill.greedy(10, Duration.ofMinutes(1));

        Bandwidth limit = Bandwidth.simple(10, Duration.ofMinutes(1)).withInitialTokens(10);

        return Bucket4j.builder()
                .addLimit(limit)
                .build();
    }
    @Override
    protected  void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws jakarta.servlet.ServletException, IOException{
        String ip = request.getRemoteAddr();
        Bucket bucket = buckets.computeIfAbsent(ip,k -> crearBucket());
        if(bucket.tryConsume(1)){
            filterChain.doFilter(request,response);
        }else{
            response.setStatus(429);
            response.getWriter().write("Has excedido el limite de solicitudes por minuto");
        }
    }
}
