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
import ch.cyberduck.core.box.io.swagger.client.model.RetentionPolicyBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * A mini representation of a retention policy, used when nested within another resource.
 */
@Schema(description = "A mini representation of a retention policy, used when nested within another resource.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class RetentionPolicyMini extends RetentionPolicyBase {
  @JsonProperty("policy_name")
  private String policyName = null;

  @JsonProperty("retention_length")
  private String retentionLength = null;

  /**
   * The disposition action of the retention policy. This action can be &#x60;permanently_delete&#x60;, which will cause the content retained by the policy to be permanently deleted, or &#x60;remove_retention&#x60;, which will lift the retention policy from the content, allowing it to be deleted by users, once the retention policy has expired.
   */
  public enum DispositionActionEnum {
    PERMANENTLY_DELETE("permanently_delete"),
    REMOVE_RETENTION("remove_retention");

    private String value;

    DispositionActionEnum(String value) {
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
    public static DispositionActionEnum fromValue(String text) {
      for (DispositionActionEnum b : DispositionActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("disposition_action")
  private DispositionActionEnum dispositionAction = null;

  public RetentionPolicyMini policyName(String policyName) {
    this.policyName = policyName;
    return this;
  }

   /**
   * The name given to the retention policy
   * @return policyName
  **/
  @Schema(example = "Some Policy Name", description = "The name given to the retention policy")
  public String getPolicyName() {
    return policyName;
  }

  public void setPolicyName(String policyName) {
    this.policyName = policyName;
  }

  public RetentionPolicyMini retentionLength(String retentionLength) {
    this.retentionLength = retentionLength;
    return this;
  }

   /**
   * The length of the retention policy. This length specifies the duration in days that the retention policy will be active for after being assigned to content.  If the policy has A &#x60;policy_type&#x60; of &#x60;indefinite&#x60;, the &#x60;retention_length&#x60; will also be &#x60;indefinite&#x60;.
   * @return retentionLength
  **/
  @Schema(example = "365", description = "The length of the retention policy. This length specifies the duration in days that the retention policy will be active for after being assigned to content.  If the policy has A `policy_type` of `indefinite`, the `retention_length` will also be `indefinite`.")
  public String getRetentionLength() {
    return retentionLength;
  }

  public void setRetentionLength(String retentionLength) {
    this.retentionLength = retentionLength;
  }

  public RetentionPolicyMini dispositionAction(DispositionActionEnum dispositionAction) {
    this.dispositionAction = dispositionAction;
    return this;
  }

   /**
   * The disposition action of the retention policy. This action can be &#x60;permanently_delete&#x60;, which will cause the content retained by the policy to be permanently deleted, or &#x60;remove_retention&#x60;, which will lift the retention policy from the content, allowing it to be deleted by users, once the retention policy has expired.
   * @return dispositionAction
  **/
  @Schema(example = "permanently_delete", description = "The disposition action of the retention policy. This action can be `permanently_delete`, which will cause the content retained by the policy to be permanently deleted, or `remove_retention`, which will lift the retention policy from the content, allowing it to be deleted by users, once the retention policy has expired.")
  public DispositionActionEnum getDispositionAction() {
    return dispositionAction;
  }

  public void setDispositionAction(DispositionActionEnum dispositionAction) {
    this.dispositionAction = dispositionAction;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RetentionPolicyMini retentionPolicyMini = (RetentionPolicyMini) o;
    return Objects.equals(this.policyName, retentionPolicyMini.policyName) &&
        Objects.equals(this.retentionLength, retentionPolicyMini.retentionLength) &&
        Objects.equals(this.dispositionAction, retentionPolicyMini.dispositionAction) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(policyName, retentionLength, dispositionAction, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RetentionPolicyMini {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    policyName: ").append(toIndentedString(policyName)).append("\n");
    sb.append("    retentionLength: ").append(toIndentedString(retentionLength)).append("\n");
    sb.append("    dispositionAction: ").append(toIndentedString(dispositionAction)).append("\n");
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
