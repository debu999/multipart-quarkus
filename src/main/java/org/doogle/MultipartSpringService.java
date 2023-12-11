package org.doogle;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.client.impl.multipart.QuarkusMultipartForm;

@RegisterRestClient(configKey = "spring-multipart")
@RegisterClientHeaders
@Path("/api")
public interface MultipartSpringService {

  @POST
  @Path("/multipart")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  Map<String, String> springMultipartCall(QuarkusMultipartForm dataParts);

  @POST
  @Path("/test")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  Map<String, String> testCallSpring(@RestForm("payload") String payload);
}


