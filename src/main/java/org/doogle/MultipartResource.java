package org.doogle;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.client.impl.multipart.QuarkusMultipartForm;

@ApplicationScoped
@Path("/api")
public class MultipartResource {

  @RestClient
  MultipartSpringService springService;

  @POST
  @Path("/multipart")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Map<String, String> multipart(MultiPartPayloadFormData data) {

    QuarkusMultipartForm qmf = new QuarkusMultipartForm();
    qmf.attribute("jsonPayload", data.getJsonPayload(), "jsonPayload");
    data.getFiles().forEach(f -> {
      qmf.binaryFileUpload("file", f.name(), f.filePath().toString(), f.contentType());
    });

    return springService.springMultipartCall(qmf);
  }

  @GET
  @Path("/hi")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Map<String, String> test() {
    return Map.of("a", "b");
  }

  @POST
  @Path("/hi")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  public Map<String, String> testPost(MultiPartPayloadFormData data) {
    return multipart(data);
  }
}
