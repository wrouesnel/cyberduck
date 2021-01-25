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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * The operations that have been locked. Currently the &#x60;move&#x60; and &#x60;delete&#x60; operations cannot be locked separately, and both need to be set to &#x60;true&#x60;. 
 */
@Schema(description = "The operations that have been locked. Currently the `move` and `delete` operations cannot be locked separately, and both need to be set to `true`. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class FolderLockLockedOperations {
  @JsonProperty("move")
  private Boolean move = null;

  @JsonProperty("delete")
  private Boolean delete = null;

  public FolderLockLockedOperations move(Boolean move) {
    this.move = move;
    return this;
  }

   /**
   * Whether moving the folder is restricted.
   * @return move
  **/
  @Schema(example = "true", description = "Whether moving the folder is restricted.")
  public Boolean isMove() {
    return move;
  }

  public void setMove(Boolean move) {
    this.move = move;
  }

  public FolderLockLockedOperations delete(Boolean delete) {
    this.delete = delete;
    return this;
  }

   /**
   * Whether deleting the folder is restricted.
   * @return delete
  **/
  @Schema(example = "true", description = "Whether deleting the folder is restricted.")
  public Boolean isDelete() {
    return delete;
  }

  public void setDelete(Boolean delete) {
    this.delete = delete;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FolderLockLockedOperations folderLockLockedOperations = (FolderLockLockedOperations) o;
    return Objects.equals(this.move, folderLockLockedOperations.move) &&
        Objects.equals(this.delete, folderLockLockedOperations.delete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(move, delete);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FolderLockLockedOperations {\n");
    
    sb.append("    move: ").append(toIndentedString(move)).append("\n");
    sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
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
