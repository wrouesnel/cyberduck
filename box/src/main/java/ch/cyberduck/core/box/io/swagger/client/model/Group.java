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
import ch.cyberduck.core.box.io.swagger.client.model.GroupMini;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * A standard representation of a group, as returned from any group API endpoints by default
 */
@Schema(description = "A standard representation of a group, as returned from any group API endpoints by default")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class Group extends GroupMini {
  @JsonProperty("created_at")
  private DateTime createdAt = null;

  @JsonProperty("modified_at")
  private DateTime modifiedAt = null;

  public Group createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * When the group object was created
   * @return createdAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "When the group object was created")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Group modifiedAt(DateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

   /**
   * When the group object was last modified
   * @return modifiedAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "When the group object was last modified")
  public DateTime getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(DateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.createdAt, group.createdAt) &&
        Objects.equals(this.modifiedAt, group.modifiedAt) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdAt, modifiedAt, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    modifiedAt: ").append(toIndentedString(modifiedAt)).append("\n");
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
