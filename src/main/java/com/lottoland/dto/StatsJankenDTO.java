package com.lottoland.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * StatsJankenDTO
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-07-07T16:30:43.540903+02:00[Europe/Madrid]")


public class StatsJankenDTO   {
  @JsonProperty("rounds")
  @Valid
  private List<JankenDTO> rounds = null;

  public StatsJankenDTO rounds(List<JankenDTO> rounds) {
    this.rounds = rounds;
    return this;
  }

  public StatsJankenDTO addRoundsItem(JankenDTO roundsItem) {
    if (this.rounds == null) {
      this.rounds = new ArrayList<JankenDTO>();
    }
    this.rounds.add(roundsItem);
    return this;
  }

  /**
   * Get rounds
   * @return rounds
   **/
  @Schema(description = "")
      @Valid
    public List<JankenDTO> getRounds() {
    return rounds;
  }

  public void setRounds(List<JankenDTO> rounds) {
    this.rounds = rounds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatsJankenDTO statsJankenDTO = (StatsJankenDTO) o;
    return Objects.equals(this.rounds, statsJankenDTO.rounds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rounds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatsJankenDTO {\n");
    
    sb.append("    rounds: ").append(toIndentedString(rounds)).append("\n");
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
