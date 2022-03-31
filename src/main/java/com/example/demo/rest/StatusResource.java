package com.example.demo.rest;

import com.example.demo.dto.Status;
import com.example.demo.service.StatusService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {

    private StatusService statusService;

    @Inject
    public StatusResource(
            StatusService statusService
    ) {
        this.statusService = statusService;
    }

    @GET
    @Path("/")
    public Status pingPong() {
        long uptimeSeconds = getUptimeSeconds();
        return new Status("Ok", uptimeSeconds);
    }

    @GET
    @Path("/db")
    public Status checkDb() {
        long uptimeSeconds = getUptimeSeconds();
        return new Status(statusService.status(), uptimeSeconds);
    }

    private static long getUptimeSeconds() {
        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        return rb.getUptime() / 1000;
    }
}
