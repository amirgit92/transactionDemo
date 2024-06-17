package com.course.transactiondemo.util;

import it.avutils.jmapper.JMapper;
import org.springframework.context.annotation.Bean;


public class Convert {
    @Bean
    public static <S, D> D convertObject(S source, Class<D> destinationClass) {
        JMapper<D, S> jMapper = new JMapper<>(destinationClass, (Class<S>) source.getClass());
        return jMapper.getDestination(source);
    }
}
