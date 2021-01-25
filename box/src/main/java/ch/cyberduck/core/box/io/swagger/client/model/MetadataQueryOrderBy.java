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
 * An object representing one of the metadata template fields to sort the metadata query results by.
 */
@Schema(description = "An object representing one of the metadata template fields to sort the metadata query results by.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class MetadataQueryOrderBy {
  @JsonProperty("field_key")
  private String fieldKey = null;

  /**
   * The direction to order by, either ascending or descending.  The &#x60;ordering&#x60; direction must be the same for each item in the array.
   */
  public enum DirectionEnum {
    ASC("ASC"),
    DESC("DESC"),
    ASC_2("asc"),
    DESC_3("desc");

    private String value;

    DirectionEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static DirectionEnum fromValue(String text) {
      for (DirectionEnum b : DirectionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("direction")
  private DirectionEnum direction = null;

  public MetadataQueryOrderBy fieldKey(String fieldKey) {
    this.fieldKey = fieldKey;
    return this;
  }

   /**
   * The metadata template field to order by.  The &#x60;field_key&#x60; represents the &#x60;key&#x60; value of a field from the metadata template being searched for.
   * @return fieldKey
  **/
  @Schema(example = "amount", description = "The metadata template field to order by.  The `field_key` represents the `key` value of a field from the metadata template being searched for.")
  public String getFieldKey() {
    return fieldKey;
  }

  public void setFieldKey(String fieldKey) {
    this.fieldKey = fieldKey;
  }

  public MetadataQueryOrderBy direction(DirectionEnum direction) {
    this.direction = direction;
    return this;
  }

   /**
   * The direction to order by, either ascending or descending.  The &#x60;ordering&#x60; direction must be the same for each item in the array.
   * @return direction
  **/
  @Schema(example = "asc", description = "The direction to order by, either ascending or descending.  The `ordering` direction must be the same for each item in the array.")
  public DirectionEnum getDirection() {
    return direction;
  }

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MetadataQueryOrderBy metadataQueryOrderBy = (MetadataQueryOrderBy) o;
    return Objects.equals(this.fieldKey, metadataQueryOrderBy.fieldKey) &&
        Objects.equals(this.direction, metadataQueryOrderBy.direction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fieldKey, direction);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MetadataQueryOrderBy {\n");
    
    sb.append("    fieldKey: ").append(toIndentedString(fieldKey)).append("\n");
    sb.append("    direction: ").append(toIndentedString(direction)).append("\n");
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
