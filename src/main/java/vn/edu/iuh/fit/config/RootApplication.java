package vn.edu.iuh.fit.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.convert.MapperContextResolver;
import vn.edu.iuh.fit.resource.EmployeeResource;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RootApplication extends Application {

}


