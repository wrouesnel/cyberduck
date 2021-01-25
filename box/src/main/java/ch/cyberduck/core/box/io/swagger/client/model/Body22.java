/*
 * Box Platform API
 * [Box Platform](https://box.dev) provides functionality to provide access to content stored within [Box](https://box.com). It provides endpoints for basic manipulation of files and folders, management of users within an enterprise, as well as more complex topics such as legal holds and retention policies.
 *
 * OpenAPI spec version: 2.0.0
 * Contact: devrel@box.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.box.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.box.io.swagger.client.model.FolderLocksFolder;
import ch.cyberduck.core.box.io.swagger.client.model.FolderLocksLockedOperations;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * Body22
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class Body22 {
  @JsonProperty("locked_operations")
  private FolderLocksLockedOperations lockedOperations = null;

  @JsonProperty("folder")
  private FolderLocksFolder folder = null;

  public Body22 lockedOperations(FolderLocksLockedOperations lockedOperations) {
    this.lockedOperations = lockedOperations;
    return this;
  }

   /**
   * Get lockedOperations
   * @return lockedOperations
  **/
  @Schema(description = "")
  public FolderLocksLockedOperations getLockedOperations() {
    return lockedOperations;
  }

  public void setLockedOperations(FolderLocksLockedOperations lockedOperations) {
    this.lockedOperations = lockedOperations;
  }

  public Body22 folder(FolderLocksFolder folder) {
    this.folder = folder;
    return this;
  }

   /**
   * Get folder
   * @return folder
  **/
  @Schema(required = true, description = "")
  public FolderLocksFolder getFolder() {
    return folder;
  }

  public void setFolder(FolderLocksFolder folder) {
    this.folder = folder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body22 body22 = (Body22) o;
    return Objects.equals(this.lockedOperations, body22.lockedOperations) &&
        Objects.equals(this.folder, body22.folder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lockedOperations, folder);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body22 {\n");
    
    sb.append("    lockedOperations: ").append(toIndentedString(lockedOperations)).append("\n");
    sb.append("    folder: ").append(toIndentedString(folder)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
