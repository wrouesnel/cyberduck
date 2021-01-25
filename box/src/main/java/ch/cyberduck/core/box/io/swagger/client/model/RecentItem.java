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
import org.joda.time.DateTime;
/**
 * A recent item accessed by a user.
 */
@Schema(description = "A recent item accessed by a user.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class RecentItem {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("item")
  private AllOfRecentItemItem item = null;

  /**
   * The most recent type of access the user performed on the item.
   */
  public enum InteractionTypeEnum {
    PREVIEW("item_preview"),
    UPLOAD("item_upload"),
    COMMENT("item_comment"),
    OPEN("item_open"),
    MODIFY("item_modify");

    private String value;

    InteractionTypeEnum(String value) {
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
    public static InteractionTypeEnum fromValue(String text) {
      for (InteractionTypeEnum b : InteractionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("interaction_type")
  private InteractionTypeEnum interactionType = null;

  @JsonProperty("interacted_at")
  private DateTime interactedAt = null;

  @JsonProperty("interaction_shared_link")
  private String interactionSharedLink = null;

  public RecentItem type(String type) {
    this.type = type;
    return this;
  }

   /**
   * &#x60;recent_item&#x60;
   * @return type
  **/
  @Schema(example = "recent_item", description = "`recent_item`")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public RecentItem item(AllOfRecentItemItem item) {
    this.item = item;
    return this;
  }

   /**
   * Get item
   * @return item
  **/
  @Schema(description = "")
  public AllOfRecentItemItem getItem() {
    return item;
  }

  public void setItem(AllOfRecentItemItem item) {
    this.item = item;
  }

  public RecentItem interactionType(InteractionTypeEnum interactionType) {
    this.interactionType = interactionType;
    return this;
  }

   /**
   * The most recent type of access the user performed on the item.
   * @return interactionType
  **/
  @Schema(example = "item_preview", description = "The most recent type of access the user performed on the item.")
  public InteractionTypeEnum getInteractionType() {
    return interactionType;
  }

  public void setInteractionType(InteractionTypeEnum interactionType) {
    this.interactionType = interactionType;
  }

  public RecentItem interactedAt(DateTime interactedAt) {
    this.interactedAt = interactedAt;
    return this;
  }

   /**
   * The time of the most recent interaction.
   * @return interactedAt
  **/
  @Schema(example = "2018-04-13T13:53:23-07:00", description = "The time of the most recent interaction.")
  public DateTime getInteractedAt() {
    return interactedAt;
  }

  public void setInteractedAt(DateTime interactedAt) {
    this.interactedAt = interactedAt;
  }

  public RecentItem interactionSharedLink(String interactionSharedLink) {
    this.interactionSharedLink = interactionSharedLink;
    return this;
  }

   /**
   * If the item was accessed through a shared link it will appear here, otherwise this will be null.
   * @return interactionSharedLink
  **/
  @Schema(example = "https://www.box.com/shared/static/rh935iit6ewrmw0unyul.jpeg", description = "If the item was accessed through a shared link it will appear here, otherwise this will be null.")
  public String getInteractionSharedLink() {
    return interactionSharedLink;
  }

  public void setInteractionSharedLink(String interactionSharedLink) {
    this.interactionSharedLink = interactionSharedLink;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecentItem recentItem = (RecentItem) o;
    return Objects.equals(this.type, recentItem.type) &&
        Objects.equals(this.item, recentItem.item) &&
        Objects.equals(this.interactionType, recentItem.interactionType) &&
        Objects.equals(this.interactedAt, recentItem.interactedAt) &&
        Objects.equals(this.interactionSharedLink, recentItem.interactionSharedLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, item, interactionType, interactedAt, interactionSharedLink);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecentItem {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    interactionType: ").append(toIndentedString(interactionType)).append("\n");
    sb.append("    interactedAt: ").append(toIndentedString(interactedAt)).append("\n");
    sb.append("    interactionSharedLink: ").append(toIndentedString(interactionSharedLink)).append("\n");
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
