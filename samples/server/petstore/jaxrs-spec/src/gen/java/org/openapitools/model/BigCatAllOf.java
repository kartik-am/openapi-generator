/*
 * Generation info:
 *   - generator version: 6.6.5-amadeus
 *   - datetime: 2023-08-22T08:19:21.786034800Z[UTC]
 */

package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.*;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;



@JsonTypeName("BigCat_allOf")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen")
public class BigCatAllOf  implements Serializable {
  

public enum KindEnum {

    LIONS(String.valueOf("lions")), TIGERS(String.valueOf("tigers")), LEOPARDS(String.valueOf("leopards")), JAGUARS(String.valueOf("jaguars"));


    private String value;

    KindEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static KindEnum fromString(String s) {
        for (KindEnum b : KindEnum.values()) {
            // using Objects.toString() to be safe if value type non-object type
            // because types like 'int' etc. will be auto-boxed
            if (java.util.Objects.toString(b.value).equals(s)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected string value '" + s + "'");
	}
	
    @JsonCreator
    public static KindEnum fromValue(String value) {
        for (KindEnum b : KindEnum.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

  
  private @Valid KindEnum kind;

  

  protected BigCatAllOf(BigCatAllOfBuilder<?, ?> b) {
    this.kind = b.kind;
  }

  public BigCatAllOf() {
  }

  /**
   **/
  public BigCatAllOf kind(KindEnum kind) {
    this.kind = kind;
    return this;
  }

  
  
  @ApiModelProperty(value = "")
  @JsonProperty("kind")
  public KindEnum getKind() {
    return kind;
  }

  @JsonProperty("kind")
  public void setKind(KindEnum kind) {
    this.kind = kind;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BigCatAllOf bigCatAllOf = (BigCatAllOf) o;
    return Objects.equals(this.kind, bigCatAllOf.kind);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BigCatAllOf {\n");
    
    sb.append("    kind: ").append(toIndentedString(kind)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static BigCatAllOfBuilder<?, ?> builder() {
    return new BigCatAllOfBuilderImpl();
  }

  private static final class BigCatAllOfBuilderImpl extends BigCatAllOfBuilder<BigCatAllOf, BigCatAllOfBuilderImpl> {

    @Override
    protected BigCatAllOfBuilderImpl self() {
      return this;
    }

    @Override
    public BigCatAllOf build() {
      return new BigCatAllOf(this);
    }
  }

  public static abstract class BigCatAllOfBuilder<C extends BigCatAllOf, B extends BigCatAllOfBuilder<C, B>>  {
    private KindEnum kind;
    protected abstract B self();

    public abstract C build();

    public B kind(KindEnum kind) {
      this.kind = kind;
      return self();
    }
  }

  
  private Map<String, Object> unknown = new HashMap<>();

  @JsonAnyGetter
  public Map<String, Object> getUnknown() {
    return unknown;
  }

  @JsonAnySetter
  public void addUnknown(String key, Object value) {
    unknown.put(key, value);
  }
  
}

