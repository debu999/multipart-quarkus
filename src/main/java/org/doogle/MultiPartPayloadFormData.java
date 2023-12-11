package org.doogle;

import jakarta.ws.rs.core.MediaType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MultiPartPayloadFormData {

  @RestForm("files")
  @PartType(MediaType.APPLICATION_OCTET_STREAM)
  List<FileUpload> files;

  @RestForm("jsonPayload")
  @PartType(MediaType.TEXT_PLAIN)
  String jsonPayload;
}