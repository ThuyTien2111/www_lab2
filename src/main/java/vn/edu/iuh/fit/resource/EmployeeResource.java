package vn.edu.iuh.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.service.EmployeeService;

import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    private EmployeeService employeeService;

    public EmployeeResource() {
        employeeService=new EmployeeService();
    }

    @GET
    @Produces("application/json")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GET
    @Path("/{employeeId}")
    @Produces("application/json")
    public Response getEmployeeById(@PathParam("employeeId") long employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            return Response.ok(employee).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addEmployee(Employee employee) {
        boolean added = employeeService.addEmployee(employee);
        if (added) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{employeeId}")
    public Response updateEmployee(@PathParam("employeeId") long employeeId, Employee updatedEmployee) {
        if (employeeService.updateEmployee(updatedEmployee)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{employeeId}")
    public Response deleteEmployee(@PathParam("employeeId") long employeeId) {
        boolean deleted = employeeService.deleteEmployee(employeeId);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/{employeeId}/activate")
    public Response activateEmployee(@PathParam("employeeId") long employeeId) {
        boolean activated = employeeService.activateEmployee(employeeId);
        if (activated) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}

