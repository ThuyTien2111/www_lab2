package vn.edu.iuh.fit.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;


@Provider
public class MapperContextResolver implements ContextResolver<ObjectMapper> {
    final ObjectMapper mapper=new ObjectMapper();

    public MapperContextResolver() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}