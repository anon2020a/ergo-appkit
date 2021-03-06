/*
 * Ergo blockchain explorer
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package org.ergoplatform.explorer.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.ergoplatform.explorer.client.model.TransactionInput;
import org.ergoplatform.explorer.client.model.TransactionOutput;
/**
 * Transaction without any lockers and unlockers
 */
@Schema(description = "Transaction without any lockers and unlockers")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2019-12-09T08:14:50.203Z[GMT]")
public class Transaction {
  @SerializedName("id")
  private String id = null;

  @SerializedName("headerId")
  private String headerId = null;

  @SerializedName("timestamp")
  private Integer timestamp = null;

  @SerializedName("confirmationsCount")
  private Integer confirmationsCount = null;

  @SerializedName("inputs")
  private List<TransactionInput> inputs = new ArrayList<>();

  @SerializedName("outputs")
  private List<TransactionOutput> outputs = new ArrayList<>();

  public Transaction id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @Schema(required = true, description = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Transaction headerId(String headerId) {
    this.headerId = headerId;
    return this;
  }

   /**
   * Get headerId
   * @return headerId
  **/
  @Schema(required = true, description = "")
  public String getHeaderId() {
    return headerId;
  }

  public void setHeaderId(String headerId) {
    this.headerId = headerId;
  }

  public Transaction timestamp(Integer timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @Schema(required = true, description = "")
  public Integer getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Integer timestamp) {
    this.timestamp = timestamp;
  }

  public Transaction confirmationsCount(Integer confirmationsCount) {
    this.confirmationsCount = confirmationsCount;
    return this;
  }

   /**
   * Number of confimations in transaction
   * @return confirmationsCount
  **/
  @Schema(example = "142", description = "Number of confimations in transaction")
  public Integer getConfirmationsCount() {
    return confirmationsCount;
  }

  public void setConfirmationsCount(Integer confirmationsCount) {
    this.confirmationsCount = confirmationsCount;
  }

  public Transaction inputs(List<TransactionInput> inputs) {
    this.inputs = inputs;
    return this;
  }

  public Transaction addInputsItem(TransactionInput inputsItem) {
    this.inputs.add(inputsItem);
    return this;
  }

   /**
   * Many transaction inputs
   * @return inputs
  **/
  @Schema(required = true, description = "Many transaction inputs")
  public List<TransactionInput> getInputs() {
    return inputs;
  }

  public void setInputs(List<TransactionInput> inputs) {
    this.inputs = inputs;
  }

  public Transaction outputs(List<TransactionOutput> outputs) {
    this.outputs = outputs;
    return this;
  }

  public Transaction addOutputsItem(TransactionOutput outputsItem) {
    this.outputs.add(outputsItem);
    return this;
  }

   /**
   * Many transaction outputs
   * @return outputs
  **/
  @Schema(required = true, description = "Many transaction outputs")
  public List<TransactionOutput> getOutputs() {
    return outputs;
  }

  public void setOutputs(List<TransactionOutput> outputs) {
    this.outputs = outputs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.headerId, transaction.headerId) &&
        Objects.equals(this.timestamp, transaction.timestamp) &&
        Objects.equals(this.confirmationsCount, transaction.confirmationsCount) &&
        Objects.equals(this.inputs, transaction.inputs) &&
        Objects.equals(this.outputs, transaction.outputs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, headerId, timestamp, confirmationsCount, inputs, outputs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    headerId: ").append(toIndentedString(headerId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    confirmationsCount: ").append(toIndentedString(confirmationsCount)).append("\n");
    sb.append("    inputs: ").append(toIndentedString(inputs)).append("\n");
    sb.append("    outputs: ").append(toIndentedString(outputs)).append("\n");
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
