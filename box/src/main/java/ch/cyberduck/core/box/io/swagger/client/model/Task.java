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
 * A task allows for file-centric workflows within Box. Users can create tasks on files and assign them to other users for them to complete the tasks.
 */
@Schema(description = "A task allows for file-centric workflows within Box. Users can create tasks on files and assign them to other users for them to complete the tasks.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-01-25T11:35:18.602705+01:00[Europe/Zurich]")
public class Task {
  @JsonProperty("id")
  private String id = null;

  /**
   * &#x60;task&#x60;
   */
  public enum TypeEnum {
    TASK("task");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("item")
  private AllOfTaskItem item = null;

  @JsonProperty("due_at")
  private DateTime dueAt = null;

  /**
   * The type of task the task assignee will be prompted to perform.
   */
  public enum ActionEnum {
    REVIEW("review"),
    COMPLETE("complete");

    private String value;

    ActionEnum(String value) {
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
    public static ActionEnum fromValue(String text) {
      for (ActionEnum b : ActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("action")
  private ActionEnum action = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("task_assignment_collection")
  private AllOfTaskTaskAssignmentCollection taskAssignmentCollection = null;

  @JsonProperty("is_completed")
  private Boolean isCompleted = null;

  @JsonProperty("created_by")
  private AllOfTaskCreatedBy createdBy = null;

  @JsonProperty("created_at")
  private DateTime createdAt = null;

  /**
   * Defines which assignees need to complete this task before the task is considered completed.  * &#x60;all_assignees&#x60; requires all assignees to review or approve the the task in order for it to be considered completed. * &#x60;any_assignee&#x60; accepts any one assignee to review or approve the the task in order for it to be considered completed.
   */
  public enum CompletionRuleEnum {
    ALL_ASSIGNEES("all_assignees"),
    ANY_ASSIGNEE("any_assignee");

    private String value;

    CompletionRuleEnum(String value) {
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
    public static CompletionRuleEnum fromValue(String text) {
      for (CompletionRuleEnum b : CompletionRuleEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("completion_rule")
  private CompletionRuleEnum completionRule = null;

  public Task id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The unique identifier for this task
   * @return id
  **/
  @Schema(example = "11446498", description = "The unique identifier for this task")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Task type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * &#x60;task&#x60;
   * @return type
  **/
  @Schema(example = "task", description = "`task`")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Task item(AllOfTaskItem item) {
    this.item = item;
    return this;
  }

   /**
   * Get item
   * @return item
  **/
  @Schema(description = "")
  public AllOfTaskItem getItem() {
    return item;
  }

  public void setItem(AllOfTaskItem item) {
    this.item = item;
  }

  public Task dueAt(DateTime dueAt) {
    this.dueAt = dueAt;
    return this;
  }

   /**
   * When the task is due
   * @return dueAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "When the task is due")
  public DateTime getDueAt() {
    return dueAt;
  }

  public void setDueAt(DateTime dueAt) {
    this.dueAt = dueAt;
  }

  public Task action(ActionEnum action) {
    this.action = action;
    return this;
  }

   /**
   * The type of task the task assignee will be prompted to perform.
   * @return action
  **/
  @Schema(example = "review", description = "The type of task the task assignee will be prompted to perform.")
  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public Task message(String message) {
    this.message = message;
    return this;
  }

   /**
   * A message that will be included with the task
   * @return message
  **/
  @Schema(example = "Legal review", description = "A message that will be included with the task")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Task taskAssignmentCollection(AllOfTaskTaskAssignmentCollection taskAssignmentCollection) {
    this.taskAssignmentCollection = taskAssignmentCollection;
    return this;
  }

   /**
   * Get taskAssignmentCollection
   * @return taskAssignmentCollection
  **/
  @Schema(description = "")
  public AllOfTaskTaskAssignmentCollection getTaskAssignmentCollection() {
    return taskAssignmentCollection;
  }

  public void setTaskAssignmentCollection(AllOfTaskTaskAssignmentCollection taskAssignmentCollection) {
    this.taskAssignmentCollection = taskAssignmentCollection;
  }

  public Task isCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
    return this;
  }

   /**
   * Whether the task has been completed
   * @return isCompleted
  **/
  @Schema(example = "true", description = "Whether the task has been completed")
  public Boolean isIsCompleted() {
    return isCompleted;
  }

  public void setIsCompleted(Boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public Task createdBy(AllOfTaskCreatedBy createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/
  @Schema(description = "")
  public AllOfTaskCreatedBy getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(AllOfTaskCreatedBy createdBy) {
    this.createdBy = createdBy;
  }

  public Task createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * When the task object was created
   * @return createdAt
  **/
  @Schema(example = "2012-12-12T10:53:43-08:00", description = "When the task object was created")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Task completionRule(CompletionRuleEnum completionRule) {
    this.completionRule = completionRule;
    return this;
  }

   /**
   * Defines which assignees need to complete this task before the task is considered completed.  * &#x60;all_assignees&#x60; requires all assignees to review or approve the the task in order for it to be considered completed. * &#x60;any_assignee&#x60; accepts any one assignee to review or approve the the task in order for it to be considered completed.
   * @return completionRule
  **/
  @Schema(example = "all_assignees", description = "Defines which assignees need to complete this task before the task is considered completed.  * `all_assignees` requires all assignees to review or approve the the task in order for it to be considered completed. * `any_assignee` accepts any one assignee to review or approve the the task in order for it to be considered completed.")
  public CompletionRuleEnum getCompletionRule() {
    return completionRule;
  }

  public void setCompletionRule(CompletionRuleEnum completionRule) {
    this.completionRule = completionRule;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.id, task.id) &&
        Objects.equals(this.type, task.type) &&
        Objects.equals(this.item, task.item) &&
        Objects.equals(this.dueAt, task.dueAt) &&
        Objects.equals(this.action, task.action) &&
        Objects.equals(this.message, task.message) &&
        Objects.equals(this.taskAssignmentCollection, task.taskAssignmentCollection) &&
        Objects.equals(this.isCompleted, task.isCompleted) &&
        Objects.equals(this.createdBy, task.createdBy) &&
        Objects.equals(this.createdAt, task.createdAt) &&
        Objects.equals(this.completionRule, task.completionRule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, item, dueAt, action, message, taskAssignmentCollection, isCompleted, createdBy, createdAt, completionRule);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    dueAt: ").append(toIndentedString(dueAt)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    taskAssignmentCollection: ").append(toIndentedString(taskAssignmentCollection)).append("\n");
    sb.append("    isCompleted: ").append(toIndentedString(isCompleted)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    completionRule: ").append(toIndentedString(completionRule)).append("\n");
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
